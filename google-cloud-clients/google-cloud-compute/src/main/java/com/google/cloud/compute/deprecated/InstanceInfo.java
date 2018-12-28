/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.compute.model.Instance;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * A Google Compute Engine VM Instance. An instance is a virtual machine (VM) hosted on Google's
 * infrastructure. Instances can run Linux and Windows Server images provided by Google, or any
 * customized versions of these images. You can also build and run images of other operating
 * systems. Google Compute Engine also lets you choose the machine properties of your instances,
 * such as the number of virtual CPUs and the amount of memory
 *
 * <p>By default, each Compute Engine instance has a small root persistent disk that contains the
 * operating system. When your applications require additional storage space, you can add one or
 * more additional disks to your instance.
 *
 * <p>Instances communicate with other instances in the same network through a local area network.
 * Instances communicate with the rest of the world through the Internet. A network lives in a
 * project and is isolated from other networks in the project. A project can have up to five
 * different networks.
 *
 * @see <a href="https://cloud.google.com/compute/docs/instances/">Virtual Machine Instances</a>
 */
public class InstanceInfo implements Serializable {

  static final Function<Instance, InstanceInfo> FROM_PB_FUNCTION =
      new Function<Instance, InstanceInfo>() {
        @Override
        public InstanceInfo apply(Instance pb) {
          return InstanceInfo.fromPb(pb);
        }
      };
  static final Function<InstanceInfo, Instance> TO_PB_FUNCTION =
      new Function<InstanceInfo, Instance>() {
        @Override
        public Instance apply(InstanceInfo instance) {
          return instance.toPb();
        }
      };

  private static final long serialVersionUID = -6601223112628977168L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private final String generatedId;
  private final InstanceId instanceId;
  private final Long creationTimestamp;
  private final String description;
  private final Status status;
  private final String statusMessage;
  private final Tags tags;
  private final MachineTypeId machineType;
  private final Boolean canIpForward;
  private final List<NetworkInterface> networkInterfaces;
  private final List<AttachedDisk> attachedDisks;
  private final Metadata metadata;
  private final List<ServiceAccount> serviceAccounts;
  private final SchedulingOptions schedulingOptions;
  private final String cpuPlatform;

  /** The status of the instance. */
  public enum Status {
    /**
     * Indicates that resources are being reserved for the instance. The instance isn't running yet.
     */
    PROVISIONING,

    /**
     * Indicates that resources have been acquired and the instance is being prepared for launch.
     */
    STAGING,

    /**
     * Indicates that the instance is booting up or running. You should be able to {@code ssh} into
     * the instance soon, though not immediately, after it enters this state.
     */
    RUNNING,

    /**
     * Indicates that the instance is being stopped either due to a failure, or the instance being
     * shut down. This is a temporary status and the instance will move to {@code TERMINATED}.
     */
    STOPPING,

    /**
     * Indicates that the instance was shut down or encountered a failure, either through the API or
     * from inside the guest. You can choose to restart the instance or delete it.
     */
    TERMINATED
  }

  /** A builder for {@code InstanceInfo} objects. */
  public abstract static class Builder {

    abstract Builder setGeneratedId(String generatedId);

    /** Sets the identity of the virtual machine instance. */
    public abstract Builder setInstanceId(InstanceId instanceId);

    abstract Builder setCreationTimestamp(Long creationTimestamp);

    /** Sets an optional description of this Google Compute Engine instance. */
    public abstract Builder setDescription(String description);

    abstract Builder setStatus(Status status);

    abstract Builder setStatusMessage(String statusMessage);

    /**
     * Sets the tags to apply to this instance. Tags are used to identify valid sources or targets
     * for network firewalls.
     */
    public abstract Builder setTags(Tags tags);

    /** Sets the machine type identity. */
    public abstract Builder setMachineType(MachineTypeId machineType);

    /**
     * Sets whether to allow this instance to send and receive packets with non-matching destination
     * or source IPs. This is required if you plan to use this instance to forward routes.
     *
     * @see <a href="https://cloud.google.com/compute/docs/networking#canipforward">Enabling IP
     *     Forwarding</a>
     */
    public abstract Builder setCanIpForward(Boolean canIpForward);

    /**
     * Sets a list of network interfaces. This specifies how this instance is configured to interact
     * with other network services, such as connecting to the internet. At the moment, instances
     * only support one network interface.
     */
    public abstract Builder setNetworkInterfaces(List<NetworkInterface> networkInterfaces);

    /**
     * Sets a list of network interfaces. This specifies how this instance is configured to interact
     * with other network services, such as connecting to the internet. At the moment, instances
     * only support one network interface.
     */
    public abstract Builder setNetworkInterfaces(NetworkInterface... networkInterfaces);

