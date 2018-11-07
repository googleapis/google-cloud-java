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
public final class RouterStatusNatStatus implements ApiMessage {
  private final List<String> autoAllocatedNatIps;
  private final Integer minExtraNatIpsNeeded;
  private final String name;
  private final Integer numVmEndpointsWithNatMappings;
  private final List<String> userAllocatedNatIpResources;
  private final List<String> userAllocatedNatIps;

  private RouterStatusNatStatus() {
    this.autoAllocatedNatIps = null;
    this.minExtraNatIpsNeeded = null;
    this.name = null;
    this.numVmEndpointsWithNatMappings = null;
    this.userAllocatedNatIpResources = null;
    this.userAllocatedNatIps = null;
  }

  private RouterStatusNatStatus(
      List<String> autoAllocatedNatIps,
      Integer minExtraNatIpsNeeded,
      String name,
      Integer numVmEndpointsWithNatMappings,
      List<String> userAllocatedNatIpResources,
      List<String> userAllocatedNatIps) {
    this.autoAllocatedNatIps = autoAllocatedNatIps;
    this.minExtraNatIpsNeeded = minExtraNatIpsNeeded;
    this.name = name;
    this.numVmEndpointsWithNatMappings = numVmEndpointsWithNatMappings;
    this.userAllocatedNatIpResources = userAllocatedNatIpResources;
    this.userAllocatedNatIps = userAllocatedNatIps;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("autoAllocatedNatIps")) {
      return autoAllocatedNatIps;
    }
    if (fieldName.equals("minExtraNatIpsNeeded")) {
      return minExtraNatIpsNeeded;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("numVmEndpointsWithNatMappings")) {
      return numVmEndpointsWithNatMappings;
    }
    if (fieldName.equals("userAllocatedNatIpResources")) {
      return userAllocatedNatIpResources;
    }
    if (fieldName.equals("userAllocatedNatIps")) {
      return userAllocatedNatIps;
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

  public List<String> getAutoAllocatedNatIpsList() {
    return autoAllocatedNatIps;
  }

  public Integer getMinExtraNatIpsNeeded() {
    return minExtraNatIpsNeeded;
  }

  public String getName() {
    return name;
  }

  public Integer getNumVmEndpointsWithNatMappings() {
    return numVmEndpointsWithNatMappings;
  }

  public List<String> getUserAllocatedNatIpResourcesList() {
    return userAllocatedNatIpResources;
  }

  public List<String> getUserAllocatedNatIpsList() {
    return userAllocatedNatIps;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterStatusNatStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterStatusNatStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterStatusNatStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterStatusNatStatus();
  }

  public static class Builder {
    private List<String> autoAllocatedNatIps;
    private Integer minExtraNatIpsNeeded;
    private String name;
    private Integer numVmEndpointsWithNatMappings;
    private List<String> userAllocatedNatIpResources;
    private List<String> userAllocatedNatIps;

    Builder() {}

    public Builder mergeFrom(RouterStatusNatStatus other) {
      if (other == RouterStatusNatStatus.getDefaultInstance()) return this;
      if (other.getAutoAllocatedNatIpsList() != null) {
        this.autoAllocatedNatIps = other.autoAllocatedNatIps;
      }
      if (other.getMinExtraNatIpsNeeded() != null) {
        this.minExtraNatIpsNeeded = other.minExtraNatIpsNeeded;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNumVmEndpointsWithNatMappings() != null) {
        this.numVmEndpointsWithNatMappings = other.numVmEndpointsWithNatMappings;
      }
      if (other.getUserAllocatedNatIpResourcesList() != null) {
        this.userAllocatedNatIpResources = other.userAllocatedNatIpResources;
      }
      if (other.getUserAllocatedNatIpsList() != null) {
        this.userAllocatedNatIps = other.userAllocatedNatIps;
      }
      return this;
    }

    Builder(RouterStatusNatStatus source) {
      this.autoAllocatedNatIps = source.autoAllocatedNatIps;
      this.minExtraNatIpsNeeded = source.minExtraNatIpsNeeded;
      this.name = source.name;
      this.numVmEndpointsWithNatMappings = source.numVmEndpointsWithNatMappings;
      this.userAllocatedNatIpResources = source.userAllocatedNatIpResources;
      this.userAllocatedNatIps = source.userAllocatedNatIps;
    }

    public List<String> getAutoAllocatedNatIpsList() {
      return autoAllocatedNatIps;
    }

    public Builder addAllAutoAllocatedNatIps(List<String> autoAllocatedNatIps) {
      if (this.autoAllocatedNatIps == null) {
        this.autoAllocatedNatIps = new LinkedList<>();
      }
      this.autoAllocatedNatIps.addAll(autoAllocatedNatIps);
      return this;
    }

    public Builder addAutoAllocatedNatIps(String autoAllocatedNatIps) {
      if (this.autoAllocatedNatIps == null) {
        this.autoAllocatedNatIps = new LinkedList<>();
      }
      this.autoAllocatedNatIps.add(autoAllocatedNatIps);
      return this;
    }

    public Integer getMinExtraNatIpsNeeded() {
      return minExtraNatIpsNeeded;
    }

    public Builder setMinExtraNatIpsNeeded(Integer minExtraNatIpsNeeded) {
      this.minExtraNatIpsNeeded = minExtraNatIpsNeeded;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getNumVmEndpointsWithNatMappings() {
      return numVmEndpointsWithNatMappings;
    }

    public Builder setNumVmEndpointsWithNatMappings(Integer numVmEndpointsWithNatMappings) {
      this.numVmEndpointsWithNatMappings = numVmEndpointsWithNatMappings;
      return this;
    }

    public List<String> getUserAllocatedNatIpResourcesList() {
      return userAllocatedNatIpResources;
    }

    public Builder addAllUserAllocatedNatIpResources(List<String> userAllocatedNatIpResources) {
      if (this.userAllocatedNatIpResources == null) {
        this.userAllocatedNatIpResources = new LinkedList<>();
      }
      this.userAllocatedNatIpResources.addAll(userAllocatedNatIpResources);
      return this;
    }

    public Builder addUserAllocatedNatIpResources(String userAllocatedNatIpResources) {
      if (this.userAllocatedNatIpResources == null) {
        this.userAllocatedNatIpResources = new LinkedList<>();
      }
      this.userAllocatedNatIpResources.add(userAllocatedNatIpResources);
      return this;
    }

    public List<String> getUserAllocatedNatIpsList() {
      return userAllocatedNatIps;
    }

    public Builder addAllUserAllocatedNatIps(List<String> userAllocatedNatIps) {
      if (this.userAllocatedNatIps == null) {
        this.userAllocatedNatIps = new LinkedList<>();
      }
      this.userAllocatedNatIps.addAll(userAllocatedNatIps);
      return this;
    }

    public Builder addUserAllocatedNatIps(String userAllocatedNatIps) {
      if (this.userAllocatedNatIps == null) {
        this.userAllocatedNatIps = new LinkedList<>();
      }
      this.userAllocatedNatIps.add(userAllocatedNatIps);
      return this;
    }

    public RouterStatusNatStatus build() {

      return new RouterStatusNatStatus(
          autoAllocatedNatIps,
          minExtraNatIpsNeeded,
          name,
          numVmEndpointsWithNatMappings,
          userAllocatedNatIpResources,
          userAllocatedNatIps);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAutoAllocatedNatIps(this.autoAllocatedNatIps);
      newBuilder.setMinExtraNatIpsNeeded(this.minExtraNatIpsNeeded);
      newBuilder.setName(this.name);
      newBuilder.setNumVmEndpointsWithNatMappings(this.numVmEndpointsWithNatMappings);
      newBuilder.addAllUserAllocatedNatIpResources(this.userAllocatedNatIpResources);
      newBuilder.addAllUserAllocatedNatIps(this.userAllocatedNatIps);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterStatusNatStatus{"
        + "autoAllocatedNatIps="
        + autoAllocatedNatIps
        + ", "
        + "minExtraNatIpsNeeded="
        + minExtraNatIpsNeeded
        + ", "
        + "name="
        + name
        + ", "
        + "numVmEndpointsWithNatMappings="
        + numVmEndpointsWithNatMappings
        + ", "
        + "userAllocatedNatIpResources="
        + userAllocatedNatIpResources
        + ", "
        + "userAllocatedNatIps="
        + userAllocatedNatIps
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterStatusNatStatus) {
      RouterStatusNatStatus that = (RouterStatusNatStatus) o;
      return Objects.equals(this.autoAllocatedNatIps, that.getAutoAllocatedNatIpsList())
          && Objects.equals(this.minExtraNatIpsNeeded, that.getMinExtraNatIpsNeeded())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(
              this.numVmEndpointsWithNatMappings, that.getNumVmEndpointsWithNatMappings())
          && Objects.equals(
              this.userAllocatedNatIpResources, that.getUserAllocatedNatIpResourcesList())
          && Objects.equals(this.userAllocatedNatIps, that.getUserAllocatedNatIpsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoAllocatedNatIps,
        minExtraNatIpsNeeded,
        name,
        numVmEndpointsWithNatMappings,
        userAllocatedNatIpResources,
        userAllocatedNatIps);
  }
}
