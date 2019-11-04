/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class MachineTypeTest {

  private static final String GENERATED_ID = "42";
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
  private static final MachineType MACHINE_TYPE =
      MachineType.newBuilder()
          .setGeneratedId(GENERATED_ID)
          .setMachineTypeId(MACHINE_TYPE_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setCpus(CPUS)
          .setMemoryMb(MEMORY_MB)
          .setScratchDisksSizeGb(SCRATCH_DISKS)
          .setMaximumPersistentDisks(MAXIMUM_PERSISTENT_DISKS)
          .setMaximumPersistentDisksSizeGb(MAXIMUM_PERSISTENT_DISKS_SIZE_GB)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, MACHINE_TYPE.getGeneratedId());
    assertEquals(MACHINE_TYPE_ID, MACHINE_TYPE.getMachineTypeId());
    assertEquals(CREATION_TIMESTAMP, MACHINE_TYPE.getCreationTimestamp());
    assertEquals(DESCRIPTION, MACHINE_TYPE.getDescription());
    assertEquals(CPUS, MACHINE_TYPE.getCpus());
    assertEquals(MEMORY_MB, MACHINE_TYPE.getMemoryMb());
    assertEquals(SCRATCH_DISKS, MACHINE_TYPE.getScratchDisksSizeGb());
    assertEquals(MAXIMUM_PERSISTENT_DISKS, MACHINE_TYPE.getMaximumPersistentDisks());
    assertEquals(MAXIMUM_PERSISTENT_DISKS_SIZE_GB, MACHINE_TYPE.getMaximumPersistentDisksSizeGb());
    assertEquals(DEPRECATION_STATUS, MACHINE_TYPE.getDeprecationStatus());
  }

  @Test
  public void testToPbAndFromPb() {
    compareMachineTypes(MACHINE_TYPE, MachineType.fromPb(MACHINE_TYPE.toPb()));
    MachineType machineType = MachineType.newBuilder().setMachineTypeId(MACHINE_TYPE_ID).build();
    compareMachineTypes(machineType, MachineType.fromPb(machineType.toPb()));
  }

  private void compareMachineTypes(MachineType expected, MachineType value) {
    assertEquals(expected, value);
    assertEquals(expected.getMachineTypeId(), value.getMachineTypeId());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getCpus(), value.getCpus());
    assertEquals(expected.getMemoryMb(), value.getMemoryMb());
    assertEquals(expected.getScratchDisksSizeGb(), value.getScratchDisksSizeGb());
    assertEquals(expected.getMaximumPersistentDisks(), value.getMaximumPersistentDisks());
    assertEquals(
        expected.getMaximumPersistentDisksSizeGb(), value.getMaximumPersistentDisksSizeGb());
    assertEquals(expected.getDeprecationStatus(), value.getDeprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
