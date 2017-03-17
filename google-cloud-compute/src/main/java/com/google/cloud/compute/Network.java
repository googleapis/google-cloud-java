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

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.compute.Compute.NetworkOption;
import com.google.cloud.compute.Compute.OperationOption;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * A Google Compute Engine Network. Every virtual machine instance is created as a member of a
 * network. Networks connect instances to each other and to the Internet. You can segment your
 * networks, use firewall rules to restrict access to instances, and create static routes to forward
 * traffic to specific destinations. Objects of this class are immutable. To get a {@code Network}
 * object with the most recent information use {@link #reload}. {@code Network} adds a layer of
 * service-related functionality over {@link NetworkInfo}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/networking">Using Networks and Firewalls</a>
 */
public class Network extends NetworkInfo {

  private static final long serialVersionUID = 8608280908101278096L;

  private final ComputeOptions options;
  private transient Compute compute;

  /**
   * A builder for {@code Network} objects.
   */
  public static class Builder extends NetworkInfo.Builder {

    private final Compute compute;
    private final NetworkInfo.BuilderImpl infoBuilder;

    Builder(Compute compute, NetworkId networkId, NetworkConfiguration configuration) {
      this.compute = compute;
      this.infoBuilder = new NetworkInfo.BuilderImpl(networkId, configuration);
      this.infoBuilder.setNetworkId(networkId);
      this.infoBuilder.setConfiguration(configuration);
    }

    Builder(Network subnetwork) {
      this.compute = subnetwork.compute;
      this.infoBuilder = new NetworkInfo.BuilderImpl(subnetwork);
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    Builder setCreationTimestamp(Long creationTimestamp) {
      infoBuilder.setCreationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    public Builder setNetworkId(NetworkId networkId) {
      infoBuilder.setNetworkId(networkId);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    public Builder setConfiguration(NetworkConfiguration configuration) {
      infoBuilder.setConfiguration(configuration);
      return this;
    }

    @Override
    public Network build() {
      return new Network(compute, infoBuilder);
    }
  }

  Network(Compute compute, NetworkInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.compute = checkNotNull(compute);
    this.options = compute.getOptions();
  }

  /**
   * Checks if this network exists.
   *
   * @return {@code true} if this network exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(NetworkOption.fields()) != null;
  }

  /**
   * Fetches current network' latest information. Returns {@code null} if the network does not
   * exist.
   *
   * @param options network options
   * @return a {@code Network} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Network reload(NetworkOption... options) {
    return compute.getNetwork(getNetworkId().getNetwork(), options);
  }

  /**
   * Deletes this network.
   *
   * @return an operation object if delete request was successfully sent, {@code null} if the
   *     network was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.deleteNetwork(getNetworkId().getNetwork(), options);
  }

  /**
   * Creates a subnetwork for this network given its identity and the range of IPv4 addresses in
   * CIDR format. Subnetwork creation is only supported for networks in "custom subnet mode" (i.e.
   * {@link #getConfiguration()} returns a {@link SubnetNetworkConfiguration}) with automatic
   * creation of subnetworks disabled (i.e. {@link SubnetNetworkConfiguration#autoCreateSubnetworks()}
   * returns {@code false}).
   *
   * @return an operation object if creation request was successfully sent
   * @throws ComputeException upon failure
   * @see <a href="https://wikipedia.org/wiki/Classless_Inter-Domain_Routing">CIDR</a>
   */
  public Operation createSubnetwork(SubnetworkId subnetworkId, String ipRange,
      OperationOption... options) {
    return compute.create(SubnetworkInfo.of(subnetworkId, getNetworkId(), ipRange), options);
  }

  /**
   * Returns the network's {@code Compute} object used to issue requests.
   */
  public Compute getCompute() {
    return compute;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Network.class)) {
      return false;
    }
    Network other = (Network) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.getService();
  }

  static Network fromPb(Compute compute,
      com.google.api.services.compute.model.Network networkPb) {
    return new Network(compute, new NetworkInfo.BuilderImpl(networkPb));
  }
}
