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
/** Status of a NAT contained in this router. */
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
    if ("autoAllocatedNatIps".equals(fieldName)) {
      return autoAllocatedNatIps;
    }
    if ("minExtraNatIpsNeeded".equals(fieldName)) {
      return minExtraNatIpsNeeded;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("numVmEndpointsWithNatMappings".equals(fieldName)) {
      return numVmEndpointsWithNatMappings;
    }
    if ("userAllocatedNatIpResources".equals(fieldName)) {
      return userAllocatedNatIpResources;
    }
    if ("userAllocatedNatIps".equals(fieldName)) {
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** A list of IPs auto-allocated for NAT. Example: ["1.1.1.1", "129.2.16.89"] */
  public List<String> getAutoAllocatedNatIpsList() {
    return autoAllocatedNatIps;
  }

  /**
   * The number of extra IPs to allocate. This will be greater than 0 only if user-specified IPs are
   * NOT enough to allow all configured VMs to use NAT. This value is meaningful only when
   * auto-allocation of NAT IPs is &#42;not&#42; used.
   */
  public Integer getMinExtraNatIpsNeeded() {
    return minExtraNatIpsNeeded;
  }

  /** Unique name of this NAT. */
  public String getName() {
    return name;
  }

  /** Number of VM endpoints (i.e., Nics) that can use NAT. */
  public Integer getNumVmEndpointsWithNatMappings() {
    return numVmEndpointsWithNatMappings;
  }

  /** A list of fully qualified URLs of reserved IP address resources. */
  public List<String> getUserAllocatedNatIpResourcesList() {
    return userAllocatedNatIpResources;
  }

  /** A list of IPs user-allocated for NAT. They will be raw IP strings like "179.12.26.133". */
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

    /** A list of IPs auto-allocated for NAT. Example: ["1.1.1.1", "129.2.16.89"] */
    public List<String> getAutoAllocatedNatIpsList() {
      return autoAllocatedNatIps;
    }

    /** A list of IPs auto-allocated for NAT. Example: ["1.1.1.1", "129.2.16.89"] */
    public Builder addAllAutoAllocatedNatIps(List<String> autoAllocatedNatIps) {
      if (this.autoAllocatedNatIps == null) {
        this.autoAllocatedNatIps = new LinkedList<>();
      }
      this.autoAllocatedNatIps.addAll(autoAllocatedNatIps);
      return this;
    }

    /** A list of IPs auto-allocated for NAT. Example: ["1.1.1.1", "129.2.16.89"] */
    public Builder addAutoAllocatedNatIps(String autoAllocatedNatIps) {
      if (this.autoAllocatedNatIps == null) {
        this.autoAllocatedNatIps = new LinkedList<>();
      }
      this.autoAllocatedNatIps.add(autoAllocatedNatIps);
      return this;
    }

    /**
     * The number of extra IPs to allocate. This will be greater than 0 only if user-specified IPs
     * are NOT enough to allow all configured VMs to use NAT. This value is meaningful only when
     * auto-allocation of NAT IPs is &#42;not&#42; used.
     */
    public Integer getMinExtraNatIpsNeeded() {
      return minExtraNatIpsNeeded;
    }

    /**
     * The number of extra IPs to allocate. This will be greater than 0 only if user-specified IPs
     * are NOT enough to allow all configured VMs to use NAT. This value is meaningful only when
     * auto-allocation of NAT IPs is &#42;not&#42; used.
     */
    public Builder setMinExtraNatIpsNeeded(Integer minExtraNatIpsNeeded) {
      this.minExtraNatIpsNeeded = minExtraNatIpsNeeded;
      return this;
    }

    /** Unique name of this NAT. */
    public String getName() {
      return name;
    }

    /** Unique name of this NAT. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** Number of VM endpoints (i.e., Nics) that can use NAT. */
    public Integer getNumVmEndpointsWithNatMappings() {
      return numVmEndpointsWithNatMappings;
    }

    /** Number of VM endpoints (i.e., Nics) that can use NAT. */
    public Builder setNumVmEndpointsWithNatMappings(Integer numVmEndpointsWithNatMappings) {
      this.numVmEndpointsWithNatMappings = numVmEndpointsWithNatMappings;
      return this;
    }

    /** A list of fully qualified URLs of reserved IP address resources. */
    public List<String> getUserAllocatedNatIpResourcesList() {
      return userAllocatedNatIpResources;
    }

    /** A list of fully qualified URLs of reserved IP address resources. */
    public Builder addAllUserAllocatedNatIpResources(List<String> userAllocatedNatIpResources) {
      if (this.userAllocatedNatIpResources == null) {
        this.userAllocatedNatIpResources = new LinkedList<>();
      }
      this.userAllocatedNatIpResources.addAll(userAllocatedNatIpResources);
      return this;
    }

    /** A list of fully qualified URLs of reserved IP address resources. */
    public Builder addUserAllocatedNatIpResources(String userAllocatedNatIpResources) {
      if (this.userAllocatedNatIpResources == null) {
        this.userAllocatedNatIpResources = new LinkedList<>();
      }
      this.userAllocatedNatIpResources.add(userAllocatedNatIpResources);
      return this;
    }

    /** A list of IPs user-allocated for NAT. They will be raw IP strings like "179.12.26.133". */
    public List<String> getUserAllocatedNatIpsList() {
      return userAllocatedNatIps;
    }

    /** A list of IPs user-allocated for NAT. They will be raw IP strings like "179.12.26.133". */
    public Builder addAllUserAllocatedNatIps(List<String> userAllocatedNatIps) {
      if (this.userAllocatedNatIps == null) {
        this.userAllocatedNatIps = new LinkedList<>();
      }
      this.userAllocatedNatIps.addAll(userAllocatedNatIps);
      return this;
    }

    /** A list of IPs user-allocated for NAT. They will be raw IP strings like "179.12.26.133". */
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
