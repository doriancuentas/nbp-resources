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

package org.netbeans.modules.project.ui.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.prefs.Preferences;
import javax.swing.AbstractAction;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.modules.project.ui.NewProjectWizard;
import org.netbeans.modules.project.ui.OpenProjectList;
import org.netbeans.modules.project.ui.OpenProjectListSettings;
import org.netbeans.modules.project.ui.ProjectTab;
import org.netbeans.modules.project.ui.ProjectUtilities;
import org.netbeans.modules.project.ui.ProjectsRootNode;
import static org.netbeans.modules.project.ui.actions.Bundle.*;
import org.netbeans.modules.project.ui.api.ProjectTemplates;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.ErrorManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;
import org.openide.util.RequestProcessor;

@ActionID(id = "org.netbeans.modules.project.ui.NewProject", category = "Project")
@ActionRegistration(displayName = "#LBL_NewProjectAction_Name", iconBase = "org/netbeans/modules/project/ui/resources/newProject.png")
@ActionReferences({
    @ActionReference(path = "Shortcuts", name = "DS-N"),
    @ActionReference(path = ProjectsRootNode.ACTIONS_FOLDER, position = 100),
    @ActionReference(path = "Menu/File", position = 100),
    @ActionReference(path = "Toolbars/File", position = 200)
})
@Messages("LBL_NewProjectAction_Name=Ne&w Project...")
public class NewProject extends AbstractAction {
        
    private RequestProcessor.Task bodyTask;

    @Messages("LBL_NewProjectAction_Tooltip=New Project...")
    public NewProject() {
        putValue(SHORT_DESCRIPTION, LBL_NewProjectAction_Tooltip()); // is this actually useful?
        bodyTask = new RequestProcessor( "NewProjectBody" ).create( new Runnable () { // NOI18N
            @Override
            public void run () {
                doPerform ();
            }
        });
    }

    @Override
    public void actionPerformed( ActionEvent evt ) {
        bodyTask.schedule( 0 );
        
        if ( "waitFinished".equals( evt.getActionCommand() ) ) {
            bodyTask.waitFinished();
        }
    }    
        
    /*T9Y*/ NewProjectWizard prepareWizardDescriptor(FileObject fo) {
        NewProjectWizard wizard = new NewProjectWizard(fo);
            
        wizard.putProperty(ProjectTemplates.PRESELECT_CATEGORY, getValue(ProjectTemplates.PRESELECT_CATEGORY));
        wizard.putProperty(ProjectTemplates.PRESELECT_TEMPLATE, getValue(ProjectTemplates.PRESELECT_TEMPLATE));

        FileObject folder = (FileObject) getValue(CommonProjectActions.EXISTING_SOURCES_FOLDER);
        if (folder != null) {
            wizard.putProperty(CommonProjectActions.EXISTING_SOURCES_FOLDER, folder);
        }
        File f = (File) getValue(CommonProjectActions.PROJECT_PARENT_FOLDER);
        if (f != null) {
            wizard.putProperty(CommonProjectActions.PROJECT_PARENT_FOLDER, f);
        }
        // carry over properties like e.g. groupId and version from maven when creating new submodule.
        // see aso issue #217087 and #250190
        String[] moreProps = (String[]) getValue(CommonProjectActions.INITIAL_VALUE_PROPERTIES);
        if (moreProps != null) {
            for (String key : moreProps) {
                Object obj = getValue(key);
                if (obj != null) {
                    wizard.putProperty(key, obj);
                }
            }
        }
        return wizard;
    }
    
    private void doPerform () {
        
        FileObject fo = FileUtil.getConfigFile( "Templates/Project" ); //NOI18N
        final NewProjectWizard wizard = prepareWizardDescriptor(fo);
        
        final Set newObjects;
        try {
            newObjects = wizard.instantiate();
        } catch (IOException e) {
            ErrorManager.getDefault().notify(ErrorManager.INFORMATIONAL, e);
            return;
        }
                    // #75960 - test if any folder was created during the wizard and if yes and it's empty delete it
                    Preferences prefs = NbPreferences.forModule(OpenProjectListSettings.class);
                    String nbPrjDirPath = prefs.get(OpenProjectListSettings.PROP_CREATED_PROJECTS_FOLDER, null);
                    prefs.remove(OpenProjectListSettings.PROP_CREATED_PROJECTS_FOLDER);
                    if (nbPrjDirPath != null) {
                        File prjDir = new File(nbPrjDirPath);
                        if (prjDir.exists() && prjDir.isDirectory() && prjDir.listFiles() != null && prjDir.listFiles().length == 0) {
                            prjDir.delete();
                        }
                    }

                    //#69618: the non-project cache may contain a project folder listed in newObjects:
                    ProjectManager.getDefault().clearNonProjectCache();
        
                    ProjectUtilities.WaitCursor.show();
                    
                    if ( newObjects != null && !newObjects.isEmpty() ) {
                        // First. Open all returned projects in the GUI.

                        final LinkedList<DataObject> filesToOpen = new LinkedList<DataObject>();
                        List<Project> projectsToOpen = new LinkedList<Project>();

                        for( Iterator it = newObjects.iterator(); it.hasNext(); ) {
                            Object obj = it.next();
                            FileObject newFo;
                            DataObject newDo;
                            if (obj instanceof DataObject) {
                                newDo = (DataObject) obj;
                                newFo = newDo.getPrimaryFile();
                            } else if (obj instanceof FileObject) {
                                newFo = (FileObject) obj;
                                try {
                                    newDo = DataObject.find(newFo);
                                } catch (DataObjectNotFoundException e) {
                                    ErrorManager.getDefault().notify(ErrorManager.INFORMATIONAL, e);
                                    continue;
                                }
                            } else {
                                ErrorManager.getDefault().log(ErrorManager.WARNING, "Found unrecognized object " + obj + " in result set from instantiate()");
                                continue;
                            }
                            // check if it's a project directory
                            if (newFo.isFolder()) {
                                try {
                                    Project p = ProjectManager.getDefault().findProject(newFo);
                                    if (p != null) {
                                        // It is a project, so schedule it to open:
                                        projectsToOpen.add(p);
                                    } else {
                                        // Just a folder to expand
                                        filesToOpen.add(newDo);
                                    }
                                } catch (IOException e) {
                                    ErrorManager.getDefault().notify(ErrorManager.INFORMATIONAL, e);
                                    continue;
                                }
                            } else {
                                filesToOpen.add(newDo);
                            }
                        }
                        
                        final Project lastProject = projectsToOpen.size() > 0 ? projectsToOpen.get(0) : null;
                        
                        Project mainProject = null;
                        if (Templates.getDefinesMainProject(wizard) && lastProject != null) {
                            mainProject = lastProject;
                        }
                        
                        OpenProjectList.getDefault().open(projectsToOpen.toArray(new Project[0]), false, true, mainProject);
                        
        EventQueue.invokeLater( new Runnable() {
            @Override public void run() {
                        // Show the project tab to show the user we did something
                        ProjectUtilities.makeProjectTabVisible();
            }
        });

                        ProjectTab.RP.post(new Runnable() {
                            public @Override void run() {
                                if (lastProject != null) {
                                    // Just select and expand the project node
                                    ProjectUtilities.selectAndExpandProject(lastProject);
                                }
                                // Second open the files
                                for (DataObject d : filesToOpen) { // Open the files
                                    ProjectUtilities.openAndSelectNewObject(d);
                                }
                            }
                        }, 500);
                        
                    }
                    ProjectUtilities.WaitCursor.hide();
    }
    
}
