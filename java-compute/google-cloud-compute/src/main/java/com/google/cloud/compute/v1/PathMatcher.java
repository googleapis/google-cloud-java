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
  private final String defaultService;
  private final String description;
  private final String name;
  private final List<PathRule> pathRules;

  private PathMatcher() {
    this.defaultService = null;
    this.description = null;
    this.name = null;
    this.pathRules = null;
  }

  private PathMatcher(
      String defaultService, String description, String name, List<PathRule> pathRules) {
    this.defaultService = defaultService;
    this.description = description;
    this.name = name;
    this.pathRules = pathRules;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("defaultService".equals(fieldName)) {
      return defaultService;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("pathRules".equals(fieldName)) {
      return pathRules;
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
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
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
   * in this list. Only one of pathRules or routeRules must be set.
   */
  public List<PathRule> getPathRulesList() {
    return pathRules;
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
    private String defaultService;
    private String description;
    private String name;
    private List<PathRule> pathRules;

    Builder() {}

    public Builder mergeFrom(PathMatcher other) {
      if (other == PathMatcher.getDefaultInstance()) return this;
      if (other.getDefaultService() != null) {
        this.defaultService = other.defaultService;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPathRulesList() != null) {
        this.pathRules = other.pathRules;
      }
      return this;
    }

    Builder(PathMatcher source) {
      this.defaultService = source.defaultService;
      this.description = source.description;
      this.name = source.name;
      this.pathRules = source.pathRules;
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
     * appear in this list. Only one of pathRules or routeRules must be set.
     */
    public List<PathRule> getPathRulesList() {
      return pathRules;
    }

    /**
     * The list of path rules. Use this list instead of routeRules when routing based on simple path
     * matching is all that's required. The order by which path rules are specified does not matter.
     * Matches are always done on the longest-path-first basis. For example: a pathRule with a path
     * /a/b/c/&#42; will match before /a/b/&#42; irrespective of the order in which those paths
     * appear in this list. Only one of pathRules or routeRules must be set.
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
     * appear in this list. Only one of pathRules or routeRules must be set.
     */
    public Builder addPathRules(PathRule pathRules) {
      if (this.pathRules == null) {
        this.pathRules = new LinkedList<>();
      }
      this.pathRules.add(pathRules);
      return this;
    }

    public PathMatcher build() {

      return new PathMatcher(defaultService, description, name, pathRules);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDefaultService(this.defaultService);
      newBuilder.setDescription(this.description);
      newBuilder.setName(this.name);
      newBuilder.addAllPathRules(this.pathRules);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PathMatcher{"
        + "defaultService="
        + defaultService
        + ", "
        + "description="
        + description
        + ", "
        + "name="
        + name
        + ", "
        + "pathRules="
        + pathRules
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PathMatcher) {
      PathMatcher that = (PathMatcher) o;
      return Objects.equals(this.defaultService, that.getDefaultService())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.pathRules, that.getPathRulesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultService, description, name, pathRules);
  }
}
