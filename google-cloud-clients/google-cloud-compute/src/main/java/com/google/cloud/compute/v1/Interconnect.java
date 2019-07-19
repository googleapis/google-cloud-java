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
 * Represents an Interconnect resource.
 *
 * <p>An Interconnect resource is a dedicated connection between the GCP network and your
 * on-premises network. For more information, read the Dedicated Interconnect Overview. (==
 * resource_for v1.interconnects ==) (== resource_for beta.interconnects ==)
 */
public final class Interconnect implements ApiMessage {
  private final Boolean adminEnabled;
  private final List<InterconnectCircuitInfo> circuitInfos;
  private final String creationTimestamp;
  private final String customerName;
  private final String description;
  private final List<InterconnectOutageNotification> expectedOutages;
  private final String googleIpAddress;
  private final String googleReferenceId;
  private final String id;
  private final List<String> interconnectAttachments;
  private final String interconnectType;
  private final String kind;
  private final String linkType;
  private final String location;
  private final String name;
  private final String nocContactEmail;
  private final String operationalStatus;
  private final String peerIpAddress;
  private final Integer provisionedLinkCount;
  private final Integer requestedLinkCount;
  private final String selfLink;
  private final String state;

  private Interconnect() {
    this.adminEnabled = null;
    this.circuitInfos = null;
    this.creationTimestamp = null;
    this.customerName = null;
    this.description = null;
    this.expectedOutages = null;
    this.googleIpAddress = null;
    this.googleReferenceId = null;
    this.id = null;
    this.interconnectAttachments = null;
    this.interconnectType = null;
    this.kind = null;
    this.linkType = null;
    this.location = null;
    this.name = null;
    this.nocContactEmail = null;
    this.operationalStatus = null;
    this.peerIpAddress = null;
    this.provisionedLinkCount = null;
    this.requestedLinkCount = null;
    this.selfLink = null;
    this.state = null;
  }

