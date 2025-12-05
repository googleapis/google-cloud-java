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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Response for generating rubrics. */
@AutoValue
@JsonDeserialize(builder = GenerateInstanceRubricsResponse.Builder.class)
public abstract class GenerateInstanceRubricsResponse extends JsonSerializable {
  /** A list of generated rubrics. */
  @JsonProperty("generatedRubrics")
  public abstract Optional<List<Rubric>> generatedRubrics();

  /** Instantiates a builder for GenerateInstanceRubricsResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateInstanceRubricsResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateInstanceRubricsResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateInstanceRubricsResponse.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateInstanceRubricsResponse.Builder();
    }

    /**
     * Setter for generatedRubrics.
     *
     * <p>generatedRubrics: A list of generated rubrics.
     */
    @JsonProperty("generatedRubrics")
    public abstract Builder generatedRubrics(List<Rubric> generatedRubrics);

    /**
     * Setter for generatedRubrics.
     *
     * <p>generatedRubrics: A list of generated rubrics.
     */
    @CanIgnoreReturnValue
    public Builder generatedRubrics(Rubric... generatedRubrics) {
      return generatedRubrics(Arrays.asList(generatedRubrics));
    }

    /**
     * Setter for generatedRubrics builder.
     *
     * <p>generatedRubrics: A list of generated rubrics.
     */
    @CanIgnoreReturnValue
    public Builder generatedRubrics(Rubric.Builder... generatedRubricsBuilders) {
      return generatedRubrics(
          Arrays.asList(generatedRubricsBuilders).stream()
              .map(Rubric.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generatedRubrics(Optional<List<Rubric>> generatedRubrics);

    /** Clears the value of generatedRubrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGeneratedRubrics() {
      return generatedRubrics(Optional.empty());
    }

    public abstract GenerateInstanceRubricsResponse build();
  }

  /** Deserializes a JSON string to a GenerateInstanceRubricsResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateInstanceRubricsResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GenerateInstanceRubricsResponse.class);
  }
}
