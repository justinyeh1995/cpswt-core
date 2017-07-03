package EchoExample;

import hla.rti.EventRetractionHandle;
import hla.rti.LogicalTime;
import hla.rti.ReceivedInteraction;

import c2w.hla.C2WInteractionRoot;
import c2w.hla.InteractionRoot;
import c2w.hla.SubscribedInteractionFilter;
import c2w.hla.SynchronizedFederate;


import org.cpswt.config.FederateConfig;

public class EchoServerBase extends SynchronizedFederate {

	private SubscribedInteractionFilter _subscribedInteractionFilter = new SubscribedInteractionFilter();
	
	// constructor
	public EchoServerBase(FederateConfig params) throws Exception {
		super(params);

		super.createLRC();
		super.joinFederation();
		super.publishFederateInfoObject();

		super.enableTimeConstrained();
		super.enableTimeRegulation(getLookAhead());
		super.enableAsynchronousDelivery();

        // interaction pubsub
        ServerReply.publish( getLRC() );

        ClientMessage.subscribe( getLRC() );
        _subscribedInteractionFilter.setFedFilters( 
			ClientMessage.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);		// object pubsub
	}
	
	public ServerReply create_ServerReply() {
	   ServerReply interaction = new ServerReply();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	@Override
	public void receiveInteraction(
	 int interactionClass, ReceivedInteraction theInteraction, byte[] userSuppliedTag
	) {
		InteractionRoot interactionRoot = InteractionRoot.create_interaction( interactionClass, theInteraction );
		if ( interactionRoot instanceof C2WInteractionRoot ) {
			
			C2WInteractionRoot c2wInteractionRoot = (C2WInteractionRoot)interactionRoot;

	        // Filter interaction if src/origin fed requirements (if any) are not met
	        if (  _subscribedInteractionFilter.filterC2WInteraction( getFederateId(), c2wInteractionRoot )  ) {
	        	return;
	        } 
		}
		
		super.receiveInteraction( interactionClass, theInteraction, userSuppliedTag );			
	}

	@Override
	public void receiveInteraction(
	 int interactionClass,
	 ReceivedInteraction theInteraction,
	 byte[] userSuppliedTag,
	 LogicalTime theTime,
	 EventRetractionHandle retractionHandle
	) {
		InteractionRoot interactionRoot = InteractionRoot.create_interaction( interactionClass, theInteraction, theTime );
		if ( interactionRoot instanceof C2WInteractionRoot ) {

			C2WInteractionRoot c2wInteractionRoot = (C2WInteractionRoot)interactionRoot;

	        // Filter interaction if src/origin fed requirements (if any) are not met
	        if (  _subscribedInteractionFilter.filterC2WInteraction( getFederateId(), c2wInteractionRoot )  ) {
	        	return;
	        } 
		}

		super.receiveInteraction( interactionClass, theInteraction, userSuppliedTag, theTime, retractionHandle );			
	}
}
