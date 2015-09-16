package com.takipi.sdk.v1.api.core.events;

/**
 * An interface implemented by the data structure returned by {@link TakipiEvent#fire()} and its
 * various overloads.<br><br>
 * 
 * This structure contains information about the event instance that was fired, such as the data
 * snapshot's unique ID.
 * 
 * @author Niv Steingarten
 */
public interface TakipiEventResult {
	
	/**
	 * Returns whether or not this instance of the event generated a data snapshot.
	 * 
	 * @return {@code true} if this event instance generated a data snapshot; {@code false} otherwise.
	 */
	public boolean hasSnapshot();
	
	/**
	 * Returns the event instance's data snapshot's unique ID, or {@code null} if no snapshot was
	 * generated during the firing of this event instance.
	 * 
	 * @return The data snapshot's unique ID, or {@code null} if none.
	 */
	public String getSnapshotId();
}
