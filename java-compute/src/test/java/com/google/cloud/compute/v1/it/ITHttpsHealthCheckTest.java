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

import com.google.cloud.compute.v1.HttpsHealthCheck2;
import com.google.cloud.compute.v1.HttpsHealthCheckClient;
import com.google.cloud.compute.v1.HttpsHealthCheckSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalHttpsHealthCheckName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITHttpsHealthCheckTest extends BaseTest {

  private static final String HTTPS_HEALTH_CHECK_2 =
      TestHelper.getTestUniqueName("https-health-check");
  private static final String HTTPS_HEALTH_CHECK_LINK =
      String.format("%s/global/httpsHealthChecks/%s", PROJECT_LINK, HTTPS_HEALTH_CHECK_2);
  private static final ProjectGlobalHttpsHealthCheckName HTTPS_HEALTH_CHECK_NAME =
      ProjectGlobalHttpsHealthCheckName.of(HTTPS_HEALTH_CHECK_2, DEFAULT_PROJECT);
  private static final Integer PORT = 80;
  private static final Integer UNHEALTHY_THRESHOLD = 2;

  private static HttpsHealthCheckClient httpsHealthCheckClient;
  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    HttpsHealthCheckSettings httpsHealthCheckSettings =
        HttpsHealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    httpsHealthCheckClient = HttpsHealthCheckClient.create(httpsHealthCheckSettings);
    HttpsHealthCheck2 httpsHealthCheckResource =
        HttpsHealthCheck2.newBuilder()
            .setName(HTTPS_HEALTH_CHECK_2)
            .setPort(PORT)
            .setHealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    Operation completedOperation =
        waitForOperation(
            httpsHealthCheckClient.insertHttpsHealthCheck(PROJECT_NAME, httpsHealthCheckResource));
    resourcesToCleanUp.put("https-health-check", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String httpsHealthCheck : resourcesToCleanUp.get("https-health-check")) {
      waitForOperation(httpsHealthCheckClient.deleteHttpsHealthCheck(httpsHealthCheck));
    }
    httpsHealthCheckClient.close();
  }

  @Test
  public void getHttpsHealthCheckTest() throws Exception {
    HttpsHealthCheck2 httpsHealthCheck =
        httpsHealthCheckClient.getHttpsHealthCheck(HTTPS_HEALTH_CHECK_NAME);
    assertThat(httpsHealthCheck.getName()).isEqualTo(HTTPS_HEALTH_CHECK_2);
    assertThat(httpsHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
    assertThat(httpsHealthCheck.getPort()).isEqualTo(PORT);
    assertThat(httpsHealthCheck.getSelfLink()).isEqualTo(HTTPS_HEALTH_CHECK_LINK);
  }

  @Test
  public void listHttpsHealthChecksTest() {
    List<HttpsHealthCheck2> httpsHealthCheck2s =
        Lists.newArrayList(httpsHealthCheckClient.listHttpsHealthChecks(PROJECT_NAME).iterateAll());
    for (HttpsHealthCheck2 httpsHealthCheck : httpsHealthCheck2s) {
      if (HTTPS_HEALTH_CHECK_2.equals(httpsHealthCheck.getName())) {
        assertThat(httpsHealthCheck.getName()).isEqualTo(HTTPS_HEALTH_CHECK_2);
        assertThat(httpsHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
        assertThat(httpsHealthCheck.getPort()).isEqualTo(PORT);
        assertThat(httpsHealthCheck.getSelfLink()).isEqualTo(HTTPS_HEALTH_CHECK_LINK);
      }
    }
  }
}
