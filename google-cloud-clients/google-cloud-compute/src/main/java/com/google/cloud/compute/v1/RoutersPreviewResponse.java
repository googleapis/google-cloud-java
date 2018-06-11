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
public final class RoutersPreviewResponse implements ApiMessage {
  private final Router resource;

  private RoutersPreviewResponse() {
    this.resource = null;
  }

  private RoutersPreviewResponse(Router resource) {
    this.resource = resource;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("resource")) {
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

  public Router getResource() {
    return resource;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RoutersPreviewResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RoutersPreviewResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RoutersPreviewResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RoutersPreviewResponse();
  }

  public static class Builder {
    private Router resource;

    Builder() {}

    public Builder mergeFrom(RoutersPreviewResponse other) {
      if (other == RoutersPreviewResponse.getDefaultInstance()) return this;
      if (other.getResource() != null) {
        this.resource = other.resource;
      }
      return this;
    }

    Builder(RoutersPreviewResponse source) {
      this.resource = source.resource;
    }

    public Router getResource() {
      return resource;
    }

    public Builder setResource(Router resource) {
      this.resource = resource;
      return this;
    }

    public RoutersPreviewResponse build() {
      return new RoutersPreviewResponse(resource);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setResource(this.resource);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RoutersPreviewResponse{" + "resource=" + resource + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RoutersPreviewResponse) {
      RoutersPreviewResponse that = (RoutersPreviewResponse) o;
      return Objects.equals(this.resource, that.getResource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource);
  }
}
