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

import com.google.api.services.dns.model.ManagedZone;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A {@code Zone} represents a DNS zone hosted by the Google Cloud DNS service. A zone is a subtree
 * of the DNS namespace under one administrative responsibility. See <a
 * href="https://cloud.google.com/dns/api/v1/managedZones">Google Cloud DNS documentation</a> for
 * more information.
 */
public class ZoneInfo implements Serializable {

  private static final long serialVersionUID = -5313169712036079818L;
  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);

  private final String name;
  private final String generatedId;
  private final Long creationTimeMillis;
  private final String dnsName;
  private final String description;
  private final String nameServerSet;
  private final List<String> nameServers;

  /** Builder for {@code ZoneInfo}. */
  public abstract static class Builder {

    /** Sets a mandatory user-provided name for the zone. It must be unique within the project. */
    public abstract Builder setName(String name);

    /** Sets service-generated id for the zone. */
    abstract Builder setGeneratedId(String generatedId);

    /** Sets the time when this zone was created. */
    abstract Builder setCreationTimeMillis(long creationTimeMillis);

    /** Sets a mandatory DNS name of this zone, for instance "example.com.". */
    public abstract Builder setDnsName(String dnsName);

    /**
     * Sets a mandatory description for this zone. The value is a string of at most 1024 characters
     * which has no effect on the zone's function.
     */
    public abstract Builder setDescription(String description);

    /**
     * Optionally specifies the NameServerSet for this zone. A NameServerSet is a set of DNS name
     * servers that all host the same zones. Most users will not need to specify this value.
     */
    abstract Builder setNameServerSet(String nameServerSet);
    // this should not be included in tooling as per the service owners

    /**
     * Sets a list of servers that hold the information about the zone. This information is provided
     * by Google Cloud DNS and is read only.
     */
    abstract Builder setNameServers(List<String> nameServers);

    /** Builds the instance of {@code ZoneInfo} based on the information set by this builder. */
    public abstract ZoneInfo build();
  }

  static class BuilderImpl extends Builder {
    private String name;
    private String generatedId;
    private Long creationTimeMillis;
    private String dnsName;
    private String description;
    private String nameServerSet;
    private List<String> nameServers;

    private BuilderImpl(String name) {
      this.name = checkNotNull(name);
    }

    /** Creates a builder from an existing ZoneInfo object. */
    BuilderImpl(ZoneInfo info) {
      this.name = info.name;
      this.generatedId = info.generatedId;
      this.creationTimeMillis = info.creationTimeMillis;
      this.dnsName = info.dnsName;
      this.description = info.description;
      this.nameServerSet = info.nameServerSet;
      if (info.nameServers != null) {
        this.nameServers = ImmutableList.copyOf(info.nameServers);
      }
    }

    @Override
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder setCreationTimeMillis(long creationTimeMillis) {
      this.creationTimeMillis = creationTimeMillis;
      return this;
    }

    @Override
    public Builder setDnsName(String dnsName) {
      this.dnsName = checkNotNull(dnsName);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.description = checkNotNull(description);
      return this;
    }

    @Override
    Builder setNameServerSet(String nameServerSet) {
      this.nameServerSet = checkNotNull(nameServerSet);
      return this;
    }

    @Override
    Builder setNameServers(List<String> nameServers) {
      checkNotNull(nameServers);
      this.nameServers = Lists.newLinkedList(nameServers);
      return this;
    }

    @Override
    public ZoneInfo build() {
      return new ZoneInfo(this);
    }
  }

  ZoneInfo(BuilderImpl builder) {
    this.name = builder.name;
    this.generatedId = builder.generatedId;
    this.creationTimeMillis = builder.creationTimeMillis;
    this.dnsName = builder.dnsName;
    this.description = builder.description;
    this.nameServerSet = builder.nameServerSet;
    this.nameServers =
        builder.nameServers == null ? null : ImmutableList.copyOf(builder.nameServers);
  }

  /**
   * Returns a ZoneInfo object with assigned {@code name}, {@code dnsName} and {@code description}.
   */
  public static ZoneInfo of(String name, String dnsName, String description) {
    return new BuilderImpl(name).setDnsName(dnsName).setDescription(description).build();
  }

  /** Returns the user-defined name of the zone. */
  public String getName() {
    return name;
  }

  /** Returns the service-generated id for this zone. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the time when this zone was created on the server. */
  public Long getCreationTimeMillis() {
    return creationTimeMillis;
  }

  /** Returns the DNS name of this zone, for instance "example.com.". */
  public String getDnsName() {
    return dnsName;
  }

  /** Returns the description of this zone. */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the optionally specified set of DNS name servers that all host this zone. This value is
   * set only for specific use cases and is left empty for vast majority of users.
   */
  public String getNameServerSet() {
    return nameServerSet;
  }

  /**
   * The nameservers that the zone should be delegated to. This is defined by the Google DNS cloud.
   */
  public List<String> getNameServers() {
    return nameServers == null ? ImmutableList.<String>of() : nameServers;
  }

  /** Returns a builder for {@code ZoneInfo} prepopulated with the metadata of this zone. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  ManagedZone toPb() {
    ManagedZone pb = new ManagedZone();
    pb.setDescription(this.getDescription());
    pb.setDnsName(this.getDnsName());
    if (this.getGeneratedId() != null) {
      pb.setId(new BigInteger(this.getGeneratedId()));
    }
    pb.setName(this.getName());
    pb.setNameServers(this.nameServers); // do use real attribute value which may be null
    pb.setNameServerSet(this.getNameServerSet());
    if (this.getCreationTimeMillis() != null) {
      pb.setCreationTime(
          DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(this.getCreationTimeMillis())));
    }
    return pb;
  }

  static ZoneInfo fromPb(ManagedZone pb) {
    Builder builder = new BuilderImpl(pb.getName());
    if (pb.getDescription() != null) {
      builder.setDescription(pb.getDescription());
    }
    if (pb.getDnsName() != null) {
      builder.setDnsName(pb.getDnsName());
    }
    if (pb.getId() != null) {
      builder.setGeneratedId(pb.getId().toString());
    }
    if (pb.getNameServers() != null) {
      builder.setNameServers(pb.getNameServers());
    }
    if (pb.getNameServerSet() != null) {
      builder.setNameServerSet(pb.getNameServerSet());
    }
    if (pb.getCreationTime() != null) {
      builder.setCreationTimeMillis(
          DATE_TIME_FORMATTER.parse(pb.getCreationTime(), Instant.FROM).toEpochMilli());
    }
    return builder.build();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ZoneInfo.class)
            && Objects.equals(toPb(), ((ZoneInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name, generatedId, creationTimeMillis, dnsName, description, nameServerSet, nameServers);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", getName())
        .add("generatedId", getGeneratedId())
        .add("description", getDescription())
        .add("dnsName", getDnsName())
        .add("nameServerSet", getNameServerSet())
        .add("nameServers", getNameServers())
        .add("creationTimeMillis", getCreationTimeMillis())
        .toString();
  }
}
