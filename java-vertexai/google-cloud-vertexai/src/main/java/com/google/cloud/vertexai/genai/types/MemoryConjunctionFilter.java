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

/** The conjunction filter for memories. */
@AutoValue
@JsonDeserialize(builder = MemoryConjunctionFilter.Builder.class)
public abstract class MemoryConjunctionFilter extends JsonSerializable {
  /** Filters that will combined using AND logic. */
  @JsonProperty("filters")
  public abstract Optional<List<MemoryFilter>> filters();

  /** Instantiates a builder for MemoryConjunctionFilter. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryConjunctionFilter.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryConjunctionFilter. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MemoryConjunctionFilter.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryConjunctionFilter.Builder();
    }

    /**
     * Setter for filters.
     *
     * <p>filters: Filters that will combined using AND logic.
     */
    @JsonProperty("filters")
    public abstract Builder filters(List<MemoryFilter> filters);

    /**
     * Setter for filters.
     *
     * <p>filters: Filters that will combined using AND logic.
     */
    @CanIgnoreReturnValue
    public Builder filters(MemoryFilter... filters) {
      return filters(Arrays.asList(filters));
    }

    /**
     * Setter for filters builder.
     *
     * <p>filters: Filters that will combined using AND logic.
     */
    @CanIgnoreReturnValue
    public Builder filters(MemoryFilter.Builder... filtersBuilders) {
      return filters(
          Arrays.asList(filtersBuilders).stream()
              .map(MemoryFilter.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder filters(Optional<List<MemoryFilter>> filters);

    /** Clears the value of filters field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFilters() {
      return filters(Optional.empty());
    }

    public abstract MemoryConjunctionFilter build();
  }

  /** Deserializes a JSON string to a MemoryConjunctionFilter object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryConjunctionFilter fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryConjunctionFilter.class);
  }
}
