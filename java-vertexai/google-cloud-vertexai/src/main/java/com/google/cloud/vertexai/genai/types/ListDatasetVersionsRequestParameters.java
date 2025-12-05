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

/** Parameters for listing dataset versions. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = ListDatasetVersionsRequestParameters.Builder.class)
public abstract class ListDatasetVersionsRequestParameters extends JsonSerializable {
  /** */
  @JsonProperty("readMask")
  public abstract Optional<String> readMask();

  /** */
  @JsonProperty("datasetId")
  public abstract Optional<String> datasetId();

  /** */
  @JsonProperty("config")
  public abstract Optional<ListPromptsConfig> config();

  /** Instantiates a builder for ListDatasetVersionsRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListDatasetVersionsRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListDatasetVersionsRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ListDatasetVersionsRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListDatasetVersionsRequestParameters.Builder();
    }

    /**
     * Setter for readMask.
     *
     * <p>readMask:
     */
    @JsonProperty("readMask")
    public abstract Builder readMask(String readMask);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder readMask(Optional<String> readMask);

    /** Clears the value of readMask field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReadMask() {
      return readMask(Optional.empty());
    }

    /**
     * Setter for datasetId.
     *
     * <p>datasetId:
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
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(ListPromptsConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(ListPromptsConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<ListPromptsConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract ListDatasetVersionsRequestParameters build();
  }

  /** Deserializes a JSON string to a ListDatasetVersionsRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListDatasetVersionsRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ListDatasetVersionsRequestParameters.class);
  }
}
