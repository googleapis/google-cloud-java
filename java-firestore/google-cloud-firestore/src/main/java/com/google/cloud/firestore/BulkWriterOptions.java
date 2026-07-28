/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore;

import com.google.auto.value.AutoValue;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Options used to configure request throttling in BulkWriter. */
@AutoValue
public abstract class BulkWriterOptions {
  /**
   * Return whether throttling is enabled.
   *
   * @return Whether throttling is enabled.
   */
  public abstract boolean getThrottlingEnabled();

  /**
   * Returns the initial maximum number of operations per second allowed by the throttler.
   *
   * @return The initial maximum number of operations per second allowed by the throttler.
   */
  @Nullable
  public abstract Double getInitialOpsPerSecond();

  /**
   * Returns the maximum number of operations per second allowed by the throttler.
   *
   * <p>The throttler's allowed operations per second does not ramp up past the specified operations
   * per second.
   *
   * @return The maximum number of operations per second allowed by the throttler.
   */
  @Nullable
  public abstract Double getMaxOpsPerSecond();

  /**
   * @return The {@link ScheduledExecutorService} that BulkWriter uses to schedule all operations.
   *     If null, the default executor will be used.
   */
  @Nullable
  public abstract ScheduledExecutorService getExecutor();

  public static Builder builder() {
    return new AutoValue_BulkWriterOptions.Builder()
        .setMaxOpsPerSecond(null)
        .setInitialOpsPerSecond(null)
        .setThrottlingEnabled(true)
        .setExecutor(null);
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Sets whether throttling should be enabled. By default, throttling is enabled.
     *
     * @param enabled Whether throttling should be enabled.
     */
    public abstract Builder setThrottlingEnabled(boolean enabled);

    /**
     * Set the initial maximum number of operations per second allowed by the throttler.
     *
     * @param initialOpsPerSecond The initial maximum number of operations per second allowed by the
     *     throttler.
     */
    abstract Builder setInitialOpsPerSecond(@Nullable Double initialOpsPerSecond);

    /**
     * Set the initial maximum number of operations per second allowed by the throttler.
     *
     * @param initialOpsPerSecond The initial maximum number of operations per second allowed by the
     *     throttler.
     */
    public Builder setInitialOpsPerSecond(int initialOpsPerSecond) {
      return setInitialOpsPerSecond(new Double(initialOpsPerSecond));
    }

    /**
     * Set the maximum number of operations per second allowed by the throttler.
     *
     * @param maxOpsPerSecond The maximum number of operations per second allowed by the throttler.
     *     The throttler's allowed operations per second does not ramp up past the specified
     *     operations per second.
     */
    abstract Builder setMaxOpsPerSecond(@Nullable Double maxOpsPerSecond);

    /**
     * Set the maximum number of operations per second allowed by the throttler.
     *
     * @param maxOpsPerSecond The maximum number of operations per second allowed by the throttler.
     *     The throttler's allowed operations per second does not ramp up past the specified
     *     operations per second.
     */
    public Builder setMaxOpsPerSecond(int maxOpsPerSecond) {
      return setMaxOpsPerSecond(new Double(maxOpsPerSecond));
    }

    /**
     * Set the executor that the BulkWriter instance schedules operations on.
     *
     * @param executor The executor to schedule BulkWriter operations on.
     */
    public abstract Builder setExecutor(@Nullable ScheduledExecutorService executor);

    public abstract BulkWriterOptions autoBuild();

    @Nonnull
    public BulkWriterOptions build() {
      BulkWriterOptions options = autoBuild();
      Double initialRate = options.getInitialOpsPerSecond();
      Double maxRate = options.getMaxOpsPerSecond();

      if (initialRate != null && initialRate < 1) {
        throw FirestoreException.forInvalidArgument(
            "Value for argument 'initialOpsPerSecond' must be greater than 1, but was: "
                + initialRate.intValue());
      }

      if (maxRate != null && maxRate < 1) {
        throw FirestoreException.forInvalidArgument(
            "Value for argument 'maxOpsPerSecond' must be greater than 1, but was: "
                + maxRate.intValue());
      }

      if (maxRate != null && initialRate != null && initialRate > maxRate) {
        throw FirestoreException.forInvalidArgument(
            "'maxOpsPerSecond' cannot be less than 'initialOpsPerSecond'.");
      }

      if (!options.getThrottlingEnabled() && (maxRate != null || initialRate != null)) {
        throw FirestoreException.forInvalidArgument(
            "Cannot set 'initialOpsPerSecond' or 'maxOpsPerSecond' when 'throttlingEnabled' is set"
                + " to false.");
      }
      return options;
    }
  }
}
