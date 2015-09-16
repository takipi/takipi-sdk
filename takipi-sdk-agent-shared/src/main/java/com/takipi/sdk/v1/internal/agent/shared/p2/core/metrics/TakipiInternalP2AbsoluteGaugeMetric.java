package com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1Metric;

public interface TakipiInternalP2AbsoluteGaugeMetric extends TakipiInternalP1Metric {
	
	public void set(TakipiInternalP1Context context, double value);
}
