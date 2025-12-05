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

/** Config for updating agent engine session. */
@AutoValue
@JsonDeserialize(builder = UpdateAgentEngineSessionConfig.Builder.class)
public abstract class UpdateAgentEngineSessionConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** The display name of the session. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Session state which stores key conversation points. */
  @JsonProperty("sessionState")
  public abstract Optional<Map<String, Object>> sessionState();

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
   * Optional. The labels with user-defined metadata to organize your Sessions. Label keys and
   * values can be no longer than 64 characters (Unicode codepoints), can only contain lowercase
   * letters, numeric characters, underscores and dashes. International characters are allowed. See
   * https://goo.gl/xmQnxf for more information and examples of labels.
   */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /**
   * The update mask to apply. For the `FieldMask` definition, see
   * https://protobuf.dev/reference/protobuf/google.protobuf/#field-mask.
   */
  @JsonProperty("updateMask")
  public abstract Optional<String> updateMask();

  /** User ID of the agent engine session to update. */
  @JsonProperty("userId")
  public abstract Optional<String> userId();

  /** Instantiates a builder for UpdateAgentEngineSessionConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_UpdateAgentEngineSessionConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for UpdateAgentEngineSessionConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `UpdateAgentEngineSessionConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_UpdateAgentEngineSessionConfig.Builder();
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
     * <p>displayName: The display name of the session.
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
     * Setter for sessionState.
     *
     * <p>sessionState: Session state which stores key conversation points.
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
     * Setter for labels.
     *
     * <p>labels: Optional. The labels with user-defined metadata to organize your Sessions. Label
     * keys and values can be no longer than 64 characters (Unicode codepoints), can only contain
     * lowercase letters, numeric characters, underscores and dashes. International characters are
     * allowed. See https://goo.gl/xmQnxf for more information and examples of labels.
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

    /**
     * Setter for userId.
     *
     * <p>userId: User ID of the agent engine session to update.
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

    public abstract UpdateAgentEngineSessionConfig build();
  }

  /** Deserializes a JSON string to a UpdateAgentEngineSessionConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static UpdateAgentEngineSessionConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, UpdateAgentEngineSessionConfig.class);
  }
}
