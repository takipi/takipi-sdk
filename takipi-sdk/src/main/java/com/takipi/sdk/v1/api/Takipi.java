package com.takipi.sdk.v1.api;

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
import com.takipi.sdk.v1.internal.impl.TakipiClientFactory;
import com.takipi.sdk.v1.internal.util.Assert;
import com.takipi.sdk.v1.internal.util.Strings;

/**
 * The entry point for the Takipi SDK.<br><br>
 * 
 * The SDK allows for the creation of custom metrics for application entry points
 * and custom events for recording and analyzing application events of significance.
 * 
 * @author Niv Steingarten
 */
public class Takipi {
	
	/**
	 * Returns an instance of the {@link Takipi} class, which is the entry point for
	 * the entire SDK functionality. The instance is configured using the default options.<br><br>
	 * 
	 * Invoking this method is equivalent to calling: {@code create(frameworkId, TakipiOptions.DEFAULT)}
	 * 
	 * @param frameworkId A globally unique ID representing the framework to which the instance relates
	 * @return An instance of the {@link Takipi} class
	 */
	public static Takipi create(String frameworkId) {
		return create(frameworkId, TakipiOptions.DEFAULT);
	}
	
	/**
	 * Returns an instance of the {@link Takipi} class, which is the entry point for
	 * the entire SDK functionality. The instance is configured using the provided
	 * {@link TakipiOptions}.
	 * 
	 * @param frameworkId A globally unique ID representing the framework to which the instance relates
	 * @param options Configurable options for the Takipi SDK
	 * @return An instance of the {@link Takipi} class
	 */
	public static Takipi create(String frameworkId, TakipiOptions options) {
		Assert.notNullOrEmpty(frameworkId, "Framework ID must not be null or empty");
		Assert.notNull(options, "Options must not be null");
		
		return new Takipi(TakipiClientFactory.create(frameworkId, options));
	}
	
	private volatile TakipiClient client;
	
	private final Contexts contexts;
	private final Events events;
	private final Metrics metrics;
	
	private Takipi(TakipiClient client) {
		this.client = client;
		
		this.contexts = new Contexts();
		this.events = new Events();
		this.metrics = new Metrics();
	}
	
	/**
	 * Returns an instance of the {@link Takipi.Contexts} class, which is the entry point for
	 * functionality pertaining to Takipi contexts. Namely, creating and managing contexts.
	 * 
	 * @return An instance of the {@link Takipi.Contexts} class
	 */
	public final Contexts contexts() {
		return contexts;
	}
	
	/**
	 * Returns an instance of the {@link Takipi.Events} class, which is the entry point for
	 * functionality pertaining to Takipi events. Namely, creating and managing custom events.
	 * 
	 * @return An instance of the {@link Takipi.Events} class
	 */
	public final Events events() {
		return events;
	}
	
	/**
	 * Returns an instance of the {@link Takipi.Metrics} class, which is the entry point for
	 * functionality pertaining to Takipi metrics. Namely, creating and managing custom metrics.
	 * 
	 * @return An instance of the {@link Takipi.Metrics} class
	 */
	public final Metrics metrics() {
		return metrics;
	}
	
	/**
	 * The entry point for all functionality pertaining to Takipi contexts.<br><br>
	 * 
	 * This class allows for the creation of context helper classes for use when manipulating
	 * Takipi data model entities (e.g. metrics).
	 * 
	 * @author Niv Steingarten
	 */
	public final class Contexts {
		
		private Contexts() {}
		
		/**
		 * Returns an instance of {@link TakipiContext} representing the given class.<br><br>
		 * 
		 * Takipi contexts represent application entry-points and other distinct application-space entities,
		 * and are used for differentiation when collecting metrics. Metrics are collected on a per-context
		 * basis, and are aggregated separately by context.<br><br>
		 * 
		 * Invoking this method is equivalent to calling: {@code createContext(clazz, null)}
		 * 
		 * @param clazz The class this context object represents
		 * @return An instance of {@link TakipiContext} representing the given class
		 */
		public TakipiContext createContext(Class<?> clazz) {
			return createContext(clazz, null);
		}
		
		/**
		 * Returns an instance of {@link TakipiContext} representing an entity denoted by the given path,
		 * under the given class.<br><br>
		 * 
		 * Takipi contexts represent application entry-points and other distinct application-space entities,
		 * and are used for differentiation when collecting metrics. Metrics are collected on a per-context
		 * basis, and are aggregated separately by context.
		 * 
		 * @param clazz The class this context object represents
		 * @param path A path identifying the application entity this context represents. May be {@code null}
		 * @return An instance of {@link TakipiContext} representing the given class and path
		 */
		public TakipiContext createContext(Class<?> clazz, String path) {
			Assert.notNull(clazz, "Context class must not be null");
			
			return client.createContext(clazz, Strings.nonNull(path));
		}
	}
	
	/**
	 * The entry point for all functionality pertaining to Takipi events.<br><br>
	 * 
	 * This class allows for the creation of custom events for capturing snapshots and analytics for special
	 * points of interest in the application.
	 * 
	 * @author Niv Steingarten
	 */
	public final class Events {
		
