/**
 *	This generated bean class DataSourceType matches the schema element 'data-sourceType'.
 *  The root bean class is WebFragment
 *
 *	===============================================================
 *	
 *	
 *	        Configuration of a DataSource.
 *	        
 *	      
 *	===============================================================
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.web.model_3_0_frag;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;

// BEGIN_NOI18N

public class DataSourceType extends org.netbeans.modules.schema2beans.BaseBean
{

	static Vector comparators = new Vector();
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	;	// NOI18N

	static public final String ID = "Id";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String NAME = "Name";	// NOI18N
	static public final String CLASS_NAME = "ClassName";	// NOI18N
	static public final String SERVER_NAME = "ServerName";	// NOI18N
	static public final String SERVERNAMEID = "ServerNameId";	// NOI18N
	static public final String PORT_NUMBER = "PortNumber";	// NOI18N
	static public final String PORTNUMBERID = "PortNumberId";	// NOI18N
	static public final String DATABASE_NAME = "DatabaseName";	// NOI18N
	static public final String DATABASENAMEID = "DatabaseNameId";	// NOI18N
	static public final String URL = "Url";	// NOI18N
	static public final String USER = "User";	// NOI18N
	static public final String USERID = "UserId";	// NOI18N
	static public final String PASSWORD = "Password";	// NOI18N
	static public final String PASSWORDID = "PasswordId";	// NOI18N
	static public final String PROPERTY2 = "Property2";	// NOI18N
	static public final String LOGIN_TIMEOUT = "LoginTimeout";	// NOI18N
	static public final String LOGINTIMEOUTID = "LoginTimeoutId";	// NOI18N
	static public final String TRANSACTIONAL = "Transactional";	// NOI18N
	static public final String TRANSACTIONALID = "TransactionalId";	// NOI18N
	static public final String ISOLATION_LEVEL = "IsolationLevel";	// NOI18N
	static public final String INITIAL_POOL_SIZE = "InitialPoolSize";	// NOI18N
	static public final String INITIALPOOLSIZEID = "InitialPoolSizeId";	// NOI18N
	static public final String MAX_POOL_SIZE = "MaxPoolSize";	// NOI18N
	static public final String MAXPOOLSIZEID = "MaxPoolSizeId";	// NOI18N
	static public final String MIN_POOL_SIZE = "MinPoolSize";	// NOI18N
	static public final String MINPOOLSIZEID = "MinPoolSizeId";	// NOI18N
	static public final String MAX_IDLE_TIME = "MaxIdleTime";	// NOI18N
	static public final String MAXIDLETIMEID = "MaxIdleTimeId";	// NOI18N
	static public final String MAX_STATEMENTS = "MaxStatements";	// NOI18N
	static public final String MAXSTATEMENTSID = "MaxStatementsId";	// NOI18N

	public DataSourceType() {
		this(Common.USE_DEFAULT_VALUES);
	}

	public DataSourceType(int options)
	{
		super(comparators, runtimeVersion);
		// Properties (see root bean comments for the bean graph)
		initPropertyTables(18);
		this.createProperty("description", 	// NOI18N
			DESCRIPTION, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(DESCRIPTION, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createAttribute(DESCRIPTION, "xml:lang", "XmlLang", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("name", 	// NOI18N
			NAME, 
			Common.TYPE_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("class-name", 	// NOI18N
			CLASS_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("server-name", 	// NOI18N
			SERVER_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(SERVER_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("port-number", 	// NOI18N
			PORT_NUMBER, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(PORT_NUMBER, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("database-name", 	// NOI18N
			DATABASE_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(DATABASE_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("url", 	// NOI18N
			URL, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("user", 	// NOI18N
			USER, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(USER, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("password", 	// NOI18N
			PASSWORD, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(PASSWORD, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("property", 	// NOI18N
			PROPERTY2, 
			Common.TYPE_0_N | Common.TYPE_BEAN | Common.TYPE_KEY, 
			PropertyType.class);
		this.createAttribute(PROPERTY2, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("login-timeout", 	// NOI18N
			LOGIN_TIMEOUT, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(LOGIN_TIMEOUT, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("transactional", 	// NOI18N
			TRANSACTIONAL, 
			Common.TYPE_0_1 | Common.TYPE_BOOLEAN | Common.TYPE_SHOULD_NOT_BE_EMPTY | Common.TYPE_KEY, 
			Boolean.class);
		this.createAttribute(TRANSACTIONAL, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("isolation-level", 	// NOI18N
			ISOLATION_LEVEL, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createProperty("initial-pool-size", 	// NOI18N
			INITIAL_POOL_SIZE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(INITIAL_POOL_SIZE, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("max-pool-size", 	// NOI18N
			MAX_POOL_SIZE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(MAX_POOL_SIZE, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("min-pool-size", 	// NOI18N
			MIN_POOL_SIZE, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(MIN_POOL_SIZE, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("max-idle-time", 	// NOI18N
			MAX_IDLE_TIME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(MAX_IDLE_TIME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("max-statements", 	// NOI18N
			MAX_STATEMENTS, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.math.BigInteger.class);
		this.createAttribute(MAX_STATEMENTS, "id", "Id", 
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

	// This attribute is optional
	public void setDescription(java.lang.String value) {
		this.setValue(DESCRIPTION, value);
	}

	//
	public java.lang.String getDescription() {
		return (java.lang.String)this.getValue(DESCRIPTION);
	}

	// This attribute is optional
	public void setDescriptionId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DESCRIPTION) == 0) {
			setValue(DESCRIPTION, "");
		}
		setAttributeValue(DESCRIPTION, "Id", value);
	}

	//
	public java.lang.String getDescriptionId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(DESCRIPTION) == 0) {
			return null;
		} else {
			return getAttributeValue(DESCRIPTION, "Id");
		}
	}

	// This attribute is optional
	public void setDescriptionXmlLang(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(DESCRIPTION) == 0) {
			setValue(DESCRIPTION, "");
		}
		setAttributeValue(DESCRIPTION, "XmlLang", value);
	}

	//
	public java.lang.String getDescriptionXmlLang() {
		// If our element does not exist, then the attribute does not exist.
		if (size(DESCRIPTION) == 0) {
			return null;
		} else {
			return getAttributeValue(DESCRIPTION, "XmlLang");
		}
	}

	// This attribute is mandatory
	public void setName(java.lang.String value) {
		this.setValue(NAME, value);
	}

	//
	public java.lang.String getName() {
		return (java.lang.String)this.getValue(NAME);
	}

	// This attribute is optional
	public void setClassName(java.lang.String value) {
		this.setValue(CLASS_NAME, value);
	}

	//
	public java.lang.String getClassName() {
		return (java.lang.String)this.getValue(CLASS_NAME);
	}

	// This attribute is optional
	public void setServerName(java.lang.String value) {
		this.setValue(SERVER_NAME, value);
	}

	//
	public java.lang.String getServerName() {
		return (java.lang.String)this.getValue(SERVER_NAME);
	}

	// This attribute is optional
	public void setServerNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(SERVER_NAME) == 0) {
			setValue(SERVER_NAME, "");
		}
		setAttributeValue(SERVER_NAME, "Id", value);
	}

	//
	public java.lang.String getServerNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(SERVER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(SERVER_NAME, "Id");
		}
	}

	// This attribute is optional
	public void setPortNumber(java.math.BigInteger value) {
		this.setValue(PORT_NUMBER, value);
	}

	//
	public java.math.BigInteger getPortNumber() {
		return (java.math.BigInteger)this.getValue(PORT_NUMBER);
	}

	// This attribute is optional
	public void setPortNumberId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getPortNumberId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setDatabaseName(java.lang.String value) {
		this.setValue(DATABASE_NAME, value);
	}

	//
	public java.lang.String getDatabaseName() {
		return (java.lang.String)this.getValue(DATABASE_NAME);
	}

	// This attribute is optional
	public void setDatabaseNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(SERVER_NAME) == 0) {
			setValue(SERVER_NAME, "");
		}
		setAttributeValue(SERVER_NAME, "Id", value);
	}

	//
	public java.lang.String getDatabaseNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(SERVER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(SERVER_NAME, "Id");
		}
	}

	// This attribute is optional
	public void setUrl(java.lang.String value) {
		this.setValue(URL, value);
	}

	//
	public java.lang.String getUrl() {
		return (java.lang.String)this.getValue(URL);
	}

	// This attribute is optional
	public void setUser(java.lang.String value) {
		this.setValue(USER, value);
	}

	//
	public java.lang.String getUser() {
		return (java.lang.String)this.getValue(USER);
	}

	// This attribute is optional
	public void setUserId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(SERVER_NAME) == 0) {
			setValue(SERVER_NAME, "");
		}
		setAttributeValue(SERVER_NAME, "Id", value);
	}

	//
	public java.lang.String getUserId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(SERVER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(SERVER_NAME, "Id");
		}
	}

	// This attribute is optional
	public void setPassword(java.lang.String value) {
		this.setValue(PASSWORD, value);
	}

	//
	public java.lang.String getPassword() {
		return (java.lang.String)this.getValue(PASSWORD);
	}

	// This attribute is optional
	public void setPasswordId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(SERVER_NAME) == 0) {
			setValue(SERVER_NAME, "");
		}
		setAttributeValue(SERVER_NAME, "Id", value);
	}

	//
	public java.lang.String getPasswordId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(SERVER_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(SERVER_NAME, "Id");
		}
	}

	// This attribute is an array, possibly empty
	public void setProperty2(int index, PropertyType value) {
		this.setValue(PROPERTY2, index, value);
	}

	//
	public PropertyType getProperty2(int index) {
		return (PropertyType)this.getValue(PROPERTY2, index);
	}

	// Return the number of properties
	public int sizeProperty2() {
		return this.size(PROPERTY2);
	}

	// This attribute is an array, possibly empty
	public void setProperty2(PropertyType[] value) {
		this.setValue(PROPERTY2, value);
	}

	//
	public PropertyType[] getProperty2() {
		return (PropertyType[])this.getValues(PROPERTY2);
	}

	// Add a new element returning its index in the list
	public int addProperty2(org.netbeans.modules.j2ee.dd.impl.web.model_3_0_frag.PropertyType value) {
		int positionOfNewItem = this.addValue(PROPERTY2, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeProperty2(org.netbeans.modules.j2ee.dd.impl.web.model_3_0_frag.PropertyType value) {
		return this.removeValue(PROPERTY2, value);
	}

	// This attribute is optional
	public void setLoginTimeout(java.math.BigInteger value) {
		this.setValue(LOGIN_TIMEOUT, value);
	}

	//
	public java.math.BigInteger getLoginTimeout() {
		return (java.math.BigInteger)this.getValue(LOGIN_TIMEOUT);
	}

	// This attribute is optional
	public void setLoginTimeoutId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getLoginTimeoutId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setTransactional(boolean value) {
		this.setValue(TRANSACTIONAL, (value ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE));
	}

	//
	public boolean isTransactional() {
		Boolean ret = (Boolean)this.getValue(TRANSACTIONAL);
		if (ret == null)
			ret = (Boolean)Common.defaultScalarValue(Common.TYPE_BOOLEAN);
		return ((java.lang.Boolean)ret).booleanValue();
	}

	// This attribute is optional
	public void setTransactionalId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(TRANSACTIONAL) == 0) {
			setValue(TRANSACTIONAL, "");
		}
		setAttributeValue(TRANSACTIONAL, "Id", value);
	}

	//
	public java.lang.String getTransactionalId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(TRANSACTIONAL) == 0) {
			return null;
		} else {
			return getAttributeValue(TRANSACTIONAL, "Id");
		}
	}

	// This attribute is optional
	public void setIsolationLevel(java.lang.String value) {
		this.setValue(ISOLATION_LEVEL, value);
	}

	//
	public java.lang.String getIsolationLevel() {
		return (java.lang.String)this.getValue(ISOLATION_LEVEL);
	}

	// This attribute is optional
	public void setInitialPoolSize(java.math.BigInteger value) {
		this.setValue(INITIAL_POOL_SIZE, value);
	}

	//
	public java.math.BigInteger getInitialPoolSize() {
		return (java.math.BigInteger)this.getValue(INITIAL_POOL_SIZE);
	}

	// This attribute is optional
	public void setInitialPoolSizeId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getInitialPoolSizeId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setMaxPoolSize(java.math.BigInteger value) {
		this.setValue(MAX_POOL_SIZE, value);
	}

	//
	public java.math.BigInteger getMaxPoolSize() {
		return (java.math.BigInteger)this.getValue(MAX_POOL_SIZE);
	}

	// This attribute is optional
	public void setMaxPoolSizeId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getMaxPoolSizeId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setMinPoolSize(java.math.BigInteger value) {
		this.setValue(MIN_POOL_SIZE, value);
	}

	//
	public java.math.BigInteger getMinPoolSize() {
		return (java.math.BigInteger)this.getValue(MIN_POOL_SIZE);
	}

	// This attribute is optional
	public void setMinPoolSizeId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getMinPoolSizeId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setMaxIdleTime(java.math.BigInteger value) {
		this.setValue(MAX_IDLE_TIME, value);
	}

	//
	public java.math.BigInteger getMaxIdleTime() {
		return (java.math.BigInteger)this.getValue(MAX_IDLE_TIME);
	}

	// This attribute is optional
	public void setMaxIdleTimeId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getMaxIdleTimeId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	// This attribute is optional
	public void setMaxStatements(java.math.BigInteger value) {
		this.setValue(MAX_STATEMENTS, value);
	}

	//
	public java.math.BigInteger getMaxStatements() {
		return (java.math.BigInteger)this.getValue(MAX_STATEMENTS);
	}

	// This attribute is optional
	public void setMaxStatementsId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(PORT_NUMBER) == 0) {
			setValue(PORT_NUMBER, "");
		}
		setAttributeValue(PORT_NUMBER, "Id", value);
	}

	//
	public java.lang.String getMaxStatementsId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(PORT_NUMBER) == 0) {
			return null;
		} else {
			return getAttributeValue(PORT_NUMBER, "Id");
		}
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public PropertyType newPropertyType() {
		return new PropertyType();
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
		if (getDescriptionId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getDescriptionId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "descriptionId", this);	// NOI18N
			}
		}
		// Validating property descriptionXmlLang
		// Validating property name
		if (getName() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getName() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "name", this);	// NOI18N
		}
		// Validating property className
		// Validating property serverName
		if (getServerName() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getServerName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "serverName", this);	// NOI18N
			}
		}
		// Validating property serverNameId
		if (getServerNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getServerNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "serverNameId", this);	// NOI18N
			}
		}
		// Validating property portNumber
		// Validating property portNumberId
		if (getPortNumberId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPortNumberId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "portNumberId", this);	// NOI18N
			}
		}
		// Validating property databaseName
		if (getDatabaseName() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getDatabaseName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "databaseName", this);	// NOI18N
			}
		}
		// Validating property databaseNameId
		if (getDatabaseNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getDatabaseNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "databaseNameId", this);	// NOI18N
			}
		}
		// Validating property url
		if (getUrl() != null) {
			{
				boolean patternPassed = false;
				if ((getUrl()).matches("jdbc:(.*):(.*)")) {
					patternPassed = true;
				}
				restrictionFailure = !patternPassed;
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getUrl()", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "url", this);	// NOI18N
			}
		}
		// Validating property user
		if (getUser() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getUser() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "user", this);	// NOI18N
			}
		}
		// Validating property userId
		if (getUserId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getUserId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "userId", this);	// NOI18N
			}
		}
		// Validating property password
		if (getPassword() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPassword() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "password", this);	// NOI18N
			}
		}
		// Validating property passwordId
		if (getPasswordId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getPasswordId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "passwordId", this);	// NOI18N
			}
		}
		// Validating property property2
		for (int _index = 0; _index < sizeProperty2(); ++_index) {
			org.netbeans.modules.j2ee.dd.impl.web.model_3_0_frag.PropertyType element = getProperty2(_index);
			if (element != null) {
				element.validate();
			}
		}
		// Validating property loginTimeout
		// Validating property loginTimeoutId
		if (getLoginTimeoutId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getLoginTimeoutId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "loginTimeoutId", this);	// NOI18N
			}
		}
		// Validating property transactional
		// Validating property transactionalId
		if (getTransactionalId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getTransactionalId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "transactionalId", this);	// NOI18N
			}
		}
		// Validating property isolationLevel
		if (getIsolationLevel() != null) {
			final java.lang.String[] enumRestrictionIsolationLevel = {"TRANSACTION_READ_UNCOMMITTED", "TRANSACTION_READ_COMMITTED", "TRANSACTION_REPEATABLE_READ", "TRANSACTION_SERIALIZABLE"};
			restrictionFailure = true;
			for (int _index2 = 0; 
				_index2 < enumRestrictionIsolationLevel.length; ++_index2) {
				if (enumRestrictionIsolationLevel[_index2].equals(getIsolationLevel())) {
					restrictionFailure = false;
					break;
				}
			}
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getIsolationLevel() enumeration test", org.netbeans.modules.schema2beans.ValidateException.FailureType.ENUM_RESTRICTION, "isolationLevel", this);	// NOI18N
			}
		}
		// Validating property initialPoolSize
		// Validating property initialPoolSizeId
		if (getInitialPoolSizeId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getInitialPoolSizeId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "initialPoolSizeId", this);	// NOI18N
			}
		}
		// Validating property maxPoolSize
		// Validating property maxPoolSizeId
		if (getMaxPoolSizeId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMaxPoolSizeId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "maxPoolSizeId", this);	// NOI18N
			}
		}
		// Validating property minPoolSize
		// Validating property minPoolSizeId
		if (getMinPoolSizeId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMinPoolSizeId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "minPoolSizeId", this);	// NOI18N
			}
		}
		// Validating property maxIdleTime
		// Validating property maxIdleTimeId
		if (getMaxIdleTimeId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMaxIdleTimeId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "maxIdleTimeId", this);	// NOI18N
			}
		}
		// Validating property maxStatements
		// Validating property maxStatementsId
		if (getMaxStatementsId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getMaxStatementsId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "maxStatementsId", this);	// NOI18N
			}
		}
	}

	// Dump the content of this bean returning it as a String
	public void dump(StringBuffer str, String indent){
		String s;
		Object o;
		org.netbeans.modules.schema2beans.BaseBean n;
		str.append(indent);
		str.append("Description");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getDescription();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(DESCRIPTION, 0, str, indent);

		str.append(indent);
		str.append("Name");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(NAME, 0, str, indent);

		str.append(indent);
		str.append("ClassName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getClassName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(CLASS_NAME, 0, str, indent);

		str.append(indent);
		str.append("ServerName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getServerName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(SERVER_NAME, 0, str, indent);

		str.append(indent);
		str.append("PortNumber");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPortNumber();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PORT_NUMBER, 0, str, indent);

		str.append(indent);
		str.append("DatabaseName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getDatabaseName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(DATABASE_NAME, 0, str, indent);

		str.append(indent);
		str.append("Url");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getUrl();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(URL, 0, str, indent);

		str.append(indent);
		str.append("User");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getUser();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(USER, 0, str, indent);

		str.append(indent);
		str.append("Password");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getPassword();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(PASSWORD, 0, str, indent);

		str.append(indent);
		str.append("Property2["+this.sizeProperty2()+"]");	// NOI18N
		for(int i=0; i<this.sizeProperty2(); i++)
		{
			str.append(indent+"\t");
			str.append("#"+i+":");
			n = (org.netbeans.modules.schema2beans.BaseBean) this.getProperty2(i);
			if (n != null)
				n.dump(str, indent + "\t");	// NOI18N
			else
				str.append(indent+"\tnull");	// NOI18N
			this.dumpAttributes(PROPERTY2, i, str, indent);
		}

		str.append(indent);
		str.append("LoginTimeout");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getLoginTimeout();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(LOGIN_TIMEOUT, 0, str, indent);

		str.append(indent);
		str.append("Transactional");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append((this.isTransactional()?"true":"false"));
		this.dumpAttributes(TRANSACTIONAL, 0, str, indent);

		str.append(indent);
		str.append("IsolationLevel");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getIsolationLevel();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(ISOLATION_LEVEL, 0, str, indent);

		str.append(indent);
		str.append("InitialPoolSize");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getInitialPoolSize();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(INITIAL_POOL_SIZE, 0, str, indent);

		str.append(indent);
		str.append("MaxPoolSize");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMaxPoolSize();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MAX_POOL_SIZE, 0, str, indent);

		str.append(indent);
		str.append("MinPoolSize");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMinPoolSize();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MIN_POOL_SIZE, 0, str, indent);

		str.append(indent);
		str.append("MaxIdleTime");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMaxIdleTime();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MAX_IDLE_TIME, 0, str, indent);

		str.append(indent);
		str.append("MaxStatements");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getMaxStatements();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MAX_STATEMENTS, 0, str, indent);

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("DataSourceType\n");	// NOI18N
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
      @(#)web-fragment_3_0.xsds
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

	This is the XML Schema for the Servlet 3.0 deployment descriptor.
	The deployment descriptor must be named "META-INF/web-fragment.xml" in the
	web fragment's jar file.  All Servlet deployment descriptors
	must indicate the web fragment schema by using the Java EE
	namespace:

	http://java.sun.com/xml/ns/javaee

	and by indicating the version of the schema by
	using the version element as shown below:

	    <web-fragment xmlns="http://java.sun.com/xml/ns/javaee"
	      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	      xsi:schemaLocation="..."
	      version="3.0">
	      ...
	    </web-fragment>

	The instance documents may indicate the published version of
	the schema using the xsi:schemaLocation attribute for Java EE
	namespace with the following location:

	http://java.sun.com/xml/ns/javaee/web-fragment_3_0.xsd

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

  <xsd:element name="web-fragment" type="javaee:web-fragmentType">
    <xsd:annotation>
      <xsd:documentation>

	The web-fragment element is the root of the deployment
	descriptor for a web fragment.  Note that the sub-elements
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
      <xsd:field    xpath="javaee:servlet-name"/>
    </xsd:unique>

    <xsd:unique name="web-common-filter-name-uniqueness">
      <xsd:annotation>
	<xsd:documentation>

	  The filter element contains the name of a filter.
	  The name must be unique within the web application.

	</xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:filter"/>
      <xsd:field    xpath="javaee:filter-name"/>
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
      <xsd:field    xpath="javaee:ejb-ref-name"/>
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
      <xsd:field    xpath="javaee:ejb-ref-name"/>
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
      <xsd:field    xpath="javaee:resource-env-ref-name"/>
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
      <xsd:field    xpath="javaee:message-destination-ref-name"/>
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
      <xsd:field    xpath="javaee:res-ref-name"/>
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
      <xsd:field    xpath="javaee:env-entry-name"/>
    </xsd:unique>

    <xsd:key name="web-common-role-name-key">
      <xsd:annotation>
	<xsd:documentation>

	  A role-name-key is specified to allow the references
	  from the security-role-refs.

	</xsd:documentation>
      </xsd:annotation>
      <xsd:selector xpath="javaee:security-role"/>
      <xsd:field    xpath="javaee:role-name"/>
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
      <xsd:field    xpath="javaee:role-link"/>
    </xsd:keyref>
  </xsd:element>

</xsd:schema>


*/