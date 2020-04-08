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
public final class InstanceGroupManagersListManagedInstancesResponse implements ApiMessage {
  private final List<ManagedInstance> managedInstances;
  private final String nextPageToken;

  private InstanceGroupManagersListManagedInstancesResponse() {
    this.managedInstances = null;
    this.nextPageToken = null;
  }

  private InstanceGroupManagersListManagedInstancesResponse(
      List<ManagedInstance> managedInstances, String nextPageToken) {
    this.managedInstances = managedInstances;
    this.nextPageToken = nextPageToken;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("managedInstances".equals(fieldName)) {
      return managedInstances;
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

  /** [Output Only] The list of instances in the managed instance group. */
  public List<ManagedInstance> getManagedInstancesList() {
    return managedInstances;
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

  public static Builder newBuilder(InstanceGroupManagersListManagedInstancesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersListManagedInstancesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersListManagedInstancesResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersListManagedInstancesResponse();
  }

  public static class Builder {
    private List<ManagedInstance> managedInstances;
    private String nextPageToken;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersListManagedInstancesResponse other) {
      if (other == InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance())
        return this;
      if (other.getManagedInstancesList() != null) {
        this.managedInstances = other.managedInstances;
      }
      if (other.getNextPageToken() != null) {
        this.nextPageToken = other.nextPageToken;
      }
      return this;
    }

    Builder(InstanceGroupManagersListManagedInstancesResponse source) {
      this.managedInstances = source.managedInstances;
      this.nextPageToken = source.nextPageToken;
    }

    /** [Output Only] The list of instances in the managed instance group. */
    public List<ManagedInstance> getManagedInstancesList() {
      return managedInstances;
    }

    /** [Output Only] The list of instances in the managed instance group. */
    public Builder addAllManagedInstances(List<ManagedInstance> managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.addAll(managedInstances);
      return this;
    }

    /** [Output Only] The list of instances in the managed instance group. */
    public Builder addManagedInstances(ManagedInstance managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.add(managedInstances);
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

    public InstanceGroupManagersListManagedInstancesResponse build() {

      return new InstanceGroupManagersListManagedInstancesResponse(managedInstances, nextPageToken);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllManagedInstances(this.managedInstances);
      newBuilder.setNextPageToken(this.nextPageToken);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersListManagedInstancesResponse{"
        + "managedInstances="
        + managedInstances
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
    if (o instanceof InstanceGroupManagersListManagedInstancesResponse) {
      InstanceGroupManagersListManagedInstancesResponse that =
          (InstanceGroupManagersListManagedInstancesResponse) o;
      return Objects.equals(this.managedInstances, that.getManagedInstancesList())
          && Objects.equals(this.nextPageToken, that.getNextPageToken());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(managedInstances, nextPageToken);
  }
}
