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
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("nextPageToken".equals(fieldName)) {
      return nextPageToken;
    }
    if ("resources".equals(fieldName)) {
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
   * [Output Only] Type of resource. Always compute#projectsGetXpnResources for lists of service
   * resources (a.k.a service projects)
   */
  public String getKind() {
    return kind;
  }

  /**
   * [Output Only] This token allows you to get the next page of results for list requests. If the
   * number of results is larger than maxResults, use the nextPageToken as a value for the query
   * parameter pageToken in the next list request. Subsequent list requests will have their own
   * nextPageToken to continue paging through the results.
   */
  public String getNextPageToken() {
    return nextPageToken;
  }

  /**
   * Service resources (a.k.a service projects) attached to this project as their shared VPC host.
   */
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

    /**
     * [Output Only] Type of resource. Always compute#projectsGetXpnResources for lists of service
     * resources (a.k.a service projects)
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of resource. Always compute#projectsGetXpnResources for lists of service
     * resources (a.k.a service projects)
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * [Output Only] This token allows you to get the next page of results for list requests. If the
     * number of results is larger than maxResults, use the nextPageToken as a value for the query
     * parameter pageToken in the next list request. Subsequent list requests will have their own
     * nextPageToken to continue paging through the results.
     */
    public String getNextPageToken() {
      return nextPageToken;
    }

    /**
     * [Output Only] This token allows you to get the next page of results for list requests. If the
     * number of results is larger than maxResults, use the nextPageToken as a value for the query
     * parameter pageToken in the next list request. Subsequent list requests will have their own
     * nextPageToken to continue paging through the results.
     */
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
      return this;
    }

    /**
     * Service resources (a.k.a service projects) attached to this project as their shared VPC host.
     */
    public List<XpnResourceId> getResourcesList() {
      return resources;
    }

    /**
     * Service resources (a.k.a service projects) attached to this project as their shared VPC host.
     */
    public Builder addAllResources(List<XpnResourceId> resources) {
      if (this.resources == null) {
        this.resources = new LinkedList<>();
      }
      this.resources.addAll(resources);
      return this;
    }

    /**
     * Service resources (a.k.a service projects) attached to this project as their shared VPC host.
     */
    public Builder addResources(XpnResourceId resources) {
      if (this.resources == null) {
        this.resources = new LinkedList<>();
      }
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
