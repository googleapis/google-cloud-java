/*
 * Copyright 2018 Google LLC
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InstancesScopedList implements ApiMessage {
  private final List<Instance> instances;
  private final Warning warning;

  private InstancesScopedList() {
    this.instances = null;
    this.warning = null;
  }

  private InstancesScopedList(List<Instance> instances, Warning warning) {
    this.instances = instances;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("instances")) {
      return instances;
    }
    if (fieldName.equals("warning")) {
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

  public List<Instance> getInstancesList() {
    return instances;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstancesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstancesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstancesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstancesScopedList();
  }

  public static class Builder {
    private List<Instance> instances;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(InstancesScopedList other) {
      if (other == InstancesScopedList.getDefaultInstance()) return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(InstancesScopedList source) {
      this.instances = source.instances;
      this.warning = source.warning;
    }

    public List<Instance> getInstancesList() {
      return instances;
    }

    public Builder addAllInstances(List<Instance> instances) {
      if (this.instances == null) {
        this.instances = new ArrayList<>(instances.size());
      }
      this.instances.addAll(instances);
      return this;
    }

    public Builder addInstances(Instance instances) {
      this.instances.add(instances);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public InstancesScopedList build() {

      return new InstancesScopedList(instances, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstancesScopedList{" + "instances=" + instances + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstancesScopedList) {
      InstancesScopedList that = (InstancesScopedList) o;
      return Objects.equals(this.instances, that.getInstancesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances, warning);
  }
}
