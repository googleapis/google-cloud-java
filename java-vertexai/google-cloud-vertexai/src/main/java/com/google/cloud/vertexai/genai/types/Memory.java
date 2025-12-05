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
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** A memory. */
@AutoValue
@JsonDeserialize(builder = Memory.Builder.class)
public abstract class Memory extends JsonSerializable {
  /**
   * Optional. Timestamp of when this resource is considered expired. This is *always* provided on
   * output when `expiration` is set on input, regardless of whether `expire_time` or `ttl` was
   * provided.
   */
  @JsonProperty("expireTime")
  public abstract Optional<Instant> expireTime();

  /**
   * Optional. Input only. The TTL for this resource. The expiration time is computed: now + TTL.
   */
  @JsonProperty("ttl")
  public abstract Optional<Duration> ttl();

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

  /** Output only. Timestamp when this Memory was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Optional. Description of the Memory. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Optional. Display name of the Memory. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Required. Semantic knowledge extracted from the source content. */
  @JsonProperty("fact")
  public abstract Optional<String> fact();

  /**
   * Identifier. The resource name of the Memory. Format:
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * Required. Immutable. The scope of the Memory. Memories are isolated within their scope. The
   * scope is defined when creating or generating memories. Scope values cannot contain the wildcard
   * character '*'.
   */
  @JsonProperty("scope")
  public abstract Optional<Map<String, String>> scope();

  /** Output only. Timestamp when this Memory was most recently updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Optional. The Topics of the Memory. */
  @JsonProperty("topics")
  public abstract Optional<List<MemoryTopicId>> topics();

  /** Instantiates a builder for Memory. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Memory.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Memory. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Memory.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Memory.Builder();
    }

    /**
     * Setter for expireTime.
     *
     * <p>expireTime: Optional. Timestamp of when this resource is considered expired. This is
     * *always* provided on output when `expiration` is set on input, regardless of whether
     * `expire_time` or `ttl` was provided.
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
     * Setter for ttl.
     *
     * <p>ttl: Optional. Input only. The TTL for this resource. The expiration time is computed: now
     * + TTL.
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
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this Memory was created.
     */
    @JsonProperty("createTime")
    public abstract Builder createTime(Instant createTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder createTime(Optional<Instant> createTime);

    /** Clears the value of createTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreateTime() {
      return createTime(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: Optional. Description of the Memory.
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
     * Setter for displayName.
     *
     * <p>displayName: Optional. Display name of the Memory.
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
     * Setter for fact.
     *
     * <p>fact: Required. Semantic knowledge extracted from the source content.
     */
    @JsonProperty("fact")
    public abstract Builder fact(String fact);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder fact(Optional<String> fact);

    /** Clears the value of fact field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFact() {
      return fact(Optional.empty());
    }

    /**
     * Setter for name.
     *
     * <p>name: Identifier. The resource name of the Memory. Format:
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for scope.
     *
     * <p>scope: Required. Immutable. The scope of the Memory. Memories are isolated within their
     * scope. The scope is defined when creating or generating memories. Scope values cannot contain
     * the wildcard character '*'.
     */
    @JsonProperty("scope")
    public abstract Builder scope(Map<String, String> scope);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder scope(Optional<Map<String, String>> scope);

    /** Clears the value of scope field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScope() {
      return scope(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when this Memory was most recently updated.
     */
    @JsonProperty("updateTime")
    public abstract Builder updateTime(Instant updateTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder updateTime(Optional<Instant> updateTime);

    /** Clears the value of updateTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUpdateTime() {
      return updateTime(Optional.empty());
    }

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The Topics of the Memory.
     */
    @JsonProperty("topics")
    public abstract Builder topics(List<MemoryTopicId> topics);

    /**
     * Setter for topics.
     *
     * <p>topics: Optional. The Topics of the Memory.
     */
    @CanIgnoreReturnValue
    public Builder topics(MemoryTopicId... topics) {
      return topics(Arrays.asList(topics));
    }

    /**
     * Setter for topics builder.
     *
     * <p>topics: Optional. The Topics of the Memory.
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

    public abstract Memory build();
  }

  /** Deserializes a JSON string to a Memory object. */
  @ExcludeFromGeneratedCoverageReport
  public static Memory fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Memory.class);
  }
}
