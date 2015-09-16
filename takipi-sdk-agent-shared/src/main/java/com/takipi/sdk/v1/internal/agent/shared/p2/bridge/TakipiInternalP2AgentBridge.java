package com.takipi.sdk.v1.internal.agent.shared.p2.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p1.bridge.TakipiInternalP1AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AdjustableGaugeMetric;

public interface TakipiInternalP2AgentBridge extends TakipiInternalP1AgentBridge {
	
	public TakipiInternalP2AbsoluteGaugeMetric createInternalAbsoluteGaugeMetric(
			String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	
	public TakipiInternalP2AdjustableGaugeMetric createInternalAdjustableGaugeMetric(
			String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
}
