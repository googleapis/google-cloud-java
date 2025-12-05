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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Map;
import java.util.Optional;

/** Parameters for generating agent engine memories. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = GenerateAgentEngineMemoriesRequestParameters.Builder.class)
public abstract class GenerateAgentEngineMemoriesRequestParameters extends JsonSerializable {
  /** Name of the agent engine to generate memories for. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The vertex session source of the memories that should be generated. */
  @JsonProperty("vertexSessionSource")
  public abstract Optional<GenerateMemoriesRequestVertexSessionSource> vertexSessionSource();

  /** The direct contents source of the memories that should be generated. */
  @JsonProperty("directContentsSource")
  public abstract Optional<GenerateMemoriesRequestDirectContentsSource> directContentsSource();

  /** The direct memories source of the memories that should be generated. */
  @JsonProperty("directMemoriesSource")
  public abstract Optional<GenerateMemoriesRequestDirectMemoriesSource> directMemoriesSource();

  /**
   * The scope of the memories that should be generated.
   *
   * <p>Memories will be consolidated across memories with the same scope. Must be provided unless
   * the scope is defined in the source content. If `scope` is provided, it will override the scope
   * defined in the source content. Scope values cannot contain the wildcard character '*'.
   */
  @JsonProperty("scope")
  public abstract Optional<Map<String, String>> scope();

  /** */
  @JsonProperty("config")
  public abstract Optional<GenerateAgentEngineMemoriesConfig> config();

  /** Instantiates a builder for GenerateAgentEngineMemoriesRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GenerateAgentEngineMemoriesRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GenerateAgentEngineMemoriesRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GenerateAgentEngineMemoriesRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GenerateAgentEngineMemoriesRequestParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Name of the agent engine to generate memories for.
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
     * Setter for vertexSessionSource.
     *
     * <p>vertexSessionSource: The vertex session source of the memories that should be generated.
     */
    @JsonProperty("vertexSessionSource")
    public abstract Builder vertexSessionSource(
        GenerateMemoriesRequestVertexSessionSource vertexSessionSource);

    /**
     * Setter for vertexSessionSource builder.
     *
     * <p>vertexSessionSource: The vertex session source of the memories that should be generated.
     */
    @CanIgnoreReturnValue
    public Builder vertexSessionSource(
        GenerateMemoriesRequestVertexSessionSource.Builder vertexSessionSourceBuilder) {
      return vertexSessionSource(vertexSessionSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder vertexSessionSource(
        Optional<GenerateMemoriesRequestVertexSessionSource> vertexSessionSource);

    /** Clears the value of vertexSessionSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVertexSessionSource() {
      return vertexSessionSource(Optional.empty());
    }

    /**
     * Setter for directContentsSource.
     *
     * <p>directContentsSource: The direct contents source of the memories that should be generated.
     */
    @JsonProperty("directContentsSource")
    public abstract Builder directContentsSource(
        GenerateMemoriesRequestDirectContentsSource directContentsSource);

    /**
     * Setter for directContentsSource builder.
     *
     * <p>directContentsSource: The direct contents source of the memories that should be generated.
     */
    @CanIgnoreReturnValue
    public Builder directContentsSource(
        GenerateMemoriesRequestDirectContentsSource.Builder directContentsSourceBuilder) {
      return directContentsSource(directContentsSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder directContentsSource(
        Optional<GenerateMemoriesRequestDirectContentsSource> directContentsSource);

    /** Clears the value of directContentsSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDirectContentsSource() {
      return directContentsSource(Optional.empty());
    }

    /**
     * Setter for directMemoriesSource.
     *
     * <p>directMemoriesSource: The direct memories source of the memories that should be generated.
     */
    @JsonProperty("directMemoriesSource")
    public abstract Builder directMemoriesSource(
        GenerateMemoriesRequestDirectMemoriesSource directMemoriesSource);

    /**
     * Setter for directMemoriesSource builder.
     *
     * <p>directMemoriesSource: The direct memories source of the memories that should be generated.
     */
    @CanIgnoreReturnValue
    public Builder directMemoriesSource(
        GenerateMemoriesRequestDirectMemoriesSource.Builder directMemoriesSourceBuilder) {
      return directMemoriesSource(directMemoriesSourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder directMemoriesSource(
        Optional<GenerateMemoriesRequestDirectMemoriesSource> directMemoriesSource);

    /** Clears the value of directMemoriesSource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDirectMemoriesSource() {
      return directMemoriesSource(Optional.empty());
    }

    /**
     * Setter for scope.
     *
     * <p>scope: The scope of the memories that should be generated.
     *
     * <p>Memories will be consolidated across memories with the same scope. Must be provided unless
     * the scope is defined in the source content. If `scope` is provided, it will override the
     * scope defined in the source content. Scope values cannot contain the wildcard character '*'.
     */
    @JsonProperty("scope")
    public abstract Builder scope(Map<String, String> scope);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder scope(Optional<Map<String, String>> scope);

    /** Clears the value of scope field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearScope() {
      return scope(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(GenerateAgentEngineMemoriesConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(GenerateAgentEngineMemoriesConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<GenerateAgentEngineMemoriesConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract GenerateAgentEngineMemoriesRequestParameters build();
  }

  /** Deserializes a JSON string to a GenerateAgentEngineMemoriesRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static GenerateAgentEngineMemoriesRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GenerateAgentEngineMemoriesRequestParameters.class);
  }
}
