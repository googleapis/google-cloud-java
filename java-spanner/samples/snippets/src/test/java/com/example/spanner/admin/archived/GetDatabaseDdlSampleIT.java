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
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class GetDatabaseDdlSampleIT extends SampleTestBase {

  @Test
  public void testGetDatabaseDdl() throws Exception {
    // Finds a possible new leader option
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

    // Creates database
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient.createDatabase(
        multiRegionalInstanceId,
        databaseId,
        Arrays.asList(
            "CREATE TABLE Singers (Id INT64 NOT NULL) PRIMARY KEY (Id)",
            "ALTER DATABASE `"
                + databaseId
                + "` SET OPTIONS ( default_leader = '"
                + defaultLeader
                + "')"
        )
    ).get(5, TimeUnit.MINUTES);

    // Runs sample
    final String out = SampleRunner.runSample(() -> GetDatabaseDdlSample
        .getDatabaseDdl(projectId, multiRegionalInstanceId, databaseId)
    );

    assertTrue(
        "Expected to have retrieved database DDL for " + databaseId + "."
            + " Output received was " + out,
        out.contains("Retrieved database DDL for " + databaseId)
    );
    assertTrue(
        "Expected leader to be set to " + defaultLeader + "."
            + " Output received was " + out,
        out.contains("default_leader = '" + defaultLeader + "'")
    );
    assertTrue(
        "Expected table to have been created in " + databaseId + "."
            + " Output received was " + out,
        out.contains("CREATE TABLE Singers")
    );
  }
}
