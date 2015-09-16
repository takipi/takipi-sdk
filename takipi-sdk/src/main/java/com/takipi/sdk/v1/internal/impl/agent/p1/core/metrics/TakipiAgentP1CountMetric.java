package com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiCountMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1CountMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP1CountMetric extends AbstractTakipiMetric implements TakipiCountMetric {
	
	public static TakipiCountMetric create(String name, TakipiMetricOptions options,
			TakipiInternalP1CountMetric internalMetric) {
		return new TakipiAgentP1CountMetric(name, options, internalMetric);
	}
	
	private final TakipiInternalP1CountMetric internalMetric;
	
	private TakipiAgentP1CountMetric(String name, TakipiMetricOptions options,
			TakipiInternalP1CountMetric internalMetric) {
		super(name, options);
		this.internalMetric = internalMetric;
	}
	
	@Override
	public void clear(TakipiContext context) {
		internalMetric.clear(((TakipiAgentP1Context)context).getInternalContext());
	}
	
	@Override
	public void increment(TakipiContext context) {
		increment(context, 1);
	}
	
	@Override
	public void increment(TakipiContext context, int count) {
		internalMetric.increment(((TakipiAgentP1Context)context).getInternalContext(), count);
	}
}
