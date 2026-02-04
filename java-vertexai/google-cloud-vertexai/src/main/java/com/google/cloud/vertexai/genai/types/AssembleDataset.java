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

/** Represents the assembled dataset. */
@AutoValue
@JsonDeserialize(builder = AssembleDataset.Builder.class)
public abstract class AssembleDataset extends JsonSerializable {
  /** The BigQuery destination of the assembled dataset. */
  @JsonProperty("bigqueryDestination")
  public abstract Optional<String> bigqueryDestination();

  /** Instantiates a builder for AssembleDataset. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AssembleDataset.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AssembleDataset. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AssembleDataset.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AssembleDataset.Builder();
    }

    /**
     * Setter for bigqueryDestination.
     *
     * <p>bigqueryDestination: The BigQuery destination of the assembled dataset.
     */
    @JsonProperty("bigqueryDestination")
    public abstract Builder bigqueryDestination(String bigqueryDestination);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bigqueryDestination(Optional<String> bigqueryDestination);

    /** Clears the value of bigqueryDestination field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBigqueryDestination() {
      return bigqueryDestination(Optional.empty());
    }

    public abstract AssembleDataset build();
  }

  /** Deserializes a JSON string to a AssembleDataset object. */
  @ExcludeFromGeneratedCoverageReport
  public static AssembleDataset fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AssembleDataset.class);
  }
}
