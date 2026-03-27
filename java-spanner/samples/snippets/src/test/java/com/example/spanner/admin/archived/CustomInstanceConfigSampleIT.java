/*
 * Copyright 2022 Google LLC
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

package com.example.spanner.admin.archived;

import static org.junit.Assert.assertTrue;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import org.junit.Test;

public class CustomInstanceConfigSampleIT extends SampleTestBase {

  @Test
  public void testCustomInstanceConfigOperations() throws Exception {
    String customInstanceConfigId = idGenerator.generateInstanceConfigId();

    // Create a random instance config. Display name is set to the instance config id in sample.
    final String out1 =
        SampleRunner.runSample(
            () ->
                CreateInstanceConfigSample.createInstanceConfig(
                    projectId, instanceConfigName, customInstanceConfigId));
    assertTrue(out1.contains("Created instance configuration"));

    // List the instance config operations.
    final String out2 =
        SampleRunner.runSample(
            () ->
                ListInstanceConfigOperationsSample.listInstanceConfigOperations(projectId));
    assertTrue(out2.contains("Create instance config operation"));

    // Update display name to a randomly generated instance config id.
    final String out3 =
        SampleRunner.runSample(
            () ->
                UpdateInstanceConfigSample.updateInstanceConfig(
                    projectId, customInstanceConfigId));
    assertTrue(out3.contains("Updated instance configuration"));

    // Delete the created instance config.
    final String out4 =
        SampleRunner.runSample(
            () ->
                DeleteInstanceConfigSample.deleteInstanceConfig(projectId, customInstanceConfigId));
    assertTrue(out4.contains("Deleted instance configuration"));
  }
}
