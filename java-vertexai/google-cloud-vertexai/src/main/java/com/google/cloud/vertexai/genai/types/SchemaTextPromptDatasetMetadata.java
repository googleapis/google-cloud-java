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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents the text prompt dataset metadata. */
@AutoValue
@JsonDeserialize(builder = SchemaTextPromptDatasetMetadata.Builder.class)
public abstract class SchemaTextPromptDatasetMetadata extends JsonSerializable {
  /** Number of candidates. */
  @JsonProperty("candidateCount")
  public abstract Optional<Long> candidateCount();

  /** The Google Cloud Storage URI that stores the prompt data. */
  @JsonProperty("gcsUri")
  public abstract Optional<String> gcsUri();

  /** Grounding checking configuration. */
  @JsonProperty("groundingConfig")
  public abstract Optional<SchemaPredictParamsGroundingConfig> groundingConfig();

  /** Whether the prompt dataset has prompt variable. */
  @JsonProperty("hasPromptVariable")
  public abstract Optional<Boolean> hasPromptVariable();

  /** Whether or not the user has enabled logit probabilities in the model parameters. */
  @JsonProperty("logprobs")
  public abstract Optional<Boolean> logprobs();

  /** Value of the maximum number of tokens generated set when the dataset was saved. */
  @JsonProperty("maxOutputTokens")
  public abstract Optional<Long> maxOutputTokens();

  /** User-created prompt note. Note size limit is 2KB. */
  @JsonProperty("note")
  public abstract Optional<String> note();

  /** The API schema of the prompt to support both UI and SDK usages. */
  @JsonProperty("promptApiSchema")
  public abstract Optional<SchemaPromptApiSchema> promptApiSchema();

  /** Type of the prompt dataset. */
  @JsonProperty("promptType")
  public abstract Optional<String> promptType();

  /**
   * Seeding enables model to return a deterministic response on a best effort basis. Determinism
   * isn't guaranteed. This field determines whether or not seeding is enabled.
   */
  @JsonProperty("seedEnabled")
  public abstract Optional<Boolean> seedEnabled();

  /** The actual value of the seed. */
  @JsonProperty("seedValue")
  public abstract Optional<Long> seedValue();

  /** Customized stop sequences. */
  @JsonProperty("stopSequences")
  public abstract Optional<List<String>> stopSequences();

  /** The content of the prompt dataset system instruction. */
  @JsonProperty("systemInstruction")
  public abstract Optional<String> systemInstruction();

  /** The Google Cloud Storage URI that stores the system instruction, starting with gs://. */
  @JsonProperty("systemInstructionGcsUri")
  public abstract Optional<String> systemInstructionGcsUri();

  /**
   * Temperature value used for sampling set when the dataset was saved. This value is used to tune
   * the degree of randomness.
   */
  @JsonProperty("temperature")
  public abstract Optional<Float> temperature();

  /** The content of the prompt dataset. */
  @JsonProperty("text")
  public abstract Optional<String> text();

  /**
   * Top K value set when the dataset was saved. This value determines how many candidates with
   * highest probability from the vocab would be selected for each decoding step.
   */
  @JsonProperty("topK")
  public abstract Optional<Long> topK();

  /**
   * Top P value set when the dataset was saved. Given topK tokens for decoding, top candidates will
   * be selected until the sum of their probabilities is topP.
   */
  @JsonProperty("topP")
  public abstract Optional<Float> topP();

