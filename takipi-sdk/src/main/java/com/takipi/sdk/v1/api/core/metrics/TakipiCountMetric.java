package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>count</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, count semantics mean that the
 * resulting value is the number of values that have been fed into the metric.<br><br>
 * 
 * This metric is somewhat similar to {@link TakipiSumMetric}, besides having an integral
 * value type.<br><br>
 * 
 * <b>Example:</b> The total number of requests received by an application.<br>
 * Using count semantics, one can increment the metric every time a request is received by the
 * application for processing. When viewing the aggregation, one can see the total amount of
 * requests processed by their application, either on a specific application instance, or
 * across JVMs and machines.
 * 
 * @author Niv Steingarten
 */
public interface TakipiCountMetric extends TakipiMetric {
	
	/**
	 * Increments {@code context}'s counter by 1.
	 * 
	 * @param context The context for which the counter should be incremented
	 */
	public void increment(TakipiContext context);
	
	/**
	 * Increments {@code context}'s counter by {@code count}.
	 * 
	 * @param context The context for which the counter should be incremented
	 * @param count The amount by which to increment the counter
	 */
	public void increment(TakipiContext context, int count);
}
