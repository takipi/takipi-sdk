package com.takipi.sdk.v1.internal.impl.agent.p4;

import com.takipi.sdk.v1.api.TakipiOptions;
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
import com.takipi.sdk.v1.internal.agent.shared.p4.bridge.TakipiInternalP4AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1AverageMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1CountMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1LatestMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1MaxMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1MinMetric;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.metrics.TakipiAgentP1SumMetric;
import com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics.TakipiAgentP2AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics.TakipiAgentP2AdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.impl.agent.p3.TakipiAgentP3ClientImpl;

public class TakipiAgentP4ClientImpl extends TakipiAgentP3ClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP4ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP4Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP4AgentBridge bridge;
	
	protected TakipiAgentP4ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP4AgentBridge bridge) {
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}
	
	@Override
	public TakipiMinMetric createMinMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1MinMetric.create(name, options,
				bridge.createInternalMinMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiMaxMetric createMaxMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1MaxMetric.create(name, options,
				bridge.createInternalMaxMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiSumMetric createSumMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1SumMetric.create(name, options,
				bridge.createInternalSumMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiCountMetric createCountMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1CountMetric.create(name, options,
				bridge.createInternalCountMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiAverageMetric createAverageMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1AverageMetric.create(name, options,
				bridge.createInternalAverageMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiLatestMetric createLatestMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP1LatestMetric.create(name, options,
				bridge.createInternalLatestMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP2AbsoluteGaugeMetric.create(name, options,
				bridge.createInternalAbsoluteGaugeMetric(name, flatten(options)));
	}
	
	@Override
	public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP2AdjustableGaugeMetric.create(name, options,
				bridge.createInternalAdjustableGaugeMetric(name, flatten(options)));
	}
	
	private static Object[] flatten(TakipiMetricOptions options) {
		return new Object[] {
				options.getDisplayName(),
				options.getUnit().name(),
				options.getUnitSuffix(),
				options.getUnitPluralSuffix(),
				options.getBrackets() };
	}
}
