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
public final class InstanceGroupManagersScopedList implements ApiMessage {
  private final List<InstanceGroupManager> instanceGroupManagers;
  private final Warning warning;

  private InstanceGroupManagersScopedList() {
    this.instanceGroupManagers = null;
    this.warning = null;
  }

  private InstanceGroupManagersScopedList(
      List<InstanceGroupManager> instanceGroupManagers, Warning warning) {
    this.instanceGroupManagers = instanceGroupManagers;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceGroupManagers".equals(fieldName)) {
      return instanceGroupManagers;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  public List<InstanceGroupManager> getInstanceGroupManagersList() {
    return instanceGroupManagers;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersScopedList();
  }

  public static class Builder {
    private List<InstanceGroupManager> instanceGroupManagers;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersScopedList other) {
      if (other == InstanceGroupManagersScopedList.getDefaultInstance()) return this;
      if (other.getInstanceGroupManagersList() != null) {
        this.instanceGroupManagers = other.instanceGroupManagers;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(InstanceGroupManagersScopedList source) {
      this.instanceGroupManagers = source.instanceGroupManagers;
      this.warning = source.warning;
    }

    public List<InstanceGroupManager> getInstanceGroupManagersList() {
      return instanceGroupManagers;
    }

    public Builder addAllInstanceGroupManagers(List<InstanceGroupManager> instanceGroupManagers) {
      if (this.instanceGroupManagers == null) {
        this.instanceGroupManagers = new LinkedList<>();
      }
      this.instanceGroupManagers.addAll(instanceGroupManagers);
      return this;
    }

    public Builder addInstanceGroupManagers(InstanceGroupManager instanceGroupManagers) {
      if (this.instanceGroupManagers == null) {
        this.instanceGroupManagers = new LinkedList<>();
      }
      this.instanceGroupManagers.add(instanceGroupManagers);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public InstanceGroupManagersScopedList build() {

      return new InstanceGroupManagersScopedList(instanceGroupManagers, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstanceGroupManagers(this.instanceGroupManagers);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersScopedList{"
        + "instanceGroupManagers="
        + instanceGroupManagers
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersScopedList) {
      InstanceGroupManagersScopedList that = (InstanceGroupManagersScopedList) o;
      return Objects.equals(this.instanceGroupManagers, that.getInstanceGroupManagersList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceGroupManagers, warning);
  }
}
