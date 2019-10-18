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
public final class HttpRouteAction implements ApiMessage {
  private final CorsPolicy corsPolicy;
  private final HttpFaultInjection faultInjectionPolicy;
  private final RequestMirrorPolicy requestMirrorPolicy;
  private final HttpRetryPolicy retryPolicy;
  private final Duration timeout;
  private final UrlRewrite urlRewrite;
  private final List<WeightedBackendService> weightedBackendServices;

  private HttpRouteAction() {
    this.corsPolicy = null;
    this.faultInjectionPolicy = null;
    this.requestMirrorPolicy = null;
    this.retryPolicy = null;
    this.timeout = null;
    this.urlRewrite = null;
    this.weightedBackendServices = null;
  }

  private HttpRouteAction(
      CorsPolicy corsPolicy,
      HttpFaultInjection faultInjectionPolicy,
      RequestMirrorPolicy requestMirrorPolicy,
      HttpRetryPolicy retryPolicy,
      Duration timeout,
      UrlRewrite urlRewrite,
      List<WeightedBackendService> weightedBackendServices) {
    this.corsPolicy = corsPolicy;
    this.faultInjectionPolicy = faultInjectionPolicy;
    this.requestMirrorPolicy = requestMirrorPolicy;
    this.retryPolicy = retryPolicy;
    this.timeout = timeout;
    this.urlRewrite = urlRewrite;
    this.weightedBackendServices = weightedBackendServices;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("corsPolicy".equals(fieldName)) {
      return corsPolicy;
    }
    if ("faultInjectionPolicy".equals(fieldName)) {
      return faultInjectionPolicy;
    }
    if ("requestMirrorPolicy".equals(fieldName)) {
      return requestMirrorPolicy;
    }
    if ("retryPolicy".equals(fieldName)) {
      return retryPolicy;
    }
    if ("timeout".equals(fieldName)) {
      return timeout;
    }
    if ("urlRewrite".equals(fieldName)) {
      return urlRewrite;
    }
    if ("weightedBackendServices".equals(fieldName)) {
      return weightedBackendServices;
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
   * The specification for allowing client side cross-origin requests. Please see W3C Recommendation
   * for Cross Origin Resource Sharing
   */
  public CorsPolicy getCorsPolicy() {
    return corsPolicy;
  }

  /**
   * The specification for fault injection introduced into traffic to test the resiliency of clients
   * to backend service failure. As part of fault injection, when clients send requests to a backend
   * service, delays can be introduced by Loadbalancer on a percentage of requests before sending
   * those request to the backend service. Similarly requests from clients can be aborted by the
   * Loadbalancer for a percentage of requests. timeout and retry_policy will be ignored by clients
   * that are configured with a fault_injection_policy.
   */
  public HttpFaultInjection getFaultInjectionPolicy() {
    return faultInjectionPolicy;
  }

  /**
   * Specifies the policy on how requests intended for the route's backends are shadowed to a
   * separate mirrored backend service. Loadbalancer does not wait for responses from the shadow
   * service. Prior to sending traffic to the shadow service, the host / authority header is
   * suffixed with -shadow.
   */
  public RequestMirrorPolicy getRequestMirrorPolicy() {
    return requestMirrorPolicy;
  }

  /** Specifies the retry policy associated with this route. */
  public HttpRetryPolicy getRetryPolicy() {
    return retryPolicy;
  }

  /**
   * Specifies the timeout for the selected route. Timeout is computed from the time the request is
   * has been fully processed (i.e. end-of-stream) up until the response has been completely
   * processed. Timeout includes all retries. If not specified, the default value is 15 seconds.
   */
  public Duration getTimeout() {
    return timeout;
  }

  /**
   * The spec to modify the URL of the request, prior to forwarding the request to the matched
   * service
   */
  public UrlRewrite getUrlRewrite() {
    return urlRewrite;
  }

  /**
   * A list of weighted backend services to send traffic to when a route match occurs. The weights
   * determine the fraction of traffic that flows to their corresponding backend service. If all
   * traffic needs to go to a single backend service, there must be one weightedBackendService with
   * weight set to a non 0 number. Once a backendService is identified and before forwarding the
   * request to the backend service, advanced routing actions like Url rewrites and header
   * transformations are applied depending on additional settings specified in this HttpRouteAction.
   */
  public List<WeightedBackendService> getWeightedBackendServicesList() {
    return weightedBackendServices;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpRouteAction prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpRouteAction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpRouteAction DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpRouteAction();
  }

  public static class Builder {
    private CorsPolicy corsPolicy;
    private HttpFaultInjection faultInjectionPolicy;
    private RequestMirrorPolicy requestMirrorPolicy;
    private HttpRetryPolicy retryPolicy;
    private Duration timeout;
    private UrlRewrite urlRewrite;
    private List<WeightedBackendService> weightedBackendServices;

    Builder() {}

    public Builder mergeFrom(HttpRouteAction other) {
      if (other == HttpRouteAction.getDefaultInstance()) return this;
      if (other.getCorsPolicy() != null) {
        this.corsPolicy = other.corsPolicy;
      }
      if (other.getFaultInjectionPolicy() != null) {
        this.faultInjectionPolicy = other.faultInjectionPolicy;
      }
      if (other.getRequestMirrorPolicy() != null) {
        this.requestMirrorPolicy = other.requestMirrorPolicy;
      }
      if (other.getRetryPolicy() != null) {
        this.retryPolicy = other.retryPolicy;
      }
      if (other.getTimeout() != null) {
        this.timeout = other.timeout;
      }
      if (other.getUrlRewrite() != null) {
        this.urlRewrite = other.urlRewrite;
      }
      if (other.getWeightedBackendServicesList() != null) {
        this.weightedBackendServices = other.weightedBackendServices;
      }
      return this;
    }

    Builder(HttpRouteAction source) {
      this.corsPolicy = source.corsPolicy;
      this.faultInjectionPolicy = source.faultInjectionPolicy;
      this.requestMirrorPolicy = source.requestMirrorPolicy;
      this.retryPolicy = source.retryPolicy;
      this.timeout = source.timeout;
      this.urlRewrite = source.urlRewrite;
      this.weightedBackendServices = source.weightedBackendServices;
    }

    /**
     * The specification for allowing client side cross-origin requests. Please see W3C
     * Recommendation for Cross Origin Resource Sharing
     */
    public CorsPolicy getCorsPolicy() {
      return corsPolicy;
    }

    /**
     * The specification for allowing client side cross-origin requests. Please see W3C
     * Recommendation for Cross Origin Resource Sharing
     */
    public Builder setCorsPolicy(CorsPolicy corsPolicy) {
      this.corsPolicy = corsPolicy;
      return this;
    }

    /**
     * The specification for fault injection introduced into traffic to test the resiliency of
     * clients to backend service failure. As part of fault injection, when clients send requests to
     * a backend service, delays can be introduced by Loadbalancer on a percentage of requests
     * before sending those request to the backend service. Similarly requests from clients can be
     * aborted by the Loadbalancer for a percentage of requests. timeout and retry_policy will be
     * ignored by clients that are configured with a fault_injection_policy.
     */
    public HttpFaultInjection getFaultInjectionPolicy() {
      return faultInjectionPolicy;
    }

    /**
     * The specification for fault injection introduced into traffic to test the resiliency of
     * clients to backend service failure. As part of fault injection, when clients send requests to
     * a backend service, delays can be introduced by Loadbalancer on a percentage of requests
     * before sending those request to the backend service. Similarly requests from clients can be
     * aborted by the Loadbalancer for a percentage of requests. timeout and retry_policy will be
     * ignored by clients that are configured with a fault_injection_policy.
     */
    public Builder setFaultInjectionPolicy(HttpFaultInjection faultInjectionPolicy) {
      this.faultInjectionPolicy = faultInjectionPolicy;
      return this;
    }

    /**
     * Specifies the policy on how requests intended for the route's backends are shadowed to a
     * separate mirrored backend service. Loadbalancer does not wait for responses from the shadow
     * service. Prior to sending traffic to the shadow service, the host / authority header is
     * suffixed with -shadow.
     */
    public RequestMirrorPolicy getRequestMirrorPolicy() {
      return requestMirrorPolicy;
    }

    /**
     * Specifies the policy on how requests intended for the route's backends are shadowed to a
     * separate mirrored backend service. Loadbalancer does not wait for responses from the shadow
     * service. Prior to sending traffic to the shadow service, the host / authority header is
     * suffixed with -shadow.
     */
    public Builder setRequestMirrorPolicy(RequestMirrorPolicy requestMirrorPolicy) {
      this.requestMirrorPolicy = requestMirrorPolicy;
      return this;
    }

    /** Specifies the retry policy associated with this route. */
    public HttpRetryPolicy getRetryPolicy() {
      return retryPolicy;
    }

    /** Specifies the retry policy associated with this route. */
    public Builder setRetryPolicy(HttpRetryPolicy retryPolicy) {
      this.retryPolicy = retryPolicy;
      return this;
    }

    /**
     * Specifies the timeout for the selected route. Timeout is computed from the time the request
     * is has been fully processed (i.e. end-of-stream) up until the response has been completely
     * processed. Timeout includes all retries. If not specified, the default value is 15 seconds.
     */
    public Duration getTimeout() {
      return timeout;
    }

    /**
     * Specifies the timeout for the selected route. Timeout is computed from the time the request
     * is has been fully processed (i.e. end-of-stream) up until the response has been completely
     * processed. Timeout includes all retries. If not specified, the default value is 15 seconds.
     */
    public Builder setTimeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * The spec to modify the URL of the request, prior to forwarding the request to the matched
     * service
     */
    public UrlRewrite getUrlRewrite() {
      return urlRewrite;
    }

    /**
     * The spec to modify the URL of the request, prior to forwarding the request to the matched
     * service
     */
    public Builder setUrlRewrite(UrlRewrite urlRewrite) {
      this.urlRewrite = urlRewrite;
      return this;
    }

    /**
     * A list of weighted backend services to send traffic to when a route match occurs. The weights
     * determine the fraction of traffic that flows to their corresponding backend service. If all
     * traffic needs to go to a single backend service, there must be one weightedBackendService
     * with weight set to a non 0 number. Once a backendService is identified and before forwarding
     * the request to the backend service, advanced routing actions like Url rewrites and header
     * transformations are applied depending on additional settings specified in this
     * HttpRouteAction.
     */
    public List<WeightedBackendService> getWeightedBackendServicesList() {
      return weightedBackendServices;
    }

    /**
     * A list of weighted backend services to send traffic to when a route match occurs. The weights
     * determine the fraction of traffic that flows to their corresponding backend service. If all
     * traffic needs to go to a single backend service, there must be one weightedBackendService
     * with weight set to a non 0 number. Once a backendService is identified and before forwarding
     * the request to the backend service, advanced routing actions like Url rewrites and header
     * transformations are applied depending on additional settings specified in this
     * HttpRouteAction.
     */
    public Builder addAllWeightedBackendServices(
        List<WeightedBackendService> weightedBackendServices) {
      if (this.weightedBackendServices == null) {
        this.weightedBackendServices = new LinkedList<>();
      }
      this.weightedBackendServices.addAll(weightedBackendServices);
      return this;
    }

    /**
     * A list of weighted backend services to send traffic to when a route match occurs. The weights
     * determine the fraction of traffic that flows to their corresponding backend service. If all
     * traffic needs to go to a single backend service, there must be one weightedBackendService
     * with weight set to a non 0 number. Once a backendService is identified and before forwarding
     * the request to the backend service, advanced routing actions like Url rewrites and header
     * transformations are applied depending on additional settings specified in this
     * HttpRouteAction.
     */
    public Builder addWeightedBackendServices(WeightedBackendService weightedBackendServices) {
      if (this.weightedBackendServices == null) {
        this.weightedBackendServices = new LinkedList<>();
      }
      this.weightedBackendServices.add(weightedBackendServices);
      return this;
    }

    public HttpRouteAction build() {

      return new HttpRouteAction(
          corsPolicy,
          faultInjectionPolicy,
          requestMirrorPolicy,
          retryPolicy,
          timeout,
          urlRewrite,
          weightedBackendServices);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCorsPolicy(this.corsPolicy);
      newBuilder.setFaultInjectionPolicy(this.faultInjectionPolicy);
      newBuilder.setRequestMirrorPolicy(this.requestMirrorPolicy);
      newBuilder.setRetryPolicy(this.retryPolicy);
      newBuilder.setTimeout(this.timeout);
      newBuilder.setUrlRewrite(this.urlRewrite);
      newBuilder.addAllWeightedBackendServices(this.weightedBackendServices);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpRouteAction{"
        + "corsPolicy="
        + corsPolicy
        + ", "
        + "faultInjectionPolicy="
        + faultInjectionPolicy
        + ", "
        + "requestMirrorPolicy="
        + requestMirrorPolicy
        + ", "
        + "retryPolicy="
        + retryPolicy
        + ", "
        + "timeout="
        + timeout
        + ", "
        + "urlRewrite="
        + urlRewrite
        + ", "
        + "weightedBackendServices="
        + weightedBackendServices
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpRouteAction) {
      HttpRouteAction that = (HttpRouteAction) o;
      return Objects.equals(this.corsPolicy, that.getCorsPolicy())
          && Objects.equals(this.faultInjectionPolicy, that.getFaultInjectionPolicy())
          && Objects.equals(this.requestMirrorPolicy, that.getRequestMirrorPolicy())
          && Objects.equals(this.retryPolicy, that.getRetryPolicy())
          && Objects.equals(this.timeout, that.getTimeout())
          && Objects.equals(this.urlRewrite, that.getUrlRewrite())
          && Objects.equals(this.weightedBackendServices, that.getWeightedBackendServicesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        corsPolicy,
        faultInjectionPolicy,
        requestMirrorPolicy,
        retryPolicy,
        timeout,
        urlRewrite,
        weightedBackendServices);
  }
}
