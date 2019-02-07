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
/** A specification of the type and number of accelerator cards attached to the instance. */
public final class AcceleratorConfig implements ApiMessage {
  private final Integer acceleratorCount;
  private final String acceleratorType;

  private AcceleratorConfig() {
    this.acceleratorCount = null;
    this.acceleratorType = null;
  }

  private AcceleratorConfig(Integer acceleratorCount, String acceleratorType) {
    this.acceleratorCount = acceleratorCount;
    this.acceleratorType = acceleratorType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("acceleratorCount".equals(fieldName)) {
      return acceleratorCount;
    }
    if ("acceleratorType".equals(fieldName)) {
      return acceleratorType;
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

  /** The number of the guest accelerator cards exposed to this instance. */
  public Integer getAcceleratorCount() {
    return acceleratorCount;
  }

  /**
   * Full or partial URL of the accelerator type resource to attach to this instance. For example:
   * projects/my-project/zones/us-central1-c/acceleratorTypes/nvidia-tesla-p100 If you are creating
   * an instance template, specify only the accelerator name. See GPUs on Compute Engine for a full
   * list of accelerator types.
   */
  public String getAcceleratorType() {
    return acceleratorType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AcceleratorConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AcceleratorConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AcceleratorConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AcceleratorConfig();
  }

  public static class Builder {
    private Integer acceleratorCount;
    private String acceleratorType;

    Builder() {}

    public Builder mergeFrom(AcceleratorConfig other) {
      if (other == AcceleratorConfig.getDefaultInstance()) return this;
      if (other.getAcceleratorCount() != null) {
        this.acceleratorCount = other.acceleratorCount;
      }
      if (other.getAcceleratorType() != null) {
        this.acceleratorType = other.acceleratorType;
      }
      return this;
    }

    Builder(AcceleratorConfig source) {
      this.acceleratorCount = source.acceleratorCount;
      this.acceleratorType = source.acceleratorType;
    }

    /** The number of the guest accelerator cards exposed to this instance. */
    public Integer getAcceleratorCount() {
      return acceleratorCount;
    }

    /** The number of the guest accelerator cards exposed to this instance. */
    public Builder setAcceleratorCount(Integer acceleratorCount) {
      this.acceleratorCount = acceleratorCount;
      return this;
    }

    /**
     * Full or partial URL of the accelerator type resource to attach to this instance. For example:
     * projects/my-project/zones/us-central1-c/acceleratorTypes/nvidia-tesla-p100 If you are
     * creating an instance template, specify only the accelerator name. See GPUs on Compute Engine
     * for a full list of accelerator types.
     */
    public String getAcceleratorType() {
      return acceleratorType;
    }

    /**
     * Full or partial URL of the accelerator type resource to attach to this instance. For example:
     * projects/my-project/zones/us-central1-c/acceleratorTypes/nvidia-tesla-p100 If you are
     * creating an instance template, specify only the accelerator name. See GPUs on Compute Engine
     * for a full list of accelerator types.
     */
    public Builder setAcceleratorType(String acceleratorType) {
      this.acceleratorType = acceleratorType;
      return this;
    }

    public AcceleratorConfig build() {

      return new AcceleratorConfig(acceleratorCount, acceleratorType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAcceleratorCount(this.acceleratorCount);
      newBuilder.setAcceleratorType(this.acceleratorType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AcceleratorConfig{"
        + "acceleratorCount="
        + acceleratorCount
        + ", "
        + "acceleratorType="
        + acceleratorType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AcceleratorConfig) {
      AcceleratorConfig that = (AcceleratorConfig) o;
      return Objects.equals(this.acceleratorCount, that.getAcceleratorCount())
          && Objects.equals(this.acceleratorType, that.getAcceleratorType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceleratorCount, acceleratorType);
  }
}
