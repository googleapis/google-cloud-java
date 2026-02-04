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

/** Defines an instance for Rubric-based metrics, allowing various input formats. */
@AutoValue
@JsonDeserialize(builder = RubricBasedMetricInstance.Builder.class)
public abstract class RubricBasedMetricInstance extends JsonSerializable {
  /** Specify evaluation fields and their string values in JSON format. */
  @JsonProperty("jsonInstance")
  public abstract Optional<String> jsonInstance();

  /** Provide input as Gemini Content along with one or more associated rubric groups. */
  @JsonProperty("rubricEnhancedContents")
  public abstract Optional<RubricEnhancedContents> rubricEnhancedContents();

  /** Instantiates a builder for RubricBasedMetricInstance. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricBasedMetricInstance.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricBasedMetricInstance. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricBasedMetricInstance.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricBasedMetricInstance.Builder();
    }

    /**
     * Setter for jsonInstance.
     *
     * <p>jsonInstance: Specify evaluation fields and their string values in JSON format.
     */
    @JsonProperty("jsonInstance")
    public abstract Builder jsonInstance(String jsonInstance);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder jsonInstance(Optional<String> jsonInstance);

    /** Clears the value of jsonInstance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearJsonInstance() {
      return jsonInstance(Optional.empty());
    }

    /**
     * Setter for rubricEnhancedContents.
     *
     * <p>rubricEnhancedContents: Provide input as Gemini Content along with one or more associated
     * rubric groups.
     */
    @JsonProperty("rubricEnhancedContents")
    public abstract Builder rubricEnhancedContents(RubricEnhancedContents rubricEnhancedContents);

    /**
     * Setter for rubricEnhancedContents builder.
     *
     * <p>rubricEnhancedContents: Provide input as Gemini Content along with one or more associated
     * rubric groups.
     */
    @CanIgnoreReturnValue
    public Builder rubricEnhancedContents(
        RubricEnhancedContents.Builder rubricEnhancedContentsBuilder) {
      return rubricEnhancedContents(rubricEnhancedContentsBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricEnhancedContents(
        Optional<RubricEnhancedContents> rubricEnhancedContents);

    /** Clears the value of rubricEnhancedContents field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricEnhancedContents() {
      return rubricEnhancedContents(Optional.empty());
    }

    public abstract RubricBasedMetricInstance build();
  }

  /** Deserializes a JSON string to a RubricBasedMetricInstance object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricBasedMetricInstance fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricBasedMetricInstance.class);
  }
}
