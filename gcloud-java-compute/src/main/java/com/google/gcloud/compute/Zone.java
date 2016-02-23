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

import com.google.api.services.compute.model.Zone.MaintenanceWindows;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine zone.
 *
 * @see <a href="https://cloud.google.com/compute/docs/zones">Region and Zones</a>
 */
public final class Zone implements Serializable {

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

  private final ZoneId zoneId;
  private final BigInteger id;
  private final String creationTimestamp;
  private final String description;
  private final String selfLink;
  private final Status status;
  private final List<MaintenanceWindow> maintenanceWindows;
  private final RegionId region;

  /**
   * Status of the region.
   */
  public enum Status {
    UP,
    DOWN
  }

  /**
   * A scheduled maintenance windows for this zone. When a zone is in a maintenance window, all
   * resources which reside in the zone will be unavailable.
   *
   * @see <a href="https://cloud.google.com/compute/docs/robustsystems#maintenance">Maintenance
   *     Windows</a>
   */
  public static final class MaintenanceWindow implements Serializable {

    static final Function<MaintenanceWindows, MaintenanceWindow> FROM_PB_FUNCTION =
        new Function<MaintenanceWindows, MaintenanceWindow>() {
          @Override
          public MaintenanceWindow apply(MaintenanceWindows pb) {
            return MaintenanceWindow.fromPb(pb);
          }
        };
    static final Function<MaintenanceWindow, MaintenanceWindows> TO_PB_FUNCTION =
        new Function<MaintenanceWindow, MaintenanceWindows>() {
          @Override
          public MaintenanceWindows apply(MaintenanceWindow maintenanceWindow) {
            return maintenanceWindow.toPb();
          }
        };

    private static final long serialVersionUID = 2270641266683329963L;

    private final String name;
    private final String description;
    private final String beginTime;
    private final String endTime;

    /**
     * Returns a zone maintenance window object.
     */
    MaintenanceWindow(String name, String description, String beginTime, String endTime) {
      this.name = name;
      this.description = description;
      this.beginTime = beginTime;
      this.endTime = endTime;
    }

    /**
     * Returns the disk of the maintanance window.
     */
    public String name() {
      return name;
    }

    /**
     * Returns a textual description of the maintenance window.
     */
    public String description() {
      return description;
    }

    /**
     * Returns the starting time of the maintenance window in RFC3339 text format.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
     */
    public String beginTime() {
      return beginTime;
    }

    /**
     * Returns the ending time of the maintenance window in RFC3339 text format.
     *
     * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
     */
    public String endTime() {
      return endTime;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("disk", name)
          .add("description", description)
          .add("beginTime", beginTime)
          .add("endTime", endTime)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, description, beginTime, endTime);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof MaintenanceWindow
          && Objects.equals(toPb(), ((MaintenanceWindow) obj).toPb());
    }

    MaintenanceWindows toPb() {
      return new MaintenanceWindows()
          .setName(name)
          .setDescription(description)
          .setBeginTime(beginTime)
          .setEndTime(endTime);
    }

    static MaintenanceWindow fromPb(MaintenanceWindows windowPb) {
      return new MaintenanceWindow(windowPb.getName(), windowPb.getDescription(),
          windowPb.getBeginTime(), windowPb.getEndTime());
    }
  }

  static final class Builder {

    private ZoneId zoneId;
    private BigInteger id;
    private String creationTimestamp;
    private String description;
    private String selfLink;
    private Status status;
    private List<MaintenanceWindow> maintenanceWindows;
    private RegionId region;

    private Builder() {}

    Builder zoneId(ZoneId zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    Builder id(BigInteger id) {
      this.id = id;
      return this;
    }

    Builder creationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    Builder description(String description) {
      this.description = description;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    Builder status(Status status) {
      this.status = status;
      return this;
    }

    Builder maintenanceWindows(List<MaintenanceWindow> maintenanceWindows) {
      this.maintenanceWindows = maintenanceWindows;
      return this;
    }

    Builder region(RegionId region) {
      this.region = region;
      return this;
    }

    Zone build() {
      return new Zone(this);
    }
  }

  private Zone(Builder builder) {
    this.zoneId = builder.zoneId;
    this.id = builder.id;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.selfLink = builder.selfLink;
    this.status = builder.status;
    this.maintenanceWindows = builder.maintenanceWindows;
    this.region = builder.region;
  }

  /**
   * Returns the zone's identity.
   */
  public ZoneId zoneId() {
    return zoneId;
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
   * Returns an optional textual description of the zone.
   */
  public String description() {
    return description;
  }

  /**
   * Returns an unique identifier for the zone; defined by the service.
   */
  public BigInteger id() {
    return id;
  }

  /**
   * Returns a service-defined URL for the zone.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the status of the zone.
   */
  public Status status() {
    return status;
  }

  /**
   * Returns the scheduled maintenance windows for this zone, if any. When the zone is in a
   * maintenance window, all resources which reside in the zone will be unavailable.
   *
   * @see <a href="https://cloud.google.com/compute/docs/robustsystems#maintenance">Maintenance
   *     Windows</a>
   */
  public List<MaintenanceWindow> maintenanceWindows() {
    return maintenanceWindows;
  }

  /**
   * Returns the identity of the region that hosts the zone.
   */
  public RegionId region() {
    return region;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("zoneId", zoneId)
        .add("id", id)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("selfLink", selfLink)
        .add("status", status)
        .add("maintenanceWindows", maintenanceWindows)
        .add("region", region)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(zoneId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Zone && Objects.equals(toPb(), ((Zone) obj).toPb());
  }

  com.google.api.services.compute.model.Zone toPb() {
    com.google.api.services.compute.model.Zone zonePb =
        new com.google.api.services.compute.model.Zone();
    zonePb.setId(id);
    zonePb.setCreationTimestamp(creationTimestamp);
    zonePb.setName(zoneId.zone());
    zonePb.setDescription(description);
    zonePb.setSelfLink(selfLink);
    zonePb.setStatus(status.name());
    if (maintenanceWindows != null) {
      zonePb.setMaintenanceWindows(
          Lists.transform(maintenanceWindows, MaintenanceWindow.TO_PB_FUNCTION));
    }
    if (region != null) {
      zonePb.setRegion(region.toUrl());
    }
    return zonePb;
  }

  static Builder builder() {
    return new Builder();
  }

  static Zone fromPb(com.google.api.services.compute.model.Zone zonePb) {
    Builder builder = builder();
    builder.zoneId(ZoneId.fromUrl(zonePb.getSelfLink()));
    builder.id(zonePb.getId());
    builder.creationTimestamp(zonePb.getCreationTimestamp());
    builder.description(zonePb.getDescription());
    builder.selfLink(zonePb.getSelfLink());
    if (zonePb.getStatus() != null) {
      builder.status(Status.valueOf(zonePb.getStatus()));
    }
    if (zonePb.getMaintenanceWindows() != null) {
      builder.maintenanceWindows(
          Lists.transform(zonePb.getMaintenanceWindows(), MaintenanceWindow.FROM_PB_FUNCTION));
    }
    if (zonePb.getRegion() != null) {
      builder.region(RegionId.fromUrl(zonePb.getRegion()));
    }
    return builder.build();
  }
}
