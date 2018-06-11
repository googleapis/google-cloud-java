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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("hosts")) {
      return hosts;
    }
    if (fieldName.equals("pathMatcher")) {
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

  public String getDescription() {
    return description;
  }

  public List<String> getHostsList() {
    return hosts;
  }

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

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public List<String> getHostsList() {
      return hosts;
    }

    public Builder addAllHosts(List<String> hosts) {
      if (this.hosts == null) {
        this.hosts = new ArrayList<>(hosts.size());
      }
      this.hosts.addAll(hosts);
      return this;
    }

    public Builder addHosts(String hosts) {
      this.hosts.add(hosts);
      return this;
    }

    public String getPathMatcher() {
      return pathMatcher;
    }

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
