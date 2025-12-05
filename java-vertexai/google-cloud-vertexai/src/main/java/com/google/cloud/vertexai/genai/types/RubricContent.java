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

/** Content of the rubric, defining the testable criteria. */
@AutoValue
@JsonDeserialize(builder = RubricContent.Builder.class)
public abstract class RubricContent extends JsonSerializable {
  /** Evaluation criteria based on a specific property. */
  @JsonProperty("property")
  public abstract Optional<RubricContentProperty> property();

  /** Instantiates a builder for RubricContent. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricContent.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricContent. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricContent.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricContent.Builder();
    }

    /**
     * Setter for property.
     *
     * <p>property: Evaluation criteria based on a specific property.
     */
    @JsonProperty("property")
    public abstract Builder property(RubricContentProperty property);

    /**
     * Setter for property builder.
     *
     * <p>property: Evaluation criteria based on a specific property.
     */
    @CanIgnoreReturnValue
    public Builder property(RubricContentProperty.Builder propertyBuilder) {
      return property(propertyBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder property(Optional<RubricContentProperty> property);

    /** Clears the value of property field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearProperty() {
      return property(Optional.empty());
    }

    public abstract RubricContent build();
  }

  /** Deserializes a JSON string to a RubricContent object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricContent fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricContent.class);
  }
}
