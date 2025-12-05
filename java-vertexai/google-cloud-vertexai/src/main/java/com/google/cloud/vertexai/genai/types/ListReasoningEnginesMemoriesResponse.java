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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Response for listing agent engine memories. */
@AutoValue
@JsonDeserialize(builder = ListReasoningEnginesMemoriesResponse.Builder.class)
public abstract class ListReasoningEnginesMemoriesResponse extends JsonSerializable {
  /** Used to retain the full HTTP response. */
  @JsonProperty("sdkHttpResponse")
  public abstract Optional<HttpResponse> sdkHttpResponse();

  /** */
  @JsonProperty("nextPageToken")
  public abstract Optional<String> nextPageToken();

  /** List of agent engine memories. */
  @JsonProperty("memories")
  public abstract Optional<List<Memory>> memories();

  /** Instantiates a builder for ListReasoningEnginesMemoriesResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListReasoningEnginesMemoriesResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListReasoningEnginesMemoriesResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ListReasoningEnginesMemoriesResponse.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListReasoningEnginesMemoriesResponse.Builder();
    }

    /**
     * Setter for sdkHttpResponse.
     *
     * <p>sdkHttpResponse: Used to retain the full HTTP response.
     */
    @JsonProperty("sdkHttpResponse")
    public abstract Builder sdkHttpResponse(HttpResponse sdkHttpResponse);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sdkHttpResponse(Optional<HttpResponse> sdkHttpResponse);

    /** Clears the value of sdkHttpResponse field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSdkHttpResponse() {
      return sdkHttpResponse(Optional.empty());
    }

    /**
     * Setter for nextPageToken.
     *
     * <p>nextPageToken:
     */
    @JsonProperty("nextPageToken")
    public abstract Builder nextPageToken(String nextPageToken);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder nextPageToken(Optional<String> nextPageToken);

    /** Clears the value of nextPageToken field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNextPageToken() {
      return nextPageToken(Optional.empty());
    }

    /**
     * Setter for memories.
     *
     * <p>memories: List of agent engine memories.
     */
    @JsonProperty("memories")
    public abstract Builder memories(List<Memory> memories);

    /**
     * Setter for memories.
     *
     * <p>memories: List of agent engine memories.
     */
    @CanIgnoreReturnValue
    public Builder memories(Memory... memories) {
      return memories(Arrays.asList(memories));
    }

    /**
     * Setter for memories builder.
     *
     * <p>memories: List of agent engine memories.
     */
    @CanIgnoreReturnValue
    public Builder memories(Memory.Builder... memoriesBuilders) {
      return memories(
          Arrays.asList(memoriesBuilders).stream()
              .map(Memory.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memories(Optional<List<Memory>> memories);

    /** Clears the value of memories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemories() {
      return memories(Optional.empty());
    }

    public abstract ListReasoningEnginesMemoriesResponse build();
  }

  /** Deserializes a JSON string to a ListReasoningEnginesMemoriesResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListReasoningEnginesMemoriesResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ListReasoningEnginesMemoriesResponse.class);
  }
}
