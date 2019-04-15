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
public final class DiskMoveRequest implements ApiMessage {
  private final String destinationZone;
  private final String targetDisk;

  private DiskMoveRequest() {
    this.destinationZone = null;
    this.targetDisk = null;
  }

  private DiskMoveRequest(String destinationZone, String targetDisk) {
    this.destinationZone = destinationZone;
    this.targetDisk = targetDisk;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("destinationZone".equals(fieldName)) {
      return destinationZone;
    }
    if ("targetDisk".equals(fieldName)) {
      return targetDisk;
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
   * The URL of the destination zone to move the disk. This can be a full or partial URL. For
   * example, the following are all valid URLs to a zone: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone - projects/project/zones/zone
   * - zones/zone
   */
  public String getDestinationZone() {
    return destinationZone;
  }

  /**
   * The URL of the target disk to move. This can be a full or partial URL. For example, the
   * following are all valid URLs to a disk: -
   * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
   * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
   */
  public String getTargetDisk() {
    return targetDisk;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DiskMoveRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DiskMoveRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DiskMoveRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DiskMoveRequest();
  }

  public static class Builder {
    private String destinationZone;
    private String targetDisk;

    Builder() {}

    public Builder mergeFrom(DiskMoveRequest other) {
      if (other == DiskMoveRequest.getDefaultInstance()) return this;
      if (other.getDestinationZone() != null) {
        this.destinationZone = other.destinationZone;
      }
      if (other.getTargetDisk() != null) {
        this.targetDisk = other.targetDisk;
      }
      return this;
    }

    Builder(DiskMoveRequest source) {
      this.destinationZone = source.destinationZone;
      this.targetDisk = source.targetDisk;
    }

    /**
     * The URL of the destination zone to move the disk. This can be a full or partial URL. For
     * example, the following are all valid URLs to a zone: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone -
     * projects/project/zones/zone - zones/zone
     */
    public String getDestinationZone() {
      return destinationZone;
    }

    /**
     * The URL of the destination zone to move the disk. This can be a full or partial URL. For
     * example, the following are all valid URLs to a zone: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone -
     * projects/project/zones/zone - zones/zone
     */
    public Builder setDestinationZone(String destinationZone) {
      this.destinationZone = destinationZone;
      return this;
    }

    /**
     * The URL of the target disk to move. This can be a full or partial URL. For example, the
     * following are all valid URLs to a disk: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
     * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
     */
    public String getTargetDisk() {
      return targetDisk;
    }

    /**
     * The URL of the target disk to move. This can be a full or partial URL. For example, the
     * following are all valid URLs to a disk: -
     * https://www.googleapis.com/compute/v1/projects/project/zones/zone/disks/disk -
     * projects/project/zones/zone/disks/disk - zones/zone/disks/disk
     */
    public Builder setTargetDisk(String targetDisk) {
      this.targetDisk = targetDisk;
      return this;
    }

    public DiskMoveRequest build() {

      return new DiskMoveRequest(destinationZone, targetDisk);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDestinationZone(this.destinationZone);
      newBuilder.setTargetDisk(this.targetDisk);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DiskMoveRequest{"
        + "destinationZone="
        + destinationZone
        + ", "
        + "targetDisk="
        + targetDisk
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DiskMoveRequest) {
      DiskMoveRequest that = (DiskMoveRequest) o;
      return Objects.equals(this.destinationZone, that.getDestinationZone())
          && Objects.equals(this.targetDisk, that.getTargetDisk());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationZone, targetDisk);
  }
}
