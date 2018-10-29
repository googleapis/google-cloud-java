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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InstancesSetMachineResourcesRequest implements ApiMessage {
  private final List<AcceleratorConfig> guestAccelerators;

  private InstancesSetMachineResourcesRequest() {
    this.guestAccelerators = null;
  }

  private InstancesSetMachineResourcesRequest(List<AcceleratorConfig> guestAccelerators) {
    this.guestAccelerators = guestAccelerators;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("guestAccelerators")) {
      return guestAccelerators;
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

  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstancesSetMachineResourcesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstancesSetMachineResourcesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstancesSetMachineResourcesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstancesSetMachineResourcesRequest();
  }

  public static class Builder {
    private List<AcceleratorConfig> guestAccelerators;

    Builder() {}

    public Builder mergeFrom(InstancesSetMachineResourcesRequest other) {
      if (other == InstancesSetMachineResourcesRequest.getDefaultInstance()) return this;
      if (other.getGuestAcceleratorsList() != null) {
        this.guestAccelerators = other.guestAccelerators;
      }
      return this;
    }

    Builder(InstancesSetMachineResourcesRequest source) {
      this.guestAccelerators = source.guestAccelerators;
    }

    public List<AcceleratorConfig> getGuestAcceleratorsList() {
      return guestAccelerators;
    }

    public Builder addAllGuestAccelerators(List<AcceleratorConfig> guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.addAll(guestAccelerators);
      return this;
    }

    public Builder addGuestAccelerators(AcceleratorConfig guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.add(guestAccelerators);
      return this;
    }

    public InstancesSetMachineResourcesRequest build() {
      return new InstancesSetMachineResourcesRequest(guestAccelerators);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllGuestAccelerators(this.guestAccelerators);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstancesSetMachineResourcesRequest{" + "guestAccelerators=" + guestAccelerators + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstancesSetMachineResourcesRequest) {
      InstancesSetMachineResourcesRequest that = (InstancesSetMachineResourcesRequest) o;
      return Objects.equals(this.guestAccelerators, that.getGuestAcceleratorsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestAccelerators);
  }
}