    /**
     * Sets a list of disks to attach to the instance. One boot disk must be provided (i.e. an
     * attached disk such that {@link AttachedDisk.AttachedDiskConfiguration#boot()} returns {@code
     * true}).
     */
    public abstract Builder setAttachedDisks(List<AttachedDisk> attachedDisks);

    /** Sets a list of disks to attach to the instance. One boot disk must be provided. */
    public abstract Builder setAttachedDisks(AttachedDisk... attachedDisks);

    /** Sets the instance metadata. */
    public abstract Builder setMetadata(Metadata metadata);

    /**
     * Sets a list of service accounts, with their specified scopes, authorized for this instance.
     * Service accounts generate access tokens that can be accessed through the metadata server and
     * used to authenticate applications on the instance.
     *
     * @see <a href="https://cloud.google.com/compute/docs/authentication">Authenticating from
     *     Google Compute Engine</a>
     */
    public abstract Builder setServiceAccounts(List<ServiceAccount> serviceAccounts);

    /** Sets the scheduling options for the instance. */
    public abstract Builder setSchedulingOptions(SchedulingOptions schedulingOptions);

    abstract Builder setCpuPlatform(String cpuPlatform);

    /** Creates an {@code InstanceInfo} object. */
    public abstract InstanceInfo build();
  }

  public static final class BuilderImpl extends Builder {

    private String generatedId;
    private InstanceId instanceId;
    private Long creationTimestamp;
    private String description;
    private Status status;
    private String statusMessage;
    private Tags tags;
    private MachineTypeId machineType;
    private Boolean canIpForward;
    private List<NetworkInterface> networkInterfaces;
    private List<AttachedDisk> attachedDisks;
    private Metadata metadata;
    private List<ServiceAccount> serviceAccounts;
    private SchedulingOptions schedulingOptions;
    private String cpuPlatform;

    BuilderImpl(InstanceId instanceId) {
      this.instanceId = checkNotNull(instanceId);
    }

    BuilderImpl(InstanceInfo instance) {
      this.generatedId = instance.generatedId;
      this.instanceId = instance.instanceId;
      this.creationTimestamp = instance.creationTimestamp;
      this.description = instance.description;
      this.status = instance.status;
      this.statusMessage = instance.statusMessage;
      this.tags = instance.tags;
      this.machineType = instance.machineType;
      this.canIpForward = instance.canIpForward;
      this.networkInterfaces = instance.networkInterfaces;
      this.attachedDisks = instance.attachedDisks;
      this.metadata = instance.metadata;
      this.serviceAccounts = instance.serviceAccounts;
      this.schedulingOptions = instance.schedulingOptions;
      this.cpuPlatform = instance.cpuPlatform;
    }

    BuilderImpl(Instance instancePb) {
      if (instancePb.getId() != null) {
        this.generatedId = instancePb.getId().toString();
      }
      this.instanceId = InstanceId.fromUrl(instancePb.getSelfLink());
      if (instancePb.getCreationTimestamp() != null) {
        this.creationTimestamp = TIMESTAMP_FORMATTER.parseMillis(instancePb.getCreationTimestamp());
      }
      this.description = instancePb.getDescription();
      if (instancePb.getStatus() != null) {
        this.status = Status.valueOf(instancePb.getStatus());
      }
      this.statusMessage = instancePb.getStatusMessage();
      if (instancePb.getTags() != null) {
        this.tags = Tags.fromPb(instancePb.getTags());
      }
      if (instancePb.getMachineType() != null) {
        this.machineType = MachineTypeId.fromUrl(instancePb.getMachineType());
      }
      this.canIpForward = instancePb.getCanIpForward();
      if (instancePb.getNetworkInterfaces() != null) {
        this.networkInterfaces =
            Lists.transform(instancePb.getNetworkInterfaces(), NetworkInterface.FROM_PB_FUNCTION);
      }
      if (instancePb.getDisks() != null) {
        this.attachedDisks = Lists.transform(instancePb.getDisks(), AttachedDisk.FROM_PB_FUNCTION);
      }
      if (instancePb.getMetadata() != null) {
        this.metadata = Metadata.fromPb(instancePb.getMetadata());
      }
      if (instancePb.getServiceAccounts() != null) {
        this.serviceAccounts =
            Lists.transform(instancePb.getServiceAccounts(), ServiceAccount.FROM_PB_FUNCTION);
      }
      if (instancePb.getScheduling() != null) {
        this.schedulingOptions = SchedulingOptions.fromPb(instancePb.getScheduling());
      }
      this.cpuPlatform = instancePb.getCpuPlatform();
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    public Builder setInstanceId(InstanceId instanceId) {
      this.instanceId = checkNotNull(instanceId);
      return this;
    }

    @Override
    Builder setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    Builder setStatus(Status status) {
      this.status = status;
      return this;
    }

    @Override
    Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    @Override
    public Builder setTags(Tags tags) {
      this.tags = tags;
      return this;
    }

    @Override
    public Builder setMachineType(MachineTypeId machineType) {
      this.machineType = checkNotNull(machineType);
      return this;
    }

    @Override
    public Builder setCanIpForward(Boolean canIpForward) {
      this.canIpForward = canIpForward;
      return this;
    }

    @Override
    public Builder setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
      this.networkInterfaces = ImmutableList.copyOf(checkNotNull(networkInterfaces));
      return this;
    }

