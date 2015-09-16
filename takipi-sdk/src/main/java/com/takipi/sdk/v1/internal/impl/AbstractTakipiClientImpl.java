package com.takipi.sdk.v1.internal.impl;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.internal.TakipiClient;

public abstract class AbstractTakipiClientImpl implements TakipiClient {
	
	private final String frameworkId;
	private final String clientId;
	private final TakipiOptions options;
	
	protected AbstractTakipiClientImpl(String frameworkId, String clientId, TakipiOptions options) {
		this.frameworkId = frameworkId;
		this.clientId = clientId;
		this.options = options;
	}
	
	@Override
	public String getFrameworkId() {
		return frameworkId;
	}
	
	@Override
	public String getClientId() {
		return clientId;
	}
	
	@Override
	public TakipiOptions getOptions() {
		return options;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + frameworkId + " " + clientId;
	}
}
