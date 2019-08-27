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
/** Policy for retention of scheduled snapshots. */
public final class ResourcePolicySnapshotSchedulePolicyRetentionPolicy implements ApiMessage {
  private final Integer maxRetentionDays;
  private final String onSourceDiskDelete;

  private ResourcePolicySnapshotSchedulePolicyRetentionPolicy() {
    this.maxRetentionDays = null;
    this.onSourceDiskDelete = null;
  }

  private ResourcePolicySnapshotSchedulePolicyRetentionPolicy(
      Integer maxRetentionDays, String onSourceDiskDelete) {
    this.maxRetentionDays = maxRetentionDays;
    this.onSourceDiskDelete = onSourceDiskDelete;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("maxRetentionDays".equals(fieldName)) {
      return maxRetentionDays;
    }
    if ("onSourceDiskDelete".equals(fieldName)) {
      return onSourceDiskDelete;
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

  /** Maximum age of the snapshot that is allowed to be kept. */
  public Integer getMaxRetentionDays() {
    return maxRetentionDays;
  }

  /** Specifies the behavior to apply to scheduled snapshots when the source disk is deleted. */
  public String getOnSourceDiskDelete() {
    return onSourceDiskDelete;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicySnapshotSchedulePolicyRetentionPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicySnapshotSchedulePolicyRetentionPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicySnapshotSchedulePolicyRetentionPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicySnapshotSchedulePolicyRetentionPolicy();
  }

  public static class Builder {
    private Integer maxRetentionDays;
    private String onSourceDiskDelete;

    Builder() {}

    public Builder mergeFrom(ResourcePolicySnapshotSchedulePolicyRetentionPolicy other) {
      if (other == ResourcePolicySnapshotSchedulePolicyRetentionPolicy.getDefaultInstance())
        return this;
      if (other.getMaxRetentionDays() != null) {
        this.maxRetentionDays = other.maxRetentionDays;
      }
      if (other.getOnSourceDiskDelete() != null) {
        this.onSourceDiskDelete = other.onSourceDiskDelete;
      }
      return this;
    }

    Builder(ResourcePolicySnapshotSchedulePolicyRetentionPolicy source) {
      this.maxRetentionDays = source.maxRetentionDays;
      this.onSourceDiskDelete = source.onSourceDiskDelete;
    }

    /** Maximum age of the snapshot that is allowed to be kept. */
    public Integer getMaxRetentionDays() {
      return maxRetentionDays;
    }

    /** Maximum age of the snapshot that is allowed to be kept. */
    public Builder setMaxRetentionDays(Integer maxRetentionDays) {
      this.maxRetentionDays = maxRetentionDays;
      return this;
    }

    /** Specifies the behavior to apply to scheduled snapshots when the source disk is deleted. */
    public String getOnSourceDiskDelete() {
      return onSourceDiskDelete;
    }

    /** Specifies the behavior to apply to scheduled snapshots when the source disk is deleted. */
    public Builder setOnSourceDiskDelete(String onSourceDiskDelete) {
      this.onSourceDiskDelete = onSourceDiskDelete;
      return this;
    }

    public ResourcePolicySnapshotSchedulePolicyRetentionPolicy build() {

      return new ResourcePolicySnapshotSchedulePolicyRetentionPolicy(
          maxRetentionDays, onSourceDiskDelete);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMaxRetentionDays(this.maxRetentionDays);
      newBuilder.setOnSourceDiskDelete(this.onSourceDiskDelete);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicySnapshotSchedulePolicyRetentionPolicy{"
        + "maxRetentionDays="
        + maxRetentionDays
        + ", "
        + "onSourceDiskDelete="
        + onSourceDiskDelete
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicySnapshotSchedulePolicyRetentionPolicy) {
      ResourcePolicySnapshotSchedulePolicyRetentionPolicy that =
          (ResourcePolicySnapshotSchedulePolicyRetentionPolicy) o;
      return Objects.equals(this.maxRetentionDays, that.getMaxRetentionDays())
          && Objects.equals(this.onSourceDiskDelete, that.getOnSourceDiskDelete());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxRetentionDays, onSourceDiskDelete);
  }
}
