package com.takipi.sdk.v1.internal.impl.nop;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiAverageMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiCountMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiLatestMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMaxMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiMinMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiSumMetric;
import com.takipi.sdk.v1.internal.core.AbstractTakipiMetric;

public class TakipiNopMetric extends AbstractTakipiMetric
	implements TakipiMinMetric,
			   TakipiMaxMetric,
			   TakipiSumMetric,
			   TakipiCountMetric,
			   TakipiAverageMetric,
			   TakipiLatestMetric,
			   TakipiAbsoluteGaugeMetric,
			   TakipiAdjustableGaugeMetric {
	
	public static TakipiNopMetric create(String name, TakipiMetricOptions options) {
		return new TakipiNopMetric(name, options);
	}
	
	private TakipiNopMetric(String name, TakipiMetricOptions options) {
		super(name, options);
	}
	
	@Override
	public void clear(TakipiContext context) {}
	
	@Override
	public void increment(TakipiContext context) {}
	
	@Override
	public void increment(TakipiContext context, int count) {}
	
	@Override
	public void add(TakipiContext context, double value) {}
	
	@Override
	public void update(TakipiContext context, double value) {}
	
	@Override
	public void set(TakipiContext context, double value) {}
	
	@Override
	public void adjust(TakipiContext context, double amount) {}
}
