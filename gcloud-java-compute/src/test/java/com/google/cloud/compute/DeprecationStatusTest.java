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

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

public class DeprecationStatusTest {

  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();
  private static final Long DELETED_MILLIS = 1453293540000L;
  private static final Long DEPRECATED_MILLIS = 1453293420000L;
  private static final Long OBSOLETE_MILLIS = 1453293480000L;
  private static final String DELETED = TIMESTAMP_FORMATTER.print(DELETED_MILLIS);
  private static final String DEPRECATED = TIMESTAMP_FORMATTER.print(DEPRECATED_MILLIS);
  private static final String OBSOLETE = TIMESTAMP_FORMATTER.print(OBSOLETE_MILLIS);
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final MachineTypeId MACHINE_TYPE_ID =
      MachineTypeId.of("project", "zone", "machineType");
  private static final DeprecationStatus.Status STATUS = DeprecationStatus.Status.DELETED;
  private static final DeprecationStatus<DiskTypeId> DISK_TYPE_STATUS =
      DeprecationStatus.<DiskTypeId>builder(STATUS)
          .replacement(DISK_TYPE_ID)
          .deprecated(DEPRECATED)
          .obsolete(OBSOLETE)
          .deleted(DELETED)
          .build();
  private static final DeprecationStatus<DiskTypeId> DISK_TYPE_STATUS_MILLIS =
      DeprecationStatus.<DiskTypeId>builder(STATUS)
          .replacement(DISK_TYPE_ID)
          .deprecated(DEPRECATED_MILLIS)
          .obsolete(OBSOLETE_MILLIS)
          .deleted(DELETED_MILLIS)
          .build();
  private static final DeprecationStatus<MachineTypeId> MACHINE_TYPE_STATUS =
      DeprecationStatus.builder(STATUS, MACHINE_TYPE_ID)
          .deprecated(DEPRECATED)
          .obsolete(OBSOLETE)
          .deleted(DELETED)
          .build();

  @Test
  public void testBuilder() {
    compareDeprecationStatus(DISK_TYPE_STATUS, DISK_TYPE_STATUS_MILLIS);
    assertEquals(DELETED, DISK_TYPE_STATUS.deleted());
    assertEquals(DEPRECATED, DISK_TYPE_STATUS.deprecated());
    assertEquals(OBSOLETE, DISK_TYPE_STATUS.obsolete());
    assertEquals(DISK_TYPE_ID, DISK_TYPE_STATUS.replacement());
    assertEquals(DEPRECATED_MILLIS, DISK_TYPE_STATUS.deprecatedMillis());
    assertEquals(DELETED_MILLIS, DISK_TYPE_STATUS.deletedMillis());
    assertEquals(OBSOLETE_MILLIS, DISK_TYPE_STATUS.obsoleteMillis());
    assertEquals(STATUS, DISK_TYPE_STATUS.status());
    assertEquals(DELETED, DISK_TYPE_STATUS_MILLIS.deleted());
    assertEquals(DEPRECATED, DISK_TYPE_STATUS_MILLIS.deprecated());
    assertEquals(OBSOLETE, DISK_TYPE_STATUS_MILLIS.obsolete());
    assertEquals(DISK_TYPE_ID, DISK_TYPE_STATUS_MILLIS.replacement());
    assertEquals(DEPRECATED_MILLIS, DISK_TYPE_STATUS_MILLIS.deprecatedMillis());
    assertEquals(DELETED_MILLIS, DISK_TYPE_STATUS_MILLIS.deletedMillis());
    assertEquals(OBSOLETE_MILLIS, DISK_TYPE_STATUS_MILLIS.obsoleteMillis());
    assertEquals(STATUS, DISK_TYPE_STATUS.status());
    assertEquals(DELETED, MACHINE_TYPE_STATUS.deleted());
    assertEquals(DEPRECATED, MACHINE_TYPE_STATUS.deprecated());
    assertEquals(OBSOLETE, MACHINE_TYPE_STATUS.obsolete());
    assertEquals(DEPRECATED_MILLIS, MACHINE_TYPE_STATUS.deprecatedMillis());
    assertEquals(DELETED_MILLIS, MACHINE_TYPE_STATUS.deletedMillis());
    assertEquals(OBSOLETE_MILLIS, MACHINE_TYPE_STATUS.obsoleteMillis());
    assertEquals(MACHINE_TYPE_ID, MACHINE_TYPE_STATUS.replacement());
    assertEquals(STATUS, MACHINE_TYPE_STATUS.status());
  }

