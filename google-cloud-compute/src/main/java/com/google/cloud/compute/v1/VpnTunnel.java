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
public final class VpnTunnel implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String detailedStatus;
  private final String id;
  private final Integer ikeVersion;
  private final String kind;
  private final List<String> localTrafficSelector;
  private final String name;
  private final String peerIp;
  private final String region;
  private final List<String> remoteTrafficSelector;
  private final String router;
  private final String selfLink;
  private final String sharedSecret;
  private final String sharedSecretHash;
  private final String status;
  private final String targetVpnGateway;

  private VpnTunnel() {
    this.creationTimestamp = null;
    this.description = null;
    this.detailedStatus = null;
    this.id = null;
    this.ikeVersion = null;
    this.kind = null;
    this.localTrafficSelector = null;
    this.name = null;
    this.peerIp = null;
    this.region = null;
    this.remoteTrafficSelector = null;
    this.router = null;
    this.selfLink = null;
    this.sharedSecret = null;
    this.sharedSecretHash = null;
    this.status = null;
    this.targetVpnGateway = null;
  }

  private VpnTunnel(
      String creationTimestamp,
      String description,
      String detailedStatus,
      String id,
      Integer ikeVersion,
      String kind,
      List<String> localTrafficSelector,
      String name,
      String peerIp,
      String region,
      List<String> remoteTrafficSelector,
      String router,
      String selfLink,
      String sharedSecret,
      String sharedSecretHash,
      String status,
      String targetVpnGateway) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.detailedStatus = detailedStatus;
    this.id = id;
    this.ikeVersion = ikeVersion;
    this.kind = kind;
    this.localTrafficSelector = localTrafficSelector;
    this.name = name;
    this.peerIp = peerIp;
    this.region = region;
    this.remoteTrafficSelector = remoteTrafficSelector;
    this.router = router;
    this.selfLink = selfLink;
    this.sharedSecret = sharedSecret;
    this.sharedSecretHash = sharedSecretHash;
    this.status = status;
    this.targetVpnGateway = targetVpnGateway;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put(
          "creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("detailedStatus") && detailedStatus != null) {
      fieldMap.put("detailedStatus", Collections.singletonList(String.valueOf(detailedStatus)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("ikeVersion") && ikeVersion != null) {
      fieldMap.put("ikeVersion", Collections.singletonList(String.valueOf(ikeVersion)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("localTrafficSelector") && localTrafficSelector != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : localTrafficSelector) {
        stringList.add(item.toString());
      }
      fieldMap.put("localTrafficSelector", stringList.build());
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("peerIp") && peerIp != null) {
      fieldMap.put("peerIp", Collections.singletonList(String.valueOf(peerIp)));
    }
    if (fieldNames.contains("region") && region != null) {
      fieldMap.put("region", Collections.singletonList(String.valueOf(region)));
    }
    if (fieldNames.contains("remoteTrafficSelector") && remoteTrafficSelector != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : remoteTrafficSelector) {
        stringList.add(item.toString());
      }
      fieldMap.put("remoteTrafficSelector", stringList.build());
    }
    if (fieldNames.contains("router") && router != null) {
      fieldMap.put("router", Collections.singletonList(String.valueOf(router)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("sharedSecret") && sharedSecret != null) {
      fieldMap.put("sharedSecret", Collections.singletonList(String.valueOf(sharedSecret)));
    }
    if (fieldNames.contains("sharedSecretHash") && sharedSecretHash != null) {
      fieldMap.put("sharedSecretHash", Collections.singletonList(String.valueOf(sharedSecretHash)));
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    if (fieldNames.contains("targetVpnGateway") && targetVpnGateway != null) {
      fieldMap.put("targetVpnGateway", Collections.singletonList(String.valueOf(targetVpnGateway)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("detailedStatus")) {
      return String.valueOf(detailedStatus);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("ikeVersion")) {
      return String.valueOf(ikeVersion);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("localTrafficSelector")) {
      return String.valueOf(localTrafficSelector);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("peerIp")) {
      return String.valueOf(peerIp);
    }
    if (fieldName.equals("region")) {
      return String.valueOf(region);
    }
    if (fieldName.equals("remoteTrafficSelector")) {
      return String.valueOf(remoteTrafficSelector);
    }
    if (fieldName.equals("router")) {
      return String.valueOf(router);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("sharedSecret")) {
      return String.valueOf(sharedSecret);
    }
    if (fieldName.equals("sharedSecretHash")) {
      return String.valueOf(sharedSecretHash);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    if (fieldName.equals("targetVpnGateway")) {
      return String.valueOf(targetVpnGateway);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getDetailedStatus() {
    return detailedStatus;
  }

  public String getId() {
    return id;
  }

  public Integer getIkeVersion() {
    return ikeVersion;
  }

  public String getKind() {
    return kind;
  }

  public List<String> getLocalTrafficSelectorList() {
    return localTrafficSelector;
  }

  public String getName() {
    return name;
  }

  public String getPeerIp() {
    return peerIp;
  }

  public String getRegion() {
    return region;
  }

  public List<String> getRemoteTrafficSelectorList() {
    return remoteTrafficSelector;
  }

  public String getRouter() {
    return router;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getSharedSecret() {
    return sharedSecret;
  }

  public String getSharedSecretHash() {
    return sharedSecretHash;
  }

  public String getStatus() {
    return status;
  }

  public String getTargetVpnGateway() {
    return targetVpnGateway;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VpnTunnel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VpnTunnel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VpnTunnel DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VpnTunnel();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String detailedStatus;
    private String id;
    private Integer ikeVersion;
    private String kind;
    private List<String> localTrafficSelector;
    private String name;
    private String peerIp;
    private String region;
    private List<String> remoteTrafficSelector;
    private String router;
    private String selfLink;
    private String sharedSecret;
    private String sharedSecretHash;
    private String status;
    private String targetVpnGateway;

    Builder() {}

    public Builder mergeFrom(VpnTunnel other) {
      if (other == VpnTunnel.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDetailedStatus() != null) {
        this.detailedStatus = other.detailedStatus;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getIkeVersion() != null) {
        this.ikeVersion = other.ikeVersion;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLocalTrafficSelectorList() != null) {
        this.localTrafficSelector = other.localTrafficSelector;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPeerIp() != null) {
        this.peerIp = other.peerIp;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getRemoteTrafficSelectorList() != null) {
        this.remoteTrafficSelector = other.remoteTrafficSelector;
      }
      if (other.getRouter() != null) {
        this.router = other.router;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSharedSecret() != null) {
        this.sharedSecret = other.sharedSecret;
      }
      if (other.getSharedSecretHash() != null) {
        this.sharedSecretHash = other.sharedSecretHash;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getTargetVpnGateway() != null) {
        this.targetVpnGateway = other.targetVpnGateway;
      }
      return this;
    }

    Builder(VpnTunnel source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.detailedStatus = source.detailedStatus;
      this.id = source.id;
      this.ikeVersion = source.ikeVersion;
      this.kind = source.kind;
      this.localTrafficSelector = source.localTrafficSelector;
      this.name = source.name;
      this.peerIp = source.peerIp;
      this.region = source.region;
      this.remoteTrafficSelector = source.remoteTrafficSelector;
      this.router = source.router;
      this.selfLink = source.selfLink;
      this.sharedSecret = source.sharedSecret;
      this.sharedSecretHash = source.sharedSecretHash;
      this.status = source.status;
      this.targetVpnGateway = source.targetVpnGateway;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getDetailedStatus() {
      return detailedStatus;
    }

    public Builder setDetailedStatus(String detailedStatus) {
      this.detailedStatus = detailedStatus;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Integer getIkeVersion() {
      return ikeVersion;
    }

    public Builder setIkeVersion(Integer ikeVersion) {
      this.ikeVersion = ikeVersion;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public List<String> getLocalTrafficSelectorList() {
      return localTrafficSelector;
    }

    public Builder addAllLocalTrafficSelector(List<String> localTrafficSelector) {
      if (this.localTrafficSelector == null) {
        this.localTrafficSelector = new ArrayList<>(localTrafficSelector.size());
      }
      this.localTrafficSelector.addAll(localTrafficSelector);
      return this;
    }

    public Builder addLocalTrafficSelector(String localTrafficSelector) {
      this.localTrafficSelector.add(localTrafficSelector);
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getPeerIp() {
      return peerIp;
    }

    public Builder setPeerIp(String peerIp) {
      this.peerIp = peerIp;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public List<String> getRemoteTrafficSelectorList() {
      return remoteTrafficSelector;
    }

    public Builder addAllRemoteTrafficSelector(List<String> remoteTrafficSelector) {
      if (this.remoteTrafficSelector == null) {
        this.remoteTrafficSelector = new ArrayList<>(remoteTrafficSelector.size());
      }
      this.remoteTrafficSelector.addAll(remoteTrafficSelector);
      return this;
    }

    public Builder addRemoteTrafficSelector(String remoteTrafficSelector) {
      this.remoteTrafficSelector.add(remoteTrafficSelector);
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

    public String getSharedSecret() {
      return sharedSecret;
    }

    public Builder setSharedSecret(String sharedSecret) {
      this.sharedSecret = sharedSecret;
      return this;
    }

    public String getSharedSecretHash() {
      return sharedSecretHash;
    }

    public Builder setSharedSecretHash(String sharedSecretHash) {
      this.sharedSecretHash = sharedSecretHash;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getTargetVpnGateway() {
      return targetVpnGateway;
    }

    public Builder setTargetVpnGateway(String targetVpnGateway) {
      this.targetVpnGateway = targetVpnGateway;
      return this;
    }

    public VpnTunnel build() {

      return new VpnTunnel(
          creationTimestamp,
          description,
          detailedStatus,
          id,
          ikeVersion,
          kind,
          localTrafficSelector,
          name,
          peerIp,
          region,
          remoteTrafficSelector,
          router,
          selfLink,
          sharedSecret,
          sharedSecretHash,
          status,
          targetVpnGateway);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setDetailedStatus(this.detailedStatus);
      newBuilder.setId(this.id);
      newBuilder.setIkeVersion(this.ikeVersion);
      newBuilder.setKind(this.kind);
      newBuilder.addAllLocalTrafficSelector(this.localTrafficSelector);
      newBuilder.setName(this.name);
      newBuilder.setPeerIp(this.peerIp);
      newBuilder.setRegion(this.region);
      newBuilder.addAllRemoteTrafficSelector(this.remoteTrafficSelector);
      newBuilder.setRouter(this.router);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSharedSecret(this.sharedSecret);
      newBuilder.setSharedSecretHash(this.sharedSecretHash);
      newBuilder.setStatus(this.status);
      newBuilder.setTargetVpnGateway(this.targetVpnGateway);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VpnTunnel{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "detailedStatus="
        + detailedStatus
        + ", "
        + "id="
        + id
        + ", "
        + "ikeVersion="
        + ikeVersion
        + ", "
        + "kind="
        + kind
        + ", "
        + "localTrafficSelector="
        + localTrafficSelector
        + ", "
        + "name="
        + name
        + ", "
        + "peerIp="
        + peerIp
        + ", "
        + "region="
        + region
        + ", "
        + "remoteTrafficSelector="
        + remoteTrafficSelector
        + ", "
        + "router="
        + router
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sharedSecret="
        + sharedSecret
        + ", "
        + "sharedSecretHash="
        + sharedSecretHash
        + ", "
        + "status="
        + status
        + ", "
        + "targetVpnGateway="
        + targetVpnGateway
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VpnTunnel) {
      VpnTunnel that = (VpnTunnel) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.detailedStatus, that.getDetailedStatus())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.ikeVersion, that.getIkeVersion())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.localTrafficSelector, that.getLocalTrafficSelectorList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.peerIp, that.getPeerIp())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.remoteTrafficSelector, that.getRemoteTrafficSelectorList())
          && Objects.equals(this.router, that.getRouter())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sharedSecret, that.getSharedSecret())
          && Objects.equals(this.sharedSecretHash, that.getSharedSecretHash())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.targetVpnGateway, that.getTargetVpnGateway());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        detailedStatus,
        id,
        ikeVersion,
        kind,
        localTrafficSelector,
        name,
        peerIp,
        region,
        remoteTrafficSelector,
        router,
        selfLink,
        sharedSecret,
        sharedSecretHash,
        status,
        targetVpnGateway);
  }
}
