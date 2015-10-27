package com.takipi.sdk.v1.api.core.contexts;

/**
 * An interface implemented by contexts of metrics and events in Takipi. The context for events is determined
 * automatically by the Takipi agent. The contexts for metrics are supplied to the metrics explicitly upon update.
 * 
 * @author Niv Steingarten
 */
public interface TakipiContext {
	
	/**
	 * Notifies the Takipi runtime that the context represented by this {@link TakipiContext} instance is
	 * no longer in use and may be disposed.<br><br>
	 * 
	 * Invoking this method does not guarantee <i>immediate</i> disposal of the context or the resources
	 * associated with it, but rather signals the runtime, which will do so in a timely manner.<br><br>
	 * 
	 * <b>Note:</b> A context may be represented by multiple {@code TakipiContext} instances (i.e.
	 * context equality is not determined by {@code TakipiContext} reference equality). Calling
	 * {@code dispose} on a {@code TakipiContext} instance disposes of the <i>underlying</i> context,
	 * and not just the instance on which it is invoked, thus rendering all other equivalent
	 * {@code TakipiContext} instances invalid.
	 */
	public void dispose();
}
