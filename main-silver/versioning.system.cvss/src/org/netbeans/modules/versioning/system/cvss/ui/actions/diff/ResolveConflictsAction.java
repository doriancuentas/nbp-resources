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

package org.netbeans.modules.versioning.system.cvss.ui.actions.diff;

import org.netbeans.modules.versioning.system.cvss.FileInformation;
import org.netbeans.modules.versioning.system.cvss.CvsVersioningSystem;
import org.netbeans.modules.versioning.system.cvss.CvsFileNode;
import org.netbeans.modules.versioning.system.cvss.FileStatusCache;
import org.netbeans.modules.versioning.system.cvss.util.Utils;
import org.netbeans.modules.versioning.system.cvss.ui.actions.AbstractSystemAction;
import org.netbeans.lib.cvsclient.admin.Entry;
import org.openide.NotifyDescriptor;
import org.openide.DialogDisplayer;
import org.openide.nodes.Node;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;

import java.io.File;

/**
 * Opens the Visual Merge component. 
 *  
 * @author Maros Sandor
 */
public class ResolveConflictsAction extends AbstractSystemAction {
    
    public ResolveConflictsAction() {
        setIcon(null);
        putValue("noIconInMenu", Boolean.TRUE); // NOI18N
    }

    protected String getBaseName(Node [] activatedNodes) {
        return "CTL_MenuItem_ResolveConflicts"; // NOI18N
    }

    @Override
    protected boolean enable(Node[] nodes) {
        return CvsVersioningSystem.getInstance().getStatusCache().listFiles(getCachedContext(nodes), FileInformation.STATUS_VERSIONED_CONFLICT).length > 0;
    }

    public void performCvsAction(Node[] nodes) {
        CvsFileNode [] fileNodes = CvsVersioningSystem.getInstance().getFileTableModel(getContext(nodes), FileInformation.STATUS_VERSIONED_CONFLICT).getNodes();
        if (fileNodes.length == 0) {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                NbBundle.getMessage(ResolveConflictsAction.class, "MSG_NoConflicts")));
            return;
        }
        FileStatusCache cache = CvsVersioningSystem.getInstance().getStatusCache();
        for (int i = 0; i < fileNodes.length; i++) {
            final File file = fileNodes[i].getFile();
            FileInformation info = cache.getStatus(file);
            Entry entry = info.getEntry(file);
            if (entry == null) {
                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                    NbBundle.getMessage(ResolveConflictsAction.class, "MSG_MoveAwayLocalFileConflict", file.getName())));
            } else {
                CvsVersioningSystem.getInstance().getParallelRequestProcessor().post(new Runnable() {
                    public void run() {
                        ResolveConflictsExecutor rce = new ResolveConflictsExecutor();
                        rce.exec(file);
                    }
                });
            }
        }
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
    
}