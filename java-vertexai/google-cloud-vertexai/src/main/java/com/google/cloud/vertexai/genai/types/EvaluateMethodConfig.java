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
import com.google.genai.types.HttpOptions;
import java.util.Optional;

/** Optional parameters for the evaluate method. */
@AutoValue
@JsonDeserialize(builder = EvaluateMethodConfig.Builder.class)
public abstract class EvaluateMethodConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The schema to use for the dataset. If not specified, the dataset schema will be inferred from
   * the first example in the dataset.
   */
  @JsonProperty("datasetSchema")
  public abstract Optional<DatasetSchema> datasetSchema();

  /** The destination path for the evaluation results. */
  @JsonProperty("dest")
  public abstract Optional<String> dest();

  /** Instantiates a builder for EvaluateMethodConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluateMethodConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluateMethodConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluateMethodConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluateMethodConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for datasetSchema.
     *
     * <p>datasetSchema: The schema to use for the dataset. If not specified, the dataset schema
     * will be inferred from the first example in the dataset.
     */
    @JsonProperty("datasetSchema")
    public abstract Builder datasetSchema(DatasetSchema datasetSchema);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasetSchema(Optional<DatasetSchema> datasetSchema);

    /** Clears the value of datasetSchema field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasetSchema() {
      return datasetSchema(Optional.empty());
    }

    /**
     * Setter for datasetSchema given a known enum.
     *
     * <p>datasetSchema: The schema to use for the dataset. If not specified, the dataset schema
     * will be inferred from the first example in the dataset.
     */
    @CanIgnoreReturnValue
    public Builder datasetSchema(DatasetSchema.Known knownType) {
      return datasetSchema(new DatasetSchema(knownType));
    }

    /**
     * Setter for datasetSchema given a string.
     *
     * <p>datasetSchema: The schema to use for the dataset. If not specified, the dataset schema
     * will be inferred from the first example in the dataset.
     */
    @CanIgnoreReturnValue
    public Builder datasetSchema(String datasetSchema) {
      return datasetSchema(new DatasetSchema(datasetSchema));
    }

    /**
     * Setter for dest.
     *
     * <p>dest: The destination path for the evaluation results.
     */
    @JsonProperty("dest")
    public abstract Builder dest(String dest);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dest(Optional<String> dest);

    /** Clears the value of dest field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDest() {
      return dest(Optional.empty());
    }

    public abstract EvaluateMethodConfig build();
  }

  /** Deserializes a JSON string to a EvaluateMethodConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluateMethodConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluateMethodConfig.class);
  }
}
