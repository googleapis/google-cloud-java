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

public class ITDiskTest extends BaseTest {

  private static final String DISK_NAME = TestHelper.getTestUniqueName("disk");
  private static final String DISK_SIZE = "1";
  private static final ProjectZoneDiskName PROJECT_ZONE_DISK_NAME =
      ProjectZoneDiskName.of(DISK_NAME, DEFAULT_PROJECT, ZONE);
  private static final String DISK_SELF_LINK =
      String.format("%s/disks/%s", ZONE_SELF_LINK, DISK_NAME);
  private static final ProjectZoneDiskResourceName PROJECT_ZONE_DISK_RESOURCE_NAME =
      ProjectZoneDiskResourceName.of(DEFAULT_PROJECT, DISK_NAME, ZONE);

  private static DiskClient diskClient;
  private static RegionDiskClient regionDiskClient;

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

    RegionDiskSettings regionDiskSettings =
        RegionDiskSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionDiskClient = RegionDiskClient.create(regionDiskSettings);
  }

  @AfterClass
  public static void tearDown() {
    for (String disk : resourcesToCleanUp.get("disk")) {
      waitForOperation(diskClient.deleteDisk(disk));
    }
    diskClient.close();
    regionDiskClient.close();
  }

  @Test
  public void addResourcePoliciesDiskTest() {
    DisksAddResourcePoliciesRequest resourcePoliciesRequest =
        DisksAddResourcePoliciesRequest.newBuilder().build();
    Operation resourcePoliciesDisk =
        diskClient.addResourcePoliciesDisk(PROJECT_ZONE_DISK_NAME, resourcePoliciesRequest);
    assertThat(resourcePoliciesDisk).isNotNull();
    assertThat(resourcePoliciesDisk.getStatus()).isEqualTo("RUNNING");
    assertThat(resourcePoliciesDisk.getOperationType()).isEqualTo("addResourcePolicies");
    assertThat(resourcePoliciesDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(resourcePoliciesDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void removeResourcePoliciesDiskTest() {
    DisksRemoveResourcePoliciesRequest resourcePoliciesRequest =
        DisksRemoveResourcePoliciesRequest.newBuilder().build();
    Operation resourcePoliciesDisk =
        diskClient.removeResourcePoliciesDisk(PROJECT_ZONE_DISK_NAME, resourcePoliciesRequest);
    assertThat(resourcePoliciesDisk).isNotNull();
    assertThat(resourcePoliciesDisk.getStatus()).isEqualTo("RUNNING");
    assertThat(resourcePoliciesDisk.getOperationType()).isEqualTo("removeResourcePolicies");
    assertThat(resourcePoliciesDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(resourcePoliciesDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void aggregatedListDisksTest() {
    List<DisksScopedList> disksScopedLists =
        Lists.newArrayList(diskClient.aggregatedListDisks(true, PROJECT_NAME).iterateAll());
    for (DisksScopedList disksScopedList : disksScopedLists) {
      List<Disk> disks = disksScopedList.getDisksList();
      if (null != disks && disks.size() > 0) {
        for (Disk disk : disks) {
          if (DISK_NAME.equals(disk.getName())) {
            assertThat(disk.getName()).isEqualTo(DISK_NAME);
            assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
            assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
            assertThat(disk.getStatus()).isEqualTo("READY");
          }
        }
      }
    }
  }

  @Test
  public void createSnapshotDiskTest() {
    String snapshotName = TestHelper.getTestUniqueName("snapshot");
    Snapshot snapshotResource =
        Snapshot.newBuilder().setName(snapshotName).setDiskSizeGb(DISK_SIZE).build();
    CreateSnapshotDiskHttpRequest diskHttpRequest =
        CreateSnapshotDiskHttpRequest.newBuilder()
            .setDisk(PROJECT_ZONE_DISK_NAME.toString())
            .setGuestFlush(Boolean.FALSE)
            .setSnapshotResource(snapshotResource)
            .build();
    Operation snapshotDisk = waitForOperation(diskClient.createSnapshotDisk(diskHttpRequest));
    assertThat(snapshotDisk).isNotNull();
    assertThat(snapshotDisk.getStatus()).isEqualTo("DONE");
    assertThat(snapshotDisk.getOperationType()).isEqualTo("createSnapshot");
    assertThat(snapshotDisk.getTargetLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(snapshotDisk.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void getDiskTest() {
    Disk disk = diskClient.getDisk(PROJECT_ZONE_DISK_NAME);
    assertThat(disk).isNotNull();
    assertThat(disk.getName()).isEqualTo(DISK_NAME);
    assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
    assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(disk.getStatus()).isEqualTo("READY");
  }

  @Test
  public void getIamPolicyDiskTest() {
    Policy policy =
        diskClient.getIamPolicyDisk(
            GetIamPolicyDiskHttpRequest.newBuilder()
                .setResource(PROJECT_ZONE_DISK_RESOURCE_NAME.toString())
                .build());
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }

  @Test
  public void resizeDiskTest() throws Exception {
    String diskSize = "2";
    DisksResizeRequest disksResizeRequestResource =
        DisksResizeRequest.newBuilder().setSizeGb(diskSize).build();
    Operation resizeDisk =
        waitForOperation(diskClient.resizeDisk(PROJECT_ZONE_DISK_NAME, disksResizeRequestResource));

    assertThat(resizeDisk).isNotNull();
    Disk disk = diskClient.getDisk(PROJECT_ZONE_DISK_NAME);
    assertThat(disk).isNotNull();
    assertThat(disk.getName()).isEqualTo(DISK_NAME);
    assertThat(disk.getSizeGb()).isEqualTo(diskSize);
    assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
    assertThat(disk.getStatus()).isEqualTo("READY");
  }

  @Test
  public void listDisksTest() {
    List<Disk> disks = Lists.newArrayList(diskClient.listDisks(PROJECT_ZONE_NAME).iterateAll());
    assertThat(disks).isNotNull();
    assertThat(disks.size()).isGreaterThan(0);
    for (Disk disk : disks) {
      if (DISK_NAME.equals(disk.getName())) {
        assertThat(disk.getName()).isEqualTo(DISK_NAME);
        assertThat(disk.getSizeGb()).isEqualTo(DISK_SIZE);
        assertThat(disk.getSelfLink()).isEqualTo(DISK_SELF_LINK);
        assertThat(disk.getStatus()).isEqualTo("READY");
      }
    }
  }
}
