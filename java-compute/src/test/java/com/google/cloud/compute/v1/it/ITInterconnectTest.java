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

import com.google.cloud.compute.v1.Interconnect;
import com.google.cloud.compute.v1.InterconnectClient;
import com.google.cloud.compute.v1.InterconnectSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITInterconnectTest extends BaseTest {

  private static final String LOCATION =
      String.format("%s/global/interconnectLocations/den-zone2-389", PROJECT_LINK);
  private static final String INTER_CONNECT = TestHelper.getTestUniqueName("interconnect");
  private static final String INTER_CONNECT_TYPE = "IT_PRIVATE";
  private static final String INTER_CONNECT_LINK_TYPE = "LINK_TYPE_ETHERNET_10G_LR";
  private static final Integer INTER_CONNECT_REQUESTED_LINK_COUNT = 1;
  private static final String INTER_CONNECT_LINK =
      String.format("%s/global/interconnects/%s", PROJECT_LINK, INTER_CONNECT);
  private static final String CUSTOMER_NAME = "customer";
  private static final String OPERATIONAL_STATUS = "OS_ACTIVE";

  private static InterconnectClient interconnectClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    InterconnectSettings interconnectSettings =
        InterconnectSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    interconnectClient = InterconnectClient.create(interconnectSettings);

    Interconnect interconnectResource =
        Interconnect.newBuilder()
            .setName(INTER_CONNECT)
            .setInterconnectType(INTER_CONNECT_TYPE)
            .setLinkType(INTER_CONNECT_LINK_TYPE)
            .setRequestedLinkCount(INTER_CONNECT_REQUESTED_LINK_COUNT)
            .setAdminEnabled(Boolean.TRUE)
            .setCustomerName(CUSTOMER_NAME)
            .setOperationalStatus(OPERATIONAL_STATUS)
            .setLocation(LOCATION)
            .build();
    Operation completedOperation =
        waitForOperation(interconnectClient.insertInterconnect(PROJECT_NAME, interconnectResource));
    resourcesToCleanUp.put("interconnect", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String interconnect : resourcesToCleanUp.get("interconnect")) {
      waitForOperation(interconnectClient.deleteInterconnect(interconnect));
    }
    interconnectClient.close();
  }

  @Test
  public void listInterconnectsTest() {
    List<Interconnect> interconnects =
        Lists.newArrayList(interconnectClient.listInterconnects(PROJECT_NAME).iterateAll());
    assertThat(interconnects.size()).isGreaterThan(0);
    for (Interconnect interconnect : interconnects) {
      if (INTER_CONNECT.equals(interconnect.getName())) {
        assertThat(interconnect.getCustomerName()).isEqualTo(CUSTOMER_NAME);
        assertThat(interconnect.getAdminEnabled()).isTrue();
        assertThat(interconnect.getInterconnectType()).isEqualTo(INTER_CONNECT_TYPE);
        assertThat(interconnect.getLinkType()).isEqualTo(INTER_CONNECT_LINK_TYPE);
        assertThat(interconnect.getName()).isEqualTo(INTER_CONNECT);
        assertThat(interconnect.getRequestedLinkCount())
            .isEqualTo(INTER_CONNECT_REQUESTED_LINK_COUNT);
        assertThat(interconnect.getSelfLink()).isEqualTo(INTER_CONNECT_LINK);
      }
    }
  }
}
