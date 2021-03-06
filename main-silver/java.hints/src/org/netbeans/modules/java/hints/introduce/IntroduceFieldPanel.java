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
 * Portions Copyrighted 2007 Sun Microsystems, Inc.
 */
package org.netbeans.modules.java.hints.introduce;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.prefs.Preferences;
import javax.lang.model.element.Modifier;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.openide.util.NbPreferences;
import org.openide.util.Utilities;

/**
 * Panel that contains options for creating a field or a local variable.
 * 
 * The class was refactored to handle both variables and fields. For variables, the access modifiers and initialize parts
 * are hidden. If more options for variables are desired, a subpanel should be probably created and inserted here.
 * 
 * Supports a special mode for constants, which are always static final and initialized by an constant initializer (now).
 *
 * @author Jan Lahoda
 */
public class IntroduceFieldPanel extends javax.swing.JPanel {
    public static final int FIELD = 0;
    public static final int CONSTANT = 1;
    public static final int VARIABLE = 2;
    
    public static final int INIT_METHOD = 1;
    public static final int INIT_FIELD = 2;
    public static final int INIT_CONSTRUCTORS = 4;
    
    private static final int ACCESS_PUBLIC = 1;
    private static final int ACCESS_PROTECTED = 2;
    private static final int ACCESS_DEFAULT = 3;
    private static final int ACCESS_PRIVATE = 4;
    
    private int[] allowInitMethods;
    private boolean allowFinalInCurrentMethod;
    
    private JButton btnOk;
    private int elementType;
    private Preferences preferences;
    /**
     * Enables access mods, defaults to true. False now indicates insertion into an interface
     * and also causes not to show initialize in part.
     */
    private boolean allowAccess = true;
    
    /**
     * Constructs the dialog.
     * 
     * The `allowInitMethods' array contains two indexes. Possible init methods for the current occurrence only is at index 0,
     * possible init methods for all occurrences are at index 1.
     * @param name proposed field name
     * @param allowInitMethods contains INIT_bitfield for possible initialization methods. Null can be passed, meaning initialization from field.
     * @param numOccurrences number of other expression occurrences
     * @param allowFinalInCurrentMethod
     * @param variableRewrite allow to rename variable
     * @param type field/constant/variable
     * @param btnOk confirm button, to hook callbacks
     */
    public IntroduceFieldPanel(String name, int[] allowInitMethods, int numOccurrences, boolean allowFinalInCurrentMethod, boolean variableRewrite, int type, String prefNode, JButton btnOk) {
        this.elementType = type;
        this.btnOk = btnOk;
        
        initComponents();
        
        this.name.setText(name);
        if ( name != null && name.trim().length() > 0 && !variableRewrite) {
            this.name.setCaretPosition(name.length());
            this.name.setSelectionStart(0);
            this.name.setSelectionEnd(name.length());
        }

        if (variableRewrite) {
            this.name.setEditable(false);
        }
        
        this.allowInitMethods = allowInitMethods;
        this.replaceAll.setEnabled(numOccurrences > 1);
        this.allowFinalInCurrentMethod = allowFinalInCurrentMethod;
        this.preferences = NbPreferences.forModule( IntroduceFieldPanel.class ).node( prefNode ); //NOI18N
        Preferences pref = preferences;
        if( numOccurrences == 1 ) {
            replaceAll.setEnabled( false );
            replaceAll.setSelected( false );
        } else {
            replaceAll.setEnabled( true );
            // FIXME - I18N
            replaceAll.setText( replaceAll.getText() + " (" + numOccurrences + ")" );
            replaceAll.setSelected( pref.getBoolean("replaceAll", true) ); //NOI18N
        }
        
        if (isConstant()) {
            declareFinal.setEnabled(false);
            // value of declare final will be used in IntroduceFieldFix for constants, no special case in isDeclareFinal()
            declareFinal.setSelected(true);
        } else {
            declareFinal.setSelected( pref.getBoolean("declareFinal", true) ); //NOI18N
        }
        
        if (supportsAccess()) {
            int accessModifier = pref.getInt( "accessModifier", ACCESS_PRIVATE ); //NOI18N
            switch( accessModifier ) {
            case ACCESS_PUBLIC:
                accessPublic.setSelected( true );
                break;
            case ACCESS_PROTECTED:
                accessProtected.setSelected( true );
                break;
            case ACCESS_DEFAULT:
                accessDefault.setSelected( true );
                break;
            case ACCESS_PRIVATE:
                accessPrivate.setSelected( true );
                break;
            }
        } else {
            lblAccess.setVisible(false);
            accessPublic.setVisible(false);
            accessProtected.setVisible(false);
            accessDefault.setVisible(false);
            accessPrivate.setVisible(false);
        }
        resetAccess();
        resetInit();
        adjustInitializeIn();
        adjustFinal();
    }
    
