/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright © 2008-2012 Oracle and/or its affiliates. All rights reserved.
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
 * nbbuild/licenses/CDDL-GPL-2-CP.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
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
package org.netbeans.modules.testng.ant;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tools.ant.module.api.support.ActionUtils;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.java.project.classpath.ProjectClassPathModifier;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.libraries.Library;
import org.netbeans.api.project.libraries.LibraryManager;
import org.netbeans.modules.java.testrunner.JavaUtils;
import org.netbeans.modules.testng.api.TestNGSupport.Action;
import org.netbeans.modules.testng.spi.TestConfig;
import org.netbeans.modules.testng.spi.TestNGSupportImplementation;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.netbeans.spi.project.ant.AntArtifactProvider;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author lukas
 */
@ServiceProvider(service = TestNGSupportImplementation.class)
public class AntTestNGSupport extends TestNGSupportImplementation {

    private static final Logger LOGGER = Logger.getLogger(AntTestNGSupport.class.getName());
    private static final Set<Action> SUPPORTED_ACTIONS;

    static {
        Set<Action> s = new HashSet<Action>();
//        s.add(Action.CREATE_TEST);
//        s.add(Action.RUN_FAILED);
//        s.add(Action.RUN_TESTMETHOD);
        s.add(Action.RUN_TESTSUITE);
//        s.add(Action.DEBUG_TEST);
//        s.add(Action.DEBUG_TESTMETHOD);
        s.add(Action.DEBUG_TESTSUITE);
        SUPPORTED_ACTIONS = Collections.unmodifiableSet(s);
    }

    @Override
    public boolean isSupportEnabled(FileObject[] activatedFOs) {
        return JavaUtils.isSupportEnabled(AntArtifactProvider.class, activatedFOs);
    }

    @Override
    public boolean isActionSupported(Action action, Project p) {
        return p != null && p.getLookup().lookup(AntArtifactProvider.class) != null && SUPPORTED_ACTIONS.contains(action);
    }

