package com.takipi.sdk.v1.internal.util;

public class Assert {
	
	public static void notEmpty(String str, String message) {
		if ((str != null) && (str.isEmpty())) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notNullOrEmpty(String str, String message) {
		if ((str == null) || (str.isEmpty())) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
