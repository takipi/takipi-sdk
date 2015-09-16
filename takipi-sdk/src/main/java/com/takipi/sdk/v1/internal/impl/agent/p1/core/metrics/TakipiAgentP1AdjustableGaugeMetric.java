package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;

public class TakipiAgentP1AdjustableGaugeMetric extends AbstractTakipiMetric implements TakipiAdjustableGaugeMetric {
	
	public static TakipiAdjustableGaugeMetric create(String name, TakipiMetricOptions options) {
		return new TakipiAgentP1AdjustableGaugeMetric(name, options);
	}
	
	private TakipiAgentP1AdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		super(name, options);
	}
	
	@Override
	public void clear(TakipiContext context) {
		
	}
	
	@Override
	public void adjust(TakipiContext context, double amount) {

	}
}
