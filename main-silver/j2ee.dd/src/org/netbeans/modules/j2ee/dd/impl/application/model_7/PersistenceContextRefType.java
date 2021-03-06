/**
 *	This generated bean class PersistenceContextRefType matches the schema element 'persistence-context-refType'.
 *  The root bean class is Application
 *
 *	===============================================================
 *	
 *	
 *	        This group collects elements that are common to all the
 *	        JNDI resource elements. It does not include the lookup-name
 *	        element, that is only applicable to some resource elements.
 *	        
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.application.model_7;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class PersistenceContextRefType extends org.netbeans.modules.schema2beans.BaseBean
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String PERSISTENCE_CONTEXT_REF_NAME = "PersistenceContextRefName";	// NOI18N
	static public final String PERSISTENCE_UNIT_NAME = "PersistenceUnitName";	// NOI18N
	static public final String PERSISTENCEUNITNAMEID = "PersistenceUnitNameId";	// NOI18N
	static public final String PERSISTENCE_CONTEXT_TYPE = "PersistenceContextType";	// NOI18N
	static public final String PERSISTENCE_CONTEXT_SYNCHRONIZATION = "PersistenceContextSynchronization";	// NOI18N
	static public final String PERSISTENCE_PROPERTY = "PersistenceProperty";	// NOI18N
	static public final String MAPPED_NAME = "MappedName";	// NOI18N
	static public final String MAPPEDNAMEID = "MappedNameId";	// NOI18N
	static public final String INJECTION_TARGET = "InjectionTarget";	// NOI18N

	public PersistenceContextRefType() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public PersistenceContextRefType(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(8);
		this.createProperty("description", 	// NOI18N
			DESCRIPTION, 
			Common.TYPE_0_N | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(DESCRIPTION, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createAttribute(DESCRIPTION, "xml:lang", "XmlLang", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("persistence-context-ref-name", 	// NOI18N
			PERSISTENCE_CONTEXT_REF_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("persistence-unit-name", 	// NOI18N
			PERSISTENCE_UNIT_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(PERSISTENCE_UNIT_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("persistence-context-type", 	// NOI18N
			PERSISTENCE_CONTEXT_TYPE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("persistence-context-synchronization", 	// NOI18N
			PERSISTENCE_CONTEXT_SYNCHRONIZATION, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("persistence-property", 	// NOI18N
			PERSISTENCE_PROPERTY, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			PropertyType.class);
		this.createAttribute(PERSISTENCE_PROPERTY, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("mapped-name", 	// NOI18N
			MAPPED_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(MAPPED_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("injection-target", 	// NOI18N
			INJECTION_TARGET, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			InjectionTargetType.class);
		this.initialize(options);
	}

	// Setting the default values of the properties
	void initialize(int options) {

	}

	// This attribute is optional
	public void setId(java.lang.String value) {
		setAttributeValue(ID, value);
	}

	//
	public java.lang.String getId() {
		return getAttributeValue(ID);
	}

	// This attribute is an array, possibly empty
	public void setDescription(int index, java.lang.String value) {
		this.setValue(DESCRIPTION, index, value);
	}

	//
	public java.lang.String getDescription(int index) {
		return (java.lang.String)this.getValue(DESCRIPTION, index);
	}

	// Return the number of properties
	public int sizeDescription() {
		return this.size(DESCRIPTION);
	}

	// This attribute is an array, possibly empty
	public void setDescription(java.lang.String[] value) {
		this.setValue(DESCRIPTION, value);
	}

	//
	public java.lang.String[] getDescription() {
		return (java.lang.String[])this.getValues(DESCRIPTION);
	}

	// Add a new element returning its index in the list
	public int addDescription(java.lang.String value) {
		int positionOfNewItem = this.addValue(DESCRIPTION, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeDescription(java.lang.String value) {
		return this.removeValue(DESCRIPTION, value);
	}

	// This attribute is an array, possibly empty
	public void setDescriptionId(int index, java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DESCRIPTION) == 0) {
			addValue(DESCRIPTION, "");
		}
		setAttributeValue(DESCRIPTION, index, "Id", value);
	}

	//
	public java.lang.String getDescriptionId(int index) {
		// If our element does not exist, then the attribute does not exist.
		if (size(DESCRIPTION) == 0) {
			return null;
		} else {
			return getAttributeValue(DESCRIPTION, index, "Id");
		}
	}

	// Return the number of properties
	public int sizeDescriptionId() {
		return this.size(DESCRIPTION);
	}

	// This attribute is an array, possibly empty
	public void setDescriptionXmlLang(int index, java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DESCRIPTION) == 0) {
			addValue(DESCRIPTION, "");
		}
		setAttributeValue(DESCRIPTION, index, "XmlLang", value);
	}

	//
	public java.lang.String getDescriptionXmlLang(int index) {
		// If our element does not exist, then the attribute does not exist.
		if (size(DESCRIPTION) == 0) {
			return null;
		} else {
			return getAttributeValue(DESCRIPTION, index, "XmlLang");
		}
	}

	// Return the number of properties
	public int sizeDescriptionXmlLang() {
		return this.size(DESCRIPTION);
	}

	// This attribute is mandatory
	public void setPersistenceContextRefName(java.lang.String value) {
		this.setValue(PERSISTENCE_CONTEXT_REF_NAME, value);
	}

	//
	public java.lang.String getPersistenceContextRefName() {
		return (java.lang.String)this.getValue(PERSISTENCE_CONTEXT_REF_NAME);
	}

	// This attribute is optional
	public void setPersistenceUnitName(java.lang.String value) {
		this.setValue(PERSISTENCE_UNIT_NAME, value);
	}

	//
	public java.lang.String getPersistenceUnitName() {
		return (java.lang.String)this.getValue(PERSISTENCE_UNIT_NAME);
	}

	// This attribute is optional
	public void setPersistenceUnitNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PERSISTENCE_UNIT_NAME) == 0) {
			setValue(PERSISTENCE_UNIT_NAME, "");
		}
		setAttributeValue(PERSISTENCE_UNIT_NAME, "Id", value);
	}

	//
	public java.lang.String getPersistenceUnitNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PERSISTENCE_UNIT_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(PERSISTENCE_UNIT_NAME, "Id");
		}
	}

	// This attribute is optional
	public void setPersistenceContextType(java.lang.String value) {
		this.setValue(PERSISTENCE_CONTEXT_TYPE, value);
	}

	//
	public java.lang.String getPersistenceContextType() {
		return (java.lang.String)this.getValue(PERSISTENCE_CONTEXT_TYPE);
	}

	// This attribute is optional
	public void setPersistenceContextSynchronization(java.lang.String value) {
		this.setValue(PERSISTENCE_CONTEXT_SYNCHRONIZATION, value);
	}

	//
	public java.lang.String getPersistenceContextSynchronization() {
		return (java.lang.String)this.getValue(PERSISTENCE_CONTEXT_SYNCHRONIZATION);
	}

	// This attribute is an array, possibly empty
	public void setPersistenceProperty(int index, PropertyType value) {
		this.setValue(PERSISTENCE_PROPERTY, index, value);
	}

	//
	public PropertyType getPersistenceProperty(int index) {
		return (PropertyType)this.getValue(PERSISTENCE_PROPERTY, index);
	}

	// Return the number of properties
	public int sizePersistenceProperty() {
		return this.size(PERSISTENCE_PROPERTY);
	}

	// This attribute is an array, possibly empty
	public void setPersistenceProperty(PropertyType[] value) {
		this.setValue(PERSISTENCE_PROPERTY, value);
	}

	//
	public PropertyType[] getPersistenceProperty() {
		return (PropertyType[])this.getValues(PERSISTENCE_PROPERTY);
	}

	// Add a new element returning its index in the list
	public int addPersistenceProperty(org.netbeans.modules.j2ee.dd.impl.application.model_7.PropertyType value) {
		int positionOfNewItem = this.addValue(PERSISTENCE_PROPERTY, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removePersistenceProperty(org.netbeans.modules.j2ee.dd.impl.application.model_7.PropertyType value) {
		return this.removeValue(PERSISTENCE_PROPERTY, value);
	}

	// This attribute is optional
	public void setMappedName(java.lang.String value) {
		this.setValue(MAPPED_NAME, value);
	}

	//
	public java.lang.String getMappedName() {
		return (java.lang.String)this.getValue(MAPPED_NAME);
	}

	// This attribute is optional
	public void setMappedNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(MAPPED_NAME) == 0) {
			setValue(MAPPED_NAME, "");
		}
		setAttributeValue(MAPPED_NAME, "Id", value);
	}

	//
	public java.lang.String getMappedNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(MAPPED_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(MAPPED_NAME, "Id");
		}
	}

	// This attribute is an array, possibly empty
	public void setInjectionTarget(int index, InjectionTargetType value) {
		this.setValue(INJECTION_TARGET, index, value);
	}

	//
	public InjectionTargetType getInjectionTarget(int index) {
		return (InjectionTargetType)this.getValue(INJECTION_TARGET, index);
	}

	// Return the number of properties
	public int sizeInjectionTarget() {
		return this.size(INJECTION_TARGET);
	}

	// This attribute is an array, possibly empty
	public void setInjectionTarget(InjectionTargetType[] value) {
		this.setValue(INJECTION_TARGET, value);
	}

	//
	public InjectionTargetType[] getInjectionTarget() {
		return (InjectionTargetType[])this.getValues(INJECTION_TARGET);
	}

	// Add a new element returning its index in the list
	public int addInjectionTarget(org.netbeans.modules.j2ee.dd.impl.application.model_7.InjectionTargetType value) {
		int positionOfNewItem = this.addValue(INJECTION_TARGET, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeInjectionTarget(org.netbeans.modules.j2ee.dd.impl.application.model_7.InjectionTargetType value) {
		return this.removeValue(INJECTION_TARGET, value);
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public PropertyType newPropertyType() {
		return new PropertyType();
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public InjectionTargetType newInjectionTargetType() {
		return new InjectionTargetType();
	}

	//
	public static void addComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.add(c);
	}

	//
	public static void removeComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.remove(c);
	}
	public void validate() throws org.netbeans.modules.schema2beans.ValidateException {
		boolean restrictionFailure = false;
		boolean restrictionPassed = false;
		// Validating property id
		if (getId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "id", this);	// NOI18N
			}
		}
		// Validating property description
		// Validating property descriptionId
		// Validating property descriptionXmlLang
		// Validating property persistenceContextRefName
		if (getPersistenceContextRefName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceContextRefName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "persistenceContextRefName", this);	// NOI18N
		}
		// Validating property persistenceUnitName
		if (getPersistenceUnitName() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceUnitName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "persistenceUnitName", this);	// NOI18N
			}
		}
		// Validating property persistenceUnitNameId
		if (getPersistenceUnitNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceUnitNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "persistenceUnitNameId", this);	// NOI18N
			}
		}
		// Validating property persistenceContextType
		if (getPersistenceContextType() != null) {
			final java.lang.String[] enumRestrictionPersistenceContextType = {"Transaction", "Extended"};
			restrictionFailure = true;
			for (int _index2 = 0; 
				_index2 < enumRestrictionPersistenceContextType.length; 
				++_index2) {
				if (enumRestrictionPersistenceContextType[_index2].equals(getPersistenceContextType())) {
					restrictionFailure = false;
					break;
				}
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceContextType() enumeration test", org.netbeans.modules.schema2beans.ValidateException.FailureType.ENUM_RESTRICTION, "persistenceContextType", this);	// NOI18N
			}
		}
		// Validating property persistenceContextSynchronization
		if (getPersistenceContextSynchronization() != null) {
			final java.lang.String[] enumRestrictionPersistenceContextSynchronization = {"Synchronized", "Unsynchronized"};
			restrictionFailure = true;
			for (int _index2 = 0; 
				_index2 < enumRestrictionPersistenceContextSynchronization.length; 
				++_index2) {
				if (enumRestrictionPersistenceContextSynchronization[_index2].equals(getPersistenceContextSynchronization())) {
					restrictionFailure = false;
					break;
				}
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceContextSynchronization() enumeration test", org.netbeans.modules.schema2beans.ValidateException.FailureType.ENUM_RESTRICTION, "persistenceContextSynchronization", this);	// NOI18N
			}
		}
		// Validating property persistenceProperty
		for (int _index = 0; _index < sizePersistenceProperty(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.application.model_7.PropertyType element = getPersistenceProperty(_index);
			if (element != null) {
				element.validate();
			}
		}
		// Validating property mappedName
		// Validating property mappedNameId
		if (getMappedNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMappedNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "mappedNameId", this);	// NOI18N
			}
		}
		// Validating property injectionTarget
		for (int _index = 0; _index < sizeInjectionTarget(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.application.model_7.InjectionTargetType element = getInjectionTarget(_index);
			if (element != null) {
				element.validate();
			}
		}
	}

	// Dump the content of this bean returning it as a String
	public void dump(StringBuffer str, String indent){
		String s;
		Object o;
		org.netbeans.modules.schema2beans.BaseBean n;
		str.append(indent);
		str.append("Description["+this.sizeDescription()+"]");	// NOI18N
		for(int i=0; i<this.sizeDescription(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			str.append(indent+"\t");	// NOI18N
			str.append("<");	// NOI18N
			o = this.getDescription(i);
			str.append((o==null?"null":o.toString().trim()));	// NOI18N
			str.append(">\n");	// NOI18N
			this.dumpAttributes(DESCRIPTION, i, str, indent);
		}

		str.append(indent);
		str.append("PersistenceContextRefName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceContextRefName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_CONTEXT_REF_NAME, 0, str, indent);

		str.append(indent);
		str.append("PersistenceUnitName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceUnitName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_UNIT_NAME, 0, str, indent);

		str.append(indent);
		str.append("PersistenceContextType");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceContextType();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_CONTEXT_TYPE, 0, str, indent);

		str.append(indent);
		str.append("PersistenceContextSynchronization");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceContextSynchronization();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_CONTEXT_SYNCHRONIZATION, 0, str, indent);

		str.append(indent);
		str.append("PersistenceProperty["+this.sizePersistenceProperty()+"]");	// NOI18N
		for(int i=0; i<this.sizePersistenceProperty(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getPersistenceProperty(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(PERSISTENCE_PROPERTY, i, str, indent);
		}

		str.append(indent);
		str.append("MappedName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMappedName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MAPPED_NAME, 0, str, indent);

		str.append(indent);
		str.append("InjectionTarget["+this.sizeInjectionTarget()+"]");	// NOI18N
		for(int i=0; i<this.sizeInjectionTarget(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getInjectionTarget(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(INJECTION_TARGET, i, str, indent);
		}

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("PersistenceContextRefType\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N


/*
		The following schema file has been used for generation:

<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns="http://www.w3.org/2001/XMLSchema"
            targetNamespace="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:javaee="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsd="http://www.w3.org/2001/XMLSchema"
            elementFormDefault="qualified"
            attributeFormDefault="unqualified"
            version="7">
  <xsd:annotation>
    <xsd:documentation>

      DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
      
      Copyright (c) 2009-2013 Oracle and/or its affiliates. All rights reserved.
      
      The contents of this file are subject to the terms of either the GNU
      General Public License Version 2 only ("GPL") or the Common Development
      and Distribution License("CDDL") (collectively, the "License").  You
      may not use this file except in compliance with the License.  You can
      obtain a copy of the License at
      https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
      or packager/legal/LICENSE.txt.  See the License for the specific
      language governing permissions and limitations under the License.
      
      When distributing the software, include this License Header Notice in each
      file and include the License file at packager/legal/LICENSE.txt.
      
      GPL Classpath Exception:
      Oracle designates this particular file as subject to the "Classpath"
      exception as provided by Oracle in the GPL Version 2 section of the License
      file that accompanied this code.
      
      Modifications:
      If applicable, add the following below the License Header, with the fields
      enclosed by brackets [] replaced by your own identifying information:
      "Portions Copyright [year] [name of copyright owner]"
      
      Contributor(s):
      If you wish your version of this file to be governed by only the CDDL or
      only the GPL Version 2, indicate your decision by adding "[Contributor]
      elects to include this software in this distribution under the [CDDL or GPL
      Version 2] license."  If you don't indicate a single choice of license, a
      recipient has the option to distribute your version of this file under
      either the CDDL, the GPL Version 2 or to extend the choice of license to
      its licensees as provided above.  However, if you add GPL Version 2 code
      and therefore, elected the GPL Version 2 license, then the option applies
      only if the new code is made subject to such option by the copyright
      holder.
      
    </xsd:documentation>
  </xsd:annotation>

  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[[
      This is the XML Schema for the application 7 deployment
      descriptor.  The deployment descriptor must be named
      "META-INF/application.xml" in the application's ear file.
      All application deployment descriptors must indicate
      the application schema by using the Java EE namespace:
      
      http://xmlns.jcp.org/xml/ns/javaee
      
      and indicate the version of the schema by
      using the version element as shown below:
      
      <application xmlns="http://xmlns.jcp.org/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
      	http://xmlns.jcp.org/xml/ns/javaee/application_7.xsd"
      version="7">
      ...
      </application>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://xmlns.jcp.org/xml/ns/javaee/application_7.xsd
      
      ]]>
    </xsd:documentation>
  </xsd:annotation>

  <xsd:annotation>
    <xsd:documentation>

      The following conventions apply to all Java EE
      deployment descriptor elements unless indicated otherwise.
      
      - In elements that specify a pathname to a file within the
      same JAR file, relative filenames (i.e., those not
      starting with "/") are considered relative to the root of
      the JAR file's namespace.  Absolute filenames (i.e., those
      starting with "/") also specify names in the root of the
      JAR file's namespace.  In general, relative names are
      preferred.  The exception is .war files where absolute
      names are preferred for consistency with the Servlet API.
      
    </xsd:documentation>
  </xsd:annotation>

  <xsd:include schemaLocation="javaee_7.xsd"/>


<!-- **************************************************** -->

  <xsd:element name="application"
               type="javaee:applicationType">
    <xsd:annotation>
      <xsd:documentation>

        The application element is the root element of a Java EE
        application deployment descriptor.
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:unique name="context-root-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The context-root element content must be unique
          in the ear. 
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:module/javaee:web"/>
      <xsd:field xpath="javaee:context-root"/>
    </xsd:unique>
    <xsd:unique name="security-role-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The security-role-name element content
          must be unique in the ear.  
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:security-role"/>
      <xsd:field xpath="javaee:role-name"/>
    </xsd:unique>
  </xsd:element>


<!-- **************************************************** -->

  <xsd:complexType name="applicationType">
    <xsd:annotation>
      <xsd:documentation>

        The applicationType defines the structure of the
        application. 
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:sequence>
      <xsd:element name="application-name"
                   type="javaee:string"
                   minOccurs="0"/>
      <xsd:group ref="javaee:descriptionGroup"/>
      <xsd:element name="initialize-in-order"
                   type="javaee:generic-booleanType"
                   minOccurs="0"
                   maxOccurs="1">
        <xsd:annotation>
          <xsd:documentation>

            If initialize-in-order is true, modules must be initialized
            in the order they're listed in this deployment descriptor,
            with the exception of application client modules, which can
            be initialized in any order.
            If initialize-in-order is not set or set to false, the order
            of initialization is unspecified and may be product-dependent.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
      <xsd:element name="module"
                   type="javaee:moduleType"
                   maxOccurs="unbounded">
        <xsd:annotation>
          <xsd:documentation>

            The application deployment descriptor must have one
            module element for each Java EE module in the
            application package. A module element is defined 
            by moduleType definition. 
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
      <xsd:element name="security-role"
                   type="javaee:security-roleType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="library-directory"
                   type="javaee:pathType"
                   minOccurs="0"
                   maxOccurs="1">
        <xsd:annotation>
          <xsd:documentation>

            The library-directory element specifies the pathname
            of a directory within the application package, relative
            to the top level of the application package.  All files
            named "*.jar" in this directory must be made available
            in the class path of all components included in this
            application package.  If this element isn't specified,
            the directory named "lib" is searched.  An empty element
            may be used to disable searching.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
      <xsd:element name="env-entry"
                   type="javaee:env-entryType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="ejb-ref"
                   type="javaee:ejb-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="ejb-local-ref"
                   type="javaee:ejb-local-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:group ref="javaee:service-refGroup"/>
      <xsd:element name="resource-ref"
                   type="javaee:resource-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="resource-env-ref"
                   type="javaee:resource-env-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="message-destination-ref"
                   type="javaee:message-destination-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="persistence-context-ref"
                   type="javaee:persistence-context-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="persistence-unit-ref"
                   type="javaee:persistence-unit-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="message-destination"
                   type="javaee:message-destinationType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="data-source"
                   type="javaee:data-sourceType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="jms-connection-factory"
                   type="javaee:jms-connection-factoryType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="jms-destination"
                   type="javaee:jms-destinationType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="mail-session"
                   type="javaee:mail-sessionType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="connection-factory"
                   type="javaee:connection-factory-resourceType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="administered-object"
                   type="javaee:administered-objectType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
    </xsd:sequence>
    <xsd:attribute name="version"
                   type="javaee:dewey-versionType"
                   fixed="7"
                   use="required">
      <xsd:annotation>
        <xsd:documentation>

          The required value for the version is 7.
          
        </xsd:documentation>
      </xsd:annotation>
    </xsd:attribute>
    <xsd:attribute name="id"
                   type="xsd:ID"/>
  </xsd:complexType>


<!-- **************************************************** -->

  <xsd:complexType name="moduleType">
    <xsd:annotation>
      <xsd:documentation>

        The moduleType defines a single Java EE module and contains a
        connector, ejb, java, or web element, which indicates the
        module type and contains a path to the module file, and an
        optional alt-dd element, which specifies an optional URI to
        the post-assembly version of the deployment descriptor.
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:sequence>
      <xsd:choice>
        <xsd:element name="connector"
                     type="javaee:pathType">
          <xsd:annotation>
            <xsd:documentation>

              The connector element specifies the URI of a
              resource adapter archive file, relative to the
              top level of the application package.
              
            </xsd:documentation>
          </xsd:annotation>
        </xsd:element>
        <xsd:element name="ejb"
                     type="javaee:pathType">
          <xsd:annotation>
            <xsd:documentation>

              The ejb element specifies the URI of an ejb-jar,
              relative to the top level of the application
              package.
              
            </xsd:documentation>
          </xsd:annotation>
        </xsd:element>
        <xsd:element name="java"
                     type="javaee:pathType">
          <xsd:annotation>
            <xsd:documentation>

              The java element specifies the URI of a java
              application client module, relative to the top
              level of the application package.
              
            </xsd:documentation>
          </xsd:annotation>
        </xsd:element>
        <xsd:element name="web"
                     type="javaee:webType"/>
      </xsd:choice>
      <xsd:element name="alt-dd"
                   type="javaee:pathType"
                   minOccurs="0">
        <xsd:annotation>
          <xsd:documentation>

            The alt-dd element specifies an optional URI to the
            post-assembly version of the deployment descriptor
            file for a particular Java EE module.  The URI must
            specify the full pathname of the deployment
            descriptor file relative to the application's root
            directory. If alt-dd is not specified, the deployer
            must read the deployment descriptor from the default
            location and file name required by the respective
            component specification.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
    </xsd:sequence>
    <xsd:attribute name="id"
                   type="xsd:ID"/>
  </xsd:complexType>


<!-- **************************************************** -->

  <xsd:complexType name="webType">
    <xsd:annotation>
      <xsd:documentation>

        The webType defines the web-uri and context-root of
        a web application module.
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:sequence>
      <xsd:element name="web-uri"
                   type="javaee:pathType">
        <xsd:annotation>
          <xsd:documentation>

            The web-uri element specifies the URI of a web
            application file, relative to the top level of the
            application package.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
      <xsd:element name="context-root"
                   type="javaee:string">
        <xsd:annotation>
          <xsd:documentation>

            The context-root element specifies the context root
            of a web application.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
    </xsd:sequence>
    <xsd:attribute name="id"
                   type="xsd:ID"/>
  </xsd:complexType>

</xsd:schema>

*/
