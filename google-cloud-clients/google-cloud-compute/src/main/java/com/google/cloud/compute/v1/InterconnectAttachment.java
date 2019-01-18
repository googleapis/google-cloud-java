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
  public List<String> getFieldMask() {
    return null;
  }

  public Boolean getAdminEnabled() {
    return adminEnabled;
  }

  public String getBandwidth() {
    return bandwidth;
  }

  public List<String> getCandidateSubnetsList() {
    return candidateSubnets;
  }

  public String getCloudRouterIpAddress() {
    return cloudRouterIpAddress;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getCustomerRouterIpAddress() {
    return customerRouterIpAddress;
  }

  public String getDescription() {
    return description;
  }

  public String getEdgeAvailabilityDomain() {
    return edgeAvailabilityDomain;
  }

  public String getGoogleReferenceId() {
    return googleReferenceId;
  }

  public String getId() {
    return id;
  }

  public String getInterconnect() {
    return interconnect;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getOperationalStatus() {
    return operationalStatus;
  }

  public String getPairingKey() {
    return pairingKey;
  }

  public String getPartnerAsn() {
    return partnerAsn;
  }

  public InterconnectAttachmentPartnerMetadata getPartnerMetadata() {
    return partnerMetadata;
  }

  public InterconnectAttachmentPrivateInfo getPrivateInterconnectInfo() {
    return privateInterconnectInfo;
  }

  public String getRegion() {
    return region;
  }

  public String getRouter() {
    return router;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getState() {
    return state;
  }

  public String getType() {
    return type;
  }

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

    public Boolean getAdminEnabled() {
      return adminEnabled;
    }

    public Builder setAdminEnabled(Boolean adminEnabled) {
      this.adminEnabled = adminEnabled;
      return this;
    }

    public String getBandwidth() {
      return bandwidth;
    }

    public Builder setBandwidth(String bandwidth) {
      this.bandwidth = bandwidth;
      return this;
    }

    public List<String> getCandidateSubnetsList() {
      return candidateSubnets;
    }

    public Builder addAllCandidateSubnets(List<String> candidateSubnets) {
      if (this.candidateSubnets == null) {
        this.candidateSubnets = new LinkedList<>();
      }
      this.candidateSubnets.addAll(candidateSubnets);
      return this;
    }

    public Builder addCandidateSubnets(String candidateSubnets) {
      if (this.candidateSubnets == null) {
        this.candidateSubnets = new LinkedList<>();
      }
      this.candidateSubnets.add(candidateSubnets);
      return this;
    }

    public String getCloudRouterIpAddress() {
      return cloudRouterIpAddress;
    }

    public Builder setCloudRouterIpAddress(String cloudRouterIpAddress) {
      this.cloudRouterIpAddress = cloudRouterIpAddress;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getCustomerRouterIpAddress() {
      return customerRouterIpAddress;
    }

    public Builder setCustomerRouterIpAddress(String customerRouterIpAddress) {
      this.customerRouterIpAddress = customerRouterIpAddress;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getEdgeAvailabilityDomain() {
      return edgeAvailabilityDomain;
    }

    public Builder setEdgeAvailabilityDomain(String edgeAvailabilityDomain) {
      this.edgeAvailabilityDomain = edgeAvailabilityDomain;
      return this;
    }

    public String getGoogleReferenceId() {
      return googleReferenceId;
    }

    public Builder setGoogleReferenceId(String googleReferenceId) {
      this.googleReferenceId = googleReferenceId;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getInterconnect() {
      return interconnect;
    }

    public Builder setInterconnect(String interconnect) {
      this.interconnect = interconnect;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getOperationalStatus() {
      return operationalStatus;
    }

    public Builder setOperationalStatus(String operationalStatus) {
      this.operationalStatus = operationalStatus;
      return this;
    }

    public String getPairingKey() {
      return pairingKey;
    }

    public Builder setPairingKey(String pairingKey) {
      this.pairingKey = pairingKey;
      return this;
    }

    public String getPartnerAsn() {
      return partnerAsn;
    }

    public Builder setPartnerAsn(String partnerAsn) {
      this.partnerAsn = partnerAsn;
      return this;
    }

    public InterconnectAttachmentPartnerMetadata getPartnerMetadata() {
      return partnerMetadata;
    }

    public Builder setPartnerMetadata(InterconnectAttachmentPartnerMetadata partnerMetadata) {
      this.partnerMetadata = partnerMetadata;
      return this;
    }

    public InterconnectAttachmentPrivateInfo getPrivateInterconnectInfo() {
      return privateInterconnectInfo;
    }

    public Builder setPrivateInterconnectInfo(
        InterconnectAttachmentPrivateInfo privateInterconnectInfo) {
      this.privateInterconnectInfo = privateInterconnectInfo;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getRouter() {
      return router;
    }

    public Builder setRouter(String router) {
      this.router = router;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public Integer getVlanTag8021q() {
      return vlanTag8021q;
    }

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
