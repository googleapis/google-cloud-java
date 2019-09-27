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
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Forwarding Rule resource.
 *
 * <p>A forwardingRules resource represents a regional forwarding rule.
 *
 * <p>Regional external forwarding rules can reference any of the following resources:
 *
 * <p>- A target instance - A Cloud VPN Classic gateway (targetVpnGateway), - A target pool for a
 * Network Load Balancer - A global target HTTP(S) proxy for an HTTP(S) load balancer using Standard
 * Tier - A target SSL proxy for a SSL Proxy load balancer using Standard Tier - A target TCP proxy
 * for a TCP Proxy load balancer using Standard Tier.
 *
 * <p>Regional internal forwarding rules can reference the backend service of an internal TCP/UDP
 * load balancer.
 *
 * <p>For regional internal forwarding rules, the following applies: - If the loadBalancingScheme
 * for the load balancer is INTERNAL, then the forwarding rule references a regional internal
 * backend service. - If the loadBalancingScheme for the load balancer is INTERNAL_MANAGED, then the
 * forwarding rule must reference a regional target HTTP(S) proxy.
 *
 * <p>For more information, read Using Forwarding rules.
 *
 * <p>A globalForwardingRules resource represents a global forwarding rule.
 *
 * <p>Global forwarding rules are only used by load balancers that use Premium Tier. (==
 * resource_for beta.forwardingRules ==) (== resource_for v1.forwardingRules ==) (== resource_for
 * beta.globalForwardingRules ==) (== resource_for v1.globalForwardingRules ==) (== resource_for
 * beta.regionForwardingRules ==) (== resource_for v1.regionForwardingRules ==)
 */
public final class ForwardingRule implements ApiMessage {
  private final Boolean allPorts;
  private final String backendService;
  private final String creationTimestamp;
  private final String description;

  @SerializedName("IPAddress")
  private final String iPAddress;

  @SerializedName("IPProtocol")
  private final String iPProtocol;

  private final String id;
  private final String ipVersion;
  private final String kind;
  private final String loadBalancingScheme;
  private final List<MetadataFilter> metadataFilters;
  private final String name;
  private final String network;
  private final String networkTier;
  private final String portRange;
  private final List<String> ports;
  private final String region;
  private final String selfLink;
  private final String serviceLabel;
  private final String serviceName;
  private final String subnetwork;
  private final String target;

  private ForwardingRule() {
    this.allPorts = null;
    this.backendService = null;
    this.creationTimestamp = null;
    this.description = null;
    this.iPAddress = null;
    this.iPProtocol = null;
    this.id = null;
    this.ipVersion = null;
    this.kind = null;
    this.loadBalancingScheme = null;
    this.metadataFilters = null;
    this.name = null;
    this.network = null;
    this.networkTier = null;
    this.portRange = null;
    this.ports = null;
    this.region = null;
    this.selfLink = null;
    this.serviceLabel = null;
    this.serviceName = null;
    this.subnetwork = null;
    this.target = null;
  }

