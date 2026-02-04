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

/**
 * A SavedQuery is a view of the dataset. It references a subset of annotations by problem type and
 * filters.
 */
@AutoValue
@JsonDeserialize(builder = SavedQuery.Builder.class)
public abstract class SavedQuery extends JsonSerializable {
  /** Output only. Filters on the Annotations in the dataset. */
  @JsonProperty("annotationFilter")
  public abstract Optional<String> annotationFilter();

  /** Output only. Number of AnnotationSpecs in the context of the SavedQuery. */
  @JsonProperty("annotationSpecCount")
  public abstract Optional<Integer> annotationSpecCount();

  /** Output only. Timestamp when this SavedQuery was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /**
   * Required. The user-defined name of the SavedQuery. The name can be up to 128 characters long
   * and can consist of any UTF-8 characters.
   */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /**
   * Used to perform a consistent read-modify-write update. If not set, a blind "overwrite" update
   * happens.
   */
  @JsonProperty("etag")
  public abstract Optional<String> etag();

  /** Some additional information about the SavedQuery. */
  @JsonProperty("metadata")
  public abstract Optional<Object> metadata();

  /** Output only. Resource name of the SavedQuery. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * Required. Problem type of the SavedQuery. Allowed values: * IMAGE_CLASSIFICATION_SINGLE_LABEL *
   * IMAGE_CLASSIFICATION_MULTI_LABEL * IMAGE_BOUNDING_POLY * IMAGE_BOUNDING_BOX *
   * TEXT_CLASSIFICATION_SINGLE_LABEL * TEXT_CLASSIFICATION_MULTI_LABEL * TEXT_EXTRACTION *
   * TEXT_SENTIMENT * VIDEO_CLASSIFICATION * VIDEO_OBJECT_TRACKING
   */
  @JsonProperty("problemType")
  public abstract Optional<String> problemType();

  /**
   * Output only. If the Annotations belonging to the SavedQuery can be used for AutoML training.
   */
  @JsonProperty("supportAutomlTraining")
  public abstract Optional<Boolean> supportAutomlTraining();

  /** Output only. Timestamp when SavedQuery was last updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Instantiates a builder for SavedQuery. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SavedQuery.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SavedQuery. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SavedQuery.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SavedQuery.Builder();
    }

    /**
     * Setter for annotationFilter.
     *
     * <p>annotationFilter: Output only. Filters on the Annotations in the dataset.
     */
    @JsonProperty("annotationFilter")
    public abstract Builder annotationFilter(String annotationFilter);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder annotationFilter(Optional<String> annotationFilter);

    /** Clears the value of annotationFilter field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAnnotationFilter() {
      return annotationFilter(Optional.empty());
    }

    /**
     * Setter for annotationSpecCount.
     *
     * <p>annotationSpecCount: Output only. Number of AnnotationSpecs in the context of the
     * SavedQuery.
     */
    @JsonProperty("annotationSpecCount")
    public abstract Builder annotationSpecCount(Integer annotationSpecCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder annotationSpecCount(Optional<Integer> annotationSpecCount);

    /** Clears the value of annotationSpecCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAnnotationSpecCount() {
      return annotationSpecCount(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this SavedQuery was created.
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
     * <p>displayName: Required. The user-defined name of the SavedQuery. The name can be up to 128
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
     * <p>etag: Used to perform a consistent read-modify-write update. If not set, a blind
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
     * Setter for metadata.
     *
     * <p>metadata: Some additional information about the SavedQuery.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Object metadata);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Object> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for name.
     *
     * <p>name: Output only. Resource name of the SavedQuery.
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
     * Setter for problemType.
     *
     * <p>problemType: Required. Problem type of the SavedQuery. Allowed values: *
     * IMAGE_CLASSIFICATION_SINGLE_LABEL * IMAGE_CLASSIFICATION_MULTI_LABEL * IMAGE_BOUNDING_POLY *
     * IMAGE_BOUNDING_BOX * TEXT_CLASSIFICATION_SINGLE_LABEL * TEXT_CLASSIFICATION_MULTI_LABEL *
     * TEXT_EXTRACTION * TEXT_SENTIMENT * VIDEO_CLASSIFICATION * VIDEO_OBJECT_TRACKING
     */
    @JsonProperty("problemType")
    public abstract Builder problemType(String problemType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder problemType(Optional<String> problemType);

    /** Clears the value of problemType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearProblemType() {
      return problemType(Optional.empty());
    }

    /**
     * Setter for supportAutomlTraining.
     *
     * <p>supportAutomlTraining: Output only. If the Annotations belonging to the SavedQuery can be
     * used for AutoML training.
     */
    @JsonProperty("supportAutomlTraining")
    public abstract Builder supportAutomlTraining(boolean supportAutomlTraining);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder supportAutomlTraining(Optional<Boolean> supportAutomlTraining);

    /** Clears the value of supportAutomlTraining field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSupportAutomlTraining() {
      return supportAutomlTraining(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when SavedQuery was last updated.
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

    public abstract SavedQuery build();
  }

  /** Deserializes a JSON string to a SavedQuery object. */
  @ExcludeFromGeneratedCoverageReport
  public static SavedQuery fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SavedQuery.class);
  }
}
