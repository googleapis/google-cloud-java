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
/** [Output Only] A list of managed instance groups. */
public final class InstanceGroupManagerList implements ApiMessage {
  private final String id;
  private final List<InstanceGroupManager> items;
  private final String kind;
  private final String nextPageToken;
  private final String selfLink;
  private final Warning warning;

  private InstanceGroupManagerList() {
    this.id = null;
    this.items = null;
    this.kind = null;
    this.nextPageToken = null;
    this.selfLink = null;
    this.warning = null;
  }

  private InstanceGroupManagerList(
      String id,
      List<InstanceGroupManager> items,
      String kind,
      String nextPageToken,
      String selfLink,
      Warning warning) {
    this.id = id;
    this.items = items;
    this.kind = kind;
    this.nextPageToken = nextPageToken;
    this.selfLink = selfLink;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("items".equals(fieldName)) {
      return items;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("nextPageToken".equals(fieldName)) {
      return nextPageToken;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** [Output Only] Unique identifier for the resource; defined by the server. */
  public String getId() {
    return id;
  }

  /** A list of InstanceGroupManager resources. */
  public List<InstanceGroupManager> getItemsList() {
    return items;
  }

  /**
   * [Output Only] The resource type, which is always compute#instanceGroupManagerList for a list of
   * managed instance groups.
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

  /** [Output Only] Server-defined URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Informational warning message. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerList();
  }

  public static class Builder {
    private String id;
    private List<InstanceGroupManager> items;
    private String kind;
    private String nextPageToken;
    private String selfLink;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerList other) {
      if (other == InstanceGroupManagerList.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getItemsList() != null) {
        this.items = other.items;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getNextPageToken() != null) {
        this.nextPageToken = other.nextPageToken;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(InstanceGroupManagerList source) {
      this.id = source.id;
      this.items = source.items;
      this.kind = source.kind;
      this.nextPageToken = source.nextPageToken;
      this.selfLink = source.selfLink;
      this.warning = source.warning;
    }

    /** [Output Only] Unique identifier for the resource; defined by the server. */
    public String getId() {
      return id;
    }

    /** [Output Only] Unique identifier for the resource; defined by the server. */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** A list of InstanceGroupManager resources. */
    public List<InstanceGroupManager> getItemsList() {
      return items;
    }

    /** A list of InstanceGroupManager resources. */
    public Builder addAllItems(List<InstanceGroupManager> items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.addAll(items);
      return this;
    }

    /** A list of InstanceGroupManager resources. */
    public Builder addItems(InstanceGroupManager items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.add(items);
      return this;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceGroupManagerList for a list
     * of managed instance groups.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceGroupManagerList for a list
     * of managed instance groups.
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

    /** [Output Only] Server-defined URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] Informational warning message. */
    public Warning getWarning() {
      return warning;
    }

    /** [Output Only] Informational warning message. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public InstanceGroupManagerList build() {

      return new InstanceGroupManagerList(id, items, kind, nextPageToken, selfLink, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setId(this.id);
      newBuilder.addAllItems(this.items);
      newBuilder.setKind(this.kind);
      newBuilder.setNextPageToken(this.nextPageToken);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerList{"
        + "id="
        + id
        + ", "
        + "items="
        + items
        + ", "
        + "kind="
        + kind
        + ", "
        + "nextPageToken="
        + nextPageToken
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerList) {
      InstanceGroupManagerList that = (InstanceGroupManagerList) o;
      return Objects.equals(this.id, that.getId())
          && Objects.equals(this.items, that.getItemsList())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.nextPageToken, that.getNextPageToken())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, items, kind, nextPageToken, selfLink, warning);
  }
}
