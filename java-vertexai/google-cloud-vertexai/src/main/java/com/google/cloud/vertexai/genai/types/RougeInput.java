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

/** Rouge input. */
@AutoValue
@JsonDeserialize(builder = RougeInput.Builder.class)
public abstract class RougeInput extends JsonSerializable {
  /** Required. Repeated rouge instances. */
  @JsonProperty("instances")
  public abstract Optional<List<RougeInstance>> instances();

  /** Instantiates a builder for RougeInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RougeInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RougeInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RougeInput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RougeInput.Builder();
    }

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated rouge instances.
     */
    @JsonProperty("instances")
    public abstract Builder instances(List<RougeInstance> instances);

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated rouge instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(RougeInstance... instances) {
      return instances(Arrays.asList(instances));
    }

    /**
     * Setter for instances builder.
     *
     * <p>instances: Required. Repeated rouge instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(RougeInstance.Builder... instancesBuilders) {
      return instances(
          Arrays.asList(instancesBuilders).stream()
              .map(RougeInstance.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instances(Optional<List<RougeInstance>> instances);

    /** Clears the value of instances field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstances() {
      return instances(Optional.empty());
    }

    public abstract RougeInput build();
  }

  /** Deserializes a JSON string to a RougeInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static RougeInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RougeInput.class);
  }
}
