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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** The retry policy associates with HttpRouteRule */
public final class HttpRetryPolicy implements ApiMessage {
  private final Integer numRetries;
  private final Duration perTryTimeout;
  private final List<String> retryConditions;

  private HttpRetryPolicy() {
    this.numRetries = null;
    this.perTryTimeout = null;
    this.retryConditions = null;
  }

  private HttpRetryPolicy(
      Integer numRetries, Duration perTryTimeout, List<String> retryConditions) {
    this.numRetries = numRetries;
    this.perTryTimeout = perTryTimeout;
    this.retryConditions = retryConditions;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("numRetries".equals(fieldName)) {
      return numRetries;
    }
    if ("perTryTimeout".equals(fieldName)) {
      return perTryTimeout;
    }
    if ("retryConditions".equals(fieldName)) {
      return retryConditions;
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

  /** Specifies the allowed number retries. This number must be &gt; 0. */
  public Integer getNumRetries() {
    return numRetries;
  }

  /** Specifies a non-zero timeout per retry attempt. */
  public Duration getPerTryTimeout() {
    return perTryTimeout;
  }

  /**
   * Specfies one or more conditions when this retry rule applies. Valid values are: - 5xx:
   * Loadbalancer will attempt a retry if the backend service responds with any 5xx response code,
   * or if the backend service does not respond at all, example: disconnects, reset, read timeout,
   * connection failure, and refused streams. - gateway-error: Similar to 5xx, but only applies to
   * response codes 502, 503 or 504. - - connect-failure: Loadbalancer will retry on failures
   * connecting to backend services, for example due to connection timeouts. - retriable-4xx:
   * Loadbalancer will retry for retriable 4xx response codes. Currently the only retriable error
   * supported is 409. - refused-stream:Loadbalancer will retry if the backend service resets the
   * stream with a REFUSED_STREAM error code. This reset type indicates that it is safe to retry. -
   * cancelledLoadbalancer will retry if the gRPC status code in the response header is set to
   * cancelled - deadline-exceeded: Loadbalancer will retry if the gRPC status code in the response
   * header is set to deadline-exceeded - resource-exhausted: Loadbalancer will retry if the gRPC
   * status code in the response header is set to resource-exhausted - unavailable: Loadbalancer
   * will retry if the gRPC status code in the response header is set to unavailable
   */
  public List<String> getRetryConditionsList() {
    return retryConditions;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpRetryPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpRetryPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpRetryPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpRetryPolicy();
  }

  public static class Builder {
    private Integer numRetries;
    private Duration perTryTimeout;
    private List<String> retryConditions;

    Builder() {}

    public Builder mergeFrom(HttpRetryPolicy other) {
      if (other == HttpRetryPolicy.getDefaultInstance()) return this;
      if (other.getNumRetries() != null) {
        this.numRetries = other.numRetries;
      }
      if (other.getPerTryTimeout() != null) {
        this.perTryTimeout = other.perTryTimeout;
      }
      if (other.getRetryConditionsList() != null) {
        this.retryConditions = other.retryConditions;
      }
      return this;
    }

    Builder(HttpRetryPolicy source) {
      this.numRetries = source.numRetries;
      this.perTryTimeout = source.perTryTimeout;
      this.retryConditions = source.retryConditions;
    }

    /** Specifies the allowed number retries. This number must be &gt; 0. */
    public Integer getNumRetries() {
      return numRetries;
    }

    /** Specifies the allowed number retries. This number must be &gt; 0. */
    public Builder setNumRetries(Integer numRetries) {
      this.numRetries = numRetries;
      return this;
    }

    /** Specifies a non-zero timeout per retry attempt. */
    public Duration getPerTryTimeout() {
      return perTryTimeout;
    }

    /** Specifies a non-zero timeout per retry attempt. */
    public Builder setPerTryTimeout(Duration perTryTimeout) {
      this.perTryTimeout = perTryTimeout;
      return this;
    }

    /**
     * Specfies one or more conditions when this retry rule applies. Valid values are: - 5xx:
     * Loadbalancer will attempt a retry if the backend service responds with any 5xx response code,
     * or if the backend service does not respond at all, example: disconnects, reset, read timeout,
     * connection failure, and refused streams. - gateway-error: Similar to 5xx, but only applies to
     * response codes 502, 503 or 504. - - connect-failure: Loadbalancer will retry on failures
     * connecting to backend services, for example due to connection timeouts. - retriable-4xx:
     * Loadbalancer will retry for retriable 4xx response codes. Currently the only retriable error
     * supported is 409. - refused-stream:Loadbalancer will retry if the backend service resets the
     * stream with a REFUSED_STREAM error code. This reset type indicates that it is safe to retry.
     * - cancelledLoadbalancer will retry if the gRPC status code in the response header is set to
     * cancelled - deadline-exceeded: Loadbalancer will retry if the gRPC status code in the
     * response header is set to deadline-exceeded - resource-exhausted: Loadbalancer will retry if
     * the gRPC status code in the response header is set to resource-exhausted - unavailable:
     * Loadbalancer will retry if the gRPC status code in the response header is set to unavailable
     */
    public List<String> getRetryConditionsList() {
      return retryConditions;
    }

    /**
     * Specfies one or more conditions when this retry rule applies. Valid values are: - 5xx:
     * Loadbalancer will attempt a retry if the backend service responds with any 5xx response code,
     * or if the backend service does not respond at all, example: disconnects, reset, read timeout,
     * connection failure, and refused streams. - gateway-error: Similar to 5xx, but only applies to
     * response codes 502, 503 or 504. - - connect-failure: Loadbalancer will retry on failures
     * connecting to backend services, for example due to connection timeouts. - retriable-4xx:
     * Loadbalancer will retry for retriable 4xx response codes. Currently the only retriable error
     * supported is 409. - refused-stream:Loadbalancer will retry if the backend service resets the
     * stream with a REFUSED_STREAM error code. This reset type indicates that it is safe to retry.
     * - cancelledLoadbalancer will retry if the gRPC status code in the response header is set to
     * cancelled - deadline-exceeded: Loadbalancer will retry if the gRPC status code in the
     * response header is set to deadline-exceeded - resource-exhausted: Loadbalancer will retry if
     * the gRPC status code in the response header is set to resource-exhausted - unavailable:
     * Loadbalancer will retry if the gRPC status code in the response header is set to unavailable
     */
    public Builder addAllRetryConditions(List<String> retryConditions) {
      if (this.retryConditions == null) {
        this.retryConditions = new LinkedList<>();
      }
      this.retryConditions.addAll(retryConditions);
      return this;
    }

    /**
     * Specfies one or more conditions when this retry rule applies. Valid values are: - 5xx:
     * Loadbalancer will attempt a retry if the backend service responds with any 5xx response code,
     * or if the backend service does not respond at all, example: disconnects, reset, read timeout,
     * connection failure, and refused streams. - gateway-error: Similar to 5xx, but only applies to
     * response codes 502, 503 or 504. - - connect-failure: Loadbalancer will retry on failures
     * connecting to backend services, for example due to connection timeouts. - retriable-4xx:
     * Loadbalancer will retry for retriable 4xx response codes. Currently the only retriable error
     * supported is 409. - refused-stream:Loadbalancer will retry if the backend service resets the
     * stream with a REFUSED_STREAM error code. This reset type indicates that it is safe to retry.
     * - cancelledLoadbalancer will retry if the gRPC status code in the response header is set to
     * cancelled - deadline-exceeded: Loadbalancer will retry if the gRPC status code in the
     * response header is set to deadline-exceeded - resource-exhausted: Loadbalancer will retry if
     * the gRPC status code in the response header is set to resource-exhausted - unavailable:
     * Loadbalancer will retry if the gRPC status code in the response header is set to unavailable
     */
    public Builder addRetryConditions(String retryConditions) {
      if (this.retryConditions == null) {
        this.retryConditions = new LinkedList<>();
      }
      this.retryConditions.add(retryConditions);
      return this;
    }

    public HttpRetryPolicy build() {

      return new HttpRetryPolicy(numRetries, perTryTimeout, retryConditions);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setNumRetries(this.numRetries);
      newBuilder.setPerTryTimeout(this.perTryTimeout);
      newBuilder.addAllRetryConditions(this.retryConditions);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpRetryPolicy{"
        + "numRetries="
        + numRetries
        + ", "
        + "perTryTimeout="
        + perTryTimeout
        + ", "
        + "retryConditions="
        + retryConditions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpRetryPolicy) {
      HttpRetryPolicy that = (HttpRetryPolicy) o;
      return Objects.equals(this.numRetries, that.getNumRetries())
          && Objects.equals(this.perTryTimeout, that.getPerTryTimeout())
          && Objects.equals(this.retryConditions, that.getRetryConditionsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numRetries, perTryTimeout, retryConditions);
  }
}
