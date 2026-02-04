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
import com.google.genai.types.EncryptionSpec;
import com.google.genai.types.HttpOptions;
import java.util.Optional;

/** Config for creating a prompt. */
@AutoValue
@JsonDeserialize(builder = CreatePromptConfig.Builder.class)
public abstract class CreatePromptConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** The display name for the prompt. If not set, a default name with a timestamp will be used. */
  @JsonProperty("promptDisplayName")
  public abstract Optional<String> promptDisplayName();

  /**
   * The timeout for the create_version request in seconds. If not set, the default timeout is 90
   * seconds.
   */
  @JsonProperty("timeout")
  public abstract Optional<Integer> timeout();

  /**
   * Customer-managed encryption key spec for a prompt dataset. If set, this prompt dataset and all
   * sub-resources of this prompt dataset will be secured by this key.
   */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** Instantiates a builder for CreatePromptConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreatePromptConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreatePromptConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CreatePromptConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreatePromptConfig.Builder();
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
     * Setter for promptDisplayName.
     *
     * <p>promptDisplayName: The display name for the prompt. If not set, a default name with a
     * timestamp will be used.
     */
    @JsonProperty("promptDisplayName")
    public abstract Builder promptDisplayName(String promptDisplayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptDisplayName(Optional<String> promptDisplayName);

    /** Clears the value of promptDisplayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptDisplayName() {
      return promptDisplayName(Optional.empty());
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

    /**
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec: Customer-managed encryption key spec for a prompt dataset. If set, this
     * prompt dataset and all sub-resources of this prompt dataset will be secured by this key.
     */
    @JsonProperty("encryptionSpec")
    public abstract Builder encryptionSpec(EncryptionSpec encryptionSpec);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder encryptionSpec(Optional<EncryptionSpec> encryptionSpec);

    /** Clears the value of encryptionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEncryptionSpec() {
      return encryptionSpec(Optional.empty());
    }

    public abstract CreatePromptConfig build();
  }

  /** Deserializes a JSON string to a CreatePromptConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreatePromptConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreatePromptConfig.class);
  }
}
