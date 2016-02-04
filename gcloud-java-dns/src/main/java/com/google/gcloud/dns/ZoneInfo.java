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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A {@code Zone} represents a DNS zone hosted by the Google Cloud DNS service. A zone is a subtree
 * of the DNS namespace under one administrative responsibility. See <a
 * href="https://cloud.google.com/dns/api/v1/managedZones">Google Cloud DNS documentation</a> for
 * more information.
 */
public class ZoneInfo implements Serializable {

  private static final long serialVersionUID = 201601191647L;
  private final String name;
  private final String id;
  private final Long creationTimeMillis;
  private final String dnsName;
  private final String description;
  private final String nameServerSet;
  private final List<String> nameServers;

  /**
   * A builder for {@code ZoneInfo}.
   */
  public static class Builder {
    private String name;
    private String id;
    private Long creationTimeMillis;
    private String dnsName;
    private String description;
    private String nameServerSet;
    private List<String> nameServers = new LinkedList<>();

    /**
     * Returns an empty builder for {@code ZoneInfo}. We use it internally in {@code toPb()}.
     */
    private Builder() {
    }

    private Builder(String name) {
      this.name = checkNotNull(name);
    }

    /**
     * Creates a builder from an existing ZoneInfo object.
     */
    Builder(ZoneInfo info) {
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
     * Sets an id for the zone which is assigned to the zone by the server.
     */
    Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the time when this zone was created.
     */
    Builder creationTimeMillis(long creationTimeMillis) {
      this.creationTimeMillis = creationTimeMillis;
      return this;
    }

    /**
     * Sets a mandatory DNS name of this zone, for instance "example.com.".
     */
    public Builder dnsName(String dnsName) {
      this.dnsName = checkNotNull(dnsName);
      return this;
    }

    /**
     * Sets a mandatory description for this zone. The value is a string of at most 1024 characters
     * which has no effect on the zone's function.
     */
    public Builder description(String description) {
      this.description = checkNotNull(description);
      return this;
    }

    /**
     * Optionally specifies the NameServerSet for this zone. A NameServerSet is a set of DNS name
     * servers that all host the same zones. Most users will not need to specify this value.
     */
    public Builder nameServerSet(String nameServerSet) {
      // todo(mderka) add more to the doc when questions are answered by the service owner
      this.nameServerSet = checkNotNull(nameServerSet);
      return this;
    }

    /**
     * Sets a list of servers that hold the information about the zone. This information is provided
     * by Google Cloud DNS and is read only.
     */
    Builder nameServers(List<String> nameServers) {
      checkNotNull(nameServers);
      this.nameServers = Lists.newLinkedList(nameServers);
      return this;
    }

    /**
     * Builds the instance of {@code ZoneInfo} based on the information set by this builder.
     */
    public ZoneInfo build() {
      return new ZoneInfo(this);
    }
  }

  private ZoneInfo(Builder builder) {
    this.name = builder.name;
    this.id = builder.id;
    this.creationTimeMillis = builder.creationTimeMillis;
    this.dnsName = builder.dnsName;
    this.description = builder.description;
    this.nameServerSet = builder.nameServerSet;
    this.nameServers = ImmutableList.copyOf(builder.nameServers);
  }

  /**
   * Returns a builder for {@code ZoneInfo} with an assigned {@code name}.
   */
  public static Builder builder(String name) {
    return new Builder(name);
  }

  /**
   * Returns the user-defined name of the zone.
   */
  public String name() {
    return name;
  }

  /**
   * Returns the read-only zone id assigned by the server.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the time when this zone was created on the server.
   */
  public Long creationTimeMillis() {
    return creationTimeMillis;
  }

  /**
   * Returns the DNS name of this zone, for instance "example.com.".
   */
  public String dnsName() {
    return dnsName;
  }

  /**
   * Returns the description of this zone.
   */
  public String description() {
    return description;
  }

  /**
   * Returns the optionally specified set of DNS name servers that all host this zone.
   */
  public String nameServerSet() {
    // todo(mderka) update this doc after finding out more about this from the service owners
    return nameServerSet;
  }

  /**
   * The nameservers that the zone should be delegated to. This is defined by the Google DNS cloud.
   */
  public List<String> nameServers() {
    return nameServers;
  }

  /**
   * Returns a builder for {@code ZoneInfo} prepopulated with the metadata of this zone.
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
      pb.setId(new BigInteger(this.id()));
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

  static ZoneInfo fromPb(com.google.api.services.dns.model.ManagedZone pb) {
    Builder builder = new Builder();
    if (pb.getDescription() != null) {
      builder.description(pb.getDescription());
    }
    if (pb.getDnsName() != null) {
      builder.dnsName(pb.getDnsName());
    }
    if (pb.getId() != null) {
      builder.id(pb.getId().toString());
    }
    if (pb.getName() != null) {
      builder.name(pb.getName());
    }
    if (pb.getNameServers() != null) {
      builder.nameServers(pb.getNameServers());
    }
    if (pb.getNameServerSet() != null) {
      builder.nameServerSet(pb.getNameServerSet());
    }
    if (pb.getCreationTime() != null) {
      builder.creationTimeMillis(DateTime.parse(pb.getCreationTime()).getMillis());
    }
    return builder.build();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ZoneInfo && Objects.equals(toPb(), ((ZoneInfo) obj).toPb());
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
        .add("creationTimeMillis", creationTimeMillis())
        .toString();
  }
}
