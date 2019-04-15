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
  private final ShieldedInstanceConfig shieldedInstanceConfig;
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
    this.shieldedInstanceConfig = null;
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
      ShieldedInstanceConfig shieldedInstanceConfig,
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
    this.shieldedInstanceConfig = shieldedInstanceConfig;
    this.tags = tags;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("canIpForward".equals(fieldName)) {
      return canIpForward;
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
    if ("networkInterfaces".equals(fieldName)) {
      return networkInterfaces;
    }
    if ("scheduling".equals(fieldName)) {
      return scheduling;
    }
    if ("serviceAccounts".equals(fieldName)) {
      return serviceAccounts;
    }
    if ("shieldedInstanceConfig".equals(fieldName)) {
      return shieldedInstanceConfig;
    }
    if ("tags".equals(fieldName)) {
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
   * Enables instances created based on this template to send packets with source IP addresses other
   * than their own and receive packets with destination IP addresses other than their own. If these
   * instances will be used as an IP gateway or it will be set as the next-hop in a Route resource,
   * specify true. If unsure, leave this set to false. See the Enable IP forwarding documentation
   * for more information.
   */
  public Boolean getCanIpForward() {
    return canIpForward;
  }

  /**
   * An optional text description for the instances that are created from this instance template.
   */
  public String getDescription() {
    return description;
  }

  /**
   * An array of disks that are associated with the instances that are created from this template.
   */
  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  /**
   * A list of guest accelerator cards' type and count to use for instances created from the
   * instance template.
   */
  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
  }

  /** Labels to apply to instances that are created from this template. */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /** The machine type to use for instances that are created from this template. */
  public String getMachineType() {
    return machineType;
  }

  /**
   * The metadata key/value pairs to assign to instances that are created from this template. These
   * pairs can consist of custom metadata or predefined keys. See Project and instance metadata for
   * more information.
   */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * Minimum cpu/platform to be used by this instance. The instance may be scheduled on the
   * specified or newer cpu/platform. Applicable values are the friendly names of CPU platforms,
   * such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel Sandy Bridge". For more
   * information, read Specifying a Minimum CPU Platform.
   */
  public String getMinCpuPlatform() {
    return minCpuPlatform;
  }

  /** An array of network access configurations for this interface. */
  public List<NetworkInterface> getNetworkInterfacesList() {
    return networkInterfaces;
  }

  /** Specifies the scheduling options for the instances that are created from this template. */
  public Scheduling getScheduling() {
    return scheduling;
  }

  /**
   * A list of service accounts with specified scopes. Access tokens for these service accounts are
   * available to the instances that are created from this template. Use metadata queries to obtain
   * the access tokens for these instances.
   */
  public List<ServiceAccount> getServiceAccountsList() {
    return serviceAccounts;
  }

  public ShieldedInstanceConfig getShieldedInstanceConfig() {
    return shieldedInstanceConfig;
  }

  /**
   * A list of tags to apply to the instances that are created from this template. The tags identify
   * valid sources or targets for network firewalls. The setTags method can modify this list of
   * tags. Each tag within the list must comply with RFC1035.
   */
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
    private ShieldedInstanceConfig shieldedInstanceConfig;
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
      if (other.getShieldedInstanceConfig() != null) {
        this.shieldedInstanceConfig = other.shieldedInstanceConfig;
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
      this.shieldedInstanceConfig = source.shieldedInstanceConfig;
      this.tags = source.tags;
    }

    /**
     * Enables instances created based on this template to send packets with source IP addresses
     * other than their own and receive packets with destination IP addresses other than their own.
     * If these instances will be used as an IP gateway or it will be set as the next-hop in a Route
     * resource, specify true. If unsure, leave this set to false. See the Enable IP forwarding
     * documentation for more information.
     */
    public Boolean getCanIpForward() {
      return canIpForward;
    }

    /**
     * Enables instances created based on this template to send packets with source IP addresses
     * other than their own and receive packets with destination IP addresses other than their own.
     * If these instances will be used as an IP gateway or it will be set as the next-hop in a Route
     * resource, specify true. If unsure, leave this set to false. See the Enable IP forwarding
     * documentation for more information.
     */
    public Builder setCanIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
      return this;
    }

    /**
     * An optional text description for the instances that are created from this instance template.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional text description for the instances that are created from this instance template.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * An array of disks that are associated with the instances that are created from this template.
     */
    public List<AttachedDisk> getDisksList() {
      return disks;
    }

    /**
     * An array of disks that are associated with the instances that are created from this template.
     */
    public Builder addAllDisks(List<AttachedDisk> disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.addAll(disks);
      return this;
    }

    /**
     * An array of disks that are associated with the instances that are created from this template.
     */
    public Builder addDisks(AttachedDisk disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.add(disks);
      return this;
    }

    /**
     * A list of guest accelerator cards' type and count to use for instances created from the
     * instance template.
     */
    public List<AcceleratorConfig> getGuestAcceleratorsList() {
      return guestAccelerators;
    }

    /**
     * A list of guest accelerator cards' type and count to use for instances created from the
     * instance template.
     */
    public Builder addAllGuestAccelerators(List<AcceleratorConfig> guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.addAll(guestAccelerators);
      return this;
    }

    /**
     * A list of guest accelerator cards' type and count to use for instances created from the
     * instance template.
     */
    public Builder addGuestAccelerators(AcceleratorConfig guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.add(guestAccelerators);
      return this;
    }

    /** Labels to apply to instances that are created from this template. */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /** Labels to apply to instances that are created from this template. */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /** The machine type to use for instances that are created from this template. */
    public String getMachineType() {
      return machineType;
    }

    /** The machine type to use for instances that are created from this template. */
    public Builder setMachineType(String machineType) {
      this.machineType = machineType;
      return this;
    }

    /**
     * The metadata key/value pairs to assign to instances that are created from this template.
     * These pairs can consist of custom metadata or predefined keys. See Project and instance
     * metadata for more information.
     */
    public Metadata getMetadata() {
      return metadata;
    }

    /**
     * The metadata key/value pairs to assign to instances that are created from this template.
     * These pairs can consist of custom metadata or predefined keys. See Project and instance
     * metadata for more information.
     */
    public Builder setMetadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Minimum cpu/platform to be used by this instance. The instance may be scheduled on the
     * specified or newer cpu/platform. Applicable values are the friendly names of CPU platforms,
     * such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel Sandy Bridge". For more
     * information, read Specifying a Minimum CPU Platform.
     */
    public String getMinCpuPlatform() {
      return minCpuPlatform;
    }

    /**
     * Minimum cpu/platform to be used by this instance. The instance may be scheduled on the
     * specified or newer cpu/platform. Applicable values are the friendly names of CPU platforms,
     * such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel Sandy Bridge". For more
     * information, read Specifying a Minimum CPU Platform.
     */
    public Builder setMinCpuPlatform(String minCpuPlatform) {
      this.minCpuPlatform = minCpuPlatform;
      return this;
    }

    /** An array of network access configurations for this interface. */
    public List<NetworkInterface> getNetworkInterfacesList() {
      return networkInterfaces;
    }

    /** An array of network access configurations for this interface. */
    public Builder addAllNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new LinkedList<>();
      }
      this.networkInterfaces.addAll(networkInterfaces);
      return this;
    }

    /** An array of network access configurations for this interface. */
    public Builder addNetworkInterfaces(NetworkInterface networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new LinkedList<>();
      }
      this.networkInterfaces.add(networkInterfaces);
      return this;
    }

    /** Specifies the scheduling options for the instances that are created from this template. */
    public Scheduling getScheduling() {
      return scheduling;
    }

    /** Specifies the scheduling options for the instances that are created from this template. */
    public Builder setScheduling(Scheduling scheduling) {
      this.scheduling = scheduling;
      return this;
    }

    /**
     * A list of service accounts with specified scopes. Access tokens for these service accounts
     * are available to the instances that are created from this template. Use metadata queries to
     * obtain the access tokens for these instances.
     */
    public List<ServiceAccount> getServiceAccountsList() {
      return serviceAccounts;
    }

    /**
     * A list of service accounts with specified scopes. Access tokens for these service accounts
     * are available to the instances that are created from this template. Use metadata queries to
     * obtain the access tokens for these instances.
     */
    public Builder addAllServiceAccounts(List<ServiceAccount> serviceAccounts) {
      if (this.serviceAccounts == null) {
        this.serviceAccounts = new LinkedList<>();
      }
      this.serviceAccounts.addAll(serviceAccounts);
      return this;
    }

    /**
     * A list of service accounts with specified scopes. Access tokens for these service accounts
     * are available to the instances that are created from this template. Use metadata queries to
     * obtain the access tokens for these instances.
     */
    public Builder addServiceAccounts(ServiceAccount serviceAccounts) {
      if (this.serviceAccounts == null) {
        this.serviceAccounts = new LinkedList<>();
      }
      this.serviceAccounts.add(serviceAccounts);
      return this;
    }

    public ShieldedInstanceConfig getShieldedInstanceConfig() {
      return shieldedInstanceConfig;
    }

    public Builder setShieldedInstanceConfig(ShieldedInstanceConfig shieldedInstanceConfig) {
      this.shieldedInstanceConfig = shieldedInstanceConfig;
      return this;
    }

    /**
     * A list of tags to apply to the instances that are created from this template. The tags
     * identify valid sources or targets for network firewalls. The setTags method can modify this
     * list of tags. Each tag within the list must comply with RFC1035.
     */
    public Tags getTags() {
      return tags;
    }

    /**
     * A list of tags to apply to the instances that are created from this template. The tags
     * identify valid sources or targets for network firewalls. The setTags method can modify this
     * list of tags. Each tag within the list must comply with RFC1035.
     */
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
          shieldedInstanceConfig,
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
      newBuilder.setShieldedInstanceConfig(this.shieldedInstanceConfig);
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
        + "shieldedInstanceConfig="
        + shieldedInstanceConfig
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
          && Objects.equals(this.shieldedInstanceConfig, that.getShieldedInstanceConfig())
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
        shieldedInstanceConfig,
        tags);
  }
}
