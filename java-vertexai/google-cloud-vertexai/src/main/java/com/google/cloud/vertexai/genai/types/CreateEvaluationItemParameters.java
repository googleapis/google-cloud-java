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

/** Represents a job that creates an evaluation item. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = CreateEvaluationItemParameters.Builder.class)
public abstract class CreateEvaluationItemParameters extends JsonSerializable {
  /** */
  @JsonProperty("evaluationItemType")
  public abstract Optional<String> evaluationItemType();

  /** */
  @JsonProperty("gcsUri")
  public abstract Optional<String> gcsUri();

  /** */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** */
  @JsonProperty("config")
  public abstract Optional<CreateEvaluationItemConfig> config();

  /** Instantiates a builder for CreateEvaluationItemParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreateEvaluationItemParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreateEvaluationItemParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `CreateEvaluationItemParameters.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreateEvaluationItemParameters.Builder();
    }

    /**
     * Setter for evaluationItemType.
     *
     * <p>evaluationItemType:
     */
    @JsonProperty("evaluationItemType")
    public abstract Builder evaluationItemType(String evaluationItemType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationItemType(Optional<String> evaluationItemType);

    /** Clears the value of evaluationItemType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationItemType() {
      return evaluationItemType(Optional.empty());
    }

    /**
     * Setter for gcsUri.
     *
     * <p>gcsUri:
     */
    @JsonProperty("gcsUri")
    public abstract Builder gcsUri(String gcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsUri(Optional<String> gcsUri);

    /** Clears the value of gcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsUri() {
      return gcsUri(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName:
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
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(CreateEvaluationItemConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(CreateEvaluationItemConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<CreateEvaluationItemConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract CreateEvaluationItemParameters build();
  }

  /** Deserializes a JSON string to a CreateEvaluationItemParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreateEvaluationItemParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreateEvaluationItemParameters.class);
  }
}
