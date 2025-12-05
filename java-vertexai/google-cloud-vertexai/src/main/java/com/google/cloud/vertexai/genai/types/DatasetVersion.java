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
import java.util.Optional;

/** Represents a dataset version resource to store prompts. */
@AutoValue
@JsonDeserialize(builder = DatasetVersion.Builder.class)
public abstract class DatasetVersion extends JsonSerializable {
  /** Required. Output only. Additional information about the DatasetVersion. */
  @JsonProperty("metadata")
  public abstract Optional<SchemaTextPromptDatasetMetadata> metadata();

  /** Output only. Name of the associated BigQuery dataset. */
  @JsonProperty("bigQueryDatasetName")
  public abstract Optional<String> bigQueryDatasetName();

  /** Output only. Timestamp when this DatasetVersion was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /**
   * The user-defined name of the DatasetVersion. The name can be up to 128 characters long and can
   * consist of any UTF-8 characters.
   */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /**
   * Used to perform consistent read-modify-write updates. If not set, a blind "overwrite" update
   * happens.
   */
  @JsonProperty("etag")
  public abstract Optional<String> etag();

  /**
   * Output only. Reference to the public base model last used by the dataset version. Only set for
   * prompt dataset versions.
   */
  @JsonProperty("modelReference")
  public abstract Optional<String> modelReference();

  /**
   * Output only. Identifier. The resource name of the DatasetVersion. Format:
   * `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzi")
  public abstract Optional<Boolean> satisfiesPzi();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzs")
  public abstract Optional<Boolean> satisfiesPzs();

  /** Output only. Timestamp when this DatasetVersion was last updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Instantiates a builder for DatasetVersion. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_DatasetVersion.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for DatasetVersion. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `DatasetVersion.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_DatasetVersion.Builder();
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Required. Output only. Additional information about the DatasetVersion.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(SchemaTextPromptDatasetMetadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata: Required. Output only. Additional information about the DatasetVersion.
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
     * Setter for bigQueryDatasetName.
     *
     * <p>bigQueryDatasetName: Output only. Name of the associated BigQuery dataset.
     */
    @JsonProperty("bigQueryDatasetName")
    public abstract Builder bigQueryDatasetName(String bigQueryDatasetName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bigQueryDatasetName(Optional<String> bigQueryDatasetName);

    /** Clears the value of bigQueryDatasetName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBigQueryDatasetName() {
      return bigQueryDatasetName(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this DatasetVersion was created.
     */
    @JsonProperty("createTime")
    public abstract Builder createTime(Instant createTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder createTime(Optional<Instant> createTime);

    /** Clears the value of createTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreateTime() {
      return createTime(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: The user-defined name of the DatasetVersion. The name can be up to 128
     * characters long and can consist of any UTF-8 characters.
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
     * Setter for etag.
     *
     * <p>etag: Used to perform consistent read-modify-write updates. If not set, a blind
     * "overwrite" update happens.
     */
    @JsonProperty("etag")
    public abstract Builder etag(String etag);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder etag(Optional<String> etag);

    /** Clears the value of etag field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEtag() {
      return etag(Optional.empty());
    }

    /**
     * Setter for modelReference.
     *
     * <p>modelReference: Output only. Reference to the public base model last used by the dataset
     * version. Only set for prompt dataset versions.
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
     * Setter for name.
     *
     * <p>name: Output only. Identifier. The resource name of the DatasetVersion. Format:
     * `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`
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
     * Setter for satisfiesPzi.
     *
     * <p>satisfiesPzi: Output only. Reserved for future use.
     */
    @JsonProperty("satisfiesPzi")
    public abstract Builder satisfiesPzi(boolean satisfiesPzi);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder satisfiesPzi(Optional<Boolean> satisfiesPzi);

    /** Clears the value of satisfiesPzi field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSatisfiesPzi() {
      return satisfiesPzi(Optional.empty());
    }

    /**
     * Setter for satisfiesPzs.
     *
     * <p>satisfiesPzs: Output only. Reserved for future use.
     */
    @JsonProperty("satisfiesPzs")
    public abstract Builder satisfiesPzs(boolean satisfiesPzs);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder satisfiesPzs(Optional<Boolean> satisfiesPzs);

    /** Clears the value of satisfiesPzs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSatisfiesPzs() {
      return satisfiesPzs(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when this DatasetVersion was last updated.
     */
    @JsonProperty("updateTime")
    public abstract Builder updateTime(Instant updateTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder updateTime(Optional<Instant> updateTime);

    /** Clears the value of updateTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUpdateTime() {
      return updateTime(Optional.empty());
    }

    public abstract DatasetVersion build();
  }

  /** Deserializes a JSON string to a DatasetVersion object. */
  @ExcludeFromGeneratedCoverageReport
  public static DatasetVersion fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, DatasetVersion.class);
  }
}