  private ForwardingRule(
      Boolean allPorts,
      String backendService,
      String creationTimestamp,
      String description,
      String iPAddress,
      String iPProtocol,
      String id,
      String ipVersion,
      String kind,
      String loadBalancingScheme,
      List<MetadataFilter> metadataFilters,
      String name,
      String network,
      String networkTier,
      String portRange,
      List<String> ports,
      String region,
      String selfLink,
      String serviceLabel,
      String serviceName,
      String subnetwork,
      String target) {
    this.allPorts = allPorts;
    this.backendService = backendService;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.iPAddress = iPAddress;
    this.iPProtocol = iPProtocol;
    this.id = id;
    this.ipVersion = ipVersion;
    this.kind = kind;
    this.loadBalancingScheme = loadBalancingScheme;
    this.metadataFilters = metadataFilters;
    this.name = name;
    this.network = network;
    this.networkTier = networkTier;
    this.portRange = portRange;
    this.ports = ports;
    this.region = region;
    this.selfLink = selfLink;
    this.serviceLabel = serviceLabel;
    this.serviceName = serviceName;
    this.subnetwork = subnetwork;
    this.target = target;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("allPorts".equals(fieldName)) {
      return allPorts;
    }
    if ("backendService".equals(fieldName)) {
      return backendService;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("iPAddress".equals(fieldName)) {
      return iPAddress;
    }
    if ("iPProtocol".equals(fieldName)) {
      return iPProtocol;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("ipVersion".equals(fieldName)) {
      return ipVersion;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("loadBalancingScheme".equals(fieldName)) {
      return loadBalancingScheme;
    }
    if ("metadataFilters".equals(fieldName)) {
      return metadataFilters;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("networkTier".equals(fieldName)) {
      return networkTier;
    }
    if ("portRange".equals(fieldName)) {
      return portRange;
    }
    if ("ports".equals(fieldName)) {
      return ports;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("serviceLabel".equals(fieldName)) {
      return serviceLabel;
    }
    if ("serviceName".equals(fieldName)) {
      return serviceName;
    }
    if ("subnetwork".equals(fieldName)) {
      return subnetwork;
    }
    if ("target".equals(fieldName)) {
      return target;
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
   * This field is used along with the backend_service field for internal load balancing or with the
   * target field for internal TargetInstance. This field cannot be used with port or portRange
   * fields.
   *
   * <p>When the load balancing scheme is INTERNAL and protocol is TCP/UDP, specify this field to
   * allow packets addressed to any ports will be forwarded to the backends configured with this
   * forwarding rule.
   */
  public Boolean getAllPorts() {
    return allPorts;
  }

  /**
   * This field is only used for INTERNAL load balancing.
   *
   * <p>For internal load balancing, this field identifies the BackendService resource to receive
   * the matched traffic.
   */
  public String getBackendService() {
    return backendService;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * IP address that this forwarding rule serves. When a client sends traffic to this IP address,
   * the forwarding rule directs the traffic to the target that you specify in the forwarding rule.
   *
   * <p>If you don't specify a reserved IP address, an ephemeral IP address is assigned. Methods for
   * specifying an IP address:
   *
   * <p>&#42; IPv4 dotted decimal, as in `100.1.2.3` &#42; Full URL, as in
   * https://www.googleapis.com/compute/v1/projects/project_id/regions/region/addresses/address-name
   * &#42; Partial URL or by name, as in: &#42;
   * projects/project_id/regions/region/addresses/address-name &#42;
   * regions/region/addresses/address-name &#42; global/addresses/address-name &#42; address-name
   *
   * <p>The loadBalancingScheme and the forwarding rule's target determine the type of IP address
   * that you can use. For detailed information, refer to [IP address
   * specifications](/load-balancing/docs/forwarding-rule-concepts#ip_address_specifications).
   */
  public String getIPAddress() {
    return iPAddress;
  }

  /**
   * The IP protocol to which this rule applies. Valid options are TCP, UDP, ESP, AH, SCTP or ICMP.
   *
   * <p>When the load balancing scheme is INTERNAL, only TCP and UDP are valid. When the load
   * balancing scheme is INTERNAL_SELF_MANAGED, only TCPis valid.
   */
  public String getIPProtocol() {
    return iPProtocol;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * The IP Version that will be used by this forwarding rule. Valid options are IPV4 or IPV6. This
   * can only be specified for an external global forwarding rule.
   */
  public String getIpVersion() {
    return ipVersion;
  }

  /**
   * [Output Only] Type of the resource. Always compute#forwardingRule for Forwarding Rule
   * resources.
   */
  public String getKind() {
    return kind;
  }

  /**
   * This signifies what the ForwardingRule will be used for and can only take the following values:
   * INTERNAL, INTERNAL_SELF_MANAGED, EXTERNAL. The value of INTERNAL means that this will be used
   * for Internal Network Load Balancing (TCP, UDP). The value of INTERNAL_SELF_MANAGED means that
   * this will be used for Internal Global HTTP(S) LB. The value of EXTERNAL means that this will be
   * used for External Load Balancing (HTTP(S) LB, External TCP/UDP LB, SSL Proxy)
   */
  public String getLoadBalancingScheme() {
    return loadBalancingScheme;
  }

  /**
   * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited set
   * xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
   * metadata. If a match takes place, the relevant routing configuration is made available to those
   * proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to MATCH_ANY,
   * at least one of the filterLabels must match the corresponding label provided in the metadata.
   * If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels must match with
   * corresponding labels in the provided metadata. metadataFilters specified here can be overridden
   * by those specified in the UrlMap that this ForwardingRule references. metadataFilters only
   * applies to Loadbalancers that have their loadBalancingScheme set to INTERNAL_SELF_MANAGED.
   */
  public List<MetadataFilter> getMetadataFiltersList() {
    return metadataFilters;
  }

  /**
   * Name of the resource; provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * This field is not used for external load balancing.
   *
   * <p>For INTERNAL and INTERNAL_SELF_MANAGED load balancing, this field identifies the network
   * that the load balanced IP should belong to for this Forwarding Rule. If this field is not
   * specified, the default network will be used.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * This signifies the networking tier used for configuring this load balancer and can only take
   * the following values: PREMIUM , STANDARD.
   *
   * <p>For regional ForwardingRule, the valid values are PREMIUM and STANDARD. For
   * GlobalForwardingRule, the valid value is PREMIUM.
   *
   * <p>If this field is not specified, it is assumed to be PREMIUM. If IPAddress is specified, this
   * value must be equal to the networkTier of the Address.
   */
  public String getNetworkTier() {
    return networkTier;
  }

  /** This field is deprecated. See the port field. */
  public String getPortRange() {
    return portRange;
  }

  /**
   * List of comma-separated ports. The forwarding rule forwards packets with matching destination
   * ports. If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
   * references a target pool, specifying ports is optional. You can specify an unlimited number of
   * ports, but they must be contiguous. If you omit ports, GCP forwards traffic on any port of the
   * forwarding rule's protocol.
   *
   * <p>If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule references
   * a target HTTP proxy, target HTTPS proxy, target TCP proxy, target SSL proxy, or target VPN
   * gateway, you must specify ports using the following constraints:
   *
   * <p>- TargetHttpProxy: 80, 8080 - TargetHttpsProxy: 443 - TargetTcpProxy: 25, 43, 110, 143, 195,
   * 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetSslProxy: 25, 43, 110, 143, 195, 443,
   * 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetVpnGateway: 500, 4500
   *
   * <p>If the forwarding rule's loadBalancingScheme is INTERNAL, you must specify ports in one of
   * the following ways:
   *
   * <p>&#42; A list of up to five ports, which can be non-contiguous &#42; Keyword ALL, which
   * causes the forwarding rule to forward traffic on any port of the forwarding rule's protocol.
   *
   * <p>The ports field is used along with the target field for TargetHttpProxy, TargetHttpsProxy,
   * TargetSslProxy, TargetTcpProxy, TargetVpnGateway, TargetPool, TargetInstance.
   *
   * <p>Applicable only when IPProtocol is TCP, UDP, or SCTP. Forwarding rules with the same
   * [IPAddress, IPProtocol] pair must have disjoint port ranges.
   */
  public List<String> getPortsList() {
    return ports;
  }

  /**
   * [Output Only] URL of the region where the regional forwarding rule resides. This field is not
   * applicable to global forwarding rules. You must specify this field as part of the HTTP request
   * URL. It is not settable as a field in the request body.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * An optional prefix to the service name for this Forwarding Rule. If specified, the prefix is
   * the first label of the fully qualified service name.
   *
   * <p>The label must be 1-63 characters long, and comply with RFC1035. Specifically, the label
   * must be 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   *
   * <p>This field is only used for internal load balancing.
   */
  public String getServiceLabel() {
    return serviceLabel;
  }

  /**
   * [Output Only] The internal fully qualified service name for this Forwarding Rule.
   *
   * <p>This field is only used for internal load balancing.
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * This field is only used for INTERNAL load balancing.
   *
   * <p>For internal load balancing, this field identifies the subnetwork that the load balanced IP
   * should belong to for this Forwarding Rule.
   *
   * <p>If the network specified is in auto subnet mode, this field is optional. However, if the
   * network is in custom subnet mode, a subnetwork must be specified.
   */
  public String getSubnetwork() {
    return subnetwork;
  }

  /**
   * The URL of the target resource to receive the matched traffic. For regional forwarding rules,
   * this target must live in the same region as the forwarding rule. For global forwarding rules,
   * this target must be a global load balancing resource. The forwarded traffic must be of a type
   * appropriate to the target object. For INTERNAL_SELF_MANAGED load balancing, only HTTP and HTTPS
   * targets are valid.
   */
  public String getTarget() {
    return target;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ForwardingRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ForwardingRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ForwardingRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ForwardingRule();
  }

  public static class Builder {
    private Boolean allPorts;
    private String backendService;
    private String creationTimestamp;
    private String description;
    private String iPAddress;
    private String iPProtocol;
    private String id;
    private String ipVersion;
    private String kind;
    private String loadBalancingScheme;
    private List<MetadataFilter> metadataFilters;
    private String name;
    private String network;
    private String networkTier;
    private String portRange;
    private List<String> ports;
    private String region;
    private String selfLink;
    private String serviceLabel;
    private String serviceName;
    private String subnetwork;
    private String target;

    Builder() {}

    public Builder mergeFrom(ForwardingRule other) {
      if (other == ForwardingRule.getDefaultInstance()) return this;
      if (other.getAllPorts() != null) {
        this.allPorts = other.allPorts;
      }
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getIPAddress() != null) {
        this.iPAddress = other.iPAddress;
      }
      if (other.getIPProtocol() != null) {
        this.iPProtocol = other.iPProtocol;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIpVersion() != null) {
        this.ipVersion = other.ipVersion;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLoadBalancingScheme() != null) {
        this.loadBalancingScheme = other.loadBalancingScheme;
      }
      if (other.getMetadataFiltersList() != null) {
        this.metadataFilters = other.metadataFilters;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getNetworkTier() != null) {
        this.networkTier = other.networkTier;
      }
      if (other.getPortRange() != null) {
        this.portRange = other.portRange;
      }
      if (other.getPortsList() != null) {
        this.ports = other.ports;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getServiceLabel() != null) {
        this.serviceLabel = other.serviceLabel;
      }
      if (other.getServiceName() != null) {
        this.serviceName = other.serviceName;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      return this;
    }

    Builder(ForwardingRule source) {
      this.allPorts = source.allPorts;
      this.backendService = source.backendService;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.iPAddress = source.iPAddress;
      this.iPProtocol = source.iPProtocol;
      this.id = source.id;
      this.ipVersion = source.ipVersion;
      this.kind = source.kind;
      this.loadBalancingScheme = source.loadBalancingScheme;
      this.metadataFilters = source.metadataFilters;
      this.name = source.name;
      this.network = source.network;
      this.networkTier = source.networkTier;
      this.portRange = source.portRange;
      this.ports = source.ports;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.serviceLabel = source.serviceLabel;
      this.serviceName = source.serviceName;
      this.subnetwork = source.subnetwork;
      this.target = source.target;
    }

    /**
     * This field is used along with the backend_service field for internal load balancing or with
     * the target field for internal TargetInstance. This field cannot be used with port or
     * portRange fields.
     *
     * <p>When the load balancing scheme is INTERNAL and protocol is TCP/UDP, specify this field to
     * allow packets addressed to any ports will be forwarded to the backends configured with this
     * forwarding rule.
     */
    public Boolean getAllPorts() {
      return allPorts;
    }

    /**
     * This field is used along with the backend_service field for internal load balancing or with
     * the target field for internal TargetInstance. This field cannot be used with port or
     * portRange fields.
     *
     * <p>When the load balancing scheme is INTERNAL and protocol is TCP/UDP, specify this field to
     * allow packets addressed to any ports will be forwarded to the backends configured with this
     * forwarding rule.
     */
    public Builder setAllPorts(Boolean allPorts) {
      this.allPorts = allPorts;
      return this;
    }

    /**
     * This field is only used for INTERNAL load balancing.
     *
     * <p>For internal load balancing, this field identifies the BackendService resource to receive
     * the matched traffic.
     */
    public String getBackendService() {
      return backendService;
    }

    /**
     * This field is only used for INTERNAL load balancing.
     *
     * <p>For internal load balancing, this field identifies the BackendService resource to receive
     * the matched traffic.
     */
    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
      return this;
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
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * IP address that this forwarding rule serves. When a client sends traffic to this IP address,
     * the forwarding rule directs the traffic to the target that you specify in the forwarding
     * rule.
     *
     * <p>If you don't specify a reserved IP address, an ephemeral IP address is assigned. Methods
     * for specifying an IP address:
     *
     * <p>&#42; IPv4 dotted decimal, as in `100.1.2.3` &#42; Full URL, as in
     * https://www.googleapis.com/compute/v1/projects/project_id/regions/region/addresses/address-name
     * &#42; Partial URL or by name, as in: &#42;
     * projects/project_id/regions/region/addresses/address-name &#42;
     * regions/region/addresses/address-name &#42; global/addresses/address-name &#42; address-name
     *
     * <p>The loadBalancingScheme and the forwarding rule's target determine the type of IP address
     * that you can use. For detailed information, refer to [IP address
     * specifications](/load-balancing/docs/forwarding-rule-concepts#ip_address_specifications).
     */
    public String getIPAddress() {
      return iPAddress;
    }

    /**
     * IP address that this forwarding rule serves. When a client sends traffic to this IP address,
     * the forwarding rule directs the traffic to the target that you specify in the forwarding
     * rule.
     *
     * <p>If you don't specify a reserved IP address, an ephemeral IP address is assigned. Methods
     * for specifying an IP address:
     *
     * <p>&#42; IPv4 dotted decimal, as in `100.1.2.3` &#42; Full URL, as in
     * https://www.googleapis.com/compute/v1/projects/project_id/regions/region/addresses/address-name
     * &#42; Partial URL or by name, as in: &#42;
     * projects/project_id/regions/region/addresses/address-name &#42;
     * regions/region/addresses/address-name &#42; global/addresses/address-name &#42; address-name
     *
     * <p>The loadBalancingScheme and the forwarding rule's target determine the type of IP address
     * that you can use. For detailed information, refer to [IP address
     * specifications](/load-balancing/docs/forwarding-rule-concepts#ip_address_specifications).
     */
    public Builder setIPAddress(String iPAddress) {
      this.iPAddress = iPAddress;
      return this;
    }

    /**
     * The IP protocol to which this rule applies. Valid options are TCP, UDP, ESP, AH, SCTP or
     * ICMP.
     *
     * <p>When the load balancing scheme is INTERNAL, only TCP and UDP are valid. When the load
     * balancing scheme is INTERNAL_SELF_MANAGED, only TCPis valid.
     */
    public String getIPProtocol() {
      return iPProtocol;
    }

    /**
     * The IP protocol to which this rule applies. Valid options are TCP, UDP, ESP, AH, SCTP or
     * ICMP.
     *
     * <p>When the load balancing scheme is INTERNAL, only TCP and UDP are valid. When the load
     * balancing scheme is INTERNAL_SELF_MANAGED, only TCPis valid.
     */
    public Builder setIPProtocol(String iPProtocol) {
      this.iPProtocol = iPProtocol;
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
     * The IP Version that will be used by this forwarding rule. Valid options are IPV4 or IPV6.
     * This can only be specified for an external global forwarding rule.
     */
    public String getIpVersion() {
      return ipVersion;
    }

    /**
     * The IP Version that will be used by this forwarding rule. Valid options are IPV4 or IPV6.
     * This can only be specified for an external global forwarding rule.
     */
    public Builder setIpVersion(String ipVersion) {
      this.ipVersion = ipVersion;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#forwardingRule for Forwarding Rule
     * resources.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#forwardingRule for Forwarding Rule
     * resources.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * This signifies what the ForwardingRule will be used for and can only take the following
     * values: INTERNAL, INTERNAL_SELF_MANAGED, EXTERNAL. The value of INTERNAL means that this will
     * be used for Internal Network Load Balancing (TCP, UDP). The value of INTERNAL_SELF_MANAGED
     * means that this will be used for Internal Global HTTP(S) LB. The value of EXTERNAL means that
     * this will be used for External Load Balancing (HTTP(S) LB, External TCP/UDP LB, SSL Proxy)
     */
    public String getLoadBalancingScheme() {
      return loadBalancingScheme;
    }

    /**
     * This signifies what the ForwardingRule will be used for and can only take the following
     * values: INTERNAL, INTERNAL_SELF_MANAGED, EXTERNAL. The value of INTERNAL means that this will
     * be used for Internal Network Load Balancing (TCP, UDP). The value of INTERNAL_SELF_MANAGED
     * means that this will be used for Internal Global HTTP(S) LB. The value of EXTERNAL means that
     * this will be used for External Load Balancing (HTTP(S) LB, External TCP/UDP LB, SSL Proxy)
     */
    public Builder setLoadBalancingScheme(String loadBalancingScheme) {
      this.loadBalancingScheme = loadBalancingScheme;
      return this;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overridden by those specified in the UrlMap that this ForwardingRule references.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public List<MetadataFilter> getMetadataFiltersList() {
      return metadataFilters;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overridden by those specified in the UrlMap that this ForwardingRule references.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public Builder addAllMetadataFilters(List<MetadataFilter> metadataFilters) {
      if (this.metadataFilters == null) {
        this.metadataFilters = new LinkedList<>();
      }
      this.metadataFilters.addAll(metadataFilters);
      return this;
    }

    /**
     * Opaque filter criteria used by Loadbalancer to restrict routing configuration to a limited
     * set xDS compliant clients. In their xDS requests to Loadbalancer, xDS clients present node
     * metadata. If a match takes place, the relevant routing configuration is made available to
     * those proxies. For each metadataFilter in this list, if its filterMatchCriteria is set to
     * MATCH_ANY, at least one of the filterLabels must match the corresponding label provided in
     * the metadata. If its filterMatchCriteria is set to MATCH_ALL, then all of its filterLabels
     * must match with corresponding labels in the provided metadata. metadataFilters specified here
     * can be overridden by those specified in the UrlMap that this ForwardingRule references.
     * metadataFilters only applies to Loadbalancers that have their loadBalancingScheme set to
     * INTERNAL_SELF_MANAGED.
     */
    public Builder addMetadataFilters(MetadataFilter metadataFilters) {
      if (this.metadataFilters == null) {
        this.metadataFilters = new LinkedList<>();
      }
      this.metadataFilters.add(metadataFilters);
      return this;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * This field is not used for external load balancing.
     *
     * <p>For INTERNAL and INTERNAL_SELF_MANAGED load balancing, this field identifies the network
     * that the load balanced IP should belong to for this Forwarding Rule. If this field is not
     * specified, the default network will be used.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * This field is not used for external load balancing.
     *
     * <p>For INTERNAL and INTERNAL_SELF_MANAGED load balancing, this field identifies the network
     * that the load balanced IP should belong to for this Forwarding Rule. If this field is not
     * specified, the default network will be used.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * This signifies the networking tier used for configuring this load balancer and can only take
     * the following values: PREMIUM , STANDARD.
     *
     * <p>For regional ForwardingRule, the valid values are PREMIUM and STANDARD. For
     * GlobalForwardingRule, the valid value is PREMIUM.
     *
     * <p>If this field is not specified, it is assumed to be PREMIUM. If IPAddress is specified,
     * this value must be equal to the networkTier of the Address.
     */
    public String getNetworkTier() {
      return networkTier;
    }

    /**
     * This signifies the networking tier used for configuring this load balancer and can only take
     * the following values: PREMIUM , STANDARD.
     *
     * <p>For regional ForwardingRule, the valid values are PREMIUM and STANDARD. For
     * GlobalForwardingRule, the valid value is PREMIUM.
     *
     * <p>If this field is not specified, it is assumed to be PREMIUM. If IPAddress is specified,
     * this value must be equal to the networkTier of the Address.
     */
    public Builder setNetworkTier(String networkTier) {
      this.networkTier = networkTier;
      return this;
    }

    /** This field is deprecated. See the port field. */
    public String getPortRange() {
      return portRange;
    }

    /** This field is deprecated. See the port field. */
    public Builder setPortRange(String portRange) {
      this.portRange = portRange;
      return this;
    }

    /**
     * List of comma-separated ports. The forwarding rule forwards packets with matching destination
     * ports. If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target pool, specifying ports is optional. You can specify an unlimited number
     * of ports, but they must be contiguous. If you omit ports, GCP forwards traffic on any port of
     * the forwarding rule's protocol.
     *
     * <p>If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target HTTP proxy, target HTTPS proxy, target TCP proxy, target SSL proxy, or
     * target VPN gateway, you must specify ports using the following constraints:
     *
     * <p>- TargetHttpProxy: 80, 8080 - TargetHttpsProxy: 443 - TargetTcpProxy: 25, 43, 110, 143,
     * 195, 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetSslProxy: 25, 43, 110, 143, 195,
     * 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetVpnGateway: 500, 4500
     *
     * <p>If the forwarding rule's loadBalancingScheme is INTERNAL, you must specify ports in one of
     * the following ways:
     *
     * <p>&#42; A list of up to five ports, which can be non-contiguous &#42; Keyword ALL, which
     * causes the forwarding rule to forward traffic on any port of the forwarding rule's protocol.
     *
     * <p>The ports field is used along with the target field for TargetHttpProxy, TargetHttpsProxy,
     * TargetSslProxy, TargetTcpProxy, TargetVpnGateway, TargetPool, TargetInstance.
     *
     * <p>Applicable only when IPProtocol is TCP, UDP, or SCTP. Forwarding rules with the same
     * [IPAddress, IPProtocol] pair must have disjoint port ranges.
     */
    public List<String> getPortsList() {
      return ports;
    }

    /**
     * List of comma-separated ports. The forwarding rule forwards packets with matching destination
     * ports. If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target pool, specifying ports is optional. You can specify an unlimited number
     * of ports, but they must be contiguous. If you omit ports, GCP forwards traffic on any port of
     * the forwarding rule's protocol.
     *
     * <p>If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target HTTP proxy, target HTTPS proxy, target TCP proxy, target SSL proxy, or
     * target VPN gateway, you must specify ports using the following constraints:
     *
     * <p>- TargetHttpProxy: 80, 8080 - TargetHttpsProxy: 443 - TargetTcpProxy: 25, 43, 110, 143,
     * 195, 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetSslProxy: 25, 43, 110, 143, 195,
     * 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetVpnGateway: 500, 4500
     *
     * <p>If the forwarding rule's loadBalancingScheme is INTERNAL, you must specify ports in one of
     * the following ways:
     *
     * <p>&#42; A list of up to five ports, which can be non-contiguous &#42; Keyword ALL, which
     * causes the forwarding rule to forward traffic on any port of the forwarding rule's protocol.
     *
     * <p>The ports field is used along with the target field for TargetHttpProxy, TargetHttpsProxy,
     * TargetSslProxy, TargetTcpProxy, TargetVpnGateway, TargetPool, TargetInstance.
     *
     * <p>Applicable only when IPProtocol is TCP, UDP, or SCTP. Forwarding rules with the same
     * [IPAddress, IPProtocol] pair must have disjoint port ranges.
     */
    public Builder addAllPorts(List<String> ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.addAll(ports);
      return this;
    }

    /**
     * List of comma-separated ports. The forwarding rule forwards packets with matching destination
     * ports. If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target pool, specifying ports is optional. You can specify an unlimited number
     * of ports, but they must be contiguous. If you omit ports, GCP forwards traffic on any port of
     * the forwarding rule's protocol.
     *
     * <p>If the forwarding rule's loadBalancingScheme is EXTERNAL, and the forwarding rule
     * references a target HTTP proxy, target HTTPS proxy, target TCP proxy, target SSL proxy, or
     * target VPN gateway, you must specify ports using the following constraints:
     *
     * <p>- TargetHttpProxy: 80, 8080 - TargetHttpsProxy: 443 - TargetTcpProxy: 25, 43, 110, 143,
     * 195, 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetSslProxy: 25, 43, 110, 143, 195,
     * 443, 465, 587, 700, 993, 995, 1688, 1883, 5222 - TargetVpnGateway: 500, 4500
     *
     * <p>If the forwarding rule's loadBalancingScheme is INTERNAL, you must specify ports in one of
     * the following ways:
     *
     * <p>&#42; A list of up to five ports, which can be non-contiguous &#42; Keyword ALL, which
     * causes the forwarding rule to forward traffic on any port of the forwarding rule's protocol.
     *
     * <p>The ports field is used along with the target field for TargetHttpProxy, TargetHttpsProxy,
     * TargetSslProxy, TargetTcpProxy, TargetVpnGateway, TargetPool, TargetInstance.
     *
     * <p>Applicable only when IPProtocol is TCP, UDP, or SCTP. Forwarding rules with the same
     * [IPAddress, IPProtocol] pair must have disjoint port ranges.
     */
    public Builder addPorts(String ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.add(ports);
      return this;
    }

    /**
     * [Output Only] URL of the region where the regional forwarding rule resides. This field is not
     * applicable to global forwarding rules. You must specify this field as part of the HTTP
     * request URL. It is not settable as a field in the request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the regional forwarding rule resides. This field is not
     * applicable to global forwarding rules. You must specify this field as part of the HTTP
     * request URL. It is not settable as a field in the request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
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

    /**
     * An optional prefix to the service name for this Forwarding Rule. If specified, the prefix is
     * the first label of the fully qualified service name.
     *
     * <p>The label must be 1-63 characters long, and comply with RFC1035. Specifically, the label
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     *
     * <p>This field is only used for internal load balancing.
     */
    public String getServiceLabel() {
      return serviceLabel;
    }

    /**
     * An optional prefix to the service name for this Forwarding Rule. If specified, the prefix is
     * the first label of the fully qualified service name.
     *
     * <p>The label must be 1-63 characters long, and comply with RFC1035. Specifically, the label
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     *
     * <p>This field is only used for internal load balancing.
     */
    public Builder setServiceLabel(String serviceLabel) {
      this.serviceLabel = serviceLabel;
      return this;
    }

    /**
     * [Output Only] The internal fully qualified service name for this Forwarding Rule.
     *
     * <p>This field is only used for internal load balancing.
     */
    public String getServiceName() {
      return serviceName;
    }

    /**
     * [Output Only] The internal fully qualified service name for this Forwarding Rule.
     *
     * <p>This field is only used for internal load balancing.
     */
    public Builder setServiceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * This field is only used for INTERNAL load balancing.
     *
     * <p>For internal load balancing, this field identifies the subnetwork that the load balanced
     * IP should belong to for this Forwarding Rule.
     *
     * <p>If the network specified is in auto subnet mode, this field is optional. However, if the
     * network is in custom subnet mode, a subnetwork must be specified.
     */
    public String getSubnetwork() {
      return subnetwork;
    }

    /**
     * This field is only used for INTERNAL load balancing.
     *
     * <p>For internal load balancing, this field identifies the subnetwork that the load balanced
     * IP should belong to for this Forwarding Rule.
     *
     * <p>If the network specified is in auto subnet mode, this field is optional. However, if the
     * network is in custom subnet mode, a subnetwork must be specified.
     */
    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    /**
     * The URL of the target resource to receive the matched traffic. For regional forwarding rules,
     * this target must live in the same region as the forwarding rule. For global forwarding rules,
     * this target must be a global load balancing resource. The forwarded traffic must be of a type
     * appropriate to the target object. For INTERNAL_SELF_MANAGED load balancing, only HTTP and
     * HTTPS targets are valid.
     */
    public String getTarget() {
      return target;
    }

    /**
     * The URL of the target resource to receive the matched traffic. For regional forwarding rules,
     * this target must live in the same region as the forwarding rule. For global forwarding rules,
     * this target must be a global load balancing resource. The forwarded traffic must be of a type
     * appropriate to the target object. For INTERNAL_SELF_MANAGED load balancing, only HTTP and
     * HTTPS targets are valid.
     */
    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    public ForwardingRule build() {

      return new ForwardingRule(
          allPorts,
          backendService,
          creationTimestamp,
          description,
          iPAddress,
          iPProtocol,
          id,
          ipVersion,
          kind,
          loadBalancingScheme,
          metadataFilters,
          name,
          network,
          networkTier,
          portRange,
          ports,
          region,
          selfLink,
          serviceLabel,
          serviceName,
          subnetwork,
          target);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAllPorts(this.allPorts);
      newBuilder.setBackendService(this.backendService);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setIPAddress(this.iPAddress);
      newBuilder.setIPProtocol(this.iPProtocol);
      newBuilder.setId(this.id);
      newBuilder.setIpVersion(this.ipVersion);
      newBuilder.setKind(this.kind);
      newBuilder.setLoadBalancingScheme(this.loadBalancingScheme);
      newBuilder.addAllMetadataFilters(this.metadataFilters);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkTier(this.networkTier);
      newBuilder.setPortRange(this.portRange);
      newBuilder.addAllPorts(this.ports);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setServiceLabel(this.serviceLabel);
      newBuilder.setServiceName(this.serviceName);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setTarget(this.target);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ForwardingRule{"
        + "allPorts="
        + allPorts
        + ", "
        + "backendService="
        + backendService
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "iPAddress="
        + iPAddress
        + ", "
        + "iPProtocol="
        + iPProtocol
        + ", "
        + "id="
        + id
        + ", "
        + "ipVersion="
        + ipVersion
        + ", "
        + "kind="
        + kind
        + ", "
        + "loadBalancingScheme="
        + loadBalancingScheme
        + ", "
        + "metadataFilters="
        + metadataFilters
        + ", "
        + "name="
        + name
        + ", "
        + "network="
        + network
        + ", "
        + "networkTier="
        + networkTier
        + ", "
        + "portRange="
        + portRange
        + ", "
        + "ports="
        + ports
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "serviceLabel="
        + serviceLabel
        + ", "
        + "serviceName="
        + serviceName
        + ", "
        + "subnetwork="
        + subnetwork
        + ", "
        + "target="
        + target
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ForwardingRule) {
      ForwardingRule that = (ForwardingRule) o;
      return Objects.equals(this.allPorts, that.getAllPorts())
          && Objects.equals(this.backendService, that.getBackendService())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.iPAddress, that.getIPAddress())
          && Objects.equals(this.iPProtocol, that.getIPProtocol())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ipVersion, that.getIpVersion())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.loadBalancingScheme, that.getLoadBalancingScheme())
          && Objects.equals(this.metadataFilters, that.getMetadataFiltersList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkTier, that.getNetworkTier())
          && Objects.equals(this.portRange, that.getPortRange())
          && Objects.equals(this.ports, that.getPortsList())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.serviceLabel, that.getServiceLabel())
          && Objects.equals(this.serviceName, that.getServiceName())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.target, that.getTarget());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        allPorts,
        backendService,
        creationTimestamp,
        description,
        iPAddress,
        iPProtocol,
        id,
        ipVersion,
        kind,
        loadBalancingScheme,
        metadataFilters,
        name,
        network,
        networkTier,
        portRange,
        ports,
        region,
        selfLink,
        serviceLabel,
        serviceName,
        subnetwork,
        target);
  }
}
