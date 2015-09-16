package com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP2AdjustableGaugeMetric extends AbstractTakipiMetric implements TakipiAdjustableGaugeMetric {
	
	public static TakipiAdjustableGaugeMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP2AdjustableGaugeMetric internalMetric) {
		return new TakipiAgentP2AdjustableGaugeMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP2AdjustableGaugeMetric internalMetric;
	
	private TakipiAgentP2AdjustableGaugeMetric(String name, TakipiMetricOptions options,
			TakipiInternalP2AdjustableGaugeMetric internalMetric) {
		super(name, options);
		this.internalMetric = internalMetric;
	}
	
	@Override
	public void clear(TakipiContext context) {
		internalMetric.clear(((TakipiAgentP1Context)context).getInternalContext());
	}
	
	@Override
	public void adjust(TakipiContext context, double amount) {
		internalMetric.adjust(((TakipiAgentP1Context)context).getInternalContext(), amount);
	}
}
