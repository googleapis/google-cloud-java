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
/**
 * Represents an Instance resource.
 *
 * <p>An instance is a virtual machine that is hosted on Google Cloud Platform. For more
 * information, read Virtual Machine Instances. (== resource_for beta.instances ==) (== resource_for
 * v1.instances ==)
 */
public final class Instance implements ApiMessage {
  private final Boolean canIpForward;
  private final String cpuPlatform;
  private final String creationTimestamp;
  private final Boolean deletionProtection;
  private final String description;
  private final List<AttachedDisk> disks;
  private final DisplayDevice displayDevice;
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
  private final ReservationAffinity reservationAffinity;
  private final Scheduling scheduling;
  private final String selfLink;
  private final List<ServiceAccount> serviceAccounts;
  private final ShieldedInstanceConfig shieldedInstanceConfig;
  private final ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy;
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
    this.displayDevice = null;
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
    this.reservationAffinity = null;
    this.scheduling = null;
    this.selfLink = null;
    this.serviceAccounts = null;
    this.shieldedInstanceConfig = null;
    this.shieldedInstanceIntegrityPolicy = null;
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
      DisplayDevice displayDevice,
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
      ReservationAffinity reservationAffinity,
      Scheduling scheduling,
      String selfLink,
      List<ServiceAccount> serviceAccounts,
      ShieldedInstanceConfig shieldedInstanceConfig,
      ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy,
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
    this.displayDevice = displayDevice;
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
    this.reservationAffinity = reservationAffinity;
    this.scheduling = scheduling;
    this.selfLink = selfLink;
    this.serviceAccounts = serviceAccounts;
    this.shieldedInstanceConfig = shieldedInstanceConfig;
    this.shieldedInstanceIntegrityPolicy = shieldedInstanceIntegrityPolicy;
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
    if ("displayDevice".equals(fieldName)) {
      return displayDevice;
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
    if ("reservationAffinity".equals(fieldName)) {
      return reservationAffinity;
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
    if ("shieldedInstanceConfig".equals(fieldName)) {
      return shieldedInstanceConfig;
    }
    if ("shieldedInstanceIntegrityPolicy".equals(fieldName)) {
      return shieldedInstanceIntegrityPolicy;
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
   * Allows this instance to send and receive packets with non-matching destination or source IPs.
   * This is required if you plan to use this instance to forward routes. For more information, see
   * Enabling IP Forwarding.
   */
  public Boolean getCanIpForward() {
    return canIpForward;
  }

  /** [Output Only] The CPU platform used by this instance. */
  public String getCpuPlatform() {
    return cpuPlatform;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Whether the resource should be protected against deletion. */
  public Boolean getDeletionProtection() {
    return deletionProtection;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Array of disks associated with this instance. Persistent disks must be created before you can
   * assign them.
   */
  public List<AttachedDisk> getDisksList() {
    return disks;
  }

  /** Enables display device for the instance. */
  public DisplayDevice getDisplayDevice() {
    return displayDevice;
  }

  /** A list of the type and count of accelerator cards attached to the instance. */
  public List<AcceleratorConfig> getGuestAcceleratorsList() {
    return guestAccelerators;
  }

  /**
   * Specifies the hostname of the instance. The specified hostname must be RFC1035 compliant. If
   * hostname is not specified, the default hostname is [INSTANCE_NAME].c.[PROJECT_ID].internal when
   * using the global DNS, and [INSTANCE_NAME].[ZONE].c.[PROJECT_ID].internal when using zonal DNS.
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#instance for instances. */
  public String getKind() {
    return kind;
  }

  /**
   * A fingerprint for this request, which is essentially a hash of the label's contents and used
   * for optimistic locking. The fingerprint is initially generated by Compute Engine and changes
   * after every request to modify or update labels. You must always provide an up-to-date
   * fingerprint hash in order to update or change labels.
   *
   * <p>To see the latest fingerprint, make get() request to the instance.
   */
  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  /** Labels to apply to this instance. These can be later modified by the setLabels method. */
  public Map<String, String> getLabelsMap() {
    return labels;
  }

  /**
   * Full or partial URL of the machine type resource to use for this instance, in the format:
   * zones/zone/machineTypes/machine-type. This is provided by the client when the instance is
   * created. For example, the following is a valid partial url to a predefined machine type:
   * zones/us-central1-f/machineTypes/n1-standard-1
   *
   * <p>To create a custom machine type, provide a URL to a machine type in the following format,
   * where CPUS is 1 or an even number up to 32 (2, 4, 6, ... 24, etc), and MEMORY is the total
   * memory for this instance. Memory must be a multiple of 256 MB and must be supplied in MB (e.g.
   * 5 GB of memory is 5120 MB): zones/zone/machineTypes/custom-CPUS-MEMORY
   *
   * <p>For example: zones/us-central1-f/machineTypes/custom-4-5120
   *
   * <p>For a full list of restrictions, read the Specifications for custom machine types.
   */
  public String getMachineType() {
    return machineType;
  }

  /**
   * The metadata key/value pairs assigned to this instance. This includes custom metadata and
   * predefined keys.
   */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * Specifies a minimum CPU platform for the VM instance. Applicable values are the friendly names
   * of CPU platforms, such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel Sandy
   * Bridge".
   */
  public String getMinCpuPlatform() {
    return minCpuPlatform;
  }

  /**
   * The name of the resource, provided by the client when initially creating the resource. The
   * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
   * must be 1-63 characters long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?`
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * An array of network configurations for this instance. These specify how interfaces are
   * configured to interact with other network services, such as connecting to the internet.
   * Multiple interfaces are supported per instance.
   */
  public List<NetworkInterface> getNetworkInterfacesList() {
    return networkInterfaces;
  }

  /** Specifies the reservations that this instance can consume from. */
  public ReservationAffinity getReservationAffinity() {
    return reservationAffinity;
  }

  /** Sets the scheduling options for this instance. */
  public Scheduling getScheduling() {
    return scheduling;
  }

  /** [Output Only] Server-defined URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * A list of service accounts, with their specified scopes, authorized for this instance. Only one
   * service account per VM instance is supported.
   *
   * <p>Service accounts generate access tokens that can be accessed through the metadata server and
   * used to authenticate applications on the instance. See Service Accounts for more information.
   */
  public List<ServiceAccount> getServiceAccountsList() {
    return serviceAccounts;
  }

  public ShieldedInstanceConfig getShieldedInstanceConfig() {
    return shieldedInstanceConfig;
  }

  public ShieldedInstanceIntegrityPolicy getShieldedInstanceIntegrityPolicy() {
    return shieldedInstanceIntegrityPolicy;
  }

  /**
   * [Output Only] Whether a VM has been restricted for start because Compute Engine has detected
   * suspicious activity.
   */
  public Boolean getStartRestricted() {
    return startRestricted;
  }

  /**
   * [Output Only] The status of the instance. One of the following values: PROVISIONING, STAGING,
   * RUNNING, STOPPING, STOPPED, SUSPENDING, SUSPENDED, and TERMINATED.
   */
  public String getStatus() {
    return status;
  }

  /** [Output Only] An optional, human-readable explanation of the status. */
  public String getStatusMessage() {
    return statusMessage;
  }

  /**
   * Tags to apply to this instance. Tags are used to identify valid sources or targets for network
   * firewalls and are specified by the client during instance creation. The tags can be later
   * modified by the setTags method. Each tag within the list must comply with RFC1035. Multiple
   * tags can be specified via the 'tags.items' field.
   */
  public Tags getTags() {
    return tags;
  }

  /**
   * [Output Only] URL of the zone where the instance resides. You must specify this field as part
   * of the HTTP request URL. It is not settable as a field in the request body.
   */
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
    private DisplayDevice displayDevice;
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
    private ReservationAffinity reservationAffinity;
    private Scheduling scheduling;
    private String selfLink;
    private List<ServiceAccount> serviceAccounts;
    private ShieldedInstanceConfig shieldedInstanceConfig;
    private ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy;
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
      if (other.getDisplayDevice() != null) {
        this.displayDevice = other.displayDevice;
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
      if (other.getReservationAffinity() != null) {
        this.reservationAffinity = other.reservationAffinity;
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
      if (other.getShieldedInstanceConfig() != null) {
        this.shieldedInstanceConfig = other.shieldedInstanceConfig;
      }
      if (other.getShieldedInstanceIntegrityPolicy() != null) {
        this.shieldedInstanceIntegrityPolicy = other.shieldedInstanceIntegrityPolicy;
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
      this.displayDevice = source.displayDevice;
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
      this.reservationAffinity = source.reservationAffinity;
      this.scheduling = source.scheduling;
      this.selfLink = source.selfLink;
      this.serviceAccounts = source.serviceAccounts;
      this.shieldedInstanceConfig = source.shieldedInstanceConfig;
      this.shieldedInstanceIntegrityPolicy = source.shieldedInstanceIntegrityPolicy;
      this.startRestricted = source.startRestricted;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
      this.tags = source.tags;
      this.zone = source.zone;
    }

    /**
     * Allows this instance to send and receive packets with non-matching destination or source IPs.
     * This is required if you plan to use this instance to forward routes. For more information,
     * see Enabling IP Forwarding.
     */
    public Boolean getCanIpForward() {
      return canIpForward;
    }

    /**
     * Allows this instance to send and receive packets with non-matching destination or source IPs.
     * This is required if you plan to use this instance to forward routes. For more information,
     * see Enabling IP Forwarding.
     */
    public Builder setCanIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
      return this;
    }

    /** [Output Only] The CPU platform used by this instance. */
    public String getCpuPlatform() {
      return cpuPlatform;
    }

    /** [Output Only] The CPU platform used by this instance. */
    public Builder setCpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /** Whether the resource should be protected against deletion. */
    public Boolean getDeletionProtection() {
      return deletionProtection;
    }

    /** Whether the resource should be protected against deletion. */
    public Builder setDeletionProtection(Boolean deletionProtection) {
      this.deletionProtection = deletionProtection;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * Array of disks associated with this instance. Persistent disks must be created before you can
     * assign them.
     */
    public List<AttachedDisk> getDisksList() {
      return disks;
    }

    /**
     * Array of disks associated with this instance. Persistent disks must be created before you can
     * assign them.
     */
    public Builder addAllDisks(List<AttachedDisk> disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.addAll(disks);
      return this;
    }

    /**
     * Array of disks associated with this instance. Persistent disks must be created before you can
     * assign them.
     */
    public Builder addDisks(AttachedDisk disks) {
      if (this.disks == null) {
        this.disks = new LinkedList<>();
      }
      this.disks.add(disks);
      return this;
    }

    /** Enables display device for the instance. */
    public DisplayDevice getDisplayDevice() {
      return displayDevice;
    }

    /** Enables display device for the instance. */
    public Builder setDisplayDevice(DisplayDevice displayDevice) {
      this.displayDevice = displayDevice;
      return this;
    }

    /** A list of the type and count of accelerator cards attached to the instance. */
    public List<AcceleratorConfig> getGuestAcceleratorsList() {
      return guestAccelerators;
    }

    /** A list of the type and count of accelerator cards attached to the instance. */
    public Builder addAllGuestAccelerators(List<AcceleratorConfig> guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.addAll(guestAccelerators);
      return this;
    }

    /** A list of the type and count of accelerator cards attached to the instance. */
    public Builder addGuestAccelerators(AcceleratorConfig guestAccelerators) {
      if (this.guestAccelerators == null) {
        this.guestAccelerators = new LinkedList<>();
      }
      this.guestAccelerators.add(guestAccelerators);
      return this;
    }

    /**
     * Specifies the hostname of the instance. The specified hostname must be RFC1035 compliant. If
     * hostname is not specified, the default hostname is [INSTANCE_NAME].c.[PROJECT_ID].internal
     * when using the global DNS, and [INSTANCE_NAME].[ZONE].c.[PROJECT_ID].internal when using
     * zonal DNS.
     */
    public String getHostname() {
      return hostname;
    }

    /**
     * Specifies the hostname of the instance. The specified hostname must be RFC1035 compliant. If
     * hostname is not specified, the default hostname is [INSTANCE_NAME].c.[PROJECT_ID].internal
     * when using the global DNS, and [INSTANCE_NAME].[ZONE].c.[PROJECT_ID].internal when using
     * zonal DNS.
     */
    public Builder setHostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#instance for instances. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#instance for instances. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A fingerprint for this request, which is essentially a hash of the label's contents and used
     * for optimistic locking. The fingerprint is initially generated by Compute Engine and changes
     * after every request to modify or update labels. You must always provide an up-to-date
     * fingerprint hash in order to update or change labels.
     *
     * <p>To see the latest fingerprint, make get() request to the instance.
     */
    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    /**
     * A fingerprint for this request, which is essentially a hash of the label's contents and used
     * for optimistic locking. The fingerprint is initially generated by Compute Engine and changes
     * after every request to modify or update labels. You must always provide an up-to-date
     * fingerprint hash in order to update or change labels.
     *
     * <p>To see the latest fingerprint, make get() request to the instance.
     */
    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    /** Labels to apply to this instance. These can be later modified by the setLabels method. */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /** Labels to apply to this instance. These can be later modified by the setLabels method. */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * Full or partial URL of the machine type resource to use for this instance, in the format:
     * zones/zone/machineTypes/machine-type. This is provided by the client when the instance is
     * created. For example, the following is a valid partial url to a predefined machine type:
     * zones/us-central1-f/machineTypes/n1-standard-1
     *
     * <p>To create a custom machine type, provide a URL to a machine type in the following format,
     * where CPUS is 1 or an even number up to 32 (2, 4, 6, ... 24, etc), and MEMORY is the total
     * memory for this instance. Memory must be a multiple of 256 MB and must be supplied in MB
     * (e.g. 5 GB of memory is 5120 MB): zones/zone/machineTypes/custom-CPUS-MEMORY
     *
     * <p>For example: zones/us-central1-f/machineTypes/custom-4-5120
     *
     * <p>For a full list of restrictions, read the Specifications for custom machine types.
     */
    public String getMachineType() {
      return machineType;
    }

    /**
     * Full or partial URL of the machine type resource to use for this instance, in the format:
     * zones/zone/machineTypes/machine-type. This is provided by the client when the instance is
     * created. For example, the following is a valid partial url to a predefined machine type:
     * zones/us-central1-f/machineTypes/n1-standard-1
     *
     * <p>To create a custom machine type, provide a URL to a machine type in the following format,
     * where CPUS is 1 or an even number up to 32 (2, 4, 6, ... 24, etc), and MEMORY is the total
     * memory for this instance. Memory must be a multiple of 256 MB and must be supplied in MB
     * (e.g. 5 GB of memory is 5120 MB): zones/zone/machineTypes/custom-CPUS-MEMORY
     *
     * <p>For example: zones/us-central1-f/machineTypes/custom-4-5120
     *
     * <p>For a full list of restrictions, read the Specifications for custom machine types.
     */
    public Builder setMachineType(String machineType) {
      this.machineType = machineType;
      return this;
    }

    /**
     * The metadata key/value pairs assigned to this instance. This includes custom metadata and
     * predefined keys.
     */
    public Metadata getMetadata() {
      return metadata;
    }

    /**
     * The metadata key/value pairs assigned to this instance. This includes custom metadata and
     * predefined keys.
     */
    public Builder setMetadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Specifies a minimum CPU platform for the VM instance. Applicable values are the friendly
     * names of CPU platforms, such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel
     * Sandy Bridge".
     */
    public String getMinCpuPlatform() {
      return minCpuPlatform;
    }

    /**
     * Specifies a minimum CPU platform for the VM instance. Applicable values are the friendly
     * names of CPU platforms, such as minCpuPlatform: "Intel Haswell" or minCpuPlatform: "Intel
     * Sandy Bridge".
     */
    public Builder setMinCpuPlatform(String minCpuPlatform) {
      this.minCpuPlatform = minCpuPlatform;
      return this;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the resource, provided by the client when initially creating the resource. The
     * resource name must be 1-63 characters long, and comply with RFC1035. Specifically, the name
     * must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * An array of network configurations for this instance. These specify how interfaces are
     * configured to interact with other network services, such as connecting to the internet.
     * Multiple interfaces are supported per instance.
     */
    public List<NetworkInterface> getNetworkInterfacesList() {
      return networkInterfaces;
    }

    /**
     * An array of network configurations for this instance. These specify how interfaces are
     * configured to interact with other network services, such as connecting to the internet.
     * Multiple interfaces are supported per instance.
     */
    public Builder addAllNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new LinkedList<>();
      }
      this.networkInterfaces.addAll(networkInterfaces);
      return this;
    }

    /**
     * An array of network configurations for this instance. These specify how interfaces are
     * configured to interact with other network services, such as connecting to the internet.
     * Multiple interfaces are supported per instance.
     */
    public Builder addNetworkInterfaces(NetworkInterface networkInterfaces) {
      if (this.networkInterfaces == null) {
        this.networkInterfaces = new LinkedList<>();
      }
      this.networkInterfaces.add(networkInterfaces);
      return this;
    }

    /** Specifies the reservations that this instance can consume from. */
    public ReservationAffinity getReservationAffinity() {
      return reservationAffinity;
    }

    /** Specifies the reservations that this instance can consume from. */
    public Builder setReservationAffinity(ReservationAffinity reservationAffinity) {
      this.reservationAffinity = reservationAffinity;
      return this;
    }

    /** Sets the scheduling options for this instance. */
    public Scheduling getScheduling() {
      return scheduling;
    }

    /** Sets the scheduling options for this instance. */
    public Builder setScheduling(Scheduling scheduling) {
      this.scheduling = scheduling;
      return this;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * A list of service accounts, with their specified scopes, authorized for this instance. Only
     * one service account per VM instance is supported.
     *
     * <p>Service accounts generate access tokens that can be accessed through the metadata server
     * and used to authenticate applications on the instance. See Service Accounts for more
     * information.
     */
    public List<ServiceAccount> getServiceAccountsList() {
      return serviceAccounts;
    }

    /**
     * A list of service accounts, with their specified scopes, authorized for this instance. Only
     * one service account per VM instance is supported.
     *
     * <p>Service accounts generate access tokens that can be accessed through the metadata server
     * and used to authenticate applications on the instance. See Service Accounts for more
     * information.
     */
    public Builder addAllServiceAccounts(List<ServiceAccount> serviceAccounts) {
      if (this.serviceAccounts == null) {
        this.serviceAccounts = new LinkedList<>();
      }
      this.serviceAccounts.addAll(serviceAccounts);
      return this;
    }

    /**
     * A list of service accounts, with their specified scopes, authorized for this instance. Only
     * one service account per VM instance is supported.
     *
     * <p>Service accounts generate access tokens that can be accessed through the metadata server
     * and used to authenticate applications on the instance. See Service Accounts for more
     * information.
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

    public ShieldedInstanceIntegrityPolicy getShieldedInstanceIntegrityPolicy() {
      return shieldedInstanceIntegrityPolicy;
    }

    public Builder setShieldedInstanceIntegrityPolicy(
        ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy) {
      this.shieldedInstanceIntegrityPolicy = shieldedInstanceIntegrityPolicy;
      return this;
    }

    /**
     * [Output Only] Whether a VM has been restricted for start because Compute Engine has detected
     * suspicious activity.
     */
    public Boolean getStartRestricted() {
      return startRestricted;
    }

    /**
     * [Output Only] Whether a VM has been restricted for start because Compute Engine has detected
     * suspicious activity.
     */
    public Builder setStartRestricted(Boolean startRestricted) {
      this.startRestricted = startRestricted;
      return this;
    }

    /**
     * [Output Only] The status of the instance. One of the following values: PROVISIONING, STAGING,
     * RUNNING, STOPPING, STOPPED, SUSPENDING, SUSPENDED, and TERMINATED.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the instance. One of the following values: PROVISIONING, STAGING,
     * RUNNING, STOPPING, STOPPED, SUSPENDING, SUSPENDED, and TERMINATED.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public String getStatusMessage() {
      return statusMessage;
    }

    /** [Output Only] An optional, human-readable explanation of the status. */
    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    /**
     * Tags to apply to this instance. Tags are used to identify valid sources or targets for
     * network firewalls and are specified by the client during instance creation. The tags can be
     * later modified by the setTags method. Each tag within the list must comply with RFC1035.
     * Multiple tags can be specified via the 'tags.items' field.
     */
    public Tags getTags() {
      return tags;
    }

    /**
     * Tags to apply to this instance. Tags are used to identify valid sources or targets for
     * network firewalls and are specified by the client during instance creation. The tags can be
     * later modified by the setTags method. Each tag within the list must comply with RFC1035.
     * Multiple tags can be specified via the 'tags.items' field.
     */
    public Builder setTags(Tags tags) {
      this.tags = tags;
      return this;
    }

    /**
     * [Output Only] URL of the zone where the instance resides. You must specify this field as part
     * of the HTTP request URL. It is not settable as a field in the request body.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] URL of the zone where the instance resides. You must specify this field as part
     * of the HTTP request URL. It is not settable as a field in the request body.
     */
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
          displayDevice,
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
          reservationAffinity,
          scheduling,
          selfLink,
          serviceAccounts,
          shieldedInstanceConfig,
          shieldedInstanceIntegrityPolicy,
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
      newBuilder.setDisplayDevice(this.displayDevice);
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
      newBuilder.setReservationAffinity(this.reservationAffinity);
      newBuilder.setScheduling(this.scheduling);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllServiceAccounts(this.serviceAccounts);
      newBuilder.setShieldedInstanceConfig(this.shieldedInstanceConfig);
      newBuilder.setShieldedInstanceIntegrityPolicy(this.shieldedInstanceIntegrityPolicy);
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
        + "displayDevice="
        + displayDevice
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
        + "reservationAffinity="
        + reservationAffinity
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
        + "shieldedInstanceConfig="
        + shieldedInstanceConfig
        + ", "
        + "shieldedInstanceIntegrityPolicy="
        + shieldedInstanceIntegrityPolicy
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
          && Objects.equals(this.displayDevice, that.getDisplayDevice())
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
          && Objects.equals(this.reservationAffinity, that.getReservationAffinity())
          && Objects.equals(this.scheduling, that.getScheduling())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.serviceAccounts, that.getServiceAccountsList())
          && Objects.equals(this.shieldedInstanceConfig, that.getShieldedInstanceConfig())
          && Objects.equals(
              this.shieldedInstanceIntegrityPolicy, that.getShieldedInstanceIntegrityPolicy())
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
        displayDevice,
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
        reservationAffinity,
        scheduling,
        selfLink,
        serviceAccounts,
        shieldedInstanceConfig,
        shieldedInstanceIntegrityPolicy,
        startRestricted,
        status,
        statusMessage,
        tags,
        zone);
  }
}
