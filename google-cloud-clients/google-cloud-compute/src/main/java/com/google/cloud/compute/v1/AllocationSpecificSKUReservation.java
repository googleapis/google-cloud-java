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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** This reservation type allows to pre allocate specific instance configuration. */
public final class AllocationSpecificSKUReservation implements ApiMessage {
  private final String count;
  private final String inUseCount;
  private final AllocationSpecificSKUAllocationReservedInstanceProperties instanceProperties;

  private AllocationSpecificSKUReservation() {
    this.count = null;
    this.inUseCount = null;
    this.instanceProperties = null;
  }

  private AllocationSpecificSKUReservation(
      String count,
      String inUseCount,
      AllocationSpecificSKUAllocationReservedInstanceProperties instanceProperties) {
    this.count = count;
    this.inUseCount = inUseCount;
    this.instanceProperties = instanceProperties;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("count".equals(fieldName)) {
      return count;
    }
    if ("inUseCount".equals(fieldName)) {
      return inUseCount;
    }
    if ("instanceProperties".equals(fieldName)) {
      return instanceProperties;
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

  /** Specifies number of resources that are allocated. */
  public String getCount() {
    return count;
  }

  /** [OutputOnly] Indicates how many resource are in use. */
  public String getInUseCount() {
    return inUseCount;
  }

  /** The instance properties for this specific sku reservation. */
  public AllocationSpecificSKUAllocationReservedInstanceProperties getInstanceProperties() {
    return instanceProperties;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AllocationSpecificSKUReservation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AllocationSpecificSKUReservation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AllocationSpecificSKUReservation DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AllocationSpecificSKUReservation();
  }

  public static class Builder {
    private String count;
    private String inUseCount;
    private AllocationSpecificSKUAllocationReservedInstanceProperties instanceProperties;

    Builder() {}

    public Builder mergeFrom(AllocationSpecificSKUReservation other) {
      if (other == AllocationSpecificSKUReservation.getDefaultInstance()) return this;
      if (other.getCount() != null) {
        this.count = other.count;
      }
      if (other.getInUseCount() != null) {
        this.inUseCount = other.inUseCount;
      }
      if (other.getInstanceProperties() != null) {
        this.instanceProperties = other.instanceProperties;
      }
      return this;
    }

    Builder(AllocationSpecificSKUReservation source) {
      this.count = source.count;
      this.inUseCount = source.inUseCount;
      this.instanceProperties = source.instanceProperties;
    }

    /** Specifies number of resources that are allocated. */
    public String getCount() {
      return count;
    }

    /** Specifies number of resources that are allocated. */
    public Builder setCount(String count) {
      this.count = count;
      return this;
    }

    /** [OutputOnly] Indicates how many resource are in use. */
    public String getInUseCount() {
      return inUseCount;
    }

    /** [OutputOnly] Indicates how many resource are in use. */
    public Builder setInUseCount(String inUseCount) {
      this.inUseCount = inUseCount;
      return this;
    }

    /** The instance properties for this specific sku reservation. */
    public AllocationSpecificSKUAllocationReservedInstanceProperties getInstanceProperties() {
      return instanceProperties;
    }

    /** The instance properties for this specific sku reservation. */
    public Builder setInstanceProperties(
        AllocationSpecificSKUAllocationReservedInstanceProperties instanceProperties) {
      this.instanceProperties = instanceProperties;
      return this;
    }

    public AllocationSpecificSKUReservation build() {

      return new AllocationSpecificSKUReservation(count, inUseCount, instanceProperties);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCount(this.count);
      newBuilder.setInUseCount(this.inUseCount);
      newBuilder.setInstanceProperties(this.instanceProperties);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AllocationSpecificSKUReservation{"
        + "count="
        + count
        + ", "
        + "inUseCount="
        + inUseCount
        + ", "
        + "instanceProperties="
        + instanceProperties
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AllocationSpecificSKUReservation) {
      AllocationSpecificSKUReservation that = (AllocationSpecificSKUReservation) o;
      return Objects.equals(this.count, that.getCount())
          && Objects.equals(this.inUseCount, that.getInUseCount())
          && Objects.equals(this.instanceProperties, that.getInstanceProperties());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, inUseCount, instanceProperties);
  }
}