    private void resetInit() {
        if (supportsInit()) {
            int init = preferences.getInt( "initMethod", INIT_METHOD ); //NOI18N
            switch( init ) {
            case INIT_FIELD:
                initField.setSelected( true );
                break;
            case INIT_CONSTRUCTORS:
                initConstructors.setSelected( true );
                break;
            case INIT_METHOD:
            default:
                initMethod.setSelected( true );
                break;
            }
        } else {
            lblInitializeIn.setVisible(false);
            initField.setVisible(false);
            initConstructors.setVisible(false);
            initMethod.setVisible(false);
            // reset the first radio button in the group
            initMethod.setSelected(false);
        }
    }
    
    private void resetAccess() {
        if (supportsAccess()) {
            int accessModifier = preferences.getInt( "accessModifier", ACCESS_PRIVATE ); //NOI18N
            switch( accessModifier ) {
            case ACCESS_PUBLIC:
                accessPublic.setSelected( true );
                break;
            case ACCESS_PROTECTED:
                accessProtected.setSelected( true );
                break;
            case ACCESS_DEFAULT:
                accessDefault.setSelected( true );
                break;
            case ACCESS_PRIVATE:
                accessPrivate.setSelected( true );
                break;
            }
        } else {
            lblAccess.setVisible(false);
            accessPublic.setVisible(false);
            accessProtected.setVisible(false);
            accessDefault.setVisible(false);
            accessPrivate.setVisible(false);
        }
    }
    
    public void setAllowAccess(boolean allow) {
        this.allowAccess = allow;
        resetAccess();
        resetInit();
    }
    
    private boolean isConstant() {
        return elementType == CONSTANT;
    }
    
    private boolean supportsInit() {
        return allowAccess && elementType == FIELD;
    }
    
    private boolean supportsAccess() {
        return allowAccess && elementType != VARIABLE;
    }
    
    private Preferences getPreferences() {
        return preferences;
    }

    private void adjustInitializeIn() {
        if (!supportsInit()) {
            return;
        }
        final int initIn;
        if (this.allowInitMethods != null) {
            initIn = this.allowInitMethods[this.replaceAll.isSelected() ? 1 : 0];
        } else {
            // currently serves for constants, see IntroduceConstantFix
            initIn = INIT_FIELD;
        }
        
        boolean oldInitMethod = initMethod.isSelected();
        
        initMethod.setEnabled((initIn & INIT_METHOD) != 0);
        initField.setEnabled((initIn & INIT_FIELD) != 0);
        initConstructors.setEnabled((initIn & INIT_CONSTRUCTORS) != 0);
        
        if( !initMethod.isEnabled() && initMethod.isSelected() ) {
            if( initField.isEnabled() )
                initField.setSelected(true);
            else
                initConstructors.setSelected(true);
        } else if( !initField.isEnabled() && initField.isSelected() ) {
            if( initMethod.isEnabled() )
                initMethod.setSelected(true);
            else
                initConstructors.setSelected(true);
        } else if( !initConstructors.isEnabled() && initConstructors.isSelected() ) {
            if( initMethod.isEnabled() )
                initMethod.setSelected(true);
            else
                initField.setSelected(true);
        }
        if (oldInitMethod != initMethod.isSelected()) {
            adjustFinal();
        }
    }
    
