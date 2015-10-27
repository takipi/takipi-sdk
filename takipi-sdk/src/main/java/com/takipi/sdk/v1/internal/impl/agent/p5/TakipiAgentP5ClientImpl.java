package com.takipi.sdk.v1.internal.impl.agent.p5;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.agent.shared.p5.bridge.TakipiInternalP5AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p4.TakipiAgentP4ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p5.core.contexts.TakipiAgentP5Context;

public class TakipiAgentP5ClientImpl extends TakipiAgentP4ClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP5ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP5Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP5AgentBridge bridge;
	
	private TakipiAgentP5ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP5AgentBridge bridge) {
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}
	
	@Override
	public TakipiContext createContext(Class<?> clazz, String path) {
		return TakipiAgentP5Context.create(clazz, path, bridge.createInternalContext(clazz, path));
	}
}
