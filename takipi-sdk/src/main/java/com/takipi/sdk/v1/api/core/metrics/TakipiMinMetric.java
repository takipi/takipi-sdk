package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>minimum</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, minimum semantics mean that the
 * resulting value is the smallest of any value that's been fed into the metric.<br><br>
 * 
 * <b>Example:</b> The time an event was first spotted.<br>
 * Using minimum semantics, one can feed the metric with different time-stamps across different
 * JVMs or machines, and be able to view the earliest time-stamp when viewing the aggregation.
 * 
 * @author Niv Steingarten
 */
public interface TakipiMinMetric extends TakipiMetric {
	
	/**
	 * If {@code value} is less than the current value of {@code context}'s metric, updates
	 * the value of the metric to {@code value}.
	 * 
	 * @param context The context for which the minimum should be updated
	 * @param value The new value to be incorporated into the minimum calculation
	 */
	public void update(TakipiContext context, double value);
}
