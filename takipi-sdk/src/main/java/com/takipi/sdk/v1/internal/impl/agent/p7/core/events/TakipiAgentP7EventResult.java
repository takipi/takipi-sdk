package com.takipi.sdk.v1.internal.impl.agent.p7.core.events;

import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.agent.shared.p7.core.events.TakipiInternalP7EventResult;
import com.takipi.sdk.v1.internal.core.AbstractTakipiEventResult;

public class TakipiAgentP7EventResult extends AbstractTakipiEventResult {
	
	public static TakipiEventResult create(TakipiInternalP7EventResult internalResult) {
		return new TakipiAgentP7EventResult(internalResult);
	}
	
	private final TakipiInternalP7EventResult internalResult;
	
	private TakipiAgentP7EventResult(TakipiInternalP7EventResult internalResult) {
		this.internalResult = internalResult;
	}
	
	@Override
	public boolean hasSnapshot() {
		return internalResult.hasSnapshot();
	}
	
	@Override
	public String getSnapshotId() {
		return internalResult.getSnapshotId();
	}

	@Override
	public boolean hasSnapshotUrl() {
		return internalResult.hasSnapshotUrl();
	}
	
	@Override
	public String getSnapshotUrl() {
		return internalResult.getSnapshotUrl();
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + internalResult + ")";
	}
}
