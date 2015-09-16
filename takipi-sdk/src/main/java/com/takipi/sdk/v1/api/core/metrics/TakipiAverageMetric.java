package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * The interface for Takipi metrics that are aggregated using <b>average</b> semantics.<br><br>
 * 
 * When viewed on its own, or across JVMs and machines, average semantics mean that the
 * resulting value is the average of all the values that have been fed into the metric.<br><br>
 * 
 * <b>Example:</b> The average time it takes to process a message in an application.<br>
 * Using average semantics, one can measure the time it takes for a given message to be processed
 * in their application, then feed that time-span into the metric. Average semantics mean that when
 * viewing the aggregation, one will be able to see how much time their application spent <i>on
 * average</i> processing these messages on that JVM, or across JVMs and machines.
 * 
 * @author Niv Steingarten
 */
public interface TakipiAverageMetric extends TakipiMetric {
	
	/**
	 * Updates {@code context}'s average with {@code value}.
	 * 
	 * @param context The context for which the average should be updated
	 * @param value The new value to be included in the average
	 */
	public void update(TakipiContext context, double value);
}
