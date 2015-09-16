package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiLatestMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugLatestMetric extends TakipiDebugMetric implements TakipiLatestMetric {
	
	public static TakipiLatestMetric wrap(TakipiLatestMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugLatestMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiLatestMetric metric;
	
	private TakipiDebugLatestMetric(TakipiLatestMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void set(TakipiContext context, double value) {
		metric.set(context, value);
		logUpdate(context, value);
	}
}
