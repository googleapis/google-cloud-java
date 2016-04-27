/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.gcloud.compute.Compute.InstanceOption;
import com.google.gcloud.compute.Compute.OperationOption;
import com.google.gcloud.compute.NetworkInterface.AccessConfig;

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

  /**
   * A builder for {@code Instance} objects.
   */
  public static class Builder extends InstanceInfo.Builder {

    private final Compute compute;
    private final InstanceInfo.BuilderImpl infoBuilder;

    Builder(Compute compute, InstanceId instanceId, MachineTypeId machineType,
        AttachedDisk attachedDisk, NetworkInterface networkInterface) {
      this.compute = compute;
      this.infoBuilder = new InstanceInfo.BuilderImpl(instanceId);
      this.infoBuilder.machineType(machineType);
      this.infoBuilder.attachedDisks(ImmutableList.of(attachedDisk));
      this.infoBuilder.networkInterfaces(ImmutableList.of(networkInterface));
    }

    Builder(Instance instance) {
      this.compute = instance.compute;
      this.infoBuilder = new InstanceInfo.BuilderImpl(instance);
    }

    @Override
    Builder generatedId(String generatedId) {
      this.infoBuilder.generatedId(generatedId);
      return this;
    }

    @Override
    public Builder instanceId(InstanceId instanceId) {
      this.infoBuilder.instanceId(instanceId);
      return this;
    }

    @Override
    Builder creationTimestamp(Long creationTimestamp) {
      this.infoBuilder.creationTimestamp(creationTimestamp);
      return this;
    }

    @Override
    public Builder description(String description) {
      this.infoBuilder.description(description);
      return this;
    }

    @Override
    Builder status(Status status) {
      this.infoBuilder.status(status);
      return this;
    }

    @Override
    Builder statusMessage(String statusMessage) {
      this.infoBuilder.statusMessage(statusMessage);
      return this;
    }

    @Override
    public Builder tags(Tags tags) {
      this.infoBuilder.tags(tags);
      return this;
    }

    @Override
    public Builder machineType(MachineTypeId machineType) {
      this.infoBuilder.machineType(machineType);
      return this;
    }

    @Override
    public Builder canIpForward(Boolean canIpForward) {
      this.infoBuilder.canIpForward(canIpForward);
      return this;
    }

    @Override
    public Builder networkInterfaces(List<NetworkInterface> networkInterfaces) {
      this.infoBuilder.networkInterfaces(networkInterfaces);
      return this;
    }

    @Override
    public Builder networkInterfaces(NetworkInterface... networkInterfaces) {
      this.infoBuilder.networkInterfaces(networkInterfaces);
      return this;
    }

    @Override
    public Builder attachedDisks(List<AttachedDisk> attachedDisks) {
      this.infoBuilder.attachedDisks(attachedDisks);
      return this;
    }

    @Override
    public Builder attachedDisks(AttachedDisk... attachedDisks) {
      this.infoBuilder.attachedDisks(attachedDisks);
      return this;
    }

    @Override
    public Builder metadata(Metadata metadata) {
      this.infoBuilder.metadata(metadata);
      return this;
    }

    @Override
    public Builder serviceAccounts(List<ServiceAccount> serviceAccounts) {
      this.infoBuilder.serviceAccounts(serviceAccounts);
      return this;
    }

    @Override
    public Builder schedulingOptions(SchedulingOptions schedulingOptions) {
      this.infoBuilder.schedulingOptions(schedulingOptions);
      return this;
    }

    @Override
    Builder cpuPlatform(String cpuPlatform) {
      this.infoBuilder.cpuPlatform(cpuPlatform);
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
    this.options = compute.options();
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
    return compute.get(instanceId(), options);
  }

  /**
   * Deletes this instance.
   *
   * @return a zone operation if delete request was successfully sent, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation delete(OperationOption... options) {
    return compute.delete(instanceId(), options);
  }

  /**
   * Adds an access configuration to the provided network interface for this instance.
   *
   * @return a zone operation if the add request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation addAccessConfig(String networkInterface, AccessConfig accessConfig,
      OperationOption... options) {
    return compute.addAccessConfig(instanceId(), networkInterface, accessConfig, options);
  }

  /**
   * Attaches a persistent disk to this instance given its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(PersistentDiskConfiguration configuration,
      OperationOption... options) {
    return compute.attachDisk(instanceId(), configuration, options);
  }

  /**
   * Attaches a persistent disk to this instance given the device name and its configuration.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(String deviceName, PersistentDiskConfiguration configuration,
      OperationOption... options) {
    return compute.attachDisk(instanceId(), deviceName, configuration, options);
  }

  /**
   * Attaches a persistent disk to this instance given the device name, its configuration and the
   * device index.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation attachDisk(String deviceName, PersistentDiskConfiguration configuration,
      int index, OperationOption... options) {
    return compute.attachDisk(instanceId(), deviceName, configuration, index, options);
  }

  /**
   * Deletes an access configuration from the provided network interface for this instance.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation deleteAccessConfig(String networkInterface, String accessConfig,
      OperationOption... options) {
    return compute.deleteAccessConfig(instanceId(), networkInterface, accessConfig, options);
  }

  /**
   * Detaches a disk from this instance.
   *
   * @return a zone operation if the detach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation detachDisk(String deviceName, OperationOption... options) {
    return compute.detachDisk(instanceId(), deviceName, options);
  }

  /**
   * Returns the serial port output for this instance and port number. {@code port} must be between
   * 1 and 4 (inclusive).
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  public String getSerialPortOutput(int port) {
    return compute.getSerialPortOutput(instanceId(), port);
  }

  /**
   * Returns the default serial port output for this instance. Default serial port corresponds to
   * port number 1.
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  public String getSerialPortOutput() {
    return compute.getSerialPortOutput(instanceId());
  }

  /**
   * Resets this instance.
   *
   * @return a zone operation if the reset request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation reset(OperationOption... options) {
    return compute.reset(instanceId(), options);
  }

  /**
   * Sets the auto-delete flag for a disk attached to this instance.
   *
   * @return a zone operation if the flag setting request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation setDiskAutoDelete(String deviceName, boolean autoDelete,
      OperationOption... options) {
    return compute.setDiskAutoDelete(instanceId(), deviceName, autoDelete, options);
  }

  /**
   * Sets the machine type for this instance. The instance must be in
   * {@link InstanceInfo.Status#TERMINATED} state to be able to set its machine type.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMachineType(MachineTypeId machineType, OperationOption... options) {
    return compute.setMachineType(instanceId(), machineType, options);
  }

  /**
   * Sets the metadata for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMetadata(Metadata metadata, OperationOption... options) {
    return compute.setMetadata(instanceId(), metadata, options);
  }

  /**
   * Sets the metadata for this instance, fingerprint value is taken from this instance's
   * {@code tags().fingerprint()}.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setMetadata(Map<String, String> metadata, OperationOption... options) {
    return setMetadata(metadata().toBuilder().values(metadata).build(), options);
  }

  /**
   * Sets the scheduling options for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setSchedulingOptions(SchedulingOptions scheduling, OperationOption... options) {
    return compute.setSchedulingOptions(instanceId(), scheduling, options);
  }

  /**
   * Sets the tags for this instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setTags(Tags tags, OperationOption... options) {
    return compute.setTags(instanceId(), tags, options);
  }

  /**
   * Sets the tags for this instance, fingerprint value is taken from this instance's
   * {@code tags().fingerprint()}.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  public Operation setTags(Iterable<String> tags, OperationOption... options) {
    return setTags(tags().toBuilder().values(tags).build(), options);
  }

  /**
   * Starts this instance.
   *
   * @return a zone operation if the start request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation start(OperationOption... options) {
    return compute.start(instanceId(), options);
  }

  /**
   * Stops this instance.
   *
   * @return a zone operation if the stop request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  public Operation stop(OperationOption... options) {
    return compute.stop(instanceId(), options);
  }

  /**
   * Returns the snapshot's {@code Compute} object used to issue requests.
   */
  public Compute compute() {
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
    this.compute = options.service();
  }

  static Instance fromPb(Compute compute,
      com.google.api.services.compute.model.Instance instancePb) {
    return new Instance(compute, new InstanceInfo.BuilderImpl(instancePb));
  }
}
