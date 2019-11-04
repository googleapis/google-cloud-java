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

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A network interface for a Google Compute Engine instance. Network interfaces specify how the
 * instance is configured to interact with other network services, such as connecting to the
 * internet.
 *
 * @see <a href="https://cloud.google.com/compute/docs/instances-and-network">Configuring an
 *     Instance's IP Addresses</a>
 */
public class NetworkInterface implements Serializable {

  static final Function<com.google.api.services.compute.model.NetworkInterface, NetworkInterface>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.compute.model.NetworkInterface, NetworkInterface>() {
            @Override
            public NetworkInterface apply(
                com.google.api.services.compute.model.NetworkInterface pb) {
              return NetworkInterface.fromPb(pb);
            }
          };
  static final Function<NetworkInterface, com.google.api.services.compute.model.NetworkInterface>
      TO_PB_FUNCTION =
          new Function<NetworkInterface, com.google.api.services.compute.model.NetworkInterface>() {
            @Override
            public com.google.api.services.compute.model.NetworkInterface apply(
                NetworkInterface networkInterface) {
              return networkInterface.toPb();
            }
          };

  private static final long serialVersionUID = 936741262053605581L;

  private final String name;
  private final NetworkId network;
  private final String networkIp;
  private final SubnetworkId subnetwork;
  private final List<AccessConfig> accessConfigurations;

  /**
   * Access configuration for a Google Compute Engine instance's network interface. Objects of this
   * class can be used to assign either a static or an ephemeral external IP address to Google
   * Compute Engine instances.
   *
   * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">
   *     Static external IP addresses</a>
   * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#ephemeraladdress">
   *     Ephemeral external IP addresses</a>
   */
  public static final class AccessConfig implements Serializable {

    static final Function<com.google.api.services.compute.model.AccessConfig, AccessConfig>
        FROM_PB_FUNCTION =
            new Function<com.google.api.services.compute.model.AccessConfig, AccessConfig>() {
              @Override
              public AccessConfig apply(com.google.api.services.compute.model.AccessConfig pb) {
                return AccessConfig.fromPb(pb);
              }
            };
    static final Function<AccessConfig, com.google.api.services.compute.model.AccessConfig>
        TO_PB_FUNCTION =
            new Function<AccessConfig, com.google.api.services.compute.model.AccessConfig>() {
              @Override
              public com.google.api.services.compute.model.AccessConfig apply(
                  AccessConfig instance) {
                return instance.toPb();
              }
            };

    private static final long serialVersionUID = -5438060668934041567L;

    private final String name;
    private final String natIp;
    private final Type type;

    /**
     * The type of network access configuration. The only supported value is {@code ONE_TO_ONE_NAT}.
     */
    public static final class Type extends StringEnumValue {
      private static final long serialVersionUID = -1181560540824208967L;

      private static final ApiFunction<String, Type> CONSTRUCTOR =
          new ApiFunction<String, Type>() {
            @Override
            public Type apply(String constant) {
              return new Type(constant);
            }
          };

      private static final StringEnumType<Type> type = new StringEnumType(Type.class, CONSTRUCTOR);

      public static final Type ONE_TO_ONE_NAT = type.createAndRegister("ONE_TO_ONE_NAT");

      private Type(String constant) {
        super(constant);
      }

      /**
       * Get the Type for the given String constant, and throw an exception if the constant is not
       * recognized.
       */
      public static Type valueOfStrict(String constant) {
        return type.valueOfStrict(constant);
      }

      /** Get the Type for the given String constant, and allow unrecognized values. */
      public static Type valueOf(String constant) {
        return type.valueOf(constant);
      }

      /** Return the known values for Type. */
      public static Type[] values() {
        return type.values();
      }
    }

    public static final class Builder {

      private String name;
      private String natIp;
      private Type type;

      private Builder() {}

      private Builder(AccessConfig accessConfig) {
        this.name = accessConfig.name;
        this.natIp = accessConfig.natIp;
        this.type = accessConfig.type;
      }

      /** Sets the name of the access configuration. */
      public Builder setName(String name) {
        this.name = name;
        return this;
      }

      /**
       * Sets an external IP address associated with this instance. Specify an unused static
       * external IP address available to the project or leave this field undefined to use an IP
       * from a shared ephemeral IP address pool. If you specify a static external IP address, it
       * must live in the same region as the zone of the instance.
       *
       * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">
       *     Ephemeral external IP addresses</a>
       * @see <a
       *     href="https://cloud.google.com/compute/docs/instances-and-network#ephemeraladdress">
       *     Ephemeral external IP addresses</a>
       */
      public Builder setNatIp(String natIp) {
        this.natIp = natIp;
        return this;
      }

