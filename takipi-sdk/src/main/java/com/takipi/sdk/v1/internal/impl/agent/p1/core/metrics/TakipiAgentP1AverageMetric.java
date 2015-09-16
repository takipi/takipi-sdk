package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAverageMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1AverageMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1AverageMetric extends AbstractTakipiMetric implements TakipiAverageMetric {
	
	public static TakipiAverageMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1AverageMetric internalMetric) {
		return new TakipiAgentP1AverageMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1AverageMetric internalMetric;
	
	private TakipiAgentP1AverageMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1AverageMetric internalMetric) {
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
