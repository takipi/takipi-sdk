package com.takipi.sdk.v1.internal.agent.shared.p1.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.events.TakipiInternalP1Event;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1AverageMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1CountMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1LatestMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MaxMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MinMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1SumMetric;

public interface TakipiInternalP1AgentBridge {
	
	public TakipiInternalP1Context			createInternalContext(Class<?> clazz);
	
	public TakipiInternalP1Event			createInternalEvent(String name);
	
	public TakipiInternalP1MinMetric		createInternalMinMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	public TakipiInternalP1MaxMetric		createInternalMaxMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	public TakipiInternalP1SumMetric		createInternalSumMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	public TakipiInternalP1CountMetric		createInternalCountMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	public TakipiInternalP1AverageMetric	createInternalAverageMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
	public TakipiInternalP1LatestMetric		createInternalLatestMetric(String name, String displayName, String unit, String unitSuffix, String unitPluralSuffix);
}
