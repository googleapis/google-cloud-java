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

import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallClient;
import com.google.cloud.compute.v1.FirewallSettings;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkClient;
import com.google.cloud.compute.v1.NetworkSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNetworkTest extends BaseTest {
  private static final String NETWORK = TestHelper.getTestUniqueName("network");;

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
        Network.newBuilder().setAutoCreateSubnetworks(Boolean.FALSE).setName(NETWORK).build();
    Operation completedOperation =
        waitForOperation(networkClient.insertNetwork(PROJECT_NAME, networkResource));
    resourcesToCleanUp.put("network", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    List<Firewall> firewalls =
        Lists.newArrayList(firewallClient.listFirewalls(PROJECT_NAME).iterateAll());
    for (String networkLink : resourcesToCleanUp.get("network")) {
      Network network = networkClient.getNetwork(networkLink);
      for (Firewall firewall : firewalls) {
        if (firewall.getName().startsWith(network.getName())) {
          System.out.println("deleting firewall:" + firewall.getSelfLink());
          waitForOperation(firewallClient.deleteFirewall(firewall.getSelfLink()));
        }
      }
      waitForOperation(networkClient.deleteNetwork(networkLink));
    }

    firewallClient.close();
    networkClient.close();
  }

  @Test
  public void listNetworkTest() {
    List<Network> networks =
        Lists.newArrayList(networkClient.listNetworks(PROJECT_NAME).iterateAll());

    boolean found = false;
    for (Network network : networks) {
      if (NETWORK.equals(network.getName())) {
        found = true;
        assertThat(network.getAutoCreateSubnetworks()).isFalse();
      }
    }
    assertThat(found).isTrue();
  }
}
