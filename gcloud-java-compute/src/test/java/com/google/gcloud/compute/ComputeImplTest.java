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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.gcloud.Page;
import com.google.gcloud.RetryParams;
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

  // Empty ComputeRpc options
  private static final Map<ComputeRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // DiskType options
  private static final Compute.DiskTypeOption DISK_TYPE_OPTION_FIELDS =
      Compute.DiskTypeOption.fields(Compute.DiskTypeField.ID, Compute.DiskTypeField.DESCRIPTION);

  // DiskType list options
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_PAGE_TOKEN =
      Compute.DiskTypeListOption.startPageToken("cursor");
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_MAX_RESULTS =
      Compute.DiskTypeListOption.maxResults(42L);
  private static final Map<ComputeRpc.Option, ?> DISK_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L);

  // MachineType options
  private static final Compute.MachineTypeOption MACHINE_TYPE_OPTION_FIELDS =
      Compute.MachineTypeOption.fields(Compute.MachineTypeField.ID,
          Compute.MachineTypeField.DESCRIPTION);

  // MachineType list options
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_PAGE_TOKEN =
      Compute.MachineTypeListOption.startPageToken("cursor");
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_MAX_RESULTS =
      Compute.MachineTypeListOption.maxResults(42L);
  private static final Map<ComputeRpc.Option, ?> MACHINE_TYPE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L);

  // Region options
  private static final Compute.RegionOption REGION_OPTION_FIELDS =
      Compute.RegionOption.fields(Compute.RegionField.ID, Compute.RegionField.DESCRIPTION);

  // Region list options
  private static final Compute.RegionListOption REGION_LIST_PAGE_TOKEN =
      Compute.RegionListOption.startPageToken("cursor");
  private static final Compute.RegionListOption REGION_LIST_MAX_RESULTS =
      Compute.RegionListOption.maxResults(42L);
  private static final Map<ComputeRpc.Option, ?> REGION_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L);

  // Zone options
  private static final Compute.ZoneOption ZONE_OPTION_FIELDS =
      Compute.ZoneOption.fields(Compute.ZoneField.ID, Compute.ZoneField.DESCRIPTION);

  // Zone list options
  private static final Compute.ZoneListOption ZONE_LIST_PAGE_TOKEN =
      Compute.ZoneListOption.startPageToken("cursor");
  private static final Compute.ZoneListOption ZONE_LIST_MAX_RESULTS =
      Compute.ZoneListOption.maxResults(42L);
  private static final Map<ComputeRpc.Option, ?> ZONE_LIST_OPTIONS = ImmutableMap.of(
      ComputeRpc.Option.PAGE_TOKEN, "cursor",
      ComputeRpc.Option.MAX_RESULTS, 42L);

  // License options
  private static final Compute.LicenseOption LICENSE_OPTION_FIELDS =
      Compute.LicenseOption.fields(Compute.LicenseField.CHARGES_USE_FEE);

  private ComputeOptions options;
  private ComputeRpcFactory rpcFactoryMock;
  private ComputeRpc computeRpcMock;
  private Compute compute;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(ComputeRpcFactory.class);
    computeRpcMock = EasyMock.createMock(ComputeRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(ComputeOptions.class)))
        .andReturn(computeRpcMock).times(1);
    EasyMock.replay(rpcFactoryMock);
    options = ComputeOptions.builder()
        .projectId(PROJECT)
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
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
        DISK_TYPE_LIST_PAGE_TOKEN);
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
    Page<DiskType> page =
        compute.listDiskTypes(DISK_TYPE_LIST_MAX_RESULTS, DISK_TYPE_LIST_PAGE_TOKEN);
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
        MACHINE_TYPE_LIST_MAX_RESULTS, MACHINE_TYPE_LIST_PAGE_TOKEN);
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
    Page<MachineType> page =
        compute.listMachineTypes(MACHINE_TYPE_LIST_MAX_RESULTS, MACHINE_TYPE_LIST_PAGE_TOKEN);
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
    Page<Region> page = compute.listRegions(REGION_LIST_MAX_RESULTS, REGION_LIST_PAGE_TOKEN);
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
    Page<Zone> page = compute.listZones(ZONE_LIST_MAX_RESULTS, ZONE_LIST_PAGE_TOKEN);
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
}
