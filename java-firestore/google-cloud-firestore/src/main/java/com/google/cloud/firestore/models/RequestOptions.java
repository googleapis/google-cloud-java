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

package com.google.cloud.firestore.models;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Model class for {@link com.google.firestore.v1.RequestOptions}. Contains options for a request
 * such as request tags.
 */
@BetaApi
public class RequestOptions {

  private final com.google.firestore.v1.RequestOptions proto;

  private RequestOptions(com.google.firestore.v1.RequestOptions proto) {
    this.proto = proto;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Creates a {@link RequestOptions} instance from its proto representation. */
  public static RequestOptions fromProto(com.google.firestore.v1.RequestOptions proto) {
    return new RequestOptions(proto);
  }

  /** Returns a default {@code RequestOptions} instance. */
  public static RequestOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Returns the list of request tags. */
  @Nonnull
  public List<String> getRequestTags() {
    return proto.getRequestTagsList();
  }

  /** Returns the list of request tags (alias for {@link #getRequestTags()}). */
  @Nonnull
  public List<String> getTags() {
    return getRequestTags();
  }

  public Builder toBuilder() {
    return new Builder(this.proto);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RequestOptions)) {
      return false;
    }
    RequestOptions that = (RequestOptions) o;
    return Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  @Override
  public String toString() {
    return "RequestOptions{" + "requestTags=" + getRequestTags() + "}";
  }

  @InternalApi
  @VisibleForTesting
  public com.google.firestore.v1.RequestOptions toPb() {
    return this.proto;
  }

  /** Converts this instance to its protobuf representation. */
  public com.google.firestore.v1.RequestOptions toProto() {
    return this.proto;
  }

  public static class Builder {

    private final com.google.firestore.v1.RequestOptions.Builder protoBuilder;

    private Builder() {
      this.protoBuilder = com.google.firestore.v1.RequestOptions.newBuilder();
    }

    private Builder(com.google.firestore.v1.RequestOptions proto) {
      this.protoBuilder = proto.toBuilder();
    }

    /**
     * Sets the request tags for the request options.
     *
     * @param requestTags the request tags to set
     * @return this builder
     */
    public Builder setRequestTags(@Nonnull List<String> requestTags) {
      Preconditions.checkNotNull(requestTags, "requestTags cannot be null");
      protoBuilder.clearRequestTags();
      protoBuilder.addAllRequestTags(requestTags);
      return this;
    }

    /**
     * Sets the request tags for the request options (alias for {@link #setRequestTags(List)}).
     *
     * @param tags the request tags to set
     * @return this builder
     */
    public Builder setTags(@Nonnull List<String> tags) {
      return setRequestTags(tags);
    }

    /**
     * Adds a request tag to the request options.
     *
     * @param tag the request tag to add
     * @return this builder
     */
    public Builder addTag(@Nonnull String tag) {
      Preconditions.checkNotNull(tag, "tag cannot be null");
      protoBuilder.addRequestTags(tag);
      return this;
    }

    /**
     * Adds a request tag to the request options.
     *
     * @param tag the request tag to add
     * @return this builder
     */
    public Builder addRequestTag(@Nonnull String tag) {
      return addTag(tag);
    }

    /** Builds the {@link RequestOptions} instance. */
    @Nonnull
    public RequestOptions build() {
      return new RequestOptions(protoBuilder.build());
    }
  }
}
