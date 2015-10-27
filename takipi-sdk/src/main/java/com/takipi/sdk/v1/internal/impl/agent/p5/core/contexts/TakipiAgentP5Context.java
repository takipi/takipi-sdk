package com.takipi.sdk.v1.internal.impl.agent.p5.core.contexts;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.agent.shared.p5.core.contexts.TakipiInternalP5Context;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP5Context extends TakipiAgentP1Context {
	
	public static TakipiContext create(Class<?> clazz, String path, TakipiInternalP5Context internalContext) {
		return new TakipiAgentP5Context(clazz, path, internalContext);
	}
	
	private final TakipiInternalP5Context internalContext;
	
	private TakipiAgentP5Context(Class<?> clazz, String path, TakipiInternalP5Context internalContext) {
		super(clazz, path, internalContext);
		this.internalContext = internalContext;
	}
	
	@Override
	public void dispose() {
		internalContext.dispose();
	}
}
