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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class Instance implements ApiMessage {
  private final Boolean canIpForward;
  private final String cpuPlatform;
  private final String creationTimestamp;
  private final Boolean deletionProtection;
  private final String description;
  private final List<AttachedDisk> disks;
  private final List<AcceleratorConfig> guestAccelerators;
  private final String hostname;
  private final String id;
  private final String kind;
  private final String labelFingerprint;
  private final Map<String, String> labels;
  private final String machineType;
  private final Metadata metadata;
  private final String minCpuPlatform;
  private final String name;
  private final List<NetworkInterface> networkInterfaces;
  private final Scheduling scheduling;
  private final String selfLink;
  private final List<ServiceAccount> serviceAccounts;
  private final Boolean startRestricted;
  private final String status;
  private final String statusMessage;
  private final Tags tags;
  private final String zone;

  private Instance() {
    this.canIpForward = null;
    this.cpuPlatform = null;
    this.creationTimestamp = null;
    this.deletionProtection = null;
    this.description = null;
    this.disks = null;
    this.guestAccelerators = null;
    this.hostname = null;
    this.id = null;
    this.kind = null;
    this.labelFingerprint = null;
    this.labels = null;
    this.machineType = null;
    this.metadata = null;
    this.minCpuPlatform = null;
    this.name = null;
    this.networkInterfaces = null;
    this.scheduling = null;
    this.selfLink = null;
    this.serviceAccounts = null;
    this.startRestricted = null;
    this.status = null;
    this.statusMessage = null;
    this.tags = null;
    this.zone = null;
  }

  private Instance(
      Boolean canIpForward,
      String cpuPlatform,
      String creationTimestamp,
      Boolean deletionProtection,
      String description,
      List<AttachedDisk> disks,
      List<AcceleratorConfig> guestAccelerators,
      String hostname,
      String id,
      String kind,
      String labelFingerprint,
      Map<String, String> labels,
      String machineType,
      Metadata metadata,
      String minCpuPlatform,
      String name,
      List<NetworkInterface> networkInterfaces,
      Scheduling scheduling,
      String selfLink,
      List<ServiceAccount> serviceAccounts,
      Boolean startRestricted,
      String status,
      String statusMessage,
      Tags tags,
      String zone) {
    this.canIpForward = canIpForward;
    this.cpuPlatform = cpuPlatform;
    this.creationTimestamp = creationTimestamp;
    this.deletionProtection = deletionProtection;
    this.description = description;
    this.disks = disks;
    this.guestAccelerators = guestAccelerators;
    this.hostname = hostname;
    this.id = id;
    this.kind = kind;
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
    this.machineType = machineType;
    this.metadata = metadata;
    this.minCpuPlatform = minCpuPlatform;
    this.name = name;
    this.networkInterfaces = networkInterfaces;
    this.scheduling = scheduling;
    this.selfLink = selfLink;
    this.serviceAccounts = serviceAccounts;
    this.startRestricted = startRestricted;
    this.status = status;
    this.statusMessage = statusMessage;
    this.tags = tags;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("canIpForward".equals(fieldName)) {
      return canIpForward;
    }
    if ("cpuPlatform".equals(fieldName)) {
      return cpuPlatform;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("deletionProtection".equals(fieldName)) {
      return deletionProtection;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("disks".equals(fieldName)) {
      return disks;
    }
    if ("guestAccelerators".equals(fieldName)) {
      return guestAccelerators;
    }
    if ("hostname".equals(fieldName)) {
      return hostname;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("labelFingerprint".equals(fieldName)) {
      return labelFingerprint;
    }
    if ("labels".equals(fieldName)) {
      return labels;
    }
    if ("machineType".equals(fieldName)) {
      return machineType;
    }
    if ("metadata".equals(fieldName)) {
      return metadata;
    }
    if ("minCpuPlatform".equals(fieldName)) {
      return minCpuPlatform;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("networkInterfaces".equals(fieldName)) {
      return networkInterfaces;
    }
    if ("scheduling".equals(fieldName)) {
      return scheduling;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("serviceAccounts".equals(fieldName)) {
      return serviceAccounts;
    }
    if ("startRestricted".equals(fieldName)) {
      return startRestricted;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusMessage".equals(fieldName)) {
      return statusMessage;
    }
    if ("tags".equals(fieldName)) {
      return tags;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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

  public Boolean getCanIpForward() {
    return canIpForward;
  }

  public String getCpuPlatform() {
    return cpuPlatform;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public Boolean getDeletionProtection() {
    return deletionProtection;
  }

  public String getDescription() {
    return description;
  }

  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
  }

  public String getHostname() {
    return hostname;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  public Map<String, String> getLabelsMap() {
    return labels;
  }

  public String getMachineType() {
    return machineType;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public String getMinCpuPlatform() {
    return minCpuPlatform;
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

  public Boolean getStartRestricted() {
    return startRestricted;
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
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
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
    private Boolean deletionProtection;
    private String description;
    private List<AttachedDisk> disks;
    private List<AcceleratorConfig> guestAccelerators;
    private String hostname;
    private String id;
    private String kind;
    private String labelFingerprint;
    private Map<String, String> labels;
    private String machineType;
    private Metadata metadata;
    private String minCpuPlatform;
    private String name;
    private List<NetworkInterface> networkInterfaces;
    private Scheduling scheduling;
    private String selfLink;
    private List<ServiceAccount> serviceAccounts;
    private Boolean startRestricted;
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
      if (other.getDeletionProtection() != null) {
        this.deletionProtection = other.deletionProtection;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDisksList() != null) {
        this.disks = other.disks;
      }
      if (other.getGuestAcceleratorsList() != null) {
        this.guestAccelerators = other.guestAccelerators;
      }
      if (other.getHostname() != null) {
        this.hostname = other.hostname;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLabelFingerprint() != null) {
        this.labelFingerprint = other.labelFingerprint;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      if (other.getMachineType() != null) {
        this.machineType = other.machineType;
      }
      if (other.getMetadata() != null) {
        this.metadata = other.metadata;
      }
      if (other.getMinCpuPlatform() != null) {
        this.minCpuPlatform = other.minCpuPlatform;
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
      if (other.getStartRestricted() != null) {
        this.startRestricted = other.startRestricted;
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
      this.deletionProtection = source.deletionProtection;
      this.description = source.description;
      this.disks = source.disks;
      this.guestAccelerators = source.guestAccelerators;
      this.hostname = source.hostname;
      this.id = source.id;
      this.kind = source.kind;
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
      this.machineType = source.machineType;
      this.metadata = source.metadata;
      this.minCpuPlatform = source.minCpuPlatform;
      this.name = source.name;
      this.networkInterfaces = source.networkInterfaces;
      this.scheduling = source.scheduling;
      this.selfLink = source.selfLink;
      this.serviceAccounts = source.serviceAccounts;
      this.startRestricted = source.startRestricted;
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

    public Boolean getDeletionProtection() {
      return deletionProtection;
    }

    public Builder setDeletionProtection(Boolean deletionProtection) {
      this.deletionProtection = deletionProtection;
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
        this.disks = new LinkedList<>();
      }
      this.disks.addAll(disks);
      return this;
    }

    public Builder addDisks(AttachedDisk disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.add(disks);
      return this;
    }

    public List<AcceleratorConfig> getGuestAcceleratorsList() {
      return guestAccelerators;
    }

    public Builder addAllGuestAccelerators(List<AcceleratorConfig> guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.addAll(guestAccelerators);
      return this;
    }

    public Builder addGuestAccelerators(AcceleratorConfig guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.add(guestAccelerators);
      return this;
    }

    public String getHostname() {
      return hostname;
    }

    public Builder setHostname(String hostname) {
      this.hostname = hostname;
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

    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    public Map<String, String> getLabelsMap() {
      return labels;
    }

    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
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

    public String getMinCpuPlatform() {
      return minCpuPlatform;
    }

    public Builder setMinCpuPlatform(String minCpuPlatform) {
      this.minCpuPlatform = minCpuPlatform;
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
        this.networkInterfaces = new LinkedList<>();
      }
      this.networkInterfaces.addAll(networkInterfaces);
      return this;
    }

    public Builder addNetworkInterfaces(NetworkInterface networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new LinkedList<>();
      }
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
        this.serviceAccounts = new LinkedList<>();
      }
      this.serviceAccounts.addAll(serviceAccounts);
      return this;
    }

    public Builder addServiceAccounts(ServiceAccount serviceAccounts) {
      if (this.serviceAccounts == null) {
        this.serviceAccounts = new LinkedList<>();
      }
      this.serviceAccounts.add(serviceAccounts);
      return this;
    }

    public Boolean getStartRestricted() {
      return startRestricted;
    }

    public Builder setStartRestricted(Boolean startRestricted) {
      this.startRestricted = startRestricted;
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
          deletionProtection,
          description,
          disks,
          guestAccelerators,
          hostname,
          id,
          kind,
          labelFingerprint,
          labels,
          machineType,
          metadata,
          minCpuPlatform,
          name,
          networkInterfaces,
          scheduling,
          selfLink,
          serviceAccounts,
          startRestricted,
          status,
          statusMessage,
          tags,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCanIpForward(this.canIpForward);
      newBuilder.setCpuPlatform(this.cpuPlatform);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeletionProtection(this.deletionProtection);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDisks(this.disks);
      newBuilder.addAllGuestAccelerators(this.guestAccelerators);
      newBuilder.setHostname(this.hostname);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      newBuilder.setMachineType(this.machineType);
      newBuilder.setMetadata(this.metadata);
      newBuilder.setMinCpuPlatform(this.minCpuPlatform);
      newBuilder.setName(this.name);
      newBuilder.addAllNetworkInterfaces(this.networkInterfaces);
      newBuilder.setScheduling(this.scheduling);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllServiceAccounts(this.serviceAccounts);
      newBuilder.setStartRestricted(this.startRestricted);
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
        + "canIpForward="
        + canIpForward
        + ", "
        + "cpuPlatform="
        + cpuPlatform
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "deletionProtection="
        + deletionProtection
        + ", "
        + "description="
        + description
        + ", "
        + "disks="
        + disks
        + ", "
        + "guestAccelerators="
        + guestAccelerators
        + ", "
        + "hostname="
        + hostname
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "labelFingerprint="
        + labelFingerprint
        + ", "
        + "labels="
        + labels
        + ", "
        + "machineType="
        + machineType
        + ", "
        + "metadata="
        + metadata
        + ", "
        + "minCpuPlatform="
        + minCpuPlatform
        + ", "
        + "name="
        + name
        + ", "
        + "networkInterfaces="
        + networkInterfaces
        + ", "
        + "scheduling="
        + scheduling
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "serviceAccounts="
        + serviceAccounts
        + ", "
        + "startRestricted="
        + startRestricted
        + ", "
        + "status="
        + status
        + ", "
        + "statusMessage="
        + statusMessage
        + ", "
        + "tags="
        + tags
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Instance) {
      Instance that = (Instance) o;
      return Objects.equals(this.canIpForward, that.getCanIpForward())
          && Objects.equals(this.cpuPlatform, that.getCpuPlatform())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deletionProtection, that.getDeletionProtection())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.disks, that.getDisksList())
          && Objects.equals(this.guestAccelerators, that.getGuestAcceleratorsList())
          && Objects.equals(this.hostname, that.getHostname())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.machineType, that.getMachineType())
          && Objects.equals(this.metadata, that.getMetadata())
          && Objects.equals(this.minCpuPlatform, that.getMinCpuPlatform())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.networkInterfaces, that.getNetworkInterfacesList())
          && Objects.equals(this.scheduling, that.getScheduling())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.serviceAccounts, that.getServiceAccountsList())
          && Objects.equals(this.startRestricted, that.getStartRestricted())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.statusMessage, that.getStatusMessage())
          && Objects.equals(this.tags, that.getTags())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        canIpForward,
        cpuPlatform,
        creationTimestamp,
        deletionProtection,
        description,
        disks,
        guestAccelerators,
        hostname,
        id,
        kind,
        labelFingerprint,
        labels,
        machineType,
        metadata,
        minCpuPlatform,
        name,
        networkInterfaces,
        scheduling,
        selfLink,
        serviceAccounts,
        startRestricted,
        status,
        statusMessage,
        tags,
        zone);
  }
}
