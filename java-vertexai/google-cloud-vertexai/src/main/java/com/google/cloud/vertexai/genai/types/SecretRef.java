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
import java.util.Optional;

/**
 * Reference to a secret stored in the Cloud Secret Manager that will provide the value for this
 * environment variable.
 */
@AutoValue
@JsonDeserialize(builder = SecretRef.Builder.class)
public abstract class SecretRef extends JsonSerializable {
  /** Required. The name of the secret in Cloud Secret Manager. Format: {secret_name}. */
  @JsonProperty("secret")
  public abstract Optional<String> secret();

  /**
   * The Cloud Secret Manager secret version. Can be 'latest' for the latest version, an integer for
   * a specific version, or a version alias.
   */
  @JsonProperty("version")
  public abstract Optional<String> version();

  /** Instantiates a builder for SecretRef. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SecretRef.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SecretRef. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SecretRef.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SecretRef.Builder();
    }

    /**
     * Setter for secret.
     *
     * <p>secret: Required. The name of the secret in Cloud Secret Manager. Format: {secret_name}.
     */
    @JsonProperty("secret")
    public abstract Builder secret(String secret);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder secret(Optional<String> secret);

    /** Clears the value of secret field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSecret() {
      return secret(Optional.empty());
    }

    /**
     * Setter for version.
     *
     * <p>version: The Cloud Secret Manager secret version. Can be 'latest' for the latest version,
     * an integer for a specific version, or a version alias.
     */
    @JsonProperty("version")
    public abstract Builder version(String version);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder version(Optional<String> version);

    /** Clears the value of version field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVersion() {
      return version(Optional.empty());
    }

    public abstract SecretRef build();
  }

  /** Deserializes a JSON string to a SecretRef object. */
  @ExcludeFromGeneratedCoverageReport
  public static SecretRef fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SecretRef.class);
  }
}
