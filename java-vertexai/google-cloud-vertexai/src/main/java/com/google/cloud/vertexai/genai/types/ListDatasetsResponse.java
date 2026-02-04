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

/** Response for listing prompt datasets. */
@AutoValue
@JsonDeserialize(builder = ListDatasetsResponse.Builder.class)
public abstract class ListDatasetsResponse extends JsonSerializable {
  /** Used to retain the full HTTP response. */
  @JsonProperty("sdkHttpResponse")
  public abstract Optional<HttpResponse> sdkHttpResponse();

  /** */
  @JsonProperty("nextPageToken")
  public abstract Optional<String> nextPageToken();

  /** List of datasets for the project. */
  @JsonProperty("datasets")
  public abstract Optional<List<Dataset>> datasets();

  /** Instantiates a builder for ListDatasetsResponse. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ListDatasetsResponse.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ListDatasetsResponse. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ListDatasetsResponse.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ListDatasetsResponse.Builder();
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
     * Setter for datasets.
     *
     * <p>datasets: List of datasets for the project.
     */
    @JsonProperty("datasets")
    public abstract Builder datasets(List<Dataset> datasets);

    /**
     * Setter for datasets.
     *
     * <p>datasets: List of datasets for the project.
     */
    @CanIgnoreReturnValue
    public Builder datasets(Dataset... datasets) {
      return datasets(Arrays.asList(datasets));
    }

    /**
     * Setter for datasets builder.
     *
     * <p>datasets: List of datasets for the project.
     */
    @CanIgnoreReturnValue
    public Builder datasets(Dataset.Builder... datasetsBuilders) {
      return datasets(
          Arrays.asList(datasetsBuilders).stream()
              .map(Dataset.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder datasets(Optional<List<Dataset>> datasets);

    /** Clears the value of datasets field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDatasets() {
      return datasets(Optional.empty());
    }

    public abstract ListDatasetsResponse build();
  }

  /** Deserializes a JSON string to a ListDatasetsResponse object. */
  @ExcludeFromGeneratedCoverageReport
  public static ListDatasetsResponse fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ListDatasetsResponse.class);
  }
}
