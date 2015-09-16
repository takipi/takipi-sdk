package com.takipi.sdk.v1.internal.impl.nop;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiAverageMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiCountMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiLatestMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMaxMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiMinMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiSumMetric;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.impl.AbstractTakipiClientImpl;

public class TakipiNopClientImpl extends AbstractTakipiClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiNopClientImpl(frameworkId, clientId, options);
	}
	
	private TakipiNopClientImpl(String frameworkId, String clientId, TakipiOptions options) {
		super(frameworkId, clientId, options);
	}
	
	@Override
	public TakipiContext createContext(Class<?> clazz, String path) {
		return TakipiNopContext.create(clazz, path);
	}
	
	@Override
	public TakipiEvent createEvent(String name) {
		return TakipiNopEvent.create(name);
	}
	
	@Override
	public TakipiMinMetric createMinMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiMaxMetric createMaxMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiSumMetric createSumMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiCountMetric createCountMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiAverageMetric createAverageMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiLatestMetric createLatestMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
	
	@Override
	public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiNopMetric.create(name, options);
	}
}
