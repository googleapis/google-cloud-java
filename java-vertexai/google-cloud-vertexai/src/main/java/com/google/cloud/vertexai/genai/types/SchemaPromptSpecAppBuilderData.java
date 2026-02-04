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

/** Defines data for an application builder. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecAppBuilderData.Builder.class)
public abstract class SchemaPromptSpecAppBuilderData extends JsonSerializable {
  /**
   * Serialized state of the code repository. This string will typically contain a JSON
   * representation of the UI's CodeRepositoryService state (files, folders, content, and any
   * metadata). The UI is responsible for serialization and deserialization.
   */
  @JsonProperty("codeRepositoryState")
  public abstract Optional<String> codeRepositoryState();

  /** Optional. Framework used to build the application. */
  @JsonProperty("framework")
  public abstract Optional<Framework> framework();

  /** Linked resources attached to the application by the user. */
  @JsonProperty("linkedResources")
  public abstract Optional<List<SchemaPromptSpecAppBuilderDataLinkedResource>> linkedResources();

  /** Instantiates a builder for SchemaPromptSpecAppBuilderData. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecAppBuilderData.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecAppBuilderData. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecAppBuilderData.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecAppBuilderData.Builder();
    }

    /**
     * Setter for codeRepositoryState.
     *
     * <p>codeRepositoryState: Serialized state of the code repository. This string will typically
     * contain a JSON representation of the UI's CodeRepositoryService state (files, folders,
     * content, and any metadata). The UI is responsible for serialization and deserialization.
     */
    @JsonProperty("codeRepositoryState")
    public abstract Builder codeRepositoryState(String codeRepositoryState);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder codeRepositoryState(Optional<String> codeRepositoryState);

    /** Clears the value of codeRepositoryState field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCodeRepositoryState() {
      return codeRepositoryState(Optional.empty());
    }

    /**
     * Setter for framework.
     *
     * <p>framework: Optional. Framework used to build the application.
     */
    @JsonProperty("framework")
    public abstract Builder framework(Framework framework);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder framework(Optional<Framework> framework);

    /** Clears the value of framework field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFramework() {
      return framework(Optional.empty());
    }

    /**
     * Setter for framework given a known enum.
     *
     * <p>framework: Optional. Framework used to build the application.
     */
    @CanIgnoreReturnValue
    public Builder framework(Framework.Known knownType) {
      return framework(new Framework(knownType));
    }

    /**
     * Setter for framework given a string.
     *
     * <p>framework: Optional. Framework used to build the application.
     */
    @CanIgnoreReturnValue
    public Builder framework(String framework) {
      return framework(new Framework(framework));
    }

    /**
     * Setter for linkedResources.
     *
     * <p>linkedResources: Linked resources attached to the application by the user.
     */
    @JsonProperty("linkedResources")
    public abstract Builder linkedResources(
        List<SchemaPromptSpecAppBuilderDataLinkedResource> linkedResources);

    /**
     * Setter for linkedResources.
     *
     * <p>linkedResources: Linked resources attached to the application by the user.
     */
    @CanIgnoreReturnValue
    public Builder linkedResources(
        SchemaPromptSpecAppBuilderDataLinkedResource... linkedResources) {
      return linkedResources(Arrays.asList(linkedResources));
    }

    /**
     * Setter for linkedResources builder.
     *
     * <p>linkedResources: Linked resources attached to the application by the user.
     */
    @CanIgnoreReturnValue
    public Builder linkedResources(
        SchemaPromptSpecAppBuilderDataLinkedResource.Builder... linkedResourcesBuilders) {
      return linkedResources(
          Arrays.asList(linkedResourcesBuilders).stream()
              .map(SchemaPromptSpecAppBuilderDataLinkedResource.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder linkedResources(
        Optional<List<SchemaPromptSpecAppBuilderDataLinkedResource>> linkedResources);

    /** Clears the value of linkedResources field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLinkedResources() {
      return linkedResources(Optional.empty());
    }

    public abstract SchemaPromptSpecAppBuilderData build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecAppBuilderData object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecAppBuilderData fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecAppBuilderData.class);
  }
}
