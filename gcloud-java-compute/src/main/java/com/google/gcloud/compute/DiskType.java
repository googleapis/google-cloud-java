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

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * A Google Compute Engine disk type. A disk type represents the type of disk to use, such as
 * {@code pd-ssd} or {@code pd-standard}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/reference/latest/diskTypes">Disk Types</a>
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
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final String id;
  private final DiskTypeId diskTypeId;
  private final Long creationTimestamp;
  private final String description;
  private final String validDiskSize;
  private final Long defaultDiskSizeGb;
  private final DeprecationStatus<DiskTypeId> deprecationStatus;

  static final class Builder {

    private String id;
    private DiskTypeId diskTypeId;
    private Long creationTimestamp;
    private String description;
    private String validDiskSize;
    private Long defaultDiskSizeGb;
    private DeprecationStatus<DiskTypeId> deprecationStatus;

    private Builder() {}

    Builder id(String id) {
      this.id = id;
      return this;
    }

    Builder creationTimestamp(Long creationTimestamp) {
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

    Builder defaultDiskSizeGb(Long defaultDiskSizeGb) {
      this.defaultDiskSizeGb = defaultDiskSizeGb;
      return this;
    }

    Builder deprecationStatus(DeprecationStatus<DiskTypeId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

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
    this.defaultDiskSizeGb = builder.defaultDiskSizeGb;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /**
   * Returns the creation timestamp in milliseconds since epoch.
   */
  public Long creationTimestamp() {
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
  public String id() {
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
   * Returns the service-defined default disk size in GB.
   */
  public Long defaultDiskSizeGb() {
    return defaultDiskSizeGb;
  }

  /**
   * Returns the deprecation status of the disk type. If {@link DeprecationStatus#status()} is
   * either {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE}
   * the disk type should not be used. Returns {@code null} if the disk type is not deprecated.
   */
  public DeprecationStatus<DiskTypeId> deprecationStatus() {
    return deprecationStatus;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("validDiskSize", validDiskSize)
        .add("defaultDiskSizeGb", defaultDiskSizeGb)
        .add("deprecationStatus", deprecationStatus)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskTypeId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DiskType && Objects.equals(toPb(), ((DiskType) obj).toPb());
  }

  com.google.api.services.compute.model.DiskType toPb() {
    com.google.api.services.compute.model.DiskType diskTypePb =
        new com.google.api.services.compute.model.DiskType();
    if (id != null) {
      diskTypePb.setId(new BigInteger(id));
    }
    if (creationTimestamp != null) {
      diskTypePb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    diskTypePb.setDescription(description);
    diskTypePb.setValidDiskSize(validDiskSize);
    diskTypePb.setSelfLink(diskTypeId.selfLink());
    diskTypePb.setDefaultDiskSizeGb(defaultDiskSizeGb);
    diskTypePb.setZone(diskTypeId.zoneId().selfLink());
    if (deprecationStatus != null) {
      diskTypePb.setDeprecated(deprecationStatus.toPb());
    }
    return diskTypePb;
  }

  static Builder builder() {
    return new Builder();
  }

  static DiskType fromPb(com.google.api.services.compute.model.DiskType diskTypePb) {
    Builder builder = builder();
    if (diskTypePb.getId() != null) {
      builder.id(diskTypePb.getId().toString());
    }
    if (diskTypePb.getCreationTimestamp() != null) {
      builder.creationTimestamp(TIMESTAMP_FORMATTER.parseMillis(diskTypePb.getCreationTimestamp()));
    }
    builder.diskTypeId(DiskTypeId.fromUrl(diskTypePb.getSelfLink()));
    builder.description(diskTypePb.getDescription());
    builder.validDiskSize(diskTypePb.getValidDiskSize());
    builder.defaultDiskSizeGb(diskTypePb.getDefaultDiskSizeGb());
    if (diskTypePb.getDeprecated() != null) {
      builder.deprecationStatus(
          DeprecationStatus.fromPb(diskTypePb.getDeprecated(), DiskTypeId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
