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
package org.apache.jmeter.module;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.Action;
import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.module.exceptions.InitializationException;
import org.apache.jmeter.module.integration.JMeterIntegrationEngine;
import org.apache.jmeter.module.integration.JMeterPlan;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.util.JMeterUtils;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.WeakListeners;

public class JMXTypeDataNode extends DataNode {

  private static final ResourceBundle bundle = ResourceBundle.getBundle("org/apache/jmeter/images/icon");

  private static final String NB_ENABLED = "nb.enabled";
  private static final String NB_RAMPUP = "nb.rampup";
  private static final String NB_PORT = "nb.port";
  private static final String NB_SERVER = "nb.server";
  private static final String NB_USERS = "nb.users";

  private class MapBasedProperty extends PropertySupport.ReadWrite {

    private Map vars = null;

    public MapBasedProperty(final Map vars, final String name, final Class clz, final String displayName, final String shortDescription) {
      super(name, clz, displayName, shortDescription);
      this.vars = vars;
    }

    public void setValue(Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Object oldValue = getValue();
      vars.put(getName(), value != null ? value.toString() : null);
      if (oldValue == null || value == null || !oldValue.equals(value)) {
        if (!firePropertyChanged(getName(), oldValue, value)) {
          vars.put(getName(), oldValue != null ? oldValue.toString() : oldValue);
        }
      }
    }

    public Object getValue() throws IllegalAccessException, InvocationTargetException {
      Object result = vars.get(getName());
      Class typeClass = getValueType();
      Class intClass = Integer.class;

      if (getValueType().equals(Integer.class)) {
        result = Integer.parseInt(result.toString());
      }
      return result;
    }
  }

  private JMeterPlan associatedPlan;
  private JMeterIntegrationEngine engine;

  public JMXTypeDataNode(JMXTypeDataObject obj) {
    super(obj, Children.LEAF);

    if (obj == null) {
      return;
    }
  }

  public Image getOpenedIcon(int i) {
    Image icon = null;
    icon = JMeterUtils.getImage("feather.gif").getImage();

    return icon != null ? icon : super.getOpenedIcon(i);
  }

  public Image getIcon(int i) {
    Image icon = null;
    icon = JMeterUtils.getImage("feather.gif").getImage();

    return icon != null ? icon : super.getIcon(i);
  }

  /**
   * Dont use preferred action! The preferred action is called at the creation of new node *TWICE*
   */
  public Action getPreferredAction() {
    return null;
  }

  protected Sheet createSheet() {
    Sheet retValue;

    Sheet.Set expert = null;
    try {
      final String path = FileUtil.toFile(getDataObject().getPrimaryFile()).getCanonicalPath();
      associatedPlan = getEngine().getPlan(path);
      final Map vars = associatedPlan.getRoot().getUserDefinedVariables();

      if (vars.containsKey(NB_ENABLED)) {
        expert = Sheet.createExpertSet();
        expert.put(new MapBasedProperty(vars, NB_SERVER, String.class, "Target server", "Sets the target server"));
        expert.put(new MapBasedProperty(vars, NB_PORT, Integer.class, "Target server port", "Sets the target server port"));
        expert.put(new MapBasedProperty(vars, NB_USERS, Integer.class, "Number of users", "The number of simulated users"));
        expert.put(new MapBasedProperty(vars, NB_RAMPUP, Integer.class, "Rampup time", "The time between starting the first and the last simulated user (in seconds)"));

        expert.addPropertyChangeListener(new PropertyChangeListener() {

          public void propertyChange(PropertyChangeEvent evt) {
            System.out.println("Property changed");
          }
        });
      }
    } catch (Exception e) {
    }

    retValue = super.createSheet();
//    Sheet.Set set = retValue.get(Sheet.PROPERTIES);
//    set.addPropertyChangeListener(new PropertyChangeListener() {
//
//      public void propertyChange(PropertyChangeEvent evt) {
//        Sheet.Set props = (Sheet.Set) evt.getSource();
//
//        for (Property prop : props.getProperties()) {
//          try {
//            System.out.println("Property value: " + prop.getName() + " = " + prop.getValue());
//          } catch (IllegalAccessException ex) {
//            Exceptions.printStackTrace(ex);
//          } catch (InvocationTargetException ex) {
//            Exceptions.printStackTrace(ex);
//          }
//        }
//      }
//    });


    if (expert != null) {
      retValue.put(expert);
    }
    return retValue;
  }

  private synchronized JMeterIntegrationEngine getEngine() {
    if (engine == null) {
      try {
        engine = JMeterIntegrationEngine.getDefault();
      } catch (InitializationException e) {
      }
    }
    return engine;
  }

  private boolean firePropertyChanged(final String name, final Object oldValue, final Object newValue) {
    Arguments args = (Arguments) associatedPlan.getRoot().getUserDefinedVariablesAsProperty().getObjectValue();
    for (int i = 0; i < args.getArgumentCount(); i++) {
      Argument arg = args.getArgument(i);
      System.out.println(arg.getName() + " = " + arg.getValue());
      if (arg.getName().equals(name)) {
        arg.setValue(newValue != null ? newValue.toString() : null);
      }
    }
    return getEngine().savePlan(associatedPlan);
  }
}
