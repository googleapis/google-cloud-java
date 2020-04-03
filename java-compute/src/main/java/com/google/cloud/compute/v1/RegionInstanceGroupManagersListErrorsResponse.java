/*
 * Copyright 2020 Google LLC
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
public final class RegionInstanceGroupManagersListErrorsResponse implements ApiMessage {
  private final List<InstanceManagedByIgmError> items;
  private final String nextPageToken;

  private RegionInstanceGroupManagersListErrorsResponse() {
    this.items = null;
    this.nextPageToken = null;
  }

  private RegionInstanceGroupManagersListErrorsResponse(
      List<InstanceManagedByIgmError> items, String nextPageToken) {
    this.items = items;
    this.nextPageToken = nextPageToken;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("items".equals(fieldName)) {
      return items;
    }
    if ("nextPageToken".equals(fieldName)) {
      return nextPageToken;
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

  /** [Output Only] The list of errors of the managed instance group. */
  public List<InstanceManagedByIgmError> getItemsList() {
    return items;
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

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupManagersListErrorsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupManagersListErrorsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupManagersListErrorsResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupManagersListErrorsResponse();
  }

  public static class Builder {
    private List<InstanceManagedByIgmError> items;
    private String nextPageToken;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupManagersListErrorsResponse other) {
      if (other == RegionInstanceGroupManagersListErrorsResponse.getDefaultInstance()) return this;
      if (other.getItemsList() != null) {
        this.items = other.items;
      }
      if (other.getNextPageToken() != null) {
        this.nextPageToken = other.nextPageToken;
      }
      return this;
    }

    Builder(RegionInstanceGroupManagersListErrorsResponse source) {
      this.items = source.items;
      this.nextPageToken = source.nextPageToken;
    }

    /** [Output Only] The list of errors of the managed instance group. */
    public List<InstanceManagedByIgmError> getItemsList() {
      return items;
    }

    /** [Output Only] The list of errors of the managed instance group. */
    public Builder addAllItems(List<InstanceManagedByIgmError> items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.addAll(items);
      return this;
    }

    /** [Output Only] The list of errors of the managed instance group. */
    public Builder addItems(InstanceManagedByIgmError items) {
      if (this.items == null) {
        this.items = new LinkedList<>();
      }
      this.items.add(items);
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

    public RegionInstanceGroupManagersListErrorsResponse build() {

      return new RegionInstanceGroupManagersListErrorsResponse(items, nextPageToken);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllItems(this.items);
      newBuilder.setNextPageToken(this.nextPageToken);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupManagersListErrorsResponse{"
        + "items="
        + items
        + ", "
        + "nextPageToken="
        + nextPageToken
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupManagersListErrorsResponse) {
      RegionInstanceGroupManagersListErrorsResponse that =
          (RegionInstanceGroupManagersListErrorsResponse) o;
      return Objects.equals(this.items, that.getItemsList())
          && Objects.equals(this.nextPageToken, that.getNextPageToken());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, nextPageToken);
  }
}
