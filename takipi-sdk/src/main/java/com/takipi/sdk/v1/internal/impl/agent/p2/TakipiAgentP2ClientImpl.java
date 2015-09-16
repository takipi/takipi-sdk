package com.takipi.sdk.v1.internal.impl.agent.p2;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiAbsoluteGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiAdjustableGaugeMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiMetricOptions;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.agent.shared.p2.bridge.TakipiInternalP2AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p1.TakipiAgentP1ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics.TakipiAgentP2AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.impl.agent.p2.core.metrics.TakipiAgentP2AdjustableGaugeMetric;

public class TakipiAgentP2ClientImpl extends TakipiAgentP1ClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP2ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP2Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP2AgentBridge bridge;
	
	protected TakipiAgentP2ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP2AgentBridge bridge) {
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}
	
	@Override
	public TakipiAbsoluteGaugeMetric createAbsoluteGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP2AbsoluteGaugeMetric.create(name, options,
				bridge.createInternalAbsoluteGaugeMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
	
	@Override
	public TakipiAdjustableGaugeMetric createAdjustableGaugeMetric(String name, TakipiMetricOptions options) {
		return TakipiAgentP2AdjustableGaugeMetric.create(name, options,
				bridge.createInternalAdjustableGaugeMetric(name,
						options.getDisplayName(), options.getUnit().name(),
						options.getUnitSuffix(), options.getUnitPluralSuffix()));
	}
}
