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
import com.google.genai.types.HttpOptions;
import java.util.Optional;

/** Config for retrieving memories. */
@AutoValue
@JsonDeserialize(builder = RetrieveAgentEngineMemoriesConfig.Builder.class)
public abstract class RetrieveAgentEngineMemoriesConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The standard list filter that will be applied to the retrieved memories. More detail in
   * [AIP-160](https://google.aip.dev/160).
   *
   * <p>Supported fields: `fact` `create_time` `update_time`
   */
  @JsonProperty("filter")
  public abstract Optional<String> filter();

  /** Instantiates a builder for RetrieveAgentEngineMemoriesConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RetrieveAgentEngineMemoriesConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RetrieveAgentEngineMemoriesConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RetrieveAgentEngineMemoriesConfig.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RetrieveAgentEngineMemoriesConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for filter.
     *
     * <p>filter: The standard list filter that will be applied to the retrieved memories. More
     * detail in [AIP-160](https://google.aip.dev/160).
     *
     * <p>Supported fields: `fact` `create_time` `update_time`
     */
    @JsonProperty("filter")
    public abstract Builder filter(String filter);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder filter(Optional<String> filter);

    /** Clears the value of filter field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFilter() {
      return filter(Optional.empty());
    }

    public abstract RetrieveAgentEngineMemoriesConfig build();
  }

  /** Deserializes a JSON string to a RetrieveAgentEngineMemoriesConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static RetrieveAgentEngineMemoriesConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RetrieveAgentEngineMemoriesConfig.class);
  }
}
