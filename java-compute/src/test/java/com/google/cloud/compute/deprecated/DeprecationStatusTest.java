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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

public class DeprecationStatusTest {

  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);
  private static final Long DELETED_MILLIS = 1453293540000L;
  private static final Long DEPRECATED_MILLIS = 1453293420000L;
  private static final Long OBSOLETE_MILLIS = 1453293480000L;
  private static final String DELETED =
      TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(DELETED_MILLIS));
  private static final String DEPRECATED =
      TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(DEPRECATED_MILLIS));
  private static final String OBSOLETE =
      TIMESTAMP_FORMATTER.format(Instant.ofEpochMilli(OBSOLETE_MILLIS));
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final MachineTypeId MACHINE_TYPE_ID =
      MachineTypeId.of("project", "zone", "machineType");
  private static final DeprecationStatus.Status STATUS = DeprecationStatus.Status.DELETED;
  private static final DeprecationStatus<DiskTypeId> DISK_TYPE_STATUS =
      DeprecationStatus.<DiskTypeId>newBuilder(STATUS)
          .setReplacement(DISK_TYPE_ID)
          .setDeprecated(DEPRECATED)
          .setObsolete(OBSOLETE)
          .setDeleted(DELETED)
          .build();
  private static final DeprecationStatus<DiskTypeId> DISK_TYPE_STATUS_MILLIS =
      DeprecationStatus.<DiskTypeId>newBuilder(STATUS)
          .setReplacement(DISK_TYPE_ID)
          .setDeprecated(DEPRECATED_MILLIS)
          .setObsolete(OBSOLETE_MILLIS)
          .setDeleted(DELETED_MILLIS)
          .build();
  private static final DeprecationStatus<MachineTypeId> MACHINE_TYPE_STATUS =
      DeprecationStatus.newBuilder(STATUS, MACHINE_TYPE_ID)
          .setDeprecated(DEPRECATED)
          .setObsolete(OBSOLETE)
          .setDeleted(DELETED)
          .build();

  @Test
  public void testBuilder() {
    compareDeprecationStatus(DISK_TYPE_STATUS, DISK_TYPE_STATUS_MILLIS);
    assertEquals(DELETED, DISK_TYPE_STATUS.getDeleted());
    assertEquals(DEPRECATED, DISK_TYPE_STATUS.getDeprecated());
    assertEquals(OBSOLETE, DISK_TYPE_STATUS.getObsolete());
    assertEquals(DISK_TYPE_ID, DISK_TYPE_STATUS.getReplacement());
    assertEquals(DEPRECATED_MILLIS, DISK_TYPE_STATUS.getDeprecatedMillis());
    assertEquals(DELETED_MILLIS, DISK_TYPE_STATUS.getDeletedMillis());
    assertEquals(OBSOLETE_MILLIS, DISK_TYPE_STATUS.getObsoleteMillis());
    assertEquals(STATUS, DISK_TYPE_STATUS.getStatus());
    assertEquals(DELETED, DISK_TYPE_STATUS_MILLIS.getDeleted());
    assertEquals(DEPRECATED, DISK_TYPE_STATUS_MILLIS.getDeprecated());
    assertEquals(OBSOLETE, DISK_TYPE_STATUS_MILLIS.getObsolete());
    assertEquals(DISK_TYPE_ID, DISK_TYPE_STATUS_MILLIS.getReplacement());
    assertEquals(DEPRECATED_MILLIS, DISK_TYPE_STATUS_MILLIS.getDeprecatedMillis());
    assertEquals(DELETED_MILLIS, DISK_TYPE_STATUS_MILLIS.getDeletedMillis());
    assertEquals(OBSOLETE_MILLIS, DISK_TYPE_STATUS_MILLIS.getObsoleteMillis());
    assertEquals(STATUS, DISK_TYPE_STATUS.getStatus());
    assertEquals(DELETED, MACHINE_TYPE_STATUS.getDeleted());
    assertEquals(DEPRECATED, MACHINE_TYPE_STATUS.getDeprecated());
    assertEquals(OBSOLETE, MACHINE_TYPE_STATUS.getObsolete());
    assertEquals(DEPRECATED_MILLIS, MACHINE_TYPE_STATUS.getDeprecatedMillis());
    assertEquals(DELETED_MILLIS, MACHINE_TYPE_STATUS.getDeletedMillis());
    assertEquals(OBSOLETE_MILLIS, MACHINE_TYPE_STATUS.getObsoleteMillis());
    assertEquals(MACHINE_TYPE_ID, MACHINE_TYPE_STATUS.getReplacement());
    assertEquals(STATUS, MACHINE_TYPE_STATUS.getStatus());
  }

  @Test
  public void testGettersIllegalArgument() {
    DeprecationStatus<MachineTypeId> deprecationStatus =
        DeprecationStatus.newBuilder(STATUS, MACHINE_TYPE_ID)
            .setDeprecated("deprecated")
            .setObsolete("obsolete")
            .setDeleted("delete")
            .build();
    assertEquals("deprecated", deprecationStatus.getDeprecated());
    try {
      deprecationStatus.getDeprecatedMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
    assertEquals("obsolete", deprecationStatus.getObsolete());
    try {
      deprecationStatus.getObsoleteMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
    assertEquals("delete", deprecationStatus.getDeleted());
    try {
      deprecationStatus.getDeletedMillis();
      fail("Expected IllegalArgumentException");
    } catch (IllegalStateException ex) {
      // never reached
    }
  }

  @Test
  public void testToBuilder() {
    compareDeprecationStatus(DISK_TYPE_STATUS, DISK_TYPE_STATUS.toBuilder().build());
    compareDeprecationStatus(MACHINE_TYPE_STATUS, MACHINE_TYPE_STATUS.toBuilder().build());
    DeprecationStatus<DiskTypeId> deprecationStatus =
        DISK_TYPE_STATUS.toBuilder().setDeleted(DEPRECATED).build();
    assertEquals(DEPRECATED, deprecationStatus.getDeleted());
    deprecationStatus = deprecationStatus.toBuilder().setDeleted(DELETED).build();
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
    assertNull(diskStatus.getDeleted());
    assertNull(diskStatus.getDeprecated());
    assertNull(diskStatus.getObsolete());
    assertEquals(DISK_TYPE_ID, diskStatus.getReplacement());
    assertEquals(STATUS, diskStatus.getStatus());
  }

  @Test
  public void testToAndFromPb() {
    DeprecationStatus<DiskTypeId> diskStatus =
        DeprecationStatus.fromPb(DISK_TYPE_STATUS.toPb(), DiskTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(DISK_TYPE_STATUS, diskStatus);
    DeprecationStatus<MachineTypeId> machineStatus =
        DeprecationStatus.fromPb(MACHINE_TYPE_STATUS.toPb(), MachineTypeId.FROM_URL_FUNCTION);
    compareDeprecationStatus(MACHINE_TYPE_STATUS, machineStatus);
    diskStatus =
        DeprecationStatus.newBuilder(STATUS, DISK_TYPE_ID).setDeprecated(DEPRECATED).build();
    assertEquals(
        diskStatus, DeprecationStatus.fromPb(diskStatus.toPb(), DiskTypeId.FROM_URL_FUNCTION));
    machineStatus =
        DeprecationStatus.newBuilder(STATUS, MACHINE_TYPE_ID).setDeprecated(DEPRECATED).build();
    assertEquals(
        machineStatus,
        DeprecationStatus.fromPb(machineStatus.toPb(), MachineTypeId.FROM_URL_FUNCTION));
    diskStatus = DeprecationStatus.of(STATUS, DISK_TYPE_ID);
    assertEquals(
        diskStatus, DeprecationStatus.fromPb(diskStatus.toPb(), DiskTypeId.FROM_URL_FUNCTION));
  }

  private void compareDeprecationStatus(DeprecationStatus expected, DeprecationStatus value) {
    assertEquals(expected, value);
    assertEquals(expected.getDeleted(), value.getDeleted());
    assertEquals(expected.getDeprecated(), value.getDeprecated());
    assertEquals(expected.getObsolete(), value.getObsolete());
    assertEquals(expected.getDeletedMillis(), value.getDeletedMillis());
    assertEquals(expected.getDeprecatedMillis(), value.getDeprecatedMillis());
    assertEquals(expected.getObsoleteMillis(), value.getObsoleteMillis());
    assertEquals(expected.getReplacement(), value.getReplacement());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