		private Events() {}
		
		/**
		 * Creates and returns an instance of an event named {@code name}.<br><br>
		 * 
		 * The Takipi agent collects metrics and snapshots for events for visualization and analysis.
		 * These metrics include the number of times the event happened, the number of times the enclosing
		 * method has executed, along with time-stamps and entry-point information. Snapshots of data across
		 * the stack are sampled by the agent in order to impose minimal impact on monitored applications.
		 * 
		 * @param name The name of the event
		 * @return An instance of {@link TakipiEvent} representing the named event
		 */
		public TakipiEvent createEvent(String name) {
			Assert.notNullOrEmpty(name, "Event name must not be null or empty");
			
			return client.createEvent(name);
		}
	}
	
	/**
	 * The entry point for all functionality pertaining to Takipi metrics.<br><br>
	 * 
	 * This class allows for the creation of custom application metrics with different aggregation
	 * semantics (e.g. average, min, max, sum...). Metrics are collected per context, and are
	 * periodically collected and aggregated by the Takipi agent.
	 * 
	 * @author Niv Steingarten
	 */
	public final class Metrics {
		
		private Metrics() {}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>minimum</b> semantics. The instance is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createMinMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiMinMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiMinMetric} representing the named metric
		 */
		public TakipiMinMetric createMinMetric(String name) {
			return createMinMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>minimum</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiMinMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiMinMetric} representing the named metric
		 */
		public TakipiMinMetric createMinMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createMinMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>maximum</b> semantics. The instance is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createMaxMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiMaxMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiMaxMetric} representing the named metric
		 */
		public TakipiMaxMetric createMaxMetric(String name) {
			return createMaxMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>maximum</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiMaxMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiMaxMetric} representing the named metric
		 */
		public TakipiMaxMetric createMaxMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createMaxMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>sum</b> semantics. The instance is configured using the default options.<br><br>
		 *
		 * Invoking this method is equivalent to calling:
		 * {@code createSumMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiSumMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiSumMetric} representing the named metric
		 */
		public TakipiSumMetric createSumMetric(String name) {
			return createSumMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>sum</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 *
		 * See {@link TakipiSumMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiSumMetric} representing the named metric
		 */
		public TakipiSumMetric createSumMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createSumMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>count</b> semantics. The instance is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createCountMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiCountMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiCountMetric} representing the named metric
		 */
		public TakipiCountMetric createCountMetric(String name) {
			return createCountMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>count</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiCountMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiCountMetric} representing the named metric
		 */
		public TakipiCountMetric createCountMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createCountMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>average</b> semantics. The instance is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createAverageMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiAverageMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiAverageMetric} representing the named metric
		 */
		public TakipiAverageMetric createAverageMetric(String name) {
			return createAverageMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>average</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiAverageMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiAverageMetric} representing the named metric
		 */
		public TakipiAverageMetric createAverageMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createAverageMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>latest</b> semantics. The instance is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createLatestMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiLatestMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiLatestMetric} representing the named metric
		 */
		public TakipiLatestMetric createLatestMetric(String name) {
			return createLatestMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>latest</b> semantics. The instance is configured using the provided
		 * {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiLatestMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiLatestMetric} representing the named metric
		 */
		public TakipiLatestMetric createLatestMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createLatestMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>gauge</b> semantics, via <b>periodic setting</b> of the metric's value. The instance
		 * is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createAbsoluteGaugeMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiAbsoluteGaugeMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiAbsoluteGaugeMetric} representing the named metric
		 */
		public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name) {
			return createAbsoluteGaugeMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>gauge</b> semantics, via <b>periodic setting</b> of the metric's value. The instance
		 * is configured using the provided {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiAbsoluteGaugeMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiAbsoluteGaugeMetric} representing the named metric
		 */
		public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createAbsoluteGaugeMetric(name, options);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>gauge</b> semantics, via <b>periodic adjustment</b> of the metric's value. The instance
		 * is configured using the default options.<br><br>
		 * 
		 * Invoking this method is equivalent to calling:
		 * {@code createAdjustableGaugeMetric(name, TakipiMetricOptions.DEFAULT)}<br><br>
		 * 
		 * See {@link TakipiAdjustableGaugeMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @return An instance of {@link TakipiAdjustableGaugeMetric} representing the named metric
		 */
		public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name) {
			return createAdjustableGaugeMetric(name, TakipiMetricOptions.DEFAULT);
		}
		
		/**
		 * Creates and returns an instance of a metric named {@code name}, to be aggregated using
		 * <b>gauge</b> semantics, via <b>periodic adjustment</b> of the metric's value. The instance
		 * is configured using the provided {@link TakipiMetricOptions}.<br><br>
		 * 
		 * See {@link TakipiAdjustableGaugeMetric} for details.
		 * 
		 * @param name The name of the metric
		 * @param options Configurable options for the metric
		 * @return An instance of {@link TakipiAdjustableGaugeMetric} representing the named metric
		 */
		public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
			Assert.notNullOrEmpty(name, "Metric name must not be null or empty");
			Assert.notNull(options, "Options must not be null");
			
			return client.createAdjustableGaugeMetric(name, options);
		}
	}
}
