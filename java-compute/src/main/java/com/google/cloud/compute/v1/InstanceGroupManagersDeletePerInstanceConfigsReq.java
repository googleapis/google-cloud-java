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
/** InstanceGroupManagers.deletePerInstanceConfigs */
public final class InstanceGroupManagersDeletePerInstanceConfigsReq implements ApiMessage {
  private final List<String> names;

  private InstanceGroupManagersDeletePerInstanceConfigsReq() {
    this.names = null;
  }

  private InstanceGroupManagersDeletePerInstanceConfigsReq(List<String> names) {
    this.names = names;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("names".equals(fieldName)) {
      return names;
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
   * The list of instance names for which we want to delete per-instance configs on this managed
   * instance group.
   */
  public List<String> getNamesList() {
    return names;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersDeletePerInstanceConfigsReq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersDeletePerInstanceConfigsReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersDeletePerInstanceConfigsReq DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersDeletePerInstanceConfigsReq();
  }

  public static class Builder {
    private List<String> names;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersDeletePerInstanceConfigsReq other) {
      if (other == InstanceGroupManagersDeletePerInstanceConfigsReq.getDefaultInstance())
        return this;
      if (other.getNamesList() != null) {
        this.names = other.names;
      }
      return this;
    }

    Builder(InstanceGroupManagersDeletePerInstanceConfigsReq source) {
      this.names = source.names;
    }

    /**
     * The list of instance names for which we want to delete per-instance configs on this managed
     * instance group.
     */
    public List<String> getNamesList() {
      return names;
    }

    /**
     * The list of instance names for which we want to delete per-instance configs on this managed
     * instance group.
     */
    public Builder addAllNames(List<String> names) {
      if (this.names == null) {
        this.names = new LinkedList<>();
      }
      this.names.addAll(names);
      return this;
    }

    /**
     * The list of instance names for which we want to delete per-instance configs on this managed
     * instance group.
     */
    public Builder addNames(String names) {
      if (this.names == null) {
        this.names = new LinkedList<>();
      }
      this.names.add(names);
      return this;
    }

    public InstanceGroupManagersDeletePerInstanceConfigsReq build() {
      return new InstanceGroupManagersDeletePerInstanceConfigsReq(names);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNames(this.names);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersDeletePerInstanceConfigsReq{" + "names=" + names + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersDeletePerInstanceConfigsReq) {
      InstanceGroupManagersDeletePerInstanceConfigsReq that =
          (InstanceGroupManagersDeletePerInstanceConfigsReq) o;
      return Objects.equals(this.names, that.getNamesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(names);
  }
}
