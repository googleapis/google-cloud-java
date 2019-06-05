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
public final class RouterInterface implements ApiMessage {
  private final String ipRange;
  private final String linkedInterconnectAttachment;
  private final String linkedVpnTunnel;
  private final String managementType;
  private final String name;

  private RouterInterface() {
    this.ipRange = null;
    this.linkedInterconnectAttachment = null;
    this.linkedVpnTunnel = null;
    this.managementType = null;
    this.name = null;
  }

  private RouterInterface(
      String ipRange,
      String linkedInterconnectAttachment,
      String linkedVpnTunnel,
      String managementType,
      String name) {
    this.ipRange = ipRange;
    this.linkedInterconnectAttachment = linkedInterconnectAttachment;
    this.linkedVpnTunnel = linkedVpnTunnel;
    this.managementType = managementType;
    this.name = name;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("ipRange".equals(fieldName)) {
      return ipRange;
    }
    if ("linkedInterconnectAttachment".equals(fieldName)) {
      return linkedInterconnectAttachment;
    }
    if ("linkedVpnTunnel".equals(fieldName)) {
      return linkedVpnTunnel;
    }
    if ("managementType".equals(fieldName)) {
      return managementType;
    }
    if ("name".equals(fieldName)) {
      return name;
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
   * IP address and range of the interface. The IP range must be in the RFC3927 link-local IP
   * address space. The value must be a CIDR-formatted string, for example: 169.254.0.1/30. NOTE: Do
   * not truncate the address as it represents the IP address of the interface.
   */
  public String getIpRange() {
    return ipRange;
  }

  /**
   * URI of the linked Interconnect attachment. It must be in the same region as the router. Each
   * interface can have one linked resource, which can be either be a VPN tunnel or an Interconnect
   * attachment.
   */
  public String getLinkedInterconnectAttachment() {
    return linkedInterconnectAttachment;
  }

  /**
   * URI of the linked VPN tunnel, which must be in the same region as the router. Each interface
   * can have one linked resource, which can be either a VPN tunnel or an Interconnect attachment.
   */
  public String getLinkedVpnTunnel() {
    return linkedVpnTunnel;
  }

  /**
   * [Output Only] The resource that configures and manages this interface. - MANAGED_BY_USER is the
   * default value and can be managed directly by users. - MANAGED_BY_ATTACHMENT is an interface
   * that is configured and managed by Cloud Interconnect, specifically, by an
   * InterconnectAttachment of type PARTNER. Google automatically creates, updates, and deletes this
   * type of interface when the PARTNER InterconnectAttachment is created, updated, or deleted.
   */
  public String getManagementType() {
    return managementType;
  }

  /**
   * Name of this interface entry. The name must be 1-63 characters long and comply with RFC1035.
   */
  public String getName() {
    return name;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterInterface prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterInterface getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterInterface DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterInterface();
  }

  public static class Builder {
    private String ipRange;
    private String linkedInterconnectAttachment;
    private String linkedVpnTunnel;
    private String managementType;
    private String name;

    Builder() {}

    public Builder mergeFrom(RouterInterface other) {
      if (other == RouterInterface.getDefaultInstance()) return this;
      if (other.getIpRange() != null) {
        this.ipRange = other.ipRange;
      }
      if (other.getLinkedInterconnectAttachment() != null) {
        this.linkedInterconnectAttachment = other.linkedInterconnectAttachment;
      }
      if (other.getLinkedVpnTunnel() != null) {
        this.linkedVpnTunnel = other.linkedVpnTunnel;
      }
      if (other.getManagementType() != null) {
        this.managementType = other.managementType;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      return this;
    }

    Builder(RouterInterface source) {
      this.ipRange = source.ipRange;
      this.linkedInterconnectAttachment = source.linkedInterconnectAttachment;
      this.linkedVpnTunnel = source.linkedVpnTunnel;
      this.managementType = source.managementType;
      this.name = source.name;
    }

    /**
     * IP address and range of the interface. The IP range must be in the RFC3927 link-local IP
     * address space. The value must be a CIDR-formatted string, for example: 169.254.0.1/30. NOTE:
     * Do not truncate the address as it represents the IP address of the interface.
     */
    public String getIpRange() {
      return ipRange;
    }

    /**
     * IP address and range of the interface. The IP range must be in the RFC3927 link-local IP
     * address space. The value must be a CIDR-formatted string, for example: 169.254.0.1/30. NOTE:
     * Do not truncate the address as it represents the IP address of the interface.
     */
    public Builder setIpRange(String ipRange) {
      this.ipRange = ipRange;
      return this;
    }

    /**
     * URI of the linked Interconnect attachment. It must be in the same region as the router. Each
     * interface can have one linked resource, which can be either be a VPN tunnel or an
     * Interconnect attachment.
     */
    public String getLinkedInterconnectAttachment() {
      return linkedInterconnectAttachment;
    }

    /**
     * URI of the linked Interconnect attachment. It must be in the same region as the router. Each
     * interface can have one linked resource, which can be either be a VPN tunnel or an
     * Interconnect attachment.
     */
    public Builder setLinkedInterconnectAttachment(String linkedInterconnectAttachment) {
      this.linkedInterconnectAttachment = linkedInterconnectAttachment;
      return this;
    }

    /**
     * URI of the linked VPN tunnel, which must be in the same region as the router. Each interface
     * can have one linked resource, which can be either a VPN tunnel or an Interconnect attachment.
     */
    public String getLinkedVpnTunnel() {
      return linkedVpnTunnel;
    }

    /**
     * URI of the linked VPN tunnel, which must be in the same region as the router. Each interface
     * can have one linked resource, which can be either a VPN tunnel or an Interconnect attachment.
     */
    public Builder setLinkedVpnTunnel(String linkedVpnTunnel) {
      this.linkedVpnTunnel = linkedVpnTunnel;
      return this;
    }

    /**
     * [Output Only] The resource that configures and manages this interface. - MANAGED_BY_USER is
     * the default value and can be managed directly by users. - MANAGED_BY_ATTACHMENT is an
     * interface that is configured and managed by Cloud Interconnect, specifically, by an
     * InterconnectAttachment of type PARTNER. Google automatically creates, updates, and deletes
     * this type of interface when the PARTNER InterconnectAttachment is created, updated, or
     * deleted.
     */
    public String getManagementType() {
      return managementType;
    }

    /**
     * [Output Only] The resource that configures and manages this interface. - MANAGED_BY_USER is
     * the default value and can be managed directly by users. - MANAGED_BY_ATTACHMENT is an
     * interface that is configured and managed by Cloud Interconnect, specifically, by an
     * InterconnectAttachment of type PARTNER. Google automatically creates, updates, and deletes
     * this type of interface when the PARTNER InterconnectAttachment is created, updated, or
     * deleted.
     */
    public Builder setManagementType(String managementType) {
      this.managementType = managementType;
      return this;
    }

    /**
     * Name of this interface entry. The name must be 1-63 characters long and comply with RFC1035.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of this interface entry. The name must be 1-63 characters long and comply with RFC1035.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public RouterInterface build() {

      return new RouterInterface(
          ipRange, linkedInterconnectAttachment, linkedVpnTunnel, managementType, name);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIpRange(this.ipRange);
      newBuilder.setLinkedInterconnectAttachment(this.linkedInterconnectAttachment);
      newBuilder.setLinkedVpnTunnel(this.linkedVpnTunnel);
      newBuilder.setManagementType(this.managementType);
      newBuilder.setName(this.name);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterInterface{"
        + "ipRange="
        + ipRange
        + ", "
        + "linkedInterconnectAttachment="
        + linkedInterconnectAttachment
        + ", "
        + "linkedVpnTunnel="
        + linkedVpnTunnel
        + ", "
        + "managementType="
        + managementType
        + ", "
        + "name="
        + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterInterface) {
      RouterInterface that = (RouterInterface) o;
      return Objects.equals(this.ipRange, that.getIpRange())
          && Objects.equals(
              this.linkedInterconnectAttachment, that.getLinkedInterconnectAttachment())
          && Objects.equals(this.linkedVpnTunnel, that.getLinkedVpnTunnel())
          && Objects.equals(this.managementType, that.getManagementType())
          && Objects.equals(this.name, that.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        ipRange, linkedInterconnectAttachment, linkedVpnTunnel, managementType, name);
  }
}
