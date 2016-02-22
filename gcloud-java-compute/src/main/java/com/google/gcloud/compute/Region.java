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
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine region.
 */
public final class Region implements Serializable {

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
  public static class Quota implements Serializable {

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

    public String metric() {
      return metric;
    }

    public double limit() {
      return limit;
    }

    public double usage() {
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

  private final RegionId regionId;
  private final Long id;
  private final String creationTimestamp;
  private final String description;
  private final String selfLink;
  private final Status status;
  private final List<ZoneId> zones;
  private final List<Quota> quotas;

  public static final class Builder {

    private RegionId regionId;
    private Long id;
    private String creationTimestamp;
    private String description;
    private String selfLink;
    private Status status;
    private List<ZoneId> zones;
    private List<Quota> quotas;

    Builder() {}

    Builder regionId(RegionId regionId) {
      this.regionId = regionId;
      return this;
    }

    Builder id(Long id) {
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

    Builder zones(List<ZoneId> zones) {
      this.zones = zones;
      return this;
    }

    Builder quotas(List<Quota> quotas) {
      this.quotas = quotas;
      return this;
    }

    Region build() {
      return new Region(this);
    }
  }

  Region(Builder builder) {
    this.regionId = builder.regionId;
    this.id = builder.id;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.selfLink = builder.selfLink;
    this.status = builder.status;
    this.zones = builder.zones;
    this.quotas = builder.quotas;
  }

  public RegionId regionId() {
    return regionId;
  }

  public Long id() {
    return id;
  }

  public String creationTimestamp() {
    return creationTimestamp;
  }

  public String description() {
    return description;
  }

  public String selfLink() {
    return selfLink;
  }

  public Status status() {
    return status;
  }

  public List<ZoneId> zones() {
    return zones;
  }

  public List<Quota> quotas() {
    return quotas;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("regionId", regionId)
        .add("id", id)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("selfLink", selfLink)
        .add("status", status)
        .add("zones", zones)
        .add("quotas", quotas)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Region && Objects.equals(toPb(), ((Region) obj).toPb());
  }

  com.google.api.services.compute.model.Region toPb() {
    com.google.api.services.compute.model.Region regionPb =
        new com.google.api.services.compute.model.Region();
    if (id != null) {
      regionPb.setId(BigInteger.valueOf(id));
    }
    regionPb.setCreationTimestamp(creationTimestamp);
    regionPb.setName(regionId.region());
    regionPb.setDescription(description);
    regionPb.setSelfLink(selfLink);
    regionPb.setStatus(status.name());
    if (zones != null) {
      regionPb.setZones(Lists.transform(zones, ZoneId.TO_URL_FUNCTION));
    }
    if (quotas != null) {
      regionPb.setQuotas(Lists.transform(quotas, Quota.TO_PB_FUNCTION));
    }
    return regionPb;
  }

  static Builder builder() {
    return new Builder();
  }

  static Region fromPb(com.google.api.services.compute.model.Region regionPb) {
    Builder builder = builder();
    builder.regionId(RegionId.fromUrl(regionPb.getSelfLink()));
    if (regionPb.getId() != null) {
      builder.id(regionPb.getId().longValue());
    }
    builder.creationTimestamp(regionPb.getCreationTimestamp());
    builder.description(regionPb.getDescription());
    builder.selfLink(regionPb.getSelfLink());
    if (regionPb.getStatus() != null) {
      builder.status(Status.valueOf(regionPb.getStatus()));
    }
    if (regionPb.getZones() != null) {
      builder.zones(Lists.transform(regionPb.getZones(), ZoneId.FROM_URL_FUNCTION));
    }
    if (regionPb.getQuotas() != null) {
      builder.quotas(Lists.transform(regionPb.getQuotas(), Quota.FROM_PB_FUNCTION));
    }
    return builder.build();
  }
}
