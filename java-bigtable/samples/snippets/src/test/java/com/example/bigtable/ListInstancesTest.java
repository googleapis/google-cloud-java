/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link ListInstances}. */
public class ListInstancesTest extends BigtableBaseTest {

  /** Initializes project and instance test variables from environment variables. */
  @BeforeClass
  public static void beforeClass() {
    initializeVariables();
  }

  /** Verifies that {@link ListInstances#listInstances(String)} prints the test instance name. */
  @Test
  public void testListInstances() throws IOException {
    ListInstances.listInstances(projectId);

    String output = bout.toString();
    assertThat(output).contains("projects/" + projectId + "/instances/" + instanceId);
  }
}
