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
import com.google.genai.types.HttpOptions;
import java.util.Optional;

/** Config for listing agent engine memories. */
@AutoValue
@JsonDeserialize(builder = ListAgentEngineMemoryConfig.Builder.class)
public abstract class ListAgentEngineMemoryConfig extends JsonSerializable {
  /** Used to override HTTP request options. */
  @JsonProperty("httpOptions")
  public abstract Optional<HttpOptions> httpOptions();

  /** */
  @JsonProperty("pageSize")
  public abstract Optional<Integer> pageSize();

  /** */
  @JsonProperty("pageToken")
  public abstract Optional<String> pageToken();

  /**
   * An expression for filtering the results of the request. For field names both snake_case and
   * camelCase are supported.
   */
  @JsonProperty("filter")
  public abstract Optional<String> filter();

  /**
   * The standard list order by string. If not specified, the default order is `create_time desc`.
   * If specified, the default sorting order of provided fields is ascending. More detail in
   * [AIP-132](https://google.aip.dev/132).
   *
   * <p>Supported fields: `create_time` `update_time`
   */
  @JsonProperty("orderBy")
  public abstract Optional<String> orderBy();

  /** Instantiates a builder for ListAgentEngineMemoryConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListAgentEngineMemoryConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListAgentEngineMemoryConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ListAgentEngineMemoryConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListAgentEngineMemoryConfig.Builder();
    }

    /**
     * Setter for httpOptions.
     *
     * <p>httpOptions: Used to override HTTP request options.
     */
    @JsonProperty("httpOptions")
    public abstract Builder httpOptions(HttpOptions httpOptions);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder httpOptions(Optional<HttpOptions> httpOptions);

    /** Clears the value of httpOptions field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearHttpOptions() {
      return httpOptions(Optional.empty());
    }

    /**
     * Setter for pageSize.
     *
     * <p>pageSize:
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
     * <p>pageToken:
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

    /**
     * Setter for filter.
     *
     * <p>filter: An expression for filtering the results of the request. For field names both
     * snake_case and camelCase are supported.
     */
    @JsonProperty("filter")
    public abstract Builder filter(String filter);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder filter(Optional<String> filter);

    /** Clears the value of filter field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFilter() {
      return filter(Optional.empty());
    }

    /**
     * Setter for orderBy.
     *
     * <p>orderBy: The standard list order by string. If not specified, the default order is
     * `create_time desc`. If specified, the default sorting order of provided fields is ascending.
     * More detail in [AIP-132](https://google.aip.dev/132).
     *
     * <p>Supported fields: `create_time` `update_time`
     */
    @JsonProperty("orderBy")
    public abstract Builder orderBy(String orderBy);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder orderBy(Optional<String> orderBy);

    /** Clears the value of orderBy field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOrderBy() {
      return orderBy(Optional.empty());
    }

    public abstract ListAgentEngineMemoryConfig build();
  }

  /** Deserializes a JSON string to a ListAgentEngineMemoryConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListAgentEngineMemoryConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ListAgentEngineMemoryConfig.class);
  }
}
