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

import com.google.api.services.compute.model.Network;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Google Compute Engine network configuration. Use {@link
 * StandardNetworkConfiguration} to create a standard network with associated address range. Use
 * {@link SubnetNetworkConfiguration} to create a network that supports subnetworks, up to one per
 * region, each with its own address range.
 *
 * @see <a href="https://cloud.google.com/compute/docs/networking">Using Networks and Firewalls</a>
 */
public abstract class NetworkConfiguration implements Serializable {

  private static final long serialVersionUID = 6599798536784576564L;

  private final Type type;

  /** Type of a Google Compute Engine disk configuration. */
  public enum Type {
    /** A Google Compute Engine network with no subnetworks. */
    STANDARD,

    /**
     * A Google Compute Engine network that supports the creation of subnetworks (either automatic
     * or manual).
     */
    SUBNET
  }

  NetworkConfiguration(Type type) {
    this.type = type;
  }

  /**
   * Returns the network's type. This method returns {@link Type#STANDARD} for a standard networks
   * with no subnetworks. This method returns {@link Type#SUBNET} for a network that supports the
   * creation of subnetworks (either automatic or manual).
   */
  public Type getType() {
    return type;
  }

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("type", type);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(type);
  }

  final boolean baseEquals(NetworkConfiguration networkConfiguration) {
    return networkConfiguration != null
        && getClass().equals(networkConfiguration.getClass())
        && Objects.equals(toPb(), networkConfiguration.toPb());
  }

  abstract Network toPb();

  @SuppressWarnings("unchecked")
  static <T extends NetworkConfiguration> T fromPb(Network networkPb) {
    if (networkPb.getIPv4Range() != null) {
      return (T) StandardNetworkConfiguration.fromPb(networkPb);
    } else {
      return (T) SubnetNetworkConfiguration.fromPb(networkPb);
    }
  }
}