    private void adjustFinal() {
        if (isConstant()) {
            return;
        }
        declareFinal.setEnabled( !(initMethod.isSelected() && !allowFinalInCurrentMethod) );
        if (initMethod.isSelected() && !allowFinalInCurrentMethod) {
            declareFinal.setSelected(false);
        }
    }
    
        
    private JLabel createErrorLabel() {
        ErrorLabel.Validator validator = new ErrorLabel.Validator() {

            public String validate(String text) {
                if( null == text 
                    || text.length() == 0 ) return "";
                if (!Utilities.isJavaIdentifier(text))
                    return getDefaultErrorMessage( text );
                return null;
            }
        };
        
        final ErrorLabel errorLabel = new ErrorLabel( name.getDocument(), validator );
        errorLabel.addPropertyChangeListener(  ErrorLabel.PROP_IS_VALID,new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                btnOk.setEnabled(errorLabel.isInputTextValid());
            }
        });
        return errorLabel;
    }
    
    String getDefaultErrorMessage( String inputText ) {
        return "'" + inputText +"' is not a valid identifier";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        initilizeIn = new javax.swing.ButtonGroup();
        accessGroup = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        replaceAll = new javax.swing.JCheckBox();
        declareFinal = new javax.swing.JCheckBox();
        lblInitializeIn = new javax.swing.JLabel();
        initMethod = new javax.swing.JRadioButton();
        initField = new javax.swing.JRadioButton();
        initConstructors = new javax.swing.JRadioButton();
        lblAccess = new javax.swing.JLabel();
        accessPublic = new javax.swing.JRadioButton();
        accessProtected = new javax.swing.JRadioButton();
        accessDefault = new javax.swing.JRadioButton();
        accessPrivate = new javax.swing.JRadioButton();
        errLabel = createErrorLabel();

        lblName.setLabelFor(name);
        org.openide.awt.Mnemonics.setLocalizedText(lblName, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_Name")); // NOI18N

        name.setColumns(20);

        org.openide.awt.Mnemonics.setLocalizedText(replaceAll, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_ReplaceAll")); // NOI18N
        replaceAll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        replaceAll.setMargin(new java.awt.Insets(0, 0, 0, 0));
        replaceAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceAllActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(declareFinal, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_DeclareFinal")); // NOI18N
        declareFinal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        declareFinal.setMargin(new java.awt.Insets(0, 0, 0, 0));
        declareFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declareFinalActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lblInitializeIn, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "IntroduceFieldPanel.lblInitializeIn.text")); // NOI18N

        initilizeIn.add(initMethod);
        org.openide.awt.Mnemonics.setLocalizedText(initMethod, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_CurrentMethod")); // NOI18N
        initMethod.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initMethod.setMargin(new java.awt.Insets(0, 0, 0, 0));
        initMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initMethodActionPerformed(evt);
            }
        });

        initilizeIn.add(initField);
        org.openide.awt.Mnemonics.setLocalizedText(initField, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_Field")); // NOI18N
        initField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        initField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initFieldActionPerformed(evt);
            }
        });

        initilizeIn.add(initConstructors);
        org.openide.awt.Mnemonics.setLocalizedText(initConstructors, org.openide.util.NbBundle.getBundle(IntroduceFieldPanel.class).getString("LBL_Constructors")); // NOI18N
        initConstructors.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initConstructors.setMargin(new java.awt.Insets(0, 0, 0, 0));
        initConstructors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initConstructorsActionPerformed(evt);
            }
        });

        lblAccess.setLabelFor(accessPublic);
        org.openide.awt.Mnemonics.setLocalizedText(lblAccess, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "LBL_Access")); // NOI18N

        accessGroup.add(accessPublic);
        org.openide.awt.Mnemonics.setLocalizedText(accessPublic, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "LBL_public")); // NOI18N
        accessPublic.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        accessPublic.setMargin(new java.awt.Insets(0, 0, 0, 0));

        accessGroup.add(accessProtected);
        org.openide.awt.Mnemonics.setLocalizedText(accessProtected, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "LBL_protected")); // NOI18N
        accessProtected.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        accessProtected.setMargin(new java.awt.Insets(0, 0, 0, 0));

        accessGroup.add(accessDefault);
        org.openide.awt.Mnemonics.setLocalizedText(accessDefault, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "LBL_Default")); // NOI18N
        accessDefault.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        accessDefault.setMargin(new java.awt.Insets(0, 0, 0, 0));

        accessGroup.add(accessPrivate);
        accessPrivate.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(accessPrivate, org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "LBL_private")); // NOI18N
        accessPrivate.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        accessPrivate.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(errLabel, "jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccess)
                            .addComponent(lblName))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(accessPublic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accessProtected)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accessDefault)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accessPrivate))))
                    .addComponent(declareFinal)
                    .addComponent(replaceAll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInitializeIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initConstructors)
                            .addComponent(initField)
                            .addComponent(initMethod))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccess)
                    .addComponent(accessPublic)
                    .addComponent(accessProtected)
                    .addComponent(accessDefault)
                    .addComponent(accessPrivate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(declareFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replaceAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInitializeIn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(initMethod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initField)
                        .addGap(7, 7, 7)
                        .addComponent(initConstructors)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(errLabel)
                .addContainerGap())
        );

        lblName.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Name")); // NOI18N
        replaceAll.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_ReplaceAllOccurences")); // NOI18N
        declareFinal.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_DeclareFinal")); // NOI18N
        initMethod.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_CurrentMethod")); // NOI18N
        initField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Field")); // NOI18N
        initConstructors.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Constructors")); // NOI18N
        accessPublic.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Public")); // NOI18N
        accessProtected.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Protected")); // NOI18N
        accessDefault.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Default")); // NOI18N
        accessPrivate.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Private")); // NOI18N

        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(IntroduceFieldPanel.class, "AD_IntrFld_Dialog")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void declareFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declareFinalActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_declareFinalActionPerformed

