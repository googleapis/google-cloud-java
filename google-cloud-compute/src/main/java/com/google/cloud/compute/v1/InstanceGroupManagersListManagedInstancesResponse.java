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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
      List<ManagedInstance> managedInstances
      ) {
    this.managedInstances = managedInstances;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("managedInstances") && managedInstances != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (ManagedInstance item : managedInstances) {
        stringList.add(item.toString());
      }
      fieldMap.put("managedInstances", stringList.build());
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("managedInstances")) {
      return String.valueOf(managedInstances);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
      if (other == InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance()) return this;
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
        this.managedInstances = new ArrayList<>(managedInstances.size());
      }
      this.managedInstances.addAll(managedInstances);
      return this;
    }

    public Builder addManagedInstances(ManagedInstance managedInstances) {
      this.managedInstances.add(managedInstances);
      return this;
    }


    public InstanceGroupManagersListManagedInstancesResponse build() {
      return new InstanceGroupManagersListManagedInstancesResponse(
        managedInstances
      );
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
        + "managedInstances=" + managedInstances
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersListManagedInstancesResponse) {
      InstanceGroupManagersListManagedInstancesResponse that = (InstanceGroupManagersListManagedInstancesResponse) o;
      return
          Objects.equals(this.managedInstances, that.getManagedInstancesList())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      managedInstances
    );
  }
}
