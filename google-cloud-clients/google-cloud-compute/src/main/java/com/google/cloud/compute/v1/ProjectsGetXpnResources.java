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
public final class ProjectsGetXpnResources implements ApiMessage {
  private final String kind;
  private final String nextPageToken;
  private final List<XpnResourceId> resources;

  private ProjectsGetXpnResources() {
    this.kind = null;
    this.nextPageToken = null;
    this.resources = null;
  }

  private ProjectsGetXpnResources(
      String kind, String nextPageToken, List<XpnResourceId> resources) {
    this.kind = kind;
    this.nextPageToken = nextPageToken;
    this.resources = resources;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("nextPageToken")) {
      return nextPageToken;
    }
    if (fieldName.equals("resources")) {
      return resources;
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

  public String getKind() {
    return kind;
  }

  public String getNextPageToken() {
    return nextPageToken;
  }

  public List<XpnResourceId> getResourcesList() {
    return resources;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ProjectsGetXpnResources prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ProjectsGetXpnResources getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ProjectsGetXpnResources DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ProjectsGetXpnResources();
  }

  public static class Builder {
    private String kind;
    private String nextPageToken;
    private List<XpnResourceId> resources;

    Builder() {}

    public Builder mergeFrom(ProjectsGetXpnResources other) {
      if (other == ProjectsGetXpnResources.getDefaultInstance()) return this;
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getNextPageToken() != null) {
        this.nextPageToken = other.nextPageToken;
      }
      if (other.getResourcesList() != null) {
        this.resources = other.resources;
      }
      return this;
    }

    Builder(ProjectsGetXpnResources source) {
      this.kind = source.kind;
      this.nextPageToken = source.nextPageToken;
      this.resources = source.resources;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getNextPageToken() {
      return nextPageToken;
    }

    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
      return this;
    }

    public List<XpnResourceId> getResourcesList() {
      return resources;
    }

    public Builder addAllResources(List<XpnResourceId> resources) {
      if (this.resources == null) {
        this.resources = new ArrayList<>(resources.size());
      }
      this.resources.addAll(resources);
      return this;
    }

    public Builder addResources(XpnResourceId resources) {
      this.resources.add(resources);
      return this;
    }

    public ProjectsGetXpnResources build() {

      return new ProjectsGetXpnResources(kind, nextPageToken, resources);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKind(this.kind);
      newBuilder.setNextPageToken(this.nextPageToken);
      newBuilder.addAllResources(this.resources);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ProjectsGetXpnResources{"
        + "kind="
        + kind
        + ", "
        + "nextPageToken="
        + nextPageToken
        + ", "
        + "resources="
        + resources
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectsGetXpnResources) {
      ProjectsGetXpnResources that = (ProjectsGetXpnResources) o;
      return Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.nextPageToken, that.getNextPageToken())
          && Objects.equals(this.resources, that.getResourcesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, nextPageToken, resources);
  }
}
