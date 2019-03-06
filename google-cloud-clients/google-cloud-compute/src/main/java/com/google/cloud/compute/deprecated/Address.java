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

import com.google.cloud.compute.deprecated.Compute.AddressOption;
import com.google.cloud.compute.deprecated.Compute.OperationOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * A Google Compute Engine address. With Compute Engine you can create static external IP addresses
 * that are assigned to your project and persist until you explicitly release them. A region address
 * can be assigned to a Compute Engine instance or to a regional forwarding rule. Compute Engine
 * also allows you to create global addresses that are used for global forwarding rules. Both global
 * addresses and global forwarding rules can only be used for HTTP load balancing. {@code Address}
 * adds a layer of service-related functionality over {@link AddressInfo}. Objects of this class are
 * immutable. To get an {@code Address} object with the most recent information use {@link #reload}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/instances-and-network#reservedaddress">Static
 *     external IP addresses</a>
 * @see <a href="https://cloud.google.com/compute/docs/load-balancing/http/">HTTP Load Balancing</a>
 */
public class Address extends AddressInfo {

  private static final long serialVersionUID = 3457542817554062712L;

  private final ComputeOptions options;
  private transient Compute compute;

  /** A builder for {@code Address} objects. */
  public static class Builder extends AddressInfo.Builder {

    private final Compute compute;
    private final AddressInfo.BuilderImpl infoBuilder;

    Builder(Compute compute, AddressId addressId) {
      this.compute = compute;
      this.infoBuilder = new AddressInfo.BuilderImpl();
      this.infoBuilder.setAddressId(addressId);
    }

    Builder(Address address) {
      this.compute = address.compute;
      this.infoBuilder = new AddressInfo.BuilderImpl(address);
    }

    @Override
    public Builder setAddress(String address) {
      infoBuilder.setAddress(address);
      return this;
    }

    @Override
    Builder setCreationTimestamp(Long creationTimestamp) {
      infoBuilder.setCreationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    public Builder setAddressId(AddressId addressId) {
      infoBuilder.setAddressId(addressId);
      return this;
    }

    @Override
    Builder setStatus(Status status) {
      infoBuilder.setStatus(status);
      return this;
    }

    @Override
    Builder setUsage(Usage usage) {
      infoBuilder.setUsage(usage);
      return this;
    }

    @Override
    public Address build() {
      return new Address(compute, infoBuilder);
    }
  }

  Address(Compute compute, AddressInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.compute = checkNotNull(compute);
    this.options = compute.getOptions();
  }

  /**
   * Checks if this address exists.
   *
   * @return {@code true} if this address exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(AddressOption.fields()) != null;
  }

  /**
   * Fetches the current address' latest information. Returns {@code null} if the address does not
   * exist.
   *
   * @param options address options
   * @return an {@code Address} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Address reload(AddressOption... options) {
    return compute.getAddress(getAddressId(), options);
  }

  /**
   * Deletes this address.
   *
   * @return an {@code Operation} object if delete request was successfully sent, {@code null} if
   *     the address was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.deleteAddress(getAddressId(), options);
  }

  /** Returns the address's {@code Compute} object used to issue requests. */
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
    if (obj == null || !obj.getClass().equals(Address.class)) {
      return false;
    }
    Address other = (Address) obj;
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

  static Address fromPb(Compute compute, com.google.api.services.compute.model.Address addressPb) {
    return new Address(compute, new AddressInfo.BuilderImpl(addressPb));
  }
}
