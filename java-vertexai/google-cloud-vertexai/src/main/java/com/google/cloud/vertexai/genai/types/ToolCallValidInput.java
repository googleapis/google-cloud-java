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

/** Tool call valid input. */
@AutoValue
@JsonDeserialize(builder = ToolCallValidInput.Builder.class)
public abstract class ToolCallValidInput extends JsonSerializable {
  /** Required. Repeated tool call valid instances. */
  @JsonProperty("instances")
  public abstract Optional<List<ToolCallValidInstance>> instances();

  /** Required. Spec for tool call valid metric. */
  @JsonProperty("metricSpec")
  public abstract Optional<ToolCallValidSpec> metricSpec();

  /** Instantiates a builder for ToolCallValidInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolCallValidInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolCallValidInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolCallValidInput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolCallValidInput.Builder();
    }

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated tool call valid instances.
     */
    @JsonProperty("instances")
    public abstract Builder instances(List<ToolCallValidInstance> instances);

    /**
     * Setter for instances.
     *
     * <p>instances: Required. Repeated tool call valid instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(ToolCallValidInstance... instances) {
      return instances(Arrays.asList(instances));
    }

    /**
     * Setter for instances builder.
     *
     * <p>instances: Required. Repeated tool call valid instances.
     */
    @CanIgnoreReturnValue
    public Builder instances(ToolCallValidInstance.Builder... instancesBuilders) {
      return instances(
          Arrays.asList(instancesBuilders).stream()
              .map(ToolCallValidInstance.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instances(Optional<List<ToolCallValidInstance>> instances);

    /** Clears the value of instances field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstances() {
      return instances(Optional.empty());
    }

    /**
     * Setter for metricSpec.
     *
     * <p>metricSpec: Required. Spec for tool call valid metric.
     */
    @JsonProperty("metricSpec")
    public abstract Builder metricSpec(ToolCallValidSpec metricSpec);

    /**
     * Setter for metricSpec builder.
     *
     * <p>metricSpec: Required. Spec for tool call valid metric.
     */
    @CanIgnoreReturnValue
    public Builder metricSpec(ToolCallValidSpec.Builder metricSpecBuilder) {
      return metricSpec(metricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricSpec(Optional<ToolCallValidSpec> metricSpec);

    /** Clears the value of metricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricSpec() {
      return metricSpec(Optional.empty());
    }

    public abstract ToolCallValidInput build();
  }

  /** Deserializes a JSON string to a ToolCallValidInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolCallValidInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolCallValidInput.class);
  }
}
