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

/** Represents the input config for multimodal dataset metadata. */
@AutoValue
@JsonDeserialize(builder = SchemaTablesDatasetMetadataInputConfig.Builder.class)
public abstract class SchemaTablesDatasetMetadataInputConfig extends JsonSerializable {
  /** The BigQuery source for multimodal dataset metadata. */
  @JsonProperty("bigquerySource")
  public abstract Optional<SchemaTablesDatasetMetadataBigQuerySource> bigquerySource();

  /** Instantiates a builder for SchemaTablesDatasetMetadataInputConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaTablesDatasetMetadataInputConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaTablesDatasetMetadataInputConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaTablesDatasetMetadataInputConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaTablesDatasetMetadataInputConfig.Builder();
    }

    /**
     * Setter for bigquerySource.
     *
     * <p>bigquerySource: The BigQuery source for multimodal dataset metadata.
     */
    @JsonProperty("bigquerySource")
    public abstract Builder bigquerySource(
        SchemaTablesDatasetMetadataBigQuerySource bigquerySource);

    /**
     * Setter for bigquerySource builder.
     *
     * <p>bigquerySource: The BigQuery source for multimodal dataset metadata.
     */
    @CanIgnoreReturnValue
    public Builder bigquerySource(
        SchemaTablesDatasetMetadataBigQuerySource.Builder bigquerySourceBuilder) {
      return bigquerySource(bigquerySourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bigquerySource(
        Optional<SchemaTablesDatasetMetadataBigQuerySource> bigquerySource);

    /** Clears the value of bigquerySource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBigquerySource() {
      return bigquerySource(Optional.empty());
    }

    public abstract SchemaTablesDatasetMetadataInputConfig build();
  }

  /** Deserializes a JSON string to a SchemaTablesDatasetMetadataInputConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaTablesDatasetMetadataInputConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaTablesDatasetMetadataInputConfig.class);
  }
}
