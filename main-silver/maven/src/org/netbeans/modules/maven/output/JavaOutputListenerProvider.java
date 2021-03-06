/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */
package org.netbeans.modules.maven.output;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.modules.maven.api.output.OutputProcessor;
import org.netbeans.modules.maven.api.output.OutputVisitor;
import org.netbeans.api.java.project.JavaProjectConstants;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;




/**
 * compilation output processing
 * @author  Milos Kleint
 */
public class JavaOutputListenerProvider implements OutputProcessor {
    
    private static final String[] JAVAGOALS = new String[] {
        "mojo-execute#compiler:compile", //NOI18N
        "mojo-execute#compiler:testCompile", //NOI18N
        // issue #252093
        "mojo-execute#takari-lifecycle-plugin:compile", //NOI18N
        "mojo-execute#takari-lifecycle-plugin:testCompile" //NOI18N
    };
    
    private final Pattern failPattern;
    private String windowsDrive; // #197381
    /** @see org.codehaus.plexus.compiler.javac.JavacCompiler#compile */
    private static final Pattern windowsDriveInfoPattern = Pattern.compile("Compiling \\d+ source files? to ([A-Za-z]:)\\\\.+");
    
    /** Creates a new instance of JavaOutputListenerProvider */
    public JavaOutputListenerProvider() {
        //[javac] required because of forked compilation
        //DOTALL seems to fix MEVENIDE-455 on windows. one of the characters seems to be a some kind of newline and that's why the line doesnt' get matched otherwise.
        failPattern = Pattern.compile("\\s*(?:\\[WARNING\\])?(?:\\[javac\\])?(?:Compilation failure)?\\s*(.*)\\.java\\:\\[([0-9]*),([0-9]*)\\] (.*)", Pattern.DOTALL); //NOI18N
    }
    
    @Override
    public void processLine(String line, OutputVisitor visitor) {
            Matcher match = failPattern.matcher(line);
            if (match.matches()) {
                String clazz = match.group(1);
                String lineNum = match.group(2);
                String text = match.group(4);
                File clazzfile;
                if (clazz.startsWith("\\") && !clazz.startsWith("\\\\") && windowsDrive != null) {
                    clazzfile = FileUtil.normalizeFile(new File(windowsDrive + clazz + ".java"));
                } else {
                    clazzfile = FileUtil.normalizeFile(new File(clazz + ".java"));
                }
                visitor.setOutputListener(new CompileAnnotation(clazzfile, lineNum,
                        text), text.indexOf("[deprecation]") < 0); //NOI18N
                FileUtil.refreshFor(clazzfile);
                FileObject file = FileUtil.toFileObject(clazzfile);
                String newclazz = clazz;
                if (file != null) {
                    Project prj = FileOwnerQuery.getOwner(file);
                    if (prj != null) {
                        Sources srcs = prj.getLookup().lookup(Sources.class);
                        if (srcs != null) {
                            for (SourceGroup grp : srcs.getSourceGroups(JavaProjectConstants.SOURCES_TYPE_JAVA)) {
                                if (FileUtil.isParentOf(grp.getRootFolder(), file)) {
                                    newclazz = FileUtil.getRelativePath(grp.getRootFolder(), file);
                                    if (newclazz.endsWith(".java")) { //NOI18N
                                        newclazz = newclazz.substring(0, newclazz.length() - ".java".length()); //NOI18N
                                    }
                                }
                            }
                        }
                    }
                }
                line = line.replace(clazz, newclazz); //NOI18N
                visitor.setLine(line);
            }
        match = windowsDriveInfoPattern.matcher(line);
        if (match.matches()) {
            windowsDrive = match.group(1);
        }
    }

    @Override
    public String[] getRegisteredOutputSequences() {
        return JAVAGOALS;
    }

    @Override
    public void sequenceStart(String sequenceId, OutputVisitor visitor) {
    }

    @Override
    public void sequenceEnd(String sequenceId, OutputVisitor visitor) {
    }
    
    @Override
    public void sequenceFail(String sequenceId, OutputVisitor visitor) {
    }
    
}
