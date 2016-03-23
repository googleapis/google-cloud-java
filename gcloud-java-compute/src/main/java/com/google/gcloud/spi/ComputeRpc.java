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

package com.google.gcloud.spi;

import com.google.api.services.compute.model.Address;
import com.google.api.services.compute.model.DiskType;
import com.google.api.services.compute.model.License;
import com.google.api.services.compute.model.MachineType;
import com.google.api.services.compute.model.Operation;
import com.google.api.services.compute.model.Region;
import com.google.api.services.compute.model.Snapshot;
import com.google.api.services.compute.model.Zone;
import com.google.gcloud.compute.ComputeException;

import java.util.Map;

public interface ComputeRpc {

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
   * Lists all disk types.
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
   * Lists all machine types.
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
   * @return a zone operation if the create request was issued correctly, {@code null} if the disk
   *     was not found
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
   * Lists all snapshots.
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
}
