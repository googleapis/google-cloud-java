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
 * UrlMaps A host-matching rule for a URL. If matched, will use the named PathMatcher to select the
 * BackendService.
 */
public final class HostRule implements ApiMessage {
  private final String description;
  private final List<String> hosts;
  private final String pathMatcher;

  private HostRule() {
    this.description = null;
    this.hosts = null;
    this.pathMatcher = null;
  }

  private HostRule(String description, List<String> hosts, String pathMatcher) {
    this.description = description;
    this.hosts = hosts;
    this.pathMatcher = pathMatcher;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("hosts".equals(fieldName)) {
      return hosts;
    }
    if ("pathMatcher".equals(fieldName)) {
      return pathMatcher;
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
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The list of host patterns to match. They must be valid hostnames, except &#42; will match any
   * string of ([a-z0-9-.]&#42;). In that case, &#42; must be the first character and must be
   * followed in the pattern by either - or ..
   */
  public List<String> getHostsList() {
    return hosts;
  }

  /**
   * The name of the PathMatcher to use to match the path portion of the URL if the hostRule matches
   * the URL's host portion.
   */
  public String getPathMatcher() {
    return pathMatcher;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(HostRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static HostRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final HostRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new HostRule();
  }

  public static class Builder {
    private String description;
    private List<String> hosts;
    private String pathMatcher;

    Builder() {}

    public Builder mergeFrom(HostRule other) {
      if (other == HostRule.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getHostsList() != null) {
        this.hosts = other.hosts;
      }
      if (other.getPathMatcher() != null) {
        this.pathMatcher = other.pathMatcher;
      }
      return this;
    }

    Builder(HostRule source) {
      this.description = source.description;
      this.hosts = source.hosts;
      this.pathMatcher = source.pathMatcher;
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
     * The list of host patterns to match. They must be valid hostnames, except &#42; will match any
     * string of ([a-z0-9-.]&#42;). In that case, &#42; must be the first character and must be
     * followed in the pattern by either - or ..
     */
    public List<String> getHostsList() {
      return hosts;
    }

    /**
     * The list of host patterns to match. They must be valid hostnames, except &#42; will match any
     * string of ([a-z0-9-.]&#42;). In that case, &#42; must be the first character and must be
     * followed in the pattern by either - or ..
     */
    public Builder addAllHosts(List<String> hosts) {
      if (this.hosts == null) {
        this.hosts = new LinkedList<>();
      }
      this.hosts.addAll(hosts);
      return this;
    }

    /**
     * The list of host patterns to match. They must be valid hostnames, except &#42; will match any
     * string of ([a-z0-9-.]&#42;). In that case, &#42; must be the first character and must be
     * followed in the pattern by either - or ..
     */
    public Builder addHosts(String hosts) {
      if (this.hosts == null) {
        this.hosts = new LinkedList<>();
      }
      this.hosts.add(hosts);
      return this;
    }

    /**
     * The name of the PathMatcher to use to match the path portion of the URL if the hostRule
     * matches the URL's host portion.
     */
    public String getPathMatcher() {
      return pathMatcher;
    }

    /**
     * The name of the PathMatcher to use to match the path portion of the URL if the hostRule
     * matches the URL's host portion.
     */
    public Builder setPathMatcher(String pathMatcher) {
      this.pathMatcher = pathMatcher;
      return this;
    }

    public HostRule build() {

      return new HostRule(description, hosts, pathMatcher);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.addAllHosts(this.hosts);
      newBuilder.setPathMatcher(this.pathMatcher);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "HostRule{"
        + "description="
        + description
        + ", "
        + "hosts="
        + hosts
        + ", "
        + "pathMatcher="
        + pathMatcher
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostRule) {
      HostRule that = (HostRule) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.hosts, that.getHostsList())
          && Objects.equals(this.pathMatcher, that.getPathMatcher());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, hosts, pathMatcher);
  }
}
