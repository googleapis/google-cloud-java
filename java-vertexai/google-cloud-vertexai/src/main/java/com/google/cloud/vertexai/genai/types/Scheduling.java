/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.time.Duration;
import java.util.Optional;

/** All parameters related to queuing and scheduling of custom jobs. */
@AutoValue
@JsonDeserialize(builder = Scheduling.Builder.class)
public abstract class Scheduling extends JsonSerializable {
  /**
   * Optional. Indicates if the job should retry for internal errors after the job starts running.
   * If true, overrides `Scheduling.restart_job_on_worker_restart` to false.
   */
  @JsonProperty("disableRetries")
  public abstract Optional<Boolean> disableRetries();

  /**
   * Optional. This is the maximum duration that a job will wait for the requested resources to be
   * provisioned if the scheduling strategy is set to [Strategy.DWS_FLEX_START]. If set to 0, the
   * job will wait indefinitely. The default is 24 hours.
   */
  @JsonProperty("maxWaitDuration")
  public abstract Optional<Duration> maxWaitDuration();

  /**
   * Optional. Restarts the entire CustomJob if a worker gets restarted. This feature can be used by
   * distributed training jobs that are not resilient to workers leaving and joining a job.
   */
  @JsonProperty("restartJobOnWorkerRestart")
  public abstract Optional<Boolean> restartJobOnWorkerRestart();

  /** Optional. This determines which type of scheduling strategy to use. */
  @JsonProperty("strategy")
  public abstract Optional<Strategy> strategy();

  /** Optional. The maximum job running time. The default is 7 days. */
  @JsonProperty("timeout")
  public abstract Optional<Duration> timeout();

  /** Instantiates a builder for Scheduling. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Scheduling.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Scheduling. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Scheduling.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Scheduling.Builder();
    }

    /**
     * Setter for disableRetries.
     *
     * <p>disableRetries: Optional. Indicates if the job should retry for internal errors after the
     * job starts running. If true, overrides `Scheduling.restart_job_on_worker_restart` to false.
     */
    @JsonProperty("disableRetries")
    public abstract Builder disableRetries(boolean disableRetries);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder disableRetries(Optional<Boolean> disableRetries);

    /** Clears the value of disableRetries field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisableRetries() {
      return disableRetries(Optional.empty());
    }

    /**
     * Setter for maxWaitDuration.
     *
     * <p>maxWaitDuration: Optional. This is the maximum duration that a job will wait for the
     * requested resources to be provisioned if the scheduling strategy is set to
     * [Strategy.DWS_FLEX_START]. If set to 0, the job will wait indefinitely. The default is 24
     * hours.
     */
    @JsonProperty("maxWaitDuration")
    public abstract Builder maxWaitDuration(Duration maxWaitDuration);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder maxWaitDuration(Optional<Duration> maxWaitDuration);

    /** Clears the value of maxWaitDuration field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMaxWaitDuration() {
      return maxWaitDuration(Optional.empty());
    }

    /**
     * Setter for restartJobOnWorkerRestart.
     *
     * <p>restartJobOnWorkerRestart: Optional. Restarts the entire CustomJob if a worker gets
     * restarted. This feature can be used by distributed training jobs that are not resilient to
     * workers leaving and joining a job.
     */
    @JsonProperty("restartJobOnWorkerRestart")
    public abstract Builder restartJobOnWorkerRestart(boolean restartJobOnWorkerRestart);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder restartJobOnWorkerRestart(Optional<Boolean> restartJobOnWorkerRestart);

    /** Clears the value of restartJobOnWorkerRestart field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRestartJobOnWorkerRestart() {
      return restartJobOnWorkerRestart(Optional.empty());
    }

    /**
     * Setter for strategy.
     *
     * <p>strategy: Optional. This determines which type of scheduling strategy to use.
     */
    @JsonProperty("strategy")
    public abstract Builder strategy(Strategy strategy);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder strategy(Optional<Strategy> strategy);

    /** Clears the value of strategy field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStrategy() {
      return strategy(Optional.empty());
    }

    /**
     * Setter for strategy given a known enum.
     *
     * <p>strategy: Optional. This determines which type of scheduling strategy to use.
     */
    @CanIgnoreReturnValue
    public Builder strategy(Strategy.Known knownType) {
      return strategy(new Strategy(knownType));
    }

    /**
     * Setter for strategy given a string.
     *
     * <p>strategy: Optional. This determines which type of scheduling strategy to use.
     */
    @CanIgnoreReturnValue
    public Builder strategy(String strategy) {
      return strategy(new Strategy(strategy));
    }

    /**
     * Setter for timeout.
     *
     * <p>timeout: Optional. The maximum job running time. The default is 7 days.
     */
    @JsonProperty("timeout")
    public abstract Builder timeout(Duration timeout);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder timeout(Optional<Duration> timeout);

    /** Clears the value of timeout field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTimeout() {
      return timeout(Optional.empty());
    }

    public abstract Scheduling build();
  }

  /** Deserializes a JSON string to a Scheduling object. */
  @ExcludeFromGeneratedCoverageReport
  public static Scheduling fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Scheduling.class);
  }
}
