/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.netbeans.modules.search.ui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import org.netbeans.modules.search.MatchingObject;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.ContextAwareAction;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.util.actions.ActionPresenterProvider;
import org.openide.util.actions.NodeAction;
import org.openide.util.actions.Presenter;

/**
 * Action for creating "Other" submenu in Actions pop-up menu.
 *
 * @author jhavlin
 */
public class MoreAction extends NodeAction implements Presenter.Popup {

    private static final KeyStroke DELETE_KS
            = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);

    @Override
    protected void performAction(Node[] activatedNodes) {
    }

    @Override
    protected boolean enable(Node[] activatedNodes) {
        return true;
    }

    @NbBundle.Messages("MoreAction.name=More")
    @Override
    public String getName() {
        return Bundle.MoreAction_name();
    }

    @Override
    public HelpCtx getHelpCtx() {
        return null;
    }

    @Override
    public JMenuItem getPopupPresenter() {
        Lookup l = Utilities.actionsGlobalContext();
        Collection<? extends MatchingObject> matchingObjects
                = l.lookupAll(MatchingObject.class);
        LinkedHashSet<Action> commonActions = new LinkedHashSet<Action>();
        boolean first = true;
        for (MatchingObject mo : matchingObjects) {
            DataObject dob = mo.getDataObject();
            if (dob != null) {
                Node nodeDelegate = dob.getNodeDelegate();
                Collection<Action> dobActions = Arrays.asList(
                        nodeDelegate.getActions(false));
                if (first) {
                    commonActions.addAll(dobActions);
                    first = false;
                } else {
                    commonActions.retainAll(dobActions);
                }
            }
        }
        return actionsToMenu(commonActions, l);
    }

    /**
     * Most of code copied from Utilities.actionsToPopup.
     */
    private JMenuItem actionsToMenu(Set<Action> actions, Lookup lookup) {
        // keeps actions for which was menu item created already (do not add them twice)
        Set<Action> counted = new HashSet<Action>();
        // components to be added (separators are null)
        List<Component> components = new ArrayList<Component>();

        for (Action action : actions) {
            if (action != null && counted.add(action)) {
                // switch to replacement action if there is some
                if (action instanceof ContextAwareAction) {
                    Action contextAwareAction = ((ContextAwareAction) action).createContextAwareInstance(
                            lookup);
                    if (contextAwareAction == null) {
                        Logger.getLogger(Utilities.class.getName()).log(
                                Level.WARNING,
                                "ContextAwareAction.createContextAwareInstance(lookup) returns null. That is illegal!" + " action={0}, lookup={1}",
                                new Object[]{action, lookup});
                    } else {
                        action = contextAwareAction;
                    }
                }

                JMenuItem item;
                if (action instanceof Presenter.Popup) {
                    item = ((Presenter.Popup) action).getPopupPresenter();
                    if (item == null) {
                        Logger.getLogger(Utilities.class.getName()).log(
                                Level.WARNING,
                                "findContextMenuImpl, getPopupPresenter returning null for {0}",
                                action);
                        continue;
                    }
                } else {
                    // We need to correctly handle mnemonics with '&' etc.
                    item = ActionPresenterProvider.getDefault().createPopupPresenter(
                            action);
                }
                if (!action.isEnabled()) {
                    continue;
                }
                for (Component c : ActionPresenterProvider.getDefault().convertComponents(
                        item)) {
                    if (!(c instanceof JSeparator)) {
                        components.add(c);
                    }
                }
            }
        }
        // Now create actual menu. Strip adjacent, leading, and trailing separators.
        JMenu menu = new JMenu(this);
        boolean nonempty = false; // has anything been added yet?
        boolean pendingSep = false; // should there be a separator before any following item?
        for (Component c : components) {
            try {
                if (c == null) {
                    pendingSep = nonempty;
                } else {
                    removeDeleteAccelerator(c);
                    nonempty = true;
                    if (pendingSep) {
                        pendingSep = false;
                        menu.addSeparator();
                    }
                    menu.add(c);
                }
            } catch (RuntimeException ex) {
                Exceptions.attachMessage(ex, "Current component: " + c); // NOI18N
                Exceptions.attachMessage(ex, "List of components: " + components); // NOI18N
                Exceptions.attachMessage(ex, "List of actions: " + actions); // NOI18N
                Exceptions.printStackTrace(ex);
            }
        }
        return menu;
    }

    /**
     * Remove DELETE accelerator from Delete action, because it is used by Hide
     * action in this context.
     */
    private void removeDeleteAccelerator(Component item) {
        if (item instanceof JMenuItem) {
            JMenuItem mItem = (JMenuItem) item;
            if (DELETE_KS.equals(mItem.getAccelerator())) {
                mItem.setAccelerator(null);
            }
        }
    }
}
