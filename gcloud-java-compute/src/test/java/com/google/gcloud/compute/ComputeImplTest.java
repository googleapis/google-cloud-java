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

import static com.google.gcloud.compute.spi.ComputeRpc.Option.FILTER;
import static com.google.gcloud.compute.spi.ComputeRpc.Option.MAX_RESULTS;
import static com.google.gcloud.compute.spi.ComputeRpc.Option.PAGE_TOKEN;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.gcloud.Page;
import com.google.gcloud.RetryParams;
import com.google.gcloud.compute.Compute.AddressAggregatedListOption;
import com.google.gcloud.compute.Compute.AddressFilter;
import com.google.gcloud.compute.Compute.AddressListOption;
import com.google.gcloud.compute.Compute.AddressOption;
import com.google.gcloud.compute.Compute.DiskAggregatedListOption;
import com.google.gcloud.compute.Compute.DiskField;
import com.google.gcloud.compute.Compute.DiskFilter;
import com.google.gcloud.compute.Compute.DiskListOption;
import com.google.gcloud.compute.Compute.DiskOption;
import com.google.gcloud.compute.Compute.DiskTypeAggregatedListOption;
import com.google.gcloud.compute.Compute.DiskTypeFilter;
import com.google.gcloud.compute.Compute.DiskTypeListOption;
import com.google.gcloud.compute.Compute.DiskTypeOption;
import com.google.gcloud.compute.Compute.ImageField;
import com.google.gcloud.compute.Compute.ImageFilter;
import com.google.gcloud.compute.Compute.ImageListOption;
import com.google.gcloud.compute.Compute.ImageOption;
import com.google.gcloud.compute.Compute.LicenseOption;
import com.google.gcloud.compute.Compute.MachineTypeAggregatedListOption;
import com.google.gcloud.compute.Compute.MachineTypeFilter;
import com.google.gcloud.compute.Compute.MachineTypeListOption;
import com.google.gcloud.compute.Compute.MachineTypeOption;
import com.google.gcloud.compute.Compute.NetworkField;
import com.google.gcloud.compute.Compute.NetworkFilter;
import com.google.gcloud.compute.Compute.NetworkListOption;
import com.google.gcloud.compute.Compute.NetworkOption;
import com.google.gcloud.compute.Compute.OperationFilter;
import com.google.gcloud.compute.Compute.OperationListOption;
import com.google.gcloud.compute.Compute.OperationOption;
import com.google.gcloud.compute.Compute.RegionFilter;
import com.google.gcloud.compute.Compute.RegionListOption;
import com.google.gcloud.compute.Compute.RegionOption;
import com.google.gcloud.compute.Compute.SnapshotFilter;
import com.google.gcloud.compute.Compute.SnapshotListOption;
import com.google.gcloud.compute.Compute.SnapshotOption;
import com.google.gcloud.compute.Compute.SubnetworkAggregatedListOption;
import com.google.gcloud.compute.Compute.SubnetworkField;
import com.google.gcloud.compute.Compute.SubnetworkFilter;
import com.google.gcloud.compute.Compute.SubnetworkListOption;
import com.google.gcloud.compute.Compute.SubnetworkOption;
import com.google.gcloud.compute.Compute.ZoneFilter;
import com.google.gcloud.compute.Compute.ZoneListOption;
import com.google.gcloud.compute.Compute.ZoneOption;
import com.google.gcloud.compute.Operation.OperationError;
import com.google.gcloud.compute.Operation.OperationWarning;
import com.google.gcloud.compute.Operation.Status;
import com.google.gcloud.compute.spi.ComputeRpc;
import com.google.gcloud.compute.spi.ComputeRpc.Tuple;
import com.google.gcloud.compute.spi.ComputeRpcFactory;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Map;

public class ComputeImplTest {

  private static final String PROJECT = "project";
  private static final String ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final String VALID_DISK_SIZE = "10GB-10TB";
  private static final Long DEFAULT_DISK_SIZE_GB = 10L;
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final DiskType DISK_TYPE = DiskType.builder()
      .id(ID)
      .diskTypeId(DISK_TYPE_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .validDiskSize(VALID_DISK_SIZE)
      .defaultDiskSizeGb(DEFAULT_DISK_SIZE_GB)
      .build();
  private static final MachineTypeId MACHINE_TYPE_ID = MachineTypeId.of("project", "zone", "type");
  private static final Integer GUEST_CPUS = 1;
  private static final Integer MEMORY_MB = 2;
  private static final List<Integer> SCRATCH_DISKS = ImmutableList.of(3);
  private static final Integer MAXIMUM_PERSISTENT_DISKS = 4;
  private static final Long MAXIMUM_PERSISTENT_DISKS_SIZE_GB = 5L;
  private static final MachineType MACHINE_TYPE = MachineType.builder()
      .id(ID)
      .machineTypeId(MACHINE_TYPE_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .cpus(GUEST_CPUS)
      .memoryMb(MEMORY_MB)
      .scratchDisksSizeGb(SCRATCH_DISKS)
      .maximumPersistentDisks(MAXIMUM_PERSISTENT_DISKS)
      .maximumPersistentDisksSizeGb(MAXIMUM_PERSISTENT_DISKS_SIZE_GB)
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
      .regionId(REGION_ID)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(REGION_STATUS)
      .zones(ZONES)
      .quotas(QUOTAS)
      .build();
  private static final ZoneId ZONE_ID = ZoneId.of("project", "zone");
  private static final Zone.Status ZONE_STATUS = Zone.Status.DOWN;
  private static final Zone ZONE = Zone.builder()
      .zoneId(ZONE_ID)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(ZONE_STATUS)
      .region(REGION_ID)
      .build();
  private static final LicenseId LICENSE_ID = LicenseId.of("project", "license");
  private static final Boolean CHARGES_USE_FEE = true;
  private static final License LICENSE = new License(LICENSE_ID, CHARGES_USE_FEE);
  private static final OperationError OPERATION_ERROR1 =
      new OperationError("code1", "location1", "message1");
  private static final OperationError OPERATION_ERROR2 =
      new OperationError("code2", "location2", "message2");
  private static final OperationWarning OPERATION_WARNING1 =
      new OperationWarning("code1", "message1", ImmutableMap.of("k1", "v1"));
  private static final OperationWarning OPERATION_WARNING2 =
      new OperationWarning("code2", "location2", ImmutableMap.of("k2", "v2"));
  private static final String CLIENT_OPERATION_ID = "clientOperationId";
  private static final String OPERATION_TYPE = "delete";
  private static final String TARGET_LINK = "targetLink";
  private static final String TARGET_ID = "42";
  private static final Status STATUS = Status.DONE;
  private static final String STATUS_MESSAGE = "statusMessage";
  private static final String USER = "user";
  private static final Integer PROGRESS = 100;
  private static final Long INSERT_TIME = 1453293540000L;
  private static final Long START_TIME = 1453293420000L;
  private static final Long END_TIME = 1453293480000L;
  private static final List<OperationError> ERRORS =
      ImmutableList.of(OPERATION_ERROR1, OPERATION_ERROR2);
  private static final List<OperationWarning> WARNINGS =
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
  private static final AddressInfo REGION_ADDRESS = AddressInfo.builder(REGION_ADDRESS_ID).build();
  private static final AddressInfo GLOBAL_ADDRESS = AddressInfo.builder(GLOBAL_ADDRESS_ID).build();
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final SnapshotId SNAPSHOT_ID = SnapshotId.of("project", "snapshot");
  private static final SnapshotInfo SNAPSHOT = SnapshotInfo.of(SNAPSHOT_ID, DISK_ID);
  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final ImageInfo IMAGE = ImageInfo.of(IMAGE_ID, DiskImageConfiguration.of(DISK_ID));
  private static final DeprecationStatus<ImageId> DEPRECATION_STATUS =
      DeprecationStatus.builder(DeprecationStatus.Status.DEPRECATED, IMAGE_ID).build();
  private static final DiskInfo DISK =
      DiskInfo.of(DISK_ID, StandardDiskConfiguration.of(DISK_TYPE_ID));
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final SubnetworkId SUBNETWORK_ID = SubnetworkId.of("project", "region", "network");
  private static final SubnetworkInfo SUBNETWORK =
      SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, "192.168.0.0/16");
  private static final NetworkInfo NETWORK =
      NetworkInfo.of(NETWORK_ID, StandardNetworkConfiguration.of("192.168.0.0/16"));

  // Empty ComputeRpc options
  private static final Map<ComputeRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // DiskType options
  private static final DiskTypeOption DISK_TYPE_OPTION_FIELDS =
      DiskTypeOption.fields(Compute.DiskTypeField.ID, Compute.DiskTypeField.DESCRIPTION);

  // DiskType list options
  private static final DiskTypeFilter DISK_TYPE_FILTER =
      DiskTypeFilter.equals(Compute.DiskTypeField.DESCRIPTION, "someDescription");
  private static final DiskTypeListOption DISK_TYPE_LIST_PAGE_TOKEN =
      DiskTypeListOption.pageToken("cursor");
  private static final DiskTypeListOption DISK_TYPE_LIST_PAGE_SIZE =
      DiskTypeListOption.pageSize(42L);
  private static final DiskTypeListOption DISK_TYPE_LIST_FILTER =
      DiskTypeListOption.filter(DISK_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> DISK_TYPE_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "description eq someDescription");

  // DiskType aggregated list options
  private static final DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      DiskTypeAggregatedListOption.pageToken("cursor");
  private static final DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_PAGE_SIZE =
      DiskTypeAggregatedListOption.pageSize(42L);
  private static final DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_FILTER =
      DiskTypeAggregatedListOption.filter(DISK_TYPE_FILTER);

  // MachineType options
  private static final MachineTypeOption MACHINE_TYPE_OPTION_FIELDS =
      MachineTypeOption.fields(Compute.MachineTypeField.ID,
          Compute.MachineTypeField.DESCRIPTION);

  // MachineType list options
  private static final MachineTypeFilter MACHINE_TYPE_FILTER =
      MachineTypeFilter.notEquals(Compute.MachineTypeField.MAXIMUM_PERSISTENT_DISKS, 42L);
  private static final MachineTypeListOption MACHINE_TYPE_LIST_PAGE_TOKEN =
      MachineTypeListOption.pageToken("cursor");
  private static final MachineTypeListOption MACHINE_TYPE_LIST_PAGE_SIZE =
      MachineTypeListOption.pageSize(42L);
  private static final MachineTypeListOption MACHINE_TYPE_LIST_FILTER =
      MachineTypeListOption.filter(MACHINE_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> MACHINE_TYPE_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "maximumPersistentDisks ne 42");

  // MachineType aggregated list options
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      MachineTypeAggregatedListOption.pageToken("cursor");
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_PAGE_SIZE =
      MachineTypeAggregatedListOption.pageSize(42L);
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_FILTER =
      MachineTypeAggregatedListOption.filter(MACHINE_TYPE_FILTER);

  // Region options
  private static final RegionOption REGION_OPTION_FIELDS =
      RegionOption.fields(Compute.RegionField.ID, Compute.RegionField.DESCRIPTION);

  // Region list options
  private static final RegionFilter REGION_FILTER =
      RegionFilter.equals(Compute.RegionField.ID, "someId");
  private static final RegionListOption REGION_LIST_PAGE_TOKEN =
      RegionListOption.pageToken("cursor");
  private static final RegionListOption REGION_LIST_PAGE_SIZE =
      RegionListOption.pageSize(42L);
  private static final RegionListOption REGION_LIST_FILTER =
      RegionListOption.filter(REGION_FILTER);
  private static final Map<ComputeRpc.Option, ?> REGION_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "id eq someId");

