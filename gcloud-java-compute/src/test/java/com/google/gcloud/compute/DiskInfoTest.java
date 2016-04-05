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

import com.google.api.services.compute.model.Disk;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.DiskInfo.CreationStatus;

import org.junit.Test;

import java.util.List;

public class DiskInfoTest {

  private static final String ID = "42";
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final CreationStatus CREATION_STATUS = CreationStatus.READY;
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
      StandardDiskConfiguration.builder()
          .sizeGb(SIZE_GB)
          .diskType(TYPE)
          .build();
  private static final SnapshotDiskConfiguration SNAPSHOT_DISK_CONFIGURATION =
      SnapshotDiskConfiguration.builder(SNAPSHOT)
          .sizeGb(SIZE_GB)
          .diskType(TYPE)
          .sourceSnapshotId(SNAPSHOT_ID)
          .build();
  private static final ImageDiskConfiguration IMAGE_DISK_CONFIGURATION =
      ImageDiskConfiguration.builder(IMAGE)
          .sizeGb(SIZE_GB)
          .diskType(TYPE)
          .sourceImageId(IMAGE_ID)
          .build();
  private static final DiskInfo DISK_INFO = DiskInfo.builder(DISK_ID, DISK_CONFIGURATION)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .creationStatus(CREATION_STATUS)
      .description(DESCRIPTION)
      .licenses(LICENSES)
      .attachedInstances(ATTACHED_INSTANCES)
      .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
      .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
      .build();
  private static final DiskInfo SNAPSHOT_DISK_INFO =
      DiskInfo.builder(DISK_ID, SNAPSHOT_DISK_CONFIGURATION)
          .id(ID)
          .creationTimestamp(CREATION_TIMESTAMP)
          .creationStatus(CREATION_STATUS)
          .description(DESCRIPTION)
          .licenses(LICENSES)
          .attachedInstances(ATTACHED_INSTANCES)
          .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();
  private static final DiskInfo IMAGE_DISK_INFO =
      DiskInfo.builder(DISK_ID, IMAGE_DISK_CONFIGURATION)
          .id(ID)
          .creationTimestamp(CREATION_TIMESTAMP)
          .creationStatus(CREATION_STATUS)
          .description(DESCRIPTION)
          .licenses(LICENSES)
          .attachedInstances(ATTACHED_INSTANCES)
          .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
          .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
          .build();

  @Test
  public void testToBuilder() {
    compareDiskInfo(DISK_INFO, DISK_INFO.toBuilder().build());
    compareDiskInfo(IMAGE_DISK_INFO, IMAGE_DISK_INFO.toBuilder().build());
    compareDiskInfo(SNAPSHOT_DISK_INFO, SNAPSHOT_DISK_INFO.toBuilder().build());
    DiskInfo diskInfo = DISK_INFO.toBuilder().description("newDescription").build();
    assertEquals("newDescription", diskInfo.description());
    diskInfo = diskInfo.toBuilder().description("description").build();
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
    assertEquals(ID, DISK_INFO.id());
    assertEquals(DISK_ID, DISK_INFO.diskId());
    assertEquals(DISK_CONFIGURATION, DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, DISK_INFO.description());
    assertEquals(LICENSES, DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, DISK_INFO.lastDetachTimestamp());
    assertEquals(ID, IMAGE_DISK_INFO.id());
    assertEquals(DISK_ID, IMAGE_DISK_INFO.diskId());
    assertEquals(IMAGE_DISK_CONFIGURATION, IMAGE_DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, IMAGE_DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, IMAGE_DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, IMAGE_DISK_INFO.description());
    assertEquals(LICENSES, IMAGE_DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, IMAGE_DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, IMAGE_DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, IMAGE_DISK_INFO.lastDetachTimestamp());
    assertEquals(ID, SNAPSHOT_DISK_INFO.id());
    assertEquals(DISK_ID, SNAPSHOT_DISK_INFO.diskId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, SNAPSHOT_DISK_INFO.configuration());
    assertEquals(CREATION_TIMESTAMP, SNAPSHOT_DISK_INFO.creationTimestamp());
    assertEquals(CREATION_STATUS, SNAPSHOT_DISK_INFO.creationStatus());
    assertEquals(DESCRIPTION, SNAPSHOT_DISK_INFO.description());
    assertEquals(LICENSES, SNAPSHOT_DISK_INFO.licenses());
    assertEquals(ATTACHED_INSTANCES, SNAPSHOT_DISK_INFO.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, SNAPSHOT_DISK_INFO.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, SNAPSHOT_DISK_INFO.lastDetachTimestamp());
  }

