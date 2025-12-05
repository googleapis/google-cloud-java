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

/** Input for a rubric-based metrics. */
@AutoValue
@JsonDeserialize(builder = RubricBasedMetricInput.Builder.class)
public abstract class RubricBasedMetricInput extends JsonSerializable {
  /** Specification for the rubric-based metric. */
  @JsonProperty("metricSpec")
  public abstract Optional<RubricBasedMetricSpec> metricSpec();

  /** The instance to be evaluated. */
  @JsonProperty("instance")
  public abstract Optional<RubricBasedMetricInstance> instance();

  /** Instantiates a builder for RubricBasedMetricInput. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricBasedMetricInput.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricBasedMetricInput. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricBasedMetricInput.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricBasedMetricInput.Builder();
    }

    /**
     * Setter for metricSpec.
     *
     * <p>metricSpec: Specification for the rubric-based metric.
     */
    @JsonProperty("metricSpec")
    public abstract Builder metricSpec(RubricBasedMetricSpec metricSpec);

    /**
     * Setter for metricSpec builder.
     *
     * <p>metricSpec: Specification for the rubric-based metric.
     */
    @CanIgnoreReturnValue
    public Builder metricSpec(RubricBasedMetricSpec.Builder metricSpecBuilder) {
      return metricSpec(metricSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metricSpec(Optional<RubricBasedMetricSpec> metricSpec);

    /** Clears the value of metricSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetricSpec() {
      return metricSpec(Optional.empty());
    }

    /**
     * Setter for instance.
     *
     * <p>instance: The instance to be evaluated.
     */
    @JsonProperty("instance")
    public abstract Builder instance(RubricBasedMetricInstance instance);

    /**
     * Setter for instance builder.
     *
     * <p>instance: The instance to be evaluated.
     */
    @CanIgnoreReturnValue
    public Builder instance(RubricBasedMetricInstance.Builder instanceBuilder) {
      return instance(instanceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instance(Optional<RubricBasedMetricInstance> instance);

    /** Clears the value of instance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstance() {
      return instance(Optional.empty());
    }

    public abstract RubricBasedMetricInput build();
  }

  /** Deserializes a JSON string to a RubricBasedMetricInput object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricBasedMetricInput fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricBasedMetricInput.class);
  }
}
