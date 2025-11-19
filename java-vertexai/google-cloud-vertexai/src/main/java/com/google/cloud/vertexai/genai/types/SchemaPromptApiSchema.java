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

/** The A2 schema of a prompt. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptApiSchema.Builder.class)
public abstract class SchemaPromptApiSchema extends JsonSerializable {
  /** The Schema version that represents changes to the API behavior. */
  @JsonProperty("apiSchemaVersion")
  public abstract Optional<String> apiSchemaVersion();

  /** A list of execution instances for constructing a ready-to-use prompt. */
  @JsonProperty("executions")
  public abstract Optional<List<SchemaPromptInstancePromptExecution>> executions();

  /** Multimodal prompt which embeds preambles to prompt string. */
  @JsonProperty("multimodalPrompt")
  public abstract Optional<SchemaPromptSpecMultimodalPrompt> multimodalPrompt();

  /** The prompt variation that stores preambles in separate fields. */
  @JsonProperty("structuredPrompt")
  public abstract Optional<SchemaPromptSpecStructuredPrompt> structuredPrompt();

  /** The prompt variation for Translation use case. */
  @JsonProperty("translationPrompt")
  public abstract Optional<SchemaPromptSpecTranslationPrompt> translationPrompt();

  /** Instantiates a builder for SchemaPromptApiSchema. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptApiSchema.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptApiSchema. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SchemaPromptApiSchema.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptApiSchema.Builder();
    }

    /**
     * Setter for apiSchemaVersion.
     *
     * <p>apiSchemaVersion: The Schema version that represents changes to the API behavior.
     */
    @JsonProperty("apiSchemaVersion")
    public abstract Builder apiSchemaVersion(String apiSchemaVersion);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder apiSchemaVersion(Optional<String> apiSchemaVersion);

    /** Clears the value of apiSchemaVersion field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApiSchemaVersion() {
      return apiSchemaVersion(Optional.empty());
    }

    /**
     * Setter for executions.
     *
     * <p>executions: A list of execution instances for constructing a ready-to-use prompt.
     */
    @JsonProperty("executions")
    public abstract Builder executions(List<SchemaPromptInstancePromptExecution> executions);

    /**
     * Setter for executions.
     *
     * <p>executions: A list of execution instances for constructing a ready-to-use prompt.
     */
    @CanIgnoreReturnValue
    public Builder executions(SchemaPromptInstancePromptExecution... executions) {
      return executions(Arrays.asList(executions));
    }

    /**
     * Setter for executions builder.
     *
     * <p>executions: A list of execution instances for constructing a ready-to-use prompt.
     */
    @CanIgnoreReturnValue
    public Builder executions(SchemaPromptInstancePromptExecution.Builder... executionsBuilders) {
      return executions(
          Arrays.asList(executionsBuilders).stream()
              .map(SchemaPromptInstancePromptExecution.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder executions(Optional<List<SchemaPromptInstancePromptExecution>> executions);

    /** Clears the value of executions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExecutions() {
      return executions(Optional.empty());
    }

    /**
     * Setter for multimodalPrompt.
     *
     * <p>multimodalPrompt: Multimodal prompt which embeds preambles to prompt string.
     */
    @JsonProperty("multimodalPrompt")
    public abstract Builder multimodalPrompt(SchemaPromptSpecMultimodalPrompt multimodalPrompt);

    /**
     * Setter for multimodalPrompt builder.
     *
     * <p>multimodalPrompt: Multimodal prompt which embeds preambles to prompt string.
     */
    @CanIgnoreReturnValue
    public Builder multimodalPrompt(
        SchemaPromptSpecMultimodalPrompt.Builder multimodalPromptBuilder) {
      return multimodalPrompt(multimodalPromptBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder multimodalPrompt(Optional<SchemaPromptSpecMultimodalPrompt> multimodalPrompt);

    /** Clears the value of multimodalPrompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMultimodalPrompt() {
      return multimodalPrompt(Optional.empty());
    }

    /**
     * Setter for structuredPrompt.
     *
     * <p>structuredPrompt: The prompt variation that stores preambles in separate fields.
     */
    @JsonProperty("structuredPrompt")
    public abstract Builder structuredPrompt(SchemaPromptSpecStructuredPrompt structuredPrompt);

    /**
     * Setter for structuredPrompt builder.
     *
     * <p>structuredPrompt: The prompt variation that stores preambles in separate fields.
     */
    @CanIgnoreReturnValue
    public Builder structuredPrompt(
        SchemaPromptSpecStructuredPrompt.Builder structuredPromptBuilder) {
      return structuredPrompt(structuredPromptBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder structuredPrompt(Optional<SchemaPromptSpecStructuredPrompt> structuredPrompt);

    /** Clears the value of structuredPrompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStructuredPrompt() {
      return structuredPrompt(Optional.empty());
    }

    /**
     * Setter for translationPrompt.
     *
     * <p>translationPrompt: The prompt variation for Translation use case.
     */
    @JsonProperty("translationPrompt")
    public abstract Builder translationPrompt(SchemaPromptSpecTranslationPrompt translationPrompt);

    /**
     * Setter for translationPrompt builder.
     *
     * <p>translationPrompt: The prompt variation for Translation use case.
     */
    @CanIgnoreReturnValue
    public Builder translationPrompt(
        SchemaPromptSpecTranslationPrompt.Builder translationPromptBuilder) {
      return translationPrompt(translationPromptBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder translationPrompt(
        Optional<SchemaPromptSpecTranslationPrompt> translationPrompt);

    /** Clears the value of translationPrompt field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTranslationPrompt() {
      return translationPrompt(Optional.empty());
    }

    public abstract SchemaPromptApiSchema build();
  }

  /** Deserializes a JSON string to a SchemaPromptApiSchema object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptApiSchema fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptApiSchema.class);
  }
}
