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
import java.util.Optional;

/** Config for creating a Sandbox. */
@AutoValue
@JsonDeserialize(builder = CreateAgentEngineSandboxConfig.Builder.class)
public abstract class CreateAgentEngineSandboxConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** The display name of the sandbox. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The description of the sandbox. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Waits for the operation to complete before returning. */
  @JsonProperty("waitForCompletion")
  public abstract Optional<Boolean> waitForCompletion();

  /** The TTL for this resource. The expiration time is computed: now + TTL. */
  @JsonProperty("ttl")
  public abstract Optional<Duration> ttl();

  /** Instantiates a builder for CreateAgentEngineSandboxConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreateAgentEngineSandboxConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreateAgentEngineSandboxConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `CreateAgentEngineSandboxConfig.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreateAgentEngineSandboxConfig.Builder();
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
     * <p>displayName: The display name of the sandbox.
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
     * <p>description: The description of the sandbox.
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
     * <p>ttl: The TTL for this resource. The expiration time is computed: now + TTL.
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

    public abstract CreateAgentEngineSandboxConfig build();
  }

  /** Deserializes a JSON string to a CreateAgentEngineSandboxConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreateAgentEngineSandboxConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreateAgentEngineSandboxConfig.class);
  }
}
