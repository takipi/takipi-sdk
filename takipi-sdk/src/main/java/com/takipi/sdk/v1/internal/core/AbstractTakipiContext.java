package com.takipi.sdk.v1.internal.core;

import com.takipi.sdk.v1.api.core.contexts.TakipiContext;

public abstract class AbstractTakipiContext implements TakipiContext {
	
	private final Class<?> clazz;
	private final String path;
	
	protected AbstractTakipiContext(Class<?> clazz, String path) {
		this.clazz = clazz;
		this.path = path;
	}
	
	@Override
	public abstract void dispose();
	
	@Override
	public final int hashCode() {
		return clazz.hashCode();
	}
	
	@Override
	public final boolean equals(Object o) {
		if ((o == null) ||
			(!(o instanceof AbstractTakipiContext))) {
			return false;
		}
		
		AbstractTakipiContext other = (AbstractTakipiContext)o;
		
		return ((clazz == other.clazz) &&
				(path.equals(other.path)));
	}
	
	@Override
	public String toString() {
		return clazz.getName() + " [" + path + "]";
	}
}
