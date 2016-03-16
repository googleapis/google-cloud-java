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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RetryParams;
import com.google.gcloud.compute.Zone.MaintenanceWindow;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class SerializationTest {

  private static final Compute COMPUTE = ComputeOptions.builder().projectId("p").build().service();
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
  private static final Long BEGIN_TIME = 1453293420000L;
  private static final Long END_TIME = 1453293480000L;
  private static final MaintenanceWindow WINDOW1 = new MaintenanceWindow("NAME1", "DESCRIPTION1",
      BEGIN_TIME, END_TIME);
  private static final MaintenanceWindow WINDOW2 = new MaintenanceWindow("NAME2", "DESCRIPTION2",
      BEGIN_TIME, END_TIME);
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
  private static final Long DELETED = 1453293540000L;
  private static final Long DEPRECATED = 1453293420000L;
  private static final Long OBSOLETE = 1453293480000L;
  private static final DeprecationStatus<MachineTypeId> DEPRECATION_STATUS =
      new DeprecationStatus<>(DELETED, DEPRECATED, OBSOLETE, MACHINE_TYPE_ID,
          DeprecationStatus.Status.DELETED);
  private static final LicenseId LICENSE_ID = LicenseId.of("project", "license");
  private static final Boolean CHARGES_USE_FEE = true;
  private static final License LICENSE = new License(LICENSE_ID, CHARGES_USE_FEE);
  private static final GlobalOperationId GLOBAL_OPERATION_ID =
      GlobalOperationId.of("project", "op");
  private static final ZoneOperationId ZONE_OPERATION_ID =
      ZoneOperationId.of("project", "zone", "op");
  private static final RegionOperationId REGION_OPERATION_ID =
      RegionOperationId.of("project", "region", "op");
  private static final Operation GLOBAL_OPERATION =
      new Operation.Builder(COMPUTE).operationId(GLOBAL_OPERATION_ID).build();
  private static final Operation ZONE_OPERATION =
      new Operation.Builder(COMPUTE).operationId(ZONE_OPERATION_ID).build();
  private static final Operation REGION_OPERATION =
      new Operation.Builder(COMPUTE).operationId(REGION_OPERATION_ID).build();
  private static final Compute.DiskTypeOption DISK_TYPE_OPTION =
      Compute.DiskTypeOption.fields();
  private static final Compute.DiskTypeFilter DISK_TYPE_FILTER =
      Compute.DiskTypeFilter.equals(Compute.DiskTypeField.SELF_LINK, "selfLink");
  private static final Compute.DiskTypeListOption DISK_TYPE_LIST_OPTION =
      Compute.DiskTypeListOption.filter(DISK_TYPE_FILTER);
  private static final Compute.DiskTypeAggregatedListOption DISK_TYPE_AGGREGATED_LIST_OPTION =
      Compute.DiskTypeAggregatedListOption.filter(DISK_TYPE_FILTER);
  private static final Compute.MachineTypeOption MACHINE_TYPE_OPTION =
      Compute.MachineTypeOption.fields();
  private static final Compute.MachineTypeFilter MACHINE_TYPE_FILTER =
      Compute.MachineTypeFilter.equals(Compute.MachineTypeField.SELF_LINK, "selfLink");
  private static final Compute.MachineTypeListOption MACHINE_TYPE_LIST_OPTION =
      Compute.MachineTypeListOption.filter(MACHINE_TYPE_FILTER);
  private static final Compute.MachineTypeAggregatedListOption MACHINE_TYPE_AGGREGATED_LIST_OPTION =
      Compute.MachineTypeAggregatedListOption.filter(MACHINE_TYPE_FILTER);
  private static final Compute.RegionOption REGION_OPTION = Compute.RegionOption.fields();
  private static final Compute.RegionFilter REGION_FILTER =
      Compute.RegionFilter.equals(Compute.RegionField.SELF_LINK, "selfLink");
  private static final Compute.RegionListOption REGION_LIST_OPTION =
      Compute.RegionListOption.filter(REGION_FILTER);
  private static final Compute.ZoneOption ZONE_OPTION = Compute.ZoneOption.fields();
  private static final Compute.ZoneFilter ZONE_FILTER =
      Compute.ZoneFilter.equals(Compute.ZoneField.SELF_LINK, "selfLink");
  private static final Compute.ZoneListOption ZONE_LIST_OPTION =
      Compute.ZoneListOption.filter(ZONE_FILTER);
  private static final Compute.LicenseOption LICENSE_OPTION = Compute.LicenseOption.fields();
  private static final Compute.OperationOption OPERATION_OPTION = Compute.OperationOption.fields();
  private static final Compute.OperationFilter OPERATION_FILTER =
      Compute.OperationFilter.equals(Compute.OperationField.SELF_LINK, "selfLink");
  private static final Compute.OperationListOption OPERATION_LIST_OPTION =
      Compute.OperationListOption.filter(OPERATION_FILTER);
  @Test
  public void testServiceOptions() throws Exception {
    ComputeOptions options = ComputeOptions.builder()
        .projectId("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    ComputeOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);

    options = options.toBuilder()
        .projectId("p2")
        .retryParams(RetryParams.defaultInstance())
        .authCredentials(null)
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {DISK_TYPE_ID, DISK_TYPE, MACHINE_TYPE_ID, MACHINE_TYPE, REGION_ID,
        REGION, ZONE_ID, ZONE, LICENSE_ID, LICENSE, DEPRECATION_STATUS, GLOBAL_OPERATION_ID,
        REGION_OPERATION_ID, ZONE_OPERATION_ID, GLOBAL_OPERATION, REGION_OPERATION, ZONE_OPERATION,
        DISK_TYPE_OPTION, DISK_TYPE_FILTER, DISK_TYPE_LIST_OPTION, DISK_TYPE_AGGREGATED_LIST_OPTION,
        MACHINE_TYPE_OPTION, MACHINE_TYPE_FILTER, MACHINE_TYPE_LIST_OPTION,
        MACHINE_TYPE_AGGREGATED_LIST_OPTION, REGION_OPTION, REGION_FILTER, REGION_LIST_OPTION,
        ZONE_OPTION, ZONE_FILTER, ZONE_LIST_OPTION, LICENSE_OPTION, OPERATION_OPTION,
        OPERATION_FILTER, OPERATION_LIST_OPTION};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
             new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
