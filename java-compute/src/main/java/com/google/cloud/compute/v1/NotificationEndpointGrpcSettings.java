/*
 * Copyright 2020 Google LLC
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
 * Represents a gRPC setting that describes one gRPC notification endpoint and the retry duration
 * attempting to send notification to this endpoint.
 */
public final class NotificationEndpointGrpcSettings implements ApiMessage {
  private final String authority;
  private final String endpoint;
  private final String payloadName;
  private final Duration resendInterval;
  private final Integer retryDurationSec;

  private NotificationEndpointGrpcSettings() {
    this.authority = null;
    this.endpoint = null;
    this.payloadName = null;
    this.resendInterval = null;
    this.retryDurationSec = null;
  }

  private NotificationEndpointGrpcSettings(
      String authority,
      String endpoint,
      String payloadName,
      Duration resendInterval,
      Integer retryDurationSec) {
    this.authority = authority;
    this.endpoint = endpoint;
    this.payloadName = payloadName;
    this.resendInterval = resendInterval;
    this.retryDurationSec = retryDurationSec;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("authority".equals(fieldName)) {
      return authority;
    }
    if ("endpoint".equals(fieldName)) {
      return endpoint;
    }
    if ("payloadName".equals(fieldName)) {
      return payloadName;
    }
    if ("resendInterval".equals(fieldName)) {
      return resendInterval;
    }
    if ("retryDurationSec".equals(fieldName)) {
      return retryDurationSec;
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
   * Optional. If specified, this field is used to set the authority header by the sender of
   * notifications. See https://tools.ietf.org/html/rfc7540#section-8.1.2.3
   */
  public String getAuthority() {
    return authority;
  }

  /** Endpoint to which gRPC notifications are sent. This must be a valid gRPCLB DNS name. */
  public String getEndpoint() {
    return endpoint;
  }

  /** Optional. If specified, this field is used to populate the "name" field in gRPC requests. */
  public String getPayloadName() {
    return payloadName;
  }

  /**
   * Optional. This field is used to configure how often to send a full update of all non-healthy
   * backends. If unspecified, full updates are not sent. If specified, must be in the range between
   * 600 seconds to 3600 seconds. Nanos are disallowed.
   */
  public Duration getResendInterval() {
    return resendInterval;
  }

  /**
   * How much time (in seconds) is spent attempting notification retries until a successful response
   * is received. Default is 30s. Limit is 20m (1200s). Must be a positive number.
   */
  public Integer getRetryDurationSec() {
    return retryDurationSec;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NotificationEndpointGrpcSettings prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NotificationEndpointGrpcSettings getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NotificationEndpointGrpcSettings DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NotificationEndpointGrpcSettings();
  }

  public static class Builder {
    private String authority;
    private String endpoint;
    private String payloadName;
    private Duration resendInterval;
    private Integer retryDurationSec;

    Builder() {}

    public Builder mergeFrom(NotificationEndpointGrpcSettings other) {
      if (other == NotificationEndpointGrpcSettings.getDefaultInstance()) return this;
      if (other.getAuthority() != null) {
        this.authority = other.authority;
      }
      if (other.getEndpoint() != null) {
        this.endpoint = other.endpoint;
      }
      if (other.getPayloadName() != null) {
        this.payloadName = other.payloadName;
      }
      if (other.getResendInterval() != null) {
        this.resendInterval = other.resendInterval;
      }
      if (other.getRetryDurationSec() != null) {
        this.retryDurationSec = other.retryDurationSec;
      }
      return this;
    }

    Builder(NotificationEndpointGrpcSettings source) {
      this.authority = source.authority;
      this.endpoint = source.endpoint;
      this.payloadName = source.payloadName;
      this.resendInterval = source.resendInterval;
      this.retryDurationSec = source.retryDurationSec;
    }

    /**
     * Optional. If specified, this field is used to set the authority header by the sender of
     * notifications. See https://tools.ietf.org/html/rfc7540#section-8.1.2.3
     */
    public String getAuthority() {
      return authority;
    }

    /**
     * Optional. If specified, this field is used to set the authority header by the sender of
     * notifications. See https://tools.ietf.org/html/rfc7540#section-8.1.2.3
     */
    public Builder setAuthority(String authority) {
      this.authority = authority;
      return this;
    }

    /** Endpoint to which gRPC notifications are sent. This must be a valid gRPCLB DNS name. */
    public String getEndpoint() {
      return endpoint;
    }

    /** Endpoint to which gRPC notifications are sent. This must be a valid gRPCLB DNS name. */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /** Optional. If specified, this field is used to populate the "name" field in gRPC requests. */
    public String getPayloadName() {
      return payloadName;
    }

    /** Optional. If specified, this field is used to populate the "name" field in gRPC requests. */
    public Builder setPayloadName(String payloadName) {
      this.payloadName = payloadName;
      return this;
    }

    /**
     * Optional. This field is used to configure how often to send a full update of all non-healthy
     * backends. If unspecified, full updates are not sent. If specified, must be in the range
     * between 600 seconds to 3600 seconds. Nanos are disallowed.
     */
    public Duration getResendInterval() {
      return resendInterval;
    }

    /**
     * Optional. This field is used to configure how often to send a full update of all non-healthy
     * backends. If unspecified, full updates are not sent. If specified, must be in the range
     * between 600 seconds to 3600 seconds. Nanos are disallowed.
     */
    public Builder setResendInterval(Duration resendInterval) {
      this.resendInterval = resendInterval;
      return this;
    }

    /**
     * How much time (in seconds) is spent attempting notification retries until a successful
     * response is received. Default is 30s. Limit is 20m (1200s). Must be a positive number.
     */
    public Integer getRetryDurationSec() {
      return retryDurationSec;
    }

    /**
     * How much time (in seconds) is spent attempting notification retries until a successful
     * response is received. Default is 30s. Limit is 20m (1200s). Must be a positive number.
     */
    public Builder setRetryDurationSec(Integer retryDurationSec) {
      this.retryDurationSec = retryDurationSec;
      return this;
    }

    public NotificationEndpointGrpcSettings build() {

      return new NotificationEndpointGrpcSettings(
          authority, endpoint, payloadName, resendInterval, retryDurationSec);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAuthority(this.authority);
      newBuilder.setEndpoint(this.endpoint);
      newBuilder.setPayloadName(this.payloadName);
      newBuilder.setResendInterval(this.resendInterval);
      newBuilder.setRetryDurationSec(this.retryDurationSec);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NotificationEndpointGrpcSettings{"
        + "authority="
        + authority
        + ", "
        + "endpoint="
        + endpoint
        + ", "
        + "payloadName="
        + payloadName
        + ", "
        + "resendInterval="
        + resendInterval
        + ", "
        + "retryDurationSec="
        + retryDurationSec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NotificationEndpointGrpcSettings) {
      NotificationEndpointGrpcSettings that = (NotificationEndpointGrpcSettings) o;
      return Objects.equals(this.authority, that.getAuthority())
          && Objects.equals(this.endpoint, that.getEndpoint())
          && Objects.equals(this.payloadName, that.getPayloadName())
          && Objects.equals(this.resendInterval, that.getResendInterval())
          && Objects.equals(this.retryDurationSec, that.getRetryDurationSec());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(authority, endpoint, payloadName, resendInterval, retryDurationSec);
  }
}
