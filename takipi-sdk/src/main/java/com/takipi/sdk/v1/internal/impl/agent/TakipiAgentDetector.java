package com.takipi.sdk.v1.internal.impl.agent;

public class TakipiAgentDetector {
	
	private static final int UNINITIALIZED		= -1;
	private static final int NO_AGENT			= 0;
	
	public static TakipiAgentDetector create() {
		return new TakipiAgentDetector();
	}
	
	private int maxSupportedProtocolVersion;
	
	private TakipiAgentDetector() {
		this.maxSupportedProtocolVersion = UNINITIALIZED;
	}
	
	public boolean isAgentPresent() {
		return (getMaxSupportedProtocolVersion() != NO_AGENT);
	}
	
	public int getMaxSupportedProtocolVersion() {
		if (maxSupportedProtocolVersion == UNINITIALIZED) {
			try {
				maxSupportedProtocolVersion = detectAgent();
			} catch (Throwable e) {
				maxSupportedProtocolVersion = NO_AGENT;
			}
		}
		
		return maxSupportedProtocolVersion;
	}
	
	private static int detectAgent() {
		return TakipiAgentInterface.create().getMaxSupportedProtocolVersion();
	}
}