      /**
       * Sets the type of the access configuration. The only supported value is {@link
       * Type#ONE_TO_ONE_NAT}.
       */
      public Builder setType(Type type) {
        this.type = type;
        return this;
      }

      /** Creates an {@code AccessConfig} object. */
      public AccessConfig build() {
        return new AccessConfig(this);
      }
    }

    AccessConfig(Builder builder) {
      this.name = builder.name;
      this.natIp = builder.natIp;
      this.type = builder.type;
    }

    /** Returns the name of the access configuration. */
    public String getName() {
      return name;
    }

    /** Returns an external IP address associated with this instance. */
    public String getNatIp() {
      return natIp;
    }

    /**
     * Returns the type of network access configuration. The only supported value is {@link
     * Type#ONE_TO_ONE_NAT}.
     */
    public Type getType() {
      return type;
    }

    /** Returns a builder for the current access configuration. */
    public Builder toBuilder() {
      return new Builder(this);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("name", name)
          .add("natIp", natIp)
          .add("type", type)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, natIp, type);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj instanceof AccessConfig && Objects.equals(toPb(), ((AccessConfig) obj).toPb());
    }

    com.google.api.services.compute.model.AccessConfig toPb() {
      com.google.api.services.compute.model.AccessConfig accessConfigPb =
          new com.google.api.services.compute.model.AccessConfig();
      accessConfigPb.setName(name);
      accessConfigPb.setNatIP(natIp);
      if (type != null) {
        accessConfigPb.setType(type.name());
      }
      return accessConfigPb;
    }

    /** Returns a builder for an {@code AccessConfig} object. */
    public static Builder newBuilder() {
      return new Builder();
    }

    /**
     * Returns an {@code AccessConfig} object given the static external IP address.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">
     *     Static external IP addresses</a>
     */
    public static AccessConfig of(String natIp) {
      return newBuilder().setNatIp(natIp).build();
    }

    /**
     * Returns an {@code AccessConfig} object. IP address for this access configuration will be
     * taken from a pool of ephemeral addresses.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#ephemeraladdress">
     *     Ephemeral external IP addresses</a>
     */
    public static AccessConfig of() {
      return newBuilder().build();
    }

