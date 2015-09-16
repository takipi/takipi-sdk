package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMaxMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MaxMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1MaxMetric extends AbstractTakipiMetric implements TakipiMaxMetric {
	
	public static TakipiMaxMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1MaxMetric internalMetric) {
		return new TakipiAgentP1MaxMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1MaxMetric internalMetric;
	
	private TakipiAgentP1MaxMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1MaxMetric internalMetric) {
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
