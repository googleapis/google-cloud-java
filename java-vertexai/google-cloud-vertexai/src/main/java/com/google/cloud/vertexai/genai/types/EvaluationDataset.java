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

/** The dataset used for evaluation. */
@AutoValue
@JsonDeserialize(builder = EvaluationDataset.Builder.class)
public abstract class EvaluationDataset extends JsonSerializable {
  /** The evaluation cases to be evaluated. */
  @JsonProperty("evalCases")
  public abstract Optional<List<EvalCase>> evalCases();

  /** The name of the candidate model or agent for this evaluation dataset. */
  @JsonProperty("candidateName")
  public abstract Optional<String> candidateName();

  /** The GCS source for the evaluation dataset. */
  @JsonProperty("gcsSource")
  public abstract Optional<GcsSource> gcsSource();

  /** The BigQuery source for the evaluation dataset. */
  @JsonProperty("bigquerySource")
  public abstract Optional<BigQuerySource> bigquerySource();

  /** Instantiates a builder for EvaluationDataset. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationDataset.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationDataset. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationDataset.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationDataset.Builder();
    }

    /**
     * Setter for evalCases.
     *
     * <p>evalCases: The evaluation cases to be evaluated.
     */
    @JsonProperty("evalCases")
    public abstract Builder evalCases(List<EvalCase> evalCases);

    /**
     * Setter for evalCases.
     *
     * <p>evalCases: The evaluation cases to be evaluated.
     */
    @CanIgnoreReturnValue
    public Builder evalCases(EvalCase... evalCases) {
      return evalCases(Arrays.asList(evalCases));
    }

    /**
     * Setter for evalCases builder.
     *
     * <p>evalCases: The evaluation cases to be evaluated.
     */
    @CanIgnoreReturnValue
    public Builder evalCases(EvalCase.Builder... evalCasesBuilders) {
      return evalCases(
          Arrays.asList(evalCasesBuilders).stream()
              .map(EvalCase.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evalCases(Optional<List<EvalCase>> evalCases);

    /** Clears the value of evalCases field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvalCases() {
      return evalCases(Optional.empty());
    }

    /**
     * Setter for candidateName.
     *
     * <p>candidateName: The name of the candidate model or agent for this evaluation dataset.
     */
    @JsonProperty("candidateName")
    public abstract Builder candidateName(String candidateName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateName(Optional<String> candidateName);

    /** Clears the value of candidateName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateName() {
      return candidateName(Optional.empty());
    }

    /**
     * Setter for gcsSource.
     *
     * <p>gcsSource: The GCS source for the evaluation dataset.
     */
    @JsonProperty("gcsSource")
    public abstract Builder gcsSource(GcsSource gcsSource);

    /**
     * Setter for gcsSource builder.
     *
     * <p>gcsSource: The GCS source for the evaluation dataset.
     */
    @CanIgnoreReturnValue
    public Builder gcsSource(GcsSource.Builder gcsSourceBuilder) {
      return gcsSource(gcsSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsSource(Optional<GcsSource> gcsSource);

    /** Clears the value of gcsSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsSource() {
      return gcsSource(Optional.empty());
    }

    /**
     * Setter for bigquerySource.
     *
     * <p>bigquerySource: The BigQuery source for the evaluation dataset.
     */
    @JsonProperty("bigquerySource")
    public abstract Builder bigquerySource(BigQuerySource bigquerySource);

    /**
     * Setter for bigquerySource builder.
     *
     * <p>bigquerySource: The BigQuery source for the evaluation dataset.
     */
    @CanIgnoreReturnValue
    public Builder bigquerySource(BigQuerySource.Builder bigquerySourceBuilder) {
      return bigquerySource(bigquerySourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bigquerySource(Optional<BigQuerySource> bigquerySource);

    /** Clears the value of bigquerySource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBigquerySource() {
      return bigquerySource(Optional.empty());
    }

    public abstract EvaluationDataset build();
  }

  /** Deserializes a JSON string to a EvaluationDataset object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationDataset fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationDataset.class);
  }
}
