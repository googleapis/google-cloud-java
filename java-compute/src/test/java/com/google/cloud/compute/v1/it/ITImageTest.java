/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITImageTest extends BaseTest {
  private static final String DISK_NAME = TestHelper.getTestUniqueName("image-disk");
  private static final String DISK_SIZE = "1";
  private static final String DISK_SELF_LINK =
      String.format("%s/disks/%s", ZONE_SELF_LINK, DISK_NAME);

  private static final String IMAGE_NAME = TestHelper.getTestUniqueName("image");
  private static final String IMAGE_LINK =
      String.format("%s/global/images/%s", PROJECT_LINK, IMAGE_NAME);
  private static final ProjectGlobalImageName PROJECT_GLOBAL_IMAGE_NAME =
      ProjectGlobalImageName.of(IMAGE_NAME, DEFAULT_PROJECT);
  private static final ProjectGlobalImageResourceName IMAGE_RESOURCE_NAME =
      ProjectGlobalImageResourceName.of(DEFAULT_PROJECT, IMAGE_NAME);

  private static DiskClient diskClient;
  private static ImageClient imageClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    DiskSettings diskSettings =
        DiskSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    diskClient = DiskClient.create(diskSettings);
    Disk diskResource =
        Disk.newBuilder().setName(DISK_NAME).setRegion(REGION_LINK).setSizeGb(DISK_SIZE).build();
    Operation completedOperation =
        waitForOperation(diskClient.insertDisk(PROJECT_ZONE_NAME, diskResource));
    resourcesToCleanUp.put("disk", completedOperation.getTargetLink());

    ImageSettings imageSettings =
        ImageSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    imageClient = ImageClient.create(imageSettings);

    InsertImageHttpRequest insertImageHttpRequest =
        InsertImageHttpRequest.newBuilder()
            .setImageResource(
                Image.newBuilder().setName(IMAGE_NAME).setSourceDisk(DISK_SELF_LINK).build())
            .setForceCreate(Boolean.TRUE)
            .setProject(PROJECT_NAME.toString())
            .build();
    completedOperation = waitForOperation(imageClient.insertImage(insertImageHttpRequest));
    resourcesToCleanUp.put("image", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String disk : resourcesToCleanUp.get("disk")) {
      waitForOperation(diskClient.deleteDisk(disk));
    }
    for (String image : resourcesToCleanUp.get("image")) {
      waitForOperation(imageClient.deleteImage(image));
    }
    imageClient.close();
  }

  @Test
  public void getImageTest() {
    Image image = imageClient.getImage(PROJECT_GLOBAL_IMAGE_NAME);
    assertThat(image).isNotNull();
    assertThat(image.getName()).isEqualTo(IMAGE_NAME);
    assertThat(image.getSelfLink()).isEqualTo(IMAGE_LINK);
    assertThat(image.getDiskSizeGb()).isEqualTo(DISK_SIZE);
  }

  @Test
  public void listImagesTest() {
    List<Image> images = Lists.newArrayList(imageClient.listImages(PROJECT_NAME).iterateAll());
    for (Image image : images) {
      if (IMAGE_NAME.equals(image.getName())) {
        assertThat(image.getName()).isEqualTo(IMAGE_NAME);
        assertThat(image.getSelfLink()).isEqualTo(IMAGE_LINK);
        assertThat(image.getDiskSizeGb()).isEqualTo(DISK_SIZE);
      }
    }
  }

  @Test
  public void getIamPolicyImageTest() {
    Policy policy =
        imageClient.getIamPolicyImage(
            GetIamPolicyImageHttpRequest.newBuilder()
                .setResource(IMAGE_RESOURCE_NAME.toString())
                .build());
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }

  @Test
  public void deprecateImageTest() {
    DeprecationStatus deprecationStatusResource = DeprecationStatus.newBuilder().build();
    Operation deprecateImage =
        imageClient.deprecateImage(PROJECT_GLOBAL_IMAGE_NAME, deprecationStatusResource);
    assertThat(deprecateImage).isNotNull();
    assertThat(deprecateImage.getOperationType()).isEqualTo("deprecateImage");
    assertThat(deprecateImage.getStatus()).isEqualTo("DONE");
    assertThat(deprecateImage.getTargetLink()).isEqualTo(IMAGE_LINK);
  }
}
