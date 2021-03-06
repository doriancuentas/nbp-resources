/**
 *	This generated bean class PersistenceContextRef matches the schema element 'persistence-context-refType'.
 *  The root bean class is EjbJar
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

package org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class PersistenceContextRef extends org.netbeans.modules.schema2beans.BaseBean
	 implements org.netbeans.modules.j2ee.dd.api.ejb.PersistenceContextRef
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
	static public final String PERSISTENCE_PROPERTY = "PersistenceProperty";	// NOI18N
	static public final String MAPPED_NAME = "MappedName";	// NOI18N
	static public final String MAPPEDNAMEID = "MappedNameId";	// NOI18N
	static public final String INJECTION_TARGET = "InjectionTarget";	// NOI18N

	public PersistenceContextRef() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public PersistenceContextRef(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(7);
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
		this.createProperty("persistence-property", 	// NOI18N
			PERSISTENCE_PROPERTY, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			Property.class);
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

	// This attribute is an array, possibly empty
	public void setPersistenceProperty(int index, org.netbeans.modules.j2ee.dd.api.ejb.Property valueInterface) {
		Property value = (Property) valueInterface;
		this.setValue(PERSISTENCE_PROPERTY, index, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.Property getPersistenceProperty(int index) {
		return (Property)this.getValue(PERSISTENCE_PROPERTY, index);
	}

	// Return the number of properties
	public int sizePersistenceProperty() {
		return this.size(PERSISTENCE_PROPERTY);
	}

	// This attribute is an array, possibly empty
	public void setPersistenceProperty(org.netbeans.modules.j2ee.dd.api.ejb.Property[] value) {
		this.setValue(PERSISTENCE_PROPERTY, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.Property[] getPersistenceProperty() {
		return (Property[])this.getValues(PERSISTENCE_PROPERTY);
	}

	// Add a new element returning its index in the list
	public int addPersistenceProperty(org.netbeans.modules.j2ee.dd.api.ejb.Property valueInterface) {
		Property value = (Property) valueInterface;
		int positionOfNewItem = this.addValue(PERSISTENCE_PROPERTY, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removePersistenceProperty(org.netbeans.modules.j2ee.dd.api.ejb.Property valueInterface) {
		Property value = (Property) valueInterface;
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
	public org.netbeans.modules.j2ee.dd.api.ejb.Property newProperty() {
		return new Property();
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
		// Validating property persistenceProperty
		for (int _index = 0; _index < sizePersistenceProperty(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.Property element = (org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.Property) getPersistenceProperty(_index);
			if (element != null) {
				((Property)element).validate();
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
			org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.InjectionTarget element = (org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.InjectionTarget) getInjectionTarget(_index);
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
		str.append("PersistenceContextRef\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N

