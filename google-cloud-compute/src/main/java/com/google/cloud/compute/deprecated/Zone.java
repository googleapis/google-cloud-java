/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * A Google Compute Engine zone.
 *
 * @see <a href="https://cloud.google.com/compute/docs/zones">Region and Zones</a>
 */
public class Zone implements Serializable {

  static final Function<com.google.api.services.compute.model.Zone, Zone> FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.Zone, Zone>() {
        @Override
        public Zone apply(com.google.api.services.compute.model.Zone pb) {
          return Zone.fromPb(pb);
        }
      };
  static final Function<Zone, com.google.api.services.compute.model.Zone> TO_PB_FUNCTION =
      new Function<Zone, com.google.api.services.compute.model.Zone>() {
        @Override
        public com.google.api.services.compute.model.Zone apply(Zone region) {
          return region.toPb();
        }
      };

  private static final long serialVersionUID = 6113636504417213010L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final ZoneId zoneId;
  private final String generatedId;
  private final Long creationTimestamp;
  private final String description;
  private final Status status;
  private final RegionId region;
  private final DeprecationStatus<ZoneId> deprecationStatus;

  /**
   * Status of the region.
   */
  public static final class Status extends StringEnumValue {
    private static final long serialVersionUID = -1052872318386811804L;

    private static final ApiFunction<String, Status> CONSTRUCTOR =
        new ApiFunction<String, Status>() {
          @Override
          public Status apply(String constant) {
            return new Status(constant);
          }
        };

    private static final StringEnumType<Status> type = new StringEnumType(
        Status.class,
        CONSTRUCTOR);

    public static final Status UP = type.createAndRegister("UP");
    public static final Status DOWN = type.createAndRegister("DOWN");

    private Status(String constant) {
      super(constant);
    }

    /**
     * Get the Status for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static Status valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the Status for the given String constant, and allow unrecognized values.
     */
    public static Status valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values for Status.
     */
    public static Status[] values() {
      return type.values();
    }
  }

  static final class Builder {

    private ZoneId zoneId;
    private String generatedId;
    private Long creationTimestamp;
    private String description;

    private Status status;
    private RegionId region;
    private DeprecationStatus<ZoneId> deprecationStatus;

    private Builder() {}

    Builder setZoneId(ZoneId zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    Builder setStatus(Status status) {
      this.status = status;
      return this;
    }

    Builder setRegion(RegionId region) {
      this.region = region;
      return this;
    }

    Builder setDeprecationStatus(DeprecationStatus<ZoneId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

    Zone build() {
      return new Zone(this);
    }
  }

  private Zone(Builder builder) {
    this.zoneId = builder.zoneId;
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.status = builder.status;
    this.region = builder.region;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /**
   * Returns the zone's identity.
   */
  public ZoneId getZoneId() {
    return zoneId;
  }

  /**
   * Returns the creation timestamp in milliseconds since epoch.
   */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Returns an optional textual description of the zone.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the service-generated unique identifier for the zone.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the status of the zone.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Returns the identity of the region that hosts the zone.
   */
  public RegionId getRegion() {
    return region;
  }

  /**
   * Returns the deprecation status of the zone. If {@link DeprecationStatus#getStatus()} is either
   * {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE} the zone
   * should not be used. Returns {@code null} if the zone is not deprecated.
   */
  public DeprecationStatus<ZoneId> getDeprecationStatus() {
    return deprecationStatus;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("zoneId", zoneId)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("status", status)
        .add("region", region)
        .add("deprecationStatus", deprecationStatus)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(zoneId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(Zone.class)
        && Objects.equals(toPb(), ((Zone) obj).toPb());
  }

  com.google.api.services.compute.model.Zone toPb() {
    com.google.api.services.compute.model.Zone zonePb =
        new com.google.api.services.compute.model.Zone();
    if (generatedId != null) {
      zonePb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      zonePb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    zonePb.setName(zoneId.getZone());
    zonePb.setDescription(description);
    zonePb.setSelfLink(zoneId.getSelfLink());
    if (status != null) {
      zonePb.setStatus(status.name());
    }
    if (region != null) {
      zonePb.setRegion(region.getSelfLink());
    }
    if (deprecationStatus != null) {
      zonePb.setDeprecated(deprecationStatus.toPb());
    }
    return zonePb;
  }

  static Builder builder() {
    return new Builder();
  }

  static Zone fromPb(com.google.api.services.compute.model.Zone zonePb) {
    Builder builder = builder();
    builder.setZoneId(ZoneId.fromUrl(zonePb.getSelfLink()));
    if (zonePb.getId() != null) {
      builder.setGeneratedId(zonePb.getId().toString());
    }
    if (zonePb.getCreationTimestamp() != null) {
      builder.setCreationTimestamp(TIMESTAMP_FORMATTER.parseMillis(zonePb.getCreationTimestamp()));
    }
    builder.setDescription(zonePb.getDescription());
    if (zonePb.getStatus() != null) {
      builder.setStatus(Status.valueOf(zonePb.getStatus()));
    }
    if (zonePb.getRegion() != null) {
      builder.setRegion(RegionId.fromUrl(zonePb.getRegion()));
    }
    if (zonePb.getDeprecated() != null) {
      builder.setDeprecationStatus(
          DeprecationStatus.fromPb(zonePb.getDeprecated(), ZoneId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
