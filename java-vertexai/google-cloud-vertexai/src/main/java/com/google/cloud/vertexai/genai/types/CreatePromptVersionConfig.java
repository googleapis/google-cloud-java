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
import java.util.Optional;

/** Config for creating a prompt version. */
@AutoValue
@JsonDeserialize(builder = CreatePromptVersionConfig.Builder.class)
public abstract class CreatePromptVersionConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The display name for the prompt version. If not set, a default name with a timestamp will be
   * used.
   */
  @JsonProperty("versionDisplayName")
  public abstract Optional<String> versionDisplayName();

  /**
   * The timeout for the create_version request in seconds. If not set, the default timeout is 90
   * seconds.
   */
  @JsonProperty("timeout")
  public abstract Optional<Integer> timeout();

  /** Instantiates a builder for CreatePromptVersionConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreatePromptVersionConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreatePromptVersionConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CreatePromptVersionConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreatePromptVersionConfig.Builder();
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
     * Setter for versionDisplayName.
     *
     * <p>versionDisplayName: The display name for the prompt version. If not set, a default name
     * with a timestamp will be used.
     */
    @JsonProperty("versionDisplayName")
    public abstract Builder versionDisplayName(String versionDisplayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder versionDisplayName(Optional<String> versionDisplayName);

    /** Clears the value of versionDisplayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVersionDisplayName() {
      return versionDisplayName(Optional.empty());
    }

    /**
     * Setter for timeout.
     *
     * <p>timeout: The timeout for the create_version request in seconds. If not set, the default
     * timeout is 90 seconds.
     */
    @JsonProperty("timeout")
    public abstract Builder timeout(Integer timeout);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder timeout(Optional<Integer> timeout);

    /** Clears the value of timeout field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTimeout() {
      return timeout(Optional.empty());
    }

    public abstract CreatePromptVersionConfig build();
  }

  /** Deserializes a JSON string to a CreatePromptVersionConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreatePromptVersionConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreatePromptVersionConfig.class);
  }
}
