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

package com.google.cloud.examples.compute;

import com.google.cloud.compute.Address;
import com.google.cloud.compute.AddressId;
import com.google.cloud.compute.AddressInfo;
import com.google.cloud.compute.AttachedDisk;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.ComputeOptions;
import com.google.cloud.compute.Disk;
import com.google.cloud.compute.DiskConfiguration;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.DiskImageConfiguration;
import com.google.cloud.compute.DiskInfo;
import com.google.cloud.compute.DiskType;
import com.google.cloud.compute.DiskTypeId;
import com.google.cloud.compute.GlobalAddressId;
import com.google.cloud.compute.GlobalOperationId;
import com.google.cloud.compute.Image;
import com.google.cloud.compute.ImageDiskConfiguration;
import com.google.cloud.compute.ImageId;
import com.google.cloud.compute.ImageInfo;
import com.google.cloud.compute.Instance;
import com.google.cloud.compute.InstanceId;
import com.google.cloud.compute.InstanceInfo;
import com.google.cloud.compute.LicenseId;
import com.google.cloud.compute.MachineType;
import com.google.cloud.compute.MachineTypeId;
import com.google.cloud.compute.Network;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.NetworkInfo;
import com.google.cloud.compute.NetworkInterface;
import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.cloud.compute.Operation;
import com.google.cloud.compute.Region;
import com.google.cloud.compute.RegionAddressId;
import com.google.cloud.compute.RegionId;
import com.google.cloud.compute.RegionOperationId;
import com.google.cloud.compute.SchedulingOptions;
import com.google.cloud.compute.SchedulingOptions.Maintenance;
import com.google.cloud.compute.Snapshot;
import com.google.cloud.compute.SnapshotDiskConfiguration;
import com.google.cloud.compute.SnapshotId;
import com.google.cloud.compute.SnapshotInfo;
import com.google.cloud.compute.StandardDiskConfiguration;
import com.google.cloud.compute.StandardNetworkConfiguration;
import com.google.cloud.compute.SubnetNetworkConfiguration;
import com.google.cloud.compute.Subnetwork;
import com.google.cloud.compute.SubnetworkId;
import com.google.cloud.compute.SubnetworkInfo;
import com.google.cloud.compute.Zone;
import com.google.cloud.compute.ZoneId;
import com.google.cloud.compute.ZoneOperationId;
import com.google.cloud.compute.spi.ComputeRpc.Tuple;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * An example of using Google Compute.
 *
 * <p>This example demonstrates a simple/typical Compute usage.
 *
 * <p>See the
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 * <pre>{@code target/appassembler/bin/ComputeExample [<project_id>]
 * list networks |
 * list region-operations <region> |
 * list instances <zone>? |
 * list regions |
 * list zones |
 * list zone-operations <zone> |
 * list disks <zone>? |
 * list subnetworks <region>? |
 * list machineTypes <zone>? |
 * list global-operations |
 * list images |
 * list diskTypes <zone>? |
 * list snapshots |
 * list addresses <region>? |
 * create subnet-network <network> true|false |
 * create image-disk <zone> <disk> <imageProject>? <image> |
 * create subnetwork <region> <subnetwork> <network> <ipRange> |
 * create address <region>? <address> |
 * create snapshot <snapshot> <zone> <disk> |
 * create snapshot-disk <zone> <disk> <snapshot> |
 * create image <image> <zone> <disk> |
 * create standard-network <network> <ipRange> |
 * create instance <zone> <instance> <machineType> <disk> <network> |
 * create standard-disk <zone> <disk> <diskType> <diskSizeGb>? |
 * info region <region> |
 * info region-operation <region> <operation> |
 * info machineType <zone> <machineType> |
 * info snapshot <snapshot> |
 * info disk <zone> <disk> |
 * info image <image> |
 * info diskType <zone> <diskType> |
 * info network <network> |
 * info zone-operation <zone> <operation> |
 * info subnetwork <region> <subnetwork> |
 * info address <region>? <address> |
 * info instance <zone> <instance> |
 * info license <license> |
 * info global-operation <operation> |
 * info zone <zone> |
 * delete region-operation <region> <operation> |
 * delete zone-operation <zone> <operation> |
 * delete subnetwork <region> <subnetwork> |
 * delete address <region>? <address> |
 * delete snapshot <snapshot> |
 * delete disk <zone> <disk> |
 * delete image <image> |
 * delete instance <zone> <instance> |
 * delete global-operation <operation> |
 * delete network <network> |
 * get-serial-port <zone> <instance> <portNumber> |
 * set-machine-type <zone> <instance> <machineType> |
 * set-disk-auto-delete <zone> <instance> <deviceName> true|false |
 * set-scheduling-options <zone> <instance> preemptible|(standard true|false MIGRATE|TERMINATE) |
 * add-access-config <zone> <instance> <networkInterface> <accessConfig> <IPaddress>? |
 * delete-access-config <zone> <instance> <networkInterface> <accessConfig> |
 * attach-disk <zone> <instance> <deviceName> <disk> |
 * detach-disk <zone> <instance> <deviceName> |
 * start <zone> <instance> |
 * stop <zone> <instance> |
 * reset <zone> <instance> |
 * set-tags <zone> <instance> <tag>* |
 * set-metadata <zone> <instance> <key value>*}</pre>
 *
 * <p>The first parameter is an optional {@code project_id} (logged-in project will be used if not
 * supplied). Second parameter is a Compute operation and can be used to demonstrate its usage. For
 * operations that apply to more than one entity (`list`, `create`, `info` and `delete`) the third
 * parameter specifies the entity.
 */
public class ComputeExample {

  private static final Map<String, ComputeAction> CREATE_ACTIONS = new HashMap<>();
  private static final Map<String, ComputeAction> INFO_ACTIONS = new HashMap<>();
  private static final Map<String, ComputeAction> LIST_ACTIONS = new HashMap<>();
  private static final Map<String, ComputeAction> DELETE_ACTIONS = new HashMap<>();
  private static final Map<String, ComputeAction> ACTIONS = new HashMap<>();

  static class Triple<X, Y, Z> {

    private final X x;
    private final Y y;
    private final Z z;

    private Triple(X x, Y y, Z z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public static <X, Y, Z> Triple<X, Y, Z> of(X x, Y y, Z z) {
      return new Triple<>(x, y, z);
    }

    X x() {
      return x;
    }

    Y y() {
      return y;
    }

    Z z() {
      return z;
    }
  }

  private abstract static class ComputeAction<T> {

