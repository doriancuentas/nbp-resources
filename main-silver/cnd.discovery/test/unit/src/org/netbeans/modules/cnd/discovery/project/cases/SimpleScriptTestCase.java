/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2011 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2011 Sun Microsystems, Inc.
 */

package org.netbeans.modules.cnd.discovery.project.cases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.netbeans.modules.cnd.api.remote.RemoteFileUtil;
import org.netbeans.modules.cnd.discovery.project.MakeProjectTestBase;
import org.netbeans.modules.cnd.makeproject.api.SourceFolderInfo;
import org.netbeans.modules.cnd.makeproject.api.configurations.MakeConfigurationDescriptor;
import org.netbeans.modules.cnd.makeproject.api.wizards.WizardConstants;
import org.netbeans.modules.cnd.utils.CndPathUtilities;
import org.netbeans.modules.cnd.utils.FSPath;
import org.netbeans.modules.nativeexecution.api.ExecutionEnvironment;
import org.netbeans.modules.remote.spi.FileSystemProvider;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;

/**
 *
 * @author as204739
 */
public class SimpleScriptTestCase extends MakeProjectTestBase {

    public SimpleScriptTestCase() {
        super("SimpleTestCase");
    }

    @Test
    public void testSimple() throws Exception {
        File dataDir = getDataDir();
        String zip = dataDir.getAbsolutePath()+"/org/netbeans/modules/cnd/discovery/project/DiscoveryTestApplication.tar.gz";
        assert new File(zip).exists() : "Not  found file "+zip;
        performTestProject(zip, null, false, "");
    }

    @Override
    protected void setupWizard(WizardDescriptor wizard) {
        final String path = WizardConstants.PROPERTY_NATIVE_PROJ_DIR.get(wizard);
        final ExecutionEnvironment fs = WizardConstants.PROPERTY_SOURCE_HOST_ENV.get(wizard);
        final FSPath fsPath = new FSPath(FileSystemProvider.getFileSystem(fs), RemoteFileUtil.normalizeAbsolutePath(path, fs));
        WizardConstants.PROPERTY_RUN_CONFIGURE.put(wizard, false);
        WizardConstants.PROPERTY_SIMPLE_MODE.put(wizard, Boolean.FALSE);
        WizardConstants.PROPERTY_WORKING_DIR.put(wizard, path);
        WizardConstants.PROPERTY_BUILD_COMMAND.put(wizard, "./build.bash");
        WizardConstants.PROPERTY_CLEAN_COMMAND.put(wizard, "./clean.bash");
        WizardConstants.PROPERTY_RUN_REBUILD.put(wizard, true);
        WizardConstants.PROPERTY_SOURCE_FOLDERS_FILTER.put(wizard, MakeConfigurationDescriptor.DEFAULT_IGNORE_FOLDERS_PATTERN_EXISTING_PROJECT);
        WizardConstants.PROPERTY_NAME.put(wizard, CndPathUtilities.getBaseName(path));

        final
        List<SourceFolderInfo> list = new ArrayList<>();
        list.add(new SourceFolderInfo() {

            @Override
            public FileObject getFileObject() {
                return fsPath.getFileObject();
            }

            @Override
            public String getFolderName() {
                return CndPathUtilities.getBaseName(path);
            }

            @Override
            public boolean isAddSubfoldersSelected() {
                return true;
            }
        });
        WizardConstants.PROPERTY_SOURCE_FOLDERS.put(wizard, list.iterator());
    }  
}
