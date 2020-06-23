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

import com.google.cloud.compute.v1.GlobalOperationClient;
import com.google.cloud.compute.v1.GlobalOperationSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationsScopedList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITGlobalOperationTest extends BaseTest {

  private static GlobalOperationClient globalOperationClient;

  @BeforeClass
  public static void setUp() throws IOException {
    GlobalOperationSettings globalOperationSettings =
        GlobalOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalOperationClient = GlobalOperationClient.create(globalOperationSettings);
  }

  @AfterClass
  public static void tearDown() {
    globalOperationClient.close();
  }

  @Test
  public void listGlobalOperationsTest() {
    GlobalOperationClient.ListGlobalOperationsPagedResponse listGlobalOperations =
        globalOperationClient.listGlobalOperations(PROJECT_NAME);
    List<Operation> operations = Lists.newArrayList(listGlobalOperations.iterateAll());
    assertThat(operations).isNotNull();
    assertThat(operations.size()).isGreaterThan(0);
    assertThat(operations.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListGlobalOperationsTest() {
    List<OperationsScopedList> operationsScopedLists =
        Lists.newArrayList(
            globalOperationClient.aggregatedListGlobalOperations(true, PROJECT_NAME).iterateAll());
    assertThat(operationsScopedLists).isNotNull();
    assertThat(operationsScopedLists.size()).isGreaterThan(0);
    assertThat(operationsScopedLists.contains(null)).isFalse();
  }
}
