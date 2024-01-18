/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.compute.v1.integration;

import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypesClient;
import com.google.cloud.compute.v1.AcceleratorTypesScopedList;
import com.google.cloud.compute.v1.AggregatedListAcceleratorTypesRequest;
import com.google.cloud.compute.v1.ListZonesRequest;
import com.google.cloud.compute.v1.Zone;
import com.google.cloud.compute.v1.ZonesClient;
import com.google.cloud.compute.v1.ZonesSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITPaginationTest extends BaseTest {
  private static ZonesClient zonesClient;

  @BeforeClass
  public static void setUp() throws IOException {
    ZonesSettings zoneSettings = ZonesSettings.newBuilder().build();
    zonesClient = ZonesClient.create(zoneSettings);
  }

  @AfterClass
  public static void tearDown() {
    zonesClient.close();
  }

  @Test
  public void testList() {
    ZonesClient.ListPagedResponse response = zonesClient.list(DEFAULT_PROJECT);
    boolean presented = false;
    for (Zone element : response.iterateAll()) {
      if (element.getName().equals(DEFAULT_ZONE)) {
        presented = true;
      }
    }
    Assert.assertTrue(presented);
  }

  @Test
  public void testPaginationMaxResults() {
    ListZonesRequest listZonesRequest =
        ListZonesRequest.newBuilder().setProject(DEFAULT_PROJECT).setMaxResults(15).build();
    ZonesClient.ListPagedResponse response = zonesClient.list(listZonesRequest);
    ZonesClient.ListPage listPage = response.getPage();
    Assert.assertEquals(15, Lists.newArrayList(listPage.getValues()).size());
  }

  @Test
  public void testPaginationNextPage() {
    ListZonesRequest listZonesRequest =
        ListZonesRequest.newBuilder().setProject(DEFAULT_PROJECT).setMaxResults(15).build();
    ZonesClient.ListPagedResponse response = zonesClient.list(listZonesRequest);
    ZonesClient.ListPage listPage = response.getPage();
    ZonesClient.ListPage nextPage = listPage.getNextPage();
    Assert.assertNotEquals(listPage, nextPage);
  }

  @Test
  public void testPaginationNextPageSize() {
    ListZonesRequest listZonesRequest =
        ListZonesRequest.newBuilder().setProject(DEFAULT_PROJECT).setMaxResults(15).build();
    ZonesClient.ListPagedResponse response = zonesClient.list(listZonesRequest);
    ZonesClient.ListPage listPage = response.getPage();
    ZonesClient.ListPage nextPage = listPage.getNextPage(20);
    Assert.assertEquals(20, Lists.newArrayList(nextPage.getValues()).size());
  }

  @Test
  public void testPaginationNextToken() {
    ListZonesRequest listZonesRequest =
        ListZonesRequest.newBuilder().setProject(DEFAULT_PROJECT).setMaxResults(15).build();
    ZonesClient.ListPagedResponse response = zonesClient.list(listZonesRequest);
    ZonesClient.ListPage listPage = response.getPage();
    String nextPageToken = listPage.getNextPageToken();
    ZonesClient.ListPage nextPage = listPage.getNextPage();

    ListZonesRequest listZonesRequestToken =
        ListZonesRequest.newBuilder()
            .setProject(DEFAULT_PROJECT)
            .setMaxResults(15)
            .setPageToken(nextPageToken)
            .build();
    ZonesClient.ListPagedResponse responseToken = zonesClient.list(listZonesRequestToken);
    ZonesClient.ListPage nextPageWithToken = responseToken.getPage();
    Assert.assertEquals(
        Lists.newArrayList(nextPage.getValues()),
        Lists.newArrayList(nextPageWithToken.getValues()));
  }

  @Test
  public void testPaginationIterating() {
    ListZonesRequest listZonesRequest =
        ListZonesRequest.newBuilder().setProject(DEFAULT_PROJECT).setMaxResults(1).build();
    ZonesClient.ListPagedResponse response = zonesClient.list(listZonesRequest);
    boolean presented = false;
    int count = 0;
    for (Zone element : response.iterateAll()) {
      count++;
      if (element.getName().equals(DEFAULT_ZONE)) {
        presented = true;
      }
    }
    Assert.assertTrue(
        String.format(
            "Zone %s was not found for %s in zones list (size: %d).",
            DEFAULT_ZONE, DEFAULT_PROJECT, count),
        presented);
  }

  @Test
  public void testPaginationAggregatedIterating() throws IOException {
    AcceleratorTypesClient acceleratorTypesClient = AcceleratorTypesClient.create();
    AggregatedListAcceleratorTypesRequest aggregatedListAcceleratorTypesRequest =
        AggregatedListAcceleratorTypesRequest.newBuilder()
            .setProject(DEFAULT_PROJECT)
            .setMaxResults(2)
            .build();
    AcceleratorTypesClient.AggregatedListPagedResponse response =
        acceleratorTypesClient.aggregatedList(aggregatedListAcceleratorTypesRequest);
    boolean presented = false;
    for (Map.Entry<String, AcceleratorTypesScopedList> entry : response.iterateAll()) {
      if (entry.getKey().equals("zones/" + DEFAULT_ZONE)) {
        for (AcceleratorType type : entry.getValue().getAcceleratorTypesList()) {
          if (type.getName().equals("nvidia-tesla-t4")) {
            presented = true;
            break;
          }
        }
      }
    }
    Assert.assertTrue(presented);
  }
}
