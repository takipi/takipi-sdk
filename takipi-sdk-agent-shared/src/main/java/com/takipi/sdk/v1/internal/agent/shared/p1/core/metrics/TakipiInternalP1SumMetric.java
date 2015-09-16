package com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;

public interface TakipiInternalP1SumMetric extends TakipiInternalP1Metric {
	
	public void add(TakipiInternalP1Context context, double value);
}
