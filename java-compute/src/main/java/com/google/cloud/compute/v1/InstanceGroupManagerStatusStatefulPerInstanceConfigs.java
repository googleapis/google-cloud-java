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
public final class InstanceGroupManagerStatusStatefulPerInstanceConfigs implements ApiMessage {
  private final Boolean allEffective;

  private InstanceGroupManagerStatusStatefulPerInstanceConfigs() {
    this.allEffective = null;
  }

  private InstanceGroupManagerStatusStatefulPerInstanceConfigs(Boolean allEffective) {
    this.allEffective = allEffective;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("allEffective".equals(fieldName)) {
      return allEffective;
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
   * A bit indicating if all of the group's per-instance configs (listed in the output of a
   * listPerInstanceConfigs API call) have status EFFECTIVE or there are no per-instance-configs.
   */
  public Boolean getAllEffective() {
    return allEffective;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerStatusStatefulPerInstanceConfigs prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerStatusStatefulPerInstanceConfigs getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerStatusStatefulPerInstanceConfigs DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerStatusStatefulPerInstanceConfigs();
  }

  public static class Builder {
    private Boolean allEffective;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerStatusStatefulPerInstanceConfigs other) {
      if (other == InstanceGroupManagerStatusStatefulPerInstanceConfigs.getDefaultInstance())
        return this;
      if (other.getAllEffective() != null) {
        this.allEffective = other.allEffective;
      }
      return this;
    }

    Builder(InstanceGroupManagerStatusStatefulPerInstanceConfigs source) {
      this.allEffective = source.allEffective;
    }

    /**
     * A bit indicating if all of the group's per-instance configs (listed in the output of a
     * listPerInstanceConfigs API call) have status EFFECTIVE or there are no per-instance-configs.
     */
    public Boolean getAllEffective() {
      return allEffective;
    }

    /**
     * A bit indicating if all of the group's per-instance configs (listed in the output of a
     * listPerInstanceConfigs API call) have status EFFECTIVE or there are no per-instance-configs.
     */
    public Builder setAllEffective(Boolean allEffective) {
      this.allEffective = allEffective;
      return this;
    }

    public InstanceGroupManagerStatusStatefulPerInstanceConfigs build() {
      return new InstanceGroupManagerStatusStatefulPerInstanceConfigs(allEffective);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAllEffective(this.allEffective);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerStatusStatefulPerInstanceConfigs{"
        + "allEffective="
        + allEffective
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerStatusStatefulPerInstanceConfigs) {
      InstanceGroupManagerStatusStatefulPerInstanceConfigs that =
          (InstanceGroupManagerStatusStatefulPerInstanceConfigs) o;
      return Objects.equals(this.allEffective, that.getAllEffective());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(allEffective);
  }
}
