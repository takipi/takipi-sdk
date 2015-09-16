package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugAbsoluteGaugeMetric extends TakipiDebugMetric implements TakipiAbsoluteGaugeMetric {
	
	public static TakipiAbsoluteGaugeMetric wrap(
			TakipiAbsoluteGaugeMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugAbsoluteGaugeMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiAbsoluteGaugeMetric metric;
	
	private TakipiDebugAbsoluteGaugeMetric(
			TakipiAbsoluteGaugeMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void set(TakipiContext context, double value) {
		metric.set(context, value);
		logUpdate(context, value);
	}
}
