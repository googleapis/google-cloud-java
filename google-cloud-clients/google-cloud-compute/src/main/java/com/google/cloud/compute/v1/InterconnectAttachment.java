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
 * Represents an InterconnectAttachment (VLAN attachment) resource. For more information, see
 * Creating VLAN Attachments. (== resource_for beta.interconnectAttachments ==) (== resource_for
 * v1.interconnectAttachments ==)
 */
public final class InterconnectAttachment implements ApiMessage {
  private final Boolean adminEnabled;
  private final String bandwidth;
  private final List<String> candidateSubnets;
  private final String cloudRouterIpAddress;
  private final String creationTimestamp;
  private final String customerRouterIpAddress;
  private final String description;
  private final String edgeAvailabilityDomain;
  private final String googleReferenceId;
  private final String id;
  private final String interconnect;
  private final String kind;
  private final String name;
  private final String operationalStatus;
  private final String pairingKey;
  private final String partnerAsn;
  private final InterconnectAttachmentPartnerMetadata partnerMetadata;
  private final InterconnectAttachmentPrivateInfo privateInterconnectInfo;
  private final String region;
  private final String router;
  private final String selfLink;
  private final String state;
  private final String type;
  private final Integer vlanTag8021q;

  private InterconnectAttachment() {
    this.adminEnabled = null;
    this.bandwidth = null;
    this.candidateSubnets = null;
    this.cloudRouterIpAddress = null;
    this.creationTimestamp = null;
    this.customerRouterIpAddress = null;
    this.description = null;
    this.edgeAvailabilityDomain = null;
    this.googleReferenceId = null;
    this.id = null;
    this.interconnect = null;
    this.kind = null;
    this.name = null;
    this.operationalStatus = null;
    this.pairingKey = null;
    this.partnerAsn = null;
    this.partnerMetadata = null;
    this.privateInterconnectInfo = null;
    this.region = null;
    this.router = null;
    this.selfLink = null;
    this.state = null;
    this.type = null;
    this.vlanTag8021q = null;
  }

