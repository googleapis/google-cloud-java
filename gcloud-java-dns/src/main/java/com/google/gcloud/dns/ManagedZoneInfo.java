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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class is a container for the managed zone metainformation. Managed zone is a resource that
 * represents a DNS zone hosted by the Cloud DNS service. See <a href="https://cloud.google.com/dns/api/v1/managedZones">Google
 * Cloud DNS documentation</a> for more information.
 */
public class ManagedZoneInfo implements Serializable {

  private static final long serialVersionUID = 201601191647L;
  private final String name;
  private final Long id;
  private final Long creationTimeMillis;
  private final String dnsName;
  private final String description;
  private final String nameServerSet;
  private final List<String> nameServers;

  /**
   * A builder for {@code ManagedZoneInfo}.
   */
  public static class Builder {
    private String name;
    private Long id;
    private Long creationTimeMillis;
    private String dnsName;
    private String description;
    private String nameServerSet;
    private List<String> nameServers = new LinkedList<>();

    private Builder() {
    }

    private Builder(Long id) {
      this.id = checkNotNull(id);
    }

    private Builder(String name) {
      this.name = checkNotNull(name);
    }

    private Builder(String name, Long id) {
      this.name = checkNotNull(name);
      this.id = checkNotNull(id);
    }

    /**
     * Creates a builder from an existing ManagedZoneInfo object.
     */
    Builder(ManagedZoneInfo info) {
      this.name = info.name;
      this.id = info.id;
      this.creationTimeMillis = info.creationTimeMillis;
      this.dnsName = info.dnsName;
      this.description = info.description;
      this.nameServerSet = info.nameServerSet;
      this.nameServers.addAll(info.nameServers);
    }

    /**
     * Sets a mandatory user-provided name for the zone. It must be unique within the project.
     */
    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /**
     * Sets an id for the managed zone which is assigned to the managed zone by the server.
     */
    public Builder id(long id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the time when this managed zone was created.
     */
    Builder creationTimeMillis(long creationTimeMillis) {
      checkArgument(creationTimeMillis >= 0, "The timestamp cannot be negative.");
      this.creationTimeMillis = creationTimeMillis;
      return this;
    }

    /**
     * Sets a mandatory DNS name of this managed zone, for instance "example.com.".
     */
    public Builder dnsName(String dnsName) {
      this.dnsName = checkNotNull(dnsName);
      return this;
    }

    /**
     * Sets a mandatory description for this managed zone. The value is a string of at most 1024
     * characters (this limit is posed by Google Cloud DNS; gcloud-java does not enforce the limit)
     * which has no effect on the managed zone's function.
     */
    public Builder description(String description) {
      this.description = checkNotNull(description);
      return this;
    }

    /**
     * Optionally specifies the NameServerSet for this managed zone. A NameServerSet is a set of DNS
     * name servers that all host the same ManagedZones.
     */
    public Builder nameServerSet(String nameServerSet) {
      // todo(mderka) add more to the doc when questions are answered by the service owner
      this.nameServerSet = checkNotNull(nameServerSet);
      return this;
    }

    /**
     * Sets a list of servers that hold the information about the managed zone. This information is
     * provided by Google Cloud DNS and is read only.
     */
    Builder nameServers(List<String> nameServers) {
      this.nameServers.addAll(checkNotNull(nameServers));
      return this;
    }

    /**
     * Removes all the nameservers from the list.
     */
    Builder clearNameServers() {
      this.nameServers.clear();
      return this;
    }

    /**
     * Builds the instance of ManagedZoneInfo based on the information set here.
     */
    public ManagedZoneInfo build() {
      return new ManagedZoneInfo(this);
    }
  }

  private ManagedZoneInfo(Builder builder) {
    this.name = builder.name;
    this.id = builder.id;
    this.creationTimeMillis = builder.creationTimeMillis;
    this.dnsName = builder.dnsName;
    this.description = builder.description;
    this.nameServerSet = builder.nameServerSet;
    this.nameServers = ImmutableList.copyOf(builder.nameServers);
  }

