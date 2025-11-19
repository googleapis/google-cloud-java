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

/** Parameters for getting a dataset operation. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = GetMultimodalDatasetOperationParameters.Builder.class)
public abstract class GetMultimodalDatasetOperationParameters extends JsonSerializable {
  /** */
  @JsonProperty("datasetId")
  public abstract Optional<String> datasetId();

  /** */
  @JsonProperty("operationId")
  public abstract Optional<String> operationId();

  /** */
  @JsonProperty("config")
  public abstract Optional<GetMultimodalDatasetOperationConfig> config();

  /** Instantiates a builder for GetMultimodalDatasetOperationParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GetMultimodalDatasetOperationParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GetMultimodalDatasetOperationParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GetMultimodalDatasetOperationParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GetMultimodalDatasetOperationParameters.Builder();
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
     * Setter for operationId.
     *
     * <p>operationId:
     */
    @JsonProperty("operationId")
    public abstract Builder operationId(String operationId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder operationId(Optional<String> operationId);

    /** Clears the value of operationId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOperationId() {
      return operationId(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(GetMultimodalDatasetOperationConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(GetMultimodalDatasetOperationConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<GetMultimodalDatasetOperationConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract GetMultimodalDatasetOperationParameters build();
  }

  /** Deserializes a JSON string to a GetMultimodalDatasetOperationParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static GetMultimodalDatasetOperationParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, GetMultimodalDatasetOperationParameters.class);
  }
}
