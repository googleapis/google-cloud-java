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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InterconnectAttachment implements ApiMessage {
  private final String cloudRouterIpAddress;
  private final String creationTimestamp;
  private final String customerRouterIpAddress;
  private final String description;
  private final String googleReferenceId;
  private final String id;
  private final String interconnect;
  private final String kind;
  private final String name;
  private final String operationalStatus;
  private final InterconnectAttachmentPrivateInfo privateInterconnectInfo;
  private final String region;
  private final String router;
  private final String selfLink;

  private InterconnectAttachment() {
    this.cloudRouterIpAddress = null;
    this.creationTimestamp = null;
    this.customerRouterIpAddress = null;
    this.description = null;
    this.googleReferenceId = null;
    this.id = null;
    this.interconnect = null;
    this.kind = null;
    this.name = null;
    this.operationalStatus = null;
    this.privateInterconnectInfo = null;
    this.region = null;
    this.router = null;
    this.selfLink = null;
  }

  private InterconnectAttachment(
      String cloudRouterIpAddress,
      String creationTimestamp,
      String customerRouterIpAddress,
      String description,
      String googleReferenceId,
      String id,
      String interconnect,
      String kind,
      String name,
      String operationalStatus,
      InterconnectAttachmentPrivateInfo privateInterconnectInfo,
      String region,
      String router,
      String selfLink) {
    this.cloudRouterIpAddress = cloudRouterIpAddress;
    this.creationTimestamp = creationTimestamp;
    this.customerRouterIpAddress = customerRouterIpAddress;
    this.description = description;
    this.googleReferenceId = googleReferenceId;
    this.id = id;
    this.interconnect = interconnect;
    this.kind = kind;
    this.name = name;
    this.operationalStatus = operationalStatus;
    this.privateInterconnectInfo = privateInterconnectInfo;
    this.region = region;
    this.router = router;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("cloudRouterIpAddress")) {
      return cloudRouterIpAddress;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("customerRouterIpAddress")) {
      return customerRouterIpAddress;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("googleReferenceId")) {
      return googleReferenceId;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("interconnect")) {
      return interconnect;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("operationalStatus")) {
      return operationalStatus;
    }
    if (fieldName.equals("privateInterconnectInfo")) {
      return privateInterconnectInfo;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("router")) {
      return router;
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
    private String cloudRouterIpAddress;
    private String creationTimestamp;
    private String customerRouterIpAddress;
    private String description;
    private String googleReferenceId;
    private String id;
    private String interconnect;
    private String kind;
    private String name;
    private String operationalStatus;
    private InterconnectAttachmentPrivateInfo privateInterconnectInfo;
    private String region;
    private String router;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(InterconnectAttachment other) {
      if (other == InterconnectAttachment.getDefaultInstance()) return this;
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
      return this;
    }

    Builder(InterconnectAttachment source) {
      this.cloudRouterIpAddress = source.cloudRouterIpAddress;
      this.creationTimestamp = source.creationTimestamp;
      this.customerRouterIpAddress = source.customerRouterIpAddress;
      this.description = source.description;
      this.googleReferenceId = source.googleReferenceId;
      this.id = source.id;
      this.interconnect = source.interconnect;
      this.kind = source.kind;
      this.name = source.name;
      this.operationalStatus = source.operationalStatus;
      this.privateInterconnectInfo = source.privateInterconnectInfo;
      this.region = source.region;
      this.router = source.router;
      this.selfLink = source.selfLink;
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

    public InterconnectAttachment build() {

      return new InterconnectAttachment(
          cloudRouterIpAddress,
          creationTimestamp,
          customerRouterIpAddress,
          description,
          googleReferenceId,
          id,
          interconnect,
          kind,
          name,
          operationalStatus,
          privateInterconnectInfo,
          region,
          router,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCloudRouterIpAddress(this.cloudRouterIpAddress);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setCustomerRouterIpAddress(this.customerRouterIpAddress);
      newBuilder.setDescription(this.description);
      newBuilder.setGoogleReferenceId(this.googleReferenceId);
      newBuilder.setId(this.id);
      newBuilder.setInterconnect(this.interconnect);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setOperationalStatus(this.operationalStatus);
      newBuilder.setPrivateInterconnectInfo(this.privateInterconnectInfo);
      newBuilder.setRegion(this.region);
      newBuilder.setRouter(this.router);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectAttachment{"
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
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectAttachment) {
      InterconnectAttachment that = (InterconnectAttachment) o;
      return Objects.equals(this.cloudRouterIpAddress, that.getCloudRouterIpAddress())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.customerRouterIpAddress, that.getCustomerRouterIpAddress())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.googleReferenceId, that.getGoogleReferenceId())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.interconnect, that.getInterconnect())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.operationalStatus, that.getOperationalStatus())
          && Objects.equals(this.privateInterconnectInfo, that.getPrivateInterconnectInfo())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.router, that.getRouter())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cloudRouterIpAddress,
        creationTimestamp,
        customerRouterIpAddress,
        description,
        googleReferenceId,
        id,
        interconnect,
        kind,
        name,
        operationalStatus,
        privateInterconnectInfo,
        region,
        router,
        selfLink);
  }
}
