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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Represents a job that gets an evaluation set. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = GetEvaluationSetParameters.Builder.class)
public abstract class GetEvaluationSetParameters extends JsonSerializable {
  /** */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** */
  @JsonProperty("config")
  public abstract Optional<GetEvaluationSetConfig> config();

  /** Instantiates a builder for GetEvaluationSetParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GetEvaluationSetParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GetEvaluationSetParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GetEvaluationSetParameters.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GetEvaluationSetParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name:
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
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(GetEvaluationSetConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(GetEvaluationSetConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<GetEvaluationSetConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract GetEvaluationSetParameters build();
  }

  /** Deserializes a JSON string to a GetEvaluationSetParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static GetEvaluationSetParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GetEvaluationSetParameters.class);
  }
}
