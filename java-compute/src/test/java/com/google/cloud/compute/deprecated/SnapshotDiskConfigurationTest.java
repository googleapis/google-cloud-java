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
import static org.junit.Assert.assertTrue;

import com.google.cloud.compute.deprecated.DiskConfiguration.Type;
import org.junit.Test;

public class SnapshotDiskConfigurationTest {

  private static final Long SIZE = 42L;
  private static final DiskTypeId DISK_TYPE = DiskTypeId.of("project", "zone", "type");
  private static final SnapshotId SNAPSHOT = SnapshotId.of("project", "snapshot");
  private static final String SNAPSHOT_ID = "snapshotId";
  private static final SnapshotDiskConfiguration DISK_CONFIGURATION =
      SnapshotDiskConfiguration.newBuilder(SNAPSHOT)
          .setSizeGb(SIZE)
          .setDiskType(DISK_TYPE)
          .setSourceSnapshotId(SNAPSHOT_ID)
          .build();

  @Test
  public void testToBuilder() {
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION, DISK_CONFIGURATION.toBuilder().build());
    SnapshotId newSnapshot = SnapshotId.of("newProject", "newSnapshot");
    SnapshotDiskConfiguration diskConfiguration =
        DISK_CONFIGURATION
            .toBuilder()
            .setSizeGb(24L)
            .setSourceSnapshot(newSnapshot)
            .setSourceSnapshotId("newSnapshotId")
            .build();
    assertEquals(24L, diskConfiguration.getSizeGb().longValue());
    assertEquals(newSnapshot, diskConfiguration.getSourceSnapshot());
    assertEquals("newSnapshotId", diskConfiguration.getSourceSnapshotId());
    diskConfiguration =
        diskConfiguration
            .toBuilder()
            .setSizeGb(SIZE)
            .setSourceSnapshot(SNAPSHOT)
            .setSourceSnapshotId(SNAPSHOT_ID)
            .build();
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION, diskConfiguration);
  }

  @Test
  public void testToBuilderIncomplete() {
    SnapshotDiskConfiguration diskConfiguration = SnapshotDiskConfiguration.of(SNAPSHOT);
    compareSnapshotDiskConfiguration(diskConfiguration, diskConfiguration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(DISK_TYPE, DISK_CONFIGURATION.getDiskType());
    assertEquals(SIZE, DISK_CONFIGURATION.getSizeGb());
    assertEquals(SNAPSHOT, DISK_CONFIGURATION.getSourceSnapshot());
    assertEquals(SNAPSHOT_ID, DISK_CONFIGURATION.getSourceSnapshotId());
    assertEquals(Type.SNAPSHOT, DISK_CONFIGURATION.getType());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(
        DiskConfiguration.fromPb(DISK_CONFIGURATION.toPb()) instanceof SnapshotDiskConfiguration);
    compareSnapshotDiskConfiguration(
        DISK_CONFIGURATION,
        DiskConfiguration.<SnapshotDiskConfiguration>fromPb(DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testOf() {
    SnapshotDiskConfiguration configuration = SnapshotDiskConfiguration.of(SNAPSHOT);
    assertNull(configuration.getDiskType());
    assertNull(configuration.getSizeGb());
    assertNull(configuration.getSourceSnapshotId());
    assertEquals(SNAPSHOT, configuration.getSourceSnapshot());
    assertEquals(Type.SNAPSHOT, configuration.getType());
  }

  @Test
  public void testSetProjectId() {
    SnapshotDiskConfiguration configuration =
        DISK_CONFIGURATION
            .toBuilder()
            .setDiskType(DiskTypeId.of(DISK_TYPE.getZone(), DISK_TYPE.getType()))
            .setSourceSnapshot(SnapshotId.of(SNAPSHOT.getSnapshot()))
            .build();
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION, configuration.setProjectId("project"));
  }

  private void compareSnapshotDiskConfiguration(
      SnapshotDiskConfiguration expected, SnapshotDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.getDiskType(), value.getDiskType());
    assertEquals(expected.getSizeGb(), value.getSizeGb());
    assertEquals(expected.getSourceSnapshot(), value.getSourceSnapshot());
    assertEquals(expected.getSourceSnapshotId(), value.getSourceSnapshotId());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
