/*
 * Copyright 2018 Google LLC
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
      String selfLink) {
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
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("adminEnabled")) {
      return adminEnabled;
    }
    if (fieldName.equals("circuitInfos")) {
      return circuitInfos;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("customerName")) {
      return customerName;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("expectedOutages")) {
      return expectedOutages;
    }
    if (fieldName.equals("googleIpAddress")) {
      return googleIpAddress;
    }
    if (fieldName.equals("googleReferenceId")) {
      return googleReferenceId;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("interconnectAttachments")) {
      return interconnectAttachments;
    }
    if (fieldName.equals("interconnectType")) {
      return interconnectType;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("linkType")) {
      return linkType;
    }
    if (fieldName.equals("location")) {
      return location;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("nocContactEmail")) {
      return nocContactEmail;
    }
    if (fieldName.equals("operationalStatus")) {
      return operationalStatus;
    }
    if (fieldName.equals("peerIpAddress")) {
      return peerIpAddress;
    }
    if (fieldName.equals("provisionedLinkCount")) {
      return provisionedLinkCount;
    }
    if (fieldName.equals("requestedLinkCount")) {
      return requestedLinkCount;
    }
    if (fieldName.equals("selfLink")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public Boolean getAdminEnabled() {
    return adminEnabled;
  }

  public List<InterconnectCircuitInfo> getCircuitInfosList() {
    return circuitInfos;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getDescription() {
    return description;
  }

  public List<InterconnectOutageNotification> getExpectedOutagesList() {
    return expectedOutages;
  }

  public String getGoogleIpAddress() {
    return googleIpAddress;
  }

  public String getGoogleReferenceId() {
    return googleReferenceId;
  }

  public String getId() {
    return id;
  }

  public List<String> getInterconnectAttachmentsList() {
    return interconnectAttachments;
  }

  public String getInterconnectType() {
    return interconnectType;
  }

  public String getKind() {
    return kind;
  }

  public String getLinkType() {
    return linkType;
  }

  public String getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

  public String getNocContactEmail() {
    return nocContactEmail;
  }

  public String getOperationalStatus() {
    return operationalStatus;
  }

  public String getPeerIpAddress() {
    return peerIpAddress;
  }

  public Integer getProvisionedLinkCount() {
    return provisionedLinkCount;
  }

  public Integer getRequestedLinkCount() {
    return requestedLinkCount;
  }

  public String getSelfLink() {
    return selfLink;
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
    }

    public Boolean getAdminEnabled() {
      return adminEnabled;
    }

    public Builder setAdminEnabled(Boolean adminEnabled) {
      this.adminEnabled = adminEnabled;
      return this;
    }

    public List<InterconnectCircuitInfo> getCircuitInfosList() {
      return circuitInfos;
    }

    public Builder addAllCircuitInfos(List<InterconnectCircuitInfo> circuitInfos) {
      if (this.circuitInfos == null) {
        this.circuitInfos = new ArrayList<>(circuitInfos.size());
      }
      this.circuitInfos.addAll(circuitInfos);
      return this;
    }

    public Builder addCircuitInfos(InterconnectCircuitInfo circuitInfos) {
      this.circuitInfos.add(circuitInfos);
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getCustomerName() {
      return customerName;
    }

    public Builder setCustomerName(String customerName) {
      this.customerName = customerName;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public List<InterconnectOutageNotification> getExpectedOutagesList() {
      return expectedOutages;
    }

    public Builder addAllExpectedOutages(List<InterconnectOutageNotification> expectedOutages) {
      if (this.expectedOutages == null) {
        this.expectedOutages = new ArrayList<>(expectedOutages.size());
      }
      this.expectedOutages.addAll(expectedOutages);
      return this;
    }

    public Builder addExpectedOutages(InterconnectOutageNotification expectedOutages) {
      this.expectedOutages.add(expectedOutages);
      return this;
    }

    public String getGoogleIpAddress() {
      return googleIpAddress;
    }

    public Builder setGoogleIpAddress(String googleIpAddress) {
      this.googleIpAddress = googleIpAddress;
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

    public List<String> getInterconnectAttachmentsList() {
      return interconnectAttachments;
    }

    public Builder addAllInterconnectAttachments(List<String> interconnectAttachments) {
      if (this.interconnectAttachments == null) {
        this.interconnectAttachments = new ArrayList<>(interconnectAttachments.size());
      }
      this.interconnectAttachments.addAll(interconnectAttachments);
      return this;
    }

    public Builder addInterconnectAttachments(String interconnectAttachments) {
      this.interconnectAttachments.add(interconnectAttachments);
      return this;
    }

    public String getInterconnectType() {
      return interconnectType;
    }

    public Builder setInterconnectType(String interconnectType) {
      this.interconnectType = interconnectType;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getLinkType() {
      return linkType;
    }

    public Builder setLinkType(String linkType) {
      this.linkType = linkType;
      return this;
    }

    public String getLocation() {
      return location;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getNocContactEmail() {
      return nocContactEmail;
    }

    public Builder setNocContactEmail(String nocContactEmail) {
      this.nocContactEmail = nocContactEmail;
      return this;
    }

    public String getOperationalStatus() {
      return operationalStatus;
    }

    public Builder setOperationalStatus(String operationalStatus) {
      this.operationalStatus = operationalStatus;
      return this;
    }

    public String getPeerIpAddress() {
      return peerIpAddress;
    }

    public Builder setPeerIpAddress(String peerIpAddress) {
      this.peerIpAddress = peerIpAddress;
      return this;
    }

    public Integer getProvisionedLinkCount() {
      return provisionedLinkCount;
    }

    public Builder setProvisionedLinkCount(Integer provisionedLinkCount) {
      this.provisionedLinkCount = provisionedLinkCount;
      return this;
    }

    public Integer getRequestedLinkCount() {
      return requestedLinkCount;
    }

    public Builder setRequestedLinkCount(Integer requestedLinkCount) {
      this.requestedLinkCount = requestedLinkCount;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
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
          selfLink);
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
          && Objects.equals(this.selfLink, that.getSelfLink());
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
        selfLink);
  }
}