    @Override
    public void configureProject(FileObject createdFile) {
        assert createdFile != null;

        Project p = FileOwnerQuery.getOwner(createdFile);
        ClassPath cp = ClassPath.getClassPath(createdFile, ClassPath.COMPILE);
        FileObject ng = cp.findResource("org.testng.annotations.Test"); //NOI18N
        if (ng == null) {
            // add library to the project
            Library nglib = LibraryManager.getDefault().getLibrary("testng"); //NOI18N
            try {
                if (!ProjectClassPathModifier.addLibraries(new Library[]{nglib}, createdFile, ClassPath.COMPILE)) {
                    LOGGER.log(Level.FINE, "TestNG library not added to project {0}", p); //NOI18N
                }
            } catch (IOException ex) {
                Logger.getLogger(AntTestNGSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedOperationException ex) {
                Logger.getLogger(AntTestNGSupport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//        AntBuildExtender extender = p.getLookup().lookup(AntBuildExtender.class);
//        if (extender != null) {
//            String ID = "test-ng-1.0"; //NOI18N
//            Extension extension = extender.getExtension(ID);
//            if (extension == null) {
//                LOGGER.log(Level.FINER, "Extensible targets: {0}", extender.getExtensibleTargets());
//                try {
//                    // create testng-build.xml
//                    FileObject testng = p.getProjectDirectory().getFileObject("nbproject").createData("testng-impl", "xml"); //NOI18N
//                    InputStream is = AntTestNGSupport.class.getResourceAsStream("testng-build.xml"); //NOI18N
//                    FileLock lock = testng.lock();
//                    OutputStream os = testng.getOutputStream(lock);
//                    try {
//                        FileUtil.copy(is, os);
//                    } finally {
//                        if (is != null) {
//                            is.close();
//                        }
//                        if (os != null) {
//                            os.close();
//                        }
//                        lock.releaseLock();
//                    }
//                    extension = extender.addExtension(ID, testng);
//                    extension.addDependency("-pre-pre-compile", "-reinit-tasks"); //NOI18N
//                    ProjectManager.getDefault().saveProject(p);
//                } catch (IOException ex) {
//                    LOGGER.log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    @Override
    public TestExecutor createExecutor(Project p) {
        return new AntExecutor(p);
    }

    private static class AntExecutor implements TestNGSupportImplementation.TestExecutor {

        private static final String failedConfPath = "build/test/results/testng-failed.xml"; //NOI18N
        private Project p;

        public AntExecutor(Project p) {
            this.p = p;
        }

        @Override
        public boolean hasFailedTests() {
            FileObject projectHome = p.getProjectDirectory();
            //XXX - should rather listen on a fileobject??
            FileUtil.refreshFor(FileUtil.toFile(projectHome));
            FileObject failedTestsConfig = projectHome.getFileObject(failedConfPath);
            return failedTestsConfig != null && failedTestsConfig.isValid();
        }

        @Override
        public void execute(Action action, TestConfig config) throws IOException {
            FileObject projectHome = p.getProjectDirectory();
            Properties props = new Properties();
            String cmd = null;
            FileObject test = config.getTest();
            ClassPath classPath = ClassPath.getClassPath(test, ClassPath.SOURCE);
	    if(classPath == null) {
		LOGGER.log(Level.WARNING, "Could not find any classpath for file {0}", FileUtil.toFile(test)); //NOI18N
		return;
	    }
            FileObject[] testRoots = classPath.getRoots();
            FileObject testRoot = null;
            for (FileObject root : testRoots) {
                if (FileUtil.isParentOf(root, test)) {
                    testRoot = root;
                    break;
                }
            }
            if (Action.RUN_TESTSUITE.equals(action)) {
                cmd = "test-single"; //NOI18N
                String xml = FileUtil.getRelativePath(testRoot, test);
                assert xml != null;
                props.put("test.includes", xml); //NOI18N
                if (isNbModuleProject()) {
                    props.setProperty("continue.after.failing.tests", "true");  //NOI18N
                }
            } else if (Action.DEBUG_TESTSUITE.equals(action)) {
                if (isNbModuleProject()) {
                    cmd = "debug-test-single-nb"; //NOI18N
                    String xml = FileUtil.getRelativePath(testRoot, test);
                    assert xml != null;
                    props.put("test.class", xml); //NOI18N
                    props.setProperty("continue.after.failing.tests", "true");  //NOI18N
                } else {
                    cmd = "debug-test"; //NOI18N
                    props.put("test.class", "'".concat(FileUtil.toFile(test).getAbsolutePath()).concat("'")); //NOI18N
                }
            } else if (Action.RUN_TESTMETHOD.equals(action)) {
                if (isNbModuleProject()) {
                    cmd = "test-method"; //NOI18N
                    props.put("test.class", config.getPackageName() + "." + config.getClassName()); //NOI18N
                    props.put("test.methods", config.getMethodName()); //NOI18N
                    props.setProperty("continue.after.failing.tests", "true");  //NOI18N
                } else {
                    cmd = "test-single-method"; //NOI18N
                    props.put("test.class", config.getPackageName() + "." + config.getClassName()); //NOI18N
                    props.put("test.method", config.getMethodName()); //NOI18N
                }
            } else if (Action.DEBUG_TESTMETHOD.equals(action)) {
                if (isNbModuleProject()) {
                    cmd = "debug-test-single-nb"; //NOI18N
                    props.put("test.class", config.getPackageName() + "." + config.getClassName()); //NOI18N
                    props.put("test.methods", config.getMethodName()); //NOI18N
                    props.setProperty("continue.after.failing.tests", "true");  //NOI18N
                } else {
                    cmd = "debug-test-method"; //NOI18N
                    props.put("test.class", config.getPackageName() + "." + config.getClassName()); //NOI18N
                    props.put("test.method", config.getMethodName()); //NOI18N
                }
            }
            assert cmd != null : "Unsupported action: " + action; //NOI18N
            props.put("javac.includes", ActionUtils.antIncludesList(new FileObject[]{testRoot}, testRoot, true)); //NOI18N
            props.setProperty("ignore.failing.tests", "true"); //NOI18N
	    FileObject buildFO = projectHome.getFileObject("build.xml"); //NOI18N
	    if(buildFO == null) {
		LOGGER.log(Level.WARNING, "Could not locate build.xml for project in {0}", projectHome); //NOI18N
		return;
	    }
            ActionUtils.runTarget(buildFO, new String[]{cmd}, props);
        }

        private boolean isNbModuleProject() {
            return p.getLookup().lookup(AntTestNGSupportProjectServiceProvider.class) != null;
        }

        @ProjectServiceProvider(service = AntTestNGSupportProjectServiceProvider.class, projectType = "org-netbeans-modules-apisupport-project")
        public static class AntTestNGSupportProjectServiceProvider {
            public AntTestNGSupportProjectServiceProvider(Project p) { }
        }
    }
}
