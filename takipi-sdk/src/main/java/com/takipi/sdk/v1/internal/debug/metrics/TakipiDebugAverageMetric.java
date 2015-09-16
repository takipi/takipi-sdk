package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAverageMetric;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugAverageMetric extends TakipiDebugMetric implements TakipiAverageMetric {
	
	public static TakipiAverageMetric wrap(TakipiAverageMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		return new TakipiDebugAverageMetric(metric, logger, printPeriodMillis);
	}
	
	private final TakipiAverageMetric metric;
	
	private TakipiDebugAverageMetric(TakipiAverageMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		super(metric, logger, printPeriodMillis);
		this.metric = metric;
	}
	
	@Override
	public void update(TakipiContext context, double value) {
		metric.update(context, value);
		logUpdate(context, value);
	}
}
