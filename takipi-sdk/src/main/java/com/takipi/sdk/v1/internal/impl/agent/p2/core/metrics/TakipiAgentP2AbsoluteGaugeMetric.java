package com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP2AbsoluteGaugeMetric extends AbstractTakipiMetric implements TakipiAbsoluteGaugeMetric {
	
	public static TakipiAbsoluteGaugeMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP2AbsoluteGaugeMetric internalMetric) {
		return new TakipiAgentP2AbsoluteGaugeMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP2AbsoluteGaugeMetric internalMetric;
	
	private TakipiAgentP2AbsoluteGaugeMetric(String name, TakipiMetricOptions options,
			TakipiInternalP2AbsoluteGaugeMetric internalMetric) {
		super(name, options);
		this.internalMetric = internalMetric;
	}
	
	@Override
	public void clear(TakipiContext context) {
		internalMetric.clear(((TakipiAgentP1Context)context).getInternalContext());
	}
	
	@Override
	public void set(TakipiContext context, double value) {
		internalMetric.set(((TakipiAgentP1Context)context).getInternalContext(), value);
	}
}