  @Test
  public void testOf() {
    DiskInfo diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    assertNull(diskInfo.id());
    assertEquals(DISK_ID, diskInfo.diskId());
    assertEquals(DISK_CONFIGURATION, diskInfo.configuration());
    assertNull(diskInfo.creationTimestamp());
    assertNull(diskInfo.creationStatus());
    assertNull(diskInfo.description());
    assertNull(diskInfo.licenses());
    assertNull(diskInfo.attachedInstances());
    assertNull(diskInfo.lastAttachTimestamp());
    assertNull(diskInfo.lastDetachTimestamp());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    assertNull(diskInfo.id());
    assertEquals(DISK_ID, diskInfo.diskId());
    assertEquals(IMAGE_DISK_CONFIGURATION, diskInfo.configuration());
    assertNull(diskInfo.creationTimestamp());
    assertNull(diskInfo.creationStatus());
    assertNull(diskInfo.description());
    assertNull(diskInfo.licenses());
    assertNull(diskInfo.attachedInstances());
    assertNull(diskInfo.lastAttachTimestamp());
    assertNull(diskInfo.lastDetachTimestamp());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    assertNull(diskInfo.id());
    assertEquals(DISK_ID, diskInfo.diskId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, diskInfo.configuration());
    assertNull(diskInfo.creationTimestamp());
    assertNull(diskInfo.creationStatus());
    assertNull(diskInfo.description());
    assertNull(diskInfo.licenses());
    assertNull(diskInfo.attachedInstances());
    assertNull(diskInfo.lastAttachTimestamp());
    assertNull(diskInfo.lastDetachTimestamp());
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
        .setSelfLink(DISK_ID.selfLink())
        .setType(TYPE.selfLink())
        .setSizeGb(SIZE_GB);
    diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
    disk = new Disk()
        .setType(TYPE.selfLink())
        .setSizeGb(SIZE_GB)
        .setSelfLink(DISK_ID.selfLink())
        .setSourceSnapshotId(SNAPSHOT_ID)
        .setSourceSnapshot(SNAPSHOT.selfLink());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
    disk = new Disk()
        .setType(TYPE.selfLink())
        .setSizeGb(SIZE_GB)
        .setSelfLink(DISK_ID.selfLink())
        .setSourceImageId(IMAGE_ID)
        .setSourceImage(IMAGE.selfLink());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    compareDiskInfo(diskInfo, DiskInfo.fromPb(disk));
  }

  @Test
  public void testSetProjectId() {
    StandardDiskConfiguration standardDiskConfiguration = DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of(TYPE.zone(), TYPE.diskType()))
        .build();
    DiskInfo diskInfo = DISK_INFO.toBuilder()
        .diskId(DiskId.of(DISK_ID.zone(), DISK_ID.disk()))
        .configuration(standardDiskConfiguration)
        .build();
    compareDiskInfo(DISK_INFO, diskInfo.setProjectId("project"));
    SnapshotDiskConfiguration snapshotDiskConfiguration = SNAPSHOT_DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of(TYPE.zone(), TYPE.diskType()))
        .sourceSnapshot(SnapshotId.of(SNAPSHOT.snapshot()))
        .build();
    diskInfo = SNAPSHOT_DISK_INFO.toBuilder()
        .diskId(DiskId.of(DISK_ID.zone(), DISK_ID.disk()))
        .configuration(snapshotDiskConfiguration)
        .build();
    compareDiskInfo(SNAPSHOT_DISK_INFO, diskInfo.setProjectId("project"));
    ImageDiskConfiguration imageDiskConfiguration = IMAGE_DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of(TYPE.zone(), TYPE.diskType()))
        .sourceImage(ImageId.of(IMAGE.image()))
        .build();
    diskInfo = IMAGE_DISK_INFO.toBuilder()
        .diskId(DiskId.of(DISK_ID.zone(), DISK_ID.disk()))
        .configuration(imageDiskConfiguration)
        .build();
    compareDiskInfo(IMAGE_DISK_INFO, diskInfo.setProjectId("project"));
  }

  public void compareDiskInfo(DiskInfo expected, DiskInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.configuration(), value.configuration());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.diskId(), value.diskId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.creationStatus(), value.creationStatus());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.licenses(), value.licenses());
    assertEquals(expected.attachedInstances(), value.attachedInstances());
    assertEquals(expected.lastAttachTimestamp(), value.lastAttachTimestamp());
    assertEquals(expected.lastDetachTimestamp(), value.lastDetachTimestamp());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
