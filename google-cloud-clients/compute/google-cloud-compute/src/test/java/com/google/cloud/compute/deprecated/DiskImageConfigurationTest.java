/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiskImageConfigurationTest {

  private static final DiskId SOURCE_DISK = DiskId.of("project", "zone", "disk");
  private static final String SOURCE_DISK_ID = "diskId";
  private static final Long ARCHIVE_SIZE_BYTES = 42L;
  private static final ImageConfiguration.SourceType SOURCE_TYPE =
      ImageConfiguration.SourceType.RAW;
  private static final DiskImageConfiguration CONFIGURATION =
      DiskImageConfiguration.newBuilder(SOURCE_DISK)
          .setSourceDiskId(SOURCE_DISK_ID)
          .setSourceType(SOURCE_TYPE)
          .setArchiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .build();

  @Test
  public void testToBuilder() {
    compareDiskImageConfiguration(CONFIGURATION, CONFIGURATION.toBuilder().build());
    DiskId newDisk = DiskId.of("newProject", "newZone", "newDisk");
    String newDiskId = "newDiskId";
    DiskImageConfiguration configuration =
        CONFIGURATION.toBuilder().setSourceDisk(newDisk).setSourceDiskId(newDiskId).build();
    assertEquals(newDisk, configuration.getSourceDisk());
    assertEquals(newDiskId, configuration.getSourceDiskId());
    configuration =
        configuration
            .toBuilder()
            .setSourceDiskId(SOURCE_DISK_ID)
            .setSourceDisk(SOURCE_DISK)
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
    assertEquals(SOURCE_TYPE, CONFIGURATION.getSourceType());
    assertEquals(SOURCE_DISK, CONFIGURATION.getSourceDisk());
    assertEquals(SOURCE_DISK_ID, CONFIGURATION.getSourceDiskId());
    assertEquals(ARCHIVE_SIZE_BYTES, CONFIGURATION.getArchiveSizeBytes());
    assertEquals(ImageConfiguration.Type.DISK, CONFIGURATION.getType());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(ImageConfiguration.fromPb(CONFIGURATION.toPb()) instanceof DiskImageConfiguration);
    compareDiskImageConfiguration(
        CONFIGURATION, ImageConfiguration.<DiskImageConfiguration>fromPb(CONFIGURATION.toPb()));
    DiskImageConfiguration configuration = DiskImageConfiguration.of(SOURCE_DISK);
    compareDiskImageConfiguration(
        configuration, DiskImageConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testOf() {
    DiskImageConfiguration configuration = DiskImageConfiguration.of(SOURCE_DISK);
    assertEquals(ImageConfiguration.Type.DISK, configuration.getType());
    assertNull(configuration.getSourceDiskId());
    assertNull(configuration.getSourceType());
    assertNull(configuration.getArchiveSizeBytes());
    assertEquals(SOURCE_DISK, configuration.getSourceDisk());
  }

  @Test
  public void testSetProjectId() {
    DiskImageConfiguration configuration =
        CONFIGURATION.toBuilder().setSourceDisk(DiskId.of("zone", "disk")).build();
    compareDiskImageConfiguration(CONFIGURATION, configuration.setProjectId("project"));
  }

  private void compareDiskImageConfiguration(
      DiskImageConfiguration expected, DiskImageConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getArchiveSizeBytes(), value.getArchiveSizeBytes());
    assertEquals(expected.getSourceDisk(), value.getSourceDisk());
    assertEquals(expected.getSourceDiskId(), value.getSourceDiskId());
    assertEquals(expected.getSourceType(), value.getSourceType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
