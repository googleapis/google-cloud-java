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

/** Response for listing agent engine memory revisions. */
@AutoValue
@JsonDeserialize(builder = ListAgentEngineMemoryRevisionsResponse.Builder.class)
public abstract class ListAgentEngineMemoryRevisionsResponse extends JsonSerializable {
  /** Used to retain the full HTTP response. */
  @JsonProperty("sdkHttpResponse")
  public abstract Optional<HttpResponse> sdkHttpResponse();

  /** */
  @JsonProperty("nextPageToken")
  public abstract Optional<String> nextPageToken();

  /** List of memory revisions. */
  @JsonProperty("memoryRevisions")
  public abstract Optional<List<MemoryRevision>> memoryRevisions();

  /** Instantiates a builder for ListAgentEngineMemoryRevisionsResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListAgentEngineMemoryRevisionsResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListAgentEngineMemoryRevisionsResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ListAgentEngineMemoryRevisionsResponse.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListAgentEngineMemoryRevisionsResponse.Builder();
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
     * Setter for memoryRevisions.
     *
     * <p>memoryRevisions: List of memory revisions.
     */
    @JsonProperty("memoryRevisions")
    public abstract Builder memoryRevisions(List<MemoryRevision> memoryRevisions);

    /**
     * Setter for memoryRevisions.
     *
     * <p>memoryRevisions: List of memory revisions.
     */
    @CanIgnoreReturnValue
    public Builder memoryRevisions(MemoryRevision... memoryRevisions) {
      return memoryRevisions(Arrays.asList(memoryRevisions));
    }

    /**
     * Setter for memoryRevisions builder.
     *
     * <p>memoryRevisions: List of memory revisions.
     */
    @CanIgnoreReturnValue
    public Builder memoryRevisions(MemoryRevision.Builder... memoryRevisionsBuilders) {
      return memoryRevisions(
          Arrays.asList(memoryRevisionsBuilders).stream()
              .map(MemoryRevision.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder memoryRevisions(Optional<List<MemoryRevision>> memoryRevisions);

    /** Clears the value of memoryRevisions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMemoryRevisions() {
      return memoryRevisions(Optional.empty());
    }

    public abstract ListAgentEngineMemoryRevisionsResponse build();
  }

  /** Deserializes a JSON string to a ListAgentEngineMemoryRevisionsResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListAgentEngineMemoryRevisionsResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ListAgentEngineMemoryRevisionsResponse.class);
  }
}
