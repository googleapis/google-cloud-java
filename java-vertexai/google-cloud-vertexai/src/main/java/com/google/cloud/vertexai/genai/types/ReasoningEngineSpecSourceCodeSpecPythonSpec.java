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

/** Specification for running a Python application from source. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecSourceCodeSpecPythonSpec.Builder.class)
public abstract class ReasoningEngineSpecSourceCodeSpecPythonSpec extends JsonSerializable {
  /**
   * Optional. The Python module to load as the entrypoint, specified as a fully qualified module
   * name. For example: path.to.agent. If not specified, defaults to "agent". The project root will
   * be added to Python sys.path, allowing imports to be specified relative to the root.
   */
  @JsonProperty("entrypointModule")
  public abstract Optional<String> entrypointModule();

  /**
   * Optional. The name of the callable object within the `entrypoint_module` to use as the
   * application If not specified, defaults to "root_agent".
   */
  @JsonProperty("entrypointObject")
  public abstract Optional<String> entrypointObject();

  /**
   * Optional. The path to the requirements file, relative to the source root. If not specified,
   * defaults to "requirements.txt".
   */
  @JsonProperty("requirementsFile")
  public abstract Optional<String> requirementsFile();

  /**
   * Optional. The version of Python to use. Support version includes 3.9, 3.10, 3.11, 3.12, 3.13.
   * If not specified, default value is 3.10.
   */
  @JsonProperty("version")
  public abstract Optional<String> version();

  /** Instantiates a builder for ReasoningEngineSpecSourceCodeSpecPythonSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecSourceCodeSpecPythonSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecSourceCodeSpecPythonSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineSpecSourceCodeSpecPythonSpec.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecSourceCodeSpecPythonSpec.Builder();
    }

    /**
     * Setter for entrypointModule.
     *
     * <p>entrypointModule: Optional. The Python module to load as the entrypoint, specified as a
     * fully qualified module name. For example: path.to.agent. If not specified, defaults to
     * "agent". The project root will be added to Python sys.path, allowing imports to be specified
     * relative to the root.
     */
    @JsonProperty("entrypointModule")
    public abstract Builder entrypointModule(String entrypointModule);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder entrypointModule(Optional<String> entrypointModule);

    /** Clears the value of entrypointModule field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEntrypointModule() {
      return entrypointModule(Optional.empty());
    }

    /**
     * Setter for entrypointObject.
     *
     * <p>entrypointObject: Optional. The name of the callable object within the `entrypoint_module`
     * to use as the application If not specified, defaults to "root_agent".
     */
    @JsonProperty("entrypointObject")
    public abstract Builder entrypointObject(String entrypointObject);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder entrypointObject(Optional<String> entrypointObject);

    /** Clears the value of entrypointObject field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEntrypointObject() {
      return entrypointObject(Optional.empty());
    }

    /**
     * Setter for requirementsFile.
     *
     * <p>requirementsFile: Optional. The path to the requirements file, relative to the source
     * root. If not specified, defaults to "requirements.txt".
     */
    @JsonProperty("requirementsFile")
    public abstract Builder requirementsFile(String requirementsFile);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder requirementsFile(Optional<String> requirementsFile);

    /** Clears the value of requirementsFile field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRequirementsFile() {
      return requirementsFile(Optional.empty());
    }

    /**
     * Setter for version.
     *
     * <p>version: Optional. The version of Python to use. Support version includes 3.9, 3.10, 3.11,
     * 3.12, 3.13. If not specified, default value is 3.10.
     */
    @JsonProperty("version")
    public abstract Builder version(String version);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder version(Optional<String> version);

    /** Clears the value of version field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVersion() {
      return version(Optional.empty());
    }

    public abstract ReasoningEngineSpecSourceCodeSpecPythonSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpecSourceCodeSpecPythonSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecSourceCodeSpecPythonSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineSpecSourceCodeSpecPythonSpec.class);
  }
}
