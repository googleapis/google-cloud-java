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
public final class RegionInstanceGroupManagersDeleteInstancesRequest implements ApiMessage {
  private final List<String> instances;

  private RegionInstanceGroupManagersDeleteInstancesRequest() {
    this.instances = null;
  }

  private RegionInstanceGroupManagersDeleteInstancesRequest(List<String> instances) {
    this.instances = instances;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instances".equals(fieldName)) {
      return instances;
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

  /**
   * The URLs of one or more instances to delete. This can be a full URL or a partial URL, such as
   * zones/[ZONE]/instances/[INSTANCE_NAME].
   */
  public List<String> getInstancesList() {
    return instances;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupManagersDeleteInstancesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupManagersDeleteInstancesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupManagersDeleteInstancesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupManagersDeleteInstancesRequest();
  }

  public static class Builder {
    private List<String> instances;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupManagersDeleteInstancesRequest other) {
      if (other == RegionInstanceGroupManagersDeleteInstancesRequest.getDefaultInstance())
        return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      return this;
    }

    Builder(RegionInstanceGroupManagersDeleteInstancesRequest source) {
      this.instances = source.instances;
    }

    /**
     * The URLs of one or more instances to delete. This can be a full URL or a partial URL, such as
     * zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public List<String> getInstancesList() {
      return instances;
    }

    /**
     * The URLs of one or more instances to delete. This can be a full URL or a partial URL, such as
     * zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public Builder addAllInstances(List<String> instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.addAll(instances);
      return this;
    }

    /**
     * The URLs of one or more instances to delete. This can be a full URL or a partial URL, such as
     * zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public Builder addInstances(String instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.add(instances);
      return this;
    }

    public RegionInstanceGroupManagersDeleteInstancesRequest build() {
      return new RegionInstanceGroupManagersDeleteInstancesRequest(instances);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupManagersDeleteInstancesRequest{" + "instances=" + instances + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupManagersDeleteInstancesRequest) {
      RegionInstanceGroupManagersDeleteInstancesRequest that =
          (RegionInstanceGroupManagersDeleteInstancesRequest) o;
      return Objects.equals(this.instances, that.getInstancesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances);
  }
}
