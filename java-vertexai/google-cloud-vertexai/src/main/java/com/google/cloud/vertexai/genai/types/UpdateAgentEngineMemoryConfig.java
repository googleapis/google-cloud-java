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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.HttpOptions;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Config for updating agent engine memory. */
@AutoValue
@JsonDeserialize(builder = UpdateAgentEngineMemoryConfig.Builder.class)
public abstract class UpdateAgentEngineMemoryConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** The display name of the memory. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The description of the memory. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Waits for the operation to complete before returning. */
  @JsonProperty("waitForCompletion")
  public abstract Optional<Boolean> waitForCompletion();

  /**
   * Optional. Input only. The TTL for this resource.
   *
   * <p>The expiration time is computed: now + TTL.
   */
  @JsonProperty("ttl")
  public abstract Optional<Duration> ttl();

  /**
   * Optional. Timestamp of when this resource is considered expired. This is *always* provided on
   * output, regardless of what `expiration` was sent on input.
   */
  @JsonProperty("expireTime")
  public abstract Optional<Instant> expireTime();

  /**
   * Optional. Input only. Timestamp of when the revision is considered expired. If not set, the
   * memory revision will be kept until manually deleted.
   */
  @JsonProperty("revisionExpireTime")
  public abstract Optional<Instant> revisionExpireTime();

  /** Optional. Input only. The TTL for the revision. The expiration time is computed: now + TTL. */
  @JsonProperty("revisionTtl")
  public abstract Optional<Duration> revisionTtl();

  /** Optional. Input only. If true, no revision will be created for this request. */
  @JsonProperty("disableMemoryRevisions")
  public abstract Optional<Boolean> disableMemoryRevisions();

  /** Optional. The topics of the memory. */
  @JsonProperty("topics")
  public abstract Optional<List<MemoryTopicId>> topics();

  /**
   * The update mask to apply. For the `FieldMask` definition, see
   * https://protobuf.dev/reference/protobuf/google.protobuf/#field-mask.
   */
  @JsonProperty("updateMask")
  public abstract Optional<String> updateMask();

  /** Instantiates a builder for UpdateAgentEngineMemoryConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_UpdateAgentEngineMemoryConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for UpdateAgentEngineMemoryConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `UpdateAgentEngineMemoryConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_UpdateAgentEngineMemoryConfig.Builder();
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
     * Setter for displayName.
     *
     * <p>displayName: The display name of the memory.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: The description of the memory.
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
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
     * Setter for ttl.
     *
     * <p>ttl: Optional. Input only. The TTL for this resource.
     *
     * <p>The expiration time is computed: now + TTL.
     */
    @JsonProperty("ttl")
    public abstract Builder ttl(Duration ttl);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder ttl(Optional<Duration> ttl);

    /** Clears the value of ttl field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTtl() {
      return ttl(Optional.empty());
    }

    /**
     * Setter for expireTime.
     *
     * <p>expireTime: Optional. Timestamp of when this resource is considered expired. This is
     * *always* provided on output, regardless of what `expiration` was sent on input.
     */
    @JsonProperty("expireTime")
    public abstract Builder expireTime(Instant expireTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder expireTime(Optional<Instant> expireTime);

    /** Clears the value of expireTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExpireTime() {
      return expireTime(Optional.empty());
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
     * <p>disableMemoryRevisions: Optional. Input only. If true, no revision will be created for
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

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The topics of the memory.
     */
    @JsonProperty("topics")
    public abstract Builder topics(List<MemoryTopicId> topics);

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The topics of the memory.
     */
    @CanIgnoreReturnValue
    public Builder topics(MemoryTopicId... topics) {
      return topics(Arrays.asList(topics));
    }

    /**
     * Setter for topics builder.
     *
     * <p>topics: Optional. The topics of the memory.
     */
    @CanIgnoreReturnValue
    public Builder topics(MemoryTopicId.Builder... topicsBuilders) {
      return topics(
          Arrays.asList(topicsBuilders).stream()
              .map(MemoryTopicId.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder topics(Optional<List<MemoryTopicId>> topics);

    /** Clears the value of topics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTopics() {
      return topics(Optional.empty());
    }

    /**
     * Setter for updateMask.
     *
     * <p>updateMask: The update mask to apply. For the `FieldMask` definition, see
     * https://protobuf.dev/reference/protobuf/google.protobuf/#field-mask.
     */
    @JsonProperty("updateMask")
    public abstract Builder updateMask(String updateMask);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder updateMask(Optional<String> updateMask);

    /** Clears the value of updateMask field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUpdateMask() {
      return updateMask(Optional.empty());
    }

    public abstract UpdateAgentEngineMemoryConfig build();
  }

  /** Deserializes a JSON string to a UpdateAgentEngineMemoryConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static UpdateAgentEngineMemoryConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, UpdateAgentEngineMemoryConfig.class);
  }
}
