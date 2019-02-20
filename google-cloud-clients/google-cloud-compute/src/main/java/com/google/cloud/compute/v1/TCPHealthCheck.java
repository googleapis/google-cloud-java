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
public final class TCPHealthCheck implements ApiMessage {
  private final Integer port;
  private final String portName;
  private final String proxyHeader;
  private final String request;
  private final String response;

  private TCPHealthCheck() {
    this.port = null;
    this.portName = null;
    this.proxyHeader = null;
    this.request = null;
    this.response = null;
  }

  private TCPHealthCheck(
      Integer port, String portName, String proxyHeader, String request, String response) {
    this.port = port;
    this.portName = portName;
    this.proxyHeader = proxyHeader;
    this.request = request;
    this.response = response;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("port".equals(fieldName)) {
      return port;
    }
    if ("portName".equals(fieldName)) {
      return portName;
    }
    if ("proxyHeader".equals(fieldName)) {
      return proxyHeader;
    }
    if ("request".equals(fieldName)) {
      return request;
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
   * The TCP port number for the health check request. The default value is 80. Valid values are 1
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

  /**
   * The application data to send once the TCP connection has been established (default value is
   * empty). If both request and response are empty, the connection establishment alone will
   * indicate health. The request data can only be ASCII.
   */
  public String getRequest() {
    return request;
  }

  /**
   * The bytes to match against the beginning of the response data. If left empty (the default
   * value), any response will indicate health. The response data can only be ASCII.
   */
  public String getResponse() {
    return response;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TCPHealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TCPHealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TCPHealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TCPHealthCheck();
  }

  public static class Builder {
    private Integer port;
    private String portName;
    private String proxyHeader;
    private String request;
    private String response;

    Builder() {}

    public Builder mergeFrom(TCPHealthCheck other) {
      if (other == TCPHealthCheck.getDefaultInstance()) return this;
      if (other.getPort() != null) {
        this.port = other.port;
      }
      if (other.getPortName() != null) {
        this.portName = other.portName;
      }
      if (other.getProxyHeader() != null) {
        this.proxyHeader = other.proxyHeader;
      }
      if (other.getRequest() != null) {
        this.request = other.request;
      }
      if (other.getResponse() != null) {
        this.response = other.response;
      }
      return this;
    }

    Builder(TCPHealthCheck source) {
      this.port = source.port;
      this.portName = source.portName;
      this.proxyHeader = source.proxyHeader;
      this.request = source.request;
      this.response = source.response;
    }

    /**
     * The TCP port number for the health check request. The default value is 80. Valid values are 1
     * through 65535.
     */
    public Integer getPort() {
      return port;
    }

    /**
     * The TCP port number for the health check request. The default value is 80. Valid values are 1
     * through 65535.
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

    /**
     * The application data to send once the TCP connection has been established (default value is
     * empty). If both request and response are empty, the connection establishment alone will
     * indicate health. The request data can only be ASCII.
     */
    public String getRequest() {
      return request;
    }

    /**
     * The application data to send once the TCP connection has been established (default value is
     * empty). If both request and response are empty, the connection establishment alone will
     * indicate health. The request data can only be ASCII.
     */
    public Builder setRequest(String request) {
      this.request = request;
      return this;
    }

    /**
     * The bytes to match against the beginning of the response data. If left empty (the default
     * value), any response will indicate health. The response data can only be ASCII.
     */
    public String getResponse() {
      return response;
    }

    /**
     * The bytes to match against the beginning of the response data. If left empty (the default
     * value), any response will indicate health. The response data can only be ASCII.
     */
    public Builder setResponse(String response) {
      this.response = response;
      return this;
    }

    public TCPHealthCheck build() {

      return new TCPHealthCheck(port, portName, proxyHeader, request, response);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPort(this.port);
      newBuilder.setPortName(this.portName);
      newBuilder.setProxyHeader(this.proxyHeader);
      newBuilder.setRequest(this.request);
      newBuilder.setResponse(this.response);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TCPHealthCheck{"
        + "port="
        + port
        + ", "
        + "portName="
        + portName
        + ", "
        + "proxyHeader="
        + proxyHeader
        + ", "
        + "request="
        + request
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
    if (o instanceof TCPHealthCheck) {
      TCPHealthCheck that = (TCPHealthCheck) o;
      return Objects.equals(this.port, that.getPort())
          && Objects.equals(this.portName, that.getPortName())
          && Objects.equals(this.proxyHeader, that.getProxyHeader())
          && Objects.equals(this.request, that.getRequest())
          && Objects.equals(this.response, that.getResponse());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, portName, proxyHeader, request, response);
  }
}
