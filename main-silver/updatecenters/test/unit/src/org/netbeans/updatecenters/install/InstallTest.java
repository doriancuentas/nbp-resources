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
package org.netbeans.updatecenters.install;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.netbeans.api.autoupdate.InstallSupport;
import org.netbeans.api.autoupdate.InstallSupport.Installer;
import org.netbeans.api.autoupdate.InstallSupport.Validator;
import org.netbeans.api.autoupdate.OperationContainer;
import org.netbeans.api.autoupdate.OperationContainer.OperationInfo;
import org.netbeans.api.autoupdate.OperationException;
import org.netbeans.api.autoupdate.OperationSupport.Restarter;
import org.netbeans.api.autoupdate.UpdateElement;
import org.netbeans.api.autoupdate.UpdateManager;
import org.netbeans.api.autoupdate.UpdateUnit;
import org.netbeans.junit.NbTestSuite;
import org.netbeans.junit.NbTestCase;
import org.netbeans.updatecenters.CountsStruct;
import org.netbeans.updatecenters.OperationUtils;

/**
 *
 * @author Jaromir.Uhrik@Sun.Com
 */
public class InstallTest extends NbTestCase {

    private static final String TEST_NEW_PLUGINS_EMPTY = "testNewPluginsEmpty";
    private static List<UpdateUnit> allAvailableUnits = null;
    private static List<UpdateElement> filteredPlugins = null;
    
    private static List<UpdateElement> currentlyPendingInstalls = null;
    private static List<UpdateElement> currentlyInstalledPlugins = null;
    private static List<UpdateElement> currentlyUpdatePlugins = null;
    //test specific
    private int currentTestNumber = 0;
    private UpdateElement currentElementToInstall = null;

    public InstallTest(String testName, UpdateElement element, int currentTestNumber) {
        super(testName);
        this.currentTestNumber = currentTestNumber;
        this.currentElementToInstall = element;
    }

    public static boolean[] readLists(String[] excludePluginFilters, String[] includePluginFilters) {
        List<UpdateElement> installedPlugins = null;
        List<UpdateElement> newPlugins = null;
        List<UpdateElement> updatePlugins = null;
        installedPlugins = new ArrayList<UpdateElement>();
        newPlugins = new ArrayList<UpdateElement>();
        updatePlugins = new ArrayList<UpdateElement>();


        boolean[] includePluginFiltersUsed = null;
        if (includePluginFilters != null) {
            includePluginFiltersUsed = new boolean[includePluginFilters.length];
            for (int i = 0; i < includePluginFiltersUsed.length; i++) {
                includePluginFiltersUsed[i] = false;
            }
        }

        for (UpdateUnit updateUnit : allAvailableUnits) {
            UpdateElement element = updateUnit.getInstalled();
            if (updateUnit.getInstalled() != null) {
                //all plugins that are installed or available updates
                List<UpdateElement> availableUpdates = updateUnit.getAvailableUpdates();
                if (!availableUpdates.isEmpty()) {
                    //updatePlugins
                    updatePlugins.add(availableUpdates.get(0));
                } else {
                    //installedPlugins
                    installedPlugins.add(element);
                }
            } else {
                //newPlugins (available not installed plugins)
                List<UpdateElement> availableUpdates = updateUnit.getAvailableUpdates();
                if (!availableUpdates.isEmpty()) {
                    UpdateElement elementToInstall = availableUpdates.get(0);
                    newPlugins.add(elementToInstall);
                    //include filters specified
                    if (includePluginFilters != null) {
                        for (int i = 0; i < includePluginFilters.length; i++) {
                            String string = includePluginFilters[i];
                            if (elementToInstall.getCodeName().equals(string)) {
                                //add it to the filteredPlugins
                                filteredPlugins.add(elementToInstall);
                                includePluginFiltersUsed[i] = true;
                                //remove it if exclude filter 
                                if (excludePluginFilters != null) {
                                    for (String excludeFilter : excludePluginFilters) {
                                        if (elementToInstall.getCodeName().equals(excludeFilter)) {
                                            filteredPlugins.remove(elementToInstall);
                                        }
                                    }
                                }

                            }
                        }
                    //include filter not specified(=specified as '*') =>   
                    } else {
                        //add it to the filteredPlugins
                        filteredPlugins.add(elementToInstall);
                        //remove it if exclude filter 
                        if (excludePluginFilters != null) {
                            for (String excludeFilter : excludePluginFilters) {
                                if (elementToInstall.getCodeName().equals(excludeFilter)) {
                                    filteredPlugins.remove(elementToInstall);
                                }
                            }
                        }
                    }
                }
            }
        }
        return includePluginFiltersUsed;
    }

