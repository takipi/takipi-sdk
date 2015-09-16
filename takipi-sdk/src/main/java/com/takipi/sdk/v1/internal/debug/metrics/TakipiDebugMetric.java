package com.takipi.sdk.v1.internal.debug.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public abstract class TakipiDebugMetric implements TakipiMetric {
	
	private final TakipiMetric metric;
	private final TakipiDebugLogger logger;
	
	private final long printPeriodMillis;
	private volatile long lastPrintTime;
	
	protected TakipiDebugMetric(TakipiMetric metric, TakipiDebugLogger logger, long printPeriodMillis) {
		this.metric = metric;
		this.logger = logger;
		
		this.printPeriodMillis = printPeriodMillis;
		this.lastPrintTime = 0l;
	}
	
	@Override
	public TakipiMetricOptions getOptions() {
		return metric.getOptions();
	}
	
	@Override
	public void clear(TakipiContext context) {
		metric.clear(context);
		
		long now = System.currentTimeMillis();
		if (now - lastPrintTime > printPeriodMillis) {
			logger.log("Clearing " + metric.toString() + " for " + context);
			lastPrintTime = now;
		}
	}
	
	protected void logUpdate(TakipiContext context, Object value) {
		long now = System.currentTimeMillis();
		if (now - lastPrintTime > printPeriodMillis) {
			logger.log("Updating " + metric.toString() + " for " + context + " with " + value);
			lastPrintTime = now;
		}
	}
}
