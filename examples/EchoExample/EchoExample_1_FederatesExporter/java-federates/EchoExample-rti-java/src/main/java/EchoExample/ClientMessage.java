
// This code has been generated by the C2W code generator.
// Do not edit manually!

package EchoExample;

import java.util.HashSet;
import java.util.Set;

import hla.rti.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.hla.*;
import org.cpswt.utils.CpswtUtils;

/**
* The ClientMessage class implements the ClientMessage interaction in the
* EchoExample simulation.
*/
public class ClientMessage extends C2WInteractionRoot {

	private static final Logger logger = LogManager.getLogger(ClientMessage.class);

	/**
	* Default constructor -- creates an instance of the ClientMessage interaction
	* class with default parameter values.
	*/
	public ClientMessage() { }

	
	
	private static int _sequenceNumber_handle;
	
	
	/**
	* Returns the handle (RTI assigned) of the "sequenceNumber" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "sequenceNumber" parameter
	*/
	public static int get_sequenceNumber_handle() { return _sequenceNumber_handle; }
	
	
	
	private static boolean _isInitialized = false;

	private static int _handle;

	/**
	* Returns the handle (RTI assigned) of the ClientMessage interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the handle of the class pertaining to the reference,\
	* rather than the handle of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassHandle()}.
	*/
	public static int get_handle() { return _handle; }

	/**
	* Returns the fully-qualified (dot-delimited) name of the ClientMessage
	* interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the name of the class pertaining to the reference,\
	* rather than the name of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassName()}.
	*/
	public static String get_class_name() { return "InteractionRoot.C2WInteractionRoot.ClientMessage"; }

	/**
	* Returns the simple name (the last name in the dot-delimited fully-qualified
	* class name) of the ClientMessage interaction class.
	*/
	public static String get_simple_class_name() { return "ClientMessage"; }

	private static Set< String > _datamemberNames = new HashSet< String >();
	private static Set< String > _allDatamemberNames = new HashSet< String >();

	/**
	* Returns a set containing the names of all of the non-hidden parameters in the
	* ClientMessage interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return a set of parameter names pertaining to the reference,\
	* rather than the parameter names of the class for the instance referred to by
	* the reference.  For the polymorphic version of this method, use
	* {@link #getParameterNames()}.
	*/
	public static Set< String > get_parameter_names() {
		return new HashSet< String >( _datamemberNames );
	}


	/**
	* Returns a set containing the names of all of the parameters in the
	* ClientMessage interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return a set of parameter names pertaining to the reference,\
	* rather than the parameter names of the class for the instance referred to by
	* the reference.  For the polymorphic version of this method, use
	* {@link #getParameterNames()}.
	*/
	public static Set< String > get_all_parameter_names() {
		return new HashSet< String >( _allDatamemberNames );
	}


	

	static {
		_classNameSet.add( "InteractionRoot.C2WInteractionRoot.ClientMessage" );
		_classNameClassMap.put( "InteractionRoot.C2WInteractionRoot.ClientMessage", ClientMessage.class );
		
		_datamemberClassNameSetMap.put( "InteractionRoot.C2WInteractionRoot.ClientMessage", _datamemberNames );
		_allDatamemberClassNameSetMap.put( "InteractionRoot.C2WInteractionRoot.ClientMessage", _allDatamemberNames );

		
		
		
		
		
		_datamemberNames.add( "sequenceNumber" );
		
		
		
		_allDatamemberNames.add( "actualLogicalGenerationTime" );
		_allDatamemberNames.add( "federateFilter" );
		_allDatamemberNames.add( "originFed" );
		_allDatamemberNames.add( "sequenceNumber" );
		_allDatamemberNames.add( "sourceFed" );
		
		
		_datamemberTypeMap.put( "sequenceNumber", "int" );
	
	

	}


