package com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;
import com.takipi.sdk.v1.internal.core.AbstractTakipiContext;

public class TakipiAgentP1Context extends AbstractTakipiContext {
	
	public static TakipiContext create(Class<?> clazz, String path, TakipiInternalP1Context internalContext) {
		return new TakipiAgentP1Context(clazz, path, internalContext);
	}
	
	private final TakipiInternalP1Context internalContext;
	
	private TakipiAgentP1Context(Class<?> clazz, String path, TakipiInternalP1Context internalContext) {
		super(clazz, path);
		this.internalContext = internalContext;
	}
	
	public TakipiInternalP1Context getInternalContext() {
		return internalContext;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + internalContext.toString() + ")";
	}
}
