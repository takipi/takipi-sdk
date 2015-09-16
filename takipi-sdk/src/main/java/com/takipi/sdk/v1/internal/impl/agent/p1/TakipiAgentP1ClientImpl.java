package com.takipi.sdk.v1.internal.impl.agent.p1;

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
import com.takipi.sdk.v1.internal.agent.shared.p1.bridge.TakipiInternalP1AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.events.TakipiAgentP1Event;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1AdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1AverageMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1CountMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1LatestMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1MaxMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1MinMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1SumMetric;

public class TakipiAgentP1ClientImpl extends TakipiAgentClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP1ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP1Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP1AgentBridge bridge;
	
	protected TakipiAgentP1ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP1AgentBridge bridge) {
		super(frameworkId, clientId, options);
		this.bridge = bridge;
	}
	
	@Override
	public TakipiContext createContext(Class<?> clazz, String path) {
		return TakipiAgentP1Context.create(clazz, path, bridge.createInternalContext(clazz));
	}
	
	@Override
	public TakipiEvent createEvent(String name) {
		return TakipiAgentP1Event.create(name, bridge.createInternalEvent(name));
	}
	
	@Override
	public TakipiMinMetric createMinMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1MinMetric.create(name, options,
				bridge.createInternalMinMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiMaxMetric createMaxMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1MaxMetric.create(name, options,
				bridge.createInternalMaxMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiSumMetric createSumMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1SumMetric.create(name, options,
				bridge.createInternalSumMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiCountMetric createCountMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1CountMetric.create(name, options,
				bridge.createInternalCountMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiAverageMetric createAverageMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1AverageMetric.create(name, options,
				bridge.createInternalAverageMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiLatestMetric createLatestMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1LatestMetric.create(name, options,
				bridge.createInternalLatestMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1AbsoluteGaugeMetric.create(name, options);
	}
	
	@Override
	public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1AdjustableGaugeMetric.create(name, options);
	}
}