    abstract void run(Compute compute, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  private static class ParentAction extends ComputeAction<Tuple<ComputeAction, Object>> {

    private final Map<String, ComputeAction> subActions;

    ParentAction(Map<String, ComputeAction> subActions) {
      this.subActions = ImmutableMap.copyOf(subActions);
    }

    @Override
    @SuppressWarnings("unchecked")
    void run(Compute compute, Tuple<ComputeAction, Object> subaction) throws Exception {
      subaction.x().run(compute, subaction.y());
    }

    @Override
    Tuple<ComputeAction, Object> parse(String... args) throws Exception {
      if (args.length >= 1) {
        ComputeAction action = subActions.get(args[0]);
        if (action != null) {
          Object actionArguments = action.parse(Arrays.copyOfRange(args, 1, args.length));
          return Tuple.of(action, actionArguments);
        } else {
          throw new IllegalArgumentException("Unrecognized entity '" + args[0] + "'.");
        }
      }
      throw new IllegalArgumentException("Missing required entity.");
    }

    @Override
    public String params() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<String, ComputeAction> entry : subActions.entrySet()) {
        builder.append('\n').append(entry.getKey());
        String param = entry.getValue().params();
        if (param != null && !param.isEmpty()) {
          builder.append(' ').append(param);
        }
      }
      return builder.toString();
    }
  }

  private abstract static class OptionalZoneAction extends ComputeAction<ZoneId> {
    @Override
    ZoneId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return ZoneId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        return null;
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone>?";
    }
  }

