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
package org.netbeans.modules.mercurial.remote.ui.clone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.modules.mercurial.remote.ui.wizards.CloneWizardAction;
import org.netbeans.modules.mercurial.remote.util.HgUtils;
import org.netbeans.modules.remotefs.versioning.api.VCSFileProxySupport;
import org.netbeans.modules.versioning.core.api.VCSFileProxy;
import org.netbeans.modules.versioning.util.Utils;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileSystem;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle.Messages;

/**
 * Clone action for mercurial: 
 * Clone an external repository. This invokes a wizard to determine the
 * location of the repository and the target location of the repository.
 * 
 * @author Padraig O'Briain
 */
@ActionID(id = "org.netbeans.modules.mercurial.remote.ui.clone.CloneExternalAction", category = "MercurialRemote")
@ActionRegistration(displayName = "#CTL_MenuItem_CloneExternal")
@ActionReferences({
   @ActionReference(path="Versioning/MercurialRemote/Actions/Global", position=301)
})
@Messages({
    "CTL_MenuItem_CloneExternal=Clone Othe&r..."
})
public class CloneExternalAction implements ActionListener, HelpCtx.Provider {
    @Override
    public void actionPerformed(ActionEvent e) {
        FileSystem[] fileSystems = VCSFileProxySupport.getConnectedFileSystems();
        if (fileSystems.length == 0) {
            return;
        }
        //TODO: provide way to select FS
        VCSFileProxy root = VCSFileProxy.createFileProxy(fileSystems[0].getRoot());
        HgUtils.runIfHgAvailable(root, new Runnable() {
            @Override
            public void run () {
                Utils.logVCSActionEvent("HG"); //NOI18N
                CloneWizardAction wiz = CloneWizardAction.getInstance();
                wiz.performAction();
            }
        });
    }

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("org.netbeans.modules.mercurial.remote.ui.clone.CloneExternalAction");
    }
}
