package com.takipi.sdk.v1.internal.debug.contexts;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugContext implements TakipiContext {
	
	public static TakipiContext wrap(TakipiContext context, TakipiDebugLogger logger) {
		return new TakipiDebugContext(context, logger);
	}
	
	private final TakipiContext context;
	private final TakipiDebugLogger logger;
	
	private TakipiDebugContext(TakipiContext context, TakipiDebugLogger logger) {
		this.context = context;
		this.logger = logger;
	}
	
	@Override
	public void dispose() {
		logger.log("Disposing of " + context);
		context.dispose();
	}
	
	@Override
	public int hashCode() {
		return context.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if ((o == null) ||
			(!(o instanceof TakipiDebugContext))) {
			return false;
		}
		
		return context.equals(((TakipiDebugContext)o).context);
	}
	
	@Override
	public String toString() {
		return context.toString();
	}
}
