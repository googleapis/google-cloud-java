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
 * Configuration for an App Engine network endpoint group (NEG). The service is optional, may be
 * provided explicitly or in the URL mask. The version is optional and can only be provided
 * explicitly or in the URL mask when service is present.
 *
 * <p>Note: App Engine service must be in the same project and located in the same region as the
 * Serverless NEG.
 */
public final class NetworkEndpointGroupAppEngine implements ApiMessage {
  private final String service;
  private final String urlMask;
  private final String version;

  private NetworkEndpointGroupAppEngine() {
    this.service = null;
    this.urlMask = null;
    this.version = null;
  }

  private NetworkEndpointGroupAppEngine(String service, String urlMask, String version) {
    this.service = service;
    this.urlMask = urlMask;
    this.version = version;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("service".equals(fieldName)) {
      return service;
    }
    if ("urlMask".equals(fieldName)) {
      return urlMask;
    }
    if ("version".equals(fieldName)) {
      return version;
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
   * Optional serving service.
   *
   * <p>The service name must be 1-63 characters long, and comply with RFC1035.
   *
   * <p>Example value: "default", "my-service".
   */
  public String getService() {
    return service;
  }

  /**
   * A template to parse service and version fields from a request URL. URL mask allows for routing
   * to multiple App Engine services without having to create multiple Network Endpoint Groups and
   * backend services.
   *
   * <p>For example, the request URLs "foo1-dot-appname.appspot.com/v1" and
   * "foo1-dot-appname.appspot.com/v2" can be backed by the same Serverless NEG with URL mask
   * "-dot-appname.appspot.com/". The URL mask will parse them to { service = "foo1", version = "v1"
   * } and { service = "foo1", version = "v2" } respectively.
   */
  public String getUrlMask() {
    return urlMask;
  }

  /**
   * Optional serving version.
   *
   * <p>The version must be 1-63 characters long, and comply with RFC1035.
   *
   * <p>Example value: "v1", "v2".
   */
  public String getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupAppEngine prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupAppEngine getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupAppEngine DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupAppEngine();
  }

  public static class Builder {
    private String service;
    private String urlMask;
    private String version;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupAppEngine other) {
      if (other == NetworkEndpointGroupAppEngine.getDefaultInstance()) return this;
      if (other.getService() != null) {
        this.service = other.service;
      }
      if (other.getUrlMask() != null) {
        this.urlMask = other.urlMask;
      }
      if (other.getVersion() != null) {
        this.version = other.version;
      }
      return this;
    }

    Builder(NetworkEndpointGroupAppEngine source) {
      this.service = source.service;
      this.urlMask = source.urlMask;
      this.version = source.version;
    }

    /**
     * Optional serving service.
     *
     * <p>The service name must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "default", "my-service".
     */
    public String getService() {
      return service;
    }

    /**
     * Optional serving service.
     *
     * <p>The service name must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "default", "my-service".
     */
    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    /**
     * A template to parse service and version fields from a request URL. URL mask allows for
     * routing to multiple App Engine services without having to create multiple Network Endpoint
     * Groups and backend services.
     *
     * <p>For example, the request URLs "foo1-dot-appname.appspot.com/v1" and
     * "foo1-dot-appname.appspot.com/v2" can be backed by the same Serverless NEG with URL mask
     * "-dot-appname.appspot.com/". The URL mask will parse them to { service = "foo1", version =
     * "v1" } and { service = "foo1", version = "v2" } respectively.
     */
    public String getUrlMask() {
      return urlMask;
    }

    /**
     * A template to parse service and version fields from a request URL. URL mask allows for
     * routing to multiple App Engine services without having to create multiple Network Endpoint
     * Groups and backend services.
     *
     * <p>For example, the request URLs "foo1-dot-appname.appspot.com/v1" and
     * "foo1-dot-appname.appspot.com/v2" can be backed by the same Serverless NEG with URL mask
     * "-dot-appname.appspot.com/". The URL mask will parse them to { service = "foo1", version =
     * "v1" } and { service = "foo1", version = "v2" } respectively.
     */
    public Builder setUrlMask(String urlMask) {
      this.urlMask = urlMask;
      return this;
    }

    /**
     * Optional serving version.
     *
     * <p>The version must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "v1", "v2".
     */
    public String getVersion() {
      return version;
    }

    /**
     * Optional serving version.
     *
     * <p>The version must be 1-63 characters long, and comply with RFC1035.
     *
     * <p>Example value: "v1", "v2".
     */
    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    public NetworkEndpointGroupAppEngine build() {

      return new NetworkEndpointGroupAppEngine(service, urlMask, version);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setService(this.service);
      newBuilder.setUrlMask(this.urlMask);
      newBuilder.setVersion(this.version);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupAppEngine{"
        + "service="
        + service
        + ", "
        + "urlMask="
        + urlMask
        + ", "
        + "version="
        + version
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroupAppEngine) {
      NetworkEndpointGroupAppEngine that = (NetworkEndpointGroupAppEngine) o;
      return Objects.equals(this.service, that.getService())
          && Objects.equals(this.urlMask, that.getUrlMask())
          && Objects.equals(this.version, that.getVersion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, urlMask, version);
  }
}
