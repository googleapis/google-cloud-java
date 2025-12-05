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

/** Represents a multimodal dataset. */
@AutoValue
@JsonDeserialize(builder = MultimodalDataset.Builder.class)
public abstract class MultimodalDataset extends JsonSerializable {
  /** The ID of the multimodal dataset. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The display name of the multimodal dataset. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The metadata of the multimodal dataset. */
  @JsonProperty("metadata")
  public abstract Optional<SchemaTablesDatasetMetadata> metadata();

  /** The description of the multimodal dataset. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Instantiates a builder for MultimodalDataset. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MultimodalDataset.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MultimodalDataset. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MultimodalDataset.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MultimodalDataset.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: The ID of the multimodal dataset.
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
     * <p>displayName: The display name of the multimodal dataset.
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
     * Setter for metadata.
     *
     * <p>metadata: The metadata of the multimodal dataset.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(SchemaTablesDatasetMetadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata: The metadata of the multimodal dataset.
     */
    @CanIgnoreReturnValue
    public Builder metadata(SchemaTablesDatasetMetadata.Builder metadataBuilder) {
      return metadata(metadataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<SchemaTablesDatasetMetadata> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: The description of the multimodal dataset.
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

    public abstract MultimodalDataset build();
  }

  /** Deserializes a JSON string to a MultimodalDataset object. */
  @ExcludeFromGeneratedCoverageReport
  public static MultimodalDataset fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MultimodalDataset.class);
  }
}
