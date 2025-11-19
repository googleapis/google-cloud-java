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

/** Parameters for generating agent engine memories. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = RollbackAgentEngineMemoryRequestParameters.Builder.class)
public abstract class RollbackAgentEngineMemoryRequestParameters extends JsonSerializable {
  /** Name of the agent engine memory to rollback. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The ID of the revision to rollback to. */
  @JsonProperty("targetRevisionId")
  public abstract Optional<String> targetRevisionId();

  /** */
  @JsonProperty("config")
  public abstract Optional<RollbackAgentEngineMemoryConfig> config();

  /** Instantiates a builder for RollbackAgentEngineMemoryRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RollbackAgentEngineMemoryRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RollbackAgentEngineMemoryRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RollbackAgentEngineMemoryRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RollbackAgentEngineMemoryRequestParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Name of the agent engine memory to rollback.
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for targetRevisionId.
     *
     * <p>targetRevisionId: The ID of the revision to rollback to.
     */
    @JsonProperty("targetRevisionId")
    public abstract Builder targetRevisionId(String targetRevisionId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder targetRevisionId(Optional<String> targetRevisionId);

    /** Clears the value of targetRevisionId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTargetRevisionId() {
      return targetRevisionId(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(RollbackAgentEngineMemoryConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(RollbackAgentEngineMemoryConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<RollbackAgentEngineMemoryConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract RollbackAgentEngineMemoryRequestParameters build();
  }

  /** Deserializes a JSON string to a RollbackAgentEngineMemoryRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static RollbackAgentEngineMemoryRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, RollbackAgentEngineMemoryRequestParameters.class);
  }
}
