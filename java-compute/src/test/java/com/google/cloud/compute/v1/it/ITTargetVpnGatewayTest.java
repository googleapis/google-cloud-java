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

import com.google.cloud.compute.v1.TargetVpnGateway;
import com.google.cloud.compute.v1.TargetVpnGatewayClient;
import com.google.cloud.compute.v1.TargetVpnGatewaySettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetVpnGatewayTest extends BaseTest {

  private static TargetVpnGatewayClient targetVpnGatewayClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetVpnGatewaySettings targetVpnGatewaySettings =
        TargetVpnGatewaySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetVpnGatewayClient = TargetVpnGatewayClient.create(targetVpnGatewaySettings);
  }

  @AfterClass
  public static void tearDown() {
    targetVpnGatewayClient.close();
  }

  @Test
  public void listTargetVpnGatewaysTest() {
    List<TargetVpnGateway> targetVpnGateways =
        Lists.newArrayList(
            targetVpnGatewayClient.listTargetVpnGateways(PROJECT_REGION_NAME).iterateAll());
    assertNotNull(targetVpnGateways);
    assertThat(targetVpnGateways.size()).isEqualTo(0);
    assertThat(targetVpnGateways.contains(null)).isFalse();
  }
}
