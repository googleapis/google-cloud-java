/*
 * Copyright 2018 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.paging.Page;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.DiskTypeClient;
import com.google.cloud.compute.v1.DiskTypeClient.AggregatedListDiskTypesPagedResponse;
import com.google.cloud.compute.v1.DiskTypeSettings;
import com.google.cloud.compute.v1.DiskTypesScopedList;
import com.google.cloud.compute.v1.ListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneDiskTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITComputeTest {

  private static final String ZONE = "us-central1-a";
  private static final String DISK_TYPE = "local-ssd";
  private  static  final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();

  private static DiskTypeClient diskTypeClient;
  private static DiskTypeSettings diskTypeSettings;


  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws IOException{
    Credentials credentials = GoogleCredentials.getApplicationDefault();

    diskTypeSettings =
        DiskTypeSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
    diskTypeClient =
        DiskTypeClient.create(diskTypeSettings);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    diskTypeClient.close();
  }

  @Test
  public void testGetDiskType() {
    DiskType diskType = diskTypeClient.getDiskType(ProjectZoneDiskTypeName
        .of(DISK_TYPE, DEFAULT_PROJECT, ZONE));
    ProjectZoneDiskTypeName returnDiskName = ProjectZoneDiskTypeName.parse(trimUrl(diskType.getSelfLink()));
    assertEquals(ZONE, returnDiskName.getZone());
    assertEquals(DISK_TYPE, returnDiskName.getDiskType());
    assertNotNull(diskType.getCreationTimestamp());
    assertNotNull(diskType.getDescription());
    assertNotNull(diskType.getValidDiskSize());
    assertNotNull(diskType.getDefaultDiskSizeGb());
  }

  @Test
  public void testListDiskTypes() {
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(ProjectZoneName.of(DEFAULT_PROJECT, ZONE)).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertNotNull(diskType.getSelfLink());
      ProjectZoneDiskTypeName returnDiskName = ProjectZoneDiskTypeName.parse(trimUrl(diskType.getSelfLink()));
      assertEquals(ZONE, returnDiskName.getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotNull(diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testListDiskTypesWithFilter() {
    ListDiskTypesHttpRequest request = ListDiskTypesHttpRequest.newBuilder()
        .setZone(ProjectZoneName.of(DEFAULT_PROJECT, ZONE).toString())
        .setFilter("(defaultDiskSizeGb = 375)")
        .build();
    Page<DiskType> diskPage = diskTypeClient.listDiskTypes(request).getPage();
    Iterator<DiskType> diskTypeIterator = diskPage.iterateAll().iterator();
    assertTrue(diskTypeIterator.hasNext());
    while (diskTypeIterator.hasNext()) {
      DiskType diskType = diskTypeIterator.next();
      assertNotNull(diskType.getZone());
      ProjectZoneName zoneName = ProjectZoneName.parse(trimUrl(diskType.getZone()));
      assertEquals(ZONE, zoneName.getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotNull(diskType.getDefaultDiskSizeGb());
    }
  }

  @Test
  public void testAggregatedListDiskTypes() {
    AggregatedListDiskTypesPagedResponse pagedListResponse = diskTypeClient.aggregatedListDiskTypes(ProjectName.of(DEFAULT_PROJECT));
    List<DiskTypesScopedList> diskTypeScopedListIterator = Lists.newArrayList(pagedListResponse.iterateAll());
    List<DiskType> diskTypeIterator = new LinkedList<>();
    for (DiskTypesScopedList scopedList : diskTypeScopedListIterator) {
      diskTypeIterator.addAll(scopedList.getDiskTypesList());
    }
    assertTrue(diskTypeIterator.size() > 0);
    for (DiskType diskType : diskTypeIterator) {
      assertNotNull(diskType.getZone());
      ProjectZoneDiskTypeName zoneName = ProjectZoneDiskTypeName.parse(trimUrl(diskType.getSelfLink()));
      assertNotNull(zoneName.getDiskType());
      assertNotNull(zoneName.getZone());
      assertNotNull(diskType.getCreationTimestamp());
      assertNotNull(diskType.getDescription());
      assertNotNull(diskType.getValidDiskSize());
      assertNotNull(diskType.getDefaultDiskSizeGb());
    }
  }

  /** For a given resource's URI, trim the path until it contains only the PathTemplate string. */
  private String trimUrl(String url) {
    return url.replaceFirst("^https://www.googleapis.com/compute/v1/", "");
  }
}