package com.takipi.sdk.v1.internal.core;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;

public abstract class AbstractTakipiMetric extends AbstractTakipiNamedEntity implements TakipiMetric {
	
	private final TakipiMetricOptions options;
	
	protected AbstractTakipiMetric(String name, TakipiMetricOptions options) {
		super(name);
		this.options = options;
	}
	
	@Override
	public TakipiMetricOptions getOptions() {
		return options;
	}
	
	@Override
	public abstract void clear(TakipiContext context);
}
