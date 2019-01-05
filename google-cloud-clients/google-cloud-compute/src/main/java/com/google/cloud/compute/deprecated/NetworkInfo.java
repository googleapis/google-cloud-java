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

import com.google.api.services.compute.model.Network;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * A Google Compute Engine Network. Every virtual machine instance is created as a member of a
 * network. Networks connect instances to each other and to the Internet. You can segment your
 * networks, use firewall rules to restrict access to instances, and create static routes to forward
 * traffic to specific destinations.
 *
 * <p>A network lives in a project and is isolated from other networks in the project. A project can
 * have up to five different networks.
 *
 * @see <a href="https://cloud.google.com/compute/docs/networking">Using Networks and Firewalls</a>
 */
public class NetworkInfo implements Serializable {

  static final Function<Network, NetworkInfo> FROM_PB_FUNCTION =
      new Function<Network, NetworkInfo>() {
        @Override
        public NetworkInfo apply(Network pb) {
          return NetworkInfo.fromPb(pb);
        }
      };
  static final Function<NetworkInfo, Network> TO_PB_FUNCTION =
      new Function<NetworkInfo, Network>() {
        @Override
        public Network apply(NetworkInfo network) {
          return network.toPb();
        }
      };

  private static final long serialVersionUID = 4336912581538114026L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final String generatedId;
  private final NetworkId networkId;
  private final Long creationTimestamp;
  private final String description;
  private final NetworkConfiguration configuration;

  /** A builder for {@code NetworkInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setCreationTimestamp(Long creationTimestamp);

    /** Sets the identity of the network. */
    public abstract Builder setNetworkId(NetworkId networkId);

    /** Sets an optional textual description of the network. */
    public abstract Builder setDescription(String description);

    /**
     * Sets the network configuration. Use {@link StandardNetworkConfiguration} to create a standard
     * network with associated IPv4 range. Use {@link SubnetNetworkConfiguration} to create a
     * network that could be divided into subnetworks, up to one per region, each with its own
     * address range.
     */
    public abstract Builder setConfiguration(NetworkConfiguration configuration);

    /** Creates a {@code NetworkInfo} object. */
    public abstract NetworkInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private NetworkId networkId;
    private Long creationTimestamp;
    private String description;
    private NetworkConfiguration configuration;

    BuilderImpl(NetworkId networkId, NetworkConfiguration configuration) {
      this.networkId = checkNotNull(networkId);
      this.configuration = checkNotNull(configuration);
    }

    BuilderImpl(NetworkInfo networkInfo) {
      this.generatedId = networkInfo.generatedId;
      this.creationTimestamp = networkInfo.creationTimestamp;
      this.networkId = networkInfo.networkId;
      this.description = networkInfo.description;
      this.configuration = networkInfo.configuration;
    }

    BuilderImpl(Network networkPb) {
      if (networkPb.getId() != null) {
        this.generatedId = networkPb.getId().toString();
      }
      if (networkPb.getCreationTimestamp() != null) {
        this.creationTimestamp = TIMESTAMP_FORMATTER.parseMillis(networkPb.getCreationTimestamp());
      }
      this.networkId = NetworkId.fromUrl(networkPb.getSelfLink());
      this.description = networkPb.getDescription();
      this.configuration = NetworkConfiguration.fromPb(networkPb);
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
    public BuilderImpl setNetworkId(NetworkId networkId) {
      this.networkId = checkNotNull(networkId);
      return this;
    }

    @Override
    public BuilderImpl setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    public BuilderImpl setConfiguration(NetworkConfiguration configuration) {
      this.configuration = checkNotNull(configuration);
      return this;
    }

    @Override
    public NetworkInfo build() {
      return new NetworkInfo(this);
    }
  }

  NetworkInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.networkId = builder.networkId;
    this.description = builder.description;
    this.configuration = builder.configuration;
  }

  /** Returns the service-generated unique identifier for the network. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns the network identity. */
  public NetworkId getNetworkId() {
    return networkId;
  }

  /** Returns a textual description of the network. */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the network configuration. Returns a {@link StandardNetworkConfiguration} for standard
   * networks with associated IPv4 range. Returns {@link SubnetNetworkConfiguration} for networks
   * that could be divided into subnetworks, up to one per region, each with its own address range.
   */
  @SuppressWarnings("unchecked")
  public <T extends NetworkConfiguration> T getConfiguration() {
    return (T) configuration;
  }

  /** Returns a builder for the current network. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("networkId", networkId)
        .add("description", description)
        .add("configuration", configuration)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(generatedId, networkId, creationTimestamp, description, configuration);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(NetworkInfo.class)
            && Objects.equals(toPb(), ((NetworkInfo) obj).toPb());
  }

  NetworkInfo setProjectId(String projectId) {
    return toBuilder().setNetworkId(networkId.setProjectId(projectId)).build();
  }

  Network toPb() {
    Network networkPb = configuration.toPb();
    if (generatedId != null) {
      networkPb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      networkPb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    networkPb.setName(networkId.getNetwork());
    networkPb.setDescription(description);
    networkPb.setSelfLink(networkId.getSelfLink());
    return networkPb;
  }

  /**
   * Returns a builder for a {@code NetworkInfo} object given the network identity and its
   * configuration. Use {@link StandardNetworkConfiguration} to create a standard network with
   * associated address range. Use {@link SubnetNetworkConfiguration} to create a network that
   * supports subnetworks, up to one per region, each with its own address range.
   */
  public static Builder newBuilder(NetworkId networkId, NetworkConfiguration configuration) {
    return new BuilderImpl(networkId, configuration);
  }

  /**
   * Returns a {@code NetworkInfo} object given the network identity. Use {@link
   * StandardNetworkConfiguration} to create a standard network with associated address range. Use
   * {@link SubnetNetworkConfiguration} to create a network that supports subnetworks, up to one per
   * region, each with its own address range.
   */
  public static NetworkInfo of(NetworkId networkId, NetworkConfiguration configuration) {
    return newBuilder(networkId, configuration).build();
  }

  static NetworkInfo fromPb(Network networkPb) {
    return new BuilderImpl(networkPb).build();
  }
}
