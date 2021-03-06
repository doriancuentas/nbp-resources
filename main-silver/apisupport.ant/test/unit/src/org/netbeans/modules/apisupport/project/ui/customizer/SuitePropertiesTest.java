/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
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
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
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
 */

package org.netbeans.modules.apisupport.project.ui.customizer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import javax.swing.JList;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.modules.apisupport.project.NbModuleProject;
import org.netbeans.modules.apisupport.project.NbModuleType;
import org.netbeans.modules.apisupport.project.SuiteProvider;
import org.netbeans.modules.apisupport.project.TestBase;
import org.netbeans.modules.apisupport.project.api.Util;
import org.netbeans.modules.apisupport.project.suite.SuiteProject;
import org.netbeans.modules.apisupport.project.ui.customizer.CustomizerComponentFactory.SuiteSubModulesListModel;
import org.netbeans.modules.apisupport.project.universe.NbPlatform;
import org.netbeans.spi.project.SubprojectProvider;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.netbeans.spi.project.support.ant.EditableProperties;
import org.openide.util.Mutex;
import org.openide.util.MutexException;
import org.openide.util.NbCollections;

/**
 * Tests {@link SuiteProperties}. Actually also for some classes which
 * SuiteProperties utilizes - which doesn't mean they shouldn't be tested
 * individually :)
 *
 * @author Martin Krauskopf
 */
public class SuitePropertiesTest extends TestBase {
    
    public SuitePropertiesTest(String name) {
        super(name);
    }
    
    protected void setUp() throws Exception {
        clearWorkDir();
        super.setUp();
        ModuleProperties.runFromTests = true;
    }
    
    public static SuiteProperties getSuiteProperties(SuiteProject suite) throws IOException {
        SubprojectProvider spp = getSubProjectProvider(suite);
        Set<NbModuleProject> subModules = NbCollections.checkedSetByCopy(spp.getSubprojects(), NbModuleProject.class, true);
        SuiteProperties suiteProps = new SuiteProperties(suite, suite.getHelper(),
                suite.getEvaluator(), subModules);
        return suiteProps;
    }
    
    static SubprojectProvider getSubProjectProvider(Project project) throws IOException {
        return project.getLookup().lookup(SubprojectProvider.class);
    }
    
    public void testPropertiesAreLoaded() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        assert suite1 != null;
        NbModuleProject module1a = TestBase.generateSuiteComponent(suite1, "module1a");
        assert module1a != null;
        NbModuleProject module1b = TestBase.generateSuiteComponent(suite1, "module1b");
        assert module1b != null;
        SuiteProperties suite1Props = getSuiteProperties(suite1);
        
