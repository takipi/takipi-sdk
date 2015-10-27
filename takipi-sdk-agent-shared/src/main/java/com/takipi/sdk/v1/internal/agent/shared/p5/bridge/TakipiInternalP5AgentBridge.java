package com.takipi.sdk.v1.internal.agent.shared.p5.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p4.bridge.TakipiInternalP4AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p5.core.contexts.TakipiInternalP5Context;

public interface TakipiInternalP5AgentBridge extends TakipiInternalP4AgentBridge {
	
	@Override
	public TakipiInternalP5Context createInternalContext(Class<?> clazz);
	
	@Override
	public TakipiInternalP5Context createInternalContext(Class<?> clazz, String path);
}
