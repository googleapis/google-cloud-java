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

import com.google.gcloud.compute.DiskConfiguration.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ImageDiskConfigurationTest {

  private static final Long SIZE = 42L;
  private static final DiskTypeId DISK_TYPE = DiskTypeId.of("project", "zone", "type");
  private static final ImageId IMAGE = ImageId.of("project", "image");
  private static final String IMAGE_ID = "imageId";
  private static final ImageDiskConfiguration DISK_CONFIGURATION =
      ImageDiskConfiguration.builder(IMAGE)
          .sizeGb(SIZE)
          .diskType(DISK_TYPE)
          .sourceImageId(IMAGE_ID)
          .build();

  @Test
  public void testToBuilder() {
    compareImageDiskConfiguration(DISK_CONFIGURATION, DISK_CONFIGURATION.toBuilder().build());
    ImageId newImageId = ImageId.of("newProject", "newImage");
    ImageDiskConfiguration diskConfiguration = DISK_CONFIGURATION.toBuilder()
        .sizeGb(24L)
        .sourceImage(newImageId)
        .sourceImageId("newImageId")
        .build();
    assertEquals(24L, diskConfiguration.sizeGb().longValue());
    assertEquals(newImageId, diskConfiguration.sourceImage());
    assertEquals("newImageId", diskConfiguration.sourceImageId());
    diskConfiguration = diskConfiguration.toBuilder()
        .sizeGb(SIZE)
        .sourceImage(IMAGE)
        .sourceImageId(IMAGE_ID)
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
    assertEquals(DISK_TYPE, DISK_CONFIGURATION.diskType());
    assertEquals(SIZE, DISK_CONFIGURATION.sizeGb());
    assertEquals(IMAGE, DISK_CONFIGURATION.sourceImage());
    assertEquals(IMAGE_ID, DISK_CONFIGURATION.sourceImageId());
    assertEquals(Type.IMAGE, DISK_CONFIGURATION.type());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(DiskConfiguration.fromPb(DISK_CONFIGURATION.toPb())
        instanceof ImageDiskConfiguration);
    compareImageDiskConfiguration(DISK_CONFIGURATION,
        DiskConfiguration.<ImageDiskConfiguration>fromPb(DISK_CONFIGURATION.toPb()));
  }

  @Test
  public void testOf() {
    ImageDiskConfiguration configuration = ImageDiskConfiguration.of(IMAGE);
    assertNull(configuration.diskType());
    assertNull(configuration.sizeGb());
    assertNull(configuration.sourceImageId());
    assertEquals(IMAGE, configuration.sourceImage());
    assertEquals(Type.IMAGE, configuration.type());
  }

  @Test
  public void testSetProjectId() {
    ImageDiskConfiguration diskConfiguration = DISK_CONFIGURATION.toBuilder()
        .diskType(DiskTypeId.of(DISK_TYPE.zone(), DISK_TYPE.type()))
        .sourceImage(ImageId.of(IMAGE.image()))
        .build();
    compareImageDiskConfiguration(DISK_CONFIGURATION, diskConfiguration.setProjectId("project"));
  }

  private void compareImageDiskConfiguration(ImageDiskConfiguration expected,
      ImageDiskConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.diskType(), value.diskType());
    assertEquals(expected.sizeGb(), value.sizeGb());
    assertEquals(expected.sourceImage(), value.sourceImage());
    assertEquals(expected.sourceImageId(), value.sourceImageId());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
