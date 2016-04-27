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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.DiskInfo.CreationStatus;

import org.junit.Test;

import java.util.List;

public class DiskTest {

  private static final String GENERATED_ID = "42";
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
  private static final String IMAGE_ID = "imageId";
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

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Disk disk;
  private Disk standardDisk;
  private Disk snapshotDisk;
  private Disk imageDisk;

  private void initializeExpectedDisk(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    standardDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, DISK_CONFIGURATION)
        .generatedId(GENERATED_ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .creationStatus(CREATION_STATUS)
        .description(DESCRIPTION)
        .licenses(LICENSES)
        .attachedInstances(ATTACHED_INSTANCES)
        .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    snapshotDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, SNAPSHOT_DISK_CONFIGURATION)
        .generatedId(GENERATED_ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .creationStatus(CREATION_STATUS)
        .description(DESCRIPTION)
        .licenses(LICENSES)
        .attachedInstances(ATTACHED_INSTANCES)
        .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    imageDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, IMAGE_DISK_CONFIGURATION)
        .generatedId(GENERATED_ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .creationStatus(CREATION_STATUS)
        .description(DESCRIPTION)
        .licenses(LICENSES)
        .attachedInstances(ATTACHED_INSTANCES)
        .lastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .lastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeDisk() {
    disk = new Disk.Builder(compute, DISK_ID, DISK_CONFIGURATION)
        .generatedId(GENERATED_ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .creationStatus(CREATION_STATUS)
        .description(DESCRIPTION)
        .licenses(LICENSES)
        .attachedInstances(ATTACHED_INSTANCES)
        .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedDisk(16);
    compareDisk(standardDisk, standardDisk.toBuilder().build());
    compareDisk(imageDisk, imageDisk.toBuilder().build());
    compareDisk(snapshotDisk, snapshotDisk.toBuilder().build());
    Disk newDisk = standardDisk.toBuilder().description("newDescription").build();
    assertEquals("newDescription", newDisk.description());
    newDisk = newDisk.toBuilder().description("description").build();
    compareDisk(standardDisk, newDisk);
  }

  @Test
  public void testToBuilderIncomplete() {
    initializeExpectedDisk(18);
    DiskInfo diskInfo = DiskInfo.of(DISK_ID, DISK_CONFIGURATION);
    Disk disk = new Disk(serviceMockReturnsOptions, new DiskInfo.BuilderImpl(diskInfo));
    compareDisk(disk, disk.toBuilder().build());
    diskInfo = DiskInfo.of(DISK_ID, SNAPSHOT_DISK_CONFIGURATION);
    disk = new Disk(serviceMockReturnsOptions, new DiskInfo.BuilderImpl(diskInfo));
    compareDisk(disk, disk.toBuilder().build());
    diskInfo = DiskInfo.of(DISK_ID, IMAGE_DISK_CONFIGURATION);
    disk = new Disk(serviceMockReturnsOptions, new DiskInfo.BuilderImpl(diskInfo));
    compareDisk(disk, disk.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedDisk(4);
    assertEquals(DISK_ID, standardDisk.diskId());
    assertEquals(GENERATED_ID, standardDisk.generatedId());
    assertEquals(DISK_CONFIGURATION, standardDisk.configuration());
    assertEquals(CREATION_TIMESTAMP, standardDisk.creationTimestamp());
    assertEquals(CREATION_STATUS, standardDisk.creationStatus());
    assertEquals(DESCRIPTION, standardDisk.description());
    assertEquals(LICENSES, standardDisk.licenses());
    assertEquals(ATTACHED_INSTANCES, standardDisk.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, standardDisk.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, standardDisk.lastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, standardDisk.compute());
    assertEquals(DISK_ID, imageDisk.diskId());
    assertEquals(GENERATED_ID, imageDisk.generatedId());
    assertEquals(IMAGE_DISK_CONFIGURATION, imageDisk.configuration());
    assertEquals(CREATION_TIMESTAMP, imageDisk.creationTimestamp());
    assertEquals(CREATION_STATUS, imageDisk.creationStatus());
    assertEquals(DESCRIPTION, imageDisk.description());
    assertEquals(LICENSES, imageDisk.licenses());
    assertEquals(ATTACHED_INSTANCES, imageDisk.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, imageDisk.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, imageDisk.lastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, imageDisk.compute());
    assertEquals(DISK_ID, snapshotDisk.diskId());
    assertEquals(GENERATED_ID, snapshotDisk.generatedId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, snapshotDisk.configuration());
    assertEquals(CREATION_TIMESTAMP, snapshotDisk.creationTimestamp());
    assertEquals(CREATION_STATUS, snapshotDisk.creationStatus());
    assertEquals(DESCRIPTION, snapshotDisk.description());
    assertEquals(LICENSES, snapshotDisk.licenses());
    assertEquals(ATTACHED_INSTANCES, snapshotDisk.attachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, snapshotDisk.lastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, snapshotDisk.lastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, snapshotDisk.compute());
    Disk disk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, DISK_CONFIGURATION)
        .diskId(DiskId.of("newProject", "newZone"))
        .configuration(SNAPSHOT_DISK_CONFIGURATION)
        .build();
    assertEquals(DiskId.of("newProject", "newZone"), disk.diskId());
    assertNull(disk.generatedId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, disk.configuration());
    assertNull(disk.creationTimestamp());
    assertNull(disk.creationStatus());
    assertNull(disk.description());
    assertNull(disk.licenses());
    assertNull(disk.attachedInstances());
    assertNull(disk.lastAttachTimestamp());
    assertNull(disk.lastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, disk.compute());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedDisk(24);
    compareDisk(standardDisk, Disk.fromPb(serviceMockReturnsOptions, standardDisk.toPb()));
    compareDisk(imageDisk, Disk.fromPb(serviceMockReturnsOptions, imageDisk.toPb()));
    compareDisk(snapshotDisk, Disk.fromPb(serviceMockReturnsOptions, snapshotDisk.toPb()));
    Disk disk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, DISK_CONFIGURATION).build();
    compareDisk(disk, Disk.fromPb(serviceMockReturnsOptions, disk.toPb()));
    disk =
        new Disk.Builder(serviceMockReturnsOptions, DISK_ID, SNAPSHOT_DISK_CONFIGURATION).build();
    compareDisk(disk, Disk.fromPb(serviceMockReturnsOptions, disk.toPb()));
    disk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, IMAGE_DISK_CONFIGURATION).build();
    compareDisk(disk, Disk.fromPb(serviceMockReturnsOptions, disk.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    expect(compute.delete(DISK_ID)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedDisk(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.delete(DISK_ID)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedDisk(3);
    Compute.DiskOption[] expectedOptions = {Compute.DiskOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(DISK_ID, expectedOptions)).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    assertTrue(disk.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedDisk(3);
    Compute.DiskOption[] expectedOptions = {Compute.DiskOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(DISK_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertFalse(disk.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedDisk(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(DISK_ID)).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    Disk updatedDisk = disk.reload();
    compareDisk(imageDisk, updatedDisk);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedDisk(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(DISK_ID)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedDisk(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(DISK_ID, Compute.DiskOption.fields())).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    Disk updatedDisk = disk.reload(Compute.DiskOption.fields());
    compareDisk(imageDisk, updatedDisk);
    verify(compute);
  }

  @Test
  public void testCreateSnapshot() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.snapshot());
    SnapshotInfo snapshot = SnapshotInfo.builder(snapshotId, DISK_ID).build();
    expect(compute.create(snapshot)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createSnapshot(SNAPSHOT.snapshot()));
  }

  @Test
  public void testCreateSnapshotWithDescription() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.snapshot());
    SnapshotInfo snapshot = SnapshotInfo.builder(snapshotId, DISK_ID)
        .description("description")
        .build();
    expect(compute.create(snapshot)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createSnapshot(SNAPSHOT.snapshot(), "description"));
  }

  @Test
  public void testCreateSnapshotWithOptions() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.snapshot());
    SnapshotInfo snapshot = SnapshotInfo.builder(snapshotId, DISK_ID).build();
    expect(compute.create(snapshot, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createSnapshot(SNAPSHOT.snapshot(), Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateSnapshotWithDescriptionAndOptions() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.snapshot());
    SnapshotInfo snapshot = SnapshotInfo.builder(snapshotId, DISK_ID)
        .description("description")
        .build();
    expect(compute.create(snapshot, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createSnapshot(SNAPSHOT.snapshot(), "description", Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateImage() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.image());
    ImageInfo image = ImageInfo.of(imageId, DiskImageConfiguration.of(DISK_ID));
    expect(compute.create(image)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.image()));
  }

  @Test
  public void testCreateImageWithDescription() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.image());
    ImageInfo image = ImageInfo.builder(imageId, DiskImageConfiguration.of(DISK_ID))
        .description("description")
        .build();
    expect(compute.create(image)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.image(), "description"));
  }

  @Test
  public void testCreateImageWithOptions() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.image());
    ImageInfo image = ImageInfo.of(imageId, DiskImageConfiguration.of(DISK_ID));
    expect(compute.create(image, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.image(), Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateImageWithDescriptionAndOptions() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.image());
    ImageInfo image = ImageInfo.builder(imageId, DiskImageConfiguration.of(DISK_ID))
        .description("description")
        .build();
    expect(compute.create(image, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createImage(IMAGE.image(), "description", Compute.OperationOption.fields()));
  }

  @Test
  public void testResizeOperation() {
    initializeExpectedDisk(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    expect(compute.resize(DISK_ID, 42L)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.resize(42L));
  }

  @Test
  public void testResizeNull() {
    initializeExpectedDisk(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.resize(DISK_ID, 42L)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.resize(42L));
  }

  public void compareDisk(Disk expected, Disk value) {
    assertEquals(expected, value);
    assertEquals(expected.compute().options(), value.compute().options());
    assertEquals(expected.diskId(), value.diskId());
    assertEquals(expected.configuration(), value.configuration());
    assertEquals(expected.generatedId(), value.generatedId());
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
