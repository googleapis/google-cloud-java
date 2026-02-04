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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Represents the create dataset version parameters. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = CreateDatasetVersionParameters.Builder.class)
public abstract class CreateDatasetVersionParameters extends JsonSerializable {
  /** */
  @JsonProperty("datasetName")
  public abstract Optional<String> datasetName();

  /** */
  @JsonProperty("metadata")
  public abstract Optional<SchemaTextPromptDatasetMetadata> metadata();

  /** */
  @JsonProperty("modelReference")
  public abstract Optional<String> modelReference();

  /** */
  @JsonProperty("parent")
  public abstract Optional<String> parent();

  /** */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** */
  @JsonProperty("config")
  public abstract Optional<CreateDatasetVersionConfig> config();

  /** Instantiates a builder for CreateDatasetVersionParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreateDatasetVersionParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreateDatasetVersionParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `CreateDatasetVersionParameters.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreateDatasetVersionParameters.Builder();
    }

    /**
     * Setter for datasetName.
     *
     * <p>datasetName:
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
     * Setter for metadata.
     *
     * <p>metadata:
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(SchemaTextPromptDatasetMetadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata:
     */
    @CanIgnoreReturnValue
    public Builder metadata(SchemaTextPromptDatasetMetadata.Builder metadataBuilder) {
      return metadata(metadataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<SchemaTextPromptDatasetMetadata> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for modelReference.
     *
     * <p>modelReference:
     */
    @JsonProperty("modelReference")
    public abstract Builder modelReference(String modelReference);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder modelReference(Optional<String> modelReference);

    /** Clears the value of modelReference field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearModelReference() {
      return modelReference(Optional.empty());
    }

    /**
     * Setter for parent.
     *
     * <p>parent:
     */
    @JsonProperty("parent")
    public abstract Builder parent(String parent);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder parent(Optional<String> parent);

    /** Clears the value of parent field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearParent() {
      return parent(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName:
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(CreateDatasetVersionConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(CreateDatasetVersionConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<CreateDatasetVersionConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract CreateDatasetVersionParameters build();
  }

  /** Deserializes a JSON string to a CreateDatasetVersionParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreateDatasetVersionParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreateDatasetVersionParameters.class);
  }
}
