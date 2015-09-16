package com.takipi.sdk.v1.internal.impl.agent.p1.core.events;

import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.events.TakipiInternalP1EventResult;
import com.takipi.sdk.v1.internal.core.AbstractTakipiEventResult;

public class TakipiAgentP1EventResult extends AbstractTakipiEventResult {
	
	public static TakipiEventResult create(TakipiInternalP1EventResult internalResult) {
		return new TakipiAgentP1EventResult(internalResult);
	}
	
	private final TakipiInternalP1EventResult internalResult;
	
	private TakipiAgentP1EventResult(TakipiInternalP1EventResult internalResult) {
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
	public String toString() {
		return super.toString() + " (" + internalResult + ")";
	}
}