    static AccessConfig fromPb(com.google.api.services.compute.model.AccessConfig configPb) {
      Builder builder = newBuilder();
      builder.setName(configPb.getName());
      if (configPb.getNatIP() != null) {
        builder.setNatIp(configPb.getNatIP());
      }
      if (configPb.getType() != null) {
        builder.setType(Type.valueOf(configPb.getType()));
      }
      return builder.build();
    }
  }

  public static final class Builder {

    private String name;
    private NetworkId network;
    private String networkIp;
    private SubnetworkId subnetwork;
    private List<AccessConfig> accessConfigurations;

    private Builder(NetworkId network) {
      this.network = checkNotNull(network);
    }

    private Builder(NetworkInterface networkInterface) {
      this.name = networkInterface.name;
      this.network = networkInterface.network;
      this.networkIp = networkInterface.networkIp;
      this.subnetwork = networkInterface.subnetwork;
      this.accessConfigurations = networkInterface.accessConfigurations;
    }

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** Sets the identity of the network this interface applies to. */
    public Builder setNetwork(NetworkId network) {
      this.network = checkNotNull(network);
      return this;
    }

    Builder setNetworkIp(String networkIp) {
      this.networkIp = networkIp;
      return this;
    }

    /**
     * Sets the identity of the subnetwork this interface applies to. Setting the subnetwork is not
     * necessary when the network is in "automatic subnet mode".
     */
    public Builder setSubnetwork(SubnetworkId subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    /**
     * Sets a list of access configurations for the network interface. Access configurations can be
     * used to assign either a static or an ephemeral external IP address to Google Compute Engine
     * instances. At the moment, network interfaces only support one access configuration.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">
     *     Static external IP addresses</a>
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#ephemeraladdress">
     *     Ephemeral external IP addresses</a>
     */
    public Builder setAccessConfigurations(List<AccessConfig> accessConfigurations) {
      this.accessConfigurations = ImmutableList.copyOf(accessConfigurations);
      return this;
    }

    /**
     * Sets a list of access configurations for the network interface. Access configurations can be
     * used to assign either a static or an ephemeral external IP address to Google Compute Engine
     * instances. At the moment, network interfaces only support one access configuration.
     *
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">
     *     Static external IP addresses</a>
     * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#ephemeraladdress">
     *     Ephemeral external IP addresses</a>
     */
    public Builder setAccessConfigurations(AccessConfig... accessConfigurations) {
      setAccessConfigurations(Arrays.asList(accessConfigurations));
      return this;
    }

    /** Creates a {@code NetworkInterface} object. */
    public NetworkInterface build() {
      return new NetworkInterface(this);
    }
  }

  private NetworkInterface(Builder builder) {
    this.name = builder.name;
    this.network = builder.network;
    this.networkIp = builder.networkIp;
    this.subnetwork = builder.subnetwork;
    this.accessConfigurations =
        builder.accessConfigurations != null
            ? builder.accessConfigurations
            : ImmutableList.<AccessConfig>of();
  }

  /**
   * Returns the name of the network interface, generated by the service. For network devices, these
   * are {@code eth0}, {@code eth1}, etc.
   */
  public String getName() {
    return name;
  }

  /** Returns the identity of the network this interface applies to. */
  public NetworkId getNetwork() {
    return network;
  }

  /**
   * An optional IPv4 internal network address assigned by the service to the instance for this
   * network interface.
   */
  public String getNetworkIp() {
    return networkIp;
  }

  /** Returns the identity of the subnetwork this interface applies to. */
  public SubnetworkId getSubnetwork() {
    return subnetwork;
  }

  /** Returns a list of access configurations for the network interface. */
  public List<AccessConfig> getAccessConfigurations() {
    return accessConfigurations;
  }

  /** Returns a builder for the current network interface. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("network", network)
        .add("networkIp", networkIp)
        .add("subnetwork", subnetwork)
        .add("accessConfigurations", accessConfigurations)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(name, network, networkIp, subnetwork, accessConfigurations);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(NetworkInterface.class)
            && Objects.equals(toPb(), ((NetworkInterface) obj).toPb());
  }

  com.google.api.services.compute.model.NetworkInterface toPb() {
    com.google.api.services.compute.model.NetworkInterface interfacePb =
        new com.google.api.services.compute.model.NetworkInterface();
    interfacePb.setName(name);
    interfacePb.setNetwork(network.getSelfLink());
    if (subnetwork != null) {
      interfacePb.setSubnetwork(subnetwork.getSelfLink());
    }
    interfacePb.setNetworkIP(networkIp);
    if (accessConfigurations != null) {
      interfacePb.setAccessConfigs(
          Lists.transform(accessConfigurations, AccessConfig.TO_PB_FUNCTION));
    }
    return interfacePb;
  }

  NetworkInterface setProjectId(String projectId) {
    Builder builder = toBuilder();
    builder.setNetwork(network.setProjectId(projectId));
    if (subnetwork != null) {
      builder.setSubnetwork(subnetwork.setProjectId(projectId));
    }
    return builder.build();
  }

  /** Returns a builder for a {@code NetworkInterface} object given the network's identity. */
  public static Builder newBuilder(NetworkId networkId) {
    return new Builder(networkId);
  }

  /** Returns a builder for a {@code NetworkInterface} object given the network's name. */
  public static Builder newBuilder(String network) {
    return newBuilder(NetworkId.of(network));
  }

  /** Returns a {@code NetworkInterface} object given the network's identity. */
  public static NetworkInterface of(NetworkId networkId) {
    return newBuilder(networkId).build();
  }

  /** Returns a {@code NetworkInterface} object given the network's name. */
  public static NetworkInterface of(String network) {
    return newBuilder(network).build();
  }

  static NetworkInterface fromPb(
      com.google.api.services.compute.model.NetworkInterface interfacePb) {
    Builder builder =
        newBuilder(NetworkId.fromUrl(interfacePb.getNetwork())).setName(interfacePb.getName());
    if (interfacePb.getSubnetwork() != null) {
      builder.setSubnetwork(SubnetworkId.fromUrl(interfacePb.getSubnetwork()));
    }
    builder.setNetworkIp(interfacePb.getNetworkIP());
    builder.setAccessConfigurations(
        interfacePb.getAccessConfigs() != null
            ? Lists.transform(interfacePb.getAccessConfigs(), AccessConfig.FROM_PB_FUNCTION)
            : ImmutableList.<AccessConfig>of());
    return builder.build();
  }
}
