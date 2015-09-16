package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>maximum</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, maximum semantics mean that the
 * resulting value is the largest of any value that's been fed into the metric.<br><br>
 * 
 * <b>Example:</b> The maximum number of elements that have been observed in a queue.<br>
 * Using maximum semantics, one can feed the metric with the size of a given queue every time
 * a new element is inserted into it. Feeding this metric across different JVMs and machines,
 * allows one to view the longest queue that's been observed across the cluster, when viewing
 * the aggregation.
 * 
 * @author Niv Steingarten
 */
public interface TakipiMaxMetric extends TakipiMetric {
	
	/**
	 * If {@code value} is greater than the current value of {@code context}'s metric,
	 * updates the value of the metric to {@code value}.
	 * 
	 * @param context The context for which the maximum should be updated
	 * @param value The new value to be incorporated into the maximum calculation
	 */
	public void update(TakipiContext context, double value);
}
