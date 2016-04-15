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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.AttachedDisk.CreateAttachedDisk;
import com.google.gcloud.compute.AttachedDisk.InterfaceType;
import com.google.gcloud.compute.AttachedDisk.Mode;
import com.google.gcloud.compute.AttachedDisk.PersistentAttachedDisk;
import com.google.gcloud.compute.AttachedDisk.ScratchAttachedDisk;
import com.google.gcloud.compute.AttachedDisk.Type;

import org.junit.Test;

import java.util.List;

public class AttachedDiskTest {

  private static final Boolean AUTO_DELETE = true;
  private static final Boolean BOOT = true;
  private static final Integer INDEX = 0;
  private static final String DEVICE_NAME = "deviceName";
      private static final String DISK_NAME = "diskName";
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
      private static final Long DISK_SIZE_GB = 42L;
  private static final DiskId DISK_ID = DiskId.of("project", "zone", "disk");
  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final InterfaceType INTERFACE_TYPE = InterfaceType.NVME;
  private static final Mode MODE = Mode.READ_ONLY;
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final PersistentAttachedDisk PERSISTENT_DISK =
      PersistentAttachedDisk.builder(DISK_ID)
          .deviceName(DEVICE_NAME)
          .index(INDEX)
          .licenses(LICENSES)
          .boot(BOOT)
          .autoDelete(AUTO_DELETE)
          .mode(MODE)
          .build();
  private static final ScratchAttachedDisk SCRATCH_DISK =
      ScratchAttachedDisk.builder(DISK_TYPE_ID)
          .deviceName(DEVICE_NAME)
          .index(INDEX)
          .licenses(LICENSES)
          .interfaceType(INTERFACE_TYPE)
          .build();
  private static final CreateAttachedDisk CREATED_DISK = CreateAttachedDisk.builder(IMAGE_ID)
      .deviceName(DEVICE_NAME)
      .index(INDEX)
      .licenses(LICENSES)
      .autoDelete(AUTO_DELETE)
      .diskName(DISK_NAME)
      .diskType(DISK_TYPE_ID)
      .diskSizeGb(DISK_SIZE_GB)
      .sourceImage(IMAGE_ID)
      .build();

  @Test
  public void testToBuilder() {
    compareAttachedDisk(PERSISTENT_DISK, PERSISTENT_DISK.toBuilder().build());
    compareAttachedDisk(SCRATCH_DISK, SCRATCH_DISK.toBuilder().build());
    compareAttachedDisk(CREATED_DISK, CREATED_DISK.toBuilder().build());
    AttachedDisk attachedDisk = PERSISTENT_DISK.toBuilder().deviceName("newDeviceName").build();
    assertEquals("newDeviceName", attachedDisk.deviceName());
    attachedDisk = attachedDisk.toBuilder().deviceName(DEVICE_NAME).build();
    compareAttachedDisk(PERSISTENT_DISK, attachedDisk);
  }

  @Test
  public void testToBuilderIncomplete() {
    AttachedDisk attachedDisk = PersistentAttachedDisk.of(DISK_ID);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
    attachedDisk = ScratchAttachedDisk.of(DISK_TYPE_ID);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
    attachedDisk = CreateAttachedDisk.of(IMAGE_ID);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(BOOT, PERSISTENT_DISK.boot());
    assertEquals(AUTO_DELETE, PERSISTENT_DISK.autoDelete());
    assertNull(PERSISTENT_DISK.interfaceType());
    assertEquals(Type.PERSISTENT, PERSISTENT_DISK.type());
    assertEquals(MODE, PERSISTENT_DISK.mode());
    assertEquals(DISK_ID, PERSISTENT_DISK.sourceDisk());
    assertEquals(DEVICE_NAME, PERSISTENT_DISK.deviceName());
    assertEquals(INDEX, PERSISTENT_DISK.index());
    assertEquals(LICENSES, PERSISTENT_DISK.licenses());

    assertFalse(SCRATCH_DISK.boot());
    assertTrue(SCRATCH_DISK.autoDelete());
    assertEquals(INTERFACE_TYPE, SCRATCH_DISK.interfaceType());
    assertEquals(Type.SCRATCH, SCRATCH_DISK.type());
    assertEquals(DISK_TYPE_ID, SCRATCH_DISK.diskType());
    assertEquals(DEVICE_NAME, SCRATCH_DISK.deviceName());
    assertEquals(INDEX, SCRATCH_DISK.index());
    assertEquals(LICENSES, SCRATCH_DISK.licenses());

    assertTrue(CREATED_DISK.boot());
    assertEquals(AUTO_DELETE, CREATED_DISK.autoDelete());
    assertNull(CREATED_DISK.interfaceType());
    assertEquals(Type.PERSISTENT, CREATED_DISK.type());
    assertEquals(IMAGE_ID, CREATED_DISK.sourceImage());
    assertEquals(DISK_NAME, CREATED_DISK.diskName());
    assertEquals(DISK_TYPE_ID, CREATED_DISK.diskType());
    assertEquals(DISK_SIZE_GB, CREATED_DISK.diskSizeGb());
    assertEquals(DEVICE_NAME, CREATED_DISK.deviceName());
    assertEquals(INDEX, CREATED_DISK.index());
    assertEquals(LICENSES, CREATED_DISK.licenses());
  }

