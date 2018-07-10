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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InstanceProperties implements ApiMessage {
  private final Boolean canIpForward;
  private final String description;
  private final List<AttachedDisk> disks;
  private final List<AcceleratorConfig> guestAccelerators;
  private final Map<String, String> labels;
  private final String machineType;
  private final Metadata metadata;
  private final String minCpuPlatform;
  private final List<NetworkInterface> networkInterfaces;
  private final Scheduling scheduling;
  private final List<ServiceAccount> serviceAccounts;
  private final Tags tags;

  private InstanceProperties() {
    this.canIpForward = null;
    this.description = null;
    this.disks = null;
    this.guestAccelerators = null;
    this.labels = null;
    this.machineType = null;
    this.metadata = null;
    this.minCpuPlatform = null;
    this.networkInterfaces = null;
    this.scheduling = null;
    this.serviceAccounts = null;
    this.tags = null;
  }

  private InstanceProperties(
      Boolean canIpForward,
      String description,
      List<AttachedDisk> disks,
      List<AcceleratorConfig> guestAccelerators,
      Map<String, String> labels,
      String machineType,
      Metadata metadata,
      String minCpuPlatform,
      List<NetworkInterface> networkInterfaces,
      Scheduling scheduling,
      List<ServiceAccount> serviceAccounts,
      Tags tags) {
    this.canIpForward = canIpForward;
    this.description = description;
    this.disks = disks;
    this.guestAccelerators = guestAccelerators;
    this.labels = labels;
    this.machineType = machineType;
    this.metadata = metadata;
    this.minCpuPlatform = minCpuPlatform;
    this.networkInterfaces = networkInterfaces;
    this.scheduling = scheduling;
    this.serviceAccounts = serviceAccounts;
    this.tags = tags;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("canIpForward")) {
      return canIpForward;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("disks")) {
      return disks;
    }
    if (fieldName.equals("guestAccelerators")) {
      return guestAccelerators;
    }
    if (fieldName.equals("labels")) {
      return labels;
    }
    if (fieldName.equals("machineType")) {
      return machineType;
    }
    if (fieldName.equals("metadata")) {
      return metadata;
    }
    if (fieldName.equals("minCpuPlatform")) {
      return minCpuPlatform;
    }
    if (fieldName.equals("networkInterfaces")) {
      return networkInterfaces;
    }
    if (fieldName.equals("scheduling")) {
      return scheduling;
    }
    if (fieldName.equals("serviceAccounts")) {
      return serviceAccounts;
    }
    if (fieldName.equals("tags")) {
      return tags;
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

  public String getDescription() {
    return description;
  }

  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
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

  public List<NetworkInterface> getNetworkInterfacesList() {
    return networkInterfaces;
  }

  public Scheduling getScheduling() {
    return scheduling;
  }

  public List<ServiceAccount> getServiceAccountsList() {
    return serviceAccounts;
  }

  public Tags getTags() {
    return tags;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceProperties prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceProperties DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceProperties();
  }

  public static class Builder {
    private Boolean canIpForward;
    private String description;
    private List<AttachedDisk> disks;
    private List<AcceleratorConfig> guestAccelerators;
    private Map<String, String> labels;
    private String machineType;
    private Metadata metadata;
    private String minCpuPlatform;
    private List<NetworkInterface> networkInterfaces;
    private Scheduling scheduling;
    private List<ServiceAccount> serviceAccounts;
    private Tags tags;

    Builder() {}

    public Builder mergeFrom(InstanceProperties other) {
      if (other == InstanceProperties.getDefaultInstance()) return this;
      if (other.getCanIpForward() != null) {
        this.canIpForward = other.canIpForward;
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
      if (other.getNetworkInterfacesList() != null) {
        this.networkInterfaces = other.networkInterfaces;
      }
      if (other.getScheduling() != null) {
        this.scheduling = other.scheduling;
      }
      if (other.getServiceAccountsList() != null) {
        this.serviceAccounts = other.serviceAccounts;
      }
      if (other.getTags() != null) {
        this.tags = other.tags;
      }
      return this;
    }

    Builder(InstanceProperties source) {
      this.canIpForward = source.canIpForward;
      this.description = source.description;
      this.disks = source.disks;
      this.guestAccelerators = source.guestAccelerators;
      this.labels = source.labels;
      this.machineType = source.machineType;
      this.metadata = source.metadata;
      this.minCpuPlatform = source.minCpuPlatform;
      this.networkInterfaces = source.networkInterfaces;
      this.scheduling = source.scheduling;
      this.serviceAccounts = source.serviceAccounts;
      this.tags = source.tags;
    }

    public Boolean getCanIpForward() {
      return canIpForward;
    }

    public Builder setCanIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
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

    public Tags getTags() {
      return tags;
    }

    public Builder setTags(Tags tags) {
      this.tags = tags;
      return this;
    }

    public InstanceProperties build() {

      return new InstanceProperties(
          canIpForward,
          description,
          disks,
          guestAccelerators,
          labels,
          machineType,
          metadata,
          minCpuPlatform,
          networkInterfaces,
          scheduling,
          serviceAccounts,
          tags);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCanIpForward(this.canIpForward);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDisks(this.disks);
      newBuilder.addAllGuestAccelerators(this.guestAccelerators);
      newBuilder.putAllLabels(this.labels);
      newBuilder.setMachineType(this.machineType);
      newBuilder.setMetadata(this.metadata);
      newBuilder.setMinCpuPlatform(this.minCpuPlatform);
      newBuilder.addAllNetworkInterfaces(this.networkInterfaces);
      newBuilder.setScheduling(this.scheduling);
      newBuilder.addAllServiceAccounts(this.serviceAccounts);
      newBuilder.setTags(this.tags);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceProperties{"
        + "canIpForward="
        + canIpForward
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
        + "networkInterfaces="
        + networkInterfaces
        + ", "
        + "scheduling="
        + scheduling
        + ", "
        + "serviceAccounts="
        + serviceAccounts
        + ", "
        + "tags="
        + tags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceProperties) {
      InstanceProperties that = (InstanceProperties) o;
      return Objects.equals(this.canIpForward, that.getCanIpForward())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.disks, that.getDisksList())
          && Objects.equals(this.guestAccelerators, that.getGuestAcceleratorsList())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.machineType, that.getMachineType())
          && Objects.equals(this.metadata, that.getMetadata())
          && Objects.equals(this.minCpuPlatform, that.getMinCpuPlatform())
          && Objects.equals(this.networkInterfaces, that.getNetworkInterfacesList())
          && Objects.equals(this.scheduling, that.getScheduling())
          && Objects.equals(this.serviceAccounts, that.getServiceAccountsList())
          && Objects.equals(this.tags, that.getTags());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        canIpForward,
        description,
        disks,
        guestAccelerators,
        labels,
        machineType,
        metadata,
        minCpuPlatform,
        networkInterfaces,
        scheduling,
        serviceAccounts,
        tags);
  }
}
