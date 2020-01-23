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
public final class InstanceGroupManagerStatus implements ApiMessage {
  private final Boolean isStable;
  private final InstanceGroupManagerStatusVersionTarget versionTarget;

  private InstanceGroupManagerStatus() {
    this.isStable = null;
    this.versionTarget = null;
  }

  private InstanceGroupManagerStatus(
      Boolean isStable, InstanceGroupManagerStatusVersionTarget versionTarget) {
    this.isStable = isStable;
    this.versionTarget = versionTarget;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("isStable".equals(fieldName)) {
      return isStable;
    }
    if ("versionTarget".equals(fieldName)) {
      return versionTarget;
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
   * [Output Only] A bit indicating whether the managed instance group is in a stable state. A
   * stable state means that: none of the instances in the managed instance group is currently
   * undergoing any type of change (for example, creation, restart, or deletion); no future changes
   * are scheduled for instances in the managed instance group; and the managed instance group
   * itself is not being modified.
   */
  public Boolean getIsStable() {
    return isStable;
  }

  /**
   * [Output Only] A status of consistency of Instances' versions with their target version
   * specified by version field on Instance Group Manager.
   */
  public InstanceGroupManagerStatusVersionTarget getVersionTarget() {
    return versionTarget;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerStatus();
  }

  public static class Builder {
    private Boolean isStable;
    private InstanceGroupManagerStatusVersionTarget versionTarget;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerStatus other) {
      if (other == InstanceGroupManagerStatus.getDefaultInstance()) return this;
      if (other.getIsStable() != null) {
        this.isStable = other.isStable;
      }
      if (other.getVersionTarget() != null) {
        this.versionTarget = other.versionTarget;
      }
      return this;
    }

    Builder(InstanceGroupManagerStatus source) {
      this.isStable = source.isStable;
      this.versionTarget = source.versionTarget;
    }

    /**
     * [Output Only] A bit indicating whether the managed instance group is in a stable state. A
     * stable state means that: none of the instances in the managed instance group is currently
     * undergoing any type of change (for example, creation, restart, or deletion); no future
     * changes are scheduled for instances in the managed instance group; and the managed instance
     * group itself is not being modified.
     */
    public Boolean getIsStable() {
      return isStable;
    }

    /**
     * [Output Only] A bit indicating whether the managed instance group is in a stable state. A
     * stable state means that: none of the instances in the managed instance group is currently
     * undergoing any type of change (for example, creation, restart, or deletion); no future
     * changes are scheduled for instances in the managed instance group; and the managed instance
     * group itself is not being modified.
     */
    public Builder setIsStable(Boolean isStable) {
      this.isStable = isStable;
      return this;
    }

    /**
     * [Output Only] A status of consistency of Instances' versions with their target version
     * specified by version field on Instance Group Manager.
     */
    public InstanceGroupManagerStatusVersionTarget getVersionTarget() {
      return versionTarget;
    }

    /**
     * [Output Only] A status of consistency of Instances' versions with their target version
     * specified by version field on Instance Group Manager.
     */
    public Builder setVersionTarget(InstanceGroupManagerStatusVersionTarget versionTarget) {
      this.versionTarget = versionTarget;
      return this;
    }

    public InstanceGroupManagerStatus build() {

      return new InstanceGroupManagerStatus(isStable, versionTarget);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIsStable(this.isStable);
      newBuilder.setVersionTarget(this.versionTarget);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerStatus{"
        + "isStable="
        + isStable
        + ", "
        + "versionTarget="
        + versionTarget
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerStatus) {
      InstanceGroupManagerStatus that = (InstanceGroupManagerStatus) o;
      return Objects.equals(this.isStable, that.getIsStable())
          && Objects.equals(this.versionTarget, that.getVersionTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isStable, versionTarget);
  }
}
