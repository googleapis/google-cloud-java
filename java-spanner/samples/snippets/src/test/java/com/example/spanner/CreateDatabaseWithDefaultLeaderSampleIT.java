/*
 * Copyright 2023 Google LLC
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

import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateDatabaseWithDefaultLeaderSampleIT extends SampleTestBaseV2 {

  @Test
  public void testCreateDatabaseWithDefaultLeader() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();

    // Finds possible default leader

    final String instanceConfigId = instanceAdminClient.getInstance(
        InstanceName.of(projectId, multiRegionalInstanceId)).getConfig();
    final InstanceConfig config = instanceAdminClient.getInstanceConfig(instanceConfigId);
    assertTrue(
        "Expected instance config " + instanceConfigId + " to have at least one leader option",
        config.getLeaderOptionsCount() > 0
    );
    final String defaultLeader = config.getLeaderOptions(0);

    // Runs sample
    final String out = SampleRunner.runSample(() ->
        CreateDatabaseWithDefaultLeaderSample.createDatabaseWithDefaultLeader(
            getInstanceName(projectId, multiRegionalInstanceId),
            databaseId,
            defaultLeader
        )
    );

    assertTrue(
        "Expected created database to have default leader " + defaultLeader + "."
            + " Output received was " + out,
        out.contains("Default leader: " + defaultLeader)
    );
  }
}
