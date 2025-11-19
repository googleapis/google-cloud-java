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

/** Parameters for deleting agent engines. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = DeleteAgentEngineRequestParameters.Builder.class)
public abstract class DeleteAgentEngineRequestParameters extends JsonSerializable {
  /** Name of the agent engine. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** If set to true, any child resources will also be deleted. */
  @JsonProperty("force")
  public abstract Optional<Boolean> force();

  /** */
  @JsonProperty("config")
  public abstract Optional<DeleteAgentEngineConfig> config();

  /** Instantiates a builder for DeleteAgentEngineRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_DeleteAgentEngineRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for DeleteAgentEngineRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `DeleteAgentEngineRequestParameters.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_DeleteAgentEngineRequestParameters.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: Name of the agent engine.
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
     * Setter for force.
     *
     * <p>force: If set to true, any child resources will also be deleted.
     */
    @JsonProperty("force")
    public abstract Builder force(boolean force);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder force(Optional<Boolean> force);

    /** Clears the value of force field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearForce() {
      return force(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(DeleteAgentEngineConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(DeleteAgentEngineConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<DeleteAgentEngineConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract DeleteAgentEngineRequestParameters build();
  }

  /** Deserializes a JSON string to a DeleteAgentEngineRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static DeleteAgentEngineRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, DeleteAgentEngineRequestParameters.class);
  }
}
