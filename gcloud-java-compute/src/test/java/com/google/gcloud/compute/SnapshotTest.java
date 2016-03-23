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

import org.junit.Test;

import java.util.List;

public class SnapshotTest {

  private static final String ID = "42";
  private static final DiskId SOURCE_DISK = DiskId.of("project", "zone", "disk");
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final SnapshotId SNAPSHOT_ID = SnapshotId.of("project", "snapshot");
  private static final SnapshotInfo.Status STATUS = SnapshotInfo.Status.CREATING;
  private static final Long DISK_SIZE_GB = 42L;
  private static final String SOURCE_DISK_ID = "diskId";
  private static final Long STORAGE_BYTES = 24L;
  private static final SnapshotInfo.StorageBytesStatus STORAGE_BYTES_STATUS =
      SnapshotInfo.StorageBytesStatus.UP_TO_DATE;

  private Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Snapshot snapshot;
  private Snapshot expectedSnapshot;

  private void initializeExpectedSnapshot(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedSnapshot = new Snapshot.Builder(serviceMockReturnsOptions, SNAPSHOT_ID, SOURCE_DISK)
        .id(ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .description(DESCRIPTION)
        .status(STATUS)
        .diskSizeGb(DISK_SIZE_GB)
        .licenses(LICENSES)
        .sourceDiskId(SOURCE_DISK_ID)
        .storageBytes(STORAGE_BYTES)
        .storageBytesStatus(STORAGE_BYTES_STATUS)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeSnapshot() {
    snapshot = new Snapshot.Builder(compute, SNAPSHOT_ID, SOURCE_DISK)
        .id(ID)
        .creationTimestamp(CREATION_TIMESTAMP)
        .description(DESCRIPTION)
        .status(STATUS)
        .diskSizeGb(DISK_SIZE_GB)
        .licenses(LICENSES)
        .sourceDiskId(SOURCE_DISK_ID)
        .storageBytes(STORAGE_BYTES)
        .storageBytesStatus(STORAGE_BYTES_STATUS)
        .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedSnapshot(8);
    compareSnapshot(expectedSnapshot, expectedSnapshot.toBuilder().build());
    Snapshot newSnapshot = expectedSnapshot.toBuilder().description("newDescription").build();
    assertEquals("newDescription", newSnapshot.description());
    newSnapshot = newSnapshot.toBuilder().description("description").build();
    compareSnapshot(expectedSnapshot, newSnapshot);
  }

  @Test
  public void testToBuilderIncomplete() {
    initializeExpectedSnapshot(5);
    SnapshotInfo snapshotInfo = SnapshotInfo.of(SNAPSHOT_ID, SOURCE_DISK);
    Snapshot snapshot =
        new Snapshot(serviceMockReturnsOptions, new SnapshotInfo.BuilderImpl(snapshotInfo));
    compareSnapshot(snapshot, snapshot.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedSnapshot(1);
    assertEquals(ID, expectedSnapshot.id());
    assertEquals(SNAPSHOT_ID, expectedSnapshot.snapshotId());
    assertEquals(CREATION_TIMESTAMP, expectedSnapshot.creationTimestamp());
    assertEquals(DESCRIPTION, expectedSnapshot.description());
    assertEquals(STATUS, expectedSnapshot.status());
    assertEquals(DISK_SIZE_GB, expectedSnapshot.diskSizeGb());
    assertEquals(LICENSES, expectedSnapshot.licenses());
    assertEquals(SOURCE_DISK, expectedSnapshot.sourceDisk());
    assertEquals(SOURCE_DISK_ID, expectedSnapshot.sourceDiskId());
    assertEquals(STORAGE_BYTES, expectedSnapshot.storageBytes());
    assertEquals(STORAGE_BYTES_STATUS, expectedSnapshot.storageBytesStatus());
    assertSame(serviceMockReturnsOptions, expectedSnapshot.compute());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedSnapshot(8);
    compareSnapshot(expectedSnapshot,
        Snapshot.fromPb(serviceMockReturnsOptions, expectedSnapshot.toPb()));
    Snapshot snapshot =
        new Snapshot.Builder(serviceMockReturnsOptions, SNAPSHOT_ID, SOURCE_DISK).build();
    compareSnapshot(snapshot, Snapshot.fromPb(serviceMockReturnsOptions, snapshot.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedSnapshot(2);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GlobalOperationId.of("project", "op"))
        .build();
    expect(compute.deleteSnapshot(SNAPSHOT_ID)).andReturn(operation);
    replay(compute);
    initializeSnapshot();
    assertSame(operation, snapshot.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedSnapshot(1);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.deleteSnapshot(SNAPSHOT_ID)).andReturn(null);
    replay(compute);
    initializeSnapshot();
    assertNull(snapshot.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedSnapshot(1);
    Compute.SnapshotOption[] expectedOptions = {Compute.SnapshotOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getSnapshot(SNAPSHOT_ID.snapshot(), expectedOptions))
        .andReturn(expectedSnapshot);
    replay(compute);
    initializeSnapshot();
    assertTrue(snapshot.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedSnapshot(1);
    Compute.SnapshotOption[] expectedOptions = {Compute.SnapshotOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getSnapshot(SNAPSHOT_ID.snapshot(), expectedOptions)).andReturn(null);
    replay(compute);
    initializeSnapshot();
    assertFalse(snapshot.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedSnapshot(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getSnapshot(SNAPSHOT_ID.snapshot())).andReturn(expectedSnapshot);
    replay(compute);
    initializeSnapshot();
    Snapshot updatedSnapshot = snapshot.reload();
    compareSnapshot(expectedSnapshot, updatedSnapshot);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedSnapshot(1);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getSnapshot(SNAPSHOT_ID.snapshot())).andReturn(null);
    replay(compute);
    initializeSnapshot();
    assertNull(snapshot.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedSnapshot(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getSnapshot(SNAPSHOT_ID.snapshot(), Compute.SnapshotOption.fields()))
        .andReturn(expectedSnapshot);
    replay(compute);
    initializeSnapshot();
    Snapshot updatedSnapshot = snapshot.reload(Compute.SnapshotOption.fields());
    compareSnapshot(expectedSnapshot, updatedSnapshot);
    verify(compute);
  }

  public void compareSnapshot(Snapshot expected, Snapshot value) {
    assertEquals(expected, value);
    assertEquals(expected.compute().options(), value.compute().options());
    assertEquals(expected.id(), value.id());
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
