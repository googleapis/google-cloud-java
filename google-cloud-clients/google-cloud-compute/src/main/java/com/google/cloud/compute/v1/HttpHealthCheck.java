/*
 * Copyright 2018 Google LLC
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
public final class HttpHealthCheck implements ApiMessage {
  private final String host;
  private final Integer port;
  private final String portName;
  private final String proxyHeader;
  private final String requestPath;
  private final String response;

  private HttpHealthCheck() {
    this.host = null;
    this.port = null;
    this.portName = null;
    this.proxyHeader = null;
    this.requestPath = null;
    this.response = null;
  }

  private HttpHealthCheck(
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
    if (fieldName.equals("host")) {
      return host;
    }
    if (fieldName.equals("port")) {
      return port;
    }
    if (fieldName.equals("portName")) {
      return portName;
    }
    if (fieldName.equals("proxyHeader")) {
      return proxyHeader;
    }
    if (fieldName.equals("requestPath")) {
      return requestPath;
    }
    if (fieldName.equals("response")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getHost() {
    return host;
  }

  public Integer getPort() {
    return port;
  }

  public String getPortName() {
    return portName;
  }

  public String getProxyHeader() {
    return proxyHeader;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public String getResponse() {
    return response;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpHealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpHealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpHealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpHealthCheck();
  }

  public static class Builder {
    private String host;
    private Integer port;
    private String portName;
    private String proxyHeader;
    private String requestPath;
    private String response;

    Builder() {}

    public Builder mergeFrom(HttpHealthCheck other) {
      if (other == HttpHealthCheck.getDefaultInstance()) return this;
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

    Builder(HttpHealthCheck source) {
      this.host = source.host;
      this.port = source.port;
      this.portName = source.portName;
      this.proxyHeader = source.proxyHeader;
      this.requestPath = source.requestPath;
      this.response = source.response;
    }

    public String getHost() {
      return host;
    }

    public Builder setHost(String host) {
      this.host = host;
      return this;
    }

    public Integer getPort() {
      return port;
    }

    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public String getPortName() {
      return portName;
    }

    public Builder setPortName(String portName) {
      this.portName = portName;
      return this;
    }

    public String getProxyHeader() {
      return proxyHeader;
    }

    public Builder setProxyHeader(String proxyHeader) {
      this.proxyHeader = proxyHeader;
      return this;
    }

    public String getRequestPath() {
      return requestPath;
    }

    public Builder setRequestPath(String requestPath) {
      this.requestPath = requestPath;
      return this;
    }

    public String getResponse() {
      return response;
    }

    public Builder setResponse(String response) {
      this.response = response;
      return this;
    }

    public HttpHealthCheck build() {

      return new HttpHealthCheck(host, port, portName, proxyHeader, requestPath, response);
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
    return "HttpHealthCheck{"
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
    if (o instanceof HttpHealthCheck) {
      HttpHealthCheck that = (HttpHealthCheck) o;
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
