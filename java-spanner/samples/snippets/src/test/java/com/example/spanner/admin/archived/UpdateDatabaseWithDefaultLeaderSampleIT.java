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
import com.example.spanner.admin.archived.UpdateDatabaseWithDefaultLeaderSample;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class UpdateDatabaseWithDefaultLeaderSampleIT extends SampleTestBase {

  @Test
  public void testUpdateDatabaseWithDefaultLeader() throws Exception {
    // Create database
    final String databaseId = idGenerator.generateDatabaseId();
    final Database createdDatabase = databaseAdminClient
        .createDatabase(multiRegionalInstanceId, databaseId, Collections.emptyList())
        .get(5, TimeUnit.MINUTES);
    final String defaultLeader = createdDatabase.getDefaultLeader();

    // Finds a possible new leader option
    final InstanceConfigId instanceConfigId = instanceAdminClient
        .getInstance(multiRegionalInstanceId)
        .getInstanceConfigId();
    final InstanceConfig config = instanceAdminClient
        .getInstanceConfig(instanceConfigId.getInstanceConfig());
    final String newLeader = config
        .getLeaderOptions()
        .stream()
        .filter(leader -> !leader.equals(defaultLeader))
        .findFirst()
        .orElseThrow(() ->
            new RuntimeException("Expected to find a leader option different than " + defaultLeader)
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
