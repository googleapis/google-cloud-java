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

import com.google.cloud.compute.deprecated.DiskConfiguration.Type;
import org.junit.Test;

public class StandardDiskConfigurationTest {

  private static final Long SIZE = 42L;
  private static final DiskTypeId DISK_TYPE = DiskTypeId.of("project", "zone", "type");
  private static final StandardDiskConfiguration DISK_CONFIGURATION =
      StandardDiskConfiguration.newBuilder().setSizeGb(SIZE).setDiskType(DISK_TYPE).build();

  @Test
  public void testToBuilder() {
    compareStandardDiskConfiguration(DISK_CONFIGURATION, DISK_CONFIGURATION.toBuilder().build());
    StandardDiskConfiguration diskConfiguration =
        DISK_CONFIGURATION.toBuilder().setSizeGb(24L).build();
    assertEquals(24L, diskConfiguration.getSizeGb().longValue());
    diskConfiguration = diskConfiguration.toBuilder().setSizeGb(SIZE).build();
    compareStandardDiskConfiguration(DISK_CONFIGURATION, diskConfiguration);
  }

  @Test
  public void testToBuilderIncomplete() {
    StandardDiskConfiguration diskConfiguration = StandardDiskConfiguration.of(DISK_TYPE);
    compareStandardDiskConfiguration(diskConfiguration, diskConfiguration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(DISK_TYPE, DISK_CONFIGURATION.getDiskType());
    assertEquals(SIZE, DISK_CONFIGURATION.getSizeGb());
    assertEquals(Type.STANDARD, DISK_CONFIGURATION.getType());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(
        DiskConfiguration.fromPb(DISK_CONFIGURATION.toPb()) instanceof StandardDiskConfiguration);
    compareStandardDiskConfiguration(
        DISK_CONFIGURATION,
        DiskConfiguration.<StandardDiskConfiguration>fromPb(DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testOf() {
    StandardDiskConfiguration configuration = StandardDiskConfiguration.of(DISK_TYPE);
    assertEquals(DISK_TYPE, configuration.getDiskType());
    assertNull(configuration.getSizeGb());
    assertEquals(Type.STANDARD, configuration.getType());
    configuration = StandardDiskConfiguration.of(DISK_TYPE, SIZE);
    assertEquals(DISK_TYPE, configuration.getDiskType());
    assertEquals(SIZE, configuration.getSizeGb());
    assertEquals(Type.STANDARD, configuration.getType());
    configuration = StandardDiskConfiguration.of(SIZE);
    assertNull(configuration.getDiskType());
    assertEquals(SIZE, configuration.getSizeGb());
    assertEquals(Type.STANDARD, configuration.getType());
  }

  @Test
  public void testSetProjectId() {
    StandardDiskConfiguration configuration =
        DISK_CONFIGURATION
            .toBuilder()
            .setDiskType(DiskTypeId.of(DISK_TYPE.getZone(), DISK_TYPE.getType()))
            .build();
    compareStandardDiskConfiguration(DISK_CONFIGURATION, configuration.setProjectId("project"));
  }

  private void compareStandardDiskConfiguration(
      StandardDiskConfiguration expected, StandardDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.getDiskType(), value.getDiskType());
    assertEquals(expected.getSizeGb(), value.getSizeGb());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
