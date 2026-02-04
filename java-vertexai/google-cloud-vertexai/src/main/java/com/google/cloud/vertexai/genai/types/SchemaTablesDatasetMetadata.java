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

/** Represents the metadata schema for multimodal dataset metadata. */
@AutoValue
@JsonDeserialize(builder = SchemaTablesDatasetMetadata.Builder.class)
public abstract class SchemaTablesDatasetMetadata extends JsonSerializable {
  /** The input config for multimodal dataset metadata. */
  @JsonProperty("inputConfig")
  public abstract Optional<SchemaTablesDatasetMetadataInputConfig> inputConfig();

  /** Instantiates a builder for SchemaTablesDatasetMetadata. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaTablesDatasetMetadata.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaTablesDatasetMetadata. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SchemaTablesDatasetMetadata.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaTablesDatasetMetadata.Builder();
    }

    /**
     * Setter for inputConfig.
     *
     * <p>inputConfig: The input config for multimodal dataset metadata.
     */
    @JsonProperty("inputConfig")
    public abstract Builder inputConfig(SchemaTablesDatasetMetadataInputConfig inputConfig);

    /**
     * Setter for inputConfig builder.
     *
     * <p>inputConfig: The input config for multimodal dataset metadata.
     */
    @CanIgnoreReturnValue
    public Builder inputConfig(SchemaTablesDatasetMetadataInputConfig.Builder inputConfigBuilder) {
      return inputConfig(inputConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inputConfig(Optional<SchemaTablesDatasetMetadataInputConfig> inputConfig);

    /** Clears the value of inputConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInputConfig() {
      return inputConfig(Optional.empty());
    }

    public abstract SchemaTablesDatasetMetadata build();
  }

  /** Deserializes a JSON string to a SchemaTablesDatasetMetadata object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaTablesDatasetMetadata fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaTablesDatasetMetadata.class);
  }
}
