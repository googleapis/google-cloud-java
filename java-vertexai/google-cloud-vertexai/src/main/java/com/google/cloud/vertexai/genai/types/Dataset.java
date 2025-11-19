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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.EncryptionSpec;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents a dataset resource to store prompts. */
@AutoValue
@JsonDeserialize(builder = Dataset.Builder.class)
public abstract class Dataset extends JsonSerializable {
  /** Required. Additional information about the Dataset. */
  @JsonProperty("metadata")
  public abstract Optional<SchemaTextPromptDatasetMetadata> metadata();

  /**
   * Customer-managed encryption key spec for a Dataset. If set, this Dataset and all sub-resources
   * of this Dataset will be secured by this key.
   */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** Output only. Timestamp when this Dataset was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /**
   * Output only. The number of DataItems in this Dataset. Only apply for non-structured Dataset.
   */
  @JsonProperty("dataItemCount")
  public abstract Optional<Long> dataItemCount();

  /** The description of the Dataset. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /**
   * Required. The user-defined name of the Dataset. The name can be up to 128 characters long and
   * can consist of any UTF-8 characters.
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
   * The labels with user-defined metadata to organize your Datasets. Label keys and values can be
   * no longer than 64 characters (Unicode codepoints), can only contain lowercase letters, numeric
   * characters, underscores and dashes. International characters are allowed. No more than 64 user
   * labels can be associated with one Dataset (System labels are excluded). See
   * https://goo.gl/xmQnxf for more information and examples of labels. System reserved label keys
   * are prefixed with "aiplatform.googleapis.com/" and are immutable. Following system labels exist
   * for each Dataset: * "aiplatform.googleapis.com/dataset_metadata_schema": output only, its value
   * is the metadata_schema's title.
   */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /**
   * Output only. The resource name of the Artifact that was created in MetadataStore when creating
   * the Dataset. The Artifact resource name pattern is
   * `projects/{project}/locations/{location}/metadataStores/{metadata_store}/artifacts/{artifact}`.
   */
  @JsonProperty("metadataArtifact")
  public abstract Optional<String> metadataArtifact();

  /**
   * Required. Points to a YAML file stored on Google Cloud Storage describing additional
   * information about the Dataset. The schema is defined as an OpenAPI 3.0.2 Schema Object. The
   * schema files that can be used here are found in
   * gs://google-cloud-aiplatform/schema/dataset/metadata/.
   */
  @JsonProperty("metadataSchemaUri")
  public abstract Optional<String> metadataSchemaUri();

  /**
   * Optional. Reference to the public base model last used by the dataset. Only set for prompt
   * datasets.
   */
  @JsonProperty("modelReference")
  public abstract Optional<String> modelReference();

  /**
   * Output only. Identifier. The resource name of the Dataset. Format:
   * `projects/{project}/locations/{location}/datasets/{dataset}`
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzi")
  public abstract Optional<Boolean> satisfiesPzi();

  /** Output only. Reserved for future use. */
  @JsonProperty("satisfiesPzs")
  public abstract Optional<Boolean> satisfiesPzs();

  /**
   * All SavedQueries belong to the Dataset will be returned in List/Get Dataset response. The
   * annotation_specs field will not be populated except for UI cases which will only use
   * annotation_spec_count. In CreateDataset request, a SavedQuery is created together if this field
   * is set, up to one SavedQuery can be set in CreateDatasetRequest. The SavedQuery should not
   * contain any AnnotationSpec.
   */
  @JsonProperty("savedQueries")
  public abstract Optional<List<SavedQuery>> savedQueries();

