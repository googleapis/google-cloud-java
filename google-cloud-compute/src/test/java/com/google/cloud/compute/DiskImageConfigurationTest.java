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
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class DiskImageConfigurationTest {

  private static final DiskId SOURCE_DISK =  DiskId.of("project", "zone", "disk");
  private static final String SOURCE_DISK_ID = "diskId";
  private static final Long ARCHIVE_SIZE_BYTES = 42L;
  private static final ImageConfiguration.SourceType SOURCE_TYPE = ImageConfiguration.SourceType.RAW;
  private static final DiskImageConfiguration CONFIGURATION =
      DiskImageConfiguration.builder(SOURCE_DISK)
          .sourceDiskId(SOURCE_DISK_ID)
          .sourceType(SOURCE_TYPE)
          .archiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .build();

  @Test
  public void testToBuilder() {
    compareDiskImageConfiguration(CONFIGURATION, CONFIGURATION.toBuilder().build());
    DiskId newDisk = DiskId.of("newProject", "newZone", "newDisk");
    String newDiskId = "newDiskId";
    DiskImageConfiguration configuration = CONFIGURATION.toBuilder()
        .sourceDisk(newDisk)
        .sourceDiskId(newDiskId)
        .build();
    assertEquals(newDisk, configuration.sourceDisk());
    assertEquals(newDiskId, configuration.sourceDiskId());
    configuration = configuration.toBuilder()
        .sourceDiskId(SOURCE_DISK_ID)
        .sourceDisk(SOURCE_DISK)
        .build();
    compareDiskImageConfiguration(CONFIGURATION, configuration);
  }

  @Test
  public void testToBuilderIncomplete() {
    DiskImageConfiguration configuration = DiskImageConfiguration.of(SOURCE_DISK);
    compareDiskImageConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(SOURCE_TYPE, CONFIGURATION.sourceType());
    assertEquals(SOURCE_DISK, CONFIGURATION.sourceDisk());
    assertEquals(SOURCE_DISK_ID, CONFIGURATION.sourceDiskId());
    assertEquals(ARCHIVE_SIZE_BYTES, CONFIGURATION.archiveSizeBytes());
    Assert.assertEquals(ImageConfiguration.Type.DISK, CONFIGURATION.type());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(ImageConfiguration.fromPb(CONFIGURATION.toPb()) instanceof DiskImageConfiguration);
    compareDiskImageConfiguration(CONFIGURATION,
        ImageConfiguration.<DiskImageConfiguration>fromPb(CONFIGURATION.toPb()));
    DiskImageConfiguration configuration = DiskImageConfiguration.of(SOURCE_DISK);
    compareDiskImageConfiguration(configuration,
        DiskImageConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testOf() {
    DiskImageConfiguration configuration = DiskImageConfiguration.of(SOURCE_DISK);
    Assert.assertEquals(ImageConfiguration.Type.DISK, configuration.type());
    assertNull(configuration.sourceDiskId());
    assertNull(configuration.sourceType());
    assertNull(configuration.archiveSizeBytes());
    assertEquals(SOURCE_DISK, configuration.sourceDisk());
  }

  @Test
  public void testSetProjectId() {
    DiskImageConfiguration configuration = CONFIGURATION.toBuilder()
        .sourceDisk(DiskId.of("zone", "disk"))
        .build();
    compareDiskImageConfiguration(CONFIGURATION, configuration.setProjectId("project"));
  }

  private void compareDiskImageConfiguration(DiskImageConfiguration expected,
      DiskImageConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.archiveSizeBytes(), value.archiveSizeBytes());
    assertEquals(expected.sourceDisk(), value.sourceDisk());
    assertEquals(expected.sourceDiskId(), value.sourceDiskId());
    assertEquals(expected.sourceType(), value.sourceType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
