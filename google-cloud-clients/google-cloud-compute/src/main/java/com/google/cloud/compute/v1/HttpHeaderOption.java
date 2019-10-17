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
/** Specification determining how headers are added to requests or responses. */
public final class HttpHeaderOption implements ApiMessage {
  private final String headerName;
  private final String headerValue;
  private final Boolean replace;

  private HttpHeaderOption() {
    this.headerName = null;
    this.headerValue = null;
    this.replace = null;
  }

  private HttpHeaderOption(String headerName, String headerValue, Boolean replace) {
    this.headerName = headerName;
    this.headerValue = headerValue;
    this.replace = replace;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("headerName".equals(fieldName)) {
      return headerName;
    }
    if ("headerValue".equals(fieldName)) {
      return headerValue;
    }
    if ("replace".equals(fieldName)) {
      return replace;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** The name of the header. */
  public String getHeaderName() {
    return headerName;
  }

  /** The value of the header to add. */
  public String getHeaderValue() {
    return headerValue;
  }

  /**
   * If false, headerValue is appended to any values that already exist for the header. If true,
   * headerValue is set for the header, discarding any values that were set for that header. The
   * default value is false.
   */
  public Boolean getReplace() {
    return replace;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpHeaderOption prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpHeaderOption getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpHeaderOption DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpHeaderOption();
  }

  public static class Builder {
    private String headerName;
    private String headerValue;
    private Boolean replace;

    Builder() {}

    public Builder mergeFrom(HttpHeaderOption other) {
      if (other == HttpHeaderOption.getDefaultInstance()) return this;
      if (other.getHeaderName() != null) {
        this.headerName = other.headerName;
      }
      if (other.getHeaderValue() != null) {
        this.headerValue = other.headerValue;
      }
      if (other.getReplace() != null) {
        this.replace = other.replace;
      }
      return this;
    }

    Builder(HttpHeaderOption source) {
      this.headerName = source.headerName;
      this.headerValue = source.headerValue;
      this.replace = source.replace;
    }

    /** The name of the header. */
    public String getHeaderName() {
      return headerName;
    }

    /** The name of the header. */
    public Builder setHeaderName(String headerName) {
      this.headerName = headerName;
      return this;
    }

    /** The value of the header to add. */
    public String getHeaderValue() {
      return headerValue;
    }

    /** The value of the header to add. */
    public Builder setHeaderValue(String headerValue) {
      this.headerValue = headerValue;
      return this;
    }

    /**
     * If false, headerValue is appended to any values that already exist for the header. If true,
     * headerValue is set for the header, discarding any values that were set for that header. The
     * default value is false.
     */
    public Boolean getReplace() {
      return replace;
    }

    /**
     * If false, headerValue is appended to any values that already exist for the header. If true,
     * headerValue is set for the header, discarding any values that were set for that header. The
     * default value is false.
     */
    public Builder setReplace(Boolean replace) {
      this.replace = replace;
      return this;
    }

    public HttpHeaderOption build() {

      return new HttpHeaderOption(headerName, headerValue, replace);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHeaderName(this.headerName);
      newBuilder.setHeaderValue(this.headerValue);
      newBuilder.setReplace(this.replace);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpHeaderOption{"
        + "headerName="
        + headerName
        + ", "
        + "headerValue="
        + headerValue
        + ", "
        + "replace="
        + replace
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpHeaderOption) {
      HttpHeaderOption that = (HttpHeaderOption) o;
      return Objects.equals(this.headerName, that.getHeaderName())
          && Objects.equals(this.headerValue, that.getHeaderValue())
          && Objects.equals(this.replace, that.getReplace());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(headerName, headerValue, replace);
  }
}
