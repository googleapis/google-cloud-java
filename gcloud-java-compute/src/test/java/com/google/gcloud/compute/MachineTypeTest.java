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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class MachineTypeTest {

  private static final String ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final MachineTypeId MACHINE_TYPE_ID = MachineTypeId.of("project", "zone", "type");
  private static final Integer CPUS = 1;
  private static final Integer MEMORY_MB = 2;
  private static final List<Integer> SCRATCH_DISKS = ImmutableList.of(3);
  private static final Integer MAXIMUM_PERSISTENT_DISKS = 4;
  private static final Long MAXIMUM_PERSISTENT_DISKS_SIZE_GB = 5L;
  private static final DeprecationStatus<MachineTypeId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, MACHINE_TYPE_ID);
  private static final MachineType MACHINE_TYPE = MachineType.builder()
      .id(ID)
      .machineTypeId(MACHINE_TYPE_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .cpus(CPUS)
      .memoryMb(MEMORY_MB)
      .scratchDisksSizeGb(SCRATCH_DISKS)
      .maximumPersistentDisks(MAXIMUM_PERSISTENT_DISKS)
      .maximumPersistentDisksSizeGb(MAXIMUM_PERSISTENT_DISKS_SIZE_GB)
      .deprecationStatus(DEPRECATION_STATUS)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(ID, MACHINE_TYPE.id());
    assertEquals(MACHINE_TYPE_ID, MACHINE_TYPE.machineTypeId());
    assertEquals(CREATION_TIMESTAMP, MACHINE_TYPE.creationTimestamp());
    assertEquals(DESCRIPTION, MACHINE_TYPE.description());
    assertEquals(CPUS, MACHINE_TYPE.cpus());
    assertEquals(MEMORY_MB, MACHINE_TYPE.memoryMb());
    assertEquals(SCRATCH_DISKS, MACHINE_TYPE.scratchDisksSizeGb());
    assertEquals(MAXIMUM_PERSISTENT_DISKS, MACHINE_TYPE.maximumPersistentDisks());
    assertEquals(MAXIMUM_PERSISTENT_DISKS_SIZE_GB, MACHINE_TYPE.maximumPersistentDisksSizeGb());
    assertEquals(DEPRECATION_STATUS, MACHINE_TYPE.deprecationStatus());
  }

  @Test
  public void testToPbAndFromPb() {
    compareMachineTypes(MACHINE_TYPE, MachineType.fromPb(MACHINE_TYPE.toPb()));
    MachineType machineType = MachineType.builder().machineTypeId(MACHINE_TYPE_ID).build();
    compareMachineTypes(machineType, MachineType.fromPb(machineType.toPb()));
  }

  private void compareMachineTypes(MachineType expected, MachineType value) {
    assertEquals(expected, value);
    assertEquals(expected.machineTypeId(), value.machineTypeId());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.cpus(), value.cpus());
    assertEquals(expected.memoryMb(), value.memoryMb());
    assertEquals(expected.scratchDisksSizeGb(), value.scratchDisksSizeGb());
    assertEquals(expected.maximumPersistentDisks(), value.maximumPersistentDisks());
    assertEquals(expected.maximumPersistentDisksSizeGb(), value.maximumPersistentDisksSizeGb());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
