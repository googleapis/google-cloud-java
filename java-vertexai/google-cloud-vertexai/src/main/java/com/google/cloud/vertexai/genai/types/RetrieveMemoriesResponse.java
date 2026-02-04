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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** The response for retrieving memories. */
@AutoValue
@JsonDeserialize(builder = RetrieveMemoriesResponse.Builder.class)
public abstract class RetrieveMemoriesResponse extends JsonSerializable {
  /**
   * A token that can be sent as `page_token` to retrieve the next page. If this field is omitted,
   * there are no subsequent pages. This token is not set if similarity search was used for
   * retrieval.
   */
  @JsonProperty("nextPageToken")
  public abstract Optional<String> nextPageToken();

  /** The retrieved memories. */
  @JsonProperty("retrievedMemories")
  public abstract Optional<List<RetrieveMemoriesResponseRetrievedMemory>> retrievedMemories();

  /** Instantiates a builder for RetrieveMemoriesResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_RetrieveMemoriesResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for RetrieveMemoriesResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `RetrieveMemoriesResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_RetrieveMemoriesResponse.Builder();
    }

    /**
     * Setter for nextPageToken.
     *
     * <p>nextPageToken: A token that can be sent as `page_token` to retrieve the next page. If this
     * field is omitted, there are no subsequent pages. This token is not set if similarity search
     * was used for retrieval.
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
     * Setter for retrievedMemories.
     *
     * <p>retrievedMemories: The retrieved memories.
     */
    @JsonProperty("retrievedMemories")
    public abstract Builder retrievedMemories(
        List<RetrieveMemoriesResponseRetrievedMemory> retrievedMemories);

    /**
     * Setter for retrievedMemories.
     *
     * <p>retrievedMemories: The retrieved memories.
     */
    @CanIgnoreReturnValue
    public Builder retrievedMemories(RetrieveMemoriesResponseRetrievedMemory... retrievedMemories) {
      return retrievedMemories(Arrays.asList(retrievedMemories));
    }

    /**
     * Setter for retrievedMemories builder.
     *
     * <p>retrievedMemories: The retrieved memories.
     */
    @CanIgnoreReturnValue
    public Builder retrievedMemories(
        RetrieveMemoriesResponseRetrievedMemory.Builder... retrievedMemoriesBuilders) {
      return retrievedMemories(
          Arrays.asList(retrievedMemoriesBuilders).stream()
              .map(RetrieveMemoriesResponseRetrievedMemory.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder retrievedMemories(
        Optional<List<RetrieveMemoriesResponseRetrievedMemory>> retrievedMemories);

    /** Clears the value of retrievedMemories field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRetrievedMemories() {
      return retrievedMemories(Optional.empty());
    }

    public abstract RetrieveMemoriesResponse build();
  }

  /** Deserializes a JSON string to a RetrieveMemoriesResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static RetrieveMemoriesResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, RetrieveMemoriesResponse.class);
  }
}
