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

import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayClient;
import com.google.cloud.compute.v1.ExternalVpnGatewayInterface;
import com.google.cloud.compute.v1.ExternalVpnGatewaySettings;
import com.google.cloud.compute.v1.Operation;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITExternalVpnGatewayTest extends BaseTest {

  private static ExternalVpnGatewayClient externalVpnGatewayClient;

  private static final String EXTERNAL_VPN_GATEWAY_NAME =
      TestHelper.getTestUniqueName("external-vpn-gateway");
  private static final String REDUNDANCY_TYPE = "SINGLE_IP_INTERNALLY_REDUNDANT";
  private static final String EXTERNAL_VPN_GATEWAY_DESCRIPTION = "ExternalVpnGateway";
  private static final String EXTERNAL_VPN_GATEWAY_TARGET_LINK =
      String.format("%s/global/externalVpnGateways/%s", PROJECT_LINK, EXTERNAL_VPN_GATEWAY_NAME);
  private static final List<ExternalVpnGatewayInterface> VPN_GATEWAY_INTERFACE =
      Arrays.asList(
          ExternalVpnGatewayInterface.newBuilder().setId(0).setIpAddress("8.8.8.8").build());

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    ExternalVpnGatewaySettings externalVpnGatewaySettings =
        ExternalVpnGatewaySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    externalVpnGatewayClient = ExternalVpnGatewayClient.create(externalVpnGatewaySettings);

    ExternalVpnGateway externalVpnGateway =
        ExternalVpnGateway.newBuilder()
            .setName(EXTERNAL_VPN_GATEWAY_NAME)
            .setRedundancyType(REDUNDANCY_TYPE)
            .setDescription(EXTERNAL_VPN_GATEWAY_DESCRIPTION)
            .addAllInterfaces(VPN_GATEWAY_INTERFACE)
            .build();
    Operation completedOperation =
        waitForOperation(
            externalVpnGatewayClient.insertExternalVpnGateway(PROJECT_NAME, externalVpnGateway));
    resourcesToCleanUp.put("external-vpn-gateway", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String externalVpnGateway : resourcesToCleanUp.get("external-vpn-gateway")) {
      waitForOperation(externalVpnGatewayClient.deleteExternalVpnGateway(externalVpnGateway));
    }
    externalVpnGatewayClient.close();
  }

  @Test
  public void listExternalVpnGatewaysTest() {
    List<ExternalVpnGateway> vpnGateways =
        Lists.newArrayList(
            externalVpnGatewayClient.listExternalVpnGateways(PROJECT_NAME).iterateAll());
    assertThat(vpnGateways.size()).isGreaterThan(0);
    assertThat(vpnGateways.contains(null)).isFalse();
    for (ExternalVpnGateway vpnGateway : vpnGateways) {
      if (EXTERNAL_VPN_GATEWAY_NAME.equals(vpnGateway.getName())) {
        assertThat(vpnGateway.getName()).isEqualTo(EXTERNAL_VPN_GATEWAY_NAME);
        assertThat(vpnGateway.getRedundancyType()).isEqualTo(REDUNDANCY_TYPE);
        assertThat(vpnGateway.getSelfLink()).isEqualTo(EXTERNAL_VPN_GATEWAY_TARGET_LINK);
        assertThat(vpnGateway.getInterfacesList()).isEqualTo(VPN_GATEWAY_INTERFACE);
        assertThat(vpnGateway.getDescription()).isEqualTo(EXTERNAL_VPN_GATEWAY_DESCRIPTION);
      }
    }
  }
}
