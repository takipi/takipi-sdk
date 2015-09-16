package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMinMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugMinMetric extends TakipiDebugMetric implements TakipiMinMetric {
	
	public static TakipiMinMetric wrap(TakipiMinMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugMinMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiMinMetric metric;
	
	private TakipiDebugMinMetric(TakipiMinMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void update(TakipiContext context, double value) {
		metric.update(context, value);
		logUpdate(context, value);
	}
}
