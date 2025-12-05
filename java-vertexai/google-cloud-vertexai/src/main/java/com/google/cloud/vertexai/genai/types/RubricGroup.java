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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** A group of rubrics, used for grouping rubrics based on a metric or a version. */
@AutoValue
@JsonDeserialize(builder = RubricGroup.Builder.class)
public abstract class RubricGroup extends JsonSerializable {
  /** Unique identifier for the group. */
  @JsonProperty("groupId")
  public abstract Optional<String> groupId();

  /**
   * Human-readable name for the group. This should be unique within a given context if used for
   * display or selection. Example: "Instruction Following V1", "Content Quality - Summarization
   * Task".
   */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Rubrics that are part of this group. */
  @JsonProperty("rubrics")
  public abstract Optional<List<Rubric>> rubrics();

  /** Instantiates a builder for RubricGroup. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricGroup.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricGroup. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricGroup.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricGroup.Builder();
    }

    /**
     * Setter for groupId.
     *
     * <p>groupId: Unique identifier for the group.
     */
    @JsonProperty("groupId")
    public abstract Builder groupId(String groupId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder groupId(Optional<String> groupId);

    /** Clears the value of groupId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGroupId() {
      return groupId(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: Human-readable name for the group. This should be unique within a given
     * context if used for display or selection. Example: "Instruction Following V1", "Content
     * Quality - Summarization Task".
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
     * Setter for rubrics.
     *
     * <p>rubrics: Rubrics that are part of this group.
     */
    @JsonProperty("rubrics")
    public abstract Builder rubrics(List<Rubric> rubrics);

    /**
     * Setter for rubrics.
     *
     * <p>rubrics: Rubrics that are part of this group.
     */
    @CanIgnoreReturnValue
    public Builder rubrics(Rubric... rubrics) {
      return rubrics(Arrays.asList(rubrics));
    }

    /**
     * Setter for rubrics builder.
     *
     * <p>rubrics: Rubrics that are part of this group.
     */
    @CanIgnoreReturnValue
    public Builder rubrics(Rubric.Builder... rubricsBuilders) {
      return rubrics(
          Arrays.asList(rubricsBuilders).stream()
              .map(Rubric.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder rubrics(Optional<List<Rubric>> rubrics);

    /** Clears the value of rubrics field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRubrics() {
      return rubrics(Optional.empty());
    }

    public abstract RubricGroup build();
  }

  /** Deserializes a JSON string to a RubricGroup object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricGroup fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricGroup.class);
  }
}
