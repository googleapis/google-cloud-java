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
public final class InstanceGroupsScopedList implements ApiMessage {
  private final List<InstanceGroup> instanceGroups;
  private final Warning warning;

  private InstanceGroupsScopedList() {
    this.instanceGroups = null;
    this.warning = null;
  }

  private InstanceGroupsScopedList(List<InstanceGroup> instanceGroups, Warning warning) {
    this.instanceGroups = instanceGroups;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceGroups".equals(fieldName)) {
      return instanceGroups;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] The list of instance groups that are contained in this scope. */
  public List<InstanceGroup> getInstanceGroupsList() {
    return instanceGroups;
  }

  /**
   * [Output Only] An informational warning that replaces the list of instance groups when the list
   * is empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupsScopedList();
  }

  public static class Builder {
    private List<InstanceGroup> instanceGroups;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(InstanceGroupsScopedList other) {
      if (other == InstanceGroupsScopedList.getDefaultInstance()) return this;
      if (other.getInstanceGroupsList() != null) {
        this.instanceGroups = other.instanceGroups;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(InstanceGroupsScopedList source) {
      this.instanceGroups = source.instanceGroups;
      this.warning = source.warning;
    }

    /** [Output Only] The list of instance groups that are contained in this scope. */
    public List<InstanceGroup> getInstanceGroupsList() {
      return instanceGroups;
    }

    /** [Output Only] The list of instance groups that are contained in this scope. */
    public Builder addAllInstanceGroups(List<InstanceGroup> instanceGroups) {
      if (this.instanceGroups == null) {
        this.instanceGroups = new LinkedList<>();
      }
      this.instanceGroups.addAll(instanceGroups);
      return this;
    }

    /** [Output Only] The list of instance groups that are contained in this scope. */
    public Builder addInstanceGroups(InstanceGroup instanceGroups) {
      if (this.instanceGroups == null) {
        this.instanceGroups = new LinkedList<>();
      }
      this.instanceGroups.add(instanceGroups);
      return this;
    }

    /**
     * [Output Only] An informational warning that replaces the list of instance groups when the
     * list is empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] An informational warning that replaces the list of instance groups when the
     * list is empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public InstanceGroupsScopedList build() {

      return new InstanceGroupsScopedList(instanceGroups, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstanceGroups(this.instanceGroups);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupsScopedList{"
        + "instanceGroups="
        + instanceGroups
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
    if (o instanceof InstanceGroupsScopedList) {
      InstanceGroupsScopedList that = (InstanceGroupsScopedList) o;
      return Objects.equals(this.instanceGroups, that.getInstanceGroupsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceGroups, warning);
  }
}
