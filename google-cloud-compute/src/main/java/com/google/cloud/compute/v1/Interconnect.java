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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("adminEnabled") && adminEnabled != null) {
      fieldMap.put("adminEnabled", Collections.singletonList(String.valueOf(adminEnabled)));
    }
    if (fieldNames.contains("circuitInfos") && circuitInfos != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (InterconnectCircuitInfo item : circuitInfos) {
        stringList.add(item.toString());
      }
      fieldMap.put("circuitInfos", stringList.build());
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put(
          "creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("customerName") && customerName != null) {
      fieldMap.put("customerName", Collections.singletonList(String.valueOf(customerName)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("expectedOutages") && expectedOutages != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (InterconnectOutageNotification item : expectedOutages) {
        stringList.add(item.toString());
      }
      fieldMap.put("expectedOutages", stringList.build());
    }
    if (fieldNames.contains("googleIpAddress") && googleIpAddress != null) {
      fieldMap.put("googleIpAddress", Collections.singletonList(String.valueOf(googleIpAddress)));
    }
    if (fieldNames.contains("googleReferenceId") && googleReferenceId != null) {
      fieldMap.put(
          "googleReferenceId", Collections.singletonList(String.valueOf(googleReferenceId)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("interconnectAttachments") && interconnectAttachments != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : interconnectAttachments) {
        stringList.add(item.toString());
      }
      fieldMap.put("interconnectAttachments", stringList.build());
    }
    if (fieldNames.contains("interconnectType") && interconnectType != null) {
      fieldMap.put("interconnectType", Collections.singletonList(String.valueOf(interconnectType)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("linkType") && linkType != null) {
      fieldMap.put("linkType", Collections.singletonList(String.valueOf(linkType)));
    }
    if (fieldNames.contains("location") && location != null) {
      fieldMap.put("location", Collections.singletonList(String.valueOf(location)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("nocContactEmail") && nocContactEmail != null) {
      fieldMap.put("nocContactEmail", Collections.singletonList(String.valueOf(nocContactEmail)));
    }
    if (fieldNames.contains("operationalStatus") && operationalStatus != null) {
      fieldMap.put(
          "operationalStatus", Collections.singletonList(String.valueOf(operationalStatus)));
    }
    if (fieldNames.contains("peerIpAddress") && peerIpAddress != null) {
      fieldMap.put("peerIpAddress", Collections.singletonList(String.valueOf(peerIpAddress)));
    }
    if (fieldNames.contains("provisionedLinkCount") && provisionedLinkCount != null) {
      fieldMap.put(
          "provisionedLinkCount", Collections.singletonList(String.valueOf(provisionedLinkCount)));
    }
    if (fieldNames.contains("requestedLinkCount") && requestedLinkCount != null) {
      fieldMap.put(
          "requestedLinkCount", Collections.singletonList(String.valueOf(requestedLinkCount)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("adminEnabled")) {
      return String.valueOf(adminEnabled);
    }
    if (fieldName.equals("circuitInfos")) {
      return String.valueOf(circuitInfos);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("customerName")) {
      return String.valueOf(customerName);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("expectedOutages")) {
      return String.valueOf(expectedOutages);
    }
    if (fieldName.equals("googleIpAddress")) {
      return String.valueOf(googleIpAddress);
    }
    if (fieldName.equals("googleReferenceId")) {
      return String.valueOf(googleReferenceId);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("interconnectAttachments")) {
      return String.valueOf(interconnectAttachments);
    }
    if (fieldName.equals("interconnectType")) {
      return String.valueOf(interconnectType);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("linkType")) {
      return String.valueOf(linkType);
    }
    if (fieldName.equals("location")) {
      return String.valueOf(location);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("nocContactEmail")) {
      return String.valueOf(nocContactEmail);
    }
    if (fieldName.equals("operationalStatus")) {
      return String.valueOf(operationalStatus);
    }
    if (fieldName.equals("peerIpAddress")) {
      return String.valueOf(peerIpAddress);
    }
    if (fieldName.equals("provisionedLinkCount")) {
      return String.valueOf(provisionedLinkCount);
    }
    if (fieldName.equals("requestedLinkCount")) {
      return String.valueOf(requestedLinkCount);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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
