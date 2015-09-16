package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * An interface implemented by custom named metrics in Takipi. Custom metrics allow for capturing of
 * special application metrics with various aggregation semantics (e.g. average, max...). These metrics
 * are associated with application contexts and are periodically collected by the Takipi agent.
 * 
 * @author Niv Steingarten
 */
public interface TakipiMetric {
	
	/**
	 * Returns the {@link TakipiMetricOptions} instance with which the metric was constructed. A
	 * default instance exists regardless of whether or not such options were passed explicitly.<br><br>
	 * 
	 * @return The options with which the metric was constructed
	 */
	public TakipiMetricOptions getOptions();
	
	/**
	 * Clears and resets {@code context}'s metric. Clearing a metric notifies the Takipi agent to
	 * disregard the metric in upcoming collection cycles, or until the metric is fed new data, which
	 * in turn puts it back in the collection pool.
	 * 
	 * @param context The context for which to clear the metric
	 */
	public void clear(TakipiContext context);
}
