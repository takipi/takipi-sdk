package com.takipi.sdk.v1.internal.impl.agent.p1.core.events;

import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.events.TakipiInternalP1Event;
import com.takipi.sdk.v1.internal.core.AbstractTakipiEvent;

public class TakipiAgentP1Event extends AbstractTakipiEvent {
	
	public static TakipiEvent create(String name, TakipiInternalP1Event internalEvent) {
		return new TakipiAgentP1Event(name, internalEvent);
	}
	
	private final TakipiInternalP1Event internalEvent;
	
	private TakipiAgentP1Event(String name, TakipiInternalP1Event internalEvent) {
		super(name);
		this.internalEvent = internalEvent;
	}
	
	@Override
	public TakipiEventResult fire(TakipiEventFireOptions options) {
		return TakipiAgentP1EventResult.create(internalEvent.fire(
				options.getMessage(),
				options.getForceSnapshot(),
				((options.getExtraContext() != null) ? options.getExtraContext().toArray() : null)));
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + internalEvent.toString() + ')';
	}
}
