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

import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckClient;
import com.google.cloud.compute.v1.HealthCheckSettings;
import com.google.cloud.compute.v1.HealthChecksScopedList;
import com.google.cloud.compute.v1.InsertHealthCheckHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TCPHealthCheck;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITHealthCheckTest extends BaseTest {

  private static final String HEALTH_CHECK_NAME = TestHelper.getTestUniqueName("health-check");
  private static final String HEALTH_CHECK_LINK =
      String.format("%s/global/healthChecks/%s", PROJECT_LINK, HEALTH_CHECK_NAME);
  private static final TCPHealthCheck TCP_HEALTH_CHECK =
      TCPHealthCheck.newBuilder().setPort(80).setProxyHeader("NONE").build();
  private static final Integer UNHEALTHY_THRESHOLD = 2;

  private static HealthCheckClient healthCheckClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    HealthCheckSettings healthCheckSettings =
        HealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    healthCheckClient = HealthCheckClient.create(healthCheckSettings);

    HealthCheck healthCheckResource =
        HealthCheck.newBuilder()
            .setName(HEALTH_CHECK_NAME)
            .setType(IP_PROTOCOL)
            .setTcpHealthCheck(TCP_HEALTH_CHECK)
            .setCheckIntervalSec(10)
            .setTimeoutSec(5)
            .setUnhealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    InsertHealthCheckHttpRequest insertHealthCheckHttpRequest =
        InsertHealthCheckHttpRequest.newBuilder()
            .setProject(PROJECT_NAME.toString())
            .setHealthCheckResource(healthCheckResource)
            .build();
    Operation completedOperation =
        waitForOperation(healthCheckClient.insertHealthCheck(insertHealthCheckHttpRequest));
    resourcesToCleanUp.put("health-check", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String healthCheck : resourcesToCleanUp.get("health-check")) {
      waitForOperation(healthCheckClient.deleteHealthCheck(healthCheck));
    }
    healthCheckClient.close();
  }

  @Test
  public void listHealthChecksTest() {
    List<HealthCheck> healthChecks =
        Lists.newArrayList(healthCheckClient.listHealthChecks(PROJECT_NAME).iterateAll());
    for (HealthCheck healthCheck : healthChecks) {
      if (HEALTH_CHECK_NAME.equals(healthCheck.getName())) {
        assertThat(healthCheck.getName()).isEqualTo(HEALTH_CHECK_NAME);
        assertThat(healthCheck.getSelfLink()).isEqualTo(HEALTH_CHECK_LINK);
        assertThat(healthCheck.getTcpHealthCheck()).isEqualTo(TCP_HEALTH_CHECK);
        assertThat(healthCheck.getType()).isEqualTo(IP_PROTOCOL);
      }
    }
  }

  @Test
  public void aggregatedListHealthChecksTest() {
    List<HealthChecksScopedList> scopedLists =
        Lists.newArrayList(
            healthCheckClient.aggregatedListHealthChecks(true, PROJECT_NAME).iterateAll());
    Iterator<HealthChecksScopedList> iterator = scopedLists.iterator();
    while (iterator.hasNext()) {
      List<HealthCheck> checkList = iterator.next().getHealthChecksList();
      if (null != checkList && checkList.size() > 0) {
        for (HealthCheck healthCheck : checkList) {
          if (HEALTH_CHECK_NAME.equals(healthCheck.getName())) {
            assertThat(healthCheck.getName()).isEqualTo(HEALTH_CHECK_NAME);
            assertThat(healthCheck.getSelfLink()).isEqualTo(HEALTH_CHECK_LINK);
            assertThat(healthCheck.getTcpHealthCheck()).isEqualTo(TCP_HEALTH_CHECK);
            assertThat(healthCheck.getType()).isEqualTo(IP_PROTOCOL);
          }
        }
      }
    }
  }
}
