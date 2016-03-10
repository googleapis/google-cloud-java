/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
import com.google.gcloud.compute.Compute.DiskTypeAggregatedListOption;
import com.google.gcloud.compute.Compute.DiskTypeFilter;
import com.google.gcloud.compute.Compute.DiskTypeListOption;
import com.google.gcloud.compute.Compute.DiskTypeOption;
import com.google.gcloud.compute.Compute.LicenseOption;
import com.google.gcloud.compute.Compute.MachineTypeAggregatedListOption;
import com.google.gcloud.compute.Compute.MachineTypeFilter;
import com.google.gcloud.compute.Compute.MachineTypeListOption;
import com.google.gcloud.compute.Compute.MachineTypeOption;
import com.google.gcloud.compute.Compute.OperationFilter;
import com.google.gcloud.compute.Compute.OperationListOption;
import com.google.gcloud.compute.Compute.OperationOption;
import com.google.gcloud.compute.Compute.RegionFilter;
import com.google.gcloud.compute.Compute.RegionListOption;
import com.google.gcloud.compute.Compute.RegionOption;
import com.google.gcloud.compute.Compute.ZoneFilter;
import com.google.gcloud.compute.Compute.ZoneListOption;
import com.google.gcloud.compute.Compute.ZoneOption;
import com.google.gcloud.compute.Operation.OperationError;
import com.google.gcloud.compute.Operation.OperationWarning;
import com.google.gcloud.compute.Operation.Status;
import com.google.gcloud.compute.Zone.MaintenanceWindow;
import com.google.gcloud.spi.ComputeRpc;
import com.google.gcloud.spi.ComputeRpc.Tuple;
import com.google.gcloud.spi.ComputeRpcFactory;

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
  private static final MaintenanceWindow WINDOW1 = new MaintenanceWindow("NAME1", "DESCRIPTION1",
      1453293420000L, 1453293480000L);
  private static final MaintenanceWindow WINDOW2 = new MaintenanceWindow("NAME2", "DESCRIPTION2",
      1453293420000L, 1453293480000L);
  private static final List<MaintenanceWindow> WINDOWS = ImmutableList.of(WINDOW1, WINDOW2);
  private static final Zone ZONE = Zone.builder()
      .zoneId(ZONE_ID)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(ZONE_STATUS)
      .maintenanceWindows(WINDOWS)
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

  // Empty ComputeRpc options
  private static final Map<ComputeRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // DiskType options
  private static final DiskTypeOption DISK_TYPE_OPTION_FIELDS =
      DiskTypeOption.fields(Compute.DiskTypeField.ID, Compute.DiskTypeField.DESCRIPTION);

  // DiskType list options
  private static final DiskTypeFilter DISK_TYPE_FILTER =
      DiskTypeFilter.equals(Compute.DiskTypeField.DESCRIPTION, "someDescription");
  private static final DiskTypeListOption DISK_TYPE_LIST_PAGE_TOKEN =
      DiskTypeListOption.startPageToken("cursor");
  private static final DiskTypeListOption DISK_TYPE_LIST_MAX_RESULTS =
      DiskTypeListOption.maxResults(42L);
  private static final DiskTypeListOption DISK_TYPE_LIST_FILTER =
      DiskTypeListOption.filter(DISK_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> DISK_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "description eq someDescription");

  // DiskType aggregated list options
  private static final DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      DiskTypeAggregatedListOption.startPageToken("cursor");
  private static final DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_MAX_RESULTS =
      DiskTypeAggregatedListOption.maxResults(42L);
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
      MachineTypeListOption.startPageToken("cursor");
  private static final MachineTypeListOption MACHINE_TYPE_LIST_MAX_RESULTS =
      MachineTypeListOption.maxResults(42L);
  private static final MachineTypeListOption MACHINE_TYPE_LIST_FILTER =
      MachineTypeListOption.filter(MACHINE_TYPE_FILTER);
  private static final Map<ComputeRpc.Option, ?> MACHINE_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "maximumPersistentDisks ne 42");

  // MachineType aggregated list options
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_PAGE_TOKEN =
      MachineTypeAggregatedListOption.startPageToken("cursor");
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_MAX_RESULTS =
      MachineTypeAggregatedListOption.maxResults(42L);
  private static final MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_FILTER =
      MachineTypeAggregatedListOption.filter(MACHINE_TYPE_FILTER);

  // Region options
  private static final RegionOption REGION_OPTION_FIELDS =
      RegionOption.fields(Compute.RegionField.ID, Compute.RegionField.DESCRIPTION);

  // Region list options
  private static final RegionFilter REGION_FILTER =
      RegionFilter.equals(Compute.RegionField.ID, "someId");
  private static final RegionListOption REGION_LIST_PAGE_TOKEN =
      RegionListOption.startPageToken("cursor");
  private static final RegionListOption REGION_LIST_MAX_RESULTS =
      RegionListOption.maxResults(42L);
  private static final RegionListOption REGION_LIST_FILTER =
      RegionListOption.filter(REGION_FILTER);
  private static final Map<ComputeRpc.Option, ?> REGION_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "id eq someId");

  // Zone options
  private static final ZoneOption ZONE_OPTION_FIELDS =
      ZoneOption.fields(Compute.ZoneField.ID, Compute.ZoneField.DESCRIPTION);

  // Zone list options
  private static final ZoneFilter ZONE_FILTER =
      ZoneFilter.notEquals(Compute.ZoneField.NAME, "someName");
  private static final ZoneListOption ZONE_LIST_PAGE_TOKEN =
      ZoneListOption.startPageToken("cursor");
  private static final ZoneListOption ZONE_LIST_MAX_RESULTS = ZoneListOption.maxResults(42L);
  private static final ZoneListOption ZONE_LIST_FILTER = ZoneListOption.filter(ZONE_FILTER);
  private static final Map<ComputeRpc.Option, ?> ZONE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "name ne someName");

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
      OperationListOption.startPageToken("cursor");
  private static final OperationListOption OPERATION_LIST_MAX_RESULTS =
      OperationListOption.maxResults(42L);
  private static final OperationListOption OPERATION_LIST_FILTER =
      OperationListOption.filter(OPERATION_FILTER);
  private static final Map<ComputeRpc.Option, ?> OPERATION_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L,
      ComputeRpc.Option.FILTER, "progress ne 0");

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
        .creationTimestamp(CREATION_TIMESTAMP)
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
        .creationTimestamp(CREATION_TIMESTAMP)
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
        .creationTimestamp(CREATION_TIMESTAMP)
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
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_ID.zone(), DISK_TYPE_LIST_MAX_RESULTS,
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
    Page<DiskType> page = compute.listDiskTypes(DISK_TYPE_AGGREGATED_LIST_MAX_RESULTS,
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
        MACHINE_TYPE_LIST_MAX_RESULTS, MACHINE_TYPE_LIST_PAGE_TOKEN, MACHINE_TYPE_LIST_FILTER);
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
    Page<MachineType> page = compute.listMachineTypes(MACHINE_TYPE_AGGREGATED_LIST_MAX_RESULTS,
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
    Page<Region> page = compute.listRegions(REGION_LIST_MAX_RESULTS, REGION_LIST_PAGE_TOKEN,
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
        compute.listZones(ZONE_LIST_MAX_RESULTS, ZONE_LIST_PAGE_TOKEN, ZONE_LIST_FILTER);
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
  public void testGetGlobalOperation() {
    EasyMock.expect(
        computeRpcMock.getGlobalOperation(GLOBAL_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(globalOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(GLOBAL_OPERATION_ID);
    assertEquals(globalOperation, operation);
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(computeRpcMock.listGlobalOperations(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(computeRpcMock.listGlobalOperations(OPERATION_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listGlobalOperations(OPERATION_LIST_MAX_RESULTS,
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(
        computeRpcMock.listRegionOperations(REGION_OPERATION_ID.region(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listRegionOperations(REGION_OPERATION_ID.region(),
        OPERATION_LIST_MAX_RESULTS, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
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
        ZONE_OPERATION_ID.operation(), EMPTY_RPC_OPTIONS))
        .andReturn(zoneOperation.toPb());
    EasyMock.replay(computeRpcMock);
    compute = options.service();
    Operation operation = compute.get(ZONE_OPERATION_ID);
    assertEquals(zoneOperation, operation);
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone());
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(operationList.toArray(), Iterables.toArray(page.values(), Operation.class));
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
        Tuple.of(cursor, Iterables.transform(operationList,
            new Function<Operation, com.google.api.services.compute.model.Operation>() {
              @Override
              public com.google.api.services.compute.model.Operation apply(Operation operation) {
                return operation.toPb();
              }
            }));
    EasyMock.expect(
        computeRpcMock.listZoneOperations(ZONE_OPERATION_ID.zone(), OPERATION_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(computeRpcMock);
    Page<Operation> page = compute.listZoneOperations(ZONE_OPERATION_ID.zone(),
        OPERATION_LIST_MAX_RESULTS, OPERATION_LIST_PAGE_TOKEN, OPERATION_LIST_FILTER);
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
