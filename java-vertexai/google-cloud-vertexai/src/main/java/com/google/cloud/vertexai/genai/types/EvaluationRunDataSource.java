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

/** Represents an evaluation run data source. */
@AutoValue
@JsonDeserialize(builder = EvaluationRunDataSource.Builder.class)
public abstract class EvaluationRunDataSource extends JsonSerializable {
  /** */
  @JsonProperty("evaluationSet")
  public abstract Optional<String> evaluationSet();

  /** */
  @JsonProperty("bigqueryRequestSet")
  public abstract Optional<BigQueryRequestSet> bigqueryRequestSet();

  /** Instantiates a builder for EvaluationRunDataSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunDataSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunDataSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunDataSource.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunDataSource.Builder();
    }

    /**
     * Setter for evaluationSet.
     *
     * <p>evaluationSet:
     */
    @JsonProperty("evaluationSet")
    public abstract Builder evaluationSet(String evaluationSet);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationSet(Optional<String> evaluationSet);

    /** Clears the value of evaluationSet field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationSet() {
      return evaluationSet(Optional.empty());
    }

    /**
     * Setter for bigqueryRequestSet.
     *
     * <p>bigqueryRequestSet:
     */
    @JsonProperty("bigqueryRequestSet")
    public abstract Builder bigqueryRequestSet(BigQueryRequestSet bigqueryRequestSet);

    /**
     * Setter for bigqueryRequestSet builder.
     *
     * <p>bigqueryRequestSet:
     */
    @CanIgnoreReturnValue
    public Builder bigqueryRequestSet(BigQueryRequestSet.Builder bigqueryRequestSetBuilder) {
      return bigqueryRequestSet(bigqueryRequestSetBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bigqueryRequestSet(Optional<BigQueryRequestSet> bigqueryRequestSet);

    /** Clears the value of bigqueryRequestSet field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBigqueryRequestSet() {
      return bigqueryRequestSet(Optional.empty());
    }

    public abstract EvaluationRunDataSource build();
  }

  /** Deserializes a JSON string to a EvaluationRunDataSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunDataSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunDataSource.class);
  }
}
