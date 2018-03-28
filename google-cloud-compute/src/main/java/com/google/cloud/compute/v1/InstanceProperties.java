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
public final class InstanceProperties implements ApiMessage {
  private final Boolean canIpForward;
  private final String description;
  private final List<AttachedDisk> disks;
  private final String machineType;
  private final Metadata metadata;
  private final List<NetworkInterface> networkInterfaces;
  private final Scheduling scheduling;
  private final List<ServiceAccount> serviceAccounts;
  private final Tags tags;

  private InstanceProperties() {
    this.canIpForward = null;
    this.description = null;
    this.disks = null;
    this.machineType = null;
    this.metadata = null;
    this.networkInterfaces = null;
    this.scheduling = null;
    this.serviceAccounts = null;
    this.tags = null;
  }


  private InstanceProperties(
      Boolean canIpForward,
      String description,
      List<AttachedDisk> disks,
      String machineType,
      Metadata metadata,
      List<NetworkInterface> networkInterfaces,
      Scheduling scheduling,
      List<ServiceAccount> serviceAccounts,
      Tags tags
      ) {
    this.canIpForward = canIpForward;
    this.description = description;
    this.disks = disks;
    this.machineType = machineType;
    this.metadata = metadata;
    this.networkInterfaces = networkInterfaces;
    this.scheduling = scheduling;
    this.serviceAccounts = serviceAccounts;
    this.tags = tags;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("canIpForward") && canIpForward != null) {
      fieldMap.put("canIpForward", Collections.singletonList(String.valueOf(canIpForward)));
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
    if (fieldNames.contains("machineType") && machineType != null) {
      fieldMap.put("machineType", Collections.singletonList(String.valueOf(machineType)));
    }
    if (fieldNames.contains("metadata") && metadata != null) {
      fieldMap.put("metadata", Collections.singletonList(String.valueOf(metadata)));
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
    if (fieldNames.contains("serviceAccounts") && serviceAccounts != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (ServiceAccount item : serviceAccounts) {
        stringList.add(item.toString());
      }
      fieldMap.put("serviceAccounts", stringList.build());
    }
    if (fieldNames.contains("tags") && tags != null) {
      fieldMap.put("tags", Collections.singletonList(String.valueOf(tags)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("canIpForward")) {
      return String.valueOf(canIpForward);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("disks")) {
      return String.valueOf(disks);
    }
    if (fieldName.equals("machineType")) {
      return String.valueOf(machineType);
    }
    if (fieldName.equals("metadata")) {
      return String.valueOf(metadata);
    }
    if (fieldName.equals("networkInterfaces")) {
      return String.valueOf(networkInterfaces);
    }
    if (fieldName.equals("scheduling")) {
      return String.valueOf(scheduling);
    }
    if (fieldName.equals("serviceAccounts")) {
      return String.valueOf(serviceAccounts);
    }
    if (fieldName.equals("tags")) {
      return String.valueOf(tags);
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

  public String getDescription() {
    return description;
  }

  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  public String getMachineType() {
    return machineType;
  }

  public Metadata getMetadata() {
    return metadata;
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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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
    private String machineType;
    private Metadata metadata;
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
      if (other.getMachineType() != null) {
        this.machineType = other.machineType;
      }
      if (other.getMetadata() != null) {
        this.metadata = other.metadata;
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
      this.machineType = source.machineType;
      this.metadata = source.metadata;
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
        this.disks = new ArrayList<>(disks.size());
      }
      this.disks.addAll(disks);
      return this;
    }

    public Builder addDisks(AttachedDisk disks) {
      this.disks.add(disks);
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
        machineType,
        metadata,
        networkInterfaces,
        scheduling,
        serviceAccounts,
        tags
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCanIpForward(this.canIpForward);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDisks(this.disks);
      newBuilder.setMachineType(this.machineType);
      newBuilder.setMetadata(this.metadata);
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
        + "canIpForward=" + canIpForward + ", "
        + "description=" + description + ", "
        + "disks=" + disks + ", "
        + "machineType=" + machineType + ", "
        + "metadata=" + metadata + ", "
        + "networkInterfaces=" + networkInterfaces + ", "
        + "scheduling=" + scheduling + ", "
        + "serviceAccounts=" + serviceAccounts + ", "
        + "tags=" + tags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceProperties) {
      InstanceProperties that = (InstanceProperties) o;
      return
          Objects.equals(this.canIpForward, that.getCanIpForward()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.disks, that.getDisksList()) &&
          Objects.equals(this.machineType, that.getMachineType()) &&
          Objects.equals(this.metadata, that.getMetadata()) &&
          Objects.equals(this.networkInterfaces, that.getNetworkInterfacesList()) &&
          Objects.equals(this.scheduling, that.getScheduling()) &&
          Objects.equals(this.serviceAccounts, that.getServiceAccountsList()) &&
          Objects.equals(this.tags, that.getTags())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      canIpForward,
      description,
      disks,
      machineType,
      metadata,
      networkInterfaces,
      scheduling,
      serviceAccounts,
      tags
    );
  }
}
