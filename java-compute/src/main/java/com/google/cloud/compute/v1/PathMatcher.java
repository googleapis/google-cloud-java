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
/**
 * A matcher for the path portion of the URL. The BackendService from the longest-matched rule will
 * serve the URL. If no rule was matched, the default service will be used.
 */
public final class PathMatcher implements ApiMessage {
  private final HttpRouteAction defaultRouteAction;
  private final String defaultService;
  private final HttpRedirectAction defaultUrlRedirect;
  private final String description;
  private final HttpHeaderAction headerAction;
  private final String name;
  private final List<PathRule> pathRules;
  private final List<HttpRouteRule> routeRules;

  private PathMatcher() {
    this.defaultRouteAction = null;
    this.defaultService = null;
    this.defaultUrlRedirect = null;
    this.description = null;
    this.headerAction = null;
    this.name = null;
    this.pathRules = null;
    this.routeRules = null;
  }

  private PathMatcher(
      HttpRouteAction defaultRouteAction,
      String defaultService,
      HttpRedirectAction defaultUrlRedirect,
      String description,
      HttpHeaderAction headerAction,
      String name,
      List<PathRule> pathRules,
      List<HttpRouteRule> routeRules) {
    this.defaultRouteAction = defaultRouteAction;
    this.defaultService = defaultService;
    this.defaultUrlRedirect = defaultUrlRedirect;
    this.description = description;
    this.headerAction = headerAction;
    this.name = name;
    this.pathRules = pathRules;
    this.routeRules = routeRules;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("defaultRouteAction".equals(fieldName)) {
      return defaultRouteAction;
    }
    if ("defaultService".equals(fieldName)) {
      return defaultService;
    }
    if ("defaultUrlRedirect".equals(fieldName)) {
      return defaultUrlRedirect;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("headerAction".equals(fieldName)) {
      return headerAction;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("pathRules".equals(fieldName)) {
      return pathRules;
    }
    if ("routeRules".equals(fieldName)) {
      return routeRules;
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
   * defaultRouteAction takes effect when none of the pathRules or routeRules match. The load
   * balancer performs advanced routing actions like URL rewrites, header transformations, etc.
   * prior to forwarding the request to the selected backend. If defaultRouteAction specifies any
   * weightedBackendServices, defaultService must not be set. Conversely if defaultService is set,
   * defaultRouteAction cannot contain any weightedBackendServices. Only one of defaultRouteAction
   * or defaultUrlRedirect must be set.
   */
  public HttpRouteAction getDefaultRouteAction() {
    return defaultRouteAction;
  }

  /**
   * The full or partial URL to the BackendService resource. This will be used if none of the
   * pathRules or routeRules defined by this PathMatcher are matched. For example, the following are
   * all valid URLs to a BackendService resource: -
   * https://www.googleapis.com/compute/v1/projects/project/global/backendServices/backendService -
   * compute/v1/projects/project/global/backendServices/backendService -
   * global/backendServices/backendService If defaultRouteAction is additionally specified, advanced
   * routing actions like URL Rewrites, etc. take effect prior to sending the request to the
   * backend. However, if defaultService is specified, defaultRouteAction cannot contain any
   * weightedBackendServices. Conversely, if defaultRouteAction specifies any
   * weightedBackendServices, defaultService must not be specified. Only one of defaultService,
   * defaultUrlRedirect or defaultRouteAction.weightedBackendService must be set. Authorization
   * requires one or more of the following Google IAM permissions on the specified resource
   * default_service: - compute.backendBuckets.use - compute.backendServices.use
   */
  public String getDefaultService() {
    return defaultService;
  }

  /**
   * When when none of the specified pathRules or routeRules match, the request is redirected to a
   * URL specified by defaultUrlRedirect. If defaultUrlRedirect is specified, defaultService or
   * defaultRouteAction must not be set.
   */
  public HttpRedirectAction getDefaultUrlRedirect() {
    return defaultUrlRedirect;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Specifies changes to request and response headers that need to take effect for the selected
   * backendService. HeaderAction specified here are applied after the matching HttpRouteRule
   * HeaderAction and before the HeaderAction in the UrlMap
   */
  public HttpHeaderAction getHeaderAction() {
    return headerAction;
  }

  /** The name to which this PathMatcher is referred by the HostRule. */
  public String getName() {
    return name;
  }

  /**
   * The list of path rules. Use this list instead of routeRules when routing based on simple path
   * matching is all that's required. The order by which path rules are specified does not matter.
   * Matches are always done on the longest-path-first basis. For example: a pathRule with a path
   * /a/b/c/&#42; will match before /a/b/&#42; irrespective of the order in which those paths appear
   * in this list. Within a given pathMatcher, only one of pathRules or routeRules must be set.
   */
  public List<PathRule> getPathRulesList() {
    return pathRules;
  }

  /**
   * The list of ordered HTTP route rules. Use this list instead of pathRules when advanced route
   * matching and routing actions are desired. The order of specifying routeRules matters: the first
   * rule that matches will cause its specified routing action to take effect. Within a given
   * pathMatcher, only one of pathRules or routeRules must be set. routeRules are not supported in
   * UrlMaps intended for External Load balancers.
   */
  public List<HttpRouteRule> getRouteRulesList() {
    return routeRules;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PathMatcher prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PathMatcher getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PathMatcher DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PathMatcher();
  }

  public static class Builder {
    private HttpRouteAction defaultRouteAction;
    private String defaultService;
    private HttpRedirectAction defaultUrlRedirect;
    private String description;
    private HttpHeaderAction headerAction;
    private String name;
    private List<PathRule> pathRules;
    private List<HttpRouteRule> routeRules;

    Builder() {}

    public Builder mergeFrom(PathMatcher other) {
      if (other == PathMatcher.getDefaultInstance()) return this;
      if (other.getDefaultRouteAction() != null) {
        this.defaultRouteAction = other.defaultRouteAction;
      }
      if (other.getDefaultService() != null) {
        this.defaultService = other.defaultService;
      }
      if (other.getDefaultUrlRedirect() != null) {
        this.defaultUrlRedirect = other.defaultUrlRedirect;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getHeaderAction() != null) {
        this.headerAction = other.headerAction;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPathRulesList() != null) {
        this.pathRules = other.pathRules;
      }
      if (other.getRouteRulesList() != null) {
        this.routeRules = other.routeRules;
      }
      return this;
    }

    Builder(PathMatcher source) {
      this.defaultRouteAction = source.defaultRouteAction;
      this.defaultService = source.defaultService;
      this.defaultUrlRedirect = source.defaultUrlRedirect;
      this.description = source.description;
      this.headerAction = source.headerAction;
      this.name = source.name;
      this.pathRules = source.pathRules;
      this.routeRules = source.routeRules;
    }

    /**
     * defaultRouteAction takes effect when none of the pathRules or routeRules match. The load
     * balancer performs advanced routing actions like URL rewrites, header transformations, etc.
     * prior to forwarding the request to the selected backend. If defaultRouteAction specifies any
     * weightedBackendServices, defaultService must not be set. Conversely if defaultService is set,
     * defaultRouteAction cannot contain any weightedBackendServices. Only one of defaultRouteAction
     * or defaultUrlRedirect must be set.
     */
    public HttpRouteAction getDefaultRouteAction() {
      return defaultRouteAction;
    }

    /**
     * defaultRouteAction takes effect when none of the pathRules or routeRules match. The load
     * balancer performs advanced routing actions like URL rewrites, header transformations, etc.
     * prior to forwarding the request to the selected backend. If defaultRouteAction specifies any
     * weightedBackendServices, defaultService must not be set. Conversely if defaultService is set,
     * defaultRouteAction cannot contain any weightedBackendServices. Only one of defaultRouteAction
     * or defaultUrlRedirect must be set.
     */
    public Builder setDefaultRouteAction(HttpRouteAction defaultRouteAction) {
      this.defaultRouteAction = defaultRouteAction;
      return this;
    }

    /**
     * The full or partial URL to the BackendService resource. This will be used if none of the
     * pathRules or routeRules defined by this PathMatcher are matched. For example, the following
     * are all valid URLs to a BackendService resource: -
     * https://www.googleapis.com/compute/v1/projects/project/global/backendServices/backendService
     * - compute/v1/projects/project/global/backendServices/backendService -
     * global/backendServices/backendService If defaultRouteAction is additionally specified,
     * advanced routing actions like URL Rewrites, etc. take effect prior to sending the request to
     * the backend. However, if defaultService is specified, defaultRouteAction cannot contain any
     * weightedBackendServices. Conversely, if defaultRouteAction specifies any
     * weightedBackendServices, defaultService must not be specified. Only one of defaultService,
     * defaultUrlRedirect or defaultRouteAction.weightedBackendService must be set. Authorization
     * requires one or more of the following Google IAM permissions on the specified resource
     * default_service: - compute.backendBuckets.use - compute.backendServices.use
     */
    public String getDefaultService() {
      return defaultService;
    }

    /**
     * The full or partial URL to the BackendService resource. This will be used if none of the
     * pathRules or routeRules defined by this PathMatcher are matched. For example, the following
     * are all valid URLs to a BackendService resource: -
     * https://www.googleapis.com/compute/v1/projects/project/global/backendServices/backendService
     * - compute/v1/projects/project/global/backendServices/backendService -
     * global/backendServices/backendService If defaultRouteAction is additionally specified,
     * advanced routing actions like URL Rewrites, etc. take effect prior to sending the request to
     * the backend. However, if defaultService is specified, defaultRouteAction cannot contain any
     * weightedBackendServices. Conversely, if defaultRouteAction specifies any
     * weightedBackendServices, defaultService must not be specified. Only one of defaultService,
     * defaultUrlRedirect or defaultRouteAction.weightedBackendService must be set. Authorization
     * requires one or more of the following Google IAM permissions on the specified resource
     * default_service: - compute.backendBuckets.use - compute.backendServices.use
     */
    public Builder setDefaultService(String defaultService) {
      this.defaultService = defaultService;
      return this;
    }

    /**
     * When when none of the specified pathRules or routeRules match, the request is redirected to a
     * URL specified by defaultUrlRedirect. If defaultUrlRedirect is specified, defaultService or
     * defaultRouteAction must not be set.
     */
    public HttpRedirectAction getDefaultUrlRedirect() {
      return defaultUrlRedirect;
    }

    /**
     * When when none of the specified pathRules or routeRules match, the request is redirected to a
     * URL specified by defaultUrlRedirect. If defaultUrlRedirect is specified, defaultService or
     * defaultRouteAction must not be set.
     */
    public Builder setDefaultUrlRedirect(HttpRedirectAction defaultUrlRedirect) {
      this.defaultUrlRedirect = defaultUrlRedirect;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. HeaderAction specified here are applied after the matching HttpRouteRule
     * HeaderAction and before the HeaderAction in the UrlMap
     */
    public HttpHeaderAction getHeaderAction() {
      return headerAction;
    }

    /**
     * Specifies changes to request and response headers that need to take effect for the selected
     * backendService. HeaderAction specified here are applied after the matching HttpRouteRule
     * HeaderAction and before the HeaderAction in the UrlMap
     */
    public Builder setHeaderAction(HttpHeaderAction headerAction) {
      this.headerAction = headerAction;
      return this;
    }

    /** The name to which this PathMatcher is referred by the HostRule. */
    public String getName() {
      return name;
    }

    /** The name to which this PathMatcher is referred by the HostRule. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The list of path rules. Use this list instead of routeRules when routing based on simple path
     * matching is all that's required. The order by which path rules are specified does not matter.
     * Matches are always done on the longest-path-first basis. For example: a pathRule with a path
     * /a/b/c/&#42; will match before /a/b/&#42; irrespective of the order in which those paths
     * appear in this list. Within a given pathMatcher, only one of pathRules or routeRules must be
     * set.
     */
    public List<PathRule> getPathRulesList() {
      return pathRules;
    }

    /**
     * The list of path rules. Use this list instead of routeRules when routing based on simple path
     * matching is all that's required. The order by which path rules are specified does not matter.
     * Matches are always done on the longest-path-first basis. For example: a pathRule with a path
     * /a/b/c/&#42; will match before /a/b/&#42; irrespective of the order in which those paths
     * appear in this list. Within a given pathMatcher, only one of pathRules or routeRules must be
     * set.
     */
    public Builder addAllPathRules(List<PathRule> pathRules) {
      if (this.pathRules == null) {
        this.pathRules = new LinkedList<>();
      }
      this.pathRules.addAll(pathRules);
      return this;
    }

    /**
     * The list of path rules. Use this list instead of routeRules when routing based on simple path
     * matching is all that's required. The order by which path rules are specified does not matter.
     * Matches are always done on the longest-path-first basis. For example: a pathRule with a path
     * /a/b/c/&#42; will match before /a/b/&#42; irrespective of the order in which those paths
     * appear in this list. Within a given pathMatcher, only one of pathRules or routeRules must be
     * set.
     */
    public Builder addPathRules(PathRule pathRules) {
      if (this.pathRules == null) {
        this.pathRules = new LinkedList<>();
      }
      this.pathRules.add(pathRules);
      return this;
    }

    /**
     * The list of ordered HTTP route rules. Use this list instead of pathRules when advanced route
     * matching and routing actions are desired. The order of specifying routeRules matters: the
     * first rule that matches will cause its specified routing action to take effect. Within a
     * given pathMatcher, only one of pathRules or routeRules must be set. routeRules are not
     * supported in UrlMaps intended for External Load balancers.
     */
    public List<HttpRouteRule> getRouteRulesList() {
      return routeRules;
    }

    /**
     * The list of ordered HTTP route rules. Use this list instead of pathRules when advanced route
     * matching and routing actions are desired. The order of specifying routeRules matters: the
     * first rule that matches will cause its specified routing action to take effect. Within a
     * given pathMatcher, only one of pathRules or routeRules must be set. routeRules are not
     * supported in UrlMaps intended for External Load balancers.
     */
    public Builder addAllRouteRules(List<HttpRouteRule> routeRules) {
      if (this.routeRules == null) {
        this.routeRules = new LinkedList<>();
      }
      this.routeRules.addAll(routeRules);
      return this;
    }

    /**
     * The list of ordered HTTP route rules. Use this list instead of pathRules when advanced route
     * matching and routing actions are desired. The order of specifying routeRules matters: the
     * first rule that matches will cause its specified routing action to take effect. Within a
     * given pathMatcher, only one of pathRules or routeRules must be set. routeRules are not
     * supported in UrlMaps intended for External Load balancers.
     */
    public Builder addRouteRules(HttpRouteRule routeRules) {
      if (this.routeRules == null) {
        this.routeRules = new LinkedList<>();
      }
      this.routeRules.add(routeRules);
      return this;
    }

    public PathMatcher build() {

      return new PathMatcher(
          defaultRouteAction,
          defaultService,
          defaultUrlRedirect,
          description,
          headerAction,
          name,
          pathRules,
          routeRules);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDefaultRouteAction(this.defaultRouteAction);
      newBuilder.setDefaultService(this.defaultService);
      newBuilder.setDefaultUrlRedirect(this.defaultUrlRedirect);
      newBuilder.setDescription(this.description);
      newBuilder.setHeaderAction(this.headerAction);
      newBuilder.setName(this.name);
      newBuilder.addAllPathRules(this.pathRules);
      newBuilder.addAllRouteRules(this.routeRules);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PathMatcher{"
        + "defaultRouteAction="
        + defaultRouteAction
        + ", "
        + "defaultService="
        + defaultService
        + ", "
        + "defaultUrlRedirect="
        + defaultUrlRedirect
        + ", "
        + "description="
        + description
        + ", "
        + "headerAction="
        + headerAction
        + ", "
        + "name="
        + name
        + ", "
        + "pathRules="
        + pathRules
        + ", "
        + "routeRules="
        + routeRules
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PathMatcher) {
      PathMatcher that = (PathMatcher) o;
      return Objects.equals(this.defaultRouteAction, that.getDefaultRouteAction())
          && Objects.equals(this.defaultService, that.getDefaultService())
          && Objects.equals(this.defaultUrlRedirect, that.getDefaultUrlRedirect())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.headerAction, that.getHeaderAction())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.pathRules, that.getPathRulesList())
          && Objects.equals(this.routeRules, that.getRouteRulesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        defaultRouteAction,
        defaultService,
        defaultUrlRedirect,
        description,
        headerAction,
        name,
        pathRules,
        routeRules);
  }
}
