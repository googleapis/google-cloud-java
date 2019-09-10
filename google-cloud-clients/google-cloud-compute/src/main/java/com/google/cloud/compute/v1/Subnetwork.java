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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Subnetwork resource.
 *
 * <p>A subnetwork (also known as a subnet) is a logical partition of a Virtual Private Cloud
 * network with one primary IP range and zero or more secondary IP ranges. For more information,
 * read Virtual Private Cloud (VPC) Network. (== resource_for beta.subnetworks ==) (== resource_for
 * v1.subnetworks ==)
 */
public final class Subnetwork implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final Boolean enableFlowLogs;
  private final String fingerprint;
  private final String gatewayAddress;
  private final String id;
  private final String ipCidrRange;
  private final String kind;
  private final SubnetworkLogConfig logConfig;
  private final String name;
  private final String network;
  private final Boolean privateIpGoogleAccess;
  private final String region;
  private final List<SubnetworkSecondaryRange> secondaryIpRanges;
  private final String selfLink;

  private Subnetwork() {
    this.creationTimestamp = null;
    this.description = null;
    this.enableFlowLogs = null;
    this.fingerprint = null;
    this.gatewayAddress = null;
    this.id = null;
    this.ipCidrRange = null;
    this.kind = null;
    this.logConfig = null;
    this.name = null;
    this.network = null;
    this.privateIpGoogleAccess = null;
    this.region = null;
    this.secondaryIpRanges = null;
    this.selfLink = null;
  }

  private Subnetwork(
      String creationTimestamp,
      String description,
      Boolean enableFlowLogs,
      String fingerprint,
      String gatewayAddress,
      String id,
      String ipCidrRange,
      String kind,
      SubnetworkLogConfig logConfig,
      String name,
      String network,
      Boolean privateIpGoogleAccess,
      String region,
      List<SubnetworkSecondaryRange> secondaryIpRanges,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.enableFlowLogs = enableFlowLogs;
    this.fingerprint = fingerprint;
    this.gatewayAddress = gatewayAddress;
    this.id = id;
    this.ipCidrRange = ipCidrRange;
    this.kind = kind;
    this.logConfig = logConfig;
    this.name = name;
    this.network = network;
    this.privateIpGoogleAccess = privateIpGoogleAccess;
    this.region = region;
    this.secondaryIpRanges = secondaryIpRanges;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("enableFlowLogs".equals(fieldName)) {
      return enableFlowLogs;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("gatewayAddress".equals(fieldName)) {
      return gatewayAddress;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("ipCidrRange".equals(fieldName)) {
      return ipCidrRange;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("logConfig".equals(fieldName)) {
      return logConfig;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("privateIpGoogleAccess".equals(fieldName)) {
      return privateIpGoogleAccess;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("secondaryIpRanges".equals(fieldName)) {
      return secondaryIpRanges;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   * This field can be set only at resource creation time.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
   * will not appear in get listings. If not set the default behavior is to disable flow logging.
   */
  public Boolean getEnableFlowLogs() {
    return enableFlowLogs;
  }

  /**
   * Fingerprint of this resource. A hash of the contents stored in this object. This field is used
   * in optimistic locking. This field will be ignored when inserting a Subnetwork. An up-to-date
   * fingerprint must be provided in order to update the Subnetwork, otherwise the request will fail
   * with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve a Subnetwork.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * [Output Only] The gateway address for default routes to reach destination addresses outside
   * this subnetwork.
   */
  public String getGatewayAddress() {
    return gatewayAddress;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * The range of internal addresses that are owned by this subnetwork. Provide this property when
   * you create the subnetwork. For example, 10.0.0.0/8 or 192.168.0.0/16. Ranges must be unique and
   * non-overlapping within a network. Only IPv4 is supported. This field can be set only at
   * resource creation time.
   */
  public String getIpCidrRange() {
    return ipCidrRange;
  }

  /** [Output Only] Type of the resource. Always compute#subnetwork for Subnetwork resources. */
  public String getKind() {
    return kind;
  }

  /**
   * This field denotes the VPC flow logging options for this subnetwork. If logging is enabled,
   * logs are exported to Stackdriver.
   */
  public SubnetworkLogConfig getLogConfig() {
    return logConfig;
  }

  /**
   * The name of the resource, provided by the client when initially creating the resource. The name
   * must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63
   * characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means
   * the first character must be a lowercase letter, and all following characters must be a dash,
   * lowercase letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * The URL of the network to which this subnetwork belongs, provided by the client when initially
   * creating the subnetwork. Only networks that are in the distributed mode can have subnetworks.
   * This field can be set only at resource creation time.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * Whether the VMs in this subnet can access Google services without assigned external IP
   * addresses. This field can be both set at resource creation time and updated using
   * setPrivateIpGoogleAccess.
   */
  public Boolean getPrivateIpGoogleAccess() {
    return privateIpGoogleAccess;
  }

  /**
   * URL of the region where the Subnetwork resides. This field can be set only at resource creation
   * time.
   */
  public String getRegion() {
    return region;
  }

  /**
   * An array of configurations for secondary IP ranges for VM instances contained in this
   * subnetwork. The primary IP of such VM must belong to the primary ipCidrRange of the subnetwork.
   * The alias IPs may belong to either primary or secondary ranges. This field can be updated with
   * a patch request.
   */
  public List<SubnetworkSecondaryRange> getSecondaryIpRangesList() {
    return secondaryIpRanges;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Subnetwork prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Subnetwork getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Subnetwork DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Subnetwork();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private Boolean enableFlowLogs;
    private String fingerprint;
    private String gatewayAddress;
    private String id;
    private String ipCidrRange;
    private String kind;
    private SubnetworkLogConfig logConfig;
    private String name;
    private String network;
    private Boolean privateIpGoogleAccess;
    private String region;
    private List<SubnetworkSecondaryRange> secondaryIpRanges;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(Subnetwork other) {
      if (other == Subnetwork.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnableFlowLogs() != null) {
        this.enableFlowLogs = other.enableFlowLogs;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getGatewayAddress() != null) {
        this.gatewayAddress = other.gatewayAddress;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpCidrRange() != null) {
        this.ipCidrRange = other.ipCidrRange;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLogConfig() != null) {
        this.logConfig = other.logConfig;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getPrivateIpGoogleAccess() != null) {
        this.privateIpGoogleAccess = other.privateIpGoogleAccess;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSecondaryIpRangesList() != null) {
        this.secondaryIpRanges = other.secondaryIpRanges;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(Subnetwork source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.enableFlowLogs = source.enableFlowLogs;
      this.fingerprint = source.fingerprint;
      this.gatewayAddress = source.gatewayAddress;
      this.id = source.id;
      this.ipCidrRange = source.ipCidrRange;
      this.kind = source.kind;
      this.logConfig = source.logConfig;
      this.name = source.name;
      this.network = source.network;
      this.privateIpGoogleAccess = source.privateIpGoogleAccess;
      this.region = source.region;
      this.secondaryIpRanges = source.secondaryIpRanges;
      this.selfLink = source.selfLink;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     * This field can be set only at resource creation time.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     * This field can be set only at resource creation time.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
     * will not appear in get listings. If not set the default behavior is to disable flow logging.
     */
    public Boolean getEnableFlowLogs() {
      return enableFlowLogs;
    }

    /**
     * Whether to enable flow logging for this subnetwork. If this field is not explicitly set, it
     * will not appear in get listings. If not set the default behavior is to disable flow logging.
     */
    public Builder setEnableFlowLogs(Boolean enableFlowLogs) {
      this.enableFlowLogs = enableFlowLogs;
      return this;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a Subnetwork. An
     * up-to-date fingerprint must be provided in order to update the Subnetwork, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a Subnetwork.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a Subnetwork. An
     * up-to-date fingerprint must be provided in order to update the Subnetwork, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve a Subnetwork.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * [Output Only] The gateway address for default routes to reach destination addresses outside
     * this subnetwork.
     */
    public String getGatewayAddress() {
      return gatewayAddress;
    }

    /**
     * [Output Only] The gateway address for default routes to reach destination addresses outside
     * this subnetwork.
     */
    public Builder setGatewayAddress(String gatewayAddress) {
      this.gatewayAddress = gatewayAddress;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * The range of internal addresses that are owned by this subnetwork. Provide this property when
     * you create the subnetwork. For example, 10.0.0.0/8 or 192.168.0.0/16. Ranges must be unique
     * and non-overlapping within a network. Only IPv4 is supported. This field can be set only at
     * resource creation time.
     */
    public String getIpCidrRange() {
      return ipCidrRange;
    }

    /**
     * The range of internal addresses that are owned by this subnetwork. Provide this property when
     * you create the subnetwork. For example, 10.0.0.0/8 or 192.168.0.0/16. Ranges must be unique
     * and non-overlapping within a network. Only IPv4 is supported. This field can be set only at
     * resource creation time.
     */
    public Builder setIpCidrRange(String ipCidrRange) {
      this.ipCidrRange = ipCidrRange;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#subnetwork for Subnetwork resources. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#subnetwork for Subnetwork resources. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * This field denotes the VPC flow logging options for this subnetwork. If logging is enabled,
     * logs are exported to Stackdriver.
     */
    public SubnetworkLogConfig getLogConfig() {
      return logConfig;
    }

    /**
     * This field denotes the VPC flow logging options for this subnetwork. If logging is enabled,
     * logs are exported to Stackdriver.
     */
    public Builder setLogConfig(SubnetworkLogConfig logConfig) {
      this.logConfig = logConfig;
      return this;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * name must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be
     * 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which
     * means the first character must be a lowercase letter, and all following characters must be a
     * dash, lowercase letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * name must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be
     * 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which
     * means the first character must be a lowercase letter, and all following characters must be a
     * dash, lowercase letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The URL of the network to which this subnetwork belongs, provided by the client when
     * initially creating the subnetwork. Only networks that are in the distributed mode can have
     * subnetworks. This field can be set only at resource creation time.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * The URL of the network to which this subnetwork belongs, provided by the client when
     * initially creating the subnetwork. Only networks that are in the distributed mode can have
     * subnetworks. This field can be set only at resource creation time.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * Whether the VMs in this subnet can access Google services without assigned external IP
     * addresses. This field can be both set at resource creation time and updated using
     * setPrivateIpGoogleAccess.
     */
    public Boolean getPrivateIpGoogleAccess() {
      return privateIpGoogleAccess;
    }

    /**
     * Whether the VMs in this subnet can access Google services without assigned external IP
     * addresses. This field can be both set at resource creation time and updated using
     * setPrivateIpGoogleAccess.
     */
    public Builder setPrivateIpGoogleAccess(Boolean privateIpGoogleAccess) {
      this.privateIpGoogleAccess = privateIpGoogleAccess;
      return this;
    }

    /**
     * URL of the region where the Subnetwork resides. This field can be set only at resource
     * creation time.
     */
    public String getRegion() {
      return region;
    }

    /**
     * URL of the region where the Subnetwork resides. This field can be set only at resource
     * creation time.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /**
     * An array of configurations for secondary IP ranges for VM instances contained in this
     * subnetwork. The primary IP of such VM must belong to the primary ipCidrRange of the
     * subnetwork. The alias IPs may belong to either primary or secondary ranges. This field can be
     * updated with a patch request.
     */
    public List<SubnetworkSecondaryRange> getSecondaryIpRangesList() {
      return secondaryIpRanges;
    }

    /**
     * An array of configurations for secondary IP ranges for VM instances contained in this
     * subnetwork. The primary IP of such VM must belong to the primary ipCidrRange of the
     * subnetwork. The alias IPs may belong to either primary or secondary ranges. This field can be
     * updated with a patch request.
     */
    public Builder addAllSecondaryIpRanges(List<SubnetworkSecondaryRange> secondaryIpRanges) {
      if (this.secondaryIpRanges == null) {
        this.secondaryIpRanges = new LinkedList<>();
      }
      this.secondaryIpRanges.addAll(secondaryIpRanges);
      return this;
    }

    /**
     * An array of configurations for secondary IP ranges for VM instances contained in this
     * subnetwork. The primary IP of such VM must belong to the primary ipCidrRange of the
     * subnetwork. The alias IPs may belong to either primary or secondary ranges. This field can be
     * updated with a patch request.
     */
    public Builder addSecondaryIpRanges(SubnetworkSecondaryRange secondaryIpRanges) {
      if (this.secondaryIpRanges == null) {
        this.secondaryIpRanges = new LinkedList<>();
      }
      this.secondaryIpRanges.add(secondaryIpRanges);
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Subnetwork build() {

      return new Subnetwork(
          creationTimestamp,
          description,
          enableFlowLogs,
          fingerprint,
          gatewayAddress,
          id,
          ipCidrRange,
          kind,
          logConfig,
          name,
          network,
          privateIpGoogleAccess,
          region,
          secondaryIpRanges,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEnableFlowLogs(this.enableFlowLogs);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setGatewayAddress(this.gatewayAddress);
      newBuilder.setId(this.id);
      newBuilder.setIpCidrRange(this.ipCidrRange);
      newBuilder.setKind(this.kind);
      newBuilder.setLogConfig(this.logConfig);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setPrivateIpGoogleAccess(this.privateIpGoogleAccess);
      newBuilder.setRegion(this.region);
      newBuilder.addAllSecondaryIpRanges(this.secondaryIpRanges);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Subnetwork{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "enableFlowLogs="
        + enableFlowLogs
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "gatewayAddress="
        + gatewayAddress
        + ", "
        + "id="
        + id
        + ", "
        + "ipCidrRange="
        + ipCidrRange
        + ", "
        + "kind="
        + kind
        + ", "
        + "logConfig="
        + logConfig
        + ", "
        + "name="
        + name
        + ", "
        + "network="
        + network
        + ", "
        + "privateIpGoogleAccess="
        + privateIpGoogleAccess
        + ", "
        + "region="
        + region
        + ", "
        + "secondaryIpRanges="
        + secondaryIpRanges
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Subnetwork) {
      Subnetwork that = (Subnetwork) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enableFlowLogs, that.getEnableFlowLogs())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.gatewayAddress, that.getGatewayAddress())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipCidrRange, that.getIpCidrRange())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.logConfig, that.getLogConfig())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.privateIpGoogleAccess, that.getPrivateIpGoogleAccess())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.secondaryIpRanges, that.getSecondaryIpRangesList())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        enableFlowLogs,
        fingerprint,
        gatewayAddress,
        id,
        ipCidrRange,
        kind,
        logConfig,
        name,
        network,
        privateIpGoogleAccess,
        region,
        secondaryIpRanges,
        selfLink);
  }
}
