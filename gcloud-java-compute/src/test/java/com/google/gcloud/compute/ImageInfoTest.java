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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.ImageConfiguration.SourceType;

import org.junit.Test;

import java.util.List;

public class ImageInfoTest {

  private static final ImageId IMAGE_ID = ImageId.of("project", "image");
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final ImageInfo.Status STATUS = ImageInfo.Status.READY;
  private static final List<LicenseId> LICENSES = ImmutableList.of(
      LicenseId.of("project", "license1"), LicenseId.of("project", "license2"));
  private static final Long DISK_SIZE_GB = 42L;
  private static final String STORAGE_SOURCE = "source";
  private static final Long ARCHIVE_SIZE_BYTES = 24L;
  private static final String SHA1_CHECKSUM = "checksum";
  private static final DiskId SOURCE_DISK =  DiskId.of("project", "zone", "disk");
  private static final String SOURCE_DISK_ID = "diskId";
  private static final SourceType SOURCE_TYPE = SourceType.RAW;
  private static final StorageImageConfiguration STORAGE_CONFIGURATION =
      StorageImageConfiguration.builder(STORAGE_SOURCE)
          .archiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .containerType(StorageImageConfiguration.ContainerType.TAR)
          .sha1(SHA1_CHECKSUM)
          .sourceType(SOURCE_TYPE)
          .build();
  private static final DiskImageConfiguration DISK_CONFIGURATION =
      DiskImageConfiguration.builder(SOURCE_DISK)
          .archiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .sourceDiskId(SOURCE_DISK_ID)
          .sourceType(SOURCE_TYPE)
          .build();
  private static final DeprecationStatus<ImageId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, IMAGE_ID);
  private static final ImageInfo STORAGE_IMAGE = ImageInfo.builder(IMAGE_ID, STORAGE_CONFIGURATION)
      .generatedId(GENERATED_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .diskSizeGb(DISK_SIZE_GB)
      .licenses(LICENSES)
      .deprecationStatus(DEPRECATION_STATUS)
      .build();
  private static final ImageInfo DISK_IMAGE = ImageInfo.builder(IMAGE_ID, DISK_CONFIGURATION)
      .generatedId(GENERATED_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .diskSizeGb(DISK_SIZE_GB)
      .licenses(LICENSES)
      .deprecationStatus(DEPRECATION_STATUS)
      .build();

  @Test
  public void testToBuilder() {
    compareImageInfo(STORAGE_IMAGE, STORAGE_IMAGE.toBuilder().build());
    compareImageInfo(DISK_IMAGE, DISK_IMAGE.toBuilder().build());
    ImageInfo imageInfo = STORAGE_IMAGE.toBuilder().description("newDescription").build();
    assertEquals("newDescription", imageInfo.description());
    imageInfo = imageInfo.toBuilder().description("description").build();
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
    assertEquals(GENERATED_ID, STORAGE_IMAGE.generatedId());
    assertEquals(IMAGE_ID, STORAGE_IMAGE.imageId());
    assertEquals(CREATION_TIMESTAMP, STORAGE_IMAGE.creationTimestamp());
    assertEquals(DESCRIPTION, STORAGE_IMAGE.description());
    assertEquals(STORAGE_CONFIGURATION, STORAGE_IMAGE.configuration());
    assertEquals(STATUS, STORAGE_IMAGE.status());
    assertEquals(DISK_SIZE_GB, STORAGE_IMAGE.diskSizeGb());
    assertEquals(LICENSES, STORAGE_IMAGE.licenses());
    assertEquals(DEPRECATION_STATUS, STORAGE_IMAGE.deprecationStatus());
    assertEquals(GENERATED_ID, DISK_IMAGE.generatedId());
    assertEquals(IMAGE_ID, DISK_IMAGE.imageId());
    assertEquals(CREATION_TIMESTAMP, DISK_IMAGE.creationTimestamp());
    assertEquals(DESCRIPTION, DISK_IMAGE.description());
    assertEquals(DISK_CONFIGURATION, DISK_IMAGE.configuration());
    assertEquals(STATUS, DISK_IMAGE.status());
    assertEquals(DISK_SIZE_GB, DISK_IMAGE.diskSizeGb());
    assertEquals(LICENSES, DISK_IMAGE.licenses());
    assertEquals(DEPRECATION_STATUS, DISK_IMAGE.deprecationStatus());
  }

  @Test
  public void testOf() {
    ImageInfo imageInfo = ImageInfo.of(IMAGE_ID, STORAGE_CONFIGURATION);
    assertEquals(IMAGE_ID, imageInfo.imageId());
    assertEquals(STORAGE_CONFIGURATION, imageInfo.configuration());
    assertNull(imageInfo.generatedId());
    assertNull(imageInfo.creationTimestamp());
    assertNull(imageInfo.description());
    assertNull(imageInfo.status());
    assertNull(imageInfo.diskSizeGb());
    assertNull(imageInfo.licenses());
    assertNull(imageInfo.deprecationStatus());
    imageInfo = ImageInfo.of(IMAGE_ID, DISK_CONFIGURATION);
    assertEquals(IMAGE_ID, imageInfo.imageId());
    assertEquals(DISK_CONFIGURATION, imageInfo.configuration());
    assertNull(imageInfo.generatedId());
    assertNull(imageInfo.creationTimestamp());
    assertNull(imageInfo.description());
    assertNull(imageInfo.status());
    assertNull(imageInfo.diskSizeGb());
    assertNull(imageInfo.licenses());
    assertNull(imageInfo.deprecationStatus());
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
    ImageInfo imageInfo = DISK_IMAGE.toBuilder()
        .imageId(ImageId.of("image"))
        .configuration(DISK_CONFIGURATION.toBuilder().sourceDisk(DiskId.of("zone", "disk")).build())
        .build();
    compareImageInfo(DISK_IMAGE, imageInfo.setProjectId("project"));
  }

  public void compareImageInfo(ImageInfo expected, ImageInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.imageId(), value.imageId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.configuration(), value.configuration());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.diskSizeGb(), value.diskSizeGb());
    assertEquals(expected.licenses(), value.licenses());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
