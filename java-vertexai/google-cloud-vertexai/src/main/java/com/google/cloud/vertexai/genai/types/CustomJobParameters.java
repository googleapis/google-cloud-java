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
import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Represents a job that runs custom workloads such as a Docker container or a Python package. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = CustomJobParameters.Builder.class)
public abstract class CustomJobParameters extends JsonSerializable {
  /** */
  @JsonProperty("customJob")
  public abstract Optional<CustomJob> customJob();

  /** */
  @JsonProperty("config")
  public abstract Optional<VertexBaseConfig> config();

  /** Instantiates a builder for CustomJobParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CustomJobParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CustomJobParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CustomJobParameters.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CustomJobParameters.Builder();
    }

    /**
     * Setter for customJob.
     *
     * <p>customJob:
     */
    @JsonProperty("customJob")
    public abstract Builder customJob(CustomJob customJob);

    /**
     * Setter for customJob builder.
     *
     * <p>customJob:
     */
    @CanIgnoreReturnValue
    public Builder customJob(CustomJob.Builder customJobBuilder) {
      return customJob(customJobBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder customJob(Optional<CustomJob> customJob);

    /** Clears the value of customJob field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCustomJob() {
      return customJob(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(VertexBaseConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(VertexBaseConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<VertexBaseConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract CustomJobParameters build();
  }

  /** Deserializes a JSON string to a CustomJobParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static CustomJobParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CustomJobParameters.class);
  }
}
