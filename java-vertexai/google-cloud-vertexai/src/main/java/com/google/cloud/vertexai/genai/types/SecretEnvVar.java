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

/** Represents an environment variable where the value is a secret in Cloud Secret Manager. */
@AutoValue
@JsonDeserialize(builder = SecretEnvVar.Builder.class)
public abstract class SecretEnvVar extends JsonSerializable {
  /** Required. Name of the secret environment variable. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * Required. Reference to a secret stored in the Cloud Secret Manager that will provide the value
   * for this environment variable.
   */
  @JsonProperty("secretRef")
  public abstract Optional<SecretRef> secretRef();

  /** Instantiates a builder for SecretEnvVar. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SecretEnvVar.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SecretEnvVar. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SecretEnvVar.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SecretEnvVar.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Required. Name of the secret environment variable.
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
     * Setter for secretRef.
     *
     * <p>secretRef: Required. Reference to a secret stored in the Cloud Secret Manager that will
     * provide the value for this environment variable.
     */
    @JsonProperty("secretRef")
    public abstract Builder secretRef(SecretRef secretRef);

    /**
     * Setter for secretRef builder.
     *
     * <p>secretRef: Required. Reference to a secret stored in the Cloud Secret Manager that will
     * provide the value for this environment variable.
     */
    @CanIgnoreReturnValue
    public Builder secretRef(SecretRef.Builder secretRefBuilder) {
      return secretRef(secretRefBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder secretRef(Optional<SecretRef> secretRef);

    /** Clears the value of secretRef field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSecretRef() {
      return secretRef(Optional.empty());
    }

    public abstract SecretEnvVar build();
  }

  /** Deserializes a JSON string to a SecretEnvVar object. */
  @ExcludeFromGeneratedCoverageReport
  public static SecretEnvVar fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SecretEnvVar.class);
  }
}
