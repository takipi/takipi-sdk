package com.takipi.sdk.v1.internal.impl.agent.p7;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.agent.shared.p7.bridge.TakipiInternalP7AgentBridge;
import com.takipi.sdk.v1.internal.impl.agent.TakipiAgentInterface;
import com.takipi.sdk.v1.internal.impl.agent.p6.TakipiAgentP6ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p7.core.events.TakipiAgentP7Event;

public class TakipiAgentP7ClientImpl extends TakipiAgentP6ClientImpl {
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options) {
		return new TakipiAgentP7ClientImpl(frameworkId, clientId, options,
				TakipiAgentInterface.create().createP7Bridge(frameworkId, clientId));
	}
	
	private final TakipiInternalP7AgentBridge bridge;

	private TakipiAgentP7ClientImpl(String frameworkId, String clientId, TakipiOptions options,
			TakipiInternalP7AgentBridge bridge) {
		super(frameworkId, clientId, options, bridge);
		this.bridge = bridge;
	}

	@Override
	public TakipiEvent createEvent(String name) {
		return TakipiAgentP7Event.create(name, bridge.createInternalEvent(name));
	}
}
