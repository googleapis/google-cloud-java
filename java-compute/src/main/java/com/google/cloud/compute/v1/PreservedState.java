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
/** Preserved state for a given instance. */
public final class PreservedState implements ApiMessage {
  private final Map<String, PreservedStatePreservedDisk> disks;
  private final Map<String, String> metadata;

  private PreservedState() {
    this.disks = null;
    this.metadata = null;
  }

  private PreservedState(
      Map<String, PreservedStatePreservedDisk> disks, Map<String, String> metadata) {
    this.disks = disks;
    this.metadata = metadata;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("disks".equals(fieldName)) {
      return disks;
    }
    if ("metadata".equals(fieldName)) {
      return metadata;
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
   * Preserved disks defined for this instance. This map is keyed with the device names of the
   * disks.
   */
  public Map<String, PreservedStatePreservedDisk> getDisksMap() {
    return disks;
  }

  /** Preserved metadata defined for this instance. */
  public Map<String, String> getMetadataMap() {
    return metadata;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PreservedState prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PreservedState getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PreservedState DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PreservedState();
  }

  public static class Builder {
    private Map<String, PreservedStatePreservedDisk> disks;
    private Map<String, String> metadata;

    Builder() {}

    public Builder mergeFrom(PreservedState other) {
      if (other == PreservedState.getDefaultInstance()) return this;
      if (other.getDisksMap() != null) {
        this.disks = other.disks;
      }
      if (other.getMetadataMap() != null) {
        this.metadata = other.metadata;
      }
      return this;
    }

    Builder(PreservedState source) {
      this.disks = source.disks;
      this.metadata = source.metadata;
    }

    /**
     * Preserved disks defined for this instance. This map is keyed with the device names of the
     * disks.
     */
    public Map<String, PreservedStatePreservedDisk> getDisksMap() {
      return disks;
    }

    /**
     * Preserved disks defined for this instance. This map is keyed with the device names of the
     * disks.
     */
    public Builder putAllDisks(Map<String, PreservedStatePreservedDisk> disks) {
      this.disks = disks;
      return this;
    }

    /** Preserved metadata defined for this instance. */
    public Map<String, String> getMetadataMap() {
      return metadata;
    }

    /** Preserved metadata defined for this instance. */
    public Builder putAllMetadata(Map<String, String> metadata) {
      this.metadata = metadata;
      return this;
    }

    public PreservedState build() {

      return new PreservedState(disks, metadata);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.putAllDisks(this.disks);
      newBuilder.putAllMetadata(this.metadata);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PreservedState{" + "disks=" + disks + ", " + "metadata=" + metadata + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PreservedState) {
      PreservedState that = (PreservedState) o;
      return Objects.equals(this.disks, that.getDisksMap())
          && Objects.equals(this.metadata, that.getMetadataMap());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(disks, metadata);
  }
}
