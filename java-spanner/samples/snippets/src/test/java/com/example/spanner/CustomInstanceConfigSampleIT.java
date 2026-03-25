/*
 * Copyright 2024 Google LLC
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

package com.example.spanner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomInstanceConfigSampleIT extends SampleTestBaseV2 {

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

    // Fetch the instance config that was created above.
    final String out2 =
        SampleRunner.runSample(
            () -> GetInstanceConfigSample.getInstanceConfig(projectId, instanceConfigName));
    assertTrue(out2.contains("Available leader options for instance config"));

    // Fetch the instance config that was created above.
    final String out3 =
        SampleRunner.runSample(
            () -> ListInstanceConfigsSample.listInstanceConfigs(projectId));
    assertTrue(out3.contains("Available leader options for instance config"));

    // List the instance config operations.
    final String out4 =
        SampleRunner.runSample(
            () ->
                ListInstanceConfigOperationsSample.listInstanceConfigOperations(projectId));
    assertTrue(out4.contains("Obtained list of instance config operations"));

    // Update display name to a randomly generated instance config id.
    final String out5 =
        SampleRunner.runSample(
            () ->
                UpdateInstanceConfigSample.updateInstanceConfig(projectId, customInstanceConfigId));
    assertTrue(out5.contains("Updated instance configuration"));

    // Delete the created instance config.
    final String out6 =
        SampleRunner.runSample(
            () ->
                DeleteInstanceConfigSample.deleteInstanceConfig(projectId, customInstanceConfigId));
    assertTrue(out6.contains("Deleted instance configuration"));
  }
}
