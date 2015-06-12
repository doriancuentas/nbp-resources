/**
 *	This generated bean class EjbJar matches the schema element 'ejb-jar'.
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
 *
 *	This class matches the root element of the XML Schema,
 *	and is the root of the following bean graph:
 *
 *	ejbJar <ejb-jar> : EjbJar
 *		[attr: version CDATA #FIXED 3.1 : java.lang.String] 	[pattern (\.?[0-9]+(\.[0-9]+)*)]
 *		[attr: metadata-complete CDATA #IMPLIED  : boolean]
 *		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *		moduleName <module-name> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *		description <description> : java.lang.String[0,n]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *		displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *		icon <icon> : Icon[0,n]
 *			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			smallIcon <small-icon> : java.lang.String[0,1]
 *			largeIcon <large-icon> : java.lang.String[0,1]
 *		enterpriseBeans <enterprise-beans> : EnterpriseBeans[0,1]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			(
 *			  | session <session> : SessionBean 	[unique name='session-ejb-local-ref-name-uniqueness', unique name='session-ejb-ref-name-uniqueness', unique name='session-resource-env-ref-uniqueness', unique name='session-message-destination-ref-uniqueness', unique name='session-res-ref-name-uniqueness', unique name='session-env-entry-name-uniqueness']
 *			  | 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	description <description> : java.lang.String[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 	displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 	icon <icon> : Icon[0,n]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		smallIcon <small-icon> : java.lang.String[0,1]
 *			  | 		largeIcon <large-icon> : java.lang.String[0,1]
 *			  | 	ejbName <ejb-name> : java.lang.String
 *			  | 	mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	home <home> : java.lang.String[0,1]
 *			  | 	remote <remote> : java.lang.String[0,1]
 *			  | 	localHome <local-home> : java.lang.String[0,1]
 *			  | 	local <local> : java.lang.String[0,1]
 *			  | 	businessLocal <business-local> : java.lang.String[0,n]
 *			  | 	businessRemote <business-remote> : java.lang.String[0,n]
 *			  | 	localBean <local-bean> : boolean[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	serviceEndpoint <service-endpoint> : java.lang.String[0,1]
 *			  | 	ejbClass <ejb-class> : java.lang.String[0,1]
 *			  | 	sessionType <session-type> : java.lang.String[0,1] 	[enumeration (Singleton), enumeration (Stateful), enumeration (Stateless)]
 *			  | 	statefulTimeout <stateful-timeout> : StatefulTimeoutType[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		timeout <timeout> : java.math.BigInteger
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		unit <unit> : java.lang.String 	[enumeration (Days), enumeration (Hours), enumeration (Minutes), enumeration (Seconds), enumeration (Milliseconds), enumeration (Microseconds), enumeration (Nanoseconds)]
 *			  | 	timeoutMethod <timeout-method> : NamedMethod[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodParams <method-params> : MethodParams[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	timer <timer> : TimerType[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		schedule <schedule> : TimerScheduleType
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			second <second> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			minute <minute> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			hour <hour> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			dayOfMonth <day-of-month> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			month <month> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			dayOfWeek <day-of-week> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			year <year> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		start <start> : java.util.Calendar[0,1]
 *			  | 		end <end> : java.util.Calendar[0,1]
 *			  | 		timeoutMethod <timeout-method> : NamedMethod
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParams <method-params> : MethodParams[0,1]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 				methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 		persistent <persistent> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 		timezone <timezone> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		info <info> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	initOnStartup <init-on-startup> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 	concurrencyManagementType <concurrency-management-type> : java.lang.String[0,1] 	[enumeration (Bean), enumeration (Container)]
 *			  | 	concurrentMethod <concurrent-method> : ConcurrentMethodType[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		method <method> : NamedMethod
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParams <method-params> : MethodParams[0,1]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 				methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 		lock <lock> : java.lang.String[0,1] 	[enumeration (Read), enumeration (Write)]
 *			  | 		accessTimeout <access-timeout> : AccessTimeoutType[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			timeout <timeout> : java.math.BigInteger
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			unit <unit> : java.lang.String 	[enumeration (Days), enumeration (Hours), enumeration (Minutes), enumeration (Seconds), enumeration (Milliseconds), enumeration (Microseconds), enumeration (Nanoseconds)]
 *			  | 	dependsOn <depends-on> : DependsOnType[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		ejbName <ejb-name> : java.lang.String[1,n]
 *			  | 	initMethod <init-method> : InitMethod[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		createMethod <create-method> : NamedMethod
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParams <method-params> : MethodParams[0,1]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 				methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 		beanMethod <bean-method> : NamedMethod
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParams <method-params> : MethodParams[0,1]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 				methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	removeMethod <remove-method> : RemoveMethod[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		beanMethod <bean-method> : NamedMethod
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParams <method-params> : MethodParams[0,1]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 				methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 		retainIfException <retain-if-exception> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 	asyncMethod <async-method> : AsyncMethodType[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodParams <method-params> : MethodParams[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	transactionType <transaction-type> : java.lang.String[0,1] 	[enumeration (Bean), enumeration (Container)]
 *			  | 	afterBeginMethod <after-begin-method> : NamedMethod[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodParams <method-params> : MethodParams[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	beforeCompletionMethod <before-completion-method> : NamedMethod[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodParams <method-params> : MethodParams[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	afterCompletionMethod <after-completion-method> : NamedMethod[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodName <method-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		methodParams <method-params> : MethodParams[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			methodParam <method-param> : java.lang.String[0,n] 	[pattern ([^\p{Z}]*)]
 *			  | 	aroundInvoke <around-invoke> : AroundInvoke[0,n]
 *			  | 		class2 <class> : java.lang.String[0,1]
 *			  | 		methodName <method-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	aroundTimeout <around-timeout> : AroundTimeoutType[0,n]
 *			  | 		class2 <class> : java.lang.String[0,1]
 *			  | 		methodName <method-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	envEntry <env-entry> : EnvEntry[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		envEntryName <env-entry-name> : java.lang.String
 *			  | 		envEntryType <env-entry-type> : java.lang.String[0,1]
 *			  | 		envEntryValue <env-entry-value> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	ejbRef <ejb-ref> : EjbRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		ejbRefName <ejb-ref-name> : java.lang.String
 *			  | 		ejbRefType <ejb-ref-type> : java.lang.String[0,1] 	[enumeration (Entity), enumeration (Session)]
 *			  | 		home <home> : java.lang.String[0,1]
 *			  | 		remote <remote> : java.lang.String[0,1]
 *			  | 		ejbLink <ejb-link> : java.lang.String[0,1]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	ejbLocalRef <ejb-local-ref> : EjbLocalRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		ejbRefName <ejb-ref-name> : java.lang.String
 *			  | 		ejbRefType <ejb-ref-type> : java.lang.String[0,1] 	[enumeration (Entity), enumeration (Session)]
 *			  | 		localHome <local-home> : java.lang.String[0,1]
 *			  | 		local <local> : java.lang.String[0,1]
 *			  | 		ejbLink <ejb-link> : java.lang.String[0,1]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	serviceRef <service-ref> : ServiceRef[0,n] 	[key name='service-ref_handler-name-key']
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		icon <icon> : Icon[0,n]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			smallIcon <small-icon> : java.lang.String[0,1]
 *			  | 			largeIcon <large-icon> : java.lang.String[0,1]
 *			  | 		serviceRefName <service-ref-name> : java.lang.String
 *			  | 		serviceInterface <service-interface> : java.lang.String
 *			  | 		serviceRefType <service-ref-type> : java.lang.String[0,1]
 *			  | 		wsdlFile <wsdl-file> : java.net.URI[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		jaxrpcMappingFile <jaxrpc-mapping-file> : java.lang.String[0,1]
 *			  | 		serviceQname <service-qname> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		portComponentRef <port-component-ref> : PortComponentRef[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			serviceEndpointInterface <service-endpoint-interface> : java.lang.String
 *			  | 			enableMtom <enable-mtom> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 			mtomThreshold <mtom-threshold> : java.math.BigInteger[0,1] 	[minInclusive (0)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			addressing <addressing> : AddressingType[0,1]
 *			  | 				enabled <enabled> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 				required <required> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 				responses <responses> : java.lang.String[0,1] 	[enumeration (ANONYMOUS), enumeration (NON_ANONYMOUS), enumeration (ALL)]
 *			  | 			respectBinding <respect-binding> : RespectBindingType[0,1]
 *			  | 				enabled <enabled> : boolean[0,1] 	[pattern ((true|false))]
 *			  | 			portComponentLink <port-component-link> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| handler <handler> : ServiceRefHandler[0,n]
 *			  | 		| 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	description <description> : java.lang.String[0,n]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 	displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 	icon <icon> : Icon[0,n]
 *			  | 		| 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		smallIcon <small-icon> : java.lang.String[0,1]
 *			  | 		| 		largeIcon <large-icon> : java.lang.String[0,1]
 *			  | 		| 	handlerName <handler-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	handlerClass <handler-class> : java.lang.String
 *			  | 		| 	initParam <init-param> : InitParam[0,n]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		description <description> : java.lang.String[0,n]
 *			  | 		| 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 		paramName <param-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 		| 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		paramValue <param-value> : java.lang.String
 *			  | 		| 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	soapHeader <soap-header> : java.lang.String[0,n]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	soapRole <soap-role> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	portName <port-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| handlerChains <handler-chains> : ServiceRefHandlerChains[0,1]
 *			  | 		| 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	handlerChain <handler-chain> : ServiceRefHandlerChainType[0,n]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		(
 *			  | 		| 		  | serviceNamePattern <service-name-pattern> : java.lang.String 	[pattern (\*|([\i-[:]][\c-[:]]*:)?[\i-[:]][\c-[:]]*\*?)]
 *			  | 		| 		  | portNamePattern <port-name-pattern> : java.lang.String 	[pattern (\*|([\i-[:]][\c-[:]]*:)?[\i-[:]][\c-[:]]*\*?)]
 *			  | 		| 		  | protocolBindings <protocol-bindings> : String
 *			  | 		| 		)[0,1]
 *			  | 		| 		handler <handler> : ServiceRefHandler[1,n]
 *			  | 		| 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			description <description> : java.lang.String[0,n]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 			displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 			icon <icon> : Icon[0,n]
 *			  | 		| 				[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 				smallIcon <small-icon> : java.lang.String[0,1]
 *			  | 		| 				largeIcon <large-icon> : java.lang.String[0,1]
 *			  | 		| 			handlerName <handler-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			handlerClass <handler-class> : java.lang.String
 *			  | 		| 			initParam <init-param> : InitParam[0,n]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 				description <description> : java.lang.String[0,n]
 *			  | 		| 					[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 					[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 				paramName <param-name> : java.lang.String 	[whiteSpace (collapse)]
 *			  | 		| 					[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 				paramValue <param-value> : java.lang.String
 *			  | 		| 					[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			soapHeader <soap-header> : java.lang.String[0,n]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			soapRole <soap-role> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 			portName <port-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		| 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	resourceRef <resource-ref> : ResourceRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		resRefName <res-ref-name> : java.lang.String
 *			  | 		resType <res-type> : java.lang.String[0,1]
 *			  | 		resAuth <res-auth> : java.lang.String[0,1] 	[enumeration (Application), enumeration (Container)]
 *			  | 		resSharingScope <res-sharing-scope> : java.lang.String[0,1] 	[enumeration (Shareable), enumeration (Unshareable)]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	resourceEnvRef <resource-env-ref> : ResourceEnvRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		resourceEnvRefName <resource-env-ref-name> : java.lang.String
 *			  | 		resourceEnvRefType <resource-env-ref-type> : java.lang.String[0,1]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	messageDestinationRef <message-destination-ref> : MessageDestinationRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		messageDestinationRefName <message-destination-ref-name> : java.lang.String
 *			  | 		messageDestinationType <message-destination-type> : java.lang.String[0,1]
 *			  | 		messageDestinationUsage <message-destination-usage> : java.lang.String[0,1] 	[enumeration (Consumes), enumeration (Produces), enumeration (ConsumesProduces)]
 *			  | 		messageDestinationLink <message-destination-link> : java.lang.String[0,1]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 		lookupName <lookup-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	persistenceContextRef <persistence-context-ref> : PersistenceContextRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		persistenceContextRefName <persistence-context-ref-name> : java.lang.String
 *			  | 		persistenceUnitName <persistence-unit-name> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		persistenceContextType <persistence-context-type> : java.lang.String[0,1] 	[enumeration (Transaction), enumeration (Extended)]
 *			  | 		persistenceProperty <persistence-property> : Property[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			name <name> : java.lang.String
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			value <value> : java.lang.String
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	persistenceUnitRef <persistence-unit-ref> : PersistenceUnitRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		persistenceUnitRefName <persistence-unit-ref-name> : java.lang.String
 *			  | 		persistenceUnitName <persistence-unit-name> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		injectionTarget <injection-target> : InjectionTarget[0,n]
 *			  | 			injectionTargetClass <injection-target-class> : java.lang.String
 *			  | 			injectionTargetName <injection-target-name> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	postConstruct <post-construct> : LifecycleCallback[0,n]
 *			  | 		lifecycleCallbackClass <lifecycle-callback-class> : java.lang.String[0,1]
 *			  | 		lifecycleCallbackMethod <lifecycle-callback-method> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	preDestroy <pre-destroy> : LifecycleCallback[0,n]
 *			  | 		lifecycleCallbackClass <lifecycle-callback-class> : java.lang.String[0,1]
 *			  | 		lifecycleCallbackMethod <lifecycle-callback-method> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	dataSource <data-source> : DataSourceType[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		name <name> : java.lang.String
 *			  | 		className <class-name> : java.lang.String[0,1]
 *			  | 		serverName <server-name> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		portNumber <port-number> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		databaseName <database-name> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		url <url> : java.lang.String[0,1] 	[pattern (jdbc:(.*):(.*))]
 *			  | 		user <user> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		password <password> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		property2 <property> : Property[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			name <name> : java.lang.String
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			value <value> : java.lang.String
 *			  | 				[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		loginTimeout <login-timeout> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		transactional <transactional> : boolean[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		isolationLevel <isolation-level> : java.lang.String[0,1] 	[enumeration (TRANSACTION_READ_UNCOMMITTED), enumeration (TRANSACTION_READ_COMMITTED), enumeration (TRANSACTION_REPEATABLE_READ), enumeration (TRANSACTION_SERIALIZABLE)]
 *			  | 		initialPoolSize <initial-pool-size> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		maxPoolSize <max-pool-size> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		minPoolSize <min-pool-size> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		maxIdleTime <max-idle-time> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		maxStatements <max-statements> : java.math.BigInteger[0,1]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	postActivate <post-activate> : LifecycleCallback[0,n]
 *			  | 		lifecycleCallbackClass <lifecycle-callback-class> : java.lang.String[0,1]
 *			  | 		lifecycleCallbackMethod <lifecycle-callback-method> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	prePassivate <pre-passivate> : LifecycleCallback[0,n]
 *			  | 		lifecycleCallbackClass <lifecycle-callback-class> : java.lang.String[0,1]
 *			  | 		lifecycleCallbackMethod <lifecycle-callback-method> : java.lang.String 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	securityRoleRef <security-role-ref> : SecurityRoleRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		roleName <role-name> : java.lang.String
 *			  | 		roleLink <role-link> : java.lang.String[0,1]
 *			  | 	securityIdentity <security-identity> : SecurityIdentity[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		description <description> : java.lang.String[0,n]
 *			  | 			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 			[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| useCallerIdentity <use-caller-identity> : boolean
 *			  | 		| 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| runAs <run-as> : RunAs
 *			  | 		| 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 	description <description> : java.lang.String[0,n]
 *			  | 		| 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		| 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		| 	roleName <role-name> : java.lang.String
 *			  | entity <entity> : EntityBean 	[unique name='entity-ejb-local-ref-name-uniqueness', unique name='entity-ejb-ref-name-uniqueness', unique name='entity-resource-env-ref-uniqueness', unique name='entity-message-destination-ref-uniqueness', unique name='entity-res-ref-name-uniqueness', unique name='entity-env-entry-name-uniqueness']
 *			  | 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	description <description> : java.lang.String[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 	displayName <display-name> : java.lang.String[0,n] 	[whiteSpace (collapse)]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 	icon <icon> : Icon[0,n]
 *			  | 		[attr: xml:lang CDATA #IMPLIED  : java.lang.String]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 		smallIcon <small-icon> : java.lang.String[0,1]
 *			  | 		largeIcon <large-icon> : java.lang.String[0,1]
 *			  | 	ejbName <ejb-name> : java.lang.String
 *			  | 	mappedName <mapped-name> : java.lang.String[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	home <home> : java.lang.String[0,1]
 *			  | 	remote <remote> : java.lang.String[0,1]
 *			  | 	localHome <local-home> : java.lang.String[0,1]
 *			  | 	local <local> : java.lang.String[0,1]
 *			  | 	ejbClass <ejb-class> : java.lang.String
 *			  | 	persistenceType <persistence-type> : java.lang.String 	[enumeration (Bean), enumeration (Container)]
 *			  | 	primKeyClass <prim-key-class> : java.lang.String
 *			  | 	reentrant <reentrant> : boolean 	[pattern ((true|false))]
 *			  | 	cmpVersion <cmp-version> : java.lang.String[0,1] 	[enumeration (1.x), enumeration (2.x)]
 *			  | 	abstractSchemaName <abstract-schema-name> : java.lang.String[0,1] 	[pattern (($|_|\p{L})(\p{L}|\p{Nd}|_|$)*)]
 *			  | 	cmpField <cmp-field> : CmpField[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	primkeyField <primkey-field> : java.lang.String[0,1] 	[whiteSpace (collapse)]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	securityRoleRef <security-role-ref> : SecurityRoleRef[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	securityIdentity <security-identity> : SecurityIdentity[0,1]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | 	query <query> : Query[0,n]
 *			  | 		[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			  | messageDriven <message-driven> : MessageDrivenBean 	[unique name='messaged-ejb-local-ref-name-uniqueness', unique name='messaged-ejb-ref-name-uniqueness', unique name='messaged-resource-env-ref-uniqueness', unique name='messaged-message-destination-ref-uniqueness', unique name='messaged-res-ref-name-uniqueness', unique name='messaged-env-entry-name-uniqueness']
 *			  | 	[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *			)[1,n]
 *		interceptors <interceptors> : Interceptors[0,1]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *		relationships <relationships> : Relationships[0,1] 	[unique name='relationship-name-uniqueness']
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *		assemblyDescriptor <assembly-descriptor> : AssemblyDescriptor[0,1]
 *			[attr: id CDATA #IMPLIED  : java.lang.String] 	[whiteSpace (collapse)]
 *		ejbClientJar <ejb-client-jar> : java.lang.String[0,1]
 *	... etc ...
 *
 * @Generated
 */

