
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

package org.netbeans.modules.profiler.stp;

import org.netbeans.lib.profiler.common.AttachSettings;
import org.netbeans.modules.profiler.api.ProjectUtilities;
import org.netbeans.modules.profiler.attach.AttachWizard;
import org.openide.util.Lookup;


/**
 *
 * @author Jiri Sedlacek
 */
public class Utils {
    //~ Static fields/initializers -----------------------------------------------------------------------------------------------

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    public static AttachSettings getAttachSettings(Lookup.Provider project) {
        AttachSettings attachSettings = null;
    
//        try {
//            attachSettings = ProjectStorage.loadAttachSettings(project);
//        } catch (IOException ex) {
//        }

        return attachSettings;
    }

    //  public static boolean iAnalyzerSettings(ProfilingSettings settings) {
    //    if (settings == null) return false;
    //    return iAnalyzerSettings(settings.getProfilingType());
    //  }
    //  
    //  public static boolean iAnalyzerSettings(int type) {
    //    return type == ProfilingSettings.PROFILE_ANALYZE;
    //  }
    
    public static String getProjectName(Lookup.Provider project) {
        if (project == null) {
            return Bundle.SelectProfilingTask_ExternalApplicationString();
        }

        return ProjectUtilities.getDisplayName(project);
    }

    static SelectProfilingTask.SettingsConfigurator getSettingsConfigurator(Lookup.Provider project) {
//        SelectProfilingTask.SettingsConfigurator configurator = ptp.getSettingsConfigurator();
//        if (configurator == null) return DefaultSettingsConfigurator.SHARED_INSTANCE;
//
//        return configurator;
        return DefaultSettingsConfigurator.SHARED_INSTANCE;
    }

    public static AttachSettings selectAttachSettings(Lookup.Provider project) {
        AttachSettings attachSettings = getAttachSettings(project);

        if (attachSettings == null) {
            attachSettings = new AttachSettings();
        }

        return AttachWizard.getDefault().configure(attachSettings, false);
//        AttachWizard attachWizard = new AttachWizard();
//        attachWizard.init(attachSettings);
//
//        final WizardDescriptor wd = attachWizard.getWizardDescriptor();
//        final Dialog d = ProfilerDialogs.createDialog(wd);
//        d.pack();
//        d.setVisible(true);
//
//        if (wd.getValue() != WizardDescriptor.FINISH_OPTION) {
//            return null; // cancelled by the user
//        }
//
//        attachWizard.finish(); // wizard correctly finished
//
//        return attachWizard.getAttachSettings();
    }
}
