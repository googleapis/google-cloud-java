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

/** The specification of a sandbox environment. */
@AutoValue
@JsonDeserialize(builder = SandboxEnvironmentSpec.Builder.class)
public abstract class SandboxEnvironmentSpec extends JsonSerializable {
  /** Optional. The code execution environment. */
  @JsonProperty("codeExecutionEnvironment")
  public abstract Optional<SandboxEnvironmentSpecCodeExecutionEnvironment>
      codeExecutionEnvironment();

  /** Optional. The computer use environment. */
  @JsonProperty("computerUseEnvironment")
  public abstract Optional<SandboxEnvironmentSpecComputerUseEnvironment> computerUseEnvironment();

  /** Instantiates a builder for SandboxEnvironmentSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SandboxEnvironmentSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SandboxEnvironmentSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `SandboxEnvironmentSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SandboxEnvironmentSpec.Builder();
    }

    /**
     * Setter for codeExecutionEnvironment.
     *
     * <p>codeExecutionEnvironment: Optional. The code execution environment.
     */
    @JsonProperty("codeExecutionEnvironment")
    public abstract Builder codeExecutionEnvironment(
        SandboxEnvironmentSpecCodeExecutionEnvironment codeExecutionEnvironment);

    /**
     * Setter for codeExecutionEnvironment builder.
     *
     * <p>codeExecutionEnvironment: Optional. The code execution environment.
     */
    @CanIgnoreReturnValue
    public Builder codeExecutionEnvironment(
        SandboxEnvironmentSpecCodeExecutionEnvironment.Builder codeExecutionEnvironmentBuilder) {
      return codeExecutionEnvironment(codeExecutionEnvironmentBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder codeExecutionEnvironment(
        Optional<SandboxEnvironmentSpecCodeExecutionEnvironment> codeExecutionEnvironment);

    /** Clears the value of codeExecutionEnvironment field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCodeExecutionEnvironment() {
      return codeExecutionEnvironment(Optional.empty());
    }

    /**
     * Setter for computerUseEnvironment.
     *
     * <p>computerUseEnvironment: Optional. The computer use environment.
     */
    @JsonProperty("computerUseEnvironment")
    public abstract Builder computerUseEnvironment(
        SandboxEnvironmentSpecComputerUseEnvironment computerUseEnvironment);

    /**
     * Setter for computerUseEnvironment builder.
     *
     * <p>computerUseEnvironment: Optional. The computer use environment.
     */
    @CanIgnoreReturnValue
    public Builder computerUseEnvironment(
        SandboxEnvironmentSpecComputerUseEnvironment.Builder computerUseEnvironmentBuilder) {
      return computerUseEnvironment(computerUseEnvironmentBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder computerUseEnvironment(
        Optional<SandboxEnvironmentSpecComputerUseEnvironment> computerUseEnvironment);

    /** Clears the value of computerUseEnvironment field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearComputerUseEnvironment() {
      return computerUseEnvironment(Optional.empty());
    }

    public abstract SandboxEnvironmentSpec build();
  }

  /** Deserializes a JSON string to a SandboxEnvironmentSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static SandboxEnvironmentSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, SandboxEnvironmentSpec.class);
  }
}
