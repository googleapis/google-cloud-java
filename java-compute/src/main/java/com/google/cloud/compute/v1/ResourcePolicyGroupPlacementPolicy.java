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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * A GroupPlacementPolicy specifies resource placement configuration. It specifies the failure
 * bucket separation as well as network locality
 */
public final class ResourcePolicyGroupPlacementPolicy implements ApiMessage {
  private final Integer availabilityDomainCount;
  private final String collocation;
  private final Integer vmCount;

  private ResourcePolicyGroupPlacementPolicy() {
    this.availabilityDomainCount = null;
    this.collocation = null;
    this.vmCount = null;
  }

  private ResourcePolicyGroupPlacementPolicy(
      Integer availabilityDomainCount, String collocation, Integer vmCount) {
    this.availabilityDomainCount = availabilityDomainCount;
    this.collocation = collocation;
    this.vmCount = vmCount;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("availabilityDomainCount".equals(fieldName)) {
      return availabilityDomainCount;
    }
    if ("collocation".equals(fieldName)) {
      return collocation;
    }
    if ("vmCount".equals(fieldName)) {
      return vmCount;
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

  /**
   * The number of availability domains instances will be spread across. If two instances are in
   * different availability domain, they will not be put in the same low latency network
   */
  public Integer getAvailabilityDomainCount() {
    return availabilityDomainCount;
  }

  /** Specifies network collocation */
  public String getCollocation() {
    return collocation;
  }

  /** Number of vms in this placement group */
  public Integer getVmCount() {
    return vmCount;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicyGroupPlacementPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicyGroupPlacementPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicyGroupPlacementPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicyGroupPlacementPolicy();
  }

  public static class Builder {
    private Integer availabilityDomainCount;
    private String collocation;
    private Integer vmCount;

    Builder() {}

    public Builder mergeFrom(ResourcePolicyGroupPlacementPolicy other) {
      if (other == ResourcePolicyGroupPlacementPolicy.getDefaultInstance()) return this;
      if (other.getAvailabilityDomainCount() != null) {
        this.availabilityDomainCount = other.availabilityDomainCount;
      }
      if (other.getCollocation() != null) {
        this.collocation = other.collocation;
      }
      if (other.getVmCount() != null) {
        this.vmCount = other.vmCount;
      }
      return this;
    }

    Builder(ResourcePolicyGroupPlacementPolicy source) {
      this.availabilityDomainCount = source.availabilityDomainCount;
      this.collocation = source.collocation;
      this.vmCount = source.vmCount;
    }

    /**
     * The number of availability domains instances will be spread across. If two instances are in
     * different availability domain, they will not be put in the same low latency network
     */
    public Integer getAvailabilityDomainCount() {
      return availabilityDomainCount;
    }

    /**
     * The number of availability domains instances will be spread across. If two instances are in
     * different availability domain, they will not be put in the same low latency network
     */
    public Builder setAvailabilityDomainCount(Integer availabilityDomainCount) {
      this.availabilityDomainCount = availabilityDomainCount;
      return this;
    }

    /** Specifies network collocation */
    public String getCollocation() {
      return collocation;
    }

    /** Specifies network collocation */
    public Builder setCollocation(String collocation) {
      this.collocation = collocation;
      return this;
    }

    /** Number of vms in this placement group */
    public Integer getVmCount() {
      return vmCount;
    }

    /** Number of vms in this placement group */
    public Builder setVmCount(Integer vmCount) {
      this.vmCount = vmCount;
      return this;
    }

    public ResourcePolicyGroupPlacementPolicy build() {

      return new ResourcePolicyGroupPlacementPolicy(availabilityDomainCount, collocation, vmCount);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAvailabilityDomainCount(this.availabilityDomainCount);
      newBuilder.setCollocation(this.collocation);
      newBuilder.setVmCount(this.vmCount);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicyGroupPlacementPolicy{"
        + "availabilityDomainCount="
        + availabilityDomainCount
        + ", "
        + "collocation="
        + collocation
        + ", "
        + "vmCount="
        + vmCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicyGroupPlacementPolicy) {
      ResourcePolicyGroupPlacementPolicy that = (ResourcePolicyGroupPlacementPolicy) o;
      return Objects.equals(this.availabilityDomainCount, that.getAvailabilityDomainCount())
          && Objects.equals(this.collocation, that.getCollocation())
          && Objects.equals(this.vmCount, that.getVmCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(availabilityDomainCount, collocation, vmCount);
  }
}
