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
public final class InstanceGroupManagersListManagedInstancesResponse implements ApiMessage {
  private final List<ManagedInstance> managedInstances;

  private InstanceGroupManagersListManagedInstancesResponse() {
    this.managedInstances = null;
  }

  private InstanceGroupManagersListManagedInstancesResponse(
      List<ManagedInstance> managedInstances) {
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

  public List<ManagedInstance> getManagedInstancesList() {
    return managedInstances;
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

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersListManagedInstancesResponse other) {
      if (other == InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance())
        return this;
      if (other.getManagedInstancesList() != null) {
        this.managedInstances = other.managedInstances;
      }
      return this;
    }

    Builder(InstanceGroupManagersListManagedInstancesResponse source) {
      this.managedInstances = source.managedInstances;
    }

    public List<ManagedInstance> getManagedInstancesList() {
      return managedInstances;
    }

    public Builder addAllManagedInstances(List<ManagedInstance> managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.addAll(managedInstances);
      return this;
    }

    public Builder addManagedInstances(ManagedInstance managedInstances) {
      if (this.managedInstances == null) {
        this.managedInstances = new LinkedList<>();
      }
      this.managedInstances.add(managedInstances);
      return this;
    }

    public InstanceGroupManagersListManagedInstancesResponse build() {
      return new InstanceGroupManagersListManagedInstancesResponse(managedInstances);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllManagedInstances(this.managedInstances);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersListManagedInstancesResponse{"
        + "managedInstances="
        + managedInstances
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
      return Objects.equals(this.managedInstances, that.getManagedInstancesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(managedInstances);
  }
}
