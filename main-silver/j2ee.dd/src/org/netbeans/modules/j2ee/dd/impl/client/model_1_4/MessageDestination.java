/**
 *	This generated bean class MessageDestination matches the schema element 'message-destinationType'.
 *  The root bean class is ApplicationClient
 *
 *	===============================================================
 *	
 *	
 *		This group keeps the usage of the contained description related
 *		elements consistent across J2EE deployment descriptors.
 *	
 *		All elements may occur multiple times with different languages,
 *		to support localization of the content.
 *	
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.client.model_1_4;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class MessageDestination extends org.netbeans.modules.j2ee.dd.impl.common.ComponentBeanMultiple
	 implements  
                org.netbeans.modules.j2ee.dd.api.common.MessageDestination, org.netbeans.modules.j2ee.dd.impl.common.KeyBean
            
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String DISPLAY_NAME = "DisplayName";	// NOI18N
	static public final String DISPLAYNAMEID = "DisplayNameId";	// NOI18N
	static public final String DISPLAYNAMEXMLLANG = "DisplayNameXmlLang";	// NOI18N
	static public final String ICON = "Icon";	// NOI18N
	static public final String MESSAGE_DESTINATION_NAME = "MessageDestinationName";	// NOI18N
	static public final String MESSAGEDESTINATIONNAMEID = "MessageDestinationNameId";	// NOI18N

	public MessageDestination() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public MessageDestination(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(4);
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
		this.createProperty("display-name", 	// NOI18N
			DISPLAY_NAME, 
			Common.TYPE_0_N | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(DISPLAY_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createAttribute(DISPLAY_NAME, "xml:lang", "XmlLang", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("icon", 	// NOI18N
			ICON, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			Icon.class);
		this.createAttribute(ICON, "xml:lang", "XmlLang", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createAttribute(ICON, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("message-destination-name", 	// NOI18N
			MESSAGE_DESTINATION_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(MESSAGE_DESTINATION_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
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

	// This attribute is an array, possibly empty
	public void setDisplayName(int index, java.lang.String value) {
		this.setValue(DISPLAY_NAME, index, value);
	}

	//
	public java.lang.String getDisplayName(int index) {
		return (java.lang.String)this.getValue(DISPLAY_NAME, index);
	}

	// Return the number of properties
	public int sizeDisplayName() {
		return this.size(DISPLAY_NAME);
	}

	// This attribute is an array, possibly empty
	public void setDisplayName(java.lang.String[] value) {
		this.setValue(DISPLAY_NAME, value);
	}

	//
	public java.lang.String[] getDisplayName() {
		return (java.lang.String[])this.getValues(DISPLAY_NAME);
	}

	// Add a new element returning its index in the list
	public int addDisplayName(java.lang.String value) {
		int positionOfNewItem = this.addValue(DISPLAY_NAME, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeDisplayName(java.lang.String value) {
		return this.removeValue(DISPLAY_NAME, value);
	}

	// This attribute is an array, possibly empty
	public void setDisplayNameId(int index, java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DISPLAY_NAME) == 0) {
			addValue(DISPLAY_NAME, "");
		}
		setAttributeValue(DISPLAY_NAME, index, "Id", value);
	}

	//
	public java.lang.String getDisplayNameId(int index) {
		// If our element does not exist, then the attribute does not exist.
		if (size(DISPLAY_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(DISPLAY_NAME, index, "Id");
		}
	}

	// Return the number of properties
	public int sizeDisplayNameId() {
		return this.size(DISPLAY_NAME);
	}

	// This attribute is an array, possibly empty
	public void setDisplayNameXmlLang(int index, java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DISPLAY_NAME) == 0) {
			addValue(DISPLAY_NAME, "");
		}
		setAttributeValue(DISPLAY_NAME, index, "XmlLang", value);
	}

	//
	public java.lang.String getDisplayNameXmlLang(int index) {
		// If our element does not exist, then the attribute does not exist.
		if (size(DISPLAY_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(DISPLAY_NAME, index, "XmlLang");
		}
	}

	// Return the number of properties
	public int sizeDisplayNameXmlLang() {
		return this.size(DISPLAY_NAME);
	}

	// This attribute is an array, possibly empty
	public void setIcon(int index,  
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                 valueInterface) {
		Icon value = (Icon) valueInterface;
		this.setValue(ICON, index, value);
	}

	//
	public  
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                 getIcon(int index) {
		return (Icon)this.getValue(ICON, index);
	}

	// Return the number of properties
	public int sizeIcon() {
		return this.size(ICON);
	}

	// This attribute is an array, possibly empty
	public void setIcon( 
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                [] value) {
		this.setValue(ICON, value);
	}

	//
	public  
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                [] getIcon() {
		return (Icon[])this.getValues(ICON);
	}

	// Add a new element returning its index in the list
	public int addIcon( 
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                 valueInterface) {
		Icon value = (Icon) valueInterface;
		int positionOfNewItem = this.addValue(ICON, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeIcon( 
                    org.netbeans.modules.j2ee.dd.api.common.Icon
                 valueInterface) {
		Icon value = (Icon) valueInterface;
		return this.removeValue(ICON, value);
	}

	// This attribute is mandatory
	public void setMessageDestinationName(java.lang.String value) {
		this.setValue(MESSAGE_DESTINATION_NAME, value);
	}

	//
	public java.lang.String getMessageDestinationName() {
		return (java.lang.String)this.getValue(MESSAGE_DESTINATION_NAME);
	}

	// This attribute is optional
	public void setMessageDestinationNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(MESSAGE_DESTINATION_NAME) == 0) {
			setValue(MESSAGE_DESTINATION_NAME, "");
		}
		setAttributeValue(MESSAGE_DESTINATION_NAME, "Id", value);
	}

	//
	public java.lang.String getMessageDestinationNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(MESSAGE_DESTINATION_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(MESSAGE_DESTINATION_NAME, "Id");
		}
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.common.Icon newIcon() {
		return new Icon();
	}

	//
	public static void addComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.add(c);
	}

	//
	public static void removeComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.remove(c);
	}

	
                public String getKeyProperty() { return "MessageDestinationName"; }
                public void setMappedName(String value) throws org.netbeans.modules.j2ee.dd.api.common.VersionNotSupportedException {
                    throw new org.netbeans.modules.j2ee.dd.api.common.VersionNotSupportedException(org.netbeans.modules.j2ee.dd.api.client.AppClient.VERSION_1_4);
                }
                public String getMappedName() throws org.netbeans.modules.j2ee.dd.api.common.VersionNotSupportedException {
                    throw new org.netbeans.modules.j2ee.dd.api.common.VersionNotSupportedException(org.netbeans.modules.j2ee.dd.api.client.AppClient.VERSION_1_4);
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
		// Validating property displayName
		for (int _index = 0; _index < sizeDisplayName(); ++_index) {
			java.lang.String element = getDisplayName(_index);
			if (element != null) {
				// has whitespace restriction
				if (restrictionFailure) {
					throw new org.netbeans.modules.schema2beans.ValidateException("element whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "displayName", this);	// NOI18N
				}
			}
		}
		// Validating property displayNameId
		// Validating property displayNameXmlLang
		// Validating property icon
		for (int _index = 0; _index < sizeIcon(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.client.model_1_4.Icon element = (org.netbeans.modules.j2ee.dd.impl.client.model_1_4.Icon) getIcon(_index);
			if (element != null) {
				((Icon)element).validate();
			}
		}
		// Validating property messageDestinationName
		if (getMessageDestinationName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getMessageDestinationName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "messageDestinationName", this);	// NOI18N
		}
		// has whitespace restriction
		if (restrictionFailure) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getMessageDestinationName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "messageDestinationName", this);	// NOI18N
		}
		// Validating property messageDestinationNameId
		if (getMessageDestinationNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMessageDestinationNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "messageDestinationNameId", this);	// NOI18N
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
		str.append("DisplayName["+this.sizeDisplayName()+"]");	// NOI18N
		for(int i=0; i<this.sizeDisplayName(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			str.append(indent+"\t");	// NOI18N
			str.append("<");	// NOI18N
			o = this.getDisplayName(i);
			str.append((o==null?"null":o.toString().trim()));	// NOI18N
			str.append(">\n");	// NOI18N
			this.dumpAttributes(DISPLAY_NAME, i, str, indent);
		}

		str.append(indent);
		str.append("Icon["+this.sizeIcon()+"]");	// NOI18N
		for(int i=0; i<this.sizeIcon(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getIcon(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(ICON, i, str, indent);
		}

		str.append(indent);
		str.append("MessageDestinationName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMessageDestinationName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MESSAGE_DESTINATION_NAME, 0, str, indent);

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("MessageDestination\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N


/*
		The following schema file has been used for generation:

<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns="http://www.w3.org/2001/XMLSchema"
	    targetNamespace="http://java.sun.com/xml/ns/j2ee"
	    xmlns:j2ee="http://java.sun.com/xml/ns/j2ee"
	    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	    elementFormDefault="qualified"
	    attributeFormDefault="unqualified"
	    version="1.4">
  <xsd:annotation>
    <xsd:documentation>
      @(#)application-client_1_4.xsds	1.17 02/11/03
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
      <![CDATA[

	This is the XML Schema for the application client 1.4
	deployment descriptor.  The deployment descriptor must
	be named "META-INF/application-client.xml" in the
	application client's jar file.  All application client
	deployment descriptors must indicate the application
	client schema by using the J2EE namespace:

	http://java.sun.com/xml/ns/j2ee

	and indicate the version of the schema by
	using the version element as shown below:

	    <application-client xmlns="http://java.sun.com/xml/ns/j2ee"
	      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	      xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
		http://java.sun.com/xml/ns/j2ee/application-client_1_4.xsd"
	      version="1.4">
	      ...
	    </application-client>

	The instance documents may indicate the published version of
	the schema using the xsi:schemaLocation attribute for J2EE
	namespace with the following location:

	http://java.sun.com/xml/ns/j2ee/application-client_1_4.xsd

	]]>
    </xsd:documentation>
  </xsd:annotation>

  <xsd:annotation>
    <xsd:documentation>

      The following conventions apply to all J2EE
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

  <xsd:include schemaLocation="j2ee_1_4.xsd"/>


<!-- **************************************************** -->


  <xsd:element name="application-client" type="j2ee:application-clientType">
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
      <xsd:selector xpath="j2ee:env-entry"/>
      <xsd:field    xpath="j2ee:env-entry-name"/>
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
      <xsd:selector xpath="j2ee:ejb-ref"/>
      <xsd:field    xpath="j2ee:ejb-ref-name"/>
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
      <xsd:selector xpath="j2ee:resource-ref"/>
      <xsd:field    xpath="j2ee:res-ref-name"/>
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
      <xsd:selector xpath="j2ee:resource-env-ref"/>
      <xsd:field    xpath="j2ee:resource-env-ref-name"/>
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
      <xsd:selector xpath="j2ee:message-destination-ref"/>
      <xsd:field    xpath="j2ee:message-destination-ref-name"/>
    </xsd:unique>
  </xsd:element>

<!-- **************************************************** -->

  <xsd:complexType name="application-clientType">
    <xsd:sequence>
      <xsd:group ref="j2ee:descriptionGroup"/>
      <xsd:element name="env-entry"
		   type="j2ee:env-entryType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="ejb-ref"
		   type="j2ee:ejb-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:group ref="j2ee:service-refGroup"/>
      <xsd:element name="resource-ref"
		   type="j2ee:resource-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="resource-env-ref"
		   type="j2ee:resource-env-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="message-destination-ref"
		   type="j2ee:message-destination-refType"
		   minOccurs="0"
		   maxOccurs="unbounded"/>
      <xsd:element name="callback-handler"
		   type="j2ee:fully-qualified-classType"
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
		   type="j2ee:message-destinationType"
		   minOccurs="0"
		   maxOccurs="unbounded"/>
    </xsd:sequence>

    <xsd:attribute name="version"
		   type="j2ee:dewey-versionType"
		   fixed="1.4"
		   use="required">
      <xsd:annotation>
	<xsd:documentation>

	  The required value for the version is 1.4.

	</xsd:documentation>
      </xsd:annotation>

    </xsd:attribute>
    <xsd:attribute name="id" type="xsd:ID"/>
  </xsd:complexType>

</xsd:schema>


*/
