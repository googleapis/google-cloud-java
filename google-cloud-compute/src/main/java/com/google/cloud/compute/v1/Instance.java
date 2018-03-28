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
import com.google.common.collect.ImmutableMap;
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
public final class Instance implements ApiMessage {
  private final Boolean canIpForward;
  private final String cpuPlatform;
  private final String creationTimestamp;
  private final String description;
  private final List<AttachedDisk> disks;
  private final String id;
  private final String kind;
  private final String machineType;
  private final Metadata metadata;
  private final String name;
  private final List<NetworkInterface> networkInterfaces;
  private final Scheduling scheduling;
  private final String selfLink;
  private final List<ServiceAccount> serviceAccounts;
  private final String status;
  private final String statusMessage;
  private final Tags tags;
  private final String zone;

  private Instance() {
    this.canIpForward = null;
    this.cpuPlatform = null;
    this.creationTimestamp = null;
    this.description = null;
    this.disks = null;
    this.id = null;
    this.kind = null;
    this.machineType = null;
    this.metadata = null;
    this.name = null;
    this.networkInterfaces = null;
    this.scheduling = null;
    this.selfLink = null;
    this.serviceAccounts = null;
    this.status = null;
    this.statusMessage = null;
    this.tags = null;
    this.zone = null;
  }


