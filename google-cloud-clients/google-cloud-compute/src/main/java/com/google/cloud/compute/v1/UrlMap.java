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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    this.selfLink = selfLink;
    this.tests = tests;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("defaultService")) {
      return defaultService;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
    }
    if (fieldName.equals("hostRules")) {
      return hostRules;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("pathMatchers")) {
      return pathMatchers;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("tests")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDefaultService() {
    return defaultService;
  }

  public String getDescription() {
    return description;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public List<HostRule> getHostRulesList() {
    return hostRules;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public List<PathMatcher> getPathMatchersList() {
    return pathMatchers;
  }

  public String getSelfLink() {
    return selfLink;
  }

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
      this.selfLink = source.selfLink;
      this.tests = source.tests;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDefaultService() {
      return defaultService;
    }

    public Builder setDefaultService(String defaultService) {
      this.defaultService = defaultService;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public List<HostRule> getHostRulesList() {
      return hostRules;
    }

    public Builder addAllHostRules(List<HostRule> hostRules) {
      if (this.hostRules == null) {
        this.hostRules = new LinkedList<>();
      }
      this.hostRules.addAll(hostRules);
      return this;
    }

    public Builder addHostRules(HostRule hostRules) {
      if (this.hostRules == null) {
        this.hostRules = new LinkedList<>();
      }
      this.hostRules.add(hostRules);
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public List<PathMatcher> getPathMatchersList() {
      return pathMatchers;
    }

    public Builder addAllPathMatchers(List<PathMatcher> pathMatchers) {
      if (this.pathMatchers == null) {
        this.pathMatchers = new LinkedList<>();
      }
      this.pathMatchers.addAll(pathMatchers);
      return this;
    }

    public Builder addPathMatchers(PathMatcher pathMatchers) {
      if (this.pathMatchers == null) {
        this.pathMatchers = new LinkedList<>();
      }
      this.pathMatchers.add(pathMatchers);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<UrlMapTest> getTestsList() {
      return tests;
    }

    public Builder addAllTests(List<UrlMapTest> tests) {
      if (this.tests == null) {
        this.tests = new LinkedList<>();
      }
      this.tests.addAll(tests);
      return this;
    }

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
        selfLink,
        tests);
  }
}
