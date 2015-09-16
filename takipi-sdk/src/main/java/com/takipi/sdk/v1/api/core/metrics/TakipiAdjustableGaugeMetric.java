package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * An interface for Takipi metrics that are aggregated using <b>gauge</b> semantics, to be determined by
 * <b>periodic adjustment</b> of the metric's value.<br><br>
 * 
 * When viewed on its own, gauge semantics mean that the resulting value is the most recent value that
 * has been set for the metric. When viewed across JVMs and machines, the resulting value is the sum of
 * all the values that have been collected.<br><br>
 * 
 * This metric is somewhat similar to {@link TakipiLatestMetric} in its micro-semantics, except for the
 * fact that the value of this metric does not reset between collection cycles. In addition, this metric
 * is similar to {@link TakipiSumMetric} in its macro-semantics.<br><br>
 * 
 * <b>Example:</b> The number of tasks running within a system at any given moment.<br>
 * Using gauge semantics, one can adjust the metric by +1 (increment it) whenever a task starts running,
 * and adjust it by -1 (decrement it) when it finishes. This makes sure that at any given moment, the
 * value of the metric represents the number of tasks running within the JVM. When viewed across JVMs
 * and machines, an aggregated view would show the total number of tasks running within the system.
 * <br><br>
 * 
 * See also: {@link TakipiAbsoluteGaugeMetric}<br><br>
 * 
 * @author Niv Steingarten
 */
public interface TakipiAdjustableGaugeMetric extends TakipiMetric {
	
	/**
	 * Adjusts the value of {@code context}'s metric by {@code amount}. That is, the new value of the
	 * metric would be its current value + {@code amount}.
	 * 
	 * @param context The context for which the metric should be adjusted
	 * @param amount The amount by which to adjust the value of the metric
	 */
	public void adjust(TakipiContext context, double amount);
}
