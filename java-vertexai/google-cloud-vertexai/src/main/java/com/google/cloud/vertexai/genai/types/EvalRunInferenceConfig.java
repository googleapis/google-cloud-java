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
import com.google.genai.types.GenerateContentConfig;
import java.util.Optional;

/** Optional parameters for inference. */
@AutoValue
@JsonDeserialize(builder = EvalRunInferenceConfig.Builder.class)
public abstract class EvalRunInferenceConfig extends JsonSerializable {
  /** The destination path for the inference results. */
  @JsonProperty("dest")
  public abstract Optional<String> dest();

  /** The prompt template to use for inference. */
  @JsonProperty("promptTemplate")
  public abstract Optional<String> promptTemplate();

  /** The config for the generate content call. */
  @JsonProperty("generateContentConfig")
  public abstract Optional<GenerateContentConfig> generateContentConfig();

  /** Instantiates a builder for EvalRunInferenceConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvalRunInferenceConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvalRunInferenceConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvalRunInferenceConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvalRunInferenceConfig.Builder();
    }

    /**
     * Setter for dest.
     *
     * <p>dest: The destination path for the inference results.
     */
    @JsonProperty("dest")
    public abstract Builder dest(String dest);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dest(Optional<String> dest);

    /** Clears the value of dest field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDest() {
      return dest(Optional.empty());
    }

    /**
     * Setter for promptTemplate.
     *
     * <p>promptTemplate: The prompt template to use for inference.
     */
    @JsonProperty("promptTemplate")
    public abstract Builder promptTemplate(String promptTemplate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptTemplate(Optional<String> promptTemplate);

    /** Clears the value of promptTemplate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptTemplate() {
      return promptTemplate(Optional.empty());
    }

    /**
     * Setter for generateContentConfig.
     *
     * <p>generateContentConfig: The config for the generate content call.
     */
    @JsonProperty("generateContentConfig")
    public abstract Builder generateContentConfig(GenerateContentConfig generateContentConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder generateContentConfig(Optional<GenerateContentConfig> generateContentConfig);

    /** Clears the value of generateContentConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGenerateContentConfig() {
      return generateContentConfig(Optional.empty());
    }

    public abstract EvalRunInferenceConfig build();
  }

  /** Deserializes a JSON string to a EvalRunInferenceConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvalRunInferenceConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvalRunInferenceConfig.class);
  }
}
