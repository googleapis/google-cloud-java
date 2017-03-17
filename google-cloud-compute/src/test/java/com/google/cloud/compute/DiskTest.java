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

import org.junit.Test;

import java.util.List;

public class DiskTest {

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
  private static final String IMAGE_ID = "imageId";
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

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Disk disk;
  private Disk standardDisk;
  private Disk snapshotDisk;
  private Disk imageDisk;

  private void initializeExpectedDisk(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    standardDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setCreationStatus(CREATION_STATUS)
        .setDescription(DESCRIPTION)
        .setLicenses(LICENSES)
        .setAttachedInstances(ATTACHED_INSTANCES)
        .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    snapshotDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, SNAPSHOT_DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setCreationStatus(CREATION_STATUS)
        .setDescription(DESCRIPTION)
        .setLicenses(LICENSES)
        .setAttachedInstances(ATTACHED_INSTANCES)
        .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    imageDisk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, IMAGE_DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setCreationStatus(CREATION_STATUS)
        .setDescription(DESCRIPTION)
        .setLicenses(LICENSES)
        .setAttachedInstances(ATTACHED_INSTANCES)
        .setLastAttachTimestamp(LAST_ATTACH_TIMESTAMP)
        .setLastDetachTimestamp(LAST_DETACH_TIMESTAMP)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeDisk() {
    disk = new Disk.Builder(compute, DISK_ID, DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setCreationStatus(CREATION_STATUS)
        .setDescription(DESCRIPTION)
        .setLicenses(LICENSES)
        .setAttachedInstances(ATTACHED_INSTANCES)
        .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedDisk(16);
    compareDisk(standardDisk, standardDisk.toBuilder().build());
    compareDisk(imageDisk, imageDisk.toBuilder().build());
    compareDisk(snapshotDisk, snapshotDisk.toBuilder().build());
    Disk newDisk = standardDisk.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", newDisk.getDescription());
    newDisk = newDisk.toBuilder().setDescription("description").build();
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
    assertEquals(DISK_ID, standardDisk.getDiskId());
    assertEquals(GENERATED_ID, standardDisk.getGeneratedId());
    assertEquals(DISK_CONFIGURATION, standardDisk.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, standardDisk.getCreationTimestamp());
    assertEquals(CREATION_STATUS, standardDisk.getCreationStatus());
    assertEquals(DESCRIPTION, standardDisk.getDescription());
    assertEquals(LICENSES, standardDisk.getLicenses());
    assertEquals(ATTACHED_INSTANCES, standardDisk.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, standardDisk.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, standardDisk.getLastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, standardDisk.getCompute());
    assertEquals(DISK_ID, imageDisk.getDiskId());
    assertEquals(GENERATED_ID, imageDisk.getGeneratedId());
    assertEquals(IMAGE_DISK_CONFIGURATION, imageDisk.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, imageDisk.getCreationTimestamp());
    assertEquals(CREATION_STATUS, imageDisk.getCreationStatus());
    assertEquals(DESCRIPTION, imageDisk.getDescription());
    assertEquals(LICENSES, imageDisk.getLicenses());
    assertEquals(ATTACHED_INSTANCES, imageDisk.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, imageDisk.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, imageDisk.getLastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, imageDisk.getCompute());
    assertEquals(DISK_ID, snapshotDisk.getDiskId());
    assertEquals(GENERATED_ID, snapshotDisk.getGeneratedId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, snapshotDisk.getConfiguration());
    assertEquals(CREATION_TIMESTAMP, snapshotDisk.getCreationTimestamp());
    assertEquals(CREATION_STATUS, snapshotDisk.getCreationStatus());
    assertEquals(DESCRIPTION, snapshotDisk.getDescription());
    assertEquals(LICENSES, snapshotDisk.getLicenses());
    assertEquals(ATTACHED_INSTANCES, snapshotDisk.getAttachedInstances());
    assertEquals(LAST_ATTACH_TIMESTAMP, snapshotDisk.getLastAttachTimestamp());
    assertEquals(LAST_DETACH_TIMESTAMP, snapshotDisk.getLastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, snapshotDisk.getCompute());
    Disk disk = new Disk.Builder(serviceMockReturnsOptions, DISK_ID, DISK_CONFIGURATION)
        .setDiskId(DiskId.of("newProject", "newZone"))
        .setConfiguration(SNAPSHOT_DISK_CONFIGURATION)
        .build();
    assertEquals(DiskId.of("newProject", "newZone"), disk.getDiskId());
    assertNull(disk.getGeneratedId());
    assertEquals(SNAPSHOT_DISK_CONFIGURATION, disk.getConfiguration());
    assertNull(disk.getCreationTimestamp());
    assertNull(disk.getCreationStatus());
    assertNull(disk.getDescription());
    assertNull(disk.getLicenses());
    assertNull(disk.getAttachedInstances());
    assertNull(disk.getLastAttachTimestamp());
    assertNull(disk.getLastDetachTimestamp());
    assertSame(serviceMockReturnsOptions, disk.getCompute());
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
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    expect(compute.deleteDisk(DISK_ID)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedDisk(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteDisk(DISK_ID)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedDisk(3);
    Compute.DiskOption[] expectedOptions = {Compute.DiskOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getDisk(DISK_ID, expectedOptions)).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    assertTrue(disk.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedDisk(3);
    Compute.DiskOption[] expectedOptions = {Compute.DiskOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getDisk(DISK_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertFalse(disk.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedDisk(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getDisk(DISK_ID)).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    Disk updatedDisk = disk.reload();
    compareDisk(imageDisk, updatedDisk);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedDisk(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getDisk(DISK_ID)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedDisk(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getDisk(DISK_ID, Compute.DiskOption.fields())).andReturn(imageDisk);
    replay(compute);
    initializeDisk();
    Disk updatedDisk = disk.reload(Compute.DiskOption.fields());
    compareDisk(imageDisk, updatedDisk);
    verify(compute);
  }

  @Test
  public void testCreateSnapshot() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.getSnapshot());
    SnapshotInfo snapshot = SnapshotInfo.newBuilder(snapshotId, DISK_ID).build();
    expect(compute.create(snapshot)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createSnapshot(SNAPSHOT.getSnapshot()));
  }

  @Test
  public void testCreateSnapshotWithDescription() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.getSnapshot());
    SnapshotInfo snapshot = SnapshotInfo.newBuilder(snapshotId, DISK_ID)
        .setDescription("description")
        .build();
    expect(compute.create(snapshot)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createSnapshot(SNAPSHOT.getSnapshot(), "description"));
  }

  @Test
  public void testCreateSnapshotWithOptions() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.getSnapshot());
    SnapshotInfo snapshot = SnapshotInfo.newBuilder(snapshotId, DISK_ID).build();
    expect(compute.create(snapshot, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createSnapshot(SNAPSHOT.getSnapshot(), Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateSnapshotWithDescriptionAndOptions() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    SnapshotId snapshotId = SnapshotId.of(SNAPSHOT.getSnapshot());
    SnapshotInfo snapshot = SnapshotInfo.newBuilder(snapshotId, DISK_ID)
        .setDescription("description")
        .build();
    expect(compute.create(snapshot, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createSnapshot(SNAPSHOT.getSnapshot(), "description",
            Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateImage() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.getImage());
    ImageInfo image = ImageInfo.of(imageId, DiskImageConfiguration.of(DISK_ID));
    expect(compute.create(image)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.getImage()));
  }

  @Test
  public void testCreateImageWithDescription() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.getImage());
    ImageInfo image = ImageInfo.newBuilder(imageId, DiskImageConfiguration.of(DISK_ID))
        .setDescription("description")
        .build();
    expect(compute.create(image)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.getImage(), "description"));
  }

  @Test
  public void testCreateImageWithOptions() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.getImage());
    ImageInfo image = ImageInfo.of(imageId, DiskImageConfiguration.of(DISK_ID));
    expect(compute.create(image, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.createImage(IMAGE.getImage(), Compute.OperationOption.fields()));
  }

  @Test
  public void testCreateImageWithDescriptionAndOptions() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    ImageId imageId = ImageId.of(IMAGE.getImage());
    ImageInfo image = ImageInfo.newBuilder(imageId, DiskImageConfiguration.of(DISK_ID))
        .setDescription("description")
        .build();
    expect(compute.create(image, Compute.OperationOption.fields())).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation,
        disk.createImage(IMAGE.getImage(), "description", Compute.OperationOption.fields()));
  }

  @Test
  public void testResizeOperation() {
    initializeExpectedDisk(4);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZoneOperationId.of("project", "zone", "op"))
        .build();
    expect(compute.resize(DISK_ID, 42L)).andReturn(operation);
    replay(compute);
    initializeDisk();
    assertSame(operation, disk.resize(42L));
  }

  @Test
  public void testResizeNull() {
    initializeExpectedDisk(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.resize(DISK_ID, 42L)).andReturn(null);
    replay(compute);
    initializeDisk();
    assertNull(disk.resize(42L));
  }

  public void compareDisk(Disk expected, Disk value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().getOptions(), value.getCompute().getOptions());
    assertEquals(expected.getDiskId(), value.getDiskId());
    assertEquals(expected.getConfiguration(), value.getConfiguration());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
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
