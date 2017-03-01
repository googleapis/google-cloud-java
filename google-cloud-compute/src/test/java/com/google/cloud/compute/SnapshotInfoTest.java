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

import com.google.cloud.compute.SnapshotInfo.Status;
import com.google.cloud.compute.SnapshotInfo.StorageBytesStatus;
import com.google.common.collect.ImmutableList;

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
  private static final SnapshotInfo SNAPSHOT_INFO =
      SnapshotInfo.newBuilder(SNAPSHOT_ID, SOURCE_DISK)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setDiskSizeGb(DISK_SIZE_GB)
          .setLicenses(LICENSES)
          .setSourceDiskId(SOURCE_DISK_ID)
          .setStorageBytes(STORAGE_BYTES)
          .setStorageBytesStatus(STORAGE_BYTES_STATUS)
          .build();
  private static final SnapshotInfo DEPRECATED_SNAPSHOT_INFO =
      SnapshotInfo.builder(SNAPSHOT_ID, SOURCE_DISK)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .description(DESCRIPTION)
          .setStatus(STATUS)
          .setDiskSizeGb(DISK_SIZE_GB)
          .setLicenses(LICENSES)
          .setSourceDiskId(SOURCE_DISK_ID)
          .setStorageBytes(STORAGE_BYTES)
          .setStorageBytesStatus(STORAGE_BYTES_STATUS)
          .build();

  @Test
  public void testToBuilder() {
    compareSnapshotInfo(SNAPSHOT_INFO, SNAPSHOT_INFO.toBuilder().build());
    SnapshotInfo snapshotInfo = SNAPSHOT_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", snapshotInfo.getDescription());
    snapshotInfo = snapshotInfo.toBuilder().setDescription("description").build();
    compareSnapshotInfo(SNAPSHOT_INFO, snapshotInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    assertEquals(snapshotInfo, snapshotInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, SNAPSHOT_INFO.getGeneratedId());
    assertEquals(SNAPSHOT_ID, SNAPSHOT_INFO.getSnapshotId());
    assertEquals(CREATION_TIMESTAMP, SNAPSHOT_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, SNAPSHOT_INFO.getDescription());
    assertEquals(STATUS, SNAPSHOT_INFO.getStatus());
    assertEquals(DISK_SIZE_GB, SNAPSHOT_INFO.getDiskSizeGb());
    assertEquals(LICENSES, SNAPSHOT_INFO.getLicenses());
    assertEquals(SOURCE_DISK, SNAPSHOT_INFO.getSourceDisk());
    assertEquals(SOURCE_DISK_ID, SNAPSHOT_INFO.getSourceDiskId());
    assertEquals(STORAGE_BYTES, SNAPSHOT_INFO.getStorageBytes());
    assertEquals(STORAGE_BYTES_STATUS, SNAPSHOT_INFO.getStorageBytesStatus());
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(GENERATED_ID, DEPRECATED_SNAPSHOT_INFO.generatedId());
    assertEquals(SNAPSHOT_ID, DEPRECATED_SNAPSHOT_INFO.snapshotId());
    assertEquals(CREATION_TIMESTAMP, DEPRECATED_SNAPSHOT_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, DEPRECATED_SNAPSHOT_INFO.description());
    assertEquals(STATUS, DEPRECATED_SNAPSHOT_INFO.status());
    assertEquals(DISK_SIZE_GB, DEPRECATED_SNAPSHOT_INFO.diskSizeGb());
    assertEquals(LICENSES, DEPRECATED_SNAPSHOT_INFO.licenses());
    assertEquals(SOURCE_DISK, DEPRECATED_SNAPSHOT_INFO.sourceDisk());
    assertEquals(SOURCE_DISK_ID, DEPRECATED_SNAPSHOT_INFO.sourceDiskId());
    assertEquals(STORAGE_BYTES, DEPRECATED_SNAPSHOT_INFO.storageBytes());
    assertEquals(STORAGE_BYTES_STATUS, DEPRECATED_SNAPSHOT_INFO.storageBytesStatus());
  }

  @Test
  public void testOf() {
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    assertNull(snapshotInfo.getGeneratedId());
    assertEquals(SNAPSHOT_ID, snapshotInfo.getSnapshotId());
    assertNull(snapshotInfo.getCreationTimestamp());
    assertNull(snapshotInfo.getDescription());
    assertNull(snapshotInfo.getStatus());
    assertNull(snapshotInfo.getDiskSizeGb());
    assertNull(snapshotInfo.getLicenses());
    assertEquals(SOURCE_DISK, snapshotInfo.getSourceDisk());
    assertNull(snapshotInfo.getSourceDiskId());
    assertNull(snapshotInfo.getStorageBytes());
    assertNull(snapshotInfo.getStorageBytesStatus());
  }

  @Test
  public void testToAndFromPb() {
    compareSnapshotInfo(SNAPSHOT_INFO, SnapshotInfo.fromPb(SNAPSHOT_INFO.toPb()));
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    compareSnapshotInfo(snapshotInfo, SnapshotInfo.fromPb(snapshotInfo.toPb()));
    snapshotInfo = new SnapshotInfo.BuilderImpl().setSnapshotId(SNAPSHOT_ID).build();
    compareSnapshotInfo(snapshotInfo, SnapshotInfo.fromPb(snapshotInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    SnapshotInfo snapshotInfo = SNAPSHOT_INFO.toBuilder()
        .setSnapshotId(SnapshotId.of("snapshot"))
        .setSourceDisk(DiskId.of("zone", "disk"))
        .build();
    compareSnapshotInfo(SNAPSHOT_INFO, snapshotInfo.setProjectId("project"));
  }

  public void compareSnapshotInfo(SnapshotInfo expected, SnapshotInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getSnapshotId(), value.getSnapshotId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getDiskSizeGb(), value.getDiskSizeGb());
    assertEquals(expected.getLicenses(), value.getLicenses());
    assertEquals(expected.getSourceDisk(), value.getSourceDisk());
    assertEquals(expected.getSourceDiskId(), value.getSourceDiskId());
    assertEquals(expected.getStorageBytes(), value.getStorageBytes());
    assertEquals(expected.getStorageBytesStatus(), value.getStorageBytesStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
