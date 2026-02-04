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

/** A linked resource attached to the application by the user. */
@AutoValue
@JsonDeserialize(builder = SchemaPromptSpecAppBuilderDataLinkedResource.Builder.class)
public abstract class SchemaPromptSpecAppBuilderDataLinkedResource extends JsonSerializable {
  /** A user-friendly name for the data source shown in the UI. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /**
   * The unique resource name of the data source. The format is determined by the 'type' field. For
   * type "SAVED_PROMPT": projects/{project}/locations/{location}/datasets/{dataset} For type
   * "AI_AGENT": projects/{project}/locations/{location}/agents/{agent}
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /**
   * The type of the linked resource. e.g., "SAVED_PROMPT", "AI_AGENT" This string corresponds to
   * the name of the LinkedResourceType enum member. See:
   * google3/cloud/console/web/ai/platform/llm/prompts/build/services/specs_repository_service/linked_resources/linked_resource.ts
   */
  @JsonProperty("type")
  public abstract Optional<String> type();

  /** Instantiates a builder for SchemaPromptSpecAppBuilderDataLinkedResource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPromptSpecAppBuilderDataLinkedResource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPromptSpecAppBuilderDataLinkedResource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPromptSpecAppBuilderDataLinkedResource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPromptSpecAppBuilderDataLinkedResource.Builder();
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: A user-friendly name for the data source shown in the UI.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for name.
     *
     * <p>name: The unique resource name of the data source. The format is determined by the 'type'
     * field. For type "SAVED_PROMPT": projects/{project}/locations/{location}/datasets/{dataset}
     * For type "AI_AGENT": projects/{project}/locations/{location}/agents/{agent}
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
     * Setter for type.
     *
     * <p>type: The type of the linked resource. e.g., "SAVED_PROMPT", "AI_AGENT" This string
     * corresponds to the name of the LinkedResourceType enum member. See:
     * google3/cloud/console/web/ai/platform/llm/prompts/build/services/specs_repository_service/linked_resources/linked_resource.ts
     */
    @JsonProperty("type")
    public abstract Builder type(String type);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder type(Optional<String> type);

    /** Clears the value of type field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearType() {
      return type(Optional.empty());
    }

    public abstract SchemaPromptSpecAppBuilderDataLinkedResource build();
  }

  /** Deserializes a JSON string to a SchemaPromptSpecAppBuilderDataLinkedResource object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPromptSpecAppBuilderDataLinkedResource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaPromptSpecAppBuilderDataLinkedResource.class);
  }
}
