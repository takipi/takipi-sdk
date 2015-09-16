package com.takipi.sdk.v1.internal.impl.agent.p3;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.agent.shared.p3.bridge.TakipiInternalP3AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;
import com.takipi.sdk.v1.internal.impl.agent.p2.TakipiAgentP2ClientImpl;

public class TakipiAgentP3ClientImpl extends TakipiAgentP2ClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP3ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP3Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP3AgentBridge bridge;
	
	protected TakipiAgentP3ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP3AgentBridge bridge) {
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}
	
	@Override
	public TakipiContext createContext(Class<?> clazz, String path) {
		return TakipiAgentP1Context.create(clazz, path, bridge.createInternalContext(clazz, path));
	}
}
