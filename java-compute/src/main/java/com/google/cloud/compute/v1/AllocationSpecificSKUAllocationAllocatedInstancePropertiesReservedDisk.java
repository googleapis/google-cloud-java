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
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk
    implements ApiMessage {
  private final String diskSizeGb;

  @SerializedName("interface")
  private final String interface2;

  private AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk() {
    this.diskSizeGb = null;
    this.interface2 = null;
  }

  private AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk(
      String diskSizeGb, String interface2) {
    this.diskSizeGb = diskSizeGb;
    this.interface2 = interface2;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("diskSizeGb".equals(fieldName)) {
      return diskSizeGb;
    }
    if ("interface2".equals(fieldName)) {
      return interface2;
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

  /** Specifies the size of the disk in base-2 GB. */
  public String getDiskSizeGb() {
    return diskSizeGb;
  }

  /**
   * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME. The
   * default is SCSI. For performance characteristics of SCSI over NVMe, see Local SSD performance.
   */
  public String getInterface() {
    return interface2;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk();
  }

  public static class Builder {
    private String diskSizeGb;
    private String interface2;

    Builder() {}

    public Builder mergeFrom(
        AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk other) {
      if (other
          == AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk
              .getDefaultInstance()) return this;
      if (other.getDiskSizeGb() != null) {
        this.diskSizeGb = other.diskSizeGb;
      }
      if (other.getInterface() != null) {
        this.interface2 = other.interface2;
      }
      return this;
    }

    Builder(AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk source) {
      this.diskSizeGb = source.diskSizeGb;
      this.interface2 = source.interface2;
    }

    /** Specifies the size of the disk in base-2 GB. */
    public String getDiskSizeGb() {
      return diskSizeGb;
    }

    /** Specifies the size of the disk in base-2 GB. */
    public Builder setDiskSizeGb(String diskSizeGb) {
      this.diskSizeGb = diskSizeGb;
      return this;
    }

    /**
     * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME.
     * The default is SCSI. For performance characteristics of SCSI over NVMe, see Local SSD
     * performance.
     */
    public String getInterface() {
      return interface2;
    }

    /**
     * Specifies the disk interface to use for attaching this disk, which is either SCSI or NVME.
     * The default is SCSI. For performance characteristics of SCSI over NVMe, see Local SSD
     * performance.
     */
    public Builder setInterface(String interface2) {
      this.interface2 = interface2;
      return this;
    }

    public AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk build() {

      return new AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk(
          diskSizeGb, interface2);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDiskSizeGb(this.diskSizeGb);
      newBuilder.setInterface(this.interface2);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk{"
        + "diskSizeGb="
        + diskSizeGb
        + ", "
        + "interface2="
        + interface2
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk) {
      AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk that =
          (AllocationSpecificSKUAllocationAllocatedInstancePropertiesReservedDisk) o;
      return Objects.equals(this.diskSizeGb, that.getDiskSizeGb())
          && Objects.equals(this.interface2, that.getInterface());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskSizeGb, interface2);
  }
}
