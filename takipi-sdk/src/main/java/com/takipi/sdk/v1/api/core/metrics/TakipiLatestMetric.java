package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>latest</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, latest semantics mean that the
 * resulting value is the most recent of all the values that have been fed into the metric.<br><br>
 * 
 * This metric is somewhat similar to {@link TakipiAbsoluteGaugeMetric} and
 * {@link TakipiAdjustableGaugeMetric} in its micro-semantics, except for the fact that the value of
 * this metric resets between collection cycles.<br><br>
 * 
 * <b>Example:</b> The message ID of the most recent message that's been processed by a system.<br>
 * Using latest semantics, one can feed the metric with the ID of a message whenever one gets processed
 * by their system. Feeding this metric across different JVMs and machines, allows one to view the most
 * recent message ID that's been observed across the cluster, when viewing the aggregation.
 * 
 * @author Niv Steingarten
 */
public interface TakipiLatestMetric extends TakipiMetric {
	
	/**
	 * Sets the value of {@code context}'s metric to {@code value}.
	 * 
	 * @param context The context for which the metric should be set
	 * @param value The latest value to be set
	 */
	public void set(TakipiContext context, double value);
}
