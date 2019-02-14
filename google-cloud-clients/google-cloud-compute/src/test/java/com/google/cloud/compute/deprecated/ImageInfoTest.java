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

import com.google.cloud.compute.deprecated.ImageConfiguration.SourceType;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class ImageInfoTest {

  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final ImageInfo.Status STATUS = ImageInfo.Status.READY;
  private static final List<LicenseId> LICENSES =
      ImmutableList.of(LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final Long DISK_SIZE_GB = 42L;
  private static final String STORAGE_SOURCE = "source";
  private static final Long ARCHIVE_SIZE_BYTES = 24L;
  private static final String SHA1_CHECKSUM = "checksum";
  private static final DiskId SOURCE_DISK = DiskId.of("project", "zone", "disk");
  private static final String SOURCE_DISK_ID = "diskId";
  private static final SourceType SOURCE_TYPE = SourceType.RAW;
  private static final StorageImageConfiguration STORAGE_CONFIGURATION =
      StorageImageConfiguration.newBuilder(STORAGE_SOURCE)
          .setArchiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .setContainerType(StorageImageConfiguration.ContainerType.TAR)
          .setSha1(SHA1_CHECKSUM)
          .setSourceType(SOURCE_TYPE)
          .build();
  private static final DiskImageConfiguration DISK_CONFIGURATION =
      DiskImageConfiguration.newBuilder(SOURCE_DISK)
          .setArchiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .setSourceDiskId(SOURCE_DISK_ID)
          .setSourceType(SOURCE_TYPE)
          .build();
  private static final DeprecationStatus<ImageId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, IMAGE_ID);
  private static final ImageInfo STORAGE_IMAGE =
      ImageInfo.newBuilder(IMAGE_ID, STORAGE_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .getCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setDiskSizeGb(DISK_SIZE_GB)
          .setLicenses(LICENSES)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .build();
  private static final ImageInfo DISK_IMAGE =
      ImageInfo.newBuilder(IMAGE_ID, DISK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .getCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setDiskSizeGb(DISK_SIZE_GB)
          .setLicenses(LICENSES)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .build();

  @Test
  public void testToBuilder() {
    compareImageInfo(STORAGE_IMAGE, STORAGE_IMAGE.toBuilder().build());
    compareImageInfo(DISK_IMAGE, DISK_IMAGE.toBuilder().build());
    ImageInfo imageInfo = STORAGE_IMAGE.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", imageInfo.getDescription());
    imageInfo = imageInfo.toBuilder().setDescription("description").build();
    compareImageInfo(STORAGE_IMAGE, imageInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    ImageInfo imageInfo = ImageInfo.of(IMAGE_ID, STORAGE_CONFIGURATION);
    assertEquals(imageInfo, imageInfo.toBuilder().build());
    imageInfo = ImageInfo.of(IMAGE_ID, DISK_CONFIGURATION);
    assertEquals(imageInfo, imageInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, STORAGE_IMAGE.getGeneratedId());
    assertEquals(IMAGE_ID, STORAGE_IMAGE.getImageId());
    assertEquals(CREATION_TIMESTAMP, STORAGE_IMAGE.getCreationTimestamp());
    assertEquals(DESCRIPTION, STORAGE_IMAGE.getDescription());
    assertEquals(STORAGE_CONFIGURATION, STORAGE_IMAGE.getConfiguration());
    assertEquals(STATUS, STORAGE_IMAGE.getStatus());
    assertEquals(DISK_SIZE_GB, STORAGE_IMAGE.getDiskSizeGb());
    assertEquals(LICENSES, STORAGE_IMAGE.getLicenses());
    assertEquals(DEPRECATION_STATUS, STORAGE_IMAGE.getDeprecationStatus());
    assertEquals(GENERATED_ID, DISK_IMAGE.getGeneratedId());
    assertEquals(IMAGE_ID, DISK_IMAGE.getImageId());
    assertEquals(CREATION_TIMESTAMP, DISK_IMAGE.getCreationTimestamp());
    assertEquals(DESCRIPTION, DISK_IMAGE.getDescription());
    assertEquals(DISK_CONFIGURATION, DISK_IMAGE.getConfiguration());
    assertEquals(STATUS, DISK_IMAGE.getStatus());
    assertEquals(DISK_SIZE_GB, DISK_IMAGE.getDiskSizeGb());
    assertEquals(LICENSES, DISK_IMAGE.getLicenses());
    assertEquals(DEPRECATION_STATUS, DISK_IMAGE.getDeprecationStatus());
  }

  @Test
  public void testOf() {
    ImageInfo imageInfo = ImageInfo.of(IMAGE_ID, STORAGE_CONFIGURATION);
    assertEquals(IMAGE_ID, imageInfo.getImageId());
    assertEquals(STORAGE_CONFIGURATION, imageInfo.getConfiguration());
    assertNull(imageInfo.getGeneratedId());
    assertNull(imageInfo.getCreationTimestamp());
    assertNull(imageInfo.getDescription());
    assertNull(imageInfo.getStatus());
    assertNull(imageInfo.getDiskSizeGb());
    assertNull(imageInfo.getLicenses());
    assertNull(imageInfo.getDeprecationStatus());
    imageInfo = ImageInfo.of(IMAGE_ID, DISK_CONFIGURATION);
    assertEquals(IMAGE_ID, imageInfo.getImageId());
    assertEquals(DISK_CONFIGURATION, imageInfo.getConfiguration());
    assertNull(imageInfo.getGeneratedId());
    assertNull(imageInfo.getCreationTimestamp());
    assertNull(imageInfo.getDescription());
    assertNull(imageInfo.getStatus());
    assertNull(imageInfo.getDiskSizeGb());
    assertNull(imageInfo.getLicenses());
    assertNull(imageInfo.getDeprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    compareImageInfo(STORAGE_IMAGE, ImageInfo.fromPb(STORAGE_IMAGE.toPb()));
    compareImageInfo(DISK_IMAGE, ImageInfo.fromPb(DISK_IMAGE.toPb()));
    ImageInfo imageInfo = ImageInfo.of(IMAGE_ID, StorageImageConfiguration.of(STORAGE_SOURCE));
    compareImageInfo(imageInfo, ImageInfo.fromPb(imageInfo.toPb()));
    imageInfo = ImageInfo.of(IMAGE_ID, DiskImageConfiguration.of(SOURCE_DISK));
    compareImageInfo(imageInfo, ImageInfo.fromPb(imageInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    ImageInfo imageInfo =
        DISK_IMAGE
            .toBuilder()
            .setImageId(ImageId.of("image"))
            .setConfiguration(
                DISK_CONFIGURATION.toBuilder().setSourceDisk(DiskId.of("zone", "disk")).build())
            .build();
    compareImageInfo(DISK_IMAGE, imageInfo.setProjectId("project"));
  }

  public void compareImageInfo(ImageInfo expected, ImageInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getImageId(), value.getImageId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getConfiguration(), value.getConfiguration());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getDiskSizeGb(), value.getDiskSizeGb());
    assertEquals(expected.getLicenses(), value.getLicenses());
    assertEquals(expected.getDeprecationStatus(), value.getDeprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
