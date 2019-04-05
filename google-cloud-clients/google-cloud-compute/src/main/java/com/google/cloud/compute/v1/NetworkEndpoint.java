/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** The network endpoint. */
public final class NetworkEndpoint implements ApiMessage {
  private final String instance;
  private final String ipAddress;
  private final Integer port;

  private NetworkEndpoint() {
    this.instance = null;
    this.ipAddress = null;
    this.port = null;
  }

  private NetworkEndpoint(String instance, String ipAddress, Integer port) {
    this.instance = instance;
    this.ipAddress = ipAddress;
    this.port = port;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instance".equals(fieldName)) {
      return instance;
    }
    if ("ipAddress".equals(fieldName)) {
      return ipAddress;
    }
    if ("port".equals(fieldName)) {
      return port;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * The name for a specific VM instance that the IP address belongs to. This is required for
   * network endpoints of type GCE_VM_IP_PORT. The instance must be in the same zone of network
   * endpoint group.
   *
   * <p>The name must be 1-63 characters long, and comply with RFC1035.
   */
  public String getInstance() {
    return instance;
  }

  /**
   * Optional IPv4 address of network endpoint. The IP address must belong to a VM in GCE (either
   * the primary IP or as part of an aliased IP range). If the IP address is not specified, then the
   * primary IP address for the VM instance in the network that the network endpoint group belongs
   * to will be used.
   */
  public String getIpAddress() {
    return ipAddress;
  }

  /**
   * Optional port number of network endpoint. If not specified and the
   * NetworkEndpointGroup.network_endpoint_type is GCE_IP_PORT, the defaultPort for the network
   * endpoint group will be used.
   */
  public Integer getPort() {
    return port;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpoint prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpoint DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpoint();
  }

  public static class Builder {
    private String instance;
    private String ipAddress;
    private Integer port;

    Builder() {}

    public Builder mergeFrom(NetworkEndpoint other) {
      if (other == NetworkEndpoint.getDefaultInstance()) return this;
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getIpAddress() != null) {
        this.ipAddress = other.ipAddress;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      return this;
    }

    Builder(NetworkEndpoint source) {
      this.instance = source.instance;
      this.ipAddress = source.ipAddress;
      this.port = source.port;
    }

    /**
     * The name for a specific VM instance that the IP address belongs to. This is required for
     * network endpoints of type GCE_VM_IP_PORT. The instance must be in the same zone of network
     * endpoint group.
     *
     * <p>The name must be 1-63 characters long, and comply with RFC1035.
     */
    public String getInstance() {
      return instance;
    }

    /**
     * The name for a specific VM instance that the IP address belongs to. This is required for
     * network endpoints of type GCE_VM_IP_PORT. The instance must be in the same zone of network
     * endpoint group.
     *
     * <p>The name must be 1-63 characters long, and comply with RFC1035.
     */
    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    /**
     * Optional IPv4 address of network endpoint. The IP address must belong to a VM in GCE (either
     * the primary IP or as part of an aliased IP range). If the IP address is not specified, then
     * the primary IP address for the VM instance in the network that the network endpoint group
     * belongs to will be used.
     */
    public String getIpAddress() {
      return ipAddress;
    }

    /**
     * Optional IPv4 address of network endpoint. The IP address must belong to a VM in GCE (either
     * the primary IP or as part of an aliased IP range). If the IP address is not specified, then
     * the primary IP address for the VM instance in the network that the network endpoint group
     * belongs to will be used.
     */
    public Builder setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }

    /**
     * Optional port number of network endpoint. If not specified and the
     * NetworkEndpointGroup.network_endpoint_type is GCE_IP_PORT, the defaultPort for the network
     * endpoint group will be used.
     */
    public Integer getPort() {
      return port;
    }

    /**
     * Optional port number of network endpoint. If not specified and the
     * NetworkEndpointGroup.network_endpoint_type is GCE_IP_PORT, the defaultPort for the network
     * endpoint group will be used.
     */
    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public NetworkEndpoint build() {

      return new NetworkEndpoint(instance, ipAddress, port);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstance(this.instance);
      newBuilder.setIpAddress(this.ipAddress);
      newBuilder.setPort(this.port);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpoint{"
        + "instance="
        + instance
        + ", "
        + "ipAddress="
        + ipAddress
        + ", "
        + "port="
        + port
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpoint) {
      NetworkEndpoint that = (NetworkEndpoint) o;
      return Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.ipAddress, that.getIpAddress())
          && Objects.equals(this.port, that.getPort());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instance, ipAddress, port);
  }
}
