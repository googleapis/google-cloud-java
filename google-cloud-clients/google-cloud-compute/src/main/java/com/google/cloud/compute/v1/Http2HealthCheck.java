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
public final class Http2HealthCheck implements ApiMessage {
  private final String host;
  private final Integer port;
  private final String portName;
  private final String proxyHeader;
  private final String requestPath;
  private final String response;

  private Http2HealthCheck() {
    this.host = null;
    this.port = null;
    this.portName = null;
    this.proxyHeader = null;
    this.requestPath = null;
    this.response = null;
  }

  private Http2HealthCheck(
      String host,
      Integer port,
      String portName,
      String proxyHeader,
      String requestPath,
      String response) {
    this.host = host;
    this.port = port;
    this.portName = portName;
    this.proxyHeader = proxyHeader;
    this.requestPath = requestPath;
    this.response = response;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("host".equals(fieldName)) {
      return host;
    }
    if ("port".equals(fieldName)) {
      return port;
    }
    if ("portName".equals(fieldName)) {
      return portName;
    }
    if ("proxyHeader".equals(fieldName)) {
      return proxyHeader;
    }
    if ("requestPath".equals(fieldName)) {
      return requestPath;
    }
    if ("response".equals(fieldName)) {
      return response;
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
   * The value of the host header in the HTTP/2 health check request. If left empty (default value),
   * the IP on behalf of which this health check is performed will be used.
   */
  public String getHost() {
    return host;
  }

  /**
   * The TCP port number for the health check request. The default value is 443. Valid values are 1
   * through 65535.
   */
  public Integer getPort() {
    return port;
  }

  /**
   * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
   * port takes precedence.
   */
  public String getPortName() {
    return portName;
  }

  /**
   * Specifies the type of proxy header to append before sending data to the backend, either NONE or
   * PROXY_V1. The default is NONE.
   */
  public String getProxyHeader() {
    return proxyHeader;
  }

  /** The request path of the HTTP/2 health check request. The default value is /. */
  public String getRequestPath() {
    return requestPath;
  }

  /**
   * The string to match anywhere in the first 1024 bytes of the response body. If left empty (the
   * default value), the status code determines health. The response data can only be ASCII.
   */
  public String getResponse() {
    return response;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Http2HealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Http2HealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Http2HealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Http2HealthCheck();
  }

  public static class Builder {
    private String host;
    private Integer port;
    private String portName;
    private String proxyHeader;
    private String requestPath;
    private String response;

    Builder() {}

    public Builder mergeFrom(Http2HealthCheck other) {
      if (other == Http2HealthCheck.getDefaultInstance()) return this;
      if (other.getHost() != null) {
        this.host = other.host;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      if (other.getPortName() != null) {
        this.portName = other.portName;
      }
      if (other.getProxyHeader() != null) {
        this.proxyHeader = other.proxyHeader;
      }
      if (other.getRequestPath() != null) {
        this.requestPath = other.requestPath;
      }
      if (other.getResponse() != null) {
        this.response = other.response;
      }
      return this;
    }

    Builder(Http2HealthCheck source) {
      this.host = source.host;
      this.port = source.port;
      this.portName = source.portName;
      this.proxyHeader = source.proxyHeader;
      this.requestPath = source.requestPath;
      this.response = source.response;
    }

    /**
     * The value of the host header in the HTTP/2 health check request. If left empty (default
     * value), the IP on behalf of which this health check is performed will be used.
     */
    public String getHost() {
      return host;
    }

    /**
     * The value of the host header in the HTTP/2 health check request. If left empty (default
     * value), the IP on behalf of which this health check is performed will be used.
     */
    public Builder setHost(String host) {
      this.host = host;
      return this;
    }

    /**
     * The TCP port number for the health check request. The default value is 443. Valid values are
     * 1 through 65535.
     */
    public Integer getPort() {
      return port;
    }

    /**
     * The TCP port number for the health check request. The default value is 443. Valid values are
     * 1 through 65535.
     */
    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    /**
     * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
     * port takes precedence.
     */
    public String getPortName() {
      return portName;
    }

    /**
     * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
     * port takes precedence.
     */
    public Builder setPortName(String portName) {
      this.portName = portName;
      return this;
    }

    /**
     * Specifies the type of proxy header to append before sending data to the backend, either NONE
     * or PROXY_V1. The default is NONE.
     */
    public String getProxyHeader() {
      return proxyHeader;
    }

    /**
     * Specifies the type of proxy header to append before sending data to the backend, either NONE
     * or PROXY_V1. The default is NONE.
     */
    public Builder setProxyHeader(String proxyHeader) {
      this.proxyHeader = proxyHeader;
      return this;
    }

    /** The request path of the HTTP/2 health check request. The default value is /. */
    public String getRequestPath() {
      return requestPath;
    }

    /** The request path of the HTTP/2 health check request. The default value is /. */
    public Builder setRequestPath(String requestPath) {
      this.requestPath = requestPath;
      return this;
    }

    /**
     * The string to match anywhere in the first 1024 bytes of the response body. If left empty (the
     * default value), the status code determines health. The response data can only be ASCII.
     */
    public String getResponse() {
      return response;
    }

    /**
     * The string to match anywhere in the first 1024 bytes of the response body. If left empty (the
     * default value), the status code determines health. The response data can only be ASCII.
     */
    public Builder setResponse(String response) {
      this.response = response;
      return this;
    }

    public Http2HealthCheck build() {

      return new Http2HealthCheck(host, port, portName, proxyHeader, requestPath, response);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHost(this.host);
      newBuilder.setPort(this.port);
      newBuilder.setPortName(this.portName);
      newBuilder.setProxyHeader(this.proxyHeader);
      newBuilder.setRequestPath(this.requestPath);
      newBuilder.setResponse(this.response);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Http2HealthCheck{"
        + "host="
        + host
        + ", "
        + "port="
        + port
        + ", "
        + "portName="
        + portName
        + ", "
        + "proxyHeader="
        + proxyHeader
        + ", "
        + "requestPath="
        + requestPath
        + ", "
        + "response="
        + response
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Http2HealthCheck) {
      Http2HealthCheck that = (Http2HealthCheck) o;
      return Objects.equals(this.host, that.getHost())
          && Objects.equals(this.port, that.getPort())
          && Objects.equals(this.portName, that.getPortName())
          && Objects.equals(this.proxyHeader, that.getProxyHeader())
          && Objects.equals(this.requestPath, that.getRequestPath())
          && Objects.equals(this.response, that.getResponse());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port, portName, proxyHeader, requestPath, response);
  }
}
