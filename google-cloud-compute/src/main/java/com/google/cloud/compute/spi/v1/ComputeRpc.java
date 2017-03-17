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

package com.google.cloud.compute.spi.v1;

import com.google.api.services.compute.model.AccessConfig;
import com.google.api.services.compute.model.Address;
import com.google.api.services.compute.model.AttachedDisk;
import com.google.api.services.compute.model.DeprecationStatus;
import com.google.api.services.compute.model.Disk;
import com.google.api.services.compute.model.DiskType;
import com.google.api.services.compute.model.Image;
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.License;
import com.google.api.services.compute.model.MachineType;
import com.google.api.services.compute.model.Metadata;
import com.google.api.services.compute.model.Network;
import com.google.api.services.compute.model.Operation;
import com.google.api.services.compute.model.Region;
import com.google.api.services.compute.model.Scheduling;
import com.google.api.services.compute.model.Snapshot;
import com.google.api.services.compute.model.Subnetwork;
import com.google.api.services.compute.model.Tags;
import com.google.api.services.compute.model.Zone;
import com.google.cloud.ServiceRpc;
import com.google.cloud.compute.ComputeException;

import java.util.Map;

public interface ComputeRpc extends ServiceRpc {

  // These options are part of the Google Compute Engine query parameters
  enum Option {
    FIELDS("fields"),
    MAX_RESULTS("maxResults"),
    PAGE_TOKEN("pageToken"),
    FILTER("filter");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }

    Long getLong(Map<Option, ?> options) {
      return get(options);
    }

