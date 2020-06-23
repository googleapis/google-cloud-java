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

import com.google.cloud.compute.v1.TargetHttpProxiesScopedList;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyClient;
import com.google.cloud.compute.v1.TargetHttpProxySettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetHttpProxyTest extends BaseTest {

  private static TargetHttpProxyClient targetHttpProxyClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetHttpProxySettings targetHttpProxySettings =
        TargetHttpProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetHttpProxyClient = TargetHttpProxyClient.create(targetHttpProxySettings);
  }

  @AfterClass
  public static void tearDown() {
    targetHttpProxyClient.close();
  }

  @Test
  public void listTargetHttpProxiesTest() {
    List<TargetHttpProxy> targetHttpProxies =
        Lists.newArrayList(targetHttpProxyClient.listTargetHttpProxies(PROJECT_NAME).iterateAll());
    assertThat(targetHttpProxies.size()).isEqualTo(0);
    assertThat(targetHttpProxies.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListTargetHttpProxiesTest() {
    List<TargetHttpProxiesScopedList> targetHttpProxiesScopedLists =
        Lists.newArrayList(
            targetHttpProxyClient.aggregatedListTargetHttpProxies(true, PROJECT_NAME).iterateAll());
    assertThat(targetHttpProxiesScopedLists).isNotNull();
    assertThat(targetHttpProxiesScopedLists.size()).isGreaterThan(0);
    assertThat(targetHttpProxiesScopedLists.contains(null)).isFalse();
  }
}
