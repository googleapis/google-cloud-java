/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import com.google.api.core.BetaApi;
import com.google.cloud.datastore.models.ExplainOptions;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.RequestOptions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class representing options for query execution in Google Cloud Datastore. Combines {@link
 * ExplainOptions}, {@link RequestOptions}, and {@link ReadOption}s.
 */
@BetaApi
public class DatastoreExecutionOptions {

  private final ExplainOptions explainOptions;
  private final RequestOptions requestOptions;
  private final List<ReadOption> readOptions;

  private DatastoreExecutionOptions(Builder builder) {
    this.explainOptions = builder.explainOptions;
    this.requestOptions = builder.requestOptions;
    this.readOptions = ImmutableList.copyOf(builder.readOptions);
  }

  public ExplainOptions getExplainOptions() {
    return explainOptions;
  }

  public RequestOptions getRequestOptions() {
    return requestOptions;
  }

  public List<ReadOption> getReadOptions() {
    return readOptions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DatastoreExecutionOptions)) return false;
    DatastoreExecutionOptions that = (DatastoreExecutionOptions) o;
    return Objects.equal(explainOptions, that.explainOptions)
        && Objects.equal(requestOptions, that.requestOptions)
        && Objects.equal(readOptions, that.readOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(explainOptions, requestOptions, readOptions);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static DatastoreExecutionOptions of(RequestOptions requestOptions) {
    return newBuilder().setRequestOptions(requestOptions).build();
  }

  public static DatastoreExecutionOptions of(ExplainOptions explainOptions) {
    return newBuilder().setExplainOptions(explainOptions).build();
  }

  public static DatastoreExecutionOptions of(List<ReadOption> readOptions) {
    return newBuilder().setReadOptions(readOptions).build();
  }

  public static DatastoreExecutionOptions of(
      RequestOptions requestOptions, List<ReadOption> readOptions) {
    return newBuilder().setRequestOptions(requestOptions).setReadOptions(readOptions).build();
  }

  public static DatastoreExecutionOptions of(
      ExplainOptions explainOptions, RequestOptions requestOptions) {
    return newBuilder().setExplainOptions(explainOptions).setRequestOptions(requestOptions).build();
  }

  public static DatastoreExecutionOptions of(
      ExplainOptions explainOptions, RequestOptions requestOptions, List<ReadOption> readOptions) {
    return newBuilder()
        .setExplainOptions(explainOptions)
        .setRequestOptions(requestOptions)
        .setReadOptions(readOptions)
        .build();
  }

  /** Builder for {@link DatastoreExecutionOptions}. */
  public static class Builder {
    private ExplainOptions explainOptions;
    private RequestOptions requestOptions;
    private List<ReadOption> readOptions = Collections.emptyList();

    private Builder() {}

    public Builder setExplainOptions(ExplainOptions explainOptions) {
      this.explainOptions = explainOptions;
      return this;
    }

    public Builder setRequestOptions(RequestOptions requestOptions) {
      this.requestOptions = requestOptions;
      return this;
    }

    public Builder setReadOptions(List<ReadOption> readOptions) {
      this.readOptions = readOptions != null ? readOptions : Collections.emptyList();
      return this;
    }

    public DatastoreExecutionOptions build() {
      return new DatastoreExecutionOptions(this);
    }
  }
}
