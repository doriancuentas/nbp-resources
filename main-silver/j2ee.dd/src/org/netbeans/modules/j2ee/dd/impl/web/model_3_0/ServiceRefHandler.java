/**
 *	This generated bean class ServiceRefHandler matches the schema element 'handlerType'.
 *  The root bean class is WebApp
 *
 *	===============================================================
 *	
 *	
 *	        This group keeps the usage of the contained description related
 *	        elements consistent across Java EE deployment descriptors.
 *	        
 *	        All elements may occur multiple times with different languages,
 *	        to support localization of the content.
 *	        
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.web.model_3_0;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class ServiceRefHandler extends org.netbeans.modules.j2ee.dd.impl.common.ComponentBeanMultiple
	 implements 
                org.netbeans.modules.j2ee.dd.api.common.ServiceRefHandler, org.netbeans.modules.j2ee.dd.impl.common.KeyBean
            
{

	static Vector comparators = new Vector();
	static{
		ServiceRefHandler.addComparator(new org.netbeans.modules.j2ee.dd.impl.common.Comparator());
	}
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
	static public final String HANDLER_NAME = "HandlerName";	// NOI18N
	static public final String HANDLERNAMEID = "HandlerNameId";	// NOI18N
	static public final String HANDLER_CLASS = "HandlerClass";	// NOI18N
	static public final String INIT_PARAM = "InitParam";	// NOI18N
	static public final String SOAP_HEADER = "SoapHeader";	// NOI18N
	static public final String SOAPHEADERID = "SoapHeaderId";	// NOI18N
	static public final String SOAP_ROLE = "SoapRole";	// NOI18N
	static public final String SOAPROLEID = "SoapRoleId";	// NOI18N
	static public final String PORT_NAME = "PortName";	// NOI18N
	static public final String PORTNAMEID = "PortNameId";	// NOI18N

	public ServiceRefHandler() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public ServiceRefHandler(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(9);
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
		this.createProperty("handler-name", 	// NOI18N
			HANDLER_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(HANDLER_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("handler-class", 	// NOI18N
			HANDLER_CLASS, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("init-param", 	// NOI18N
			INIT_PARAM, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			InitParam.class);
		this.createAttribute(INIT_PARAM, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("soap-header", 	// NOI18N
			SOAP_HEADER, 
			Common.TYPE_0_N | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(SOAP_HEADER, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("soap-role", 	// NOI18N
			SOAP_ROLE, 
			Common.TYPE_0_N | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(SOAP_ROLE, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("port-name", 	// NOI18N
			PORT_NAME, 
			Common.TYPE_0_N | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(PORT_NAME, "id", "Id", 
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
	public void setHandlerName(java.lang.String value) {
		this.setValue(HANDLER_NAME, value);
	}

	//
	public java.lang.String getHandlerName() {
		return (java.lang.String)this.getValue(HANDLER_NAME);
	}

	// This attribute is optional
	public void setHandlerNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(HANDLER_NAME) == 0) {
			setValue(HANDLER_NAME, "");
		}
		setAttributeValue(HANDLER_NAME, "Id", value);
	}

	//
	public java.lang.String getHandlerNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(HANDLER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(HANDLER_NAME, "Id");
		}
	}

	// This attribute is mandatory
	public void setHandlerClass(java.lang.String value) {
		this.setValue(HANDLER_CLASS, value);
	}

	//
	public java.lang.String getHandlerClass() {
		return (java.lang.String)this.getValue(HANDLER_CLASS);
	}

	// This attribute is an array, possibly empty
	public void setInitParam(int index,  
                    org.netbeans.modules.j2ee.dd.api.common.InitParam valueInterface) {
		InitParam value = (InitParam) valueInterface;
		this.setValue(INIT_PARAM, index, value);
	}

	//
	public  
                    org.netbeans.modules.j2ee.dd.api.common.InitParam getInitParam(int index) {
		return (InitParam)this.getValue(INIT_PARAM, index);
	}

	// Return the number of properties
	public int sizeInitParam() {
		return this.size(INIT_PARAM);
	}

	// This attribute is an array, possibly empty
	public void setInitParam( 
                    org.netbeans.modules.j2ee.dd.api.common.InitParam[] value) {
		this.setValue(INIT_PARAM, value);
	}

	//
	public  
                    org.netbeans.modules.j2ee.dd.api.common.InitParam[] getInitParam() {
		return (InitParam[])this.getValues(INIT_PARAM);
	}

	// Add a new element returning its index in the list
	public int addInitParam( 
                    org.netbeans.modules.j2ee.dd.api.common.InitParam valueInterface) {
		InitParam value = (InitParam) valueInterface;
		int positionOfNewItem = this.addValue(INIT_PARAM, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeInitParam( 
                    org.netbeans.modules.j2ee.dd.api.common.InitParam valueInterface) {
		InitParam value = (InitParam) valueInterface;
		return this.removeValue(INIT_PARAM, value);
	}

	// This attribute is an array, possibly empty
	public void setSoapHeader(int index, java.lang.String value) {
		this.setValue(SOAP_HEADER, index, value);
	}

	//
	public java.lang.String getSoapHeader(int index) {
		return (java.lang.String)this.getValue(SOAP_HEADER, index);
	}

	// Return the number of properties
	public int sizeSoapHeader() {
		return this.size(SOAP_HEADER);
	}

	// This attribute is an array, possibly empty
	public void setSoapHeader(java.lang.String[] value) {
		this.setValue(SOAP_HEADER, value);
	}

	//
	public java.lang.String[] getSoapHeader() {
		return (java.lang.String[])this.getValues(SOAP_HEADER);
	}

	// Add a new element returning its index in the list
	public int addSoapHeader(java.lang.String value) {
		int positionOfNewItem = this.addValue(SOAP_HEADER, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeSoapHeader(java.lang.String value) {
		return this.removeValue(SOAP_HEADER, value);
	}

	// This attribute is an array, possibly empty
	public void setSoapHeaderId(int index, java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(SOAP_HEADER) == 0) {
			addValue(SOAP_HEADER, "");
		}
		setAttributeValue(SOAP_HEADER, index, "Id", value);
	}

	//
	public java.lang.String getSoapHeaderId(int index) {
		// If our element does not exist, then the attribute does not exist.
		if (size(SOAP_HEADER) == 0) {
			return null;
		} else {
			return getAttributeValue(SOAP_HEADER, index, "Id");
		}
	}

	// Return the number of properties
	public int sizeSoapHeaderId() {
		return this.size(SOAP_HEADER);
	}

	// This attribute is an array, possibly empty
	public void setSoapRole(int index, java.lang.String value) {
		this.setValue(SOAP_ROLE, index, value);
	}

	//
	public java.lang.String getSoapRole(int index) {
		return (java.lang.String)this.getValue(SOAP_ROLE, index);
	}

	// Return the number of properties
	public int sizeSoapRole() {
		return this.size(SOAP_ROLE);
	}

	// This attribute is an array, possibly empty
	public void setSoapRole(java.lang.String[] value) {
		this.setValue(SOAP_ROLE, value);
	}

	//
	public java.lang.String[] getSoapRole() {
		return (java.lang.String[])this.getValues(SOAP_ROLE);
	}

	// Add a new element returning its index in the list
	public int addSoapRole(java.lang.String value) {
		int positionOfNewItem = this.addValue(SOAP_ROLE, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeSoapRole(java.lang.String value) {
		return this.removeValue(SOAP_ROLE, value);
	}

	// This attribute is optional
	public void setSoapRoleId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(HANDLER_NAME) == 0) {
			setValue(HANDLER_NAME, "");
		}
		setAttributeValue(HANDLER_NAME, "Id", value);
	}

	//
	public java.lang.String getSoapRoleId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(HANDLER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(HANDLER_NAME, "Id");
		}
	}

	// This attribute is an array, possibly empty
	public void setPortName(int index, java.lang.String value) {
		this.setValue(PORT_NAME, index, value);
	}

	//
	public java.lang.String getPortName(int index) {
		return (java.lang.String)this.getValue(PORT_NAME, index);
	}

	// Return the number of properties
	public int sizePortName() {
		return this.size(PORT_NAME);
	}

	// This attribute is an array, possibly empty
	public void setPortName(java.lang.String[] value) {
		this.setValue(PORT_NAME, value);
	}

	//
	public java.lang.String[] getPortName() {
		return (java.lang.String[])this.getValues(PORT_NAME);
	}

	// Add a new element returning its index in the list
	public int addPortName(java.lang.String value) {
		int positionOfNewItem = this.addValue(PORT_NAME, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removePortName(java.lang.String value) {
		return this.removeValue(PORT_NAME, value);
	}

	// This attribute is optional
	public void setPortNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(HANDLER_NAME) == 0) {
			setValue(HANDLER_NAME, "");
		}
		setAttributeValue(HANDLER_NAME, "Id", value);
	}

	//
	public java.lang.String getPortNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(HANDLER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(HANDLER_NAME, "Id");
		}
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.common.Icon newIcon() {
		return new Icon();
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.common.InitParam newInitParam() {
		return new InitParam();
	}

	//
	public static void addComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.add(c);
	}

	//
	public static void removeComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.remove(c);
	}

	
                public String getKeyProperty() { return "HandlerName"; }
            
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
			org.netbeans.modules.j2ee.dd.impl.web.model_3_0.Icon element = (org.netbeans.modules.j2ee.dd.impl.web.model_3_0.Icon) getIcon(_index);
			if (element != null) {
				((Icon)element).validate();
			}
		}
		// Validating property handlerName
		if (getHandlerName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getHandlerName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "handlerName", this);	// NOI18N
		}
		// has whitespace restriction
		if (restrictionFailure) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getHandlerName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "handlerName", this);	// NOI18N
		}
		// Validating property handlerNameId
		if (getHandlerNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getHandlerNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "handlerNameId", this);	// NOI18N
			}
		}
		// Validating property handlerClass
		if (getHandlerClass() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getHandlerClass() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "handlerClass", this);	// NOI18N
		}
		// Validating property initParam
		for (int _index = 0; _index < sizeInitParam(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.web.model_3_0.InitParam element = (org.netbeans.modules.j2ee.dd.impl.web.model_3_0.InitParam) getInitParam(_index);
			if (element != null) {
				((InitParam)element).validate();
			}
		}
		// Validating property soapHeader
		// Validating property soapHeaderId
		// Validating property soapRole
		for (int _index = 0; _index < sizeSoapRole(); ++_index) {
			java.lang.String element = getSoapRole(_index);
			if (element != null) {
				// has whitespace restriction
				if (restrictionFailure) {
					throw new org.netbeans.modules.schema2beans.ValidateException("element whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "soapRole", this);	// NOI18N
				}
			}
		}
		// Validating property soapRoleId
		if (getSoapRoleId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getSoapRoleId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "soapRoleId", this);	// NOI18N
			}
		}
		// Validating property portName
		for (int _index = 0; _index < sizePortName(); ++_index) {
			java.lang.String element = getPortName(_index);
			if (element != null) {
				// has whitespace restriction
				if (restrictionFailure) {
					throw new org.netbeans.modules.schema2beans.ValidateException("element whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "portName", this);	// NOI18N
				}
			}
		}
		// Validating property portNameId
		if (getPortNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPortNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "portNameId", this);	// NOI18N
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
		str.append("HandlerName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getHandlerName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(HANDLER_NAME, 0, str, indent);

		str.append(indent);
		str.append("HandlerClass");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getHandlerClass();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(HANDLER_CLASS, 0, str, indent);

		str.append(indent);
		str.append("InitParam["+this.sizeInitParam()+"]");	// NOI18N
		for(int i=0; i<this.sizeInitParam(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getInitParam(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(INIT_PARAM, i, str, indent);
		}

		str.append(indent);
		str.append("SoapHeader["+this.sizeSoapHeader()+"]");	// NOI18N
		for(int i=0; i<this.sizeSoapHeader(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			str.append(indent+"\t");	// NOI18N
			str.append("<");	// NOI18N
			o = this.getSoapHeader(i);
			str.append((o==null?"null":o.toString().trim()));	// NOI18N
			str.append(">\n");	// NOI18N
			this.dumpAttributes(SOAP_HEADER, i, str, indent);
		}

		str.append(indent);
		str.append("SoapRole["+this.sizeSoapRole()+"]");	// NOI18N
		for(int i=0; i<this.sizeSoapRole(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			str.append(indent+"\t");	// NOI18N
			str.append("<");	// NOI18N
			o = this.getSoapRole(i);
			str.append((o==null?"null":o.toString().trim()));	// NOI18N
			str.append(">\n");	// NOI18N
			this.dumpAttributes(SOAP_ROLE, i, str, indent);
		}

		str.append(indent);
		str.append("PortName["+this.sizePortName()+"]");	// NOI18N
		for(int i=0; i<this.sizePortName(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			str.append(indent+"\t");	// NOI18N
			str.append("<");	// NOI18N
			o = this.getPortName(i);
			str.append((o==null?"null":o.toString().trim()));	// NOI18N
			str.append(">\n");	// NOI18N
			this.dumpAttributes(PORT_NAME, i, str, indent);
		}

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("ServiceRefHandler\n");	// NOI18N
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
            version="3.0">
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
      This is the XML Schema for the Servlet 3.0 deployment descriptor.
      The deployment descriptor must be named "WEB-INF/web.xml" in the
      web application's war file.  All Servlet deployment descriptors
      must indicate the web application schema by using the Java EE
      namespace:
      
      http://java.sun.com/xml/ns/javaee 
      
      and by indicating the version of the schema by 
      using the version element as shown below: 
      
      <web-app xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="..."
      version="3.0"> 
      ...
      </web-app>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd
      
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

  <xsd:include schemaLocation="web-common_3_0.xsd"/>


<!-- **************************************************** -->

  <xsd:element name="web-app"
               type="javaee:web-appType">
    <xsd:annotation>
      <xsd:documentation>

        The web-app element is the root of the deployment
        descriptor for a web application.  Note that the sub-elements
        of this element can be in the arbitrary order. Because of
        that, the multiplicity of the elements of distributable,
        session-config, welcome-file-list, jsp-config, login-config,
        and locale-encoding-mapping-list was changed from "?" to "*"
        in this schema.  However, the deployment descriptor instance
        file must not contain multiple elements of session-config,
        jsp-config, and login-config. When there are multiple elements of
        welcome-file-list or locale-encoding-mapping-list, the container
        must concatenate the element contents.  The multiple occurence
        of the element distributable is redundant and the container
        treats that case exactly in the same way when there is only
        one distributable. 
        
      </xsd:documentation>
    </xsd:annotation>
    <xsd:unique name="web-common-servlet-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The servlet element contains the name of a servlet.
          The name must be unique within the web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:servlet"/>
      <xsd:field xpath="javaee:servlet-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-filter-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The filter element contains the name of a filter.
          The name must be unique within the web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:filter"/>
      <xsd:field xpath="javaee:filter-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-ejb-local-ref-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The ejb-local-ref-name element contains the name of an EJB
          reference. The EJB reference is an entry in the web
          application's environment and is relative to the
          java:comp/env context.  The name must be unique within
          the web application.
          
          It is recommended that name is prefixed with "ejb/".
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:ejb-local-ref"/>
      <xsd:field xpath="javaee:ejb-ref-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-ejb-ref-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The ejb-ref-name element contains the name of an EJB
          reference. The EJB reference is an entry in the web
          application's environment and is relative to the
          java:comp/env context.  The name must be unique within
          the web application.
          
          It is recommended that name is prefixed with "ejb/".
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:ejb-ref"/>
      <xsd:field xpath="javaee:ejb-ref-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-resource-env-ref-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The resource-env-ref-name element specifies the name of
          a resource environment reference; its value is the
          environment entry name used in the web application code.
          The name is a JNDI name relative to the java:comp/env
          context and must be unique within a web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:resource-env-ref"/>
      <xsd:field xpath="javaee:resource-env-ref-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-message-destination-ref-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The message-destination-ref-name element specifies the name of
          a message destination reference; its value is the
          environment entry name used in the web application code.
          The name is a JNDI name relative to the java:comp/env
          context and must be unique within a web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:message-destination-ref"/>
      <xsd:field xpath="javaee:message-destination-ref-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-res-ref-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The res-ref-name element specifies the name of a
          resource manager connection factory reference.  The name
          is a JNDI name relative to the java:comp/env context.
          The name must be unique within a web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:resource-ref"/>
      <xsd:field xpath="javaee:res-ref-name"/>
    </xsd:unique>
    <xsd:unique name="web-common-env-entry-name-uniqueness">
      <xsd:annotation>
        <xsd:documentation>

          The env-entry-name element contains the name of a web
          application's environment entry.  The name is a JNDI
          name relative to the java:comp/env context.  The name
          must be unique within a web application.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:env-entry"/>
      <xsd:field xpath="javaee:env-entry-name"/>
    </xsd:unique>
    <xsd:key name="web-common-role-name-key">
      <xsd:annotation>
        <xsd:documentation>

          A role-name-key is specified to allow the references
          from the security-role-refs.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:security-role"/>
      <xsd:field xpath="javaee:role-name"/>
    </xsd:key>
    <xsd:keyref name="web-common-role-name-references"
                refer="javaee:web-common-role-name-key">
      <xsd:annotation>
        <xsd:documentation>

          The keyref indicates the references from
          security-role-ref to a specified role-name.
          
        </xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:servlet/javaee:security-role-ref"/>
      <xsd:field xpath="javaee:role-link"/>
    </xsd:keyref>
  </xsd:element>

</xsd:schema>

*/
