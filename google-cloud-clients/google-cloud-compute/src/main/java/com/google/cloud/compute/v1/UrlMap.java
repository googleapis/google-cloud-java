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
 * Represents a URL Map resource.
 *
 * <p>A URL map resource is a component of certain types of load balancers. This resource defines
 * mappings from host names and URL paths to either a backend service or a backend bucket.
 *
 * <p>To use this resource, the backend service must have a loadBalancingScheme of either EXTERNAL,
 * INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map Concepts.
 */
public final class UrlMap implements ApiMessage {
  private final String creationTimestamp;
  private final String defaultService;
  private final String description;
  private final String fingerprint;
  private final List<HostRule> hostRules;
  private final String id;
  private final String kind;
  private final String name;
  private final List<PathMatcher> pathMatchers;
  private final String region;
  private final String selfLink;
  private final List<UrlMapTest> tests;

  private UrlMap() {
    this.creationTimestamp = null;
    this.defaultService = null;
    this.description = null;
    this.fingerprint = null;
    this.hostRules = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.pathMatchers = null;
    this.region = null;
    this.selfLink = null;
    this.tests = null;
  }

  private UrlMap(
      String creationTimestamp,
      String defaultService,
      String description,
      String fingerprint,
      List<HostRule> hostRules,
      String id,
      String kind,
      String name,
      List<PathMatcher> pathMatchers,
      String region,
      String selfLink,
      List<UrlMapTest> tests) {
    this.creationTimestamp = creationTimestamp;
    this.defaultService = defaultService;
    this.description = description;
    this.fingerprint = fingerprint;
    this.hostRules = hostRules;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.pathMatchers = pathMatchers;
    this.region = region;
    this.selfLink = selfLink;
    this.tests = tests;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("defaultService".equals(fieldName)) {
      return defaultService;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("hostRules".equals(fieldName)) {
      return hostRules;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("pathMatchers".equals(fieldName)) {
      return pathMatchers;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("tests".equals(fieldName)) {
      return tests;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * The full or partial URL of the defaultService resource to which traffic is directed if none of
   * the hostRules match. If defaultRouteAction is additionally specified, advanced routing actions
   * like URL Rewrites, etc. take effect prior to sending the request to the backend. However, if
   * defaultService is specified, defaultRouteAction cannot contain any weightedBackendServices.
   * Conversely, if routeAction specifies any weightedBackendServices, service must not be
   * specified. Only one of defaultService, defaultUrlRedirect or
   * defaultRouteAction.weightedBackendService must be set.
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

  /**
   * Fingerprint of this resource. A hash of the contents stored in this object. This field is used
   * in optimistic locking. This field will be ignored when inserting a UrlMap. An up-to-date
   * fingerprint must be provided in order to update the UrlMap, otherwise the request will fail
   * with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve a UrlMap.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /** The list of HostRules to use against the URL. */
  public List<HostRule> getHostRulesList() {
    return hostRules;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#urlMaps for url maps. */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /** The list of named PathMatchers to use against the URL. */
  public List<PathMatcher> getPathMatchersList() {
    return pathMatchers;
  }

  /**
   * [Output Only] URL of the region where the regional URL map resides. This field is not
   * applicable to global URL maps. You must specify this field as part of the HTTP request URL. It
   * is not settable as a field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * The list of expected URL mapping tests. Request to update this UrlMap will succeed only if all
   * of the test cases pass. You can specify a maximum of 100 tests per UrlMap.
   */
  public List<UrlMapTest> getTestsList() {
    return tests;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMap prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMap getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMap DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMap();
  }

  public static class Builder {
    private String creationTimestamp;
    private String defaultService;
    private String description;
    private String fingerprint;
    private List<HostRule> hostRules;
    private String id;
    private String kind;
    private String name;
    private List<PathMatcher> pathMatchers;
    private String region;
    private String selfLink;
    private List<UrlMapTest> tests;

    Builder() {}

    public Builder mergeFrom(UrlMap other) {
      if (other == UrlMap.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDefaultService() != null) {
        this.defaultService = other.defaultService;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getHostRulesList() != null) {
        this.hostRules = other.hostRules;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPathMatchersList() != null) {
        this.pathMatchers = other.pathMatchers;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getTestsList() != null) {
        this.tests = other.tests;
      }
      return this;
    }

    Builder(UrlMap source) {
      this.creationTimestamp = source.creationTimestamp;
      this.defaultService = source.defaultService;
      this.description = source.description;
      this.fingerprint = source.fingerprint;
      this.hostRules = source.hostRules;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.pathMatchers = source.pathMatchers;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.tests = source.tests;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * The full or partial URL of the defaultService resource to which traffic is directed if none
     * of the hostRules match. If defaultRouteAction is additionally specified, advanced routing
     * actions like URL Rewrites, etc. take effect prior to sending the request to the backend.
     * However, if defaultService is specified, defaultRouteAction cannot contain any
     * weightedBackendServices. Conversely, if routeAction specifies any weightedBackendServices,
     * service must not be specified. Only one of defaultService, defaultUrlRedirect or
     * defaultRouteAction.weightedBackendService must be set.
     */
    public String getDefaultService() {
      return defaultService;
    }

    /**
     * The full or partial URL of the defaultService resource to which traffic is directed if none
     * of the hostRules match. If defaultRouteAction is additionally specified, advanced routing
     * actions like URL Rewrites, etc. take effect prior to sending the request to the backend.
     * However, if defaultService is specified, defaultRouteAction cannot contain any
     * weightedBackendServices. Conversely, if routeAction specifies any weightedBackendServices,
     * service must not be specified. Only one of defaultService, defaultUrlRedirect or
     * defaultRouteAction.weightedBackendService must be set.
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

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a UrlMap. An up-to-date
     * fingerprint must be provided in order to update the UrlMap, otherwise the request will fail
     * with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a UrlMap.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a UrlMap. An up-to-date
     * fingerprint must be provided in order to update the UrlMap, otherwise the request will fail
     * with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a UrlMap.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /** The list of HostRules to use against the URL. */
    public List<HostRule> getHostRulesList() {
      return hostRules;
    }

    /** The list of HostRules to use against the URL. */
    public Builder addAllHostRules(List<HostRule> hostRules) {
      if (this.hostRules == null) {
        this.hostRules = new LinkedList<>();
      }
      this.hostRules.addAll(hostRules);
      return this;
    }

    /** The list of HostRules to use against the URL. */
    public Builder addHostRules(HostRule hostRules) {
      if (this.hostRules == null) {
        this.hostRules = new LinkedList<>();
      }
      this.hostRules.add(hostRules);
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#urlMaps for url maps. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#urlMaps for url maps. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** The list of named PathMatchers to use against the URL. */
    public List<PathMatcher> getPathMatchersList() {
      return pathMatchers;
    }

    /** The list of named PathMatchers to use against the URL. */
    public Builder addAllPathMatchers(List<PathMatcher> pathMatchers) {
      if (this.pathMatchers == null) {
        this.pathMatchers = new LinkedList<>();
      }
      this.pathMatchers.addAll(pathMatchers);
      return this;
    }

    /** The list of named PathMatchers to use against the URL. */
    public Builder addPathMatchers(PathMatcher pathMatchers) {
      if (this.pathMatchers == null) {
        this.pathMatchers = new LinkedList<>();
      }
      this.pathMatchers.add(pathMatchers);
      return this;
    }

    /**
     * [Output Only] URL of the region where the regional URL map resides. This field is not
     * applicable to global URL maps. You must specify this field as part of the HTTP request URL.
     * It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the regional URL map resides. This field is not
     * applicable to global URL maps. You must specify this field as part of the HTTP request URL.
     * It is not settable as a field in the request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * The list of expected URL mapping tests. Request to update this UrlMap will succeed only if
     * all of the test cases pass. You can specify a maximum of 100 tests per UrlMap.
     */
    public List<UrlMapTest> getTestsList() {
      return tests;
    }

    /**
     * The list of expected URL mapping tests. Request to update this UrlMap will succeed only if
     * all of the test cases pass. You can specify a maximum of 100 tests per UrlMap.
     */
    public Builder addAllTests(List<UrlMapTest> tests) {
      if (this.tests == null) {
        this.tests = new LinkedList<>();
      }
      this.tests.addAll(tests);
      return this;
    }

    /**
     * The list of expected URL mapping tests. Request to update this UrlMap will succeed only if
     * all of the test cases pass. You can specify a maximum of 100 tests per UrlMap.
     */
    public Builder addTests(UrlMapTest tests) {
      if (this.tests == null) {
        this.tests = new LinkedList<>();
      }
      this.tests.add(tests);
      return this;
    }

    public UrlMap build() {

      return new UrlMap(
          creationTimestamp,
          defaultService,
          description,
          fingerprint,
          hostRules,
          id,
          kind,
          name,
          pathMatchers,
          region,
          selfLink,
          tests);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDefaultService(this.defaultService);
      newBuilder.setDescription(this.description);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllHostRules(this.hostRules);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllPathMatchers(this.pathMatchers);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllTests(this.tests);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMap{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "defaultService="
        + defaultService
        + ", "
        + "description="
        + description
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "hostRules="
        + hostRules
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "pathMatchers="
        + pathMatchers
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "tests="
        + tests
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMap) {
      UrlMap that = (UrlMap) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.defaultService, that.getDefaultService())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.hostRules, that.getHostRulesList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.pathMatchers, that.getPathMatchersList())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.tests, that.getTestsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        defaultService,
        description,
        fingerprint,
        hostRules,
        id,
        kind,
        name,
        pathMatchers,
        region,
        selfLink,
        tests);
  }
}
