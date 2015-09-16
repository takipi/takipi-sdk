package com.takipi.sdk.v1.internal.impl.agent;

import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.internal.impl.AbstractTakipiClientImpl;

public abstract class TakipiAgentClientImpl extends AbstractTakipiClientImpl {
	
	protected TakipiAgentClientImpl(String frameworkId, String clientId, TakipiOptions options) {
		super(frameworkId, clientId, options);
	}
}
