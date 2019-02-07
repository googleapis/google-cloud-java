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
public final class InstanceGroupManagerVersion implements ApiMessage {
  private final String instanceTemplate;
  private final String name;
  private final FixedOrPercent targetSize;

  private InstanceGroupManagerVersion() {
    this.instanceTemplate = null;
    this.name = null;
    this.targetSize = null;
  }

  private InstanceGroupManagerVersion(
      String instanceTemplate, String name, FixedOrPercent targetSize) {
    this.instanceTemplate = instanceTemplate;
    this.name = name;
    this.targetSize = targetSize;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceTemplate".equals(fieldName)) {
      return instanceTemplate;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("targetSize".equals(fieldName)) {
      return targetSize;
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

  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  /** Name of the version. Unique among all versions in the scope of this managed instance group. */
  public String getName() {
    return name;
  }

  /**
   * Specifies the intended number of instances to be created from the instanceTemplate. The final
   * number of instances created from the template will be equal to: - If expressed as a fixed
   * number, the minimum of either targetSize.fixed or instanceGroupManager.targetSize is used. - if
   * expressed as a percent, the targetSize would be (targetSize.percent/100 &#42;
   * InstanceGroupManager.targetSize) If there is a remainder, the number is rounded up. If unset,
   * this version will update any remaining instances not updated by another version. Read Starting
   * a canary update for more information.
   */
  public FixedOrPercent getTargetSize() {
    return targetSize;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerVersion prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerVersion getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerVersion DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerVersion();
  }

  public static class Builder {
    private String instanceTemplate;
    private String name;
    private FixedOrPercent targetSize;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerVersion other) {
      if (other == InstanceGroupManagerVersion.getDefaultInstance()) return this;
      if (other.getInstanceTemplate() != null) {
        this.instanceTemplate = other.instanceTemplate;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getTargetSize() != null) {
        this.targetSize = other.targetSize;
      }
      return this;
    }

    Builder(InstanceGroupManagerVersion source) {
      this.instanceTemplate = source.instanceTemplate;
      this.name = source.name;
      this.targetSize = source.targetSize;
    }

    public String getInstanceTemplate() {
      return instanceTemplate;
    }

    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }

    /**
     * Name of the version. Unique among all versions in the scope of this managed instance group.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the version. Unique among all versions in the scope of this managed instance group.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Specifies the intended number of instances to be created from the instanceTemplate. The final
     * number of instances created from the template will be equal to: - If expressed as a fixed
     * number, the minimum of either targetSize.fixed or instanceGroupManager.targetSize is used. -
     * if expressed as a percent, the targetSize would be (targetSize.percent/100 &#42;
     * InstanceGroupManager.targetSize) If there is a remainder, the number is rounded up. If unset,
     * this version will update any remaining instances not updated by another version. Read
     * Starting a canary update for more information.
     */
    public FixedOrPercent getTargetSize() {
      return targetSize;
    }

    /**
     * Specifies the intended number of instances to be created from the instanceTemplate. The final
     * number of instances created from the template will be equal to: - If expressed as a fixed
     * number, the minimum of either targetSize.fixed or instanceGroupManager.targetSize is used. -
     * if expressed as a percent, the targetSize would be (targetSize.percent/100 &#42;
     * InstanceGroupManager.targetSize) If there is a remainder, the number is rounded up. If unset,
     * this version will update any remaining instances not updated by another version. Read
     * Starting a canary update for more information.
     */
    public Builder setTargetSize(FixedOrPercent targetSize) {
      this.targetSize = targetSize;
      return this;
    }

    public InstanceGroupManagerVersion build() {

      return new InstanceGroupManagerVersion(instanceTemplate, name, targetSize);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceTemplate(this.instanceTemplate);
      newBuilder.setName(this.name);
      newBuilder.setTargetSize(this.targetSize);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerVersion{"
        + "instanceTemplate="
        + instanceTemplate
        + ", "
        + "name="
        + name
        + ", "
        + "targetSize="
        + targetSize
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerVersion) {
      InstanceGroupManagerVersion that = (InstanceGroupManagerVersion) o;
      return Objects.equals(this.instanceTemplate, that.getInstanceTemplate())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.targetSize, that.getTargetSize());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceTemplate, name, targetSize);
  }
}
