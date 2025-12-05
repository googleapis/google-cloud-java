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

/** The spec of a Python packaged code. */
@AutoValue
@JsonDeserialize(builder = PythonPackageSpec.Builder.class)
public abstract class PythonPackageSpec extends JsonSerializable {
  /** Command line arguments to be passed to the Python task. */
  @JsonProperty("args")
  public abstract Optional<List<String>> args();

  /** Environment variables to be passed to the python module. Maximum limit is 100. */
  @JsonProperty("env")
  public abstract Optional<List<EnvVar>> env();

  /**
   * Required. The URI of a container image in Artifact Registry that will run the provided Python
   * package. Vertex AI provides a wide range of executor images with pre-installed packages to meet
   * users' various use cases. See the list of [pre-built containers for
   * training](https://cloud.google.com/vertex-ai/docs/training/pre-built-containers). You must use
   * an image from this list.
   */
  @JsonProperty("executorImageUri")
  public abstract Optional<String> executorImageUri();

  /**
   * Required. The Google Cloud Storage location of the Python package files which are the training
   * program and its dependent packages. The maximum number of package URIs is 100.
   */
  @JsonProperty("packageUris")
  public abstract Optional<List<String>> packageUris();

  /** Required. The Python module name to run after installing the packages. */
  @JsonProperty("pythonModule")
  public abstract Optional<String> pythonModule();

  /** Instantiates a builder for PythonPackageSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PythonPackageSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PythonPackageSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PythonPackageSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PythonPackageSpec.Builder();
    }

    /**
     * Setter for args.
     *
     * <p>args: Command line arguments to be passed to the Python task.
     */
    @JsonProperty("args")
    public abstract Builder args(List<String> args);

    /**
     * Setter for args.
     *
     * <p>args: Command line arguments to be passed to the Python task.
     */
    @CanIgnoreReturnValue
    public Builder args(String... args) {
      return args(Arrays.asList(args));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder args(Optional<List<String>> args);

    /** Clears the value of args field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearArgs() {
      return args(Optional.empty());
    }

    /**
     * Setter for env.
     *
     * <p>env: Environment variables to be passed to the python module. Maximum limit is 100.
     */
    @JsonProperty("env")
    public abstract Builder env(List<EnvVar> env);

    /**
     * Setter for env.
     *
     * <p>env: Environment variables to be passed to the python module. Maximum limit is 100.
     */
    @CanIgnoreReturnValue
    public Builder env(EnvVar... env) {
      return env(Arrays.asList(env));
    }

    /**
     * Setter for env builder.
     *
     * <p>env: Environment variables to be passed to the python module. Maximum limit is 100.
     */
    @CanIgnoreReturnValue
    public Builder env(EnvVar.Builder... envBuilders) {
      return env(
          Arrays.asList(envBuilders).stream()
              .map(EnvVar.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder env(Optional<List<EnvVar>> env);

    /** Clears the value of env field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnv() {
      return env(Optional.empty());
    }

    /**
     * Setter for executorImageUri.
     *
     * <p>executorImageUri: Required. The URI of a container image in Artifact Registry that will
     * run the provided Python package. Vertex AI provides a wide range of executor images with
     * pre-installed packages to meet users' various use cases. See the list of [pre-built
     * containers for
     * training](https://cloud.google.com/vertex-ai/docs/training/pre-built-containers). You must
     * use an image from this list.
     */
    @JsonProperty("executorImageUri")
    public abstract Builder executorImageUri(String executorImageUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder executorImageUri(Optional<String> executorImageUri);

    /** Clears the value of executorImageUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearExecutorImageUri() {
      return executorImageUri(Optional.empty());
    }

    /**
     * Setter for packageUris.
     *
     * <p>packageUris: Required. The Google Cloud Storage location of the Python package files which
     * are the training program and its dependent packages. The maximum number of package URIs is
     * 100.
     */
    @JsonProperty("packageUris")
    public abstract Builder packageUris(List<String> packageUris);

    /**
     * Setter for packageUris.
     *
     * <p>packageUris: Required. The Google Cloud Storage location of the Python package files which
     * are the training program and its dependent packages. The maximum number of package URIs is
     * 100.
     */
    @CanIgnoreReturnValue
    public Builder packageUris(String... packageUris) {
      return packageUris(Arrays.asList(packageUris));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder packageUris(Optional<List<String>> packageUris);

    /** Clears the value of packageUris field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPackageUris() {
      return packageUris(Optional.empty());
    }

    /**
     * Setter for pythonModule.
     *
     * <p>pythonModule: Required. The Python module name to run after installing the packages.
     */
    @JsonProperty("pythonModule")
    public abstract Builder pythonModule(String pythonModule);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pythonModule(Optional<String> pythonModule);

    /** Clears the value of pythonModule field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPythonModule() {
      return pythonModule(Optional.empty());
    }

    public abstract PythonPackageSpec build();
  }

  /** Deserializes a JSON string to a PythonPackageSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static PythonPackageSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PythonPackageSpec.class);
  }
}
