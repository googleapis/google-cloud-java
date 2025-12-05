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

/** Parameters for deleting a prompt dataset. */
@AutoValue
@InternalApi
@JsonDeserialize(builder = DeleteDatasetRequestParameters.Builder.class)
public abstract class DeleteDatasetRequestParameters extends JsonSerializable {
  /** ID of the prompt dataset to be deleted. */
  @JsonProperty("promptId")
  public abstract Optional<String> promptId();

  /** */
  @JsonProperty("config")
  public abstract Optional<DeletePromptConfig> config();

  /** Instantiates a builder for DeleteDatasetRequestParameters. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_DeleteDatasetRequestParameters.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for DeleteDatasetRequestParameters. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `DeleteDatasetRequestParameters.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_DeleteDatasetRequestParameters.Builder();
    }

    /**
     * Setter for promptId.
     *
     * <p>promptId: ID of the prompt dataset to be deleted.
     */
    @JsonProperty("promptId")
    public abstract Builder promptId(String promptId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder promptId(Optional<String> promptId);

    /** Clears the value of promptId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPromptId() {
      return promptId(Optional.empty());
    }

    /**
     * Setter for config.
     *
     * <p>config:
     */
    @JsonProperty("config")
    public abstract Builder config(DeletePromptConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config:
     */
    @CanIgnoreReturnValue
    public Builder config(DeletePromptConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(Optional<DeletePromptConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract DeleteDatasetRequestParameters build();
  }

  /** Deserializes a JSON string to a DeleteDatasetRequestParameters object. */
  @ExcludeFromGeneratedCoverageReport
  public static DeleteDatasetRequestParameters fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, DeleteDatasetRequestParameters.class);
  }
}
