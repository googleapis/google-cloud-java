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
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** A memory revision. */
@AutoValue
@JsonDeserialize(builder = MemoryRevision.Builder.class)
public abstract class MemoryRevision extends JsonSerializable {
  /**
   * Identifier. The resource name of the Memory Revision. Format:
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}/revisions/{memory_revision}`
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Output only. Timestamp when this Memory Revision was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Output only. Timestamp of when this resource is considered expired. */
  @JsonProperty("expireTime")
  public abstract Optional<Instant> expireTime();

  /**
   * Output only. The fact of the Memory Revision. This corresponds to the `fact` field of the
   * parent Memory at the time of revision creation.
   */
  @JsonProperty("fact")
  public abstract Optional<String> fact();

  /**
   * Output only. The labels of the Memory Revision. These labels are applied to the MemoryRevision
   * when it is created based on `GenerateMemoriesRequest.revision_labels`.
   */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /**
   * Output only. The extracted memories from the source content before consolidation when the
   * memory was updated via GenerateMemories. This information was used to modify an existing Memory
   * via Consolidation.
   */
  @JsonProperty("extractedMemories")
  public abstract Optional<List<IntermediateExtractedMemory>> extractedMemories();

  /** Instantiates a builder for MemoryRevision. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryRevision.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryRevision. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MemoryRevision.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryRevision.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Identifier. The resource name of the Memory Revision. Format:
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}/revisions/{memory_revision}`
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
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this Memory Revision was created.
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
     * Setter for expireTime.
     *
     * <p>expireTime: Output only. Timestamp of when this resource is considered expired.
     */
    @JsonProperty("expireTime")
    public abstract Builder expireTime(Instant expireTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder expireTime(Optional<Instant> expireTime);

    /** Clears the value of expireTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExpireTime() {
      return expireTime(Optional.empty());
    }

    /**
     * Setter for fact.
     *
     * <p>fact: Output only. The fact of the Memory Revision. This corresponds to the `fact` field
     * of the parent Memory at the time of revision creation.
     */
    @JsonProperty("fact")
    public abstract Builder fact(String fact);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder fact(Optional<String> fact);

    /** Clears the value of fact field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFact() {
      return fact(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: Output only. The labels of the Memory Revision. These labels are applied to the
     * MemoryRevision when it is created based on `GenerateMemoriesRequest.revision_labels`.
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
     * Setter for extractedMemories.
     *
     * <p>extractedMemories: Output only. The extracted memories from the source content before
     * consolidation when the memory was updated via GenerateMemories. This information was used to
     * modify an existing Memory via Consolidation.
     */
    @JsonProperty("extractedMemories")
    public abstract Builder extractedMemories(List<IntermediateExtractedMemory> extractedMemories);

    /**
     * Setter for extractedMemories.
     *
     * <p>extractedMemories: Output only. The extracted memories from the source content before
     * consolidation when the memory was updated via GenerateMemories. This information was used to
     * modify an existing Memory via Consolidation.
     */
    @CanIgnoreReturnValue
    public Builder extractedMemories(IntermediateExtractedMemory... extractedMemories) {
      return extractedMemories(Arrays.asList(extractedMemories));
    }

    /**
     * Setter for extractedMemories builder.
     *
     * <p>extractedMemories: Output only. The extracted memories from the source content before
     * consolidation when the memory was updated via GenerateMemories. This information was used to
     * modify an existing Memory via Consolidation.
     */
    @CanIgnoreReturnValue
    public Builder extractedMemories(
        IntermediateExtractedMemory.Builder... extractedMemoriesBuilders) {
      return extractedMemories(
          Arrays.asList(extractedMemoriesBuilders).stream()
              .map(IntermediateExtractedMemory.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder extractedMemories(
        Optional<List<IntermediateExtractedMemory>> extractedMemories);

    /** Clears the value of extractedMemories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExtractedMemories() {
      return extractedMemories(Optional.empty());
    }

    public abstract MemoryRevision build();
  }

  /** Deserializes a JSON string to a MemoryRevision object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryRevision fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryRevision.class);
  }
}