  private Instance(
      Boolean canIpForward,
      String cpuPlatform,
      String creationTimestamp,
      String description,
      List<AttachedDisk> disks,
      String id,
      String kind,
      String machineType,
      Metadata metadata,
      String name,
      List<NetworkInterface> networkInterfaces,
      Scheduling scheduling,
      String selfLink,
      List<ServiceAccount> serviceAccounts,
      String status,
      String statusMessage,
      Tags tags,
      String zone
      ) {
    this.canIpForward = canIpForward;
    this.cpuPlatform = cpuPlatform;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.disks = disks;
    this.id = id;
    this.kind = kind;
    this.machineType = machineType;
    this.metadata = metadata;
    this.name = name;
    this.networkInterfaces = networkInterfaces;
    this.scheduling = scheduling;
    this.selfLink = selfLink;
    this.serviceAccounts = serviceAccounts;
    this.status = status;
    this.statusMessage = statusMessage;
    this.tags = tags;
    this.zone = zone;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("canIpForward") && canIpForward != null) {
      fieldMap.put("canIpForward", Collections.singletonList(String.valueOf(canIpForward)));
    }
    if (fieldNames.contains("cpuPlatform") && cpuPlatform != null) {
      fieldMap.put("cpuPlatform", Collections.singletonList(String.valueOf(cpuPlatform)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("disks") && disks != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (AttachedDisk item : disks) {
        stringList.add(item.toString());
      }
      fieldMap.put("disks", stringList.build());
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("machineType") && machineType != null) {
      fieldMap.put("machineType", Collections.singletonList(String.valueOf(machineType)));
    }
    if (fieldNames.contains("metadata") && metadata != null) {
      fieldMap.put("metadata", Collections.singletonList(String.valueOf(metadata)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("networkInterfaces") && networkInterfaces != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (NetworkInterface item : networkInterfaces) {
        stringList.add(item.toString());
      }
      fieldMap.put("networkInterfaces", stringList.build());
    }
    if (fieldNames.contains("scheduling") && scheduling != null) {
      fieldMap.put("scheduling", Collections.singletonList(String.valueOf(scheduling)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("serviceAccounts") && serviceAccounts != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (ServiceAccount item : serviceAccounts) {
        stringList.add(item.toString());
      }
      fieldMap.put("serviceAccounts", stringList.build());
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    if (fieldNames.contains("statusMessage") && statusMessage != null) {
      fieldMap.put("statusMessage", Collections.singletonList(String.valueOf(statusMessage)));
    }
    if (fieldNames.contains("tags") && tags != null) {
      fieldMap.put("tags", Collections.singletonList(String.valueOf(tags)));
    }
    if (fieldNames.contains("zone") && zone != null) {
      fieldMap.put("zone", Collections.singletonList(String.valueOf(zone)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("canIpForward")) {
      return String.valueOf(canIpForward);
    }
    if (fieldName.equals("cpuPlatform")) {
      return String.valueOf(cpuPlatform);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("disks")) {
      return String.valueOf(disks);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("machineType")) {
      return String.valueOf(machineType);
    }
    if (fieldName.equals("metadata")) {
      return String.valueOf(metadata);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("networkInterfaces")) {
      return String.valueOf(networkInterfaces);
    }
    if (fieldName.equals("scheduling")) {
      return String.valueOf(scheduling);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("serviceAccounts")) {
      return String.valueOf(serviceAccounts);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    if (fieldName.equals("statusMessage")) {
      return String.valueOf(statusMessage);
    }
    if (fieldName.equals("tags")) {
      return String.valueOf(tags);
    }
    if (fieldName.equals("zone")) {
      return String.valueOf(zone);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public Boolean getCanIpForward() {
    return canIpForward;
  }

  public String getCpuPlatform() {
    return cpuPlatform;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getMachineType() {
    return machineType;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public String getName() {
    return name;
  }

  public List<NetworkInterface> getNetworkInterfacesList() {
    return networkInterfaces;
  }

  public Scheduling getScheduling() {
    return scheduling;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public List<ServiceAccount> getServiceAccountsList() {
    return serviceAccounts;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public Tags getTags() {
    return tags;
  }

  public String getZone() {
    return zone;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Instance prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Instance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final Instance DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Instance();
  }

  public static class Builder {
    private Boolean canIpForward;
    private String cpuPlatform;
    private String creationTimestamp;
    private String description;
    private List<AttachedDisk> disks;
    private String id;
    private String kind;
    private String machineType;
    private Metadata metadata;
    private String name;
    private List<NetworkInterface> networkInterfaces;
    private Scheduling scheduling;
    private String selfLink;
    private List<ServiceAccount> serviceAccounts;
    private String status;
    private String statusMessage;
    private Tags tags;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Instance other) {
      if (other == Instance.getDefaultInstance()) return this;
      if (other.getCanIpForward() != null) {
        this.canIpForward = other.canIpForward;
      }
      if (other.getCpuPlatform() != null) {
        this.cpuPlatform = other.cpuPlatform;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDisksList() != null) {
        this.disks = other.disks;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getMachineType() != null) {
        this.machineType = other.machineType;
      }
      if (other.getMetadata() != null) {
        this.metadata = other.metadata;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetworkInterfacesList() != null) {
        this.networkInterfaces = other.networkInterfaces;
      }
      if (other.getScheduling() != null) {
        this.scheduling = other.scheduling;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getServiceAccountsList() != null) {
        this.serviceAccounts = other.serviceAccounts;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusMessage() != null) {
        this.statusMessage = other.statusMessage;
      }
      if (other.getTags() != null) {
        this.tags = other.tags;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Instance source) {
      this.canIpForward = source.canIpForward;
      this.cpuPlatform = source.cpuPlatform;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.disks = source.disks;
      this.id = source.id;
      this.kind = source.kind;
      this.machineType = source.machineType;
      this.metadata = source.metadata;
      this.name = source.name;
      this.networkInterfaces = source.networkInterfaces;
      this.scheduling = source.scheduling;
      this.selfLink = source.selfLink;
      this.serviceAccounts = source.serviceAccounts;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
      this.tags = source.tags;
      this.zone = source.zone;
    }

    public Boolean getCanIpForward() {
      return canIpForward;
    }

    public Builder setCanIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
      return this;
    }

    public String getCpuPlatform() {
      return cpuPlatform;
    }

    public Builder setCpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
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

    public List<AttachedDisk> getDisksList() {
      return disks;
    }

    public Builder addAllDisks(List<AttachedDisk> disks) {
      if (this.disks == null) {
        this.disks = new ArrayList<>(disks.size());
      }
      this.disks.addAll(disks);
      return this;
    }

    public Builder addDisks(AttachedDisk disks) {
      this.disks.add(disks);
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getMachineType() {
      return machineType;
    }

    public Builder setMachineType(String machineType) {
      this.machineType = machineType;
      return this;
    }

    public Metadata getMetadata() {
      return metadata;
    }

    public Builder setMetadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public List<NetworkInterface> getNetworkInterfacesList() {
      return networkInterfaces;
    }

    public Builder addAllNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new ArrayList<>(networkInterfaces.size());
      }
      this.networkInterfaces.addAll(networkInterfaces);
      return this;
    }

    public Builder addNetworkInterfaces(NetworkInterface networkInterfaces) {
      this.networkInterfaces.add(networkInterfaces);
      return this;
    }

    public Scheduling getScheduling() {
      return scheduling;
    }

    public Builder setScheduling(Scheduling scheduling) {
      this.scheduling = scheduling;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<ServiceAccount> getServiceAccountsList() {
      return serviceAccounts;
    }

    public Builder addAllServiceAccounts(List<ServiceAccount> serviceAccounts) {
      if (this.serviceAccounts == null) {
        this.serviceAccounts = new ArrayList<>(serviceAccounts.size());
      }
      this.serviceAccounts.addAll(serviceAccounts);
      return this;
    }

    public Builder addServiceAccounts(ServiceAccount serviceAccounts) {
      this.serviceAccounts.add(serviceAccounts);
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getStatusMessage() {
      return statusMessage;
    }

    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    public Tags getTags() {
      return tags;
    }

    public Builder setTags(Tags tags) {
      this.tags = tags;
      return this;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }


    public Instance build() {

















      return new Instance(
        canIpForward,
        cpuPlatform,
        creationTimestamp,
        description,
        disks,
        id,
        kind,
        machineType,
        metadata,
        name,
        networkInterfaces,
        scheduling,
        selfLink,
        serviceAccounts,
        status,
        statusMessage,
        tags,
        zone
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCanIpForward(this.canIpForward);
      newBuilder.setCpuPlatform(this.cpuPlatform);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDisks(this.disks);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setMachineType(this.machineType);
      newBuilder.setMetadata(this.metadata);
      newBuilder.setName(this.name);
      newBuilder.addAllNetworkInterfaces(this.networkInterfaces);
      newBuilder.setScheduling(this.scheduling);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllServiceAccounts(this.serviceAccounts);
      newBuilder.setStatus(this.status);
      newBuilder.setStatusMessage(this.statusMessage);
      newBuilder.setTags(this.tags);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Instance{"
        + "canIpForward=" + canIpForward + ", "
        + "cpuPlatform=" + cpuPlatform + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "disks=" + disks + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "machineType=" + machineType + ", "
        + "metadata=" + metadata + ", "
        + "name=" + name + ", "
        + "networkInterfaces=" + networkInterfaces + ", "
        + "scheduling=" + scheduling + ", "
        + "selfLink=" + selfLink + ", "
        + "serviceAccounts=" + serviceAccounts + ", "
        + "status=" + status + ", "
        + "statusMessage=" + statusMessage + ", "
        + "tags=" + tags + ", "
        + "zone=" + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Instance) {
      Instance that = (Instance) o;
      return
          Objects.equals(this.canIpForward, that.getCanIpForward()) &&
          Objects.equals(this.cpuPlatform, that.getCpuPlatform()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.disks, that.getDisksList()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.machineType, that.getMachineType()) &&
          Objects.equals(this.metadata, that.getMetadata()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.networkInterfaces, that.getNetworkInterfacesList()) &&
          Objects.equals(this.scheduling, that.getScheduling()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.serviceAccounts, that.getServiceAccountsList()) &&
          Objects.equals(this.status, that.getStatus()) &&
          Objects.equals(this.statusMessage, that.getStatusMessage()) &&
          Objects.equals(this.tags, that.getTags()) &&
          Objects.equals(this.zone, that.getZone())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      canIpForward,
      cpuPlatform,
      creationTimestamp,
      description,
      disks,
      id,
      kind,
      machineType,
      metadata,
      name,
      networkInterfaces,
      scheduling,
      selfLink,
      serviceAccounts,
      status,
      statusMessage,
      tags,
      zone
    );
  }
}
