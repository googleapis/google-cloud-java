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
/** Represents a Firewall resource. */
public final class Firewall implements ApiMessage {
  private final List<Allowed> allowed;
  private final String creationTimestamp;
  private final List<Denied> denied;
  private final String description;
  private final List<String> destinationRanges;
  private final String direction;
  private final Boolean disabled;
  private final String id;
  private final String kind;
  private final FirewallLogConfig logConfig;
  private final String name;
  private final String network;
  private final Integer priority;
  private final String selfLink;
  private final List<String> sourceRanges;
  private final List<String> sourceServiceAccounts;
  private final List<String> sourceTags;
  private final List<String> targetServiceAccounts;
  private final List<String> targetTags;

  private Firewall() {
    this.allowed = null;
    this.creationTimestamp = null;
    this.denied = null;
    this.description = null;
    this.destinationRanges = null;
    this.direction = null;
    this.disabled = null;
    this.id = null;
    this.kind = null;
    this.logConfig = null;
    this.name = null;
    this.network = null;
    this.priority = null;
    this.selfLink = null;
    this.sourceRanges = null;
    this.sourceServiceAccounts = null;
    this.sourceTags = null;
    this.targetServiceAccounts = null;
    this.targetTags = null;
  }

  private Firewall(
      List<Allowed> allowed,
      String creationTimestamp,
      List<Denied> denied,
      String description,
      List<String> destinationRanges,
      String direction,
      Boolean disabled,
      String id,
      String kind,
      FirewallLogConfig logConfig,
      String name,
      String network,
      Integer priority,
      String selfLink,
      List<String> sourceRanges,
      List<String> sourceServiceAccounts,
      List<String> sourceTags,
      List<String> targetServiceAccounts,
      List<String> targetTags) {
    this.allowed = allowed;
    this.creationTimestamp = creationTimestamp;
    this.denied = denied;
    this.description = description;
    this.destinationRanges = destinationRanges;
    this.direction = direction;
    this.disabled = disabled;
    this.id = id;
    this.kind = kind;
    this.logConfig = logConfig;
    this.name = name;
    this.network = network;
    this.priority = priority;
    this.selfLink = selfLink;
    this.sourceRanges = sourceRanges;
    this.sourceServiceAccounts = sourceServiceAccounts;
    this.sourceTags = sourceTags;
    this.targetServiceAccounts = targetServiceAccounts;
    this.targetTags = targetTags;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("allowed".equals(fieldName)) {
      return allowed;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("denied".equals(fieldName)) {
      return denied;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("destinationRanges".equals(fieldName)) {
      return destinationRanges;
    }
    if ("direction".equals(fieldName)) {
      return direction;
    }
    if ("disabled".equals(fieldName)) {
      return disabled;
    }
    if ("id".equals(fieldName)) {
      return id;
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
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sourceRanges".equals(fieldName)) {
      return sourceRanges;
    }
    if ("sourceServiceAccounts".equals(fieldName)) {
      return sourceServiceAccounts;
    }
    if ("sourceTags".equals(fieldName)) {
      return sourceTags;
    }
    if ("targetServiceAccounts".equals(fieldName)) {
      return targetServiceAccounts;
    }
    if ("targetTags".equals(fieldName)) {
      return targetTags;
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
   * The list of ALLOW rules specified by this firewall. Each rule specifies a protocol and
   * port-range tuple that describes a permitted connection.
   */
  public List<Allowed> getAllowedList() {
    return allowed;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * The list of DENY rules specified by this firewall. Each rule specifies a protocol and
   * port-range tuple that describes a denied connection.
   */
  public List<Denied> getDeniedList() {
    return denied;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * If destination ranges are specified, the firewall will apply only to traffic that has
   * destination IP address in these ranges. These ranges must be expressed in CIDR format. Only
   * IPv4 is supported.
   */
  public List<String> getDestinationRangesList() {
    return destinationRanges;
  }

  /**
   * Direction of traffic to which this firewall applies; default is INGRESS. Note: For INGRESS
   * traffic, it is NOT supported to specify destinationRanges; For EGRESS traffic, it is NOT
   * supported to specify sourceRanges OR sourceTags.
   */
  public String getDirection() {
    return direction;
  }

  /**
   * Denotes whether the firewall rule is disabled, i.e not applied to the network it is associated
   * with. When set to true, the firewall rule is not enforced and the network behaves as if it did
   * not exist. If this is unspecified, the firewall rule will be enabled.
   */
  public Boolean getDisabled() {
    return disabled;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#firewall for firewall rules. */
  public String getKind() {
    return kind;
  }

  /**
   * This field denotes the logging options for a particular firewall rule. If logging is enabled,
   * logs will be exported to Stackdriver.
   */
  public FirewallLogConfig getLogConfig() {
    return logConfig;
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
   * URL of the network resource for this firewall rule. If not specified when creating a firewall
   * rule, the default network is used: global/networks/default If you choose to specify this
   * property, you can specify the network as a full or partial URL. For example, the following are
   * all valid URLs: -
   * https://www.googleapis.com/compute/v1/projects/myproject/global/networks/my-network -
   * projects/myproject/global/networks/my-network - global/networks/default
   */
  public String getNetwork() {
    return network;
  }

  /**
   * Priority for this rule. This is an integer between 0 and 65535, both inclusive. When not
   * specified, the value assumed is 1000. Relative priorities determine precedence of conflicting
   * rules. Lower value of priority implies higher precedence (eg, a rule with priority 0 has higher
   * precedence than a rule with priority 1). DENY rules take precedence over ALLOW rules having
   * equal priority.
   */
  public Integer getPriority() {
    return priority;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * If source ranges are specified, the firewall will apply only to traffic that has source IP
   * address in these ranges. These ranges must be expressed in CIDR format. One or both of
   * sourceRanges and sourceTags may be set. If both properties are set, the firewall will apply to
   * traffic that has source IP address within sourceRanges OR the source IP that belongs to a tag
   * listed in the sourceTags property. The connection does not need to match both properties for
   * the firewall to apply. Only IPv4 is supported.
   */
  public List<String> getSourceRangesList() {
    return sourceRanges;
  }

  /**
   * If source service accounts are specified, the firewall will apply only to traffic originating
   * from an instance with a service account in this list. Source service accounts cannot be used to
   * control traffic to an instance's external IP address because service accounts are associated
   * with an instance, not an IP address. sourceRanges can be set at the same time as
   * sourceServiceAccounts. If both are set, the firewall will apply to traffic that has source IP
   * address within sourceRanges OR the source IP belongs to an instance with service account listed
   * in sourceServiceAccount. The connection does not need to match both properties for the firewall
   * to apply. sourceServiceAccounts cannot be used at the same time as sourceTags or targetTags.
   */
  public List<String> getSourceServiceAccountsList() {
    return sourceServiceAccounts;
  }

  /**
   * If source tags are specified, the firewall rule applies only to traffic with source IPs that
   * match the primary network interfaces of VM instances that have the tag and are in the same VPC
   * network. Source tags cannot be used to control traffic to an instance's external IP address, it
   * only applies to traffic between instances in the same virtual network. Because tags are
   * associated with instances, not IP addresses. One or both of sourceRanges and sourceTags may be
   * set. If both properties are set, the firewall will apply to traffic that has source IP address
   * within sourceRanges OR the source IP that belongs to a tag listed in the sourceTags property.
   * The connection does not need to match both properties for the firewall to apply.
   */
  public List<String> getSourceTagsList() {
    return sourceTags;
  }

  /**
   * A list of service accounts indicating sets of instances located in the network that may make
   * network connections as specified in allowed[]. targetServiceAccounts cannot be used at the same
   * time as targetTags or sourceTags. If neither targetServiceAccounts nor targetTags are
   * specified, the firewall rule applies to all instances on the specified network.
   */
  public List<String> getTargetServiceAccountsList() {
    return targetServiceAccounts;
  }

  /**
   * A list of tags that controls which instances the firewall rule applies to. If targetTags are
   * specified, then the firewall rule applies only to instances in the VPC network that have one of
   * those tags. If no targetTags are specified, the firewall rule applies to all instances on the
   * specified network.
   */
  public List<String> getTargetTagsList() {
    return targetTags;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Firewall prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Firewall getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Firewall DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Firewall();
  }

  public static class Builder {
    private List<Allowed> allowed;
    private String creationTimestamp;
    private List<Denied> denied;
    private String description;
    private List<String> destinationRanges;
    private String direction;
    private Boolean disabled;
    private String id;
    private String kind;
    private FirewallLogConfig logConfig;
    private String name;
    private String network;
    private Integer priority;
    private String selfLink;
    private List<String> sourceRanges;
    private List<String> sourceServiceAccounts;
    private List<String> sourceTags;
    private List<String> targetServiceAccounts;
    private List<String> targetTags;

    Builder() {}

    public Builder mergeFrom(Firewall other) {
      if (other == Firewall.getDefaultInstance()) return this;
      if (other.getAllowedList() != null) {
        this.allowed = other.allowed;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeniedList() != null) {
        this.denied = other.denied;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDestinationRangesList() != null) {
        this.destinationRanges = other.destinationRanges;
      }
      if (other.getDirection() != null) {
        this.direction = other.direction;
      }
      if (other.getDisabled() != null) {
        this.disabled = other.disabled;
      }
      if (other.getId() != null) {
        this.id = other.id;
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
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSourceRangesList() != null) {
        this.sourceRanges = other.sourceRanges;
      }
      if (other.getSourceServiceAccountsList() != null) {
        this.sourceServiceAccounts = other.sourceServiceAccounts;
      }
      if (other.getSourceTagsList() != null) {
        this.sourceTags = other.sourceTags;
      }
      if (other.getTargetServiceAccountsList() != null) {
        this.targetServiceAccounts = other.targetServiceAccounts;
      }
      if (other.getTargetTagsList() != null) {
        this.targetTags = other.targetTags;
      }
      return this;
    }

    Builder(Firewall source) {
      this.allowed = source.allowed;
      this.creationTimestamp = source.creationTimestamp;
      this.denied = source.denied;
      this.description = source.description;
      this.destinationRanges = source.destinationRanges;
      this.direction = source.direction;
      this.disabled = source.disabled;
      this.id = source.id;
      this.kind = source.kind;
      this.logConfig = source.logConfig;
      this.name = source.name;
      this.network = source.network;
      this.priority = source.priority;
      this.selfLink = source.selfLink;
      this.sourceRanges = source.sourceRanges;
      this.sourceServiceAccounts = source.sourceServiceAccounts;
      this.sourceTags = source.sourceTags;
      this.targetServiceAccounts = source.targetServiceAccounts;
      this.targetTags = source.targetTags;
    }

    /**
     * The list of ALLOW rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a permitted connection.
     */
    public List<Allowed> getAllowedList() {
      return allowed;
    }

    /**
     * The list of ALLOW rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a permitted connection.
     */
    public Builder addAllAllowed(List<Allowed> allowed) {
      if (this.allowed == null) {
        this.allowed = new LinkedList<>();
      }
      this.allowed.addAll(allowed);
      return this;
    }

    /**
     * The list of ALLOW rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a permitted connection.
     */
    public Builder addAllowed(Allowed allowed) {
      if (this.allowed == null) {
        this.allowed = new LinkedList<>();
      }
      this.allowed.add(allowed);
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
     * The list of DENY rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a denied connection.
     */
    public List<Denied> getDeniedList() {
      return denied;
    }

    /**
     * The list of DENY rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a denied connection.
     */
    public Builder addAllDenied(List<Denied> denied) {
      if (this.denied == null) {
        this.denied = new LinkedList<>();
      }
      this.denied.addAll(denied);
      return this;
    }

    /**
     * The list of DENY rules specified by this firewall. Each rule specifies a protocol and
     * port-range tuple that describes a denied connection.
     */
    public Builder addDenied(Denied denied) {
      if (this.denied == null) {
        this.denied = new LinkedList<>();
      }
      this.denied.add(denied);
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
     * If destination ranges are specified, the firewall will apply only to traffic that has
     * destination IP address in these ranges. These ranges must be expressed in CIDR format. Only
     * IPv4 is supported.
     */
    public List<String> getDestinationRangesList() {
      return destinationRanges;
    }

    /**
     * If destination ranges are specified, the firewall will apply only to traffic that has
     * destination IP address in these ranges. These ranges must be expressed in CIDR format. Only
     * IPv4 is supported.
     */
    public Builder addAllDestinationRanges(List<String> destinationRanges) {
      if (this.destinationRanges == null) {
        this.destinationRanges = new LinkedList<>();
      }
      this.destinationRanges.addAll(destinationRanges);
      return this;
    }

    /**
     * If destination ranges are specified, the firewall will apply only to traffic that has
     * destination IP address in these ranges. These ranges must be expressed in CIDR format. Only
     * IPv4 is supported.
     */
    public Builder addDestinationRanges(String destinationRanges) {
      if (this.destinationRanges == null) {
        this.destinationRanges = new LinkedList<>();
      }
      this.destinationRanges.add(destinationRanges);
      return this;
    }

    /**
     * Direction of traffic to which this firewall applies; default is INGRESS. Note: For INGRESS
     * traffic, it is NOT supported to specify destinationRanges; For EGRESS traffic, it is NOT
     * supported to specify sourceRanges OR sourceTags.
     */
    public String getDirection() {
      return direction;
    }

    /**
     * Direction of traffic to which this firewall applies; default is INGRESS. Note: For INGRESS
     * traffic, it is NOT supported to specify destinationRanges; For EGRESS traffic, it is NOT
     * supported to specify sourceRanges OR sourceTags.
     */
    public Builder setDirection(String direction) {
      this.direction = direction;
      return this;
    }

    /**
     * Denotes whether the firewall rule is disabled, i.e not applied to the network it is
     * associated with. When set to true, the firewall rule is not enforced and the network behaves
     * as if it did not exist. If this is unspecified, the firewall rule will be enabled.
     */
    public Boolean getDisabled() {
      return disabled;
    }

    /**
     * Denotes whether the firewall rule is disabled, i.e not applied to the network it is
     * associated with. When set to true, the firewall rule is not enforced and the network behaves
     * as if it did not exist. If this is unspecified, the firewall rule will be enabled.
     */
    public Builder setDisabled(Boolean disabled) {
      this.disabled = disabled;
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

    /** [Output Only] Type of the resource. Always compute#firewall for firewall rules. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#firewall for firewall rules. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * This field denotes the logging options for a particular firewall rule. If logging is enabled,
     * logs will be exported to Stackdriver.
     */
    public FirewallLogConfig getLogConfig() {
      return logConfig;
    }

    /**
     * This field denotes the logging options for a particular firewall rule. If logging is enabled,
     * logs will be exported to Stackdriver.
     */
    public Builder setLogConfig(FirewallLogConfig logConfig) {
      this.logConfig = logConfig;
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
     * URL of the network resource for this firewall rule. If not specified when creating a firewall
     * rule, the default network is used: global/networks/default If you choose to specify this
     * property, you can specify the network as a full or partial URL. For example, the following
     * are all valid URLs: -
     * https://www.googleapis.com/compute/v1/projects/myproject/global/networks/my-network -
     * projects/myproject/global/networks/my-network - global/networks/default
     */
    public String getNetwork() {
      return network;
    }

    /**
     * URL of the network resource for this firewall rule. If not specified when creating a firewall
     * rule, the default network is used: global/networks/default If you choose to specify this
     * property, you can specify the network as a full or partial URL. For example, the following
     * are all valid URLs: -
     * https://www.googleapis.com/compute/v1/projects/myproject/global/networks/my-network -
     * projects/myproject/global/networks/my-network - global/networks/default
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * Priority for this rule. This is an integer between 0 and 65535, both inclusive. When not
     * specified, the value assumed is 1000. Relative priorities determine precedence of conflicting
     * rules. Lower value of priority implies higher precedence (eg, a rule with priority 0 has
     * higher precedence than a rule with priority 1). DENY rules take precedence over ALLOW rules
     * having equal priority.
     */
    public Integer getPriority() {
      return priority;
    }

    /**
     * Priority for this rule. This is an integer between 0 and 65535, both inclusive. When not
     * specified, the value assumed is 1000. Relative priorities determine precedence of conflicting
     * rules. Lower value of priority implies higher precedence (eg, a rule with priority 0 has
     * higher precedence than a rule with priority 1). DENY rules take precedence over ALLOW rules
     * having equal priority.
     */
    public Builder setPriority(Integer priority) {
      this.priority = priority;
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
     * If source ranges are specified, the firewall will apply only to traffic that has source IP
     * address in these ranges. These ranges must be expressed in CIDR format. One or both of
     * sourceRanges and sourceTags may be set. If both properties are set, the firewall will apply
     * to traffic that has source IP address within sourceRanges OR the source IP that belongs to a
     * tag listed in the sourceTags property. The connection does not need to match both properties
     * for the firewall to apply. Only IPv4 is supported.
     */
    public List<String> getSourceRangesList() {
      return sourceRanges;
    }

    /**
     * If source ranges are specified, the firewall will apply only to traffic that has source IP
     * address in these ranges. These ranges must be expressed in CIDR format. One or both of
     * sourceRanges and sourceTags may be set. If both properties are set, the firewall will apply
     * to traffic that has source IP address within sourceRanges OR the source IP that belongs to a
     * tag listed in the sourceTags property. The connection does not need to match both properties
     * for the firewall to apply. Only IPv4 is supported.
     */
    public Builder addAllSourceRanges(List<String> sourceRanges) {
      if (this.sourceRanges == null) {
        this.sourceRanges = new LinkedList<>();
      }
      this.sourceRanges.addAll(sourceRanges);
      return this;
    }

    /**
     * If source ranges are specified, the firewall will apply only to traffic that has source IP
     * address in these ranges. These ranges must be expressed in CIDR format. One or both of
     * sourceRanges and sourceTags may be set. If both properties are set, the firewall will apply
     * to traffic that has source IP address within sourceRanges OR the source IP that belongs to a
     * tag listed in the sourceTags property. The connection does not need to match both properties
     * for the firewall to apply. Only IPv4 is supported.
     */
    public Builder addSourceRanges(String sourceRanges) {
      if (this.sourceRanges == null) {
        this.sourceRanges = new LinkedList<>();
      }
      this.sourceRanges.add(sourceRanges);
      return this;
    }

    /**
     * If source service accounts are specified, the firewall will apply only to traffic originating
     * from an instance with a service account in this list. Source service accounts cannot be used
     * to control traffic to an instance's external IP address because service accounts are
     * associated with an instance, not an IP address. sourceRanges can be set at the same time as
     * sourceServiceAccounts. If both are set, the firewall will apply to traffic that has source IP
     * address within sourceRanges OR the source IP belongs to an instance with service account
     * listed in sourceServiceAccount. The connection does not need to match both properties for the
     * firewall to apply. sourceServiceAccounts cannot be used at the same time as sourceTags or
     * targetTags.
     */
    public List<String> getSourceServiceAccountsList() {
      return sourceServiceAccounts;
    }

    /**
     * If source service accounts are specified, the firewall will apply only to traffic originating
     * from an instance with a service account in this list. Source service accounts cannot be used
     * to control traffic to an instance's external IP address because service accounts are
     * associated with an instance, not an IP address. sourceRanges can be set at the same time as
     * sourceServiceAccounts. If both are set, the firewall will apply to traffic that has source IP
     * address within sourceRanges OR the source IP belongs to an instance with service account
     * listed in sourceServiceAccount. The connection does not need to match both properties for the
     * firewall to apply. sourceServiceAccounts cannot be used at the same time as sourceTags or
     * targetTags.
     */
    public Builder addAllSourceServiceAccounts(List<String> sourceServiceAccounts) {
      if (this.sourceServiceAccounts == null) {
        this.sourceServiceAccounts = new LinkedList<>();
      }
      this.sourceServiceAccounts.addAll(sourceServiceAccounts);
      return this;
    }

    /**
     * If source service accounts are specified, the firewall will apply only to traffic originating
     * from an instance with a service account in this list. Source service accounts cannot be used
     * to control traffic to an instance's external IP address because service accounts are
     * associated with an instance, not an IP address. sourceRanges can be set at the same time as
     * sourceServiceAccounts. If both are set, the firewall will apply to traffic that has source IP
     * address within sourceRanges OR the source IP belongs to an instance with service account
     * listed in sourceServiceAccount. The connection does not need to match both properties for the
     * firewall to apply. sourceServiceAccounts cannot be used at the same time as sourceTags or
     * targetTags.
     */
    public Builder addSourceServiceAccounts(String sourceServiceAccounts) {
      if (this.sourceServiceAccounts == null) {
        this.sourceServiceAccounts = new LinkedList<>();
      }
      this.sourceServiceAccounts.add(sourceServiceAccounts);
      return this;
    }

    /**
     * If source tags are specified, the firewall rule applies only to traffic with source IPs that
     * match the primary network interfaces of VM instances that have the tag and are in the same
     * VPC network. Source tags cannot be used to control traffic to an instance's external IP
     * address, it only applies to traffic between instances in the same virtual network. Because
     * tags are associated with instances, not IP addresses. One or both of sourceRanges and
     * sourceTags may be set. If both properties are set, the firewall will apply to traffic that
     * has source IP address within sourceRanges OR the source IP that belongs to a tag listed in
     * the sourceTags property. The connection does not need to match both properties for the
     * firewall to apply.
     */
    public List<String> getSourceTagsList() {
      return sourceTags;
    }

    /**
     * If source tags are specified, the firewall rule applies only to traffic with source IPs that
     * match the primary network interfaces of VM instances that have the tag and are in the same
     * VPC network. Source tags cannot be used to control traffic to an instance's external IP
     * address, it only applies to traffic between instances in the same virtual network. Because
     * tags are associated with instances, not IP addresses. One or both of sourceRanges and
     * sourceTags may be set. If both properties are set, the firewall will apply to traffic that
     * has source IP address within sourceRanges OR the source IP that belongs to a tag listed in
     * the sourceTags property. The connection does not need to match both properties for the
     * firewall to apply.
     */
    public Builder addAllSourceTags(List<String> sourceTags) {
      if (this.sourceTags == null) {
        this.sourceTags = new LinkedList<>();
      }
      this.sourceTags.addAll(sourceTags);
      return this;
    }

    /**
     * If source tags are specified, the firewall rule applies only to traffic with source IPs that
     * match the primary network interfaces of VM instances that have the tag and are in the same
     * VPC network. Source tags cannot be used to control traffic to an instance's external IP
     * address, it only applies to traffic between instances in the same virtual network. Because
     * tags are associated with instances, not IP addresses. One or both of sourceRanges and
     * sourceTags may be set. If both properties are set, the firewall will apply to traffic that
     * has source IP address within sourceRanges OR the source IP that belongs to a tag listed in
     * the sourceTags property. The connection does not need to match both properties for the
     * firewall to apply.
     */
    public Builder addSourceTags(String sourceTags) {
      if (this.sourceTags == null) {
        this.sourceTags = new LinkedList<>();
      }
      this.sourceTags.add(sourceTags);
      return this;
    }

    /**
     * A list of service accounts indicating sets of instances located in the network that may make
     * network connections as specified in allowed[]. targetServiceAccounts cannot be used at the
     * same time as targetTags or sourceTags. If neither targetServiceAccounts nor targetTags are
     * specified, the firewall rule applies to all instances on the specified network.
     */
    public List<String> getTargetServiceAccountsList() {
      return targetServiceAccounts;
    }

    /**
     * A list of service accounts indicating sets of instances located in the network that may make
     * network connections as specified in allowed[]. targetServiceAccounts cannot be used at the
     * same time as targetTags or sourceTags. If neither targetServiceAccounts nor targetTags are
     * specified, the firewall rule applies to all instances on the specified network.
     */
    public Builder addAllTargetServiceAccounts(List<String> targetServiceAccounts) {
      if (this.targetServiceAccounts == null) {
        this.targetServiceAccounts = new LinkedList<>();
      }
      this.targetServiceAccounts.addAll(targetServiceAccounts);
      return this;
    }

    /**
     * A list of service accounts indicating sets of instances located in the network that may make
     * network connections as specified in allowed[]. targetServiceAccounts cannot be used at the
     * same time as targetTags or sourceTags. If neither targetServiceAccounts nor targetTags are
     * specified, the firewall rule applies to all instances on the specified network.
     */
    public Builder addTargetServiceAccounts(String targetServiceAccounts) {
      if (this.targetServiceAccounts == null) {
        this.targetServiceAccounts = new LinkedList<>();
      }
      this.targetServiceAccounts.add(targetServiceAccounts);
      return this;
    }

    /**
     * A list of tags that controls which instances the firewall rule applies to. If targetTags are
     * specified, then the firewall rule applies only to instances in the VPC network that have one
     * of those tags. If no targetTags are specified, the firewall rule applies to all instances on
     * the specified network.
     */
    public List<String> getTargetTagsList() {
      return targetTags;
    }

    /**
     * A list of tags that controls which instances the firewall rule applies to. If targetTags are
     * specified, then the firewall rule applies only to instances in the VPC network that have one
     * of those tags. If no targetTags are specified, the firewall rule applies to all instances on
     * the specified network.
     */
    public Builder addAllTargetTags(List<String> targetTags) {
      if (this.targetTags == null) {
        this.targetTags = new LinkedList<>();
      }
      this.targetTags.addAll(targetTags);
      return this;
    }

    /**
     * A list of tags that controls which instances the firewall rule applies to. If targetTags are
     * specified, then the firewall rule applies only to instances in the VPC network that have one
     * of those tags. If no targetTags are specified, the firewall rule applies to all instances on
     * the specified network.
     */
    public Builder addTargetTags(String targetTags) {
      if (this.targetTags == null) {
        this.targetTags = new LinkedList<>();
      }
      this.targetTags.add(targetTags);
      return this;
    }

    public Firewall build() {

      return new Firewall(
          allowed,
          creationTimestamp,
          denied,
          description,
          destinationRanges,
          direction,
          disabled,
          id,
          kind,
          logConfig,
          name,
          network,
          priority,
          selfLink,
          sourceRanges,
          sourceServiceAccounts,
          sourceTags,
          targetServiceAccounts,
          targetTags);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAllowed(this.allowed);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.addAllDenied(this.denied);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDestinationRanges(this.destinationRanges);
      newBuilder.setDirection(this.direction);
      newBuilder.setDisabled(this.disabled);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLogConfig(this.logConfig);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setPriority(this.priority);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSourceRanges(this.sourceRanges);
      newBuilder.addAllSourceServiceAccounts(this.sourceServiceAccounts);
      newBuilder.addAllSourceTags(this.sourceTags);
      newBuilder.addAllTargetServiceAccounts(this.targetServiceAccounts);
      newBuilder.addAllTargetTags(this.targetTags);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Firewall{"
        + "allowed="
        + allowed
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "denied="
        + denied
        + ", "
        + "description="
        + description
        + ", "
        + "destinationRanges="
        + destinationRanges
        + ", "
        + "direction="
        + direction
        + ", "
        + "disabled="
        + disabled
        + ", "
        + "id="
        + id
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
        + "priority="
        + priority
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sourceRanges="
        + sourceRanges
        + ", "
        + "sourceServiceAccounts="
        + sourceServiceAccounts
        + ", "
        + "sourceTags="
        + sourceTags
        + ", "
        + "targetServiceAccounts="
        + targetServiceAccounts
        + ", "
        + "targetTags="
        + targetTags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Firewall) {
      Firewall that = (Firewall) o;
      return Objects.equals(this.allowed, that.getAllowedList())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.denied, that.getDeniedList())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.destinationRanges, that.getDestinationRangesList())
          && Objects.equals(this.direction, that.getDirection())
          && Objects.equals(this.disabled, that.getDisabled())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.logConfig, that.getLogConfig())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sourceRanges, that.getSourceRangesList())
          && Objects.equals(this.sourceServiceAccounts, that.getSourceServiceAccountsList())
          && Objects.equals(this.sourceTags, that.getSourceTagsList())
          && Objects.equals(this.targetServiceAccounts, that.getTargetServiceAccountsList())
          && Objects.equals(this.targetTags, that.getTargetTagsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        allowed,
        creationTimestamp,
        denied,
        description,
        destinationRanges,
        direction,
        disabled,
        id,
        kind,
        logConfig,
        name,
        network,
        priority,
        selfLink,
        sourceRanges,
        sourceServiceAccounts,
        sourceTags,
        targetServiceAccounts,
        targetTags);
  }
}