	private static String initErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ClientMessage:  could not initialize:  ";
	protected static void init( RTIambassador rti ) {
		if ( _isInitialized ) return;
		_isInitialized = true;
		
		C2WInteractionRoot.init( rti );
		
		boolean isNotInitialized = true;
		while( isNotInitialized ) {
			try {
				_handle = rti.getInteractionClassHandle( "InteractionRoot.C2WInteractionRoot.ClientMessage" );
				isNotInitialized = false;
			} catch ( FederateNotExecutionMember f ) {
				logger.error( initErrorMessage + "Federate Not Execution Member" );
				logger.error(f);
				return;				
			} catch ( NameNotFound n ) {
				logger.error( initErrorMessage + "Name Not Found" );
				logger.error(n);
				return;				
			} catch ( Exception e ) {
				logger.error(e);
				CpswtUtils.sleepDefault();
			}
		}

		_classNameHandleMap.put( "InteractionRoot.C2WInteractionRoot.ClientMessage", get_handle() );
		_classHandleNameMap.put( get_handle(), "InteractionRoot.C2WInteractionRoot.ClientMessage" );
		_classHandleSimpleNameMap.put( get_handle(), "ClientMessage" );

		
		isNotInitialized = true;
		while( isNotInitialized ) {
			try {
							
				_sequenceNumber_handle = rti.getParameterHandle( "sequenceNumber", get_handle() );
				isNotInitialized = false;
			} catch ( FederateNotExecutionMember f ) {
				logger.error( initErrorMessage + "Federate Not Execution Member" );
				logger.error(f);
				return;				
			} catch ( InteractionClassNotDefined i ) {
				logger.error( initErrorMessage + "Interaction Class Not Defined" );
				logger.error(i);
				return;				
			} catch ( NameNotFound n ) {
				logger.error( initErrorMessage + "Name Not Found" );
				logger.error(n);
				return;				
			} catch ( Exception e ) {
				logger.error(e);
				CpswtUtils.sleepDefault();
			}
		}
			
			
		_datamemberNameHandleMap.put( "InteractionRoot.C2WInteractionRoot.ClientMessage,sequenceNumber", get_sequenceNumber_handle() );
			
			
		_datamemberHandleNameMap.put( get_sequenceNumber_handle(), "sequenceNumber" );
		
	}


	private static boolean _isPublished = false;
	private static String publishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ClientMessage:  could not publish:  ";

	/**
	* Publishes the ClientMessage interaction class for a federate.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public static void publish( RTIambassador rti ) {
		if ( _isPublished ) return;
		
		init( rti );

	

		synchronized( rti ) {
			boolean isNotPublished = true;
			while( isNotPublished ) {
				try {
					rti.publishInteractionClass( get_handle() );
					isNotPublished = false;
				} catch ( FederateNotExecutionMember f ) {
					logger.error( publishErrorMessage + "Federate Not Execution Member" );
					logger.error(f);
					return;
				} catch ( InteractionClassNotDefined i ) {
					logger.error( publishErrorMessage + "Interaction Class Not Defined" );
					logger.error(i);
					return;
				} catch ( Exception e ) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isPublished = true;
	}

	private static String unpublishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ClientMessage:  could not unpublish:  ";
	/**
	* Unpublishes the ClientMessage interaction class for a federate.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public static void unpublish( RTIambassador rti ) {
		if ( !_isPublished ) return;
		
		init( rti );
		synchronized( rti ) {
			boolean isNotUnpublished = true;
			while( isNotUnpublished ) {
				try {
					rti.unpublishInteractionClass( get_handle() );
					isNotUnpublished = false;
				} catch ( FederateNotExecutionMember f ) {
					logger.error( unpublishErrorMessage + "Federate Not Execution Member" );
					logger.error(f);
					return;
				} catch ( InteractionClassNotDefined i ) {
					logger.error( unpublishErrorMessage + "Interaction Class Not Defined" );
					logger.error(i);
					return;
				} catch ( InteractionClassNotPublished i ) {
					logger.error( unpublishErrorMessage + "Interaction Class Not Published" );
					logger.error(i);
					return;
				} catch ( Exception e ) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isPublished = false;
	}

	private static boolean _isSubscribed = false;
	private static String subscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ClientMessage:  could not subscribe:  ";
	/**
	* Subscribes a federate to the ClientMessage interaction class.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public static void subscribe( RTIambassador rti ) {
		if ( _isSubscribed ) return;
		
		init( rti );
	
		
		synchronized( rti ) {
			boolean isNotSubscribed = true;
			while( isNotSubscribed ) {
				try {
					rti.subscribeInteractionClass( get_handle() );
					isNotSubscribed = false;
				} catch ( FederateNotExecutionMember f ) {
					logger.error( subscribeErrorMessage + "Federate Not Execution Member" );
					logger.error(f);
					return;
				} catch ( InteractionClassNotDefined i ) {
					logger.error( subscribeErrorMessage + "Interaction Class Not Defined" );
					logger.error(i);
					return;
				} catch ( Exception e ) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isSubscribed = true;
	}

	private static String unsubscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ClientMessage:  could not unsubscribe:  ";
	/**
	* Unsubscribes a federate from the ClientMessage interaction class.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public static void unsubscribe( RTIambassador rti ) {
		if ( !_isSubscribed ) return;

		init( rti );
		synchronized( rti ) {
			boolean isNotUnsubscribed = true;
			while( isNotUnsubscribed ) {
				try {
					rti.unsubscribeInteractionClass( get_handle() );
					isNotUnsubscribed = false;
				} catch ( FederateNotExecutionMember f ) {
					logger.error( unsubscribeErrorMessage + "Federate Not Execution Member" );
					logger.error(f);
					return;
				} catch ( InteractionClassNotDefined i ) {
					logger.error( unsubscribeErrorMessage + "Interaction Class Not Defined" );
					logger.error(i);
					return;
				} catch ( InteractionClassNotSubscribed i ) {
					logger.error( unsubscribeErrorMessage + "Interaction Class Not Subscribed" );
					logger.error(i);
					return;
				} catch ( Exception e ) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isSubscribed = false;
	}

	/**
	* Return true if "handle" is equal to the handle (RTI assigned) of this class
	* (that is, the ClientMessage interaction class).
	*
	* @param handle handle to compare to the value of the handle (RTI assigned) of
	* this class (the ClientMessage interaction class).
	* @return "true" if "handle" matches the value of the handle of this class
	* (that is, the ClientMessage interaction class).
	*/
	public static boolean match( int handle ) { return handle == get_handle(); }