    public static CountsStruct getPluginCounts(String[] excludePluginFilters, String[] includePluginFilters) {
        currentlyPendingInstalls = null;
        currentlyPendingInstalls = new ArrayList<UpdateElement>();
        currentlyInstalledPlugins = null;
        currentlyInstalledPlugins = new ArrayList<UpdateElement>();
        currentlyUpdatePlugins = null;
        currentlyUpdatePlugins = new ArrayList<UpdateElement>();

        //new, installed, updates, filtered, pending
        CountsStruct countsStruct = new CountsStruct();

        boolean[] includePluginFiltersUsed = null;
        if (includePluginFilters != null) {
            includePluginFiltersUsed = new boolean[includePluginFilters.length];
            for (int i = 0; i < includePluginFiltersUsed.length; i++) {
                includePluginFiltersUsed[i] = false;
            }
        }
        for (UpdateUnit updateUnit : allAvailableUnits) {
            UpdateElement element = updateUnit.getInstalled();
            if (updateUnit.getInstalled() != null) {
                //all plugins that are installed or available updates
                List<UpdateElement> availableUpdates = updateUnit.getAvailableUpdates();
                if (!availableUpdates.isEmpty()) {
                    //updatePlugins
                    countsStruct.incUpdatesCount();
                    currentlyUpdatePlugins.add(element);
                } else {
                    //installedPlugins
                    countsStruct.incInstalledCount();
                    currentlyInstalledPlugins.add(element);
                }
            } else {
                //newPlugins (available not installed plugins)
                List<UpdateElement> availableUpdates = updateUnit.getAvailableUpdates();
                if (!availableUpdates.isEmpty()) {
                    UpdateElement elementToInstall = availableUpdates.get(0);
                    countsStruct.incNewCount();
                    if (updateUnit.isPending()) {
                        countsStruct.incPendingCount();
                        currentlyPendingInstalls.add(elementToInstall);
                    }
                    //include filters specified
                    if (includePluginFilters != null) {
                        for (int i = 0; i < includePluginFilters.length; i++) {
                            String string = includePluginFilters[i];
                            if (elementToInstall.getCodeName().equals(string)) {
                                //add it to the filteredPlugins
                                countsStruct.incFilteredCount();
                                includePluginFiltersUsed[i] = true;
                                //remove it if exclude filter 
                                if (excludePluginFilters != null) {
                                    for (String excludeFilter : excludePluginFilters) {
                                        if (elementToInstall.getCodeName().equals(excludeFilter)) {
                                            countsStruct.decFilteredCount();
                                        }
                                    }
                                }

                            }
                        }

                    } else {//include filter not specified(=specified as '*') =>
                        //add it to the filteredPlugins

                        countsStruct.incFilteredCount();
                        //remove it if exclude filter 
                        if (excludePluginFilters != null) {
                            for (String excludeFilter : excludePluginFilters) {
                                if (elementToInstall.getCodeName().equals(excludeFilter)) {
                                    countsStruct.decFilteredCount();
                                }
                            }
                        }
                    }
                }
            }
        }
        return countsStruct;
    }

    @Override
    protected void runTest() throws Throwable {
        String[] excludePluginFilters = OperationUtils.parseExcludePluginFilters();
        String[] includePluginFilters = OperationUtils.parseIncludePluginFilters();

        CountsStruct pluginCounts = getPluginCounts(excludePluginFilters, includePluginFilters);
        if (currentElementToInstall == null) {
            if (getName().equals(TEST_NEW_PLUGINS_EMPTY)) {
                OperationUtils.logProperties(this);
                OperationUtils.logRegisteredUCs(true, this);
                logCurrentValues(pluginCounts);
                assertFalse("The list of plugins to install is empty!", filteredPlugins.isEmpty());
            } else {
                fail("Specified plugin '" + getName().substring(OperationUtils.INVALID_FILTER_PREFIX.length()) + "' is not available - maybe the filter is wrong");
            }
        } else {
            System.out.println("INSTALLING PLUGIN #" + currentTestNumber + "/" + filteredPlugins.size());
            logCurrentValues(pluginCounts);
            installPlugin(currentElementToInstall);
            CountsStruct newPluginCounts = getPluginCounts(excludePluginFilters, includePluginFilters);
            logCurrentValues(newPluginCounts);
        }
    }

