/**
 *	This generated bean class EjbRef matches the schema element 'ejb-refType'.
 *  The root bean class is WebApp
 *
 *	===============================================================
 *	
 *	
 *		This group collects elements that are common to all the
 *		JNDI resource elements.
 *	
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.web.model_2_5;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class EjbRef extends org.netbeans.modules.j2ee.dd.impl.common.DescriptionBeanMultiple
	 implements  
                org.netbeans.modules.j2ee.dd.api.common.EjbRef, org.netbeans.modules.j2ee.dd.impl.common.KeyBean
            
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String EJB_REF_NAME = "EjbRefName";	// NOI18N
	static public final String EJB_REF_TYPE = "EjbRefType";	// NOI18N
	static public final String HOME = "Home";	// NOI18N
	static public final String REMOTE = "Remote";	// NOI18N
	static public final String EJB_LINK = "EjbLink";	// NOI18N
	static public final String MAPPED_NAME = "MappedName";	// NOI18N
	static public final String MAPPEDNAMEID = "MappedNameId";	// NOI18N
	static public final String INJECTION_TARGET = "InjectionTarget";	// NOI18N

	public EjbRef() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public EjbRef(int options)
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
		this.createProperty("ejb-ref-name", 	// NOI18N
			EJB_REF_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("ejb-ref-type", 	// NOI18N
			EJB_REF_TYPE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("home", 	// NOI18N
			HOME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("remote", 	// NOI18N
			REMOTE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("ejb-link", 	// NOI18N
			EJB_LINK, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
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
	public void setEjbRefName(java.lang.String value) {
		this.setValue(EJB_REF_NAME, value);
	}

	//
	public java.lang.String getEjbRefName() {
		return (java.lang.String)this.getValue(EJB_REF_NAME);
	}

	// This attribute is optional
	public void setEjbRefType(java.lang.String value) {
		this.setValue(EJB_REF_TYPE, value);
	}

	//
	public java.lang.String getEjbRefType() {
		return (java.lang.String)this.getValue(EJB_REF_TYPE);
	}

	// This attribute is optional
	public void setHome(java.lang.String value) {
		this.setValue(HOME, value);
	}

	//
	public java.lang.String getHome() {
		return (java.lang.String)this.getValue(HOME);
	}

	// This attribute is optional
	public void setRemote(java.lang.String value) {
		this.setValue(REMOTE, value);
	}

	//
	public java.lang.String getRemote() {
		return (java.lang.String)this.getValue(REMOTE);
	}

	// This attribute is optional
	public void setEjbLink(java.lang.String value) {
		this.setValue(EJB_LINK, value);
	}

	//
	public java.lang.String getEjbLink() {
		return (java.lang.String)this.getValue(EJB_LINK);
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

	
                public String getKeyProperty() { return "EjbRefName"; }
            
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
		// Validating property ejbRefName
		if (getEjbRefName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getEjbRefName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "ejbRefName", this);	// NOI18N
		}
		// Validating property ejbRefType
		if (getEjbRefType() != null) {
			final java.lang.String[] enumRestrictionEjbRefType = {"Entity", "Session"};
			restrictionFailure = true;
			for (int _index2 = 0; 
				_index2 < enumRestrictionEjbRefType.length; ++_index2) {
				if (enumRestrictionEjbRefType[_index2].equals(getEjbRefType())) {
					restrictionFailure = false;
					break;
				}
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getEjbRefType() enumeration test", org.netbeans.modules.schema2beans.ValidateException.FailureType.ENUM_RESTRICTION, "ejbRefType", this);	// NOI18N
			}
		}
		// Validating property home
		// Validating property remote
		// Validating property ejbLink
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
			org.netbeans.modules.j2ee.dd.impl.web.model_2_5.InjectionTarget element = (org.netbeans.modules.j2ee.dd.impl.web.model_2_5.InjectionTarget) getInjectionTarget(_index);
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
		str.append("EjbRefName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getEjbRefName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(EJB_REF_NAME, 0, str, indent);

		str.append(indent);
		str.append("EjbRefType");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getEjbRefType();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(EJB_REF_TYPE, 0, str, indent);

		str.append(indent);
		str.append("Home");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getHome();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(HOME, 0, str, indent);

		str.append(indent);
		str.append("Remote");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getRemote();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(REMOTE, 0, str, indent);

		str.append(indent);
		str.append("EjbLink");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getEjbLink();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(EJB_LINK, 0, str, indent);

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
		str.append("EjbRef\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N

