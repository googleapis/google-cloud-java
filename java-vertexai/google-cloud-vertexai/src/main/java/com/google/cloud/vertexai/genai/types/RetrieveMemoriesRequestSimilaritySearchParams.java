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

/** The parameters for semantic similarity search based retrieval. */
@AutoValue
@JsonDeserialize(builder = RetrieveMemoriesRequestSimilaritySearchParams.Builder.class)
public abstract class RetrieveMemoriesRequestSimilaritySearchParams extends JsonSerializable {
  /**
   * Required. Query to use for similarity search retrieval. If provided, then the parent
   * ReasoningEngine must have ReasoningEngineContextSpec.MemoryBankConfig.SimilaritySearchConfig
   * set.
   */
  @JsonProperty("searchQuery")
  public abstract Optional<String> searchQuery();

  /**
   * Optional. The maximum number of memories to return. The service may return fewer than this
   * value. If unspecified, at most 3 memories will be returned. The maximum value is 100; values
   * above 100 will be coerced to 100.
   */
  @JsonProperty("topK")
  public abstract Optional<Integer> topK();

  /** Instantiates a builder for RetrieveMemoriesRequestSimilaritySearchParams. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RetrieveMemoriesRequestSimilaritySearchParams.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RetrieveMemoriesRequestSimilaritySearchParams. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RetrieveMemoriesRequestSimilaritySearchParams.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RetrieveMemoriesRequestSimilaritySearchParams.Builder();
    }

    /**
     * Setter for searchQuery.
     *
     * <p>searchQuery: Required. Query to use for similarity search retrieval. If provided, then the
     * parent ReasoningEngine must have
     * ReasoningEngineContextSpec.MemoryBankConfig.SimilaritySearchConfig set.
     */
    @JsonProperty("searchQuery")
    public abstract Builder searchQuery(String searchQuery);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder searchQuery(Optional<String> searchQuery);

    /** Clears the value of searchQuery field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSearchQuery() {
      return searchQuery(Optional.empty());
    }

    /**
     * Setter for topK.
     *
     * <p>topK: Optional. The maximum number of memories to return. The service may return fewer
     * than this value. If unspecified, at most 3 memories will be returned. The maximum value is
     * 100; values above 100 will be coerced to 100.
     */
    @JsonProperty("topK")
    public abstract Builder topK(Integer topK);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder topK(Optional<Integer> topK);

    /** Clears the value of topK field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTopK() {
      return topK(Optional.empty());
    }

    public abstract RetrieveMemoriesRequestSimilaritySearchParams build();
  }

  /** Deserializes a JSON string to a RetrieveMemoriesRequestSimilaritySearchParams object. */
  @ExcludeFromGeneratedCoverageReport
  public static RetrieveMemoriesRequestSimilaritySearchParams fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, RetrieveMemoriesRequestSimilaritySearchParams.class);
  }
}
