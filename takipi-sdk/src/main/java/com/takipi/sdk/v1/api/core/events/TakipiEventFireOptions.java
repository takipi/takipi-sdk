package com.takipi.sdk.v1.api.core.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.takipi.sdk.v1.internal.util.Assert;

/**
 * Options class used to control various elements of firing Takipi events.<br><br>
 * 
 * See {@link TakipiEvent}.
 * 
 * @author Niv Steingarten
 */
public class TakipiEventFireOptions {
	
	/**
	 * A pre-built instance of {@code TakipiEventFireOptions} that consists of the default options.
	 */
	public static final TakipiEventFireOptions DEFAULT = createDefaultInstance();
	
	private final String message;
	private final boolean forceSnapshot;
	private final List<Object> extraContext;
	
	private TakipiEventFireOptions(String message, boolean forceSnapshot, List<Object> extraContext) {
		this.message = message;
		this.forceSnapshot = forceSnapshot;
		this.extraContext = extraContext;
	}
	
	/**
	 * A custom textual message to be associated with the instance of the event. May be
	 * {@code null}.<br><br>
	 * 
	 * Default: {@code null}
	 * 
	 * @return The message to be associated with the instance of the event, or {@code null} if none
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * If {@code true}, the Takipi agent will take a data snapshot forcefully, without regard to
	 * sampling and throttling policies (use with care). If {@code false}, the Takipi agent takes data
	 * snapshots periodically as to not affect application performance.<br><br>
	 * 
	 * Default: {@code false}
	 * 
	 * @return {@code true} if forcing a data snapshot; {@code false} otherwise
	 */
	public boolean getForceSnapshot() {
		return forceSnapshot;
	}
	
	/**
	 * Extra contextual data to be associated with this instance of the event. This data is serialized
	 * alongside the standard snapshot data recorded by the Takipi agent, if taken. If a data snapshot
	 * is not taken, this data is disregarded. May be {@code null}.<br><br>
	 * 
	 * Default: {@code null}
	 * 
	 * @return The array of objects to be serialized alongside the snapshot data; May be {@code null}
	 */
	public List<Object> getExtraContext() {
		if (extraContext == null) {
			return null;
		} else {
			return Collections.unmodifiableList(extraContext);
		}
	}
	
	@Override
	public String toString() {
		return 	"Message: \"" + message + "\"\n" +
				"Force snapshot: " + forceSnapshot + "\n" +
				"Extra context: " + extraContext;
	}
	
	private static TakipiEventFireOptions createDefaultInstance() {
		return newBuilder().build();
	}
	
	/**
	 * Creates a new builder for the {@link TakipiEventFireOptions} class.<br><br>
	 * 
	 * See {@link TakipiEventFireOptions.Builder} for details.
	 * 
	 * @return A new {@code TakipiEventFireOptions.Builder} instance for constructing an immutable
	 * 		   {@code TakipiEventFireOptions} object.
	 */
	public static Builder newBuilder() {
		return new Builder();
	}
	
	/**
	 * This class allows for the easy configuration of the different parameters available in
	 * {@code TakipiEventFireOptions}. Once built, the returned {@code TakipiEventFireOptions}
	 * instance is immutable.
	 * 
	 * @author Niv Steingarten
	 */
	public static class Builder {
		
		private String message;
		private boolean forceSnapshot;
		private List<Object> extraContext;
		
		private Builder() {
			setDefaults();
		}
		
		private void setDefaults() {
			this.message = null;
			this.forceSnapshot = false;
			this.extraContext = null;
		}
		
		/**
		 * Sets a custom error message for this event instance.
		 * See {@link TakipiEventFireOptions#getMessage()}.
		 * 
		 * @param message The custom message to set. May be {@code null}
		 * @return The instance of the {@code Builder}
		 */
		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}
		
		/**
		 * Sets whether or not a data snapshot will be forcefully taken during this event instance
		 * (use with care). See {@link TakipiEventFireOptions#getForceSnapshot()}.
		 * 
		 * @param forceSnapshot Whether or not to force a data snapshot collection
		 * @return The instance of the {@code Builder}
		 */
		public Builder withForceSnapshot(boolean forceSnapshot) {
			this.forceSnapshot = forceSnapshot;
			return this;
		}
		
		/**
		 * Sets extra objects to be evacuated alongside the data snapshot, if a data snapshot is
		 * indeed evacuated. See {@link TakipiEventFireOptions#getExtraContext()}.<br><br>
		 * 
		 * This method <i>replaces</i> any extra context the {@code Builder} currently holds. To add
		 * objects to the existing list, see {@link Builder#addExtraContext(Collection)}.
		 * 
		 * @param extraContext A collection of objects to evacuate
		 * @return The instance of the {@code Builder}
		 */
		public Builder withExtraContext(Collection<Object> extraContext) {
			Assert.notNull(extraContext, "Extra context must not be null");
			
			this.extraContext = new ArrayList<Object>(extraContext);
			return this;
		}
		
		/**
		 * Adds extra objects to be evacuated alongside the data snapshot, if a data snapshot is
		 * indeed evacuated. See {@link TakipiEventFireOptions#getExtraContext()}.<br><br>
		 * 
		 * @param extraContext A collection of objects to add to the evacuation
		 * @return The instance of the {@code Builder}
		 */
		public Builder addExtraContext(Collection<Object> extraContext) {
			Assert.notNull(extraContext, "Extra context must not be null");
			
			if (this.extraContext == null) {
				this.extraContext = new ArrayList<Object>(extraContext);
			} else {
				this.extraContext.addAll(extraContext);
			}
			
			return this;
		}
		
		/**
		 * Clears the entire extra context that has been added to the {@code Builder} instance.
		 * 
		 * @return The instance of the {@code Builder}
		 */
		public Builder clearExtraContext() {
			this.extraContext = null;
			return this;
		}
		
		/**
		 * Constructs an immutable {@link TakipiEventFireOptions} object based on the options
		 * configured in this {@code Builder} instance.
		 * 
		 * @return An immutable {@code TakipiEventFireOptions} instance.
		 */
		public TakipiEventFireOptions build() {
			return new TakipiEventFireOptions(message, forceSnapshot, extraContext);
		}
	}
}
