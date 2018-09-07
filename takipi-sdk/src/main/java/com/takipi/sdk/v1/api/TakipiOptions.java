package com.takipi.sdk.v1.api;

/**
 * Options class used to configure the Takipi SDK when constructing an instance of
 * the class {@link Takipi}.
 * 
 * @author Niv Steingarten
 */
public class TakipiOptions {
	
	/**
	 * A pre-built instance of {@code TakipiOptions} that consists of the default options.
	 */
	public static final TakipiOptions DEFAULT = createDefaultInstance();
	
	private final boolean isDebugEnabled;
	private final long debugMetricsPrintPeriodMillis;
	
	private TakipiOptions(boolean isDebugEnabled, long debugMetricsPrintPeriodMillis) {
		this.isDebugEnabled = isDebugEnabled;
		this.debugMetricsPrintPeriodMillis = debugMetricsPrintPeriodMillis;
	}
	
	/**
	 * Is debug mode enabled.<br><br>
	 * 
	 * In this mode, the Takipi SDK adds to the implementation a debug bridge that prints verbose debugging
	 * information to the standard output and error. This mode is useful during development in order to
	 * track the state of the model (e.g. metrics and events).<br><br>
	 * 
	 * Default: {@code false}
	 * 
	 * @return {@code true} if debug mode is enabled; {@code false} otherwise
	 */
	public boolean isDebugEnabled() {
		return isDebugEnabled;
	}
	
	/**
	 * When in debug mode, this parameter determines how often debug information about metrics is printed
	 * to the standard output. For example, if 100, debug information will be printed <b>at most</b> once
	 * every 100 milliseconds.<br><br>
	 * 
	 * Default: {@code 1000}
	 * 
	 * @return The maximum frequency, in milliseconds
	 */
	public long getDebugMetricsPrintPeriodMillis() {
		return debugMetricsPrintPeriodMillis;
	}
	
	@Override
	public String toString() {
		return 	"Debug enabled: " + isDebugEnabled + '\n' +
				"Debug metrics print period: " + debugMetricsPrintPeriodMillis + " millis";
	}
	
	private static TakipiOptions createDefaultInstance() {
		return newBuilder().build();
	}
	
	/**
	 * Creates a new builder for the {@link TakipiOptions} class.<br><br>
	 * 
	 * See {@link TakipiOptions.Builder} for details.
	 * 
	 * @return A new {@code TakipiOptions.Builder} instance for constructing an immutable
	 * 		   {@code TakipiOptions} object.
	 */
	public static Builder newBuilder() {
		return new Builder();
	}
	
	/**
	 * This class allows for the easy configuration of the different parameters available in
	 * {@code TakipiOptions}. Once built, the returned {@code TakipiOptions} instance is immutable.
	 * 
	 * @author Niv Steingarten
	 */
	public static class Builder {
		
		private boolean isDebugEnabled;
		private long debugMetricsPrintPeriodMillis;
		
		private Builder() {
			setDefaults();
		}
		
		private void setDefaults() {
			this.isDebugEnabled = false;
			this.debugMetricsPrintPeriodMillis = 1000l;
		}
		
		/**
		 * Set whether the Takipi SDK will be in debug mode. See {@link TakipiOptions#isDebugEnabled()}.
		 * 
		 * @param isDebugEnabled Whether or not the Takipi SDK will be in debug mode.
		 * @return The instance of the {@code Builder}
		 */
		public Builder withDebugEnabled(boolean isDebugEnabled) {
			this.isDebugEnabled = isDebugEnabled;
			return this;
		}
		
		/**
		 * Set the metric information debug print period. See
		 * {@link TakipiOptions#getDebugMetricsPrintPeriodMillis()}.
		 * 
		 * @param debugMetricsPrintPeriodMillis How often, in milliseconds, debug information should be printed
		 * @return The instance of the {@code Builder}.
		 */
		public Builder withDebugMetricsPrintPeriodMillis(long debugMetricsPrintPeriodMillis) {
			this.debugMetricsPrintPeriodMillis = debugMetricsPrintPeriodMillis;
			return this;
		}
		
		/**
		 * Constructs an immutable {@link TakipiOptions} object based on the options configured in
		 * this {@code Builder} instance.
		 * 
		 * @return An immutable {@code TakipiOptions} instance.
		 */
		public TakipiOptions build() {
			return new TakipiOptions(isDebugEnabled, debugMetricsPrintPeriodMillis);
		}
	}
}
