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
public final class InstanceGroupManagersAbandonInstancesRequest implements ApiMessage {
  private final List<String> instances;

  private InstanceGroupManagersAbandonInstancesRequest() {
    this.instances = null;
  }

  private InstanceGroupManagersAbandonInstancesRequest(List<String> instances) {
    this.instances = instances;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("instances")) {
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

  public List<String> getInstancesList() {
    return instances;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersAbandonInstancesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersAbandonInstancesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersAbandonInstancesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersAbandonInstancesRequest();
  }

  public static class Builder {
    private List<String> instances;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersAbandonInstancesRequest other) {
      if (other == InstanceGroupManagersAbandonInstancesRequest.getDefaultInstance()) return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      return this;
    }

    Builder(InstanceGroupManagersAbandonInstancesRequest source) {
      this.instances = source.instances;
    }

    public List<String> getInstancesList() {
      return instances;
    }

    public Builder addAllInstances(List<String> instances) {
      if (this.instances == null) {
        this.instances = new ArrayList<>(instances.size());
      }
      this.instances.addAll(instances);
      return this;
    }

    public Builder addInstances(String instances) {
      this.instances.add(instances);
      return this;
    }

    public InstanceGroupManagersAbandonInstancesRequest build() {
      return new InstanceGroupManagersAbandonInstancesRequest(instances);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersAbandonInstancesRequest{" + "instances=" + instances + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersAbandonInstancesRequest) {
      InstanceGroupManagersAbandonInstancesRequest that =
          (InstanceGroupManagersAbandonInstancesRequest) o;
      return Objects.equals(this.instances, that.getInstancesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances);
  }
}
