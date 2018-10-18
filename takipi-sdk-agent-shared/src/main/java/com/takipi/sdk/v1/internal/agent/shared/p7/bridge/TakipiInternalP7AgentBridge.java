package com.takipi.sdk.v1.internal.agent.shared.p7.bridge;

import com.takipi.sdk.v1.internal.agent.shared.p6.bridge.TakipiInternalP6AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p7.core.events.TakipiInternalP7Event;

public interface TakipiInternalP7AgentBridge extends TakipiInternalP6AgentBridge {
	
	@Override
	public TakipiInternalP7Event createInternalEvent(String name);
}