  /**
   * Returns a builder for {@code ManagedZoneInfo} with an assigned {@code name}.
   */
  public static Builder builder(String name) {
    return new Builder(name);
  }

  /**
   * Returns a builder for {@code ManagedZoneInfo} with an assigned {@code id}.
   */
  public static Builder builder(Long id) {
    return new Builder(id);
  }

  /**
   * Returns a builder for {@code ManagedZoneInfo} with an assigned {@code name} and {@code id}.
   */
  public static Builder builder(String name, Long id) {
    return new Builder(name, id);
  }

  /**
   * Returns an empty builder for {@code ManagedZoneInfo}. We use it internally in {@code toPb()}.
   */
  private static Builder builder() {
    return new Builder();
  }

  /**
   * Returns the user-defined name of the managed zone.
   */
  public String name() {
    return name;
  }

  /**
   * Returns the read-only managed zone id assigned by the server.
   */
  public Long id() {
    return id;
  }

  /**
   * Returns the time when this time that this managed zone was created on the server.
   */
  public Long creationTimeMillis() {
    return creationTimeMillis;
  }

  /**
   * Returns the DNS name of this managed zone, for instance "example.com.".
   */
  public String dnsName() {
    return dnsName;
  }

  /**
   * Returns the description of this managed zone. This is at most 1024 long mandatory string
   * provided by the user.
   */
  public String description() {
    return description;
  }

  /**
   * Returns the optionally specified set of DNS name servers that all host this managed zone.
   */
  public String nameServerSet() {
    // todo(mderka) update this doc after finding out more about this from the service owners
    return nameServerSet;
  }

  /**
   * The nameservers that the managed zone should be delegated to. This is defined by the Google DNS
   * cloud.
   */
  public List<String> nameServers() {
    return nameServers;
  }

  /**
   * Returns a builder for {@code ManagedZoneInfo} prepopulated with the metadata of this managed
   * zone.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  com.google.api.services.dns.model.ManagedZone toPb() {
    com.google.api.services.dns.model.ManagedZone pb =
        new com.google.api.services.dns.model.ManagedZone();
    pb.setDescription(this.description());
    pb.setDnsName(this.dnsName());
    if (this.id() != null) {
      pb.setId(BigInteger.valueOf(this.id()));
    }
    pb.setName(this.name());
    pb.setNameServers(this.nameServers());
    pb.setNameServerSet(this.nameServerSet());
    if (this.creationTimeMillis() != null) {
      pb.setCreationTime(ISODateTimeFormat.dateTime()
          .withZoneUTC()
          .print(this.creationTimeMillis()));
    }
    return pb;
  }

  static ManagedZoneInfo fromPb(com.google.api.services.dns.model.ManagedZone pb) {
    Builder b = builder();
    if (pb.getDescription() != null) {
      b.description(pb.getDescription());
    }
    if (pb.getDnsName() != null) {
      b.dnsName(pb.getDnsName());
    }
    if (pb.getId() != null) {
      b.id(pb.getId().longValue());
    }
    if (pb.getName() != null) {
      b.name(pb.getName());
    }
    if (pb.getNameServers() != null) {
      b.nameServers(pb.getNameServers());
    }
    if (pb.getNameServerSet() != null) {
      b.nameServerSet(pb.getNameServerSet());
    }
    if (pb.getCreationTime() != null) {
      b.creationTimeMillis(DateTime.parse(pb.getCreationTime()).getMillis());
    }
    return b.build();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ManagedZoneInfo && Objects.equals(toPb(), ((ManagedZoneInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, creationTimeMillis, dnsName,
        description, nameServerSet, nameServers);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name())
        .add("id", id())
        .add("description", description())
        .add("dnsName", dnsName())
        .add("nameServerSet", nameServerSet())
        .add("nameServers", nameServers())
        .toString();
  }
}
