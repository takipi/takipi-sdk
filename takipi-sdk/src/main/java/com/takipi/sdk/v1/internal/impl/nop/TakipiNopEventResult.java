package com.takipi.sdk.v1.internal.impl.nop;

import com.takipi.sdk.v1.internal.core.AbstractTakipiEventResult;

public class TakipiNopEventResult extends AbstractTakipiEventResult {
	
	public static TakipiNopEventResult create() {
		return new TakipiNopEventResult();
	}
	
	private TakipiNopEventResult() {}
	
	@Override
	public boolean hasSnapshot() {
		return false;
	}
	
	@Override
	public String getSnapshotId() {
		return null;
	}
}
