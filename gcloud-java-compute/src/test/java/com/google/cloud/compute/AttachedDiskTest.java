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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.compute.AttachedDisk.AttachedDiskConfiguration.InterfaceType;
import com.google.cloud.compute.AttachedDisk.AttachedDiskConfiguration.Type;
import com.google.cloud.compute.AttachedDisk.CreateDiskConfiguration;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.AttachedDisk.ScratchDiskConfiguration;
import com.google.common.collect.ImmutableList;

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
  private static final PersistentDiskConfiguration.Mode MODE =
          PersistentDiskConfiguration.Mode.READ_ONLY;
  private static final PersistentDiskConfiguration PERSISTENT_DISK_CONFIGURATION =
      PersistentDiskConfiguration.builder(DISK_ID)
          .boot(BOOT)
          .autoDelete(AUTO_DELETE)
          .mode(MODE)
          .build();
  private static final ScratchDiskConfiguration SCRATCH_DISK_CONFIGURATION =
      ScratchDiskConfiguration.builder(DISK_TYPE_ID).interfaceType(INTERFACE_TYPE).build();
  private static final CreateDiskConfiguration CREATE_DISK_CONFIGURATION =
      CreateDiskConfiguration.builder(IMAGE_ID)
          .autoDelete(AUTO_DELETE)
          .diskName(DISK_NAME)
          .diskType(DISK_TYPE_ID)
          .diskSizeGb(DISK_SIZE_GB)
          .sourceImage(IMAGE_ID)
          .build();
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final AttachedDisk PERSISTENT_DISK =
      AttachedDisk.builder(PERSISTENT_DISK_CONFIGURATION)
          .deviceName(DEVICE_NAME)
          .index(INDEX)
          .licenses(LICENSES)
          .build();
  private static final AttachedDisk SCRATCH_DISK  =
      AttachedDisk.builder(SCRATCH_DISK_CONFIGURATION)
          .deviceName(DEVICE_NAME)
          .index(INDEX)
          .licenses(LICENSES)
          .build();
  private static final AttachedDisk CREATED_DISK  =
      AttachedDisk.builder(CREATE_DISK_CONFIGURATION)
          .deviceName(DEVICE_NAME)
          .index(INDEX)
          .licenses(LICENSES)
          .build();

  @Test
  public void testConfigurationToBuilder() {
    comparePersistentDiskConfiguration(PERSISTENT_DISK_CONFIGURATION,
        PERSISTENT_DISK_CONFIGURATION.toBuilder().build());
    compareScratchDiskConfiguration(SCRATCH_DISK_CONFIGURATION,
        SCRATCH_DISK_CONFIGURATION.toBuilder().build());
    compareCreateDiskConfiguration(CREATE_DISK_CONFIGURATION,
        CREATE_DISK_CONFIGURATION.toBuilder().build());
    PersistentDiskConfiguration persistentDiskConfiguration =
        PERSISTENT_DISK_CONFIGURATION.toBuilder().autoDelete(false).build();
    assertFalse(persistentDiskConfiguration.autoDelete());
    persistentDiskConfiguration =
        persistentDiskConfiguration.toBuilder().autoDelete(AUTO_DELETE).build();
    assertEquals(PERSISTENT_DISK_CONFIGURATION, persistentDiskConfiguration);
    ScratchDiskConfiguration scratchDiskConfiguration =
        SCRATCH_DISK_CONFIGURATION.toBuilder().interfaceType(InterfaceType.SCSI).build();
    assertEquals(InterfaceType.SCSI, scratchDiskConfiguration.interfaceType());
    scratchDiskConfiguration =
        scratchDiskConfiguration.toBuilder().interfaceType(INTERFACE_TYPE).build();
    assertEquals(SCRATCH_DISK_CONFIGURATION, scratchDiskConfiguration);
    CreateDiskConfiguration createDiskConfiguration =
        CREATE_DISK_CONFIGURATION.toBuilder().autoDelete(false).build();
    assertFalse(createDiskConfiguration.autoDelete());
    createDiskConfiguration = createDiskConfiguration.toBuilder().autoDelete(AUTO_DELETE).build();
    assertEquals(CREATE_DISK_CONFIGURATION, createDiskConfiguration);
  }

  @Test
  public void testConfigurationToBuilderIncomplete() {
    PersistentDiskConfiguration persistentConfiguration = PersistentDiskConfiguration.of(DISK_ID);
    comparePersistentDiskConfiguration(persistentConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<PersistentDiskConfiguration>fromPb(
            persistentConfiguration.toPb()));
    ScratchDiskConfiguration scratchDiskConfiguration = ScratchDiskConfiguration.of(DISK_TYPE_ID);
    compareScratchDiskConfiguration(scratchDiskConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<ScratchDiskConfiguration>fromPb(
            scratchDiskConfiguration.toPb()));
    CreateDiskConfiguration createDiskConfiguration = CreateDiskConfiguration.of(IMAGE_ID);
    compareCreateDiskConfiguration(createDiskConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<CreateDiskConfiguration>fromPb(
            createDiskConfiguration.toPb()));
  }

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
    AttachedDisk attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
    attachedDisk = AttachedDisk.of(SCRATCH_DISK_CONFIGURATION);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
    attachedDisk = AttachedDisk.of(CREATE_DISK_CONFIGURATION);
    assertEquals(attachedDisk, attachedDisk.toBuilder().build());
  }

  @Test
  public void testConfigurationBuilder() {
    assertTrue(CREATE_DISK_CONFIGURATION.boot());
    assertEquals(AUTO_DELETE, CREATE_DISK_CONFIGURATION.autoDelete());
    assertNull(CREATE_DISK_CONFIGURATION.interfaceType());
    assertEquals(Type.PERSISTENT, CREATE_DISK_CONFIGURATION.type());
    assertEquals(IMAGE_ID, CREATE_DISK_CONFIGURATION.sourceImage());
    assertEquals(DISK_NAME, CREATE_DISK_CONFIGURATION.diskName());
    assertEquals(DISK_TYPE_ID, CREATE_DISK_CONFIGURATION.diskType());
    assertEquals(DISK_SIZE_GB, CREATE_DISK_CONFIGURATION.diskSizeGb());
    assertEquals(IMAGE_ID, CREATE_DISK_CONFIGURATION.sourceImage());

    assertEquals(BOOT, PERSISTENT_DISK_CONFIGURATION.boot());
    assertEquals(AUTO_DELETE, PERSISTENT_DISK_CONFIGURATION.autoDelete());
    assertNull(PERSISTENT_DISK_CONFIGURATION.interfaceType());
    assertEquals(Type.PERSISTENT, PERSISTENT_DISK_CONFIGURATION.type());
    assertEquals(MODE, PERSISTENT_DISK_CONFIGURATION.mode());
    assertEquals(DISK_ID, PERSISTENT_DISK_CONFIGURATION.sourceDisk());

    assertFalse(SCRATCH_DISK_CONFIGURATION.boot());
    assertTrue(SCRATCH_DISK_CONFIGURATION.autoDelete());
    assertEquals(INTERFACE_TYPE, SCRATCH_DISK_CONFIGURATION.interfaceType());
    assertEquals(Type.SCRATCH, SCRATCH_DISK_CONFIGURATION.type());
    assertEquals(DISK_TYPE_ID, SCRATCH_DISK_CONFIGURATION.diskType());
  }

  @Test
  public void testBuilder() {
    assertEquals(PERSISTENT_DISK_CONFIGURATION, PERSISTENT_DISK.configuration());
    assertEquals(DEVICE_NAME, PERSISTENT_DISK.deviceName());
    assertEquals(INDEX, PERSISTENT_DISK.index());
    assertEquals(LICENSES, PERSISTENT_DISK.licenses());
    assertEquals(SCRATCH_DISK_CONFIGURATION, SCRATCH_DISK.configuration());
    assertEquals(DEVICE_NAME, SCRATCH_DISK.deviceName());
    assertEquals(INDEX, SCRATCH_DISK.index());
    assertEquals(LICENSES, SCRATCH_DISK.licenses());
    assertEquals(CREATE_DISK_CONFIGURATION, CREATED_DISK.configuration());
    assertEquals(DEVICE_NAME, CREATED_DISK.deviceName());
    assertEquals(INDEX, CREATED_DISK.index());
    assertEquals(LICENSES, CREATED_DISK.licenses());
  }

  @Test
  public void testConfigurationOf() {
    PersistentDiskConfiguration persistentConfiguration = PersistentDiskConfiguration.of(DISK_ID);
    assertEquals(DISK_ID, persistentConfiguration.sourceDisk());
    assertEquals(Type.PERSISTENT, persistentConfiguration.type());
    assertNull(persistentConfiguration.autoDelete());
    assertNull(persistentConfiguration.boot());
    assertNull(persistentConfiguration.interfaceType());
    ScratchDiskConfiguration scratchDiskConfiguration = ScratchDiskConfiguration.of(DISK_TYPE_ID);
    assertEquals(DISK_TYPE_ID, scratchDiskConfiguration.diskType());
    assertNull(scratchDiskConfiguration.interfaceType());
    assertEquals(Type.SCRATCH, scratchDiskConfiguration.type());
    assertTrue(scratchDiskConfiguration.autoDelete());
    assertFalse(scratchDiskConfiguration.boot());
    assertNull(scratchDiskConfiguration.interfaceType());
    CreateDiskConfiguration createDiskConfiguration = CreateDiskConfiguration.of(IMAGE_ID);
    assertEquals(IMAGE_ID, createDiskConfiguration.sourceImage());
    assertNull(createDiskConfiguration.diskType());
    assertNull(createDiskConfiguration.diskName());
    assertNull(createDiskConfiguration.diskSizeGb());
    assertNull(createDiskConfiguration.interfaceType());
    assertEquals(Type.PERSISTENT, createDiskConfiguration.type());
    assertNull(createDiskConfiguration.autoDelete());
    assertTrue(createDiskConfiguration.boot());
    assertNull(createDiskConfiguration.interfaceType());
  }

  @Test
  public void testOf() {
    AttachedDisk attachedDisk = AttachedDisk.of(DEVICE_NAME, PERSISTENT_DISK_CONFIGURATION);
    assertEquals(PERSISTENT_DISK_CONFIGURATION, attachedDisk.configuration());
    assertEquals(DEVICE_NAME, attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
    attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    assertEquals(PERSISTENT_DISK_CONFIGURATION, attachedDisk.configuration());
    assertNull(attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
    attachedDisk = AttachedDisk.of(DEVICE_NAME, SCRATCH_DISK_CONFIGURATION);
    assertEquals(SCRATCH_DISK_CONFIGURATION, attachedDisk.configuration());
    assertEquals(DEVICE_NAME, attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
    attachedDisk = AttachedDisk.of(SCRATCH_DISK_CONFIGURATION);
    assertEquals(SCRATCH_DISK_CONFIGURATION, attachedDisk.configuration());
    assertNull(attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
    attachedDisk = AttachedDisk.of(DEVICE_NAME, CREATE_DISK_CONFIGURATION);
    assertEquals(CREATE_DISK_CONFIGURATION, attachedDisk.configuration());
    assertEquals(DEVICE_NAME, attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
    attachedDisk = AttachedDisk.of(CREATE_DISK_CONFIGURATION);
    assertEquals(CREATE_DISK_CONFIGURATION, attachedDisk.configuration());
    assertNull(attachedDisk.deviceName());
    assertNull(attachedDisk.index());
    assertNull(attachedDisk.licenses());
  }

  @Test
  public void testConfigurationToAndFromPb() {
    PersistentDiskConfiguration persistentConfiguration =
        PersistentDiskConfiguration.of(DISK_ID);
    comparePersistentDiskConfiguration(persistentConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<PersistentDiskConfiguration>fromPb(
            persistentConfiguration.toPb()));
    comparePersistentDiskConfiguration(PERSISTENT_DISK_CONFIGURATION,
        AttachedDisk.AttachedDiskConfiguration.<PersistentDiskConfiguration>fromPb(
            PERSISTENT_DISK_CONFIGURATION.toPb()));
    ScratchDiskConfiguration scratchDiskConfiguration =
        ScratchDiskConfiguration.of(DISK_TYPE_ID);
    compareScratchDiskConfiguration(scratchDiskConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<ScratchDiskConfiguration>fromPb(
            scratchDiskConfiguration.toPb()));
    compareScratchDiskConfiguration(SCRATCH_DISK_CONFIGURATION,
        AttachedDisk.AttachedDiskConfiguration.<ScratchDiskConfiguration>fromPb(
            SCRATCH_DISK_CONFIGURATION.toPb()));
    CreateDiskConfiguration createDiskConfiguration =
        CreateDiskConfiguration.of(IMAGE_ID);
    compareCreateDiskConfiguration(createDiskConfiguration,
        AttachedDisk.AttachedDiskConfiguration.<CreateDiskConfiguration>fromPb(
            createDiskConfiguration.toPb()));
    compareCreateDiskConfiguration(CREATE_DISK_CONFIGURATION,
        AttachedDisk.AttachedDiskConfiguration.<CreateDiskConfiguration>fromPb(
            CREATE_DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testToAndFromPb() {
    AttachedDisk attachedDisk = AttachedDisk.fromPb(PERSISTENT_DISK.toPb());
    compareAttachedDisk(PERSISTENT_DISK, attachedDisk);
    attachedDisk = AttachedDisk.fromPb(SCRATCH_DISK.toPb());
    compareAttachedDisk(SCRATCH_DISK, attachedDisk);
    attachedDisk = AttachedDisk.fromPb(CREATED_DISK.toPb());
    compareAttachedDisk(CREATED_DISK, attachedDisk);
    attachedDisk = AttachedDisk.of(DEVICE_NAME, PERSISTENT_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
    attachedDisk = AttachedDisk.of(PERSISTENT_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
    attachedDisk = AttachedDisk.of(DEVICE_NAME, SCRATCH_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
    attachedDisk = AttachedDisk.of(SCRATCH_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
    attachedDisk = AttachedDisk.of(DEVICE_NAME, CREATE_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
    attachedDisk = AttachedDisk.of(CREATE_DISK_CONFIGURATION);
    compareAttachedDisk(attachedDisk, AttachedDisk.fromPb(attachedDisk.toPb()));
  }

  @Test
  public void testConfigurationSetProjectId() {
    PersistentDiskConfiguration persistentConfiguration =
        PersistentDiskConfiguration.of(DiskId.of("zone", "disk"));
    comparePersistentDiskConfiguration(
        PersistentDiskConfiguration.of(DiskId.of("project", "zone", "disk")),
            persistentConfiguration.setProjectId("project"));
    ScratchDiskConfiguration scratchDiskConfiguration =
        ScratchDiskConfiguration.of(DiskTypeId.of("zone", "diskType"));
    compareScratchDiskConfiguration(
        ScratchDiskConfiguration.of(DiskTypeId.of("project", "zone", "diskType")),
            scratchDiskConfiguration.setProjectId("project"));
    CreateDiskConfiguration createDiskConfiguration = CREATE_DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of("zone", "diskType"))
        .sourceImage(ImageId.of("image"))
        .build();
    compareCreateDiskConfiguration(CREATE_DISK_CONFIGURATION,
        createDiskConfiguration.setProjectId("project"));
  }

  @Test
  public void testSetProjectId() {
    PersistentDiskConfiguration persistentConfiguration =
        PersistentDiskConfiguration.of(DiskId.of("zone", "disk"));
    PersistentDiskConfiguration persistentConfigurationWithProject =
        PersistentDiskConfiguration.of(DiskId.of("project", "zone", "disk"));
    AttachedDisk attachedDisk = AttachedDisk.of(persistentConfiguration);
    compareAttachedDisk(AttachedDisk.of(persistentConfigurationWithProject),
        attachedDisk.setProjectId("project"));
    ScratchDiskConfiguration scratchDiskConfiguration =
        ScratchDiskConfiguration.of(DiskTypeId.of("zone", "diskType"));
    ScratchDiskConfiguration scratchDiskConfigurationWithProject =
        ScratchDiskConfiguration.of(DiskTypeId.of("project", "zone", "diskType"));
    compareAttachedDisk(AttachedDisk.of(scratchDiskConfigurationWithProject),
        AttachedDisk.of(scratchDiskConfiguration).setProjectId("project"));
    CreateDiskConfiguration createDiskConfiguration =
        CreateDiskConfiguration.of(ImageId.of("image"));
    CreateDiskConfiguration createDiskConfigurationWithProject =
        CreateDiskConfiguration.of(ImageId.of("project", "image"));
    compareAttachedDisk(AttachedDisk.of(createDiskConfigurationWithProject),
        AttachedDisk.of(createDiskConfiguration).setProjectId("project"));
    createDiskConfiguration = CREATE_DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of("zone", "diskType"))
        .sourceImage(ImageId.of("image"))
        .build();
    compareAttachedDisk(AttachedDisk.of(CREATE_DISK_CONFIGURATION),
        AttachedDisk.of(createDiskConfiguration).setProjectId("project"));
  }

  public void compareAttachedDiskConfiguration(AttachedDisk.AttachedDiskConfiguration expected,
      AttachedDisk.AttachedDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.interfaceType(), value.interfaceType());
    assertEquals(expected.boot(), value.boot());
    assertEquals(expected.autoDelete(), value.autoDelete());
    assertEquals(expected.hashCode(), value.hashCode());
  }

  public void comparePersistentDiskConfiguration(PersistentDiskConfiguration expected,
      PersistentDiskConfiguration value) {
    compareAttachedDiskConfiguration(expected, value);
    assertEquals(expected.mode(), value.mode());
    assertEquals(expected.sourceDisk(), value.sourceDisk());
  }

  public void compareCreateDiskConfiguration(CreateDiskConfiguration expected,
      CreateDiskConfiguration value) {
    compareAttachedDiskConfiguration(expected, value);
    assertEquals(expected.diskName(), value.diskName());
    assertEquals(expected.diskType(), value.diskType());
    assertEquals(expected.diskSizeGb(), value.diskSizeGb());
    assertEquals(expected.sourceImage(), value.sourceImage());
  }

  public void compareScratchDiskConfiguration(ScratchDiskConfiguration expected,
      ScratchDiskConfiguration value) {
    compareAttachedDiskConfiguration(expected, value);
    assertEquals(expected.diskType(), value.diskType());
  }

  public void compareAttachedDisk(AttachedDisk expected, AttachedDisk value) {
    assertEquals(expected, value);
    assertEquals(expected.deviceName(), value.deviceName());
    assertEquals(expected.index(), value.index());
    assertEquals(expected.configuration(), value.configuration());
    assertEquals(expected.licenses(), value.licenses());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
