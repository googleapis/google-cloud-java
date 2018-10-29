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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class TargetPoolsScopedList implements ApiMessage {
  private final List<TargetPool> targetPools;
  private final Warning warning;

  private TargetPoolsScopedList() {
    this.targetPools = null;
    this.warning = null;
  }

  private TargetPoolsScopedList(List<TargetPool> targetPools, Warning warning) {
    this.targetPools = targetPools;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("targetPools")) {
      return targetPools;
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

  public List<TargetPool> getTargetPoolsList() {
    return targetPools;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetPoolsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetPoolsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetPoolsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetPoolsScopedList();
  }

  public static class Builder {
    private List<TargetPool> targetPools;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(TargetPoolsScopedList other) {
      if (other == TargetPoolsScopedList.getDefaultInstance()) return this;
      if (other.getTargetPoolsList() != null) {
        this.targetPools = other.targetPools;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(TargetPoolsScopedList source) {
      this.targetPools = source.targetPools;
      this.warning = source.warning;
    }

    public List<TargetPool> getTargetPoolsList() {
      return targetPools;
    }

    public Builder addAllTargetPools(List<TargetPool> targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.addAll(targetPools);
      return this;
    }

    public Builder addTargetPools(TargetPool targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.add(targetPools);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public TargetPoolsScopedList build() {

      return new TargetPoolsScopedList(targetPools, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllTargetPools(this.targetPools);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetPoolsScopedList{"
        + "targetPools="
        + targetPools
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
    if (o instanceof TargetPoolsScopedList) {
      TargetPoolsScopedList that = (TargetPoolsScopedList) o;
      return Objects.equals(this.targetPools, that.getTargetPoolsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetPools, warning);
  }
}
