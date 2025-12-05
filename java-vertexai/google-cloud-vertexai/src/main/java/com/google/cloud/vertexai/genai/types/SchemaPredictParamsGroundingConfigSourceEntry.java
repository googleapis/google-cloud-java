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

/** Single source entry for the grounding checking. */
@AutoValue
@JsonDeserialize(builder = SchemaPredictParamsGroundingConfigSourceEntry.Builder.class)
public abstract class SchemaPredictParamsGroundingConfigSourceEntry extends JsonSerializable {
  /**
   * The uri of the Vertex AI Search data source. Deprecated. Use vertex_ai_search_datastore
   * instead.
   */
  @JsonProperty("enterpriseDatastore")
  public abstract Optional<String> enterpriseDatastore();

  /**
   * The grounding text passed inline with the Predict API. It can support up to 1 million bytes.
   */
  @JsonProperty("inlineContext")
  public abstract Optional<String> inlineContext();

  /** The type of the grounding checking source. */
  @JsonProperty("type")
  public abstract Optional<Type> type();

  /** The uri of the Vertex AI Search data source. */
  @JsonProperty("vertexAiSearchDatastore")
  public abstract Optional<String> vertexAiSearchDatastore();

  /** Instantiates a builder for SchemaPredictParamsGroundingConfigSourceEntry. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_SchemaPredictParamsGroundingConfigSourceEntry.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for SchemaPredictParamsGroundingConfigSourceEntry. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `SchemaPredictParamsGroundingConfigSourceEntry.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_SchemaPredictParamsGroundingConfigSourceEntry.Builder();
    }

    /**
     * Setter for enterpriseDatastore.
     *
     * <p>enterpriseDatastore: The uri of the Vertex AI Search data source. Deprecated. Use
     * vertex_ai_search_datastore instead.
     */
    @JsonProperty("enterpriseDatastore")
    public abstract Builder enterpriseDatastore(String enterpriseDatastore);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder enterpriseDatastore(Optional<String> enterpriseDatastore);

    /** Clears the value of enterpriseDatastore field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEnterpriseDatastore() {
      return enterpriseDatastore(Optional.empty());
    }

    /**
     * Setter for inlineContext.
     *
     * <p>inlineContext: The grounding text passed inline with the Predict API. It can support up to
     * 1 million bytes.
     */
    @JsonProperty("inlineContext")
    public abstract Builder inlineContext(String inlineContext);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder inlineContext(Optional<String> inlineContext);

    /** Clears the value of inlineContext field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInlineContext() {
      return inlineContext(Optional.empty());
    }

    /**
     * Setter for type.
     *
     * <p>type: The type of the grounding checking source.
     */
    @JsonProperty("type")
    public abstract Builder type(Type type);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder type(Optional<Type> type);

    /** Clears the value of type field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearType() {
      return type(Optional.empty());
    }

    /**
     * Setter for type given a known enum.
     *
     * <p>type: The type of the grounding checking source.
     */
    @CanIgnoreReturnValue
    public Builder type(Type.Known knownType) {
      return type(new Type(knownType));
    }

    /**
     * Setter for type given a string.
     *
     * <p>type: The type of the grounding checking source.
     */
    @CanIgnoreReturnValue
    public Builder type(String type) {
      return type(new Type(type));
    }

    /**
     * Setter for vertexAiSearchDatastore.
     *
     * <p>vertexAiSearchDatastore: The uri of the Vertex AI Search data source.
     */
    @JsonProperty("vertexAiSearchDatastore")
    public abstract Builder vertexAiSearchDatastore(String vertexAiSearchDatastore);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder vertexAiSearchDatastore(Optional<String> vertexAiSearchDatastore);

    /** Clears the value of vertexAiSearchDatastore field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVertexAiSearchDatastore() {
      return vertexAiSearchDatastore(Optional.empty());
    }

    public abstract SchemaPredictParamsGroundingConfigSourceEntry build();
  }

  /** Deserializes a JSON string to a SchemaPredictParamsGroundingConfigSourceEntry object. */
  @ExcludeFromGeneratedCoverageReport
  public static SchemaPredictParamsGroundingConfigSourceEntry fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, SchemaPredictParamsGroundingConfigSourceEntry.class);
  }
}