  /** Instantiates a builder for SchemaTextPromptDatasetMetadata. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaTextPromptDatasetMetadata.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaTextPromptDatasetMetadata. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaTextPromptDatasetMetadata.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaTextPromptDatasetMetadata.Builder();
    }

    /**
     * Setter for candidateCount.
     *
     * <p>candidateCount: Number of candidates.
     */
    @JsonProperty("candidateCount")
    public abstract Builder candidateCount(Long candidateCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder candidateCount(Optional<Long> candidateCount);

    /** Clears the value of candidateCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCandidateCount() {
      return candidateCount(Optional.empty());
    }

    /**
     * Setter for gcsUri.
     *
     * <p>gcsUri: The Google Cloud Storage URI that stores the prompt data.
     */
    @JsonProperty("gcsUri")
    public abstract Builder gcsUri(String gcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsUri(Optional<String> gcsUri);

    /** Clears the value of gcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsUri() {
      return gcsUri(Optional.empty());
    }

    /**
     * Setter for groundingConfig.
     *
     * <p>groundingConfig: Grounding checking configuration.
     */
    @JsonProperty("groundingConfig")
    public abstract Builder groundingConfig(SchemaPredictParamsGroundingConfig groundingConfig);

    /**
     * Setter for groundingConfig builder.
     *
     * <p>groundingConfig: Grounding checking configuration.
     */
    @CanIgnoreReturnValue
    public Builder groundingConfig(
        SchemaPredictParamsGroundingConfig.Builder groundingConfigBuilder) {
      return groundingConfig(groundingConfigBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder groundingConfig(Optional<SchemaPredictParamsGroundingConfig> groundingConfig);

    /** Clears the value of groundingConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGroundingConfig() {
      return groundingConfig(Optional.empty());
    }

    /**
     * Setter for hasPromptVariable.
     *
     * <p>hasPromptVariable: Whether the prompt dataset has prompt variable.
     */
    @JsonProperty("hasPromptVariable")
    public abstract Builder hasPromptVariable(boolean hasPromptVariable);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder hasPromptVariable(Optional<Boolean> hasPromptVariable);

    /** Clears the value of hasPromptVariable field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHasPromptVariable() {
      return hasPromptVariable(Optional.empty());
    }

    /**
     * Setter for logprobs.
     *
     * <p>logprobs: Whether or not the user has enabled logit probabilities in the model parameters.
     */
    @JsonProperty("logprobs")
    public abstract Builder logprobs(boolean logprobs);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder logprobs(Optional<Boolean> logprobs);

    /** Clears the value of logprobs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLogprobs() {
      return logprobs(Optional.empty());
    }

    /**
     * Setter for maxOutputTokens.
     *
     * <p>maxOutputTokens: Value of the maximum number of tokens generated set when the dataset was
     * saved.
     */
    @JsonProperty("maxOutputTokens")
    public abstract Builder maxOutputTokens(Long maxOutputTokens);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder maxOutputTokens(Optional<Long> maxOutputTokens);

    /** Clears the value of maxOutputTokens field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMaxOutputTokens() {
      return maxOutputTokens(Optional.empty());
    }

    /**
     * Setter for note.
     *
     * <p>note: User-created prompt note. Note size limit is 2KB.
     */
    @JsonProperty("note")
    public abstract Builder note(String note);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder note(Optional<String> note);

    /** Clears the value of note field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNote() {
      return note(Optional.empty());
    }

    /**
     * Setter for promptApiSchema.
     *
     * <p>promptApiSchema: The API schema of the prompt to support both UI and SDK usages.
     */
    @JsonProperty("promptApiSchema")
    public abstract Builder promptApiSchema(SchemaPromptApiSchema promptApiSchema);

    /**
     * Setter for promptApiSchema builder.
     *
     * <p>promptApiSchema: The API schema of the prompt to support both UI and SDK usages.
     */
    @CanIgnoreReturnValue
    public Builder promptApiSchema(SchemaPromptApiSchema.Builder promptApiSchemaBuilder) {
      return promptApiSchema(promptApiSchemaBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptApiSchema(Optional<SchemaPromptApiSchema> promptApiSchema);

    /** Clears the value of promptApiSchema field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptApiSchema() {
      return promptApiSchema(Optional.empty());
    }

    /**
     * Setter for promptType.
     *
     * <p>promptType: Type of the prompt dataset.
     */
    @JsonProperty("promptType")
    public abstract Builder promptType(String promptType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptType(Optional<String> promptType);

    /** Clears the value of promptType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptType() {
      return promptType(Optional.empty());
    }

    /**
     * Setter for seedEnabled.
     *
     * <p>seedEnabled: Seeding enables model to return a deterministic response on a best effort
     * basis. Determinism isn't guaranteed. This field determines whether or not seeding is enabled.
     */
    @JsonProperty("seedEnabled")
    public abstract Builder seedEnabled(boolean seedEnabled);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder seedEnabled(Optional<Boolean> seedEnabled);

    /** Clears the value of seedEnabled field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSeedEnabled() {
      return seedEnabled(Optional.empty());
    }

    /**
     * Setter for seedValue.
     *
     * <p>seedValue: The actual value of the seed.
     */
    @JsonProperty("seedValue")
    public abstract Builder seedValue(Long seedValue);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder seedValue(Optional<Long> seedValue);

    /** Clears the value of seedValue field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSeedValue() {
      return seedValue(Optional.empty());
    }

    /**
     * Setter for stopSequences.
     *
     * <p>stopSequences: Customized stop sequences.
     */
    @JsonProperty("stopSequences")
    public abstract Builder stopSequences(List<String> stopSequences);

    /**
     * Setter for stopSequences.
     *
     * <p>stopSequences: Customized stop sequences.
     */
    @CanIgnoreReturnValue
    public Builder stopSequences(String... stopSequences) {
      return stopSequences(Arrays.asList(stopSequences));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder stopSequences(Optional<List<String>> stopSequences);

    /** Clears the value of stopSequences field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStopSequences() {
      return stopSequences(Optional.empty());
    }

    /**
     * Setter for systemInstruction.
     *
     * <p>systemInstruction: The content of the prompt dataset system instruction.
     */
    @JsonProperty("systemInstruction")
    public abstract Builder systemInstruction(String systemInstruction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder systemInstruction(Optional<String> systemInstruction);

    /** Clears the value of systemInstruction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSystemInstruction() {
      return systemInstruction(Optional.empty());
    }

    /**
     * Setter for systemInstructionGcsUri.
     *
     * <p>systemInstructionGcsUri: The Google Cloud Storage URI that stores the system instruction,
     * starting with gs://.
     */
    @JsonProperty("systemInstructionGcsUri")
    public abstract Builder systemInstructionGcsUri(String systemInstructionGcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder systemInstructionGcsUri(Optional<String> systemInstructionGcsUri);

    /** Clears the value of systemInstructionGcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSystemInstructionGcsUri() {
      return systemInstructionGcsUri(Optional.empty());
    }

    /**
     * Setter for temperature.
     *
     * <p>temperature: Temperature value used for sampling set when the dataset was saved. This
     * value is used to tune the degree of randomness.
     */
    @JsonProperty("temperature")
    public abstract Builder temperature(Float temperature);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder temperature(Optional<Float> temperature);

    /** Clears the value of temperature field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTemperature() {
      return temperature(Optional.empty());
    }

    /**
     * Setter for text.
     *
     * <p>text: The content of the prompt dataset.
     */
    @JsonProperty("text")
    public abstract Builder text(String text);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder text(Optional<String> text);

    /** Clears the value of text field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearText() {
      return text(Optional.empty());
    }

    /**
     * Setter for topK.
     *
     * <p>topK: Top K value set when the dataset was saved. This value determines how many
     * candidates with highest probability from the vocab would be selected for each decoding step.
     */
    @JsonProperty("topK")
    public abstract Builder topK(Long topK);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder topK(Optional<Long> topK);

    /** Clears the value of topK field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTopK() {
      return topK(Optional.empty());
    }

    /**
     * Setter for topP.
     *
     * <p>topP: Top P value set when the dataset was saved. Given topK tokens for decoding, top
     * candidates will be selected until the sum of their probabilities is topP.
     */
    @JsonProperty("topP")
    public abstract Builder topP(Float topP);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder topP(Optional<Float> topP);

    /** Clears the value of topP field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTopP() {
      return topP(Optional.empty());
    }

    public abstract SchemaTextPromptDatasetMetadata build();
  }

  /** Deserializes a JSON string to a SchemaTextPromptDatasetMetadata object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaTextPromptDatasetMetadata fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SchemaTextPromptDatasetMetadata.class);
  }
}
