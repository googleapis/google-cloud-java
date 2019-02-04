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
public final class InstanceGroupManagerStatus implements ApiMessage {
  private final Boolean isStable;

  private InstanceGroupManagerStatus() {
    this.isStable = null;
  }

  private InstanceGroupManagerStatus(Boolean isStable) {
    this.isStable = isStable;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("isStable".equals(fieldName)) {
      return isStable;
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

  public Boolean getIsStable() {
    return isStable;
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

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerStatus other) {
      if (other == InstanceGroupManagerStatus.getDefaultInstance()) return this;
      if (other.getIsStable() != null) {
        this.isStable = other.isStable;
      }
      return this;
    }

    Builder(InstanceGroupManagerStatus source) {
      this.isStable = source.isStable;
    }

    public Boolean getIsStable() {
      return isStable;
    }

    public Builder setIsStable(Boolean isStable) {
      this.isStable = isStable;
      return this;
    }

    public InstanceGroupManagerStatus build() {
      return new InstanceGroupManagerStatus(isStable);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIsStable(this.isStable);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerStatus{" + "isStable=" + isStable + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerStatus) {
      InstanceGroupManagerStatus that = (InstanceGroupManagerStatus) o;
      return Objects.equals(this.isStable, that.getIsStable());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isStable);
  }
}
