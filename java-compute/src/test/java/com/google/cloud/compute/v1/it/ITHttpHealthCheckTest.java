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

import com.google.cloud.compute.v1.GetHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HttpHealthCheck2;
import com.google.cloud.compute.v1.HttpHealthCheckClient;
import com.google.cloud.compute.v1.HttpHealthCheckSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalHttpHealthCheckName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITHttpHealthCheckTest extends BaseTest {

  private static final String HTTP_HEALTH_CHECK_2 =
      TestHelper.getTestUniqueName("http-health-check2");
  private static final String HTTP_HEALTH_CHECK_LINK =
      String.format("%s/global/httpHealthChecks/%s", PROJECT_LINK, HTTP_HEALTH_CHECK_2);
  private static final ProjectGlobalHttpHealthCheckName HTTP_HEALTH_CHECK_NAME =
      ProjectGlobalHttpHealthCheckName.of(HTTP_HEALTH_CHECK_2, DEFAULT_PROJECT);
  private static final Integer PORT = 80;
  private static final Integer UNHEALTHY_THRESHOLD = 2;

  private static HttpHealthCheckClient httpHealthCheckClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    HttpHealthCheckSettings httpHealthCheckSettings =
        HttpHealthCheckSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    httpHealthCheckClient = HttpHealthCheckClient.create(httpHealthCheckSettings);

    HttpHealthCheck2 httpHealthCheckResource =
        HttpHealthCheck2.newBuilder()
            .setName(HTTP_HEALTH_CHECK_2)
            .setPort(PORT)
            .setUnhealthyThreshold(UNHEALTHY_THRESHOLD)
            .build();
    Operation completedOperation =
        waitForOperation(
            httpHealthCheckClient.insertHttpHealthCheck(PROJECT_NAME, httpHealthCheckResource));
    resourcesToCleanUp.put("http-health-check", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String httpHealthCheck : resourcesToCleanUp.get("http-health-check")) {
      waitForOperation(httpHealthCheckClient.deleteHttpHealthCheck(httpHealthCheck));
    }
    httpHealthCheckClient.close();
  }

  @Test
  public void getHttpHealthCheckTest() throws Exception {
    GetHttpHealthCheckHttpRequest request =
        GetHttpHealthCheckHttpRequest.newBuilder()
            .setHttpHealthCheck(HTTP_HEALTH_CHECK_NAME.toString())
            .build();
    HttpHealthCheck2 httpHealthCheck = httpHealthCheckClient.getHttpHealthCheck(request);
    assertThat(httpHealthCheck.getName()).isEqualTo(HTTP_HEALTH_CHECK_2);
    assertThat(httpHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
    assertThat(httpHealthCheck.getPort()).isEqualTo(PORT);
    assertThat(httpHealthCheck.getSelfLink()).isEqualTo(HTTP_HEALTH_CHECK_LINK);
  }

  @Test
  public void listHttpHealthChecksTest() {
    List<HttpHealthCheck2> healthCheck2s =
        Lists.newArrayList(httpHealthCheckClient.listHttpHealthChecks(PROJECT_NAME).iterateAll());
    for (HttpHealthCheck2 httpHealthCheck : healthCheck2s) {
      if (HTTP_HEALTH_CHECK_2.equals(httpHealthCheck.getName())) {
        assertThat(httpHealthCheck.getName()).isEqualTo(HTTP_HEALTH_CHECK_2);
        assertThat(httpHealthCheck.getHealthyThreshold()).isEqualTo(UNHEALTHY_THRESHOLD);
        assertThat(httpHealthCheck.getPort()).isEqualTo(PORT);
        assertThat(httpHealthCheck.getSelfLink()).isEqualTo(HTTP_HEALTH_CHECK_LINK);
      }
    }
  }
}
