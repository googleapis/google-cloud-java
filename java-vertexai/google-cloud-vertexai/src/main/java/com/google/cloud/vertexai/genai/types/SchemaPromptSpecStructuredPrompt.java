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
import com.google.genai.types.Content;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a structured prompt. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecStructuredPrompt.Builder.class)
public abstract class SchemaPromptSpecStructuredPrompt extends JsonSerializable {
  /** Preamble: The context of the prompt. */
  @JsonProperty("context")
  public abstract Optional<Content> context();

  /** Preamble: A set of examples for expected model response. */
  @JsonProperty("examples")
  public abstract Optional<List<SchemaPromptSpecPartList>> examples();

  /** Preamble: For infill prompt, the prefix before expected model response. */
  @JsonProperty("infillPrefix")
  public abstract Optional<String> infillPrefix();

  /** Preamble: For infill prompt, the suffix after expected model response. */
  @JsonProperty("infillSuffix")
  public abstract Optional<String> infillSuffix();

  /** Preamble: The input prefixes before each example input. */
  @JsonProperty("inputPrefixes")
  public abstract Optional<List<String>> inputPrefixes();

  /** Preamble: The output prefixes before each example output. */
  @JsonProperty("outputPrefixes")
  public abstract Optional<List<String>> outputPrefixes();

  /**
   * Preamble: The input test data for prediction. Each PartList in this field represents one
   * text-only input set for a single model request.
   */
  @JsonProperty("predictionInputs")
  public abstract Optional<List<SchemaPromptSpecPartList>> predictionInputs();

  /** The prompt message. */
  @JsonProperty("promptMessage")
  public abstract Optional<SchemaPromptSpecPromptMessage> promptMessage();

  /** Instantiates a builder for SchemaPromptSpecStructuredPrompt. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecStructuredPrompt.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecStructuredPrompt. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecStructuredPrompt.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecStructuredPrompt.Builder();
    }

    /**
     * Setter for context.
     *
     * <p>context: Preamble: The context of the prompt.
     */
    @JsonProperty("context")
    public abstract Builder context(Content context);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder context(Optional<Content> context);

    /** Clears the value of context field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContext() {
      return context(Optional.empty());
    }

    /**
     * Setter for examples.
     *
     * <p>examples: Preamble: A set of examples for expected model response.
     */
    @JsonProperty("examples")
    public abstract Builder examples(List<SchemaPromptSpecPartList> examples);

    /**
     * Setter for examples.
     *
     * <p>examples: Preamble: A set of examples for expected model response.
     */
    @CanIgnoreReturnValue
    public Builder examples(SchemaPromptSpecPartList... examples) {
      return examples(Arrays.asList(examples));
    }

