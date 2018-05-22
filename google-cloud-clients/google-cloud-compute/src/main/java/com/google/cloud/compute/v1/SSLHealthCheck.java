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
public final class SSLHealthCheck implements ApiMessage {
  private final Integer port;
  private final String portName;
  private final String proxyHeader;
  private final String request;
  private final String response;

  private SSLHealthCheck() {
    this.port = null;
    this.portName = null;
    this.proxyHeader = null;
    this.request = null;
    this.response = null;
  }

  private SSLHealthCheck(
      Integer port, String portName, String proxyHeader, String request, String response) {
    this.port = port;
    this.portName = portName;
    this.proxyHeader = proxyHeader;
    this.request = request;
    this.response = response;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("port")) {
      return port;
    }
    if (fieldName.equals("portName")) {
      return portName;
    }
    if (fieldName.equals("proxyHeader")) {
      return proxyHeader;
    }
    if (fieldName.equals("request")) {
      return request;
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

  public Integer getPort() {
    return port;
  }

  public String getPortName() {
    return portName;
  }

  public String getProxyHeader() {
    return proxyHeader;
  }

  public String getRequest() {
    return request;
  }

  public String getResponse() {
    return response;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SSLHealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SSLHealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SSLHealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SSLHealthCheck();
  }

  public static class Builder {
    private Integer port;
    private String portName;
    private String proxyHeader;
    private String request;
    private String response;

    Builder() {}

    public Builder mergeFrom(SSLHealthCheck other) {
      if (other == SSLHealthCheck.getDefaultInstance()) return this;
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

    Builder(SSLHealthCheck source) {
      this.port = source.port;
      this.portName = source.portName;
      this.proxyHeader = source.proxyHeader;
      this.request = source.request;
      this.response = source.response;
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

    public String getRequest() {
      return request;
    }

    public Builder setRequest(String request) {
      this.request = request;
      return this;
    }

    public String getResponse() {
      return response;
    }

    public Builder setResponse(String response) {
      this.response = response;
      return this;
    }

    public SSLHealthCheck build() {

      return new SSLHealthCheck(port, portName, proxyHeader, request, response);
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
    return "SSLHealthCheck{"
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
    if (o instanceof SSLHealthCheck) {
      SSLHealthCheck that = (SSLHealthCheck) o;
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
