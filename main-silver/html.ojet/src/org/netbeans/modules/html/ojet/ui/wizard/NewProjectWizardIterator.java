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
package org.netbeans.modules.html.ojet.ui.wizard;

import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.modules.html.ojet.OJETUtils;
import org.netbeans.modules.web.clientproject.api.network.NetworkException;
import org.netbeans.modules.web.clientproject.api.network.NetworkSupport;
import org.netbeans.modules.web.clientproject.createprojectapi.ClientSideProjectGenerator;
import org.netbeans.modules.web.clientproject.createprojectapi.CreateProjectProperties;
import org.netbeans.modules.web.clientproject.createprojectapi.CreateProjectUtils;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Mutex;
import org.openide.util.NbBundle;
import org.openide.util.Pair;

public final class NewProjectWizardIterator implements WizardDescriptor.ProgressInstantiatingIterator<WizardDescriptor> {

    private static final Logger LOGGER = Logger.getLogger(NewProjectWizardIterator.class.getName());

    private static final String HTML_MIME_TYPE = "text/html"; // NOI18N
    private static final String XHTML_MIME_TYPE = "text/xhtml"; // NOI18N

    private final String displayName;
    private final String zipUrl;
    private final File tmpFile;
    private final Pair<WizardDescriptor.FinishablePanel<WizardDescriptor>, String> baseWizard;

    private int index;
    private WizardDescriptor.Panel<WizardDescriptor>[] panels;
    private WizardDescriptor wizardDescriptor;


    private NewProjectWizardIterator(String displayName, String projectDirName, String zipUrl, File tmpFile) {
        assert displayName != null;
        assert projectDirName != null;
        assert zipUrl != null;
        assert tmpFile != null;
        this.displayName = displayName;
        this.zipUrl = zipUrl;
        this.tmpFile = tmpFile;
        baseWizard = CreateProjectUtils.createBaseWizardPanel(projectDirName);
    }

    @TemplateRegistration(
            folder = "Project/ClientSide",
            displayName = "#NewProjectWizardIterator.newProject.displayName",
            description = "../resources/NewOracleJETProjectDescription.html",
            iconBase = OJETUtils.OJET_ICON_PATH,
            position = 250)
    @NbBundle.Messages("NewProjectWizardIterator.newProject.displayName=Oracle JET QuickStart Basic")
    public static NewProjectWizardIterator newOracleJETProject() {
        return new NewProjectWizardIterator(
                Bundle.NewProjectWizardIterator_newProject_displayName(),
                "OracleJETApplication", // NOI18N
                "http://slc01hih.us.oracle.com:8080/hudson/job/OJET_Build/lastSuccessfulBuild/artifact/apps/components/public_html/public_samples/OracleJET_QuickStartBasic.zip", // NOI18N
                new File(System.getProperty("java.io.tmpdir"), "OracleJET_QuickStartBasic.zip") // NOI18N
        );
    }

    @TemplateRegistration(
            folder = "Project/Samples/HTML5",
            displayName = "#NewProjectWizardIterator.newComponentInteractionSample.displayName",
            description = "../resources/NewComponentInteractionSampleDescription.html",
            iconBase = OJETUtils.OJET_ICON_PATH,
            position = 3000)
    @NbBundle.Messages("NewProjectWizardIterator.newComponentInteractionSample.displayName=Oracle JET Component Interaction Sample")
    public static NewProjectWizardIterator newComponentInteractionSample() {
        return new NewProjectWizardIterator(
                Bundle.NewProjectWizardIterator_newComponentInteractionSample_displayName(),
                "OracleJETComponentInteraction", // NOI18N
                "http://slc01hih.us.oracle.com:8080/hudson/job/OJET_Build/lastSuccessfulBuild/artifact/apps/components/public_html/public_samples/JET-ComponentInteraction.zip", // NOI18N
                new File(System.getProperty("java.io.tmpdir"), "JET-ComponentInteraction.zip") // NOI18N
        );
    }

    @NbBundle.Messages("NewProjectWizardIterator.progress.creating=Creating project...")
    @Override
    public Set<FileObject> instantiate(ProgressHandle handle) throws IOException {
        handle.start();
        handle.progress(Bundle.NewProjectWizardIterator_progress_creating());

        Set<FileObject> files = new HashSet<>();

        File projectDir = FileUtil.normalizeFile((File) wizardDescriptor.getProperty(CreateProjectUtils.PROJECT_DIRECTORY));
        if (!projectDir.isDirectory()
                && !projectDir.mkdirs()) {
            throw new IOException("Cannot create project directory: " + projectDir);
        }
        FileObject projectDirectory = FileUtil.toFileObject(projectDir);
        assert projectDirectory != null : "FileObject must be found for " + projectDir;
        files.add(projectDirectory);

        CreateProjectProperties createProperties = new CreateProjectProperties(projectDirectory, (String) wizardDescriptor.getProperty(CreateProjectUtils.PROJECT_NAME))
                .setSiteRootFolder(""); // NOI18N
        ClientSideProjectGenerator.createProject(createProperties);

        setupProject(handle, files, projectDirectory);

        handle.finish();
        return files;
    }

