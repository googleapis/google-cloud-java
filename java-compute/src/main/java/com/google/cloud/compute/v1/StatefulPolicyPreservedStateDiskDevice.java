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
public final class StatefulPolicyPreservedStateDiskDevice implements ApiMessage {
  private final String autoDelete;

  private StatefulPolicyPreservedStateDiskDevice() {
    this.autoDelete = null;
  }

  private StatefulPolicyPreservedStateDiskDevice(String autoDelete) {
    this.autoDelete = autoDelete;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoDelete".equals(fieldName)) {
      return autoDelete;
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
   * These stateful disks will never be deleted during autohealing, update or VM instance recreate
   * operations. This flag is used to configure if the disk should be deleted after it is no longer
   * used by the group, e.g. when the given instance or the whole group is deleted. Note: disks
   * attached in READ_ONLY mode cannot be auto-deleted.
   */
  public String getAutoDelete() {
    return autoDelete;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(StatefulPolicyPreservedStateDiskDevice prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static StatefulPolicyPreservedStateDiskDevice getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final StatefulPolicyPreservedStateDiskDevice DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new StatefulPolicyPreservedStateDiskDevice();
  }

  public static class Builder {
    private String autoDelete;

    Builder() {}

    public Builder mergeFrom(StatefulPolicyPreservedStateDiskDevice other) {
      if (other == StatefulPolicyPreservedStateDiskDevice.getDefaultInstance()) return this;
      if (other.getAutoDelete() != null) {
        this.autoDelete = other.autoDelete;
      }
      return this;
    }

    Builder(StatefulPolicyPreservedStateDiskDevice source) {
      this.autoDelete = source.autoDelete;
    }

    /**
     * These stateful disks will never be deleted during autohealing, update or VM instance recreate
     * operations. This flag is used to configure if the disk should be deleted after it is no
     * longer used by the group, e.g. when the given instance or the whole group is deleted. Note:
     * disks attached in READ_ONLY mode cannot be auto-deleted.
     */
    public String getAutoDelete() {
      return autoDelete;
    }

    /**
     * These stateful disks will never be deleted during autohealing, update or VM instance recreate
     * operations. This flag is used to configure if the disk should be deleted after it is no
     * longer used by the group, e.g. when the given instance or the whole group is deleted. Note:
     * disks attached in READ_ONLY mode cannot be auto-deleted.
     */
    public Builder setAutoDelete(String autoDelete) {
      this.autoDelete = autoDelete;
      return this;
    }

    public StatefulPolicyPreservedStateDiskDevice build() {
      return new StatefulPolicyPreservedStateDiskDevice(autoDelete);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoDelete(this.autoDelete);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "StatefulPolicyPreservedStateDiskDevice{" + "autoDelete=" + autoDelete + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof StatefulPolicyPreservedStateDiskDevice) {
      StatefulPolicyPreservedStateDiskDevice that = (StatefulPolicyPreservedStateDiskDevice) o;
      return Objects.equals(this.autoDelete, that.getAutoDelete());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoDelete);
  }
}
