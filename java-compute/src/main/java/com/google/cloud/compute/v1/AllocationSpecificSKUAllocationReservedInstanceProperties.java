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
/** Properties of the SKU instances being reserved. */
public final class AllocationSpecificSKUAllocationReservedInstanceProperties implements ApiMessage {
  private final List<AcceleratorConfig> guestAccelerators;
  private final List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk>
      localSsds;
  private final String machineType;
  private final String minCpuPlatform;

  private AllocationSpecificSKUAllocationReservedInstanceProperties() {
    this.guestAccelerators = null;
    this.localSsds = null;
    this.machineType = null;
    this.minCpuPlatform = null;
  }

  private AllocationSpecificSKUAllocationReservedInstanceProperties(
      List<AcceleratorConfig> guestAccelerators,
      List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk> localSsds,
      String machineType,
      String minCpuPlatform) {
    this.guestAccelerators = guestAccelerators;
    this.localSsds = localSsds;
    this.machineType = machineType;
    this.minCpuPlatform = minCpuPlatform;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("guestAccelerators".equals(fieldName)) {
      return guestAccelerators;
    }
    if ("localSsds".equals(fieldName)) {
      return localSsds;
    }
    if ("machineType".equals(fieldName)) {
      return machineType;
    }
    if ("minCpuPlatform".equals(fieldName)) {
      return minCpuPlatform;
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

  /** Specifies accelerator type and count. */
  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
  }

  /** Specifies amount of local ssd to reserve with each instance. The type of disk is local-ssd. */
  public List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk>
      getLocalSsdsList() {
    return localSsds;
  }

  /**
   * Specifies type of machine (name only) which has fixed number of vCPUs and fixed amount of
   * memory. This also includes specifying custom machine type following
   * custom-NUMBER_OF_CPUS-AMOUNT_OF_MEMORY pattern.
   */
  public String getMachineType() {
    return machineType;
  }

  /** Minimum cpu platform the reservation. */
  public String getMinCpuPlatform() {
    return minCpuPlatform;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      AllocationSpecificSKUAllocationReservedInstanceProperties prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AllocationSpecificSKUAllocationReservedInstanceProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AllocationSpecificSKUAllocationReservedInstanceProperties DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AllocationSpecificSKUAllocationReservedInstanceProperties();
  }

  public static class Builder {
    private List<AcceleratorConfig> guestAccelerators;
    private List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk> localSsds;
    private String machineType;
    private String minCpuPlatform;

    Builder() {}

    public Builder mergeFrom(AllocationSpecificSKUAllocationReservedInstanceProperties other) {
      if (other == AllocationSpecificSKUAllocationReservedInstanceProperties.getDefaultInstance())
        return this;
      if (other.getGuestAcceleratorsList() != null) {
        this.guestAccelerators = other.guestAccelerators;
      }
      if (other.getLocalSsdsList() != null) {
        this.localSsds = other.localSsds;
      }
      if (other.getMachineType() != null) {
        this.machineType = other.machineType;
      }
      if (other.getMinCpuPlatform() != null) {
        this.minCpuPlatform = other.minCpuPlatform;
      }
      return this;
    }

    Builder(AllocationSpecificSKUAllocationReservedInstanceProperties source) {
      this.guestAccelerators = source.guestAccelerators;
      this.localSsds = source.localSsds;
      this.machineType = source.machineType;
      this.minCpuPlatform = source.minCpuPlatform;
    }

    /** Specifies accelerator type and count. */
    public List<AcceleratorConfig> getGuestAcceleratorsList() {
      return guestAccelerators;
    }

    /** Specifies accelerator type and count. */
    public Builder addAllGuestAccelerators(List<AcceleratorConfig> guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.addAll(guestAccelerators);
      return this;
    }

    /** Specifies accelerator type and count. */
    public Builder addGuestAccelerators(AcceleratorConfig guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.add(guestAccelerators);
      return this;
    }

    /**
     * Specifies amount of local ssd to reserve with each instance. The type of disk is local-ssd.
     */
    public List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk>
        getLocalSsdsList() {
      return localSsds;
    }

    /**
     * Specifies amount of local ssd to reserve with each instance. The type of disk is local-ssd.
     */
    public Builder addAllLocalSsds(
        List<AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk> localSsds) {
      if (this.localSsds == null) {
        this.localSsds = new LinkedList<>();
      }
      this.localSsds.addAll(localSsds);
      return this;
    }

    /**
     * Specifies amount of local ssd to reserve with each instance. The type of disk is local-ssd.
     */
    public Builder addLocalSsds(
        AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk localSsds) {
      if (this.localSsds == null) {
        this.localSsds = new LinkedList<>();
      }
      this.localSsds.add(localSsds);
      return this;
    }

    /**
     * Specifies type of machine (name only) which has fixed number of vCPUs and fixed amount of
     * memory. This also includes specifying custom machine type following
     * custom-NUMBER_OF_CPUS-AMOUNT_OF_MEMORY pattern.
     */
    public String getMachineType() {
      return machineType;
    }

    /**
     * Specifies type of machine (name only) which has fixed number of vCPUs and fixed amount of
     * memory. This also includes specifying custom machine type following
     * custom-NUMBER_OF_CPUS-AMOUNT_OF_MEMORY pattern.
     */
    public Builder setMachineType(String machineType) {
      this.machineType = machineType;
      return this;
    }

    /** Minimum cpu platform the reservation. */
    public String getMinCpuPlatform() {
      return minCpuPlatform;
    }

    /** Minimum cpu platform the reservation. */
    public Builder setMinCpuPlatform(String minCpuPlatform) {
      this.minCpuPlatform = minCpuPlatform;
      return this;
    }

    public AllocationSpecificSKUAllocationReservedInstanceProperties build() {

      return new AllocationSpecificSKUAllocationReservedInstanceProperties(
          guestAccelerators, localSsds, machineType, minCpuPlatform);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllGuestAccelerators(this.guestAccelerators);
      newBuilder.addAllLocalSsds(this.localSsds);
      newBuilder.setMachineType(this.machineType);
      newBuilder.setMinCpuPlatform(this.minCpuPlatform);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AllocationSpecificSKUAllocationReservedInstanceProperties{"
        + "guestAccelerators="
        + guestAccelerators
        + ", "
        + "localSsds="
        + localSsds
        + ", "
        + "machineType="
        + machineType
        + ", "
        + "minCpuPlatform="
        + minCpuPlatform
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AllocationSpecificSKUAllocationReservedInstanceProperties) {
      AllocationSpecificSKUAllocationReservedInstanceProperties that =
          (AllocationSpecificSKUAllocationReservedInstanceProperties) o;
      return Objects.equals(this.guestAccelerators, that.getGuestAcceleratorsList())
          && Objects.equals(this.localSsds, that.getLocalSsdsList())
          && Objects.equals(this.machineType, that.getMachineType())
          && Objects.equals(this.minCpuPlatform, that.getMinCpuPlatform());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestAccelerators, localSsds, machineType, minCpuPlatform);
  }
}
