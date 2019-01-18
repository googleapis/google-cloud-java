/*
 * Copyright 2019 Google LLC
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
public final class UrlMapReference implements ApiMessage {
  private final String urlMap;

  private UrlMapReference() {
    this.urlMap = null;
  }

  private UrlMapReference(String urlMap) {
    this.urlMap = urlMap;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("urlMap".equals(fieldName)) {
      return urlMap;
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

  public String getUrlMap() {
    return urlMap;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapReference();
  }

  public static class Builder {
    private String urlMap;

    Builder() {}

    public Builder mergeFrom(UrlMapReference other) {
      if (other == UrlMapReference.getDefaultInstance()) return this;
      if (other.getUrlMap() != null) {
        this.urlMap = other.urlMap;
      }
      return this;
    }

    Builder(UrlMapReference source) {
      this.urlMap = source.urlMap;
    }

    public String getUrlMap() {
      return urlMap;
    }

    public Builder setUrlMap(String urlMap) {
      this.urlMap = urlMap;
      return this;
    }

    public UrlMapReference build() {
      return new UrlMapReference(urlMap);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setUrlMap(this.urlMap);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapReference{" + "urlMap=" + urlMap + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapReference) {
      UrlMapReference that = (UrlMapReference) o;
      return Objects.equals(this.urlMap, that.getUrlMap());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(urlMap);
  }
}
