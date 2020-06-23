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
import static org.junit.Assert.assertNotNull;

import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.AutoscalerClient;
import com.google.cloud.compute.v1.AutoscalerSettings;
import com.google.cloud.compute.v1.AutoscalersScopedList;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.RegionAutoscalerClient;
import com.google.cloud.compute.v1.RegionAutoscalerSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITAutoscalerTest extends BaseTest {

  private static AutoscalerClient autoscalerClient;
  private static final ProjectZoneName PROJECT_ZONE_NAME =
      ProjectZoneName.of(DEFAULT_PROJECT, ZONE);

  private static RegionAutoscalerClient regionAutoscalerClient;

  @BeforeClass
  public static void setUp() throws IOException {
    AutoscalerSettings autoscalerSettings =
        AutoscalerSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    autoscalerClient = AutoscalerClient.create(autoscalerSettings);

    RegionAutoscalerSettings regionAutoscalerSettings =
        RegionAutoscalerSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionAutoscalerClient = RegionAutoscalerClient.create(regionAutoscalerSettings);
  }

  @AfterClass
  public static void tearDown() {
    autoscalerClient.close();
    regionAutoscalerClient.close();
  }

  @Test
  public void listAutoscalersTest() {
    List<Autoscaler> autoscalers =
        Lists.newArrayList(autoscalerClient.listAutoscalers(PROJECT_ZONE_NAME).iterateAll());
    assertNotNull(autoscalers);
    assertThat(autoscalers.size()).isEqualTo(0);
    assertThat(autoscalers.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListAutoscalersTest() {
    List<AutoscalersScopedList> autoscalersScopedLists =
        Lists.newArrayList(
            autoscalerClient.aggregatedListAutoscalers(true, PROJECT_NAME).iterateAll());
    assertNotNull(autoscalersScopedLists);
    assertThat(autoscalersScopedLists.size()).isGreaterThan(0);
    assertThat(autoscalersScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listRegionAutoscalersTest() {
    List<Autoscaler> autoscalers =
        Lists.newArrayList(
            regionAutoscalerClient.listRegionAutoscalers(PROJECT_REGION_NAME).iterateAll());
    assertThat(autoscalers).isNotNull();
    assertThat(autoscalers.size()).isEqualTo(0);
    assertThat(autoscalers.contains(null)).isFalse();
  }
}