        assertNotNull(suite1Props.getActivePlatform());
        assertEquals("platform id: ", NbPlatform.PLATFORM_ID_DEFAULT, suite1Props.getActivePlatform().getID());
        SuiteSubModulesListModel model = suite1Props.getModulesListModel();
        assertNotNull(model);
        assertEquals("number of sub-modules: ", 2, model.getSize());
        // assert order by display name ("module1a", "module1b")
        NbModuleProject p = (NbModuleProject) model.getElementAt(0);
        assertEquals("module1a project first", p.getCodeNameBase(), "org.example.module1a");
        p = (NbModuleProject) model.getElementAt(1);
        assertEquals("module1b project first", p.getCodeNameBase(), "org.example.module1b");
    }
    
    public void testRemoveAllSubModules() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        TestBase.generateSuiteComponent(suite1, "module1a");
        TestBase.generateSuiteComponent(suite1, "module1b");
        SuiteProperties suite1Props = getSuiteProperties(suite1);
        
        SuiteSubModulesListModel model = suite1Props.getModulesListModel();
        assertNotNull(model);
        
        // simulate removing all items from the list
        JList moduleList = new JList(model);
        moduleList.setSelectedIndices(new int[] {0, model.getSize() - 1});
        model.removeModules(Arrays.asList(moduleList.getSelectedValues()));
        assertEquals("no subModule should be left", 0, model.getSize());
        
        saveProperties(suite1Props);
        
        SubprojectProvider spp = getSubProjectProvider(suite1);
        assertEquals("no module should be left", 0, spp.getSubprojects().size());
    }
    
    public void testAddModule() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        TestBase.generateSuiteComponent(suite1, "module1");
        
        SubprojectProvider spp = getSubProjectProvider(suite1);
        SuiteProperties suiteProps = getSuiteProperties(suite1);
        
        SuiteSubModulesListModel model = suiteProps.getModulesListModel();
        assertEquals("one module suite component", 1, model.getSize());
        
        NbModuleProject module2ToAdd = generateStandaloneModule("module2");
        NbModuleProject module3ToAdd = generateStandaloneModule("module3");
        assertNull(module2ToAdd.getLookup().lookup(SuiteProvider.class));
        model.addModule(module2ToAdd);
        model.addModule(module3ToAdd);
        
        saveProperties(suiteProps);

        SuiteProvider suiteProvider = module2ToAdd.getLookup().lookup(SuiteProvider.class);
        assertNotNull(suiteProvider);
        assertNotNull(suiteProvider.getSuiteDirectory());
        
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        assertNotNull(suiteProvider.getSuiteDirectory());
        assertEquals("three module suite components", 3, suiteProps.getModulesListModel().getSize());
    }
    
    public void testRemoveOneSubModule() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        NbModuleProject module1a = TestBase.generateSuiteComponent(suite1, "module1a");
        TestBase.generateSuiteComponent(suite1, "module1b");
        SuiteProperties suite1Props = getSuiteProperties(suite1);
        
        SuiteSubModulesListModel model = suite1Props.getModulesListModel();
        assertNotNull(model);
        
        // simulate removing first item from the list
        JList moduleList = new JList(model);
        moduleList.setSelectedIndex(0);
        model.removeModules(Arrays.asList(moduleList.getSelectedValues()));
        assertEquals("one subModule should left", 1, model.getSize());
        
        saveProperties(suite1Props);
        
        SubprojectProvider spp = getSubProjectProvider(suite1);
        assertEquals("one module should be left", 1, spp.getSubprojects().size());
        NbModuleProject project = (NbModuleProject) spp.getSubprojects().toArray()[0];
        assertEquals("module1b should be the one", "org.example.module1b", project.getCodeNameBase());
        assertSame("module1b module is still suite component module", NbModuleType.SUITE_COMPONENT, project.getModuleType());
        
        // assert that the remove module (module1a) is standalone
        assertSame("module1a module is standalone module now", NbModuleType.STANDALONE, module1a.getModuleType());
    }

