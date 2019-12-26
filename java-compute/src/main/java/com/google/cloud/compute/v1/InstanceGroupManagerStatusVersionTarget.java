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
public final class InstanceGroupManagerStatusVersionTarget implements ApiMessage {
  private final Boolean isReached;

  private InstanceGroupManagerStatusVersionTarget() {
    this.isReached = null;
  }

  private InstanceGroupManagerStatusVersionTarget(Boolean isReached) {
    this.isReached = isReached;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("isReached".equals(fieldName)) {
      return isReached;
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
   * [Output Only] A bit indicating whether version target has been reached in this managed instance
   * group, i.e. all instances are in their target version. Instances' target version are specified
   * by version field on Instance Group Manager.
   */
  public Boolean getIsReached() {
    return isReached;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerStatusVersionTarget prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerStatusVersionTarget getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerStatusVersionTarget DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerStatusVersionTarget();
  }

  public static class Builder {
    private Boolean isReached;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerStatusVersionTarget other) {
      if (other == InstanceGroupManagerStatusVersionTarget.getDefaultInstance()) return this;
      if (other.getIsReached() != null) {
        this.isReached = other.isReached;
      }
      return this;
    }

    Builder(InstanceGroupManagerStatusVersionTarget source) {
      this.isReached = source.isReached;
    }

    /**
     * [Output Only] A bit indicating whether version target has been reached in this managed
     * instance group, i.e. all instances are in their target version. Instances' target version are
     * specified by version field on Instance Group Manager.
     */
    public Boolean getIsReached() {
      return isReached;
    }

    /**
     * [Output Only] A bit indicating whether version target has been reached in this managed
     * instance group, i.e. all instances are in their target version. Instances' target version are
     * specified by version field on Instance Group Manager.
     */
    public Builder setIsReached(Boolean isReached) {
      this.isReached = isReached;
      return this;
    }

    public InstanceGroupManagerStatusVersionTarget build() {
      return new InstanceGroupManagerStatusVersionTarget(isReached);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIsReached(this.isReached);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerStatusVersionTarget{" + "isReached=" + isReached + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerStatusVersionTarget) {
      InstanceGroupManagerStatusVersionTarget that = (InstanceGroupManagerStatusVersionTarget) o;
      return Objects.equals(this.isReached, that.getIsReached());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isReached);
  }
}
