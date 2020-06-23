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

import com.google.api.gax.paging.Page;
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.DiskTypeClient;
import com.google.cloud.compute.v1.DiskTypeSettings;
import com.google.cloud.compute.v1.DiskTypesScopedList;
import com.google.cloud.compute.v1.ListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionDiskTypeName;
import com.google.cloud.compute.v1.ProjectZoneDiskTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITDiskTypeTest extends BaseTest {

  private static DiskTypeClient diskTypeClient;

  private static final String DISK_TYPE = "local-ssd";

  @BeforeClass
  public static void setUp() throws IOException {
    DiskTypeSettings diskTypeSettings =
        DiskTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    diskTypeClient = DiskTypeClient.create(diskTypeSettings);
  }

  @AfterClass
  public static void tearDown() {
    diskTypeClient.close();
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType =
        diskTypeClient.getDiskType(ProjectZoneDiskTypeName.of(DISK_TYPE, DEFAULT_PROJECT, ZONE));
    ProjectZoneDiskTypeName returnDiskName = ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
    assertThat(returnDiskName.getZone()).isEqualTo(ZONE);
    assertThat(returnDiskName.getDiskType()).isEqualTo(DISK_TYPE);
    assertThat(diskType.getCreationTimestamp()).isNotNull();
    assertThat(diskType.getDescription()).isNotNull();
    assertThat(diskType.getValidDiskSize()).isNotNull();
    assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
  }

  @Test
  public void testListDiskTypes() {
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(PROJECT_ZONE_NAME).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertThat(diskTypeIterator.hasNext()).isTrue();
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertThat(diskType.getSelfLink()).isNotNull();
      ProjectZoneDiskTypeName returnDiskName =
          ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
      assertThat(returnDiskName.getZone()).isEqualTo(ZONE);
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }

  @Test
  public void testListDiskTypesWithFilter() {
    ListDiskTypesHttpRequest request =
        ListDiskTypesHttpRequest.newBuilder()
            .setZone(PROJECT_ZONE_NAME.toString())
            .setFilter("(defaultDiskSizeGb = 375)")
            .build();
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(request).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertThat(diskTypeIterator.hasNext()).isTrue();
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertThat(diskType.getZone()).isNotNull();
      ProjectZoneName zoneName = ProjectZoneName.parse(diskType.getZone());
      assertThat(zoneName.getZone()).isEqualTo(ZONE);
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }

  @Test
  public void testAggregatedListDiskTypes() {
    DiskTypeClient.AggregatedListDiskTypesPagedResponse pagedListResponse =
        diskTypeClient.aggregatedListDiskTypes(false, PROJECT_NAME);
    List<DiskTypesScopedList> diskTypeScopedListIterator =
        Lists.newArrayList(pagedListResponse.iterateAll());
    List<DiskType> diskTypeIterator = new LinkedList<>();
    for (DiskTypesScopedList scopedList : diskTypeScopedListIterator) {
      assertThat(scopedList.getDiskTypesList()).isNotNull();
      diskTypeIterator.addAll(scopedList.getDiskTypesList());
    }
    assertThat(diskTypeIterator.size()).isGreaterThan(0);
    for (DiskType diskType : diskTypeIterator) {
      assertThat(diskType.getRegion() != null || diskType.getZone() != null).isTrue();
      if (diskType.getRegion() != null) {
        ProjectRegionDiskTypeName zoneName =
            ProjectRegionDiskTypeName.parse(diskType.getSelfLink());
        assertThat(zoneName.getDiskType()).isNotNull();
        assertThat(zoneName.getRegion()).isNotNull();
      } else {
        ProjectZoneDiskTypeName zoneName = ProjectZoneDiskTypeName.parse(diskType.getSelfLink());
        assertThat(zoneName.getDiskType()).isNotNull();
        assertThat(zoneName.getZone()).isNotNull();
      }
      assertThat(diskType.getCreationTimestamp()).isNotNull();
      assertThat(diskType.getDescription()).isNotNull();
      assertThat(diskType.getValidDiskSize()).isNotNull();
      assertThat(diskType.getDefaultDiskSizeGb()).isNotNull();
    }
  }
}
