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

package com.example.spanner.admin.archived;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import com.example.spanner.admin.archived.UpdateDatabaseSample;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.DatabaseInfo.DatabaseField;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class UpdateDatabaseSampleIT extends SampleTestBase {

  @Test
  public void testUpdateDatabase() throws Exception {
    // Create database
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(instanceId, databaseId, Collections.emptyList())
        .get(5, TimeUnit.MINUTES);

    // Runs sample
    final String out =
        SampleRunner.runSample(
            () -> UpdateDatabaseSample.updateDatabase(projectId, instanceId, databaseId));

    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
    assertTrue(
        "Expected that database would have been updated. Output received was " + out,
        out.contains(String.format("Updated database %s", dbId)));

    // Cleanup
    Database databaseToUpdate =
        databaseAdminClient.newDatabaseBuilder(dbId).disableDropProtection().build();
    OperationFuture<Database, UpdateDatabaseMetadata> operation =
        databaseAdminClient.updateDatabase(databaseToUpdate, DatabaseField.DROP_PROTECTION);
    Database updatedDb = operation.get(5, TimeUnit.MINUTES);
    assertFalse(updatedDb.isDropProtectionEnabled());
  }
}
