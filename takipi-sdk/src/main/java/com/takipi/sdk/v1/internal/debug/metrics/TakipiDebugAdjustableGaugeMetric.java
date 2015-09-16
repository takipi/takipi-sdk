package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugAdjustableGaugeMetric extends TakipiDebugMetric implements TakipiAdjustableGaugeMetric {
	
	public static TakipiAdjustableGaugeMetric wrap(
			TakipiAdjustableGaugeMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugAdjustableGaugeMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiAdjustableGaugeMetric metric;
	
	private TakipiDebugAdjustableGaugeMetric(
			TakipiAdjustableGaugeMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void adjust(TakipiContext context, double amount) {
		metric.adjust(context, amount);
		logUpdate(context, amount);
	}
}
