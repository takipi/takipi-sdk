package com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;

public interface TakipiInternalP1CountMetric extends TakipiInternalP1Metric {
	
	public void increment(TakipiInternalP1Context context, int count);
}