  // Zone options
  private static final ZoneOption ZONE_OPTION_FIELDS =
      ZoneOption.fields(Compute.ZoneField.ID, Compute.ZoneField.DESCRIPTION);

  // Zone list options
  private static final ZoneFilter ZONE_FILTER =
      ZoneFilter.notEquals(Compute.ZoneField.NAME, "someName");
  private static final ZoneListOption ZONE_LIST_PAGE_TOKEN =
      ZoneListOption.pageToken("cursor");
  private static final ZoneListOption ZONE_LIST_PAGE_SIZE = ZoneListOption.pageSize(42L);
  private static final ZoneListOption ZONE_LIST_FILTER = ZoneListOption.filter(ZONE_FILTER);
  private static final Map<ComputeRpc.Option, ?> ZONE_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "name ne someName");

  // License options
  private static final LicenseOption LICENSE_OPTION_FIELDS =
      LicenseOption.fields(Compute.LicenseField.CHARGES_USE_FEE);

  // Operation options
  private static final OperationOption OPERATION_OPTION_FIELDS =
      OperationOption.fields(Compute.OperationField.ID, Compute.OperationField.DESCRIPTION);

  // Operation list options
  private static final OperationFilter OPERATION_FILTER =
      OperationFilter.notEquals(Compute.OperationField.PROGRESS, 0);
  private static final OperationListOption OPERATION_LIST_PAGE_TOKEN =
      OperationListOption.pageToken("cursor");
  private static final OperationListOption OPERATION_LIST_PAGE_SIZE =
      OperationListOption.pageSize(42L);
  private static final OperationListOption OPERATION_LIST_FILTER =
      OperationListOption.filter(OPERATION_FILTER);
  private static final Map<ComputeRpc.Option, ?> OPERATION_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "progress ne 0");

  // Address options
  private static final AddressOption ADDRESS_OPTION_FIELDS =
      AddressOption.fields(Compute.AddressField.ID, Compute.AddressField.DESCRIPTION);

  // Address list options
  private static final AddressFilter ADDRESS_FILTER =
      AddressFilter.notEquals(Compute.AddressField.REGION, "someRegion");
  private static final AddressListOption ADDRESS_LIST_PAGE_TOKEN =
      AddressListOption.pageToken("cursor");
  private static final AddressListOption ADDRESS_LIST_PAGE_SIZE = AddressListOption.pageSize(42L);
  private static final AddressListOption ADDRESS_LIST_FILTER =
      AddressListOption.filter(ADDRESS_FILTER);
  private static final Map<ComputeRpc.Option, ?> ADDRESS_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "region ne someRegion");

  // Address aggregated list options
  private static final AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_PAGE_TOKEN =
      AddressAggregatedListOption.pageToken("cursor");
  private static final AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_PAGE_SIZE =
      AddressAggregatedListOption.pageSize(42L);
  private static final AddressAggregatedListOption ADDRESS_AGGREGATED_LIST_FILTER =
      AddressAggregatedListOption.filter(ADDRESS_FILTER);

  // Snapshot options
  private static final SnapshotOption SNAPSHOT_OPTION_FIELDS =
      SnapshotOption.fields(Compute.SnapshotField.ID, Compute.SnapshotField.DESCRIPTION);

  // Snapshot list options
  private static final SnapshotFilter SNAPSHOT_FILTER =
      SnapshotFilter.equals(Compute.SnapshotField.DISK_SIZE_GB, 500L);
  private static final SnapshotListOption SNAPSHOT_LIST_PAGE_TOKEN =
      SnapshotListOption.pageToken("cursor");
  private static final SnapshotListOption SNAPSHOT_LIST_PAGE_SIZE =
      SnapshotListOption.pageSize(42L);
  private static final SnapshotListOption SNAPSHOT_LIST_FILTER =
      SnapshotListOption.filter(SNAPSHOT_FILTER);
  private static final Map<ComputeRpc.Option, ?> SNAPSHOT_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "diskSizeGb eq 500");

  // Image options
  private static final ImageOption IMAGE_OPTION_FIELDS =
      ImageOption.fields(ImageField.ID, ImageField.DESCRIPTION);

  // Image list options
  private static final ImageFilter IMAGE_FILTER =
      ImageFilter.notEquals(ImageField.DISK_SIZE_GB, 500L);
  private static final ImageListOption IMAGE_LIST_PAGE_TOKEN = ImageListOption.pageToken("cursor");
  private static final ImageListOption IMAGE_LIST_PAGE_SIZE = ImageListOption.pageSize(42L);
  private static final ImageListOption IMAGE_LIST_FILTER = ImageListOption.filter(IMAGE_FILTER);
  private static final Map<ComputeRpc.Option, ?> IMAGE_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "diskSizeGb ne 500");

  // Disk options
  private static final DiskOption DISK_OPTION_FIELDS =
      DiskOption.fields(DiskField.ID, DiskField.DESCRIPTION);

  // Disk list options
  private static final DiskFilter DISK_FILTER = DiskFilter.notEquals(DiskField.SIZE_GB, 500L);
  private static final DiskListOption DISK_LIST_PAGE_TOKEN = DiskListOption.pageToken("cursor");
  private static final DiskListOption DISK_LIST_PAGE_SIZE = DiskListOption.pageSize(42L);
  private static final DiskListOption DISK_LIST_FILTER = DiskListOption.filter(DISK_FILTER);
  private static final Map<ComputeRpc.Option, ?> DISK_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "sizeGb ne 500");

  // Disk aggregated list options
  private static final DiskAggregatedListOption DISK_AGGREGATED_LIST_PAGE_TOKEN =
      DiskAggregatedListOption.pageToken("cursor");
  private static final DiskAggregatedListOption DISK_AGGREGATED_LIST_PAGE_SIZE =
      DiskAggregatedListOption.pageSize(42L);
  private static final DiskAggregatedListOption DISK_AGGREGATED_LIST_FILTER =
      DiskAggregatedListOption.filter(DISK_FILTER);

  // Subnetwork options
  private static final SubnetworkOption SUBNETWORK_OPTION_FIELDS =
      SubnetworkOption.fields(SubnetworkField.ID, SubnetworkField.DESCRIPTION);

  // Subnetwork list options
  private static final SubnetworkFilter SUBNETWORK_FILTER =
      SubnetworkFilter.equals(SubnetworkField.IP_CIDR_RANGE, "192.168.0.0/16");
  private static final SubnetworkListOption SUBNETWORK_LIST_PAGE_TOKEN =
      SubnetworkListOption.pageToken("cursor");
  private static final SubnetworkListOption SUBNETWORK_LIST_PAGE_SIZE =
      SubnetworkListOption.pageSize(42L);
  private static final SubnetworkListOption SUBNETWORK_LIST_FILTER =
      SubnetworkListOption.filter(SUBNETWORK_FILTER);
  private static final Map<ComputeRpc.Option, ?> SUBNETWORK_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "ipCidrRange eq 192.168.0.0/16");

  // Subnetwork aggregated list options
  private static final SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_PAGE_TOKEN =
      SubnetworkAggregatedListOption.pageToken("cursor");
  private static final SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_PAGE_SIZE =
      SubnetworkAggregatedListOption.pageSize(42L);
  private static final SubnetworkAggregatedListOption SUBNETWORK_AGGREGATED_LIST_FILTER =
      SubnetworkAggregatedListOption.filter(SUBNETWORK_FILTER);

  // Network options
  private static final NetworkOption NETWORK_OPTION_FIELDS =
      NetworkOption.fields(NetworkField.ID, NetworkField.DESCRIPTION);

  // Network list options
  private static final NetworkFilter NETWORK_FILTER =
      NetworkFilter.equals(NetworkField.IPV4_RANGE, "192.168.0.0/16");
  private static final NetworkListOption NETWORK_LIST_PAGE_TOKEN =
      NetworkListOption.pageToken("cursor");
  private static final NetworkListOption NETWORK_LIST_PAGE_SIZE =
      NetworkListOption.pageSize(42L);
  private static final NetworkListOption NETWORK_LIST_FILTER =
      NetworkListOption.filter(NETWORK_FILTER);
  private static final Map<ComputeRpc.Option, ?> NETWORK_LIST_OPTIONS = ImmutableMap.of(
      PAGE_TOKEN, "cursor",
      MAX_RESULTS, 42L,
      FILTER, "IPv4Range eq 192.168.0.0/16");

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
    options = ComputeOptions.builder()
        .projectId(PROJECT)
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
        .build();
    Compute otherService = options.toBuilder().build().service();
    globalOperation = new Operation.Builder(otherService)
        .id(ID)
        .operationId(GLOBAL_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
    zoneOperation = new Operation.Builder(otherService)
        .id(ID)
        .operationId(ZONE_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
    regionOperation = new Operation.Builder(otherService)
        .id(ID)
        .operationId(REGION_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, computeRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertSame(options, compute.options());
  }

  @Test
  public void testGetDiskType() {
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType());
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testGetDiskType_Null() {
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType()));
  }

  @Test
  public void testGetDiskTypeFromDiskTypeId() {
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID);
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testGetDiskTypeWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.getDiskType(
            eq(DISK_TYPE_ID.zone()), eq(DISK_TYPE_ID.diskType()), capture(capturedOptions)))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    DiskType diskType =
        compute.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), DISK_TYPE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DISK_TYPE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testListDiskTypes() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testListDiskTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    ImmutableList<DiskType> nextDiskTypeList = ImmutableList.of(DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskTypeList, DiskType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.zone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextDiskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testListEmptyDiskTypes() {
    ImmutableList<com.google.api.services.compute.model.DiskType> diskTypes = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.DiskType>>of(null, diskTypes);
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.zone());
    assertNull(page.nextPageCursor());
    assertArrayEquals(diskTypes.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testListDiskTypesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_ID.zone(), DISK_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.zone(), DISK_TYPE_LIST_PAGE_SIZE,
        DISK_TYPE_LIST_PAGE_TOKEN, DISK_TYPE_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypes() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    ImmutableList<DiskType> nextDiskTypeList = ImmutableList.of(DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskTypeList, DiskType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listDiskTypes(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextDiskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testAggregatedListEmptyDiskTypes() {
    ImmutableList<com.google.api.services.compute.model.DiskType> diskTypes = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.DiskType>>of(null, diskTypes);
    EasyMock.expect(computeRpcMock.listDiskTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<DiskType> page = compute.listDiskTypes();
    assertNull(page.nextPageCursor());
    assertArrayEquals(diskTypes.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testAggregatedListDiskTypesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<DiskType> diskTypeList = ImmutableList.of(DISK_TYPE, DISK_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.DiskType>> result =
        Tuple.of(cursor, Iterables.transform(diskTypeList, DiskType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDiskTypes(DISK_TYPE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_AGGREGATED_LIST_PAGE_SIZE,
            DISK_TYPE_AGGREGATED_LIST_PAGE_TOKEN, DISK_TYPE_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskTypeList.toArray(), Iterables.toArray(page.values(), DiskType.class));
  }

  @Test
  public void testGetMachineType() {
    EasyMock.expect(
        computeRpcMock.getMachineType(
            MACHINE_TYPE_ID.zone(), MACHINE_TYPE_ID.machineType(), EMPTY_RPC_OPTIONS))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    MachineType machineType =
        compute.getMachineType(MACHINE_TYPE_ID.zone(), MACHINE_TYPE_ID.machineType());
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testGetMachineType_Null() {
    EasyMock.expect(
        computeRpcMock.getMachineType(
            MACHINE_TYPE_ID.zone(), MACHINE_TYPE_ID.machineType(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getMachineType(MACHINE_TYPE_ID.zone(), MACHINE_TYPE_ID.machineType()));
  }

  @Test
  public void testGetMachineTypeFromMachineTypeId() {
    EasyMock.expect(computeRpcMock.getMachineType(
            MACHINE_TYPE_ID.zone(), MACHINE_TYPE_ID.machineType(), EMPTY_RPC_OPTIONS))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    MachineType machineType = compute.getMachineType(MACHINE_TYPE_ID);
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testGetMachineTypeWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.getMachineType(eq(MACHINE_TYPE_ID.zone()), eq(MACHINE_TYPE_ID.machineType()),
            capture(capturedOptions)))
        .andReturn(MACHINE_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    MachineType machineType = compute.getMachineType(MACHINE_TYPE_ID.zone(),
        MACHINE_TYPE_ID.machineType(), MACHINE_TYPE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DISK_TYPE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(MACHINE_TYPE, machineType);
  }

  @Test
  public void testListMachineTypes() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(), Iterables.toArray(page.values(),
        MachineType.class));
  }

  @Test
  public void testListMachineTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    ImmutableList<MachineType> nextMachineTypeList = ImmutableList.of(MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextMachineTypeList, MachineType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.zone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextMachineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testListEmptyMachineTypes() {
    ImmutableList<com.google.api.services.compute.model.MachineType> machineTypes =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.MachineType>>of(null,
            machineTypes);
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.zone());
    assertNull(page.nextPageCursor());
    assertArrayEquals(machineTypes.toArray(), Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testListMachineTypesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listMachineTypes(MACHINE_TYPE_ID.zone(), MACHINE_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_ID.zone(),
        MACHINE_TYPE_LIST_PAGE_SIZE, MACHINE_TYPE_LIST_PAGE_TOKEN, MACHINE_TYPE_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypes() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(), Iterables.toArray(page.values(),
        MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    ImmutableList<MachineType> nextMachineTypeList = ImmutableList.of(MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextMachineTypeList, MachineType.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listMachineTypes(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextMachineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testAggregatedListEmptyMachineTypes() {
    ImmutableList<com.google.api.services.compute.model.MachineType> machineTypes =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.MachineType>>of(null,
            machineTypes);
    EasyMock.expect(computeRpcMock.listMachineTypes(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<MachineType> page = compute.listMachineTypes();
    assertNull(page.nextPageCursor());
    assertArrayEquals(machineTypes.toArray(), Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testAggregatedListMachineTypesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<MachineType> machineTypeList = ImmutableList.of(MACHINE_TYPE, MACHINE_TYPE);
    Tuple<String, Iterable<com.google.api.services.compute.model.MachineType>> result =
        Tuple.of(cursor, Iterables.transform(machineTypeList, MachineType.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listMachineTypes(MACHINE_TYPE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_AGGREGATED_LIST_PAGE_SIZE,
        MACHINE_TYPE_AGGREGATED_LIST_PAGE_TOKEN, MACHINE_TYPE_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(machineTypeList.toArray(),
        Iterables.toArray(page.values(), MachineType.class));
  }

  @Test
  public void testGetRegion() {
    EasyMock.expect(computeRpcMock.getRegion(REGION_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(REGION.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Region region = compute.getRegion(REGION_ID.region());
    assertEquals(REGION, region);
  }

  @Test
  public void testGetRegion_Null() {
    EasyMock.expect(computeRpcMock.getRegion(REGION_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getRegion(REGION_ID.region()));
  }

  @Test
  public void testGetRegionWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegion(eq(REGION_ID.region()), capture(capturedOptions)))
        .andReturn(REGION.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Region region = compute.getRegion(REGION_ID.region(), REGION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(REGION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(REGION, region);
  }

  @Test
  public void testListRegions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.values(), Region.class));
  }

  @Test
  public void testListRegionsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    ImmutableList<Region> nextRegionList = ImmutableList.of(REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextRegionList, Region.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listRegions(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.values(), Region.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextRegionList.toArray(), Iterables.toArray(page.values(), Region.class));
  }

  @Test
  public void testListEmptyRegions() {
    ImmutableList<com.google.api.services.compute.model.Region> regions = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Region>>of(null,
            regions);
    EasyMock.expect(computeRpcMock.listRegions(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Region> page = compute.listRegions();
    assertNull(page.nextPageCursor());
    assertArrayEquals(regions.toArray(), Iterables.toArray(page.values(), Region.class));
  }

  @Test
  public void testListRegionsWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Region> regionList = ImmutableList.of(REGION, REGION);
    Tuple<String, Iterable<com.google.api.services.compute.model.Region>> result =
        Tuple.of(cursor, Iterables.transform(regionList, Region.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listRegions(REGION_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Region> page = compute.listRegions(REGION_LIST_PAGE_SIZE, REGION_LIST_PAGE_TOKEN,
        REGION_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(regionList.toArray(), Iterables.toArray(page.values(), Region.class));
  }

  @Test
  public void testGetZone() {
    EasyMock.expect(computeRpcMock.getZone(ZONE_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(ZONE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Zone zone = compute.getZone(ZONE_ID.zone());
    assertEquals(ZONE, zone);
  }

  @Test
  public void testGetZone_Null() {
    EasyMock.expect(computeRpcMock.getZone(ZONE_ID.zone(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getZone(ZONE_ID.zone()));
  }

  @Test
  public void testGetZoneWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getZone(eq(ZONE_ID.zone()), capture(capturedOptions)))
        .andReturn(ZONE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Zone zone = compute.getZone(ZONE_ID.zone(), ZONE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ZONE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(ZONE, zone);
  }

  @Test
  public void testListZones() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page = compute.listZones();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.values(), Zone.class));
  }

  @Test
  public void testListZonesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    ImmutableList<Zone> nextZoneList = ImmutableList.of(ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextZoneList, Zone.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listZones(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page = compute.listZones();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.values(), Zone.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextZoneList.toArray(), Iterables.toArray(page.values(), Zone.class));
  }

  @Test
  public void testListEmptyZones() {
    ImmutableList<com.google.api.services.compute.model.Zone> zones = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Zone>>of(null, zones);
    EasyMock.expect(computeRpcMock.listZones(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Zone> page = compute.listZones();
    assertNull(page.nextPageCursor());
    assertArrayEquals(zones.toArray(), Iterables.toArray(page.values(), Zone.class));
  }

  @Test
  public void testListZonesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Zone> zoneList = ImmutableList.of(ZONE, ZONE);
    Tuple<String, Iterable<com.google.api.services.compute.model.Zone>> result =
        Tuple.of(cursor, Iterables.transform(zoneList, Zone.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listZones(ZONE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Zone> page =
        compute.listZones(ZONE_LIST_PAGE_SIZE, ZONE_LIST_PAGE_TOKEN, ZONE_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(zoneList.toArray(), Iterables.toArray(page.values(), Zone.class));
  }

  @Test
  public void testGetLicenseFromString() {
    EasyMock.expect(computeRpcMock.getLicense(PROJECT, LICENSE_ID.license(), EMPTY_RPC_OPTIONS))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    License license = compute.getLicense(LICENSE_ID.license());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromString_Null() {
    EasyMock.expect(computeRpcMock.getLicense(PROJECT, LICENSE_ID.license(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getLicense(LICENSE_ID.license()));
  }

  @Test
  public void testGetLicenseFromStringWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.getLicense(eq(PROJECT), eq(LICENSE_ID.license()), capture(capturedOptions)))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    License license = compute.getLicense(LICENSE_ID.license(),  LICENSE_OPTION_FIELDS);
    assertEquals(LICENSE, license);
    String selector = (String) capturedOptions.getValue().get(LICENSE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("chargesUseFee"));
    assertEquals(22, selector.length());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromIdWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(computeRpcMock.getLicense(eq(licenseId.project()), eq(licenseId.license()),
        capture(capturedOptions)))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    License license = compute.getLicense(licenseId,  LICENSE_OPTION_FIELDS);
    assertEquals(LICENSE, license);
    String selector = (String) capturedOptions.getValue().get(LICENSE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("chargesUseFee"));
    assertEquals(22, selector.length());
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromId() {
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(
        computeRpcMock.getLicense(licenseId.project(), licenseId.license(), EMPTY_RPC_OPTIONS))
        .andReturn(LICENSE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    License license = compute.getLicense(licenseId);
    assertEquals(LICENSE, license);
  }

  @Test
  public void testGetLicenseFromId_Null() {
    LicenseId licenseId = LicenseId.of("project2", "license2");
    EasyMock.expect(
        computeRpcMock.getLicense(licenseId.project(), licenseId.license(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getLicense(licenseId));
  }

  @Test
  public void testGetGlobalOperation() {
    EasyMock.expect(
        computeRpcMock.getGlobalOperation(GLOBAL_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.get(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetGlobalOperation_Null() {
    EasyMock.expect(
        computeRpcMock.getGlobalOperation(GLOBAL_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetGlobalOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getGlobalOperation(
             eq(GLOBAL_OPERATION_ID.operation()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(GLOBAL_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testListGlobalOperations() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListGlobalOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listGlobalOperations(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListEmptyGlobalOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Operation> page = compute.listGlobalOperations();
    assertNull(page.nextPageCursor());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListGlobalOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(globalOperation, globalOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalOperations(OPERATION_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations(OPERATION_LIST_PAGE_SIZE,
        OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testDeleteGlobalOperation_True() {
    EasyMock.expect(computeRpcMock.deleteGlobalOperation(GLOBAL_OPERATION_ID.operation()))
        .andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertTrue(compute.delete(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testDeleteGlobalOperation_False() {
    EasyMock.expect(computeRpcMock.deleteGlobalOperation(GLOBAL_OPERATION_ID.operation()))
        .andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertFalse(compute.delete(GLOBAL_OPERATION_ID));
  }

  @Test
  public void testGetRegionOperation() {
    EasyMock.expect(computeRpcMock.getRegionOperation(REGION_OPERATION_ID.region(),
            REGION_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(REGION_OPERATION_ID);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetRegionOperation_Null() {
    EasyMock.expect(computeRpcMock.getRegionOperation(REGION_OPERATION_ID.region(),
        REGION_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(REGION_OPERATION_ID);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetRegionOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegionOperation(eq(REGION_OPERATION_ID.region()),
            eq(REGION_OPERATION_ID.operation()), capture(capturedOptions)))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(REGION_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testListRegionOperations() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListRegionOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(),
        EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(),
        nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListEmptyRegionOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region());
    assertNull(page.nextPageCursor());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListRegionOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(regionOperation, regionOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region(),
        OPERATION_LIST_PAGE_SIZE, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testDeleteRegionOperation_True() {
    EasyMock.expect(computeRpcMock.deleteRegionOperation(REGION_OPERATION_ID.region(),
        REGION_OPERATION_ID.operation())).andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertTrue(compute.delete(REGION_OPERATION_ID));
  }

  @Test
  public void testDeleteRegionOperation_False() {
    EasyMock.expect(computeRpcMock.deleteRegionOperation(REGION_OPERATION_ID.region(),
        REGION_OPERATION_ID.operation())).andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertFalse(compute.delete(REGION_OPERATION_ID));
  }

  @Test
  public void testGetZoneOperation() {
    EasyMock.expect(computeRpcMock.getZoneOperation(ZONE_OPERATION_ID.zone(),
        ZONE_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(ZONE_OPERATION_ID);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testGetZoneOperation_Null() {
    EasyMock.expect(computeRpcMock.getZoneOperation(ZONE_OPERATION_ID.zone(),
        ZONE_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(ZONE_OPERATION_ID));
  }

  @Test
  public void testGetZoneOperationWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getZoneOperation(eq(ZONE_OPERATION_ID.zone()),
        eq(ZONE_OPERATION_ID.operation()), capture(capturedOptions)))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(ZONE_OPERATION_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testListZoneOperations() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListZoneOperationsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    ImmutableList<Operation> nextOperationList = ImmutableList.of(zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextOperationList, OPERATION_TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextOperationList.toArray(),
        Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListEmptyZoneOperations() {
    ImmutableList<com.google.api.services.compute.model.Operation> operations = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Operation>>of(null,
            operations);
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone());
    assertNull(page.nextPageCursor());
    assertArrayEquals(operations.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testListZoneOperationsWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Operation> operationList = ImmutableList.of(zoneOperation, zoneOperation);
    Tuple<String, Iterable<com.google.api.services.compute.model.Operation>> result =
        Tuple.of(cursor, Iterables.transform(operationList, OPERATION_TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone(),
        OPERATION_LIST_PAGE_SIZE, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
  }

  @Test
  public void testDeleteZoneOperation_True() {
    EasyMock.expect(computeRpcMock.deleteZoneOperation(ZONE_OPERATION_ID.zone(),
        ZONE_OPERATION_ID.operation())).andReturn(true);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertTrue(compute.delete(ZONE_OPERATION_ID));
  }

  @Test
  public void testDeleteZoneOperation_False() {
    EasyMock.expect(computeRpcMock.deleteZoneOperation(ZONE_OPERATION_ID.zone(),
        ZONE_OPERATION_ID.operation())).andReturn(false);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertFalse(compute.delete(ZONE_OPERATION_ID));
  }

  @Test
  public void testGetGlobalAddress() {
    EasyMock.expect(computeRpcMock.getGlobalAddress(GLOBAL_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS))
        .andReturn(GLOBAL_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Address address = compute.get(GLOBAL_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)), address);
  }

  @Test
  public void testGetGlobalAddress_Null() {
    EasyMock.expect(computeRpcMock.getGlobalAddress(GLOBAL_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testGetGlobalAddressWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getGlobalAddress(
        eq(GLOBAL_ADDRESS_ID.address()), capture(capturedOptions)))
        .andReturn(GLOBAL_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Address address = compute.get(GLOBAL_ADDRESS_ID, ADDRESS_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ADDRESS_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddress() {
    EasyMock.expect(computeRpcMock.getRegionAddress(REGION_ADDRESS_ID.region(),
        REGION_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS)).andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Address address = compute.get(REGION_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddress_Null() {
    EasyMock.expect(computeRpcMock.getRegionAddress(REGION_ADDRESS_ID.region(),
        REGION_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS)).andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Address address = compute.get(REGION_ADDRESS_ID);
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testGetRegionAddressWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getRegionAddress(eq(REGION_ADDRESS_ID.region()),
        eq(REGION_ADDRESS_ID.address()), capture(capturedOptions)))
        .andReturn(REGION_ADDRESS.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Address address = compute.get(REGION_ADDRESS_ID, ADDRESS_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ADDRESS_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)), address);
  }

  @Test
  public void testDeleteGlobalAddress_Operation() {
    EasyMock
        .expect(computeRpcMock.deleteGlobalAddress(GLOBAL_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.delete(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testDeleteGlobalAddressWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteGlobalAddress(eq(GLOBAL_ADDRESS_ID.address()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.delete(GLOBAL_ADDRESS_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteGlobalAddress_Null() {
    EasyMock
        .expect(computeRpcMock.deleteGlobalAddress(GLOBAL_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.delete(GLOBAL_ADDRESS_ID));
  }

  @Test
  public void testDeleteRegionAddress_Operation() {
    EasyMock.expect(computeRpcMock.deleteRegionAddress(REGION_ADDRESS_ID.region(),
        REGION_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(regionOperation, compute.delete(REGION_ADDRESS_ID));
  }

  @Test
  public void testDeleteRegionAddressWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteRegionAddress(eq(REGION_ADDRESS_ID.region()),
        eq(REGION_ADDRESS_ID.address()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.delete(REGION_ADDRESS_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteRegionAddress_Null() {
    EasyMock.expect(computeRpcMock.deleteRegionAddress(REGION_ADDRESS_ID.region(),
        REGION_ADDRESS_ID.address(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.delete(REGION_ADDRESS_ID));
  }

  @Test
  public void testListGlobalAddresses() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListGlobalAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextAddressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListEmptyGlobalAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null, addresses);
    EasyMock.expect(computeRpcMock.listGlobalAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Address> page = compute.listGlobalAddresses();
    assertNull(page.nextPageCursor());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListGlobalAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(GLOBAL_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listGlobalAddresses(ADDRESS_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listGlobalAddresses(ADDRESS_LIST_PAGE_SIZE,
        ADDRESS_LIST_PAGE_TOKEN, ADDRESS_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListRegionAddresses() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListRegionAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.region(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextAddressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListEmptyRegionAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null, addresses);
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.region());
    assertNull(page.nextPageCursor());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testListRegionAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(
        computeRpcMock.listRegionAddresses(REGION_ADDRESS_ID.region(), ADDRESS_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listRegionAddresses(REGION_ADDRESS_ID.region(),
        ADDRESS_LIST_PAGE_SIZE, ADDRESS_LIST_PAGE_TOKEN, ADDRESS_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testAggregatedListAddresses() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testAggregatedListAddressesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    ImmutableList<Address> nextAddressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextAddressList, AddressInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listAddresses(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextAddressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testAggregatedListEmptyAddresses() {
    ImmutableList<com.google.api.services.compute.model.Address> addresses = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Address>>of(null, addresses);
    EasyMock.expect(computeRpcMock.listAddresses(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Page<Address> page = compute.listAddresses();
    assertNull(page.nextPageCursor());
    assertArrayEquals(addresses.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testAggregatedListAddressesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Address> addressList = ImmutableList.of(
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)),
        new Address(compute, new AddressInfo.BuilderImpl(REGION_ADDRESS)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Address>> result =
        Tuple.of(cursor, Iterables.transform(addressList, AddressInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listAddresses(ADDRESS_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Address> page = compute.listAddresses(ADDRESS_AGGREGATED_LIST_PAGE_SIZE,
        ADDRESS_AGGREGATED_LIST_PAGE_TOKEN, ADDRESS_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(addressList.toArray(), Iterables.toArray(page.values(), Address.class));
  }

  @Test
  public void testCreateGlobalAddress() {
    EasyMock.expect(computeRpcMock.createGlobalAddress(GLOBAL_ADDRESS.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    AddressId incompleteId = GlobalAddressId.of("address");
    Operation operation =
        compute.create(GLOBAL_ADDRESS.toBuilder().addressId(incompleteId).build());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateGlobalAddressWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        computeRpcMock.createGlobalAddress(eq(GLOBAL_ADDRESS.toPb()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(GLOBAL_ADDRESS, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateRegionAddress() {
    EasyMock.expect(computeRpcMock.createRegionAddress(REGION_ADDRESS_ID.region(),
        REGION_ADDRESS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    AddressId incompleteId = RegionAddressId.of("region", "address");
    Operation operation =
        compute.create(REGION_ADDRESS.toBuilder().addressId(incompleteId).build());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateRegionAddressWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createRegionAddress(eq(REGION_ADDRESS_ID.region()),
        eq(REGION_ADDRESS.toPb()), capture(capturedOptions))).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(REGION_ADDRESS, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateSnapshot() {
    EasyMock.expect(computeRpcMock.createSnapshot(DISK_ID.zone(), DISK_ID.disk(),
        SNAPSHOT_ID.snapshot(), null, EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(SNAPSHOT);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testCreateSnapshotWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createSnapshot(eq(DISK_ID.zone()), eq(DISK_ID.disk()),
        eq(SNAPSHOT_ID.snapshot()), EasyMock.<String>isNull(), capture(capturedOptions)))
            .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(SNAPSHOT, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testGetSnapshot() {
    EasyMock.expect(computeRpcMock.getSnapshot(SNAPSHOT_ID.snapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(SNAPSHOT.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Snapshot snapshot = compute.getSnapshot(SNAPSHOT_ID.snapshot());
    assertEquals(new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)), snapshot);
  }

  @Test
  public void testGetSnapshot_Null() {
    EasyMock.expect(computeRpcMock.getSnapshot(SNAPSHOT_ID.snapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getSnapshot(SNAPSHOT_ID.snapshot()));
  }

  @Test
  public void testGetSnapshotWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getSnapshot(eq(SNAPSHOT_ID.snapshot()),
        capture(capturedOptions))).andReturn(SNAPSHOT.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Snapshot snapshot = compute.getSnapshot(SNAPSHOT_ID.snapshot(), SNAPSHOT_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(SNAPSHOT_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)), snapshot);
  }

  @Test
  public void testDeleteSnapshot_Operation() {
    EasyMock.expect(computeRpcMock.deleteSnapshot(SNAPSHOT_ID.snapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.deleteSnapshot(SNAPSHOT_ID.snapshot()));
  }

  @Test
  public void testDeleteSnapshotWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteSnapshot(eq(SNAPSHOT_ID.snapshot()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.deleteSnapshot(SNAPSHOT_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteSnapshot_Null() {
    EasyMock.expect(computeRpcMock.deleteSnapshot(SNAPSHOT_ID.snapshot(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.deleteSnapshot(SNAPSHOT_ID));
  }

  @Test
  public void testListSnapshots() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.values(), Snapshot.class));
  }

  @Test
  public void testListSnapshotsNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    ImmutableList<Snapshot> nextSnapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextSnapshotList, SnapshotInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listSnapshots(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.values(), Snapshot.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextSnapshotList.toArray(), Iterables.toArray(page.values(), Snapshot.class));
  }

  @Test
  public void testListEmptySnapshots() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Snapshot> snapshots = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Snapshot>>of(null, snapshots);
    EasyMock.expect(computeRpcMock.listSnapshots(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots();
    assertNull(page.nextPageCursor());
    assertArrayEquals(snapshots.toArray(), Iterables.toArray(page.values(), Snapshot.class));
  }

  @Test
  public void testListSnapshotsWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Snapshot> snapshotList = ImmutableList.of(
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)),
        new Snapshot(compute, new SnapshotInfo.BuilderImpl(SNAPSHOT)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Snapshot>> result =
        Tuple.of(cursor, Iterables.transform(snapshotList, SnapshotInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSnapshots(SNAPSHOT_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Snapshot> page = compute.listSnapshots(SNAPSHOT_LIST_PAGE_SIZE, SNAPSHOT_LIST_PAGE_TOKEN,
        SNAPSHOT_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(snapshotList.toArray(), Iterables.toArray(page.values(), Snapshot.class));
  }

  @Test
  public void testCreateImage() {
    EasyMock.expect(computeRpcMock.createImage(IMAGE.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(IMAGE);
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testCreateImageWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createImage(eq(IMAGE.toPb()), capture(capturedOptions)))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(IMAGE, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testGetImage() {
    EasyMock.expect(
        computeRpcMock.getImage(IMAGE_ID.project(), IMAGE_ID.image(), EMPTY_RPC_OPTIONS))
            .andReturn(IMAGE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Image image = compute.get(IMAGE_ID);
    assertEquals(new Image(compute, new ImageInfo.BuilderImpl(IMAGE)), image);
  }

  @Test
  public void testGetImage_Null() {
    EasyMock.expect(
        computeRpcMock.getImage(IMAGE_ID.project(), IMAGE_ID.image(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(IMAGE_ID));
  }

  @Test
  public void testGetImageWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getImage(eq(IMAGE_ID.project()), eq(IMAGE_ID.image()),
        capture(capturedOptions))).andReturn(IMAGE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Image image = compute.get(IMAGE_ID, IMAGE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(IMAGE_OPTION_FIELDS.rpcOption());
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
    EasyMock.expect(computeRpcMock.deleteImage(IMAGE_ID.project(), IMAGE_ID.image(),
        EMPTY_RPC_OPTIONS)).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.delete(IMAGE_ID));
  }

  @Test
  public void testDeleteImageWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteImage(eq(PROJECT), eq(IMAGE_ID.image()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.delete(ImageId.of("image"), OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteImage_Null() {
    EasyMock.expect(computeRpcMock.deleteImage(IMAGE_ID.project(), IMAGE_ID.image(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.delete(IMAGE_ID));
  }

  @Test
  public void testDeprecateImage_Operation() {
    EasyMock.expect(computeRpcMock.deprecateImage(IMAGE_ID.project(), IMAGE_ID.image(),
        DEPRECATION_STATUS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.deprecate(IMAGE_ID, DEPRECATION_STATUS));
  }

  @Test
  public void testDeprecateImageWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deprecateImage(eq(PROJECT), eq(IMAGE_ID.image()),
        eq(DEPRECATION_STATUS.toPb()), capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation =
        compute.deprecate(ImageId.of("image"), DEPRECATION_STATUS, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeprecateImage_Null() {
    EasyMock.expect(computeRpcMock.deprecateImage(IMAGE_ID.project(), IMAGE_ID.image(),
        DEPRECATION_STATUS.toPb(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.deprecate(IMAGE_ID, DEPRECATION_STATUS));
  }

  @Test
  public void testListImages() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListImagesNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    ImmutableList<Image> nextImageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextImageList, ImageInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.values(), Image.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextImageList.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListImagesForProject() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages("otherProject", EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("otherProject");
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListEmptyImages() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Image> images = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Image>>of(null, images);
    EasyMock.expect(computeRpcMock.listImages(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages();
    assertNull(page.nextPageCursor());
    assertArrayEquals(images.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListEmptyImagesForProject() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Image> images = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Image>>of(null, images);
    EasyMock.expect(computeRpcMock.listImages("otherProject", EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("otherProject");
    assertNull(page.nextPageCursor());
    assertArrayEquals(images.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListImagesWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages(PROJECT, IMAGE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages(IMAGE_LIST_PAGE_SIZE, IMAGE_LIST_PAGE_TOKEN,
        IMAGE_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testListImagesForProjectWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Image> imageList = ImmutableList.of(
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)),
        new Image(compute, new ImageInfo.BuilderImpl(IMAGE)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Image>> result =
        Tuple.of(cursor, Iterables.transform(imageList, ImageInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listImages("other", IMAGE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Image> page = compute.listImages("other", IMAGE_LIST_PAGE_SIZE, IMAGE_LIST_PAGE_TOKEN,
        IMAGE_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(imageList.toArray(), Iterables.toArray(page.values(), Image.class));
  }

  @Test
  public void testGetDisk() {
    EasyMock.expect(computeRpcMock.getDisk(DISK_ID.zone(), DISK_ID.disk(), EMPTY_RPC_OPTIONS))
        .andReturn(DISK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Disk disk = compute.get(DISK_ID);
    assertEquals(new Disk(compute, new DiskInfo.BuilderImpl(DISK)), disk);
  }

  @Test
  public void testGetDisk_Null() {
    EasyMock.expect(computeRpcMock.getDisk(DISK_ID.zone(), DISK_ID.disk(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(DISK_ID));
  }

  @Test
  public void testGetDiskWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getDisk(eq(DISK_ID.zone()), eq(DISK_ID.disk()),
        capture(capturedOptions))).andReturn(DISK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Disk disk = compute.get(DISK_ID, DISK_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DISK_OPTION_FIELDS.rpcOption());
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
    EasyMock.expect(computeRpcMock.deleteDisk(DISK_ID.zone(), DISK_ID.disk(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(zoneOperation, compute.delete(DISK_ID));
  }

  @Test
  public void testDeleteDiskWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteDisk(eq(DISK_ID.zone()), eq(DISK_ID.disk()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.delete(DISK_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testDeleteDisk_Null() {
    EasyMock.expect(computeRpcMock.deleteDisk(DISK_ID.zone(), DISK_ID.disk(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.delete(DISK_ID));
  }

  @Test
  public void testListDisks() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testListDisksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    ImmutableList<Disk> nextDiskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskList, DiskInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.zone(), EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.zone(), nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextDiskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testListEmptyDisks() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Disk> disks = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Disk>>of(null, disks);
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.zone());
    assertNull(page.nextPageCursor());
    assertArrayEquals(disks.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testListDisksWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_ID.zone(), DISK_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_ID.zone(), DISK_LIST_PAGE_SIZE, DISK_LIST_PAGE_TOKEN,
        DISK_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testAggregatedListDisks() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testAggregatedListDisksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    ImmutableList<Disk> nextDiskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextDiskList, DiskInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listDisks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextDiskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testAggregatedListEmptyDisks() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Disk> diskList = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Disk>>of(null, diskList);
    EasyMock.expect(computeRpcMock.listDisks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks();
    assertNull(page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testAggregatedListDisksWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Disk> diskList = ImmutableList.of(
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)),
        new Disk(compute, new DiskInfo.BuilderImpl(DISK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Disk>> result =
        Tuple.of(cursor, Iterables.transform(diskList, DiskInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listDisks(DISK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Disk> page = compute.listDisks(DISK_AGGREGATED_LIST_PAGE_SIZE,
        DISK_AGGREGATED_LIST_PAGE_TOKEN, DISK_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(diskList.toArray(), Iterables.toArray(page.values(), Disk.class));
  }

  @Test
  public void testCreateDisk() {
    EasyMock.expect(computeRpcMock.createDisk(DISK_ID.zone(), DISK.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    DiskId diskId = DiskId.of("zone", "disk");
    DiskTypeId diskTypeId = DiskTypeId.of("zone", "diskType");
    DiskInfo disk = DISK.toBuilder()
        .diskId(diskId)
        .configuration(StandardDiskConfiguration.of(diskTypeId))
        .build();
    Operation operation = compute.create(disk);
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testCreateDiskWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createDisk(eq(DISK_ID.zone()), eq(DISK.toPb()),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(DISK, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testResizeDisk_Operation() {
    EasyMock.expect(computeRpcMock.resizeDisk(DISK_ID.zone(), DISK_ID.disk(), 42L,
        EMPTY_RPC_OPTIONS)).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(zoneOperation, compute.resize(DISK_ID, 42L));
  }

  @Test
  public void testResizeDiskWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.resizeDisk(eq(DISK_ID.zone()), eq(DISK_ID.disk()), eq(42L),
        capture(capturedOptions))).andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.resize(DISK_ID, 42L, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(zoneOperation, operation);
  }

  @Test
  public void testResizeDisk_Null() {
    EasyMock.expect(computeRpcMock.resizeDisk(DISK_ID.zone(), DISK_ID.disk(), 42L,
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.resize(DISK_ID, 42L));
  }

  @Test
  public void testGetSubnetwork() {
    EasyMock.expect(computeRpcMock.getSubnetwork(SUBNETWORK_ID.region(), SUBNETWORK_ID.subnetwork(),
        EMPTY_RPC_OPTIONS)).andReturn(SUBNETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Subnetwork subnetwork = compute.get(SUBNETWORK_ID);
    assertEquals(new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)), subnetwork);
  }

  @Test
  public void testGetSubnetwork_Null() {
    EasyMock.expect(computeRpcMock.getSubnetwork(SUBNETWORK_ID.region(), SUBNETWORK_ID.subnetwork(),
        EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.get(SUBNETWORK_ID));
  }

  @Test
  public void testGetSubnetworkWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getSubnetwork(eq(SUBNETWORK_ID.region()),
        eq(SUBNETWORK_ID.subnetwork()), capture(capturedOptions))).andReturn(SUBNETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Subnetwork subnetwork = compute.get(SUBNETWORK_ID, SUBNETWORK_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(SUBNETWORK_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)), subnetwork);
  }

  @Test
  public void testDeleteSubnetwork_Operation() {
    EasyMock.expect(computeRpcMock.deleteSubnetwork(SUBNETWORK_ID.region(),
        SUBNETWORK_ID.subnetwork(), EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(regionOperation, compute.delete(SUBNETWORK_ID));
  }

  @Test
  public void testDeleteSubnetworkWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteSubnetwork(eq(SUBNETWORK_ID.region()),
        eq(SUBNETWORK_ID.subnetwork()), capture(capturedOptions)))
        .andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.delete(SUBNETWORK_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testDeleteSubnetwork_Null() {
    EasyMock.expect(computeRpcMock.deleteSubnetwork(SUBNETWORK_ID.region(),
        SUBNETWORK_ID.subnetwork(), EMPTY_RPC_OPTIONS)).andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.delete(SUBNETWORK_ID));
  }

  @Test
  public void testListSubnetworks() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testListSubnetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    ImmutableList<Subnetwork> nextSubnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextSubnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.region(), nextOptions))
        .andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextSubnetworkList.toArray(),
        Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testListEmptySubnetworks() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Subnetwork> subnetworks =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Subnetwork>>of(null,
            subnetworks);
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.region());
    assertNull(page.nextPageCursor());
    assertArrayEquals(subnetworks.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testListSubnetworksWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_ID.region(), SUBNETWORK_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_ID.region(),
        SUBNETWORK_LIST_PAGE_SIZE, SUBNETWORK_LIST_PAGE_TOKEN, SUBNETWORK_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworks() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    ImmutableList<Subnetwork> nextSubnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> nextResult =
        Tuple.of(nextCursor,
            Iterables.transform(nextSubnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listSubnetworks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextSubnetworkList.toArray(),
        Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListEmptySubnetworks() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Subnetwork> subnetworks =
        ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Subnetwork>>of(null,
            subnetworks);
    EasyMock.expect(computeRpcMock.listSubnetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks();
    assertNull(page.nextPageCursor());
    assertArrayEquals(subnetworks.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testAggregatedListSubnetworksWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Subnetwork> subnetworkList = ImmutableList.of(
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)),
        new Subnetwork(compute, new SubnetworkInfo.BuilderImpl(SUBNETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Subnetwork>> result =
        Tuple.of(cursor, Iterables.transform(subnetworkList, SubnetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listSubnetworks(SUBNETWORK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Subnetwork> page = compute.listSubnetworks(SUBNETWORK_AGGREGATED_LIST_PAGE_SIZE,
        SUBNETWORK_AGGREGATED_LIST_PAGE_TOKEN, SUBNETWORK_AGGREGATED_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(subnetworkList.toArray(), Iterables.toArray(page.values(), Subnetwork.class));
  }

  @Test
  public void testCreateSubnetwork() {
    EasyMock.expect(computeRpcMock.createSubnetwork(SUBNETWORK_ID.region(), SUBNETWORK.toPb(),
        EMPTY_RPC_OPTIONS)).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    SubnetworkId subnetworkId = SubnetworkId.of("region", "network");
    NetworkId networkId = NetworkId.of("network");
    SubnetworkInfo subnetwork = SubnetworkInfo.of(subnetworkId, networkId, "192.168.0.0/16");
    Operation operation = compute.create(subnetwork);
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testCreateSubnetworkWithOptions() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.createSubnetwork(eq(SUBNETWORK_ID.region()),
        eq(SUBNETWORK.toPb()), capture(capturedOptions))).andReturn(regionOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.create(SUBNETWORK, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(regionOperation, operation);
  }

  @Test
  public void testGetNetwork() {
    EasyMock.expect(computeRpcMock.getNetwork(NETWORK_ID.network(), EMPTY_RPC_OPTIONS))
        .andReturn(NETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Network network = compute.getNetwork(NETWORK_ID.network());
    assertEquals(new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)), network);
  }

  @Test
  public void testGetNetwork_Null() {
    EasyMock.expect(computeRpcMock.getNetwork(NETWORK_ID.network(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.getNetwork(NETWORK_ID.network()));
  }

  @Test
  public void testGetNetworkWithSelectedFields() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.getNetwork(eq(NETWORK_ID.network()), capture(capturedOptions)))
        .andReturn(NETWORK.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Network network = compute.getNetwork(NETWORK_ID.network(), NETWORK_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(NETWORK_OPTION_FIELDS.rpcOption());
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
    EasyMock.expect(computeRpcMock.deleteNetwork(NETWORK_ID.network(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertEquals(globalOperation, compute.deleteNetwork(NETWORK_ID));
  }

  @Test
  public void testDeleteNetworkWithSelectedFields_Operation() {
    Capture<Map<ComputeRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(computeRpcMock.deleteNetwork(eq(NETWORK_ID.network()),
        capture(capturedOptions))).andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.deleteNetwork(NETWORK_ID, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testDeleteNetwork_Null() {
    EasyMock.expect(computeRpcMock.deleteNetwork(NETWORK_ID.network(), EMPTY_RPC_OPTIONS))
        .andReturn(null);
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    assertNull(compute.deleteNetwork(NETWORK_ID));
  }

  @Test
  public void testListNetworks() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.values(), Network.class));
  }

  @Test
  public void testListNetworksNextPage() {
    String cursor = "cursor";
    String nextCursor = "nextCursor";
    compute = options.service();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    ImmutableList<Network> nextNetworkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> nextResult =
        Tuple.of(nextCursor, Iterables.transform(nextNetworkList, NetworkInfo.TO_PB_FUNCTION));
    Map<ComputeRpc.Option, ?> nextOptions = ImmutableMap.of(PAGE_TOKEN, cursor);
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.expect(computeRpcMock.listNetworks(nextOptions)).andReturn(nextResult);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.values(), Network.class));
    page = page.nextPage();
    assertEquals(nextCursor, page.nextPageCursor());
    assertArrayEquals(nextNetworkList.toArray(), Iterables.toArray(page.values(), Network.class));
  }

  @Test
  public void testListEmptyNetworks() {
    compute = options.service();
    ImmutableList<com.google.api.services.compute.model.Network> networks = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.<String, Iterable<com.google.api.services.compute.model.Network>>of(null, networks);
    EasyMock.expect(computeRpcMock.listNetworks(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks();
    assertNull(page.nextPageCursor());
    assertArrayEquals(networks.toArray(), Iterables.toArray(page.values(), Network.class));
  }

  @Test
  public void testListNetworksWithOptions() {
    String cursor = "cursor";
    compute = options.service();
    ImmutableList<Network> networkList = ImmutableList.of(
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)),
        new Network(compute, new NetworkInfo.BuilderImpl(NETWORK)));
    Tuple<String, Iterable<com.google.api.services.compute.model.Network>> result =
        Tuple.of(cursor, Iterables.transform(networkList, NetworkInfo.TO_PB_FUNCTION));
    EasyMock.expect(computeRpcMock.listNetworks(NETWORK_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Network> page = compute.listNetworks(NETWORK_LIST_PAGE_SIZE, NETWORK_LIST_PAGE_TOKEN,
        NETWORK_LIST_FILTER);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(networkList.toArray(), Iterables.toArray(page.values(), Network.class));
  }

  @Test
  public void testCreateNetwork() {
    EasyMock.expect(computeRpcMock.createNetwork(NETWORK.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
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
    compute = options.service();
    Operation operation = compute.create(NETWORK, OPERATION_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(OPERATION_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("selfLink"));
    assertTrue(selector.contains("id"));
    assertTrue(selector.contains("description"));
    assertEquals(23, selector.length());
    assertEquals(globalOperation, operation);
  }

  @Test
  public void testRetryableException() {
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andThrow(new ComputeException(500, "InternalError"))
        .andReturn(DISK_TYPE.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    DiskType diskType = compute.getDiskType(DISK_TYPE_ID);
    assertEquals(DISK_TYPE, diskType);
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andThrow(new ComputeException(501, exceptionMessage));
    EasyMock.replay(computeRpcMock);
    compute = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    thrown.expect(ComputeException.class);
    thrown.expectMessage(exceptionMessage);
    compute.getDiskType(DISK_TYPE_ID);
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(
        computeRpcMock.getDiskType(DISK_TYPE_ID.zone(), DISK_TYPE_ID.diskType(), EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(computeRpcMock);
    compute = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    thrown.expect(ComputeException.class);
    thrown.expectMessage(exceptionMessage);
    compute.getDiskType(DISK_TYPE_ID);
  }
}
