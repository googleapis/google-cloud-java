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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** An agent engine instance. */
@AutoValue
@JsonDeserialize(builder = AgentEngine.Builder.class)
public abstract class AgentEngine extends JsonSerializable {
  /** The underlying API client. */
  @JsonIgnore
  public abstract Optional<Object> apiClient();

  /** The underlying API client for asynchronous operations. */
  @JsonIgnore
  public abstract Optional<Object> apiAsyncClient();

  /** The underlying API resource (i.e. ReasoningEngine). */
  @JsonProperty("apiResource")
  public abstract Optional<ReasoningEngine> apiResource();

  /** Instantiates a builder for AgentEngine. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentEngine.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentEngine. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `AgentEngine.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentEngine.Builder();
    }

    /**
     * Setter for apiClient.
     *
     * <p>apiClient: The underlying API client.
     */
    @JsonIgnore
    public abstract Builder apiClient(Object apiClient);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder apiClient(Optional<Object> apiClient);

    /** Clears the value of apiClient field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApiClient() {
      return apiClient(Optional.empty());
    }

    /**
     * Setter for apiAsyncClient.
     *
     * <p>apiAsyncClient: The underlying API client for asynchronous operations.
     */
    @JsonIgnore
    public abstract Builder apiAsyncClient(Object apiAsyncClient);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder apiAsyncClient(Optional<Object> apiAsyncClient);

    /** Clears the value of apiAsyncClient field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApiAsyncClient() {
      return apiAsyncClient(Optional.empty());
    }

    /**
     * Setter for apiResource.
     *
     * <p>apiResource: The underlying API resource (i.e. ReasoningEngine).
     */
    @JsonProperty("apiResource")
    public abstract Builder apiResource(ReasoningEngine apiResource);

    /**
     * Setter for apiResource builder.
     *
     * <p>apiResource: The underlying API resource (i.e. ReasoningEngine).
     */
    @CanIgnoreReturnValue
    public Builder apiResource(ReasoningEngine.Builder apiResourceBuilder) {
      return apiResource(apiResourceBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder apiResource(Optional<ReasoningEngine> apiResource);

    /** Clears the value of apiResource field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearApiResource() {
      return apiResource(Optional.empty());
    }

    public abstract AgentEngine build();
  }

  /** Deserializes a JSON string to a AgentEngine object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentEngine fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentEngine.class);
  }
}
