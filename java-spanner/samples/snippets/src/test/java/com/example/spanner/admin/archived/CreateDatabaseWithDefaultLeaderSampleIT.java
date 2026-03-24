/*
 * Copyright 2021 Google LLC
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
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import org.junit.Test;

public class CreateDatabaseWithDefaultLeaderSampleIT extends SampleTestBase {

  @Test
  public void testCreateDatabaseWithDefaultLeader() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();

    // Finds possible default leader
    final InstanceConfigId instanceConfigId = instanceAdminClient
        .getInstance(multiRegionalInstanceId)
        .getInstanceConfigId();
    final InstanceConfig config = instanceAdminClient
        .getInstanceConfig(instanceConfigId.getInstanceConfig());
    assertTrue(
        "Expected instance config " + instanceConfigId + " to have at least one leader option",
        config.getLeaderOptions().size() > 0
    );
    final String defaultLeader = config.getLeaderOptions().get(0);

    // Runs sample
    final String out = SampleRunner.runSample(() ->
        CreateDatabaseWithDefaultLeaderSample.createDatabaseWithDefaultLeader(
            projectId,
            multiRegionalInstanceId,
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
