package com.takipi.sdk.v1.internal.core;

import com.takipi.sdk.v1.api.core.events.TakipiEventResult;

public abstract class AbstractTakipiEventResult implements TakipiEventResult {
	
	protected AbstractTakipiEventResult() {}
	
	@Override
	public abstract boolean hasSnapshot();
	
	@Override
	public abstract String getSnapshotId();
	
	@Override
	public String toString() {
		return "Snapshot ID: " + getSnapshotId();
	}
}
