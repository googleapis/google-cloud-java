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
/**
 * A specification of the parameters to use when creating the instance template from a source
 * instance.
 */
public final class SourceInstanceParams implements ApiMessage {
  private final List<DiskInstantiationConfig> diskConfigs;

  private SourceInstanceParams() {
    this.diskConfigs = null;
  }

  private SourceInstanceParams(List<DiskInstantiationConfig> diskConfigs) {
    this.diskConfigs = diskConfigs;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("diskConfigs".equals(fieldName)) {
      return diskConfigs;
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
   * Attached disks configuration. If not provided, defaults are applied: For boot disk and any
   * other R/W disks, new custom images will be created from each disk. For read-only disks, they
   * will be attached in read-only mode. Local SSD disks will be created as blank volumes.
   */
  public List<DiskInstantiationConfig> getDiskConfigsList() {
    return diskConfigs;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SourceInstanceParams prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SourceInstanceParams getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SourceInstanceParams DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SourceInstanceParams();
  }

  public static class Builder {
    private List<DiskInstantiationConfig> diskConfigs;

    Builder() {}

    public Builder mergeFrom(SourceInstanceParams other) {
      if (other == SourceInstanceParams.getDefaultInstance()) return this;
      if (other.getDiskConfigsList() != null) {
        this.diskConfigs = other.diskConfigs;
      }
      return this;
    }

    Builder(SourceInstanceParams source) {
      this.diskConfigs = source.diskConfigs;
    }

    /**
     * Attached disks configuration. If not provided, defaults are applied: For boot disk and any
     * other R/W disks, new custom images will be created from each disk. For read-only disks, they
     * will be attached in read-only mode. Local SSD disks will be created as blank volumes.
     */
    public List<DiskInstantiationConfig> getDiskConfigsList() {
      return diskConfigs;
    }

    /**
     * Attached disks configuration. If not provided, defaults are applied: For boot disk and any
     * other R/W disks, new custom images will be created from each disk. For read-only disks, they
     * will be attached in read-only mode. Local SSD disks will be created as blank volumes.
     */
    public Builder addAllDiskConfigs(List<DiskInstantiationConfig> diskConfigs) {
      if (this.diskConfigs == null) {
        this.diskConfigs = new LinkedList<>();
      }
      this.diskConfigs.addAll(diskConfigs);
      return this;
    }

    /**
     * Attached disks configuration. If not provided, defaults are applied: For boot disk and any
     * other R/W disks, new custom images will be created from each disk. For read-only disks, they
     * will be attached in read-only mode. Local SSD disks will be created as blank volumes.
     */
    public Builder addDiskConfigs(DiskInstantiationConfig diskConfigs) {
      if (this.diskConfigs == null) {
        this.diskConfigs = new LinkedList<>();
      }
      this.diskConfigs.add(diskConfigs);
      return this;
    }

    public SourceInstanceParams build() {
      return new SourceInstanceParams(diskConfigs);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllDiskConfigs(this.diskConfigs);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SourceInstanceParams{" + "diskConfigs=" + diskConfigs + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SourceInstanceParams) {
      SourceInstanceParams that = (SourceInstanceParams) o;
      return Objects.equals(this.diskConfigs, that.getDiskConfigsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskConfigs);
  }
}
