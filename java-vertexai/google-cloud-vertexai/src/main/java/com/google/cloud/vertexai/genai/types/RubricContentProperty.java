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

/** Defines criteria based on a specific property. */
@AutoValue
@JsonDeserialize(builder = RubricContentProperty.Builder.class)
public abstract class RubricContentProperty extends JsonSerializable {
  /**
   * Description of the property being evaluated. Example: "The model's response is grammatically
   * correct."
   */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Instantiates a builder for RubricContentProperty. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RubricContentProperty.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RubricContentProperty. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RubricContentProperty.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RubricContentProperty.Builder();
    }

    /**
     * Setter for description.
     *
     * <p>description: Description of the property being evaluated. Example: "The model's response
     * is grammatically correct."
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    public abstract RubricContentProperty build();
  }

  /** Deserializes a JSON string to a RubricContentProperty object. */
  @ExcludeFromGeneratedCoverageReport
  public static RubricContentProperty fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RubricContentProperty.class);
  }
}
