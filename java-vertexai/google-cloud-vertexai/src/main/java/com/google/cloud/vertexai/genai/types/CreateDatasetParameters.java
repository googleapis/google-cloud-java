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
import com.google.genai.types.EncryptionSpec;
import java.util.Optional;

/** Parameters for creating a dataset resource to store prompts. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = CreateDatasetParameters.Builder.class)
public abstract class CreateDatasetParameters extends JsonSerializable {
  /** */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** */
  @JsonProperty("metadataSchemaUri")
  public abstract Optional<String> metadataSchemaUri();

  /** */
  @JsonProperty("metadata")
  public abstract Optional<SchemaTextPromptDatasetMetadata> metadata();

  /** */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** */
  @JsonProperty("modelReference")
  public abstract Optional<String> modelReference();

  /** */
  @JsonProperty("config")
  public abstract Optional<CreateDatasetConfig> config();

  /** Instantiates a builder for CreateDatasetParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CreateDatasetParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CreateDatasetParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CreateDatasetParameters.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CreateDatasetParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name:
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
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
     * Setter for metadataSchemaUri.
     *
     * <p>metadataSchemaUri:
     */
    @JsonProperty("metadataSchemaUri")
    public abstract Builder metadataSchemaUri(String metadataSchemaUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadataSchemaUri(Optional<String> metadataSchemaUri);

    /** Clears the value of metadataSchemaUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadataSchemaUri() {
      return metadataSchemaUri(Optional.empty());
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
     * Setter for description.
     *
     * <p>description:
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    /**
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec:
     */
    @JsonProperty("encryptionSpec")
    public abstract Builder encryptionSpec(EncryptionSpec encryptionSpec);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder encryptionSpec(Optional<EncryptionSpec> encryptionSpec);

    /** Clears the value of encryptionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEncryptionSpec() {
      return encryptionSpec(Optional.empty());
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
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(CreateDatasetConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(CreateDatasetConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<CreateDatasetConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract CreateDatasetParameters build();
  }

  /** Deserializes a JSON string to a CreateDatasetParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static CreateDatasetParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CreateDatasetParameters.class);
  }
}
