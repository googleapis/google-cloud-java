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

/** The parameters for simple (non-similarity search) retrieval. */
@AutoValue
@JsonDeserialize(builder = RetrieveMemoriesRequestSimpleRetrievalParams.Builder.class)
public abstract class RetrieveMemoriesRequestSimpleRetrievalParams extends JsonSerializable {
  /**
   * Optional. The maximum number of memories to return. The service may return fewer than this
   * value. If unspecified, at most 3 memories will be returned. The maximum value is 100; values
   * above 100 will be coerced to 100.
   */
  @JsonProperty("pageSize")
  public abstract Optional<Integer> pageSize();

  /**
   * Optional. A page token, received from a previous `RetrieveMemories` call. Provide this to
   * retrieve the subsequent page.
   */
  @JsonProperty("pageToken")
  public abstract Optional<String> pageToken();

  /** Instantiates a builder for RetrieveMemoriesRequestSimpleRetrievalParams. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RetrieveMemoriesRequestSimpleRetrievalParams.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RetrieveMemoriesRequestSimpleRetrievalParams. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `RetrieveMemoriesRequestSimpleRetrievalParams.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RetrieveMemoriesRequestSimpleRetrievalParams.Builder();
    }

    /**
     * Setter for pageSize.
     *
     * <p>pageSize: Optional. The maximum number of memories to return. The service may return fewer
     * than this value. If unspecified, at most 3 memories will be returned. The maximum value is
     * 100; values above 100 will be coerced to 100.
     */
    @JsonProperty("pageSize")
    public abstract Builder pageSize(Integer pageSize);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pageSize(Optional<Integer> pageSize);

    /** Clears the value of pageSize field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPageSize() {
      return pageSize(Optional.empty());
    }

    /**
     * Setter for pageToken.
     *
     * <p>pageToken: Optional. A page token, received from a previous `RetrieveMemories` call.
     * Provide this to retrieve the subsequent page.
     */
    @JsonProperty("pageToken")
    public abstract Builder pageToken(String pageToken);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pageToken(Optional<String> pageToken);

    /** Clears the value of pageToken field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPageToken() {
      return pageToken(Optional.empty());
    }

    public abstract RetrieveMemoriesRequestSimpleRetrievalParams build();
  }

  /** Deserializes a JSON string to a RetrieveMemoriesRequestSimpleRetrievalParams object. */
  @ExcludeFromGeneratedCoverageReport
  public static RetrieveMemoriesRequestSimpleRetrievalParams fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, RetrieveMemoriesRequestSimpleRetrievalParams.class);
  }
}
