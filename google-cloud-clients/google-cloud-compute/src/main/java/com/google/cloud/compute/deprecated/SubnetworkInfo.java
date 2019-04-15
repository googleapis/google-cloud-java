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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.compute.model.Subnetwork;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A Google Compute Engine subnetwork. Compute Engine subnetworks allow you to segment your Compute
 * Engine network IP space into subnetworks. Subnetworks for a Compute Engine network can be
 * automatically allocated, or you can create a custom topology.
 *
 * @see <a href="https://cloud.google.com/compute/docs/subnetworks">Subnetworks</a>
 */
public class SubnetworkInfo implements Serializable {

  static final Function<Subnetwork, SubnetworkInfo> FROM_PB_FUNCTION =
      new Function<Subnetwork, SubnetworkInfo>() {
        @Override
        public SubnetworkInfo apply(Subnetwork pb) {
          return SubnetworkInfo.fromPb(pb);
        }
      };
  static final Function<SubnetworkInfo, Subnetwork> TO_PB_FUNCTION =
      new Function<SubnetworkInfo, Subnetwork>() {
        @Override
        public Subnetwork apply(SubnetworkInfo subnetwork) {
          return subnetwork.toPb();
        }
      };

  private static final long serialVersionUID = 7491176262675441579L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);

  private final String generatedId;
  private final SubnetworkId subnetworkId;
  private final Long creationTimestamp;
  private final String description;
  private final String gatewayAddress;
  private final NetworkId network;
  private final String ipRange;

  /** A builder for {@code SubnetworkInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setCreationTimestamp(Long creationTimestamp);

    /** Sets the identity of the subnework. */
    public abstract Builder setSubnetworkId(SubnetworkId subnetworkId);

    /** Sets an optional textual description of the subnetwork. */
    public abstract Builder setDescription(String description);

    abstract Builder setGatewayAddress(String gatewayAddress);

    /**
     * Sets the identity of the network to which this subnetwork belongs. Only networks that are in
     * subnet mode can have subnetworks.
     */
    public abstract Builder setNetwork(NetworkId network);

    /**
     * Sets the range of internal IPv4 addresses that are owned by this subnetwork. This range must
     * be a CIDR specification, for example: {@code 192.168.0.0/16}. Ranges must be unique and
     * non-overlapping within a network.
     *
     * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
     */
    public abstract Builder setIpRange(String ipRange);

    /** Creates a {@code SubnetworkInfo} object. */
    public abstract SubnetworkInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private SubnetworkId subnetworkId;
    private Long creationTimestamp;
    private String description;
    private String gatewayAddress;
    private NetworkId network;
    private String ipRange;

    BuilderImpl(SubnetworkId subnetworkId, NetworkId network, String ipRange) {
      this.subnetworkId = checkNotNull(subnetworkId);
      this.network = checkNotNull(network);
      this.ipRange = checkNotNull(ipRange);
    }

    BuilderImpl(SubnetworkInfo subnetworkInfo) {
      this.generatedId = subnetworkInfo.generatedId;
      this.creationTimestamp = subnetworkInfo.creationTimestamp;
      this.subnetworkId = subnetworkInfo.subnetworkId;
      this.description = subnetworkInfo.description;
      this.gatewayAddress = subnetworkInfo.gatewayAddress;
      this.network = subnetworkInfo.network;
      this.ipRange = subnetworkInfo.ipRange;
    }

    BuilderImpl(Subnetwork subnetworkPb) {
      if (subnetworkPb.getId() != null) {
        this.generatedId = subnetworkPb.getId().toString();
      }
      if (subnetworkPb.getCreationTimestamp() != null) {
        this.creationTimestamp =
            TIMESTAMP_FORMATTER
                .parse(subnetworkPb.getCreationTimestamp(), Instant.FROM)
                .toEpochMilli();
      }
      this.subnetworkId = SubnetworkId.fromUrl(subnetworkPb.getSelfLink());
      this.description = subnetworkPb.getDescription();
      this.gatewayAddress = subnetworkPb.getGatewayAddress();
      if (subnetworkPb.getNetwork() != null) {
        this.network = NetworkId.fromUrl(subnetworkPb.getNetwork());
      }
      this.ipRange = subnetworkPb.getIpCidrRange();
    }

    @Override
    BuilderImpl setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    BuilderImpl setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    public BuilderImpl setSubnetworkId(SubnetworkId subnetworkId) {
      this.subnetworkId = checkNotNull(subnetworkId);
      return this;
    }

    @Override
    public BuilderImpl setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    BuilderImpl setGatewayAddress(String gatewayAddress) {
      this.gatewayAddress = gatewayAddress;
      return this;
    }

    @Override
    public BuilderImpl setNetwork(NetworkId network) {
      this.network = checkNotNull(network);
      return this;
    }

    @Override
    public BuilderImpl setIpRange(String ipRange) {
      this.ipRange = checkNotNull(ipRange);
      return this;
    }

    @Override
    public SubnetworkInfo build() {
      return new SubnetworkInfo(this);
    }
  }

  SubnetworkInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.subnetworkId = checkNotNull(builder.subnetworkId);
    this.description = builder.description;
    this.gatewayAddress = builder.gatewayAddress;
    this.network = builder.network;
    this.ipRange = builder.ipRange;
  }

  /** Returns the service-generated unique identifier for the subnetwork. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns the subnetwork identity. */
  public SubnetworkId getSubnetworkId() {
    return subnetworkId;
  }

  /** Returns a textual description of the subnetwork. */
  public String getDescription() {
    return description;
  }

  /** Returns the gateway IPv4 address for this subnetwork, selected by the service. */
  public String getGatewayAddress() {
    return gatewayAddress;
  }

  /**
   * Returns the identity of the network to which this subnetwork belongs. Only networks that are in
   * subnet mode can have subnetworks.
   */
  public NetworkId getNetwork() {
    return network;
  }

  /**
   * Returns the range of internal IPv4 addresses that are owned by this subnetwork. This range is a
   * CIDR specification, for example: {@code 192.168.0.0/16}. Ranges must be unique and
   * non-overlapping within a network.
   *
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public String getIpRange() {
    return ipRange;
  }

  /** Returns a builder for the current subnetwork. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("subnetworkId", subnetworkId)
        .add("description", description)
        .add("gatewayAddress", gatewayAddress)
        .add("network", network)
        .add("ipRange", ipRange)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        generatedId,
        creationTimestamp,
        subnetworkId,
        description,
        gatewayAddress,
        network,
        ipRange);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(SubnetworkInfo.class)
            && Objects.equals(toPb(), ((SubnetworkInfo) obj).toPb());
  }

  SubnetworkInfo setProjectId(String projectId) {
    return toBuilder()
        .setSubnetworkId(subnetworkId.setProjectId(projectId))
        .setNetwork(network.setProjectId(projectId))
        .build();
  }

  Subnetwork toPb() {
    Subnetwork subnetworkPb = new Subnetwork();
    if (generatedId != null) {
      subnetworkPb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      subnetworkPb.setCreationTimestamp(
          TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(creationTimestamp)));
    }
    subnetworkPb.setName(subnetworkId.getSubnetwork());
    subnetworkPb.setDescription(description);
    subnetworkPb.setSelfLink(subnetworkId.getSelfLink());
    subnetworkPb.setGatewayAddress(gatewayAddress);
    subnetworkPb.setNetwork(network.getSelfLink());
    subnetworkPb.setIpCidrRange(ipRange);
    return subnetworkPb;
  }

  /**
   * Returns a builder for a {@code SubnetworkInfo} object given the identity of the subnetwork, the
   * identity of the network this subnetwork belongs to and the range of IPv4 addresses owned by
   * this subnetwork. {@code ipRange} must be a CIDR specification, for example: {@code
   * 192.168.0.0/16}.
   *
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public static Builder newBuilder(SubnetworkId subnetworkId, NetworkId network, String ipRange) {
    return new BuilderImpl(subnetworkId, network, ipRange);
  }

  /**
   * Returns a {@code SubnetworkInfo} object given the identity of the subnetwork, the identity of
   * the network this subnetwork belongs to and the range of IPv4 addresses owned by this
   * subnetwork. {@code ipRange} must be a CIDR specification, for example: {@code 192.168.0.0/16}.
   *
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public static SubnetworkInfo of(SubnetworkId subnetworkId, NetworkId network, String ipRange) {
    return newBuilder(subnetworkId, network, ipRange).build();
  }

  static SubnetworkInfo fromPb(Subnetwork subnetworkPb) {
    return new BuilderImpl(subnetworkPb).build();
  }
}
