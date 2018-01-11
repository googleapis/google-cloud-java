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

public class ImageTest {

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
  private static final ImageConfiguration.SourceType SOURCE_TYPE =
      ImageConfiguration.SourceType.RAW;
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

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Image image;
  private Image diskImage;
  private Image storageImage;

  private void initializeExpectedImage(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    diskImage = new Image.Builder(serviceMockReturnsOptions, IMAGE_ID, DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .getCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setStatus(STATUS)
        .setDiskSizeGb(DISK_SIZE_GB)
        .setLicenses(LICENSES)
        .setDeprecationStatus(DEPRECATION_STATUS)
        .build();
    storageImage = new Image.Builder(serviceMockReturnsOptions, IMAGE_ID, STORAGE_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .getCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setStatus(STATUS)
        .setDiskSizeGb(DISK_SIZE_GB)
        .setLicenses(LICENSES)
        .setDeprecationStatus(DEPRECATION_STATUS)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeImage() {
    image = new Image.Builder(compute, IMAGE_ID, DISK_CONFIGURATION)
        .setGeneratedId(GENERATED_ID)
        .getCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setStatus(STATUS)
        .setDiskSizeGb(DISK_SIZE_GB)
        .setLicenses(LICENSES)
        .setDeprecationStatus(DEPRECATION_STATUS)
        .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedImage(12);
    compareImage(diskImage, diskImage.toBuilder().build());
    compareImage(storageImage, storageImage.toBuilder().build());
    Image newImage = diskImage.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", newImage.getDescription());
    newImage = newImage.toBuilder().setDescription("description").build();
    compareImage(diskImage, newImage);
  }

  @Test
  public void testToBuilderIncomplete() {
    initializeExpectedImage(6);
    ImageInfo imageInfo = ImageInfo.of(IMAGE_ID, DISK_CONFIGURATION);
    Image image =
        new Image(serviceMockReturnsOptions, new ImageInfo.BuilderImpl(imageInfo));
    compareImage(image, image.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedImage(3);
    assertEquals(GENERATED_ID, diskImage.getGeneratedId());
    assertEquals(IMAGE_ID, diskImage.getImageId());
    assertEquals(CREATION_TIMESTAMP, diskImage.getCreationTimestamp());
    assertEquals(DESCRIPTION, diskImage.getDescription());
    assertEquals(DISK_CONFIGURATION, diskImage.getConfiguration());
    assertEquals(STATUS, diskImage.getStatus());
    assertEquals(DISK_SIZE_GB, diskImage.getDiskSizeGb());
    assertEquals(LICENSES, diskImage.getLicenses());
    assertEquals(DEPRECATION_STATUS, diskImage.getDeprecationStatus());
    assertSame(serviceMockReturnsOptions, diskImage.getCompute());
    assertEquals(GENERATED_ID, storageImage.getGeneratedId());
    assertEquals(IMAGE_ID, storageImage.getImageId());
    assertEquals(CREATION_TIMESTAMP, storageImage.getCreationTimestamp());
    assertEquals(DESCRIPTION, storageImage.getDescription());
    assertEquals(STORAGE_CONFIGURATION, storageImage.getConfiguration());
    assertEquals(STATUS, storageImage.getStatus());
    assertEquals(DISK_SIZE_GB, storageImage.getDiskSizeGb());
    assertEquals(LICENSES, storageImage.getLicenses());
    assertEquals(DEPRECATION_STATUS, storageImage.getDeprecationStatus());
    assertSame(serviceMockReturnsOptions, storageImage.getCompute());
    ImageId imageId = ImageId.of("otherImage");
    Image image = new Image.Builder(serviceMockReturnsOptions, IMAGE_ID, STORAGE_CONFIGURATION)
        .setImageId(imageId)
        .setConfiguration(DISK_CONFIGURATION)
        .build();
    assertNull(image.getGeneratedId());
    assertEquals(imageId, image.getImageId());
    assertNull(image.getCreationTimestamp());
    assertNull(image.getDescription());
    assertEquals(DISK_CONFIGURATION, image.getConfiguration());
    assertNull(image.getStatus());
    assertNull(image.getDiskSizeGb());
    assertNull(image.getLicenses());
    assertNull(image.getDeprecationStatus());
    assertSame(serviceMockReturnsOptions, image.getCompute());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedImage(12);
    compareImage(diskImage,
        Image.fromPb(serviceMockReturnsOptions, diskImage.toPb()));
    compareImage(storageImage,
        Image.fromPb(serviceMockReturnsOptions, storageImage.toPb()));
    Image image =
        new Image.Builder(serviceMockReturnsOptions, IMAGE_ID, DISK_CONFIGURATION).build();
    compareImage(image, Image.fromPb(serviceMockReturnsOptions, image.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedImage(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    expect(compute.deleteImage(IMAGE_ID)).andReturn(operation);
    replay(compute);
    initializeImage();
    assertSame(operation, image.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedImage(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteImage(IMAGE_ID)).andReturn(null);
    replay(compute);
    initializeImage();
    assertNull(image.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedImage(2);
    Compute.ImageOption[] expectedOptions = {Compute.ImageOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getImage(IMAGE_ID, expectedOptions)).andReturn(diskImage);
    replay(compute);
    initializeImage();
    assertTrue(image.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedImage(2);
    Compute.ImageOption[] expectedOptions = {Compute.ImageOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getImage(IMAGE_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeImage();
    assertFalse(image.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedImage(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getImage(IMAGE_ID)).andReturn(storageImage);
    replay(compute);
    initializeImage();
    Image updateImage = image.reload();
    compareImage(storageImage, updateImage);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedImage(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getImage(IMAGE_ID)).andReturn(null);
    replay(compute);
    initializeImage();
    assertNull(image.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedImage(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getImage(IMAGE_ID, Compute.ImageOption.fields())).andReturn(storageImage);
    replay(compute);
    initializeImage();
    Image updateImage = image.reload(Compute.ImageOption.fields());
    compareImage(storageImage, updateImage);
    verify(compute);
  }

  @Test
  public void testDeprecateImage() {
    initializeExpectedImage(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    DeprecationStatus<ImageId> status =
        DeprecationStatus.of(DeprecationStatus.Status.DEPRECATED, IMAGE_ID);
    expect(compute.deprecate(IMAGE_ID, status)).andReturn(operation);
    replay(compute);
    initializeImage();
    assertSame(operation, image.deprecate(status));
  }

  @Test
  public void testDeprecateNull() {
    initializeExpectedImage(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    DeprecationStatus<ImageId> status =
        DeprecationStatus.of(DeprecationStatus.Status.DEPRECATED, IMAGE_ID);
    expect(compute.deprecate(IMAGE_ID, status)).andReturn(null);
    replay(compute);
    initializeImage();
    assertNull(image.deprecate(status));
  }

  public void compareImage(Image expected, Image value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().getOptions(), value.getCompute().getOptions());
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
