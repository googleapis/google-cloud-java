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
public final class VmEndpointNatMappings implements ApiMessage {
  private final String instanceName;
  private final List<VmEndpointNatMappingsInterfaceNatMappings> interfaceNatMappings;

  private VmEndpointNatMappings() {
    this.instanceName = null;
    this.interfaceNatMappings = null;
  }

  private VmEndpointNatMappings(
      String instanceName, List<VmEndpointNatMappingsInterfaceNatMappings> interfaceNatMappings) {
    this.instanceName = instanceName;
    this.interfaceNatMappings = interfaceNatMappings;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("instanceName")) {
      return instanceName;
    }
    if (fieldName.equals("interfaceNatMappings")) {
      return interfaceNatMappings;
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

  public String getInstanceName() {
    return instanceName;
  }

  public List<VmEndpointNatMappingsInterfaceNatMappings> getInterfaceNatMappingsList() {
    return interfaceNatMappings;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VmEndpointNatMappings prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VmEndpointNatMappings getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VmEndpointNatMappings DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VmEndpointNatMappings();
  }

  public static class Builder {
    private String instanceName;
    private List<VmEndpointNatMappingsInterfaceNatMappings> interfaceNatMappings;

    Builder() {}

    public Builder mergeFrom(VmEndpointNatMappings other) {
      if (other == VmEndpointNatMappings.getDefaultInstance()) return this;
      if (other.getInstanceName() != null) {
        this.instanceName = other.instanceName;
      }
      if (other.getInterfaceNatMappingsList() != null) {
        this.interfaceNatMappings = other.interfaceNatMappings;
      }
      return this;
    }

    Builder(VmEndpointNatMappings source) {
      this.instanceName = source.instanceName;
      this.interfaceNatMappings = source.interfaceNatMappings;
    }

    public String getInstanceName() {
      return instanceName;
    }

    public Builder setInstanceName(String instanceName) {
      this.instanceName = instanceName;
      return this;
    }

    public List<VmEndpointNatMappingsInterfaceNatMappings> getInterfaceNatMappingsList() {
      return interfaceNatMappings;
    }

    public Builder addAllInterfaceNatMappings(
        List<VmEndpointNatMappingsInterfaceNatMappings> interfaceNatMappings) {
      if (this.interfaceNatMappings == null) {
        this.interfaceNatMappings = new LinkedList<>();
      }
      this.interfaceNatMappings.addAll(interfaceNatMappings);
      return this;
    }

    public Builder addInterfaceNatMappings(
        VmEndpointNatMappingsInterfaceNatMappings interfaceNatMappings) {
      if (this.interfaceNatMappings == null) {
        this.interfaceNatMappings = new LinkedList<>();
      }
      this.interfaceNatMappings.add(interfaceNatMappings);
      return this;
    }

    public VmEndpointNatMappings build() {

      return new VmEndpointNatMappings(instanceName, interfaceNatMappings);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceName(this.instanceName);
      newBuilder.addAllInterfaceNatMappings(this.interfaceNatMappings);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VmEndpointNatMappings{"
        + "instanceName="
        + instanceName
        + ", "
        + "interfaceNatMappings="
        + interfaceNatMappings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VmEndpointNatMappings) {
      VmEndpointNatMappings that = (VmEndpointNatMappings) o;
      return Objects.equals(this.instanceName, that.getInstanceName())
          && Objects.equals(this.interfaceNatMappings, that.getInterfaceNatMappingsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceName, interfaceNatMappings);
  }
}
