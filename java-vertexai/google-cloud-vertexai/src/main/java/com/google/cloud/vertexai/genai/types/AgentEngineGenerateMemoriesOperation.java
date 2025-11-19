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
import java.util.Map;
import java.util.Optional;

/** Operation that generates memories for an agent engine. */
@AutoValue
@JsonDeserialize(builder = AgentEngineGenerateMemoriesOperation.Builder.class)
public abstract class AgentEngineGenerateMemoriesOperation extends JsonSerializable {
  /**
   * The server-assigned name, which is only unique within the same service that originally returns
   * it. If you use the default HTTP mapping, the `name` should be a resource name ending with
   * `operations/{unique_id}`.
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * Service-specific metadata associated with the operation. It typically contains progress
   * information and common metadata such as create time. Some services might not provide such
   * metadata. Any method that returns a long-running operation should document the metadata type,
   * if any.
   */
  @JsonProperty("metadata")
  public abstract Optional<Map<String, Object>> metadata();

  /**
   * If the value is `false`, it means the operation is still in progress. If `true`, the operation
   * is completed, and either `error` or `response` is available.
   */
  @JsonProperty("done")
  public abstract Optional<Boolean> done();

  /** The error result of the operation in case of failure or cancellation. */
  @JsonProperty("error")
  public abstract Optional<Map<String, Object>> error();

  /** The response for generating memories. */
  @JsonProperty("response")
  public abstract Optional<GenerateMemoriesResponse> response();

  /** Instantiates a builder for AgentEngineGenerateMemoriesOperation. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_AgentEngineGenerateMemoriesOperation.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for AgentEngineGenerateMemoriesOperation. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `AgentEngineGenerateMemoriesOperation.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_AgentEngineGenerateMemoriesOperation.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: The server-assigned name, which is only unique within the same service that
     * originally returns it. If you use the default HTTP mapping, the `name` should be a resource
     * name ending with `operations/{unique_id}`.
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
     * Setter for metadata.
     *
     * <p>metadata: Service-specific metadata associated with the operation. It typically contains
     * progress information and common metadata such as create time. Some services might not provide
     * such metadata. Any method that returns a long-running operation should document the metadata
     * type, if any.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Map<String, Object> metadata);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Map<String, Object>> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for done.
     *
     * <p>done: If the value is `false`, it means the operation is still in progress. If `true`, the
     * operation is completed, and either `error` or `response` is available.
     */
    @JsonProperty("done")
    public abstract Builder done(boolean done);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder done(Optional<Boolean> done);

    /** Clears the value of done field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDone() {
      return done(Optional.empty());
    }

    /**
     * Setter for error.
     *
     * <p>error: The error result of the operation in case of failure or cancellation.
     */
    @JsonProperty("error")
    public abstract Builder error(Map<String, Object> error);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder error(Optional<Map<String, Object>> error);

    /** Clears the value of error field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearError() {
      return error(Optional.empty());
    }

    /**
     * Setter for response.
     *
     * <p>response: The response for generating memories.
     */
    @JsonProperty("response")
    public abstract Builder response(GenerateMemoriesResponse response);

    /**
     * Setter for response builder.
     *
     * <p>response: The response for generating memories.
     */
    @CanIgnoreReturnValue
    public Builder response(GenerateMemoriesResponse.Builder responseBuilder) {
      return response(responseBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder response(Optional<GenerateMemoriesResponse> response);

    /** Clears the value of response field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearResponse() {
      return response(Optional.empty());
    }

    public abstract AgentEngineGenerateMemoriesOperation build();
  }

  /** Deserializes a JSON string to a AgentEngineGenerateMemoriesOperation object. */
  @ExcludeFromGeneratedCoverageReport
  public static AgentEngineGenerateMemoriesOperation fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, AgentEngineGenerateMemoriesOperation.class);
  }
}
