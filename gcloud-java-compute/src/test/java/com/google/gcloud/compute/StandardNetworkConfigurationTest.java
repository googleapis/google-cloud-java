/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.compute;

import com.google.gcloud.compute.NetworkConfiguration.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StandardNetworkConfigurationTest {

  private static final String IP_RANGE = "192.168.0.0/16";
  private static final String GATEWAY_ADDRESS = "192.168.1.1";
  private static final StandardNetworkConfiguration NETWORK_CONFIGURATION =
      new StandardNetworkConfiguration(IP_RANGE, GATEWAY_ADDRESS);

  @Test
  public void testConstructor() {
    assertEquals(Type.STANDARD, NETWORK_CONFIGURATION.type());
    assertEquals(IP_RANGE, NETWORK_CONFIGURATION.ipRange());
    assertEquals(GATEWAY_ADDRESS, NETWORK_CONFIGURATION.gatewayAddress());
    StandardNetworkConfiguration networkConfiguration =
        new StandardNetworkConfiguration(IP_RANGE, null);
    assertEquals(Type.STANDARD, networkConfiguration.type());
    assertEquals(IP_RANGE, networkConfiguration.ipRange());
    assertNull(networkConfiguration.gatewayAddress());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(NetworkConfiguration.fromPb(NETWORK_CONFIGURATION.toPb())
        instanceof StandardNetworkConfiguration);
    compareNetworkConfiguration(NETWORK_CONFIGURATION,
        NetworkConfiguration.<StandardNetworkConfiguration>fromPb(NETWORK_CONFIGURATION.toPb()));
    StandardNetworkConfiguration networkConfiguration =
        new StandardNetworkConfiguration(IP_RANGE, null);
    assertTrue(NetworkConfiguration.fromPb(networkConfiguration.toPb())
        instanceof StandardNetworkConfiguration);
    compareNetworkConfiguration(networkConfiguration,
        NetworkConfiguration.<StandardNetworkConfiguration>fromPb(networkConfiguration.toPb()));
  }

  @Test
  public void testOf() {
    StandardNetworkConfiguration configuration = StandardNetworkConfiguration.of(IP_RANGE);
    assertEquals(Type.STANDARD, configuration.type());
    assertEquals(IP_RANGE, configuration.ipRange());
    assertNull(configuration.gatewayAddress());
  }

  private void compareNetworkConfiguration(StandardNetworkConfiguration expected,
      StandardNetworkConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.ipRange(), value.ipRange());
    assertEquals(expected.gatewayAddress(), value.gatewayAddress());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