  private InterconnectAttachment(
      Boolean adminEnabled,
      String bandwidth,
      List<String> candidateSubnets,
      String cloudRouterIpAddress,
      String creationTimestamp,
      String customerRouterIpAddress,
      String description,
      String edgeAvailabilityDomain,
      String googleReferenceId,
      String id,
      String interconnect,
      String kind,
      String name,
      String operationalStatus,
      String pairingKey,
      String partnerAsn,
      InterconnectAttachmentPartnerMetadata partnerMetadata,
      InterconnectAttachmentPrivateInfo privateInterconnectInfo,
      String region,
      String router,
      String selfLink,
      String state,
      String type,
      Integer vlanTag8021q) {
    this.adminEnabled = adminEnabled;
    this.bandwidth = bandwidth;
    this.candidateSubnets = candidateSubnets;
    this.cloudRouterIpAddress = cloudRouterIpAddress;
    this.creationTimestamp = creationTimestamp;
    this.customerRouterIpAddress = customerRouterIpAddress;
    this.description = description;
    this.edgeAvailabilityDomain = edgeAvailabilityDomain;
    this.googleReferenceId = googleReferenceId;
    this.id = id;
    this.interconnect = interconnect;
    this.kind = kind;
    this.name = name;
    this.operationalStatus = operationalStatus;
    this.pairingKey = pairingKey;
    this.partnerAsn = partnerAsn;
    this.partnerMetadata = partnerMetadata;
    this.privateInterconnectInfo = privateInterconnectInfo;
    this.region = region;
    this.router = router;
    this.selfLink = selfLink;
    this.state = state;
    this.type = type;
    this.vlanTag8021q = vlanTag8021q;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("adminEnabled".equals(fieldName)) {
      return adminEnabled;
    }
    if ("bandwidth".equals(fieldName)) {
      return bandwidth;
    }
    if ("candidateSubnets".equals(fieldName)) {
      return candidateSubnets;
    }
    if ("cloudRouterIpAddress".equals(fieldName)) {
      return cloudRouterIpAddress;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("customerRouterIpAddress".equals(fieldName)) {
      return customerRouterIpAddress;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("edgeAvailabilityDomain".equals(fieldName)) {
      return edgeAvailabilityDomain;
    }
    if ("googleReferenceId".equals(fieldName)) {
      return googleReferenceId;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("interconnect".equals(fieldName)) {
      return interconnect;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("operationalStatus".equals(fieldName)) {
      return operationalStatus;
    }
    if ("pairingKey".equals(fieldName)) {
      return pairingKey;
    }
    if ("partnerAsn".equals(fieldName)) {
      return partnerAsn;
    }
    if ("partnerMetadata".equals(fieldName)) {
      return partnerMetadata;
    }
    if ("privateInterconnectInfo".equals(fieldName)) {
      return privateInterconnectInfo;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("router".equals(fieldName)) {
      return router;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("state".equals(fieldName)) {
      return state;
    }
    if ("type".equals(fieldName)) {
      return type;
    }
    if ("vlanTag8021q".equals(fieldName)) {
      return vlanTag8021q;
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

  /** Determines whether this Attachment will carry packets. Not present for PARTNER_PROVIDER. */
  public Boolean getAdminEnabled() {
    return adminEnabled;
  }

  /**
   * Provisioned bandwidth capacity for the interconnect attachment. For attachments of type
   * DEDICATED, the user can set the bandwidth. For attachments of type PARTNER, the Google Partner
   * that is operating the interconnect must set the bandwidth. Output only for PARTNER type,
   * mutable for PARTNER_PROVIDER and DEDICATED, and can take one of the following values: -
   * BPS_50M: 50 Mbit/s - BPS_100M: 100 Mbit/s - BPS_200M: 200 Mbit/s - BPS_300M: 300 Mbit/s -
   * BPS_400M: 400 Mbit/s - BPS_500M: 500 Mbit/s - BPS_1G: 1 Gbit/s - BPS_2G: 2 Gbit/s - BPS_5G: 5
   * Gbit/s - BPS_10G: 10 Gbit/s
   */
  public String getBandwidth() {
    return bandwidth;
  }

  /**
   * Up to 16 candidate prefixes that can be used to restrict the allocation of cloudRouterIpAddress
   * and customerRouterIpAddress for this attachment. All prefixes must be within link-local address
   * space (169.254.0.0/16) and must be /29 or shorter (/28, /27, etc). Google will attempt to
   * select an unused /29 from the supplied candidate prefix(es). The request will fail if all
   * possible /29s are in use on Google?s edge. If not supplied, Google will randomly select an
   * unused /29 from all of link-local space.
   */
  public List<String> getCandidateSubnetsList() {
    return candidateSubnets;
  }

  /**
   * [Output Only] IPv4 address + prefix length to be configured on Cloud Router Interface for this
   * interconnect attachment.
   */
  public String getCloudRouterIpAddress() {
    return cloudRouterIpAddress;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * [Output Only] IPv4 address + prefix length to be configured on the customer router subinterface
   * for this interconnect attachment.
   */
  public String getCustomerRouterIpAddress() {
    return customerRouterIpAddress;
  }

  /** An optional description of this resource. */
  public String getDescription() {
    return description;
  }

  /**
   * Desired availability domain for the attachment. Only available for type PARTNER, at creation
   * time, and can take one of the following values: - AVAILABILITY_DOMAIN_ANY -
   * AVAILABILITY_DOMAIN_1 - AVAILABILITY_DOMAIN_2 For improved reliability, customers should
   * configure a pair of attachments, one per availability domain. The selected availability domain
   * will be provided to the Partner via the pairing key, so that the provisioned circuit will lie
   * in the specified domain. If not specified, the value will default to AVAILABILITY_DOMAIN_ANY.
   */
  public String getEdgeAvailabilityDomain() {
    return edgeAvailabilityDomain;
  }

  /**
   * [Output Only] Google reference ID, to be used when raising support tickets with Google or
   * otherwise to debug backend connectivity issues.
   */
  public String getGoogleReferenceId() {
    return googleReferenceId;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * URL of the underlying Interconnect object that this attachment's traffic will traverse through.
   */
  public String getInterconnect() {
    return interconnect;
  }

  /**
   * [Output Only] Type of the resource. Always compute#interconnectAttachment for interconnect
   * attachments.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * [Output Only] The current status of whether or not this interconnect attachment is functional,
   * which can take one of the following values: - OS_ACTIVE: The attachment has been turned up and
   * is ready to use. - OS_UNPROVISIONED: The attachment is not ready to use yet, because turnup is
   * not complete.
   */
  public String getOperationalStatus() {
    return operationalStatus;
  }

  /**
   * [Output only for type PARTNER. Input only for PARTNER_PROVIDER. Not present for DEDICATED]. The
   * opaque identifier of an PARTNER attachment used to initiate provisioning with a selected
   * partner. Of the form "XXXXX/region/domain"
   */
  public String getPairingKey() {
    return pairingKey;
  }

  /**
   * Optional BGP ASN for the router supplied by a Layer 3 Partner if they configured BGP on behalf
   * of the customer. Output only for PARTNER type, input only for PARTNER_PROVIDER, not available
   * for DEDICATED.
   */
  public String getPartnerAsn() {
    return partnerAsn;
  }

  /**
   * Informational metadata about Partner attachments from Partners to display to customers. Output
   * only for for PARTNER type, mutable for PARTNER_PROVIDER, not available for DEDICATED.
   */
  public InterconnectAttachmentPartnerMetadata getPartnerMetadata() {
    return partnerMetadata;
  }

  /**
   * [Output Only] Information specific to an InterconnectAttachment. This property is populated if
   * the interconnect that this is attached to is of type DEDICATED.
   */
  public InterconnectAttachmentPrivateInfo getPrivateInterconnectInfo() {
    return privateInterconnectInfo;
  }

  /**
   * [Output Only] URL of the region where the regional interconnect attachment resides. You must
   * specify this field as part of the HTTP request URL. It is not settable as a field in the
   * request body.
   */
  public String getRegion() {
    return region;
  }

  /**
   * URL of the Cloud Router to be used for dynamic routing. This router must be in the same region
   * as this InterconnectAttachment. The InterconnectAttachment will automatically connect the
   * Interconnect to the network &amp; region within which the Cloud Router is configured.
   */
  public String getRouter() {
    return router;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The current state of this attachment's functionality. Enum values ACTIVE and
   * UNPROVISIONED are shared by DEDICATED/PRIVATE, PARTNER, and PARTNER_PROVIDER interconnect
   * attachments, while enum values PENDING_PARTNER, PARTNER_REQUEST_RECEIVED, and PENDING_CUSTOMER
   * are used for only PARTNER and PARTNER_PROVIDER interconnect attachments. This state can take
   * one of the following values: - ACTIVE: The attachment has been turned up and is ready to use. -
   * UNPROVISIONED: The attachment is not ready to use yet, because turnup is not complete. -
   * PENDING_PARTNER: A newly-created PARTNER attachment that has not yet been configured on the
   * Partner side. - PARTNER_REQUEST_RECEIVED: A PARTNER attachment is in the process of
   * provisioning after a PARTNER_PROVIDER attachment was created that references it. -
   * PENDING_CUSTOMER: A PARTNER or PARTNER_PROVIDER attachment that is waiting for a customer to
   * activate it. - DEFUNCT: The attachment was deleted externally and is no longer functional. This
   * could be because the associated Interconnect was removed, or because the other side of a
   * Partner attachment was deleted.
   */
  public String getState() {
    return state;
  }

  /**
   * The type of interconnect attachment this is, which can take one of the following values: -
   * DEDICATED: an attachment to a Dedicated Interconnect. - PARTNER: an attachment to a Partner
   * Interconnect, created by the customer. - PARTNER_PROVIDER: an attachment to a Partner
   * Interconnect, created by the partner.
   */
  public String getType() {
    return type;
  }

  /**
   * The IEEE 802.1Q VLAN tag for this attachment, in the range 2-4094. Only specified at creation
   * time.
   */
  public Integer getVlanTag8021q() {
    return vlanTag8021q;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectAttachment prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectAttachment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectAttachment DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectAttachment();
  }

  public static class Builder {
    private Boolean adminEnabled;
    private String bandwidth;
    private List<String> candidateSubnets;
    private String cloudRouterIpAddress;
    private String creationTimestamp;
    private String customerRouterIpAddress;
    private String description;
    private String edgeAvailabilityDomain;
    private String googleReferenceId;
    private String id;
    private String interconnect;
    private String kind;
    private String name;
    private String operationalStatus;
    private String pairingKey;
    private String partnerAsn;
    private InterconnectAttachmentPartnerMetadata partnerMetadata;
    private InterconnectAttachmentPrivateInfo privateInterconnectInfo;
    private String region;
    private String router;
    private String selfLink;
    private String state;
    private String type;
    private Integer vlanTag8021q;

    Builder() {}

    public Builder mergeFrom(InterconnectAttachment other) {
      if (other == InterconnectAttachment.getDefaultInstance()) return this;
      if (other.getAdminEnabled() != null) {
        this.adminEnabled = other.adminEnabled;
      }
      if (other.getBandwidth() != null) {
        this.bandwidth = other.bandwidth;
      }
      if (other.getCandidateSubnetsList() != null) {
        this.candidateSubnets = other.candidateSubnets;
      }
      if (other.getCloudRouterIpAddress() != null) {
        this.cloudRouterIpAddress = other.cloudRouterIpAddress;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getCustomerRouterIpAddress() != null) {
        this.customerRouterIpAddress = other.customerRouterIpAddress;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEdgeAvailabilityDomain() != null) {
        this.edgeAvailabilityDomain = other.edgeAvailabilityDomain;
      }
      if (other.getGoogleReferenceId() != null) {
        this.googleReferenceId = other.googleReferenceId;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInterconnect() != null) {
        this.interconnect = other.interconnect;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getOperationalStatus() != null) {
        this.operationalStatus = other.operationalStatus;
      }
      if (other.getPairingKey() != null) {
        this.pairingKey = other.pairingKey;
      }
      if (other.getPartnerAsn() != null) {
        this.partnerAsn = other.partnerAsn;
      }
      if (other.getPartnerMetadata() != null) {
        this.partnerMetadata = other.partnerMetadata;
      }
      if (other.getPrivateInterconnectInfo() != null) {
        this.privateInterconnectInfo = other.privateInterconnectInfo;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getRouter() != null) {
        this.router = other.router;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      if (other.getVlanTag8021q() != null) {
        this.vlanTag8021q = other.vlanTag8021q;
      }
      return this;
    }

    Builder(InterconnectAttachment source) {
      this.adminEnabled = source.adminEnabled;
      this.bandwidth = source.bandwidth;
      this.candidateSubnets = source.candidateSubnets;
      this.cloudRouterIpAddress = source.cloudRouterIpAddress;
      this.creationTimestamp = source.creationTimestamp;
      this.customerRouterIpAddress = source.customerRouterIpAddress;
      this.description = source.description;
      this.edgeAvailabilityDomain = source.edgeAvailabilityDomain;
      this.googleReferenceId = source.googleReferenceId;
      this.id = source.id;
      this.interconnect = source.interconnect;
      this.kind = source.kind;
      this.name = source.name;
      this.operationalStatus = source.operationalStatus;
      this.pairingKey = source.pairingKey;
      this.partnerAsn = source.partnerAsn;
      this.partnerMetadata = source.partnerMetadata;
      this.privateInterconnectInfo = source.privateInterconnectInfo;
      this.region = source.region;
      this.router = source.router;
      this.selfLink = source.selfLink;
      this.state = source.state;
      this.type = source.type;
      this.vlanTag8021q = source.vlanTag8021q;
    }

    /** Determines whether this Attachment will carry packets. Not present for PARTNER_PROVIDER. */
    public Boolean getAdminEnabled() {
      return adminEnabled;
    }

    /** Determines whether this Attachment will carry packets. Not present for PARTNER_PROVIDER. */
    public Builder setAdminEnabled(Boolean adminEnabled) {
      this.adminEnabled = adminEnabled;
      return this;
    }

    /**
     * Provisioned bandwidth capacity for the interconnect attachment. For attachments of type
     * DEDICATED, the user can set the bandwidth. For attachments of type PARTNER, the Google
     * Partner that is operating the interconnect must set the bandwidth. Output only for PARTNER
     * type, mutable for PARTNER_PROVIDER and DEDICATED, and can take one of the following values: -
     * BPS_50M: 50 Mbit/s - BPS_100M: 100 Mbit/s - BPS_200M: 200 Mbit/s - BPS_300M: 300 Mbit/s -
     * BPS_400M: 400 Mbit/s - BPS_500M: 500 Mbit/s - BPS_1G: 1 Gbit/s - BPS_2G: 2 Gbit/s - BPS_5G: 5
     * Gbit/s - BPS_10G: 10 Gbit/s
     */
    public String getBandwidth() {
      return bandwidth;
    }

    /**
     * Provisioned bandwidth capacity for the interconnect attachment. For attachments of type
     * DEDICATED, the user can set the bandwidth. For attachments of type PARTNER, the Google
     * Partner that is operating the interconnect must set the bandwidth. Output only for PARTNER
     * type, mutable for PARTNER_PROVIDER and DEDICATED, and can take one of the following values: -
     * BPS_50M: 50 Mbit/s - BPS_100M: 100 Mbit/s - BPS_200M: 200 Mbit/s - BPS_300M: 300 Mbit/s -
     * BPS_400M: 400 Mbit/s - BPS_500M: 500 Mbit/s - BPS_1G: 1 Gbit/s - BPS_2G: 2 Gbit/s - BPS_5G: 5
     * Gbit/s - BPS_10G: 10 Gbit/s
     */
    public Builder setBandwidth(String bandwidth) {
      this.bandwidth = bandwidth;
      return this;
    }

    /**
     * Up to 16 candidate prefixes that can be used to restrict the allocation of
     * cloudRouterIpAddress and customerRouterIpAddress for this attachment. All prefixes must be
     * within link-local address space (169.254.0.0/16) and must be /29 or shorter (/28, /27, etc).
     * Google will attempt to select an unused /29 from the supplied candidate prefix(es). The
     * request will fail if all possible /29s are in use on Google?s edge. If not supplied, Google
     * will randomly select an unused /29 from all of link-local space.
     */
    public List<String> getCandidateSubnetsList() {
      return candidateSubnets;
    }

    /**
     * Up to 16 candidate prefixes that can be used to restrict the allocation of
     * cloudRouterIpAddress and customerRouterIpAddress for this attachment. All prefixes must be
     * within link-local address space (169.254.0.0/16) and must be /29 or shorter (/28, /27, etc).
     * Google will attempt to select an unused /29 from the supplied candidate prefix(es). The
     * request will fail if all possible /29s are in use on Google?s edge. If not supplied, Google
     * will randomly select an unused /29 from all of link-local space.
     */
    public Builder addAllCandidateSubnets(List<String> candidateSubnets) {
      if (this.candidateSubnets == null) {
        this.candidateSubnets = new LinkedList<>();
      }
      this.candidateSubnets.addAll(candidateSubnets);
      return this;
    }

    /**
     * Up to 16 candidate prefixes that can be used to restrict the allocation of
     * cloudRouterIpAddress and customerRouterIpAddress for this attachment. All prefixes must be
     * within link-local address space (169.254.0.0/16) and must be /29 or shorter (/28, /27, etc).
     * Google will attempt to select an unused /29 from the supplied candidate prefix(es). The
     * request will fail if all possible /29s are in use on Google?s edge. If not supplied, Google
     * will randomly select an unused /29 from all of link-local space.
     */
    public Builder addCandidateSubnets(String candidateSubnets) {
      if (this.candidateSubnets == null) {
        this.candidateSubnets = new LinkedList<>();
      }
      this.candidateSubnets.add(candidateSubnets);
      return this;
    }

    /**
     * [Output Only] IPv4 address + prefix length to be configured on Cloud Router Interface for
     * this interconnect attachment.
     */
    public String getCloudRouterIpAddress() {
      return cloudRouterIpAddress;
    }

    /**
     * [Output Only] IPv4 address + prefix length to be configured on Cloud Router Interface for
     * this interconnect attachment.
     */
    public Builder setCloudRouterIpAddress(String cloudRouterIpAddress) {
      this.cloudRouterIpAddress = cloudRouterIpAddress;
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
     * [Output Only] IPv4 address + prefix length to be configured on the customer router
     * subinterface for this interconnect attachment.
     */
    public String getCustomerRouterIpAddress() {
      return customerRouterIpAddress;
    }

    /**
     * [Output Only] IPv4 address + prefix length to be configured on the customer router
     * subinterface for this interconnect attachment.
     */
    public Builder setCustomerRouterIpAddress(String customerRouterIpAddress) {
      this.customerRouterIpAddress = customerRouterIpAddress;
      return this;
    }

    /** An optional description of this resource. */
    public String getDescription() {
      return description;
    }

    /** An optional description of this resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Desired availability domain for the attachment. Only available for type PARTNER, at creation
     * time, and can take one of the following values: - AVAILABILITY_DOMAIN_ANY -
     * AVAILABILITY_DOMAIN_1 - AVAILABILITY_DOMAIN_2 For improved reliability, customers should
     * configure a pair of attachments, one per availability domain. The selected availability
     * domain will be provided to the Partner via the pairing key, so that the provisioned circuit
     * will lie in the specified domain. If not specified, the value will default to
     * AVAILABILITY_DOMAIN_ANY.
     */
    public String getEdgeAvailabilityDomain() {
      return edgeAvailabilityDomain;
    }

    /**
     * Desired availability domain for the attachment. Only available for type PARTNER, at creation
     * time, and can take one of the following values: - AVAILABILITY_DOMAIN_ANY -
     * AVAILABILITY_DOMAIN_1 - AVAILABILITY_DOMAIN_2 For improved reliability, customers should
     * configure a pair of attachments, one per availability domain. The selected availability
     * domain will be provided to the Partner via the pairing key, so that the provisioned circuit
     * will lie in the specified domain. If not specified, the value will default to
     * AVAILABILITY_DOMAIN_ANY.
     */
    public Builder setEdgeAvailabilityDomain(String edgeAvailabilityDomain) {
      this.edgeAvailabilityDomain = edgeAvailabilityDomain;
      return this;
    }

    /**
     * [Output Only] Google reference ID, to be used when raising support tickets with Google or
     * otherwise to debug backend connectivity issues.
     */
    public String getGoogleReferenceId() {
      return googleReferenceId;
    }

    /**
     * [Output Only] Google reference ID, to be used when raising support tickets with Google or
     * otherwise to debug backend connectivity issues.
     */
    public Builder setGoogleReferenceId(String googleReferenceId) {
      this.googleReferenceId = googleReferenceId;
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
     * URL of the underlying Interconnect object that this attachment's traffic will traverse
     * through.
     */
    public String getInterconnect() {
      return interconnect;
    }

    /**
     * URL of the underlying Interconnect object that this attachment's traffic will traverse
     * through.
     */
    public Builder setInterconnect(String interconnect) {
      this.interconnect = interconnect;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#interconnectAttachment for interconnect
     * attachments.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#interconnectAttachment for interconnect
     * attachments.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
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
     * [Output Only] The current status of whether or not this interconnect attachment is
     * functional, which can take one of the following values: - OS_ACTIVE: The attachment has been
     * turned up and is ready to use. - OS_UNPROVISIONED: The attachment is not ready to use yet,
     * because turnup is not complete.
     */
    public String getOperationalStatus() {
      return operationalStatus;
    }

    /**
     * [Output Only] The current status of whether or not this interconnect attachment is
     * functional, which can take one of the following values: - OS_ACTIVE: The attachment has been
     * turned up and is ready to use. - OS_UNPROVISIONED: The attachment is not ready to use yet,
     * because turnup is not complete.
     */
    public Builder setOperationalStatus(String operationalStatus) {
      this.operationalStatus = operationalStatus;
      return this;
    }

    /**
     * [Output only for type PARTNER. Input only for PARTNER_PROVIDER. Not present for DEDICATED].
     * The opaque identifier of an PARTNER attachment used to initiate provisioning with a selected
     * partner. Of the form "XXXXX/region/domain"
     */
    public String getPairingKey() {
      return pairingKey;
    }

    /**
     * [Output only for type PARTNER. Input only for PARTNER_PROVIDER. Not present for DEDICATED].
     * The opaque identifier of an PARTNER attachment used to initiate provisioning with a selected
     * partner. Of the form "XXXXX/region/domain"
     */
    public Builder setPairingKey(String pairingKey) {
      this.pairingKey = pairingKey;
      return this;
    }

    /**
     * Optional BGP ASN for the router supplied by a Layer 3 Partner if they configured BGP on
     * behalf of the customer. Output only for PARTNER type, input only for PARTNER_PROVIDER, not
     * available for DEDICATED.
     */
    public String getPartnerAsn() {
      return partnerAsn;
    }

    /**
     * Optional BGP ASN for the router supplied by a Layer 3 Partner if they configured BGP on
     * behalf of the customer. Output only for PARTNER type, input only for PARTNER_PROVIDER, not
     * available for DEDICATED.
     */
    public Builder setPartnerAsn(String partnerAsn) {
      this.partnerAsn = partnerAsn;
      return this;
    }

    /**
     * Informational metadata about Partner attachments from Partners to display to customers.
     * Output only for for PARTNER type, mutable for PARTNER_PROVIDER, not available for DEDICATED.
     */
    public InterconnectAttachmentPartnerMetadata getPartnerMetadata() {
      return partnerMetadata;
    }

    /**
     * Informational metadata about Partner attachments from Partners to display to customers.
     * Output only for for PARTNER type, mutable for PARTNER_PROVIDER, not available for DEDICATED.
     */
    public Builder setPartnerMetadata(InterconnectAttachmentPartnerMetadata partnerMetadata) {
      this.partnerMetadata = partnerMetadata;
      return this;
    }

    /**
     * [Output Only] Information specific to an InterconnectAttachment. This property is populated
     * if the interconnect that this is attached to is of type DEDICATED.
     */
    public InterconnectAttachmentPrivateInfo getPrivateInterconnectInfo() {
      return privateInterconnectInfo;
    }

    /**
     * [Output Only] Information specific to an InterconnectAttachment. This property is populated
     * if the interconnect that this is attached to is of type DEDICATED.
     */
    public Builder setPrivateInterconnectInfo(
        InterconnectAttachmentPrivateInfo privateInterconnectInfo) {
      this.privateInterconnectInfo = privateInterconnectInfo;
      return this;
    }

    /**
     * [Output Only] URL of the region where the regional interconnect attachment resides. You must
     * specify this field as part of the HTTP request URL. It is not settable as a field in the
     * request body.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] URL of the region where the regional interconnect attachment resides. You must
     * specify this field as part of the HTTP request URL. It is not settable as a field in the
     * request body.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /**
     * URL of the Cloud Router to be used for dynamic routing. This router must be in the same
     * region as this InterconnectAttachment. The InterconnectAttachment will automatically connect
     * the Interconnect to the network &amp; region within which the Cloud Router is configured.
     */
    public String getRouter() {
      return router;
    }

    /**
     * URL of the Cloud Router to be used for dynamic routing. This router must be in the same
     * region as this InterconnectAttachment. The InterconnectAttachment will automatically connect
     * the Interconnect to the network &amp; region within which the Cloud Router is configured.
     */
    public Builder setRouter(String router) {
      this.router = router;
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
     * [Output Only] The current state of this attachment's functionality. Enum values ACTIVE and
     * UNPROVISIONED are shared by DEDICATED/PRIVATE, PARTNER, and PARTNER_PROVIDER interconnect
     * attachments, while enum values PENDING_PARTNER, PARTNER_REQUEST_RECEIVED, and
     * PENDING_CUSTOMER are used for only PARTNER and PARTNER_PROVIDER interconnect attachments.
     * This state can take one of the following values: - ACTIVE: The attachment has been turned up
     * and is ready to use. - UNPROVISIONED: The attachment is not ready to use yet, because turnup
     * is not complete. - PENDING_PARTNER: A newly-created PARTNER attachment that has not yet been
     * configured on the Partner side. - PARTNER_REQUEST_RECEIVED: A PARTNER attachment is in the
     * process of provisioning after a PARTNER_PROVIDER attachment was created that references it. -
     * PENDING_CUSTOMER: A PARTNER or PARTNER_PROVIDER attachment that is waiting for a customer to
     * activate it. - DEFUNCT: The attachment was deleted externally and is no longer functional.
     * This could be because the associated Interconnect was removed, or because the other side of a
     * Partner attachment was deleted.
     */
    public String getState() {
      return state;
    }

    /**
     * [Output Only] The current state of this attachment's functionality. Enum values ACTIVE and
     * UNPROVISIONED are shared by DEDICATED/PRIVATE, PARTNER, and PARTNER_PROVIDER interconnect
     * attachments, while enum values PENDING_PARTNER, PARTNER_REQUEST_RECEIVED, and
     * PENDING_CUSTOMER are used for only PARTNER and PARTNER_PROVIDER interconnect attachments.
     * This state can take one of the following values: - ACTIVE: The attachment has been turned up
     * and is ready to use. - UNPROVISIONED: The attachment is not ready to use yet, because turnup
     * is not complete. - PENDING_PARTNER: A newly-created PARTNER attachment that has not yet been
     * configured on the Partner side. - PARTNER_REQUEST_RECEIVED: A PARTNER attachment is in the
     * process of provisioning after a PARTNER_PROVIDER attachment was created that references it. -
     * PENDING_CUSTOMER: A PARTNER or PARTNER_PROVIDER attachment that is waiting for a customer to
     * activate it. - DEFUNCT: The attachment was deleted externally and is no longer functional.
     * This could be because the associated Interconnect was removed, or because the other side of a
     * Partner attachment was deleted.
     */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    /**
     * The type of interconnect attachment this is, which can take one of the following values: -
     * DEDICATED: an attachment to a Dedicated Interconnect. - PARTNER: an attachment to a Partner
     * Interconnect, created by the customer. - PARTNER_PROVIDER: an attachment to a Partner
     * Interconnect, created by the partner.
     */
    public String getType() {
      return type;
    }

    /**
     * The type of interconnect attachment this is, which can take one of the following values: -
     * DEDICATED: an attachment to a Dedicated Interconnect. - PARTNER: an attachment to a Partner
     * Interconnect, created by the customer. - PARTNER_PROVIDER: an attachment to a Partner
     * Interconnect, created by the partner.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    /**
     * The IEEE 802.1Q VLAN tag for this attachment, in the range 2-4094. Only specified at creation
     * time.
     */
    public Integer getVlanTag8021q() {
      return vlanTag8021q;
    }

    /**
     * The IEEE 802.1Q VLAN tag for this attachment, in the range 2-4094. Only specified at creation
     * time.
     */
    public Builder setVlanTag8021q(Integer vlanTag8021q) {
      this.vlanTag8021q = vlanTag8021q;
      return this;
    }

    public InterconnectAttachment build() {

      return new InterconnectAttachment(
          adminEnabled,
          bandwidth,
          candidateSubnets,
          cloudRouterIpAddress,
          creationTimestamp,
          customerRouterIpAddress,
          description,
          edgeAvailabilityDomain,
          googleReferenceId,
          id,
          interconnect,
          kind,
          name,
          operationalStatus,
          pairingKey,
          partnerAsn,
          partnerMetadata,
          privateInterconnectInfo,
          region,
          router,
          selfLink,
          state,
          type,
          vlanTag8021q);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdminEnabled(this.adminEnabled);
      newBuilder.setBandwidth(this.bandwidth);
      newBuilder.addAllCandidateSubnets(this.candidateSubnets);
      newBuilder.setCloudRouterIpAddress(this.cloudRouterIpAddress);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setCustomerRouterIpAddress(this.customerRouterIpAddress);
      newBuilder.setDescription(this.description);
      newBuilder.setEdgeAvailabilityDomain(this.edgeAvailabilityDomain);
      newBuilder.setGoogleReferenceId(this.googleReferenceId);
      newBuilder.setId(this.id);
      newBuilder.setInterconnect(this.interconnect);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setOperationalStatus(this.operationalStatus);
      newBuilder.setPairingKey(this.pairingKey);
      newBuilder.setPartnerAsn(this.partnerAsn);
      newBuilder.setPartnerMetadata(this.partnerMetadata);
      newBuilder.setPrivateInterconnectInfo(this.privateInterconnectInfo);
      newBuilder.setRegion(this.region);
      newBuilder.setRouter(this.router);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setState(this.state);
      newBuilder.setType(this.type);
      newBuilder.setVlanTag8021q(this.vlanTag8021q);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectAttachment{"
        + "adminEnabled="
        + adminEnabled
        + ", "
        + "bandwidth="
        + bandwidth
        + ", "
        + "candidateSubnets="
        + candidateSubnets
        + ", "
        + "cloudRouterIpAddress="
        + cloudRouterIpAddress
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "customerRouterIpAddress="
        + customerRouterIpAddress
        + ", "
        + "description="
        + description
        + ", "
        + "edgeAvailabilityDomain="
        + edgeAvailabilityDomain
        + ", "
        + "googleReferenceId="
        + googleReferenceId
        + ", "
        + "id="
        + id
        + ", "
        + "interconnect="
        + interconnect
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "operationalStatus="
        + operationalStatus
        + ", "
        + "pairingKey="
        + pairingKey
        + ", "
        + "partnerAsn="
        + partnerAsn
        + ", "
        + "partnerMetadata="
        + partnerMetadata
        + ", "
        + "privateInterconnectInfo="
        + privateInterconnectInfo
        + ", "
        + "region="
        + region
        + ", "
        + "router="
        + router
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "state="
        + state
        + ", "
        + "type="
        + type
        + ", "
        + "vlanTag8021q="
        + vlanTag8021q
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectAttachment) {
      InterconnectAttachment that = (InterconnectAttachment) o;
      return Objects.equals(this.adminEnabled, that.getAdminEnabled())
          && Objects.equals(this.bandwidth, that.getBandwidth())
          && Objects.equals(this.candidateSubnets, that.getCandidateSubnetsList())
          && Objects.equals(this.cloudRouterIpAddress, that.getCloudRouterIpAddress())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.customerRouterIpAddress, that.getCustomerRouterIpAddress())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.edgeAvailabilityDomain, that.getEdgeAvailabilityDomain())
          && Objects.equals(this.googleReferenceId, that.getGoogleReferenceId())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.interconnect, that.getInterconnect())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.operationalStatus, that.getOperationalStatus())
          && Objects.equals(this.pairingKey, that.getPairingKey())
          && Objects.equals(this.partnerAsn, that.getPartnerAsn())
          && Objects.equals(this.partnerMetadata, that.getPartnerMetadata())
          && Objects.equals(this.privateInterconnectInfo, that.getPrivateInterconnectInfo())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.router, that.getRouter())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.state, that.getState())
          && Objects.equals(this.type, that.getType())
          && Objects.equals(this.vlanTag8021q, that.getVlanTag8021q());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        adminEnabled,
        bandwidth,
        candidateSubnets,
        cloudRouterIpAddress,
        creationTimestamp,
        customerRouterIpAddress,
        description,
        edgeAvailabilityDomain,
        googleReferenceId,
        id,
        interconnect,
        kind,
        name,
        operationalStatus,
        pairingKey,
        partnerAsn,
        partnerMetadata,
        privateInterconnectInfo,
        region,
        router,
        selfLink,
        state,
        type,
        vlanTag8021q);
  }
}
