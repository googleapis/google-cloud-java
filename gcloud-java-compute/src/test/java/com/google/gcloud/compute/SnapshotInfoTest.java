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
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.SnapshotInfo.Status;
import com.google.gcloud.compute.SnapshotInfo.StorageBytesStatus;

import org.junit.Test;

import java.util.List;

public class SnapshotInfoTest {

  private static final String GENERATED_ID = "42";
  private static final DiskId SOURCE_DISK = DiskId.of("project", "zone", "disk");
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final SnapshotId SNAPSHOT_ID = SnapshotId.of("project", "snapshot");
  private static final Status STATUS = Status.CREATING;
  private static final Long DISK_SIZE_GB = 42L;
  private static final String SOURCE_DISK_ID = "diskId";
  private static final Long STORAGE_BYTES = 24L;
  private static final StorageBytesStatus STORAGE_BYTES_STATUS = StorageBytesStatus.UP_TO_DATE;
  private static final SnapshotInfo SNAPSHOT_INFO = SnapshotInfo.builder(SNAPSHOT_ID, SOURCE_DISK)
      .generatedId(GENERATED_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .diskSizeGb(DISK_SIZE_GB)
      .licenses(LICENSES)
      .sourceDiskId(SOURCE_DISK_ID)
      .storageBytes(STORAGE_BYTES)
      .storageBytesStatus(STORAGE_BYTES_STATUS)
      .build();

  @Test
  public void testToBuilder() {
    compareSnapshotInfo(SNAPSHOT_INFO, SNAPSHOT_INFO.toBuilder().build());
    SnapshotInfo snapshotInfo = SNAPSHOT_INFO.toBuilder().description("newDescription").build();
    assertEquals("newDescription", snapshotInfo.description());
    snapshotInfo = snapshotInfo.toBuilder().description("description").build();
    compareSnapshotInfo(SNAPSHOT_INFO, snapshotInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    assertEquals(snapshotInfo, snapshotInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, SNAPSHOT_INFO.generatedId());
    assertEquals(SNAPSHOT_ID, SNAPSHOT_INFO.snapshotId());
    assertEquals(CREATION_TIMESTAMP, SNAPSHOT_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, SNAPSHOT_INFO.description());
    assertEquals(STATUS, SNAPSHOT_INFO.status());
    assertEquals(DISK_SIZE_GB, SNAPSHOT_INFO.diskSizeGb());
    assertEquals(LICENSES, SNAPSHOT_INFO.licenses());
    assertEquals(SOURCE_DISK, SNAPSHOT_INFO.sourceDisk());
    assertEquals(SOURCE_DISK_ID, SNAPSHOT_INFO.sourceDiskId());
    assertEquals(STORAGE_BYTES, SNAPSHOT_INFO.storageBytes());
    assertEquals(STORAGE_BYTES_STATUS, SNAPSHOT_INFO.storageBytesStatus());
  }

  @Test
  public void testOf() {
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    assertNull(snapshotInfo.generatedId());
    assertEquals(SNAPSHOT_ID, snapshotInfo.snapshotId());
    assertNull(snapshotInfo.creationTimestamp());
    assertNull(snapshotInfo.description());
    assertNull(snapshotInfo.status());
    assertNull(snapshotInfo.diskSizeGb());
    assertNull(snapshotInfo.licenses());
    assertEquals(SOURCE_DISK, snapshotInfo.sourceDisk());
    assertNull(snapshotInfo.sourceDiskId());
    assertNull(snapshotInfo.storageBytes());
    assertNull(snapshotInfo.storageBytesStatus());
  }

  @Test
  public void testToAndFromPb() {
    compareSnapshotInfo(SNAPSHOT_INFO, SnapshotInfo.fromPb(SNAPSHOT_INFO.toPb()));
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    compareSnapshotInfo(snapshotInfo, SnapshotInfo.fromPb(snapshotInfo.toPb()));
    snapshotInfo = new SnapshotInfo.BuilderImpl().snapshotId(SNAPSHOT_ID).build();
    compareSnapshotInfo(snapshotInfo, SnapshotInfo.fromPb(snapshotInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    SnapshotInfo snapshotInfo = SNAPSHOT_INFO.toBuilder()
        .snapshotId(SnapshotId.of("snapshot"))
        .sourceDisk(DiskId.of("zone", "disk"))
        .build();
    compareSnapshotInfo(SNAPSHOT_INFO, snapshotInfo.setProjectId("project"));
  }

  public void compareSnapshotInfo(SnapshotInfo expected, SnapshotInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.snapshotId(), value.snapshotId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.diskSizeGb(), value.diskSizeGb());
    assertEquals(expected.licenses(), value.licenses());
    assertEquals(expected.sourceDisk(), value.sourceDisk());
    assertEquals(expected.sourceDiskId(), value.sourceDiskId());
    assertEquals(expected.storageBytes(), value.storageBytes());
    assertEquals(expected.storageBytesStatus(), value.storageBytesStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
