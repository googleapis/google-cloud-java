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
/** This message defines settings for a consistent hash style load balancer. */
public final class ConsistentHashLoadBalancerSettings implements ApiMessage {
  private final ConsistentHashLoadBalancerSettingsHttpCookie httpCookie;
  private final String httpHeaderName;
  private final String minimumRingSize;

  private ConsistentHashLoadBalancerSettings() {
    this.httpCookie = null;
    this.httpHeaderName = null;
    this.minimumRingSize = null;
  }

  private ConsistentHashLoadBalancerSettings(
      ConsistentHashLoadBalancerSettingsHttpCookie httpCookie,
      String httpHeaderName,
      String minimumRingSize) {
    this.httpCookie = httpCookie;
    this.httpHeaderName = httpHeaderName;
    this.minimumRingSize = minimumRingSize;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("httpCookie".equals(fieldName)) {
      return httpCookie;
    }
    if ("httpHeaderName".equals(fieldName)) {
      return httpHeaderName;
    }
    if ("minimumRingSize".equals(fieldName)) {
      return minimumRingSize;
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
   * Hash is based on HTTP Cookie. This field describes a HTTP cookie that will be used as the hash
   * key for the consistent hash load balancer. If the cookie is not present, it will be generated.
   * This field is applicable if the sessionAffinity is set to HTTP_COOKIE.
   */
  public ConsistentHashLoadBalancerSettingsHttpCookie getHttpCookie() {
    return httpCookie;
  }

  /**
   * The hash based on the value of the specified header field. This field is applicable if the
   * sessionAffinity is set to HEADER_FIELD.
   */
  public String getHttpHeaderName() {
    return httpHeaderName;
  }

  /**
   * The minimum number of virtual nodes to use for the hash ring. Defaults to 1024. Larger ring
   * sizes result in more granular load distributions. If the number of hosts in the load balancing
   * pool is larger than the ring size, each host will be assigned a single virtual node.
   */
  public String getMinimumRingSize() {
    return minimumRingSize;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ConsistentHashLoadBalancerSettings prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ConsistentHashLoadBalancerSettings getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ConsistentHashLoadBalancerSettings DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ConsistentHashLoadBalancerSettings();
  }

  public static class Builder {
    private ConsistentHashLoadBalancerSettingsHttpCookie httpCookie;
    private String httpHeaderName;
    private String minimumRingSize;

    Builder() {}

    public Builder mergeFrom(ConsistentHashLoadBalancerSettings other) {
      if (other == ConsistentHashLoadBalancerSettings.getDefaultInstance()) return this;
      if (other.getHttpCookie() != null) {
        this.httpCookie = other.httpCookie;
      }
      if (other.getHttpHeaderName() != null) {
        this.httpHeaderName = other.httpHeaderName;
      }
      if (other.getMinimumRingSize() != null) {
        this.minimumRingSize = other.minimumRingSize;
      }
      return this;
    }

    Builder(ConsistentHashLoadBalancerSettings source) {
      this.httpCookie = source.httpCookie;
      this.httpHeaderName = source.httpHeaderName;
      this.minimumRingSize = source.minimumRingSize;
    }

    /**
     * Hash is based on HTTP Cookie. This field describes a HTTP cookie that will be used as the
     * hash key for the consistent hash load balancer. If the cookie is not present, it will be
     * generated. This field is applicable if the sessionAffinity is set to HTTP_COOKIE.
     */
    public ConsistentHashLoadBalancerSettingsHttpCookie getHttpCookie() {
      return httpCookie;
    }

    /**
     * Hash is based on HTTP Cookie. This field describes a HTTP cookie that will be used as the
     * hash key for the consistent hash load balancer. If the cookie is not present, it will be
     * generated. This field is applicable if the sessionAffinity is set to HTTP_COOKIE.
     */
    public Builder setHttpCookie(ConsistentHashLoadBalancerSettingsHttpCookie httpCookie) {
      this.httpCookie = httpCookie;
      return this;
    }

    /**
     * The hash based on the value of the specified header field. This field is applicable if the
     * sessionAffinity is set to HEADER_FIELD.
     */
    public String getHttpHeaderName() {
      return httpHeaderName;
    }

    /**
     * The hash based on the value of the specified header field. This field is applicable if the
     * sessionAffinity is set to HEADER_FIELD.
     */
    public Builder setHttpHeaderName(String httpHeaderName) {
      this.httpHeaderName = httpHeaderName;
      return this;
    }

    /**
     * The minimum number of virtual nodes to use for the hash ring. Defaults to 1024. Larger ring
     * sizes result in more granular load distributions. If the number of hosts in the load
     * balancing pool is larger than the ring size, each host will be assigned a single virtual
     * node.
     */
    public String getMinimumRingSize() {
      return minimumRingSize;
    }

    /**
     * The minimum number of virtual nodes to use for the hash ring. Defaults to 1024. Larger ring
     * sizes result in more granular load distributions. If the number of hosts in the load
     * balancing pool is larger than the ring size, each host will be assigned a single virtual
     * node.
     */
    public Builder setMinimumRingSize(String minimumRingSize) {
      this.minimumRingSize = minimumRingSize;
      return this;
    }

    public ConsistentHashLoadBalancerSettings build() {

      return new ConsistentHashLoadBalancerSettings(httpCookie, httpHeaderName, minimumRingSize);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHttpCookie(this.httpCookie);
      newBuilder.setHttpHeaderName(this.httpHeaderName);
      newBuilder.setMinimumRingSize(this.minimumRingSize);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ConsistentHashLoadBalancerSettings{"
        + "httpCookie="
        + httpCookie
        + ", "
        + "httpHeaderName="
        + httpHeaderName
        + ", "
        + "minimumRingSize="
        + minimumRingSize
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ConsistentHashLoadBalancerSettings) {
      ConsistentHashLoadBalancerSettings that = (ConsistentHashLoadBalancerSettings) o;
      return Objects.equals(this.httpCookie, that.getHttpCookie())
          && Objects.equals(this.httpHeaderName, that.getHttpHeaderName())
          && Objects.equals(this.minimumRingSize, that.getMinimumRingSize());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpCookie, httpHeaderName, minimumRingSize);
  }
}
