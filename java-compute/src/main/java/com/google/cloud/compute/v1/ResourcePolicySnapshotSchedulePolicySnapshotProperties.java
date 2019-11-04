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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Specified snapshot properties for scheduled snapshots created by this policy. */
public final class ResourcePolicySnapshotSchedulePolicySnapshotProperties implements ApiMessage {
  private final Boolean guestFlush;
  private final Map<String, String> labels;
  private final List<String> storageLocations;

  private ResourcePolicySnapshotSchedulePolicySnapshotProperties() {
    this.guestFlush = null;
    this.labels = null;
    this.storageLocations = null;
  }

  private ResourcePolicySnapshotSchedulePolicySnapshotProperties(
      Boolean guestFlush, Map<String, String> labels, List<String> storageLocations) {
    this.guestFlush = guestFlush;
    this.labels = labels;
    this.storageLocations = storageLocations;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("guestFlush".equals(fieldName)) {
      return guestFlush;
    }
    if ("labels".equals(fieldName)) {
      return labels;
    }
    if ("storageLocations".equals(fieldName)) {
      return storageLocations;
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

  /** Indication to perform a ?guest aware? snapshot. */
  public Boolean getGuestFlush() {
    return guestFlush;
  }

  /**
   * Labels to apply to scheduled snapshots. These can be later modified by the setLabels method.
   * Label values may be empty.
   */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /** Cloud Storage bucket storage location of the auto snapshot (regional or multi-regional). */
  public List<String> getStorageLocationsList() {
    return storageLocations;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      ResourcePolicySnapshotSchedulePolicySnapshotProperties prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicySnapshotSchedulePolicySnapshotProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicySnapshotSchedulePolicySnapshotProperties DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicySnapshotSchedulePolicySnapshotProperties();
  }

  public static class Builder {
    private Boolean guestFlush;
    private Map<String, String> labels;
    private List<String> storageLocations;

    Builder() {}

    public Builder mergeFrom(ResourcePolicySnapshotSchedulePolicySnapshotProperties other) {
      if (other == ResourcePolicySnapshotSchedulePolicySnapshotProperties.getDefaultInstance())
        return this;
      if (other.getGuestFlush() != null) {
        this.guestFlush = other.guestFlush;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      if (other.getStorageLocationsList() != null) {
        this.storageLocations = other.storageLocations;
      }
      return this;
    }

    Builder(ResourcePolicySnapshotSchedulePolicySnapshotProperties source) {
      this.guestFlush = source.guestFlush;
      this.labels = source.labels;
      this.storageLocations = source.storageLocations;
    }

    /** Indication to perform a ?guest aware? snapshot. */
    public Boolean getGuestFlush() {
      return guestFlush;
    }

    /** Indication to perform a ?guest aware? snapshot. */
    public Builder setGuestFlush(Boolean guestFlush) {
      this.guestFlush = guestFlush;
      return this;
    }

    /**
     * Labels to apply to scheduled snapshots. These can be later modified by the setLabels method.
     * Label values may be empty.
     */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /**
     * Labels to apply to scheduled snapshots. These can be later modified by the setLabels method.
     * Label values may be empty.
     */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /** Cloud Storage bucket storage location of the auto snapshot (regional or multi-regional). */
    public List<String> getStorageLocationsList() {
      return storageLocations;
    }

    /** Cloud Storage bucket storage location of the auto snapshot (regional or multi-regional). */
    public Builder addAllStorageLocations(List<String> storageLocations) {
      if (this.storageLocations == null) {
        this.storageLocations = new LinkedList<>();
      }
      this.storageLocations.addAll(storageLocations);
      return this;
    }

    /** Cloud Storage bucket storage location of the auto snapshot (regional or multi-regional). */
    public Builder addStorageLocations(String storageLocations) {
      if (this.storageLocations == null) {
        this.storageLocations = new LinkedList<>();
      }
      this.storageLocations.add(storageLocations);
      return this;
    }

    public ResourcePolicySnapshotSchedulePolicySnapshotProperties build() {

      return new ResourcePolicySnapshotSchedulePolicySnapshotProperties(
          guestFlush, labels, storageLocations);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setGuestFlush(this.guestFlush);
      newBuilder.putAllLabels(this.labels);
      newBuilder.addAllStorageLocations(this.storageLocations);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicySnapshotSchedulePolicySnapshotProperties{"
        + "guestFlush="
        + guestFlush
        + ", "
        + "labels="
        + labels
        + ", "
        + "storageLocations="
        + storageLocations
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicySnapshotSchedulePolicySnapshotProperties) {
      ResourcePolicySnapshotSchedulePolicySnapshotProperties that =
          (ResourcePolicySnapshotSchedulePolicySnapshotProperties) o;
      return Objects.equals(this.guestFlush, that.getGuestFlush())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.storageLocations, that.getStorageLocationsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestFlush, labels, storageLocations);
  }
}
