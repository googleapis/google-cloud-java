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

import org.junit.Test;

public class DiskTypeTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final String VALID_DISK_SIZE = "10GB-10TB";
  private static final Long DEFAULT_DISK_SIZE_GB = 10L;
  private static final DiskTypeId DISK_TYPE_ID = DiskTypeId.of("project", "zone", "diskType");
  private static final DeprecationStatus<DiskTypeId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, DISK_TYPE_ID);
  private static final DiskType DISK_TYPE =
      DiskType.newBuilder()
          .setGeneratedId(GENERATED_ID)
          .setDiskTypeId(DISK_TYPE_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setValidDiskSize(VALID_DISK_SIZE)
          .setDefaultDiskSizeGb(DEFAULT_DISK_SIZE_GB)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, DISK_TYPE.getGeneratedId());
    assertEquals(DISK_TYPE_ID, DISK_TYPE.getDiskTypeId());
    assertEquals(CREATION_TIMESTAMP, DISK_TYPE.getCreationTimestamp());
    assertEquals(DESCRIPTION, DISK_TYPE.getDescription());
    assertEquals(VALID_DISK_SIZE, DISK_TYPE.getValidDiskSize());
    assertEquals(DEFAULT_DISK_SIZE_GB, DISK_TYPE.getDefaultDiskSizeGb());
    assertEquals(DEPRECATION_STATUS, DISK_TYPE.getDeprecationStatus());
  }

  @Test
  public void testToPbAndFromPb() {
    compareDiskTypes(DISK_TYPE, DiskType.fromPb(DISK_TYPE.toPb()));
    DiskType diskType = DiskType.newBuilder().setDiskTypeId(DISK_TYPE_ID).build();
    compareDiskTypes(diskType, DiskType.fromPb(diskType.toPb()));
  }

  private void compareDiskTypes(DiskType expected, DiskType value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getDiskTypeId(), value.getDiskTypeId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getValidDiskSize(), value.getValidDiskSize());
    assertEquals(expected.getDefaultDiskSizeGb(), value.getDefaultDiskSizeGb());
    assertEquals(expected.getDeprecationStatus(), value.getDeprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
