/**
 *	This generated bean class PersistenceUnitRefType matches the schema element 'persistence-unit-refType'.
 *  The root bean class is ApplicationClient
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

package org.netbeans.modules.j2ee.dd.impl.client.model_6_0;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class PersistenceUnitRefType extends org.netbeans.modules.schema2beans.BaseBean
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String PERSISTENCE_UNIT_REF_NAME = "PersistenceUnitRefName";	// NOI18N
	static public final String PERSISTENCE_UNIT_NAME = "PersistenceUnitName";	// NOI18N
	static public final String PERSISTENCEUNITNAMEID = "PersistenceUnitNameId";	// NOI18N
	static public final String MAPPED_NAME = "MappedName";	// NOI18N
	static public final String MAPPEDNAMEID = "MappedNameId";	// NOI18N
	static public final String INJECTION_TARGET = "InjectionTarget";	// NOI18N

	public PersistenceUnitRefType() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public PersistenceUnitRefType(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(5);
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
		this.createProperty("persistence-unit-ref-name", 	// NOI18N
			PERSISTENCE_UNIT_REF_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("persistence-unit-name", 	// NOI18N
			PERSISTENCE_UNIT_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(PERSISTENCE_UNIT_NAME, "id", "Id", 
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
			InjectionTarget.class);
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
	public void setPersistenceUnitRefName(java.lang.String value) {
		this.setValue(PERSISTENCE_UNIT_REF_NAME, value);
	}

	//
	public java.lang.String getPersistenceUnitRefName() {
		return (java.lang.String)this.getValue(PERSISTENCE_UNIT_REF_NAME);
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
	public void setInjectionTarget(int index, org.netbeans.modules.j2ee.dd.api.common.InjectionTarget valueInterface) {
		InjectionTarget value = (InjectionTarget) valueInterface;
		this.setValue(INJECTION_TARGET, index, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.InjectionTarget getInjectionTarget(int index) {
		return (InjectionTarget)this.getValue(INJECTION_TARGET, index);
	}

	// Return the number of properties
	public int sizeInjectionTarget() {
		return this.size(INJECTION_TARGET);
	}

	// This attribute is an array, possibly empty
	public void setInjectionTarget(org.netbeans.modules.j2ee.dd.api.common.InjectionTarget[] value) {
		this.setValue(INJECTION_TARGET, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.InjectionTarget[] getInjectionTarget() {
		return (InjectionTarget[])this.getValues(INJECTION_TARGET);
	}

	// Add a new element returning its index in the list
	public int addInjectionTarget(org.netbeans.modules.j2ee.dd.api.common.InjectionTarget valueInterface) {
		InjectionTarget value = (InjectionTarget) valueInterface;
		int positionOfNewItem = this.addValue(INJECTION_TARGET, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeInjectionTarget(org.netbeans.modules.j2ee.dd.api.common.InjectionTarget valueInterface) {
		InjectionTarget value = (InjectionTarget) valueInterface;
		return this.removeValue(INJECTION_TARGET, value);
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.common.InjectionTarget newInjectionTarget() {
		return new InjectionTarget();
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
		// Validating property persistenceUnitRefName
		if (getPersistenceUnitRefName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getPersistenceUnitRefName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "persistenceUnitRefName", this);	// NOI18N
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
			org.netbeans.modules.j2ee.dd.impl.client.model_6_0.InjectionTarget element = (org.netbeans.modules.j2ee.dd.impl.client.model_6_0.InjectionTarget) getInjectionTarget(_index);
			if (element != null) {
				((InjectionTarget)element).validate();
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
		str.append("PersistenceUnitRefName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceUnitRefName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_UNIT_REF_NAME, 0, str, indent);

		str.append(indent);
		str.append("PersistenceUnitName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPersistenceUnitName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PERSISTENCE_UNIT_NAME, 0, str, indent);

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
		str.append("PersistenceUnitRefType\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N


/*
		The following schema file has been used for generation:

<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns="http://www.w3.org/2001/XMLSchema"
            targetNamespace="http://java.sun.com/xml/ns/javaee"
            xmlns:javaee="http://java.sun.com/xml/ns/javaee"
            xmlns:xsd="http://www.w3.org/2001/XMLSchema"
            elementFormDefault="qualified"
            attributeFormDefault="unqualified"
            version="6">
  <xsd:annotation>
    <xsd:documentation>

      $Id$

    </xsd:documentation>
  </xsd:annotation>

  <xsd:annotation>
    <xsd:documentation>

      DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

      Copyright 2003-2010 Oracle and/or its affiliates. All rights reserved.

Oracle and Java are registered trademarks of Oracle and/or its affiliates.
Other names may be trademarks of their respective owners.

      The contents of this file are subject to the terms of either the
      GNU General Public License Version 2 only ("GPL") or the Common
      Development and Distribution License("CDDL") (collectively, the
      "License").  You may not use this file except in compliance with
      the License. You can obtain a copy of the License at
      https://glassfish.dev.java.net/public/CDDL+GPL.html or
      glassfish/bootstrap/legal/LICENSE.txt.  See the License for the
      specific language governing permissions and limitations under the
      License.
      
      When distributing the software, include this License Header
      Notice in each file and include the License file at
      glassfish/bootstrap/legal/LICENSE.txt.  Sun designates this
      particular file as subject to the "Classpath" exception as
      provided by Sun in the GPL Version 2 section of the License file
      that accompanied this code.  If applicable, add the following
      below the License Header, with the fields enclosed by brackets []
      replaced by your own identifying information:
      "Portions Copyrighted [year] [name of copyright owner]"
      
      Contributor(s):
      
      If you wish your version of this file to be governed by only the
      CDDL or only the GPL Version 2, indicate your decision by adding
      "[Contributor] elects to include this software in this
      distribution under the [CDDL or GPL Version 2] license."  If you
      don't indicate a single choice of license, a recipient has the
      option to distribute your version of this file under either the
      CDDL, the GPL Version 2 or to extend the choice of license to its
      licensees as provided above.  However, if you add GPL Version 2
      code and therefore, elected the GPL Version 2 license, then the
      option applies only if the new code is made subject to such
      option by the copyright holder.
      
    </xsd:documentation>
  </xsd:annotation>

  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[[
      This is the XML Schema for the application client 6
      deployment descriptor.  The deployment descriptor must
      be named "META-INF/application-client.xml" in the
      application client's jar file.  All application client
      deployment descriptors must indicate the application
      client schema by using the Java EE namespace:
      
      http://java.sun.com/xml/ns/javaee
      
      and indicate the version of the schema by
      using the version element as shown below:
      
      <application-client xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
      	http://java.sun.com/xml/ns/javaee/application-client_6.xsd"
      version="6">
      ...
      </application-client>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://java.sun.com/xml/ns/javaee/application-client_6.xsd
      
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

  <xsd:include schemaLocation="javaee_6.xsd"/>


<!-- **************************************************** -->

  <xsd:element name="application-client"
               type="javaee:application-clientType">
    <xsd:annotation>
      <xsd:documentation>

        The application-client element is the root element of an
        application client deployment descriptor.  The application
        client deployment descriptor describes the EJB components
        and external resources referenced by the application
        client.
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:unique name="env-entry-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The env-entry-name element contains the name of an
          application client's environment entry.  The name is a JNDI
          name relative to the java:comp/env context.  The name must
          be unique within an application client.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:env-entry"/>
      <xsd:field xpath="javaee:env-entry-name"/>
    </xsd:unique>
    <xsd:unique name="ejb-ref-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The ejb-ref-name element contains the name of an EJB
          reference. The EJB reference is an entry in the application
          client's environment and is relative to the
          java:comp/env context. The name must be unique within the
          application client.
          
          It is recommended that name is prefixed with "ejb/".
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:ejb-ref"/>
      <xsd:field xpath="javaee:ejb-ref-name"/>
    </xsd:unique>
    <xsd:unique name="res-ref-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The res-ref-name element specifies the name of a
          resource manager connection factory reference.The name
          is a JNDI name relative to the java:comp/env context.
          The name must be unique within an application client.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:resource-ref"/>
      <xsd:field xpath="javaee:res-ref-name"/>
    </xsd:unique>
    <xsd:unique name="resource-env-ref-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The resource-env-ref-name element specifies the name of
          a resource environment reference; its value is the
          environment entry name used in the application client
          code. The name is a JNDI name relative to the
          java:comp/env context and must be unique within an
          application client.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:resource-env-ref"/>
      <xsd:field xpath="javaee:resource-env-ref-name"/>
    </xsd:unique>
    <xsd:unique name="message-destination-ref-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The message-destination-ref-name element specifies the
          name of a message destination reference; its value is
          the message destination reference name used in the
          application client code. The name is a JNDI name
          relative to the java:comp/env context and must be unique
          within an application client.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:message-destination-ref"/>
      <xsd:field xpath="javaee:message-destination-ref-name"/>
    </xsd:unique>
  </xsd:element>


<!-- **************************************************** -->

  <xsd:complexType name="application-clientType">
    <xsd:sequence>
      <xsd:element name="module-name"
                   type="javaee:string"
                   minOccurs="0"/>
      <xsd:group ref="javaee:descriptionGroup"/>
      <xsd:element name="env-entry"
                   type="javaee:env-entryType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="ejb-ref"
                   type="javaee:ejb-refType"
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
      <xsd:element name="persistence-unit-ref"
                   type="javaee:persistence-unit-refType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="post-construct"
                   type="javaee:lifecycle-callbackType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="pre-destroy"
                   type="javaee:lifecycle-callbackType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="callback-handler"
                   type="javaee:fully-qualified-classType"
                   minOccurs="0">
        <xsd:annotation>
          <xsd:documentation>

            The callback-handler element names a class provided by
            the application.  The class must have a no args
            constructor and must implement the
            javax.security.auth.callback.CallbackHandler
            interface.  The class will be instantiated by the
            application client container and used by the container
            to collect authentication information from the user.
            
          </xsd:documentation>
        </xsd:annotation>
      </xsd:element>
      <xsd:element name="message-destination"
                   type="javaee:message-destinationType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
      <xsd:element name="data-source"
                   type="javaee:data-sourceType"
                   minOccurs="0"
                   maxOccurs="unbounded"/>
    </xsd:sequence>
    <xsd:attribute name="version"
                   type="javaee:dewey-versionType"
                   fixed="6"
                   use="required">
      <xsd:annotation>
        <xsd:documentation>

          The required value for the version is 6.
          
        </xsd:documentation>
      </xsd:annotation>
    </xsd:attribute>
    <xsd:attribute name="metadata-complete"
                   type="xsd:boolean">
      <xsd:annotation>
        <xsd:documentation>

          The metadata-complete attribute defines whether this
          deployment descriptor and other related deployment
          descriptors for this module (e.g., web service
          descriptors) are complete, or whether the class
          files available to this module and packaged with
          this application should be examined for annotations
          that specify deployment information.
          
          If metadata-complete is set to "true", the deployment
          tool must ignore any annotations that specify deployment
          information, which might be present in the class files
          of the application.
          
          If metadata-complete is not specified or is set to
          "false", the deployment tool must examine the class
          files of the application for annotations, as
          specified by the specifications.
          
        </xsd:documentation>
      </xsd:annotation>
    </xsd:attribute>
    <xsd:attribute name="id"
                   type="xsd:ID"/>
  </xsd:complexType>

</xsd:schema>

*/
