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

import com.google.cloud.compute.v1.InsertTargetPoolHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionTargetPoolName;
import com.google.cloud.compute.v1.SetBackupTargetPoolHttpRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolClient;
import com.google.cloud.compute.v1.TargetPoolSettings;
import com.google.cloud.compute.v1.TargetPoolsAddHealthCheckRequest;
import com.google.cloud.compute.v1.TargetPoolsAddInstanceRequest;
import com.google.cloud.compute.v1.TargetPoolsScopedList;
import com.google.cloud.compute.v1.TargetReference;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetPoolTest extends BaseTest {

  private static final String TARGET_POOL_NAME = TestHelper.getTestUniqueName("target-pool");
  private static final String TARGET_POOL_SELF_LINK =
      String.format("%s/targetPools/%s", REGION_LINK, TARGET_POOL_NAME);
  private static final String SESSION_AFFINITY = "NONE";
  private static final ProjectRegionTargetPoolName REGION_TARGET_POOL_NAME =
      ProjectRegionTargetPoolName.of(DEFAULT_PROJECT, REGION, TARGET_POOL_NAME);

  private static TargetPoolClient targetPoolClient;
  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    TargetPoolSettings targetPoolSettings =
        TargetPoolSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetPoolClient = TargetPoolClient.create(targetPoolSettings);

    TargetPool targetPool =
        TargetPool.newBuilder()
            .setName(TARGET_POOL_NAME)
            .setRegion(PROJECT_REGION_NAME.toString())
            .setSessionAffinity(SESSION_AFFINITY)
            .build();
    InsertTargetPoolHttpRequest request =
        InsertTargetPoolHttpRequest.newBuilder()
            .setTargetPoolResource(targetPool)
            .setRegion(PROJECT_REGION_NAME.toString())
            .build();
    Operation completedOperation = waitForOperation(targetPoolClient.insertTargetPool(request));
    System.out.println(completedOperation);
    resourcesToCleanUp.put("target-pool", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String targetPool : resourcesToCleanUp.get("target-pool")) {
      waitForOperation(targetPoolClient.deleteTargetPool(targetPool));
    }
    targetPoolClient.close();
  }

  @Test
  public void getTargetPoolTest() {
    TargetPool targetPool = targetPoolClient.getTargetPool(REGION_TARGET_POOL_NAME);
    assertThat(targetPool).isNotNull();
    assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
    assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
    assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
    assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
  }

  @Test
  public void listTargetPoolsTest() {
    List<TargetPool> targetPools =
        Lists.newArrayList(targetPoolClient.listTargetPools(PROJECT_REGION_NAME).iterateAll());
    assertThat(targetPools).isNotNull();
    assertThat(targetPools.size()).isGreaterThan(0);
    assertThat(targetPools.contains(null)).isFalse();
    for (TargetPool targetPool : targetPools) {
      if (TARGET_POOL_NAME.equals(targetPool.getName())) {
        assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
        assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
        assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
        assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
      }
    }
  }

  @Test
  public void addInstanceTargetPoolTest() throws Exception {
    TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource =
        TargetPoolsAddInstanceRequest.newBuilder().build();
    Operation instanceTargetPool =
        targetPoolClient.addInstanceTargetPool(
            REGION_TARGET_POOL_NAME, targetPoolsAddInstanceRequestResource);
    assertThat(instanceTargetPool).isNotNull();
    assertThat(instanceTargetPool.getOperationType()).isEqualTo("AddInstance");
    assertThat(instanceTargetPool.getRegion()).isEqualTo(REGION_LINK);
    assertThat(instanceTargetPool.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void setBackupTargetPoolTest() throws Exception {
    TargetReference targetReferenceResource = TargetReference.newBuilder().build();
    SetBackupTargetPoolHttpRequest request =
        SetBackupTargetPoolHttpRequest.newBuilder()
            .setTargetPool(REGION_TARGET_POOL_NAME.toString())
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    Operation response = targetPoolClient.setBackupTargetPool(request);
    assertThat(response).isNotNull();
    assertThat(response.getOperationType()).isEqualTo("SetBackup");
    assertThat(response.getStatus()).isEqualTo("RUNNING");
    assertThat(response.getRegion()).isEqualTo(REGION_LINK);
    assertThat(response.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }

  @Test
  public void aggregatedListTargetPoolsTest() {
    List<TargetPoolsScopedList> targetPoolsScopedLists =
        Lists.newArrayList(
            targetPoolClient.aggregatedListTargetPools(true, PROJECT_NAME).iterateAll());
    for (TargetPoolsScopedList targetPoolsScopedList : targetPoolsScopedLists) {
      List<TargetPool> targetPools = targetPoolsScopedList.getTargetPoolsList();
      if (targetPools != null) {
        for (TargetPool targetPool : targetPools) {
          if (TARGET_POOL_NAME.equals(targetPool.getName())) {
            assertThat(targetPool.getName()).isEqualTo(TARGET_POOL_NAME);
            assertThat(targetPool.getRegion()).isEqualTo(REGION_LINK);
            assertThat(targetPool.getSelfLink()).isEqualTo(TARGET_POOL_SELF_LINK);
            assertThat(targetPool.getSessionAffinity()).isEqualTo(SESSION_AFFINITY);
          }
        }
      }
    }
  }

  @Test
  public void addHealthCheckTargetPoolTest() {
    TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource =
        TargetPoolsAddHealthCheckRequest.newBuilder().build();
    Operation response =
        targetPoolClient.addHealthCheckTargetPool(
            REGION_TARGET_POOL_NAME, targetPoolsAddHealthCheckRequestResource);
    assertThat(response).isNotNull();
    assertThat(response.getOperationType()).isEqualTo("AddHealthCheck");
    assertThat(response.getStatus()).isEqualTo("DONE");
    assertThat(response.getRegion()).isEqualTo(REGION_LINK);
    assertThat(response.getTargetLink()).isEqualTo(TARGET_POOL_SELF_LINK);
  }
}
