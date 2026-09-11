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

package com.google.cloud.firestore;

import com.google.api.core.BetaApi;
import com.google.cloud.firestore.models.RequestOptions;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Class representing options for query or request execution in Google Cloud Firestore. Combines
 * {@link ExplainOptions} and {@link RequestOptions}.
 */
@BetaApi
public class FirestoreExecutionOptions {

  private final @Nullable ExplainOptions explainOptions;
  private final RequestOptions requestOptions;

  private FirestoreExecutionOptions(Builder builder) {
    this.explainOptions = builder.explainOptions;
    this.requestOptions = builder.requestOptions;
  }

  @Nullable
  public ExplainOptions getExplainOptions() {
    return explainOptions;
  }

  @Nonnull
  public RequestOptions getRequestOptions() {
    return requestOptions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FirestoreExecutionOptions)) {
      return false;
    }
    FirestoreExecutionOptions that = (FirestoreExecutionOptions) o;
    return Objects.equal(explainOptions, that.explainOptions)
        && Objects.equal(requestOptions, that.requestOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(explainOptions, requestOptions);
  }

  @Override
  public String toString() {
    return "FirestoreExecutionOptions{"
        + "explainOptions="
        + explainOptions
        + ", requestOptions="
        + requestOptions
        + "}";
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder options() {
    return new Builder();
  }

  /** Returns a default {@code FirestoreExecutionOptions} instance. */
  public static FirestoreExecutionOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Builder for {@link FirestoreExecutionOptions}. */
  public static class Builder {
    private @Nullable ExplainOptions explainOptions;
    private RequestOptions requestOptions = RequestOptions.getDefaultInstance();

    private Builder() {}

    private Builder(FirestoreExecutionOptions options) {
      this.explainOptions = options.explainOptions;
      this.requestOptions = options.requestOptions;
    }

    public Builder setExplainOptions(@Nullable ExplainOptions explainOptions) {
      this.explainOptions = explainOptions;
      return this;
    }

    public Builder withExplainOptions(@Nullable ExplainOptions explainOptions) {
      return setExplainOptions(explainOptions);
    }

    public Builder setRequestOptions(@Nonnull RequestOptions requestOptions) {
      Preconditions.checkNotNull(requestOptions, "requestOptions cannot be null");
      this.requestOptions = requestOptions;
      return this;
    }

    public Builder withRequestOptions(@Nonnull RequestOptions requestOptions) {
      return setRequestOptions(requestOptions);
    }

    @Nonnull
    public FirestoreExecutionOptions build() {
      return new FirestoreExecutionOptions(this);
    }
  }
}
