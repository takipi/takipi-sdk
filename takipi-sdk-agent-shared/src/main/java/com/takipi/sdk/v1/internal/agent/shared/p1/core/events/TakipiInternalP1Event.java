package com.takipi.sdk.v1.internal.agent.shared.p1.core.events;

public interface TakipiInternalP1Event {
	
	public TakipiInternalP1EventResult fire(String message, boolean forceSnapshot, Object[] extraContext);
}
