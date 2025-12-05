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
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Metadata for an evaluation run. */
@AutoValue
@JsonDeserialize(builder = EvaluationRunMetadata.Builder.class)
public abstract class EvaluationRunMetadata extends JsonSerializable {
  /** Name of the candidate(s) being evaluated in the evaluation run. */
  @JsonProperty("candidateNames")
  public abstract Optional<List<String>> candidateNames();

  /** Name of the evaluation dataset used for the evaluation run. */
  @JsonProperty("datasetName")
  public abstract Optional<String> datasetName();

  /** Unique identifier for the evaluation dataset used for the evaluation run. */
  @JsonProperty("datasetId")
  public abstract Optional<String> datasetId();

  /** Creation timestamp of the evaluation run. */
  @JsonProperty("creationTimestamp")
  public abstract Optional<Instant> creationTimestamp();

  /** Instantiates a builder for EvaluationRunMetadata. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationRunMetadata.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationRunMetadata. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationRunMetadata.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationRunMetadata.Builder();
    }

    /**
     * Setter for candidateNames.
     *
     * <p>candidateNames: Name of the candidate(s) being evaluated in the evaluation run.
     */
    @JsonProperty("candidateNames")
    public abstract Builder candidateNames(List<String> candidateNames);

    /**
     * Setter for candidateNames.
     *
     * <p>candidateNames: Name of the candidate(s) being evaluated in the evaluation run.
     */
    @CanIgnoreReturnValue
    public Builder candidateNames(String... candidateNames) {
      return candidateNames(Arrays.asList(candidateNames));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateNames(Optional<List<String>> candidateNames);

    /** Clears the value of candidateNames field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateNames() {
      return candidateNames(Optional.empty());
    }

    /**
     * Setter for datasetName.
     *
     * <p>datasetName: Name of the evaluation dataset used for the evaluation run.
     */
    @JsonProperty("datasetName")
    public abstract Builder datasetName(String datasetName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasetName(Optional<String> datasetName);

    /** Clears the value of datasetName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasetName() {
      return datasetName(Optional.empty());
    }

    /**
     * Setter for datasetId.
     *
     * <p>datasetId: Unique identifier for the evaluation dataset used for the evaluation run.
     */
    @JsonProperty("datasetId")
    public abstract Builder datasetId(String datasetId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasetId(Optional<String> datasetId);

    /** Clears the value of datasetId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasetId() {
      return datasetId(Optional.empty());
    }

    /**
     * Setter for creationTimestamp.
     *
     * <p>creationTimestamp: Creation timestamp of the evaluation run.
     */
    @JsonProperty("creationTimestamp")
    public abstract Builder creationTimestamp(Instant creationTimestamp);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder creationTimestamp(Optional<Instant> creationTimestamp);

    /** Clears the value of creationTimestamp field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreationTimestamp() {
      return creationTimestamp(Optional.empty());
    }

    public abstract EvaluationRunMetadata build();
  }

  /** Deserializes a JSON string to a EvaluationRunMetadata object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationRunMetadata fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationRunMetadata.class);
  }
}
