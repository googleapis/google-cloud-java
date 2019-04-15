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
 * A specification of the desired way to instantiate a disk in the instance template when its
 * created from a source instance.
 */
public final class DiskInstantiationConfig implements ApiMessage {
  private final Boolean autoDelete;
  private final String customImage;
  private final String deviceName;
  private final String instantiateFrom;

  private DiskInstantiationConfig() {
    this.autoDelete = null;
    this.customImage = null;
    this.deviceName = null;
    this.instantiateFrom = null;
  }

  private DiskInstantiationConfig(
      Boolean autoDelete, String customImage, String deviceName, String instantiateFrom) {
    this.autoDelete = autoDelete;
    this.customImage = customImage;
    this.deviceName = deviceName;
    this.instantiateFrom = instantiateFrom;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoDelete".equals(fieldName)) {
      return autoDelete;
    }
    if ("customImage".equals(fieldName)) {
      return customImage;
    }
    if ("deviceName".equals(fieldName)) {
      return deviceName;
    }
    if ("instantiateFrom".equals(fieldName)) {
      return instantiateFrom;
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
   * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when the
   * disk is detached from the instance).
   */
  public Boolean getAutoDelete() {
    return autoDelete;
  }

  /**
   * The custom source image to be used to restore this disk when instantiating this instance
   * template.
   */
  public String getCustomImage() {
    return customImage;
  }

  /** Specifies the device name of the disk to which the configurations apply to. */
  public String getDeviceName() {
    return deviceName;
  }

  /**
   * Specifies whether to include the disk and what image to use. Possible values are: -
   * source-image: to use the same image that was used to create the source instance's corresponding
   * disk. Applicable to the boot disk and additional read-write disks. - source-image-family: to
   * use the same image family that was used to create the source instance's corresponding disk.
   * Applicable to the boot disk and additional read-write disks. - custom-image: to use a
   * user-provided image url for disk creation. Applicable to the boot disk and additional
   * read-write disks. - attach-read-only: to attach a read-only disk. Applicable to read-only
   * disks. - do-not-include: to exclude a disk from the template. Applicable to additional
   * read-write disks, local SSDs, and read-only disks.
   */
  public String getInstantiateFrom() {
    return instantiateFrom;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DiskInstantiationConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DiskInstantiationConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DiskInstantiationConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DiskInstantiationConfig();
  }

  public static class Builder {
    private Boolean autoDelete;
    private String customImage;
    private String deviceName;
    private String instantiateFrom;

    Builder() {}

    public Builder mergeFrom(DiskInstantiationConfig other) {
      if (other == DiskInstantiationConfig.getDefaultInstance()) return this;
      if (other.getAutoDelete() != null) {
        this.autoDelete = other.autoDelete;
      }
      if (other.getCustomImage() != null) {
        this.customImage = other.customImage;
      }
      if (other.getDeviceName() != null) {
        this.deviceName = other.deviceName;
      }
      if (other.getInstantiateFrom() != null) {
        this.instantiateFrom = other.instantiateFrom;
      }
      return this;
    }

    Builder(DiskInstantiationConfig source) {
      this.autoDelete = source.autoDelete;
      this.customImage = source.customImage;
      this.deviceName = source.deviceName;
      this.instantiateFrom = source.instantiateFrom;
    }

    /**
     * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when
     * the disk is detached from the instance).
     */
    public Boolean getAutoDelete() {
      return autoDelete;
    }

    /**
     * Specifies whether the disk will be auto-deleted when the instance is deleted (but not when
     * the disk is detached from the instance).
     */
    public Builder setAutoDelete(Boolean autoDelete) {
      this.autoDelete = autoDelete;
      return this;
    }

    /**
     * The custom source image to be used to restore this disk when instantiating this instance
     * template.
     */
    public String getCustomImage() {
      return customImage;
    }

    /**
     * The custom source image to be used to restore this disk when instantiating this instance
     * template.
     */
    public Builder setCustomImage(String customImage) {
      this.customImage = customImage;
      return this;
    }

    /** Specifies the device name of the disk to which the configurations apply to. */
    public String getDeviceName() {
      return deviceName;
    }

    /** Specifies the device name of the disk to which the configurations apply to. */
    public Builder setDeviceName(String deviceName) {
      this.deviceName = deviceName;
      return this;
    }

    /**
     * Specifies whether to include the disk and what image to use. Possible values are: -
     * source-image: to use the same image that was used to create the source instance's
     * corresponding disk. Applicable to the boot disk and additional read-write disks. -
     * source-image-family: to use the same image family that was used to create the source
     * instance's corresponding disk. Applicable to the boot disk and additional read-write disks. -
     * custom-image: to use a user-provided image url for disk creation. Applicable to the boot disk
     * and additional read-write disks. - attach-read-only: to attach a read-only disk. Applicable
     * to read-only disks. - do-not-include: to exclude a disk from the template. Applicable to
     * additional read-write disks, local SSDs, and read-only disks.
     */
    public String getInstantiateFrom() {
      return instantiateFrom;
    }

    /**
     * Specifies whether to include the disk and what image to use. Possible values are: -
     * source-image: to use the same image that was used to create the source instance's
     * corresponding disk. Applicable to the boot disk and additional read-write disks. -
     * source-image-family: to use the same image family that was used to create the source
     * instance's corresponding disk. Applicable to the boot disk and additional read-write disks. -
     * custom-image: to use a user-provided image url for disk creation. Applicable to the boot disk
     * and additional read-write disks. - attach-read-only: to attach a read-only disk. Applicable
     * to read-only disks. - do-not-include: to exclude a disk from the template. Applicable to
     * additional read-write disks, local SSDs, and read-only disks.
     */
    public Builder setInstantiateFrom(String instantiateFrom) {
      this.instantiateFrom = instantiateFrom;
      return this;
    }

    public DiskInstantiationConfig build() {

      return new DiskInstantiationConfig(autoDelete, customImage, deviceName, instantiateFrom);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoDelete(this.autoDelete);
      newBuilder.setCustomImage(this.customImage);
      newBuilder.setDeviceName(this.deviceName);
      newBuilder.setInstantiateFrom(this.instantiateFrom);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DiskInstantiationConfig{"
        + "autoDelete="
        + autoDelete
        + ", "
        + "customImage="
        + customImage
        + ", "
        + "deviceName="
        + deviceName
        + ", "
        + "instantiateFrom="
        + instantiateFrom
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DiskInstantiationConfig) {
      DiskInstantiationConfig that = (DiskInstantiationConfig) o;
      return Objects.equals(this.autoDelete, that.getAutoDelete())
          && Objects.equals(this.customImage, that.getCustomImage())
          && Objects.equals(this.deviceName, that.getDeviceName())
          && Objects.equals(this.instantiateFrom, that.getInstantiateFrom());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoDelete, customImage, deviceName, instantiateFrom);
  }
}
