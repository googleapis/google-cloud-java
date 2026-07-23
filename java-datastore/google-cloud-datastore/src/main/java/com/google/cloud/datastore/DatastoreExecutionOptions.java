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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.RequestOptions;
import java.util.Collections;
import java.util.List;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Class representing options for query execution in Google Cloud Datastore. Combines {@link
 * ExplainOptions}, {@link RequestOptions}, and {@link ReadOption}s.
 */
@BetaApi
@NullMarked
public class DatastoreExecutionOptions {

  private final @Nullable ExplainOptions explainOptions;
  private final @Nullable RequestOptions requestOptions;
  private final List<ReadOption> readOptions;

  private DatastoreExecutionOptions(Builder builder) {
    this.explainOptions = builder.explainOptions;
    this.requestOptions = builder.requestOptions;
    this.readOptions = ImmutableList.copyOf(builder.readOptions);
  }

  public @Nullable ExplainOptions getExplainOptions() {
    return explainOptions;
  }

  public @Nullable RequestOptions getRequestOptions() {
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

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a default {@code DatastoreExecutionOptions} instance. */
  public static DatastoreExecutionOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Builder for {@link DatastoreExecutionOptions}. */
  public static class Builder {
    private @Nullable ExplainOptions explainOptions;
    private @Nullable RequestOptions requestOptions;
    private List<ReadOption> readOptions = Collections.emptyList();

    private Builder() {}

    private Builder(DatastoreExecutionOptions options) {
      this.explainOptions = options.explainOptions;
      this.requestOptions = options.requestOptions;
      this.readOptions = options.readOptions;
    }

    public Builder setExplainOptions(@Nullable ExplainOptions explainOptions) {
      this.explainOptions = explainOptions;
      return this;
    }

    public Builder setRequestOptions(@Nullable RequestOptions requestOptions) {
      this.requestOptions = requestOptions;
      return this;
    }

    public Builder setReadOptions(List<ReadOption> readOptions) {
      Preconditions.checkNotNull(readOptions, "readOptions cannot be null");
      this.readOptions = readOptions;
      return this;
    }

    public DatastoreExecutionOptions build() {
      return new DatastoreExecutionOptions(this);
    }
  }
}
