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

import com.google.cloud.compute.v1.NodeTemplate;
import com.google.cloud.compute.v1.NodeTemplateClient;
import com.google.cloud.compute.v1.NodeTemplateSettings;
import com.google.cloud.compute.v1.NodeTemplatesScopedList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNodeTemplateTest extends BaseTest {

  private static NodeTemplateClient nodeTemplateClient;

  @BeforeClass
  public static void setUp() throws IOException {
    NodeTemplateSettings nodeTemplateSettings =
        NodeTemplateSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    nodeTemplateClient = NodeTemplateClient.create(nodeTemplateSettings);
  }

  @AfterClass
  public static void tearDown() {
    nodeTemplateClient.close();
  }

  @Test
  public void listNodeTemplatesTest() {
    List<NodeTemplate> nodeTemplates =
        Lists.newArrayList(nodeTemplateClient.listNodeTemplates(PROJECT_REGION_NAME).iterateAll());
    assertThat(nodeTemplates).isNotNull();
    assertThat(nodeTemplates.size()).isEqualTo(0);
    assertThat(nodeTemplates.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListNodeTemplatesTest() {
    List<NodeTemplatesScopedList> nodeTemplatesScopedLists =
        Lists.newArrayList(
            nodeTemplateClient.aggregatedListNodeTemplates(true, PROJECT_NAME).iterateAll());
    assertThat(nodeTemplatesScopedLists).isNotNull();
    assertThat(nodeTemplatesScopedLists.size()).isGreaterThan(0);
    assertThat(nodeTemplatesScopedLists.contains(null)).isFalse();
  }
}
