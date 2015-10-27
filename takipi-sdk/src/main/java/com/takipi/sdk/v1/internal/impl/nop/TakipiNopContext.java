package com.takipi.sdk.v1.internal.impl.nop;

import com.takipi.sdk.v1.internal.core.AbstractTakipiContext;

public class TakipiNopContext extends AbstractTakipiContext {
	
	public static TakipiNopContext create(Class<?> clazz, String path) {
		return new TakipiNopContext(clazz, path);
	}
	
	private TakipiNopContext(Class<?> clazz, String path) {
		super(clazz, path);
	}
	
	@Override
	public void dispose() {}
}
