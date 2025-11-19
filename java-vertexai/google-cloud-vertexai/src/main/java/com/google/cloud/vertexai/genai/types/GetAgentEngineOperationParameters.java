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

/** Parameters for getting an operation with an agent engine as a response. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = GetAgentEngineOperationParameters.Builder.class)
public abstract class GetAgentEngineOperationParameters extends JsonSerializable {
  /** The server-assigned name for the operation. */
  @JsonProperty("operationName")
  public abstract Optional<String> operationName();

  /** Used to override the default configuration. */
  @JsonProperty("config")
  public abstract Optional<GetAgentEngineOperationConfig> config();

  /** Instantiates a builder for GetAgentEngineOperationParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GetAgentEngineOperationParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GetAgentEngineOperationParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `GetAgentEngineOperationParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GetAgentEngineOperationParameters.Builder();
    }

    /**
     * Setter for operationName.
     *
     * <p>operationName: The server-assigned name for the operation.
     */
    @JsonProperty("operationName")
    public abstract Builder operationName(String operationName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder operationName(Optional<String> operationName);

    /** Clears the value of operationName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOperationName() {
      return operationName(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config: Used to override the default configuration.
     */
    @JsonProperty("config")
    public abstract Builder config(GetAgentEngineOperationConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config: Used to override the default configuration.
     */
    @CanIgnoreReturnValue
    public Builder config(GetAgentEngineOperationConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<GetAgentEngineOperationConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract GetAgentEngineOperationParameters build();
  }

  /** Deserializes a JSON string to a GetAgentEngineOperationParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static GetAgentEngineOperationParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GetAgentEngineOperationParameters.class);
  }
}
