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

package com.google.gcloud.dns;

import static com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The class that encapsulates information about a project in Google Cloud DNS. A project is a top
 * level container for resources including {@link ManagedZone}s. Projects can be created only in the
 * APIs console.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/projects">Google Cloud DNS documentation</a>
 */
public class ProjectInfo implements Serializable {

  private static final long serialVersionUID = 201601251420L;
  private final String id;
  private final BigInteger number;
  private final Quota quota;

  /**
   * This class represents quotas assigned to the {@code ProjectInfo}.
   *
   * @see <a href="https://cloud.google.com/dns/api/v1/projects">Google Cloud DNS documentation</a>
   */
  public static class Quota {

    private Integer zones;
    private Integer resourceRecordsPerRrset;
    private Integer rrsetAdditionsPerChange;
    private Integer rrsetDeletionsPerChange;
    private Integer rrsetsPerManagedZone;
    private Integer totalRrdataSizePerChange;

    /**
     * Creates an instance of {@code Quota}.
     *
     * This is the only way of creating an instance of {@code Quota}. As the service does not allow
     * for specifying options, quota is an "all-or-nothing object" and we do not need a builder.
     */
    Quota(Integer zones,
          Integer resourceRecordsPerRrset,
          Integer rrsetAdditionsPerChange,
          Integer rrsetDeletionsPerChange,
          Integer rrsetsPerManagedZone,
          Integer totalRrdataSizePerChange) {
      this.zones = checkNotNull(zones);
      this.resourceRecordsPerRrset = checkNotNull(resourceRecordsPerRrset);
      this.rrsetAdditionsPerChange = checkNotNull(rrsetAdditionsPerChange);
      this.rrsetDeletionsPerChange = checkNotNull(rrsetDeletionsPerChange);
      this.rrsetsPerManagedZone = checkNotNull(rrsetsPerManagedZone);
      this.totalRrdataSizePerChange = checkNotNull(totalRrdataSizePerChange);
    }

    /**
     * Returns the maximum allowed number of managed zones in the project.
     */
    public Integer zones() {
      return zones;
    }

    /**
     * Returns the maximum allowed number of records per {@link DnsRecord}.
     */
    public Integer resourceRecordsPerRrset() {
      return resourceRecordsPerRrset;
    }

    /**
     * Returns the maximum allowed number of {@link DnsRecord}s to add per {@code ChangesRequest}.
     */
    public Integer rrsetAdditionsPerChange() {
      return rrsetAdditionsPerChange;
    }

    /**
     * Returns the maximum allowed number of {@link DnsRecord}s to delete per {@code
     * ChangesRequest}.
     */
    public Integer rrsetDeletionsPerChange() {
      return rrsetDeletionsPerChange;
    }

    /**
     * Returns the maximum allowed number of {@link DnsRecord}s per {@link ManagedZone} in the
     * project.
     */
    public Integer rrsetsPerManagedZone() {
      return rrsetsPerManagedZone;
    }

    /**
     * Returns the maximum allowed size for total records in one ChangesRequest in bytes.
     */
    public Integer totalRrdataSizePerChange() {
      return totalRrdataSizePerChange;
    }

    @Override
    public boolean equals(Object o) {
      return (o instanceof Quota) && this.toPb().equals(((Quota) o).toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(zones, resourceRecordsPerRrset, rrsetAdditionsPerChange,
          rrsetDeletionsPerChange, rrsetsPerManagedZone, totalRrdataSizePerChange);
    }

    com.google.api.services.dns.model.Quota toPb() {
      com.google.api.services.dns.model.Quota pb = new com.google.api.services.dns.model.Quota();
      pb.setManagedZones(zones);
      pb.setResourceRecordsPerRrset(resourceRecordsPerRrset);
      pb.setRrsetAdditionsPerChange(rrsetAdditionsPerChange);
      pb.setRrsetDeletionsPerChange(rrsetDeletionsPerChange);
      pb.setRrsetsPerManagedZone(rrsetsPerManagedZone);
      pb.setTotalRrdataSizePerChange(totalRrdataSizePerChange);
      return pb;
    }

    static Quota fromPb(com.google.api.services.dns.model.Quota pb) {
      Quota q = new Quota(pb.getManagedZones(),
          pb.getResourceRecordsPerRrset(),
          pb.getRrsetAdditionsPerChange(),
          pb.getRrsetDeletionsPerChange(),
          pb.getRrsetsPerManagedZone(),
          pb.getTotalRrdataSizePerChange()
      );
      return q;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("zones", zones)
          .add("resourceRecordsPerRrset", resourceRecordsPerRrset)
          .add("rrsetAdditionsPerChange", rrsetAdditionsPerChange)
          .add("rrsetDeletionsPerChange", rrsetDeletionsPerChange)
          .add("rrsetsPerManagedZone", rrsetsPerManagedZone)
          .add("totalRrdataSizePerChange", totalRrdataSizePerChange)
          .toString();
    }
  }

  /**
   * A builder for {@code ProjectInfo}.
   */
  static class Builder {
    private String id;
    private BigInteger number;
    private Quota quota;

    private Builder() {
    }

    /**
     * Sets an id of the project.
     */
    Builder id(String id) {
      this.id = checkNotNull(id);
      return this;
    }

    /**
     * Sets a number of the project.
     */
    Builder number(BigInteger number) {
      this.number = checkNotNull(number);
      return this;
    }

    /**
     * Sets quotas assigned to the project.
     */
    Builder quota(Quota quota) {
      this.quota = checkNotNull(quota);
      return this;
    }

    /**
     * Builds an instance of the {@code ProjectInfo}.
     */
    ProjectInfo build() {
      return new ProjectInfo(this);
    }
  }

  private ProjectInfo(Builder b) {
    this.id = b.id;
    this.number = b.number;
    this.quota = b.quota;
  }

  /**
   * Returns a builder for {@code ProjectInfo}.
   */
  static Builder builder() {
    return new Builder();
  }

  /**
   * Returns the user-assigned unique identifier for the project.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the unique numeric identifier for the project.
   */
  public BigInteger number() {
    return number;
  }

  /**
   * Returns the {@code Quota} object which contains quotas assigned to this project.
   */
  public Quota quota() {
    return quota;
  }

  com.google.api.services.dns.model.Project toPb() {
    com.google.api.services.dns.model.Project pb = new com.google.api.services.dns.model.Project();
    pb.setId(id());
    pb.setNumber(number());
    if (this.quota() != null) {
      pb.setQuota(quota().toPb());
    }
    return pb;
  }

  static ProjectInfo fromPb(com.google.api.services.dns.model.Project pb) {
    Builder b = builder();
    if (pb.getId() != null) {
      b.id(pb.getId());
    }
    if (pb.getNumber() != null) {
      b.number(pb.getNumber());
    }
    if (pb.getQuota() != null) {
      b.quota(Quota.fromPb(pb.getQuota()));
    }
    return b.build();
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof ProjectInfo) && this.toPb().equals(((ProjectInfo) o).toPb());
  }

  @Override
  public int hashCode() {
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
