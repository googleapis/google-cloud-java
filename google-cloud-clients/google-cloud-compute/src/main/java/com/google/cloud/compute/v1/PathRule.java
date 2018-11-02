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
    if (fieldName.equals("paths")) {
      return paths;
    }
    if (fieldName.equals("service")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<String> getPathsList() {
    return paths;
  }

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

    public List<String> getPathsList() {
      return paths;
    }

    public Builder addAllPaths(List<String> paths) {
      if (this.paths == null) {
        this.paths = new LinkedList<>();
      }
      this.paths.addAll(paths);
      return this;
    }

    public Builder addPaths(String paths) {
      if (this.paths == null) {
        this.paths = new LinkedList<>();
      }
      this.paths.add(paths);
      return this;
    }

    public String getService() {
      return service;
    }

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
