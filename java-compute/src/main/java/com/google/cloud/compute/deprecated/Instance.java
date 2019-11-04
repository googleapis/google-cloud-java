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

import com.google.cloud.compute.deprecated.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.deprecated.Compute.InstanceOption;
import com.google.cloud.compute.deprecated.Compute.OperationOption;
import com.google.cloud.compute.deprecated.NetworkInterface.AccessConfig;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Compute Engine VM Instance. An instance is a virtual machine (VM) hosted on Google's
 * infrastructure. Instances can run Linux and Windows Server images provided by Google, or any
 * customized versions of these images. You can also build and run images of other operating
 * systems. Objects of this class are immutable. To get an {@code Instance} object with the most
 * recent information use {@link #reload}. {@code Instance} adds a layer of service-related
 * functionality over {@link InstanceInfo}.
 *
 * @see <a href="https://cloud.google.com/compute/docs/instances/">Virtual Machine Instances</a>
 */
public class Instance extends InstanceInfo {

  private static final long serialVersionUID = 3072508155558980677L;

  private final ComputeOptions options;
  private transient Compute compute;

  /** A builder for {@code Instance} objects. */
  public static class Builder extends InstanceInfo.Builder {

    private final Compute compute;
    private final InstanceInfo.BuilderImpl infoBuilder;

    Builder(
        Compute compute,
        InstanceId instanceId,
        MachineTypeId machineType,
        AttachedDisk attachedDisk,
        NetworkInterface networkInterface) {
      this.compute = compute;
      this.infoBuilder = new InstanceInfo.BuilderImpl(instanceId);
      this.infoBuilder.setMachineType(machineType);
      this.infoBuilder.setAttachedDisks(ImmutableList.of(attachedDisk));
      this.infoBuilder.setNetworkInterfaces(ImmutableList.of(networkInterface));
    }

    Builder(Instance instance) {
      this.compute = instance.compute;
      this.infoBuilder = new InstanceInfo.BuilderImpl(instance);
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    public Builder setInstanceId(InstanceId instanceId) {
      this.infoBuilder.setInstanceId(instanceId);
      return this;
    }

    @Override
    Builder setCreationTimestamp(Long creationTimestamp) {
      this.infoBuilder.setCreationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setStatus(Status status) {
      this.infoBuilder.setStatus(status);
      return this;
    }

    @Override
    Builder setStatusMessage(String statusMessage) {
      this.infoBuilder.setStatusMessage(statusMessage);
      return this;
    }

    @Override
    public Builder setTags(Tags tags) {
      this.infoBuilder.setTags(tags);
      return this;
    }

    @Override
    public Builder setMachineType(MachineTypeId machineType) {
      this.infoBuilder.setMachineType(machineType);
      return this;
    }

    @Override
    public Builder setCanIpForward(Boolean canIpForward) {
      this.infoBuilder.setCanIpForward(canIpForward);
      return this;
    }

    @Override
    public Builder setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
      this.infoBuilder.setNetworkInterfaces(networkInterfaces);
      return this;
    }

    @Override
    public Builder setNetworkInterfaces(NetworkInterface... networkInterfaces) {
      this.infoBuilder.setNetworkInterfaces(networkInterfaces);
      return this;
    }

    @Override
    public Builder setAttachedDisks(List<AttachedDisk> attachedDisks) {
      this.infoBuilder.setAttachedDisks(attachedDisks);
      return this;
    }

    @Override
    public Builder setAttachedDisks(AttachedDisk... attachedDisks) {
      this.infoBuilder.setAttachedDisks(attachedDisks);
      return this;
    }

    @Override
    public Builder setMetadata(Metadata metadata) {
      this.infoBuilder.setMetadata(metadata);
      return this;
    }

    @Override
    public Builder setServiceAccounts(List<ServiceAccount> serviceAccounts) {
      this.infoBuilder.setServiceAccounts(serviceAccounts);
      return this;
    }

    @Override
    public Builder setSchedulingOptions(SchedulingOptions schedulingOptions) {
      this.infoBuilder.setSchedulingOptions(schedulingOptions);
      return this;
    }

    @Override
    Builder setCpuPlatform(String cpuPlatform) {
      this.infoBuilder.setCpuPlatform(cpuPlatform);
      return this;
    }

    @Override
    public Instance build() {
      return new Instance(compute, infoBuilder);
    }
  }

  Instance(Compute compute, Instance.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.compute = checkNotNull(compute);
    this.options = compute.getOptions();
  }

  /**
   * Checks if this instance exists.
   *
   * @return {@code true} if this instance exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(InstanceOption.fields()) != null;
  }

  /**
   * Fetches current instance's latest information. Returns {@code null} if the instance does not
   * exist.
   *
   * @param options instance options
   * @return a {@code Instance} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Instance reload(InstanceOption... options) {
    return compute.getInstance(getInstanceId(), options);
  }

  /**
   * Deletes this instance.
   *
   * @return a zone operation if delete request was successfully sent, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.deleteInstance(getInstanceId(), options);
  }

  /**
   * Adds an access configuration to the provided network interface for this instance.
   *
   * @return a zone operation if the add request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation addAccessConfig(
      String networkInterface, AccessConfig accessConfig, OperationOption... options) {
    return compute.addAccessConfig(getInstanceId(), networkInterface, accessConfig, options);
  }

  /**
   * Attaches a persistent disk to this instance given its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(
      PersistentDiskConfiguration configuration, OperationOption... options) {
    return compute.attachDisk(getInstanceId(), configuration, options);
  }

  /**
   * Attaches a persistent disk to this instance given the device name and its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(
      String deviceName, PersistentDiskConfiguration configuration, OperationOption... options) {
    return compute.attachDisk(getInstanceId(), deviceName, configuration, options);
  }

  /**
   * Attaches a persistent disk to this instance given the device name, its configuration and the
   * device index.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(
      String deviceName,
      PersistentDiskConfiguration configuration,
      int index,
      OperationOption... options) {
    return compute.attachDisk(getInstanceId(), deviceName, configuration, index, options);
  }

  /**
   * Deletes an access configuration from the provided network interface for this instance.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation deleteAccessConfig(
      String networkInterface, String accessConfig, OperationOption... options) {
    return compute.deleteAccessConfig(getInstanceId(), networkInterface, accessConfig, options);
  }

  /**
   * Detaches a disk from this instance.
   *
   * @return a zone operation if the detach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation detachDisk(String deviceName, OperationOption... options) {
    return compute.detachDisk(getInstanceId(), deviceName, options);
  }

  /**
   * Returns the serial port output for this instance and port number. {@code port} must be between
   * 1 and 4 (inclusive).
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  public String getSerialPortOutput(int port) {
    return compute.getSerialPortOutput(getInstanceId(), port);
  }

  /**
   * Returns the default serial port output for this instance. Default serial port corresponds to
   * port number 1.
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  public String getSerialPortOutput() {
    return compute.getSerialPortOutput(getInstanceId());
  }

  /**
   * Resets this instance.
   *
   * @return a zone operation if the reset request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation reset(OperationOption... options) {
    return compute.reset(getInstanceId(), options);
  }

  /**
   * Sets the auto-delete flag for a disk attached to this instance.
   *
   * @return a zone operation if the flag setting request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation setDiskAutoDelete(
      String deviceName, boolean autoDelete, OperationOption... options) {
    return compute.setDiskAutoDelete(getInstanceId(), deviceName, autoDelete, options);
  }

  /**
   * Sets the machine type for this instance. The instance must be in {@link
   * InstanceInfo.Status#TERMINATED} state to be able to set its machine type.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMachineType(MachineTypeId machineType, OperationOption... options) {
    return compute.setMachineType(getInstanceId(), machineType, options);
  }

  /**
   * Sets the metadata for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMetadata(Metadata metadata, OperationOption... options) {
    return compute.setMetadata(getInstanceId(), metadata, options);
  }

  /**
   * Sets the metadata for this instance, fingerprint value is taken from this instance's {@code
   * tags().fingerprint()}.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMetadata(Map<String, String> metadata, OperationOption... options) {
    return setMetadata(getMetadata().toBuilder().setValues(metadata).build(), options);
  }

  /**
   * Sets the scheduling options for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setSchedulingOptions(SchedulingOptions scheduling, OperationOption... options) {
    return compute.setSchedulingOptions(getInstanceId(), scheduling, options);
  }

  /**
   * Sets the tags for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setTags(Tags tags, OperationOption... options) {
    return compute.setTags(getInstanceId(), tags, options);
  }

  /**
   * Sets the tags for this instance, fingerprint value is taken from this instance's {@code
   * tags().fingerprint()}.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setTags(Iterable<String> tags, OperationOption... options) {
    return setTags(getTags().toBuilder().setValues(tags).build(), options);
  }

  /**
   * Starts this instance.
   *
   * @return a zone operation if the start request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation start(OperationOption... options) {
    return compute.start(getInstanceId(), options);
  }

  /**
   * Stops this instance.
   *
   * @return a zone operation if the stop request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation stop(OperationOption... options) {
    return compute.stop(getInstanceId(), options);
  }

  /** Returns the snapshot's {@code Compute} object used to issue requests. */
  public Compute getCompute() {
    return compute;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Instance.class)) {
      return false;
    }
    Instance other = (Instance) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.getService();
  }

  static Instance fromPb(
      Compute compute, com.google.api.services.compute.model.Instance instancePb) {
    return new Instance(compute, new InstanceInfo.BuilderImpl(instancePb));
  }
}
