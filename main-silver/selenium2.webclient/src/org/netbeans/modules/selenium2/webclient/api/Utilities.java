/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2014 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2014 Sun Microsystems, Inc.
 */
package org.netbeans.modules.selenium2.webclient.api;

import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.annotations.common.NullAllowed;
import org.netbeans.api.project.Project;
import org.netbeans.modules.gsf.testrunner.ui.api.TestRunnerNodeFactory;
import org.netbeans.modules.javascript.nodejs.api.NodeJsSupport;
import org.netbeans.modules.selenium2.webclient.spi.JumpToCallStackCallback;
import org.netbeans.modules.selenium2.webclient.ui.SeleniumTestRunnerNodeFactory;
import org.netbeans.modules.web.clientproject.api.ProjectDirectoriesProvider;
import org.netbeans.spi.project.ui.CustomizerProvider2;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Theofanis Oikonomou
 */
public class Utilities {

    private Utilities() {
    }
    
    /**
     * Gets file path (<b>possibly with parameters!</b>) representing <tt>node</tt> executable of the given project
     * or {@code null} if not set/found. If the project is {@code null}, the default <tt>node</tt>
     * path is returned (path set in IDE Options).
     * @param project project to get <tt>node</tt> for, can be {@code null}
     * @return file path (<b>possibly with parameters!</b>) representing <tt>node</tt> executable, can be {@code null} if not set/found
     * @since 1.2
     */
    @CheckForNull
    public static String getNode(@NullAllowed Project project) {
        return NodeJsSupport.getInstance().getNode(project);
    }
    
    /**
     * Checks whether node.js support is present and enabled in the given project.
     * @param project project to be checked
     * @return {@code true} if node.js support is present and enabled in the given project, {@code false} otherwise
     * @since 1.2
     */
    public static boolean isEnabled(@NonNull Project project) {
        return NodeJsSupport.getInstance().isEnabled(project);
    }
    /**
     * Opens <tt>node</tt> settings for the given project - if project specific <tt>node</tt> is used
     * (and node.js is enabled in the given project), Project Properties dialog is opened (otherwise
     * IDE Options). If project is {@code null}, opens IDE Options.
     * @param project project to be used, can be {@code null}
     * @since 1.2
     */
    public static void openNodeSettings(@NullAllowed Project project) {
        NodeJsSupport.getInstance().openNodeSettings(project);
    }
    
    @CheckForNull
    public static FileObject getTestsFolder(Project project, boolean showFileChooser) {
        ProjectDirectoriesProvider directoriesProvider = project.getLookup().lookup(ProjectDirectoriesProvider.class);
        if (directoriesProvider == null) {
            return null;
        }
        return directoriesProvider.getTestDirectory(showFileChooser);
    }
    
    @CheckForNull
    public static FileObject getTestsSeleniumFolder(Project project, boolean showFileChooser) {
        ProjectDirectoriesProvider directoriesProvider = project.getLookup().lookup(ProjectDirectoriesProvider.class);
        if (directoriesProvider == null) {
            return null;
        }
        return directoriesProvider.getTestSeleniumDirectory(showFileChooser);
    }

    public static void openCustomizer(Project project, String category) {
        assert project != null;
        assert category != null;
        CustomizerProvider2 customizerProvider = project.getLookup().lookup(CustomizerProvider2.class);
        assert customizerProvider != null : "CustomizerProvider2 must be found in lookup of " + project.getClass().getName();
        customizerProvider.showCustomizer(category, null);
    }
    
    public static TestRunnerNodeFactory getTestRunnerNodeFactory(JumpToCallStackCallback callback) {
        return new SeleniumTestRunnerNodeFactory(callback);
    }
    
}
