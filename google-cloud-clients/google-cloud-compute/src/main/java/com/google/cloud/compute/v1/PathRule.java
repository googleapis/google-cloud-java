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
 * A path-matching rule for a URL. If matched, will use the specified BackendService to handle the
 * traffic arriving at this URL.
 */
public final class PathRule implements ApiMessage {
  private final List<String> paths;
  private final String service;

  private PathRule() {
    this.paths = null;
    this.service = null;
  }

  private PathRule(List<String> paths, String service) {
    this.paths = paths;
    this.service = service;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("paths".equals(fieldName)) {
      return paths;
    }
    if ("service".equals(fieldName)) {
      return service;
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
   * The list of path patterns to match. Each must start with / and the only place a &#42; is
   * allowed is at the end following a /. The string fed to the path matcher does not include any
   * text after the first ? or #, and those chars are not allowed here.
   */
  public List<String> getPathsList() {
    return paths;
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

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PathRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PathRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PathRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PathRule();
  }

  public static class Builder {
    private List<String> paths;
    private String service;

    Builder() {}

    public Builder mergeFrom(PathRule other) {
      if (other == PathRule.getDefaultInstance()) return this;
      if (other.getPathsList() != null) {
        this.paths = other.paths;
      }
      if (other.getService() != null) {
        this.service = other.service;
      }
      return this;
    }

    Builder(PathRule source) {
      this.paths = source.paths;
      this.service = source.service;
    }

    /**
     * The list of path patterns to match. Each must start with / and the only place a &#42; is
     * allowed is at the end following a /. The string fed to the path matcher does not include any
     * text after the first ? or #, and those chars are not allowed here.
     */
    public List<String> getPathsList() {
      return paths;
    }

    /**
     * The list of path patterns to match. Each must start with / and the only place a &#42; is
     * allowed is at the end following a /. The string fed to the path matcher does not include any
     * text after the first ? or #, and those chars are not allowed here.
     */
    public Builder addAllPaths(List<String> paths) {
      if (this.paths == null) {
        this.paths = new LinkedList<>();
      }
      this.paths.addAll(paths);
      return this;
    }

    /**
     * The list of path patterns to match. Each must start with / and the only place a &#42; is
     * allowed is at the end following a /. The string fed to the path matcher does not include any
     * text after the first ? or #, and those chars are not allowed here.
     */
    public Builder addPaths(String paths) {
      if (this.paths == null) {
        this.paths = new LinkedList<>();
      }
      this.paths.add(paths);
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

    public PathRule build() {

      return new PathRule(paths, service);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllPaths(this.paths);
      newBuilder.setService(this.service);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PathRule{" + "paths=" + paths + ", " + "service=" + service + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PathRule) {
      PathRule that = (PathRule) o;
      return Objects.equals(this.paths, that.getPathsList())
          && Objects.equals(this.service, that.getService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(paths, service);
  }
}
