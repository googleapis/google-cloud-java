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

/** Response for listing multimodal datasets. */
@AutoValue
@JsonDeserialize(builder = ListMultimodalDatasetsResponse.Builder.class)
public abstract class ListMultimodalDatasetsResponse extends JsonSerializable {
  /** Used to retain the full HTTP response. */
  @JsonProperty("sdkHttpResponse")
  public abstract Optional<HttpResponse> sdkHttpResponse();

  /** */
  @JsonProperty("nextPageToken")
  public abstract Optional<String> nextPageToken();

  /**
   * The timeout for the list datasets request in seconds. If not set, the default timeout is 90
   * seconds.
   */
  @JsonProperty("timeout")
  public abstract Optional<Integer> timeout();

  /** List of datasets for the project. */
  @JsonProperty("datasets")
  public abstract Optional<List<MultimodalDataset>> datasets();

  /** Instantiates a builder for ListMultimodalDatasetsResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListMultimodalDatasetsResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListMultimodalDatasetsResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ListMultimodalDatasetsResponse.builder()` for instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListMultimodalDatasetsResponse.Builder();
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
     * Setter for timeout.
     *
     * <p>timeout: The timeout for the list datasets request in seconds. If not set, the default
     * timeout is 90 seconds.
     */
    @JsonProperty("timeout")
    public abstract Builder timeout(Integer timeout);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder timeout(Optional<Integer> timeout);

    /** Clears the value of timeout field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTimeout() {
      return timeout(Optional.empty());
    }

    /**
     * Setter for datasets.
     *
     * <p>datasets: List of datasets for the project.
     */
    @JsonProperty("datasets")
    public abstract Builder datasets(List<MultimodalDataset> datasets);

    /**
     * Setter for datasets.
     *
     * <p>datasets: List of datasets for the project.
     */
    @CanIgnoreReturnValue
    public Builder datasets(MultimodalDataset... datasets) {
      return datasets(Arrays.asList(datasets));
    }

    /**
     * Setter for datasets builder.
     *
     * <p>datasets: List of datasets for the project.
     */
    @CanIgnoreReturnValue
    public Builder datasets(MultimodalDataset.Builder... datasetsBuilders) {
      return datasets(
          Arrays.asList(datasetsBuilders).stream()
              .map(MultimodalDataset.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasets(Optional<List<MultimodalDataset>> datasets);

    /** Clears the value of datasets field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasets() {
      return datasets(Optional.empty());
    }

    public abstract ListMultimodalDatasetsResponse build();
  }

  /** Deserializes a JSON string to a ListMultimodalDatasetsResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListMultimodalDatasetsResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ListMultimodalDatasetsResponse.class);
  }
}
