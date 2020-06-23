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

import com.google.cloud.compute.v1.TargetTcpProxy;
import com.google.cloud.compute.v1.TargetTcpProxyClient;
import com.google.cloud.compute.v1.TargetTcpProxySettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetTcpProxyTest extends BaseTest {

  private static TargetTcpProxyClient targetTcpProxyClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetTcpProxySettings targetTcpProxySettings =
        TargetTcpProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetTcpProxyClient = TargetTcpProxyClient.create(targetTcpProxySettings);
  }

  @AfterClass
  public static void tearDown() {
    targetTcpProxyClient.close();
  }

  @Test
  public void listTargetTcpProxiesTest() {
    List<TargetTcpProxy> proxies =
        Lists.newArrayList(targetTcpProxyClient.listTargetTcpProxies(PROJECT_NAME).iterateAll());
    assertThat(proxies).isNotNull();
    assertThat(proxies.size()).isEqualTo(0);
    assertThat(proxies.contains(null)).isFalse();
  }
}
