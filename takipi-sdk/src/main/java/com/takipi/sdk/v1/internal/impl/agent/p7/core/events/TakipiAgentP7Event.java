package com.takipi.sdk.v1.internal.impl.agent.p7.core.events;

import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.agent.shared.p7.core.events.TakipiInternalP7Event;
import com.takipi.sdk.v1.internal.core.AbstractTakipiEvent;

public class TakipiAgentP7Event extends AbstractTakipiEvent {
	
	public static TakipiEvent create(String name, TakipiInternalP7Event internalEvent) {
		return new TakipiAgentP7Event(name, internalEvent);
	}
	
	private final TakipiInternalP7Event internalEvent;
	
	private TakipiAgentP7Event(String name, TakipiInternalP7Event internalEvent) {
		super(name);
		this.internalEvent = internalEvent;
	}
	
	@Override
	public TakipiEventResult fire(TakipiEventFireOptions options) {
		return TakipiAgentP7EventResult.create(internalEvent.fire(
				options.getMessage(),
				options.getForceSnapshot(),
				((options.getExtraContext() != null) ? options.getExtraContext().toArray() : null)));
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + internalEvent.toString() + ")";
	}
}