private void initConstructorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initConstructorsActionPerformed
    adjustFinal();
}//GEN-LAST:event_initConstructorsActionPerformed

private void initFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initFieldActionPerformed
    adjustFinal();
}//GEN-LAST:event_initFieldActionPerformed

private void initMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initMethodActionPerformed
    adjustFinal();
}//GEN-LAST:event_initMethodActionPerformed

private void replaceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceAllActionPerformed
        adjustInitializeIn();
}//GEN-LAST:event_replaceAllActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton accessDefault;
    private javax.swing.ButtonGroup accessGroup;
    private javax.swing.JRadioButton accessPrivate;
    private javax.swing.JRadioButton accessProtected;
    private javax.swing.JRadioButton accessPublic;
    private javax.swing.JCheckBox declareFinal;
    private javax.swing.JLabel errLabel;
    private javax.swing.JRadioButton initConstructors;
    private javax.swing.JRadioButton initField;
    private javax.swing.JRadioButton initMethod;
    private javax.swing.ButtonGroup initilizeIn;
    private javax.swing.JLabel lblAccess;
    private javax.swing.JLabel lblInitializeIn;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox replaceAll;
    // End of variables declaration//GEN-END:variables
    
    public String getFieldName() {
        if (fieldNameTest != null) return fieldNameTest;
        return this.name.getText();
    }
    
    public int getInitializeIn() {
        if (initializeInTest != null) return initializeInTest;
        int ret;
        
        if (!allowAccess) {
            return INIT_FIELD;
        }
        if (initMethod.isSelected())
            ret = INIT_METHOD;
        else if (initField.isSelected())
            ret = INIT_FIELD;
        else if (initConstructors.isSelected())
            ret = INIT_CONSTRUCTORS;
        else if (isConstant()) {
            return INIT_FIELD;
        } else {
            throw new IllegalStateException();
        }
        getPreferences().putInt( "initMethod", ret ); //NOI18N
        return ret;
    }
    
    public boolean isReplaceAll() {
        if (replaceAllTest != null) return replaceAllTest;
        boolean ret = replaceAll.isSelected();
        getPreferences().putBoolean( "replaceAll", ret ); //NOI18N
        return ret;
    }
    
    public Set<Modifier> getAccess() {
        if (accessTest != null) return accessTest;
        Set<Modifier> set;
        int val;
        if (!allowAccess) {
            return Collections.emptySet();
        }
        if( accessPublic.isSelected() ) {
            val = ACCESS_PUBLIC;
            set = EnumSet.of(Modifier.PUBLIC);
        } else if( accessProtected.isSelected() ) {
            val = ACCESS_PROTECTED;
            set = EnumSet.of(Modifier.PROTECTED);
        } else if( accessDefault.isSelected() ) {
            val = ACCESS_DEFAULT;
            set = Collections.emptySet();
        } else {
            val = ACCESS_PRIVATE;
            set = EnumSet.of(Modifier.PRIVATE);
        }
        getPreferences().putInt( "accessModifier", val ); //NOI18N
        return set;
    }
    
    public boolean isDeclareFinal() {
        if (declareFinalTest != null) return declareFinalTest;
        boolean ret = declareFinal.isSelected();
        getPreferences().putBoolean( "declareFinal", ret ); //NOI18N
        return ret;
    }
    
    //For tests:
    private String fieldNameTest;
    private Integer initializeInTest;
    private Boolean replaceAllTest;
    private Set<Modifier> accessTest;
    private Boolean declareFinalTest;
    
    void setAccess(Set<Modifier> access) {
        this.accessTest = access;
    }

    void setDeclareFinal(Boolean declareFinal) {
        this.declareFinalTest = declareFinal;
    }

    void setFieldName(String fieldName) {
        this.fieldNameTest = fieldName;
    }

    void setInitializeIn(Integer initializeIn) {
        this.initializeInTest = initializeIn;
    }

    void setReplaceAll(Boolean replaceAll) {
        this.replaceAllTest = replaceAll;
    }
    
}
