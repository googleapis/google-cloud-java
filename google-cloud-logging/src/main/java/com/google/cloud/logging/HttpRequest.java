/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Objects of this class represent information about the (optional) HTTP request associated with a
 * log entry.
 *
 * @see <a href=
 *     "https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/LogEntry#httprequest">
 *     Http Request</a>
 */
public final class HttpRequest implements Serializable {

  private static final long serialVersionUID = -274998005454709817L;

  private final RequestMethod requestMethod;
  private final String requestUrl;
  private final Long requestSize;
  private final Integer status;
  private final Long responseSize;
  private final String userAgent;
  private final String remoteIp;
  private final String serverIp;
  private final String referer;
  private final boolean cacheLookup;
  private final boolean cacheHit;
  private final boolean cacheValidatedWithOriginServer;
  private final Long cacheFillBytes;

  /**
   * The HTTP request method.
   */
  public static final class RequestMethod extends StringEnumValue {
    private static final long serialVersionUID = 2403969065179486996L;

    private RequestMethod(String constant) {
      super(constant);
    }

    private static final ApiFunction<String, RequestMethod> CONSTRUCTOR =
        new ApiFunction<String, RequestMethod>() {
          @Override
          public RequestMethod apply(String constant) {
            return new RequestMethod(constant);
          }
        };

    private static final StringEnumType<RequestMethod> type = new StringEnumType(
        RequestMethod.class,
        CONSTRUCTOR);

    public static final RequestMethod GET = type.createAndRegister("GET");
    public static final RequestMethod HEAD = type.createAndRegister("HEAD");
    public static final RequestMethod PUT = type.createAndRegister("PUT");
    public static final RequestMethod POST = type.createAndRegister("POST");

    /**
     * Get the RequestMethod for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static RequestMethod valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the RequestMethod for the given String constant, and allow unrecognized values.
     */
    public static RequestMethod valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values for RequestMethod.
     */
    public static RequestMethod[] values() {
      return type.values();
    }
  }

  /**
   * A builder for {@code HttpRequest} objects.
   */
  public static final class Builder {

    private RequestMethod requestMethod;
    private String requestUrl;
    private Long requestSize;
    private Integer status;
    private Long responseSize;
    private String userAgent;
    private String remoteIp;
    private String serverIp;
    private String referer;
    private boolean cacheLookup;
    private boolean cacheHit;
    private boolean cacheValidatedWithOriginServer;
    private Long cacheFillBytes;

    Builder() {}

    Builder(HttpRequest request) {
      this.requestMethod = request.requestMethod;
      this.requestUrl = request.requestUrl;
      this.requestSize = request.requestSize;
      this.status = request.status;
      this.responseSize = request.responseSize;
      this.userAgent = request.userAgent;
      this.remoteIp = request.remoteIp;
      this.serverIp = request.serverIp;
      this.referer = request.referer;
      this.cacheLookup = request.cacheLookup;
      this.cacheHit = request.cacheHit;
      this.cacheValidatedWithOriginServer = request.cacheValidatedWithOriginServer;
      this.cacheFillBytes = request.cacheFillBytes;
    }


    /**
     * Sets the HTTP request method.
     */
    public Builder setRequestMethod(RequestMethod requestMethod) {
      this.requestMethod = requestMethod;
      return this;
    }


    /**
     * Sets the requested URL. Request URL contains the scheme ({@code http}, {@code https}), the
     * host name, the path and the query portion of the URL that was requested. Example:
     * {@code http://example.com/some/info?color=red}.
     */
    public Builder setRequestUrl(String requestUrl) {
      this.requestUrl = requestUrl;
      return this;
    }


    /**
     * Sets the size of the HTTP request message in bytes, including the request headers and the
     * request body.
     */
    public Builder setRequestSize(long requestSize) {
      this.requestSize = requestSize;
      return this;
    }


    /**
     * Sets the response code indicating the status of response.
     */
    public Builder setStatus(int status) {
      this.status = status;
      return this;
    }


    /**
     * Sets the size of the HTTP response message sent back to the client, in bytes, including the
     * response headers and the response body.
     */
    public Builder setResponseSize(long responseSize) {
      this.responseSize = responseSize;
      return this;
    }


    /**
     * Sets the user agent sent by the client. Example:
     * {@code Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Q312461; .NET CLR 1.0.3705)}.
     */
    public Builder setUserAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
    }


    /**
     * Sets the IP address (IPv4 or IPv6) of the client that issued the HTTP request. Examples:
     * {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    public Builder setRemoteIp(String remoteIp) {
      this.remoteIp = remoteIp;
      return this;
    }


    /**
     * Sets the IP address (IPv4 or IPv6) of the origin server that the request was sent to.
     * Examples: {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    public Builder setServerIp(String serverIp) {
      this.serverIp = serverIp;
      return this;
    }


    /**
     * Sets the referer URL of the request, as defined in HTTP/1.1 Header Field Definitions.
     *
     * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html">HTTP/1.1 Header Field
     *     Definitions</a>
     */
    public Builder setReferer(String referer) {
      this.referer = referer;
      return this;
    }


