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

package com.example.spanner;

import static org.junit.Assert.assertTrue;

import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class UpdateDatabaseWithDefaultLeaderSampleIT extends SampleTestBaseV2 {

  @Test
  public void testUpdateDatabaseWithDefaultLeader() throws Exception {
    // Create database
    final String databaseId = idGenerator.generateDatabaseId();
    final Database createdDatabase = databaseAdminClient
        .createDatabaseAsync(getInstanceName(projectId, multiRegionalInstanceId),
            "CREATE DATABASE `" + databaseId + "`")
        .get(5, TimeUnit.MINUTES);
    final String defaultLeader = createdDatabase.getDefaultLeader();

    // Finds a possible new leader option
    final String instanceConfigId =
        instanceAdminClient.getInstance(getInstanceName(projectId, multiRegionalInstanceId))
            .getConfig();
    final InstanceConfig config = instanceAdminClient.getInstanceConfig(instanceConfigId);
    final String newLeader =
        config.getLeaderOptionsList().stream()
            .filter(leader -> !leader.equals(defaultLeader))
            .findFirst().orElseThrow(() ->
                new RuntimeException("Expected to find a leader option different than "
                    + defaultLeader)
            );

    // Runs sample
    final String out = SampleRunner.runSample(() -> UpdateDatabaseWithDefaultLeaderSample
        .updateDatabaseWithDefaultLeader(projectId, multiRegionalInstanceId, databaseId, newLeader)
    );

    assertTrue(
        "Expected that database new leader would had been updated to " + newLeader + "."
            + " Output received was " + out,
        out.contains("Updated default leader to " + newLeader)
    );
  }
}
