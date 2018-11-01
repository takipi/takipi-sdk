package com.takipi.sdk.v1.internal.agent.shared.p7.core.events;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.events.TakipiInternalP1EventResult;

public interface TakipiInternalP7EventResult extends TakipiInternalP1EventResult {
	
	public boolean hasSnapshotUrl();
	public String getSnapshotUrl();
}
