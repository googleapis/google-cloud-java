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

package com.google.cloud.datastore.models;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.List;
import org.jspecify.annotations.NullMarked;

/**
 * Model class for {@link com.google.datastore.v1.RequestOptions}. Contains options for a request
 * such as request tags.
 */
@BetaApi
@NullMarked
public class RequestOptions {

  private final com.google.datastore.v1.RequestOptions proto;

  private RequestOptions(com.google.datastore.v1.RequestOptions proto) {
    this.proto = proto;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a default {@code RequestOptions} instance. */
  public static RequestOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Returns the list of request tags. */
  public List<String> getRequestTags() {
    return proto.getRequestTagsList();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RequestOptions)) return false;
    RequestOptions that = (RequestOptions) o;
    return proto.equals(that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  @InternalApi
  @VisibleForTesting
  public com.google.datastore.v1.RequestOptions toPb() {
    return this.proto;
  }

  public static class Builder {

    private final com.google.datastore.v1.RequestOptions.Builder protoBuilder =
        com.google.datastore.v1.RequestOptions.newBuilder();

    private Builder() {}

    /**
     * Sets the request tags for the request options.
     *
     * @param requestTags the request tags to set
     * @return this builder
     */
    public Builder setRequestTags(List<String> requestTags) {
      Preconditions.checkNotNull(requestTags, "requestTags cannot be null");
      protoBuilder.clearRequestTags();
      protoBuilder.addAllRequestTags(requestTags);
      return this;
    }

    /** Builds the {@link RequestOptions} instance. */
    public RequestOptions build() {
      return new RequestOptions(protoBuilder.build());
    }
  }
}
