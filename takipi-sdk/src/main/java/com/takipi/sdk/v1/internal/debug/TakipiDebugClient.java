package com.takipi.sdk.v1.internal.debug;

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
import com.takipi.sdk.v1.internal.debug.contexts.TakipiDebugContext;
import com.takipi.sdk.v1.internal.debug.events.TakipiDebugEvent;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugAbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugAdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugAverageMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugCountMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugLatestMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugMaxMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugMinMetric;
import com.takipi.sdk.v1.internal.debug.metrics.TakipiDebugSumMetric;

public class TakipiDebugClient implements TakipiClient {
	
	public static TakipiClient wrap(TakipiClient client) {
		return new TakipiDebugClient(client);
	}
	
	private final TakipiClient client;
	private final TakipiDebugLogger logger;
	
	private TakipiDebugClient(TakipiClient client) {
		this.client = client;
		this.logger = TakipiDebugLogger.create(client.getFrameworkId());
	}
	
	@Override
	public String getFrameworkId() {
		return client.getFrameworkId();
	}
	
	@Override
	public String getClientId() {
		return client.getClientId();
	}
	
	@Override
	public TakipiOptions getOptions() {
		return client.getOptions();
	}
	
	@Override
	public TakipiContext createContext(Class<?> clazz, String path) {
		logger.log("Creating context: " + clazz.getName() + " [" + path + "]");
		try {
			return TakipiDebugContext.wrap(client.createContext(clazz, path), logger);
		} finally {
			logger.log("Context created: " + clazz.getName() + " [" + path + "]");
		}
	}
	
	@Override
	public TakipiEvent createEvent(String name) {
		logger.log("Creating event: " + name);
		try {
			return TakipiDebugEvent.wrap(client.createEvent(name), logger);
		} finally {
			logger.log("Event created: " + name);
		}
	}
	
	@Override
	public TakipiMinMetric createMinMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating minimum metric: " + name);
		try {
			return TakipiDebugMinMetric.wrap(client.createMinMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Minimum metric created: " + name);
		}
	}
	
	@Override
	public TakipiMaxMetric createMaxMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating maximum metric: " + name);
		try {
			return TakipiDebugMaxMetric.wrap(client.createMaxMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Maximum metric created: " + name);
		}
	}
	
	@Override
	public TakipiSumMetric createSumMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating sum metric: " + name);
		try {
			return TakipiDebugSumMetric.wrap(client.createSumMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Sum metric created: " + name);
		}
	}
	
	@Override
	public TakipiCountMetric createCountMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating count metric: " + name);
		try {
			return TakipiDebugCountMetric.wrap(client.createCountMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Count metric created: " + name);
		}
	}
	
	@Override
	public TakipiAverageMetric createAverageMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating average metric: " + name);
		try {
			return TakipiDebugAverageMetric.wrap(client.createAverageMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Average metric created: " + name);
		}
	}
	
	@Override
	public TakipiLatestMetric createLatestMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating latest metric: " + name);
		try {
			return TakipiDebugLatestMetric.wrap(client.createLatestMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Latest metric created: " + name);
		}
	}
	
	@Override
	public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating absolute gauge metric: " + name);
		try {
			return TakipiDebugAbsoluteGaugeMetric.wrap(client.createAbsoluteGaugeMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Absolute gauge metric created: " + name);
		}
	}
	
	@Override
	public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		logger.log("Creating adjustable gauge metric: " + name);
		try {
			return TakipiDebugAdjustableGaugeMetric.wrap(client.createAdjustableGaugeMetric(name, options), logger,
					client.getOptions().getDebugMetricsPrintPeriodMillis());
		} finally {
			logger.log("Adjustable gauge metric created: " + name);
		}
	}
}
