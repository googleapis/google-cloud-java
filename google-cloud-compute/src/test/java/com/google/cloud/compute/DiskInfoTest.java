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

import com.google.api.services.compute.model.Disk;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class DiskInfoTest {

  private static final String GENERATED_ID = "42";
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final DiskInfo.CreationStatus CREATION_STATUS = DiskInfo.CreationStatus.READY;
  private static final String DESCRIPTION = "description";
  private static final Long SIZE_GB = 500L;
  private static final DiskTypeId TYPE = DiskTypeId.of("project", "zone", "disk");
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final List<InstanceId> ATTACHED_INSTANCES = ImmutableList.of(
      InstanceId.of("project", "zone", "instance1"),
      InstanceId.of("project", "zone", "instance2"));
  private static final SnapshotId SNAPSHOT = SnapshotId.of("project", "snapshot");
  private static final ImageId IMAGE = ImageId.of("project", "image");
  private static final String SNAPSHOT_ID = "snapshotId";
  private static final String IMAGE_ID = "snapshotId";
  private static final Long LAST_ATTACH_TIMESTAMP = 1453293600000L;
  private static final Long LAST_DETACH_TIMESTAMP = 1453293660000L;
  private static final StandardDiskConfiguration DISK_CONFIGURATION =
      StandardDiskConfiguration.newBuilder()
          .setSizeGb(SIZE_GB)
          .setDiskType(TYPE)
          .build();
  private static final SnapshotDiskConfiguration SNAPSHOT_DISK_CONFIGURATION =
      SnapshotDiskConfiguration.newBuilder(SNAPSHOT)
          .setSizeGb(SIZE_GB)
          .setDiskType(TYPE)
          .setSourceSnapshotId(SNAPSHOT_ID)
          .build();
  private static final ImageDiskConfiguration IMAGE_DISK_CONFIGURATION =
      ImageDiskConfiguration.newBuilder(IMAGE)
          .setSizeGb(SIZE_GB)
          .setDiskType(TYPE)
          .setSourceImageId(IMAGE_ID)
          .build();
  private static final DiskInfo DISK_INFO = DiskInfo.newBuilder(DISK_ID, DISK_CONFIGURATION)
      .setGeneratedId(GENERATED_ID)
      .setCreationTimestamp(CREATION_TIMESTAMP)
      .setCreationStatus(CREATION_STATUS)
      .setDescription(DESCRIPTION)
      .setLicenses(LICENSES)
      .setAttachedInstances(ATTACHED_INSTANCES)
      .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
      .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
      .build();
  private static final DiskInfo SNAPSHOT_DISK_INFO =
      DiskInfo.newBuilder(DISK_ID, SNAPSHOT_DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setCreationStatus(CREATION_STATUS)
          .setDescription(DESCRIPTION)
          .setLicenses(LICENSES)
          .setAttachedInstances(ATTACHED_INSTANCES)
          .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();
  private static final DiskInfo IMAGE_DISK_INFO =
      DiskInfo.newBuilder(DISK_ID, IMAGE_DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setCreationStatus(CREATION_STATUS)
          .setDescription(DESCRIPTION)
          .setLicenses(LICENSES)
          .setAttachedInstances(ATTACHED_INSTANCES)
          .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();
  private static final DiskInfo DEPRECATED_DISK_INFO =
      DiskInfo.builder(DISK_ID, DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setCreationStatus(CREATION_STATUS)
          .description(DESCRIPTION)
          .setLicenses(LICENSES)
          .setAttachedInstances(ATTACHED_INSTANCES)
          .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();
  private static final DiskInfo DEPRECATED_SNAPSHOT_DISK_INFO =
      DiskInfo.builder(DISK_ID, SNAPSHOT_DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setCreationStatus(CREATION_STATUS)
          .description(DESCRIPTION)
          .setLicenses(LICENSES)
          .setAttachedInstances(ATTACHED_INSTANCES)
          .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();
  private static final DiskInfo DEPRECATED_IMAGE_DISK_INFO =
      DiskInfo.builder(DISK_ID, IMAGE_DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setCreationStatus(CREATION_STATUS)
          .description(DESCRIPTION)
          .setLicenses(LICENSES)
          .setAttachedInstances(ATTACHED_INSTANCES)
          .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();

  @Test
  public void testToBuilder() {
    compareDiskInfo(DISK_INFO, DISK_INFO.toBuilder().build());
    compareDiskInfo(IMAGE_DISK_INFO, IMAGE_DISK_INFO.toBuilder().build());
    compareDiskInfo(SNAPSHOT_DISK_INFO, SNAPSHOT_DISK_INFO.toBuilder().build());
    DiskInfo diskInfo = DISK_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", diskInfo.getDescription());
    diskInfo = diskInfo.toBuilder().setDescription("description").build();
    compareDiskInfo(DISK_INFO, diskInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    DiskInfo diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    assertEquals(diskInfo, diskInfo.toBuilder().build());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    assertEquals(diskInfo, diskInfo.toBuilder().build());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    assertEquals(diskInfo, diskInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, DISK_INFO.getGeneratedId());
    assertEquals(DISK_ID, DISK_INFO.getDiskId());
    assertEquals(DISK_CONFIGURATION, DISK_INFO.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, DISK_INFO.getCreationTimestamp());
    assertEquals(CREATION_STATUS, DISK_INFO.getCreationStatus());
    assertEquals(DESCRIPTION, DISK_INFO.getDescription());
    assertEquals(LICENSES, DISK_INFO.getLicenses());
    assertEquals(ATTACHED_INSTANCES, DISK_INFO.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, DISK_INFO.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, DISK_INFO.getLastDetachTimestamp());
    assertEquals(GENERATED_ID, IMAGE_DISK_INFO.getGeneratedId());
    assertEquals(DISK_ID, IMAGE_DISK_INFO.getDiskId());
    assertEquals(IMAGE_DISK_CONFIGURATION, IMAGE_DISK_INFO.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, IMAGE_DISK_INFO.getCreationTimestamp());
    assertEquals(CREATION_STATUS, IMAGE_DISK_INFO.getCreationStatus());
    assertEquals(DESCRIPTION, IMAGE_DISK_INFO.getDescription());
    assertEquals(LICENSES, IMAGE_DISK_INFO.getLicenses());
    assertEquals(ATTACHED_INSTANCES, IMAGE_DISK_INFO.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, IMAGE_DISK_INFO.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, IMAGE_DISK_INFO.getLastDetachTimestamp());
    assertEquals(GENERATED_ID, SNAPSHOT_DISK_INFO.getGeneratedId());
    assertEquals(DISK_ID, SNAPSHOT_DISK_INFO.getDiskId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, SNAPSHOT_DISK_INFO.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, SNAPSHOT_DISK_INFO.getCreationTimestamp());
    assertEquals(CREATION_STATUS, SNAPSHOT_DISK_INFO.getCreationStatus());
    assertEquals(DESCRIPTION, SNAPSHOT_DISK_INFO.getDescription());
    assertEquals(LICENSES, SNAPSHOT_DISK_INFO.getLicenses());
    assertEquals(ATTACHED_INSTANCES, SNAPSHOT_DISK_INFO.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, SNAPSHOT_DISK_INFO.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, SNAPSHOT_DISK_INFO.getLastDetachTimestamp());
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(GENERATED_ID, DEPRECATED_DISK_INFO.generatedId());
    assertEquals(DISK_ID, DEPRECATED_DISK_INFO.diskId());
    assertEquals(DISK_CONFIGURATION, DEPRECATED_DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, DEPRECATED_DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, DEPRECATED_DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, DEPRECATED_DISK_INFO.description());
    assertEquals(LICENSES, DEPRECATED_DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, DEPRECATED_DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, DEPRECATED_DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, DEPRECATED_DISK_INFO.lastDetachTimestamp());
    assertEquals(GENERATED_ID, DEPRECATED_IMAGE_DISK_INFO.generatedId());
    assertEquals(DISK_ID, DEPRECATED_IMAGE_DISK_INFO.diskId());
    assertEquals(IMAGE_DISK_CONFIGURATION, DEPRECATED_IMAGE_DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, DEPRECATED_IMAGE_DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, DEPRECATED_IMAGE_DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, DEPRECATED_IMAGE_DISK_INFO.description());
    assertEquals(LICENSES, DEPRECATED_IMAGE_DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, DEPRECATED_IMAGE_DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, DEPRECATED_IMAGE_DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, DEPRECATED_IMAGE_DISK_INFO.lastDetachTimestamp());
    assertEquals(GENERATED_ID, DEPRECATED_SNAPSHOT_DISK_INFO.generatedId());
    assertEquals(DISK_ID, DEPRECATED_SNAPSHOT_DISK_INFO.diskId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, DEPRECATED_SNAPSHOT_DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, DEPRECATED_SNAPSHOT_DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, DEPRECATED_SNAPSHOT_DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, DEPRECATED_SNAPSHOT_DISK_INFO.description());
    assertEquals(LICENSES, DEPRECATED_SNAPSHOT_DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, DEPRECATED_SNAPSHOT_DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, DEPRECATED_SNAPSHOT_DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, DEPRECATED_SNAPSHOT_DISK_INFO.lastDetachTimestamp());
  }

  @Test
  public void testOf() {
    DiskInfo diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    assertNull(diskInfo.getGeneratedId());
    assertEquals(DISK_ID, diskInfo.getDiskId());
    assertEquals(DISK_CONFIGURATION, diskInfo.getConfiguration());
    assertNull(diskInfo.getCreationTimestamp());
    assertNull(diskInfo.getCreationStatus());
    assertNull(diskInfo.getDescription());
    assertNull(diskInfo.getLicenses());
    assertNull(diskInfo.getAttachedInstances());
    assertNull(diskInfo.getLastAttachTimestamp());
    assertNull(diskInfo.getLastDetachTimestamp());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    assertNull(diskInfo.getGeneratedId());
    assertEquals(DISK_ID, diskInfo.getDiskId());
    assertEquals(IMAGE_DISK_CONFIGURATION, diskInfo.getConfiguration());
    assertNull(diskInfo.getCreationTimestamp());
    assertNull(diskInfo.getCreationStatus());
    assertNull(diskInfo.getDescription());
    assertNull(diskInfo.getLicenses());
    assertNull(diskInfo.getAttachedInstances());
    assertNull(diskInfo.getLastAttachTimestamp());
    assertNull(diskInfo.getLastDetachTimestamp());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    assertNull(diskInfo.getGeneratedId());
    assertEquals(DISK_ID, diskInfo.getDiskId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, diskInfo.getConfiguration());
    assertNull(diskInfo.getCreationTimestamp());
    assertNull(diskInfo.getCreationStatus());
    assertNull(diskInfo.getDescription());
    assertNull(diskInfo.getLicenses());
    assertNull(diskInfo.getAttachedInstances());
    assertNull(diskInfo.getLastAttachTimestamp());
    assertNull(diskInfo.getLastDetachTimestamp());
  }

  @Test
  public void testToAndFromPb() {
    DiskInfo diskInfo = DiskInfo.fromPb(DISK_INFO.toPb());
    compareDiskInfo(DISK_INFO, diskInfo);
    diskInfo = DiskInfo.fromPb(SNAPSHOT_DISK_INFO.toPb());
    compareDiskInfo(SNAPSHOT_DISK_INFO, diskInfo);
    diskInfo = DiskInfo.fromPb(IMAGE_DISK_INFO.toPb());
    compareDiskInfo(IMAGE_DISK_INFO, diskInfo);
    Disk disk = new Disk()
        .setSelfLink(DISK_ID.getSelfLink())
        .setType(TYPE.getSelfLink())
        .setSizeGb(SIZE_GB);
    diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
    disk = new Disk()
        .setType(TYPE.getSelfLink())
        .setSizeGb(SIZE_GB)
        .setSelfLink(DISK_ID.getSelfLink())
        .setSourceSnapshotId(SNAPSHOT_ID)
        .setSourceSnapshot(SNAPSHOT.getSelfLink());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
    disk = new Disk()
        .setType(TYPE.getSelfLink())
        .setSizeGb(SIZE_GB)
        .setSelfLink(DISK_ID.getSelfLink())
        .setSourceImageId(IMAGE_ID)
        .setSourceImage(IMAGE.getSelfLink());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
  }

  @Test
  public void testSetProjectId() {
    StandardDiskConfiguration standardDiskConfiguration = DISK_CONFIGURATION.toBuilder()
        .setDiskType(DiskTypeId.of(TYPE.getZone(), TYPE.getType()))
        .build();
    DiskInfo diskInfo = DISK_INFO.toBuilder()
        .setDiskId(DiskId.of(DISK_ID.getZone(), DISK_ID.getDisk()))
        .setConfiguration(standardDiskConfiguration)
        .build();
    compareDiskInfo(DISK_INFO, diskInfo.setProjectId("project"));
    SnapshotDiskConfiguration snapshotDiskConfiguration = SNAPSHOT_DISK_CONFIGURATION.toBuilder()
        .setDiskType(DiskTypeId.of(TYPE.getZone(), TYPE.getType()))
        .setSourceSnapshot(SnapshotId.of(SNAPSHOT.getSnapshot()))
        .build();
    diskInfo = SNAPSHOT_DISK_INFO.toBuilder()
        .setDiskId(DiskId.of(DISK_ID.getZone(), DISK_ID.getDisk()))
        .setConfiguration(snapshotDiskConfiguration)
        .build();
    compareDiskInfo(SNAPSHOT_DISK_INFO, diskInfo.setProjectId("project"));
    ImageDiskConfiguration imageDiskConfiguration = IMAGE_DISK_CONFIGURATION.toBuilder()
        .setDiskType(DiskTypeId.of(TYPE.getZone(), TYPE.getType()))
        .setSourceImage(ImageId.of(IMAGE.getImage()))
        .build();
    diskInfo = IMAGE_DISK_INFO.toBuilder()
        .setDiskId(DiskId.of(DISK_ID.getZone(), DISK_ID.getDisk()))
        .setConfiguration(imageDiskConfiguration)
        .build();
    compareDiskInfo(IMAGE_DISK_INFO, diskInfo.setProjectId("project"));
  }

  public void compareDiskInfo(DiskInfo expected, DiskInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getConfiguration(), value.getConfiguration());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getDiskId(), value.getDiskId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getCreationStatus(), value.getCreationStatus());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getLicenses(), value.getLicenses());
    assertEquals(expected.getAttachedInstances(), value.getAttachedInstances());
    assertEquals(expected.getLastAttachTimestamp(), value.getLastAttachTimestamp());
    assertEquals(expected.getLastDetachTimestamp(), value.getLastDetachTimestamp());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