  @Test
  public void testGettersIllegalArgument() {
    DeprecationStatus<MachineTypeId> deprecationStatus =
        DeprecationStatus.builder(STATUS, MACHINE_TYPE_ID)
            .deprecated("deprecated")
            .obsolete("obsolete")
            .deleted("delete")
            .build();
    assertEquals("deprecated", deprecationStatus.deprecated());
    try {
      deprecationStatus.deprecatedMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
    assertEquals("obsolete", deprecationStatus.obsolete());
    try {
      deprecationStatus.obsoleteMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
    assertEquals("delete", deprecationStatus.deleted());
    try {
      deprecationStatus.deletedMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
  }

  @Test
  public void testToBuilder() {
    compareDeprecationStatus(DISK_TYPE_STATUS, DISK_TYPE_STATUS.toBuilder().build());
    compareDeprecationStatus(MACHINE_TYPE_STATUS, MACHINE_TYPE_STATUS.toBuilder().build());
    DeprecationStatus<DiskTypeId> deprecationStatus = DISK_TYPE_STATUS.toBuilder()
        .deleted(DEPRECATED)
        .build();
    assertEquals(DEPRECATED, deprecationStatus.deleted());
    deprecationStatus = deprecationStatus.toBuilder().deleted(DELETED).build();
    compareDeprecationStatus(DISK_TYPE_STATUS, deprecationStatus);
  }

  @Test
  public void testToBuilderIncomplete() {
    DeprecationStatus<DiskTypeId> diskStatus = DeprecationStatus.of(STATUS, DISK_TYPE_ID);
    assertEquals(diskStatus, diskStatus.toBuilder().build());
  }

  @Test
  public void testOf() {
    DeprecationStatus<DiskTypeId> diskStatus = DeprecationStatus.of(STATUS, DISK_TYPE_ID);
    assertNull(diskStatus.deleted());
    assertNull(diskStatus.deprecated());
    assertNull(diskStatus.obsolete());
    assertEquals(DISK_TYPE_ID, diskStatus.replacement());
    assertEquals(STATUS, diskStatus.status());
  }

  @Test
  public void testToAndFromPb() {
    DeprecationStatus<DiskTypeId> diskStatus =
        DeprecationStatus.fromPb(DISK_TYPE_STATUS.toPb(), DiskTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(DISK_TYPE_STATUS, diskStatus);
    DeprecationStatus<MachineTypeId> machineStatus =
        DeprecationStatus.fromPb(MACHINE_TYPE_STATUS.toPb(), MachineTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(MACHINE_TYPE_STATUS, machineStatus);
    diskStatus = DeprecationStatus.builder(STATUS, DISK_TYPE_ID).deprecated(DEPRECATED).build();
    assertEquals(diskStatus,
        DeprecationStatus.fromPb(diskStatus.toPb(), DiskTypeId.FROM_URL_FUNCTION));
    machineStatus =
        DeprecationStatus.builder(STATUS, MACHINE_TYPE_ID).deprecated(DEPRECATED).build();
    assertEquals(machineStatus,
        DeprecationStatus.fromPb(machineStatus.toPb(), MachineTypeId.FROM_URL_FUNCTION));
    diskStatus = DeprecationStatus.of(STATUS, DISK_TYPE_ID);
    assertEquals(diskStatus,
        DeprecationStatus.fromPb(diskStatus.toPb(), DiskTypeId.FROM_URL_FUNCTION));
  }

  private void compareDeprecationStatus(DeprecationStatus expected, DeprecationStatus value) {
    assertEquals(expected, value);
    assertEquals(expected.deleted(), value.deleted());
    assertEquals(expected.deprecated(), value.deprecated());
    assertEquals(expected.obsolete(), value.obsolete());
    assertEquals(expected.deletedMillis(), value.deletedMillis());
    assertEquals(expected.deprecatedMillis(), value.deprecatedMillis());
    assertEquals(expected.obsoleteMillis(), value.obsoleteMillis());
    assertEquals(expected.replacement(), value.replacement());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
