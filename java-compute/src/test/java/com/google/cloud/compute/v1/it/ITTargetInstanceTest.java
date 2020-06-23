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

import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceClient;
import com.google.cloud.compute.v1.TargetInstanceSettings;
import com.google.cloud.compute.v1.TargetInstancesScopedList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetInstanceTest extends BaseTest {

  private static TargetInstanceClient targetInstanceClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetInstanceSettings targetInstanceSettings =
        TargetInstanceSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetInstanceClient = TargetInstanceClient.create(targetInstanceSettings);
  }

  @AfterClass
  public static void tearDown() {
    targetInstanceClient.close();
  }

  @Test
  public void listTargetInstancesTest() {
    List<TargetInstance> targetInstances =
        Lists.newArrayList(
            targetInstanceClient.listTargetInstances(PROJECT_ZONE_NAME).iterateAll());
    assertThat(targetInstances).isNotNull();
    assertThat(targetInstances.size()).isEqualTo(0);
    assertThat(targetInstances.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListTargetInstancesTest() {
    List<TargetInstancesScopedList> targetInstancesScopedLists =
        Lists.newArrayList(
            targetInstanceClient.aggregatedListTargetInstances(true, PROJECT_NAME).iterateAll());
    assertNotNull(targetInstancesScopedLists);
    assertThat(targetInstancesScopedLists.size()).isGreaterThan(0);
    assertThat(targetInstancesScopedLists.contains(null)).isFalse();
  }
}
