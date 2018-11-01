package com.takipi.sdk.v1.internal.impl.agent;

import com.takipi.sdk.v1.api.util.TakipiRuntimeException;
import com.takipi.sdk.v1.internal.agent.shared.p1.bridge.TakipiInternalP1AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p2.bridge.TakipiInternalP2AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p3.bridge.TakipiInternalP3AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p4.bridge.TakipiInternalP4AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p5.bridge.TakipiInternalP5AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p6.bridge.TakipiInternalP6AgentBridge;
import com.takipi.sdk.v1.internal.agent.shared.p7.bridge.TakipiInternalP7AgentBridge;

public class TakipiAgentInterface {
	
	private static final String PACKAGE_NAME		= "com.sparktale.bugtale.agent.sdk.v1";
	private static final String SIMPLE_CLASS_NAME	= "TakipiSdkInterface";
	
	private static final String FULL_CLASS_NAME		= PACKAGE_NAME + "." + SIMPLE_CLASS_NAME;
	
	private static final String GET_MAX_SUPPORTED_PROTOCOL_VERSION_METHOD_NAME	= "getMaxSupportedProtocolVersion";
	private static final String CREATE_BRIDGE_METHOD_NAME_PATTERN				= "createP%dBridge";
	
	public static TakipiAgentInterface create() {
		try {
			return new TakipiAgentInterface(findClass());
		} catch (Exception e) {
			throw new TakipiRuntimeException(e);
		}
	}
	
	private static Class<?> findClass() throws ClassNotFoundException {
		return Class.forName(FULL_CLASS_NAME);
	}
	
	private final Class<?> clazz;
	
	private TakipiAgentInterface(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public int getMaxSupportedProtocolVersion() {
		try {
			return (Integer)clazz
					.getDeclaredMethod(GET_MAX_SUPPORTED_PROTOCOL_VERSION_METHOD_NAME)
					.invoke(null);
		} catch (Exception e) {
			throw new TakipiRuntimeException(e);
		}
	}
	
	public TakipiInternalP1AgentBridge createP1Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 1);
	}
	
	public TakipiInternalP2AgentBridge createP2Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 2);
	}
	
	public TakipiInternalP3AgentBridge createP3Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 3);
	}
	
	public TakipiInternalP4AgentBridge createP4Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 4);
	}
	
	public TakipiInternalP5AgentBridge createP5Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 5);
	}
	
	public TakipiInternalP6AgentBridge createP6Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 6);
	}

	public TakipiInternalP7AgentBridge createP7Bridge(String frameworkId, String clientId) {
		return createBridge(frameworkId, clientId, 7);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T createBridge(String frameworkId, String clientId, int protocolVersion) {
		try {
			return (T)clazz
					.getDeclaredMethod(
							String.format(CREATE_BRIDGE_METHOD_NAME_PATTERN, protocolVersion),
							String.class, String.class)
					.invoke(null, frameworkId, clientId);
		} catch (Exception e) {
			throw new TakipiRuntimeException(e);
		}
	}
}
