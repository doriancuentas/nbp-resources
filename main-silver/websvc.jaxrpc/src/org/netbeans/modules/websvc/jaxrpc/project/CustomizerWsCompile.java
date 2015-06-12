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

package org.netbeans.modules.websvc.jaxrpc.project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.websvc.api.webservices.WsCompileEditorSupport;
import org.openide.ErrorManager;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 *
 * @author Peter Williams
 */
public class CustomizerWsCompile extends javax.swing.JPanel implements WsCompileEditorSupport.Panel, HelpCtx.Provider {
    
    public static final Color ErrorTextForegroundColor = new Color(89, 79, 191);
    
    private static final int MAX_IMPORTANT_FEATURES = 12;
    
    private DefaultListModel servicesModel;
    private JCheckBox [] featureCheckboxes;
    
    private int serviceType;
    private String features;
    private boolean updatingDisplay;
    private boolean processingCheckBox;
    private boolean processingFeatureString;
    
    public CustomizerWsCompile() {
        initComponents();
        initUserComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPnlServices = new javax.swing.JPanel();
        jLblServices = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstServices = new javax.swing.JList();
        jPnlFeatures = new javax.swing.JPanel();
        jLblPanelDescription = new javax.swing.JLabel();
        jPnlOptions = new javax.swing.JPanel();
        jChkFeatureA = new javax.swing.JCheckBox();
        jChkFeatureB = new javax.swing.JCheckBox();
        jChkFeatureC = new javax.swing.JCheckBox();
        jChkFeatureD = new javax.swing.JCheckBox();
        jChkFeatureE = new javax.swing.JCheckBox();
        jChkFeatureF = new javax.swing.JCheckBox();
        jChkFeatureG = new javax.swing.JCheckBox();
        jChkFeatureH = new javax.swing.JCheckBox();
        jChkFeatureI = new javax.swing.JCheckBox();
        jChkFeatureJ = new javax.swing.JCheckBox();
        jChkFeatureK = new javax.swing.JCheckBox();
        jChkFeatureL = new javax.swing.JCheckBox();
        jLblEnabledFeatures = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtEnabledFeatures = new javax.swing.JTextArea();
        jLblError = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jPnlServices.setLayout(new java.awt.GridBagLayout());

        jLblServices.setLabelFor(jLstServices);
        jLblServices.setText(org.openide.util.NbBundle.getMessage(CustomizerWsCompile.class, "LBL_WebServices")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        jPnlServices.add(jLblServices, gridBagConstraints);

        jLstServices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLstServices.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jLstServicesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jLstServices);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        jPnlServices.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        add(jPnlServices, gridBagConstraints);

        jPnlFeatures.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLblPanelDescription, NbBundle.getMessage(CustomizerWsCompile.class, "LBL_PanelDescriptionService")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlFeatures.add(jLblPanelDescription, gridBagConstraints);

        jPnlOptions.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureA, "Feature A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureA, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureB, "Feature B");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureB, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureC, "Feature C");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureC, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureD, "Feature D");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureD, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureE, "Feature E");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureE, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureF, "Feature F");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureF, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureG, "Feature G");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureG, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureH, "Feature H");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureH, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureI, "Feature I");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureI, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureJ, "Feature J");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureJ, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureK, "Feature K");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureK, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jChkFeatureL, "Feature L");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 11);
        jPnlOptions.add(jChkFeatureL, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPnlFeatures.add(jPnlOptions, gridBagConstraints);

        jLblEnabledFeatures.setLabelFor(jTxtEnabledFeatures);
        org.openide.awt.Mnemonics.setLocalizedText(jLblEnabledFeatures, org.openide.util.NbBundle.getMessage(CustomizerWsCompile.class, "LBL_EnabledFeatures")); // NOI18N
        jLblEnabledFeatures.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 11);
        jPnlFeatures.add(jLblEnabledFeatures, gridBagConstraints);

        jTxtEnabledFeatures.setLineWrap(true);
        jTxtEnabledFeatures.setRows(3);
        jTxtEnabledFeatures.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTxtEnabledFeatures);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        jPnlFeatures.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(jPnlFeatures, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLblError, " ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        add(jLblError, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLstServicesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jLstServicesValueChanged
        if(!evt.getValueIsAdjusting()) {
            WsCompileEditorSupport.ServiceSettings entry = (WsCompileEditorSupport.ServiceSettings) jLstServices.getSelectedValue();
            if(entry != null) {
                updateServiceFeatures(entry);
            } else {
                disableServiceFeatures();
            }
        }
    }//GEN-LAST:event_jLstServicesValueChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jChkFeatureA;
    private javax.swing.JCheckBox jChkFeatureB;
    private javax.swing.JCheckBox jChkFeatureC;
    private javax.swing.JCheckBox jChkFeatureD;
    private javax.swing.JCheckBox jChkFeatureE;
    private javax.swing.JCheckBox jChkFeatureF;
    private javax.swing.JCheckBox jChkFeatureG;
    private javax.swing.JCheckBox jChkFeatureH;
    private javax.swing.JCheckBox jChkFeatureI;
    private javax.swing.JCheckBox jChkFeatureJ;
    private javax.swing.JCheckBox jChkFeatureK;
    private javax.swing.JCheckBox jChkFeatureL;
    private javax.swing.JLabel jLblEnabledFeatures;
    private javax.swing.JLabel jLblError;
    private javax.swing.JLabel jLblPanelDescription;
    private javax.swing.JLabel jLblServices;
    private javax.swing.JList jLstServices;
    private javax.swing.JPanel jPnlFeatures;
    private javax.swing.JPanel jPnlOptions;
    private javax.swing.JPanel jPnlServices;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtEnabledFeatures;
    // End of variables declaration//GEN-END:variables
    
