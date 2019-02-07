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
public final class RegionInstanceGroupManagersListInstancesResponse implements ApiMessage {
  private final List<ManagedInstance> managedInstances;

  private RegionInstanceGroupManagersListInstancesResponse() {
    this.managedInstances = null;
  }

  private RegionInstanceGroupManagersListInstancesResponse(List<ManagedInstance> managedInstances) {
    this.managedInstances = managedInstances;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("managedInstances".equals(fieldName)) {
      return managedInstances;
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

  /** A list of managed instances. */
  public List<ManagedInstance> getManagedInstancesList() {
    return managedInstances;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupManagersListInstancesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupManagersListInstancesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupManagersListInstancesResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupManagersListInstancesResponse();
  }

  public static class Builder {
    private List<ManagedInstance> managedInstances;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupManagersListInstancesResponse other) {
      if (other == RegionInstanceGroupManagersListInstancesResponse.getDefaultInstance())
        return this;
      if (other.getManagedInstancesList() != null) {
        this.managedInstances = other.managedInstances;
      }
      return this;
    }

    Builder(RegionInstanceGroupManagersListInstancesResponse source) {
      this.managedInstances = source.managedInstances;
    }

    /** A list of managed instances. */
    public List<ManagedInstance> getManagedInstancesList() {
      return managedInstances;
    }

    /** A list of managed instances. */
    public Builder addAllManagedInstances(List<ManagedInstance> managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.addAll(managedInstances);
      return this;
    }

    /** A list of managed instances. */
    public Builder addManagedInstances(ManagedInstance managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.add(managedInstances);
      return this;
    }

    public RegionInstanceGroupManagersListInstancesResponse build() {
      return new RegionInstanceGroupManagersListInstancesResponse(managedInstances);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllManagedInstances(this.managedInstances);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupManagersListInstancesResponse{"
        + "managedInstances="
        + managedInstances
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupManagersListInstancesResponse) {
      RegionInstanceGroupManagersListInstancesResponse that =
          (RegionInstanceGroupManagersListInstancesResponse) o;
      return Objects.equals(this.managedInstances, that.getManagedInstancesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(managedInstances);
  }
}