    @Override
    public Builder setNetworkInterfaces(NetworkInterface... networkInterfaces) {
      this.networkInterfaces = Arrays.asList(networkInterfaces);
      return this;
    }

    @Override
    public Builder setAttachedDisks(List<AttachedDisk> attachedDisks) {
      this.attachedDisks = ImmutableList.copyOf(checkNotNull(attachedDisks));
      return this;
    }

    @Override
    public Builder setAttachedDisks(AttachedDisk... attachedDisks) {
      this.attachedDisks = Arrays.asList(attachedDisks);
      return this;
    }

    @Override
    public Builder setMetadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public Builder setServiceAccounts(List<ServiceAccount> serviceAccounts) {
      this.serviceAccounts = ImmutableList.copyOf(checkNotNull(serviceAccounts));
      return this;
    }

    @Override
    public Builder setSchedulingOptions(SchedulingOptions schedulingOptions) {
      this.schedulingOptions = schedulingOptions;
      return this;
    }

    @Override
    Builder setCpuPlatform(String cpuPlatform) {
      this.cpuPlatform = cpuPlatform;
      return this;
    }

    @Override
    public InstanceInfo build() {
      checkNotNull(attachedDisks);
      checkNotNull(networkInterfaces);
      return new InstanceInfo(this);
    }
  }

  InstanceInfo(BuilderImpl builder) {
    this.generatedId = builder.generatedId;
    this.instanceId = builder.instanceId;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.status = builder.status;
    this.statusMessage = builder.statusMessage;
    this.tags = builder.tags;
    this.machineType = builder.machineType;
    this.canIpForward = builder.canIpForward;
    this.networkInterfaces = builder.networkInterfaces;
    this.attachedDisks = builder.attachedDisks;
    this.metadata = builder.metadata;
    this.serviceAccounts = builder.serviceAccounts;
    this.schedulingOptions = builder.schedulingOptions;
    this.cpuPlatform = builder.cpuPlatform;
  }