	/**
	* Returns the handle (RTI assigned) of this instance's interaction class .
	* 
	* @return the handle (RTI assigned) if this instance's interaction class
	*/
	public int getClassHandle() { return get_handle(); }

	/**
	* Returns the fully-qualified (dot-delimited) name of this instance's interaction class.
	* 
	* @return the fully-qualified (dot-delimited) name of this instance's interaction class
	*/
	public String getClassName() { return get_class_name(); }

	/**
	* Returns the simple name (last name in its fully-qualified dot-delimited name)
	* of this instance's interaction class.
	* 
	* @return the simple name of this instance's interaction class 
	*/
	public String getSimpleClassName() { return get_simple_class_name(); }

	/**
	* Returns a set containing the names of all of the non-hiddenparameters of an
	* interaction class instance.
	*
	* @return set containing the names of all of the parameters of an
	* interaction class instance
	*/
	public Set< String > getParameterNames() { return get_parameter_names(); }

	/**
	* Returns a set containing the names of all of the parameters of an
	* interaction class instance.
	*
	* @return set containing the names of all of the parameters of an
	* interaction class instance
	*/
	public Set< String > getAllParameterNames() { return get_all_parameter_names(); }

	/**
	* Publishes the interaction class of this instance of the class for a federate.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public void publishInteraction( RTIambassador rti ) { publish( rti ); }

	/**
	* Unpublishes the interaction class of this instance of this class for a federate.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public void unpublishInteraction( RTIambassador rti ) { unpublish( rti ); }

	/**
	* Subscribes a federate to the interaction class of this instance of this class.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public void subscribeInteraction( RTIambassador rti ) { subscribe( rti ); }

	/**
	* Unsubscribes a federate from the interaction class of this instance of this class.
	*
	* @param rti handle to the RTI, usu. obtained through the
	* {@link SynchronizedFederate#getRTI()} call
	*/
	public void unsubscribeInteraction( RTIambassador rti ) { unsubscribe( rti ); }

	

	public String toString() {
		return "ClientMessage("
			
			
			+ "sequenceNumber:" + get_sequenceNumber()
			+ ")";
	}
	



	
	
	private int _sequenceNumber = 0;

	
	
	/**
	* Set the value of the "sequenceNumber" parameter to "value" for this parameter.
	*
	* @param value the new value for the "sequenceNumber" parameter
	*/
	public void set_sequenceNumber( int value ) { _sequenceNumber = value; }
	
