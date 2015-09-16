package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiSumMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugSumMetric extends TakipiDebugMetric implements TakipiSumMetric {
	
	public static TakipiSumMetric wrap(TakipiSumMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugSumMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiSumMetric metric;
	
	private TakipiDebugSumMetric(TakipiSumMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void add(TakipiContext context, double value) {
		metric.add(context, value);
		logUpdate(context, value);
	}
}
