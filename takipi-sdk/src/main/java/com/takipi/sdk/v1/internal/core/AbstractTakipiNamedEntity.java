package com.takipi.sdk.v1.internal.core;

public abstract class AbstractTakipiNamedEntity {
	
	private final String name;
	
	protected AbstractTakipiNamedEntity(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public final int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public final boolean equals(Object o) {
		if ((o == null) ||
			(!(o instanceof AbstractTakipiNamedEntity))) {
			return false;
		}
		
		return name.equals(((AbstractTakipiNamedEntity)o).name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