    /**
     * Sets whether or not a cache lookup was attempted. If not set, {@code false} is used.
     */
    public Builder setCacheLookup(boolean cacheLookup) {
      this.cacheLookup = cacheLookup;
      return this;
    }


    /**
     * Sets whether or not an entity was served from cache (with or without validation). If not set,
     * {@code false} is used.
     */
    public Builder setCacheHit(boolean cacheHit) {
      this.cacheHit = cacheHit;
      return this;
    }


    /**
     * Sets whether or not the response was validated with the origin server before being served
     * from cache. This field is only meaningful if {@link #setCacheHit(boolean)} is set to
     * {@code true}. If not set, {@code false} is used.
     */
    public Builder setCacheValidatedWithOriginServer(boolean cacheValidatedWithOriginServer) {
      this.cacheValidatedWithOriginServer = cacheValidatedWithOriginServer;
      return this;
    }


    /**
     * Sets the number of HTTP response bytes inserted into cache. Set only when a cache fill was
     * attempted.
     */
    public Builder setCacheFillBytes(long cacheFillBytes) {
      this.cacheFillBytes = cacheFillBytes;
      return this;
    }

    /**
     * Creates a {@code HttpRequest} object for this builder.
     */
    public HttpRequest build() {
      return new HttpRequest(this);
    }
  }

  HttpRequest(Builder builder) {
    this.requestMethod = builder.requestMethod;
    this.requestUrl = builder.requestUrl;
    this.requestSize = builder.requestSize;
    this.status = builder.status;
    this.responseSize = builder.responseSize;
    this.userAgent = builder.userAgent;
    this.remoteIp = builder.remoteIp;
    this.serverIp = builder.serverIp;
    this.referer = builder.referer;
    this.cacheLookup = builder.cacheLookup;
    this.cacheHit = builder.cacheHit;
    this.cacheValidatedWithOriginServer = builder.cacheValidatedWithOriginServer;
    this.cacheFillBytes = builder.cacheFillBytes;
  }


  /**
   * Returns the HTTP request method.
   */
  public RequestMethod getRequestMethod() {
    return requestMethod;
  }


  /**
   * Returns the requested URL. Request URL contains the scheme ({@code http}, {@code https}), the
   * host name, the path and the query portion of the URL that was requested. Example:
   * {@code http://example.com/some/info?color=red}.
   */
  public String getRequestUrl() {
    return requestUrl;
  }


  /**
   * Returns the size of the HTTP request message in bytes, including the request headers and the
   * request body.
   */
  public Long getRequestSize() {
    return requestSize;
  }


  /**
   * Returns the response code indicating the status of response.
   */
  public Integer getStatus() {
    return status;
  }


  /**
   * Returns the size of the HTTP response message sent back to the client, in bytes, including the
   * response headers and the response body.
   */
  public Long getResponseSize() {
    return responseSize;
  }


  /**
   * Returns the user agent sent by the client. Example:
   * {@code Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Q312461; .NET CLR 1.0.3705)}.
   */
  public String getUserAgent() {
    return userAgent;
  }


  /**
   * Returns the IP address (IPv4 or IPv6) of the client that issued the HTTP request. Examples:
   * {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
   */
  public String getRemoteIp() {
    return remoteIp;
  }


  /**
   * Returns the IP address (IPv4 or IPv6) of the origin server that the request was sent to.
   * Examples: {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
   */
  public String getServerIp() {
    return serverIp;
  }


  /**
   * Returns the referer URL of the request, as defined in HTTP/1.1 Header Field Definitions.
   *
   * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html">HTTP/1.1 Header Field
   *     Definitions</a>
   */
  public String getReferer() {
    return referer;
  }

  /**
   * Returns whether or not a cache lookup was attempted. If not set, this method returns
   * {@code false}.
   */
  public boolean cacheLookup() {
    return cacheLookup;
  }

  /**
   * Returns whether or not an entity was served from cache (with or without validation). If not
   * set, this method returns {@code false}.
   */
  public boolean cacheHit() {
    return cacheHit;
  }

  /**
   * Returns whether or not the response was validated with the origin server before being served
   * from cache. If not set, this method returns {@code false}. This field is only meaningful if
   * {@link #cacheHit()} is set to {@code true}.
   */
  public boolean cacheValidatedWithOriginServer() {
    return cacheValidatedWithOriginServer;
  }


  /**
   * Returns the number of HTTP response bytes inserted into cache. Set only when a cache fill was
   * attempted.
   */
  public Long getCacheFillBytes() {
    return cacheFillBytes;
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestMethod, requestUrl, requestSize, status, responseSize, userAgent,
        serverIp, cacheLookup, cacheFillBytes, remoteIp, referer, cacheHit,
        cacheValidatedWithOriginServer);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("requestMethod", requestMethod)
        .add("requestUrl", requestUrl)
        .add("requestSize", requestSize)
        .add("status", status)
        .add("responseSize", responseSize)
        .add("userAgent", userAgent)
        .add("remoteIp", remoteIp)
        .add("serverIp", serverIp)
        .add("referer", referer)
        .add("cacheLookup", cacheLookup)
        .add("cacheHit", cacheHit)
        .add("cacheValidatedWithOriginServer", cacheValidatedWithOriginServer)
        .add("cacheFillBytes", cacheFillBytes)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof HttpRequest)) {
      return false;
    }
    HttpRequest other = (HttpRequest) obj;
    return Objects.equals(requestMethod, other.requestMethod)
        && Objects.equals(requestUrl, other.requestUrl)
        && Objects.equals(requestSize, other.requestSize)
        && Objects.equals(status, other.status)
        && Objects.equals(responseSize, other.responseSize)
        && Objects.equals(userAgent, other.userAgent)
        && Objects.equals(remoteIp, other.remoteIp)
        && Objects.equals(serverIp, other.serverIp)
        && Objects.equals(referer, other.referer)
        && cacheLookup == other.cacheLookup
        && cacheHit == other.cacheHit
        && cacheValidatedWithOriginServer == other.cacheValidatedWithOriginServer
        && Objects.equals(cacheFillBytes, other.cacheFillBytes);
  }

  /**
   * Returns a builder for this object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  com.google.logging.type.HttpRequest toPb() {
    com.google.logging.type.HttpRequest.Builder builder =
        com.google.logging.type.HttpRequest.newBuilder();
    if (requestMethod != null) {
      builder.setRequestMethod(requestMethod.name());
    }
    if (requestUrl != null) {
      builder.setRequestUrl(requestUrl);
    }
    if (requestSize != null) {
      builder.setRequestSize(requestSize);
    }
    if (status != null) {
      builder.setStatus(status);
    }
    if (responseSize != null) {
      builder.setResponseSize(responseSize);
    }
    if (userAgent != null) {
      builder.setUserAgent(userAgent);
    }
    if (remoteIp != null) {
      builder.setRemoteIp(remoteIp);
    }
    if (serverIp != null) {
      builder.setServerIp(serverIp);
    }
    if (referer != null) {
      builder.setReferer(referer);
    }
    builder.setCacheLookup(cacheLookup);
    builder.setCacheHit(cacheHit);
    builder.setCacheValidatedWithOriginServer(cacheValidatedWithOriginServer);
    if (cacheFillBytes != null) {
      builder.setCacheFillBytes(cacheFillBytes);
    }
    return builder.build();
  }


  /**
   * Returns a builder for {@code HttpRequest} objects.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  static HttpRequest fromPb(com.google.logging.type.HttpRequest requestPb) {
    Builder builder = newBuilder();
    if (requestPb.getRequestMethod() != null && !requestPb.getRequestMethod().equals("")) {
      builder.setRequestMethod(RequestMethod.valueOf(requestPb.getRequestMethod()));
    }
    if (requestPb.getRequestUrl() != null && !requestPb.getRequestUrl().equals("")) {
      builder.setRequestUrl(requestPb.getRequestUrl());
    }
    if (requestPb.getRequestSize() != 0L) {
      builder.setRequestSize(requestPb.getRequestSize());
    }
    if (requestPb.getStatus() != 0L) {
      builder.setStatus(requestPb.getStatus());
    }
    if (requestPb.getResponseSize() != 0L) {
      builder.setResponseSize(requestPb.getResponseSize());
    }
    if (requestPb.getUserAgent() != null && !requestPb.getRequestUrl().equals("")) {
      builder.setUserAgent(requestPb.getUserAgent());
    }
    if (requestPb.getServerIp() != null && !requestPb.getServerIp().equals("")) {
      builder.setServerIp(requestPb.getServerIp());
    }
    if (requestPb.getRemoteIp() != null && !requestPb.getRemoteIp().equals("")) {
      builder.setRemoteIp(requestPb.getRemoteIp());
    }
    if (requestPb.getReferer() != null && !requestPb.getReferer().equals("")) {
      builder.setReferer(requestPb.getReferer());
    }
    builder.setCacheLookup(requestPb.getCacheLookup());
    builder.setCacheHit(requestPb.getCacheHit());
    builder.setCacheValidatedWithOriginServer(requestPb.getCacheValidatedWithOriginServer());
    if (requestPb.getCacheFillBytes() != 0L) {
      builder.setCacheFillBytes(requestPb.getCacheFillBytes());
    }
    return builder.build();
  }
}
