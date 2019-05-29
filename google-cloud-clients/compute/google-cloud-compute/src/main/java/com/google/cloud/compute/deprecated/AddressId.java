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

import com.google.common.base.MoreObjects;
import java.util.Objects;

/** Base class for Google Compute Engine address identities. */
public abstract class AddressId extends ResourceId {

  private static final long serialVersionUID = 147328216049936438L;

  private final String address;

  /** Possible types for a Google Compute Engine address identity. */
  enum Type {
    /** Global static external IP addresses can be assigned to global forwarding rules. */
    GLOBAL,

    /**
     * Region static external IP addresses can be assigned to instances and region forwarding rules.
     */
    REGION
  }

  AddressId(String project, String address) {
    super(project);
    this.address = checkNotNull(address);
  }

  /** Returns the type of this address identity. */
  public abstract Type getType();

  /**
   * Returns the name of the address resource. The name must be 1-63 characters long and comply with
   * RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getAddress() {
    return address;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("address", address);
  }

  @Override
  final int baseHashCode() {
    return Objects.hash(super.baseHashCode(), address);
  }

  @Override
  final boolean baseEquals(ResourceId resourceId) {
    return resourceId instanceof AddressId
        && super.baseEquals(resourceId)
        && Objects.equals(address, ((AddressId) resourceId).address);
  }

  @Override
  abstract AddressId setProjectId(String projectId);
}