  /** Output only. Timestamp when this Dataset was last updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Instantiates a builder for Dataset. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Dataset.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Dataset. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Dataset.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Dataset.Builder();
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Required. Additional information about the Dataset.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(SchemaTextPromptDatasetMetadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata: Required. Additional information about the Dataset.
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
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec: Customer-managed encryption key spec for a Dataset. If set, this Dataset
     * and all sub-resources of this Dataset will be secured by this key.
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
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this Dataset was created.
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
     * Setter for dataItemCount.
     *
     * <p>dataItemCount: Output only. The number of DataItems in this Dataset. Only apply for
     * non-structured Dataset.
     */
    @JsonProperty("dataItemCount")
    public abstract Builder dataItemCount(Long dataItemCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dataItemCount(Optional<Long> dataItemCount);

    /** Clears the value of dataItemCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDataItemCount() {
      return dataItemCount(Optional.empty());
    }

    /**
     * Setter for description.
     *
     * <p>description: The description of the Dataset.
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
     * Setter for displayName.
     *
     * <p>displayName: Required. The user-defined name of the Dataset. The name can be up to 128
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
     * Setter for labels.
     *
     * <p>labels: The labels with user-defined metadata to organize your Datasets. Label keys and
     * values can be no longer than 64 characters (Unicode codepoints), can only contain lowercase
     * letters, numeric characters, underscores and dashes. International characters are allowed. No
     * more than 64 user labels can be associated with one Dataset (System labels are excluded). See
     * https://goo.gl/xmQnxf for more information and examples of labels. System reserved label keys
     * are prefixed with "aiplatform.googleapis.com/" and are immutable. Following system labels
     * exist for each Dataset: * "aiplatform.googleapis.com/dataset_metadata_schema": output only,
     * its value is the metadata_schema's title.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for metadataArtifact.
     *
     * <p>metadataArtifact: Output only. The resource name of the Artifact that was created in
     * MetadataStore when creating the Dataset. The Artifact resource name pattern is
     * `projects/{project}/locations/{location}/metadataStores/{metadata_store}/artifacts/{artifact}`.
     */
    @JsonProperty("metadataArtifact")
    public abstract Builder metadataArtifact(String metadataArtifact);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadataArtifact(Optional<String> metadataArtifact);

    /** Clears the value of metadataArtifact field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadataArtifact() {
      return metadataArtifact(Optional.empty());
    }

    /**
     * Setter for metadataSchemaUri.
     *
     * <p>metadataSchemaUri: Required. Points to a YAML file stored on Google Cloud Storage
     * describing additional information about the Dataset. The schema is defined as an OpenAPI
     * 3.0.2 Schema Object. The schema files that can be used here are found in
     * gs://google-cloud-aiplatform/schema/dataset/metadata/.
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
     * Setter for modelReference.
     *
     * <p>modelReference: Optional. Reference to the public base model last used by the dataset.
     * Only set for prompt datasets.
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
     * <p>name: Output only. Identifier. The resource name of the Dataset. Format:
     * `projects/{project}/locations/{location}/datasets/{dataset}`
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
     * Setter for savedQueries.
     *
     * <p>savedQueries: All SavedQueries belong to the Dataset will be returned in List/Get Dataset
     * response. The annotation_specs field will not be populated except for UI cases which will
     * only use annotation_spec_count. In CreateDataset request, a SavedQuery is created together if
     * this field is set, up to one SavedQuery can be set in CreateDatasetRequest. The SavedQuery
     * should not contain any AnnotationSpec.
     */
    @JsonProperty("savedQueries")
    public abstract Builder savedQueries(List<SavedQuery> savedQueries);

    /**
     * Setter for savedQueries.
     *
     * <p>savedQueries: All SavedQueries belong to the Dataset will be returned in List/Get Dataset
     * response. The annotation_specs field will not be populated except for UI cases which will
     * only use annotation_spec_count. In CreateDataset request, a SavedQuery is created together if
     * this field is set, up to one SavedQuery can be set in CreateDatasetRequest. The SavedQuery
     * should not contain any AnnotationSpec.
     */
    @CanIgnoreReturnValue
    public Builder savedQueries(SavedQuery... savedQueries) {
      return savedQueries(Arrays.asList(savedQueries));
    }

    /**
     * Setter for savedQueries builder.
     *
     * <p>savedQueries: All SavedQueries belong to the Dataset will be returned in List/Get Dataset
     * response. The annotation_specs field will not be populated except for UI cases which will
     * only use annotation_spec_count. In CreateDataset request, a SavedQuery is created together if
     * this field is set, up to one SavedQuery can be set in CreateDatasetRequest. The SavedQuery
     * should not contain any AnnotationSpec.
     */
    @CanIgnoreReturnValue
    public Builder savedQueries(SavedQuery.Builder... savedQueriesBuilders) {
      return savedQueries(
          Arrays.asList(savedQueriesBuilders).stream()
              .map(SavedQuery.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder savedQueries(Optional<List<SavedQuery>> savedQueries);

    /** Clears the value of savedQueries field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSavedQueries() {
      return savedQueries(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when this Dataset was last updated.
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

    public abstract Dataset build();
  }

  /** Deserializes a JSON string to a Dataset object. */
  @ExcludeFromGeneratedCoverageReport
  public static Dataset fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Dataset.class);
  }
}
