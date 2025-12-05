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
import java.util.Map;
import java.util.Optional;

/** Instance data specified as a map. */
@AutoValue
@JsonDeserialize(builder = MapInstance.Builder.class)
public abstract class MapInstance extends JsonSerializable {
  /** Map of instance data. */
  @JsonProperty("mapInstance")
  public abstract Optional<Map<String, InstanceData>> mapInstance();

  /** Instantiates a builder for MapInstance. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MapInstance.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MapInstance. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MapInstance.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MapInstance.Builder();
    }

    /**
     * Setter for mapInstance.
     *
     * <p>mapInstance: Map of instance data.
     */
    @JsonProperty("mapInstance")
    public abstract Builder mapInstance(Map<String, InstanceData> mapInstance);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder mapInstance(Optional<Map<String, InstanceData>> mapInstance);

    /** Clears the value of mapInstance field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMapInstance() {
      return mapInstance(Optional.empty());
    }

    public abstract MapInstance build();
  }

  /** Deserializes a JSON string to a MapInstance object. */
  @ExcludeFromGeneratedCoverageReport
  public static MapInstance fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MapInstance.class);
  }
}
