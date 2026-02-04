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

/** The code execution environment with customized settings. */
@AutoValue
@JsonDeserialize(builder = SandboxEnvironmentSpecCodeExecutionEnvironment.Builder.class)
public abstract class SandboxEnvironmentSpecCodeExecutionEnvironment extends JsonSerializable {
  /** The coding language supported in this environment. */
  @JsonProperty("codeLanguage")
  public abstract Optional<Language> codeLanguage();

  /** The machine config of the code execution environment. */
  @JsonProperty("machineConfig")
  public abstract Optional<MachineConfig> machineConfig();

  /** Instantiates a builder for SandboxEnvironmentSpecCodeExecutionEnvironment. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SandboxEnvironmentSpecCodeExecutionEnvironment.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SandboxEnvironmentSpecCodeExecutionEnvironment. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SandboxEnvironmentSpecCodeExecutionEnvironment.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SandboxEnvironmentSpecCodeExecutionEnvironment.Builder();
    }

    /**
     * Setter for codeLanguage.
     *
     * <p>codeLanguage: The coding language supported in this environment.
     */
    @JsonProperty("codeLanguage")
    public abstract Builder codeLanguage(Language codeLanguage);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder codeLanguage(Optional<Language> codeLanguage);

    /** Clears the value of codeLanguage field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCodeLanguage() {
      return codeLanguage(Optional.empty());
    }

    /**
     * Setter for codeLanguage given a known enum.
     *
     * <p>codeLanguage: The coding language supported in this environment.
     */
    @CanIgnoreReturnValue
    public Builder codeLanguage(Language.Known knownType) {
      return codeLanguage(new Language(knownType));
    }

    /**
     * Setter for codeLanguage given a string.
     *
     * <p>codeLanguage: The coding language supported in this environment.
     */
    @CanIgnoreReturnValue
    public Builder codeLanguage(String codeLanguage) {
      return codeLanguage(new Language(codeLanguage));
    }

    /**
     * Setter for machineConfig.
     *
     * <p>machineConfig: The machine config of the code execution environment.
     */
    @JsonProperty("machineConfig")
    public abstract Builder machineConfig(MachineConfig machineConfig);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder machineConfig(Optional<MachineConfig> machineConfig);

    /** Clears the value of machineConfig field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMachineConfig() {
      return machineConfig(Optional.empty());
    }

    /**
     * Setter for machineConfig given a known enum.
     *
     * <p>machineConfig: The machine config of the code execution environment.
     */
    @CanIgnoreReturnValue
    public Builder machineConfig(MachineConfig.Known knownType) {
      return machineConfig(new MachineConfig(knownType));
    }

    /**
     * Setter for machineConfig given a string.
     *
     * <p>machineConfig: The machine config of the code execution environment.
     */
    @CanIgnoreReturnValue
    public Builder machineConfig(String machineConfig) {
      return machineConfig(new MachineConfig(machineConfig));
    }

    public abstract SandboxEnvironmentSpecCodeExecutionEnvironment build();
  }

  /** Deserializes a JSON string to a SandboxEnvironmentSpecCodeExecutionEnvironment object. */
  @ExcludeFromGeneratedCoverageReport
  public static SandboxEnvironmentSpecCodeExecutionEnvironment fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SandboxEnvironmentSpecCodeExecutionEnvironment.class);
  }
}
