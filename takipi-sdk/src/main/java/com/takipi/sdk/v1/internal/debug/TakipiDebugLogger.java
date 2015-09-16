package com.takipi.sdk.v1.internal.debug;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class TakipiDebugLogger {
	
	private static final String MESSAGE_FORMAT = "[%s] [%s] %s";
	
	public static TakipiDebugLogger create(String frameworkId) {
		return new TakipiDebugLogger(frameworkId);
	}
	
	private final String frameworkId;
	
	private TakipiDebugLogger(String frameworkId) {
		this.frameworkId = frameworkId;
	}
	
	public void log(String message) {
		internalLog(System.out, message);
	}
	
	public void error(String message) {
		internalLog(System.err, message);
	}
	
	public void stack() {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			
			new Exception().printStackTrace(pw);
			
			String exceptionStack = sw.toString();
			String rawStack = exceptionStack.substring(exceptionStack.indexOf('\n') + 1);
			
			System.out.print("Stack trace:\n" + rawStack);
		} catch (Exception e) {
			System.err.println("Error generating stack trace.");
		}
	}
	
	private void internalLog(PrintStream ps, String message) {
		ps.println(String.format(MESSAGE_FORMAT, new Date().toString(), frameworkId, message));
	}
}
