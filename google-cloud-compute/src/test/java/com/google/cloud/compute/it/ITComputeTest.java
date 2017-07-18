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

package com.google.cloud.compute.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.compute.Address;
import com.google.cloud.compute.AddressId;
import com.google.cloud.compute.AddressInfo;
import com.google.cloud.compute.AttachedDisk;
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.DeprecationStatus;
import com.google.cloud.compute.Disk;
import com.google.cloud.compute.DiskConfiguration;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.DiskImageConfiguration;
import com.google.cloud.compute.DiskInfo;
import com.google.cloud.compute.DiskType;
import com.google.cloud.compute.DiskTypeId;
import com.google.cloud.compute.GlobalAddressId;
import com.google.cloud.compute.Image;
import com.google.cloud.compute.ImageConfiguration;
import com.google.cloud.compute.ImageDiskConfiguration;
import com.google.cloud.compute.ImageId;
import com.google.cloud.compute.ImageInfo;
import com.google.cloud.compute.Instance;
import com.google.cloud.compute.InstanceId;
import com.google.cloud.compute.InstanceInfo;
import com.google.cloud.compute.License;
import com.google.cloud.compute.LicenseId;
import com.google.cloud.compute.MachineType;
import com.google.cloud.compute.MachineTypeId;
import com.google.cloud.compute.Network;
import com.google.cloud.compute.NetworkConfiguration;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.NetworkInfo;
import com.google.cloud.compute.NetworkInterface;
import com.google.cloud.compute.Operation;
import com.google.cloud.compute.Region;
import com.google.cloud.compute.RegionAddressId;
import com.google.cloud.compute.RegionOperationId;
import com.google.cloud.compute.SchedulingOptions;
import com.google.cloud.compute.Snapshot;
import com.google.cloud.compute.SnapshotDiskConfiguration;
import com.google.cloud.compute.SnapshotId;
import com.google.cloud.compute.SnapshotInfo;
import com.google.cloud.compute.StandardDiskConfiguration;
import com.google.cloud.compute.StandardNetworkConfiguration;
import com.google.cloud.compute.StorageImageConfiguration;
import com.google.cloud.compute.SubnetNetworkConfiguration;
import com.google.cloud.compute.Subnetwork;
import com.google.cloud.compute.SubnetworkId;
import com.google.cloud.compute.SubnetworkInfo;
import com.google.cloud.compute.Zone;
import com.google.cloud.compute.ZoneOperationId;
import com.google.cloud.compute.testing.ResourceCleaner;
import com.google.cloud.compute.testing.RemoteComputeHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITComputeTest {

  private static final String REGION = "us-central1";
  private static final String ZONE = "us-central1-a";
  private static final String DISK_TYPE = "local-ssd";
  private static final String MACHINE_TYPE = "f1-micro";
  private static final LicenseId LICENSE_ID = LicenseId.of("ubuntu-os-cloud", "ubuntu-1404-trusty");
  private static final String BASE_RESOURCE_NAME = RemoteComputeHelper.baseResourceName();
  private static final ImageId IMAGE_ID = ImageId.of("debian-cloud", "debian-8-jessie-v20160219");
  private static final String IMAGE_PROJECT = "debian-cloud";

  private static Compute compute;
  private static ResourceCleaner resourceCleaner;


  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteComputeHelper computeHelper = RemoteComputeHelper.create();
    compute = computeHelper.getOptions().getService();
    resourceCleaner = ResourceCleaner.create(compute);
  }

  @AfterClass
  public static void tearDown() {
    resourceCleaner.cleanUp();
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE);
    // assertNotNull(diskType.getGeneratedId());
    assertEquals(ZONE, diskType.getDiskTypeId().getZone());
    assertEquals(DISK_TYPE, diskType.getDiskTypeId().getType());
    assertNotNull(diskType.getCreationTimestamp());
    assertNotNull(diskType.getDescription());
    assertNotNull(diskType.getValidDiskSize());
    assertNotNull(diskType.getDefaultDiskSizeGb());
  }

  @Test
  public void testGetDiskTypeWithSelectedFields() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE,
        Compute.DiskTypeOption.fields(Compute.DiskTypeField.CREATION_TIMESTAMP));
    // assertNotNull(diskType.getGeneratedId());
    assertEquals(ZONE, diskType.getDiskTypeId().getZone());
    assertEquals(DISK_TYPE, diskType.getDiskTypeId().getType());
    assertNotNull(diskType.getCreationTimestamp());
    assertNull(diskType.getDescription());
    assertNull(diskType.getValidDiskSize());
    assertNull(diskType.getDefaultDiskSizeGb());
  }

  @Test
  public void testListDiskTypes() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE);
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.getGeneratedId());
      assertNotNull(diskType.getDiskTypeId());
      assertEquals(ZONE, diskType.getDiskTypeId().getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotNull(diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testListDiskTypesWithSelectedFields() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE,
        Compute.DiskTypeListOption.fields(Compute.DiskTypeField.CREATION_TIMESTAMP));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertNull(diskType.getGeneratedId());
      assertNotNull(diskType.getDiskTypeId());
      assertEquals(ZONE, diskType.getDiskTypeId().getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNull(diskType.getDescription());
      assertNull(diskType.getValidDiskSize());
      assertNull(diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testListDiskTypesWithFilter() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE, Compute.DiskTypeListOption.filter(
        Compute.DiskTypeFilter.equals(Compute.DiskTypeField.DEFAULT_DISK_SIZE_GB, 375)));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.getGeneratedId());
      assertNotNull(diskType.getDiskTypeId());
      assertEquals(ZONE, diskType.getDiskTypeId().getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertEquals(375, (long) diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testAggregatedListDiskTypes() {
    Page<DiskType> diskPage = compute.listDiskTypes();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.getGeneratedId());
      assertNotNull(diskType.getDiskTypeId());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotNull(diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testAggregatedListDiskTypesWithFilter() {
    Page<DiskType> diskPage = compute.listDiskTypes(Compute.DiskTypeAggregatedListOption.filter(
        Compute.DiskTypeFilter.notEquals(Compute.DiskTypeField.DEFAULT_DISK_SIZE_GB, 375)));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.getGeneratedId());
      assertNotNull(diskType.getDiskTypeId());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotEquals(375, (long) diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testGetMachineType() {
    MachineType machineType = compute.getMachineType(ZONE, MACHINE_TYPE);
    assertEquals(ZONE, machineType.getMachineTypeId().getZone());
    assertEquals(MACHINE_TYPE, machineType.getMachineTypeId().getType());
    assertNotNull(machineType.getGeneratedId());
    assertNotNull(machineType.getCreationTimestamp());
    assertNotNull(machineType.getDescription());
    assertNotNull(machineType.getCpus());
    assertNotNull(machineType.getMemoryMb());
    assertNotNull(machineType.getMaximumPersistentDisks());
    assertNotNull(machineType.getMaximumPersistentDisksSizeGb());
  }

  @Test
  public void testGetMachineTypeWithSelectedFields() {
    MachineType machineType = compute.getMachineType(ZONE, MACHINE_TYPE,
        Compute.MachineTypeOption.fields(Compute.MachineTypeField.ID));
    assertEquals(ZONE, machineType.getMachineTypeId().getZone());
    assertEquals(MACHINE_TYPE, machineType.getMachineTypeId().getType());
    assertNotNull(machineType.getGeneratedId());
    assertNull(machineType.getCreationTimestamp());
    assertNull(machineType.getDescription());
    assertNull(machineType.getCpus());
    assertNull(machineType.getMemoryMb());
    assertNull(machineType.getMaximumPersistentDisks());
    assertNull(machineType.getMaximumPersistentDisksSizeGb());
  }

  @Test
  public void testListMachineTypes() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE);
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll().iterator();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.getMachineTypeId());
      assertEquals(ZONE, machineType.getMachineTypeId().getZone());
      assertNotNull(machineType.getGeneratedId());
      assertNotNull(machineType.getCreationTimestamp());
      assertNotNull(machineType.getDescription());
      assertNotNull(machineType.getCpus());
      assertNotNull(machineType.getMemoryMb());
      assertNotNull(machineType.getMaximumPersistentDisks());
      assertNotNull(machineType.getMaximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testListMachineTypesWithSelectedFields() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE,
        Compute.MachineTypeListOption.fields(Compute.MachineTypeField.CREATION_TIMESTAMP));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll().iterator();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.getMachineTypeId());
      assertEquals(ZONE, machineType.getMachineTypeId().getZone());
      assertNull(machineType.getGeneratedId());
      assertNotNull(machineType.getCreationTimestamp());
      assertNull(machineType.getDescription());
      assertNull(machineType.getCpus());
      assertNull(machineType.getMemoryMb());
      assertNull(machineType.getMaximumPersistentDisks());
      assertNull(machineType.getMaximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testListMachineTypesWithFilter() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE,
        Compute.MachineTypeListOption.filter(
            Compute.MachineTypeFilter.equals(Compute.MachineTypeField.GUEST_CPUS, 2)));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll().iterator();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.getMachineTypeId());
      assertEquals(ZONE, machineType.getMachineTypeId().getZone());
      assertNotNull(machineType.getGeneratedId());
      assertNotNull(machineType.getCreationTimestamp());
      assertNotNull(machineType.getDescription());
      assertNotNull(machineType.getCpus());
      assertEquals(2, (long) machineType.getCpus());
      assertNotNull(machineType.getMemoryMb());
      assertNotNull(machineType.getMaximumPersistentDisks());
      assertNotNull(machineType.getMaximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testAggregatedListMachineTypes() {
    Page<MachineType> machinePage = compute.listMachineTypes();
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll().iterator();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.getMachineTypeId());
      assertNotNull(machineType.getGeneratedId());
      assertNotNull(machineType.getCreationTimestamp());
      assertNotNull(machineType.getDescription());
      assertNotNull(machineType.getCpus());
      assertNotNull(machineType.getMemoryMb());
      assertNotNull(machineType.getMaximumPersistentDisks());
      assertNotNull(machineType.getMaximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testAggregatedListMachineTypesWithFilter() {
    Page<MachineType> machinePage =
        compute.listMachineTypes(Compute.MachineTypeAggregatedListOption.filter(
            Compute.MachineTypeFilter.notEquals(Compute.MachineTypeField.GUEST_CPUS, 2)));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll().iterator();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.getMachineTypeId());
      assertNotNull(machineType.getGeneratedId());
      assertNotNull(machineType.getCreationTimestamp());
      assertNotNull(machineType.getDescription());
      assertNotNull(machineType.getCpus());
      assertNotEquals(2, (long) machineType.getCpus());
      assertNotNull(machineType.getMemoryMb());
      assertNotNull(machineType.getMaximumPersistentDisks());
      assertNotNull(machineType.getMaximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testGetLicense() {
    License license = compute.getLicense(LICENSE_ID);
    assertEquals(LICENSE_ID, license.getLicenseId());
    assertNotNull(license.chargesUseFee());
  }

  @Test
  public void testGetLicenseWithSelectedFields() {
    License license = compute.getLicense(LICENSE_ID, Compute.LicenseOption.fields());
    assertEquals(LICENSE_ID, license.getLicenseId());
    assertNull(license.chargesUseFee());
  }

  @Test
  public void testGetRegion() {
    Region region = compute.getRegion(REGION);
    assertEquals(REGION, region.getRegionId().getRegion());
    assertNotNull(region.getDescription());
    assertNotNull(region.getCreationTimestamp());
    assertNotNull(region.getGeneratedId());
    assertNotNull(region.getQuotas());
    assertNotNull(region.getStatus());
    assertNotNull(region.getZones());
  }

  @Test
  public void testGetRegionWithSelectedFields() {
    Region region = compute.getRegion(REGION, Compute.RegionOption.fields(Compute.RegionField.ID));
    assertEquals(REGION, region.getRegionId().getRegion());
    assertNotNull(region.getGeneratedId());
    assertNull(region.getDescription());
    assertNull(region.getCreationTimestamp());
    assertNull(region.getQuotas());
    assertNull(region.getStatus());
    assertNull(region.getZones());
  }

  @Test
  public void testListRegions() {
    Page<Region> regionPage = compute.listRegions();
    Iterator<Region> regionIterator = regionPage.iterateAll().iterator();
    while (regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.getRegionId());
      assertNotNull(region.getDescription());
      assertNotNull(region.getCreationTimestamp());
      assertNotNull(region.getGeneratedId());
      assertNotNull(region.getQuotas());
      assertNotNull(region.getStatus());
      assertNotNull(region.getZones());
    }
  }

  @Test
  public void testListRegionsWithSelectedFields() {
    Page<Region> regionPage =
        compute.listRegions(Compute.RegionListOption.fields(Compute.RegionField.ID));
    Iterator<Region> regionIterator = regionPage.iterateAll().iterator();
    while (regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.getRegionId());
      assertNull(region.getDescription());
      assertNull(region.getCreationTimestamp());
      assertNotNull(region.getGeneratedId());
      assertNull(region.getQuotas());
      assertNull(region.getStatus());
      assertNull(region.getZones());
    }
  }

  @Test
  public void testListRegionsWithFilter() {
    Page<Region> regionPage = compute.listRegions(Compute.RegionListOption.filter(
        Compute.RegionFilter.equals(Compute.RegionField.NAME, REGION)));
    Iterator<Region> regionIterator = regionPage.iterateAll().iterator();
    assertEquals(REGION, regionIterator.next().getRegionId().getRegion());
    assertFalse(regionIterator.hasNext());
  }

  @Test
  public void testGetZone() {
    Zone zone = compute.getZone(ZONE);
    assertEquals(ZONE, zone.getZoneId().getZone());
    assertNotNull(zone.getGeneratedId());
    assertNotNull(zone.getCreationTimestamp());
    assertNotNull(zone.getDescription());
    assertNotNull(zone.getStatus());
    assertNotNull(zone.getRegion());
  }

  @Test
  public void testGetZoneWithSelectedFields() {
    Zone zone = compute.getZone(ZONE, Compute.ZoneOption.fields(Compute.ZoneField.ID));
    assertEquals(ZONE, zone.getZoneId().getZone());
    assertNotNull(zone.getGeneratedId());
    assertNull(zone.getCreationTimestamp());
    assertNull(zone.getDescription());
    assertNull(zone.getStatus());
    assertNull(zone.getRegion());
  }

  @Test
  public void testListZones() {
    Page<Zone> zonePage = compute.listZones();
    Iterator<Zone> zoneIterator = zonePage.iterateAll().iterator();
    while (zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.getZoneId());
      assertNotNull(zone.getGeneratedId());
      assertNotNull(zone.getCreationTimestamp());
      assertNotNull(zone.getDescription());
      assertNotNull(zone.getStatus());
      assertNotNull(zone.getRegion());
    }
  }

  @Test
  public void testListZonesWithSelectedFields() {
    Page<Zone> zonePage = compute.listZones(
        Compute.ZoneListOption.fields(Compute.ZoneField.CREATION_TIMESTAMP));
    Iterator<Zone> zoneIterator = zonePage.iterateAll().iterator();
    while (zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.getZoneId());
      assertNull(zone.getGeneratedId());
      assertNotNull(zone.getCreationTimestamp());
      assertNull(zone.getDescription());
      assertNull(zone.getStatus());
      assertNull(zone.getRegion());
    }
  }

  @Test
  public void testListZonesWithFilter() {
    Page<Zone> zonePage = compute.listZones(
        Compute.ZoneListOption.filter(Compute.ZoneFilter.equals(Compute.ZoneField.NAME, ZONE)));
    Iterator<Zone> zoneIterator = zonePage.iterateAll().iterator();
    assertEquals(ZONE, zoneIterator.next().getZoneId().getZone());
    assertFalse(zoneIterator.hasNext());
  }

  @Test
  public void testListGlobalOperations() {
    Page<Operation> operationPage = compute.listGlobalOperations();
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertNotNull(operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testListGlobalOperationsWithSelectedFields() {
    Page<Operation> operationPage =
        compute.listGlobalOperations(Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertNull(operation.getOperationType());
      assertNull(operation.getTargetLink());
      assertNull(operation.getTargetId());
      assertNull(operation.getOperationType());
      assertNull(operation.getStatus());
      assertNull(operation.getStatusMessage());
      assertNull(operation.getUser());
      assertNull(operation.getProgress());
      assertNull(operation.getDescription());
      assertNull(operation.getInsertTime());
      assertNull(operation.getStartTime());
      assertNull(operation.getEndTime());
      assertNull(operation.getWarnings());
      assertNull(operation.getHttpErrorMessage());
    }
  }

  @Test
  public void testListGlobalOperationsWithFilter() {
    Page<Operation> operationPage = compute.listGlobalOperations(Compute.OperationListOption.filter(
        Compute.OperationFilter.equals(Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertEquals(Operation.Status.DONE, operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testListRegionOperations() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION);
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(REGION, operation.<RegionOperationId>getOperationId().getRegion());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertNotNull(operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testListRegionOperationsWithSelectedFields() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION,
        Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(REGION, operation.<RegionOperationId>getOperationId().getRegion());
      assertNull(operation.getOperationType());
      assertNull(operation.getTargetLink());
      assertNull(operation.getTargetId());
      assertNull(operation.getOperationType());
      assertNull(operation.getStatus());
      assertNull(operation.getStatusMessage());
      assertNull(operation.getUser());
      assertNull(operation.getProgress());
      assertNull(operation.getDescription());
      assertNull(operation.getInsertTime());
      assertNull(operation.getStartTime());
      assertNull(operation.getEndTime());
      assertNull(operation.getWarnings());
      assertNull(operation.getHttpErrorMessage());
    }
  }

  @Test
  public void testListRegionOperationsWithFilter() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION,
        Compute.OperationListOption.filter(Compute.OperationFilter.equals(
            Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(REGION, operation.<RegionOperationId>getOperationId().getRegion());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertEquals(Operation.Status.DONE, operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testListZoneOperations() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE);
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(ZONE, operation.<ZoneOperationId>getOperationId().getZone());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertNotNull(operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testListZoneOperationsWithSelectedFields() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE,
        Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(ZONE, operation.<ZoneOperationId>getOperationId().getZone());
      assertNull(operation.getOperationType());
      assertNull(operation.getTargetLink());
      assertNull(operation.getTargetId());
      assertNull(operation.getOperationType());
      assertNull(operation.getStatus());
      assertNull(operation.getStatusMessage());
      assertNull(operation.getUser());
      assertNull(operation.getProgress());
      assertNull(operation.getDescription());
      assertNull(operation.getInsertTime());
      assertNull(operation.getStartTime());
      assertNull(operation.getEndTime());
      assertNull(operation.getWarnings());
      assertNull(operation.getHttpErrorMessage());
    }
  }

  @Test
  public void testListZoneOperationsWithFilter() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE,
        Compute.OperationListOption.filter(Compute.OperationFilter.equals(
            Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll().iterator();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.getGeneratedId());
      assertNotNull(operation.getOperationId());
      assertEquals(ZONE, operation.<ZoneOperationId>getOperationId().getZone());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.getCreationTimestamp());
      assertNotNull(operation.getOperationType());
      assertEquals(Operation.Status.DONE, operation.getStatus());
      assertNotNull(operation.getUser());
    }
  }

  @Test
  public void testCreateGetAndDeleteRegionAddress() throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "create-and-get-region-address";
    AddressId addressId = RegionAddressId.of(REGION, name);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    operation.waitFor();
    // test get
    Address remoteAddress = compute.getAddress(addressId);
    resourceCleaner.add(addressId);
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.getAddressId() instanceof RegionAddressId);
    assertEquals(REGION, remoteAddress.<RegionAddressId>getAddressId().getRegion());
    assertEquals(addressId.getAddress(), remoteAddress.getAddressId().getAddress());
    assertNotNull(remoteAddress.getAddress());
    assertNotNull(remoteAddress.getCreationTimestamp());
    assertNotNull(remoteAddress.getGeneratedId());
    assertNotNull(remoteAddress.getStatus());
    // test get with selected fields
    remoteAddress = compute.getAddress(addressId, Compute.AddressOption.fields());
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.getAddressId() instanceof RegionAddressId);
    assertEquals(REGION, remoteAddress.<RegionAddressId>getAddressId().getRegion());
    assertEquals(addressId.getAddress(), remoteAddress.getAddressId().getAddress());
    assertNull(remoteAddress.getAddress());
    assertNull(remoteAddress.getCreationTimestamp());
    assertNull(remoteAddress.getGeneratedId());
    operation = remoteAddress.delete();
    operation.waitFor();
    resourceCleaner.remove(addressId);
    assertNull(compute.getAddress(addressId));
  }

  @Test
  public void testListRegionAddresses() throws InterruptedException, TimeoutException {
    String prefix = BASE_RESOURCE_NAME + "list-region-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = RegionAddressId.of(REGION, addressNames[0]);
    AddressId secondAddressId = RegionAddressId.of(REGION, addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    firstOperation.waitFor();
    resourceCleaner.add(firstAddressId);
    secondOperation.waitFor();
    resourceCleaner.add(secondAddressId);
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    // test list
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listRegionAddresses(REGION, Compute.AddressListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll().iterator();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.getAddressId());
      assertTrue(address.getAddressId() instanceof RegionAddressId);
      assertEquals(REGION, address.<RegionAddressId>getAddressId().getRegion());
      assertTrue(addressSet.contains(address.getAddressId().getAddress()));
      assertNotNull(address.getAddress());
      assertNotNull(address.getCreationTimestamp());
      assertNotNull(address.getGeneratedId());
      count++;
    }
    assertEquals(2, count);
    // test list with selected fields
    count = 0;
    addressPage = compute.listRegionAddresses(REGION, Compute.AddressListOption.filter(filter),
        Compute.AddressListOption.fields(Compute.AddressField.ADDRESS));
    addressIterator = addressPage.iterateAll().iterator();
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertTrue(address.getAddressId() instanceof RegionAddressId);
      assertEquals(REGION, address.<RegionAddressId>getAddressId().getRegion());
      assertTrue(addressSet.contains(address.getAddressId().getAddress()));
      assertNotNull(address.getAddress());
      assertNull(address.getCreationTimestamp());
      assertNull(address.getGeneratedId());
      assertNull(address.getStatus());
      assertNull(address.getUsage());
      count++;
    }
    assertEquals(2, count);
  }

  @Test
  public void testAggregatedListAddresses() throws InterruptedException, TimeoutException {
    String prefix = BASE_RESOURCE_NAME + "aggregated-list-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = RegionAddressId.of(REGION, addressNames[0]);
    AddressId secondAddressId = GlobalAddressId.of(REGION, addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    firstOperation.waitFor();
    resourceCleaner.add(firstAddressId);
    secondOperation.waitFor();
    resourceCleaner.add(secondAddressId);
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listAddresses(Compute.AddressAggregatedListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll().iterator();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.getAddressId());
      assertTrue(addressSet.contains(address.getAddressId().getAddress()));
      assertNotNull(address.getAddress());
      assertNotNull(address.getCreationTimestamp());
      assertNotNull(address.getGeneratedId());
      count++;
    }
    assertEquals(2, count);
  }

  @Test
  public void testCreateGetAndDeleteGlobalAddress() throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "create-and-get-global-address";
    AddressId addressId = GlobalAddressId.of(name);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    operation.waitFor();
    // test get
    Address remoteAddress = compute.getAddress(addressId);
    resourceCleaner.add(addressId);
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.getAddressId() instanceof GlobalAddressId);
    assertEquals(addressId.getAddress(), remoteAddress.getAddressId().getAddress());
    assertNotNull(remoteAddress.getAddress());
    assertNotNull(remoteAddress.getCreationTimestamp());
    assertNotNull(remoteAddress.getGeneratedId());
    assertNotNull(remoteAddress.getStatus());
    // test get with selected fields
    remoteAddress = compute.getAddress(addressId, Compute.AddressOption.fields());
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.getAddressId() instanceof GlobalAddressId);
    assertEquals(addressId.getAddress(), remoteAddress.getAddressId().getAddress());
    assertNull(remoteAddress.getAddress());
    assertNull(remoteAddress.getCreationTimestamp());
    assertNull(remoteAddress.getGeneratedId());
    operation = remoteAddress.delete();
    operation.waitFor();
    resourceCleaner.remove(addressId);
    assertNull(compute.getAddress(addressId));
  }

  @Test
  public void testListGlobalAddresses() throws InterruptedException, TimeoutException {
    String prefix = BASE_RESOURCE_NAME + "list-global-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = GlobalAddressId.of(addressNames[0]);
    AddressId secondAddressId = GlobalAddressId.of(addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    firstOperation.waitFor();
    resourceCleaner.add(firstAddressId);
    secondOperation.waitFor();
    resourceCleaner.add(secondAddressId);
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    // test list
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listGlobalAddresses(Compute.AddressListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll().iterator();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.getAddressId());
      assertTrue(address.getAddressId() instanceof GlobalAddressId);
      assertTrue(addressSet.contains(address.getAddressId().getAddress()));
      assertNotNull(address.getAddress());
      assertNotNull(address.getCreationTimestamp());
      assertNotNull(address.getGeneratedId());
      count++;
    }
    assertEquals(2, count);
    // test list with selected fields
    count = 0;
    addressPage = compute.listGlobalAddresses(Compute.AddressListOption.filter(filter),
        Compute.AddressListOption.fields(Compute.AddressField.ADDRESS));
    addressIterator = addressPage.iterateAll().iterator();
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertTrue(address.getAddressId() instanceof GlobalAddressId);
      assertTrue(addressSet.contains(address.getAddressId().getAddress()));
      assertNotNull(address.getAddress());
      assertNull(address.getCreationTimestamp());
      assertNull(address.getGeneratedId());
      assertNull(address.getStatus());
      assertNull(address.getUsage());
      count++;
    }
    assertEquals(2, count);
  }

  @Test
  public void testCreateGetResizeAndDeleteStandardDisk()
      throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "create-and-get-standard-disk";
    DiskId diskId = DiskId.of(ZONE, name);
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
    operation.waitFor();
    // test get
    Disk remoteDisk = compute.getDisk(diskId);
    resourceCleaner.add(diskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(diskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertNotNull(remoteDisk.getCreationTimestamp());
    assertNotNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof StandardDiskConfiguration);
    StandardDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(100L, (long) remoteConfiguration.getSizeGb());
    assertEquals("pd-ssd", remoteConfiguration.getDiskType().getType());
    assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.getType());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    operation = remoteDisk.resize(200L);
    operation.waitFor();
    // test resize and get with selected fields
    remoteDisk = compute.getDisk(diskId, Compute.DiskOption.fields(Compute.DiskField.SIZE_GB));
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(diskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertNull(remoteDisk.getCreationTimestamp());
    assertNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof StandardDiskConfiguration);
    remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(200L, (long) remoteConfiguration.getSizeGb());
    assertEquals("pd-ssd", remoteConfiguration.getDiskType().getType());
    assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.getType());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    operation = remoteDisk.delete();
    operation.waitFor();
    resourceCleaner.remove(diskId);
    assertNull(compute.getDisk(diskId));
  }

  @Test
  public void testCreateGetAndDeleteImageDisk() throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "create-and-get-image-disk";
    DiskId diskId = DiskId.of(ZONE, name);
    DiskInfo diskInfo = DiskInfo.of(diskId, ImageDiskConfiguration.of(IMAGE_ID));
    Operation operation = compute.create(diskInfo);
    operation.waitFor();
    // test get
    Disk remoteDisk = compute.getDisk(diskId);
    resourceCleaner.add(diskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(diskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.getCreationStatus());
    assertNotNull(remoteDisk.getCreationTimestamp());
    assertNotNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof ImageDiskConfiguration);
    ImageDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(IMAGE_ID, remoteConfiguration.getSourceImage());
    assertNotNull(remoteConfiguration.getSourceImageId());
    assertEquals(DiskConfiguration.Type.IMAGE, remoteConfiguration.getType());
    assertNotNull(remoteConfiguration.getSizeGb());
    assertEquals("pd-standard", remoteConfiguration.getDiskType().getType());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    // test get with selected fields
    remoteDisk = compute.getDisk(diskId, Compute.DiskOption.fields());
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(diskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertNull(remoteDisk.getCreationTimestamp());
    assertNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof ImageDiskConfiguration);
    remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(IMAGE_ID, remoteConfiguration.getSourceImage());
    assertNull(remoteConfiguration.getSourceImageId());
    assertEquals(DiskConfiguration.Type.IMAGE, remoteConfiguration.getType());
    assertNull(remoteConfiguration.getSizeGb());
    assertEquals("pd-standard", remoteConfiguration.getDiskType().getType());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    operation = remoteDisk.delete();
    operation.waitFor();
    resourceCleaner.remove(diskId);
    assertNull(compute.getDisk(diskId));
  }

  @Test
  public void testCreateGetAndDeleteSnapshotAndSnapshotDisk()
      throws InterruptedException, TimeoutException {
    String diskName = BASE_RESOURCE_NAME + "create-and-get-snapshot-disk1";
    String snapshotDiskName = BASE_RESOURCE_NAME + "create-and-get-snapshot-disk2";
    DiskId diskId = DiskId.of(ZONE, diskName);
    DiskId snapshotDiskId = DiskId.of(ZONE, snapshotDiskName);
    String snapshotName = BASE_RESOURCE_NAME + "create-and-get-snapshot";
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
    operation.waitFor();
    Disk remoteDisk = compute.getDisk(diskId);
    resourceCleaner.add(diskId);
    operation = remoteDisk.createSnapshot(snapshotName);
    operation.waitFor();
    // test get snapshot with selected fields
    Snapshot snapshot = compute.getSnapshot(snapshotName,
        Compute.SnapshotOption.fields(Compute.SnapshotField.CREATION_TIMESTAMP));
    resourceCleaner.add(snapshot.getSnapshotId());
    assertNull(snapshot.getGeneratedId());
    assertNotNull(snapshot.getSnapshotId());
    assertNotNull(snapshot.getCreationTimestamp());
    assertNull(snapshot.getDescription());
    assertNull(snapshot.getStatus());
    assertNull(snapshot.getDiskSizeGb());
    assertNull(snapshot.getLicenses());
    assertNull(snapshot.getSourceDisk());
    assertNull(snapshot.getSourceDiskId());
    assertNull(snapshot.getStorageBytes());
    assertNull(snapshot.getStorageBytesStatus());
    // test get snapshot
    snapshot = compute.getSnapshot(snapshotName);
    assertNotNull(snapshot.getGeneratedId());
    assertNotNull(snapshot.getSnapshotId());
    assertNotNull(snapshot.getCreationTimestamp());
    assertNotNull(snapshot.getStatus());
    assertEquals(100L, (long) snapshot.getDiskSizeGb());
    assertEquals(diskName, snapshot.getSourceDisk().getDisk());
    assertNotNull(snapshot.getSourceDiskId());
    assertNotNull(snapshot.getStorageBytes());
    assertNotNull(snapshot.getStorageBytesStatus());
    remoteDisk.delete();
    resourceCleaner.remove(diskId);
    diskInfo =
        DiskInfo.of(snapshotDiskId, SnapshotDiskConfiguration.of(SnapshotId.of(snapshotName)));
    operation = compute.create(diskInfo);
    operation.waitFor();
    // test get disk
    remoteDisk = compute.getDisk(snapshotDiskId);
    resourceCleaner.add(snapshotDiskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(snapshotDiskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.getCreationStatus());
    assertNotNull(remoteDisk.getCreationTimestamp());
    assertNotNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof SnapshotDiskConfiguration);
    SnapshotDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(DiskConfiguration.Type.SNAPSHOT, remoteConfiguration.getType());
    assertEquals(snapshotName, remoteConfiguration.getSourceSnapshot().getSnapshot());
    assertEquals(100L, (long) remoteConfiguration.getSizeGb());
    assertEquals("pd-standard", remoteConfiguration.getDiskType().getType());
    assertNotNull(remoteConfiguration.getSourceSnapshotId());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    // test get disk with selected fields
    remoteDisk = compute.getDisk(snapshotDiskId, Compute.DiskOption.fields());
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.getDiskId().getZone());
    assertEquals(snapshotDiskId.getDisk(), remoteDisk.getDiskId().getDisk());
    assertNull(remoteDisk.getCreationStatus());
    assertNull(remoteDisk.getCreationTimestamp());
    assertNull(remoteDisk.getGeneratedId());
    assertTrue(remoteDisk.getConfiguration() instanceof SnapshotDiskConfiguration);
    remoteConfiguration = remoteDisk.getConfiguration();
    assertEquals(DiskConfiguration.Type.SNAPSHOT, remoteConfiguration.getType());
    assertEquals(snapshotName, remoteConfiguration.getSourceSnapshot().getSnapshot());
    assertNull(remoteConfiguration.getSizeGb());
    assertEquals("pd-standard", remoteConfiguration.getDiskType().getType());
    assertNull(remoteDisk.<SnapshotDiskConfiguration>getConfiguration().getSourceSnapshotId());
    assertNull(remoteDisk.getLastAttachTimestamp());
    assertNull(remoteDisk.getLastDetachTimestamp());
    operation = remoteDisk.delete();
    operation.waitFor();
    resourceCleaner.remove(snapshotDiskId);
    assertNull(compute.getDisk(snapshotDiskId));
    operation = snapshot.delete();
    operation.waitFor();
    resourceCleaner.remove(snapshot.getSnapshotId());
    assertNull(compute.getSnapshot(snapshotName));
  }

  @Test
  public void testListDisksAndSnapshots() throws InterruptedException, TimeoutException {
    String prefix = BASE_RESOURCE_NAME + "list-disks-and-snapshots-disk";
    String[] diskNames = {prefix + "1", prefix + "2"};
    DiskId firstDiskId = DiskId.of(ZONE, diskNames[0]);
    DiskId secondDiskId = DiskId.of(ZONE, diskNames[1]);
    DiskConfiguration configuration =
        StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L);
    Operation firstOperation = compute.create(DiskInfo.of(firstDiskId, configuration));
    Operation secondOperation = compute.create(DiskInfo.of(secondDiskId, configuration));
    firstOperation.waitFor();
    resourceCleaner.add(firstDiskId);
    secondOperation.waitFor();
    resourceCleaner.add(secondDiskId);
    Set<String> diskSet = ImmutableSet.copyOf(diskNames);
    // test list disks
    Compute.DiskFilter diskFilter =
        Compute.DiskFilter.equals(Compute.DiskField.NAME, prefix + "\\d");
    Page<Disk> diskPage = compute.listDisks(ZONE, Compute.DiskListOption.filter(diskFilter));
    Iterator<Disk> diskIterator = diskPage.iterateAll().iterator();
    int count = 0;
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertEquals(ZONE, remoteDisk.getDiskId().getZone());
      assertTrue(diskSet.contains(remoteDisk.getDiskId().getDisk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.getCreationStatus());
      assertNotNull(remoteDisk.getCreationTimestamp());
      assertNotNull(remoteDisk.getGeneratedId());
      assertTrue(remoteDisk.getConfiguration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
      assertEquals(100L, (long) remoteConfiguration.getSizeGb());
      assertEquals("pd-ssd", remoteConfiguration.getDiskType().getType());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.getType());
      assertNull(remoteDisk.getLastAttachTimestamp());
      assertNull(remoteDisk.getLastDetachTimestamp());
      count++;
    }
    assertEquals(2, count);
    // test list disks with selected fields
    count = 0;
    diskPage = compute.listDisks(ZONE, Compute.DiskListOption.filter(diskFilter),
        Compute.DiskListOption.fields(Compute.DiskField.STATUS));
    diskIterator = diskPage.iterateAll().iterator();
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertEquals(ZONE, remoteDisk.getDiskId().getZone());
      assertTrue(diskSet.contains(remoteDisk.getDiskId().getDisk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.getCreationStatus());
      assertNull(remoteDisk.getCreationTimestamp());
      assertNull(remoteDisk.getGeneratedId());
      assertTrue(remoteDisk.getConfiguration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
      assertNull(remoteConfiguration.getSizeGb());
      assertEquals("pd-ssd", remoteConfiguration.getDiskType().getType());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.getType());
      assertNull(remoteDisk.getLastAttachTimestamp());
      assertNull(remoteDisk.getLastDetachTimestamp());
      count++;
    }
    assertEquals(2, count);
    // test snapshots
    SnapshotId firstSnapshotId = SnapshotId.of(diskNames[0]);
    SnapshotId secondSnapshotId = SnapshotId.of(diskNames[1]);
    firstOperation = compute.create(SnapshotInfo.of(firstSnapshotId, firstDiskId));
    secondOperation = compute.create(SnapshotInfo.of(secondSnapshotId, secondDiskId));
    firstOperation.waitFor();
    resourceCleaner.add(firstSnapshotId);
    secondOperation.waitFor();
    resourceCleaner.add(secondSnapshotId);
    // test list snapshots
    Compute.SnapshotFilter snapshotFilter =
        Compute.SnapshotFilter.equals(Compute.SnapshotField.NAME, prefix + "\\d");
    Page<Snapshot> snapshotPage =
        compute.listSnapshots(Compute.SnapshotListOption.filter(snapshotFilter));
    Iterator<Snapshot> snapshotIterator = snapshotPage.iterateAll().iterator();
    count = 0;
    while (snapshotIterator.hasNext()) {
      Snapshot remoteSnapshot = snapshotIterator.next();
      assertNotNull(remoteSnapshot.getGeneratedId());
      assertTrue(diskSet.contains(remoteSnapshot.getSnapshotId().getSnapshot()));
      assertNotNull(remoteSnapshot.getCreationTimestamp());
      assertNotNull(remoteSnapshot.getStatus());
      assertEquals(100L, (long) remoteSnapshot.getDiskSizeGb());
      assertTrue(diskSet.contains(remoteSnapshot.getSourceDisk().getDisk()));
      assertNotNull(remoteSnapshot.getSourceDiskId());
      assertNotNull(remoteSnapshot.getStorageBytes());
      assertNotNull(remoteSnapshot.getStorageBytesStatus());
      count++;
    }
    assertEquals(2, count);
    // test list snapshots with selected fields
    snapshotPage = compute.listSnapshots(Compute.SnapshotListOption.filter(snapshotFilter),
        Compute.SnapshotListOption.fields(Compute.SnapshotField.CREATION_TIMESTAMP));
    snapshotIterator = snapshotPage.iterateAll().iterator();
    count = 0;
    while (snapshotIterator.hasNext()) {
      Snapshot remoteSnapshot = snapshotIterator.next();
      assertNull(remoteSnapshot.getGeneratedId());
      assertTrue(diskSet.contains(remoteSnapshot.getSnapshotId().getSnapshot()));
      assertNotNull(remoteSnapshot.getCreationTimestamp());
      assertNull(remoteSnapshot.getStatus());
      assertNull(remoteSnapshot.getDiskSizeGb());
      assertNull(remoteSnapshot.getSourceDisk());
      assertNull(remoteSnapshot.getSourceDiskId());
      assertNull(remoteSnapshot.getStorageBytes());
      assertNull(remoteSnapshot.getStorageBytesStatus());
      count++;
    }
    assertEquals(2, count);
  }

  @Test
  public void testAggregatedListDisks() throws InterruptedException, TimeoutException {
    String prefix = BASE_RESOURCE_NAME + "list-aggregated-disk";
    String[] diskZones = {"us-central1-a", "us-east1-c"};
    String[] diskNames = {prefix + "1", prefix + "2"};
    DiskId firstDiskId = DiskId.of(diskZones[0], diskNames[0]);
    DiskId secondDiskId = DiskId.of(diskZones[1], diskNames[1]);
    DiskConfiguration configuration =
        StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L);
    Operation firstOperation = compute.create(DiskInfo.of(firstDiskId, configuration));
    Operation secondOperation = compute.create(DiskInfo.of(secondDiskId, configuration));
    firstOperation.waitFor();
    resourceCleaner.add(firstDiskId);
    secondOperation.waitFor();
    resourceCleaner.add(secondDiskId);
    Set<String> zoneSet = ImmutableSet.copyOf(diskZones);
    Set<String> diskSet = ImmutableSet.copyOf(diskNames);
    Compute.DiskFilter diskFilter =
        Compute.DiskFilter.equals(Compute.DiskField.NAME, prefix + "\\d");
    Page<Disk> diskPage = compute.listDisks(Compute.DiskAggregatedListOption.filter(diskFilter));
    Iterator<Disk> diskIterator = diskPage.iterateAll().iterator();
    int count = 0;
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertTrue(zoneSet.contains(remoteDisk.getDiskId().getZone()));
      assertTrue(diskSet.contains(remoteDisk.getDiskId().getDisk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.getCreationStatus());
      assertNotNull(remoteDisk.getCreationTimestamp());
      assertNotNull(remoteDisk.getGeneratedId());
      assertTrue(remoteDisk.getConfiguration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.getConfiguration();
      assertEquals(100L, (long) remoteConfiguration.getSizeGb());
      assertEquals("pd-ssd", remoteConfiguration.getDiskType().getType());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.getType());
      count++;
    }
    assertEquals(2, count);
  }

  @Test
  public void testCreateGetAndDeprecateImage() throws InterruptedException, TimeoutException {
    String diskName = BASE_RESOURCE_NAME + "create-and-get-image-disk";
    String imageName = BASE_RESOURCE_NAME + "create-and-get-image";
    DiskId diskId = DiskId.of(ZONE, diskName);
    ImageId imageId = ImageId.of(imageName);
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
operation.waitFor();
    Disk remoteDisk = compute.getDisk(diskId);
    ImageInfo imageInfo = ImageInfo.of(imageId, DiskImageConfiguration.of(diskId));
    operation = compute.create(imageInfo);
operation.waitFor();
    resourceCleaner.add(diskId);
    // test get image with selected fields
    Image image = compute.getImage(imageId,
        Compute.ImageOption.fields(Compute.ImageField.CREATION_TIMESTAMP));
    resourceCleaner.add(imageId);
    assertNull(image.getGeneratedId());
    assertNotNull(image.getImageId());
    assertNotNull(image.getCreationTimestamp());
    assertNull(image.getDescription());
    assertNotNull(image.getConfiguration());
    assertTrue(image.getConfiguration() instanceof DiskImageConfiguration);
    DiskImageConfiguration remoteConfiguration = image.getConfiguration();
    assertEquals(ImageConfiguration.Type.DISK, remoteConfiguration.getType());
    assertEquals(diskName, remoteConfiguration.getSourceDisk().getDisk());
    assertNull(image.getStatus());
    assertNull(image.getDiskSizeGb());
    assertNull(image.getLicenses());
    assertNull(image.getDeprecationStatus());
    // test get image
    image = compute.getImage(imageId);
    assertNotNull(image.getGeneratedId());
    assertNotNull(image.getImageId());
    assertNotNull(image.getCreationTimestamp());
    assertNotNull(image.getConfiguration());
    assertTrue(image.getConfiguration() instanceof DiskImageConfiguration);
    remoteConfiguration = image.getConfiguration();
    assertEquals(ImageConfiguration.Type.DISK, remoteConfiguration.getType());
    assertEquals(diskName, remoteConfiguration.getSourceDisk().getDisk());
    assertEquals(100L, (long) image.getDiskSizeGb());
    assertNotNull(image.getStatus());
    assertNull(image.getDeprecationStatus());
    // test deprecate image
    DeprecationStatus<ImageId> deprecationStatus =
        DeprecationStatus.newBuilder(DeprecationStatus.Status.DEPRECATED, imageId)
            .setDeprecated(System.currentTimeMillis())
            .build();
    operation = image.deprecate(deprecationStatus);
    operation.waitFor();
    image = compute.getImage(imageId);
    assertEquals(deprecationStatus, image.getDeprecationStatus());
    remoteDisk.delete();
    resourceCleaner.remove(diskId);
    operation = image.delete();
    operation.waitFor();
    resourceCleaner.remove(imageId);
    assertNull(compute.getImage(imageId));
  }

  @Test
  public void testListImages() {
    Page<Image> imagePage = compute.listImages(IMAGE_PROJECT);
    Iterator<Image> imageIterator = imagePage.iterateAll().iterator();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.getGeneratedId());
      assertNotNull(image.getImageId());
      assertNotNull(image.getCreationTimestamp());
      assertNotNull(image.getConfiguration());
      assertNotNull(image.getStatus());
      assertNotNull(image.getDiskSizeGb());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testListImagesWithSelectedFields() {
    Page<Image> imagePage =
        compute.listImages(IMAGE_PROJECT, Compute.ImageListOption.fields(Compute.ImageField.ID));
    Iterator<Image> imageIterator = imagePage.iterateAll().iterator();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.getGeneratedId());
      assertNotNull(image.getImageId());
      assertNull(image.getCreationTimestamp());
      assertNotNull(image.getConfiguration());
      assertNull(image.getStatus());
      assertNull(image.getDiskSizeGb());
      assertNull(image.getLicenses());
      assertNull(image.getDeprecationStatus());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testListImagesWithFilter() {
    Page<Image> imagePage = compute.listImages(IMAGE_PROJECT, Compute.ImageListOption.filter(
        Compute.ImageFilter.equals(Compute.ImageField.ARCHIVE_SIZE_BYTES, 365056004L)));
    Iterator<Image> imageIterator = imagePage.iterateAll().iterator();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.getGeneratedId());
      assertNotNull(image.getImageId());
      assertNotNull(image.getCreationTimestamp());
      assertNotNull(image.getConfiguration());
      assertNotNull(image.getStatus());
      assertNotNull(image.getDiskSizeGb());
      assertEquals(365056004L,
          (long) image.<StorageImageConfiguration>getConfiguration().getArchiveSizeBytes());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testCreateAndGetNetwork() throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "create-and-get-network";
    NetworkId networkId = NetworkId.of(name);
    NetworkInfo networkInfo =
        NetworkInfo.of(networkId, StandardNetworkConfiguration.of("192.168.0.0/16"));
    Operation operation = compute.create(networkInfo);
