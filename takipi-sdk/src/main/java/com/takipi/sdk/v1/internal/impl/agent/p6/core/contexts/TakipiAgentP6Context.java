package com.takipi.sdk.v1.internal.impl.agent.p6.core.contexts;

import com.takipi.sdk.v1.internal.agent.shared.p1.core.contexts.TakipiInternalP1Context;
import com.takipi.sdk.v1.internal.impl.agent.p1.core.contexts.TakipiAgentP1Context;

public class TakipiAgentP6Context extends TakipiAgentP1Context
{
	protected TakipiAgentP6Context(Class<?> clazz, String methodName, String path, TakipiInternalP1Context internalContext)
	{
		super(clazz, path, internalContext);
	}
}
