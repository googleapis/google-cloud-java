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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a job that creates an evaluation set. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = CreateEvaluationSetParameters.Builder.class)
public abstract class CreateEvaluationSetParameters extends JsonSerializable {
  /** */
  @JsonProperty("evaluationItems")
  public abstract Optional<List<String>> evaluationItems();

  /** */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** */
  @JsonProperty("config")
  public abstract Optional<CreateEvaluationSetConfig> config();

  /** Instantiates a builder for CreateEvaluationSetParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreateEvaluationSetParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreateEvaluationSetParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `CreateEvaluationSetParameters.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreateEvaluationSetParameters.Builder();
    }

    /**
     * Setter for evaluationItems.
     *
     * <p>evaluationItems:
     */
    @JsonProperty("evaluationItems")
    public abstract Builder evaluationItems(List<String> evaluationItems);

    /**
     * Setter for evaluationItems.
     *
     * <p>evaluationItems:
     */
    @CanIgnoreReturnValue
    public Builder evaluationItems(String... evaluationItems) {
      return evaluationItems(Arrays.asList(evaluationItems));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationItems(Optional<List<String>> evaluationItems);

    /** Clears the value of evaluationItems field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationItems() {
      return evaluationItems(Optional.empty());
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
    public abstract Builder config(CreateEvaluationSetConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(CreateEvaluationSetConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<CreateEvaluationSetConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract CreateEvaluationSetParameters build();
  }

  /** Deserializes a JSON string to a CreateEvaluationSetParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreateEvaluationSetParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreateEvaluationSetParameters.class);
  }
}
