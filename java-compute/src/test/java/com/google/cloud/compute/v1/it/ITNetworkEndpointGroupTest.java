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

import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupClient;
import com.google.cloud.compute.v1.NetworkEndpointGroupSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNetworkEndpointGroupTest extends BaseTest {

  private static NetworkEndpointGroupClient networkEndpointGroupClient;

  @BeforeClass
  public static void setUp() throws IOException {
    NetworkEndpointGroupSettings networkEndpointGroupSettings =
        NetworkEndpointGroupSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    networkEndpointGroupClient = NetworkEndpointGroupClient.create(networkEndpointGroupSettings);
  }

  @AfterClass
  public static void tearDown() {
    networkEndpointGroupClient.close();
  }

  @Test
  public void listNetworkEndpointGroupsTest() {
    List<NetworkEndpointGroup> networkEndpointGroups =
        Lists.newArrayList(
            networkEndpointGroupClient.listNetworkEndpointGroups(PROJECT_ZONE_NAME).iterateAll());
    assertThat(networkEndpointGroups).isNotNull();
    assertThat(networkEndpointGroups.contains(null)).isFalse();
  }
}
