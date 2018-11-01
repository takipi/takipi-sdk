package com.takipi.sdk.v1.internal.agent.shared.p7.core.events;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.events.TakipiInternalP1Event;

public interface TakipiInternalP7Event extends TakipiInternalP1Event {
	@Override
	public TakipiInternalP7EventResult fire(String message, boolean forceSnapshot, Object[] extraContext);
}
