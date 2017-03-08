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

package com.google.cloud.compute;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine region.
 *
 * @see <a href="https://cloud.google.com/compute/docs/zones">Region and Zones</a>
 */
public class Region implements Serializable {

  static final Function<com.google.api.services.compute.model.Region, Region> FROM_PB_FUNCTION =
      new Function<com.google.api.services.compute.model.Region, Region>() {
        @Override
        public Region apply(com.google.api.services.compute.model.Region pb) {
          return Region.fromPb(pb);
        }
      };
  static final Function<Region, com.google.api.services.compute.model.Region> TO_PB_FUNCTION =
      new Function<Region, com.google.api.services.compute.model.Region>() {
        @Override
        public com.google.api.services.compute.model.Region apply(Region region) {
          return region.toPb();
        }
      };

  private static final long serialVersionUID = -3578710133393645135L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final RegionId regionId;
  private final String generatedId;
  private final Long creationTimestamp;
  private final String description;
  private final Status status;
  private final List<ZoneId> zones;
  private final List<Quota> quotas;
  private final DeprecationStatus<RegionId> deprecationStatus;

  /**
   * Status of the region.
   */
  public enum Status {
    UP,
    DOWN
  }

  /**
   * A quota assigned to this region.
   */
  public static final class Quota implements Serializable {

    static final Function<com.google.api.services.compute.model.Quota, Quota> FROM_PB_FUNCTION =
        new Function<com.google.api.services.compute.model.Quota, Quota>() {
          @Override
          public Quota apply(com.google.api.services.compute.model.Quota pb) {
            return Quota.fromPb(pb);
          }
        };
    static final Function<Quota, com.google.api.services.compute.model.Quota> TO_PB_FUNCTION =
        new Function<Quota, com.google.api.services.compute.model.Quota>() {
          @Override
          public com.google.api.services.compute.model.Quota apply(Quota quota) {
            return quota.toPb();
          }
        };
    private static final long serialVersionUID = -4357118665133226338L;

    private final String metric;
    private final double limit;
    private final double usage;

    /**
     * Returns a region quota object.
     */
    Quota(String metric, double limit, double usage) {
      this.metric = metric;
      this.limit = limit;
      this.usage = usage;
    }

    /**
     * Returns the name of the quota metric.
     */
    @Deprecated
    public String metric() {
      return getMetric();
    }

    /**
     * Returns the name of the quota metric.
     */
    public String getMetric() {
      return metric;
    }

    /**
     * Returns the quota limit for this metric.
     */
    @Deprecated
    public double limit() {
      return getLimit();
    }

    /**
     * Returns the quota limit for this metric.
     */
    public double getLimit() {
      return limit;
    }

    /**
     * Returns the current usage for this quota.
     */
    @Deprecated
    public double usage() {
      return getUsage();
    }

