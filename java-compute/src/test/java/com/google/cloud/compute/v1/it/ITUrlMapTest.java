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

import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapClient;
import com.google.cloud.compute.v1.UrlMapSettings;
import com.google.cloud.compute.v1.UrlMapsScopedList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITUrlMapTest extends BaseTest {

  private static UrlMapClient urlMapClient;

  @BeforeClass
  public static void setUp() throws IOException {
    UrlMapSettings urlMapSettings =
        UrlMapSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    urlMapClient = UrlMapClient.create(urlMapSettings);
  }

  @AfterClass
  public static void tearDown() {
    urlMapClient.close();
  }

  @Test
  public void listUrlMapsTest() {
    List<UrlMap> urlMaps = Lists.newArrayList(urlMapClient.listUrlMaps(PROJECT_NAME).iterateAll());
    assertThat(urlMaps).isNotNull();
    assertThat(urlMaps.size()).isEqualTo(0);
    assertThat(urlMaps.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListUrlMapsTest() {
    List<UrlMapsScopedList> urlMapsScopedLists =
        Lists.newArrayList(urlMapClient.aggregatedListUrlMaps(true, PROJECT_NAME).iterateAll());
    assertThat(urlMapsScopedLists).isNotNull();
    assertThat(urlMapsScopedLists.size()).isGreaterThan(0);
    assertThat(urlMapsScopedLists.contains(null)).isFalse();
  }
}
