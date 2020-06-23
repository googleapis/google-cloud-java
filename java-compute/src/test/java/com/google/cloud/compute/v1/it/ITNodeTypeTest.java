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

import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeClient;
import com.google.cloud.compute.v1.NodeTypeSettings;
import com.google.cloud.compute.v1.NodeTypesScopedList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNodeTypeTest extends BaseTest {

  private static NodeTypeClient nodeTypeClient;

  @BeforeClass
  public static void setUp() throws IOException {
    NodeTypeSettings nodeTypeSettings =
        NodeTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    nodeTypeClient = NodeTypeClient.create(nodeTypeSettings);
  }

  @AfterClass
  public static void tearDown() {
    nodeTypeClient.close();
  }

  @Test
  public void listNodeTypesTest() {
    List<NodeType> nodeTypes =
        Lists.newArrayList(nodeTypeClient.listNodeTypes(PROJECT_ZONE_NAME).iterateAll());
    assertThat(nodeTypes).isNotNull();
    assertThat(nodeTypes.size()).isGreaterThan(0);
    assertThat(nodeTypes.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListNodeTypesTest() {
    List<NodeTypesScopedList> nodeTypesScopedLists =
        Lists.newArrayList(nodeTypeClient.aggregatedListNodeTypes(true, PROJECT_NAME).iterateAll());
    assertThat(nodeTypesScopedLists).isNotNull();
    assertThat(nodeTypesScopedLists.size()).isGreaterThan(0);
    assertThat(nodeTypesScopedLists.contains(null)).isFalse();
  }
}
