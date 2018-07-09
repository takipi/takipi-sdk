package com.takipi.sdk.v1.internal.impl.agent.p6;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.agent.shared.p6.bridge.TakipiInternalP6AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p5.TakipiAgentP5ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p5.core.contexts.TakipiAgentP5Context;

public class TakipiAgentP6ClientImpl extends TakipiAgentP5ClientImpl
{
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP6ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP6Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP6AgentBridge bridge;
	
	protected TakipiAgentP6ClientImpl(String frameworkId, String clientId, TakipiOptions options, TakipiInternalP6AgentBridge bridge)
	{
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}
	
	public TakipiContext createInternalContext(Class<?> clazz, String methodName, String methodDesc)
	{
		String path = methodName + ";" + methodDesc;
		
		return TakipiAgentP5Context.create(clazz, path, bridge.createInternalContext(clazz, path));
	}
	
	public TakipiContext createInternalContext(long contextHash)
	{
		String path = String.valueOf(contextHash);
		
		return TakipiAgentP5Context.create(Object.class, path, bridge.createInternalContext(Object.class, path));
	}
}
