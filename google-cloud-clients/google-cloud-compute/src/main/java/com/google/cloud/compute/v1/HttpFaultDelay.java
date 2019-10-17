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
/**
 * Specifies the delay introduced by Loadbalancer before forwarding the request to the backend
 * service as part of fault injection.
 */
public final class HttpFaultDelay implements ApiMessage {
  private final Duration fixedDelay;
  private final Double percentage;

  private HttpFaultDelay() {
    this.fixedDelay = null;
    this.percentage = null;
  }

  private HttpFaultDelay(Duration fixedDelay, Double percentage) {
    this.fixedDelay = fixedDelay;
    this.percentage = percentage;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fixedDelay".equals(fieldName)) {
      return fixedDelay;
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

  /** Specifies the value of the fixed delay interval. */
  public Duration getFixedDelay() {
    return fixedDelay;
  }

  /**
   * The percentage of traffic (connections/operations/requests) on which delay will be introduced
   * as part of fault injection. The value must be between 0.0 and 100.0 inclusive.
   */
  public Double getPercentage() {
    return percentage;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpFaultDelay prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpFaultDelay getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpFaultDelay DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpFaultDelay();
  }

  public static class Builder {
    private Duration fixedDelay;
    private Double percentage;

    Builder() {}

    public Builder mergeFrom(HttpFaultDelay other) {
      if (other == HttpFaultDelay.getDefaultInstance()) return this;
      if (other.getFixedDelay() != null) {
        this.fixedDelay = other.fixedDelay;
      }
      if (other.getPercentage() != null) {
        this.percentage = other.percentage;
      }
      return this;
    }

    Builder(HttpFaultDelay source) {
      this.fixedDelay = source.fixedDelay;
      this.percentage = source.percentage;
    }

    /** Specifies the value of the fixed delay interval. */
    public Duration getFixedDelay() {
      return fixedDelay;
    }

    /** Specifies the value of the fixed delay interval. */
    public Builder setFixedDelay(Duration fixedDelay) {
      this.fixedDelay = fixedDelay;
      return this;
    }

    /**
     * The percentage of traffic (connections/operations/requests) on which delay will be introduced
     * as part of fault injection. The value must be between 0.0 and 100.0 inclusive.
     */
    public Double getPercentage() {
      return percentage;
    }

    /**
     * The percentage of traffic (connections/operations/requests) on which delay will be introduced
     * as part of fault injection. The value must be between 0.0 and 100.0 inclusive.
     */
    public Builder setPercentage(Double percentage) {
      this.percentage = percentage;
      return this;
    }

    public HttpFaultDelay build() {

      return new HttpFaultDelay(fixedDelay, percentage);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFixedDelay(this.fixedDelay);
      newBuilder.setPercentage(this.percentage);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpFaultDelay{" + "fixedDelay=" + fixedDelay + ", " + "percentage=" + percentage + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpFaultDelay) {
      HttpFaultDelay that = (HttpFaultDelay) o;
      return Objects.equals(this.fixedDelay, that.getFixedDelay())
          && Objects.equals(this.percentage, that.getPercentage());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fixedDelay, percentage);
  }
}