  private Interconnect(
      Boolean adminEnabled,
      List<InterconnectCircuitInfo> circuitInfos,
      String creationTimestamp,
      String customerName,
      String description,
      List<InterconnectOutageNotification> expectedOutages,
      String googleIpAddress,
      String googleReferenceId,
      String id,
      List<String> interconnectAttachments,
      String interconnectType,
      String kind,
      String linkType,
      String location,
      String name,
      String nocContactEmail,
      String operationalStatus,
      String peerIpAddress,
      Integer provisionedLinkCount,
      Integer requestedLinkCount,
      String selfLink,
      String state) {
    this.adminEnabled = adminEnabled;
    this.circuitInfos = circuitInfos;
    this.creationTimestamp = creationTimestamp;
    this.customerName = customerName;
    this.description = description;
    this.expectedOutages = expectedOutages;
    this.googleIpAddress = googleIpAddress;
    this.googleReferenceId = googleReferenceId;
    this.id = id;
    this.interconnectAttachments = interconnectAttachments;
    this.interconnectType = interconnectType;
    this.kind = kind;
    this.linkType = linkType;
    this.location = location;
    this.name = name;
    this.nocContactEmail = nocContactEmail;
    this.operationalStatus = operationalStatus;
    this.peerIpAddress = peerIpAddress;
    this.provisionedLinkCount = provisionedLinkCount;
    this.requestedLinkCount = requestedLinkCount;
    this.selfLink = selfLink;
    this.state = state;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("adminEnabled".equals(fieldName)) {
      return adminEnabled;
    }
    if ("circuitInfos".equals(fieldName)) {
      return circuitInfos;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("customerName".equals(fieldName)) {
      return customerName;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("expectedOutages".equals(fieldName)) {
      return expectedOutages;
    }
    if ("googleIpAddress".equals(fieldName)) {
      return googleIpAddress;
    }
    if ("googleReferenceId".equals(fieldName)) {
      return googleReferenceId;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("interconnectAttachments".equals(fieldName)) {
      return interconnectAttachments;
    }
    if ("interconnectType".equals(fieldName)) {
      return interconnectType;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("linkType".equals(fieldName)) {
      return linkType;
    }
    if ("location".equals(fieldName)) {
      return location;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("nocContactEmail".equals(fieldName)) {
      return nocContactEmail;
    }
    if ("operationalStatus".equals(fieldName)) {
      return operationalStatus;
    }
    if ("peerIpAddress".equals(fieldName)) {
      return peerIpAddress;
    }
    if ("provisionedLinkCount".equals(fieldName)) {
      return provisionedLinkCount;
    }
    if ("requestedLinkCount".equals(fieldName)) {
      return requestedLinkCount;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("state".equals(fieldName)) {
      return state;
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
   * Administrative status of the interconnect. When this is set to true, the Interconnect is
   * functional and can carry traffic. When set to false, no packets can be carried over the
   * interconnect and no BGP routes are exchanged over it. By default, the status is set to true.
   */
  public Boolean getAdminEnabled() {
    return adminEnabled;
  }

  /**
   * [Output Only] A list of CircuitInfo objects, that describe the individual circuits in this LAG.
   */
  public List<InterconnectCircuitInfo> getCircuitInfosList() {
    return circuitInfos;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Customer name, to put in the Letter of Authorization as the party authorized to request a
   * crossconnect.
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /** [Output Only] A list of outages expected for this Interconnect. */
  public List<InterconnectOutageNotification> getExpectedOutagesList() {
    return expectedOutages;
  }

  /**
   * [Output Only] IP address configured on the Google side of the Interconnect link. This can be
   * used only for ping tests.
   */
  public String getGoogleIpAddress() {
    return googleIpAddress;
  }

  /**
   * [Output Only] Google reference ID to be used when raising support tickets with Google or
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
   * [Output Only] A list of the URLs of all InterconnectAttachments configured to use this
   * Interconnect.
   */
  public List<String> getInterconnectAttachmentsList() {
    return interconnectAttachments;
  }

  /**
   * Type of interconnect, which can take one of the following values: - PARTNER: A partner-managed
   * interconnection shared between customers though a partner. - DEDICATED: A dedicated physical
   * interconnection with the customer. Note that a value IT_PRIVATE has been deprecated in favor of
   * DEDICATED.
   */
  public String getInterconnectType() {
    return interconnectType;
  }

  /** [Output Only] Type of the resource. Always compute#interconnect for interconnects. */
  public String getKind() {
    return kind;
  }

  /**
   * Type of link requested, which can take one of the following values: -
   * LINK_TYPE_ETHERNET_10G_LR: A 10G Ethernet with LR optics - LINK_TYPE_ETHERNET_100G_LR: A 100G
   * Ethernet with LR optics. Note that this field indicates the speed of each of the links in the
   * bundle, not the speed of the entire bundle.
   */
  public String getLinkType() {
    return linkType;
  }

  /**
   * URL of the InterconnectLocation object that represents where this connection is to be
   * provisioned.
   */
  public String getLocation() {
    return location;
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
   * Email address to contact the customer NOC for operations and maintenance notifications
   * regarding this Interconnect. If specified, this will be used for notifications in addition to
   * all other forms described, such as Stackdriver logs alerting and Cloud Notifications.
   */
  public String getNocContactEmail() {
    return nocContactEmail;
  }

  /**
   * [Output Only] The current status of this Interconnect's functionality, which can take one of
   * the following values: - OS_ACTIVE: A valid Interconnect, which is turned up and is ready to
   * use. Attachments may be provisioned on this Interconnect. - OS_UNPROVISIONED: An Interconnect
   * that has not completed turnup. No attachments may be provisioned on this Interconnect. -
   * OS_UNDER_MAINTENANCE: An Interconnect that is undergoing internal maintenance. No attachments
   * may be provisioned or updated on this Interconnect.
   */
  public String getOperationalStatus() {
    return operationalStatus;
  }

  /**
   * [Output Only] IP address configured on the customer side of the Interconnect link. The customer
   * should configure this IP address during turnup when prompted by Google NOC. This can be used
   * only for ping tests.
   */
  public String getPeerIpAddress() {
    return peerIpAddress;
  }

  /** [Output Only] Number of links actually provisioned in this interconnect. */
  public Integer getProvisionedLinkCount() {
    return provisionedLinkCount;
  }

  /** Target number of physical links in the link bundle, as requested by the customer. */
  public Integer getRequestedLinkCount() {
    return requestedLinkCount;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The current state of Interconnect functionality, which can take one of the
   * following values: - ACTIVE: The Interconnect is valid, turned up and ready to use. Attachments
   * may be provisioned on this Interconnect. - UNPROVISIONED: The Interconnect has not completed
   * turnup. No attachments may be provisioned on this Interconnect. - UNDER_MAINTENANCE: The
   * Interconnect is undergoing internal maintenance. No attachments may be provisioned or updated
   * on this Interconnect.
   */
  public String getState() {
    return state;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Interconnect prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Interconnect getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Interconnect DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Interconnect();
  }

  public static class Builder {
    private Boolean adminEnabled;
    private List<InterconnectCircuitInfo> circuitInfos;
    private String creationTimestamp;
    private String customerName;
    private String description;
    private List<InterconnectOutageNotification> expectedOutages;
    private String googleIpAddress;
    private String googleReferenceId;
    private String id;
    private List<String> interconnectAttachments;
    private String interconnectType;
    private String kind;
    private String linkType;
    private String location;
    private String name;
    private String nocContactEmail;
    private String operationalStatus;
    private String peerIpAddress;
    private Integer provisionedLinkCount;
    private Integer requestedLinkCount;
    private String selfLink;
    private String state;

    Builder() {}

    public Builder mergeFrom(Interconnect other) {
      if (other == Interconnect.getDefaultInstance()) return this;
      if (other.getAdminEnabled() != null) {
        this.adminEnabled = other.adminEnabled;
      }
      if (other.getCircuitInfosList() != null) {
        this.circuitInfos = other.circuitInfos;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getCustomerName() != null) {
        this.customerName = other.customerName;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getExpectedOutagesList() != null) {
        this.expectedOutages = other.expectedOutages;
      }
      if (other.getGoogleIpAddress() != null) {
        this.googleIpAddress = other.googleIpAddress;
      }
      if (other.getGoogleReferenceId() != null) {
        this.googleReferenceId = other.googleReferenceId;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInterconnectAttachmentsList() != null) {
        this.interconnectAttachments = other.interconnectAttachments;
      }
      if (other.getInterconnectType() != null) {
        this.interconnectType = other.interconnectType;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLinkType() != null) {
        this.linkType = other.linkType;
      }
      if (other.getLocation() != null) {
        this.location = other.location;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNocContactEmail() != null) {
        this.nocContactEmail = other.nocContactEmail;
      }
      if (other.getOperationalStatus() != null) {
        this.operationalStatus = other.operationalStatus;
      }
      if (other.getPeerIpAddress() != null) {
        this.peerIpAddress = other.peerIpAddress;
      }
      if (other.getProvisionedLinkCount() != null) {
        this.provisionedLinkCount = other.provisionedLinkCount;
      }
      if (other.getRequestedLinkCount() != null) {
        this.requestedLinkCount = other.requestedLinkCount;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      return this;
    }

    Builder(Interconnect source) {
      this.adminEnabled = source.adminEnabled;
      this.circuitInfos = source.circuitInfos;
      this.creationTimestamp = source.creationTimestamp;
      this.customerName = source.customerName;
      this.description = source.description;
      this.expectedOutages = source.expectedOutages;
      this.googleIpAddress = source.googleIpAddress;
      this.googleReferenceId = source.googleReferenceId;
      this.id = source.id;
      this.interconnectAttachments = source.interconnectAttachments;
      this.interconnectType = source.interconnectType;
      this.kind = source.kind;
      this.linkType = source.linkType;
      this.location = source.location;
      this.name = source.name;
      this.nocContactEmail = source.nocContactEmail;
      this.operationalStatus = source.operationalStatus;
      this.peerIpAddress = source.peerIpAddress;
      this.provisionedLinkCount = source.provisionedLinkCount;
      this.requestedLinkCount = source.requestedLinkCount;
      this.selfLink = source.selfLink;
      this.state = source.state;
    }

    /**
     * Administrative status of the interconnect. When this is set to true, the Interconnect is
     * functional and can carry traffic. When set to false, no packets can be carried over the
     * interconnect and no BGP routes are exchanged over it. By default, the status is set to true.
     */
    public Boolean getAdminEnabled() {
      return adminEnabled;
    }

    /**
     * Administrative status of the interconnect. When this is set to true, the Interconnect is
     * functional and can carry traffic. When set to false, no packets can be carried over the
     * interconnect and no BGP routes are exchanged over it. By default, the status is set to true.
     */
    public Builder setAdminEnabled(Boolean adminEnabled) {
      this.adminEnabled = adminEnabled;
      return this;
    }

    /**
     * [Output Only] A list of CircuitInfo objects, that describe the individual circuits in this
     * LAG.
     */
    public List<InterconnectCircuitInfo> getCircuitInfosList() {
      return circuitInfos;
    }

    /**
     * [Output Only] A list of CircuitInfo objects, that describe the individual circuits in this
     * LAG.
     */
    public Builder addAllCircuitInfos(List<InterconnectCircuitInfo> circuitInfos) {
      if (this.circuitInfos == null) {
        this.circuitInfos = new LinkedList<>();
      }
      this.circuitInfos.addAll(circuitInfos);
      return this;
    }

    /**
     * [Output Only] A list of CircuitInfo objects, that describe the individual circuits in this
     * LAG.
     */
    public Builder addCircuitInfos(InterconnectCircuitInfo circuitInfos) {
      if (this.circuitInfos == null) {
        this.circuitInfos = new LinkedList<>();
      }
      this.circuitInfos.add(circuitInfos);
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
     * Customer name, to put in the Letter of Authorization as the party authorized to request a
     * crossconnect.
     */
    public String getCustomerName() {
      return customerName;
    }

    /**
     * Customer name, to put in the Letter of Authorization as the party authorized to request a
     * crossconnect.
     */
    public Builder setCustomerName(String customerName) {
      this.customerName = customerName;
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

    /** [Output Only] A list of outages expected for this Interconnect. */
    public List<InterconnectOutageNotification> getExpectedOutagesList() {
      return expectedOutages;
    }

    /** [Output Only] A list of outages expected for this Interconnect. */
    public Builder addAllExpectedOutages(List<InterconnectOutageNotification> expectedOutages) {
      if (this.expectedOutages == null) {
        this.expectedOutages = new LinkedList<>();
      }
      this.expectedOutages.addAll(expectedOutages);
      return this;
    }

    /** [Output Only] A list of outages expected for this Interconnect. */
    public Builder addExpectedOutages(InterconnectOutageNotification expectedOutages) {
      if (this.expectedOutages == null) {
        this.expectedOutages = new LinkedList<>();
      }
      this.expectedOutages.add(expectedOutages);
      return this;
    }

    /**
     * [Output Only] IP address configured on the Google side of the Interconnect link. This can be
     * used only for ping tests.
     */
    public String getGoogleIpAddress() {
      return googleIpAddress;
    }

    /**
     * [Output Only] IP address configured on the Google side of the Interconnect link. This can be
     * used only for ping tests.
     */
    public Builder setGoogleIpAddress(String googleIpAddress) {
      this.googleIpAddress = googleIpAddress;
      return this;
    }

    /**
     * [Output Only] Google reference ID to be used when raising support tickets with Google or
     * otherwise to debug backend connectivity issues.
     */
    public String getGoogleReferenceId() {
      return googleReferenceId;
    }

    /**
     * [Output Only] Google reference ID to be used when raising support tickets with Google or
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
     * [Output Only] A list of the URLs of all InterconnectAttachments configured to use this
     * Interconnect.
     */
    public List<String> getInterconnectAttachmentsList() {
      return interconnectAttachments;
    }

    /**
     * [Output Only] A list of the URLs of all InterconnectAttachments configured to use this
     * Interconnect.
     */
    public Builder addAllInterconnectAttachments(List<String> interconnectAttachments) {
      if (this.interconnectAttachments == null) {
        this.interconnectAttachments = new LinkedList<>();
      }
      this.interconnectAttachments.addAll(interconnectAttachments);
      return this;
    }

    /**
     * [Output Only] A list of the URLs of all InterconnectAttachments configured to use this
     * Interconnect.
     */
    public Builder addInterconnectAttachments(String interconnectAttachments) {
      if (this.interconnectAttachments == null) {
        this.interconnectAttachments = new LinkedList<>();
      }
      this.interconnectAttachments.add(interconnectAttachments);
      return this;
    }

    /**
     * Type of interconnect, which can take one of the following values: - PARTNER: A
     * partner-managed interconnection shared between customers though a partner. - DEDICATED: A
     * dedicated physical interconnection with the customer. Note that a value IT_PRIVATE has been
     * deprecated in favor of DEDICATED.
     */
    public String getInterconnectType() {
      return interconnectType;
    }

    /**
     * Type of interconnect, which can take one of the following values: - PARTNER: A
     * partner-managed interconnection shared between customers though a partner. - DEDICATED: A
     * dedicated physical interconnection with the customer. Note that a value IT_PRIVATE has been
     * deprecated in favor of DEDICATED.
     */
    public Builder setInterconnectType(String interconnectType) {
      this.interconnectType = interconnectType;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#interconnect for interconnects. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#interconnect for interconnects. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Type of link requested, which can take one of the following values: -
     * LINK_TYPE_ETHERNET_10G_LR: A 10G Ethernet with LR optics - LINK_TYPE_ETHERNET_100G_LR: A 100G
     * Ethernet with LR optics. Note that this field indicates the speed of each of the links in the
     * bundle, not the speed of the entire bundle.
     */
    public String getLinkType() {
      return linkType;
    }

    /**
     * Type of link requested, which can take one of the following values: -
     * LINK_TYPE_ETHERNET_10G_LR: A 10G Ethernet with LR optics - LINK_TYPE_ETHERNET_100G_LR: A 100G
     * Ethernet with LR optics. Note that this field indicates the speed of each of the links in the
     * bundle, not the speed of the entire bundle.
     */
    public Builder setLinkType(String linkType) {
      this.linkType = linkType;
      return this;
    }

    /**
     * URL of the InterconnectLocation object that represents where this connection is to be
     * provisioned.
     */
    public String getLocation() {
      return location;
    }

    /**
     * URL of the InterconnectLocation object that represents where this connection is to be
     * provisioned.
     */
    public Builder setLocation(String location) {
      this.location = location;
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
     * Email address to contact the customer NOC for operations and maintenance notifications
     * regarding this Interconnect. If specified, this will be used for notifications in addition to
     * all other forms described, such as Stackdriver logs alerting and Cloud Notifications.
     */
    public String getNocContactEmail() {
      return nocContactEmail;
    }

    /**
     * Email address to contact the customer NOC for operations and maintenance notifications
     * regarding this Interconnect. If specified, this will be used for notifications in addition to
     * all other forms described, such as Stackdriver logs alerting and Cloud Notifications.
     */
    public Builder setNocContactEmail(String nocContactEmail) {
      this.nocContactEmail = nocContactEmail;
      return this;
    }

    /**
     * [Output Only] The current status of this Interconnect's functionality, which can take one of
     * the following values: - OS_ACTIVE: A valid Interconnect, which is turned up and is ready to
     * use. Attachments may be provisioned on this Interconnect. - OS_UNPROVISIONED: An Interconnect
     * that has not completed turnup. No attachments may be provisioned on this Interconnect. -
     * OS_UNDER_MAINTENANCE: An Interconnect that is undergoing internal maintenance. No attachments
     * may be provisioned or updated on this Interconnect.
     */
    public String getOperationalStatus() {
      return operationalStatus;
    }

    /**
     * [Output Only] The current status of this Interconnect's functionality, which can take one of
     * the following values: - OS_ACTIVE: A valid Interconnect, which is turned up and is ready to
     * use. Attachments may be provisioned on this Interconnect. - OS_UNPROVISIONED: An Interconnect
     * that has not completed turnup. No attachments may be provisioned on this Interconnect. -
     * OS_UNDER_MAINTENANCE: An Interconnect that is undergoing internal maintenance. No attachments
     * may be provisioned or updated on this Interconnect.
     */
    public Builder setOperationalStatus(String operationalStatus) {
      this.operationalStatus = operationalStatus;
      return this;
    }

    /**
     * [Output Only] IP address configured on the customer side of the Interconnect link. The
     * customer should configure this IP address during turnup when prompted by Google NOC. This can
     * be used only for ping tests.
     */
    public String getPeerIpAddress() {
      return peerIpAddress;
    }

    /**
     * [Output Only] IP address configured on the customer side of the Interconnect link. The
     * customer should configure this IP address during turnup when prompted by Google NOC. This can
     * be used only for ping tests.
     */
    public Builder setPeerIpAddress(String peerIpAddress) {
      this.peerIpAddress = peerIpAddress;
      return this;
    }

    /** [Output Only] Number of links actually provisioned in this interconnect. */
    public Integer getProvisionedLinkCount() {
      return provisionedLinkCount;
    }

    /** [Output Only] Number of links actually provisioned in this interconnect. */
    public Builder setProvisionedLinkCount(Integer provisionedLinkCount) {
      this.provisionedLinkCount = provisionedLinkCount;
      return this;
    }

    /** Target number of physical links in the link bundle, as requested by the customer. */
    public Integer getRequestedLinkCount() {
      return requestedLinkCount;
    }

    /** Target number of physical links in the link bundle, as requested by the customer. */
    public Builder setRequestedLinkCount(Integer requestedLinkCount) {
      this.requestedLinkCount = requestedLinkCount;
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
     * [Output Only] The current state of Interconnect functionality, which can take one of the
     * following values: - ACTIVE: The Interconnect is valid, turned up and ready to use.
     * Attachments may be provisioned on this Interconnect. - UNPROVISIONED: The Interconnect has
     * not completed turnup. No attachments may be provisioned on this Interconnect. -
     * UNDER_MAINTENANCE: The Interconnect is undergoing internal maintenance. No attachments may be
     * provisioned or updated on this Interconnect.
     */
    public String getState() {
      return state;
    }

    /**
     * [Output Only] The current state of Interconnect functionality, which can take one of the
     * following values: - ACTIVE: The Interconnect is valid, turned up and ready to use.
     * Attachments may be provisioned on this Interconnect. - UNPROVISIONED: The Interconnect has
     * not completed turnup. No attachments may be provisioned on this Interconnect. -
     * UNDER_MAINTENANCE: The Interconnect is undergoing internal maintenance. No attachments may be
     * provisioned or updated on this Interconnect.
     */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public Interconnect build() {

      return new Interconnect(
          adminEnabled,
          circuitInfos,
          creationTimestamp,
          customerName,
          description,
          expectedOutages,
          googleIpAddress,
          googleReferenceId,
          id,
          interconnectAttachments,
          interconnectType,
          kind,
          linkType,
          location,
          name,
          nocContactEmail,
          operationalStatus,
          peerIpAddress,
          provisionedLinkCount,
          requestedLinkCount,
          selfLink,
          state);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAdminEnabled(this.adminEnabled);
      newBuilder.addAllCircuitInfos(this.circuitInfos);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setCustomerName(this.customerName);
      newBuilder.setDescription(this.description);
      newBuilder.addAllExpectedOutages(this.expectedOutages);
      newBuilder.setGoogleIpAddress(this.googleIpAddress);
      newBuilder.setGoogleReferenceId(this.googleReferenceId);
      newBuilder.setId(this.id);
      newBuilder.addAllInterconnectAttachments(this.interconnectAttachments);
      newBuilder.setInterconnectType(this.interconnectType);
      newBuilder.setKind(this.kind);
      newBuilder.setLinkType(this.linkType);
      newBuilder.setLocation(this.location);
      newBuilder.setName(this.name);
      newBuilder.setNocContactEmail(this.nocContactEmail);
      newBuilder.setOperationalStatus(this.operationalStatus);
      newBuilder.setPeerIpAddress(this.peerIpAddress);
      newBuilder.setProvisionedLinkCount(this.provisionedLinkCount);
      newBuilder.setRequestedLinkCount(this.requestedLinkCount);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setState(this.state);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Interconnect{"
        + "adminEnabled="
        + adminEnabled
        + ", "
        + "circuitInfos="
        + circuitInfos
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "customerName="
        + customerName
        + ", "
        + "description="
        + description
        + ", "
        + "expectedOutages="
        + expectedOutages
        + ", "
        + "googleIpAddress="
        + googleIpAddress
        + ", "
        + "googleReferenceId="
        + googleReferenceId
        + ", "
        + "id="
        + id
        + ", "
        + "interconnectAttachments="
        + interconnectAttachments
        + ", "
        + "interconnectType="
        + interconnectType
        + ", "
        + "kind="
        + kind
        + ", "
        + "linkType="
        + linkType
        + ", "
        + "location="
        + location
        + ", "
        + "name="
        + name
        + ", "
        + "nocContactEmail="
        + nocContactEmail
        + ", "
        + "operationalStatus="
        + operationalStatus
        + ", "
        + "peerIpAddress="
        + peerIpAddress
        + ", "
        + "provisionedLinkCount="
        + provisionedLinkCount
        + ", "
        + "requestedLinkCount="
        + requestedLinkCount
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "state="
        + state
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Interconnect) {
      Interconnect that = (Interconnect) o;
      return Objects.equals(this.adminEnabled, that.getAdminEnabled())
          && Objects.equals(this.circuitInfos, that.getCircuitInfosList())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.customerName, that.getCustomerName())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.expectedOutages, that.getExpectedOutagesList())
          && Objects.equals(this.googleIpAddress, that.getGoogleIpAddress())
          && Objects.equals(this.googleReferenceId, that.getGoogleReferenceId())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.interconnectAttachments, that.getInterconnectAttachmentsList())
          && Objects.equals(this.interconnectType, that.getInterconnectType())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.linkType, that.getLinkType())
          && Objects.equals(this.location, that.getLocation())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.nocContactEmail, that.getNocContactEmail())
          && Objects.equals(this.operationalStatus, that.getOperationalStatus())
          && Objects.equals(this.peerIpAddress, that.getPeerIpAddress())
          && Objects.equals(this.provisionedLinkCount, that.getProvisionedLinkCount())
          && Objects.equals(this.requestedLinkCount, that.getRequestedLinkCount())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.state, that.getState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        adminEnabled,
        circuitInfos,
        creationTimestamp,
        customerName,
        description,
        expectedOutages,
        googleIpAddress,
        googleReferenceId,
        id,
        interconnectAttachments,
        interconnectType,
        kind,
        linkType,
        location,
        name,
        nocContactEmail,
        operationalStatus,
        peerIpAddress,
        provisionedLinkCount,
        requestedLinkCount,
        selfLink,
        state);
  }
}
