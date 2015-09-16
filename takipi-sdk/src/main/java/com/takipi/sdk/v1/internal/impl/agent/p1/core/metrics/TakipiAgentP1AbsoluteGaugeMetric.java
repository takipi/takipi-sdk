package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;

public class TakipiAgentP1AbsoluteGaugeMetric extends AbstractTakipiMetric implements TakipiAbsoluteGaugeMetric {
	
	public static TakipiAbsoluteGaugeMetric create(String name, TakipiMetricOptions options) {
		return new TakipiAgentP1AbsoluteGaugeMetric(name, options);
	}
	
	private TakipiAgentP1AbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		super(name, options);
	}
	
	@Override
	public void clear(TakipiContext context) {
		
	}
	
	@Override
	public void set(TakipiContext context, double value) {
		
	}
}