    /**
     * Returns the current usage for this quota.
     */
    public double getUsage() {
      return usage;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("metric", metric)
          .add("limit", limit)
          .add("usage", usage)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(metric, limit, usage);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Quota)) {
        return false;
      }
      Quota other = (Quota) obj;
      return Objects.equals(metric, other.metric)
          && Objects.equals(limit, other.limit)
          && Objects.equals(usage, other.usage);
    }

    com.google.api.services.compute.model.Quota toPb() {
      return new com.google.api.services.compute.model.Quota()
          .setMetric(metric)
          .setLimit(limit)
          .setUsage(usage);
    }

    static Quota fromPb(com.google.api.services.compute.model.Quota quotaPb) {
      return new Quota(quotaPb.getMetric(), quotaPb.getLimit(), quotaPb.getUsage());
    }
  }

  static final class Builder {

    private RegionId regionId;
    private String generatedId;
    private Long creationTimestamp;
    private String description;

    private Status status;
    private List<ZoneId> zones;
    private List<Quota> quotas;
    private  DeprecationStatus<RegionId> deprecationStatus;

    private Builder() {}

    Builder setRegionId(RegionId regionId) {
      this.regionId = regionId;
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

    Builder setZones(List<ZoneId> zones) {
      this.zones = ImmutableList.copyOf(zones);
      return this;
    }

    Builder setQuotas(List<Quota> quotas) {
      this.quotas = ImmutableList.copyOf(quotas);
      return this;
    }

    Builder setDeprecationStatus(DeprecationStatus<RegionId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

    Region build() {
      return new Region(this);
    }
  }

  private Region(Builder builder) {
    this.regionId = builder.regionId;
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.status = builder.status;
    this.zones = builder.zones;
    this.quotas = builder.quotas;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /**
   * Returns the region's identity.
   */
  @Deprecated
  public RegionId regionId() {
    return getRegionId();
  }

  /**
   * Returns the region's identity.
   */
  public RegionId getRegionId() {
    return regionId;
  }

  /**
   * Returns the service-generated unique identifier for the region.
   */
  @Deprecated
  public String generatedId() {
    return getGeneratedId();
  }

  /**
   * Returns the service-generated unique identifier for the region.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the creation timestamp in milliseconds since epoch.
   */
  @Deprecated
  public Long creationTimestamp() {
    return getCreationTimestamp();
  }

  /**
   * Returns the creation timestamp in milliseconds since epoch.
   */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Returns an optional textual description of the region.
   */
  @Deprecated
  public String description() {
    return getDescription();
  }

  /**
   * Returns an optional textual description of the region.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the status of the status.
   */
  @Deprecated
  public Status status() {
    return getStatus();
  }

  /**
   * Returns the status of the status.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Returns a list of identities of zones available in this region.
   */
  @Deprecated
  public List<ZoneId> zones() {
    return getZones();
  }

  /**
   * Returns a list of identities of zones available in this region.
   */
  public List<ZoneId> getZones() {
    return zones;
  }

  /**
   * Returns quotas assigned to this region.
   */
  @Deprecated
  public List<Quota> quotas() {
    return getQuotas();
  }

  /**
   * Returns quotas assigned to this region.
   */
  public List<Quota> getQuotas() {
    return quotas;
  }

  /**
   * Returns the deprecation status of the region. If {@link DeprecationStatus#status()} is either
   * {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE} the
   * region should not be used. Returns {@code null} if the region is not deprecated.
   */
  @Deprecated
  public DeprecationStatus<RegionId> deprecationStatus() {
    return getDeprecationStatus();
  }

  /**
   * Returns the deprecation status of the region. If {@link DeprecationStatus#getStatus()} is either
   * {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE} the
   * region should not be used. Returns {@code null} if the region is not deprecated.
   */
  public DeprecationStatus<RegionId> getDeprecationStatus() {
    return deprecationStatus;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("regionId", regionId)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("status", status)
        .add("zones", zones)
        .add("quotas", quotas)
        .add("deprecationStatus", deprecationStatus)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(regionId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(Region.class)
        && Objects.equals(toPb(), ((Region) obj).toPb());
  }

  com.google.api.services.compute.model.Region toPb() {
    com.google.api.services.compute.model.Region regionPb =
        new com.google.api.services.compute.model.Region();
    if (generatedId != null) {
      regionPb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      regionPb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    regionPb.setName(regionId.getRegion());
    regionPb.setDescription(description);
    regionPb.setSelfLink(regionId.getSelfLink());
    if (status != null) {
      regionPb.setStatus(status.name());
    }
    if (zones != null) {
      regionPb.setZones(Lists.transform(zones, ZoneId.TO_URL_FUNCTION));
    }
    if (quotas != null) {
      regionPb.setQuotas(Lists.transform(quotas, Quota.TO_PB_FUNCTION));
    }
    if (deprecationStatus != null) {
      regionPb.setDeprecated(deprecationStatus.toPb());
    }
    return regionPb;
  }

  static Builder builder() {
    return new Builder();
  }

  static Region fromPb(com.google.api.services.compute.model.Region regionPb) {
    Builder builder = builder();
    builder.setRegionId(RegionId.fromUrl(regionPb.getSelfLink()));
    if (regionPb.getId() != null) {
      builder.setGeneratedId(regionPb.getId().toString());
    }
    if (regionPb.getCreationTimestamp() != null) {
      builder.setCreationTimestamp(
          TIMESTAMP_FORMATTER.parseMillis(regionPb.getCreationTimestamp()));
    }
    builder.setDescription(regionPb.getDescription());
    if (regionPb.getStatus() != null) {
      builder.setStatus(Status.valueOf(regionPb.getStatus()));
    }
    if (regionPb.getZones() != null) {
      builder.setZones(Lists.transform(regionPb.getZones(), ZoneId.FROM_URL_FUNCTION));
    }
    if (regionPb.getQuotas() != null) {
      builder.setQuotas(Lists.transform(regionPb.getQuotas(), Quota.FROM_PB_FUNCTION));
    }
    if (regionPb.getDeprecated() != null) {
      builder.setDeprecationStatus(
          DeprecationStatus.fromPb(regionPb.getDeprecated(), RegionId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
