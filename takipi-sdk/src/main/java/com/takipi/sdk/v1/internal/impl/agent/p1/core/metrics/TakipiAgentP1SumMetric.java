package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiSumMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1SumMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1SumMetric extends AbstractTakipiMetric implements TakipiSumMetric {
	
	public static TakipiSumMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1SumMetric internalMetric) {
		return new TakipiAgentP1SumMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1SumMetric internalMetric;
	
	private TakipiAgentP1SumMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1SumMetric internalMetric) {
		super(name, options);
		this.internalMetric = internalMetric;
	}
	
	@Override
	public void clear(TakipiContext context) {
		internalMetric.clear(((TakipiAgentP1Context)context).getInternalContext());
	}
	
	@Override
	public void add(TakipiContext context, double value) {
		internalMetric.add(((TakipiAgentP1Context)context).getInternalContext(), value);
	}
}
