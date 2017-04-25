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

package com.google.cloud.compute;

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.cloud.compute.spi.ComputeRpcFactory;
import com.google.cloud.compute.spi.v1.ComputeRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ComputeImplTest {

  private static final String PROJECT = "project";
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final String VALID_DISK_SIZE = "10GB-10TB";
  private static final Long DEFAULT_DISK_SIZE_GB = 10L;
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final DiskType DISK_TYPE = DiskType.newBuilder()
      .setGeneratedId(GENERATED_ID)
      .setDiskTypeId(DISK_TYPE_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setValidDiskSize(VALID_DISK_SIZE)
      .setDefaultDiskSizeGb(DEFAULT_DISK_SIZE_GB)
      .build();
  private static final MachineTypeId MACHINE_TYPE_ID = MachineTypeId.of("project", "zone", "type");
  private static final Integer GUEST_CPUS = 1;
  private static final Integer MEMORY_MB = 2;
  private static final List<Integer> SCRATCH_DISKS = ImmutableList.of(3);
  private static final Integer MAXIMUM_PERSISTENT_DISKS = 4;
  private static final Long MAXIMUM_PERSISTENT_DISKS_SIZE_GB = 5L;
  private static final MachineType MACHINE_TYPE = MachineType.newBuilder()
      .setGeneratedId(GENERATED_ID)
      .setMachineTypeId(MACHINE_TYPE_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setCpus(GUEST_CPUS)
      .setMemoryMb(MEMORY_MB)
      .setScratchDisksSizeGb(SCRATCH_DISKS)
      .setMaximumPersistentDisks(MAXIMUM_PERSISTENT_DISKS)
      .setMaximumPersistentDisksSizeGb(MAXIMUM_PERSISTENT_DISKS_SIZE_GB)
      .build();
  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final Region.Status REGION_STATUS = Region.Status.DOWN;
  private static final ZoneId ZONE_ID1 = ZoneId.of("project", "zone1");
  private static final ZoneId ZONE_ID2 = ZoneId.of("project", "zone2");
  private static final List<ZoneId> ZONES = ImmutableList.of(ZONE_ID1, ZONE_ID2);
  private static final Region.Quota QUOTA1 =
      new Region.Quota("METRIC1", 2, 1);
  private static final Region.Quota QUOTA2 =
      new Region.Quota("METRIC2", 4, 3);
  private static final List<Region.Quota> QUOTAS = ImmutableList.of(QUOTA1, QUOTA2);
  private static final Region REGION = Region.builder()
      .setRegionId(REGION_ID)
      .setGeneratedId(GENERATED_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setStatus(REGION_STATUS)
      .setZones(ZONES)
      .setQuotas(QUOTAS)
      .build();
  private static final ZoneId ZONE_ID = ZoneId.of("project", "zone");
  private static final Zone.Status ZONE_STATUS = Zone.Status.DOWN;
  private static final Zone ZONE = Zone.builder()
      .setZoneId(ZONE_ID)
      .setGeneratedId(GENERATED_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setDescription(DESCRIPTION)
      .setStatus(ZONE_STATUS)
      .setRegion(REGION_ID)
      .build();
  private static final LicenseId LICENSE_ID = LicenseId.of("project", "license");
  private static final Boolean CHARGES_USE_FEE = true;
  private static final License LICENSE = new License(LICENSE_ID, CHARGES_USE_FEE);
  private static final Operation.OperationError OPERATION_ERROR1 =
      new Operation.OperationError("code1", "location1", "message1");
  private static final Operation.OperationError OPERATION_ERROR2 =
      new Operation.OperationError("code2", "location2", "message2");
  private static final Operation.OperationWarning OPERATION_WARNING1 =
      new Operation.OperationWarning("code1", "message1", ImmutableMap.of("k1", "v1"));
  private static final Operation.OperationWarning OPERATION_WARNING2 =
      new Operation.OperationWarning("code2", "location2", ImmutableMap.of("k2", "v2"));
  private static final String CLIENT_OPERATION_ID = "clientOperationId";
  private static final String OPERATION_TYPE = "delete";
  private static final String TARGET_LINK = "targetLink";
  private static final String TARGET_ID = "42";
  private static final Operation.Status STATUS = Operation.Status.DONE;
  private static final String STATUS_MESSAGE = "statusMessage";
  private static final String USER = "user";
  private static final Integer PROGRESS = 100;
  private static final Long INSERT_TIME = 1453293540000L;
  private static final Long START_TIME = 1453293420000L;
  private static final Long END_TIME = 1453293480000L;
  private static final List<Operation.OperationError> ERRORS =
      ImmutableList.of(OPERATION_ERROR1, OPERATION_ERROR2);
  private static final List<Operation.OperationWarning> WARNINGS =
      ImmutableList.of(OPERATION_WARNING1, OPERATION_WARNING2);
  private static final Integer HTTP_ERROR_STATUS_CODE = 404;
  private static final String HTTP_ERROR_MESSAGE = "NOT FOUND";
  private static final GlobalOperationId GLOBAL_OPERATION_ID =
      GlobalOperationId.of("project", "op");
  private static final ZoneOperationId ZONE_OPERATION_ID =
      ZoneOperationId.of("project", "zone", "op");
  private static final RegionOperationId REGION_OPERATION_ID =
      RegionOperationId.of("project", "region", "op");
  private static final RegionAddressId REGION_ADDRESS_ID =
      RegionAddressId.of("project", "region", "address");
  private static final GlobalAddressId GLOBAL_ADDRESS_ID =
      GlobalAddressId.of("project", "address");
  private static final AddressInfo REGION_ADDRESS =
      AddressInfo.newBuilder(REGION_ADDRESS_ID).build();
  private static final AddressInfo GLOBAL_ADDRESS =
      AddressInfo.newBuilder(GLOBAL_ADDRESS_ID).build();
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final SnapshotId SNAPSHOT_ID = SnapshotId.of("project", "snapshot");
  private static final SnapshotInfo SNAPSHOT = SnapshotInfo.of(SNAPSHOT_ID, DISK_ID);
  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final ImageInfo IMAGE = ImageInfo.of(IMAGE_ID, DiskImageConfiguration.of(DISK_ID));
  private static final DeprecationStatus<ImageId> DEPRECATION_STATUS =
      DeprecationStatus.newBuilder(DeprecationStatus.Status.DEPRECATED, IMAGE_ID).build();
  private static final DiskInfo DISK =
      DiskInfo.of(DISK_ID, StandardDiskConfiguration.of(DISK_TYPE_ID));
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final SubnetworkId SUBNETWORK_ID = SubnetworkId.of("project", "region", "network");
  private static final SubnetworkInfo SUBNETWORK =
      SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, "192.168.0.0/16");
  private static final NetworkInfo NETWORK =
      NetworkInfo.of(NETWORK_ID, StandardNetworkConfiguration.of("192.168.0.0/16"));
  private static final InstanceId INSTANCE_ID = InstanceId.of("project", "zone", "instance");
  private static final AttachedDisk.PersistentDiskConfiguration PERSISTENT_DISK_CONFIGURATION =
      AttachedDisk.PersistentDiskConfiguration.of(DISK_ID);
  private static final AttachedDisk ATTACHED_DISK =
      AttachedDisk.of("device", PERSISTENT_DISK_CONFIGURATION);
  private static final NetworkInterface NETWORK_INTERFACE = NetworkInterface.of(NETWORK_ID);
  private static final InstanceInfo INSTANCE =
      InstanceInfo.of(INSTANCE_ID, MACHINE_TYPE_ID, ATTACHED_DISK, NETWORK_INTERFACE);

  // Empty ComputeRpc options
  private static final Map<ComputeRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // DiskType options
  private static final Compute.DiskTypeOption DISK_TYPE_OPTION_FIELDS =
      Compute.DiskTypeOption.fields(Compute.DiskTypeField.ID, Compute.DiskTypeField.DESCRIPTION);

  // DiskType list options
  private static final Compute.DiskTypeFilter DISK_TYPE_FILTER =
      Compute.DiskTypeFilter.equals(Compute.DiskTypeField.DESCRIPTION, "someDescription");
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_PAGE_TOKEN =
      Compute.DiskTypeListOption.pageToken("cursor");
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_PAGE_SIZE =
      Compute.DiskTypeListOption.pageSize(42L);
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_FILTER =
      Compute.DiskTypeListOption.filter(DISK_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> DISK_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "description eq someDescription");

  // DiskType aggregated list options
  private static final Compute.DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.DiskTypeAggregatedListOption.pageToken("cursor");
  private static final Compute.DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_PAGE_SIZE =
      Compute.DiskTypeAggregatedListOption.pageSize(42L);
  private static final Compute.DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_FILTER =
      Compute.DiskTypeAggregatedListOption.filter(DISK_TYPE_FILTER);

  // MachineType options
  private static final Compute.MachineTypeOption MACHINE_TYPE_OPTION_FIELDS =
      Compute.MachineTypeOption.fields(Compute.MachineTypeField.ID,
          Compute.MachineTypeField.DESCRIPTION);

  // MachineType list options
  private static final Compute.MachineTypeFilter MACHINE_TYPE_FILTER =
      Compute.MachineTypeFilter.notEquals(Compute.MachineTypeField.MAXIMUM_PERSISTENT_DISKS, 42L);
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_PAGE_TOKEN =
      Compute.MachineTypeListOption.pageToken("cursor");
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_PAGE_SIZE =
      Compute.MachineTypeListOption.pageSize(42L);
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_FILTER =
      Compute.MachineTypeListOption.filter(MACHINE_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> MACHINE_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "maximumPersistentDisks ne 42");

  // MachineType aggregated list options
  private static final Compute.MachineTypeAggregatedListOption
      MACHINE_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.MachineTypeAggregatedListOption.pageToken("cursor");
  private static final Compute.MachineTypeAggregatedListOption
      MACHINE_TYPE_AGGREGATED_LIST_PAGE_SIZE =
      Compute.MachineTypeAggregatedListOption.pageSize(42L);
  private static final Compute.MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_FILTER =
      Compute.MachineTypeAggregatedListOption.filter(MACHINE_TYPE_FILTER);

  // Region options
  private static final Compute.RegionOption REGION_OPTION_FIELDS =
      Compute.RegionOption.fields(Compute.RegionField.ID, Compute.RegionField.DESCRIPTION);

  // Region list options
  private static final Compute.RegionFilter REGION_FILTER =
      Compute.RegionFilter.equals(Compute.RegionField.ID, "someId");
  private static final Compute.RegionListOption REGION_LIST_PAGE_TOKEN =
      Compute.RegionListOption.pageToken("cursor");
  private static final Compute.RegionListOption REGION_LIST_PAGE_SIZE =
      Compute.RegionListOption.pageSize(42L);
  private static final Compute.RegionListOption REGION_LIST_FILTER =
      Compute.RegionListOption.filter(REGION_FILTER);
  private static final Map<ComputeRpc.Option, ?> REGION_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "id eq someId");

  // Zone options
  private static final Compute.ZoneOption ZONE_OPTION_FIELDS =
      Compute.ZoneOption.fields(Compute.ZoneField.ID, Compute.ZoneField.DESCRIPTION);

  // Zone list options
  private static final Compute.ZoneFilter ZONE_FILTER =
      Compute.ZoneFilter.notEquals(Compute.ZoneField.NAME, "someName");
  private static final Compute.ZoneListOption ZONE_LIST_PAGE_TOKEN =
      Compute.ZoneListOption.pageToken("cursor");
  private static final Compute.ZoneListOption ZONE_LIST_PAGE_SIZE =
      Compute.ZoneListOption.pageSize(42L);
  private static final Compute.ZoneListOption ZONE_LIST_FILTER =
      Compute.ZoneListOption.filter(ZONE_FILTER);
  private static final Map<ComputeRpc.Option, ?> ZONE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "name ne someName");

  // License options
  private static final Compute.LicenseOption LICENSE_OPTION_FIELDS =
      Compute.LicenseOption.fields(Compute.LicenseField.CHARGES_USE_FEE);

  // Operation options
  private static final Compute.OperationOption OPERATION_OPTION_FIELDS =
      Compute.OperationOption.fields(Compute.OperationField.ID, Compute.OperationField.DESCRIPTION);

  // Operation list options
  private static final Compute.OperationFilter OPERATION_FILTER =
      Compute.OperationFilter.notEquals(Compute.OperationField.PROGRESS, 0);
  private static final Compute.OperationListOption OPERATION_LIST_PAGE_TOKEN =
      Compute.OperationListOption.pageToken("cursor");
  private static final Compute.OperationListOption OPERATION_LIST_PAGE_SIZE =
      Compute.OperationListOption.pageSize(42L);
  private static final Compute.OperationListOption OPERATION_LIST_FILTER =
      Compute.OperationListOption.filter(OPERATION_FILTER);
  private static final Map<ComputeRpc.Option, ?> OPERATION_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "progress ne 0");

  // Address options
  private static final Compute.AddressOption ADDRESS_OPTION_FIELDS =
      Compute.AddressOption.fields(Compute.AddressField.ID, Compute.AddressField.DESCRIPTION);

  // Address list options
  private static final Compute.AddressFilter ADDRESS_FILTER =
      Compute.AddressFilter.notEquals(Compute.AddressField.REGION, "someRegion");
  private static final Compute.AddressListOption ADDRESS_LIST_PAGE_TOKEN =
      Compute.AddressListOption.pageToken("cursor");
  private static final Compute.AddressListOption ADDRESS_LIST_PAGE_SIZE =
      Compute.AddressListOption.pageSize(42L);
  private static final Compute.AddressListOption ADDRESS_LIST_FILTER =
      Compute.AddressListOption.filter(ADDRESS_FILTER);
  private static final Map<ComputeRpc.Option, ?> ADDRESS_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "region ne someRegion");

  // Address aggregated list options
  private static final Compute.AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.AddressAggregatedListOption.pageToken("cursor");
  private static final Compute.AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_PAGE_SIZE =
      Compute.AddressAggregatedListOption.pageSize(42L);
  private static final Compute.AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_FILTER =
      Compute.AddressAggregatedListOption.filter(ADDRESS_FILTER);

  // Snapshot options
  private static final Compute.SnapshotOption SNAPSHOT_OPTION_FIELDS =
      Compute.SnapshotOption.fields(Compute.SnapshotField.ID, Compute.SnapshotField.DESCRIPTION);

  // Snapshot list options
  private static final Compute.SnapshotFilter SNAPSHOT_FILTER =
      Compute.SnapshotFilter.equals(Compute.SnapshotField.DISK_SIZE_GB, 500L);
  private static final Compute.SnapshotListOption SNAPSHOT_LIST_PAGE_TOKEN =
      Compute.SnapshotListOption.pageToken("cursor");
  private static final Compute.SnapshotListOption SNAPSHOT_LIST_PAGE_SIZE =
      Compute.SnapshotListOption.pageSize(42L);
  private static final Compute.SnapshotListOption SNAPSHOT_LIST_FILTER =
      Compute.SnapshotListOption.filter(SNAPSHOT_FILTER);
  private static final Map<ComputeRpc.Option, ?> SNAPSHOT_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "diskSizeGb eq 500");

  // Image options
  private static final Compute.ImageOption IMAGE_OPTION_FIELDS =
      Compute.ImageOption.fields(Compute.ImageField.ID, Compute.ImageField.DESCRIPTION);

  // Image list options
  private static final Compute.ImageFilter IMAGE_FILTER =
      Compute.ImageFilter.notEquals(Compute.ImageField.DISK_SIZE_GB, 500L);
  private static final Compute.ImageListOption IMAGE_LIST_PAGE_TOKEN =
      Compute.ImageListOption.pageToken("cursor");
  private static final Compute.ImageListOption IMAGE_LIST_PAGE_SIZE =
      Compute.ImageListOption.pageSize(42L);
  private static final Compute.ImageListOption IMAGE_LIST_FILTER =
      Compute.ImageListOption.filter(IMAGE_FILTER);
  private static final Map<ComputeRpc.Option, ?> IMAGE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "diskSizeGb ne 500");

  // Disk options
  private static final Compute.DiskOption DISK_OPTION_FIELDS =
      Compute.DiskOption.fields(Compute.DiskField.ID, Compute.DiskField.DESCRIPTION);

  // Disk list options
  private static final Compute.DiskFilter DISK_FILTER =
      Compute.DiskFilter.notEquals(Compute.DiskField.SIZE_GB, 500L);
  private static final Compute.DiskListOption DISK_LIST_PAGE_TOKEN =
      Compute.DiskListOption.pageToken("cursor");
  private static final Compute.DiskListOption DISK_LIST_PAGE_SIZE =
      Compute.DiskListOption.pageSize(42L);
  private static final Compute.DiskListOption DISK_LIST_FILTER =
      Compute.DiskListOption.filter(DISK_FILTER);
  private static final Map<ComputeRpc.Option, ?> DISK_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "sizeGb ne 500");

  // Disk aggregated list options
  private static final Compute.DiskAggregatedListOption DISK_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.DiskAggregatedListOption.pageToken("cursor");
  private static final Compute.DiskAggregatedListOption DISK_AGGREGATED_LIST_PAGE_SIZE =
      Compute.DiskAggregatedListOption.pageSize(42L);
  private static final Compute.DiskAggregatedListOption DISK_AGGREGATED_LIST_FILTER =
      Compute.DiskAggregatedListOption.filter(DISK_FILTER);

  // Subnetwork options
  private static final Compute.SubnetworkOption SUBNETWORK_OPTION_FIELDS =
      Compute.SubnetworkOption.fields(Compute.SubnetworkField.ID,
          Compute.SubnetworkField.DESCRIPTION);

  // Subnetwork list options
  private static final Compute.SubnetworkFilter SUBNETWORK_FILTER =
      Compute.SubnetworkFilter.equals(Compute.SubnetworkField.IP_CIDR_RANGE, "192.168.0.0/16");
  private static final Compute.SubnetworkListOption SUBNETWORK_LIST_PAGE_TOKEN =
      Compute.SubnetworkListOption.pageToken("cursor");
  private static final Compute.SubnetworkListOption SUBNETWORK_LIST_PAGE_SIZE =
      Compute.SubnetworkListOption.pageSize(42L);
  private static final Compute.SubnetworkListOption SUBNETWORK_LIST_FILTER =
      Compute.SubnetworkListOption.filter(SUBNETWORK_FILTER);
  private static final Map<ComputeRpc.Option, ?> SUBNETWORK_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "ipCidrRange eq 192.168.0.0/16");

  // Subnetwork aggregated list options
  private static final Compute.SubnetworkAggregatedListOption
      SUBNETWORK_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.SubnetworkAggregatedListOption.pageToken("cursor");
  private static final Compute.SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_PAGE_SIZE =
      Compute.SubnetworkAggregatedListOption.pageSize(42L);
  private static final Compute.SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_FILTER =
      Compute.SubnetworkAggregatedListOption.filter(SUBNETWORK_FILTER);

  // Network options
  private static final Compute.NetworkOption NETWORK_OPTION_FIELDS =
      Compute.NetworkOption.fields(Compute.NetworkField.ID, Compute.NetworkField.DESCRIPTION);

  // Network list options
  private static final Compute.NetworkFilter NETWORK_FILTER =
      Compute.NetworkFilter.equals(Compute.NetworkField.IPV4_RANGE, "192.168.0.0/16");
  private static final Compute.NetworkListOption NETWORK_LIST_PAGE_TOKEN =
      Compute.NetworkListOption.pageToken("cursor");
  private static final Compute.NetworkListOption NETWORK_LIST_PAGE_SIZE =
      Compute.NetworkListOption.pageSize(42L);
  private static final Compute.NetworkListOption NETWORK_LIST_FILTER =
      Compute.NetworkListOption.filter(NETWORK_FILTER);
  private static final Map<ComputeRpc.Option, ?> NETWORK_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "IPv4Range eq 192.168.0.0/16");

  // Instance options
  private static final Compute.InstanceOption INSTANCE_OPTION_FIELDS =
      Compute.InstanceOption.fields(Compute.InstanceField.ID, Compute.InstanceField.DESCRIPTION);

  // Instance list options
  private static final Compute.InstanceFilter INSTANCE_FILTER =
      Compute.InstanceFilter.equals(Compute.InstanceField.CAN_IP_FORWARD, true);
  private static final Compute.InstanceListOption INSTANCE_LIST_PAGE_TOKEN =
      Compute.InstanceListOption.pageToken("cursor");
  private static final Compute.InstanceListOption INSTANCE_LIST_PAGE_SIZE =
      Compute.InstanceListOption.pageSize(42L);
  private static final Compute.InstanceListOption INSTANCE_LIST_FILTER =
      Compute.InstanceListOption.filter(INSTANCE_FILTER);
  private static final Map<ComputeRpc.Option, ?> INSTANCE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "canIpForward eq true");

  // Instance aggregated list options
  private static final Compute.InstanceAggregatedListOption INSTANCE_AGGREGATED_LIST_PAGE_TOKEN =
      Compute.InstanceAggregatedListOption.pageToken("cursor");
  private static final Compute.InstanceAggregatedListOption INSTANCE_AGGREGATED_LIST_PAGE_SIZE =
      Compute.InstanceAggregatedListOption.pageSize(42L);
  private static final Compute.InstanceAggregatedListOption INSTANCE_AGGREGATED_LIST_FILTER =
      Compute.InstanceAggregatedListOption.filter(INSTANCE_FILTER);

  private static final Function<Operation, com.google.api.services.compute.model.Operation>
      OPERATION_TO_PB_FUNCTION = new Function<Operation,
      com.google.api.services.compute.model.Operation>() {
    @Override
    public com.google.api.services.compute.model.Operation apply(Operation operation) {
      return operation.toPb();
    }
  };

  private ComputeOptions options;
  private ComputeRpcFactory rpcFactoryMock;
  private ComputeRpc computeRpcMock;
  private Compute compute;

  private Operation globalOperation;
  private Operation zoneOperation;
  private Operation regionOperation;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(ComputeRpcFactory.class);
    computeRpcMock = EasyMock.createMock(ComputeRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(ComputeOptions.class)))
        .andReturn(computeRpcMock).times(2);
    EasyMock.replay(rpcFactoryMock);
    options = ComputeOptions.newBuilder()
        .setProjectId(PROJECT)
        .setServiceRpcFactory(rpcFactoryMock)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
    Compute otherService = options.toBuilder().build().getService();
    globalOperation = new Operation.Builder(otherService)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(GLOBAL_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
    zoneOperation = new Operation.Builder(otherService)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(ZONE_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
    regionOperation = new Operation.Builder(otherService)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(REGION_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, computeRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertSame(options, compute.getOptions());
  }

  @Test
  public void testGetDiskType() {
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType());
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testGetDiskType_Null() {
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getDiskType(DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType()));
  }

  @Test
  public void testGetDiskTypeFromDiskTypeId() {
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID);
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testGetDiskTypeWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.getDiskType(
            eq(DISK_TYPE_ID.getZone()), eq(DISK_TYPE_ID.getType()), capture(capturedOptions)))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(),
        DISK_TYPE_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(DISK_TYPE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testListDiskTypes() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testListDiskTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    ImmutableList<DiskType> nextDiskTypeList = ImmutableList.of(DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextDiskTypeList, DiskType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.getZone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextDiskTypeList.toArray(),
        Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testListEmptyDiskTypes() {
    ImmutableList<com.google.api.services.compute.model.DiskType> diskTypes = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.DiskType>>of(null,
            diskTypes);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.getZone());
    assertNull(page.getNextPageToken());
    assertArrayEquals(diskTypes.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testListDiskTypesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.getZone(), DISK_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.getZone(), DISK_TYPE_LIST_PAGE_SIZE,
        DISK_TYPE_LIST_PAGE_TOKEN, DISK_TYPE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypes() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    ImmutableList<DiskType> nextDiskTypeList = ImmutableList.of(DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextDiskTypeList, DiskType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listDiskTypes(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextDiskTypeList.toArray(),
        Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testAggregatedListEmptyDiskTypes() {
    ImmutableList<com.google.api.services.compute.model.DiskType> diskTypes = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.DiskType>>of(null,
            diskTypes);
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<DiskType> page = compute.listDiskTypes();
    assertNull(page.getNextPageToken());
    assertArrayEquals(diskTypes.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_AGGREGATED_LIST_PAGE_SIZE,
        DISK_TYPE_AGGREGATED_LIST_PAGE_TOKEN, DISK_TYPE_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.getValues(), DiskType.class));
  }

  @Test
  public void testGetMachineType() {
    EasyMock.expect(
        computeRpcMock.getMachineType(
            MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    MachineType machineType =
        compute.getMachineType(MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_ID.getType());
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testGetMachineType_Null() {
    EasyMock.expect(
        computeRpcMock.getMachineType(
            MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getMachineType(MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_ID.getType()));
  }

  @Test
  public void testGetMachineTypeFromMachineTypeId() {
    EasyMock.expect(computeRpcMock.getMachineType(
        MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    MachineType machineType = compute.getMachineType(MACHINE_TYPE_ID);
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testGetMachineTypeWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.getMachineType(eq(MACHINE_TYPE_ID.getZone()), eq(MACHINE_TYPE_ID.getType()),
            capture(capturedOptions)))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    MachineType machineType = compute.getMachineType(MACHINE_TYPE_ID.getZone(),
        MACHINE_TYPE_ID.getType(), MACHINE_TYPE_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(DISK_TYPE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testListMachineTypes() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(), Iterables.toArray(page.getValues(),
        MachineType.class));
  }

  @Test
  public void testListMachineTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    ImmutableList<MachineType> nextMachineTypeList = ImmutableList.of(MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>>
        nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextMachineTypeList, MachineType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.getZone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextMachineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testListEmptyMachineTypes() {
    ImmutableList<com.google.api.services.compute.model.MachineType> machineTypes =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.MachineType>>of(
            null,
            machineTypes);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.getZone());
    assertNull(page.getNextPageToken());
    assertArrayEquals(machineTypes.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testListMachineTypesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.getZone(), MACHINE_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.getZone(),
        MACHINE_TYPE_LIST_PAGE_SIZE, MACHINE_TYPE_LIST_PAGE_TOKEN, MACHINE_TYPE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypes() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(), Iterables.toArray(page.getValues(),
        MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    ImmutableList<MachineType> nextMachineTypeList = ImmutableList.of(MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>>
        nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextMachineTypeList, MachineType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listMachineTypes(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextMachineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testAggregatedListEmptyMachineTypes() {
    ImmutableList<com.google.api.services.compute.model.MachineType> machineTypes =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.MachineType>>of(
            null,
            machineTypes);
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<MachineType> page = compute.listMachineTypes();
    assertNull(page.getNextPageToken());
    assertArrayEquals(machineTypes.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor,
            Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_AGGREGATED_LIST_PAGE_SIZE,
        MACHINE_TYPE_AGGREGATED_LIST_PAGE_TOKEN, MACHINE_TYPE_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.getValues(), MachineType.class));
  }

  @Test
  public void testGetRegion() {
    EasyMock.expect(computeRpcMock.getRegion(REGION_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(REGION.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Region region = compute.getRegion(REGION_ID.getRegion());
    assertEquals(REGION, region);
  }

  @Test
  public void testGetRegion_Null() {
    EasyMock.expect(computeRpcMock.getRegion(REGION_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getRegion(REGION_ID.getRegion()));
  }

  @Test
  public void testGetRegionWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegion(eq(REGION_ID.getRegion()), capture(capturedOptions)))
        .andReturn(REGION.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Region region = compute.getRegion(REGION_ID.getRegion(), REGION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(REGION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(REGION, region);
  }

  @Test
  public void testListRegions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.getValues(), Region.class));
  }

  @Test
  public void testListRegionsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    ImmutableList<Region> nextRegionList = ImmutableList.of(REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextRegionList, Region.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listRegions(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.getValues(), Region.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextRegionList.toArray(), Iterables.toArray(page.getValues(), Region.class));
  }

  @Test
  public void testListEmptyRegions() {
    ImmutableList<com.google.api.services.compute.model.Region> regions = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Region>>of(null,
            regions);
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Region> page = compute.listRegions();
    assertNull(page.getNextPageToken());
    assertArrayEquals(regions.toArray(), Iterables.toArray(page.getValues(), Region.class));
  }

  @Test
  public void testListRegionsWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listRegions(REGION_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions(REGION_LIST_PAGE_SIZE, REGION_LIST_PAGE_TOKEN,
        REGION_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.getValues(), Region.class));
  }

  @Test
  public void testGetZone() {
    EasyMock.expect(computeRpcMock.getZone(ZONE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(ZONE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Zone zone = compute.getZone(ZONE_ID.getZone());
    assertEquals(ZONE, zone);
  }

  @Test
  public void testGetZone_Null() {
    EasyMock.expect(computeRpcMock.getZone(ZONE_ID.getZone(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getZone(ZONE_ID.getZone()));
  }

  @Test
  public void testGetZoneWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getZone(eq(ZONE_ID.getZone()), capture(capturedOptions)))
        .andReturn(ZONE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Zone zone = compute.getZone(ZONE_ID.getZone(), ZONE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ZONE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(ZONE, zone);
  }

  @Test
  public void testListZones() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page = compute.listZones();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.getValues(), Zone.class));
  }

  @Test
  public void testListZonesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    ImmutableList<Zone> nextZoneList = ImmutableList.of(ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextZoneList, Zone.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listZones(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page = compute.listZones();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.getValues(), Zone.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextZoneList.toArray(), Iterables.toArray(page.getValues(), Zone.class));
  }

  @Test
  public void testListEmptyZones() {
    ImmutableList<com.google.api.services.compute.model.Zone> zones = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Zone>>of(null,
            zones);
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Zone> page = compute.listZones();
    assertNull(page.getNextPageToken());
    assertArrayEquals(zones.toArray(), Iterables.toArray(page.getValues(), Zone.class));
  }

  @Test
  public void testListZonesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listZones(ZONE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page =
        compute.listZones(ZONE_LIST_PAGE_SIZE, ZONE_LIST_PAGE_TOKEN, ZONE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.getValues(), Zone.class));
  }

  @Test
  public void testGetLicenseFromString() {
    EasyMock.expect(computeRpcMock.getLicense(PROJECT, LICENSE_ID.getLicense(), EMPTY_RPC_OPTIONS))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    License license = compute.getLicense(LICENSE_ID.getLicense());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromString_Null() {
    EasyMock.expect(computeRpcMock.getLicense(PROJECT, LICENSE_ID.getLicense(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getLicense(LICENSE_ID.getLicense()));
  }

  @Test
  public void testGetLicenseFromStringWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getLicense(
        eq(PROJECT), eq(LICENSE_ID.getLicense()), capture(capturedOptions)))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    License license = compute.getLicense(LICENSE_ID.getLicense(), LICENSE_OPTION_FIELDS);
    assertEquals(LICENSE, license);
    String selector = (String) capturedOptions.getValue().get(LICENSE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("chargesUseFee"));
    assertEquals(22, selector.length());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromIdWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(computeRpcMock.getLicense(
        eq(licenseId.getProject()), eq(licenseId.getLicense()), capture(capturedOptions)))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    License license = compute.getLicense(licenseId, LICENSE_OPTION_FIELDS);
    assertEquals(LICENSE, license);
    String selector = (String) capturedOptions.getValue().get(LICENSE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("chargesUseFee"));
    assertEquals(22, selector.length());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromId() {
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(computeRpcMock.getLicense(licenseId.getProject(), licenseId.getLicense(),
        EMPTY_RPC_OPTIONS)).andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    License license = compute.getLicense(licenseId);
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromId_Null() {
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(computeRpcMock.getLicense(
        licenseId.getProject(), licenseId.getLicense(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getLicense(licenseId));
  }

  @Test
  public void testGetGlobalOperation() {
    EasyMock.expect(
        computeRpcMock.getGlobalOperation(GLOBAL_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.getOperation(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetGlobalOperation_Null() {
    EasyMock.expect(
        computeRpcMock.getGlobalOperation(GLOBAL_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getOperation(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetGlobalOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getGlobalOperation(
        eq(GLOBAL_OPERATION_ID.getOperation()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(GLOBAL_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testListGlobalOperations() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListGlobalOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listGlobalOperations(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListEmptyGlobalOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Operation> page = compute.listGlobalOperations();
    assertNull(page.getNextPageToken());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListGlobalOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalOperations(OPERATION_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations(OPERATION_LIST_PAGE_SIZE,
        OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testDeleteGlobalOperation_True() {
    EasyMock.expect(computeRpcMock.deleteGlobalOperation(GLOBAL_OPERATION_ID.getOperation()))
        .andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertTrue(compute.deleteOperation(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testDeleteGlobalOperation_False() {
    EasyMock.expect(computeRpcMock.deleteGlobalOperation(GLOBAL_OPERATION_ID.getOperation()))
        .andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertFalse(compute.deleteOperation(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetRegionOperation() {
    EasyMock.expect(computeRpcMock.getRegionOperation(REGION_OPERATION_ID.getRegion(),
        REGION_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(REGION_OPERATION_ID);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetRegionOperation_Null() {
    EasyMock.expect(computeRpcMock.getRegionOperation(REGION_OPERATION_ID.getRegion(),
        REGION_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(REGION_OPERATION_ID);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetRegionOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegionOperation(eq(REGION_OPERATION_ID.getRegion()),
        eq(REGION_OPERATION_ID.getOperation()), capture(capturedOptions)))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(REGION_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testListRegionOperations() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListRegionOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listRegionOperations(REGION_OPERATION_ID.getRegion(),
        EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listRegionOperations(REGION_OPERATION_ID.getRegion(),
        nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListEmptyRegionOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.getRegion());
    assertNull(page.getNextPageToken());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListRegionOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listRegionOperations(
        REGION_OPERATION_ID.getRegion(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.getRegion(),
        OPERATION_LIST_PAGE_SIZE, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testDeleteRegionOperation_True() {
    EasyMock.expect(computeRpcMock.deleteRegionOperation(REGION_OPERATION_ID.getRegion(),
        REGION_OPERATION_ID.getOperation())).andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertTrue(compute.deleteOperation(REGION_OPERATION_ID));
  }

  @Test
  public void testDeleteRegionOperation_False() {
    EasyMock.expect(computeRpcMock.deleteRegionOperation(REGION_OPERATION_ID.getRegion(),
        REGION_OPERATION_ID.getOperation())).andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertFalse(compute.deleteOperation(REGION_OPERATION_ID));
  }

  @Test
  public void testGetZoneOperation() {
    EasyMock.expect(computeRpcMock.getZoneOperation(ZONE_OPERATION_ID.getZone(),
        ZONE_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(ZONE_OPERATION_ID);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testGetZoneOperation_Null() {
    EasyMock.expect(computeRpcMock.getZoneOperation(ZONE_OPERATION_ID.getZone(),
        ZONE_OPERATION_ID.getOperation(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getOperation(ZONE_OPERATION_ID));
  }

  @Test
  public void testGetZoneOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getZoneOperation(eq(ZONE_OPERATION_ID.getZone()),
        eq(ZONE_OPERATION_ID.getOperation()), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.getOperation(ZONE_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testListZoneOperations() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListZoneOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listZoneOperations(
        ZONE_OPERATION_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.getZone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListEmptyZoneOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.getZone());
    assertNull(page.getNextPageToken());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testListZoneOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.getZone(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.getZone(),
        OPERATION_LIST_PAGE_SIZE, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(operationList.toArray(),
        Iterables.toArray(page.getValues(), Operation.class));
  }

  @Test
  public void testDeleteZoneOperation_True() {
    EasyMock.expect(computeRpcMock.deleteZoneOperation(ZONE_OPERATION_ID.getZone(),
        ZONE_OPERATION_ID.getOperation())).andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertTrue(compute.deleteOperation(ZONE_OPERATION_ID));
  }

  @Test
  public void testDeleteZoneOperation_False() {
    EasyMock.expect(computeRpcMock.deleteZoneOperation(ZONE_OPERATION_ID.getZone(),
        ZONE_OPERATION_ID.getOperation())).andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertFalse(compute.deleteOperation(ZONE_OPERATION_ID));
  }

  @Test
  public void testGetGlobalAddress() {
    EasyMock.expect(computeRpcMock.getGlobalAddress(
        GLOBAL_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS))
        .andReturn(GLOBAL_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Address address = compute.getAddress(GLOBAL_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)), address);
  }

  @Test
  public void testGetGlobalAddress_Null() {
    EasyMock.expect(computeRpcMock.getGlobalAddress(
        GLOBAL_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getAddress(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testGetGlobalAddressWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getGlobalAddress(
        eq(GLOBAL_ADDRESS_ID.getAddress()), capture(capturedOptions)))
        .andReturn(GLOBAL_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Address address = compute.getAddress(GLOBAL_ADDRESS_ID, ADDRESS_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ADDRESS_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddress() {
    EasyMock.expect(computeRpcMock.getRegionAddress(REGION_ADDRESS_ID.getRegion(),
        REGION_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS)).andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Address address = compute.getAddress(REGION_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddress_Null() {
    EasyMock.expect(computeRpcMock.getRegionAddress(REGION_ADDRESS_ID.getRegion(),
        REGION_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS)).andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Address address = compute.getAddress(REGION_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddressWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegionAddress(eq(REGION_ADDRESS_ID.getRegion()),
        eq(REGION_ADDRESS_ID.getAddress()), capture(capturedOptions)))
        .andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Address address = compute.getAddress(REGION_ADDRESS_ID, ADDRESS_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ADDRESS_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testDeleteGlobalAddress_Operation() {
    EasyMock.expect(computeRpcMock.deleteGlobalAddress(
        GLOBAL_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.deleteAddress(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testDeleteGlobalAddressWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteGlobalAddress(eq(GLOBAL_ADDRESS_ID.getAddress()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteAddress(GLOBAL_ADDRESS_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteGlobalAddress_Null() {
    EasyMock.expect(computeRpcMock.deleteGlobalAddress(
        GLOBAL_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteAddress(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testDeleteRegionAddress_Operation() {
    EasyMock.expect(computeRpcMock.deleteRegionAddress(REGION_ADDRESS_ID.getRegion(),
        REGION_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(regionOperation, compute.deleteAddress(REGION_ADDRESS_ID));
  }

  @Test
  public void testDeleteRegionAddressWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteRegionAddress(eq(REGION_ADDRESS_ID.getRegion()),
        eq(REGION_ADDRESS_ID.getAddress()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteAddress(REGION_ADDRESS_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteRegionAddress_Null() {
    EasyMock.expect(computeRpcMock.deleteRegionAddress(REGION_ADDRESS_ID.getRegion(),
        REGION_ADDRESS_ID.getAddress(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteAddress(REGION_ADDRESS_ID));
  }

  @Test
  public void testListGlobalAddresses() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListGlobalAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextAddressList.toArray(),
        Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListEmptyGlobalAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null,
            addresses);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Address> page = compute.listGlobalAddresses();
    assertNull(page.getNextPageToken());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListGlobalAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalAddresses(ADDRESS_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses(ADDRESS_LIST_PAGE_SIZE,
        ADDRESS_LIST_PAGE_TOKEN, ADDRESS_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListRegionAddresses() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListRegionAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.getRegion(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextAddressList.toArray(),
        Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListEmptyRegionAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null,
            addresses);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.getRegion());
    assertNull(page.getNextPageToken());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testListRegionAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.getRegion(), ADDRESS_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.getRegion(),
        ADDRESS_LIST_PAGE_SIZE, ADDRESS_LIST_PAGE_TOKEN, ADDRESS_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testAggregatedListAddresses() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testAggregatedListAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listAddresses(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextAddressList.toArray(),
        Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testAggregatedListEmptyAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null,
            addresses);
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Page<Address> page = compute.listAddresses();
    assertNull(page.getNextPageToken());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testAggregatedListAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listAddresses(ADDRESS_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses(ADDRESS_AGGREGATED_LIST_PAGE_SIZE,
        ADDRESS_AGGREGATED_LIST_PAGE_TOKEN, ADDRESS_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.getValues(), Address.class));
  }

  @Test
  public void testCreateGlobalAddress() {
    EasyMock.expect(computeRpcMock.createGlobalAddress(GLOBAL_ADDRESS.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    AddressId incompleteId = GlobalAddressId.of("address");
    Operation operation =
        compute.create(GLOBAL_ADDRESS.toBuilder().setAddressId(incompleteId).build());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateGlobalAddressWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.createGlobalAddress(eq(GLOBAL_ADDRESS.toPb()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(GLOBAL_ADDRESS, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateRegionAddress() {
    EasyMock.expect(computeRpcMock.createRegionAddress(REGION_ADDRESS_ID.getRegion(),
        REGION_ADDRESS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    AddressId incompleteId = RegionAddressId.of("region", "address");
    Operation operation =
        compute.create(REGION_ADDRESS.toBuilder().setAddressId(incompleteId).build());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateRegionAddressWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createRegionAddress(eq(REGION_ADDRESS_ID.getRegion()),
        eq(REGION_ADDRESS.toPb()), capture(capturedOptions))).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(REGION_ADDRESS, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateSnapshot() {
    EasyMock.expect(computeRpcMock.createSnapshot(DISK_ID.getZone(), DISK_ID.getDisk(),
        SNAPSHOT_ID.getSnapshot(), null, EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(SNAPSHOT);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testCreateSnapshotWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createSnapshot(eq(DISK_ID.getZone()), eq(DISK_ID.getDisk()),
        eq(SNAPSHOT_ID.getSnapshot()), EasyMock.<String>isNull(), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(SNAPSHOT, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testGetSnapshot() {
    EasyMock.expect(computeRpcMock.getSnapshot(SNAPSHOT_ID.getSnapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(SNAPSHOT.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Snapshot snapshot = compute.getSnapshot(SNAPSHOT_ID.getSnapshot());
    assertEquals(new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)), snapshot);
  }

  @Test
  public void testGetSnapshot_Null() {
    EasyMock.expect(computeRpcMock.getSnapshot(SNAPSHOT_ID.getSnapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getSnapshot(SNAPSHOT_ID.getSnapshot()));
  }

  @Test
  public void testGetSnapshotWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getSnapshot(eq(SNAPSHOT_ID.getSnapshot()),
        capture(capturedOptions))).andReturn(SNAPSHOT.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Snapshot snapshot = compute.getSnapshot(SNAPSHOT_ID.getSnapshot(), SNAPSHOT_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(SNAPSHOT_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)), snapshot);
  }

  @Test
  public void testDeleteSnapshot_Operation() {
    EasyMock.expect(computeRpcMock.deleteSnapshot(SNAPSHOT_ID.getSnapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.deleteSnapshot(SNAPSHOT_ID.getSnapshot()));
  }

  @Test
  public void testDeleteSnapshotWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteSnapshot(eq(SNAPSHOT_ID.getSnapshot()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteSnapshot(SNAPSHOT_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteSnapshot_Null() {
    EasyMock.expect(computeRpcMock.deleteSnapshot(SNAPSHOT_ID.getSnapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteSnapshot(SNAPSHOT_ID));
  }

  @Test
  public void testListSnapshots() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.getValues(), Snapshot.class));
  }

  @Test
  public void testListSnapshotsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    ImmutableList<Snapshot> nextSnapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextSnapshotList, SnapshotInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listSnapshots(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.getValues(), Snapshot.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextSnapshotList.toArray(),
        Iterables.toArray(page.getValues(), Snapshot.class));
  }

  @Test
  public void testListEmptySnapshots() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Snapshot> snapshots = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Snapshot>>of(null,
            snapshots);
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertNull(page.getNextPageToken());
    assertArrayEquals(snapshots.toArray(), Iterables.toArray(page.getValues(), Snapshot.class));
  }

  @Test
  public void testListSnapshotsWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSnapshots(SNAPSHOT_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots(SNAPSHOT_LIST_PAGE_SIZE, SNAPSHOT_LIST_PAGE_TOKEN,
        SNAPSHOT_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.getValues(), Snapshot.class));
  }

  @Test
  public void testCreateImage() {
    EasyMock.expect(computeRpcMock.createImage(IMAGE.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(IMAGE);
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateImageWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createImage(eq(IMAGE.toPb()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(IMAGE, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testGetImage() {
    EasyMock.expect(
        computeRpcMock.getImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(), EMPTY_RPC_OPTIONS))
        .andReturn(IMAGE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Image image = compute.getImage(IMAGE_ID);
    assertEquals(new Image(compute, new ImageInfo.BuilderImpl(IMAGE)), image);
  }

  @Test
  public void testGetImage_Null() {
    EasyMock.expect(
        computeRpcMock.getImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getImage(IMAGE_ID));
  }

  @Test
  public void testGetImageWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getImage(eq(IMAGE_ID.getProject()), eq(IMAGE_ID.getImage()),
        capture(capturedOptions))).andReturn(IMAGE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Image image = compute.getImage(IMAGE_ID, IMAGE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(IMAGE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("sourceDisk"));
    assertTrue(selector.contains("rawDisk"));
    assertTrue(selector.contains("description"));
    assertEquals(42, selector.length());
    assertEquals(new Image(compute, new ImageInfo.BuilderImpl(IMAGE)), image);
  }

  @Test
  public void testDeleteImage_Operation() {
    EasyMock.expect(computeRpcMock.deleteImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(),
        EMPTY_RPC_OPTIONS)).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.deleteImage(IMAGE_ID));
  }

  @Test
  public void testDeleteImageWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteImage(eq(PROJECT), eq(IMAGE_ID.getImage()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteImage(ImageId.of("image"), OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteImage_Null() {
    EasyMock.expect(computeRpcMock.deleteImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteImage(IMAGE_ID));
  }

  @Test
  public void testDeprecateImage_Operation() {
    EasyMock.expect(computeRpcMock.deprecateImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(),
        DEPRECATION_STATUS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.deprecate(IMAGE_ID, DEPRECATION_STATUS));
  }

  @Test
  public void testDeprecateImageWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deprecateImage(eq(PROJECT), eq(IMAGE_ID.getImage()),
        eq(DEPRECATION_STATUS.toPb()), capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation =
        compute.deprecate(ImageId.of("image"), DEPRECATION_STATUS, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeprecateImage_Null() {
    EasyMock.expect(computeRpcMock.deprecateImage(IMAGE_ID.getProject(), IMAGE_ID.getImage(),
        DEPRECATION_STATUS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deprecate(IMAGE_ID, DEPRECATION_STATUS));
  }

  @Test
  public void testListImages() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListImagesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    ImmutableList<Image> nextImageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextImageList, ImageInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextImageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListImagesForProject() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages("otherProject", EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("otherProject");
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListEmptyImages() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Image> images = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Image>>of(null,
            images);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertNull(page.getNextPageToken());
    assertArrayEquals(images.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListEmptyImagesForProject() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Image> images = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Image>>of(null,
            images);
    EasyMock.expect(computeRpcMock.listImages("otherProject", EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("otherProject");
    assertNull(page.getNextPageToken());
    assertArrayEquals(images.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListImagesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages(PROJECT, IMAGE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages(IMAGE_LIST_PAGE_SIZE, IMAGE_LIST_PAGE_TOKEN,
        IMAGE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testListImagesForProjectWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages("other", IMAGE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("other", IMAGE_LIST_PAGE_SIZE, IMAGE_LIST_PAGE_TOKEN,
        IMAGE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.getValues(), Image.class));
  }

  @Test
  public void testGetDisk() {
    EasyMock.expect(computeRpcMock.getDisk(DISK_ID.getZone(), DISK_ID.getDisk(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Disk disk = compute.getDisk(DISK_ID);
    assertEquals(new Disk(compute, new DiskInfo.BuilderImpl(DISK)), disk);
  }

  @Test
  public void testGetDisk_Null() {
    EasyMock.expect(computeRpcMock.getDisk(DISK_ID.getZone(), DISK_ID.getDisk(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getDisk(DISK_ID));
  }

  @Test
  public void testGetDiskWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getDisk(eq(DISK_ID.getZone()), eq(DISK_ID.getDisk()),
        capture(capturedOptions))).andReturn(DISK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Disk disk = compute.getDisk(DISK_ID, DISK_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DISK_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("type"));
    assertTrue(selector.contains("sourceImage"));
    assertTrue(selector.contains("sourceSnapshot"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(55, selector.length());
    assertEquals(new Disk(compute, new DiskInfo.BuilderImpl(DISK)), disk);
  }

  @Test
  public void testDeleteDisk_Operation() {
    EasyMock.expect(computeRpcMock.deleteDisk(
        DISK_ID.getZone(), DISK_ID.getDisk(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.deleteDisk(DISK_ID));
  }

  @Test
  public void testDeleteDiskWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteDisk(eq(DISK_ID.getZone()), eq(DISK_ID.getDisk()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteDisk(DISK_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testDeleteDisk_Null() {
    EasyMock.expect(computeRpcMock.deleteDisk(
        DISK_ID.getZone(), DISK_ID.getDisk(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteDisk(DISK_ID));
  }

  @Test
  public void testListDisks() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testListDisksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    ImmutableList<Disk> nextDiskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskList, DiskInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.getZone(), nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextDiskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testListEmptyDisks() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Disk> disks = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Disk>>of(null,
            disks);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.getZone());
    assertNull(page.getNextPageToken());
    assertArrayEquals(disks.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testListDisksWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.getZone(), DISK_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(
        DISK_ID.getZone(), DISK_LIST_PAGE_SIZE, DISK_LIST_PAGE_TOKEN, DISK_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testAggregatedListDisks() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testAggregatedListDisksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    ImmutableList<Disk> nextDiskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskList, DiskInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listDisks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextDiskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testAggregatedListEmptyDisks() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Disk> diskList = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Disk>>of(null,
            diskList);
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertNull(page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testAggregatedListDisksWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_AGGREGATED_LIST_PAGE_SIZE,
        DISK_AGGREGATED_LIST_PAGE_TOKEN, DISK_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.getValues(), Disk.class));
  }

  @Test
  public void testCreateDisk() {
    EasyMock.expect(computeRpcMock.createDisk(DISK_ID.getZone(), DISK.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    DiskId diskId = DiskId.of("zone", "disk");
    DiskTypeId diskTypeId = DiskTypeId.of("zone", "diskType");
    DiskInfo disk = DISK.toBuilder()
        .setDiskId(diskId)
        .setConfiguration(StandardDiskConfiguration.of(diskTypeId))
        .build();
    Operation operation = compute.create(disk);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testCreateDiskWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createDisk(eq(DISK_ID.getZone()), eq(DISK.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(DISK, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testResizeDisk_Operation() {
    EasyMock.expect(computeRpcMock.resizeDisk(DISK_ID.getZone(), DISK_ID.getDisk(), 42L,
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.resize(DISK_ID, 42L));
  }

  @Test
  public void testResizeDiskWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.resizeDisk(eq(DISK_ID.getZone()), eq(DISK_ID.getDisk()), eq(42L),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.resize(DISK_ID, 42L, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testResizeDisk_Null() {
    EasyMock.expect(computeRpcMock.resizeDisk(DISK_ID.getZone(), DISK_ID.getDisk(), 42L,
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.resize(DISK_ID, 42L));
  }

  @Test
  public void testGetSubnetwork() {
    EasyMock.expect(computeRpcMock.getSubnetwork(
        SUBNETWORK_ID.getRegion(), SUBNETWORK_ID.getSubnetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(SUBNETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Subnetwork subnetwork = compute.getSubnetwork(SUBNETWORK_ID);
    assertEquals(new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)), subnetwork);
  }

  @Test
  public void testGetSubnetwork_Null() {
    EasyMock.expect(computeRpcMock.getSubnetwork(
        SUBNETWORK_ID.getRegion(), SUBNETWORK_ID.getSubnetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getSubnetwork(SUBNETWORK_ID));
  }

  @Test
  public void testGetSubnetworkWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getSubnetwork(eq(SUBNETWORK_ID.getRegion()),
        eq(SUBNETWORK_ID.getSubnetwork()), capture(capturedOptions))).andReturn(SUBNETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Subnetwork subnetwork = compute.getSubnetwork(SUBNETWORK_ID, SUBNETWORK_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(SUBNETWORK_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)), subnetwork);
  }

  @Test
  public void testDeleteSubnetwork_Operation() {
    EasyMock.expect(computeRpcMock.deleteSubnetwork(SUBNETWORK_ID.getRegion(),
        SUBNETWORK_ID.getSubnetwork(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(regionOperation, compute.deleteSubnetwork(SUBNETWORK_ID));
  }

  @Test
  public void testDeleteSubnetworkWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteSubnetwork(eq(SUBNETWORK_ID.getRegion()),
        eq(SUBNETWORK_ID.getSubnetwork()), capture(capturedOptions)))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteSubnetwork(SUBNETWORK_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testDeleteSubnetwork_Null() {
    EasyMock.expect(computeRpcMock.deleteSubnetwork(SUBNETWORK_ID.getRegion(),
        SUBNETWORK_ID.getSubnetwork(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteSubnetwork(SUBNETWORK_ID));
  }

  @Test
  public void testListSubnetworks() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testListSubnetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    ImmutableList<Subnetwork> nextSubnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>>
        nextResult = Tuple.of(nextCursor,
        Iterables.transform(nextSubnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.getRegion(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.getRegion());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextSubnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testListEmptySubnetworks() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Subnetwork> subnetworks =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Subnetwork>>of(
            null,
            subnetworks);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.getRegion(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.getRegion());
    assertNull(page.getNextPageToken());
    assertArrayEquals(subnetworks.toArray(), Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testListSubnetworksWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(
        SUBNETWORK_ID.getRegion(), SUBNETWORK_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.getRegion(),
        SUBNETWORK_LIST_PAGE_SIZE, SUBNETWORK_LIST_PAGE_TOKEN, SUBNETWORK_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworks() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    ImmutableList<Subnetwork> nextSubnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>>
        nextResult = Tuple.of(nextCursor,
        Iterables.transform(nextSubnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listSubnetworks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextSubnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListEmptySubnetworks() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Subnetwork> subnetworks =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Subnetwork>>of(
            null,
            subnetworks);
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertNull(page.getNextPageToken());
    assertArrayEquals(subnetworks.toArray(), Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworksWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor,
            Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_AGGREGATED_LIST_PAGE_SIZE,
        SUBNETWORK_AGGREGATED_LIST_PAGE_TOKEN, SUBNETWORK_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(subnetworkList.toArray(),
        Iterables.toArray(page.getValues(), Subnetwork.class));
  }

  @Test
  public void testCreateSubnetwork() {
    EasyMock.expect(computeRpcMock.createSubnetwork(SUBNETWORK_ID.getRegion(), SUBNETWORK.toPb(),
        EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    SubnetworkId subnetworkId = SubnetworkId.of("region", "network");
    NetworkId networkId = NetworkId.of("network");
    SubnetworkInfo subnetwork = SubnetworkInfo.of(subnetworkId, networkId, "192.168.0.0/16");
    Operation operation = compute.create(subnetwork);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateSubnetworkWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createSubnetwork(eq(SUBNETWORK_ID.getRegion()),
        eq(SUBNETWORK.toPb()), capture(capturedOptions))).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(SUBNETWORK, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetNetwork() {
    EasyMock.expect(computeRpcMock.getNetwork(NETWORK_ID.getNetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(NETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Network network = compute.getNetwork(NETWORK_ID.getNetwork());
    assertEquals(new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)), network);
  }

  @Test
  public void testGetNetwork_Null() {
    EasyMock.expect(computeRpcMock.getNetwork(NETWORK_ID.getNetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getNetwork(NETWORK_ID.getNetwork()));
  }

  @Test
  public void testGetNetworkWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getNetwork(eq(
        NETWORK_ID.getNetwork()), capture(capturedOptions)))
        .andReturn(NETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Network network = compute.getNetwork(NETWORK_ID.getNetwork(), NETWORK_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(NETWORK_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertTrue(selector.contains("IPv4Range"));
    assertTrue(selector.contains("autoCreateSubnetworks"));
    assertEquals(55, selector.length());
    assertEquals(new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)), network);
  }

  @Test
  public void testDeleteNetwork_Operation() {
    EasyMock.expect(computeRpcMock.deleteNetwork(NETWORK_ID.getNetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(globalOperation, compute.deleteNetwork(NETWORK_ID));
  }

  @Test
  public void testDeleteNetworkWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteNetwork(eq(NETWORK_ID.getNetwork()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteNetwork(NETWORK_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteNetwork_Null() {
    EasyMock.expect(computeRpcMock.deleteNetwork(NETWORK_ID.getNetwork(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteNetwork(NETWORK_ID));
  }

  @Test
  public void testListNetworks() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.getValues(), Network.class));
  }

  @Test
  public void testListNetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    ImmutableList<Network> nextNetworkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextNetworkList, NetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listNetworks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.getValues(), Network.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextNetworkList.toArray(),
        Iterables.toArray(page.getValues(), Network.class));
  }

  @Test
  public void testListEmptyNetworks() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Network> networks = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Network>>of(null,
            networks);
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertNull(page.getNextPageToken());
    assertArrayEquals(networks.toArray(), Iterables.toArray(page.getValues(), Network.class));
  }

  @Test
  public void testListNetworksWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listNetworks(NETWORK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks(NETWORK_LIST_PAGE_SIZE, NETWORK_LIST_PAGE_TOKEN,
        NETWORK_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.getValues(), Network.class));
  }

  @Test
  public void testCreateNetwork() {
    EasyMock.expect(computeRpcMock.createNetwork(NETWORK.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    NetworkInfo network =
        NetworkInfo.of(NetworkId.of("network"), StandardNetworkConfiguration.of("192.168.0.0/16"));
    Operation operation = compute.create(network);
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateNetworkWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createNetwork(eq(NETWORK.toPb()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(NETWORK, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testGetInstance() {
    EasyMock.expect(computeRpcMock.getInstance(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(INSTANCE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Instance instance = compute.getInstance(INSTANCE_ID);
    assertEquals(new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)), instance);
  }

  @Test
  public void testGetInstance_Null() {
    EasyMock.expect(computeRpcMock.getInstance(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getInstance(INSTANCE_ID));
  }

  @Test
  public void testGetInstanceWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getInstance(
        eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()), capture(capturedOptions)))
        .andReturn(INSTANCE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Instance instance = compute.getInstance(INSTANCE_ID, INSTANCE_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(INSTANCE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)), instance);
  }

  @Test
  public void testDeleteInstance_Operation() {
    EasyMock.expect(computeRpcMock.deleteInstance(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.deleteInstance(INSTANCE_ID));
  }

  @Test
  public void testDeleteInstanceWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteInstance(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteInstance(INSTANCE_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testDeleteInstance_Null() {
    EasyMock.expect(computeRpcMock.deleteInstance(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteInstance(INSTANCE_ID));
  }

  @Test
  public void testListInstances() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances(INSTANCE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testListInstancesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    ImmutableList<Instance> nextInstanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextInstanceList, InstanceInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_ID.getZone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances(INSTANCE_ID.getZone());
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextInstanceList.toArray(),
        Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testListEmptyInstances() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Instance> instances = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Instance>>of(null,
            instances);
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_ID.getZone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances(INSTANCE_ID.getZone());
    assertNull(page.getNextPageToken());
    assertArrayEquals(instances.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testListInstancesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_ID.getZone(), INSTANCE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances(INSTANCE_ID.getZone(), INSTANCE_LIST_PAGE_SIZE,
        INSTANCE_LIST_PAGE_TOKEN, INSTANCE_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testAggregatedListInstances() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listInstances(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testAggregatedListInstancesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    ImmutableList<Instance> nextInstanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextInstanceList, InstanceInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(ComputeRpc.Option.PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listInstances(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listInstances(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances();
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
    page = page.getNextPage();
    assertEquals(nextCursor, page.getNextPageToken());
    assertArrayEquals(nextInstanceList.toArray(),
        Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testAggregatedListEmptyInstances() {
    compute = options.getService();
    ImmutableList<com.google.api.services.compute.model.Instance> instanceList = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Instance>>of(null,
            instanceList);
    EasyMock.expect(computeRpcMock.listInstances(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances();
    assertNull(page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testAggregatedListInstancesWithOptions() {
    String cursor = "cursor";
    compute = options.getService();
    ImmutableList<Instance> instanceList = ImmutableList.of(
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)),
        new Instance(compute, new InstanceInfo.BuilderImpl(INSTANCE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Instance>> result =
        Tuple.of(cursor, Iterables.transform(instanceList, InstanceInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listInstances(INSTANCE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Instance> page = compute.listInstances(INSTANCE_AGGREGATED_LIST_PAGE_SIZE,
        INSTANCE_AGGREGATED_LIST_PAGE_TOKEN, INSTANCE_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.getNextPageToken());
    assertArrayEquals(instanceList.toArray(), Iterables.toArray(page.getValues(), Instance.class));
  }

  @Test
  public void testCreateInstance() {
    EasyMock.expect(computeRpcMock.createInstance(INSTANCE_ID.getZone(), INSTANCE.toPb(),
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    InstanceInfo instance = InstanceInfo.of(InstanceId.of("zone", "instance"),
        MachineTypeId.of("zone", "type"), ATTACHED_DISK,
        NetworkInterface.of(NetworkId.of("network")));
    Operation operation = compute.create(instance);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testCreateInstanceWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createInstance(eq(INSTANCE_ID.getZone()), eq(INSTANCE.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.create(INSTANCE, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testAddAccessConfig_Operation() {
    AccessConfig accessConfig = AccessConfig.of("192.168.1.1");
    EasyMock.expect(computeRpcMock.addAccessConfig(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        "networkInterface", accessConfig.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation,
        compute.addAccessConfig(INSTANCE_ID, "networkInterface", accessConfig));
  }

  @Test
  public void testAddAccessConfigWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    AccessConfig accessConfig = AccessConfig.of("192.168.1.1");
    EasyMock.expect(computeRpcMock.addAccessConfig(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq("networkInterface"), eq(accessConfig.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.addAccessConfig(INSTANCE_ID, "networkInterface", accessConfig,
        OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testAddAccessConfig_Null() {
    AccessConfig accessConfig = AccessConfig.of("192.168.1.1");
    EasyMock.expect(computeRpcMock.addAccessConfig(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        "networkInterface", accessConfig.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.addAccessConfig(INSTANCE_ID, "networkInterface", accessConfig));
  }

  @Test
  public void testAttachDisk_Operation() {
    AttachedDisk attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    EasyMock.expect(computeRpcMock.attachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        attachedDisk.toPb(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.attachDisk(INSTANCE_ID, PERSISTENT_DISK_CONFIGURATION));
  }

  @Test
  public void testAttachDiskWithSelectedFields_Operation() {
    AttachedDisk attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.attachDisk(
        eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()), eq(attachedDisk.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation =
        compute.attachDisk(INSTANCE_ID, PERSISTENT_DISK_CONFIGURATION, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testAttachDisk_Null() {
    AttachedDisk attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    EasyMock.expect(computeRpcMock.attachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        attachedDisk.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.attachDisk(INSTANCE_ID, PERSISTENT_DISK_CONFIGURATION));
  }

  @Test
  public void testAttachDiskName_Operation() {
    AttachedDisk attachedDisk = AttachedDisk.of("dev0", PERSISTENT_DISK_CONFIGURATION);
    EasyMock.expect(computeRpcMock.attachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        attachedDisk.toPb(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation,
        compute.attachDisk(INSTANCE_ID, "dev0", PERSISTENT_DISK_CONFIGURATION));
  }

  @Test
  public void testAttachDiskNameWithSelectedFields_Operation() {
    AttachedDisk attachedDisk = AttachedDisk.of("dev0", PERSISTENT_DISK_CONFIGURATION);
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.attachDisk(
        eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()), eq(attachedDisk.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.attachDisk(INSTANCE_ID, "dev0", PERSISTENT_DISK_CONFIGURATION,
        OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testAttachDiskName_Null() {
    AttachedDisk attachedDisk = AttachedDisk.of("dev0", PERSISTENT_DISK_CONFIGURATION);
    EasyMock.expect(computeRpcMock.attachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        attachedDisk.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.attachDisk(INSTANCE_ID, "dev0", PERSISTENT_DISK_CONFIGURATION));
  }

  @Test
  public void testDeleteAccessConfig_Operation() {
    EasyMock.expect(computeRpcMock.deleteAccessConfig(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), "networkInterface", "accessConfig", EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation,
        compute.deleteAccessConfig(INSTANCE_ID, "networkInterface", "accessConfig"));
  }

  @Test
  public void testDeleteAccessConfigWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteAccessConfig(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq("networkInterface"), eq("accessConfig"),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.deleteAccessConfig(INSTANCE_ID, "networkInterface",
        "accessConfig", OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testDeleteAccessConfig_Null() {
    EasyMock.expect(computeRpcMock.deleteAccessConfig(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), "networkInterface", "accessConfig", EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.deleteAccessConfig(INSTANCE_ID, "networkInterface", "accessConfig"));
  }

  @Test
  public void testDetachDisk_Operation() {
    EasyMock.expect(computeRpcMock.detachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        "device", EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.detachDisk(INSTANCE_ID, "device"));
  }

  @Test
  public void testDetachDiskWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.detachDisk(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq("device"), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.detachDisk(INSTANCE_ID, "device", OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testDetachDisk_Null() {
    EasyMock.expect(computeRpcMock.detachDisk(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        "device", EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.detachDisk(INSTANCE_ID, "device"));
  }

  @Test
  public void testSerialPortOutputFromPort() {
    String output = "output";
    EasyMock.expect(computeRpcMock.getSerialPortOutput(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), 2, EMPTY_RPC_OPTIONS)).andReturn(output);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(output, compute.getSerialPortOutput(INSTANCE_ID, 2));
  }

  @Test
  public void testSerialPortOutputDefault() {
    String output = "output";
    EasyMock.expect(computeRpcMock.getSerialPortOutput(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), null, EMPTY_RPC_OPTIONS)).andReturn(output);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(output, compute.getSerialPortOutput(INSTANCE_ID));
  }

  @Test
  public void testSerialPortOutputFromPort_Null() {
    EasyMock.expect(computeRpcMock.getSerialPortOutput(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), 2, EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getSerialPortOutput(INSTANCE_ID, 2));
  }

  @Test
  public void testSerialPortOutputDefault_Null() {
    EasyMock.expect(computeRpcMock.getSerialPortOutput(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), null, EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.getSerialPortOutput(INSTANCE_ID));
  }

  @Test
  public void testResetInstance_Operation() {
    EasyMock.expect(computeRpcMock.reset(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.reset(INSTANCE_ID));
  }

  @Test
  public void testResetInstanceWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.reset(eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.reset(INSTANCE_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testResetInstance_Null() {
    EasyMock.expect(computeRpcMock.reset(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.reset(INSTANCE_ID));
  }

  @Test
  public void testSetDiskAutodelete_Operation() {
    EasyMock.expect(computeRpcMock.setDiskAutoDelete(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), "device", true, EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.setDiskAutoDelete(INSTANCE_ID, "device", true));
  }

  @Test
  public void testSetDiskAutodeleteWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.setDiskAutoDelete(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq("device"), eq(true), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation =
        compute.setDiskAutoDelete(INSTANCE_ID, "device", true, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testSetDiskAutodelete_Null() {
    EasyMock.expect(computeRpcMock.setDiskAutoDelete(INSTANCE_ID.getZone(),
        INSTANCE_ID.getInstance(), "device", false, EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.setDiskAutoDelete(INSTANCE_ID, "device", false));
  }

  @Test
  public void testSetMachineType_Operation() {
    EasyMock.expect(computeRpcMock.setMachineType(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        MACHINE_TYPE_ID.getSelfLink(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation,
        compute.setMachineType(INSTANCE_ID, MachineTypeId.of("zone", "type")));
  }

  @Test
  public void testSetMachineTypeWithOptions_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.setMachineType(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq(MACHINE_TYPE_ID.getSelfLink()), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.setMachineType(INSTANCE_ID, MachineTypeId.of("zone", "type"),
        OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testSetMachineType_Null() {
    EasyMock.expect(computeRpcMock.setMachineType(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        MACHINE_TYPE_ID.getSelfLink(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.setMachineType(INSTANCE_ID, MachineTypeId.of("zone", "type")));
  }

  @Test
  public void testSetMetadata_Operation() {
    Metadata metadata = Metadata.newBuilder()
        .add("key", "value")
        .setFingerprint("fingerprint")
        .build();
    EasyMock.expect(computeRpcMock.setMetadata(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        metadata.toPb(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.setMetadata(INSTANCE_ID, metadata));
  }

  @Test
  public void testSetMetadataWithOptions_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    Metadata metadata = Metadata.newBuilder()
        .add("key", "value")
        .setFingerprint("fingerprint")
        .build();
    EasyMock.expect(computeRpcMock.setMetadata(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq(metadata.toPb()), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.setMetadata(INSTANCE_ID, metadata, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testSetMetadata_Null() {
    Metadata metadata = Metadata.newBuilder()
        .add("key", "value")
        .setFingerprint("fingerprint")
        .build();
    EasyMock.expect(computeRpcMock.setMetadata(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        metadata.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.setMetadata(INSTANCE_ID, metadata));
  }

  @Test
  public void testSetSchedulingOptions_Operation() {
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    EasyMock.expect(computeRpcMock.setScheduling(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        schedulingOptions.toPb(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.setSchedulingOptions(INSTANCE_ID, schedulingOptions));
  }

  @Test
  public void testSetSchedulingOptionsWithOptions_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    EasyMock.expect(computeRpcMock.setScheduling(eq(INSTANCE_ID.getZone()),
        eq(INSTANCE_ID.getInstance()), eq(schedulingOptions.toPb()), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation =
        compute.setSchedulingOptions(INSTANCE_ID, schedulingOptions, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testSetSchedulingOptions_Null() {
    SchedulingOptions schedulingOptions =
        SchedulingOptions.standard(true, SchedulingOptions.Maintenance.MIGRATE);
    EasyMock.expect(computeRpcMock.setScheduling(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        schedulingOptions.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.setSchedulingOptions(INSTANCE_ID, schedulingOptions));
  }

  @Test
  public void testTags_Operation() {
    Tags tags = Tags.of("tag1", "tag2");
    EasyMock.expect(computeRpcMock.setTags(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        tags.toPb(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.setTags(INSTANCE_ID, tags));
  }

  @Test
  public void testSetTagsWithOptions_Operation() {
    Tags tags = Tags.of("tag1", "tag2");
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.setTags(eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()),
        eq(tags.toPb()), capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.setTags(INSTANCE_ID, tags, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testSetTags_Null() {
    Tags tags = Tags.of("tag1", "tag2");
    EasyMock.expect(computeRpcMock.setTags(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        tags.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.setTags(INSTANCE_ID, tags));
  }

  @Test
  public void testStartInstance_Operation() {
    EasyMock.expect(computeRpcMock.start(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.start(INSTANCE_ID));
  }

  @Test
  public void testStartInstanceWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.start(eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.start(INSTANCE_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testStartInstance_Null() {
    EasyMock.expect(computeRpcMock.start(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.start(INSTANCE_ID));
  }

  @Test
  public void testStopInstance_Operation() {
    EasyMock.expect(computeRpcMock.stop(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertEquals(zoneOperation, compute.stop(INSTANCE_ID));
  }

  @Test
  public void testStopInstanceWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.stop(eq(INSTANCE_ID.getZone()), eq(INSTANCE_ID.getInstance()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    Operation operation = compute.stop(INSTANCE_ID, OPERATION_OPTION_FIELDS);
    String selector =
        (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testStopInstance_Null() {
    EasyMock.expect(computeRpcMock.stop(INSTANCE_ID.getZone(), INSTANCE_ID.getInstance(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.getService();
    assertNull(compute.stop(INSTANCE_ID));
  }

  @Test
  public void testRetryableException() {
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andThrow(new ComputeException(500, "InternalError"))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute =
        options.toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings()).build()
            .getService();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID);
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andThrow(new ComputeException(501, exceptionMessage));
    EasyMock.replay(computeRpcMock);
    compute =
        options.toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings()).build()
            .getService();
    thrown.expect(ComputeException.class);
    thrown.expectMessage(exceptionMessage);
    compute.getDiskType(DISK_TYPE_ID);
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(computeRpcMock.getDiskType(
        DISK_TYPE_ID.getZone(), DISK_TYPE_ID.getType(), EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(computeRpcMock);
    compute =
        options.toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings()).build()
            .getService();
    thrown.expect(ComputeException.class);
    thrown.expectMessage(exceptionMessage);
    compute.getDiskType(DISK_TYPE_ID);
  }
}
