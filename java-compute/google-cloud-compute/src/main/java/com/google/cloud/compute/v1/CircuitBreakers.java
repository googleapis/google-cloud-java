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
/** Settings controlling the volume of connections to a backend service. */
public final class CircuitBreakers implements ApiMessage {
  private final Integer maxConnections;
  private final Integer maxPendingRequests;
  private final Integer maxRequests;
  private final Integer maxRequestsPerConnection;
  private final Integer maxRetries;

  private CircuitBreakers() {
    this.maxConnections = null;
    this.maxPendingRequests = null;
    this.maxRequests = null;
    this.maxRequestsPerConnection = null;
    this.maxRetries = null;
  }

  private CircuitBreakers(
      Integer maxConnections,
      Integer maxPendingRequests,
      Integer maxRequests,
      Integer maxRequestsPerConnection,
      Integer maxRetries) {
    this.maxConnections = maxConnections;
    this.maxPendingRequests = maxPendingRequests;
    this.maxRequests = maxRequests;
    this.maxRequestsPerConnection = maxRequestsPerConnection;
    this.maxRetries = maxRetries;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("maxConnections".equals(fieldName)) {
      return maxConnections;
    }
    if ("maxPendingRequests".equals(fieldName)) {
      return maxPendingRequests;
    }
    if ("maxRequests".equals(fieldName)) {
      return maxRequests;
    }
    if ("maxRequestsPerConnection".equals(fieldName)) {
      return maxRequestsPerConnection;
    }
    if ("maxRetries".equals(fieldName)) {
      return maxRetries;
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
   * The maximum number of connections to the backend cluster. If not specified, the default is
   * 1024.
   */
  public Integer getMaxConnections() {
    return maxConnections;
  }

  /**
   * The maximum number of pending requests allowed to the backend cluster. If not specified, the
   * default is 1024.
   */
  public Integer getMaxPendingRequests() {
    return maxPendingRequests;
  }

  /**
   * The maximum number of parallel requests that allowed to the backend cluster. If not specified,
   * the default is 1024.
   */
  public Integer getMaxRequests() {
    return maxRequests;
  }

  /**
   * Maximum requests for a single backend connection. This parameter is respected by both the
   * HTTP/1.1 and HTTP/2 implementations. If not specified, there is no limit. Setting this
   * parameter to 1 will effectively disable keep alive.
   */
  public Integer getMaxRequestsPerConnection() {
    return maxRequestsPerConnection;
  }

  /**
   * The maximum number of parallel retries allowed to the backend cluster. If not specified, the
   * default is 3.
   */
  public Integer getMaxRetries() {
    return maxRetries;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(CircuitBreakers prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static CircuitBreakers getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final CircuitBreakers DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new CircuitBreakers();
  }

  public static class Builder {
    private Integer maxConnections;
    private Integer maxPendingRequests;
    private Integer maxRequests;
    private Integer maxRequestsPerConnection;
    private Integer maxRetries;

    Builder() {}

    public Builder mergeFrom(CircuitBreakers other) {
      if (other == CircuitBreakers.getDefaultInstance()) return this;
      if (other.getMaxConnections() != null) {
        this.maxConnections = other.maxConnections;
      }
      if (other.getMaxPendingRequests() != null) {
        this.maxPendingRequests = other.maxPendingRequests;
      }
      if (other.getMaxRequests() != null) {
        this.maxRequests = other.maxRequests;
      }
      if (other.getMaxRequestsPerConnection() != null) {
        this.maxRequestsPerConnection = other.maxRequestsPerConnection;
      }
      if (other.getMaxRetries() != null) {
        this.maxRetries = other.maxRetries;
      }
      return this;
    }

    Builder(CircuitBreakers source) {
      this.maxConnections = source.maxConnections;
      this.maxPendingRequests = source.maxPendingRequests;
      this.maxRequests = source.maxRequests;
      this.maxRequestsPerConnection = source.maxRequestsPerConnection;
      this.maxRetries = source.maxRetries;
    }

    /**
     * The maximum number of connections to the backend cluster. If not specified, the default is
     * 1024.
     */
    public Integer getMaxConnections() {
      return maxConnections;
    }

    /**
     * The maximum number of connections to the backend cluster. If not specified, the default is
     * 1024.
     */
    public Builder setMaxConnections(Integer maxConnections) {
      this.maxConnections = maxConnections;
      return this;
    }

    /**
     * The maximum number of pending requests allowed to the backend cluster. If not specified, the
     * default is 1024.
     */
    public Integer getMaxPendingRequests() {
      return maxPendingRequests;
    }

    /**
     * The maximum number of pending requests allowed to the backend cluster. If not specified, the
     * default is 1024.
     */
    public Builder setMaxPendingRequests(Integer maxPendingRequests) {
      this.maxPendingRequests = maxPendingRequests;
      return this;
    }

    /**
     * The maximum number of parallel requests that allowed to the backend cluster. If not
     * specified, the default is 1024.
     */
    public Integer getMaxRequests() {
      return maxRequests;
    }

    /**
     * The maximum number of parallel requests that allowed to the backend cluster. If not
     * specified, the default is 1024.
     */
    public Builder setMaxRequests(Integer maxRequests) {
      this.maxRequests = maxRequests;
      return this;
    }

    /**
     * Maximum requests for a single backend connection. This parameter is respected by both the
     * HTTP/1.1 and HTTP/2 implementations. If not specified, there is no limit. Setting this
     * parameter to 1 will effectively disable keep alive.
     */
    public Integer getMaxRequestsPerConnection() {
      return maxRequestsPerConnection;
    }

    /**
     * Maximum requests for a single backend connection. This parameter is respected by both the
     * HTTP/1.1 and HTTP/2 implementations. If not specified, there is no limit. Setting this
     * parameter to 1 will effectively disable keep alive.
     */
    public Builder setMaxRequestsPerConnection(Integer maxRequestsPerConnection) {
      this.maxRequestsPerConnection = maxRequestsPerConnection;
      return this;
    }

    /**
     * The maximum number of parallel retries allowed to the backend cluster. If not specified, the
     * default is 3.
     */
    public Integer getMaxRetries() {
      return maxRetries;
    }

    /**
     * The maximum number of parallel retries allowed to the backend cluster. If not specified, the
     * default is 3.
     */
    public Builder setMaxRetries(Integer maxRetries) {
      this.maxRetries = maxRetries;
      return this;
    }

    public CircuitBreakers build() {

      return new CircuitBreakers(
          maxConnections, maxPendingRequests, maxRequests, maxRequestsPerConnection, maxRetries);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMaxConnections(this.maxConnections);
      newBuilder.setMaxPendingRequests(this.maxPendingRequests);
      newBuilder.setMaxRequests(this.maxRequests);
      newBuilder.setMaxRequestsPerConnection(this.maxRequestsPerConnection);
      newBuilder.setMaxRetries(this.maxRetries);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "CircuitBreakers{"
        + "maxConnections="
        + maxConnections
        + ", "
        + "maxPendingRequests="
        + maxPendingRequests
        + ", "
        + "maxRequests="
        + maxRequests
        + ", "
        + "maxRequestsPerConnection="
        + maxRequestsPerConnection
        + ", "
        + "maxRetries="
        + maxRetries
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CircuitBreakers) {
      CircuitBreakers that = (CircuitBreakers) o;
      return Objects.equals(this.maxConnections, that.getMaxConnections())
          && Objects.equals(this.maxPendingRequests, that.getMaxPendingRequests())
          && Objects.equals(this.maxRequests, that.getMaxRequests())
          && Objects.equals(this.maxRequestsPerConnection, that.getMaxRequestsPerConnection())
          && Objects.equals(this.maxRetries, that.getMaxRetries());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        maxConnections, maxPendingRequests, maxRequests, maxRequestsPerConnection, maxRetries);
  }
}