    /**
     * Setter for examples builder.
     *
     * <p>examples: Preamble: A set of examples for expected model response.
     */
    @CanIgnoreReturnValue
    public Builder examples(SchemaPromptSpecPartList.Builder... examplesBuilders) {
      return examples(
          Arrays.asList(examplesBuilders).stream()
              .map(SchemaPromptSpecPartList.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder examples(Optional<List<SchemaPromptSpecPartList>> examples);

    /** Clears the value of examples field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExamples() {
      return examples(Optional.empty());
    }

    /**
     * Setter for infillPrefix.
     *
     * <p>infillPrefix: Preamble: For infill prompt, the prefix before expected model response.
     */
    @JsonProperty("infillPrefix")
    public abstract Builder infillPrefix(String infillPrefix);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder infillPrefix(Optional<String> infillPrefix);

    /** Clears the value of infillPrefix field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInfillPrefix() {
      return infillPrefix(Optional.empty());
    }

    /**
     * Setter for infillSuffix.
     *
     * <p>infillSuffix: Preamble: For infill prompt, the suffix after expected model response.
     */
    @JsonProperty("infillSuffix")
    public abstract Builder infillSuffix(String infillSuffix);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder infillSuffix(Optional<String> infillSuffix);

    /** Clears the value of infillSuffix field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInfillSuffix() {
      return infillSuffix(Optional.empty());
    }

    /**
     * Setter for inputPrefixes.
     *
     * <p>inputPrefixes: Preamble: The input prefixes before each example input.
     */
    @JsonProperty("inputPrefixes")
    public abstract Builder inputPrefixes(List<String> inputPrefixes);

    /**
     * Setter for inputPrefixes.
     *
     * <p>inputPrefixes: Preamble: The input prefixes before each example input.
     */
    @CanIgnoreReturnValue
    public Builder inputPrefixes(String... inputPrefixes) {
      return inputPrefixes(Arrays.asList(inputPrefixes));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inputPrefixes(Optional<List<String>> inputPrefixes);

    /** Clears the value of inputPrefixes field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInputPrefixes() {
      return inputPrefixes(Optional.empty());
    }

    /**
     * Setter for outputPrefixes.
     *
     * <p>outputPrefixes: Preamble: The output prefixes before each example output.
     */
    @JsonProperty("outputPrefixes")
    public abstract Builder outputPrefixes(List<String> outputPrefixes);

    /**
     * Setter for outputPrefixes.
     *
     * <p>outputPrefixes: Preamble: The output prefixes before each example output.
     */
    @CanIgnoreReturnValue
    public Builder outputPrefixes(String... outputPrefixes) {
      return outputPrefixes(Arrays.asList(outputPrefixes));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder outputPrefixes(Optional<List<String>> outputPrefixes);

    /** Clears the value of outputPrefixes field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOutputPrefixes() {
      return outputPrefixes(Optional.empty());
    }

    /**
     * Setter for predictionInputs.
     *
     * <p>predictionInputs: Preamble: The input test data for prediction. Each PartList in this
     * field represents one text-only input set for a single model request.
     */
    @JsonProperty("predictionInputs")
    public abstract Builder predictionInputs(List<SchemaPromptSpecPartList> predictionInputs);

    /**
     * Setter for predictionInputs.
     *
     * <p>predictionInputs: Preamble: The input test data for prediction. Each PartList in this
     * field represents one text-only input set for a single model request.
     */
    @CanIgnoreReturnValue
    public Builder predictionInputs(SchemaPromptSpecPartList... predictionInputs) {
      return predictionInputs(Arrays.asList(predictionInputs));
    }

    /**
     * Setter for predictionInputs builder.
     *
     * <p>predictionInputs: Preamble: The input test data for prediction. Each PartList in this
     * field represents one text-only input set for a single model request.
     */
    @CanIgnoreReturnValue
    public Builder predictionInputs(SchemaPromptSpecPartList.Builder... predictionInputsBuilders) {
      return predictionInputs(
          Arrays.asList(predictionInputsBuilders).stream()
              .map(SchemaPromptSpecPartList.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder predictionInputs(Optional<List<SchemaPromptSpecPartList>> predictionInputs);

    /** Clears the value of predictionInputs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPredictionInputs() {
      return predictionInputs(Optional.empty());
    }

    /**
     * Setter for promptMessage.
     *
     * <p>promptMessage: The prompt message.
     */
    @JsonProperty("promptMessage")
    public abstract Builder promptMessage(SchemaPromptSpecPromptMessage promptMessage);

    /**
     * Setter for promptMessage builder.
     *
     * <p>promptMessage: The prompt message.
     */
    @CanIgnoreReturnValue
    public Builder promptMessage(SchemaPromptSpecPromptMessage.Builder promptMessageBuilder) {
      return promptMessage(promptMessageBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptMessage(Optional<SchemaPromptSpecPromptMessage> promptMessage);

    /** Clears the value of promptMessage field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptMessage() {
      return promptMessage(Optional.empty());
    }

    public abstract SchemaPromptSpecStructuredPrompt build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecStructuredPrompt object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecStructuredPrompt fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaPromptSpecStructuredPrompt.class);
  }
}