    public void installPlugin(UpdateElement updateElement) {
        log("");
        log("-----------------------------------------------------------");
        log("|  INSTALLING FOLLOWING PLUGIN :                          |");
        log("-----------------------------------------------------------");
        log("[" + updateElement.getDisplayName() + "]" + updateElement.getCodeName());


        int numberOfPluginsToInstall = 0;

        OperationContainer<InstallSupport> install = OperationContainer.createForInstall();

        OperationInfo info = null;
        try {
            info = install.add(updateElement);
        } catch (IllegalArgumentException illegalArgumentException) {
            fail("Cannot install plugin [" + updateElement.getDisplayName() + "] " + updateElement.getCodeName() + " - probably it has already been installed by some other test. Check .log files of previously executed tests.");
            illegalArgumentException.printStackTrace();
        }

        log("Broken dependencies:");
        log(info.getBrokenDependencies().toString());
        numberOfPluginsToInstall++;
        for (OperationInfo i : install.listAll()) {
            Set<UpdateElement> reqElements = i.getRequiredElements();
            log("List of required plugins is:");
            for (UpdateElement reqElm : reqElements) {
                if (!currentlyUpdatePlugins.contains(reqElm) &&
                        !currentlyInstalledPlugins.contains(reqElm) &&
                        !currentlyPendingInstalls.contains(reqElm)) {
                    install.add(reqElm);
                    log("[" + reqElm.getDisplayName() + "]" + reqElm.getCodeName());
                    numberOfPluginsToInstall++;
                }
            }
        }
        log("Number Of Plugins to install:" + numberOfPluginsToInstall);
        List<OperationInfo<InstallSupport>> lst = install.listAll();
        assertTrue("List of invalid is not empty.", install.listInvalid().isEmpty());
        assertTrue("Dependencies broken for plugin '" + updateElement.getDisplayName() + "'." + info.getBrokenDependencies().toString(), info.getBrokenDependencies().size() == 0);
        InstallSupport is = install.getSupport();
        try {
            Validator v = is.doDownload(null, true);
            assertNotNull("Validator for " + updateElement + " is not null.", v);
            Installer installer;
            try {
                installer = is.doValidate(v, null);
                Restarter r = is.doInstall(installer, null);
                if (r == null) {
                } else {
                    is.doRestartLater(r);

                }
            } catch (OperationException oex) {
                fail("Unsuccessful operation!");
                oex.printStackTrace();
            }
        } catch (Exception e) {
            fail("Cannot download required plugin or some dependency - probably it doesn't exist");
            e.printStackTrace();
        }
        log("-----------------------------------------------------------");
    }

    public static NbTestSuite suite() throws Exception {
        NbTestSuite suite = new NbTestSuite();
        OperationUtils.setProperUpdateCenters(true, true);
        OperationUtils.refreshProviders();
        OperationUtils.saveUCList(OperationUtils.UC_LIST_FILE_NAME, true);

        filteredPlugins = null;
        filteredPlugins = new ArrayList<UpdateElement>();


        allAvailableUnits = UpdateManager.getDefault().getUpdateUnits(UpdateManager.TYPE.KIT_MODULE);


        String[] excludePluginFilters = OperationUtils.parseExcludePluginFilters();
        String[] includePluginFilters = OperationUtils.parseIncludePluginFilters();

        boolean[] includePluginFiltersUsed = readLists(excludePluginFilters, includePluginFilters);

        suite.addTest(new InstallTest(TEST_NEW_PLUGINS_EMPTY, null, 0));

        if (includePluginFiltersUsed != null) {
            for (int i = 0; i < includePluginFiltersUsed.length; i++) {
                boolean b = includePluginFiltersUsed[i];
                if (b == false) {
                    suite.addTest(new InstallTest(OperationUtils.INVALID_FILTER_PREFIX + includePluginFilters[i], null, 0));
                }
            }
        }
        int testNumber = 0;
        OperationUtils.savePluginsList(filteredPlugins, OperationUtils.INSTALL_DATA_FILE_NAME);
        for (UpdateElement updateElement : filteredPlugins) {
            suite.addTest(new InstallTest("test" + OperationUtils.getModuleCanonicalName(updateElement, testNumber), updateElement, testNumber));
            testNumber++;
        }
        return suite;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void logCurrentValues(CountsStruct pluginCounts) {
        log("");
        log("-----------------------------------------------------------");
        log("|  PLUGINS COUNTS IN DETAIL :                             |");
        log("-----------------------------------------------------------");
        log("NEW ELEMENTS:" + pluginCounts.getNewCount());
        log("INSTALLED ELEMENTS:" + pluginCounts.getInstalledCount());
        log("UPDATE ELEMENTS:" + pluginCounts.getUpdatesCount());
        log("FILTERED ELEMENTS:" + pluginCounts.getFilteredCount());
        log("PENDING ELEMENTS:" + pluginCounts.getPendingCount());
        log("-----------------------------------------------------------");

        log("-----------------------------------------------------------");
        log("|  PENDING PLUGINS :                                      |");
        log("-----------------------------------------------------------");
        for (UpdateElement updateElement : currentlyPendingInstalls) {
            log("[" + updateElement.getDisplayName() + "] " + updateElement.getCodeName());
        }
        log("-----------------------------------------------------------");

    }
}
