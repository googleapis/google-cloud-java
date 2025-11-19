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
import com.google.genai.types.HttpOptions;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/** Config for generating memories. */
@AutoValue
@JsonDeserialize(builder = GenerateAgentEngineMemoriesConfig.Builder.class)
public abstract class GenerateAgentEngineMemoriesConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * Whether to disable consolidation of memories.
   *
   * <p>If true, generated memories will not be consolidated with existing memories; all generated
   * memories will be added as new memories regardless of whether they are duplicates of or
   * contradictory to existing memories. By default, memory consolidation is enabled.
   */
  @JsonProperty("disableConsolidation")
  public abstract Optional<Boolean> disableConsolidation();

  /** Waits for the operation to complete before returning. */
  @JsonProperty("waitForCompletion")
  public abstract Optional<Boolean> waitForCompletion();

  /**
   * Labels to apply to the memory revision. For example, you can use this to label a revision with
   * its data source.
   */
  @JsonProperty("revisionLabels")
  public abstract Optional<Map<String, String>> revisionLabels();

  /**
   * Optional. Input only. Timestamp of when the revision is considered expired. If not set, the
   * memory revision will be kept until manually deleted.
   */
  @JsonProperty("revisionExpireTime")
  public abstract Optional<Instant> revisionExpireTime();

  /** Optional. Input only. The TTL for the revision. The expiration time is computed: now + TTL. */
  @JsonProperty("revisionTtl")
  public abstract Optional<Duration> revisionTtl();

  /** Optional. Input only. If true, no revisions will be created for this request. */
  @JsonProperty("disableMemoryRevisions")
  public abstract Optional<Boolean> disableMemoryRevisions();

  /** Instantiates a builder for GenerateAgentEngineMemoriesConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateAgentEngineMemoriesConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateAgentEngineMemoriesConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateAgentEngineMemoriesConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateAgentEngineMemoriesConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for disableConsolidation.
     *
     * <p>disableConsolidation: Whether to disable consolidation of memories.
     *
     * <p>If true, generated memories will not be consolidated with existing memories; all generated
     * memories will be added as new memories regardless of whether they are duplicates of or
     * contradictory to existing memories. By default, memory consolidation is enabled.
     */
    @JsonProperty("disableConsolidation")
    public abstract Builder disableConsolidation(boolean disableConsolidation);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder disableConsolidation(Optional<Boolean> disableConsolidation);

    /** Clears the value of disableConsolidation field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisableConsolidation() {
      return disableConsolidation(Optional.empty());
    }

    /**
     * Setter for waitForCompletion.
     *
     * <p>waitForCompletion: Waits for the operation to complete before returning.
     */
    @JsonProperty("waitForCompletion")
    public abstract Builder waitForCompletion(boolean waitForCompletion);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder waitForCompletion(Optional<Boolean> waitForCompletion);

    /** Clears the value of waitForCompletion field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWaitForCompletion() {
      return waitForCompletion(Optional.empty());
    }

    /**
     * Setter for revisionLabels.
     *
     * <p>revisionLabels: Labels to apply to the memory revision. For example, you can use this to
     * label a revision with its data source.
     */
    @JsonProperty("revisionLabels")
    public abstract Builder revisionLabels(Map<String, String> revisionLabels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder revisionLabels(Optional<Map<String, String>> revisionLabels);

    /** Clears the value of revisionLabels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRevisionLabels() {
      return revisionLabels(Optional.empty());
    }

    /**
     * Setter for revisionExpireTime.
     *
     * <p>revisionExpireTime: Optional. Input only. Timestamp of when the revision is considered
     * expired. If not set, the memory revision will be kept until manually deleted.
     */
    @JsonProperty("revisionExpireTime")
    public abstract Builder revisionExpireTime(Instant revisionExpireTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder revisionExpireTime(Optional<Instant> revisionExpireTime);

    /** Clears the value of revisionExpireTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRevisionExpireTime() {
      return revisionExpireTime(Optional.empty());
    }

    /**
     * Setter for revisionTtl.
     *
     * <p>revisionTtl: Optional. Input only. The TTL for the revision. The expiration time is
     * computed: now + TTL.
     */
    @JsonProperty("revisionTtl")
    public abstract Builder revisionTtl(Duration revisionTtl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder revisionTtl(Optional<Duration> revisionTtl);

    /** Clears the value of revisionTtl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRevisionTtl() {
      return revisionTtl(Optional.empty());
    }

    /**
     * Setter for disableMemoryRevisions.
     *
     * <p>disableMemoryRevisions: Optional. Input only. If true, no revisions will be created for
     * this request.
     */
    @JsonProperty("disableMemoryRevisions")
    public abstract Builder disableMemoryRevisions(boolean disableMemoryRevisions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder disableMemoryRevisions(Optional<Boolean> disableMemoryRevisions);

    /** Clears the value of disableMemoryRevisions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisableMemoryRevisions() {
      return disableMemoryRevisions(Optional.empty());
    }

    public abstract GenerateAgentEngineMemoriesConfig build();
  }

  /** Deserializes a JSON string to a GenerateAgentEngineMemoriesConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateAgentEngineMemoriesConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GenerateAgentEngineMemoriesConfig.class);
  }
}
