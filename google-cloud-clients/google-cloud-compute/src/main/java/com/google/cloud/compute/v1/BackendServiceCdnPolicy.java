/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class BackendServiceCdnPolicy implements ApiMessage {
  private final CacheKeyPolicy cacheKeyPolicy;

  private BackendServiceCdnPolicy() {
    this.cacheKeyPolicy = null;
  }

  private BackendServiceCdnPolicy(CacheKeyPolicy cacheKeyPolicy) {
    this.cacheKeyPolicy = cacheKeyPolicy;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("cacheKeyPolicy")) {
      return cacheKeyPolicy;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  public CacheKeyPolicy getCacheKeyPolicy() {
    return cacheKeyPolicy;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServiceCdnPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServiceCdnPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServiceCdnPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServiceCdnPolicy();
  }

  public static class Builder {
    private CacheKeyPolicy cacheKeyPolicy;

    Builder() {}

    public Builder mergeFrom(BackendServiceCdnPolicy other) {
      if (other == BackendServiceCdnPolicy.getDefaultInstance()) return this;
      if (other.getCacheKeyPolicy() != null) {
        this.cacheKeyPolicy = other.cacheKeyPolicy;
      }
      return this;
    }

    Builder(BackendServiceCdnPolicy source) {
      this.cacheKeyPolicy = source.cacheKeyPolicy;
    }

    public CacheKeyPolicy getCacheKeyPolicy() {
      return cacheKeyPolicy;
    }

    public Builder setCacheKeyPolicy(CacheKeyPolicy cacheKeyPolicy) {
      this.cacheKeyPolicy = cacheKeyPolicy;
      return this;
    }

    public BackendServiceCdnPolicy build() {
      return new BackendServiceCdnPolicy(cacheKeyPolicy);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCacheKeyPolicy(this.cacheKeyPolicy);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendServiceCdnPolicy{" + "cacheKeyPolicy=" + cacheKeyPolicy + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendServiceCdnPolicy) {
      BackendServiceCdnPolicy that = (BackendServiceCdnPolicy) o;
      return Objects.equals(this.cacheKeyPolicy, that.getCacheKeyPolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cacheKeyPolicy);
  }
}
