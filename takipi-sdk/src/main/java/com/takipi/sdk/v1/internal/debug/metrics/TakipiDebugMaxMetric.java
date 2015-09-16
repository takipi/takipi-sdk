package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMaxMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugMaxMetric extends TakipiDebugMetric implements TakipiMaxMetric {
	
	public static TakipiMaxMetric wrap(TakipiMaxMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugMaxMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiMaxMetric metric;
	
	private TakipiDebugMaxMetric(TakipiMaxMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void update(TakipiContext context, double value) {
		metric.update(context, value);
		logUpdate(context, value);
	}
}
