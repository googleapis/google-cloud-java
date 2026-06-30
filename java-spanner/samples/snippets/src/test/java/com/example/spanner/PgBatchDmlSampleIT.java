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

package com.example.spanner;

import static org.junit.Assert.assertTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import org.junit.Test;

public class PgBatchDmlSampleIT extends SampleTestBase {

  @Test
  public void testPgBatchDml() throws Exception {
    final String databaseId = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            databaseAdminClient
                .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
                .setDialect(Dialect.POSTGRESQL)
                .build(),
            Collections.emptyList())
        .get();
    final OperationFuture<Void, UpdateDatabaseDdlMetadata> updateOperation =
        databaseAdminClient.updateDatabaseDdl(
            instanceId,
            databaseId,
            Collections.singleton(
                "CREATE TABLE Singers ("
                    + "  SingerId   bigint NOT NULL PRIMARY KEY,"
                    + "  FirstName  varchar(1024),"
                    + "  LastName   varchar(1024)"
                    + ")"),
            null);
    updateOperation.get();

    final String out =
        SampleRunner.runSample(() -> PgBatchDmlSample.batchDml(projectId, instanceId, databaseId));

    assertTrue(out.contains("Inserted 2 singers"));
  }
}