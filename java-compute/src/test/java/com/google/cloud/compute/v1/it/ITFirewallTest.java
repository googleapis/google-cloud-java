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

import com.google.cloud.compute.v1.Allowed;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallClient;
import com.google.cloud.compute.v1.FirewallSettings;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkClient;
import com.google.cloud.compute.v1.NetworkSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalFirewallName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITFirewallTest extends BaseTest {

  private static final String NETWORK_NAME = TestHelper.getTestUniqueName("firewall-network");
  private static final String FIREWALL_NAME = TestHelper.getTestUniqueName("firewall");
  private static final String FIREWALL_DESCRIPTION = "firewall";
  private static final int FIREWALL_PRIORITY = 1000;
  private static final String DIRECTION = "INGRESS";
  private static final String IP_PROTOCOL = "TCP";
  private static final List<Allowed> ALLOWEDS =
      Arrays.asList(Allowed.newBuilder().setIPProtocol(IP_PROTOCOL.toLowerCase()).build());
  private static final ProjectGlobalFirewallName FIREWALL =
      ProjectGlobalFirewallName.of(FIREWALL_NAME, DEFAULT_PROJECT);
  private static final String FIREWALL_LINK =
      String.format("%s/global/firewalls/%s", PROJECT_LINK, FIREWALL_NAME);

  private static FirewallClient firewallClient;
  private static NetworkClient networkClient;
  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    cleanUpNetworks();

    FirewallSettings firewallSettings =
        FirewallSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    firewallClient = FirewallClient.create(firewallSettings);

    NetworkSettings networkSettings =
        NetworkSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    networkClient = NetworkClient.create(networkSettings);

    Network networkResource =
        Network.newBuilder().setAutoCreateSubnetworks(Boolean.FALSE).setName(NETWORK_NAME).build();
    Operation completedOperation =
        waitForOperation(networkClient.insertNetwork(PROJECT_NAME, networkResource));
    resourcesToCleanUp.put("firewall-network", completedOperation.getTargetLink());

    Firewall firewallResource =
        Firewall.newBuilder()
            .setName(FIREWALL_NAME)
            .setPriority(FIREWALL_PRIORITY)
            .setNetwork(completedOperation.getTargetLink())
            .setDescription(FIREWALL_DESCRIPTION)
            .addAllAllowed(ALLOWEDS)
            .build();
    completedOperation =
        waitForOperation(firewallClient.insertFirewall(PROJECT_NAME, firewallResource));
    resourcesToCleanUp.put("firewall", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() throws IOException {
    // Note: firewalls will be cleaned up by the cleanUpNetwork helper
    for (String network : resourcesToCleanUp.get("firewall-network")) {
      Network firewallNetwork = networkClient.getNetwork(network);
      cleanUpNetwork(firewallNetwork);
    }

    firewallClient.close();
    networkClient.close();
  }

  @Test
  public void getFirewallTest() {
    Firewall firewall = firewallClient.getFirewall(FIREWALL);
    assertThat(firewall.getAllowedList()).isEqualTo(ALLOWEDS);
    assertThat(firewall.getDescription()).isEqualTo(FIREWALL_DESCRIPTION);
    assertThat(firewall.getDirection()).isEqualTo(DIRECTION);
    assertThat(firewall.getDisabled()).isFalse();
    assertThat(firewall.getPriority()).isEqualTo(FIREWALL_PRIORITY);
    assertThat(firewall.getSelfLink()).isEqualTo(FIREWALL_LINK);
  }

  @Test
  public void listFirewallsTest() {
    List<Firewall> firewalls =
        Lists.newArrayList(firewallClient.listFirewalls(PROJECT_NAME).iterateAll());

    boolean found = false;
    for (Firewall firewall : firewalls) {
      if (FIREWALL_NAME.equals(firewall.getName())) {
        found = true;
        assertThat(firewall.getAllowedList()).isEqualTo(ALLOWEDS);
        assertThat(firewall.getDescription()).isEqualTo(FIREWALL_DESCRIPTION);
        assertThat(firewall.getDirection()).isEqualTo(DIRECTION);
        assertThat(firewall.getDisabled()).isFalse();
        assertThat(firewall.getPriority()).isEqualTo(FIREWALL_PRIORITY);
        assertThat(firewall.getSelfLink()).isEqualTo(FIREWALL_LINK);
      }
    }
    assertThat(found).isTrue();
  }
}
