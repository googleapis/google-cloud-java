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

import com.google.gcloud.compute.DeprecationStatus.Status;

import org.junit.Test;

public class DeprecationStatusTest {

  private static final String DELETED = "2016-01-20T04:39:00.210-08:00";
  private static final String DEPRECATED = "2016-01-20T04:37:00.210-08:00";
  private static final String OBSOLETE = "2016-01-20T04:38:00.210-08:00";
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone","diskType");
  private static final MachineTypeId MACHINE_TYPE_ID =
      MachineTypeId.of("project", "zone","machineType");
  private static final Status STATUS = Status.DELETED;
  private static final DeprecationStatus<DiskTypeId> DISK_TYPE_STATUS =
      new DeprecationStatus<>(DELETED, DEPRECATED, OBSOLETE, DISK_TYPE_ID, STATUS);
  private static final DeprecationStatus<MachineTypeId> MACHINE_TYPE_STATUS =
      new DeprecationStatus<>(DELETED, DEPRECATED, OBSOLETE, MACHINE_TYPE_ID, STATUS);

  @Test
  public void testConstructor() {
    assertEquals(DELETED, DISK_TYPE_STATUS.deleted());
    assertEquals(DEPRECATED, DISK_TYPE_STATUS.deprecated());
    assertEquals(OBSOLETE, DISK_TYPE_STATUS.obsolete());
    assertEquals(DISK_TYPE_ID, DISK_TYPE_STATUS.replacement());
    assertEquals(STATUS, DISK_TYPE_STATUS.status());
    assertEquals(DELETED, MACHINE_TYPE_STATUS.deleted());
    assertEquals(DEPRECATED, MACHINE_TYPE_STATUS.deprecated());
    assertEquals(OBSOLETE, MACHINE_TYPE_STATUS.obsolete());
    assertEquals(MACHINE_TYPE_ID, MACHINE_TYPE_STATUS.replacement());
    assertEquals(STATUS, MACHINE_TYPE_STATUS.status());
  }

  @Test
  public void testToAndFromPb() {
    DeprecationStatus<DiskTypeId> diskStatus =
        DeprecationStatus.fromPb(DISK_TYPE_STATUS.toPb(), DiskTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(DISK_TYPE_STATUS, diskStatus);
    DeprecationStatus<MachineTypeId> machineStatus =
        DeprecationStatus.fromPb(MACHINE_TYPE_STATUS.toPb(), MachineTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(MACHINE_TYPE_STATUS, machineStatus);
    diskStatus = new DeprecationStatus<>(null, DEPRECATED, null, DISK_TYPE_ID, STATUS);
    assertEquals(diskStatus,
        DeprecationStatus.fromPb(diskStatus.toPb(), DiskTypeId.FROM_URL_FUNCTION));
    machineStatus = new DeprecationStatus<>(null, DEPRECATED, null, MACHINE_TYPE_ID, STATUS);
    assertEquals(machineStatus,
        DeprecationStatus.fromPb(machineStatus.toPb(), MachineTypeId.FROM_URL_FUNCTION));
  }

  private void compareDeprecationStatus(DeprecationStatus expected, DeprecationStatus value) {
    assertEquals(expected, value);
    assertEquals(expected.deleted(), value.deleted());
    assertEquals(expected.deprecated(), value.deprecated());
    assertEquals(expected.obsolete(), value.obsolete());
    assertEquals(expected.replacement(), value.replacement());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
