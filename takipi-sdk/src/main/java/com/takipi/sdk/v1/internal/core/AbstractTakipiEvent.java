package com.takipi.sdk.v1.internal.core;

import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;

public abstract class AbstractTakipiEvent extends AbstractTakipiNamedEntity implements TakipiEvent {
	
	protected AbstractTakipiEvent(String name) {
		super(name);
	}
	
	@Override
	public TakipiEventResult fire() {
		return fire(TakipiEventFireOptions.DEFAULT);
	}
	
	@Override
	public abstract TakipiEventResult fire(TakipiEventFireOptions options);
}
