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

/** Represents the BigQuery source for multimodal dataset metadata. */
@AutoValue
@JsonDeserialize(builder = SchemaTablesDatasetMetadataBigQuerySource.Builder.class)
public abstract class SchemaTablesDatasetMetadataBigQuerySource extends JsonSerializable {
  /**
   * The URI of the BigQuery table. This accepts the table name with or without the bq:// prefix.
   */
  @JsonProperty("uri")
  public abstract Optional<String> uri();

  /** Instantiates a builder for SchemaTablesDatasetMetadataBigQuerySource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaTablesDatasetMetadataBigQuerySource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaTablesDatasetMetadataBigQuerySource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaTablesDatasetMetadataBigQuerySource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaTablesDatasetMetadataBigQuerySource.Builder();
    }

    /**
     * Setter for uri.
     *
     * <p>uri: The URI of the BigQuery table. This accepts the table name with or without the bq://
     * prefix.
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

    public abstract SchemaTablesDatasetMetadataBigQuerySource build();
  }

  /** Deserializes a JSON string to a SchemaTablesDatasetMetadataBigQuerySource object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaTablesDatasetMetadataBigQuerySource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaTablesDatasetMetadataBigQuerySource.class);
  }
}