operation.waitFor();
    // test get network with selected fields
    Network network = compute.getNetwork(networkId.getNetwork(),
        Compute.NetworkOption.fields(Compute.NetworkField.CREATION_TIMESTAMP));
    resourceCleaner.add(networkId);
    assertEquals(networkId.getNetwork(), network.getNetworkId().getNetwork());
    assertNull(network.getGeneratedId());
    assertNotNull(network.getCreationTimestamp());
    assertNull(network.getDescription());
    assertEquals(NetworkConfiguration.Type.STANDARD, network.getConfiguration().getType());
    StandardNetworkConfiguration remoteConfiguration = network.getConfiguration();
    assertEquals("192.168.0.0/16", remoteConfiguration.getIpRange());
    // test get network
    network = compute.getNetwork(networkId.getNetwork());
    assertEquals(networkId.getNetwork(), network.getNetworkId().getNetwork());
    assertNotNull(network.getGeneratedId());
    assertNotNull(network.getCreationTimestamp());
    assertEquals(NetworkConfiguration.Type.STANDARD, network.getConfiguration().getType());
    remoteConfiguration = network.getConfiguration();
    assertEquals("192.168.0.0/16", remoteConfiguration.getIpRange());
    operation = network.delete();
    operation.waitFor();
    resourceCleaner.remove(networkId);
    assertNull(compute.getNetwork(name));
  }

  @Test
  public void testListNetworks() throws InterruptedException, TimeoutException {
    String name = BASE_RESOURCE_NAME + "list-network";
    NetworkId networkId = NetworkId.of(name);
    NetworkInfo networkInfo =
        NetworkInfo.of(networkId, StandardNetworkConfiguration.of("192.168.0.0/16"));
    Operation operation = compute.create(networkInfo);
    operation.waitFor();
    resourceCleaner.add(networkId);
    // test list
    Compute.NetworkFilter filter = Compute.NetworkFilter.equals(Compute.NetworkField.NAME, name);
    Page<Network> networkPage = compute.listNetworks(Compute.NetworkListOption.filter(filter));
    Iterator<Network> networkIterator = networkPage.iterateAll().iterator();
    int count = 0;
    while (networkIterator.hasNext()) {
      Network network = networkIterator.next();
      assertEquals(networkId.getNetwork(), network.getNetworkId().getNetwork());
      assertNotNull(network.getGeneratedId());
      assertNotNull(network.getCreationTimestamp());
      assertEquals(NetworkConfiguration.Type.STANDARD, network.getConfiguration().getType());
      StandardNetworkConfiguration remoteConfiguration = network.getConfiguration();
      assertEquals("192.168.0.0/16", remoteConfiguration.getIpRange());
      count++;
    }
    assertEquals(1, count);
    // test list with selected fields
    count = 0;
    networkPage = compute.listNetworks(Compute.NetworkListOption.filter(filter),
        Compute.NetworkListOption.fields(Compute.NetworkField.CREATION_TIMESTAMP));
    networkIterator = networkPage.iterateAll().iterator();
    while (networkIterator.hasNext()) {
      Network network = networkIterator.next();
      assertEquals(networkId.getNetwork(), network.getNetworkId().getNetwork());
      assertNull(network.getGeneratedId());
      assertNotNull(network.getCreationTimestamp());
      assertNull(network.getDescription());
      assertEquals(NetworkConfiguration.Type.STANDARD, network.getConfiguration().getType());
      StandardNetworkConfiguration remoteConfiguration = network.getConfiguration();
      assertEquals("192.168.0.0/16", remoteConfiguration.getIpRange());
      count++;
    }
    assertEquals(1, count);
    operation = compute.deleteNetwork(networkId);
    operation.waitFor();
    resourceCleaner.remove(networkId);
    assertNull(compute.getNetwork(name));
  }

  @Test
  public void testCreateNetworkAndSubnetwork() throws InterruptedException, TimeoutException {
    String networkName = BASE_RESOURCE_NAME + "create-subnetwork-network";
    NetworkId networkId = NetworkId.of(networkName);
    NetworkInfo networkInfo = NetworkInfo.of(networkId, SubnetNetworkConfiguration.of(false));
    Operation operation = compute.create(networkInfo);
    operation.waitFor();
    // test get network
    Network network = compute.getNetwork(networkId.getNetwork());
    resourceCleaner.add(networkId);
    assertEquals(networkId.getNetwork(), network.getNetworkId().getNetwork());
    assertNotNull(network.getGeneratedId());
    assertNotNull(network.getCreationTimestamp());
    assertEquals(NetworkConfiguration.Type.SUBNET, network.getConfiguration().getType());
    assertTrue(network.getConfiguration() instanceof SubnetNetworkConfiguration);
    assertFalse(network.<SubnetNetworkConfiguration>getConfiguration().autoCreateSubnetworks());
    String subnetworkName = BASE_RESOURCE_NAME + "create-subnetwork-subnetwork";
    SubnetworkId subnetworkId = SubnetworkId.of(REGION, subnetworkName);
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(subnetworkId, networkId, "192.168.0.0/16");
    operation = compute.create(subnetworkInfo);
    operation.waitFor();
    // test get subnetwork with selected fields
    Subnetwork subnetwork = compute.getSubnetwork(subnetworkId,
        Compute.SubnetworkOption.fields(Compute.SubnetworkField.CREATION_TIMESTAMP));
    resourceCleaner.add(subnetworkId);
    assertNull(subnetwork.getGeneratedId());
    assertEquals(subnetworkId.getSubnetwork(), subnetwork.getSubnetworkId().getSubnetwork());
    assertNotNull(subnetwork.getCreationTimestamp());
    assertNull(subnetwork.getDescription());
    assertNull(subnetwork.getGatewayAddress());
    assertNull(subnetwork.getNetwork());
    assertNull(subnetwork.getIpRange());
    // test get subnetwork
    subnetwork = compute.getSubnetwork(subnetworkId);
    assertNotNull(subnetwork.getGeneratedId());
    assertEquals(subnetworkId.getSubnetwork(), subnetwork.getSubnetworkId().getSubnetwork());
    assertNotNull(subnetwork.getCreationTimestamp());
    assertNotNull(subnetwork.getGatewayAddress());
    assertEquals(networkId.getNetwork(), subnetwork.getNetwork().getNetwork());
    assertEquals("192.168.0.0/16", subnetwork.getIpRange());
    // test list subnetworks
    Compute.SubnetworkFilter filter =
        Compute.SubnetworkFilter.equals(Compute.SubnetworkField.NAME, subnetworkName);
    Page<Subnetwork> subnetworkPage =
        compute.listSubnetworks(REGION, Compute.SubnetworkListOption.filter(filter));
    Iterator<Subnetwork> subnetworkIterator = subnetworkPage.iterateAll().iterator();
    int count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNotNull(remoteSubnetwork.getGeneratedId());
      assertEquals(subnetworkId.getSubnetwork(),
          remoteSubnetwork.getSubnetworkId().getSubnetwork());
      assertNotNull(remoteSubnetwork.getCreationTimestamp());
      assertNotNull(remoteSubnetwork.getGatewayAddress());
      assertEquals(networkId.getNetwork(), remoteSubnetwork.getNetwork().getNetwork());
      assertEquals("192.168.0.0/16", remoteSubnetwork.getIpRange());
      count++;
    }
    assertEquals(1, count);
    // test list subnetworks with selected fields
    subnetworkPage = compute.listSubnetworks(REGION, Compute.SubnetworkListOption.filter(filter),
        Compute.SubnetworkListOption.fields(Compute.SubnetworkField.CREATION_TIMESTAMP));
    subnetworkIterator = subnetworkPage.iterateAll().iterator();
    count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNull(remoteSubnetwork.getGeneratedId());
      assertEquals(subnetworkId.getSubnetwork(),
          remoteSubnetwork.getSubnetworkId().getSubnetwork());
      assertNotNull(remoteSubnetwork.getCreationTimestamp());
      assertNull(remoteSubnetwork.getDescription());
      assertNull(remoteSubnetwork.getGatewayAddress());
      assertNull(remoteSubnetwork.getNetwork());
      assertNull(remoteSubnetwork.getIpRange());
      count++;
    }
    assertEquals(1, count);
    operation = subnetwork.delete();
    operation.waitFor();
    resourceCleaner.remove(subnetworkId);
    operation = compute.deleteNetwork(networkId);
    operation.waitFor();
    resourceCleaner.remove(networkId);
    assertNull(compute.getSubnetwork(subnetworkId));
    assertNull(compute.getNetwork(networkName));
  }

  @Test
  public void testAggregatedListSubnetworks() throws InterruptedException, TimeoutException {
    String networkName = BASE_RESOURCE_NAME + "list-subnetwork-network";
    NetworkId networkId = NetworkId.of(networkName);
    NetworkInfo networkInfo = NetworkInfo.of(networkId, SubnetNetworkConfiguration.of(false));
    Operation operation = compute.create(networkInfo);
    operation.waitFor();
    resourceCleaner.add(networkId);
    String prefix = BASE_RESOURCE_NAME + "list-subnetwork";
    String[] regionNames = {"us-central1", "us-east1"};
    String[] subnetworkNames = {prefix + "1", prefix + "2"};
    String[] ipRanges = {"10.128.0.0/20", "10.132.0.0/20"};
    SubnetworkId firstSubnetworkId = SubnetworkId.of(regionNames[0], subnetworkNames[0]);
    SubnetworkId secondSubnetworkId = SubnetworkId.of(regionNames[1], subnetworkNames[1]);
    SubnetworkInfo firstSubnetworkInfo =
        SubnetworkInfo.of(firstSubnetworkId, networkId, ipRanges[0]);
    SubnetworkInfo secondSubnetworkInfo =
        SubnetworkInfo.of(secondSubnetworkId, networkId, ipRanges[1]);
    Operation firstOperation = compute.create(firstSubnetworkInfo);
    Operation secondOperation = compute.create(secondSubnetworkInfo);
    firstOperation.waitFor();
    resourceCleaner.add(firstSubnetworkId);
    secondOperation.waitFor();
    resourceCleaner.add(secondSubnetworkId);
    Set<String> regionSet = ImmutableSet.copyOf(regionNames);
    Set<String> subnetworkSet = ImmutableSet.copyOf(subnetworkNames);
    Set<String> rangeSet = ImmutableSet.copyOf(ipRanges);
    Compute.SubnetworkFilter subnetworkFilter =
        Compute.SubnetworkFilter.equals(Compute.SubnetworkField.NAME, prefix + "\\d");
    Page<Subnetwork> subnetworkPage =
        compute.listSubnetworks(Compute.SubnetworkAggregatedListOption.filter(subnetworkFilter));
    Iterator<Subnetwork> subnetworkIterator = subnetworkPage.iterateAll().iterator();
    int count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNotNull(remoteSubnetwork.getGeneratedId());
      assertTrue(regionSet.contains(remoteSubnetwork.getSubnetworkId().getRegion()));
      assertTrue(subnetworkSet.contains(remoteSubnetwork.getSubnetworkId().getSubnetwork()));
      assertNotNull(remoteSubnetwork.getCreationTimestamp());
      assertNotNull(remoteSubnetwork.getGatewayAddress());
      assertEquals(networkId.getNetwork(), remoteSubnetwork.getNetwork().getNetwork());
      assertTrue(rangeSet.contains(remoteSubnetwork.getIpRange()));
      count++;
    }
    assertEquals(2, count);
    firstOperation = compute.deleteSubnetwork(firstSubnetworkId);
    secondOperation = compute.deleteSubnetwork(secondSubnetworkId);
    firstOperation.waitFor();
    resourceCleaner.remove(firstSubnetworkId);
    secondOperation.waitFor();
    resourceCleaner.remove(secondSubnetworkId);
    operation = compute.deleteNetwork(networkId);
    operation.waitFor();
    resourceCleaner.remove(networkId);
    assertNull(compute.getSubnetwork(firstSubnetworkId));
    assertNull(compute.getSubnetwork(secondSubnetworkId));
    assertNull(compute.getNetwork(networkName));
  }

  @Test
  public void testCreateGetAndDeleteInstance() throws InterruptedException, TimeoutException {
    String instanceName = BASE_RESOURCE_NAME + "create-and-get-instance";
    String addressName = BASE_RESOURCE_NAME + "create-and-get-instance-address";
    // Create an address to assign to the instance
    AddressId addressId = RegionAddressId.of(REGION, addressName);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    operation.waitFor();
    Address address = compute.getAddress(addressId);
    resourceCleaner.add(addressId);
    // Create an instance
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId)
        .setAccessConfigurations(NetworkInterface.AccessConfig.newBuilder()
            .setName("NAT")
            .setNatIp(address.getAddress()).build())
        .build();
    AttachedDisk disk1 = AttachedDisk.of("dev0",
        AttachedDisk.CreateDiskConfiguration.newBuilder(IMAGE_ID).setAutoDelete(true).build());
    AttachedDisk disk2 =
        AttachedDisk.of("dev1",
            AttachedDisk.ScratchDiskConfiguration.of(DiskTypeId.of(ZONE, DISK_TYPE)));
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(instanceId, MachineTypeId.of(ZONE, "n1-standard-1"))
            .setAttachedDisks(disk1, disk2)
            .setNetworkInterfaces(networkInterface)
            .build();
    operation = compute.create(instanceInfo);
    operation.waitFor();
    // test get
    Instance remoteInstance = compute.getInstance(instanceId);
    resourceCleaner.add(instanceId);
    assertEquals(instanceName, remoteInstance.getInstanceId().getInstance());
    assertEquals(ZONE, remoteInstance.getInstanceId().getZone());
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.getStatus());
    assertEquals("n1-standard-1", remoteInstance.getMachineType().getType());
    assertEquals(ZONE, remoteInstance.getMachineType().getZone());
    assertNotNull(remoteInstance.getCreationTimestamp());
    Set<String> deviceSet = ImmutableSet.of("dev0", "dev1");
    assertEquals(2, remoteInstance.getAttachedDisks().size());
    for (AttachedDisk remoteAttachedDisk : remoteInstance.getAttachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.getDeviceName()));
    }
    assertEquals(AttachedDisk.AttachedDiskConfiguration.Type.PERSISTENT,
        remoteInstance.getAttachedDisks().get(0).getConfiguration().getType());
    AttachedDisk.PersistentDiskConfiguration remoteConfiguration =
        remoteInstance.getAttachedDisks().get(0).getConfiguration();
    assertEquals(instanceName, remoteConfiguration.getSourceDisk().getDisk());
    assertEquals(ZONE, remoteConfiguration.getSourceDisk().getZone());
    assertTrue(remoteConfiguration.boot());
    assertTrue(remoteConfiguration.autoDelete());
    assertEquals(1, remoteInstance.getNetworkInterfaces().size());
    NetworkInterface remoteNetworkInterface = remoteInstance.getNetworkInterfaces().get(0);
    assertNotNull(remoteNetworkInterface.getName());
    assertEquals("default", remoteNetworkInterface.getNetwork().getNetwork());
    List<NetworkInterface.AccessConfig> remoteAccessConfigurations =
        remoteNetworkInterface.getAccessConfigurations();
    assertNotNull(remoteAccessConfigurations);
    assertEquals(1, remoteAccessConfigurations.size());
    NetworkInterface.AccessConfig remoteAccessConfig = remoteAccessConfigurations.get(0);
    assertEquals(address.getAddress(), remoteAccessConfig.getNatIp());
    assertEquals("NAT", remoteAccessConfig.getName());
    assertNotNull(remoteInstance.getMetadata());
    assertNotNull(remoteInstance.getTags());
    // test get with selected fields
    remoteInstance = compute.getInstance(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.CREATION_TIMESTAMP));
    assertEquals(instanceName, remoteInstance.getInstanceId().getInstance());
    assertEquals(ZONE, remoteInstance.getInstanceId().getZone());
    assertNull(remoteInstance.getMachineType());
    assertNotNull(remoteInstance.getCreationTimestamp());
    assertNull(remoteInstance.getAttachedDisks());
    assertNull(remoteInstance.getNetworkInterfaces());
    assertNull(remoteInstance.getMetadata());
    assertNull(remoteInstance.getTags());
    // test get default serial port output
    String serialPortOutput = remoteInstance.getSerialPortOutput();
    assertNotNull(serialPortOutput);
    // test get serial port output by number
    String newSerialPortOutput = remoteInstance.getSerialPortOutput(1);
    assertTrue(newSerialPortOutput.contains(serialPortOutput));
    operation = remoteInstance.delete();
    operation.waitFor();
    resourceCleaner.remove(instanceId);
    assertNull(compute.getInstance(instanceId));
  }

  @Test
  public void testStartStopAndResetInstance() throws InterruptedException, TimeoutException {
    String instanceName = BASE_RESOURCE_NAME + "start-stop-reset-instance";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        AttachedDisk.CreateDiskConfiguration.newBuilder(IMAGE_ID).setAutoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .setAttachedDisks(disk)
            .setNetworkInterfaces(networkInterface)
            .build();
    Operation operation = compute.create(instanceInfo);
    operation.waitFor();
    Instance remoteInstance = compute.getInstance(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    resourceCleaner.add(instanceId);
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.getStatus());
    operation = remoteInstance.stop();
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.TERMINATED, remoteInstance.getStatus());
    operation = remoteInstance.start();
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.getStatus());
    operation = remoteInstance.reset();
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.getStatus());
  }

  @Test
  public void testSetInstanceProperties() throws InterruptedException, TimeoutException {
    String instanceName = BASE_RESOURCE_NAME + "set-properties-instance";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        AttachedDisk.CreateDiskConfiguration.newBuilder(IMAGE_ID).setAutoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .setAttachedDisks(disk)
            .setNetworkInterfaces(networkInterface)
            .build();
    Operation operation = compute.create(instanceInfo);
    operation.waitFor();
    Instance remoteInstance = compute.getInstance(instanceId);
    resourceCleaner.add(instanceId);
    // test set tags
    List<String> tags = ImmutableList.of("tag1", "tag2");
    operation = remoteInstance.setTags(tags);
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals(tags, remoteInstance.getTags().getValues());
    // test set metadata
    Map<String, String> metadata = ImmutableMap.of("key", "value");
    operation = remoteInstance.setMetadata(metadata);
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals(metadata, remoteInstance.getMetadata().getValues());
    // test set machine type
    operation = remoteInstance.stop();
    operation.waitFor();
    operation = remoteInstance.setMachineType(MachineTypeId.of(ZONE, "n1-standard-1"));
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals("n1-standard-1", remoteInstance.getMachineType().getType());
    assertEquals(ZONE, remoteInstance.getMachineType().getZone());
    // test set scheduling options
    SchedulingOptions options =
        SchedulingOptions.standard(false, SchedulingOptions.Maintenance.TERMINATE);
    operation = remoteInstance.setSchedulingOptions(options);
    operation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals(options, remoteInstance.getSchedulingOptions());
  }

  @Test
  public void testAttachAndDetachDisk() throws InterruptedException, TimeoutException {
    String instanceName = BASE_RESOURCE_NAME + "attach-and-detach-disk-instance";
    String diskName = BASE_RESOURCE_NAME + "attach-and-detach-disk";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        AttachedDisk.CreateDiskConfiguration.newBuilder(IMAGE_ID).setAutoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .setAttachedDisks(disk)
            .setNetworkInterfaces(networkInterface)
            .build();
    Operation instanceOperation = compute.create(instanceInfo);
    DiskId diskId = DiskId.of(ZONE, diskName);
    Operation diskOperation = compute.create(DiskInfo.of(diskId,
            StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"))));
    instanceOperation.waitFor();
    diskOperation.waitFor();
    resourceCleaner.add(diskId);
    Instance remoteInstance = compute.getInstance(instanceId);
    // test attach disk
    instanceOperation = remoteInstance.attachDisk("dev1",
        AttachedDisk.PersistentDiskConfiguration.newBuilder(diskId).build());
    instanceOperation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    resourceCleaner.add(instanceId);
    Set<String> deviceSet = ImmutableSet.of("dev0", "dev1");
    assertEquals(2, remoteInstance.getAttachedDisks().size());
    for (AttachedDisk remoteAttachedDisk : remoteInstance.getAttachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.getDeviceName()));
    }
    // test set disk auto-delete
    instanceOperation = remoteInstance.setDiskAutoDelete("dev1", true);
    instanceOperation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals(2, remoteInstance.getAttachedDisks().size());
    for (AttachedDisk remoteAttachedDisk : remoteInstance.getAttachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.getDeviceName()));
      assertTrue(remoteAttachedDisk.getConfiguration().autoDelete());
    }
    // test detach disk
    instanceOperation = remoteInstance.detachDisk("dev1");
    instanceOperation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertEquals(1, remoteInstance.getAttachedDisks().size());
    assertEquals("dev0", remoteInstance.getAttachedDisks().get(0).getDeviceName());
  }

  @Test
  public void testAddAndRemoveAccessConfig() throws InterruptedException, TimeoutException {
    String instanceName = BASE_RESOURCE_NAME + "add-and-remove-access-instance";
    String addressName = BASE_RESOURCE_NAME + "add-and-remove-access-address";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        AttachedDisk.CreateDiskConfiguration.newBuilder(IMAGE_ID).setAutoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.newBuilder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .setAttachedDisks(disk)
            .setNetworkInterfaces(networkInterface)
            .build();
    Operation instanceOperation = compute.create(instanceInfo);
    AddressId addressId = RegionAddressId.of(REGION, addressName);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation addressOperation = compute.create(addressInfo);
    addressOperation.waitFor();
    instanceOperation.waitFor();
    Address remoteAddress = compute.getAddress(addressId);
    resourceCleaner.add(addressId);
    Instance remoteInstance = compute.getInstance(instanceId);
    resourceCleaner.add(instanceId);
    String networkInterfaceName = remoteInstance.getNetworkInterfaces().get(0).getName();
    // test add access config
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.newBuilder()
        .setNatIp(remoteAddress.getAddress())
        .setName("NAT")
        .build();
    instanceOperation = remoteInstance.addAccessConfig(networkInterfaceName, accessConfig);
    instanceOperation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    List<NetworkInterface.AccessConfig> accessConfigurations =
        remoteInstance.getNetworkInterfaces().get(0).getAccessConfigurations();
    assertEquals(1, accessConfigurations.size());
    assertEquals("NAT", accessConfigurations.get(0).getName());
    // test delete access config
    instanceOperation = remoteInstance.deleteAccessConfig(networkInterfaceName, "NAT");
    instanceOperation.waitFor();
    remoteInstance = compute.getInstance(instanceId);
    assertTrue(remoteInstance.getNetworkInterfaces().get(0).getAccessConfigurations().isEmpty());
  }
}
