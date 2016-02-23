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

import java.math.BigInteger;
import java.util.List;

public class MachineTypeTest {

  private static final BigInteger ID = BigInteger.valueOf(42L);
  private static final String CREATION_TIMESTAMP = "2016-01-20T04:39:00.210-08:00";
  private static final String DESCRIPTION = "description";
  private static final MachineTypeId MACHINE_TYPE_ID = MachineTypeId.of("project", "zone", "type");
  private static final Integer GUEST_CPUS = 1;
  private static final Integer MEMORY_MB = 2;
  private static final List<Integer> SCRATCH_DISKS = ImmutableList.of(3);
  private static final Integer MAXIMUM_PERSISTENT_DISKS = 4;
  private static final Long MAXIMUM_PERSISTENT_DISKS_SIZE_GB = 5L;
  private static final String DELETED = "2016-01-20T04:39:00.210-08:00";
  private static final String DEPRECATED = "2016-01-20T04:37:00.210-08:00";
  private static final String OBSOLETE = "2016-01-20T04:38:00.210-08:00";
  private static final DeprecationStatus.Status STATUS = DeprecationStatus.Status.DELETED;
  private static final DeprecationStatus<MachineTypeId> DEPRECATION_STATUS =
      new DeprecationStatus<>(DELETED, DEPRECATED, OBSOLETE, MACHINE_TYPE_ID, STATUS);
  private static final MachineType MACHINE_TYPE = MachineType.builder()
      .id(ID)
      .machineTypeId(MACHINE_TYPE_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .selfLink(MACHINE_TYPE_ID.toUrl())
      .guestCpus(GUEST_CPUS)
      .memoryMb(MEMORY_MB)
      .scratchDisks(SCRATCH_DISKS)
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
    assertEquals(MACHINE_TYPE_ID.toUrl(), MACHINE_TYPE.selfLink());
    assertEquals(GUEST_CPUS, MACHINE_TYPE.guestCpus());
    assertEquals(MEMORY_MB, MACHINE_TYPE.memoryMb());
    assertEquals(SCRATCH_DISKS, MACHINE_TYPE.scratchDisks());
    assertEquals(MAXIMUM_PERSISTENT_DISKS, MACHINE_TYPE.maximumPersistentDisks());
    assertEquals(MAXIMUM_PERSISTENT_DISKS_SIZE_GB, MACHINE_TYPE.maximumPersistentDisksSizeGb());
    assertEquals(DEPRECATION_STATUS, MACHINE_TYPE.deprecationStatus());
  }

  @Test
  public void testToPbAndFromPb() {
    compareMachineTypes(MACHINE_TYPE, MachineType.fromPb(MACHINE_TYPE.toPb()));
    MachineType machineType = MachineType.builder()
        .id(ID)
        .machineTypeId(MACHINE_TYPE_ID)
        .selfLink(MACHINE_TYPE_ID.toUrl())
        .build();
    compareMachineTypes(machineType, MachineType.fromPb(machineType.toPb()));
  }

  private void compareMachineTypes(MachineType expected, MachineType value) {
    assertEquals(expected, value);
    assertEquals(expected.machineTypeId(), value.machineTypeId());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.guestCpus(), value.guestCpus());
    assertEquals(expected.memoryMb(), value.memoryMb());
    assertEquals(expected.scratchDisks(), value.scratchDisks());
    assertEquals(expected.maximumPersistentDisks(), value.maximumPersistentDisks());
    assertEquals(expected.maximumPersistentDisksSizeGb(), value.maximumPersistentDisksSizeGb());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