  private abstract static class OptionalRegionAction extends ComputeAction<RegionId> {
    @Override
    RegionId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return RegionId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        return null;
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region>?";
    }
  }

  private abstract static class NoArgsAction extends ComputeAction<Void> {
    @Override
    Void parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      }
      throw new IllegalArgumentException("This action takes no arguments.");
    }
  }

  /**
   * This class demonstrates how to list Compute disk types.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/diskTypes/list">DiskTypes:
   *     list</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/diskTypes/aggregatedList">
   *     DiskTypes: aggregated list</a>
   */
  private static class ListDiskTypesAction extends OptionalZoneAction {
    @Override
    public void run(Compute compute, ZoneId zone) {
      Iterator<DiskType> diskTypeIterator;
      if (zone != null) {
        diskTypeIterator = compute.listDiskTypes(zone.getZone()).iterateAll();
      } else {
        diskTypeIterator = compute.listDiskTypes().iterateAll();
      }
      while (diskTypeIterator.hasNext()) {
        System.out.println(diskTypeIterator.next());
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute disk type.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/diskTypes/get">DiskTypes:
   *     get</a>
   */
  private static class DiskTypeInfoAction extends ComputeAction<DiskTypeId> {
    @Override
    public void run(Compute compute, DiskTypeId diskType) {
      System.out.printf("Disk type info: %s%n", compute.getDiskType(diskType));
    }

    @Override
    DiskTypeId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return DiskTypeId.of(args[0], args[1]);
      } else if (args.length < 2) {
        message = "Missing required zone and disk type id.";
      } else {
        message = "Too many arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone> <diskType>";
    }
  }

  /**
   * This class demonstrates how to list Compute machine types.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/machineTypes/list">
   *     MachineTypes: list</a>
   * @see <a href=
   *     "https://cloud.google.com/compute/docs/reference/latest/machineTypes/aggregatedList">
   *     MachineTypes: aggregated list</a>
   */
  private static class ListMachineTypesAction extends OptionalZoneAction {
    @Override
    public void run(Compute compute, ZoneId zone) {
      Iterator<MachineType> machineTypeIterator;
      if (zone != null) {
        machineTypeIterator = compute.listMachineTypes(zone.getZone()).iterateAll();
      } else {
        machineTypeIterator = compute.listMachineTypes().iterateAll();
      }
      while (machineTypeIterator.hasNext()) {
        System.out.println(machineTypeIterator.next());
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute machine type.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/machineTypes/get">
   *     MachineTypes: get</a>
   */
  private static class MachineTypeInfoAction extends ComputeAction<MachineTypeId> {
    @Override
    public void run(Compute compute, MachineTypeId machineType) {
      System.out.printf("Machine type info: %s%n", compute.getMachineType(machineType));
    }

    @Override
    MachineTypeId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return MachineTypeId.of(args[0], args[1]);
      } else if (args.length < 2) {
        message = "Missing required zone and machine type id.";
      } else {
        message = "Too many arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone> <machineType>";
    }
  }

  /**
   * This class demonstrates how to list Compute regions.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regions/list">Regions:
   *     list</a>
   */
  private static class ListRegionsAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Region> regionIterator = compute.listRegions().iterateAll();
      while (regionIterator.hasNext()) {
        System.out.println(regionIterator.next());
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute region.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regions/get">
   *     Regions: get</a>
   */
  private static class RegionInfoAction extends ComputeAction<RegionId> {
    @Override
    public void run(Compute compute, RegionId region) {
      System.out.printf("Region info: %s%n", compute.getRegion(region.getRegion()));
    }

    @Override
    RegionId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return RegionId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required region id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region>";
    }
  }

  /**
   * This class demonstrates how to list Compute zones.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zones/list">Zones: list
   *     </a>
   */
  private static class ListZonesAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Zone> zoneIterator = compute.listZones().iterateAll();
      while (zoneIterator.hasNext()) {
        System.out.println(zoneIterator.next());
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute zone.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zones/get">Zones: get</a>
   */
  private static class ZoneInfoAction extends ComputeAction<ZoneId> {
    @Override
    public void run(Compute compute, ZoneId zone) {
      System.out.printf("Zone info: %s%n", compute.getZone(zone.getZone()));
    }

    @Override
    ZoneId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return ZoneId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required zone id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute license.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/licenses/get">License:
   *     get</a>
   */
  private static class LicenseInfoAction extends ComputeAction<LicenseId> {
    @Override
    public void run(Compute compute, LicenseId license) {
      System.out.printf("License info: %s%n", compute.getLicense(license.getLicense()));
    }

    @Override
    LicenseId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return LicenseId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required license id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<license>";
    }
  }

  /**
   * This class demonstrates how to list Compute global operations.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalOperations/list">
   *     GLobalOperations: list</a>
   */
  private static class ListGlobalOperationsAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Operation> operationIterator = compute.listGlobalOperations().iterateAll();
      while (operationIterator.hasNext()) {
        System.out.println(operationIterator.next());
      }
    }
  }

  /**
   * This class demonstrates how to list Compute zone operations.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zoneOperations/list">
   *     ZoneOperations: list</a>
   */
  private static class ListZoneOperationsAction extends ComputeAction<ZoneId> {
    @Override
    public void run(Compute compute, ZoneId zone) {
      Iterator<Operation> operationIterator =
          compute.listZoneOperations(zone.getZone()).iterateAll();
      while (operationIterator.hasNext()) {
        System.out.println(operationIterator.next());
      }
    }

    @Override
    ZoneId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return ZoneId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required zone id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone>";
    }
  }

  /**
   * This class demonstrates how to list Compute region operations.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regionOperations/list">
   *     RegionOperations: list</a>
   */
  private static class ListRegionOperationsAction extends ComputeAction<RegionId> {
    @Override
    public void run(Compute compute, RegionId region) {
      Iterator<Operation> operationIterator =
          compute.listRegionOperations(region.getRegion()).iterateAll();
      while (operationIterator.hasNext()) {
        System.out.println(operationIterator.next());
      }
    }

    @Override
    RegionId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return RegionId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required region id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region>";
    }
  }

  private abstract static class GlobalOperationAction extends ComputeAction<GlobalOperationId> {
    @Override
    GlobalOperationId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return GlobalOperationId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required operation id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<operation>";
    }
  }

  private abstract static class ZoneOperationAction extends ComputeAction<ZoneOperationId> {
    @Override
    ZoneOperationId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return ZoneOperationId.of(args[0], (args[1]));
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required zone and operation id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone> <operation>";
    }
  }

  private abstract static class RegionOperationAction extends ComputeAction<RegionOperationId> {
    @Override
    RegionOperationId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return RegionOperationId.of(args[0], (args[1]));
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required region and operation id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region> <operation>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute global operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalOperations/get">
   *     GlobalOperations: get</a>
   */
  private static class GlobalOperationInfoAction extends GlobalOperationAction {
    @Override
    public void run(Compute compute, GlobalOperationId operation) {
      System.out.printf("Operation info: %s%n", compute.getOperation(operation));
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute zone operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zoneOperations/get">
   *     ZoneOperations: get</a>
   */
  private static class ZoneOperationInfoAction extends ZoneOperationAction {
    @Override
    public void run(Compute compute, ZoneOperationId operation) {
      System.out.printf("Operation info: %s%n", compute.getOperation(operation));
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute region operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regionOperations/get">
   *     RegionOperations: get</a>
   */
  private static class RegionOperationInfoAction extends RegionOperationAction {
    @Override
    public void run(Compute compute, RegionOperationId operation) {
      System.out.printf("Operation info: %s%n", compute.getOperation(operation));
    }
  }

  /**
   * This class demonstrates how to delete a Compute global operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalOperations/delete">
   *     GlobalOperations: delete</a>
   */
  private static class DeleteGlobalOperationAction extends GlobalOperationAction {
    @Override
    public void run(Compute compute, GlobalOperationId operation) {
      if (compute.deleteOperation(operation)) {
        System.out.printf("Operation %s was deleted%n", operation);
      } else {
        System.out.printf("Operation %s not found%n", operation);
      }
    }
  }

  /**
   * This class demonstrates how to delete a Compute zone operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/zoneOperations/delete">
   *     ZoneOperations: delete</a>
   */
  private static class DeleteZoneOperationAction extends ZoneOperationAction {
    @Override
    public void run(Compute compute, ZoneOperationId operation) {
      if (compute.deleteOperation(operation)) {
        System.out.printf("Operation %s was deleted%n", operation);
      } else {
        System.out.printf("Operation %s not found%n", operation);
      }
    }
  }

  /**
   * This class demonstrates how to delete a Compute region operation.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/regionOperations/delete">
   *     RegionOperations: delete</a>
   */
  private static class DeleteRegionOperationAction extends RegionOperationAction {
    @Override
    public void run(Compute compute, RegionOperationId operation) {
      if (compute.deleteOperation(operation)) {
        System.out.printf("Operation %s was deleted%n", operation);
      } else {
        System.out.printf("Operation %s not found%n", operation);
      }
    }
  }

  /**
   * This class demonstrates how to list Compute addresses.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses/list">
   *     Addresses: list</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses/aggregatedList">
   *     Addresses: aggerated list</a>
   */
  private static class ListAddressesAction extends OptionalRegionAction {
    @Override
    public void run(Compute compute, RegionId region) {
      Iterator<Address> addressIterator;
      if (region != null) {
        addressIterator = compute.listRegionAddresses(region.getRegion()).iterateAll();
      } else {
        addressIterator = compute.listAddresses().iterateAll();
      }
      while (addressIterator.hasNext()) {
        System.out.println(addressIterator.next());
      }
    }
  }

  private abstract static class AddressAction extends ComputeAction<AddressId> {
    @Override
    AddressId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return RegionAddressId.of(args[0], (args[1]));
      } else if (args.length == 1) {
        return GlobalAddressId.of(args[0]);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required address id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region>? <address>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute address.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses/get">
   *     Addresses: get</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalAddresses/get">
   *     Global Addresses: get</a>
   */
  private static class AddressInfoAction extends AddressAction {
    @Override
    public void run(Compute compute, AddressId address) {
      System.out.printf("Address info: %s%n", compute.getAddress(address));
    }
  }

  /**
   * This class demonstrates how to delete a Compute address.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses/delete">
   *     Addresses: delete</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalAddresses/delete">
   *     Global Addresses: delete</a>
   */
  private static class DeleteAddressAction extends AddressAction {
    @Override
    public void run(Compute compute, AddressId address) throws InterruptedException {
      Operation operation = compute.deleteAddress(address);
      if (operation == null) {
        System.out.printf("Address %s does not exist%n", address);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Address %s was deleted%n", address);
      } else {
        System.out.printf("Deletion of address %s failed%n", address);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute address.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/addresses/insert">
   *     Addresses: insert</a>
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/globalAddresses/insert">
   *     Global Addresses: insert</a>
   */
  private static class CreateAddressAction extends AddressAction {
    @Override
    public void run(Compute compute, AddressId address) throws InterruptedException {
      Operation operation = compute.create(AddressInfo.of(address));
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Address %s was created%n", address);
      } else {
        System.out.printf("Creation of address %s failed%n", address);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to list Compute snapshots.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots/list">
   *     Snapshots: list</a>
   */
  private static class ListSnapshotsAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Snapshot> snapshotIterator = compute.listSnapshots().iterateAll();
      while (snapshotIterator.hasNext()) {
        System.out.println(snapshotIterator.next());
      }
    }
  }

  private abstract static class SnapshotAction extends ComputeAction<SnapshotId> {
    @Override
    SnapshotId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return SnapshotId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required shapshot id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<snapshot>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute snapshot.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots/get">
   *     Snapshots: get</a>
   */
  private static class SnapshotInfoAction extends SnapshotAction {
    @Override
    public void run(Compute compute, SnapshotId snapshot) {
      System.out.printf("Snapshot info: %s%n", compute.getSnapshot(snapshot.getSnapshot()));
    }
  }

  /**
   * This class demonstrates how to delete a Compute snapshot.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots/delete">
   *     Snapshots: delete</a>
   */
  private static class DeleteSnapshotAction extends SnapshotAction {
    @Override
    public void run(Compute compute, SnapshotId snapshot) throws InterruptedException {
      Operation operation = compute.deleteSnapshot(snapshot.getSnapshot());
      if (operation == null) {
        System.out.printf("Snapshot %s does not exist%n", snapshot);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Snapshot %s was deleted%n", snapshot);
      } else {
        System.out.printf("Deletion of snapshot %s failed%n", snapshot);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute snapshot.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots/insert">
   *     Snapshots: insert</a>
   */
  private static class CreateSnapshotAction extends ComputeAction<SnapshotInfo> {
    @Override
    public void run(Compute compute, SnapshotInfo snapshot) throws InterruptedException {
      Operation operation = compute.create(snapshot);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Snapshot %s was created%n", snapshot.getSnapshotId());
      } else {
        System.out.printf("Creation of snapshot %s failed%n", snapshot.getSnapshotId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    SnapshotInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 3) {
        String snapshot = args[0];
        String zone = args[1];
        String disk = args[2];
        return SnapshotInfo.of(SnapshotId.of(snapshot), DiskId.of(zone, disk));
      } else if (args.length > 3) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<snapshot> <zone> <disk>";
    }
  }

  /**
   * This class demonstrates how to list Compute images.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images/list">Images: list
   *     </a>
   */
  private static class ListImagesAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Image> imageIterator = compute.listImages().iterateAll();
      while (imageIterator.hasNext()) {
        System.out.println(imageIterator.next());
      }
    }
  }

  private abstract static class ImageAction extends ComputeAction<ImageId> {
    @Override
    ImageId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return ImageId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required image id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<image>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute image.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images/get">Images: get
   *     </a>
   */
  private static class ImageInfoAction extends ImageAction {
    @Override
    public void run(Compute compute, ImageId image) {
      System.out.printf("Image info: %s%n", compute.getImage(image));
    }
  }

  /**
   * This class demonstrates how to delete a Compute image.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images/delete">Images:
   *     delete</a>
   */
  private static class DeleteImageAction extends ImageAction {
    @Override
    public void run(Compute compute, ImageId image) throws InterruptedException {
      Operation operation = compute.deleteImage(image);
      if (operation == null) {
        System.out.printf("Image %s does not exist%n", image);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Image %s was deleted%n", image);
      } else {
        System.out.printf("Deletion of image %s failed%n", image);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute image.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/images/insert">Images:
   *     insert</a>
   */
  private static class CreateImageAction extends ComputeAction<ImageInfo> {
    @Override
    public void run(Compute compute, ImageInfo image) throws InterruptedException {
      Operation operation = compute.create(image);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Image %s was created%n", image.getImageId());
      } else {
        System.out.printf("Creation of image %s failed%n", image.getImageId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    ImageInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 3) {
        String image = args[0];
        String zone = args[1];
        String disk = args[2];
        return ImageInfo.of(ImageId.of(image), DiskImageConfiguration.of(DiskId.of(zone, disk)));
      } else if (args.length > 3) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<image> <zone> <disk>";
    }
  }

  private abstract static class DiskAction extends ComputeAction<DiskId> {
    @Override
    DiskId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return DiskId.of(args[0], args[1]);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required zone and disk id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone> <disk>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute disk.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/snapshots/get">
   *     Snapshots: get</a>
   */
  private static class DiskInfoAction extends DiskAction {
    @Override
    public void run(Compute compute, DiskId disk) {
      System.out.printf("Disk info: %s%n", compute.getDisk(disk));
    }
  }

  /**
   * This class demonstrates how to delete a Compute disk.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks/delete">Disks:
   *     delete</a>
   */
  private static class DeleteDiskAction extends DiskAction {
    @Override
    public void run(Compute compute, DiskId disk) throws InterruptedException {
      Operation operation = compute.deleteDisk(disk);
      if (operation == null) {
        System.out.printf("Disk %s does not exist%n", disk);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Disk %s was deleted%n", disk);
      } else {
        System.out.printf("Deletion of disk %s failed%n", disk);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to list Compute disks.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks/list">Disks: list
   *     </a>
   */
  private static class ListDisksAction extends OptionalZoneAction {
    @Override
    public void run(Compute compute, ZoneId zone) {
      Iterator<Disk> diskIterator = compute.listDisks().iterateAll();
      while (diskIterator.hasNext()) {
        System.out.println(diskIterator.next());
      }
    }
  }

  private abstract static class CreateDiskAction extends ComputeAction<DiskInfo> {
    @Override
    public void run(Compute compute, DiskInfo disk) throws InterruptedException {
      Operation operation = compute.create(disk);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Disk %s was created%n", disk.getDiskId());
      } else {
        System.out.printf("Creation of disk %s failed%n", disk.getDiskId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    static DiskId parseDiskId(String[] args) {
      return DiskId.of(args[0], args[1]);
    }
  }

  /**
   * This class demonstrates how to create a Compute disk given its type and size.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks/insert">Disks:
   *     insert</a>
   */
  private static class CreateStandardDiskAction extends CreateDiskAction {
    @Override
    DiskInfo parse(String... args) throws Exception {
      if (args.length >= 3) {
        DiskId diskId = parseDiskId(args);
        String diskType = args[2];
        DiskConfiguration configuration;
        if (args.length == 4) {
          try {
            configuration = StandardDiskConfiguration.of(DiskTypeId.of(diskId.getZone(), diskType),
                Integer.parseInt(args[3]));
          } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Error parsing disk size parameter.");
          }
        } else if (args.length == 3) {
          configuration = StandardDiskConfiguration.of(DiskTypeId.of(diskId.getZone(), diskType));
        } else {
          throw new IllegalArgumentException("Too many arguments.");
        }
        return DiskInfo.of(diskId, configuration);
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <disk> <diskType> <diskSizeGb>?";
    }
  }

  /**
   * This class demonstrates how to create a Compute disk given a source snapshot.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks/insert">Disks:
   *     insert</a>
   */
  private static class CreateSnapshotDiskAction extends CreateDiskAction {
    @Override
    DiskInfo parse(String... args) throws Exception {
      if (args.length == 3) {
        DiskId diskId = parseDiskId(args);
        return DiskInfo.of(diskId, SnapshotDiskConfiguration.of(SnapshotId.of(args[2])));
      } else if (args.length > 3) {
        throw new IllegalArgumentException("Too many arguments.");
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <disk> <snapshot>";
    }
  }

  /**
   * This class demonstrates how to create a Compute disk given a source image.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/disks/insert">Disks:
   *     insert</a>
   */
  private static class CreateImageDiskAction extends CreateDiskAction {
    @Override
    DiskInfo parse(String... args) throws Exception {
      if (args.length == 3) {
        DiskId diskId = parseDiskId(args);
        return DiskInfo.of(diskId, ImageDiskConfiguration.of(ImageId.of(args[2])));
      } else if (args.length == 4) {
        DiskId diskId = parseDiskId(args);
        return DiskInfo.of(diskId, ImageDiskConfiguration.of(ImageId.of(args[2], args[3])));
      } else if (args.length > 4) {
        throw new IllegalArgumentException("Too many arguments.");
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <disk> <imageProject>? <image>";
    }
  }

  /**
   * This class demonstrates how to list Compute networks.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks/list">Networks:
   *     list</a>
   */
  private static class ListNetworksAction extends NoArgsAction {
    @Override
    public void run(Compute compute, Void arg) {
      Iterator<Network> networkIterator = compute.listNetworks().iterateAll();
      while (networkIterator.hasNext()) {
        System.out.println(networkIterator.next());
      }
    }
  }

  private abstract static class NetworkAction extends ComputeAction<NetworkId> {
    @Override
    NetworkId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return NetworkId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required network id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<network>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute network.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks/get">Networks:
   *     get</a>
   */
  private static class NetworkInfoAction extends NetworkAction {
    @Override
    public void run(Compute compute, NetworkId network) {
      System.out.printf("Network info: %s%n", compute.getNetwork(network.getNetwork()));
    }
  }

  /**
   * This class demonstrates how to delete a Compute network.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks/delete">Networks:
   *     delete</a>
   */
  private static class DeleteNetworkAction extends NetworkAction {
    @Override
    public void run(Compute compute, NetworkId network) throws InterruptedException {
      Operation operation = compute.deleteNetwork(network.getNetwork());
      if (operation == null) {
        System.out.printf("Network %s does not exist%n", network);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Network %s was deleted%n", network);
      } else {
        System.out.printf("Deletion of network %s failed%n", network);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  private abstract static class CreateNetworkAction extends ComputeAction<NetworkInfo> {
    @Override
    public void run(Compute compute, NetworkInfo network) throws InterruptedException {
      Operation operation = compute.create(network);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Network %s was created%n", network.getNetworkId());
      } else {
        System.out.printf("Creation of network %s failed%n", network.getNetworkId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute network with no subnetworks.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks/insert">Networks:
   *     insert</a>
   */
  private static class CreateStandardNetworkAction extends CreateNetworkAction {
    @Override
    NetworkInfo parse(String... args) throws Exception {
      if (args.length == 2) {
        return NetworkInfo.of(NetworkId.of(args[0]), StandardNetworkConfiguration.of(args[1]));
      } else if (args.length > 2) {
        throw new IllegalArgumentException("Too many arguments.");
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<network> <ipRange>";
    }
  }

  /**
   * This class demonstrates how to create a Compute network that supports the creation of
   * subnetworks (either manual or automatic).
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/networks/insert">Networks:
   *     insert</a>
   */
  private static class CreateSubnetNetworkAction extends CreateNetworkAction {
    @Override
    NetworkInfo parse(String... args) throws Exception {
      if (args.length == 2) {
        boolean autoCreateSubnetworks;
        switch (args[1]) {
          case "true":
            autoCreateSubnetworks = true;
            break;
          case "false":
            autoCreateSubnetworks = false;
            break;
          default:
            throw new IllegalArgumentException(
                "Couldn't parse autoCreateSubnetworks argument (must be either true or false).");
        }
        return NetworkInfo.of(NetworkId.of(args[0]),
            SubnetNetworkConfiguration.of(autoCreateSubnetworks));
      } else if (args.length > 2) {
        throw new IllegalArgumentException("Too many arguments.");
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<network> true|false";
    }
  }

  /**
   * This class demonstrates how to list Compute subnetworks.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks/list">
   *     Subnetworks: list</a>
   */
  private static class ListSubnetworksAction extends OptionalRegionAction {

    @Override
    public void run(Compute compute, RegionId region) {
      Iterator<Subnetwork> subnetworkIterator;
      if (region != null) {
        subnetworkIterator = compute.listSubnetworks(region.getRegion()).iterateAll();
      } else {
        subnetworkIterator = compute.listSubnetworks().iterateAll();
      }
      while (subnetworkIterator.hasNext()) {
        System.out.println(subnetworkIterator.next());
      }
    }
  }

  private abstract static class SubnetworkAction extends ComputeAction<SubnetworkId> {
    @Override
    SubnetworkId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return SubnetworkId.of(args[0], args[1]);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required region and subnetwork.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<region> <subnetwork>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute subnetwork.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks/get">
   *     Subnetworks: get</a>
   */
  private static class SubnetworkInfoAction extends SubnetworkAction {
    @Override
    public void run(Compute compute, SubnetworkId subnetwork) {
      System.out.printf("Subnetwork info: %s%n", compute.getSubnetwork(subnetwork));
    }
  }

  /**
   * This class demonstrates how to delete a Compute subnetwork.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks/delete">
   *     Subnetworks: delete</a>
   */
  private static class DeleteSubnetworkAction extends SubnetworkAction {
    @Override
    public void run(Compute compute, SubnetworkId subnetwork) throws InterruptedException {
      Operation operation = compute.deleteSubnetwork(subnetwork);
      if (operation == null) {
        System.out.printf("Subnetwork %s does not exist%n", subnetwork);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Subnetwork %s was deleted%n", subnetwork);
      } else {
        System.out.printf("Deletion of subnetwork %s failed%n", subnetwork);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute subnetwork.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/subnetworks/insert">
   *     Subnetworks: insert</a>
   */
  private static class CreateSubnetworkAction extends ComputeAction<SubnetworkInfo> {
    @Override
    public void run(Compute compute, SubnetworkInfo subnetwork) throws InterruptedException {
      Operation operation = compute.create(subnetwork);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Subnetwork %s was created%n", subnetwork.getSubnetworkId());
      } else {
        System.out.printf("Creation of subnetwork %s failed%n", subnetwork.getSubnetworkId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    SubnetworkInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 4) {
        SubnetworkId subnetwork = SubnetworkId.of(args[0], args[1]);
        return SubnetworkInfo.of(subnetwork, NetworkId.of(args[2]), args[3]);
      } else if (args.length > 4) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<region> <subnetwork> <network> <ipRange>";
    }
  }

  /**
   * This class demonstrates how to list Compute instances.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/list">Instances:
   *     list</a>
   */
  private static class ListInstancesAction extends OptionalZoneAction {
    @Override
    public void run(Compute compute, ZoneId zone) {
      Iterator<Instance> instanceIterator;
      if (zone != null) {
        instanceIterator = compute.listInstances(zone.getZone()).iterateAll();
      } else {
        instanceIterator = compute.listInstances().iterateAll();
      }
      while (instanceIterator.hasNext()) {
        System.out.println(instanceIterator.next());
      }
    }
  }

  private abstract static class InstanceAction extends ComputeAction<InstanceId> {
    @Override
    InstanceId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return InstanceId.of(args[0], args[1]);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required zone and instance.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<zone> <instance>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/get">Instances:
   *     get</a>
   */
  private static class InstanceInfoAction extends InstanceAction {
    @Override
    public void run(Compute compute, InstanceId instance) {
      System.out.printf("Instance info: %s%n", compute.getInstance(instance));
    }
  }

  /**
   * This class demonstrates how to delete a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/delete">
   *     Instances: delete</a>
   */
  private static class DeleteInstanceAction extends InstanceAction {
    @Override
    public void run(Compute compute, InstanceId instance) throws InterruptedException {
      Operation operation = compute.deleteInstance(instance);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Instance %s was deleted%n", instance);
      } else {
        System.out.printf("Deletion of instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to create a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/insert">
   *     Instances: insert</a>
   */
  private static class CreateInstanceAction extends ComputeAction<InstanceInfo> {
    @Override
    public void run(Compute compute, InstanceInfo instance) throws InterruptedException {
      Operation operation = compute.create(instance);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Instance %s was created%n", instance.getInstanceId());
      } else {
        System.out.printf("Creation of instance %s failed%n", instance.getInstanceId());
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    InstanceInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 5) {
        String zone = args[0];
        String instance = args[1];
        InstanceId instanceId = InstanceId.of(zone, instance);
        MachineTypeId machineTypeId = MachineTypeId.of(zone, args[2]);
        DiskId diskId = DiskId.of(zone, args[3]);
        AttachedDisk disk =
            AttachedDisk.of(PersistentDiskConfiguration.newBuilder(diskId).setBoot(true).build());
        NetworkInterface networkInterface = NetworkInterface.of(args[4]);
        return InstanceInfo.of(instanceId, machineTypeId, disk, networkInterface);
      } else if (args.length > 5) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <machineType> <disk> <network>";
    }
  }

  /**
   * This class demonstrates how to get the serial port output for a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/getSerialPortOutput">
   *     Instances: getSerialPortOutput</a>
   */
  private static class GetSerialPortAction extends ComputeAction<Tuple<InstanceId, Integer>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, Integer> instanceAndPort)
        throws InterruptedException {
      InstanceId instance = instanceAndPort.x();
      Integer port = instanceAndPort.y();
      String serialPortOutput;
      if (port != null) {
        System.out.printf("Getting serial port %d output for instance %s%n", port, instance);
        serialPortOutput = compute.getSerialPortOutput(instance, port);
      } else {
        System.out.printf("Getting serial port output for instance %s%n", instance);
        serialPortOutput = compute.getSerialPortOutput(instance);
      }
      System.out.println(serialPortOutput);
    }

    @Override
    Tuple<InstanceId, Integer> parse(String... args) throws Exception {
      if (args.length >= 2) {
        InstanceId instanceId = InstanceId.of(args[0], args[1]);
        Integer port = null;
        if (args.length == 3) {
          try {
            port = Integer.parseInt(args[2]);
          } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(
                "Error parsing portNumber parameter (must be a number)");
          }
        } else if (args.length > 3) {
          throw new IllegalArgumentException("Too many arguments.");
        }
        return Tuple.of(instanceId, port);
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <instance> <portNumber>";
    }
  }

  /**
   * This class demonstrates how to add an access configuration to a Compute instance network
   * interface.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/addAccessConfig">
   *     Instances: addAccessConfig</a>
   */
  private static class AddAccessConfigAction
      extends ComputeAction<Triple<InstanceId, String, AccessConfig>> {
    @Override
    public void run(Compute compute, Triple<InstanceId, String, AccessConfig> interfaceAndConfig)
        throws InterruptedException {
      InstanceId instance = interfaceAndConfig.x();
      String networkInterface = interfaceAndConfig.y();
      AccessConfig accessConfig = interfaceAndConfig.z();
      Operation operation = compute.addAccessConfig(instance, networkInterface, accessConfig);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Access config added to network interface %s of instance %s%n",
            networkInterface, instance);
      } else {
        System.out.printf("Attempt to add access config to network interface %s of instance %s%n",
            networkInterface, instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Triple<InstanceId, String, AccessConfig> parse(String... args) throws Exception {
      String message;
      if (args.length >= 4) {
        InstanceId instance = InstanceId.of(args[0], args[1]);
        String networkInterface = args[2];
        String accessConfig = args[3];
        if (args.length == 4) {
          return Triple.of(instance, networkInterface,
              AccessConfig.newBuilder().setName(accessConfig).build());
        } else if (args.length == 5) {
          return Triple.of(instance, networkInterface,
              AccessConfig.newBuilder().setName(accessConfig).setNatIp(args[4]).build());
        } else {
          message = "Too many arguments.";
        }
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <networkInterface> <accessConfig> <IPaddress>?";
    }
  }

  /**
   * This class demonstrates how to delete an access configuration from a Compute instance network
   * interface.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/deleteAccessConfig">
   *     Instances: deleteAccessConfig</a>
   */
  private static class DeleteAccessConfigAction extends
      ComputeAction<Triple<InstanceId, String, String>> {
    @Override
    public void run(Compute compute, Triple<InstanceId, String, String> interfaceAndConfig)
        throws InterruptedException {
      InstanceId instance = interfaceAndConfig.x();
      String networkInterface = interfaceAndConfig.y();
      String accessConfig = interfaceAndConfig.z();
      Operation operation = compute.deleteAccessConfig(instance, networkInterface, accessConfig);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Access config deleted from network interface %s of instance %s%n",
            networkInterface, instance);
      } else {
        System.out.printf(
            "Attempt to delete access config from network interface %s of instance %s failed%n",
            networkInterface, instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Triple<InstanceId, String, String> parse(String... args) throws Exception {
      String message;
      if (args.length == 4) {
        InstanceId instance = InstanceId.of(args[0], args[1]);
        String networkInterface = args[2];
        String accessConfig = args[3];
        return Triple.of(instance, networkInterface, accessConfig);
      } else if (args.length > 4) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <networkInterface> <accessConfig>";
    }
  }

  /**
   * This class demonstrates how to attach a persistent disk to a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/attachDisk">
   *     Instances: attachDisk</a>
   */
  private static class AttachDiskAction
      extends ComputeAction<Triple<InstanceId, String, PersistentDiskConfiguration>> {
    @Override
    public void run(Compute compute, Triple<InstanceId, String, PersistentDiskConfiguration>
        instanceAndDisk) throws InterruptedException {
      InstanceId instance = instanceAndDisk.x();
      String deviceName = instanceAndDisk.y();
      PersistentDiskConfiguration diskConfiguration = instanceAndDisk.z();
      Operation operation = compute.attachDisk(instance, deviceName, diskConfiguration);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Disk attached to instance %s%n", instance);
      } else {
        System.out.printf("Attempt to attach disk to instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Triple<InstanceId, String, PersistentDiskConfiguration> parse(String... args) throws Exception {
      String message;
      if (args.length == 4) {
        String zone = args[0];
        String instance = args[1];
        String deviceName = args[2];
        String disk = args[3];
        return Triple.of(InstanceId.of(zone, instance), deviceName,
            PersistentDiskConfiguration.of(DiskId.of(zone, disk)));
      } else if (args.length > 4) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <deviceName> <disk>";
    }
  }

  /**
   * This class demonstrates how to detach a persistent disk from a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/detachDisk">
   *     Instances: detachDisk</a>
   */
  private static class DetachDiskAction extends ComputeAction<Tuple<InstanceId, String>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, String> instanceAndDevice)
        throws InterruptedException {
      InstanceId instance = instanceAndDevice.x();
      String deviceName = instanceAndDevice.y();
      Operation operation = compute.detachDisk(instance, deviceName);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Disk detached from instance %s%n", instance);
      } else {
        System.out.printf("Attempt to detach disk from instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Tuple<InstanceId, String> parse(String... args) throws Exception {
      String message;
      if (args.length == 3) {
        String zone = args[0];
        String instance = args[1];
        String deviceName = args[2];
        return Tuple.of(InstanceId.of(zone, instance), deviceName);
      } else if (args.length > 4) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <deviceName>";
    }
  }

  /**
   * This class demonstrates how to set the auto-delete property of a disk attached to a Compute
   * instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/setDiskAutoDelete">
   *     Instances: setDiskAutoDelete</a>
   */
  private static class SetDiskAutoDeleteAction
      extends ComputeAction<Triple<InstanceId, String, Boolean>> {
    @Override
    public void run(Compute compute, Triple<InstanceId, String, Boolean> deviceAndAutoDelete)
        throws InterruptedException {
      InstanceId instance = deviceAndAutoDelete.x();
      String deviceName = deviceAndAutoDelete.y();
      Boolean autoDelete = deviceAndAutoDelete.z();
      Operation operation = compute.setDiskAutoDelete(instance, deviceName, autoDelete);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Auto-delete set for device %s of instance %s%n", deviceName, instance);
      } else {
        System.out.printf("Attempt to set auto-delete for device %s of instance %s failed%n",
            deviceName, instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Triple<InstanceId, String, Boolean> parse(String... args) throws Exception {
      String message;
      if (args.length == 4) {
        InstanceId instance = InstanceId.of(args[0], args[1]);
        String deviceName = args[2];
        boolean autoDelete;
        switch (args[3]) {
          case "true":
            autoDelete = true;
            break;
          case "false":
            autoDelete = false;
            break;
          default:
            throw new IllegalArgumentException(
                "Couldn't parse autoDelete argument (must be either true or false).");
        }
        return Triple.of(instance, deviceName, autoDelete);
      } else if (args.length > 3) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <deviceName> true|false";
    }
  }

  /**
   * This class demonstrates how to set the machine type for a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/setMachineType">
   *     Instances: setMachineType</a>
   */
  private static class SetMachineTypeAction
      extends ComputeAction<Tuple<InstanceId, MachineTypeId>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, MachineTypeId> instanceAndType)
        throws InterruptedException {
      InstanceId instance = instanceAndType.x();
      MachineTypeId machineType = instanceAndType.y();
      Operation operation = compute.setMachineType(instance, machineType);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Machine type set for instance %s%n", instance);
      } else {
        System.out.printf("Attempt to set machine type for instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Tuple<InstanceId, MachineTypeId> parse(String... args) throws Exception {
      String message;
      if (args.length == 3) {
        String zone = args[0];
        String instance = args[1];
        String machineType = args[2];
        return Tuple.of(InstanceId.of(zone, instance), MachineTypeId.of(zone, machineType));
      } else if (args.length > 3) {
        message = "Too many arguments.";
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> <machineType>";
    }
  }

  /**
   * This class demonstrates how to set the tags for a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/setTags">
   *     Instances: setTags</a>
   */
  private static class SetTagsAction extends ComputeAction<Tuple<InstanceId, List<String>>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, List<String>> instanceAndTags)
        throws InterruptedException {
      InstanceId instanceId = instanceAndTags.x();
      List<String> tags = instanceAndTags.y();
      Instance instance = compute.getInstance(instanceId);
      if (instance == null) {
        System.out.printf("Instance %s does not exist%n", instanceId);
        return;
      }
      Operation operation = instance.setTags(tags);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Tags set for instance %s%n", instanceId);
      } else {
        System.out.printf("Attempt to set tags for instance %s failed%n", instanceId);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Tuple<InstanceId, List<String>> parse(String... args) throws Exception {
      if (args.length >= 2) {
        InstanceId instanceId = InstanceId.of(args[0], args[1]);
        List<String> tags = Lists.newArrayListWithCapacity(args.length - 2);
        tags.addAll(Arrays.asList(args).subList(2, args.length));
        return Tuple.of(instanceId, tags);
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <instance> <tag>*";
    }
  }

  /**
   * This class demonstrates how to set the metadata for a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/setMetadata">
   *     Instances: setMetadata</a>
   */
  private static class SetMetadataAction extends ComputeAction<Tuple<InstanceId,
      Map<String, String>>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, Map<String, String>> instanceAndMetadata)
        throws InterruptedException {
      InstanceId instanceId = instanceAndMetadata.x();
      Map<String, String> metadata = instanceAndMetadata.y();
      Instance instance = compute.getInstance(instanceId);
      if (instance == null) {
        System.out.printf("Instance %s does not exist%n", instanceId);
        return;
      }
      Operation operation = instance.setMetadata(metadata);
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Metadata set for instance %s%n", instanceId);
      } else {
        System.out.printf("Attempt to set metadata for instance %s failed%n", instanceId);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Tuple<InstanceId, Map<String, String>> parse(String... args) throws Exception {
      if (args.length >= 2) {
        if ((args.length & 0x1) == 0x1) {
          throw new IllegalArgumentException("Metadata must be a list of key-value pairs.");
        }
        InstanceId instanceId = InstanceId.of(args[0], args[1]);
        Map<String, String> metadata = Maps.newHashMapWithExpectedSize((args.length / 2) - 1);
        for (int i = 2; i < args.length; i += 2) {
          metadata.put(args[i], args[i + 1]);
        }
        return Tuple.of(instanceId, metadata);
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    protected String params() {
      return "<zone> <instance> (<key> <value>)*";
    }
  }

  /**
   * This class demonstrates how to set the scheduling options for a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/setScheduling">
   *     Instances: setScheduling</a>
   */
  private static class SetSchedulingOptionsAction extends ComputeAction<Tuple<InstanceId,
      SchedulingOptions>> {
    @Override
    public void run(Compute compute, Tuple<InstanceId, SchedulingOptions> instanceAndScheduling)
        throws InterruptedException {
      InstanceId instanceId = instanceAndScheduling.x();
      SchedulingOptions schedulingOptions = instanceAndScheduling.y();
      Operation operation = compute.setSchedulingOptions(instanceId, schedulingOptions);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instanceId);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Scheduling options set for instance %s%n", instanceId);
      } else {
        System.out.printf(
            "Attempt to set scheduling options for instance %s failed%n", instanceId);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }

    @Override
    Tuple<InstanceId, SchedulingOptions> parse(String... args) throws Exception {
      String message;
      if (args.length > 2) {
        InstanceId instanceId = InstanceId.of(args[0], args[1]);
        if (args.length == 3 && args[2].equals("preemptible")) {
          return Tuple.of(instanceId, SchedulingOptions.preemptible());
        } else if (args.length == 5 && args[2].equals("standard")) {
          boolean automaticRestart;
          switch (args[3]) {
            case "true":
              automaticRestart = true;
              break;
            case "false":
              automaticRestart = false;
              break;
            default:
              throw new IllegalArgumentException(
                  "Couldn't parse automaticRestart argument (must be either true or false).");
          }
          Maintenance maintenance = Maintenance.valueOf(args[4]);
          return Tuple.of(instanceId, SchedulingOptions.standard(automaticRestart, maintenance));
        } else {
          message = "Unexpected command line arguments.";
        }
      } else {
        message = "Missing required arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<zone> <instance> preemptible|(standard true|false MIGRATE|TERMINATE)";
    }
  }

  /**
   * This class demonstrates how to reset a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/reset">
   *     Instances: reset</a>
   */
  private static class ResetInstanceAction extends InstanceAction {
    @Override
    public void run(Compute compute, InstanceId instance) throws InterruptedException {
      Operation operation = compute.reset(instance);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Instance %s was reset%n", instance);
      } else {
        System.out.printf("Attempt to reset instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to stop a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/stop">
   *     Instances: stop</a>
   */
  private static class StopInstanceAction extends InstanceAction {
    @Override
    public void run(Compute compute, InstanceId instance) throws InterruptedException {
      Operation operation = compute.stop(instance);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Instance %s was stopped%n", instance);
      } else {
        System.out.printf("Attempt to stop instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  /**
   * This class demonstrates how to start a Compute instance.
   *
   * @see <a href="https://cloud.google.com/compute/docs/reference/latest/instances/start">
   *     Instances: start</a>
   */
  private static class StartInstanceAction extends InstanceAction {
    @Override
    public void run(Compute compute, InstanceId instance) throws InterruptedException {
      Operation operation = compute.start(instance);
      if (operation == null) {
        System.out.printf("Instance %s does not exist%n", instance);
        return;
      }
      while (!operation.isDone()) {
        System.out.printf(
            "Waiting for operation %s to complete%n", operation.getOperationId().getOperation());
        Thread.sleep(1000L);
      }
      operation = operation.reload();
      if (operation.getErrors() == null) {
        System.out.printf("Instance %s was started%n", instance);
      } else {
        System.out.printf("Attempt to start instance %s failed%n", instance);
        System.out.printf("Error: %s%n", operation.getErrors());
      }
    }
  }

  static {
    CREATE_ACTIONS.put("address", new CreateAddressAction());
    CREATE_ACTIONS.put("snapshot", new CreateSnapshotAction());
    CREATE_ACTIONS.put("image", new CreateImageAction());
    CREATE_ACTIONS.put("standard-disk", new CreateStandardDiskAction());
    CREATE_ACTIONS.put("snapshot-disk", new CreateSnapshotDiskAction());
    CREATE_ACTIONS.put("image-disk", new CreateImageDiskAction());
    CREATE_ACTIONS.put("standard-network", new CreateStandardNetworkAction());
    CREATE_ACTIONS.put("subnet-network", new CreateSubnetNetworkAction());
    CREATE_ACTIONS.put("subnetwork", new CreateSubnetworkAction());
    CREATE_ACTIONS.put("instance", new CreateInstanceAction());
    INFO_ACTIONS.put("diskType", new DiskTypeInfoAction());
    INFO_ACTIONS.put("machineType", new MachineTypeInfoAction());
    INFO_ACTIONS.put("region", new RegionInfoAction());
    INFO_ACTIONS.put("zone", new ZoneInfoAction());
    INFO_ACTIONS.put("global-operation", new GlobalOperationInfoAction());
    INFO_ACTIONS.put("zone-operation", new ZoneOperationInfoAction());
    INFO_ACTIONS.put("region-operation", new RegionOperationInfoAction());
    INFO_ACTIONS.put("license", new LicenseInfoAction());
    INFO_ACTIONS.put("address", new AddressInfoAction());
    INFO_ACTIONS.put("snapshot", new SnapshotInfoAction());
    INFO_ACTIONS.put("image", new ImageInfoAction());
    INFO_ACTIONS.put("disk", new DiskInfoAction());
    INFO_ACTIONS.put("network", new NetworkInfoAction());
    INFO_ACTIONS.put("subnetwork", new SubnetworkInfoAction());
    INFO_ACTIONS.put("instance", new InstanceInfoAction());
    LIST_ACTIONS.put("diskTypes", new ListDiskTypesAction());
    LIST_ACTIONS.put("machineTypes", new ListMachineTypesAction());
    LIST_ACTIONS.put("regions", new ListRegionsAction());
    LIST_ACTIONS.put("zones", new ListZonesAction());
    LIST_ACTIONS.put("global-operations", new ListGlobalOperationsAction());
    LIST_ACTIONS.put("zone-operations", new ListZoneOperationsAction());
    LIST_ACTIONS.put("region-operations", new ListRegionOperationsAction());
    LIST_ACTIONS.put("addresses", new ListAddressesAction());
    LIST_ACTIONS.put("snapshots", new ListSnapshotsAction());
    LIST_ACTIONS.put("images", new ListImagesAction());
    LIST_ACTIONS.put("disks", new ListDisksAction());
    LIST_ACTIONS.put("networks", new ListNetworksAction());
    LIST_ACTIONS.put("subnetworks", new ListSubnetworksAction());
    LIST_ACTIONS.put("instances", new ListInstancesAction());
    DELETE_ACTIONS.put("global-operation", new DeleteGlobalOperationAction());
    DELETE_ACTIONS.put("zone-operation", new DeleteZoneOperationAction());
    DELETE_ACTIONS.put("region-operation", new DeleteRegionOperationAction());
    DELETE_ACTIONS.put("address", new DeleteAddressAction());
    DELETE_ACTIONS.put("snapshot", new DeleteSnapshotAction());
    DELETE_ACTIONS.put("image", new DeleteImageAction());
    DELETE_ACTIONS.put("disk", new DeleteDiskAction());
    DELETE_ACTIONS.put("network", new DeleteNetworkAction());
    DELETE_ACTIONS.put("subnetwork", new DeleteSubnetworkAction());
    DELETE_ACTIONS.put("instance", new DeleteInstanceAction());
    ACTIONS.put("create", new ParentAction(CREATE_ACTIONS));
    ACTIONS.put("info", new ParentAction(INFO_ACTIONS));
    ACTIONS.put("list", new ParentAction(LIST_ACTIONS));
    ACTIONS.put("delete", new ParentAction(DELETE_ACTIONS));
    ACTIONS.put("get-serial-port", new GetSerialPortAction());
    ACTIONS.put("add-access-config", new AddAccessConfigAction());
    ACTIONS.put("delete-access-config", new DeleteAccessConfigAction());
    ACTIONS.put("attach-disk", new AttachDiskAction());
    ACTIONS.put("detach-disk", new DetachDiskAction());
    ACTIONS.put("set-disk-auto-delete", new SetDiskAutoDeleteAction());
    ACTIONS.put("set-machine-type", new SetMachineTypeAction());
    ACTIONS.put("set-tags", new SetTagsAction());
    ACTIONS.put("set-metadata", new SetMetadataAction());
    ACTIONS.put("set-scheduling-options", new SetSchedulingOptionsAction());
    ACTIONS.put("reset", new ResetInstanceAction());
    ACTIONS.put("stop", new StopInstanceAction());
    ACTIONS.put("start", new StartInstanceAction());
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, ComputeAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param.replace("\n", "\n\t\t"));
      }
    }
    System.out.printf("Usage: %s [<project_id>] operation [entity] <args>*%s%n",
        ComputeExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    ComputeOptions.Builder optionsBuilder = ComputeOptions.builder();
    ComputeAction action;
    String actionName;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      actionName = args[1];
      optionsBuilder.projectId(args[0]);
      action = ACTIONS.get(args[1]);
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      action = ACTIONS.get(args[0]);
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    if (action == null) {
      System.out.println("Unrecognized action.");
      printUsage();
      return;
    }
    Compute compute = optionsBuilder.build().service();
    Object arg;
    try {
      arg = action.parse(args);
    } catch (IllegalArgumentException ex) {
      System.out.printf("Invalid input for action '%s'. %s%n", actionName, ex.getMessage());
      System.out.printf("Expected: %s%n", action.params());
      return;
    } catch (Exception ex) {
      System.out.println("Failed to parse arguments.");
      ex.printStackTrace();
      return;
    }
    action.run(compute, arg);
  }
}
