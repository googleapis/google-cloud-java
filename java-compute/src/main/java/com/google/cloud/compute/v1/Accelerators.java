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
/** [Output Only] A list of accelerator configurations assigned to this machine type. */
public final class Accelerators implements ApiMessage {
  private final Integer guestAcceleratorCount;
  private final String guestAcceleratorType;

  private Accelerators() {
    this.guestAcceleratorCount = null;
    this.guestAcceleratorType = null;
  }

  private Accelerators(Integer guestAcceleratorCount, String guestAcceleratorType) {
    this.guestAcceleratorCount = guestAcceleratorCount;
    this.guestAcceleratorType = guestAcceleratorType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("guestAcceleratorCount".equals(fieldName)) {
      return guestAcceleratorCount;
    }
    if ("guestAcceleratorType".equals(fieldName)) {
      return guestAcceleratorType;
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

  /** Number of accelerator cards exposed to the guest. */
  public Integer getGuestAcceleratorCount() {
    return guestAcceleratorCount;
  }

  /** The accelerator type resource name, not a full URL, e.g. 'nvidia-tesla-k80'. */
  public String getGuestAcceleratorType() {
    return guestAcceleratorType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Accelerators prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Accelerators getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Accelerators DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Accelerators();
  }

  public static class Builder {
    private Integer guestAcceleratorCount;
    private String guestAcceleratorType;

    Builder() {}

    public Builder mergeFrom(Accelerators other) {
      if (other == Accelerators.getDefaultInstance()) return this;
      if (other.getGuestAcceleratorCount() != null) {
        this.guestAcceleratorCount = other.guestAcceleratorCount;
      }
      if (other.getGuestAcceleratorType() != null) {
        this.guestAcceleratorType = other.guestAcceleratorType;
      }
      return this;
    }

    Builder(Accelerators source) {
      this.guestAcceleratorCount = source.guestAcceleratorCount;
      this.guestAcceleratorType = source.guestAcceleratorType;
    }

    /** Number of accelerator cards exposed to the guest. */
    public Integer getGuestAcceleratorCount() {
      return guestAcceleratorCount;
    }

    /** Number of accelerator cards exposed to the guest. */
    public Builder setGuestAcceleratorCount(Integer guestAcceleratorCount) {
      this.guestAcceleratorCount = guestAcceleratorCount;
      return this;
    }

    /** The accelerator type resource name, not a full URL, e.g. 'nvidia-tesla-k80'. */
    public String getGuestAcceleratorType() {
      return guestAcceleratorType;
    }

    /** The accelerator type resource name, not a full URL, e.g. 'nvidia-tesla-k80'. */
    public Builder setGuestAcceleratorType(String guestAcceleratorType) {
      this.guestAcceleratorType = guestAcceleratorType;
      return this;
    }

    public Accelerators build() {

      return new Accelerators(guestAcceleratorCount, guestAcceleratorType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setGuestAcceleratorCount(this.guestAcceleratorCount);
      newBuilder.setGuestAcceleratorType(this.guestAcceleratorType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Accelerators{"
        + "guestAcceleratorCount="
        + guestAcceleratorCount
        + ", "
        + "guestAcceleratorType="
        + guestAcceleratorType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Accelerators) {
      Accelerators that = (Accelerators) o;
      return Objects.equals(this.guestAcceleratorCount, that.getGuestAcceleratorCount())
          && Objects.equals(this.guestAcceleratorType, that.getGuestAcceleratorType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestAcceleratorCount, guestAcceleratorType);
  }
}
