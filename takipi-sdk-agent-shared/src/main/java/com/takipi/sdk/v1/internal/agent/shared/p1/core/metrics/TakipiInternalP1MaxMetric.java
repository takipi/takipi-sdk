package com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;

public interface TakipiInternalP1MaxMetric extends TakipiInternalP1Metric {
	
	public void update(TakipiInternalP1Context context, double value);
}
