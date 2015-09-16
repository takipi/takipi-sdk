package com.takipi.sdk.v1.internal.agent.shared.p4.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1AverageMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1CountMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1LatestMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MaxMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1MinMetric;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.metrics.TakipiInternalP1SumMetric;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AbsoluteGaugeMetric;
import com.takipi.sdk.v1.internal.agent.shared.p2.core.metrics.TakipiInternalP2AdjustableGaugeMetric;
import com.takipi.sdk.v1.internal.agent.shared.p3.bridge.TakipiInternalP3AgentBridge;

public interface TakipiInternalP4AgentBridge extends TakipiInternalP3AgentBridge {
	
	public TakipiInternalP1MinMetric				createInternalMinMetric(String name, Object[] options);
	public TakipiInternalP1MaxMetric				createInternalMaxMetric(String name, Object[] options);
	public TakipiInternalP1SumMetric				createInternalSumMetric(String name, Object[] options);
	public TakipiInternalP1CountMetric				createInternalCountMetric(String name, Object[] options);
	public TakipiInternalP1AverageMetric			createInternalAverageMetric(String name, Object[] options);
	public TakipiInternalP1LatestMetric				createInternalLatestMetric(String name, Object[] options);
	public TakipiInternalP2AbsoluteGaugeMetric		createInternalAbsoluteGaugeMetric(String name, Object[] options);
	public TakipiInternalP2AdjustableGaugeMetric	createInternalAdjustableGaugeMetric(String name, Object[] options);
}
