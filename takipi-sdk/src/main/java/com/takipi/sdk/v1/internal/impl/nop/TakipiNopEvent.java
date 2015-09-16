package com.takipi.sdk.v1.internal.impl.nop;

import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.core.AbstractTakipiEvent;

public class TakipiNopEvent extends AbstractTakipiEvent {
	
	public static TakipiNopEvent create(String name) {
		return new TakipiNopEvent(name);
	}
	
	private TakipiNopEvent(String name) {
		super(name);
	}
	
	@Override
	public TakipiEventResult fire(TakipiEventFireOptions options) {
		return TakipiNopEventResult.create();
	}
}
