/*
 * Copyright 2023 Google LLC
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class UpdateDatabaseSampleIT extends SampleTestBaseV2 {

  @Test
  public void testUpdateDatabase() throws Exception {
    // Create database
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabaseAsync(getInstanceName(projectId, instanceId),
            "CREATE DATABASE `" + databaseId + "`")
        .get(5, TimeUnit.MINUTES);

    // Runs sample
    final String out =
        SampleRunner.runSample(
            () -> UpdateDatabaseSample.updateDatabase(projectId, instanceId, databaseId));
    assertTrue(
        "Expected that database would have been updated. Output received was " + out,
        out.contains(String.format(
            "Updated database %s", DatabaseName.of(projectId, instanceId, databaseId))));

    // Cleanup
    final com.google.spanner.admin.database.v1.Database database =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(DatabaseName.of(projectId, instanceId, databaseId).toString())
            .setEnableDropProtection(false).build();
    final UpdateDatabaseRequest updateDatabaseRequest =
        UpdateDatabaseRequest.newBuilder()
            .setDatabase(database)
            .setUpdateMask(
                FieldMask.newBuilder().addAllPaths(
                    Lists.newArrayList("enable_drop_protection")).build())
            .build();

    OperationFuture<Database, UpdateDatabaseMetadata> operation =
        databaseAdminClient.updateDatabaseAsync(updateDatabaseRequest);
    Database updatedDb = operation.get(5, TimeUnit.MINUTES);
    assertFalse(updatedDb.getEnableDropProtection());
  }
}
