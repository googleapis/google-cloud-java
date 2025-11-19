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

/** User-provided package specification, containing pickled object and package requirements. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecPackageSpec.Builder.class)
public abstract class ReasoningEngineSpecPackageSpec extends JsonSerializable {
  /** Optional. The Cloud Storage URI of the dependency files in tar.gz format. */
  @JsonProperty("dependencyFilesGcsUri")
  public abstract Optional<String> dependencyFilesGcsUri();

  /** Optional. The Cloud Storage URI of the pickled python object. */
  @JsonProperty("pickleObjectGcsUri")
  public abstract Optional<String> pickleObjectGcsUri();

  /**
   * Optional. The Python version. Currently support 3.8, 3.9, 3.10, 3.11. If not specified, default
   * value is 3.10.
   */
  @JsonProperty("pythonVersion")
  public abstract Optional<String> pythonVersion();

  /** Optional. The Cloud Storage URI of the `requirements.txt` file */
  @JsonProperty("requirementsGcsUri")
  public abstract Optional<String> requirementsGcsUri();

  /** Instantiates a builder for ReasoningEngineSpecPackageSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecPackageSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecPackageSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineSpecPackageSpec.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecPackageSpec.Builder();
    }

    /**
     * Setter for dependencyFilesGcsUri.
     *
     * <p>dependencyFilesGcsUri: Optional. The Cloud Storage URI of the dependency files in tar.gz
     * format.
     */
    @JsonProperty("dependencyFilesGcsUri")
    public abstract Builder dependencyFilesGcsUri(String dependencyFilesGcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder dependencyFilesGcsUri(Optional<String> dependencyFilesGcsUri);

    /** Clears the value of dependencyFilesGcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDependencyFilesGcsUri() {
      return dependencyFilesGcsUri(Optional.empty());
    }

    /**
     * Setter for pickleObjectGcsUri.
     *
     * <p>pickleObjectGcsUri: Optional. The Cloud Storage URI of the pickled python object.
     */
    @JsonProperty("pickleObjectGcsUri")
    public abstract Builder pickleObjectGcsUri(String pickleObjectGcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pickleObjectGcsUri(Optional<String> pickleObjectGcsUri);

    /** Clears the value of pickleObjectGcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPickleObjectGcsUri() {
      return pickleObjectGcsUri(Optional.empty());
    }

    /**
     * Setter for pythonVersion.
     *
     * <p>pythonVersion: Optional. The Python version. Currently support 3.8, 3.9, 3.10, 3.11. If
     * not specified, default value is 3.10.
     */
    @JsonProperty("pythonVersion")
    public abstract Builder pythonVersion(String pythonVersion);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pythonVersion(Optional<String> pythonVersion);

    /** Clears the value of pythonVersion field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPythonVersion() {
      return pythonVersion(Optional.empty());
    }

    /**
     * Setter for requirementsGcsUri.
     *
     * <p>requirementsGcsUri: Optional. The Cloud Storage URI of the `requirements.txt` file
     */
    @JsonProperty("requirementsGcsUri")
    public abstract Builder requirementsGcsUri(String requirementsGcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder requirementsGcsUri(Optional<String> requirementsGcsUri);

    /** Clears the value of requirementsGcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRequirementsGcsUri() {
      return requirementsGcsUri(Optional.empty());
    }

    public abstract ReasoningEngineSpecPackageSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpecPackageSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecPackageSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngineSpecPackageSpec.class);
  }
}
