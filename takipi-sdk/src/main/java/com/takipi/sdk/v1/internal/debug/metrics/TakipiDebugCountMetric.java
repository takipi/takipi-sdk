package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiCountMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugCountMetric extends TakipiDebugMetric implements TakipiCountMetric {
	
	public static TakipiCountMetric wrap(TakipiCountMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugCountMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiCountMetric metric;
	
	private TakipiDebugCountMetric(TakipiCountMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void increment(TakipiContext context) {
		metric.increment(context);
		logUpdate(context, 1);
	}
	
	@Override
	public void increment(TakipiContext context, int count) {
		metric.increment(context, count);
		logUpdate(context, count);
	}
}
