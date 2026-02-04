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
import java.util.Optional;

/**
 * Specifies source code to be fetched from a Git repository managed through the Developer Connect
 * service.
 */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource.Builder.class)
public abstract class ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource
    extends JsonSerializable {
  /**
   * Required. The Developer Connect configuration that defines the specific repository, revision,
   * and directory to use as the source code root.
   */
  @JsonProperty("config")
  public abstract Optional<ReasoningEngineSpecSourceCodeSpecDeveloperConnectConfig> config();

  /** Instantiates a builder for ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use
     * `ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource.Builder();
    }

    /**
     * Setter for config.
     *
     * <p>config: Required. The Developer Connect configuration that defines the specific
     * repository, revision, and directory to use as the source code root.
     */
    @JsonProperty("config")
    public abstract Builder config(ReasoningEngineSpecSourceCodeSpecDeveloperConnectConfig config);

    /**
     * Setter for config builder.
     *
     * <p>config: Required. The Developer Connect configuration that defines the specific
     * repository, revision, and directory to use as the source code root.
     */
    @CanIgnoreReturnValue
    public Builder config(
        ReasoningEngineSpecSourceCodeSpecDeveloperConnectConfig.Builder configBuilder) {
      return config(configBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder config(
        Optional<ReasoningEngineSpecSourceCodeSpecDeveloperConnectConfig> config);

    /** Clears the value of config field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfig() {
      return config(Optional.empty());
    }

    public abstract ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource build();
  }

  /**
   * Deserializes a JSON string to a ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource object.
   */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource fromJson(
      String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineSpecSourceCodeSpecDeveloperConnectSource.class);
  }
}
