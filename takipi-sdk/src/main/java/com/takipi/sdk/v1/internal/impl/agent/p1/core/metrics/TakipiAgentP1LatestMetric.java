package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiLatestMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1LatestMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1LatestMetric extends AbstractTakipiMetric implements TakipiLatestMetric {
	
	public static TakipiLatestMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1LatestMetric internalMetric) {
		return new TakipiAgentP1LatestMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1LatestMetric internalMetric;
	
	private TakipiAgentP1LatestMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1LatestMetric internalMetric) {
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