  @Test
  public void testOf() {
    PersistentAttachedDisk persistentAttachedDisk = PersistentAttachedDisk.of(DISK_ID);
    assertNull(persistentAttachedDisk.boot());
    assertNull(persistentAttachedDisk.autoDelete());
    assertNull(persistentAttachedDisk.interfaceType());
    assertEquals(Type.PERSISTENT, persistentAttachedDisk.type());
    assertNull(persistentAttachedDisk.mode());
    assertEquals(DISK_ID, persistentAttachedDisk.sourceDisk());
    assertNull(persistentAttachedDisk.deviceName());
    assertNull(persistentAttachedDisk.index());
    assertNull(persistentAttachedDisk.licenses());

    ScratchAttachedDisk scratchAttachedDisk = ScratchAttachedDisk.of(DISK_TYPE_ID);
    assertFalse(scratchAttachedDisk.boot());
    assertTrue(scratchAttachedDisk.autoDelete());
    assertNull(scratchAttachedDisk.interfaceType());
    assertEquals(Type.SCRATCH, scratchAttachedDisk.type());
    assertEquals(DISK_TYPE_ID, scratchAttachedDisk.diskType());
    assertNull(scratchAttachedDisk.deviceName());
    assertNull(scratchAttachedDisk.index());
    assertNull(scratchAttachedDisk.licenses());

    CreateAttachedDisk createAttachedDisk = CreateAttachedDisk.of(IMAGE_ID);
    assertTrue(createAttachedDisk.boot());
    assertNull(createAttachedDisk.autoDelete());
    assertNull(createAttachedDisk.interfaceType());
    assertEquals(Type.PERSISTENT, createAttachedDisk.type());
    assertEquals(IMAGE_ID, createAttachedDisk.sourceImage());
    assertNull(createAttachedDisk.diskName());
    assertNull(createAttachedDisk.diskType());
    assertNull(createAttachedDisk.diskSizeGb());
    assertNull(createAttachedDisk.deviceName());
    assertNull(createAttachedDisk.index());
    assertNull(createAttachedDisk.licenses());
  }

  @Test
  public void testToAndFromPb() {
    AttachedDisk attachedDisk = AttachedDisk.fromPb(PERSISTENT_DISK.toPb());
    compareAttachedDisk(PERSISTENT_DISK, attachedDisk);
    attachedDisk = AttachedDisk.fromPb(SCRATCH_DISK.toPb());
    compareAttachedDisk(SCRATCH_DISK, attachedDisk);
    attachedDisk = AttachedDisk.fromPb(CREATED_DISK.toPb());
    compareAttachedDisk(CREATED_DISK, attachedDisk);
    PersistentAttachedDisk persistentAttachedDisk = PersistentAttachedDisk.of(DISK_ID);
    comparePersistentAttachedDisk(persistentAttachedDisk,
        AttachedDisk.<PersistentAttachedDisk>fromPb(persistentAttachedDisk.toPb()));
    ScratchAttachedDisk scratchAttachedDisk = ScratchAttachedDisk.of(DISK_TYPE_ID);
    compareScratchAttachedDisk(scratchAttachedDisk,
        AttachedDisk.<ScratchAttachedDisk>fromPb(scratchAttachedDisk.toPb()));
    CreateAttachedDisk createAttachedDisk = CreateAttachedDisk.of(IMAGE_ID);
    compareCreateAttachedDisk(createAttachedDisk,
        AttachedDisk.<CreateAttachedDisk>fromPb(createAttachedDisk.toPb()));
  }

  @Test
  public void testSetProjectId() {
    PersistentAttachedDisk persistentAttachedDisk =
        PersistentAttachedDisk.of(DiskId.of("zone", "disk"));
    comparePersistentAttachedDisk(
        PersistentAttachedDisk.of(DiskId.of("project", "zone", "disk")),
            persistentAttachedDisk.setProjectId("project"));
    ScratchAttachedDisk scratchAttachedDisk =
        ScratchAttachedDisk.of(DiskTypeId.of("zone", "diskType"));
    compareScratchAttachedDisk(
        ScratchAttachedDisk.of(DiskTypeId.of("project", "zone", "diskType")),
            scratchAttachedDisk.setProjectId("project"));
    CreateAttachedDisk createAttachedDisk = CREATED_DISK.toBuilder()
        .diskType(DiskTypeId.of("zone", "diskType"))
        .sourceImage(ImageId.of("image"))
        .build();
    compareCreateAttachedDisk(CREATED_DISK,
        createAttachedDisk.setProjectId("project"));
  }

  public void comparePersistentAttachedDisk(PersistentAttachedDisk expected,
      PersistentAttachedDisk value) {
    compareAttachedDisk(expected, value);
    assertEquals(expected.sourceDisk(), value.sourceDisk());
  }

  public void compareCreateAttachedDisk(CreateAttachedDisk expected, CreateAttachedDisk value) {
    compareAttachedDisk(expected, value);
    assertEquals(expected.diskName(), value.diskName());
    assertEquals(expected.diskType(), value.diskType());
    assertEquals(expected.diskSizeGb(), value.diskSizeGb());
    assertEquals(expected.sourceImage(), value.sourceImage());
  }

  public void compareScratchAttachedDisk(ScratchAttachedDisk expected, ScratchAttachedDisk value) {
    compareAttachedDisk(expected, value);
    assertEquals(expected.diskType(), value.diskType());
  }

  public void compareAttachedDisk(AttachedDisk expected, AttachedDisk value) {
    assertEquals(expected, value);
    assertEquals(expected.deviceName(), value.deviceName());
    assertEquals(expected.index(), value.index());
    assertEquals(expected.licenses(), value.licenses());
    assertEquals(expected.boot(), value.boot());
    assertEquals(expected.autoDelete(), value.autoDelete());
    assertEquals(expected.interfaceType(), value.interfaceType());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.mode(), value.mode());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
