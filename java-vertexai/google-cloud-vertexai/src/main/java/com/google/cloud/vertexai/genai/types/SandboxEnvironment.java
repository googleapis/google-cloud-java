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
import java.util.Optional;

/** A sandbox environment. */
@AutoValue
@JsonDeserialize(builder = SandboxEnvironment.Builder.class)
public abstract class SandboxEnvironment extends JsonSerializable {
  /** Expiration time of the sandbox environment. */
  @JsonProperty("expireTime")
  public abstract Optional<Instant> expireTime();

  /** Output only. The connection information of the SandboxEnvironment. */
  @JsonProperty("connectionInfo")
  public abstract Optional<SandboxEnvironmentConnectionInfo> connectionInfo();

  /** Output only. The timestamp when this SandboxEnvironment was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Required. The display name of the SandboxEnvironment. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Identifier. The name of the SandboxEnvironment. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Optional. The configuration of the SandboxEnvironment. */
  @JsonProperty("spec")
  public abstract Optional<SandboxEnvironmentSpec> spec();

  /** Output only. The runtime state of the SandboxEnvironment. */
  @JsonProperty("state")
  public abstract Optional<State> state();

  /**
   * Optional. Input only. The TTL for the sandbox environment. The expiration time is computed: now
   * + TTL.
   */
  @JsonProperty("ttl")
  public abstract Optional<Duration> ttl();

  /** Output only. The timestamp when this SandboxEnvironment was most recently updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Instantiates a builder for SandboxEnvironment. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SandboxEnvironment.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SandboxEnvironment. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SandboxEnvironment.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SandboxEnvironment.Builder();
    }

    /**
     * Setter for expireTime.
     *
     * <p>expireTime: Expiration time of the sandbox environment.
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
     * Setter for connectionInfo.
     *
     * <p>connectionInfo: Output only. The connection information of the SandboxEnvironment.
     */
    @JsonProperty("connectionInfo")
    public abstract Builder connectionInfo(SandboxEnvironmentConnectionInfo connectionInfo);

    /**
     * Setter for connectionInfo builder.
     *
     * <p>connectionInfo: Output only. The connection information of the SandboxEnvironment.
     */
    @CanIgnoreReturnValue
    public Builder connectionInfo(SandboxEnvironmentConnectionInfo.Builder connectionInfoBuilder) {
      return connectionInfo(connectionInfoBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder connectionInfo(Optional<SandboxEnvironmentConnectionInfo> connectionInfo);

    /** Clears the value of connectionInfo field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConnectionInfo() {
      return connectionInfo(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Output only. The timestamp when this SandboxEnvironment was created.
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
     * Setter for displayName.
     *
     * <p>displayName: Required. The display name of the SandboxEnvironment.
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
     * Setter for name.
     *
     * <p>name: Identifier. The name of the SandboxEnvironment.
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
     * Setter for spec.
     *
     * <p>spec: Optional. The configuration of the SandboxEnvironment.
     */
    @JsonProperty("spec")
    public abstract Builder spec(SandboxEnvironmentSpec spec);

    /**
     * Setter for spec builder.
     *
     * <p>spec: Optional. The configuration of the SandboxEnvironment.
     */
    @CanIgnoreReturnValue
    public Builder spec(SandboxEnvironmentSpec.Builder specBuilder) {
      return spec(specBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder spec(Optional<SandboxEnvironmentSpec> spec);

    /** Clears the value of spec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSpec() {
      return spec(Optional.empty());
    }

    /**
     * Setter for state.
     *
     * <p>state: Output only. The runtime state of the SandboxEnvironment.
     */
    @JsonProperty("state")
    public abstract Builder state(State state);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder state(Optional<State> state);

    /** Clears the value of state field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearState() {
      return state(Optional.empty());
    }

    /**
     * Setter for state given a known enum.
     *
     * <p>state: Output only. The runtime state of the SandboxEnvironment.
     */
    @CanIgnoreReturnValue
    public Builder state(State.Known knownType) {
      return state(new State(knownType));
    }

    /**
     * Setter for state given a string.
     *
     * <p>state: Output only. The runtime state of the SandboxEnvironment.
     */
    @CanIgnoreReturnValue
    public Builder state(String state) {
      return state(new State(state));
    }

    /**
     * Setter for ttl.
     *
     * <p>ttl: Optional. Input only. The TTL for the sandbox environment. The expiration time is
     * computed: now + TTL.
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
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. The timestamp when this SandboxEnvironment was most recently
     * updated.
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

    public abstract SandboxEnvironment build();
  }

  /** Deserializes a JSON string to a SandboxEnvironment object. */
  @ExcludeFromGeneratedCoverageReport
  public static SandboxEnvironment fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SandboxEnvironment.class);
  }
}
