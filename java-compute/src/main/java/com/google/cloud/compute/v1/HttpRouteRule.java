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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * An HttpRouteRule specifies how to match an HTTP request and the corresponding routing action that
 * load balancing proxies will perform.
 */
public final class HttpRouteRule implements ApiMessage {
  private final String description;
  private final HttpHeaderAction headerAction;
  private final List<HttpRouteRuleMatch> matchRules;
  private final Integer priority;
  private final HttpRouteAction routeAction;
  private final String service;
  private final HttpRedirectAction urlRedirect;

  private HttpRouteRule() {
    this.description = null;
    this.headerAction = null;
    this.matchRules = null;
    this.priority = null;
    this.routeAction = null;
    this.service = null;
    this.urlRedirect = null;
  }

  private HttpRouteRule(
      String description,
      HttpHeaderAction headerAction,
      List<HttpRouteRuleMatch> matchRules,
      Integer priority,
      HttpRouteAction routeAction,
      String service,
      HttpRedirectAction urlRedirect) {
    this.description = description;
    this.headerAction = headerAction;
    this.matchRules = matchRules;
    this.priority = priority;
    this.routeAction = routeAction;
    this.service = service;
    this.urlRedirect = urlRedirect;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("headerAction".equals(fieldName)) {
      return headerAction;
    }
    if ("matchRules".equals(fieldName)) {
      return matchRules;
    }
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("routeAction".equals(fieldName)) {
      return routeAction;
    }
    if ("service".equals(fieldName)) {
      return service;
    }
    if ("urlRedirect".equals(fieldName)) {
      return urlRedirect;
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
   * The short description conveying the intent of this routeRule. The description can have a
   * maximum length of 1024 characters.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Specifies changes to request and response headers that need to take effect for the selected
   * backendService. The headerAction specified here are applied before the matching
   * pathMatchers[].headerAction and after
   * pathMatchers[].routeRules[].routeAction.weightedBackendService.backendServiceWeightAction[].headerAction
   */
  public HttpHeaderAction getHeaderAction() {
    return headerAction;
  }

  public List<HttpRouteRuleMatch> getMatchRulesList() {
    return matchRules;
  }

  /**
   * For routeRules within a given pathMatcher, priority determines the order in which load balancer
   * will interpret routeRules. RouteRules are evaluated in order of priority, from the lowest to
   * highest number. The priority of a rule decreases as its number increases (1, 2, 3, N+1). The
   * first rule that matches the request is applied. You cannot configure two or more routeRules
   * with the same priority. Priority for each rule must be set to a number between 0 and 2147483647
   * inclusive. Priority numbers can have gaps, which enable you to add or remove rules in the
   * future without affecting the rest of the rules. For example, 1, 2, 3, 4, 5, 9, 12, 16 is a
   * valid series of priority numbers to which you could add rules numbered from 6 to 8, 10 to 11,
   * and 13 to 15 in the future without any impact on existing rules.
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * In response to a matching matchRule, the load balancer performs advanced routing actions like
   * URL rewrites, header transformations, etc. prior to forwarding the request to the selected
   * backend. If routeAction specifies any weightedBackendServices, service must not be set.
   * Conversely if service is set, routeAction cannot contain any weightedBackendServices. Only one
   * of urlRedirect, service or routeAction.weightedBackendService must be set.
   */
  public HttpRouteAction getRouteAction() {
    return routeAction;
  }

  /**
   * The full or partial URL of the backend service resource to which traffic is directed if this
   * rule is matched. If routeAction is additionally specified, advanced routing actions like URL
   * Rewrites, etc. take effect prior to sending the request to the backend. However, if service is
   * specified, routeAction cannot contain any weightedBackendService s. Conversely, if routeAction
   * specifies any weightedBackendServices, service must not be specified. Only one of urlRedirect,
   * service or routeAction.weightedBackendService must be set.
   */
  public String getService() {
    return service;
  }

  /**
   * When this rule is matched, the request is redirected to a URL specified by urlRedirect. If
   * urlRedirect is specified, service or routeAction must not be set.
   */
  public HttpRedirectAction getUrlRedirect() {
    return urlRedirect;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HttpRouteRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HttpRouteRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HttpRouteRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HttpRouteRule();
  }

  public static class Builder {
    private String description;
    private HttpHeaderAction headerAction;
    private List<HttpRouteRuleMatch> matchRules;
    private Integer priority;
    private HttpRouteAction routeAction;
    private String service;
    private HttpRedirectAction urlRedirect;

    Builder() {}

    public Builder mergeFrom(HttpRouteRule other) {
      if (other == HttpRouteRule.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getHeaderAction() != null) {
        this.headerAction = other.headerAction;
      }
      if (other.getMatchRulesList() != null) {
        this.matchRules = other.matchRules;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getRouteAction() != null) {
        this.routeAction = other.routeAction;
      }
      if (other.getService() != null) {
        this.service = other.service;
      }
      if (other.getUrlRedirect() != null) {
        this.urlRedirect = other.urlRedirect;
      }
      return this;
    }

    Builder(HttpRouteRule source) {
      this.description = source.description;
      this.headerAction = source.headerAction;
      this.matchRules = source.matchRules;
      this.priority = source.priority;
      this.routeAction = source.routeAction;
      this.service = source.service;
      this.urlRedirect = source.urlRedirect;
    }

    /**
     * The short description conveying the intent of this routeRule. The description can have a
     * maximum length of 1024 characters.
     */
    public String getDescription() {
      return description;
    }

    /**
     * The short description conveying the intent of this routeRule. The description can have a
     * maximum length of 1024 characters.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. The headerAction specified here are applied before the matching
     * pathMatchers[].headerAction and after
     * pathMatchers[].routeRules[].routeAction.weightedBackendService.backendServiceWeightAction[].headerAction
     */
    public HttpHeaderAction getHeaderAction() {
      return headerAction;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. The headerAction specified here are applied before the matching
     * pathMatchers[].headerAction and after
     * pathMatchers[].routeRules[].routeAction.weightedBackendService.backendServiceWeightAction[].headerAction
     */
    public Builder setHeaderAction(HttpHeaderAction headerAction) {
      this.headerAction = headerAction;
      return this;
    }

    public List<HttpRouteRuleMatch> getMatchRulesList() {
      return matchRules;
    }

    public Builder addAllMatchRules(List<HttpRouteRuleMatch> matchRules) {
      if (this.matchRules == null) {
        this.matchRules = new LinkedList<>();
      }
      this.matchRules.addAll(matchRules);
      return this;
    }

    public Builder addMatchRules(HttpRouteRuleMatch matchRules) {
      if (this.matchRules == null) {
        this.matchRules = new LinkedList<>();
      }
      this.matchRules.add(matchRules);
      return this;
    }

    /**
     * For routeRules within a given pathMatcher, priority determines the order in which load
     * balancer will interpret routeRules. RouteRules are evaluated in order of priority, from the
     * lowest to highest number. The priority of a rule decreases as its number increases (1, 2, 3,
     * N+1). The first rule that matches the request is applied. You cannot configure two or more
     * routeRules with the same priority. Priority for each rule must be set to a number between 0
     * and 2147483647 inclusive. Priority numbers can have gaps, which enable you to add or remove
     * rules in the future without affecting the rest of the rules. For example, 1, 2, 3, 4, 5, 9,
     * 12, 16 is a valid series of priority numbers to which you could add rules numbered from 6 to
     * 8, 10 to 11, and 13 to 15 in the future without any impact on existing rules.
     */
    public Integer getPriority() {
      return priority;
    }

    /**
     * For routeRules within a given pathMatcher, priority determines the order in which load
     * balancer will interpret routeRules. RouteRules are evaluated in order of priority, from the
     * lowest to highest number. The priority of a rule decreases as its number increases (1, 2, 3,
     * N+1). The first rule that matches the request is applied. You cannot configure two or more
     * routeRules with the same priority. Priority for each rule must be set to a number between 0
     * and 2147483647 inclusive. Priority numbers can have gaps, which enable you to add or remove
     * rules in the future without affecting the rest of the rules. For example, 1, 2, 3, 4, 5, 9,
     * 12, 16 is a valid series of priority numbers to which you could add rules numbered from 6 to
     * 8, 10 to 11, and 13 to 15 in the future without any impact on existing rules.
     */
    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    /**
     * In response to a matching matchRule, the load balancer performs advanced routing actions like
     * URL rewrites, header transformations, etc. prior to forwarding the request to the selected
     * backend. If routeAction specifies any weightedBackendServices, service must not be set.
     * Conversely if service is set, routeAction cannot contain any weightedBackendServices. Only
     * one of urlRedirect, service or routeAction.weightedBackendService must be set.
     */
    public HttpRouteAction getRouteAction() {
      return routeAction;
    }

    /**
     * In response to a matching matchRule, the load balancer performs advanced routing actions like
     * URL rewrites, header transformations, etc. prior to forwarding the request to the selected
     * backend. If routeAction specifies any weightedBackendServices, service must not be set.
     * Conversely if service is set, routeAction cannot contain any weightedBackendServices. Only
     * one of urlRedirect, service or routeAction.weightedBackendService must be set.
     */
    public Builder setRouteAction(HttpRouteAction routeAction) {
      this.routeAction = routeAction;
      return this;
    }

    /**
     * The full or partial URL of the backend service resource to which traffic is directed if this
     * rule is matched. If routeAction is additionally specified, advanced routing actions like URL
     * Rewrites, etc. take effect prior to sending the request to the backend. However, if service
     * is specified, routeAction cannot contain any weightedBackendService s. Conversely, if
     * routeAction specifies any weightedBackendServices, service must not be specified. Only one of
     * urlRedirect, service or routeAction.weightedBackendService must be set.
     */
    public String getService() {
      return service;
    }

    /**
     * The full or partial URL of the backend service resource to which traffic is directed if this
     * rule is matched. If routeAction is additionally specified, advanced routing actions like URL
     * Rewrites, etc. take effect prior to sending the request to the backend. However, if service
     * is specified, routeAction cannot contain any weightedBackendService s. Conversely, if
     * routeAction specifies any weightedBackendServices, service must not be specified. Only one of
     * urlRedirect, service or routeAction.weightedBackendService must be set.
     */
    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    /**
     * When this rule is matched, the request is redirected to a URL specified by urlRedirect. If
     * urlRedirect is specified, service or routeAction must not be set.
     */
    public HttpRedirectAction getUrlRedirect() {
      return urlRedirect;
    }

    /**
     * When this rule is matched, the request is redirected to a URL specified by urlRedirect. If
     * urlRedirect is specified, service or routeAction must not be set.
     */
    public Builder setUrlRedirect(HttpRedirectAction urlRedirect) {
      this.urlRedirect = urlRedirect;
      return this;
    }

    public HttpRouteRule build() {

      return new HttpRouteRule(
          description, headerAction, matchRules, priority, routeAction, service, urlRedirect);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setHeaderAction(this.headerAction);
      newBuilder.addAllMatchRules(this.matchRules);
      newBuilder.setPriority(this.priority);
      newBuilder.setRouteAction(this.routeAction);
      newBuilder.setService(this.service);
      newBuilder.setUrlRedirect(this.urlRedirect);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HttpRouteRule{"
        + "description="
        + description
        + ", "
        + "headerAction="
        + headerAction
        + ", "
        + "matchRules="
        + matchRules
        + ", "
        + "priority="
        + priority
        + ", "
        + "routeAction="
        + routeAction
        + ", "
        + "service="
        + service
        + ", "
        + "urlRedirect="
        + urlRedirect
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpRouteRule) {
      HttpRouteRule that = (HttpRouteRule) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.headerAction, that.getHeaderAction())
          && Objects.equals(this.matchRules, that.getMatchRulesList())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.routeAction, that.getRouteAction())
          && Objects.equals(this.service, that.getService())
          && Objects.equals(this.urlRedirect, that.getUrlRedirect());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        description, headerAction, matchRules, priority, routeAction, service, urlRedirect);
  }
}
