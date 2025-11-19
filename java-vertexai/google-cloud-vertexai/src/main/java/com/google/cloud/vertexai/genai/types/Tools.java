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
import com.google.genai.types.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents a list of tools for an agent. */
@AutoValue
@JsonDeserialize(builder = Tools.Builder.class)
public abstract class Tools extends JsonSerializable {
  /** List of tools: each tool can have multiple function declarations. */
  @JsonProperty("tool")
  public abstract Optional<List<Tool>> tool();

  /** Instantiates a builder for Tools. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Tools.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Tools. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Tools.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Tools.Builder();
    }

    /**
     * Setter for tool.
     *
     * <p>tool: List of tools: each tool can have multiple function declarations.
     */
    @JsonProperty("tool")
    public abstract Builder tool(List<Tool> tool);

    /**
     * Setter for tool.
     *
     * <p>tool: List of tools: each tool can have multiple function declarations.
     */
    @CanIgnoreReturnValue
    public Builder tool(Tool... tool) {
      return tool(Arrays.asList(tool));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tool(Optional<List<Tool>> tool);

    /** Clears the value of tool field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTool() {
      return tool(Optional.empty());
    }

    public abstract Tools build();
  }

  /** Deserializes a JSON string to a Tools object. */
  @ExcludeFromGeneratedCoverageReport
  public static Tools fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Tools.class);
  }
}
