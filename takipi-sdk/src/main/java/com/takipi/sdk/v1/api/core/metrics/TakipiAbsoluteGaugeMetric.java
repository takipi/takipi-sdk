package com.takipi.sdk.v1.api.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

/**
 * An interface for Takipi metrics that are aggregated using <b>gauge</b> semantics, to be determined by
 * <b>periodic setting</b> of the metric's value.<br><br>
 * 
 * When viewed on its own, gauge semantics mean that the resulting value is the most recent value that
 * has been set for the metric. When viewed across JVMs and machines, the resulting value is the sum of
 * all the values that have been collected.<br><br>
 * 
 * This metric is somewhat similar to {@link TakipiLatestMetric} in its micro-semantics, except for the
 * fact that the value of this metric does not reset between collection cycles. In addition, this metric
 * is similar to {@link TakipiSumMetric} in its macro-semantics.<br><br>
 * 
 * <b>Example:</b> The latest exchange rate between two currencies.<br>
 * Using gauge semantics and the absolute-gauge interface, one can set the exchange-rate when it changes,
 * making sure the metric retains its value as long is it is not explicitly set again using a different
 * value.<br><br>
 * 
 * See also: {@link TakipiAdjustableGaugeMetric}<br><br>
 * 
 * @author Niv Steingarten
 */
public interface TakipiAbsoluteGaugeMetric extends TakipiMetric {
	
	/**
	 * Sets the value of {@code context}'s metric to {@code value}.
	 * 
	 * @param context The context for which the metric should be set
	 * @param value The value to be set
	 */
	public void set(TakipiContext context, double value);
}
