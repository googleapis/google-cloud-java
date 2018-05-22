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
public final class TargetInstancesScopedList implements ApiMessage {
  private final List<TargetInstance> targetInstances;
  private final Warning warning;

  private TargetInstancesScopedList() {
    this.targetInstances = null;
    this.warning = null;
  }

  private TargetInstancesScopedList(List<TargetInstance> targetInstances, Warning warning) {
    this.targetInstances = targetInstances;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("targetInstances")) {
      return targetInstances;
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

  public List<TargetInstance> getTargetInstancesList() {
    return targetInstances;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetInstancesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetInstancesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetInstancesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetInstancesScopedList();
  }

  public static class Builder {
    private List<TargetInstance> targetInstances;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(TargetInstancesScopedList other) {
      if (other == TargetInstancesScopedList.getDefaultInstance()) return this;
      if (other.getTargetInstancesList() != null) {
        this.targetInstances = other.targetInstances;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(TargetInstancesScopedList source) {
      this.targetInstances = source.targetInstances;
      this.warning = source.warning;
    }

    public List<TargetInstance> getTargetInstancesList() {
      return targetInstances;
    }

    public Builder addAllTargetInstances(List<TargetInstance> targetInstances) {
      if (this.targetInstances == null) {
        this.targetInstances = new ArrayList<>(targetInstances.size());
      }
      this.targetInstances.addAll(targetInstances);
      return this;
    }

    public Builder addTargetInstances(TargetInstance targetInstances) {
      this.targetInstances.add(targetInstances);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public TargetInstancesScopedList build() {

      return new TargetInstancesScopedList(targetInstances, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllTargetInstances(this.targetInstances);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetInstancesScopedList{"
        + "targetInstances="
        + targetInstances
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
    if (o instanceof TargetInstancesScopedList) {
      TargetInstancesScopedList that = (TargetInstancesScopedList) o;
      return Objects.equals(this.targetInstances, that.getTargetInstancesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetInstances, warning);
  }
}
