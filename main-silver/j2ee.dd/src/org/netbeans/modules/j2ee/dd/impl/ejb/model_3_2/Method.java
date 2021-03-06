/**
 *	This generated bean class Method matches the schema element 'methodType'.
 *  The root bean class is EjbJar
 *
 *	===============================================================
 *	
 *	        [
 *	        The methodType is used to denote a method of an enterprise
 *	        bean.  The method may be any of the following or a set of
 *	        any of the following methods may be designated:
 *	        business interface method
 *	        home interface method
 *	        component interface method
 *	        web service endpoint interface method
 *	        no-interface view method
 *	        singleton session bean lifecycle callback method
 *	        stateful session bean lifecycle callback method (see 
 *	        limitations)
 *	        timeout callback method
 *	        message-driven bean message listener method
 *	        
 *	        The ejb-name element must be the name of one of the enterprise 
 *	        beans declared in the deployment descriptor.
 *	        The optional method-intf element allows distinguishing between a
 *	        method with the same signature that is multiply defined
 *	        across any of the above.
 *	        The method-name element specifies the method name.
 *	        The optional method-params elements identify a single method 
 *	        among multiple methods with an overloaded method name.
 *	        
 *	        There are three possible styles of using methodType element
 *	        within a method element:
 *	        
 *	        1.
 *	        <method>
 *	        <ejb-name>EJBNAME</ejb-name>
 *	        <method-name>*</method-name>
 *	        </method>
 *	        
 *	        This style is used to refer to all of the following methods 
 *	        of the specified enterprise bean:
 *	        business interface methods
 *	        home interface methods
 *	        component interface methods
 *	        web service endpoint interface methods
 *	        no-interface view methods
 *	        singleton session bean lifecycle callback methods
 *	        timeout callback methods
 *	        message-driven bean message listener method
 *	        
 *	        This style may also be used in combination with the 
 *	        method-intf element that contains LifecycleCallback as 
 *	        the value to specify transaction attributes of a stateful 
 *	        session bean PostConstruct, PreDestroy, PrePassivate, 
 *	        and PostActivate lifecycle callback methods or to override 
 *	        transaction attributes of a singleton session bean 
 *	        PostConstruct and PreDestroy lifecycle callback methods.
 *	        
 *	        2.
 *	        <method>
 *	        <ejb-name>EJBNAME</ejb-name>
 *	        <method-name>METHOD</method-name>
 *	        </method>
 *	        
 *	        This style is used to refer to the specified method of
 *	        the specified enterprise bean. If there are multiple
 *	        methods with the same overloaded name, the element of
 *	        this style refers to all the methods with the overloaded
 *	        name.
 *	        
 *	        This style may be used to refer to stateful session bean
 *	        PostConstruct, PreDestroy, PrePassivate, and PostActivate 
 *	        lifecycle callback methods to specify their transaction
 *	        attributes if any of the following is true:
 *	        there is only one method with this name in the specified 
 *	        enterprise bean
 *	        all overloaded methods with this name in the specified 
 *	        enterprise bean are lifecycle callback methods
 *	        method-intf element is specified and it contains 
 *	        LifecycleCallback as the value 
 *	        
 *	        3.
 *	        <method>
 *	        <ejb-name>EJBNAME</ejb-name>
 *	        <method-name>METHOD</method-name>
 *	        <method-params>
 *	        	  <method-param>PARAM-1</method-param>
 *	        	  <method-param>PARAM-2</method-param>
 *	        	  ...
 *	        	  <method-param>PARAM-n</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        This style is used to refer to a single method within a
 *	        set of methods with an overloaded name. PARAM-1 through
 *	        PARAM-n are the fully-qualified Java types of the
 *	        method's input parameters (if the method has no input
 *	        arguments, the method-params element contains no
 *	        method-param elements). Arrays are specified by the
 *	        array element's type, followed by one or more pair of
 *	        square brackets (e.g. int[][]). 
 *	        If a method with the same name and signature is defined 
 *	        on more than one interface of an enterprise bean, this 
 *	        style refers to all those methods. 
 *	        
 *	        Examples:
 *	        
 *	        Style 1: The following method element refers to all of the
 *	        following methods of the EmployeeService bean:
 *	        no interface view methods
 *	        business interface methods   
 *	        home interface methods   
 *	        component business interface methods   
 *	        singleton session bean lifecycle callback methods, if any
 *	        timeout callback methods
 *	        web service endpoint interface methods
 *	        message-driven bean message listener methods (if the bean
 *	        a message-driven bean)
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-name>*</method-name>
 *	        </method>
 *	        
 *	        Style 2: The following method element refers to all the
 *	        create methods of the EmployeeService bean's home
 *	        interface(s).
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-name>create</method-name>
 *	        </method>
 *	        
 *	        Style 3: The following method element refers to the
 *	        create(String firstName, String LastName) method of the
 *	        EmployeeService bean's home interface(s).
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-name>create</method-name>
 *	        <method-params>
 *	        	  <method-param>java.lang.String</method-param>
 *	        	  <method-param>java.lang.String</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        The following example illustrates a Style 3 element with
 *	        more complex parameter types. The method 
 *	        foobar(char s, int i, int[] iar, mypackage.MyClass mycl, 
 *	        mypackage.MyClass[][] myclaar) would be specified as:
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-name>foobar</method-name>
 *	        <method-params>
 *	        	  <method-param>char</method-param>
 *	        	  <method-param>int</method-param>
 *	        	  <method-param>int[]</method-param>
 *	        	  <method-param>mypackage.MyClass</method-param>
 *	        	  <method-param>mypackage.MyClass[][]</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        The optional method-intf element can be used when it becomes
 *	        necessary to differentiate between a method that is defined
 *	        multiple times with the same name and signature across any
 *	        of the following methods of an enterprise bean:
 *	        business interface methods
 *	        home interface methods
 *	        component interface methods
 *	        web service endpoint methods
 *	        no-interface view methods
 *	        singleton or stateful session bean lifecycle callback methods
 *	        timeout callback methods
 *	        message-driven bean message listener methods
 *	        
 *	        However, if the same method is a method of both the local 
 *	        business interface, and the local component interface, 
 *	        the same attribute applies to the method for both interfaces.
 *	        Likewise, if the same method is a method of both the remote 
 *	        business interface and the remote component interface, the same
 *	        attribute applies to the method for both interfaces.
 *	        
 *	        For example, the method element
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-intf>Remote</method-intf>
 *	        <method-name>create</method-name>
 *	        <method-params>
 *	        	  <method-param>java.lang.String</method-param>
 *	        	  <method-param>java.lang.String</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        can be used to differentiate the create(String, String)
 *	        method defined in the remote interface from the
 *	        create(String, String) method defined in the remote home
 *	        interface, which would be defined as
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-intf>Home</method-intf>
 *	        <method-name>create</method-name>
 *	        <method-params>
 *	        	  <method-param>java.lang.String</method-param>
 *	        	  <method-param>java.lang.String</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        and the create method that is defined in the local home
 *	        interface which would be defined as
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-intf>LocalHome</method-intf>
 *	        <method-name>create</method-name>
 *	        <method-params>
 *	        	  <method-param>java.lang.String</method-param>
 *	        	  <method-param>java.lang.String</method-param>
 *	        </method-params>
 *	        </method>
 *	        
 *	        The method-intf element can be used with all three Styles
 *	        of the method element usage. For example, the following
 *	        method element example could be used to refer to all the
 *	        methods of the EmployeeService bean's remote home interface
 *	        and the remote business interface.
 *	        
 *	        <method>
 *	        <ejb-name>EmployeeService</ejb-name>
 *	        <method-intf>Home</method-intf>
 *	        <method-name>*</method-name>
 *	        </method>
 *	        
 *	        
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.ejb.model_3_2;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class Method extends org.netbeans.modules.j2ee.dd.impl.common.DescriptionBeanMultiple
	 implements org.netbeans.modules.j2ee.dd.api.ejb.Method
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String EJB_NAME = "EjbName";	// NOI18N
	static public final String METHOD_INTF = "MethodIntf";	// NOI18N
	static public final String METHOD_NAME = "MethodName";	// NOI18N
	static public final String METHOD_PARAMS = "MethodParams";	// NOI18N

	public Method() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public Method(int options)
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
		this.createProperty("ejb-name", 	// NOI18N
			EJB_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("method-intf", 	// NOI18N
			METHOD_INTF, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("method-name", 	// NOI18N
			METHOD_NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("method-params", 	// NOI18N
			METHOD_PARAMS, 
			Common.TYPE_0_1 | Common.TYPE_BEAN | Common.TYPE_KEY, 
			MethodParams.class);
		this.createAttribute(METHOD_PARAMS, "id", "Id", 
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

	// This attribute is mandatory
	public void setEjbName(java.lang.String value) {
		this.setValue(EJB_NAME, value);
	}

	//
	public java.lang.String getEjbName() {
		return (java.lang.String)this.getValue(EJB_NAME);
	}

	// This attribute is optional
	public void setMethodIntf(java.lang.String value) {
		this.setValue(METHOD_INTF, value);
	}

	//
	public java.lang.String getMethodIntf() {
		return (java.lang.String)this.getValue(METHOD_INTF);
	}

	// This attribute is mandatory
	public void setMethodName(java.lang.String value) {
		this.setValue(METHOD_NAME, value);
	}

	//
	public java.lang.String getMethodName() {
		return (java.lang.String)this.getValue(METHOD_NAME);
	}

	// This attribute is optional
	public void setMethodParams(org.netbeans.modules.j2ee.dd.api.ejb.MethodParams valueInterface) {
		MethodParams value = (MethodParams) valueInterface;
		this.setValue(METHOD_PARAMS, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.MethodParams getMethodParams() {
		return (MethodParams)this.getValue(METHOD_PARAMS);
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.ejb.MethodParams newMethodParams() {
		return new MethodParams();
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
		// Validating property ejbName
		if (getEjbName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getEjbName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "ejbName", this);	// NOI18N
		}
		// Validating property methodIntf
		if (getMethodIntf() != null) {
			final java.lang.String[] enumRestrictionMethodIntf = {"Home", "Remote", "LocalHome", "Local", "ServiceEndpoint", "Timer", "MessageEndpoint", "LifecycleCallback"};
			restrictionFailure = true;
			for (int _index2 = 0; 
				_index2 < enumRestrictionMethodIntf.length; ++_index2) {
				if (enumRestrictionMethodIntf[_index2].equals(getMethodIntf())) {
					restrictionFailure = false;
					break;
				}
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMethodIntf() enumeration test", org.netbeans.modules.schema2beans.ValidateException.FailureType.ENUM_RESTRICTION, "methodIntf", this);	// NOI18N
			}
		}
		// Validating property methodName
		if (getMethodName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getMethodName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "methodName", this);	// NOI18N
		}
		// Validating property methodParams
		if (getMethodParams() != null) {
			((MethodParams)getMethodParams()).validate();
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
		str.append("EjbName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getEjbName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(EJB_NAME, 0, str, indent);

		str.append(indent);
		str.append("MethodIntf");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMethodIntf();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(METHOD_INTF, 0, str, indent);

		str.append(indent);
		str.append("MethodName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMethodName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(METHOD_NAME, 0, str, indent);

		str.append(indent);
		str.append("MethodParams");	// NOI18N
		n = (org.netbeans.modules.schema2beans.BaseBean) this.getMethodParams();
		if (n != null)
			n.dump(str, indent + "\t");	// NOI18N
		else
			str.append(indent+"\tnull");	// NOI18N
		this.dumpAttributes(METHOD_PARAMS, 0, str, indent);

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("Method\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N

