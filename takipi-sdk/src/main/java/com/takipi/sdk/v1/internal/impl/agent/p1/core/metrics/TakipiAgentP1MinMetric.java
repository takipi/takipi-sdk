package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiMinMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MinMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1MinMetric extends AbstractTakipiMetric implements TakipiMinMetric {
	
	public static TakipiMinMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1MinMetric internalMetric) {
		return new TakipiAgentP1MinMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1MinMetric internalMetric;
	
	private TakipiAgentP1MinMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1MinMetric internalMetric) {
		super(name, options);
		this.internalMetric = internalMetric;
	}
	
	@Override
	public void clear(TakipiContext context) {
		internalMetric.clear(((TakipiAgentP1Context)context).getInternalContext());
	}
	
	@Override
	public void update(TakipiContext context, double value) {
		internalMetric.update(((TakipiAgentP1Context)context).getInternalContext(), value);
	}
}
