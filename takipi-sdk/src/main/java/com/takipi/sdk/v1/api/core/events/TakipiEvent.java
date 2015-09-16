package com.takipi.sdk.v1.api.core.events;

/**
 * An interface implemented by custom named events in Takipi. Custom events allow for capturing of data
 * snapshots and event metrics for special points of interest in an application.
 * 
 * @author Niv Steingarten
 */
public interface TakipiEvent {
	
	/**
	 * Notifies the Takipi agent that an instance of the event occurred. This causes the collection
	 * of event metrics and possibly a data snapshot, using default options.<br><br>
	 * 
	 * Invoking this method is equivalent to invoking: {@code fire(TakipiEventFireOptions.DEFAULT)}
	 * 
	 * @return A {@link TakipiEventResult} object containing event instance information.
	 */
	public TakipiEventResult fire();
	
	/**
	 * Notifies the Takipi agent that an instance of the event occurred. This causes the collection
	 * of event metrics and possibly a data snapshot, using the custom options specified in
	 * {@code options} (see {@link TakipiEventFireOptions}.
	 * 
	 * @param options Custom options to use when processing the event instance
	 * @return A {@link TakipiEventResult} object containing event instance information
	 */
	public TakipiEventResult fire(TakipiEventFireOptions options);
}
