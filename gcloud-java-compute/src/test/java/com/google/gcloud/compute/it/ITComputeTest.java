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

package com.google.gcloud.compute.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.Page;
import com.google.gcloud.compute.Address;
import com.google.gcloud.compute.AddressId;
import com.google.gcloud.compute.AddressInfo;
import com.google.gcloud.compute.AttachedDisk;
import com.google.gcloud.compute.AttachedDisk.AttachedDiskConfiguration;
import com.google.gcloud.compute.AttachedDisk.CreateDiskConfiguration;
import com.google.gcloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.gcloud.compute.AttachedDisk.ScratchDiskConfiguration;
import com.google.gcloud.compute.Compute;
import com.google.gcloud.compute.DeprecationStatus;
import com.google.gcloud.compute.Disk;
import com.google.gcloud.compute.DiskConfiguration;
import com.google.gcloud.compute.DiskId;
import com.google.gcloud.compute.DiskImageConfiguration;
import com.google.gcloud.compute.DiskInfo;
import com.google.gcloud.compute.DiskType;
import com.google.gcloud.compute.DiskTypeId;
import com.google.gcloud.compute.GlobalAddressId;
import com.google.gcloud.compute.Image;
import com.google.gcloud.compute.ImageConfiguration;
import com.google.gcloud.compute.ImageDiskConfiguration;
import com.google.gcloud.compute.ImageId;
import com.google.gcloud.compute.ImageInfo;
import com.google.gcloud.compute.Instance;
import com.google.gcloud.compute.InstanceId;
import com.google.gcloud.compute.InstanceInfo;
import com.google.gcloud.compute.License;
import com.google.gcloud.compute.LicenseId;
import com.google.gcloud.compute.MachineType;
import com.google.gcloud.compute.MachineTypeId;
import com.google.gcloud.compute.Network;
import com.google.gcloud.compute.NetworkConfiguration;
import com.google.gcloud.compute.NetworkId;
import com.google.gcloud.compute.NetworkInfo;
import com.google.gcloud.compute.NetworkInterface;
import com.google.gcloud.compute.NetworkInterface.AccessConfig;
import com.google.gcloud.compute.Operation;
import com.google.gcloud.compute.Region;
import com.google.gcloud.compute.RegionAddressId;
import com.google.gcloud.compute.RegionOperationId;
import com.google.gcloud.compute.SchedulingOptions;
import com.google.gcloud.compute.SchedulingOptions.Maintenance;
import com.google.gcloud.compute.Snapshot;
import com.google.gcloud.compute.SnapshotDiskConfiguration;
import com.google.gcloud.compute.SnapshotId;
import com.google.gcloud.compute.SnapshotInfo;
import com.google.gcloud.compute.StandardDiskConfiguration;
import com.google.gcloud.compute.StandardNetworkConfiguration;
import com.google.gcloud.compute.StorageImageConfiguration;
import com.google.gcloud.compute.SubnetNetworkConfiguration;
import com.google.gcloud.compute.Subnetwork;
import com.google.gcloud.compute.SubnetworkId;
import com.google.gcloud.compute.SubnetworkInfo;
import com.google.gcloud.compute.Zone;
import com.google.gcloud.compute.ZoneOperationId;
import com.google.gcloud.compute.testing.RemoteComputeHelper;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteComputeHelper computeHelper = RemoteComputeHelper.create();
    compute = computeHelper.options().service();
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE);
    // assertNotNull(diskType.generatedId());
    assertEquals(ZONE, diskType.diskTypeId().zone());
    assertEquals(DISK_TYPE, diskType.diskTypeId().type());
    assertNotNull(diskType.creationTimestamp());
    assertNotNull(diskType.description());
    assertNotNull(diskType.validDiskSize());
    assertNotNull(diskType.defaultDiskSizeGb());
  }

  @Test
  public void testGetDiskTypeWithSelectedFields() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE,
        Compute.DiskTypeOption.fields(Compute.DiskTypeField.CREATION_TIMESTAMP));
    // assertNotNull(diskType.generatedId());
    assertEquals(ZONE, diskType.diskTypeId().zone());
    assertEquals(DISK_TYPE, diskType.diskTypeId().type());
    assertNotNull(diskType.creationTimestamp());
    assertNull(diskType.description());
    assertNull(diskType.validDiskSize());
    assertNull(diskType.defaultDiskSizeGb());
  }

  @Test
  public void testListDiskTypes() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE);
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.generatedId());
      assertNotNull(diskType.diskTypeId());
      assertEquals(ZONE, diskType.diskTypeId().zone());
      assertNotNull(diskType.creationTimestamp());
      assertNotNull(diskType.description());
      assertNotNull(diskType.validDiskSize());
      assertNotNull(diskType.defaultDiskSizeGb());
    }
  }

  @Test
  public void testListDiskTypesWithSelectedFields() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE,
        Compute.DiskTypeListOption.fields(Compute.DiskTypeField.CREATION_TIMESTAMP));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertNull(diskType.generatedId());
      assertNotNull(diskType.diskTypeId());
      assertEquals(ZONE, diskType.diskTypeId().zone());
      assertNotNull(diskType.creationTimestamp());
      assertNull(diskType.description());
      assertNull(diskType.validDiskSize());
      assertNull(diskType.defaultDiskSizeGb());
    }
  }

  @Test
  public void testListDiskTypesWithFilter() {
    Page<DiskType> diskPage = compute.listDiskTypes(ZONE, Compute.DiskTypeListOption.filter(
        Compute.DiskTypeFilter.equals(Compute.DiskTypeField.DEFAULT_DISK_SIZE_GB, 375)));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.generatedId());
      assertNotNull(diskType.diskTypeId());
      assertEquals(ZONE, diskType.diskTypeId().zone());
      assertNotNull(diskType.creationTimestamp());
      assertNotNull(diskType.description());
      assertNotNull(diskType.validDiskSize());
      assertEquals(375, (long) diskType.defaultDiskSizeGb());
    }
  }

  @Test
  public void testAggregatedListDiskTypes() {
    Page<DiskType> diskPage = compute.listDiskTypes();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.generatedId());
      assertNotNull(diskType.diskTypeId());
      assertNotNull(diskType.creationTimestamp());
      assertNotNull(diskType.description());
      assertNotNull(diskType.validDiskSize());
      assertNotNull(diskType.defaultDiskSizeGb());
    }
  }

  @Test
  public void testAggregatedListDiskTypesWithFilter() {
    Page<DiskType> diskPage = compute.listDiskTypes(Compute.DiskTypeAggregatedListOption.filter(
        Compute.DiskTypeFilter.notEquals(Compute.DiskTypeField.DEFAULT_DISK_SIZE_GB, 375)));
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.generatedId());
      assertNotNull(diskType.diskTypeId());
      assertNotNull(diskType.creationTimestamp());
      assertNotNull(diskType.description());
      assertNotNull(diskType.validDiskSize());
      assertNotEquals(375, (long) diskType.defaultDiskSizeGb());
    }
  }

  @Test
  public void testGetMachineType() {
    MachineType machineType = compute.getMachineType(ZONE, MACHINE_TYPE);
    assertEquals(ZONE, machineType.machineTypeId().zone());
    assertEquals(MACHINE_TYPE, machineType.machineTypeId().type());
    assertNotNull(machineType.generatedId());
    assertNotNull(machineType.creationTimestamp());
    assertNotNull(machineType.description());
    assertNotNull(machineType.cpus());
    assertNotNull(machineType.memoryMb());
    assertNotNull(machineType.maximumPersistentDisks());
    assertNotNull(machineType.maximumPersistentDisksSizeGb());
  }

  @Test
  public void testGetMachineTypeWithSelectedFields() {
    MachineType machineType = compute.getMachineType(ZONE, MACHINE_TYPE,
        Compute.MachineTypeOption.fields(Compute.MachineTypeField.ID));
    assertEquals(ZONE, machineType.machineTypeId().zone());
    assertEquals(MACHINE_TYPE, machineType.machineTypeId().type());
    assertNotNull(machineType.generatedId());
    assertNull(machineType.creationTimestamp());
    assertNull(machineType.description());
    assertNull(machineType.cpus());
    assertNull(machineType.memoryMb());
    assertNull(machineType.maximumPersistentDisks());
    assertNull(machineType.maximumPersistentDisksSizeGb());
  }

  @Test
  public void testListMachineTypes() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE);
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNotNull(machineType.generatedId());
      assertNotNull(machineType.creationTimestamp());
      assertNotNull(machineType.description());
      assertNotNull(machineType.cpus());
      assertNotNull(machineType.memoryMb());
      assertNotNull(machineType.maximumPersistentDisks());
      assertNotNull(machineType.maximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testListMachineTypesWithSelectedFields() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE,
        Compute.MachineTypeListOption.fields(Compute.MachineTypeField.CREATION_TIMESTAMP));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNull(machineType.generatedId());
      assertNotNull(machineType.creationTimestamp());
      assertNull(machineType.description());
      assertNull(machineType.cpus());
      assertNull(machineType.memoryMb());
      assertNull(machineType.maximumPersistentDisks());
      assertNull(machineType.maximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testListMachineTypesWithFilter() {
    Page<MachineType> machinePage = compute.listMachineTypes(ZONE,
        Compute.MachineTypeListOption.filter(
            Compute.MachineTypeFilter.equals(Compute.MachineTypeField.GUEST_CPUS, 2)));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNotNull(machineType.generatedId());
      assertNotNull(machineType.creationTimestamp());
      assertNotNull(machineType.description());
      assertNotNull(machineType.cpus());
      assertEquals(2, (long) machineType.cpus());
      assertNotNull(machineType.memoryMb());
      assertNotNull(machineType.maximumPersistentDisks());
      assertNotNull(machineType.maximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testAggregatedListMachineTypes() {
    Page<MachineType> machinePage = compute.listMachineTypes();
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertNotNull(machineType.generatedId());
      assertNotNull(machineType.creationTimestamp());
      assertNotNull(machineType.description());
      assertNotNull(machineType.cpus());
      assertNotNull(machineType.memoryMb());
      assertNotNull(machineType.maximumPersistentDisks());
      assertNotNull(machineType.maximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testAggregatedListMachineTypesWithFilter() {
    Page<MachineType> machinePage =
        compute.listMachineTypes(Compute.MachineTypeAggregatedListOption.filter(
            Compute.MachineTypeFilter.notEquals(Compute.MachineTypeField.GUEST_CPUS, 2)));
    Iterator<MachineType> machineTypeIterator = machinePage.iterateAll();
    assertTrue(machineTypeIterator.hasNext());
    while (machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertNotNull(machineType.generatedId());
      assertNotNull(machineType.creationTimestamp());
      assertNotNull(machineType.description());
      assertNotNull(machineType.cpus());
      assertNotEquals(2, (long) machineType.cpus());
      assertNotNull(machineType.memoryMb());
      assertNotNull(machineType.maximumPersistentDisks());
      assertNotNull(machineType.maximumPersistentDisksSizeGb());
    }
  }

  @Test
  public void testGetLicense() {
    License license = compute.getLicense(LICENSE_ID);
    assertEquals(LICENSE_ID, license.licenseId());
    assertNotNull(license.chargesUseFee());
  }

  @Test
  public void testGetLicenseWithSelectedFields() {
    License license = compute.getLicense(LICENSE_ID, Compute.LicenseOption.fields());
    assertEquals(LICENSE_ID, license.licenseId());
    assertNull(license.chargesUseFee());
  }

  @Test
  public void testGetRegion() {
    Region region = compute.getRegion(REGION);
    assertEquals(REGION, region.regionId().region());
    assertNotNull(region.description());
    assertNotNull(region.creationTimestamp());
    assertNotNull(region.generatedId());
    assertNotNull(region.quotas());
    assertNotNull(region.status());
    assertNotNull(region.zones());
  }

  @Test
  public void testGetRegionWithSelectedFields() {
    Region region = compute.getRegion(REGION, Compute.RegionOption.fields(Compute.RegionField.ID));
    assertEquals(REGION, region.regionId().region());
    assertNotNull(region.generatedId());
    assertNull(region.description());
    assertNull(region.creationTimestamp());
    assertNull(region.quotas());
    assertNull(region.status());
    assertNull(region.zones());
  }

  @Test
  public void testListRegions() {
    Page<Region> regionPage = compute.listRegions();
    Iterator<Region> regionIterator = regionPage.iterateAll();
    while (regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.regionId());
      assertNotNull(region.description());
      assertNotNull(region.creationTimestamp());
      assertNotNull(region.generatedId());
      assertNotNull(region.quotas());
      assertNotNull(region.status());
      assertNotNull(region.zones());
    }
  }

  @Test
  public void testListRegionsWithSelectedFields() {
    Page<Region> regionPage =
        compute.listRegions(Compute.RegionListOption.fields(Compute.RegionField.ID));
    Iterator<Region> regionIterator = regionPage.iterateAll();
    while (regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.regionId());
      assertNull(region.description());
      assertNull(region.creationTimestamp());
      assertNotNull(region.generatedId());
      assertNull(region.quotas());
      assertNull(region.status());
      assertNull(region.zones());
    }
  }

  @Test
  public void testListRegionsWithFilter() {
    Page<Region> regionPage = compute.listRegions(Compute.RegionListOption.filter(
        Compute.RegionFilter.equals(Compute.RegionField.NAME, REGION)));
    Iterator<Region> regionIterator = regionPage.iterateAll();
    assertEquals(REGION, regionIterator.next().regionId().region());
    assertFalse(regionIterator.hasNext());
  }

  @Test
  public void testGetZone() {
    Zone zone = compute.getZone(ZONE);
    assertEquals(ZONE, zone.zoneId().zone());
    assertNotNull(zone.generatedId());
    assertNotNull(zone.creationTimestamp());
    assertNotNull(zone.description());
    assertNotNull(zone.status());
    assertNotNull(zone.region());
  }

  @Test
  public void testGetZoneWithSelectedFields() {
    Zone zone = compute.getZone(ZONE, Compute.ZoneOption.fields(Compute.ZoneField.ID));
    assertEquals(ZONE, zone.zoneId().zone());
    assertNotNull(zone.generatedId());
    assertNull(zone.creationTimestamp());
    assertNull(zone.description());
    assertNull(zone.status());
    assertNull(zone.region());
  }

  @Test
  public void testListZones() {
    Page<Zone> zonePage = compute.listZones();
    Iterator<Zone> zoneIterator = zonePage.iterateAll();
    while (zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.zoneId());
      assertNotNull(zone.generatedId());
      assertNotNull(zone.creationTimestamp());
      assertNotNull(zone.description());
      assertNotNull(zone.status());
      assertNotNull(zone.region());
    }
  }

  @Test
  public void testListZonesWithSelectedFields() {
    Page<Zone> zonePage = compute.listZones(
        Compute.ZoneListOption.fields(Compute.ZoneField.CREATION_TIMESTAMP));
    Iterator<Zone> zoneIterator = zonePage.iterateAll();
    while (zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.zoneId());
      assertNull(zone.generatedId());
      assertNotNull(zone.creationTimestamp());
      assertNull(zone.description());
      assertNull(zone.status());
      assertNull(zone.region());
    }
  }

  @Test
  public void testListZonesWithFilter() {
    Page<Zone> zonePage = compute.listZones(
        Compute.ZoneListOption.filter(Compute.ZoneFilter.equals(Compute.ZoneField.NAME, ZONE)));
    Iterator<Zone> zoneIterator = zonePage.iterateAll();
    assertEquals(ZONE, zoneIterator.next().zoneId().zone());
    assertFalse(zoneIterator.hasNext());
  }

  @Test
  public void testListGlobalOperations() {
    Page<Operation> operationPage = compute.listGlobalOperations();
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertNotNull(operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testListGlobalOperationsWithSelectedFields() {
    Page<Operation> operationPage =
        compute.listGlobalOperations(Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.operationType());
      assertNull(operation.status());
      assertNull(operation.statusMessage());
      assertNull(operation.user());
      assertNull(operation.progress());
      assertNull(operation.description());
      assertNull(operation.insertTime());
      assertNull(operation.startTime());
      assertNull(operation.endTime());
      assertNull(operation.warnings());
      assertNull(operation.httpErrorMessage());
    }
  }

  @Test
  public void testListGlobalOperationsWithFilter() {
    Page<Operation> operationPage = compute.listGlobalOperations(Compute.OperationListOption.filter(
        Compute.OperationFilter.equals(Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertEquals(Operation.Status.DONE, operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testListRegionOperations() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION);
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(REGION, operation.<RegionOperationId>operationId().region());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertNotNull(operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testListRegionOperationsWithSelectedFields() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION,
        Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(REGION, operation.<RegionOperationId>operationId().region());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.operationType());
      assertNull(operation.status());
      assertNull(operation.statusMessage());
      assertNull(operation.user());
      assertNull(operation.progress());
      assertNull(operation.description());
      assertNull(operation.insertTime());
      assertNull(operation.startTime());
      assertNull(operation.endTime());
      assertNull(operation.warnings());
      assertNull(operation.httpErrorMessage());
    }
  }

  @Test
  public void testListRegionOperationsWithFilter() {
    Page<Operation> operationPage = compute.listRegionOperations(REGION,
        Compute.OperationListOption.filter(Compute.OperationFilter.equals(
            Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(REGION, operation.<RegionOperationId>operationId().region());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertEquals(Operation.Status.DONE, operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testListZoneOperations() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE);
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertNotNull(operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testListZoneOperationsWithSelectedFields() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE,
        Compute.OperationListOption.fields(Compute.OperationField.ID));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.operationType());
      assertNull(operation.status());
      assertNull(operation.statusMessage());
      assertNull(operation.user());
      assertNull(operation.progress());
      assertNull(operation.description());
      assertNull(operation.insertTime());
      assertNull(operation.startTime());
      assertNull(operation.endTime());
      assertNull(operation.warnings());
      assertNull(operation.httpErrorMessage());
    }
  }

  @Test
  public void testListZoneOperationsWithFilter() {
    Page<Operation> operationPage = compute.listZoneOperations(ZONE,
        Compute.OperationListOption.filter(Compute.OperationFilter.equals(
            Compute.OperationField.STATUS, "DONE")));
    Iterator<Operation> operationIterator = operationPage.iterateAll();
    while (operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.generatedId());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertEquals(Operation.Status.DONE, operation.status());
      assertNotNull(operation.user());
    }
  }

  @Test
  public void testCreateGetAndDeleteRegionAddress() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "create-and-get-region-address";
    AddressId addressId = RegionAddressId.of(REGION, name);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get
    Address remoteAddress = compute.get(addressId);
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.addressId() instanceof RegionAddressId);
    assertEquals(REGION, remoteAddress.<RegionAddressId>addressId().region());
    assertEquals(addressId.address(), remoteAddress.addressId().address());
    assertNotNull(remoteAddress.address());
    assertNotNull(remoteAddress.creationTimestamp());
    assertNotNull(remoteAddress.generatedId());
    assertNotNull(remoteAddress.status());
    // test get with selected fields
    remoteAddress = compute.get(addressId, Compute.AddressOption.fields());
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.addressId() instanceof RegionAddressId);
    assertEquals(REGION, remoteAddress.<RegionAddressId>addressId().region());
    assertEquals(addressId.address(), remoteAddress.addressId().address());
    assertNull(remoteAddress.address());
    assertNull(remoteAddress.creationTimestamp());
    assertNull(remoteAddress.generatedId());
    operation = remoteAddress.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(addressId));
  }

  @Test
  public void testListRegionAddresses() throws InterruptedException {
    String prefix = BASE_RESOURCE_NAME + "list-region-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = RegionAddressId.of(REGION, addressNames[0]);
    AddressId secondAddressId = RegionAddressId.of(REGION, addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    // test list
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listRegionAddresses(REGION, Compute.AddressListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.addressId());
      assertTrue(address.addressId() instanceof RegionAddressId);
      assertEquals(REGION, address.<RegionAddressId>addressId().region());
      assertTrue(addressSet.contains(address.addressId().address()));
      assertNotNull(address.address());
      assertNotNull(address.creationTimestamp());
      assertNotNull(address.generatedId());
      count++;
    }
    assertEquals(2, count);
    // test list with selected fields
    count = 0;
    addressPage = compute.listRegionAddresses(REGION, Compute.AddressListOption.filter(filter),
        Compute.AddressListOption.fields(Compute.AddressField.ADDRESS));
    addressIterator = addressPage.iterateAll();
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertTrue(address.addressId() instanceof RegionAddressId);
      assertEquals(REGION, address.<RegionAddressId>addressId().region());
      assertTrue(addressSet.contains(address.addressId().address()));
      assertNotNull(address.address());
      assertNull(address.creationTimestamp());
      assertNull(address.generatedId());
      assertNull(address.status());
      assertNull(address.usage());
      count++;
    }
    assertEquals(2, count);
    compute.delete(firstAddressId);
    compute.delete(secondAddressId);
  }

  @Test
  public void testAggregatedListAddresses() throws InterruptedException {
    String prefix = BASE_RESOURCE_NAME + "aggregated-list-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = RegionAddressId.of(REGION, addressNames[0]);
    AddressId secondAddressId = GlobalAddressId.of(REGION, addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listAddresses(Compute.AddressAggregatedListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.addressId());
      assertTrue(addressSet.contains(address.addressId().address()));
      assertNotNull(address.address());
      assertNotNull(address.creationTimestamp());
      assertNotNull(address.generatedId());
      count++;
    }
    assertEquals(2, count);
    compute.delete(firstAddressId);
    compute.delete(secondAddressId);
  }

  @Test
  public void testCreateGetAndDeleteGlobalAddress() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "create-and-get-global-address";
    AddressId addressId = GlobalAddressId.of(name);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get
    Address remoteAddress = compute.get(addressId);
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.addressId() instanceof GlobalAddressId);
    assertEquals(addressId.address(), remoteAddress.addressId().address());
    assertNotNull(remoteAddress.address());
    assertNotNull(remoteAddress.creationTimestamp());
    assertNotNull(remoteAddress.generatedId());
    assertNotNull(remoteAddress.status());
    // test get with selected fields
    remoteAddress = compute.get(addressId, Compute.AddressOption.fields());
    assertNotNull(remoteAddress);
    assertTrue(remoteAddress.addressId() instanceof GlobalAddressId);
    assertEquals(addressId.address(), remoteAddress.addressId().address());
    assertNull(remoteAddress.address());
    assertNull(remoteAddress.creationTimestamp());
    assertNull(remoteAddress.generatedId());
    operation = remoteAddress.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(addressId));
  }

  @Test
  public void testListGlobalAddresses() throws InterruptedException {
    String prefix = BASE_RESOURCE_NAME + "list-global-address";
    String[] addressNames = {prefix + "1", prefix + "2"};
    AddressId firstAddressId = GlobalAddressId.of(addressNames[0]);
    AddressId secondAddressId = GlobalAddressId.of(addressNames[1]);
    Operation firstOperation = compute.create(AddressInfo.of(firstAddressId));
    Operation secondOperation = compute.create(AddressInfo.of(secondAddressId));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> addressSet = ImmutableSet.copyOf(addressNames);
    // test list
    Compute.AddressFilter filter =
        Compute.AddressFilter.equals(Compute.AddressField.NAME, prefix + "\\d");
    Page<Address> addressPage =
        compute.listGlobalAddresses(Compute.AddressListOption.filter(filter));
    Iterator<Address> addressIterator = addressPage.iterateAll();
    int count = 0;
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertNotNull(address.addressId());
      assertTrue(address.addressId() instanceof GlobalAddressId);
      assertTrue(addressSet.contains(address.addressId().address()));
      assertNotNull(address.address());
      assertNotNull(address.creationTimestamp());
      assertNotNull(address.generatedId());
      count++;
    }
    assertEquals(2, count);
    // test list with selected fields
    count = 0;
    addressPage = compute.listGlobalAddresses(Compute.AddressListOption.filter(filter),
        Compute.AddressListOption.fields(Compute.AddressField.ADDRESS));
    addressIterator = addressPage.iterateAll();
    while (addressIterator.hasNext()) {
      Address address = addressIterator.next();
      assertTrue(address.addressId() instanceof GlobalAddressId);
      assertTrue(addressSet.contains(address.addressId().address()));
      assertNotNull(address.address());
      assertNull(address.creationTimestamp());
      assertNull(address.generatedId());
      assertNull(address.status());
      assertNull(address.usage());
      count++;
    }
    assertEquals(2, count);
    compute.delete(firstAddressId);
    compute.delete(secondAddressId);
  }

  @Test
  public void testCreateGetResizeAndDeleteStandardDisk() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "create-and-get-standard-disk";
    DiskId diskId = DiskId.of(ZONE, name);
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get
    Disk remoteDisk = compute.get(diskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(diskId.disk(), remoteDisk.diskId().disk());
    assertNotNull(remoteDisk.creationTimestamp());
    assertNotNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof StandardDiskConfiguration);
    StandardDiskConfiguration remoteConfiguration = remoteDisk.configuration();
    assertEquals(100L, (long) remoteConfiguration.sizeGb());
    assertEquals("pd-ssd", remoteConfiguration.diskType().type());
    assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.type());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    operation = remoteDisk.resize(200L);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test resize and get with selected fields
    remoteDisk = compute.get(diskId, Compute.DiskOption.fields(Compute.DiskField.SIZE_GB));
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(diskId.disk(), remoteDisk.diskId().disk());
    assertNull(remoteDisk.creationTimestamp());
    assertNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof StandardDiskConfiguration);
    remoteConfiguration = remoteDisk.configuration();
    assertEquals(200L, (long) remoteConfiguration.sizeGb());
    assertEquals("pd-ssd", remoteConfiguration.diskType().type());
    assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.type());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    operation = remoteDisk.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(diskId));
  }

  @Test
  public void testCreateGetAndDeleteImageDisk() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "create-and-get-image-disk";
    DiskId diskId = DiskId.of(ZONE, name);
    DiskInfo diskInfo = DiskInfo.of(diskId, ImageDiskConfiguration.of(IMAGE_ID));
    Operation operation = compute.create(diskInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get
    Disk remoteDisk = compute.get(diskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(diskId.disk(), remoteDisk.diskId().disk());
    assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.creationStatus());
    assertNotNull(remoteDisk.creationTimestamp());
    assertNotNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof ImageDiskConfiguration);
    ImageDiskConfiguration remoteConfiguration = remoteDisk.configuration();
    assertEquals(IMAGE_ID, remoteConfiguration.sourceImage());
    assertNotNull(remoteConfiguration.sourceImageId());
    assertEquals(DiskConfiguration.Type.IMAGE, remoteConfiguration.type());
    assertNotNull(remoteConfiguration.sizeGb());
    assertEquals("pd-standard", remoteConfiguration.diskType().type());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    // test get with selected fields
    remoteDisk = compute.get(diskId, Compute.DiskOption.fields());
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(diskId.disk(), remoteDisk.diskId().disk());
    assertNull(remoteDisk.creationTimestamp());
    assertNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof ImageDiskConfiguration);
    remoteConfiguration = remoteDisk.configuration();
    assertEquals(IMAGE_ID, remoteConfiguration.sourceImage());
    assertNull(remoteConfiguration.sourceImageId());
    assertEquals(DiskConfiguration.Type.IMAGE, remoteConfiguration.type());
    assertNull(remoteConfiguration.sizeGb());
    assertEquals("pd-standard", remoteConfiguration.diskType().type());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    operation = remoteDisk.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(diskId));
  }

  @Test
  public void testCreateGetAndDeleteSnapshotAndSnapshotDisk() throws InterruptedException {
    String diskName = BASE_RESOURCE_NAME + "create-and-get-snapshot-disk1";
    String snapshotDiskName = BASE_RESOURCE_NAME + "create-and-get-snapshot-disk2";
    DiskId diskId = DiskId.of(ZONE, diskName);
    DiskId snapshotDiskId = DiskId.of(ZONE, snapshotDiskName);
    String snapshotName = BASE_RESOURCE_NAME + "create-and-get-snapshot";
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    Disk remoteDisk = compute.get(diskId);
    operation = remoteDisk.createSnapshot(snapshotName);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get snapshot with selected fields
    Snapshot snapshot = compute.getSnapshot(snapshotName,
        Compute.SnapshotOption.fields(Compute.SnapshotField.CREATION_TIMESTAMP));
    assertNull(snapshot.generatedId());
    assertNotNull(snapshot.snapshotId());
    assertNotNull(snapshot.creationTimestamp());
    assertNull(snapshot.description());
    assertNull(snapshot.status());
    assertNull(snapshot.diskSizeGb());
    assertNull(snapshot.licenses());
    assertNull(snapshot.sourceDisk());
    assertNull(snapshot.sourceDiskId());
    assertNull(snapshot.storageBytes());
    assertNull(snapshot.storageBytesStatus());
    // test get snapshot
    snapshot = compute.getSnapshot(snapshotName);
    assertNotNull(snapshot.generatedId());
    assertNotNull(snapshot.snapshotId());
    assertNotNull(snapshot.creationTimestamp());
    assertNotNull(snapshot.status());
    assertEquals(100L, (long) snapshot.diskSizeGb());
    assertEquals(diskName, snapshot.sourceDisk().disk());
    assertNotNull(snapshot.sourceDiskId());
    assertNotNull(snapshot.storageBytes());
    assertNotNull(snapshot.storageBytesStatus());
    remoteDisk.delete();
    diskInfo =
        DiskInfo.of(snapshotDiskId, SnapshotDiskConfiguration.of(SnapshotId.of(snapshotName)));
    operation = compute.create(diskInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get disk
    remoteDisk = compute.get(snapshotDiskId);
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(snapshotDiskId.disk(), remoteDisk.diskId().disk());
    assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.creationStatus());
    assertNotNull(remoteDisk.creationTimestamp());
    assertNotNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof SnapshotDiskConfiguration);
    SnapshotDiskConfiguration remoteConfiguration = remoteDisk.configuration();
    assertEquals(DiskConfiguration.Type.SNAPSHOT, remoteConfiguration.type());
    assertEquals(snapshotName, remoteConfiguration.sourceSnapshot().snapshot());
    assertEquals(100L, (long) remoteConfiguration.sizeGb());
    assertEquals("pd-standard", remoteConfiguration.diskType().type());
    assertNotNull(remoteConfiguration.sourceSnapshotId());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    // test get disk with selected fields
    remoteDisk = compute.get(snapshotDiskId, Compute.DiskOption.fields());
    assertNotNull(remoteDisk);
    assertEquals(ZONE, remoteDisk.diskId().zone());
    assertEquals(snapshotDiskId.disk(), remoteDisk.diskId().disk());
    assertNull(remoteDisk.creationStatus());
    assertNull(remoteDisk.creationTimestamp());
    assertNull(remoteDisk.generatedId());
    assertTrue(remoteDisk.configuration() instanceof SnapshotDiskConfiguration);
    remoteConfiguration = remoteDisk.configuration();
    assertEquals(DiskConfiguration.Type.SNAPSHOT, remoteConfiguration.type());
    assertEquals(snapshotName, remoteConfiguration.sourceSnapshot().snapshot());
    assertNull(remoteConfiguration.sizeGb());
    assertEquals("pd-standard", remoteConfiguration.diskType().type());
    assertNull(remoteDisk.<SnapshotDiskConfiguration>configuration().sourceSnapshotId());
    assertNull(remoteDisk.lastAttachTimestamp());
    assertNull(remoteDisk.lastDetachTimestamp());
    operation = remoteDisk.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(snapshotDiskId));
    operation = snapshot.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.getSnapshot(snapshotName));
  }

  @Test
  public void testListDisksAndSnapshots() throws InterruptedException {
    String prefix = BASE_RESOURCE_NAME + "list-disks-and-snapshots-disk";
    String[] diskNames = {prefix + "1", prefix + "2"};
    DiskId firstDiskId = DiskId.of(ZONE, diskNames[0]);
    DiskId secondDiskId = DiskId.of(ZONE, diskNames[1]);
    DiskConfiguration configuration =
        StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L);
    Operation firstOperation = compute.create(DiskInfo.of(firstDiskId, configuration));
    Operation secondOperation = compute.create(DiskInfo.of(secondDiskId, configuration));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> diskSet = ImmutableSet.copyOf(diskNames);
    // test list disks
    Compute.DiskFilter diskFilter =
        Compute.DiskFilter.equals(Compute.DiskField.NAME, prefix + "\\d");
    Page<Disk> diskPage = compute.listDisks(ZONE, Compute.DiskListOption.filter(diskFilter));
    Iterator<Disk> diskIterator = diskPage.iterateAll();
    int count = 0;
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertEquals(ZONE, remoteDisk.diskId().zone());
      assertTrue(diskSet.contains(remoteDisk.diskId().disk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.creationStatus());
      assertNotNull(remoteDisk.creationTimestamp());
      assertNotNull(remoteDisk.generatedId());
      assertTrue(remoteDisk.configuration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.configuration();
      assertEquals(100L, (long) remoteConfiguration.sizeGb());
      assertEquals("pd-ssd", remoteConfiguration.diskType().type());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.type());
      assertNull(remoteDisk.lastAttachTimestamp());
      assertNull(remoteDisk.lastDetachTimestamp());
      count++;
    }
    assertEquals(2, count);
    // test list disks with selected fields
    count = 0;
    diskPage = compute.listDisks(ZONE, Compute.DiskListOption.filter(diskFilter),
        Compute.DiskListOption.fields(Compute.DiskField.STATUS));
    diskIterator = diskPage.iterateAll();
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertEquals(ZONE, remoteDisk.diskId().zone());
      assertTrue(diskSet.contains(remoteDisk.diskId().disk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.creationStatus());
      assertNull(remoteDisk.creationTimestamp());
      assertNull(remoteDisk.generatedId());
      assertTrue(remoteDisk.configuration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.configuration();
      assertNull(remoteConfiguration.sizeGb());
      assertEquals("pd-ssd", remoteConfiguration.diskType().type());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.type());
      assertNull(remoteDisk.lastAttachTimestamp());
      assertNull(remoteDisk.lastDetachTimestamp());
      count++;
    }
    assertEquals(2, count);
    // test snapshots
    SnapshotId firstSnapshotId = SnapshotId.of(diskNames[0]);
    SnapshotId secondSnapshotId = SnapshotId.of(diskNames[1]);
    firstOperation = compute.create(SnapshotInfo.of(firstSnapshotId, firstDiskId));
    secondOperation = compute.create(SnapshotInfo.of(secondSnapshotId, secondDiskId));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    // test list snapshots
    Compute.SnapshotFilter snapshotFilter =
        Compute.SnapshotFilter.equals(Compute.SnapshotField.NAME, prefix + "\\d");
    Page<Snapshot> snapshotPage =
        compute.listSnapshots(Compute.SnapshotListOption.filter(snapshotFilter));
    Iterator<Snapshot> snapshotIterator = snapshotPage.iterateAll();
    count = 0;
    while (snapshotIterator.hasNext()) {
      Snapshot remoteSnapshot = snapshotIterator.next();
      assertNotNull(remoteSnapshot.generatedId());
      assertTrue(diskSet.contains(remoteSnapshot.snapshotId().snapshot()));
      assertNotNull(remoteSnapshot.creationTimestamp());
      assertNotNull(remoteSnapshot.status());
      assertEquals(100L, (long) remoteSnapshot.diskSizeGb());
      assertTrue(diskSet.contains(remoteSnapshot.sourceDisk().disk()));
      assertNotNull(remoteSnapshot.sourceDiskId());
      assertNotNull(remoteSnapshot.storageBytes());
      assertNotNull(remoteSnapshot.storageBytesStatus());
      count++;
    }
    assertEquals(2, count);
    // test list snapshots with selected fields
    snapshotPage = compute.listSnapshots(Compute.SnapshotListOption.filter(snapshotFilter),
        Compute.SnapshotListOption.fields(Compute.SnapshotField.CREATION_TIMESTAMP));
    snapshotIterator = snapshotPage.iterateAll();
    count = 0;
    while (snapshotIterator.hasNext()) {
      Snapshot remoteSnapshot = snapshotIterator.next();
      assertNull(remoteSnapshot.generatedId());
      assertTrue(diskSet.contains(remoteSnapshot.snapshotId().snapshot()));
      assertNotNull(remoteSnapshot.creationTimestamp());
      assertNull(remoteSnapshot.status());
      assertNull(remoteSnapshot.diskSizeGb());
      assertNull(remoteSnapshot.sourceDisk());
      assertNull(remoteSnapshot.sourceDiskId());
      assertNull(remoteSnapshot.storageBytes());
      assertNull(remoteSnapshot.storageBytesStatus());
      count++;
    }
    assertEquals(2, count);
    compute.delete(firstDiskId);
    compute.delete(secondDiskId);
    compute.deleteSnapshot(firstSnapshotId);
    compute.deleteSnapshot(secondSnapshotId);
  }

  @Test
  public void testAggregatedListDisks() throws InterruptedException {
    String prefix = BASE_RESOURCE_NAME + "list-aggregated-disk";
    String[] diskZones = {"us-central1-a", "us-east1-c"};
    String[] diskNames = {prefix + "1", prefix + "2"};
    DiskId firstDiskId = DiskId.of(diskZones[0], diskNames[0]);
    DiskId secondDiskId = DiskId.of(diskZones[1], diskNames[1]);
    DiskConfiguration configuration =
        StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L);
    Operation firstOperation = compute.create(DiskInfo.of(firstDiskId, configuration));
    Operation secondOperation = compute.create(DiskInfo.of(secondDiskId, configuration));
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> zoneSet = ImmutableSet.copyOf(diskZones);
    Set<String> diskSet = ImmutableSet.copyOf(diskNames);
    Compute.DiskFilter diskFilter =
        Compute.DiskFilter.equals(Compute.DiskField.NAME, prefix + "\\d");
    Page<Disk> diskPage = compute.listDisks(Compute.DiskAggregatedListOption.filter(diskFilter));
    Iterator<Disk> diskIterator = diskPage.iterateAll();
    int count = 0;
    while (diskIterator.hasNext()) {
      Disk remoteDisk = diskIterator.next();
      assertTrue(zoneSet.contains(remoteDisk.diskId().zone()));
      assertTrue(diskSet.contains(remoteDisk.diskId().disk()));
      assertEquals(DiskInfo.CreationStatus.READY, remoteDisk.creationStatus());
      assertNotNull(remoteDisk.creationTimestamp());
      assertNotNull(remoteDisk.generatedId());
      assertTrue(remoteDisk.configuration() instanceof StandardDiskConfiguration);
      StandardDiskConfiguration remoteConfiguration = remoteDisk.configuration();
      assertEquals(100L, (long) remoteConfiguration.sizeGb());
      assertEquals("pd-ssd", remoteConfiguration.diskType().type());
      assertEquals(DiskConfiguration.Type.STANDARD, remoteConfiguration.type());
      count++;
    }
    assertEquals(2, count);
    compute.delete(firstDiskId);
    compute.delete(secondDiskId);
  }

  @Test
  public void testCreateGetAndDeprecateImage() throws InterruptedException {
    String diskName = BASE_RESOURCE_NAME + "create-and-get-image-disk";
    String imageName = BASE_RESOURCE_NAME + "create-and-get-image";
    DiskId diskId = DiskId.of(ZONE, diskName);
    ImageId imageId = ImageId.of(imageName);
    DiskInfo diskInfo =
        DiskInfo.of(diskId, StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"), 100L));
    Operation operation = compute.create(diskInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    Disk remoteDisk = compute.get(diskId);
    ImageInfo imageInfo = ImageInfo.of(imageId, DiskImageConfiguration.of(diskId));
    operation = compute.create(imageInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get image with selected fields
    Image image = compute.get(imageId,
        Compute.ImageOption.fields(Compute.ImageField.CREATION_TIMESTAMP));
    assertNull(image.generatedId());
    assertNotNull(image.imageId());
    assertNotNull(image.creationTimestamp());
    assertNull(image.description());
    assertNotNull(image.configuration());
    assertTrue(image.configuration() instanceof DiskImageConfiguration);
    DiskImageConfiguration remoteConfiguration = image.configuration();
    assertEquals(ImageConfiguration.Type.DISK, remoteConfiguration.type());
    assertEquals(diskName, remoteConfiguration.sourceDisk().disk());
    assertNull(image.status());
    assertNull(image.diskSizeGb());
    assertNull(image.licenses());
    assertNull(image.deprecationStatus());
    // test get image
    image = compute.get(imageId);
    assertNotNull(image.generatedId());
    assertNotNull(image.imageId());
    assertNotNull(image.creationTimestamp());
    assertNotNull(image.configuration());
    assertTrue(image.configuration() instanceof DiskImageConfiguration);
    remoteConfiguration = image.configuration();
    assertEquals(ImageConfiguration.Type.DISK, remoteConfiguration.type());
    assertEquals(diskName, remoteConfiguration.sourceDisk().disk());
    assertEquals(100L, (long) image.diskSizeGb());
    assertNotNull(image.status());
    assertNull(image.deprecationStatus());
    // test deprecate image
    DeprecationStatus<ImageId> deprecationStatus =
        DeprecationStatus.builder(DeprecationStatus.Status.DEPRECATED, imageId)
            .deprecated(System.currentTimeMillis())
            .build();
    operation = image.deprecate(deprecationStatus);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    image = compute.get(imageId);
    assertEquals(deprecationStatus, image.deprecationStatus());
    remoteDisk.delete();
    operation = image.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(imageId));
  }

  @Test
  public void testListImages() {
    Page<Image> imagePage = compute.listImages(IMAGE_PROJECT);
    Iterator<Image> imageIterator = imagePage.iterateAll();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.generatedId());
      assertNotNull(image.imageId());
      assertNotNull(image.creationTimestamp());
      assertNotNull(image.configuration());
      assertNotNull(image.status());
      assertNotNull(image.diskSizeGb());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testListImagesWithSelectedFields() {
    Page<Image> imagePage =
        compute.listImages(IMAGE_PROJECT, Compute.ImageListOption.fields(Compute.ImageField.ID));
    Iterator<Image> imageIterator = imagePage.iterateAll();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.generatedId());
      assertNotNull(image.imageId());
      assertNull(image.creationTimestamp());
      assertNotNull(image.configuration());
      assertNull(image.status());
      assertNull(image.diskSizeGb());
      assertNull(image.licenses());
      assertNull(image.deprecationStatus());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testListImagesWithFilter() {
    Page<Image> imagePage = compute.listImages(IMAGE_PROJECT, Compute.ImageListOption.filter(
        Compute.ImageFilter.equals(Compute.ImageField.ARCHIVE_SIZE_BYTES, 365056004L)));
    Iterator<Image> imageIterator = imagePage.iterateAll();
    int count = 0;
    while (imageIterator.hasNext()) {
      count++;
      Image image = imageIterator.next();
      assertNotNull(image.generatedId());
      assertNotNull(image.imageId());
      assertNotNull(image.creationTimestamp());
      assertNotNull(image.configuration());
      assertNotNull(image.status());
      assertNotNull(image.diskSizeGb());
      assertEquals(365056004L,
          (long) image.<StorageImageConfiguration>configuration().archiveSizeBytes());
    }
    assertTrue(count > 0);
  }

  @Test
  public void testCreateAndGetNetwork() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "create-and-get-network";
    NetworkId networkId = NetworkId.of(name);
    NetworkInfo networkInfo =
        NetworkInfo.of(networkId, StandardNetworkConfiguration.of("192.168.0.0/16"));
    Operation operation = compute.create(networkInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get network with selected fields
    Network network = compute.getNetwork(networkId.network(),
        Compute.NetworkOption.fields(Compute.NetworkField.CREATION_TIMESTAMP));
    assertEquals(networkId.network(), network.networkId().network());
    assertNull(network.generatedId());
    assertNotNull(network.creationTimestamp());
    assertNull(network.description());
    assertEquals(NetworkConfiguration.Type.STANDARD, network.configuration().type());
    StandardNetworkConfiguration remoteConfiguration = network.configuration();
    assertEquals("192.168.0.0/16", remoteConfiguration.ipRange());
    // test get network
    network = compute.getNetwork(networkId.network());
    assertEquals(networkId.network(), network.networkId().network());
    assertNotNull(network.generatedId());
    assertNotNull(network.creationTimestamp());
    assertEquals(NetworkConfiguration.Type.STANDARD, network.configuration().type());
    remoteConfiguration = network.configuration();
    assertEquals("192.168.0.0/16", remoteConfiguration.ipRange());
    operation = network.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.getNetwork(name));
  }

  @Test
  public void testListNetworks() throws InterruptedException {
    String name = BASE_RESOURCE_NAME + "list-network";
    NetworkId networkId = NetworkId.of(name);
    NetworkInfo networkInfo =
        NetworkInfo.of(networkId, StandardNetworkConfiguration.of("192.168.0.0/16"));
    Operation operation = compute.create(networkInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test list
    Compute.NetworkFilter filter = Compute.NetworkFilter.equals(Compute.NetworkField.NAME, name);
    Page<Network> networkPage = compute.listNetworks(Compute.NetworkListOption.filter(filter));
    Iterator<Network> networkIterator = networkPage.iterateAll();
    int count = 0;
    while (networkIterator.hasNext()) {
      Network network = networkIterator.next();
      assertEquals(networkId.network(), network.networkId().network());
      assertNotNull(network.generatedId());
      assertNotNull(network.creationTimestamp());
      assertEquals(NetworkConfiguration.Type.STANDARD, network.configuration().type());
      StandardNetworkConfiguration remoteConfiguration = network.configuration();
      assertEquals("192.168.0.0/16", remoteConfiguration.ipRange());
      count++;
    }
    assertEquals(1, count);
    // test list with selected fields
    count = 0;
    networkPage = compute.listNetworks(Compute.NetworkListOption.filter(filter),
        Compute.NetworkListOption.fields(Compute.NetworkField.CREATION_TIMESTAMP));
    networkIterator = networkPage.iterateAll();
    while (networkIterator.hasNext()) {
      Network network = networkIterator.next();
      assertEquals(networkId.network(), network.networkId().network());
      assertNull(network.generatedId());
      assertNotNull(network.creationTimestamp());
      assertNull(network.description());
      assertEquals(NetworkConfiguration.Type.STANDARD, network.configuration().type());
      StandardNetworkConfiguration remoteConfiguration = network.configuration();
      assertEquals("192.168.0.0/16", remoteConfiguration.ipRange());
      count++;
    }
    assertEquals(1, count);
    operation = compute.deleteNetwork(networkId);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.getNetwork(name));
  }

  @Test
  public void testCreateNetworkAndSubnetwork() throws InterruptedException {
    String networkName = BASE_RESOURCE_NAME + "create-subnetwork-network";
    NetworkId networkId = NetworkId.of(networkName);
    NetworkInfo networkInfo = NetworkInfo.of(networkId, SubnetNetworkConfiguration.of(false));
    Operation operation = compute.create(networkInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get network
    Network network = compute.getNetwork(networkId.network());
    assertEquals(networkId.network(), network.networkId().network());
    assertNotNull(network.generatedId());
    assertNotNull(network.creationTimestamp());
    assertEquals(NetworkConfiguration.Type.SUBNET, network.configuration().type());
    assertTrue(network.configuration() instanceof SubnetNetworkConfiguration);
    assertFalse(network.<SubnetNetworkConfiguration>configuration().autoCreateSubnetworks());
    String subnetworkName = BASE_RESOURCE_NAME + "create-subnetwork-subnetwork";
    SubnetworkId subnetworkId = SubnetworkId.of(REGION, subnetworkName);
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(subnetworkId, networkId, "192.168.0.0/16");
    operation = compute.create(subnetworkInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get subnetwork with selected fields
    Subnetwork subnetwork = compute.get(subnetworkId,
        Compute.SubnetworkOption.fields(Compute.SubnetworkField.CREATION_TIMESTAMP));
    assertNull(subnetwork.generatedId());
    assertEquals(subnetworkId.subnetwork(), subnetwork.subnetworkId().subnetwork());
    assertNotNull(subnetwork.creationTimestamp());
    assertNull(subnetwork.description());
    assertNull(subnetwork.gatewayAddress());
    assertNull(subnetwork.network());
    assertNull(subnetwork.ipRange());
    // test get subnetwork
    subnetwork = compute.get(subnetworkId);
    assertNotNull(subnetwork.generatedId());
    assertEquals(subnetworkId.subnetwork(), subnetwork.subnetworkId().subnetwork());
    assertNotNull(subnetwork.creationTimestamp());
    assertNotNull(subnetwork.gatewayAddress());
    assertEquals(networkId.network(), subnetwork.network().network());
    assertEquals("192.168.0.0/16", subnetwork.ipRange());
    // test list subnetworks
    Compute.SubnetworkFilter filter =
        Compute.SubnetworkFilter.equals(Compute.SubnetworkField.NAME, subnetworkName);
    Page<Subnetwork> subnetworkPage =
        compute.listSubnetworks(REGION, Compute.SubnetworkListOption.filter(filter));
    Iterator<Subnetwork> subnetworkIterator = subnetworkPage.iterateAll();
    int count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNotNull(remoteSubnetwork.generatedId());
      assertEquals(subnetworkId.subnetwork(), remoteSubnetwork.subnetworkId().subnetwork());
      assertNotNull(remoteSubnetwork.creationTimestamp());
      assertNotNull(remoteSubnetwork.gatewayAddress());
      assertEquals(networkId.network(), remoteSubnetwork.network().network());
      assertEquals("192.168.0.0/16", remoteSubnetwork.ipRange());
      count++;
    }
    assertEquals(1, count);
    // test list subnetworks with selected fields
    subnetworkPage = compute.listSubnetworks(REGION, Compute.SubnetworkListOption.filter(filter),
        Compute.SubnetworkListOption.fields(Compute.SubnetworkField.CREATION_TIMESTAMP));
    subnetworkIterator = subnetworkPage.iterateAll();
    count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNull(remoteSubnetwork.generatedId());
      assertEquals(subnetworkId.subnetwork(), remoteSubnetwork.subnetworkId().subnetwork());
      assertNotNull(remoteSubnetwork.creationTimestamp());
      assertNull(remoteSubnetwork.description());
      assertNull(remoteSubnetwork.gatewayAddress());
      assertNull(remoteSubnetwork.network());
      assertNull(remoteSubnetwork.ipRange());
      count++;
    }
    assertEquals(1, count);
    operation = subnetwork.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    operation = compute.deleteNetwork(networkId);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(subnetworkId));
    assertNull(compute.getNetwork(networkName));
  }

  @Test
  public void testAggregatedListSubnetworks() throws InterruptedException {
    String networkName = BASE_RESOURCE_NAME + "list-subnetwork-network";
    NetworkId networkId = NetworkId.of(networkName);
    NetworkInfo networkInfo = NetworkInfo.of(networkId, SubnetNetworkConfiguration.of(false));
    Operation operation = compute.create(networkInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
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
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Set<String> regionSet = ImmutableSet.copyOf(regionNames);
    Set<String> subnetworkSet = ImmutableSet.copyOf(subnetworkNames);
    Set<String> rangeSet = ImmutableSet.copyOf(ipRanges);
    Compute.SubnetworkFilter subnetworkFilter =
        Compute.SubnetworkFilter.equals(Compute.SubnetworkField.NAME, prefix + "\\d");
    Page<Subnetwork> subnetworkPage =
        compute.listSubnetworks(Compute.SubnetworkAggregatedListOption.filter(subnetworkFilter));
    Iterator<Subnetwork> subnetworkIterator = subnetworkPage.iterateAll();
    int count = 0;
    while (subnetworkIterator.hasNext()) {
      Subnetwork remoteSubnetwork = subnetworkIterator.next();
      assertNotNull(remoteSubnetwork.generatedId());
      assertTrue(regionSet.contains(remoteSubnetwork.subnetworkId().region()));
      assertTrue(subnetworkSet.contains(remoteSubnetwork.subnetworkId().subnetwork()));
      assertNotNull(remoteSubnetwork.creationTimestamp());
      assertNotNull(remoteSubnetwork.gatewayAddress());
      assertEquals(networkId.network(), remoteSubnetwork.network().network());
      assertTrue(rangeSet.contains(remoteSubnetwork.ipRange()));
      count++;
    }
    assertEquals(2, count);
    firstOperation = compute.delete(firstSubnetworkId);
    secondOperation = compute.delete(secondSubnetworkId);
    while (!firstOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!secondOperation.isDone()) {
      Thread.sleep(1000L);
    }
    operation = compute.deleteNetwork(networkId);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.getNetwork(networkName));
  }

  @Test
  public void testCreateGetAndDeleteInstance() throws InterruptedException {
    String instanceName = BASE_RESOURCE_NAME + "create-and-get-instance";
    String addressName = BASE_RESOURCE_NAME + "create-and-get-instance-address";
    // Create an address to assign to the instance
    AddressId addressId = RegionAddressId.of(REGION, addressName);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation operation = compute.create(addressInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    Address address = compute.get(addressId);
    // Create an instance
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.builder(networkId)
        .accessConfigurations(AccessConfig.builder().name("NAT").natIp(address.address()).build())
        .build();
    AttachedDisk disk1 = AttachedDisk.of("dev0",
        CreateDiskConfiguration.builder(IMAGE_ID).autoDelete(true).build());
    AttachedDisk disk2 =
        AttachedDisk.of("dev1", ScratchDiskConfiguration.of(DiskTypeId.of(ZONE, DISK_TYPE)));
    InstanceInfo instanceInfo =
        InstanceInfo.builder(instanceId, MachineTypeId.of(ZONE, "n1-standard-1"))
            .attachedDisks(disk1, disk2)
            .networkInterfaces(networkInterface)
            .build();
    operation = compute.create(instanceInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // test get
    Instance remoteInstance = compute.get(instanceId);
    assertEquals(instanceName, remoteInstance.instanceId().instance());
    assertEquals(ZONE, remoteInstance.instanceId().zone());
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.status());
    assertEquals("n1-standard-1", remoteInstance.machineType().type());
    assertEquals(ZONE, remoteInstance.machineType().zone());
    assertNotNull(remoteInstance.creationTimestamp());
    Set<String> deviceSet = ImmutableSet.of("dev0", "dev1");
    assertEquals(2, remoteInstance.attachedDisks().size());
    for (AttachedDisk remoteAttachedDisk : remoteInstance.attachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.deviceName()));
    }
    assertEquals(AttachedDiskConfiguration.Type.PERSISTENT,
        remoteInstance.attachedDisks().get(0).configuration().type());
    PersistentDiskConfiguration remoteConfiguration =
        remoteInstance.attachedDisks().get(0).configuration();
    assertEquals(instanceName, remoteConfiguration.sourceDisk().disk());
    assertEquals(ZONE, remoteConfiguration.sourceDisk().zone());
    assertTrue(remoteConfiguration.boot());
    assertTrue(remoteConfiguration.autoDelete());
    assertEquals(1, remoteInstance.networkInterfaces().size());
    NetworkInterface remoteNetworkInterface = remoteInstance.networkInterfaces().get(0);
    assertNotNull(remoteNetworkInterface.name());
    assertEquals("default", remoteNetworkInterface.network().network());
    List<AccessConfig> remoteAccessConfigurations = remoteNetworkInterface.accessConfigurations();
    assertNotNull(remoteAccessConfigurations);
    assertEquals(1, remoteAccessConfigurations.size());
    AccessConfig remoteAccessConfig = remoteAccessConfigurations.get(0);
    assertEquals(address.address(), remoteAccessConfig.natIp());
    assertEquals("NAT", remoteAccessConfig.name());
    assertNotNull(remoteInstance.metadata());
    assertNotNull(remoteInstance.tags());
    // test get with selected fields
    remoteInstance = compute.get(instanceId,
        Compute.InstanceOption.fields(Compute.InstanceField.CREATION_TIMESTAMP));
    assertEquals(instanceName, remoteInstance.instanceId().instance());
    assertEquals(ZONE, remoteInstance.instanceId().zone());
    assertNull(remoteInstance.machineType());
    assertNotNull(remoteInstance.creationTimestamp());
    assertNull(remoteInstance.attachedDisks());
    assertNull(remoteInstance.networkInterfaces());
    assertNull(remoteInstance.metadata());
    assertNull(remoteInstance.tags());
    // test get default serial port output
    String serialPortOutput = remoteInstance.getSerialPortOutput();
    assertNotNull(serialPortOutput);
    // test get serial port output by number
    String newSerialPortOutput = remoteInstance.getSerialPortOutput(1);
    assertTrue(newSerialPortOutput.contains(serialPortOutput));
    operation = remoteInstance.delete();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    assertNull(compute.get(instanceId));
    address.delete();
  }

  @Test
  public void testStartStopAndResetInstance() throws InterruptedException {
    String instanceName = BASE_RESOURCE_NAME + "start-stop-reset-instance";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.builder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        CreateDiskConfiguration.builder(IMAGE_ID).autoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.builder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .attachedDisks(disk)
            .networkInterfaces(networkInterface)
            .build();
    Operation operation = compute.create(instanceInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    Instance remoteInstance =
        compute.get(instanceId, Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.status());
    operation = remoteInstance.stop();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance =
        compute.get(instanceId, Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.TERMINATED, remoteInstance.status());
    operation = remoteInstance.start();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance =
        compute.get(instanceId, Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.status());
    operation = remoteInstance.reset();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance =
        compute.get(instanceId, Compute.InstanceOption.fields(Compute.InstanceField.STATUS));
    assertEquals(InstanceInfo.Status.RUNNING, remoteInstance.status());
    remoteInstance.delete();
  }

  @Test
  public void testSetInstanceProperties() throws InterruptedException {
    String instanceName = BASE_RESOURCE_NAME + "set-properties-instance";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.builder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        CreateDiskConfiguration.builder(IMAGE_ID).autoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.builder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .attachedDisks(disk)
            .networkInterfaces(networkInterface)
            .build();
    Operation operation = compute.create(instanceInfo);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    Instance remoteInstance = compute.get(instanceId);
    // test set tags
    List<String> tags = ImmutableList.of("tag1", "tag2");
    operation = remoteInstance.setTags(tags);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertEquals(tags, remoteInstance.tags().values());
    // test set metadata
    Map<String, String> metadata = ImmutableMap.of("key", "value");
    operation = remoteInstance.setMetadata(metadata);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertEquals(metadata, remoteInstance.metadata().values());
    // test set machine type
    operation = remoteInstance.stop();
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    operation = remoteInstance.setMachineType(MachineTypeId.of(ZONE, "n1-standard-1"));
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertEquals("n1-standard-1", remoteInstance.machineType().type());
    assertEquals(ZONE, remoteInstance.machineType().zone());
    // test set scheduling options
    SchedulingOptions options = SchedulingOptions.standard(false, Maintenance.TERMINATE);
    operation = remoteInstance.setSchedulingOptions(options);
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertEquals(options, remoteInstance.schedulingOptions());
    remoteInstance.delete();
  }

  @Test
  public void testAttachAndDetachDisk() throws InterruptedException {
    String instanceName = BASE_RESOURCE_NAME + "attach-and-detach-disk-instance";
    String diskName = BASE_RESOURCE_NAME + "attach-and-detach-disk";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.builder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        CreateDiskConfiguration.builder(IMAGE_ID).autoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.builder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .attachedDisks(disk)
            .networkInterfaces(networkInterface)
            .build();
    Operation instanceOperation = compute.create(instanceInfo);
    DiskId diskId = DiskId.of(ZONE, diskName);
    Operation diskOperation = compute.create(DiskInfo.of(diskId,
            StandardDiskConfiguration.of(DiskTypeId.of(ZONE, "pd-ssd"))));
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!diskOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Instance remoteInstance = compute.get(instanceId);
    // test attach disk
    instanceOperation = remoteInstance.attachDisk("dev1",
        PersistentDiskConfiguration.builder(diskId).build());
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    Set<String> deviceSet = ImmutableSet.of("dev0", "dev1");
    assertEquals(2, remoteInstance.attachedDisks().size());
    for (AttachedDisk remoteAttachedDisk : remoteInstance.attachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.deviceName()));
    }
    // test set disk auto-delete
    instanceOperation = remoteInstance.setDiskAutoDelete("dev1", true);
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    for (AttachedDisk remoteAttachedDisk : remoteInstance.attachedDisks()) {
      assertTrue(deviceSet.contains(remoteAttachedDisk.deviceName()));
      assertTrue(remoteAttachedDisk.configuration().autoDelete());
    }
    // test detach disk
    instanceOperation = remoteInstance.detachDisk("dev1");
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertEquals(1, remoteInstance.attachedDisks().size());
    assertEquals("dev0", remoteInstance.attachedDisks().get(0).deviceName());
    remoteInstance.delete();
  }

  @Test
  public void testAddAndRemoveAccessConfig() throws InterruptedException {
    String instanceName = BASE_RESOURCE_NAME + "add-and-remove-access-instance";
    String addressName = BASE_RESOURCE_NAME + "add-and-remove-access-address";
    InstanceId instanceId = InstanceId.of(ZONE, instanceName);
    NetworkId networkId = NetworkId.of("default");
    NetworkInterface networkInterface = NetworkInterface.builder(networkId).build();
    AttachedDisk disk = AttachedDisk.of("dev0",
        CreateDiskConfiguration.builder(IMAGE_ID).autoDelete(true).build());
    InstanceInfo instanceInfo =
        InstanceInfo.builder(instanceId, MachineTypeId.of(ZONE, MACHINE_TYPE))
            .attachedDisks(disk)
            .networkInterfaces(networkInterface)
            .build();
    Operation instanceOperation = compute.create(instanceInfo);
    AddressId addressId = RegionAddressId.of(REGION, addressName);
    AddressInfo addressInfo = AddressInfo.of(addressId);
    Operation addressOperation = compute.create(addressInfo);
    while (!addressOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    while (!addressOperation.isDone()) {
      Thread.sleep(1000L);
    }
    Address remoteAddress = compute.get(addressId);
    Instance remoteInstance = compute.get(instanceId);
    String networkInterfaceName = remoteInstance.networkInterfaces().get(0).name();
    // test add access config
    AccessConfig accessConfig = AccessConfig.builder()
        .natIp(remoteAddress.address())
        .name("NAT")
        .build();
    instanceOperation = remoteInstance.addAccessConfig(networkInterfaceName, accessConfig);
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    List<AccessConfig> accessConfigurations =
        remoteInstance.networkInterfaces().get(0).accessConfigurations();
    assertEquals(1, accessConfigurations.size());
    assertEquals("NAT", accessConfigurations.get(0).name());
    // test delete access config
    instanceOperation = remoteInstance.deleteAccessConfig(networkInterfaceName, "NAT");
    while (!instanceOperation.isDone()) {
      Thread.sleep(1000L);
    }
    remoteInstance = compute.get(instanceId);
    assertTrue(remoteInstance.networkInterfaces().get(0).accessConfigurations().isEmpty());
    remoteInstance.delete();
    remoteAddress.delete();
  }
}
