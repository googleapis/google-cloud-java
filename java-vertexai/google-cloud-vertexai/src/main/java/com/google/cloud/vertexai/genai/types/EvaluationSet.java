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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Represents an evaluation set. */
@AutoValue
@JsonDeserialize(builder = EvaluationSet.Builder.class)
public abstract class EvaluationSet extends JsonSerializable {
  /** The resource name of the evaluation set. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The display name of the evaluation set. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** The EvaluationItems that are part of this dataset. */
  @JsonProperty("evaluationItems")
  public abstract Optional<List<String>> evaluationItems();

  /** The create time of the evaluation set. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** The update time of the evaluation set. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** The metadata of the evaluation set. */
  @JsonProperty("metadata")
  public abstract Optional<Map<String, Object>> metadata();

  /** Instantiates a builder for EvaluationSet. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationSet.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationSet. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationSet.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationSet.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: The resource name of the evaluation set.
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
     * <p>displayName: The display name of the evaluation set.
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
     * Setter for evaluationItems.
     *
     * <p>evaluationItems: The EvaluationItems that are part of this dataset.
     */
    @JsonProperty("evaluationItems")
    public abstract Builder evaluationItems(List<String> evaluationItems);

    /**
     * Setter for evaluationItems.
     *
     * <p>evaluationItems: The EvaluationItems that are part of this dataset.
     */
    @CanIgnoreReturnValue
    public Builder evaluationItems(String... evaluationItems) {
      return evaluationItems(Arrays.asList(evaluationItems));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationItems(Optional<List<String>> evaluationItems);

    /** Clears the value of evaluationItems field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationItems() {
      return evaluationItems(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: The create time of the evaluation set.
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
     * Setter for updateTime.
     *
     * <p>updateTime: The update time of the evaluation set.
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

    /**
     * Setter for metadata.
     *
     * <p>metadata: The metadata of the evaluation set.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Map<String, Object> metadata);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Map<String, Object>> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    public abstract EvaluationSet build();
  }

  /** Deserializes a JSON string to a EvaluationSet object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationSet fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationSet.class);
  }
}
