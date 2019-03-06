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

package com.google.cloud.dns;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.dns.model.Project;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The class provides the Google Cloud DNS information associated with this project. A project is a
 * top level container for resources including {@code Zone}s. Projects can be created only in the
 * APIs console.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/projects">Google Cloud DNS documentation</a>
 */
public class ProjectInfo implements Serializable {

  private static final long serialVersionUID = 8696578863323485036L;
  private final String id;
  private final BigInteger number;
  private final Quota quota;

  /**
   * This class represents quotas assigned to the {@code ProjectInfo}.
   *
   * @see <a href="https://cloud.google.com/dns/api/v1/projects#quota">Google Cloud DNS
   *     documentation</a>
   */
  public static class Quota implements Serializable {

    private static final long serialVersionUID = 6854685970605363639L;
    private final int zones;
    private final int resourceRecordsPerRrset;
    private final int rrsetAdditionsPerChange;
    private final int rrsetDeletionsPerChange;
    private final int rrsetsPerZone;
    private final int totalRrdataSizePerChange;

    /**
     * Creates an instance of {@code Quota}.
     *
     * <p>This is the only way of creating an instance of {@code Quota}. As the service does not
     * allow for specifying options, quota is an "all-or-nothing object" and we do not need a
     * builder.
     */
    Quota(
        int zones,
        int resourceRecordsPerRrset,
        int rrsetAdditionsPerChange,
        int rrsetDeletionsPerChange,
        int rrsetsPerZone,
        int totalRrdataSizePerChange) {
      this.zones = zones;
      this.resourceRecordsPerRrset = resourceRecordsPerRrset;
      this.rrsetAdditionsPerChange = rrsetAdditionsPerChange;
      this.rrsetDeletionsPerChange = rrsetDeletionsPerChange;
      this.rrsetsPerZone = rrsetsPerZone;
      this.totalRrdataSizePerChange = totalRrdataSizePerChange;
    }

    /** Returns the maximum allowed number of zones in the project. */
    public int getZones() {
      return zones;
    }

    /** Returns the maximum allowed number of records per {@link RecordSet}. */
    public int getResourceRecordsPerRrset() {
      return resourceRecordsPerRrset;
    }

    /**
     * Returns the maximum allowed number of {@link RecordSet}s to add per {@link ChangeRequest}.
     */
    public int getRrsetAdditionsPerChange() {
      return rrsetAdditionsPerChange;
    }

    /**
     * Returns the maximum allowed number of {@link RecordSet}s to delete per {@link ChangeRequest}.
     */
    public int getRrsetDeletionsPerChange() {
      return rrsetDeletionsPerChange;
    }

    /**
     * Returns the maximum allowed number of {@link RecordSet}s per {@link ZoneInfo} in the project.
     */
    public int getRrsetsPerZone() {
      return rrsetsPerZone;
    }

    /** Returns the maximum allowed size for total records in one ChangesRequest in bytes. */
    public int getTotalRrdataSizePerChange() {
      return totalRrdataSizePerChange;
    }

    @Override
    public boolean equals(Object other) {
      return (other instanceof Quota) && this.toPb().equals(((Quota) other).toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          zones,
          resourceRecordsPerRrset,
          rrsetAdditionsPerChange,
          rrsetDeletionsPerChange,
          rrsetsPerZone,
          totalRrdataSizePerChange);
    }

    com.google.api.services.dns.model.Quota toPb() {
      com.google.api.services.dns.model.Quota pb = new com.google.api.services.dns.model.Quota();
      pb.setManagedZones(zones);
      pb.setResourceRecordsPerRrset(resourceRecordsPerRrset);
      pb.setRrsetAdditionsPerChange(rrsetAdditionsPerChange);
      pb.setRrsetDeletionsPerChange(rrsetDeletionsPerChange);
      pb.setRrsetsPerManagedZone(rrsetsPerZone);
      pb.setTotalRrdataSizePerChange(totalRrdataSizePerChange);
      return pb;
    }

    static Quota fromPb(com.google.api.services.dns.model.Quota pb) {
      return new Quota(
          pb.getManagedZones(),
          pb.getResourceRecordsPerRrset(),
          pb.getRrsetAdditionsPerChange(),
          pb.getRrsetDeletionsPerChange(),
          pb.getRrsetsPerManagedZone(),
          pb.getTotalRrdataSizePerChange());
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("zones", zones)
          .add("resourceRecordsPerRrset", resourceRecordsPerRrset)
          .add("rrsetAdditionsPerChange", rrsetAdditionsPerChange)
          .add("rrsetDeletionsPerChange", rrsetDeletionsPerChange)
          .add("rrsetsPerZone", rrsetsPerZone)
          .add("totalRrdataSizePerChange", totalRrdataSizePerChange)
          .toString();
    }
  }

  /** A builder for {@code ProjectInfo}. */
  static class Builder {
    private String id;
    private BigInteger number;
    private Quota quota;

    private Builder() {}

    /** Sets an id of the project. */
    Builder setId(String id) {
      this.id = checkNotNull(id);
      return this;
    }

    /** Sets a number of the project. */
    Builder setNumber(BigInteger number) {
      this.number = checkNotNull(number);
      return this;
    }

    /** Sets quotas assigned to the project. */
    Builder setQuota(Quota quota) {
      this.quota = checkNotNull(quota);
      return this;
    }

    /** Builds an instance of the {@code ProjectInfo}. */
    ProjectInfo build() {
      return new ProjectInfo(this);
    }
  }

  private ProjectInfo(Builder builder) {
    this.id = builder.id;
    this.number = builder.number;
    this.quota = builder.quota;
  }

  /** Returns a builder for {@code ProjectInfo}. */
  static Builder newBuilder() {
    return new Builder();
  }

  /** Returns the {@code Quota} object which contains quotas assigned to this project. */
  public Quota getQuota() {
    return quota;
  }

  /** Returns project number. For internal use only. */
  BigInteger getNumber() {
    return number;
  }

  /** Returns project id. For internal use only. */
  String getId() {
    return id;
  }

  Project toPb() {
    Project pb = new Project();
    pb.setId(id);
    pb.setNumber(number);
    if (this.quota != null) {
      pb.setQuota(quota.toPb());
    }
    return pb;
  }

  static ProjectInfo fromPb(Project pb) {
    Builder builder = newBuilder();
    if (pb.getId() != null) {
      builder.setId(pb.getId());
    }
    if (pb.getNumber() != null) {
      builder.setNumber(pb.getNumber());
    }
    if (pb.getQuota() != null) {
      builder.setQuota(Quota.fromPb(pb.getQuota()));
    }
    return builder.build();
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ProjectInfo.class)
            && toPb().equals(((ProjectInfo) obj).toPb());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(id, number, quota);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("number", number)
        .add("quota", quota)
        .toString();
  }
}
