package com.takipi.sdk.v1.api.core.metrics;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.takipi.sdk.v1.internal.util.Assert;

/**
 * Options class used to configure metrics when constructing instances of the different
 * implementations of {@link TakipiMetric}.
 * 
 * @author Niv Steingarten
 */
public class TakipiMetricOptions {
	
	/**
	 * A pre-built instance of {@code TakipiMetricOptions} that consists of the default options.
	 */
	public static final TakipiMetricOptions DEFAULT = createDefaultInstance();
	
	private final String displayName;
	private final TakipiMetricUnit unit;
	private final String unitSuffix;
	private final String unitPluralSuffix;
	private final Set<String> brackets;
	
	private TakipiMetricOptions(String displayName, TakipiMetricUnit unit,
			String unitSuffix, String unitPluralSuffix, Set<String> brackets) {
		this.displayName = displayName;
		this.unit = unit;
		this.unitSuffix = unitSuffix;
		this.unitPluralSuffix = unitPluralSuffix;
		this.brackets = brackets;
	}
	
	/**
	 * The display name to use for the metric. This name appears wherever the metric is formatted for
	 * human readability (e.g. the online dashboard).<br><br>
	 * 
	 * For example, a metric named "{@code totalMessageCount}" may have the display name <i>"Number
	 * of messages"</i>.<br><br>
	 * 
	 * If {@code null}, the name of the metric is used as the display name.<br><br>
	 * 
	 * Default: {@code null}
	 * 
	 * @return The string representing the display name of the metric, or {@code null} if none provided.
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * The unit type to use for the metric.<br><br>
	 * 
	 * Using this option the measurement units of the metric can be provided. See {@link TakipiMetricUnit}
	 * for a list of available predefined units.<br><br>
	 * 
	 * If {@link TakipiMetricUnit#CUSTOM} is used, a unit suffix must be provided.
	 * See {@link Builder#withUnitSuffix}.<br><br>
	 * 
	 * Default: {@code TakipiMetricUnit#NONE}
	 * 
	 * @return The unit type with which this options instance was constructed.
	 */
	public TakipiMetricUnit getUnit() {
		return unit;
	}
	
	/**
	 * For {@code CUSTOM} metrics, the suffix to use when formatting the metric in
	 * human-readable format.<br><br>
	 * 
	 * For example, "message", "celsius", "km/h". See {@link TakipiMetricUnit#CUSTOM}.<br><br>
	 * 
	 * See also: {@link TakipiMetricOptions#getUnitPluralSuffix()}<br><br>
	 * 
	 * Default: {@code null}
	 * 
	 * @return The unit suffix for the metric.
	 */
	public String getUnitSuffix() {
		return unitSuffix;
	}
	
	/**
	 * For {@code CUSTOM} metrics, this is an optional plural suffix to use when formatting the metric
	 * in human-readable format.<br><br>
	 * 
	 * If provided, the singular suffix (see {@link TakipiMetricOptions#getUnitSuffix()}) will only be
	 * used if the metric value is 1, and the plural suffix for all other values.<br><br>
	 * 
	 * For example, for the unit suffixes <i>"meter"</i> and <i>"meters"</i>:
	 * "1 meter", "3.8 meters", "0 meters".<br><br>
	 * 
	 * Default: {@code null}
	 * 
	 * @return The unit plural suffix for the metric, or {@code null} if none provided.
	 */
	public String getUnitPluralSuffix() {
		return unitPluralSuffix;
	}
	
	/**
	 * Brackets with which to associate the metric.<br><br>
	 * 
	 * Brackets are a hierarchical set of labels used for grouping of metrics into logical sets, or
	 * categories, in the Takipi dashboard. A metric may be associated with multiple brackets, and
	 * provided brackets will be added to any existing brackets already associated with the metric.
	 * <br><br>
	 * 
	 * Each bracket in the set takes the form of a simple string, or a relative path (separated by
	 * forward-slashes, '/') indicating the bracket's hierarchy.<br><br>
	 * 
	 * For example, a <i>"running tasks"</i>-style metric may be associated with the brackets:<br>
	 * <code>{ "System analytics/Task metrics", "Thread status" }</code>. It will then appear under
	 * both groups in the Takipi dashboard.<br><br>
	 * 
	 * Default: Empty set
	 * 
	 * @return The brackets to be associated with the metric, or an empty set if none provided.
	 */
	public Set<String> getBrackets() {
		return Collections.unmodifiableSet(brackets);
	}
	
	@Override
	public String toString() {
		return 	"Display name: " + displayName + '\n' +
				"Unit: " + unit + '\n' +
				"Unit suffix: " + unitSuffix + '\n' +
				"Unit plural suffix: " + unitPluralSuffix + '\n' +
				"Brackets: " + brackets;
	}
	
	private static TakipiMetricOptions createDefaultInstance() {
		return newBuilder().build();
	}
	
