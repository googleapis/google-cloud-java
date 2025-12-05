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

/** Config for assembling a multimodal dataset resource. */
@AutoValue
@JsonDeserialize(builder = AssembleDatasetConfig.Builder.class)
public abstract class AssembleDatasetConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /**
   * The timeout for the assemble dataset request in seconds. If not set, the default timeout is 90
   * seconds.
   */
  @JsonProperty("timeout")
  public abstract Optional<Integer> timeout();

  /** Instantiates a builder for AssembleDatasetConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AssembleDatasetConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AssembleDatasetConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AssembleDatasetConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AssembleDatasetConfig.Builder();
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
     * Setter for timeout.
     *
     * <p>timeout: The timeout for the assemble dataset request in seconds. If not set, the default
     * timeout is 90 seconds.
     */
    @JsonProperty("timeout")
    public abstract Builder timeout(Integer timeout);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder timeout(Optional<Integer> timeout);

    /** Clears the value of timeout field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTimeout() {
      return timeout(Optional.empty());
    }

    public abstract AssembleDatasetConfig build();
  }

  /** Deserializes a JSON string to a AssembleDatasetConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static AssembleDatasetConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AssembleDatasetConfig.class);
  }
}
