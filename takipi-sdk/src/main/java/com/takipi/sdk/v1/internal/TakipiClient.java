package com.takipi.sdk.v1.internal;

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

public interface TakipiClient {
	
	public String getFrameworkId();
	public String getClientId();
	
	public TakipiOptions getOptions();
	
	public TakipiContext				createContext(Class<?> clazz, String path);
	
	public TakipiEvent					createEvent(String name);
	
	public TakipiMinMetric				createMinMetric(String name, TakipiMetricOptions options);
	public TakipiMaxMetric				createMaxMetric(String name, TakipiMetricOptions options);
	public TakipiSumMetric				createSumMetric(String name, TakipiMetricOptions options);
	public TakipiCountMetric			createCountMetric(String name, TakipiMetricOptions options);
	public TakipiAverageMetric			createAverageMetric(String name, TakipiMetricOptions options);
	public TakipiLatestMetric			createLatestMetric(String name, TakipiMetricOptions options);
	public TakipiAbsoluteGaugeMetric	createAbsoluteGaugeMetric(String name, TakipiMetricOptions options);
	public TakipiAdjustableGaugeMetric	createAdjustableGaugeMetric(String name, TakipiMetricOptions options);
}
