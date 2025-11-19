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

/** The spec of a Container. */
@AutoValue
@JsonDeserialize(builder = ContainerSpec.Builder.class)
public abstract class ContainerSpec extends JsonSerializable {
  /** The arguments to be passed when starting the container. */
  @JsonProperty("args")
  public abstract Optional<List<String>> args();

  /**
   * The command to be invoked when the container is started. It overrides the entrypoint
   * instruction in Dockerfile when provided.
   */
  @JsonProperty("command")
  public abstract Optional<List<String>> command();

  /** Environment variables to be passed to the container. Maximum limit is 100. */
  @JsonProperty("env")
  public abstract Optional<List<EnvVar>> env();

  /**
   * Required. The URI of a container image in the Container Registry that is to be run on each
   * worker replica.
   */
  @JsonProperty("imageUri")
  public abstract Optional<String> imageUri();

  /** Instantiates a builder for ContainerSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ContainerSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ContainerSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ContainerSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ContainerSpec.Builder();
    }

    /**
     * Setter for args.
     *
     * <p>args: The arguments to be passed when starting the container.
     */
    @JsonProperty("args")
    public abstract Builder args(List<String> args);

    /**
     * Setter for args.
     *
     * <p>args: The arguments to be passed when starting the container.
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
     * Setter for command.
     *
     * <p>command: The command to be invoked when the container is started. It overrides the
     * entrypoint instruction in Dockerfile when provided.
     */
    @JsonProperty("command")
    public abstract Builder command(List<String> command);

    /**
     * Setter for command.
     *
     * <p>command: The command to be invoked when the container is started. It overrides the
     * entrypoint instruction in Dockerfile when provided.
     */
    @CanIgnoreReturnValue
    public Builder command(String... command) {
      return command(Arrays.asList(command));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder command(Optional<List<String>> command);

    /** Clears the value of command field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCommand() {
      return command(Optional.empty());
    }

    /**
     * Setter for env.
     *
     * <p>env: Environment variables to be passed to the container. Maximum limit is 100.
     */
    @JsonProperty("env")
    public abstract Builder env(List<EnvVar> env);

    /**
     * Setter for env.
     *
     * <p>env: Environment variables to be passed to the container. Maximum limit is 100.
     */
    @CanIgnoreReturnValue
    public Builder env(EnvVar... env) {
      return env(Arrays.asList(env));
    }

    /**
     * Setter for env builder.
     *
     * <p>env: Environment variables to be passed to the container. Maximum limit is 100.
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
     * Setter for imageUri.
     *
     * <p>imageUri: Required. The URI of a container image in the Container Registry that is to be
     * run on each worker replica.
     */
    @JsonProperty("imageUri")
    public abstract Builder imageUri(String imageUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder imageUri(Optional<String> imageUri);

    /** Clears the value of imageUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearImageUri() {
      return imageUri(Optional.empty());
    }

    public abstract ContainerSpec build();
  }

  /** Deserializes a JSON string to a ContainerSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ContainerSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ContainerSpec.class);
  }
}
