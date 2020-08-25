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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Configuration of preserved resources. */
public final class StatefulPolicyPreservedState implements ApiMessage {
  private final Map<String, StatefulPolicyPreservedStateDiskDevice> disks;

  private StatefulPolicyPreservedState() {
    this.disks = null;
  }

  private StatefulPolicyPreservedState(Map<String, StatefulPolicyPreservedStateDiskDevice> disks) {
    this.disks = disks;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("disks".equals(fieldName)) {
      return disks;
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
   * Disks created on the instances that will be preserved on instance delete, update, etc. This map
   * is keyed with the device names of the disks.
   */
  public Map<String, StatefulPolicyPreservedStateDiskDevice> getDisksMap() {
    return disks;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(StatefulPolicyPreservedState prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static StatefulPolicyPreservedState getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final StatefulPolicyPreservedState DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new StatefulPolicyPreservedState();
  }

  public static class Builder {
    private Map<String, StatefulPolicyPreservedStateDiskDevice> disks;

    Builder() {}

    public Builder mergeFrom(StatefulPolicyPreservedState other) {
      if (other == StatefulPolicyPreservedState.getDefaultInstance()) return this;
      if (other.getDisksMap() != null) {
        this.disks = other.disks;
      }
      return this;
    }

    Builder(StatefulPolicyPreservedState source) {
      this.disks = source.disks;
    }

    /**
     * Disks created on the instances that will be preserved on instance delete, update, etc. This
     * map is keyed with the device names of the disks.
     */
    public Map<String, StatefulPolicyPreservedStateDiskDevice> getDisksMap() {
      return disks;
    }

    /**
     * Disks created on the instances that will be preserved on instance delete, update, etc. This
     * map is keyed with the device names of the disks.
     */
    public Builder putAllDisks(Map<String, StatefulPolicyPreservedStateDiskDevice> disks) {
      this.disks = disks;
      return this;
    }

    public StatefulPolicyPreservedState build() {
      return new StatefulPolicyPreservedState(disks);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.putAllDisks(this.disks);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "StatefulPolicyPreservedState{" + "disks=" + disks + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof StatefulPolicyPreservedState) {
      StatefulPolicyPreservedState that = (StatefulPolicyPreservedState) o;
      return Objects.equals(this.disks, that.getDisksMap());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(disks);
  }
}
