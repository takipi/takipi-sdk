package com.takipi.sdk.v1.internal.debug.events;

import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;
import com.takipi.sdk.v1.internal.debug.TakipiDebugLogger;

public class TakipiDebugEvent implements TakipiEvent {
	
	public static TakipiEvent wrap(TakipiEvent event, TakipiDebugLogger logger) {
		return new TakipiDebugEvent(event, logger);
	}
	
	private final TakipiEvent event;
	private final TakipiDebugLogger logger;
	
	private TakipiDebugEvent(TakipiEvent event, TakipiDebugLogger logger) {
		this.event = event;
		this.logger = logger;
	}
	
	@Override
	public TakipiEventResult fire() {
		logger.log("Event [" + event + "] about to fire with default options.");
		logger.stack();
		
		TakipiEventResult result = null;
		
		try {
			result = event.fire();
			return result;
		} finally {
			logResult(result);
		}
	}
	
	@Override
	public TakipiEventResult fire(TakipiEventFireOptions options) {
		logger.log("Event [" + event + "] about to fire with options: " + options);
		logger.stack();
		
		TakipiEventResult result = null;
		
		try {
			result = event.fire(options);
			return result;
		} finally {
			logResult(result);
		}
	}
	
	@Override
	public String toString() {
		return event.toString();
	}
	
	private void logResult(TakipiEventResult result) {
		if (result != null) {
			if (result.hasSnapshot()) {
				logger.log("Data snapshot generated: " + result.getSnapshotId());
			} else {
				logger.log("No data snapshot generated.");
			}
		} else {
			logger.error("No result returned.");
		}
	}
}