	/**
	 * Creates a new builder for the {@link TakipiMetricOptions} class.<br><br>
	 * 
	 * See {@link TakipiMetricOptions.Builder} for details.
	 * 
	 * @return A new {@code TakipiMetricOptions.Builder} instance for constructing an immutable
	 * 		   {@code TakipiMetricOptions} object.
	 */
	public static Builder newBuilder() {
		return new Builder();
	}
	
	/**
	 * This class allows for the easy configuration of the different parameters available in
	 * {@code TakipiMetricOptions}. Once built, the returned {@code TakipiMetricOptions} instance
	 * is immutable.
	 * 
	 * @author Niv Steingarten
	 */
	public static class Builder {
		
		private String displayName;
		private TakipiMetricUnit unit;
		private String unitSuffix;
		private String unitPluralSuffix;
		private Set<String> brackets;
		
		private Builder() {
			setDefaults();
		}
		
		private void setDefaults() {
			this.displayName = null;
			this.unit = TakipiMetricUnit.NONE;
			this.unitSuffix = null;
			this.unitPluralSuffix = null;
			this.brackets = new HashSet<String>();
		}
		
		/**
		 * Sets the display name of the metric. See {@link TakipiMetricOptions#getDisplayName()}.
		 * 
		 * @param displayName The display name to set. Must not be an empty string. May be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder withDisplayName(String displayName) {
			Assert.notEmpty(displayName, "Display name must not be empty");
			
			this.displayName = displayName;
			return this;
		}
		
		/**
		 * Sets the unit type of the metric. See {@link TakipiMetricOptions#getUnit()}.
		 * 
		 * @param unit The unit type to set. Must not be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder withUnit(TakipiMetricUnit unit) {
			Assert.notNull(unit, "Unit must not be null");
			
			this.unit = unit;
			return this;
		}
		
		/**
		 * Sets the unit suffix for metrics of type {@code CUSTOM}. See
		 * {@link TakipiMetricOptions#getUnitSuffix()}.
		 * 
		 * @param unitSuffix The unit suffix to set. Must not be an empty string
		 * @return The instance of the {@code Builder}
		 */
		public Builder withUnitSuffix(String unitSuffix) {
			Assert.notEmpty(unitSuffix, "Unit suffix must not be empty");
			
			this.unitSuffix = unitSuffix;
			return this;
		}
		
		/**
		 * Sets the unit plural suffix for metrics of type {@code CUSTOM}. See
		 * {@link TakipiMetricOptions#getUnitPluralSuffix()}.
		 * 
		 * @param unitPluralSuffix The unit plural suffix to set. Must not be an empty string
		 * @return The instance of the {@code Builder}
		 */
		public Builder withUnitPluralSuffix(String unitPluralSuffix) {
			Assert.notEmpty(unitPluralSuffix, "Unit plural suffix must not be empty");
			
			this.unitPluralSuffix = unitPluralSuffix;
			return this;
		}
		
		/**
		 * Sets the set of brackets to be associated with the metric.
		 * See {@link TakipiMetricOptions#getBrackets()}.
		 * 
		 * @param brackets The brackets to be associated with the metric. Must not be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder withBrackets(Collection<? extends String> brackets) {
			Assert.notNull(brackets, "Brackets must not be null");
			
			this.brackets = new HashSet<String>(brackets);
			return this;
		}
		
		/**
		 * Adds brackets to the set of brackets to be associated with the metric.
		 * See {@link TakipiMetricOptions#getBrackets()}.
		 * 
		 * @param brackets The brackets to be added to the set. Must not be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder addBrackets(Collection<? extends String> brackets) {
			Assert.notNull(brackets, "Brackets must not be null");
			
			this.brackets.addAll(brackets);
			return this;
		}
		
		/**
		 * Adds a bracket to the set of brackets to be associated with the metric.
		 * See {@link TakipiMetricOptions#getBrackets()}.
		 * 
		 * @param bracket The bracket to be added to the set. Must not be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder addBracket(String bracket) {
			Assert.notNull(bracket, "Bracket must not be null");
			
			this.brackets.add(bracket);
			return this;
		}
		
		/**
		 * Clears the set of brackets to be associated with the metric.
		 * See {@link TakipiMetricOptions#getBrackets()}.
		 * 
		 * @return The instance of the {@code Builder}
		 */
		public Builder clearBrackets() {
			this.brackets.clear();
			return this;
		}
		
		/**
		 * Constructs an immutable {@link TakipiMetricOptions} object based on the options configured
		 * in this {@code Builder} instance.
		 * 
		 * @return An immutable {@code TakipiMetricOptions} instance.
		 */
		public TakipiMetricOptions build() {
			return new TakipiMetricOptions(displayName, unit, unitSuffix, unitPluralSuffix, brackets);
		}
	}
}