//    XXX: failing test, fix or delete
//    public void testMoveSubModuleBetweenSuites() throws Exception {
//        SuiteProject suite1 = generateSuite("suite1");
//        TestBase.generateSuiteComponent(suite1, "module1a");
//        TestBase.generateSuiteComponent(suite1, "module1b");
//        TestBase.generateSuiteComponent(suite1, "module1c");
//
//        SuiteProject suite2 = generateSuite("suite2");
//        NbModuleProject module2a = TestBase.generateSuiteComponent(suite2, "module2a");
//
//        // simulate addition of module2a to the suite1
//        SuiteProperties suite1Props = getSuiteProperties(suite1);
//        SuiteSubModulesListModel suite1model = suite1Props.getModulesListModel();
//        suite1model.addModule(module2a);
//
//        saveProperties(suite1Props); // saves all changes
//
//        // assert module2a is part of suite1 (has moved from suite2)....
//        SubprojectProvider suite1spp = getSubProjectProvider(suite1);
//        assertEquals("four module", 4, suite1spp.getSubprojects().size());
//        assertTrue("module2a has moved to suite1", suite1spp.getSubprojects().contains(module2a));
//
//        // ....and as such has correctly set suite provider
//        SuiteProvider sp = module2a.getLookup().lookup(SuiteProvider.class);
//        assertNotNull(sp);
//        assertNotNull(sp.getSuiteDirectory());
//        assertEquals("module2a has suite1 as a SuiteProvider", suite1.getProjectDirectoryFile(), sp.getSuiteDirectory());
//
//        // assert module2a is not part of suite2 (has moved to suite1)....
//        SubprojectProvider suite2spp = getSubProjectProvider(suite2);
//        assertEquals("no module", 0, suite2spp.getSubprojects().size());
//        assertFalse("module2a is not part of suite2", suite2spp.getSubprojects().contains(module2a));
//    }
    
    public void testRemovingSecondModuleFromThree_63307() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        TestBase.generateSuiteComponent(suite1, "module1");
        NbModuleProject module2 = TestBase.generateSuiteComponent(suite1, "module2");
        TestBase.generateSuiteComponent(suite1, "module3");
        
        SubprojectProvider spp = getSubProjectProvider(suite1);
        SuiteProperties suiteProps = getSuiteProperties(suite1);
        
        SuiteSubModulesListModel model = suiteProps.getModulesListModel();
        assertEquals("three module suite components", 3, model.getSize());
        model.removeModules(Arrays.asList(new Object[] { module2 }));
        
        saveProperties(suiteProps);
        
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        assertEquals("two module suite components", 2, suiteProps.getModulesListModel().getSize());
    }
    
    public void testRefreshing_63307() throws Exception {
        SuiteProject suite1 = generateSuite("suite1");
        TestBase.generateSuiteComponent(suite1, "module1");
        SubprojectProvider spp = getSubProjectProvider(suite1);
        SuiteProperties suiteProps = getSuiteProperties(suite1);
        assertEquals("one module", "${project.org.example.module1}", suiteProps.getProperty(SuiteUtils.MODULES_PROPERTY));
        TestBase.generateSuiteComponent(suite1, "module2");
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        assertEquals("two modules", "${project.org.example.module1}:${project.org.example.module2}", suiteProps.getProperty(SuiteUtils.MODULES_PROPERTY));
        assertEquals("two module suite component", 2, suiteProps.getModulesListModel().getSize());
    }
    
    public void testRefreshingWithRemovedPlatformDoesNotThrowNPE() throws Exception {
        SuiteProject suite1 = TestBase.generateSuite(getWorkDir(), "suite1", "custom");
        SubprojectProvider spp = getSubProjectProvider(suite1);
        SuiteProperties suiteProps = getSuiteProperties(suite1);
        NbPlatform.removePlatform(NbPlatform.getPlatformByID("custom"));
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        assertNotNull(suiteProps.getActivePlatform());
        assertEquals("default platform", suiteProps.getActivePlatform(), NbPlatform.getDefaultPlatform());
    }
    
    public void testCustomPropertiesReferences_61318() throws Exception {
        final SuiteProject suite1 = generateSuite("suite1");
        TestBase.generateSuiteComponent(suite1, "module1");
        NbModuleProject module2 = TestBase.generateSuiteComponent(suite1, "module2");
        TestBase.generateSuiteComponent(suite1, "module3");
        
        SubprojectProvider spp = getSubProjectProvider(suite1);
        final SuiteProperties suiteProps = getSuiteProperties(suite1);
        
        SuiteSubModulesListModel model = suiteProps.getModulesListModel();
        assertEquals("three module suite components", 3, model.getSize());
        
        ProjectManager.mutex().writeAccess(new Mutex.ExceptionAction<Void>() {
            public Void run() throws Exception {
                // choose another way to store submodules
                EditableProperties edProps = suiteProps.getProjectProperties();
                edProps.setProperty("moddir", ".");
                edProps.setProperty("modules", "${moddir}/module1:${moddir}/module2:${moddir}/module3");
                Util.storeProperties(
                        suite1.getProjectDirectory().getFileObject(AntProjectHelper.PROJECT_PROPERTIES_PATH),
                        edProps);
                return null;
            }
        });
        
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        model = suiteProps.getModulesListModel(); // reload
        assertEquals("three module suite components", 3, model.getSize());
        model.removeModules(Arrays.asList(new Object[] { module2 }));
        saveProperties(suiteProps);
        
        suiteProps.refresh(NbCollections.checkedSetByFilter(spp.getSubprojects(), NbModuleProject.class, true));
        model = suiteProps.getModulesListModel(); // reload
        assertEquals("two module suite components", 2, model.getSize());
    }
    
    public void testSuitePropertiesWithAnonymousPlatform() throws Exception { // #73795
        SuiteProject suite1 = TestBase.generateSuite(getWorkDir(), "suite1", "custom");
        SuiteProperties suiteProps = getSuiteProperties(suite1);
        File destDir = NbPlatform.getPlatformByID("custom").getDestDir();
        NbPlatform.removePlatform(NbPlatform.getPlatformByID("custom"));
        suiteProps.setActivePlatform(NbPlatform.getPlatformByDestDir(destDir, null));
        saveProperties(suiteProps);
    }
    
    private void saveProperties(final SuiteProperties props) throws IOException {
        try {
            // Store properties
            ProjectManager.mutex().writeAccess(new Mutex.ExceptionAction<Void>() {
                public Void run() throws IOException {
                    props.storeProperties();
                    return null;
                }
            });
            ProjectManager.getDefault().saveProject(props.getProject());
        } catch (MutexException e) {
            throw (IOException) e.getException();
        }
    }
    
}

