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
import java.util.Optional;

/** Specification for deploying from source code. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecSourceCodeSpec.Builder.class)
public abstract class ReasoningEngineSpecSourceCodeSpec extends JsonSerializable {
  /** Source code is provided directly in the request. */
  @JsonProperty("inlineSource")
  public abstract Optional<ReasoningEngineSpecSourceCodeSpecInlineSource> inlineSource();

  /** Configuration for a Python application. */
  @JsonProperty("pythonSpec")
  public abstract Optional<ReasoningEngineSpecSourceCodeSpecPythonSpec> pythonSpec();

  /** Instantiates a builder for ReasoningEngineSpecSourceCodeSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecSourceCodeSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecSourceCodeSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineSpecSourceCodeSpec.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecSourceCodeSpec.Builder();
    }

    /**
     * Setter for inlineSource.
     *
     * <p>inlineSource: Source code is provided directly in the request.
     */
    @JsonProperty("inlineSource")
    public abstract Builder inlineSource(
        ReasoningEngineSpecSourceCodeSpecInlineSource inlineSource);

    /**
     * Setter for inlineSource builder.
     *
     * <p>inlineSource: Source code is provided directly in the request.
     */
    @CanIgnoreReturnValue
    public Builder inlineSource(
        ReasoningEngineSpecSourceCodeSpecInlineSource.Builder inlineSourceBuilder) {
      return inlineSource(inlineSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inlineSource(
        Optional<ReasoningEngineSpecSourceCodeSpecInlineSource> inlineSource);

    /** Clears the value of inlineSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInlineSource() {
      return inlineSource(Optional.empty());
    }

    /**
     * Setter for pythonSpec.
     *
     * <p>pythonSpec: Configuration for a Python application.
     */
    @JsonProperty("pythonSpec")
    public abstract Builder pythonSpec(ReasoningEngineSpecSourceCodeSpecPythonSpec pythonSpec);

    /**
     * Setter for pythonSpec builder.
     *
     * <p>pythonSpec: Configuration for a Python application.
     */
    @CanIgnoreReturnValue
    public Builder pythonSpec(
        ReasoningEngineSpecSourceCodeSpecPythonSpec.Builder pythonSpecBuilder) {
      return pythonSpec(pythonSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pythonSpec(Optional<ReasoningEngineSpecSourceCodeSpecPythonSpec> pythonSpec);

    /** Clears the value of pythonSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPythonSpec() {
      return pythonSpec(Optional.empty());
    }

    public abstract ReasoningEngineSpecSourceCodeSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpecSourceCodeSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecSourceCodeSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngineSpecSourceCodeSpec.class);
  }
}
