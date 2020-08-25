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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** InstanceGroupManagers.patchPerInstanceConfigs */
public final class InstanceGroupManagersPatchPerInstanceConfigsReq implements ApiMessage {
  private final List<PerInstanceConfig> perInstanceConfigs;

  private InstanceGroupManagersPatchPerInstanceConfigsReq() {
    this.perInstanceConfigs = null;
  }

  private InstanceGroupManagersPatchPerInstanceConfigsReq(
      List<PerInstanceConfig> perInstanceConfigs) {
    this.perInstanceConfigs = perInstanceConfigs;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("perInstanceConfigs".equals(fieldName)) {
      return perInstanceConfigs;
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

  /** The list of per-instance configs to insert or patch on this managed instance group. */
  public List<PerInstanceConfig> getPerInstanceConfigsList() {
    return perInstanceConfigs;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersPatchPerInstanceConfigsReq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersPatchPerInstanceConfigsReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersPatchPerInstanceConfigsReq DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersPatchPerInstanceConfigsReq();
  }

  public static class Builder {
    private List<PerInstanceConfig> perInstanceConfigs;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersPatchPerInstanceConfigsReq other) {
      if (other == InstanceGroupManagersPatchPerInstanceConfigsReq.getDefaultInstance())
        return this;
      if (other.getPerInstanceConfigsList() != null) {
        this.perInstanceConfigs = other.perInstanceConfigs;
      }
      return this;
    }

    Builder(InstanceGroupManagersPatchPerInstanceConfigsReq source) {
      this.perInstanceConfigs = source.perInstanceConfigs;
    }

    /** The list of per-instance configs to insert or patch on this managed instance group. */
    public List<PerInstanceConfig> getPerInstanceConfigsList() {
      return perInstanceConfigs;
    }

    /** The list of per-instance configs to insert or patch on this managed instance group. */
    public Builder addAllPerInstanceConfigs(List<PerInstanceConfig> perInstanceConfigs) {
      if (this.perInstanceConfigs == null) {
        this.perInstanceConfigs = new LinkedList<>();
      }
      this.perInstanceConfigs.addAll(perInstanceConfigs);
      return this;
    }

    /** The list of per-instance configs to insert or patch on this managed instance group. */
    public Builder addPerInstanceConfigs(PerInstanceConfig perInstanceConfigs) {
      if (this.perInstanceConfigs == null) {
        this.perInstanceConfigs = new LinkedList<>();
      }
      this.perInstanceConfigs.add(perInstanceConfigs);
      return this;
    }

    public InstanceGroupManagersPatchPerInstanceConfigsReq build() {
      return new InstanceGroupManagersPatchPerInstanceConfigsReq(perInstanceConfigs);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllPerInstanceConfigs(this.perInstanceConfigs);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersPatchPerInstanceConfigsReq{"
        + "perInstanceConfigs="
        + perInstanceConfigs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersPatchPerInstanceConfigsReq) {
      InstanceGroupManagersPatchPerInstanceConfigsReq that =
          (InstanceGroupManagersPatchPerInstanceConfigsReq) o;
      return Objects.equals(this.perInstanceConfigs, that.getPerInstanceConfigsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(perInstanceConfigs);
  }
}
