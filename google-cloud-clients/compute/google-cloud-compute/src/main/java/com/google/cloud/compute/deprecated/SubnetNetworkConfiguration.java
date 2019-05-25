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
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine configuration for networks that support subnetworks, up to one per
 * region, each with its own address range. Subnetworks can be either automatically or manually
 * created, depending on the value of {@link SubnetNetworkConfiguration#autoCreateSubnetworks()}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/networking">Using Networks and Firewalls</a>
 */
public class SubnetNetworkConfiguration extends NetworkConfiguration {

  private static final long serialVersionUID = -5286394393047479494L;

  private final Boolean autoCreateSubnetworks;
  private final List<SubnetworkId> subnetworks;

  SubnetNetworkConfiguration(boolean autoCreateSubnetworks, List<SubnetworkId> subnetworks) {
    super(Type.SUBNET);
    this.autoCreateSubnetworks = autoCreateSubnetworks;
    this.subnetworks = subnetworks;
  }

  /**
   * Returns whether the subnetworks should be automatically created. When set to {@code true}, the
   * network is created in "auto subnet mode". When set to {@code false}, the network is in "custom
   * subnet mode". In "auto subnet mode", a subnetwork per region is automatically created. In
   * "custom subnet mode", a custom topology of subnetworks can be created by the user.
   */
  public Boolean autoCreateSubnetworks() {
    return autoCreateSubnetworks;
  }

  /** Returns the identities of all networks in this network. */
  public List<SubnetworkId> getSubnetworks() {
    return subnetworks;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(autoCreateSubnetworks, subnetworks);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(SubnetNetworkConfiguration.class)
            && Objects.equals(toPb(), ((SubnetNetworkConfiguration) obj).toPb());
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("autoCreateSubnetworks", autoCreateSubnetworks)
        .add("subnetworks", subnetworks);
  }

  @Override
  Network toPb() {
    Network networkPb = new Network().setAutoCreateSubnetworks(autoCreateSubnetworks);
    if (subnetworks != null) {
      networkPb.setSubnetworks(Lists.transform(subnetworks, SubnetworkId.TO_URL_FUNCTION));
    }
    return networkPb;
  }

  /**
   * Returns a {@code SubnetNetworkConfiguration} object. The {@code autoCreateSubnetworks}
   * parameter sets whether subnetworks should be automatically created. When set to {@code true},
   * the network is created in "auto subnet mode". When set to {@code false}, the network is in
   * "custom subnet mode". In "auto subnet mode", a subnetwork per region is automatically created.
   * In "custom subnet mode", a custom topology of subnetworks can be created by the user.
   */
  public static SubnetNetworkConfiguration of(boolean autoCreateSubnetworks) {
    return new SubnetNetworkConfiguration(autoCreateSubnetworks, null);
  }

  @SuppressWarnings("unchecked")
  static SubnetNetworkConfiguration fromPb(Network networkPb) {
    List<SubnetworkId> subnetworks = null;
    if (networkPb.getSubnetworks() != null) {
      subnetworks = Lists.transform(networkPb.getSubnetworks(), SubnetworkId.FROM_URL_FUNCTION);
    }
    return new SubnetNetworkConfiguration(networkPb.getAutoCreateSubnetworks(), subnetworks);
  }
}
