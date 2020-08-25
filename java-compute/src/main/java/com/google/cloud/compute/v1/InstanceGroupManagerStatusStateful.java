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
public final class InstanceGroupManagerStatusStateful implements ApiMessage {
  private final Boolean hasStatefulConfig;
  private final InstanceGroupManagerStatusStatefulPerInstanceConfigs perInstanceConfigs;

  private InstanceGroupManagerStatusStateful() {
    this.hasStatefulConfig = null;
    this.perInstanceConfigs = null;
  }

  private InstanceGroupManagerStatusStateful(
      Boolean hasStatefulConfig,
      InstanceGroupManagerStatusStatefulPerInstanceConfigs perInstanceConfigs) {
    this.hasStatefulConfig = hasStatefulConfig;
    this.perInstanceConfigs = perInstanceConfigs;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("hasStatefulConfig".equals(fieldName)) {
      return hasStatefulConfig;
    }
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

  /**
   * [Output Only] A bit indicating whether the managed instance group has stateful configuration,
   * that is, if you have configured any items in a stateful policy or in per-instance configs. The
   * group might report that it has no stateful config even when there is still some preserved state
   * on a managed instance, for example, if you have deleted all PICs but not yet applied those
   * deletions.
   */
  public Boolean getHasStatefulConfig() {
    return hasStatefulConfig;
  }

  /** [Output Only] Status of per-instance configs on the instance. */
  public InstanceGroupManagerStatusStatefulPerInstanceConfigs getPerInstanceConfigs() {
    return perInstanceConfigs;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerStatusStateful prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerStatusStateful getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerStatusStateful DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerStatusStateful();
  }

  public static class Builder {
    private Boolean hasStatefulConfig;
    private InstanceGroupManagerStatusStatefulPerInstanceConfigs perInstanceConfigs;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerStatusStateful other) {
      if (other == InstanceGroupManagerStatusStateful.getDefaultInstance()) return this;
      if (other.getHasStatefulConfig() != null) {
        this.hasStatefulConfig = other.hasStatefulConfig;
      }
      if (other.getPerInstanceConfigs() != null) {
        this.perInstanceConfigs = other.perInstanceConfigs;
      }
      return this;
    }

    Builder(InstanceGroupManagerStatusStateful source) {
      this.hasStatefulConfig = source.hasStatefulConfig;
      this.perInstanceConfigs = source.perInstanceConfigs;
    }

    /**
     * [Output Only] A bit indicating whether the managed instance group has stateful configuration,
     * that is, if you have configured any items in a stateful policy or in per-instance configs.
     * The group might report that it has no stateful config even when there is still some preserved
     * state on a managed instance, for example, if you have deleted all PICs but not yet applied
     * those deletions.
     */
    public Boolean getHasStatefulConfig() {
      return hasStatefulConfig;
    }

    /**
     * [Output Only] A bit indicating whether the managed instance group has stateful configuration,
     * that is, if you have configured any items in a stateful policy or in per-instance configs.
     * The group might report that it has no stateful config even when there is still some preserved
     * state on a managed instance, for example, if you have deleted all PICs but not yet applied
     * those deletions.
     */
    public Builder setHasStatefulConfig(Boolean hasStatefulConfig) {
      this.hasStatefulConfig = hasStatefulConfig;
      return this;
    }

    /** [Output Only] Status of per-instance configs on the instance. */
    public InstanceGroupManagerStatusStatefulPerInstanceConfigs getPerInstanceConfigs() {
      return perInstanceConfigs;
    }

    /** [Output Only] Status of per-instance configs on the instance. */
    public Builder setPerInstanceConfigs(
        InstanceGroupManagerStatusStatefulPerInstanceConfigs perInstanceConfigs) {
      this.perInstanceConfigs = perInstanceConfigs;
      return this;
    }

    public InstanceGroupManagerStatusStateful build() {

      return new InstanceGroupManagerStatusStateful(hasStatefulConfig, perInstanceConfigs);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setHasStatefulConfig(this.hasStatefulConfig);
      newBuilder.setPerInstanceConfigs(this.perInstanceConfigs);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerStatusStateful{"
        + "hasStatefulConfig="
        + hasStatefulConfig
        + ", "
        + "perInstanceConfigs="
        + perInstanceConfigs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerStatusStateful) {
      InstanceGroupManagerStatusStateful that = (InstanceGroupManagerStatusStateful) o;
      return Objects.equals(this.hasStatefulConfig, that.getHasStatefulConfig())
          && Objects.equals(this.perInstanceConfigs, that.getPerInstanceConfigs());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hasStatefulConfig, perInstanceConfigs);
  }
}
