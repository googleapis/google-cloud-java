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
import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * A Google Compute Engine standard network configuration. This class allows users to create a
 * network with its own address range. A network created with a {@code StandardNetworkConfiguration}
 * does not support the creation of subnetworks.
 *
 * @see <a href="https://cloud.google.com/compute/docs/networking">Using Networks and Firewalls</a>
 */
public class StandardNetworkConfiguration extends NetworkConfiguration {

  private static final long serialVersionUID = -5143748459659467966L;

  private final String ipRange;
  private final String gatewayAddress;

  StandardNetworkConfiguration(String ipRange, String gatewayAddress) {
    super(Type.STANDARD);
    this.ipRange = checkNotNull(ipRange);
    this.gatewayAddress = gatewayAddress;
  }

  /**
   * Returns the range of internal IPv4 addresses that are legal on this network. This range is a
   * CIDR specification, for example: {@code 192.168.0.0/16}.
   *
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public String getIpRange() {
    return ipRange;
  }

  /**
   * Returns the gateway IPv4 address for this networks. This value is read only and is selected by
   * Google Compute Engine, typically as the first usable address in {@code ipRange}.
   */
  public String getGatewayAddress() {
    return gatewayAddress;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.baseHashCode(), ipRange, gatewayAddress);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(StandardNetworkConfiguration.class)
            && Objects.equals(toPb(), ((StandardNetworkConfiguration) obj).toPb());
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("ipRange", ipRange).add("gatewayAddress", gatewayAddress);
  }

  @Override
  Network toPb() {
    return new Network().setIPv4Range(ipRange).setGatewayIPv4(gatewayAddress);
  }

  /**
   * Returns a {@code StandardNetworkConfiguration} object given the range of internal addresses
   * that are legal on this network. {@code ipRange} must be a CIDR specification, for example:
   * {@code 192.168.0.0/16}.
   *
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public static StandardNetworkConfiguration of(String ipRange) {
    return new StandardNetworkConfiguration(ipRange, null);
  }

  @SuppressWarnings("unchecked")
  static StandardNetworkConfiguration fromPb(Network networkPb) {
    return new StandardNetworkConfiguration(networkPb.getIPv4Range(), networkPb.getGatewayIPv4());
  }
}
