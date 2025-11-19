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
import java.util.Map;
import java.util.Optional;

/** Represents a BigQuery request set. */
@AutoValue
@JsonDeserialize(builder = BigQueryRequestSet.Builder.class)
public abstract class BigQueryRequestSet extends JsonSerializable {
  /** */
  @JsonProperty("uri")
  public abstract Optional<String> uri();

  /** The column name of the prompt in the BigQuery table. Used for EvaluationRun only. */
  @JsonProperty("promptColumn")
  public abstract Optional<String> promptColumn();

  /** The column name of the rubrics in the BigQuery table. Used for EvaluationRun only. */
  @JsonProperty("rubricsColumn")
  public abstract Optional<String> rubricsColumn();

  /**
   * The column name of the response candidates in the BigQuery table. Used for EvaluationRun only.
   */
  @JsonProperty("candidateResponseColumns")
  public abstract Optional<Map<String, String>> candidateResponseColumns();

  /** The sampling config for the BigQuery request set. Used for EvaluationRun only. */
  @JsonProperty("samplingConfig")
  public abstract Optional<SamplingConfig> samplingConfig();

  /** Instantiates a builder for BigQueryRequestSet. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_BigQueryRequestSet.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for BigQueryRequestSet. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `BigQueryRequestSet.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_BigQueryRequestSet.Builder();
    }

    /**
     * Setter for uri.
     *
     * <p>uri:
     */
    @JsonProperty("uri")
    public abstract Builder uri(String uri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder uri(Optional<String> uri);

    /** Clears the value of uri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUri() {
      return uri(Optional.empty());
    }

    /**
     * Setter for promptColumn.
     *
     * <p>promptColumn: The column name of the prompt in the BigQuery table. Used for EvaluationRun
     * only.
     */
    @JsonProperty("promptColumn")
    public abstract Builder promptColumn(String promptColumn);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptColumn(Optional<String> promptColumn);

    /** Clears the value of promptColumn field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptColumn() {
      return promptColumn(Optional.empty());
    }

    /**
     * Setter for rubricsColumn.
     *
     * <p>rubricsColumn: The column name of the rubrics in the BigQuery table. Used for
     * EvaluationRun only.
     */
    @JsonProperty("rubricsColumn")
    public abstract Builder rubricsColumn(String rubricsColumn);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubricsColumn(Optional<String> rubricsColumn);

    /** Clears the value of rubricsColumn field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubricsColumn() {
      return rubricsColumn(Optional.empty());
    }

    /**
     * Setter for candidateResponseColumns.
     *
     * <p>candidateResponseColumns: The column name of the response candidates in the BigQuery
     * table. Used for EvaluationRun only.
     */
    @JsonProperty("candidateResponseColumns")
    public abstract Builder candidateResponseColumns(Map<String, String> candidateResponseColumns);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateResponseColumns(
        Optional<Map<String, String>> candidateResponseColumns);

    /** Clears the value of candidateResponseColumns field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateResponseColumns() {
      return candidateResponseColumns(Optional.empty());
    }

    /**
     * Setter for samplingConfig.
     *
     * <p>samplingConfig: The sampling config for the BigQuery request set. Used for EvaluationRun
     * only.
     */
    @JsonProperty("samplingConfig")
    public abstract Builder samplingConfig(SamplingConfig samplingConfig);

    /**
     * Setter for samplingConfig builder.
     *
     * <p>samplingConfig: The sampling config for the BigQuery request set. Used for EvaluationRun
     * only.
     */
    @CanIgnoreReturnValue
    public Builder samplingConfig(SamplingConfig.Builder samplingConfigBuilder) {
      return samplingConfig(samplingConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder samplingConfig(Optional<SamplingConfig> samplingConfig);

    /** Clears the value of samplingConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSamplingConfig() {
      return samplingConfig(Optional.empty());
    }

    public abstract BigQueryRequestSet build();
  }

  /** Deserializes a JSON string to a BigQueryRequestSet object. */
  @ExcludeFromGeneratedCoverageReport
  public static BigQueryRequestSet fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, BigQueryRequestSet.class);
  }
}
