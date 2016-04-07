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

import com.google.gcloud.compute.DiskConfiguration.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SnapshotDiskConfigurationTest {

  private static final Long SIZE = 42L;
  private static final DiskTypeId DISK_TYPE = DiskTypeId.of("project", "zone", "type");
  private static final SnapshotId SNAPSHOT = SnapshotId.of("project", "snapshot");
  private static final String SNAPSHOT_ID = "snapshotId";
  private static final SnapshotDiskConfiguration DISK_CONFIGURATION =
      SnapshotDiskConfiguration.builder(SNAPSHOT)
          .sizeGb(SIZE)
          .diskType(DISK_TYPE)
          .sourceSnapshotId(SNAPSHOT_ID)
          .build();

  @Test
  public void testToBuilder() {
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION, DISK_CONFIGURATION.toBuilder().build());
    SnapshotId newSnapshot = SnapshotId.of("newProject", "newSnapshot");
    SnapshotDiskConfiguration diskConfiguration = DISK_CONFIGURATION.toBuilder()
        .sizeGb(24L)
        .sourceSnapshot(newSnapshot)
        .sourceSnapshotId("newSnapshotId")
        .build();
    assertEquals(24L, diskConfiguration.sizeGb().longValue());
    assertEquals(newSnapshot, diskConfiguration.sourceSnapshot());
    assertEquals("newSnapshotId", diskConfiguration.sourceSnapshotId());
    diskConfiguration = diskConfiguration.toBuilder()
        .sizeGb(SIZE)
        .sourceSnapshot(SNAPSHOT)
        .sourceSnapshotId(SNAPSHOT_ID)
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
    assertEquals(DISK_TYPE, DISK_CONFIGURATION.diskType());
    assertEquals(SIZE, DISK_CONFIGURATION.sizeGb());
    assertEquals(SNAPSHOT, DISK_CONFIGURATION.sourceSnapshot());
    assertEquals(SNAPSHOT_ID, DISK_CONFIGURATION.sourceSnapshotId());
    assertEquals(Type.SNAPSHOT, DISK_CONFIGURATION.type());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(DiskConfiguration.fromPb(DISK_CONFIGURATION.toPb())
        instanceof SnapshotDiskConfiguration);
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION,
        DiskConfiguration.<SnapshotDiskConfiguration>fromPb(DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testOf() {
    SnapshotDiskConfiguration configuration = SnapshotDiskConfiguration.of(SNAPSHOT);
    assertNull(configuration.diskType());
    assertNull(configuration.sizeGb());
    assertNull(configuration.sourceSnapshotId());
    assertEquals(SNAPSHOT, configuration.sourceSnapshot());
    assertEquals(Type.SNAPSHOT, configuration.type());
  }

  @Test
  public void testSetProjectId() {
    SnapshotDiskConfiguration configuration = DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of(DISK_TYPE.zone(), DISK_TYPE.diskType()))
        .sourceSnapshot(SnapshotId.of(SNAPSHOT.snapshot()))
        .build();
    compareSnapshotDiskConfiguration(DISK_CONFIGURATION, configuration.setProjectId("project"));
  }

  private void compareSnapshotDiskConfiguration(SnapshotDiskConfiguration expected,
      SnapshotDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.diskType(), value.diskType());
    assertEquals(expected.sizeGb(), value.sizeGb());
    assertEquals(expected.sourceSnapshot(), value.sourceSnapshot());
    assertEquals(expected.sourceSnapshotId(), value.sourceSnapshotId());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