    private void initUserComponents() {
        updatingDisplay = false;
        processingCheckBox = false;
        processingFeatureString = false;
        
        jLblError.setForeground(ErrorTextForegroundColor);
        servicesModel = new DefaultListModel();
        
        // !PW Rework this entire pattern for 5.0, including better API for specifying
        // radio buttons vs. checkboxes for competing options (e.g. rpcliteral
        // vs. documentliteral, unwrap vs. donotunwrap, etc.
        //
        // Could provide nested panel for each supported "service/client" type,
        // e.g. service from SEI, service from WSDL, and web service client.
        // J2ME might also have preferences here.
        //
        featureCheckboxes = new JCheckBox [MAX_IMPORTANT_FEATURES];
        featureCheckboxes[0] = jChkFeatureA;
        featureCheckboxes[1] = jChkFeatureB;
        featureCheckboxes[2] = jChkFeatureC;
        featureCheckboxes[3] = jChkFeatureD;
        featureCheckboxes[4] = jChkFeatureE;
        featureCheckboxes[5] = jChkFeatureF;
        featureCheckboxes[6] = jChkFeatureG;
        featureCheckboxes[7] = jChkFeatureH;
        featureCheckboxes[8] = jChkFeatureI;
        featureCheckboxes[9] = jChkFeatureJ;
        featureCheckboxes[10] = jChkFeatureK;
        featureCheckboxes[11] = jChkFeatureL;
        
        ItemListener checkBoxListener = new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if(!processingFeatureString) {
                    JCheckBox source = (JCheckBox) evt.getSource();
                    String feature = source.getText();
                    enableFeature(feature, evt.getStateChange() == ItemEvent.SELECTED);
                }
            }
        };
        
        for(int i = 0; i < MAX_IMPORTANT_FEATURES; i++) {
            featureCheckboxes[i].addItemListener(checkBoxListener);
        }
        
        jTxtEnabledFeatures.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if(!updatingDisplay) {
                    updateFeatureList(e);
                }
            }
            public void insertUpdate(DocumentEvent e) {
                if(!updatingDisplay) {
                    updateFeatureList(e);
                }
            }
            public void removeUpdate(DocumentEvent e) {
                if(!updatingDisplay) {
                    updateFeatureList(e);
                }
            }
        });
    }
    
    private void enableFeature(String feature, boolean enable) {
        boolean modified = false;
        Set featureSet = featuresAsSet(features);
        if(enable && !featureSet.contains(feature)) {
//            System.out.println("adding feature '" + feature + "'");
            featureSet.add(feature);
            modified = true;
        } else if(!enable && featureSet.contains(feature)) {
//            System.out.println("removing feature '" + feature + "'");
            featureSet.remove(feature);
            modified = true;
        }
        
        if(modified) {
            try {
                processingCheckBox = true;
                String newFeatures = featuresAsString(featureSet);
                jTxtEnabledFeatures.setText(newFeatures);
            } finally {
                processingCheckBox = false;
            }
        }
    }
    
    private Set featuresAsSet(String featureString) {
        HashSet set = new HashSet(10);
        String [] featureList = featureString.split(",");
        for(int i = 0; i < featureList.length; i++) {
            String feature = featureList[i].trim();
            if(feature != null && feature.length() > 0) {
                set.add(feature);
            }
        }
        return set;
    }
    
    private String featuresAsString(Set featureSet) {
        StringBuffer featureString = new StringBuffer(featureSet.size()*16);
        for(Iterator iter = featureSet.iterator(); iter.hasNext(); ) {
            String feature = (String) iter.next();
            featureString.append(feature);
            if(iter.hasNext()) {
                featureString.append(", ");
            }
        }
        return featureString.toString();
    }
    
    private void updateFeatureList(DocumentEvent e) {
        Document doc = e.getDocument();
        String oldFeatures = features;
        
        try {
            features = doc.getText(0, doc.getLength());
        } catch(BadLocationException ex) {
            ErrorManager.getDefault().notify(ErrorManager.EXCEPTION, ex);
        }
        
        if(!features.equals(oldFeatures)) {
            WsCompileEditorSupport.ServiceSettings entry = (WsCompileEditorSupport.ServiceSettings) jLstServices.getSelectedValue();
            entry.setNewFeatures(features);
            checkSettings(entry);
            
            if(!processingCheckBox) {
                updateCheckBoxes(features);
            }
            
            WsCompileEditorSupport.FeatureDescriptor oldF = new WsCompileEditorSupport.FeatureDescriptor(entry.getServiceName(), oldFeatures);
            WsCompileEditorSupport.FeatureDescriptor newF = new WsCompileEditorSupport.FeatureDescriptor(entry.getServiceName(), features);
//            System.out.println("feature list changed (" + newF.getServiceName() + ", [" + newF.getFeatures() + "])");
            firePropertyChange(WsCompileEditorSupport.PROP_FEATURES_CHANGED, oldF, newF);
        }
    }
    
    private void updateCheckBoxes(String features) {
        try {
            processingFeatureString = true;
            Set featureSet = featuresAsSet(features);
            for(int i = 0; i < MAX_IMPORTANT_FEATURES; i++) {
                String feature = featureCheckboxes[i].getText();
                featureCheckboxes[i].setSelected(featureSet.contains(feature));
            }
        } finally {
            processingFeatureString = false;
        }
    }
    
    private boolean checkSettings(WsCompileEditorSupport.ServiceSettings settings) {
        String message = validateSettings(settings);
        if(message != null) {
            jLblError.setText(message);
        } else {
            jLblError.setText(" ");
        }
        return message != null;
    }
    
    private String validateSettings(WsCompileEditorSupport.ServiceSettings settings) {
        // really just validate the feature string
        String message = null;
        List availableFeatures = settings.getAvailableFeatures();
        String [] featuresList = settings.getNewFeatures().split(",");
        for(int i = 0; i < featuresList.length; i++) {
            featuresList[i] = featuresList[i].trim();
            if(featuresList[i] != null && featuresList[i].length() > 0 && !availableFeatures.contains(featuresList[i])) {
                // Feature not in available list - either invalid, or out of context, determine which:
                if(masterWsCompileFeatures.contains(featuresList[i])) {
                    message = NbBundle.getMessage(CustomizerWsCompile.class, "ERR_FeatureNotSupported", featuresList[i]);
                } else {
                    message = NbBundle.getMessage(CustomizerWsCompile.class, "ERR_InvalidFeature", featuresList[i]);
                }
                break;
            }
        }
        
        // Special case to force error if rpcliteral and document literal are both checked
        // -- at least until we can fix the UI to not allow this.
        boolean usesRpcLiteral = false;
        boolean usesDocumentLiteral = false;
        
        for(int i = 0; i < featuresList.length; i++) {
            if("rpcliteral".equals(featuresList[i])) {
                usesRpcLiteral = true;
            } else if("documentliteral".equals(featuresList[i])) {
                usesDocumentLiteral = true;
            }
        }
        
        if(usesRpcLiteral && usesDocumentLiteral) {
            message = NbBundle.getMessage(CustomizerWsCompile.class, "ERR_InvalidBinding");
        }
        
        return message;
    }
    
    private void updateServiceFeatures(WsCompileEditorSupport.ServiceSettings entry) {
        try {
            updatingDisplay = true;
            enableServiceFeatures();
            
            int index = 0;
            for(Iterator iter = entry.getImportantFeatures().iterator(); iter.hasNext() && index < MAX_IMPORTANT_FEATURES; index++) {
                String feature = (String) iter.next();
                featureCheckboxes[index].setVisible(true);
                featureCheckboxes[index].setText(feature);
                featureCheckboxes[index].setToolTipText(WsCompileFeatures.getFeaturesMap().get(feature));
            }
            
            while(index < MAX_IMPORTANT_FEATURES) {
                featureCheckboxes[index++].setVisible(false);
            }
            
            features = entry.getNewFeatures();
            updateCheckBoxes(features);
            jTxtEnabledFeatures.setText(features);
            
            // If there is an existing error, proactively display it.
            checkSettings(entry);
        } finally {
            updatingDisplay = false;
        }
    }
    
    private void enableServiceFeatures() {
        
    }
    
    private void disableServiceFeatures() {
        
    }
    
    public void addNotify() {
        super.addNotify();
        
        jLstServices.setModel(servicesModel);
        jLstServices.setSelectedIndex(0);
    }
    
    public void removeNotify() {
        super.removeNotify();
    }
    
    //
    // WsCompileEditorSupport.Panel implementation
    //
    
    public void initValues(List/*ServiceSettings*/ settings) {
        assert settings.size() > 0;
        
        jLblServices.setText(NbBundle.getMessage(CustomizerWsCompile.class, "LBL_WebServices"));
        jLblPanelDescription.setText(NbBundle.getMessage(CustomizerWsCompile.class, "LBL_PanelDescriptionService"));
        
        // Load list of services (or clients) that are being configured.
        servicesModel.clear();
        for(Iterator iter = settings.iterator(); iter.hasNext(); ) {
            WsCompileEditorSupport.ServiceSettings entry = (WsCompileEditorSupport.ServiceSettings) iter.next();
            servicesModel.addElement(entry);
        }
    }
    
    public JPanel getComponent() {
        return this;
    }
    
    public void validatePanel() throws org.openide.WizardValidationException {
        // !PW FIXME do we want to iterate all services and validate all of them here?
        WsCompileEditorSupport.ServiceSettings entry = (WsCompileEditorSupport.ServiceSettings) jLstServices.getSelectedValue();
        if(entry != null) {
            final String message = validateSettings(entry);
            if(message != null) {
                throw new WizardValidationException(jTxtEnabledFeatures, message, message);
            }
        }
    }
    
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    
    private static final HashSet masterWsCompileFeatures = new HashSet(WsCompileFeatures.getFeaturesMap().keySet());
}