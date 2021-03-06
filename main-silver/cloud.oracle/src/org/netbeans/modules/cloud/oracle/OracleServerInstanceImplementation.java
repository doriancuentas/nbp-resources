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
package org.netbeans.modules.cloud.oracle;

import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.cloud.oracle.ui.CustomizerCloudGeneral;
import org.netbeans.modules.cloud.oracle.ui.OracleInstanceNode;
import org.netbeans.modules.cloud.oracle.ui.OracleWizardComponent;
import org.netbeans.spi.server.ServerInstanceImplementation;
import org.openide.nodes.Node;

/**
 * Representation of single oracle cloud account under "Cloud" node.
 */
public class OracleServerInstanceImplementation implements ServerInstanceImplementation {

    private OracleInstance ai;

    public OracleServerInstanceImplementation(OracleInstance ai) {
        this.ai = ai;
    }
    
    @Override
    public String getDisplayName() {
        return ai.getName();
    }

    @Override
    public String getServerDisplayName() {
        return "Oracle Cloud";
    }

    @Override
    public Node getFullNode() {
        return getBasicNode();
    }

    @Override
    public Node getBasicNode() {
        return new OracleInstanceNode(ai);
    }

    @Override
    public JComponent getCustomizer() {
        return new CustomizerCloudGeneral(ai);
//        final OracleWizardComponent panel = new OracleWizardComponent(ai);
//        panel.attachSingleListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                if (!panel.getJavaServiceName().equals(ai.getJavaServiceName())) {
//                    // this field is part of URL (that is server unique key) of J2EE server
//                    // corresponding to this cloud and therefore value cannot be modified
//                }
//                if (!panel.getIdentityDomain().equals(ai.getIdentityDomain())) {
//                    // see previous comment
//                }
//                if (!panel.getPassword().equals(ai.getPassword())) {
//                    ai.setPassword(panel.getPassword());
//                }
//                if (!panel.getUserName().equals(ai.getUser())) {
//                    ai.setUser(panel.getUserName());
//                }
//                if (!panel.getAdminUrl().equals(ai.getAdminURL())) {
//                    ai.setAdminURL(panel.getAdminUrl());
//                }
//                if (!panel.getInstanceUrl().equals(ai.getInstanceURL())) {
//                    ai.setInstanceURL(panel.getInstanceUrl());
//                }
//                if (!panel.getCloudUrl().equals(ai.getCloudURL())) {
//                    ai.setCloudURL(panel.getCloudUrl());
//                }
//                OracleInstanceManager.getDefault().update(ai);
//            }
//        });
//        return panel;
    }

    @Override
    public void remove() {
        OracleInstanceManager.getDefault().remove(ai);
    }

    @Override
    public boolean isRemovable() {
        return true;
    }

}
