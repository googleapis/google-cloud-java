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
public final class UrlMapsValidateResponse implements ApiMessage {
  private final UrlMapValidationResult result;

  private UrlMapsValidateResponse() {
    this.result = null;
  }

  private UrlMapsValidateResponse(UrlMapValidationResult result) {
    this.result = result;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("result".equals(fieldName)) {
      return result;
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

  public UrlMapValidationResult getResult() {
    return result;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapsValidateResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapsValidateResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapsValidateResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapsValidateResponse();
  }

  public static class Builder {
    private UrlMapValidationResult result;

    Builder() {}

    public Builder mergeFrom(UrlMapsValidateResponse other) {
      if (other == UrlMapsValidateResponse.getDefaultInstance()) return this;
      if (other.getResult() != null) {
        this.result = other.result;
      }
      return this;
    }

    Builder(UrlMapsValidateResponse source) {
      this.result = source.result;
    }

    public UrlMapValidationResult getResult() {
      return result;
    }

    public Builder setResult(UrlMapValidationResult result) {
      this.result = result;
      return this;
    }

    public UrlMapsValidateResponse build() {
      return new UrlMapsValidateResponse(result);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setResult(this.result);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapsValidateResponse{" + "result=" + result + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapsValidateResponse) {
      UrlMapsValidateResponse that = (UrlMapsValidateResponse) o;
      return Objects.equals(this.result, that.getResult());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}
