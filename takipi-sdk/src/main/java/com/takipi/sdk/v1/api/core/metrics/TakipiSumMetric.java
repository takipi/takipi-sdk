package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>sum</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, sum semantics mean that the
 * resulting value is the summation of all the values that have been fed into the metric.<br><br>
 * 
 * This metric is somewhat similar to {@link TakipiCountMetric}, besides having a floating-point
 * value type.<br><br>
 * 
 * <b>Example:</b> The total aggregated time an application has spent running a task.<br>
 * Using sum semantics, one can measure the time it takes for a given task to complete, then feed
 * that time-span into the metric. Sum semantics mean that when viewing the aggregation, one will
 * be able to see how much time their application spent executing that task on that JVM, or across
 * JVMs and machines.
 * 
 * @author Niv Steingarten
 */
public interface TakipiSumMetric extends TakipiMetric {
	
	/**
	 * Adds {@code value} to {@code context}'s current summation.
	 * 
	 * @param context The context for which the sum should be updated
	 * @param value The amount by which to increment the sum
	 */
	public void add(TakipiContext context, double value);
}
