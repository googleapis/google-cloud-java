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
public final class UrlMapsValidateRequest implements ApiMessage {
  private final UrlMap resource;

  private UrlMapsValidateRequest() {
    this.resource = null;
  }

  private UrlMapsValidateRequest(UrlMap resource) {
    this.resource = resource;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("resource".equals(fieldName)) {
      return resource;
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

  public UrlMap getResource() {
    return resource;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapsValidateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapsValidateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapsValidateRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapsValidateRequest();
  }

  public static class Builder {
    private UrlMap resource;

    Builder() {}

    public Builder mergeFrom(UrlMapsValidateRequest other) {
      if (other == UrlMapsValidateRequest.getDefaultInstance()) return this;
      if (other.getResource() != null) {
        this.resource = other.resource;
      }
      return this;
    }

    Builder(UrlMapsValidateRequest source) {
      this.resource = source.resource;
    }

    public UrlMap getResource() {
      return resource;
    }

    public Builder setResource(UrlMap resource) {
      this.resource = resource;
      return this;
    }

    public UrlMapsValidateRequest build() {
      return new UrlMapsValidateRequest(resource);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setResource(this.resource);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapsValidateRequest{" + "resource=" + resource + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapsValidateRequest) {
      UrlMapsValidateRequest that = (UrlMapsValidateRequest) o;
      return Objects.equals(this.resource, that.getResource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource);
  }
}
