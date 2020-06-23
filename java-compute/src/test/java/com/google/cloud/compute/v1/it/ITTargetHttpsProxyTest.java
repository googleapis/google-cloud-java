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

import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyClient;
import com.google.cloud.compute.v1.TargetHttpsProxySettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetHttpsProxyTest extends BaseTest {

  private static TargetHttpsProxyClient targetHttpsProxyClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetHttpsProxySettings targetHttpsProxySettings =
        TargetHttpsProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetHttpsProxyClient = TargetHttpsProxyClient.create(targetHttpsProxySettings);
  }

  @AfterClass
  public static void tearDown() {
    targetHttpsProxyClient.close();
  }

  @Test
  public void listTargetHttpsProxiesTest() {
    List<TargetHttpsProxy> targetHttpsProxies =
        Lists.newArrayList(
            targetHttpsProxyClient.listTargetHttpsProxies(PROJECT_NAME).iterateAll());
    assertThat(targetHttpsProxies).isNotNull();
    assertThat(targetHttpsProxies.size()).isEqualTo(0);
    assertThat(targetHttpsProxies.contains(null)).isFalse();
  }
}