package org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1;

import org.w3c.dom.*;
import org.netbeans.modules.schema2beans.*;
import java.beans.*;
import java.util.*;
import java.io.*;

// BEGIN_NOI18N

public class EjbJar extends org.netbeans.modules.j2ee.dd.impl.common.ComponentBeanMultiple
	 implements org.netbeans.modules.j2ee.dd.api.ejb.EjbJar
{

	static Vector comparators = new Vector();
	static{
		EjbJar.addComparator(new org.netbeans.modules.j2ee.dd.impl.common.Comparator());
	}
	private static final org.netbeans.modules.schema2beans.Version runtimeVersion = new org.netbeans.modules.schema2beans.Version(5, 0, 0);
	private static final String SERIALIZATION_HELPER_CHARSET = "UTF-8";	// NOI18N

	static public final String VERSION = "Version";	// NOI18N
	static public final String METADATACOMPLETE = "MetadataComplete";	// NOI18N
	static public final String ID = "Id";	// NOI18N
	static public final String MODULE_NAME = "ModuleName";	// NOI18N
	static public final String MODULENAMEID = "ModuleNameId";	// NOI18N
	static public final String DESCRIPTION = "Description";	// NOI18N
	static public final String DESCRIPTIONID = "DescriptionId";	// NOI18N
	static public final String DESCRIPTIONXMLLANG = "DescriptionXmlLang";	// NOI18N
	static public final String DISPLAY_NAME = "DisplayName";	// NOI18N
	static public final String DISPLAYNAMEID = "DisplayNameId";	// NOI18N
	static public final String DISPLAYNAMEXMLLANG = "DisplayNameXmlLang";	// NOI18N
	static public final String ICON = "Icon";	// NOI18N
	static public final String ENTERPRISE_BEANS = "EnterpriseBeans";	// NOI18N
	static public final String INTERCEPTORS = "Interceptors";	// NOI18N
	static public final String RELATIONSHIPS = "Relationships";	// NOI18N
	static public final String ASSEMBLY_DESCRIPTOR = "AssemblyDescriptor";	// NOI18N
	static public final String EJB_CLIENT_JAR = "EjbClientJar";	// NOI18N

	public EjbJar() {
		this(null, Common.USE_DEFAULT_VALUES);
	}

	public EjbJar(org.w3c.dom.Node doc, int options) {
		this(Common.NO_DEFAULT_VALUES);
		try {
			initFromNode(doc, options);
		}
		catch (Schema2BeansException e) {
			throw new RuntimeException(e);
		}
	}
	protected void initFromNode(org.w3c.dom.Node doc, int options) throws Schema2BeansException
	{
		if (doc == null)
		{
			doc = GraphManager.createRootElementNode("ejb-jar");	// NOI18N
			if (doc == null)
				throw new Schema2BeansException(Common.getMessage(
					"CantCreateDOMRoot_msg", "ejb-jar"));
		}
		Node n = GraphManager.getElementNode("ejb-jar", doc);	// NOI18N
		if (n == null)
			throw new Schema2BeansException(Common.getMessage(
				"DocRootNotInDOMGraph_msg", "ejb-jar", doc.getFirstChild().getNodeName()));

		this.graphManager.setXmlDocument(doc);

		// Entry point of the createBeans() recursive calls
		this.createBean(n, this.graphManager());
		this.initialize(options);
	}
	public EjbJar(int options)
	{
		super(comparators, runtimeVersion);
		initOptions(options);
	}
	protected void initOptions(int options)
	{
		// The graph manager is allocated in the bean root
		this.graphManager = new GraphManager(this);
		this.createRoot("ejb-jar", "EjbJar",	// NOI18N
			Common.TYPE_1 | Common.TYPE_BEAN, EjbJar.class);

		// Properties (see root bean comments for the bean graph)
		initPropertyTables(9);
		this.createProperty("module-name", 	// NOI18N
			MODULE_NAME, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute(MODULE_NAME, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
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
		this.createProperty("enterprise-beans", 	// NOI18N
			ENTERPRISE_BEANS, 
			Common.TYPE_0_1 | Common.TYPE_BEAN | Common.TYPE_KEY, 
			EnterpriseBeans.class);
		this.createAttribute(ENTERPRISE_BEANS, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("interceptors", 	// NOI18N
			INTERCEPTORS, 
			Common.TYPE_0_1 | Common.TYPE_BEAN | Common.TYPE_KEY, 
			Interceptors.class);
		this.createAttribute(INTERCEPTORS, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("relationships", 	// NOI18N
			RELATIONSHIPS, 
			Common.TYPE_0_1 | Common.TYPE_BEAN | Common.TYPE_KEY, 
			Relationships.class);
		this.createAttribute(RELATIONSHIPS, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("assembly-descriptor", 	// NOI18N
			ASSEMBLY_DESCRIPTOR, 
			Common.TYPE_0_1 | Common.TYPE_BEAN | Common.TYPE_KEY, 
			AssemblyDescriptor.class);
		this.createAttribute(ASSEMBLY_DESCRIPTOR, "id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createProperty("ejb-client-jar", 	// NOI18N
			EJB_CLIENT_JAR, 
			Common.TYPE_0_1 | Common.TYPE_STRING | Common.TYPE_KEY, 
			java.lang.String.class);
		this.createAttribute("version", "Version", 
						AttrProp.CDATA | AttrProp.FIXED,
						null, "3.1");
		this.createAttribute("metadata-complete", "MetadataComplete", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.createAttribute("id", "Id", 
						AttrProp.CDATA | AttrProp.IMPLIED,
						null, null);
		this.initialize(options);
	}

	// Setting the default values of the properties
	void initialize(int options) {
		setDefaultNamespace("http://java.sun.com/xml/ns/javaee");
		if ((options & Common.USE_DEFAULT_VALUES) == Common.USE_DEFAULT_VALUES) {
			setVersionString("3.1");
		}

	}

	// This attribute is mandatory
	public void setVersionString(java.lang.String value) {
		setAttributeValue(VERSION, value);
	}

	//
	public java.lang.String getVersionString() {
		return getAttributeValue(VERSION);
	}

	// This attribute is optional
	public void setMetadataComplete(boolean value) {
		setAttributeValue(METADATACOMPLETE, ""+value);
	}

	//
	public boolean isMetadataComplete() {
		return (getAttributeValue(METADATACOMPLETE) == null) ? false : ("true".equalsIgnoreCase(getAttributeValue(METADATACOMPLETE)) || "1".equals(getAttributeValue(METADATACOMPLETE)));
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
	public void setModuleName(java.lang.String value) {
		this.setValue(MODULE_NAME, value);
	}

	//
	public java.lang.String getModuleName() {
		return (java.lang.String)this.getValue(MODULE_NAME);
	}

	// This attribute is optional
	public void setModuleNameId(java.lang.String value) {
		// Make sure we've got a place to put this attribute.
		if (size(MODULE_NAME) == 0) {
			setValue(MODULE_NAME, "");
		}
		setAttributeValue(MODULE_NAME, "Id", value);
	}

	//
	public java.lang.String getModuleNameId() {
		// If our element does not exist, then the attribute does not exist.
		if (size(MODULE_NAME) == 0) {
			return null;
		} else {
			return getAttributeValue(MODULE_NAME, "Id");
		}
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
	public void setIcon(int index, org.netbeans.modules.j2ee.dd.api.common.Icon valueInterface) {
		Icon value = (Icon) valueInterface;
		this.setValue(ICON, index, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.Icon getIcon(int index) {
		return (Icon)this.getValue(ICON, index);
	}

	// Return the number of properties
	public int sizeIcon() {
		return this.size(ICON);
	}

	// This attribute is an array, possibly empty
	public void setIcon(org.netbeans.modules.j2ee.dd.api.common.Icon[] value) {
		this.setValue(ICON, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.common.Icon[] getIcon() {
		return (Icon[])this.getValues(ICON);
	}

	// Add a new element returning its index in the list
	public int addIcon(org.netbeans.modules.j2ee.dd.api.common.Icon valueInterface) {
		Icon value = (Icon) valueInterface;
		int positionOfNewItem = this.addValue(ICON, value);
		return positionOfNewItem;
	}

	//
	// Remove an element using its reference
	// Returns the index the element had in the list
	//
	public int removeIcon(org.netbeans.modules.j2ee.dd.api.common.Icon valueInterface) {
		Icon value = (Icon) valueInterface;
		return this.removeValue(ICON, value);
	}

	// This attribute is optional
	public void setEnterpriseBeans(org.netbeans.modules.j2ee.dd.api.ejb.EnterpriseBeans valueInterface) {
		EnterpriseBeans value = (EnterpriseBeans) valueInterface;
		this.setValue(ENTERPRISE_BEANS, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.EnterpriseBeans getEnterpriseBeans() {
		return (EnterpriseBeans)this.getValue(ENTERPRISE_BEANS);
	}

	// This attribute is optional
	public void setInterceptors(org.netbeans.modules.j2ee.dd.api.ejb.Interceptors valueInterface) {
		Interceptors value = (Interceptors) valueInterface;
		this.setValue(INTERCEPTORS, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.Interceptors getInterceptors() {
		return (Interceptors)this.getValue(INTERCEPTORS);
	}

	// This attribute is optional
	public void setRelationships(org.netbeans.modules.j2ee.dd.api.ejb.Relationships valueInterface) {
		Relationships value = (Relationships) valueInterface;
		this.setValue(RELATIONSHIPS, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.Relationships getRelationships() {
		return (Relationships)this.getValue(RELATIONSHIPS);
	}

	// This attribute is optional
	public void setAssemblyDescriptor(org.netbeans.modules.j2ee.dd.api.ejb.AssemblyDescriptor valueInterface) {
		AssemblyDescriptor value = (AssemblyDescriptor) valueInterface;
		this.setValue(ASSEMBLY_DESCRIPTOR, value);
	}

	//
	public org.netbeans.modules.j2ee.dd.api.ejb.AssemblyDescriptor getAssemblyDescriptor() {
		return (AssemblyDescriptor)this.getValue(ASSEMBLY_DESCRIPTOR);
	}

	// This attribute is optional
	public void setEjbClientJar(java.lang.String value) {
		this.setValue(EJB_CLIENT_JAR, value);
	}

	//
	public java.lang.String getEjbClientJar() {
		return (java.lang.String)this.getValue(EJB_CLIENT_JAR);
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
	public org.netbeans.modules.j2ee.dd.api.ejb.EnterpriseBeans newEnterpriseBeans() {
		return new EnterpriseBeans();
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.ejb.Interceptors newInterceptors() {
		return new Interceptors();
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.ejb.Relationships newRelationships() {
		return new Relationships();
	}

	/**
	 * Create a new bean using it's default constructor.
	 * This does not add it to any bean graph.
	 */
	public org.netbeans.modules.j2ee.dd.api.ejb.AssemblyDescriptor newAssemblyDescriptor() {
		return new AssemblyDescriptor();
	}

	//
	public static void addComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.add(c);
	}

	//
	public static void removeComparator(org.netbeans.modules.schema2beans.BeanComparator c) {
		comparators.remove(c);
	}
	//
	// This method returns the root of the bean graph
	// Each call creates a new bean graph from the specified DOM graph
	//
	public static EjbJar createGraph(org.w3c.dom.Node doc) {
		return new EjbJar(doc, Common.NO_DEFAULT_VALUES);
	}

	public static EjbJar createGraph(java.io.File f) throws java.io.IOException {
		java.io.InputStream in = new java.io.FileInputStream(f);
		try {
			return createGraph(in, false);
		} finally {
			in.close();
		}
	}

	public static EjbJar createGraph(java.io.InputStream in) {
		return createGraph(in, false);
	}

	public static EjbJar createGraph(java.io.InputStream in, boolean validate) {
		try {
			Document doc = GraphManager.createXmlDocument(in, validate);
			return createGraph(doc);
		}
		catch (Exception t) {
			throw new RuntimeException(Common.getMessage(
				"DOMGraphCreateFailed_msg",
				t));
		}
	}

	//
	// This method returns the root for a new empty bean graph
	//
	public static EjbJar createGraph() {
		return new EjbJar();
	}


	 
                    public org.xml.sax.SAXParseException getError() { 
                        return null; 
                    } 
                    public int getStatus() { 
                        return STATE_VALID; 
                    } 
                    public String getSingleEjbClientJar() { 
                        return getEjbClientJar(); 
                    } 
                    public org.netbeans.modules.j2ee.dd.api.ejb.AssemblyDescriptor getSingleAssemblyDescriptor() { 
                        return getAssemblyDescriptor(); 
                    } 
                    public org.netbeans.modules.j2ee.dd.api.ejb.Relationships getSingleRelationships() { 
                        return getRelationships(); 
                    } 
                    public void setVersion(java.math.BigDecimal value) {
                            setAttributeValue(VERSION, value.toString());
                    }
                    public java.math.BigDecimal getVersion() {
                            return new java.math.BigDecimal(getAttributeValue(VERSION));
                    }
                    public Object clone() {
                        org.netbeans.modules.j2ee.dd.api.ejb.EjbJar ejbJar =
                            (org.netbeans.modules.j2ee.dd.api.ejb.EjbJar) super.clone();
                        ejbJar.setVersion( getVersion());
                        return ejbJar;
                    }
               
	public void validate() throws org.netbeans.modules.schema2beans.ValidateException {
		boolean restrictionFailure = false;
		boolean restrictionPassed = false;
		// Validating property version
		if (getVersionString() == null) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getVersion() == null", org.netbeans.modules.schema2beans.ValidateException.FailureType.NULL_VALUE, "version", this);	// NOI18N
		}
		{
			boolean patternPassed = false;
			if ((getVersionString()).matches("\\.?[0-9]+(\\.[0-9]+)*")) {
				patternPassed = true;
			}
			restrictionFailure = !patternPassed;
		}
		if (restrictionFailure) {
			throw new org.netbeans.modules.schema2beans.ValidateException("getVersion()", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "version", this);	// NOI18N
		}
		// Validating property metadataComplete
		// Validating property id
		if (getId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "id", this);	// NOI18N
			}
		}
		// Validating property moduleName
		if (getModuleName() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getModuleName() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "moduleName", this);	// NOI18N
			}
		}
		// Validating property moduleNameId
		if (getModuleNameId() != null) {
			// has whitespace restriction
			if (restrictionFailure) {
				throw new org.netbeans.modules.schema2beans.ValidateException("getModuleNameId() whiteSpace (collapse)", org.netbeans.modules.schema2beans.ValidateException.FailureType.DATA_RESTRICTION, "moduleNameId", this);	// NOI18N
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
			org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.Icon element = (org.netbeans.modules.j2ee.dd.impl.ejb.model_3_1.Icon) getIcon(_index);
			if (element != null) {
				((Icon)element).validate();
			}
		}
		// Validating property enterpriseBeans
		if (getEnterpriseBeans() != null) {
			((EnterpriseBeans)getEnterpriseBeans()).validate();
		}
		// Validating property interceptors
		if (getInterceptors() != null) {
			((Interceptors)getInterceptors()).validate();
		}
		// Validating property relationships
		if (getRelationships() != null) {
			((Relationships)getRelationships()).validate();
		}
		// Validating property assemblyDescriptor
		if (getAssemblyDescriptor() != null) {
			((AssemblyDescriptor)getAssemblyDescriptor()).validate();
		}
		// Validating property ejbClientJar
	}

	// Special serializer: output XML as serialization
	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException{
		out.defaultWriteObject();
		final int MAX_SIZE = 0XFFFF;
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			write(baos, SERIALIZATION_HELPER_CHARSET);
			final byte [] array = baos.toByteArray();
			final int numStrings = array.length / MAX_SIZE;
			final int leftover = array.length % MAX_SIZE;
			out.writeInt(numStrings + (0 == leftover ? 0 : 1));
			out.writeInt(MAX_SIZE);
			int offset = 0;
			for (int i = 0; i < numStrings; i++){
				out.writeUTF(new String(array, offset, MAX_SIZE, SERIALIZATION_HELPER_CHARSET));
				offset += MAX_SIZE;
			}
			if (leftover > 0){
				final int count = array.length - offset;
				out.writeUTF(new String(array, offset, count, SERIALIZATION_HELPER_CHARSET));
			}
		}
		catch (Schema2BeansException ex){
			throw new Schema2BeansRuntimeException(ex);
		}
	}
	// Special deserializer: read XML as deserialization
	private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException{
		try{
			in.defaultReadObject();
			init(comparators, runtimeVersion);
			// init(comparators, new GenBeans.Version(1, 0, 8))
			final int numStrings = in.readInt();
			final int max_size = in.readInt();
			final StringBuilder sb = new StringBuilder(numStrings * max_size);
			for (int i = 0; i < numStrings; i++){
				sb.append(in.readUTF());
			}
			ByteArrayInputStream bais = new ByteArrayInputStream(sb.toString().getBytes(SERIALIZATION_HELPER_CHARSET));
			Document doc = GraphManager.createXmlDocument(bais, false);
			initOptions(Common.NO_DEFAULT_VALUES);
			initFromNode(doc, Common.NO_DEFAULT_VALUES);
		}
		catch (Schema2BeansException e){
			throw new RuntimeException(e);
		}
	}

	public void _setSchemaLocation(String location) {
		if (beanProp().getAttrProp("xsi:schemaLocation", true) == null) {
			createAttribute("xmlns:xsi", "xmlns:xsi", AttrProp.CDATA | AttrProp.IMPLIED, null, "http://www.w3.org/2001/XMLSchema-instance");
			setAttributeValue("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			createAttribute("xsi:schemaLocation", "xsi:schemaLocation", AttrProp.CDATA | AttrProp.IMPLIED, null, location);
		}
		setAttributeValue("xsi:schemaLocation", location);
	}

	public String _getSchemaLocation() {
		if (beanProp().getAttrProp("xsi:schemaLocation", true) == null) {
			createAttribute("xmlns:xsi", "xmlns:xsi", AttrProp.CDATA | AttrProp.IMPLIED, null, "http://www.w3.org/2001/XMLSchema-instance");
			setAttributeValue("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			createAttribute("xsi:schemaLocation", "xsi:schemaLocation", AttrProp.CDATA | AttrProp.IMPLIED, null, null);
		}
		return getAttributeValue("xsi:schemaLocation");
	}

	// Dump the content of this bean returning it as a String
	public void dump(StringBuffer str, String indent){
		String s;
		Object o;
		org.netbeans.modules.schema2beans.BaseBean n;
		str.append(indent);
		str.append("ModuleName");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getModuleName();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(MODULE_NAME, 0, str, indent);

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
		str.append("EnterpriseBeans");	// NOI18N
		n = (org.netbeans.modules.schema2beans.BaseBean) this.getEnterpriseBeans();
		if (n != null)
			n.dump(str, indent + "\t");	// NOI18N
		else
			str.append(indent+"\tnull");	// NOI18N
		this.dumpAttributes(ENTERPRISE_BEANS, 0, str, indent);

		str.append(indent);
		str.append("Interceptors");	// NOI18N
		n = (org.netbeans.modules.schema2beans.BaseBean) this.getInterceptors();
		if (n != null)
			n.dump(str, indent + "\t");	// NOI18N
		else
			str.append(indent+"\tnull");	// NOI18N
		this.dumpAttributes(INTERCEPTORS, 0, str, indent);

		str.append(indent);
		str.append("Relationships");	// NOI18N
		n = (org.netbeans.modules.schema2beans.BaseBean) this.getRelationships();
		if (n != null)
			n.dump(str, indent + "\t");	// NOI18N
		else
			str.append(indent+"\tnull");	// NOI18N
		this.dumpAttributes(RELATIONSHIPS, 0, str, indent);

		str.append(indent);
		str.append("AssemblyDescriptor");	// NOI18N
		n = (org.netbeans.modules.schema2beans.BaseBean) this.getAssemblyDescriptor();
		if (n != null)
			n.dump(str, indent + "\t");	// NOI18N
		else
			str.append(indent+"\tnull");	// NOI18N
		this.dumpAttributes(ASSEMBLY_DESCRIPTOR, 0, str, indent);

		str.append(indent);
		str.append("EjbClientJar");	// NOI18N
		str.append(indent+"\t");	// NOI18N
		str.append("<");	// NOI18N
		o = this.getEjbClientJar();
		str.append((o==null?"null":o.toString().trim()));	// NOI18N
		str.append(">\n");	// NOI18N
		this.dumpAttributes(EJB_CLIENT_JAR, 0, str, indent);

	}
	public String dumpBeanNode(){
		StringBuffer str = new StringBuffer();
		str.append("EjbJar\n");	// NOI18N
		this.dump(str, "\n  ");	// NOI18N
		return str.toString();
	}}

// END_NOI18N

