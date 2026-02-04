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

/** The response for executing a sandbox environment. */
@AutoValue
@JsonDeserialize(builder = ExecuteSandboxEnvironmentResponse.Builder.class)
public abstract class ExecuteSandboxEnvironmentResponse extends JsonSerializable {
  /** The outputs from the sandbox environment. */
  @JsonProperty("outputs")
  public abstract Optional<List<Chunk>> outputs();

  /** Instantiates a builder for ExecuteSandboxEnvironmentResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ExecuteSandboxEnvironmentResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ExecuteSandboxEnvironmentResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ExecuteSandboxEnvironmentResponse.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ExecuteSandboxEnvironmentResponse.Builder();
    }

    /**
     * Setter for outputs.
     *
     * <p>outputs: The outputs from the sandbox environment.
     */
    @JsonProperty("outputs")
    public abstract Builder outputs(List<Chunk> outputs);

    /**
     * Setter for outputs.
     *
     * <p>outputs: The outputs from the sandbox environment.
     */
    @CanIgnoreReturnValue
    public Builder outputs(Chunk... outputs) {
      return outputs(Arrays.asList(outputs));
    }

    /**
     * Setter for outputs builder.
     *
     * <p>outputs: The outputs from the sandbox environment.
     */
    @CanIgnoreReturnValue
    public Builder outputs(Chunk.Builder... outputsBuilders) {
      return outputs(
          Arrays.asList(outputsBuilders).stream()
              .map(Chunk.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder outputs(Optional<List<Chunk>> outputs);

    /** Clears the value of outputs field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOutputs() {
      return outputs(Optional.empty());
    }

    public abstract ExecuteSandboxEnvironmentResponse build();
  }

  /** Deserializes a JSON string to a ExecuteSandboxEnvironmentResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ExecuteSandboxEnvironmentResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ExecuteSandboxEnvironmentResponse.class);
  }
}
