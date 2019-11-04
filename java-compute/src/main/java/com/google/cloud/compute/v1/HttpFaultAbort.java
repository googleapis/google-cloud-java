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
/** Specification for how requests are aborted as part of fault injection. */
public final class HttpFaultAbort implements ApiMessage {
  private final Integer httpStatus;
  private final Double percentage;

  private HttpFaultAbort() {
    this.httpStatus = null;
    this.percentage = null;
  }

  private HttpFaultAbort(Integer httpStatus, Double percentage) {
    this.httpStatus = httpStatus;
    this.percentage = percentage;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("httpStatus".equals(fieldName)) {
      return httpStatus;
    }
    if ("percentage".equals(fieldName)) {
      return percentage;
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

  /**
   * The HTTP status code used to abort the request. The value must be between 200 and 599
   * inclusive.
   */
  public Integer getHttpStatus() {
    return httpStatus;
  }

  /**
   * The percentage of traffic (connections/operations/requests) which will be aborted as part of
   * fault injection. The value must be between 0.0 and 100.0 inclusive.
   */
  public Double getPercentage() {
    return percentage;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpFaultAbort prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpFaultAbort getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpFaultAbort DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpFaultAbort();
  }

  public static class Builder {
    private Integer httpStatus;
    private Double percentage;

    Builder() {}

    public Builder mergeFrom(HttpFaultAbort other) {
      if (other == HttpFaultAbort.getDefaultInstance()) return this;
      if (other.getHttpStatus() != null) {
        this.httpStatus = other.httpStatus;
      }
      if (other.getPercentage() != null) {
        this.percentage = other.percentage;
      }
      return this;
    }

    Builder(HttpFaultAbort source) {
      this.httpStatus = source.httpStatus;
      this.percentage = source.percentage;
    }

    /**
     * The HTTP status code used to abort the request. The value must be between 200 and 599
     * inclusive.
     */
    public Integer getHttpStatus() {
      return httpStatus;
    }

    /**
     * The HTTP status code used to abort the request. The value must be between 200 and 599
     * inclusive.
     */
    public Builder setHttpStatus(Integer httpStatus) {
      this.httpStatus = httpStatus;
      return this;
    }

    /**
     * The percentage of traffic (connections/operations/requests) which will be aborted as part of
     * fault injection. The value must be between 0.0 and 100.0 inclusive.
     */
    public Double getPercentage() {
      return percentage;
    }

    /**
     * The percentage of traffic (connections/operations/requests) which will be aborted as part of
     * fault injection. The value must be between 0.0 and 100.0 inclusive.
     */
    public Builder setPercentage(Double percentage) {
      this.percentage = percentage;
      return this;
    }

    public HttpFaultAbort build() {

      return new HttpFaultAbort(httpStatus, percentage);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHttpStatus(this.httpStatus);
      newBuilder.setPercentage(this.percentage);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpFaultAbort{" + "httpStatus=" + httpStatus + ", " + "percentage=" + percentage + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpFaultAbort) {
      HttpFaultAbort that = (HttpFaultAbort) o;
      return Objects.equals(this.httpStatus, that.getHttpStatus())
          && Objects.equals(this.percentage, that.getPercentage());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatus, percentage);
  }
}