    Boolean getBoolean(Map<Option, ?> options) {
      return get(options);
    }
  }

  class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    public X x() {
      return x;
    }

    public Y y() {
      return y;
    }
  }

  /**
   * Returns the requested disk type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  DiskType getDiskType(String zone, String diskType, Map<Option, ?> options);

  /**
   * Lists the disk types in the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<DiskType>> listDiskTypes(String zone, Map<Option, ?> options);

  /**
   * Lists disk types.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<DiskType>> listDiskTypes(Map<Option, ?> options);

  /**
   * Returns the requested machine type or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  MachineType getMachineType(String zone, String diskType, Map<Option, ?> options);

  /**
   * Lists the machine types in the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<MachineType>> listMachineTypes(String zone, Map<Option, ?> options);

  /**
   * Lists machine types.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<MachineType>> listMachineTypes(Map<Option, ?> options);

  /**
   * Returns the requested region or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Region getRegion(String region, Map<Option, ?> options);

  /**
   * Lists the regions.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Region>> listRegions(Map<Option, ?> options);

  /**
   * Returns the requested zone or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Zone getZone(String zone, Map<Option, ?> options);

  /**
   * Lists the zones.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Zone>> listZones(Map<Option, ?> options);

  /**
   * Returns the requested license or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  License getLicense(String project, String license, Map<Option, ?> options);

  /**
   * Returns the requested global operation or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Operation getGlobalOperation(String operation, Map<Option, ?> options);

  /**
   * Lists the global operations.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Operation>> listGlobalOperations(Map<Option, ?> options);

  /**
   * Deletes the requested global operation.
   *
   * @return {@code true} if operation was deleted, {@code false} if it was not found
   * @throws ComputeException upon failure
   */
  boolean deleteGlobalOperation(String operation);

  /**
   * Returns the requested region operation or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Operation getRegionOperation(String region, String operation, Map<Option, ?> options);

  /**
   * Lists the region operations for the provided region.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Operation>> listRegionOperations(String region, Map<Option, ?> options);

  /**
   * Deletes the requested region operation.
   *
   * @return {@code true} if operation was deleted, {@code false} if it was not found
   * @throws ComputeException upon failure
   */
  boolean deleteRegionOperation(String region, String operation);

  /**
   * Returns the requested zone operation or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Operation getZoneOperation(String zone, String operation, Map<Option, ?> options);

  /**
   * Lists the zone operations for the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Operation>> listZoneOperations(String zone, Map<Option, ?> options);

  /**
   * Deletes the requested zone operation.
   *
   * @return {@code true} if operation was deleted, {@code false} if it was not found
   * @throws ComputeException upon failure
   */
  boolean deleteZoneOperation(String zone, String operation);

  /**
   * Returns the requested global address or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Address getGlobalAddress(String address, Map<Option, ?> options);

  /**
   * Creates a new global address.
   *
   * @return a global operation for global address' creation
   * @throws ComputeException upon failure
   */
  Operation createGlobalAddress(Address address, Map<Option, ?> options);

  /**
   * Lists the global addresses.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Address>> listGlobalAddresses(Map<Option, ?> options);

  /**
   * Deletes the requested global address.
   *
   * @return a global operation if the request was issued correctly, {@code null} if the address was
   *     not found
   * @throws ComputeException upon failure
   */
  Operation deleteGlobalAddress(String address, Map<Option, ?> options);

  /**
   * Returns the requested region address or {@code null} if not found.
   *
   * @throws ComputeException upon failure or if region is not found
   */
  Address getRegionAddress(String region, String address, Map<Option, ?> options);

  /**
   * Creates a new region address.
   *
   * @return a region operation for region address' creation
   * @throws ComputeException upon failure or if region is not found
   */
  Operation createRegionAddress(String region, Address address, Map<Option, ?> options);

  /**
   * Lists the regions addresses for the provided region.
   *
   * @throws ComputeException upon failure or if region is not found
   */
  Tuple<String, Iterable<Address>> listRegionAddresses(String region, Map<Option, ?> options);

  /**
   * Lists all addresses.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Address>> listAddresses(Map<Option, ?> options);

  /**
   * Deletes the requested region address.
   *
   * @return a region operation if the request was issued correctly, {@code null} if the address was
   *     not found
   * @throws ComputeException upon failure or if region is not found
   */
  Operation deleteRegionAddress(String region, String address, Map<Option, ?> options);

  /**
   * Creates a snapshot for the specified disk.
   *
   * @return a zone operation for snapshot creation
   * @throws ComputeException upon failure
   */
  Operation createSnapshot(String zone, String disk, String snapshot, String description,
      Map<Option, ?> options);

  /**
   * Returns the requested snapshot or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Snapshot getSnapshot(String snapshot, Map<Option, ?> options);

  /**
   * Lists snapshots.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Snapshot>> listSnapshots(Map<Option, ?> options);

  /**
   * Deletes the requested snapshot. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data for that snapshot. If any data for the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next snapshot.
   *
   * @return a global operation if the request was issued correctly, {@code null} if the snapshot
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation deleteSnapshot(String snapshot, Map<Option, ?> options);

  /**
   * Creates a new image.
   *
   * @return a global operation for image's creation
   * @throws ComputeException upon failure
   */
  Operation createImage(Image image, Map<Option, ?> options);

  /**
   * Returns the requested image or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Image getImage(String project, String image, Map<Option, ?> options);

  /**
   * Lists images in the provided project that are available to the current user.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Image>> listImages(String project, Map<Option, ?> options);

  /**
   * Deletes the requested image.
   *
   * @return a global operation if the delete request was issued correctly, {@code null} if the
   *     image was not found
   * @throws ComputeException upon failure
   */
  Operation deleteImage(String project, String image, Map<Option, ?> options);

  /**
   * Deprecates the requested image.
   *
   * @return a global operation if the deprecation request was issued correctly, {@code null} if the
   *     image was not found
   * @throws ComputeException upon failure
   */
  Operation deprecateImage(String project, String image, DeprecationStatus deprecationStatus,
      Map<Option, ?> options);

  /**
   * Returns the requested disk or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Disk getDisk(String zone, String disk, Map<Option, ?> options);

  /**
   * Creates a new disk.
   *
   * @return a zone operation for disk's creation
   * @throws ComputeException upon failure
   */
  Operation createDisk(String zone, Disk disk, Map<Option, ?> options);

  /**
   * Lists the disks for the provided zone.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Disk>> listDisks(String zone, Map<Option, ?> options);

  /**
   * Lists disks for all zones.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Disk>> listDisks(Map<Option, ?> options);

  /**
   * Deletes the requested disk.
   *
   * @return a zone operation if the request was issued correctly, {@code null} if the disk was not
   *     found
   * @throws ComputeException upon failure
   */
  Operation deleteDisk(String zone, String disk, Map<Option, ?> options);

  /**
   * Resizes the disk to the requested size. The new size must be larger than the previous one.
   *
   * @return a zone operation if the request was issued correctly, {@code null} if the disk was not
   *     found
   * @throws ComputeException upon failure or if the new disk size is smaller than the previous one
   */
  Operation resizeDisk(String zone, String disk, long sizeGb, Map<Option, ?> options);

  /*
   * Creates a new subnetwork.
   *
   * @return a region operation for subnetwork's creation
   * @throws ComputeException upon failure
   */
  Operation createSubnetwork(String region, Subnetwork subnetwork, Map<Option, ?> options);

  /**
   * Returns the requested subnetwork or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Subnetwork getSubnetwork(String region, String subnetwork, Map<Option, ?> options);

  /**
   * Lists subnetworks for the provided region.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Subnetwork>> listSubnetworks(String region, Map<Option, ?> options);

  /**
   * Lists subnetworks.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Subnetwork>> listSubnetworks(Map<Option, ?> options);

  /**
   * Deletes the requested subnetwork. Any attempt to delete an automatically created subnetwork
   * will fail.
   *
   * @return a region operation if the delete request was issued correctly, {@code null} if the
   *     subnetwork was not found
   * @throws ComputeException upon failure
   */
  Operation deleteSubnetwork(String region, String subnetwork, Map<Option, ?> options);

  /**
   * Creates a new network.
   *
   * @return a global operation for network's creation
   * @throws ComputeException upon failure
   */
  Operation createNetwork(Network network, Map<Option, ?> options);

  /**
   * Returns the requested network or {@code null} if not found.
   *
   * @throws ComputeException upon failure
   */
  Network getNetwork(String network, Map<Option, ?> options);

  /**
   * Lists networks.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Network>> listNetworks(Map<Option, ?> options);

  /**
   * Deletes the requested network.
   *
   * @return a global operation if the delete request was issued correctly, {@code null} if the
   *     network was not found
   * @throws ComputeException upon failure
   */
  Operation deleteNetwork(String network, Map<Option, ?> options);

  /**
   * Creates a new instance.
   *
   * @return a zone operation for instance's creation
   * @throws ComputeException upon failure or if the zone does not exist
   */
  Operation createInstance(String zone, Instance instance, Map<Option, ?> options);

  /**
   * Returns the requested instance or {@code null} if not found.
   *
   * @throws ComputeException upon failure or if the zone does not exist
   */
  Instance getInstance(String zone, String instance, Map<Option, ?> options);

  /**
   * Lists instances for the provided zone.
   *
   * @throws ComputeException upon failure or if the zone does not exist
   */
  Tuple<String, Iterable<Instance>> listInstances(String zone, Map<Option, ?> options);

  /**
   * Lists instances.
   *
   * @throws ComputeException upon failure
   */
  Tuple<String, Iterable<Instance>> listInstances(Map<Option, ?> options);

  /**
   * Deletes the requested instance.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure or if the zone does not exist
   */
  Operation deleteInstance(String zone, String instance, Map<Option, ?> options);

  /**
   * Adds an access configuration to an instance's network interface.
   *
   * @return a zone operation if the add request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation addAccessConfig(String zone, String instance, String networkInterface,
      AccessConfig accessConfig, Map<Option, ?> options);

  /**
   * Attaches a disk to an instance.
   *
   * @return a zone operation if the attach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation attachDisk(String zone, String instance, AttachedDisk attachedDisk,
      Map<Option, ?> options);

  /**
   * Deletes an access configuration from an instance's network interface.
   *
   * @return a zone operation if the delete request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation deleteAccessConfig(String zone, String instance, String networkInterface,
      String accessConfig, Map<Option, ?> options);

  /**
   * Detaches a disk from an instance.
   *
   * @return a zone operation if the detach request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation detachDisk(String zone, String instance, String deviceName, Map<Option, ?> options);

  /**
   * Returns the serial port output for the provided instance and port number. {@code port} must be
   * between 1 and 4 (inclusive). If {@code port} is {@code null} output for the default port (1) is
   * returned.
   *
   * @return the serial port output or {@code null} if the instance was not found
   * @throws ComputeException upon failure
   */
  String getSerialPortOutput(String zone, String instance, Integer port, Map<Option, ?> options);

  /**
   * Resets the provided instance.
   *
   * @return a zone operation if the reset request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation reset(String zone, String instance, Map<Option, ?> options);

  /**
   * Sets the auto-delete flag for a disk attached to the provided instance.
   *
   * @return a zone operation if the flag setting request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation setDiskAutoDelete(String zone, String instance, String deviceName, boolean autoDelete,
      Map<Option, ?> options);

  /**
   * Sets the machine type for the provided instance. Instance must be in {@code TERMINATED} state
   * to be able to set its machine type.
   *
   * @param zone name of the zone in which the instance resides
   * @param instance name of the instance
   * @param machineTypeUrl full or partial URL of the machine type resource. For example
   *     {@code zones/us-central1-f/machineTypes/n1-standard-1}.
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setMachineType(String zone, String instance, String machineTypeUrl,
      Map<Option, ?> options);

  /**
   * Sets the metadata for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setMetadata(String zone, String instance, Metadata metadata, Map<Option, ?> options);

  /**
   * Sets the scheduling options for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setScheduling(String zone, String instance, Scheduling scheduling,
      Map<Option, ?> options);

  /**
   * Sets the tags for the provided instance.
   *
   * @return a zone operation if the set request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation setTags(String zone, String instance, Tags tags, Map<Option, ?> options);

  /**
   * Starts the provided instance.
   *
   * @return a zone operation if the start request was issued correctly, {@code null} if the
   *     instance was not found
   * @throws ComputeException upon failure
   */
  Operation start(String zone, String instance, Map<Option, ?> options);

  /**
   * Stops the provided instance.
   *
   * @return a zone operation if the stop request was issued correctly, {@code null} if the instance
   *     was not found
   * @throws ComputeException upon failure
   */
  Operation stop(String zone, String instance, Map<Option, ?> options);
}