  /** Returns the service-generated unique identifier for the instance. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the instance identity. */
  public InstanceId getInstanceId() {
    return instanceId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns a textual description of the instance. */
  public String getDescription() {
    return description;
  }

  /** Returns the status of the instance. */
  public Status getStatus() {
    return status;
  }

  /** Returns an optional, human-readable explanation of the status. */
  public String getStatusMessage() {
    return statusMessage;
  }

  /**
   * Returns the tags of this instance. Tags are used to identify valid sources or targets for
   * network firewalls.
   */
  public Tags getTags() {
    return tags;
  }

  /** Returns the machine type identity. */
  public MachineTypeId getMachineType() {
    return machineType;
  }

  /**
   * Returns whether to allow this instance to send and receive packets with non-matching
   * destination or source IPs. This is required if you plan to use this instance to forward routes.
   *
   * @see <a href="https://cloud.google.com/compute/docs/networking#canipforward">Enabling IP
   *     Forwarding</a>
   */
  public Boolean canIpForward() {
    return canIpForward;
  }

  /**
   * Returns a list of network interfaces. This specifies how this instance is configured to
   * interact with other network services, such as connecting to the internet.
   */
  public List<NetworkInterface> getNetworkInterfaces() {
    return networkInterfaces;
  }

  /** Returns a list of disks attached to the instance. */
  public List<AttachedDisk> getAttachedDisks() {
    return attachedDisks;
  }

  /** Returns the instance metadata. */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * Returns a list of service accounts, with their specified scopes, authorized for this instance.
   * Service accounts generate access tokens that can be accessed through the metadata server and
   * used to authenticate applications on the instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/authentication">Authenticating from Google
   *     Compute Engine</a>
   */
  public List<ServiceAccount> getServiceAccounts() {
    return serviceAccounts;
  }

  /** Returns the scheduling options for the instance. */
  public SchedulingOptions getSchedulingOptions() {
    return schedulingOptions;
  }

  /** Returns the CPU platform used by this instance. */
  public String getCpuPlatform() {
    return cpuPlatform;
  }

  /** Returns a builder for the current instance. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("instanceId", instanceId)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("status", status)
        .add("statusMessage", statusMessage)
        .add("tags", tags)
        .add("machineType", machineType)
        .add("canIpForward", canIpForward)
        .add("networkInterfaces", networkInterfaces)
        .add("attachedDisks", attachedDisks)
        .add("metadata", metadata)
        .add("serviceAccounts", serviceAccounts)
        .add("schedulingOptions", schedulingOptions)
        .add("cpuPlatform", cpuPlatform)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        generatedId,
        instanceId,
        creationTimestamp,
        description,
        status,
        statusMessage,
        tags,
        machineType,
        canIpForward,
        networkInterfaces,
        attachedDisks,
        metadata,
        serviceAccounts,
        schedulingOptions,
        cpuPlatform);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(InstanceInfo.class)
            && Objects.equals(toPb(), ((InstanceInfo) obj).toPb());
  }

  InstanceInfo setProjectId(final String projectId) {
    Builder builder = toBuilder();
    builder.setNetworkInterfaces(
        Lists.transform(
            networkInterfaces,
            new Function<NetworkInterface, NetworkInterface>() {
              @Override
              public NetworkInterface apply(NetworkInterface networkInterface) {
                return networkInterface.setProjectId(projectId);
              }
            }));
    builder.setAttachedDisks(
        Lists.transform(
            attachedDisks,
            new Function<AttachedDisk, AttachedDisk>() {
              @Override
              public AttachedDisk apply(AttachedDisk attachedDisk) {
                return attachedDisk.setProjectId(projectId);
              }
            }));
    return builder
        .setInstanceId(instanceId.setProjectId(projectId))
        .setMachineType(machineType.setProjectId(projectId))
        .build();
  }

  Instance toPb() {
    Instance instancePb = new Instance();
    if (generatedId != null) {
      instancePb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      instancePb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    instancePb.setName(instanceId.getInstance());
    instancePb.setDescription(description);
    instancePb.setSelfLink(instanceId.getSelfLink());
    instancePb.setZone(instanceId.getZoneId().getSelfLink());
    if (status != null) {
      instancePb.setStatus(status.name());
    }
    instancePb.setStatusMessage(statusMessage);
    if (tags != null) {
      instancePb.setTags(tags.toPb());
    }
    if (machineType != null) {
      instancePb.setMachineType(machineType.getSelfLink());
    }
    instancePb.setCanIpForward(canIpForward);
    if (networkInterfaces != null) {
      instancePb.setNetworkInterfaces(
          Lists.transform(networkInterfaces, NetworkInterface.TO_PB_FUNCTION));
    }
    if (attachedDisks != null) {
      instancePb.setDisks(Lists.transform(attachedDisks, AttachedDisk.TO_PB_FUNCTION));
    }
    if (metadata != null) {
      instancePb.setMetadata(metadata.toPb());
    }
    if (serviceAccounts != null) {
      instancePb.setServiceAccounts(
          Lists.transform(serviceAccounts, ServiceAccount.TO_PB_FUNCTION));
    }
    if (schedulingOptions != null) {
      instancePb.setScheduling(schedulingOptions.toPb());
    }
    instancePb.setCpuPlatform(cpuPlatform);
    return instancePb;
  }

  /**
   * Returns a builder for an {@code InstanceInfo} object given the instance identity and the
   * machine type.
   */
  public static Builder newBuilder(InstanceId instanceId, MachineTypeId machineType) {
    return new BuilderImpl(instanceId).setMachineType(machineType);
  }

  /**
   * Returns an {@code InstanceInfo} object given the instance identity, the machine type, a disk to
   * attach to the instance and a network interface. {@code disk} must be a boot disk (i.e. {@link
   * AttachedDisk.AttachedDiskConfiguration#boot()} returns {@code true}).
   */
  public static InstanceInfo of(
      InstanceId instanceId,
      MachineTypeId machineType,
      AttachedDisk disk,
      NetworkInterface networkInterface) {
    return newBuilder(instanceId, machineType)
        .setAttachedDisks(ImmutableList.of(disk))
        .setNetworkInterfaces(ImmutableList.of(networkInterface))
        .build();
  }

  static InstanceInfo fromPb(Instance instancePb) {
    return new BuilderImpl(instancePb).build();
  }
}
