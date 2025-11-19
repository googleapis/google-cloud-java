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

/** Parameters for restoring a prompt version. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = RestoreVersionRequestParameters.Builder.class)
public abstract class RestoreVersionRequestParameters extends JsonSerializable {
  /** ID of the prompt dataset to be restored. */
  @JsonProperty("datasetId")
  public abstract Optional<String> datasetId();

  /** ID of the prompt dataset version to be restored. */
  @JsonProperty("versionId")
  public abstract Optional<String> versionId();

  /** */
  @JsonProperty("config")
  public abstract Optional<RestoreVersionConfig> config();

  /** Instantiates a builder for RestoreVersionRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RestoreVersionRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RestoreVersionRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RestoreVersionRequestParameters.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RestoreVersionRequestParameters.Builder();
    }

    /**
     * Setter for datasetId.
     *
     * <p>datasetId: ID of the prompt dataset to be restored.
     */
    @JsonProperty("datasetId")
    public abstract Builder datasetId(String datasetId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasetId(Optional<String> datasetId);

    /** Clears the value of datasetId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasetId() {
      return datasetId(Optional.empty());
    }

    /**
     * Setter for versionId.
     *
     * <p>versionId: ID of the prompt dataset version to be restored.
     */
    @JsonProperty("versionId")
    public abstract Builder versionId(String versionId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder versionId(Optional<String> versionId);

    /** Clears the value of versionId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVersionId() {
      return versionId(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(RestoreVersionConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(RestoreVersionConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<RestoreVersionConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract RestoreVersionRequestParameters build();
  }

  /** Deserializes a JSON string to a RestoreVersionRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static RestoreVersionRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RestoreVersionRequestParameters.class);
  }
}
