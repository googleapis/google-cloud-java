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

import com.google.gcloud.Page;
import com.google.gcloud.compute.Compute;
import com.google.gcloud.compute.DiskType;
import com.google.gcloud.compute.License;
import com.google.gcloud.compute.LicenseId;
import com.google.gcloud.compute.MachineType;
import com.google.gcloud.compute.Operation;
import com.google.gcloud.compute.Region;
import com.google.gcloud.compute.RegionOperationId;
import com.google.gcloud.compute.Zone;
import com.google.gcloud.compute.ZoneOperationId;
import com.google.gcloud.compute.testing.RemoteComputeHelper;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Iterator;

public class ITComputeTest {

  private static final String REGION = "us-central1";
  private static final String ZONE = "us-central1-a";
  private static final String DISK_TYPE = "local-ssd";
  private static final String MACHINE_TYPE = "f1-micro";
  private static final LicenseId LICENSE_ID = LicenseId.of("ubuntu-os-cloud", "ubuntu-1404-trusty");

  private static Compute compute;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws InterruptedException {
    RemoteComputeHelper computeHelper = RemoteComputeHelper.create();
    compute = computeHelper.options().service();
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE);
    // assertNotNull(diskType.id());
    assertEquals(ZONE, diskType.diskTypeId().zone());
    assertEquals(DISK_TYPE, diskType.diskTypeId().diskType());
    assertNotNull(diskType.creationTimestamp());
    assertNotNull(diskType.description());
    assertNotNull(diskType.validDiskSize());
    assertNotNull(diskType.defaultDiskSizeGb());
  }

  @Test
  public void testGetDiskTypeWithSelectedFields() {
    DiskType diskType = compute.getDiskType(ZONE, DISK_TYPE,
        Compute.DiskTypeOption.fields(Compute.DiskTypeField.CREATION_TIMESTAMP));
    // assertNotNull(diskType.id());
    assertEquals(ZONE, diskType.diskTypeId().zone());
    assertEquals(DISK_TYPE, diskType.diskTypeId().diskType());
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
    while(diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.id());
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
    while(diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertNull(diskType.id());
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
    while(diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.id());
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
    while(diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // assertNotNull(diskType.id());
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
    while(diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      // todo(mziccard): uncomment or remove once #695 is closed
      // assertNotNull(diskType.id());
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
    assertEquals(MACHINE_TYPE, machineType.machineTypeId().machineType());
    assertNotNull(machineType.id());
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
    assertEquals(MACHINE_TYPE, machineType.machineTypeId().machineType());
    assertNotNull(machineType.id());
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
    while(machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNotNull(machineType.id());
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
    while(machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNull(machineType.id());
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
    while(machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertEquals(ZONE, machineType.machineTypeId().zone());
      assertNotNull(machineType.id());
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
    while(machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertNotNull(machineType.id());
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
    while(machineTypeIterator.hasNext()) {
      MachineType machineType = machineTypeIterator.next();
      assertNotNull(machineType.machineTypeId());
      assertNotNull(machineType.id());
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
    License license= compute.getLicense(LICENSE_ID);
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
    assertNotNull(region.id());
    assertNotNull(region.quotas());
    assertNotNull(region.status());
    assertNotNull(region.zones());
  }

  @Test
  public void testGetRegionWithSelectedFields() {
    Region region = compute.getRegion(REGION, Compute.RegionOption.fields(Compute.RegionField.ID));
    assertEquals(REGION, region.regionId().region());
    assertNotNull(region.id());
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
    while(regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.regionId());
      assertNotNull(region.description());
      assertNotNull(region.creationTimestamp());
      assertNotNull(region.id());
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
    while(regionIterator.hasNext()) {
      Region region = regionIterator.next();
      assertNotNull(region.regionId());
      assertNull(region.description());
      assertNull(region.creationTimestamp());
      assertNotNull(region.id());
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
    assertNotNull(zone.id());
    assertNotNull(zone.creationTimestamp());
    assertNotNull(zone.description());
    assertNotNull(zone.status());
    assertNotNull(zone.region());
  }

  @Test
  public void testGetZoneWithSelectedFields() {
    Zone zone = compute.getZone(ZONE, Compute.ZoneOption.fields(Compute.ZoneField.ID));
    assertEquals(ZONE, zone.zoneId().zone());
    assertNotNull(zone.id());
    assertNull(zone.creationTimestamp());
    assertNull(zone.description());
    assertNull(zone.status());
    assertNull(zone.maintenanceWindows());
    assertNull(zone.region());
  }

  @Test
  public void testListZones() {
    Page<Zone> zonePage = compute.listZones();
    Iterator<Zone> zoneIterator = zonePage.iterateAll();
    while(zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.zoneId());
      assertNotNull(zone.id());
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
    while(zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      assertNotNull(zone.zoneId());
      assertNull(zone.id());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.creationTimestamp());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertEquals(REGION, operation.<RegionOperationId>operationId().region());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertEquals(REGION, operation.<RegionOperationId>operationId().region());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.creationTimestamp());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
      assertNull(operation.operationType());
      assertNull(operation.targetLink());
      assertNull(operation.targetId());
      assertNull(operation.creationTimestamp());
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
    while(operationIterator.hasNext()) {
      Operation operation = operationIterator.next();
      assertNotNull(operation.id());
      assertNotNull(operation.operationId());
      assertEquals(ZONE, operation.<ZoneOperationId>operationId().zone());
      // todo(mziccard): uncomment or remove once #727 is closed
      // assertNotNull(operation.creationTimestamp());
      assertNotNull(operation.operationType());
      assertEquals(Operation.Status.DONE, operation.status());
      assertNotNull(operation.user());
    }
  }
}