	/**
	* Returns the value of the "sequenceNumber" parameter of this interaction.
	*
	* @return the value of the "sequenceNumber" parameter
	*/
	public int get_sequenceNumber() { return _sequenceNumber; }
	


	protected ClientMessage( ReceivedInteraction datamemberMap, boolean initFlag ) {
		super( datamemberMap, false );
		if ( initFlag ) setParameters( datamemberMap );
	}
	
	protected ClientMessage( ReceivedInteraction datamemberMap, LogicalTime logicalTime, boolean initFlag ) {
		super( datamemberMap, logicalTime, false );
		if ( initFlag ) setParameters( datamemberMap );
	}


	/**
	* Creates an instance of the ClientMessage interaction class, using
	* "datamemberMap" to initialize its parameter values.
	* "datamemberMap" is usually acquired as an argument to an RTI federate
	* callback method, such as "receiveInteraction".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new ClientMessage interaction class instance
	*/
	public ClientMessage( ReceivedInteraction datamemberMap ) {
		this( datamemberMap, true );
	}
	
	/**
	* Like {@link #ClientMessage( ReceivedInteraction datamemberMap )}, except this
	* new ClientMessage interaction class instance is given a timestamp of
	* "logicalTime".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new ClientMessage interaction class instance
	* @param logicalTime timestamp for this new ClientMessage interaction class
	* instance
	*/
	public ClientMessage( ReceivedInteraction datamemberMap, LogicalTime logicalTime ) {
		this( datamemberMap, logicalTime, true );
	}

	/**
	* Creates a new ClientMessage interaction class instance that is a duplicate
	* of the instance referred to by ClientMessage_var.
	*
	* @param ClientMessage_var ClientMessage interaction class instance of which
	* this newly created ClientMessage interaction class instance will be a
	* duplicate
	*/
	public ClientMessage( ClientMessage ClientMessage_var ) {
		super( ClientMessage_var );
		
		
		set_sequenceNumber( ClientMessage_var.get_sequenceNumber() );
	}


	/**
	* Returns the value of the parameter whose name is "datamemberName"
	* for this interaction.
	*
	* @param datamemberName name of parameter whose value is to be
	* returned
	* @return value of the parameter whose name is "datamemberName"
	* for this interaction
	*/
	public Object getParameter( String datamemberName ) {
		
		
		
		if (  "sequenceNumber".equals( datamemberName )  ) return new Integer( get_sequenceNumber() );
		else return super.getParameter( datamemberName );
	}
	
	/**
	* Returns the value of the parameter whose handle (RTI assigned)
	* is "datamemberHandle" for this interaction.
	*
	* @param datamemberHandle handle (RTI assigned) of parameter whose
	* value is to be returned
	* @return value of the parameter whose handle (RTI assigned) is
	* "datamemberHandle" for this interaction
	*/
	public Object getParameter( int datamemberHandle ) {
		
				
		
		if ( get_sequenceNumber_handle() == datamemberHandle ) return new Integer( get_sequenceNumber() );
		else return super.getParameter( datamemberHandle );
	}
	
	protected boolean setParameterAux( int param_handle, String val ) {
		boolean retval = true;		
		
			
		
		if ( param_handle == get_sequenceNumber_handle() ) set_sequenceNumber( Integer.parseInt( val ) );
		else retval = super.setParameterAux( param_handle, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, String val ) {
		boolean retval = true;
		
			
		
		if (  "sequenceNumber".equals( datamemberName )  ) set_sequenceNumber( Integer.parseInt( val ) );	
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, Object val ) {
		boolean retval = true;
		
		
		
		if (  "sequenceNumber".equals( datamemberName )  ) set_sequenceNumber( (Integer)val );		
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}

	protected SuppliedParameters createSuppliedDatamembers() {
		SuppliedParameters datamembers = super.createSuppliedDatamembers();

	
		
		
			datamembers.add( get_sequenceNumber_handle(), Integer.toString( get_sequenceNumber() ).getBytes() );
		
	
		return datamembers;
	}

	
	public void copyFrom( Object object ) {
		super.copyFrom( object );
		if ( object instanceof ClientMessage ) {
			ClientMessage data = (ClientMessage)object;
			
			
				_sequenceNumber = data._sequenceNumber;
			
		}
	}
}
