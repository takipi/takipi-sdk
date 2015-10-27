package com.takipi.sdk.v1.internal.impl.agent;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.util.TakipiRuntimeException;
import com.takipi.sdk.v1.internal.TakipiClient;
import com.takipi.sdk.v1.internal.impl.agent.p1.TakipiAgentP1ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p2.TakipiAgentP2ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p3.TakipiAgentP3ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p4.TakipiAgentP4ClientImpl;
import com.takipi.sdk.v1.internal.impl.agent.p5.TakipiAgentP5ClientImpl;

public class TakipiAgentClientFactory {
	
	private static final int MAX_SUPPORTED_PROTOCOL_VERSION	= 5;
	
	public static TakipiClient create(String frameworkId, String clientId, TakipiOptions options,
			int agentMaxSupportedProtocolVersion) {
		
		int protocolVersion = Math.min(
				agentMaxSupportedProtocolVersion,
				MAX_SUPPORTED_PROTOCOL_VERSION);
		
		switch (protocolVersion) {
			case 1:		return TakipiAgentP1ClientImpl.create(frameworkId, clientId, options);
			case 2:		return TakipiAgentP2ClientImpl.create(frameworkId, clientId, options);
			case 3:		return TakipiAgentP3ClientImpl.create(frameworkId, clientId, options);
			case 4:		return TakipiAgentP4ClientImpl.create(frameworkId, clientId, options);
			case 5:		return TakipiAgentP5ClientImpl.create(frameworkId, clientId, options);
			
			default:	throw new TakipiRuntimeException("Unsupported protocol version: " + protocolVersion);
		}
	}
}
