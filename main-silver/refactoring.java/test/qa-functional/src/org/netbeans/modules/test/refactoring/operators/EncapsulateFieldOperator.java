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
 * License. You can obtain x copy of the License at
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
 * under the [CDDL or GPL Version 2] license." If you do not indicate x
 * single choice of license, x recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 *//*
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
 * License. You can obtain x copy of the License at
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
 * under the [CDDL or GPL Version 2] license." If you do not indicate x
 * single choice of license, x recipient has the option to distribute
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
package org.netbeans.modules.test.refactoring.operators;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JComboBoxOperator;
import org.netbeans.jemmy.operators.JTableOperator;

/**
 * <p> @author (stanislav.sazonov@oracle.com)
 */
public class EncapsulateFieldOperator extends IntroduceOperator {

    public EncapsulateFieldOperator() {
        super("Encapsulate Fields");
    }
        
    public void setValueAt(int y, int x, boolean val){
        JTableOperator table = new JTableOperator(this, 0); 
        JTable t = ((JTable)table.getSource());                
        TableModel model = t.getModel();
        model.setValueAt(val, y, x);
    }
    
    public void setValueAt(int y, int x, String val){
        JTableOperator table = new JTableOperator(this, 0); 
        JTable t = ((JTable)table.getSource());                
        TableModel model = t.getModel();
        model.setValueAt(val, y, x);
    }
    
    public void setInsertPoint(String s){
        JComboBoxOperator combo = new JComboBoxOperator(this, 4);
        combo.selectItem(s);
    }
    
    public void setSortBy(String s){
        JComboBoxOperator combo = new JComboBoxOperator(this, 2);
        combo.selectItem(s);
    }
    
    public void setJavadoc(String s){
        JComboBoxOperator combo = new JComboBoxOperator(this, 1);
        combo.selectItem(s);
    }
    
    public void setFieldsVisibility(String s){
        JComboBoxOperator combo = new JComboBoxOperator(this, 0);
        combo.selectItem(s);
    }
    
    public void setAccessorsVisibility(String s){
        JComboBoxOperator combo = new JComboBoxOperator(this, 3);
        combo.selectItem(s);
    }
    
    //------------------------------------------------
    public void setItemToScope(int index){
        JComboBoxOperator combo = new JComboBoxOperator(this, index);
        combo.selectItem(2);
    }
    
    public void setChreckbox(int index, boolean b){
        JCheckBoxOperator combo = new JCheckBoxOperator(this, index);
        combo.setSelected(b);
    }
    //------------------------------------------------
    
    public void setUseAccessorsEvenWhenFieldIsAccessible(boolean b){
        JCheckBoxOperator check = new JCheckBoxOperator(this, 2);
        check.setSelected(b);
    }
    
    public void setGeneratePropertyChangeSupport(boolean b){
        JCheckBoxOperator check = new JCheckBoxOperator(this, 1);
        check.setSelected(b);
    }
    
    public void setGenerateVetoableChangeSupport(boolean b){
        JCheckBoxOperator check = new JCheckBoxOperator(this, 0);
        check.setSelected(b);
    }
    
    public void selectAll(){
        JButtonOperator button = new JButtonOperator(this, "Select All");
        button.clickMouse();
    }
    
    public void selectNone(){
        JButtonOperator button = new JButtonOperator(this, "Select None");
        button.clickMouse();
    }
    
    public void selectGetters(){
        JButtonOperator button = new JButtonOperator(this, "Select Getters");
        button.clickMouse();
    }
    
    public void selectSetters(){
        JButtonOperator button = new JButtonOperator(this, "Select Setters");
        button.clickMouse();
    }
}
