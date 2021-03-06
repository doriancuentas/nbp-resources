/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright © 2009-2012 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2009 Sun Microsystems, Inc.
 */
package org.netbeans.modules.testng.ant;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.apache.tools.ant.module.api.AntTargetExecutor;
import org.apache.tools.ant.module.api.support.AntScriptUtils;
import org.apache.tools.ant.module.spi.AntSession;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.modules.gsf.testrunner.api.RerunHandler;
import org.netbeans.modules.gsf.testrunner.api.RerunType;
import org.netbeans.modules.gsf.testrunner.api.TestSession;
import org.netbeans.modules.gsf.testrunner.api.Testcase;
import org.netbeans.modules.testng.api.TestNGSupport;
import org.netbeans.modules.testng.api.TestNGUtils;
import org.netbeans.modules.testng.spi.TestConfig;
import org.netbeans.modules.testng.spi.TestNGSupportImplementation;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.SingleMethod;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author answer
 */
public class TestNGExecutionManager implements RerunHandler {

    private File scriptFile = null;
    private String[] targets = null;
    private Properties properties;
    private TestSession testSession;
    private Lookup lookup = Lookup.EMPTY;

    private static final Logger LOGGER = Logger.getLogger(TestNGExecutionManager.class.getName());

    public TestNGExecutionManager(AntSession session, TestSession testSession, Properties props) {
        this.testSession = testSession;
        this.properties = props;
        properties.setProperty("ignore.failing.tests", "true"); //NOI18N
        try {
            scriptFile = session.getOriginatingScript();
            targets = session.getOriginatingTargets();

            String testIncludes = properties.getProperty("test.includes");//NOI18N
            if (testIncludes != null) {
                FileObject testFO = testSession.getFileLocator().find(testIncludes);
                lookup = Lookups.fixed(testFO);
            }
            
            //"Run/Debug Focused Test Method" actions (test-method/debug-test-single-nb) in a nb module project
            String testClass = properties.getProperty("test.class");//NOI18N
            String testMethods = properties.getProperty("test.methods");//NOI18N
            if(testClass != null) {
                FileObject testFO = testSession.getFileLocator().find(testClass.replace('.', '/') + ".java"); //NOI18N
                if (testMethods != null) {
                    SingleMethod methodSpec = new SingleMethod(testFO, testMethods);
                    lookup = Lookups.singleton(methodSpec);
                } else {
                    lookup = Lookups.fixed(testFO);
                }
            }
            
            if (targets.length == 0) {
                String className = properties.getProperty("classname");     //NOI18N
                String methodName = properties.getProperty("methodname");     //NOI18N
                if (className != null) {
                    FileObject testFO = testSession.getFileLocator().find(className.replace('.', '/') + ".java"); //NOI18N
                    if (methodName != null) {
                        SingleMethod methodSpec = new SingleMethod(testFO, methodName);
                        lookup = Lookups.singleton(methodSpec);
                    } else {
			if(testFO != null) {
			    lookup = Lookups.fixed(testFO);
			}
                    }
                }
                if (scriptFile.getName().equals("junit.xml")) {              //NOI18N
                    if (methodName != null) {
                        targets = new String[]{SingleMethod.COMMAND_RUN_SINGLE_METHOD};
                    } else {
                        targets = new String[]{ActionProvider.COMMAND_TEST_SINGLE};
                    }
                } else if (scriptFile.getName().equals("junit-debug.xml")) {  //NOI18N
                    if (methodName != null) {
                        targets = new String[]{SingleMethod.COMMAND_DEBUG_SINGLE_METHOD};
                    } else {
                        targets = new String[]{ActionProvider.COMMAND_DEBUG_TEST_SINGLE};
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void rerun() {
        if ((properties.getProperty("test.includes") != null && properties.getProperty("test.includes").endsWith(".xml")) ||    //NOI18N
                (properties.getProperty("test.class") != null && properties.getProperty("test.class").endsWith(".xml"))) {   //NOI18N
            if (properties.getProperty("continue.after.failing.tests") == null) {   //NOI18N
                properties.setProperty("continue.after.failing.tests", "true");  //NOI18N
            }
            try {
                runAnt(FileUtil.toFileObject(scriptFile), targets, properties);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            Project project = testSession.getProject();
            if(ProjectManager.getDefault().isValid(project)) {
                ActionProvider actionProvider = project.getLookup().lookup(ActionProvider.class);
                String[] actionNames = getActionNames(targets);
                if (actionProvider != null) {
                    if (Arrays.asList(actionProvider.getSupportedActions()).contains(actionNames[0])
                            && actionProvider.isActionEnabled(actionNames[0], lookup)) {
                        actionProvider.invokeAction(actionNames[0], lookup);
                    }
                }
            }
        }
    }

    public void rerun(Set<Testcase> tests) {
        Project p = testSession.getProject();
        TestNGSupportImplementation.TestExecutor exec = TestNGSupport.findTestNGSupport(p).createExecutor(p);
        TestConfig conf = TestNGUtils.getTestConfig(p.getProjectDirectory(), true, null, null, null);
        try {
            exec.execute(TestNGSupport.Action.RUN_FAILED, conf);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public boolean enabled(RerunType type) {
        switch (type){
            case ALL:
                return true;
            case CUSTOM:
                Project p = testSession.getProject();
                if (TestNGSupport.isActionSupported(TestNGSupport.Action.RUN_FAILED, p)) {
                    return TestNGSupport.findTestNGSupport(p).createExecutor(p).hasFailedTests();
                }
                return false;
            default:
                return false;
        }
    }

//    public boolean enabled() {
//        if ((scriptFile == null) || (targets == null) || (targets.length == 0)) {
//            return false;
//        }
//
//        Project project = testSession.getProject();
//        ActionProvider actionProvider = project.getLookup().lookup(ActionProvider.class);
//        if (actionProvider != null) {
//            boolean runSupported = false;
//            for (String action : actionProvider.getSupportedActions()) {
//                if (action.equals(targets[0])) {
//                    runSupported = true;
//                    break;
//                }
//            }
//            if (runSupported && actionProvider.isActionEnabled(targets[0], lookup)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    @Override
    public void addChangeListener(ChangeListener listener) {
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
    }

    private static void runAnt(FileObject antScript, String[] antTargets, Properties antProps) throws IOException {
        AntTargetExecutor.Env execenv = new AntTargetExecutor.Env();
        Properties props = execenv.getProperties();
        props.putAll(antProps);
        execenv.setProperties(props);
        AntTargetExecutor.createTargetExecutor(execenv).execute(AntScriptUtils.antProjectCookieFor(antScript), antTargets);
    }

    private String[] getActionNames(String[] targetNames) {
        String[] actions = new String[targetNames.length];
        for (int i = 0; i < targetNames.length; i++) {
            if (targetNames[i].equals("test-single")) {                      //NOI18N
                actions[i] = ActionProvider.COMMAND_TEST_SINGLE;
            } else if (targetNames[i].equals("debug-test")) {                //NOI18N
                actions[i] = ActionProvider.COMMAND_DEBUG_TEST_SINGLE;
            } else if (targetNames[i].equals("test-unit")) {                //NOI18N
                actions[i] = ActionProvider.COMMAND_TEST;
            } else if (targetNames[i].equals("test-method")) {                //NOI18N
                actions[i] = SingleMethod.COMMAND_RUN_SINGLE_METHOD;
            } else if (targetNames[i].equals("debug-test-single-nb")) {                //NOI18N
                String testMethods = properties.getProperty("test.methods");//NOI18N
                if (testMethods != null) {
                    actions[i] = SingleMethod.COMMAND_DEBUG_SINGLE_METHOD;
                } else {
                    actions[i] = ActionProvider.COMMAND_DEBUG_TEST_SINGLE;
                }
            } else {
                actions[i] = targetNames[i];
            }
        }
        return actions;
    }
}
