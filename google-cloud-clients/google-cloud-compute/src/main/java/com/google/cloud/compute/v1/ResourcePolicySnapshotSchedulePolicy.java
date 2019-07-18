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
/**
 * A snapshot schedule policy specifies when and how frequently snapshots are to be created for the
 * target disk. Also specifies how many and how long these scheduled snapshots should be retained.
 */
public final class ResourcePolicySnapshotSchedulePolicy implements ApiMessage {
  private final ResourcePolicySnapshotSchedulePolicyRetentionPolicy retentionPolicy;
  private final ResourcePolicySnapshotSchedulePolicySchedule schedule;
  private final ResourcePolicySnapshotSchedulePolicySnapshotProperties snapshotProperties;

  private ResourcePolicySnapshotSchedulePolicy() {
    this.retentionPolicy = null;
    this.schedule = null;
    this.snapshotProperties = null;
  }

  private ResourcePolicySnapshotSchedulePolicy(
      ResourcePolicySnapshotSchedulePolicyRetentionPolicy retentionPolicy,
      ResourcePolicySnapshotSchedulePolicySchedule schedule,
      ResourcePolicySnapshotSchedulePolicySnapshotProperties snapshotProperties) {
    this.retentionPolicy = retentionPolicy;
    this.schedule = schedule;
    this.snapshotProperties = snapshotProperties;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("retentionPolicy".equals(fieldName)) {
      return retentionPolicy;
    }
    if ("schedule".equals(fieldName)) {
      return schedule;
    }
    if ("snapshotProperties".equals(fieldName)) {
      return snapshotProperties;
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

  /** Retention policy applied to snapshots created by this resource policy. */
  public ResourcePolicySnapshotSchedulePolicyRetentionPolicy getRetentionPolicy() {
    return retentionPolicy;
  }

  /**
   * A Vm Maintenance Policy specifies what kind of infrastructure maintenance we are allowed to
   * perform on this VM and when. Schedule that is applied to disks covered by this policy.
   */
  public ResourcePolicySnapshotSchedulePolicySchedule getSchedule() {
    return schedule;
  }

  /** Properties with which snapshots are created such as labels, encryption keys. */
  public ResourcePolicySnapshotSchedulePolicySnapshotProperties getSnapshotProperties() {
    return snapshotProperties;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicySnapshotSchedulePolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicySnapshotSchedulePolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicySnapshotSchedulePolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicySnapshotSchedulePolicy();
  }

  public static class Builder {
    private ResourcePolicySnapshotSchedulePolicyRetentionPolicy retentionPolicy;
    private ResourcePolicySnapshotSchedulePolicySchedule schedule;
    private ResourcePolicySnapshotSchedulePolicySnapshotProperties snapshotProperties;

    Builder() {}

    public Builder mergeFrom(ResourcePolicySnapshotSchedulePolicy other) {
      if (other == ResourcePolicySnapshotSchedulePolicy.getDefaultInstance()) return this;
      if (other.getRetentionPolicy() != null) {
        this.retentionPolicy = other.retentionPolicy;
      }
      if (other.getSchedule() != null) {
        this.schedule = other.schedule;
      }
      if (other.getSnapshotProperties() != null) {
        this.snapshotProperties = other.snapshotProperties;
      }
      return this;
    }

    Builder(ResourcePolicySnapshotSchedulePolicy source) {
      this.retentionPolicy = source.retentionPolicy;
      this.schedule = source.schedule;
      this.snapshotProperties = source.snapshotProperties;
    }

    /** Retention policy applied to snapshots created by this resource policy. */
    public ResourcePolicySnapshotSchedulePolicyRetentionPolicy getRetentionPolicy() {
      return retentionPolicy;
    }

    /** Retention policy applied to snapshots created by this resource policy. */
    public Builder setRetentionPolicy(
        ResourcePolicySnapshotSchedulePolicyRetentionPolicy retentionPolicy) {
      this.retentionPolicy = retentionPolicy;
      return this;
    }

    /**
     * A Vm Maintenance Policy specifies what kind of infrastructure maintenance we are allowed to
     * perform on this VM and when. Schedule that is applied to disks covered by this policy.
     */
    public ResourcePolicySnapshotSchedulePolicySchedule getSchedule() {
      return schedule;
    }

    /**
     * A Vm Maintenance Policy specifies what kind of infrastructure maintenance we are allowed to
     * perform on this VM and when. Schedule that is applied to disks covered by this policy.
     */
    public Builder setSchedule(ResourcePolicySnapshotSchedulePolicySchedule schedule) {
      this.schedule = schedule;
      return this;
    }

    /** Properties with which snapshots are created such as labels, encryption keys. */
    public ResourcePolicySnapshotSchedulePolicySnapshotProperties getSnapshotProperties() {
      return snapshotProperties;
    }

    /** Properties with which snapshots are created such as labels, encryption keys. */
    public Builder setSnapshotProperties(
        ResourcePolicySnapshotSchedulePolicySnapshotProperties snapshotProperties) {
      this.snapshotProperties = snapshotProperties;
      return this;
    }

    public ResourcePolicySnapshotSchedulePolicy build() {

      return new ResourcePolicySnapshotSchedulePolicy(
          retentionPolicy, schedule, snapshotProperties);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setRetentionPolicy(this.retentionPolicy);
      newBuilder.setSchedule(this.schedule);
      newBuilder.setSnapshotProperties(this.snapshotProperties);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicySnapshotSchedulePolicy{"
        + "retentionPolicy="
        + retentionPolicy
        + ", "
        + "schedule="
        + schedule
        + ", "
        + "snapshotProperties="
        + snapshotProperties
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicySnapshotSchedulePolicy) {
      ResourcePolicySnapshotSchedulePolicy that = (ResourcePolicySnapshotSchedulePolicy) o;
      return Objects.equals(this.retentionPolicy, that.getRetentionPolicy())
          && Objects.equals(this.schedule, that.getSchedule())
          && Objects.equals(this.snapshotProperties, that.getSnapshotProperties());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(retentionPolicy, schedule, snapshotProperties);
  }
}
