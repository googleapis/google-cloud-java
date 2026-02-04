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

/** Tool name match input. */
@AutoValue
@JsonDeserialize(builder = ToolNameMatchInput.Builder.class)
public abstract class ToolNameMatchInput extends JsonSerializable {
  /** Required. Repeated tool name match instances. */
  @JsonProperty("instances")
  public abstract Optional<List<ToolNameMatchInstance>> instances();

  /** Required. Spec for tool name match metric. */
  @JsonProperty("metricSpec")
  public abstract Optional<ToolNameMatchSpec> metricSpec();

  /** Instantiates a builder for ToolNameMatchInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolNameMatchInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolNameMatchInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolNameMatchInput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolNameMatchInput.Builder();
    }

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated tool name match instances.
     */
    @JsonProperty("instances")
    public abstract Builder instances(List<ToolNameMatchInstance> instances);

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated tool name match instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(ToolNameMatchInstance... instances) {
      return instances(Arrays.asList(instances));
    }

    /**
     * Setter for instances builder.
     *
     * <p>instances: Required. Repeated tool name match instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(ToolNameMatchInstance.Builder... instancesBuilders) {
      return instances(
          Arrays.asList(instancesBuilders).stream()
              .map(ToolNameMatchInstance.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instances(Optional<List<ToolNameMatchInstance>> instances);

    /** Clears the value of instances field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstances() {
      return instances(Optional.empty());
    }

    /**
     * Setter for metricSpec.
     *
     * <p>metricSpec: Required. Spec for tool name match metric.
     */
    @JsonProperty("metricSpec")
    public abstract Builder metricSpec(ToolNameMatchSpec metricSpec);

    /**
     * Setter for metricSpec builder.
     *
     * <p>metricSpec: Required. Spec for tool name match metric.
     */
    @CanIgnoreReturnValue
    public Builder metricSpec(ToolNameMatchSpec.Builder metricSpecBuilder) {
      return metricSpec(metricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricSpec(Optional<ToolNameMatchSpec> metricSpec);

    /** Clears the value of metricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricSpec() {
      return metricSpec(Optional.empty());
    }

    public abstract ToolNameMatchInput build();
  }

  /** Deserializes a JSON string to a ToolNameMatchInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolNameMatchInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolNameMatchInput.class);
  }
}
