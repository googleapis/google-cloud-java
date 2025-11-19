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

/** The BigQuery location for the input content. */
@AutoValue
@JsonDeserialize(builder = BigQuerySource.Builder.class)
public abstract class BigQuerySource extends JsonSerializable {
  /**
   * Required. BigQuery URI to a table, up to 2000 characters long. Accepted forms: * BigQuery path.
   * For example: `bq://projectId.bqDatasetId.bqTableId`.
   */
  @JsonProperty("inputUri")
  public abstract Optional<String> inputUri();

  /** Instantiates a builder for BigQuerySource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_BigQuerySource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for BigQuerySource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `BigQuerySource.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_BigQuerySource.Builder();
    }

    /**
     * Setter for inputUri.
     *
     * <p>inputUri: Required. BigQuery URI to a table, up to 2000 characters long. Accepted forms: *
     * BigQuery path. For example: `bq://projectId.bqDatasetId.bqTableId`.
     */
    @JsonProperty("inputUri")
    public abstract Builder inputUri(String inputUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inputUri(Optional<String> inputUri);

    /** Clears the value of inputUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInputUri() {
      return inputUri(Optional.empty());
    }

    public abstract BigQuerySource build();
  }

  /** Deserializes a JSON string to a BigQuerySource object. */
  @ExcludeFromGeneratedCoverageReport
  public static BigQuerySource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, BigQuerySource.class);
  }
}
