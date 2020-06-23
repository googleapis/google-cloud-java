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

import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyClient;
import com.google.cloud.compute.v1.TargetSslProxySettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTargetSslProxyTest extends BaseTest {

  private static TargetSslProxyClient targetSslProxyClient;

  @BeforeClass
  public static void setUp() throws IOException {
    TargetSslProxySettings targetSslProxySettings =
        TargetSslProxySettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetSslProxyClient = TargetSslProxyClient.create(targetSslProxySettings);
  }

  @AfterClass
  public static void tearDown() {
    targetSslProxyClient.close();
  }

  @Test
  public void listTargetSslProxiesTest() {
    List<TargetSslProxy> targetSslProxies =
        Lists.newArrayList(targetSslProxyClient.listTargetSslProxies(PROJECT_NAME).iterateAll());
    assertThat(targetSslProxies.size()).isEqualTo(0);
    assertThat(targetSslProxies.contains(null)).isFalse();
  }
}
