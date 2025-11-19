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
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/** A session. */
@AutoValue
@JsonDeserialize(builder = Session.Builder.class)
public abstract class Session extends JsonSerializable {
  /**
   * Optional. Timestamp of when this session is considered expired. This is *always* provided on
   * output, regardless of what was sent on input.
   */
  @JsonProperty("expireTime")
  public abstract Optional<Instant> expireTime();

  /** Optional. Input only. The TTL for this session. */
  @JsonProperty("ttl")
  public abstract Optional<Duration> ttl();

  /**
   * Identifier. The resource name of the session. Format:
   * 'projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}'.
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Output only. Timestamp when the session was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Output only. Timestamp when the session was updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Optional. The display name of the session. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /**
   * The labels with user-defined metadata to organize your Sessions. Label keys and values can be
   * no longer than 64 characters (Unicode codepoints), can only contain lowercase letters, numeric
   * characters, underscores and dashes. International characters are allowed. See
   * https://goo.gl/xmQnxf for more information and examples of labels.
   */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** Optional. Session specific memory which stores key conversation points. */
  @JsonProperty("sessionState")
  public abstract Optional<Map<String, Object>> sessionState();

  /** Required. Immutable. String id provided by the user */
  @JsonProperty("userId")
  public abstract Optional<String> userId();

  /** Instantiates a builder for Session. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Session.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Session. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Session.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Session.Builder();
    }

    /**
     * Setter for expireTime.
     *
     * <p>expireTime: Optional. Timestamp of when this session is considered expired. This is
     * *always* provided on output, regardless of what was sent on input.
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
     * <p>ttl: Optional. Input only. The TTL for this session.
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
     * Setter for name.
     *
     * <p>name: Identifier. The resource name of the session. Format:
     * 'projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}'.
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
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when the session was created.
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
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when the session was updated.
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
     * Setter for displayName.
     *
     * <p>displayName: Optional. The display name of the session.
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
     * Setter for labels.
     *
     * <p>labels: The labels with user-defined metadata to organize your Sessions. Label keys and
     * values can be no longer than 64 characters (Unicode codepoints), can only contain lowercase
     * letters, numeric characters, underscores and dashes. International characters are allowed.
     * See https://goo.gl/xmQnxf for more information and examples of labels.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for sessionState.
     *
     * <p>sessionState: Optional. Session specific memory which stores key conversation points.
     */
    @JsonProperty("sessionState")
    public abstract Builder sessionState(Map<String, Object> sessionState);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sessionState(Optional<Map<String, Object>> sessionState);

    /** Clears the value of sessionState field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSessionState() {
      return sessionState(Optional.empty());
    }

    /**
     * Setter for userId.
     *
     * <p>userId: Required. Immutable. String id provided by the user
     */
    @JsonProperty("userId")
    public abstract Builder userId(String userId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder userId(Optional<String> userId);

    /** Clears the value of userId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUserId() {
      return userId(Optional.empty());
    }

    public abstract Session build();
  }

  /** Deserializes a JSON string to a Session object. */
  @ExcludeFromGeneratedCoverageReport
  public static Session fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Session.class);
  }
}
