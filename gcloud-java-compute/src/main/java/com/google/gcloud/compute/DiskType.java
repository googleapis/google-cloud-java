/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.compute;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Google Compute Engine Disk type. A disk type represents the type of disk to use, such as a
 * {@code pd-ssd} or {@code pd-standard}.
 */
public final class DiskType implements Serializable {

  static final Function<com.google.api.services.compute.model.DiskType, DiskType> FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.DiskType, DiskType>() {
        @Override
        public DiskType apply(com.google.api.services.compute.model.DiskType pb) {
          return DiskType.fromPb(pb);
        }
      };
  static final Function<DiskType, com.google.api.services.compute.model.DiskType> TO_PB_FUNCTION =
      new Function<DiskType, com.google.api.services.compute.model.DiskType>() {
        @Override
        public com.google.api.services.compute.model.DiskType apply(DiskType diskType) {
          return diskType.toPb();
        }
      };

  private static final long serialVersionUID = -944042261695072026L;

  private final Long id;
  private final DiskTypeId diskTypeId;
  private final String creationTimestamp;
  private final String description;
  private final String validDiskSize;
  private final String selfLink;
  private final Long defaultDiskSizeGb;

  static final class Builder {

    private Long id;
    private DiskTypeId diskTypeId;
    private String creationTimestamp;
    private String description;
    private String validDiskSize;
    private String selfLink;
    private Long defaultDiskSizeGb;

    private Builder() {}

    Builder id(Long id) {
      this.id = id;
      return this;
    }

    Builder creationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    Builder diskTypeId(DiskTypeId diskTypeId) {
      this.diskTypeId = diskTypeId;
      return this;
    }

    Builder description(String description) {
      this.description = description;
      return this;
    }

    Builder validDiskSize(String validDiskSize) {
      this.validDiskSize = validDiskSize;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    Builder defaultDiskSizeGb(Long defaultDiskSizeGb) {
      this.defaultDiskSizeGb = defaultDiskSizeGb;
      return this;
    }

    /**
     * Creates a {@code DiskType} object.
     */
    DiskType build() {
      return new DiskType(this);
    }
  }

  private DiskType(Builder builder) {
    this.id = builder.id;
    this.creationTimestamp = builder.creationTimestamp;
    this.diskTypeId = builder.diskTypeId;
    this.description = builder.description;
    this.validDiskSize = builder.validDiskSize;
    this.selfLink = builder.selfLink;
    this.defaultDiskSizeGb = builder.defaultDiskSizeGb;
  }

  /**
   * Returns the creation timestamp in RFC3339 text format.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  public String creationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Returns the disk type's identity.
   */
  public DiskTypeId diskTypeId() {
    return diskTypeId;
  }

  /**
   * Returns an unique identifier for the disk type; defined by the service.
   */
  public Long id() {
    return id;
  }

  /**
   * Returns a textual description of the disk type.
   */
  public String description() {
    return description;
  }

  /**
   * Returns an optional textual description of the valid disk size, such as "10GB-10TB".
   */
  public String validDiskSize() {
    return validDiskSize;
  }

  /**
   * Returns a service-defined URL for the disk type.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the service-defined default disk size in GB.
   */
  public Long defaultDiskSizeGb() {
    return defaultDiskSizeGb;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("validDiskSize", validDiskSize)
        .add("selfLink", selfLink)
        .add("defaultDiskSizeGb", defaultDiskSizeGb)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DiskType && Objects.equals(toPb(), ((DiskType) obj).toPb());
  }

  com.google.api.services.compute.model.DiskType toPb() {
    com.google.api.services.compute.model.DiskType diskTypePb =
        new com.google.api.services.compute.model.DiskType();
    if (id != null) {
      diskTypePb.setId(BigInteger.valueOf(id));
    }
    diskTypePb.setCreationTimestamp(creationTimestamp);
    diskTypePb.setDescription(description);
    diskTypePb.setValidDiskSize(validDiskSize);
    diskTypePb.setSelfLink(selfLink);
    diskTypePb.setDefaultDiskSizeGb(defaultDiskSizeGb);
    diskTypePb.setZone(diskTypeId.zoneId().toUrl());
    return diskTypePb;
  }

  static Builder builder() {
    return new Builder();
  }

  static DiskType fromPb(com.google.api.services.compute.model.DiskType diskTypePb) {
    Builder builder = builder();
    if (diskTypePb.getId() != null ) {
      builder.id(diskTypePb.getId().longValue());
    }
    builder.creationTimestamp(diskTypePb.getCreationTimestamp());
    builder.diskTypeId(DiskTypeId.fromUrl(diskTypePb.getSelfLink()));
    builder.description(diskTypePb.getDescription());
    builder.validDiskSize(diskTypePb.getValidDiskSize());
    builder.selfLink(diskTypePb.getSelfLink());
    builder.defaultDiskSizeGb(diskTypePb.getDefaultDiskSizeGb());
    return builder.build();
  }
}
