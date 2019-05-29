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

public class ImageDiskConfigurationTest {

  private static final Long SIZE = 42L;
  private static final DiskTypeId DISK_TYPE = DiskTypeId.of("project", "zone", "type");
  private static final ImageId IMAGE = ImageId.of("project", "image");
  private static final String IMAGE_ID = "imageId";
  private static final ImageDiskConfiguration DISK_CONFIGURATION =
      ImageDiskConfiguration.newBuilder(IMAGE)
          .setSizeGb(SIZE)
          .setDiskType(DISK_TYPE)
          .setSourceImageId(IMAGE_ID)
          .build();

  @Test
  public void testToBuilder() {
    compareImageDiskConfiguration(DISK_CONFIGURATION, DISK_CONFIGURATION.toBuilder().build());
    ImageId newImageId = ImageId.of("newProject", "newImage");
    ImageDiskConfiguration diskConfiguration =
        DISK_CONFIGURATION
            .toBuilder()
            .setSizeGb(24L)
            .setSourceImage(newImageId)
            .setSourceImageId("newImageId")
            .build();
    assertEquals(24L, diskConfiguration.getSizeGb().longValue());
    assertEquals(newImageId, diskConfiguration.getSourceImage());
    assertEquals("newImageId", diskConfiguration.getSourceImageId());
    diskConfiguration =
        diskConfiguration
            .toBuilder()
            .setSizeGb(SIZE)
            .setSourceImage(IMAGE)
            .setSourceImageId(IMAGE_ID)
            .build();
    compareImageDiskConfiguration(DISK_CONFIGURATION, diskConfiguration);
  }

  @Test
  public void testToBuilderIncomplete() {
    ImageDiskConfiguration diskConfiguration = ImageDiskConfiguration.of(IMAGE);
    compareImageDiskConfiguration(diskConfiguration, diskConfiguration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(DISK_TYPE, DISK_CONFIGURATION.getDiskType());
    assertEquals(SIZE, DISK_CONFIGURATION.getSizeGb());
    assertEquals(IMAGE, DISK_CONFIGURATION.getSourceImage());
    assertEquals(IMAGE_ID, DISK_CONFIGURATION.getSourceImageId());
    assertEquals(Type.IMAGE, DISK_CONFIGURATION.getType());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(
        DiskConfiguration.fromPb(DISK_CONFIGURATION.toPb()) instanceof ImageDiskConfiguration);
    compareImageDiskConfiguration(
        DISK_CONFIGURATION,
        DiskConfiguration.<ImageDiskConfiguration>fromPb(DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testOf() {
    ImageDiskConfiguration configuration = ImageDiskConfiguration.of(IMAGE);
    assertNull(configuration.getDiskType());
    assertNull(configuration.getSizeGb());
    assertNull(configuration.getSourceImageId());
    assertEquals(IMAGE, configuration.getSourceImage());
    assertEquals(Type.IMAGE, configuration.getType());
  }

  @Test
  public void testSetProjectId() {
    ImageDiskConfiguration diskConfiguration =
        DISK_CONFIGURATION
            .toBuilder()
            .setDiskType(DiskTypeId.of(DISK_TYPE.getZone(), DISK_TYPE.getType()))
            .setSourceImage(ImageId.of(IMAGE.getImage()))
            .build();
    compareImageDiskConfiguration(DISK_CONFIGURATION, diskConfiguration.setProjectId("project"));
  }

  private void compareImageDiskConfiguration(
      ImageDiskConfiguration expected, ImageDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.getDiskType(), value.getDiskType());
    assertEquals(expected.getSizeGb(), value.getSizeGb());
    assertEquals(expected.getSourceImage(), value.getSourceImage());
    assertEquals(expected.getSourceImageId(), value.getSourceImageId());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
