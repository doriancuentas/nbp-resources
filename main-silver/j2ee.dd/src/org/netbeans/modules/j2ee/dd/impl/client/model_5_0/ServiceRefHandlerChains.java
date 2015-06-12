/**
 *	This generated bean class ServiceRefHandlerChains matches the schema element 'service-ref_handler-chainsType'.
 *  The root bean class is ApplicationClient
 *
 *	===============================================================
 *	
 *	
 *	      The handler-chains element defines the handlerchains associated with this
 *	      service or service endpoint.
 *	
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.client.model_5_0;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class ServiceRefHandlerChains extends org.netbeans.modules.schema2beans.BaseBean
	 implements org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChains
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String HANDLER_CHAIN = "HandlerChain";	// NOI18N

	public ServiceRefHandlerChains() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public ServiceRefHandlerChains(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(1);
		this.createProperty("handler-chain", 	// NOI18N
			HANDLER_CHAIN, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			ServiceRefHandlerChainType.class);
		this.createAttribute(HANDLER_CHAIN, "id", "Id", 
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
	public void setHandlerChain(int index, org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain valueInterface) {
		ServiceRefHandlerChainType value = (ServiceRefHandlerChainType) valueInterface;
		this.setValue(HANDLER_CHAIN, index, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain getHandlerChain(int index) {
		return (ServiceRefHandlerChainType)this.getValue(HANDLER_CHAIN, index);
	}

	// Return the number of properties
	public int sizeHandlerChain() {
		return this.size(HANDLER_CHAIN);
	}

	// This attribute is an array, possibly empty
	public void setHandlerChain(org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain[] value) {
		this.setValue(HANDLER_CHAIN, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain[] getHandlerChain() {
		return (ServiceRefHandlerChainType[])this.getValues(HANDLER_CHAIN);
	}

	// Add a new element returning its index in the list
	public int addHandlerChain(org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain valueInterface) {
		ServiceRefHandlerChainType value = (ServiceRefHandlerChainType) valueInterface;
		int positionOfNewItem = this.addValue(HANDLER_CHAIN, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeHandlerChain(org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain valueInterface) {
		ServiceRefHandlerChainType value = (ServiceRefHandlerChainType) valueInterface;
		return this.removeValue(HANDLER_CHAIN, value);
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandlerChain newServiceRefHandlerChain() {
		return new ServiceRefHandlerChainType();
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
		// Validating property handlerChain
		for (int _index = 0; _index < sizeHandlerChain(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.client.model_5_0.ServiceRefHandlerChainType element = (org.netbeans.modules.j2ee.dd.impl.client.model_5_0.ServiceRefHandlerChainType) getHandlerChain(_index);
			if (element != null) {
				((ServiceRefHandlerChainType)element).validate();
			}
		}
	}

	// Dump the content of this bean returning it as a String
	public void dump(StringBuffer str, String indent){
		String s;
		Object o;
		org.netbeans.modules.schema2beans.BaseBean n;
		str.append(indent);
		str.append("HandlerChain["+this.sizeHandlerChain()+"]");	// NOI18N
		for(int i=0; i<this.sizeHandlerChain(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getHandlerChain(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(HANDLER_CHAIN, i, str, indent);
		}

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("ServiceRefHandlerChains\n");	// NOI18N
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
	    version="5">
  <xsd:annotation>
    <xsd:documentation>
      @(#)application-client_5.xsds	1.26 02/17/06
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

	This is the XML Schema for the application client 5
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
		http://java.sun.com/xml/ns/javaee/application-client_5.xsd"
	      version="5">
	      ...
	    </application-client>

	The instance documents may indicate the published version of
	the schema using the xsi:schemaLocation attribute for Java EE
	namespace with the following location:

	http://java.sun.com/xml/ns/javaee/application-client_5.xsd

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

  <xsd:include schemaLocation="javaee_5.xsd"/>


<!-- **************************************************** -->

  <xsd:element name="application-client" type="javaee:application-clientType">
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
      <xsd:field    xpath="javaee:env-entry-name"/>
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
      <xsd:field    xpath="javaee:ejb-ref-name"/>
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
      <xsd:field    xpath="javaee:res-ref-name"/>
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
      <xsd:field    xpath="javaee:resource-env-ref-name"/>
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
      <xsd:field    xpath="javaee:message-destination-ref-name"/>
    </xsd:unique>
  </xsd:element>

<!-- **************************************************** -->

  <xsd:complexType name="application-clientType">
    <xsd:sequence>
      <xsd:group ref="javaee:descriptionGroup"/>
      <xsd:element name="env-entry"
		   type="javaee:env-entryType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="ejb-ref"
		   type="javaee:ejb-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:group ref="javaee:service-refGroup"/>
      <xsd:element name="resource-ref"
		   type="javaee:resource-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="resource-env-ref"
		   type="javaee:resource-env-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="message-destination-ref"
		   type="javaee:message-destination-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="persistence-unit-ref"
		   type="javaee:persistence-unit-refType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="post-construct"
		   type="javaee:lifecycle-callbackType"
		   minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element name="pre-destroy"
		   type="javaee:lifecycle-callbackType"
		   minOccurs="0" maxOccurs="unbounded"/>
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
    </xsd:sequence>

    <xsd:attribute name="version"
		   type="javaee:dewey-versionType"
		   fixed="5"
		   use="required">
      <xsd:annotation>
	<xsd:documentation>

	  The required value for the version is 5.

	</xsd:documentation>
      </xsd:annotation>

    </xsd:attribute>

    <xsd:attribute name="metadata-complete" type="xsd:boolean">
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

    <xsd:attribute name="id" type="xsd:ID"/>
  </xsd:complexType>

</xsd:schema>


*/
