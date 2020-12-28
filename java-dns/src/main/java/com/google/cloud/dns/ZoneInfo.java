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
import static com.google.common.collect.Lists.transform;

import com.google.api.services.dns.model.DnsKeySpec;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZoneDnsSecConfig;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
  private final DnsSecConfig dnsSecConfig;

  /** This class represents the DNS key spec. */
  public static class KeySpec {

    private String algorithm;
    private Long keyLength;
    private String keyType;

    public static class Builder {
      private String algorithm;
      private Long keyLength;
      private String keyType;

      private Builder() {}

      private Builder(KeySpec keySpec) {
        this.algorithm = keySpec.algorithm;
        this.keyLength = keySpec.keyLength;
        this.keyType = keySpec.getKeyType();
      }

      /** Specifies the DNSSEC algorithm of this key. */
      public Builder setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
      }

      /** Specifies the length of the keys in bits. */
      public Builder setKeyLength(Long keyLength) {
        this.keyLength = keyLength;
        return this;
      }

      /**
       * Specifies the key type, Whether this key is a signing key (KSK) or a zone signing key
       * (ZSK).
       */
      public Builder setKeyType(String keyType) {
        this.keyType = keyType;
        return this;
      }

      /** Creates a {@code KeySpec} object. */
      public KeySpec build() {
        return new KeySpec(this);
      }
    }

    /** Returns a builder for {@code KeySpec} objects. */
    public static Builder newBuilder() {
      return new Builder();
    }

    private KeySpec(Builder builder) {
      algorithm = builder.algorithm;
      keyLength = builder.keyLength;
      keyType = builder.keyType;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      KeySpec keySpec = (KeySpec) o;
      return Objects.equals(algorithm, keySpec.algorithm)
          && Objects.equals(keyLength, keySpec.keyLength)
          && Objects.equals(keyType, keySpec.keyType);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("algorithm", getAlgorithm())
          .add("keyLength", getKeyLength())
          .add("keyType", getKeyType())
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(algorithm, keyLength, keyType);
    }

    DnsKeySpec toPb() {
      DnsKeySpec dnsKeySpecPb = new DnsKeySpec();
      dnsKeySpecPb.setAlgorithm(algorithm);
      dnsKeySpecPb.setKeyLength(keyLength);
      dnsKeySpecPb.setKeyType(keyType);
      return dnsKeySpecPb;
    }

    static KeySpec fromPb(DnsKeySpec dnsKeySpec) {
      Builder builder = newBuilder();
      builder.setAlgorithm(dnsKeySpec.getAlgorithm() == null ? null : dnsKeySpec.getAlgorithm());
      builder.setKeyLength(dnsKeySpec.getKeyLength() == null ? null : dnsKeySpec.getKeyLength());
      builder.setKeyType(dnsKeySpec.getKeyType() == null ? null : dnsKeySpec.getKeyType());
      return builder.build();
    }

    /** Returns the DNSSEC algorithm of this key. */
    public String getAlgorithm() {
      return algorithm;
    }

    /** Returns the key length. */
    public Long getKeyLength() {
      return keyLength;
    }

    /** Returns the key type. */
    public String getKeyType() {
      return keyType;
    }
  }

  /** This class represents the DNSSEC configuration. */
  public static class DnsSecConfig {

    private static final Set<String> VALID_STATE_VALUES = ImmutableSet.of("on", "off", "transfer");
    private static final Set<String> VALID_NONEXISTANCE_VALUES = ImmutableSet.of("nsec", "nsec3");

    private List<KeySpec> defaultKeySpecs;
    private String nonExistence;
    private String state;

    public static class Builder {
      private List<KeySpec> defaultKeySpecs;
      private String nonExistence;
      private String state;

      private Builder() {}

      private Builder(DnsSecConfig dnsSecConfig) {
        this.defaultKeySpecs = dnsSecConfig.defaultKeySpecs;
        this.nonExistence = dnsSecConfig.nonExistence;
        this.state = dnsSecConfig.state;
      }

      /**
       * Specifies parameters for generating initial DnsKeys for this ManagedZone. This can be
       * change while state is OFF.
       */
      public Builder setDefaultKeySpecs(List<KeySpec> defaultKeySpecs) {
        this.defaultKeySpecs = defaultKeySpecs;
        return this;
      }

      /**
       * Specifies the mechanism for authenticated denial-of-existence responses. This can be change
       * while state is OFF. Acceptable values are 'nsec' or 'nsec3'.
       *
       * @throws IllegalArgumentException if nonExistence value is not acceptable
       */
      public Builder setNonExistence(String nonExistence) {
        validateValue(nonExistence, VALID_NONEXISTANCE_VALUES);
        this.nonExistence = nonExistence;
        return this;
      }

      /**
       * Specifies whether DNSSEC is enabled, and what mode it is in. Acceptable values are 'on',
       * 'off' or 'transfer'.
       *
       * @throws IllegalArgumentException if state value is not acceptable
       */
      public Builder setState(String state) {
        validateValue(state, VALID_STATE_VALUES);
        this.state = state;
        return this;
      }

      /** Creates a {@code DnsSecConfig} object. */
      public DnsSecConfig build() {
        return new DnsSecConfig(this);
      }
    }

    /** Returns a builder for the current blob. */
    public Builder toBuilder() {
      return new Builder(this);
    }

    /** Returns a builder for {@code DnsSecConfig} objects. */
    public static Builder newBuilder() {
      return new Builder();
    }

    private DnsSecConfig(Builder builder) {
      defaultKeySpecs = builder.defaultKeySpecs;
      nonExistence = builder.nonExistence;
      state = builder.state;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      DnsSecConfig that = (DnsSecConfig) o;
      return Objects.equals(defaultKeySpecs, that.defaultKeySpecs)
          && Objects.equals(nonExistence, that.nonExistence)
          && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
      return Objects.hash(defaultKeySpecs, nonExistence, state);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("defaultKeySpecs", getDefaultKeySpecs())
          .add("nonExistence", getNonExistence())
          .add("state", getState())
          .toString();
    }

    ManagedZoneDnsSecConfig toPb() {
      ManagedZoneDnsSecConfig dnsSecConfigPb = new ManagedZoneDnsSecConfig();
      if (defaultKeySpecs != null) {
        dnsSecConfigPb.setDefaultKeySpecs(
            transform(
                defaultKeySpecs,
                new Function<KeySpec, DnsKeySpec>() {
                  @Override
                  public DnsKeySpec apply(KeySpec keySpec) {
                    return keySpec.toPb();
                  }
                }));
      }
      dnsSecConfigPb.setNonExistence(nonExistence);
      dnsSecConfigPb.setState(state);
      return dnsSecConfigPb;
    }

    static DnsSecConfig fromPb(ManagedZoneDnsSecConfig managedZoneDnsSecConfig) {
      Builder builder = newBuilder();
      if (managedZoneDnsSecConfig.getDefaultKeySpecs() != null) {
        builder.setDefaultKeySpecs(
            transform(
                managedZoneDnsSecConfig.getDefaultKeySpecs(),
                new Function<DnsKeySpec, KeySpec>() {
                  @Override
                  public KeySpec apply(DnsKeySpec dnsKeySpec) {
                    return KeySpec.fromPb(dnsKeySpec);
                  }
                }));
      }
      builder.setNonExistence(managedZoneDnsSecConfig.getNonExistence());
      builder.setState(managedZoneDnsSecConfig.getState());
      return builder.build();
    }

    /** Returns the DefaultKeySpecs. */
    public List<KeySpec> getDefaultKeySpecs() {
      return defaultKeySpecs;
    }

    /** Returns the authenticated denial-of-existence responses. */
    public String getNonExistence() {
      return nonExistence;
    }

    /** Returns the DNSSEC state. */
    public String getState() {
      return state;
    }

    private static void validateValue(String value, Set<String> validValues) {
      if (!validValues.contains(value)) {
        throw new IllegalArgumentException(
            "Invalid value, Use one of the value from acceptable values " + validValues);
      }
    }
  }

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

    /** Sets the DNSSEC configuration. */
    public Builder setDnsSecConfig(DnsSecConfig dnsSecConfig) {
      return this;
    }

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
    private DnsSecConfig dnsSecConfig;

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
      this.dnsSecConfig = info.dnsSecConfig;
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
    public Builder setDnsSecConfig(DnsSecConfig dnsSecConfig) {
      this.dnsSecConfig = checkNotNull(dnsSecConfig);
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
    this.dnsSecConfig = builder.dnsSecConfig;
  }

  /**
   * Returns a ZoneInfo object with assigned {@code name}, {@code dnsName} and {@code description}.
   */
  public static ZoneInfo of(String name, String dnsName, String description) {
    return new BuilderImpl(name).setDnsName(dnsName).setDescription(description).build();
  }

  /** Returns a {@code ZoneInfo} builder where the DNS name is set to the provided name. */
  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
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

  public DnsSecConfig getDnsSecConfig() {
    return dnsSecConfig;
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
    if (this.dnsSecConfig != null) {
      pb.setDnssecConfig(this.dnsSecConfig.toPb());
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
    if (pb.getDnssecConfig() != null) {
      builder.setDnsSecConfig(DnsSecConfig.fromPb(pb.getDnssecConfig()));
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
        name,
        generatedId,
        creationTimeMillis,
        dnsName,
        description,
        nameServerSet,
        nameServers,
        dnsSecConfig);
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
        .add("dnsSecConfig", getDnsSecConfig())
        .toString();
  }
}