    @Override
    public Set instantiate() throws IOException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void initialize(WizardDescriptor wizard) {
        wizardDescriptor = wizard;
        // #245975
        Mutex.EVENT.readAccess(new Runnable() {
            @Override
            public void run() {
                initializeInternal();
            }
        });
    }

    void initializeInternal() {
        assert EventQueue.isDispatchThread();
        index = 0;
        panels = new WizardDescriptor.Panel[] {
            baseWizard.first(),
        };
        // Make sure list of steps is accurate.
        List<String> steps = Arrays.asList(
            baseWizard.second()
        );

        // XXX should be lazy
        for (int i = 0; i < panels.length; i++) {
            Component c = panels[i].getComponent();
            assert steps.get(i) != null : "Missing name for step: " + i;
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                // Step #.
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                // Step name (actually the whole list for reference).
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps.toArray(new String[0]));
                // name
                jc.setName(steps.get(i));
            }
        }
    }

    @Override
    public void uninitialize(WizardDescriptor wizard) {
        wizardDescriptor.putProperty(CreateProjectUtils.PROJECT_DIRECTORY, null);
        wizardDescriptor.putProperty(CreateProjectUtils.PROJECT_NAME, null);
        panels = null;
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        wizardDescriptor.putProperty("NewProjectWizard_Title", displayName); // NOI18N
        return panels[index];
    }

    @NbBundle.Messages({
        "# {0} - current step index",
        "# {1} - number of steps",
        "NewProjectWizardIterator.name={0} of {1}"
    })
    @Override
    public String name() {
        return Bundle.NewProjectWizardIterator_name(index + 1, panels.length);
    }

    @Override
    public boolean hasNext() {
        return index < panels.length - 1;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    @Override
    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    @Override
    public void addChangeListener(ChangeListener l) {
        // noop
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        // noop
    }

    @NbBundle.Messages({
        "NewProjectWizardIterator.progress.downloading=Downloading archive...",
        "NewProjectWizardIterator.progress.unpacking=Unpacking archive...",
    })
    private void setupProject(ProgressHandle handle, Set<FileObject> files, FileObject projectDirectory) throws IOException {
        try {
            // download
            handle.progress(Bundle.NewProjectWizardIterator_progress_downloading());
            NetworkSupport.download(zipUrl, tmpFile);

            // check
            if (isHtmlFile(tmpFile)) {
                // likely not in oracle network
                if (NetworkSupport.showNetworkErrorDialog(displayName)) {
                    setupProject(handle, files, projectDirectory);
                }
            } else {
                // unzip
                handle.progress(Bundle.NewProjectWizardIterator_progress_unpacking());
                unzip(tmpFile.getAbsolutePath(), FileUtil.toFile(projectDirectory));

                // index file
                files.add(projectDirectory.getFileObject("index.html")); // NOI18N
            }
        } catch (NetworkException ex) {
            LOGGER.log(Level.INFO, "Failed to download OJET archive", ex);
            if (NetworkSupport.showNetworkErrorDialog(displayName)) {
                setupProject(handle, files, projectDirectory);
            }
        } catch (InterruptedException ex) {
            // cancelled, should not happen
            assert false;
        }
    }

    private static boolean isHtmlFile(File file) {
        assert file != null;
        if (!file.exists()) {
            return false;
        }
        String mimeType = FileUtil.getMIMEType(FileUtil.toFileObject(file), HTML_MIME_TYPE, XHTML_MIME_TYPE);
        return HTML_MIME_TYPE.equals(mimeType)
                || XHTML_MIME_TYPE.equals(mimeType);
    }

    private static void unzip(String zipPath, File targetDirectory) throws IOException {
        assert zipPath != null;
        assert targetDirectory != null;

        try (ZipFile zipFile = new ZipFile(zipPath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();
                File destinationFile = new File(targetDirectory, zipEntry.getName());
                ensureParentExists(destinationFile);
                copyZipEntry(zipFile, zipEntry, destinationFile);
            }
        }
    }

    private static void ensureParentExists(File file) throws IOException {
        File parent = file.getParentFile();
        if (!parent.isDirectory()) {
            if (!parent.mkdirs()) {
                throw new IOException("Cannot create parent directories for " + file.getAbsolutePath());
            }
        }
    }

    private static void copyZipEntry(ZipFile zipFile, ZipEntry zipEntry, File destinationFile) throws IOException {
        if (zipEntry.isDirectory()) {
            return;
        }
        try (InputStream inputStream = zipFile.getInputStream(zipEntry); FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            FileUtil.copy(inputStream, outputStream);
        }
    }

}
