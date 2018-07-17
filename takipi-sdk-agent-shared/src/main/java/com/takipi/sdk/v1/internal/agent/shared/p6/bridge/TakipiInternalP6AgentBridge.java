package com.takipi.sdk.v1.internal.agent.shared.p6.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p5.bridge.TakipiInternalP5AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p5.core.contexts.TakipiInternalP5Context;

public interface TakipiInternalP6AgentBridge extends TakipiInternalP5AgentBridge {
	
	public TakipiInternalP5Context createInternalContext(Class<?> clazz, String methodName, String methodDesc);
	public TakipiInternalP5Context createInternalContext(long contextHash);
}

