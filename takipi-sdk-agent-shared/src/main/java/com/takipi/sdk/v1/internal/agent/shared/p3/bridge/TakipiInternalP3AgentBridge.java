package com.takipi.sdk.v1.internal.agent.shared.p3.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;
import com.takipi.sdk.v1.internal.agent.shared.p2.bridge.TakipiInternalP2AgentBridge;

public interface TakipiInternalP3AgentBridge extends TakipiInternalP2AgentBridge {
	
	public TakipiInternalP1Context createInternalContext(Class<?> clazz, String path);
}
