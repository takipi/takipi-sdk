package com.takipi.sdk.v1.api.core.metrics;

/**
 * Predefined units for when constructing custom metrics.
 * 
 * @author Niv Steingarten
 */
public enum TakipiMetricUnit {
	
	/**
	 * No units.
	 */
	NONE,
	
	/**
	 * Custom units.<br><br>
	 * 
	 * When using {@code CUSTOM}, a custom unit suffix string should be provided via the API (e.g.
	 * "message/messages", "celsius").
	 */
	CUSTOM,
	
	/**
	 * For metrics that count the number of occurrences of certain events (e.g. failures, visits, etc).<br><br>
	 * 
	 * Suffix: <i>time / times</i>
	 */
	TIMES,
	
	/**
	 * For time metrics measured in nanoseconds (one billionth of a second).<br><br>
	 * 
	 * Suffix: <i>ns</i>
	 */
	NANOSECONDS,
	
	/**
	 * For time metrics measured in microseconds (one millionth of a second).<br><br>
	 * 
	 * Notation: <i>&#181;s</i>
	 */
	MICROSECONDS,
	
	/**
	 * For time metrics measured in milliseconds (one thousandth of a second).<br><br>
	 * 
	 * Notation: <i>ms</i>
	 */
	MILLISECONDS,
	
	/**
	 * For time metrics measured in seconds.<br><br>
	 * 
	 * Notation: <i>sec</i>
	 */
	SECONDS,
	
	/**
	 * For time metrics measured in minutes.<br><br>
	 * 
	 * Notation: <i>min</i>
	 */
	MINUTES,
	
	/**
	 * For time metrics measured in hours.<br><br>
	 * 
	 * Notation: <i>hour / hours</i>
	 */
	HOURS,
	
	/**
	 * For time metrics measured in days.<br><br>
	 * 
	 * Notation: <i>day / days</i>
	 */
	DAYS,
	
	/**
	 * For data size metrics measured in bytes.<br><br>
	 * 
	 * Notation: <i>byte / bytes</i>
	 */
	BYTES,
	
	/**
	 * For data size metrics measured in kibibytes (2<sup>10</sup> bytes).<br><br>
	 * 
	 * Notation: <i>KiB</i>
	 */
	KIBIBYTE,
	
	/**
	 * For data size metrics measured in mebibytes (2<sup>20</sup> bytes).<br><br>
	 * 
	 * Notation: <i>MiB</i>
	 */
	MEBIBYTE,
	
	/**
	 * For data size metrics measured in gibibytes (2<sup>30</sup> bytes).<br><br>
	 * 
	 * Notation: <i>GiB</i>
	 */
	GIBIBYTE;
}
