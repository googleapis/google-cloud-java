/*
 * Copyright 2025 Google LLC
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

import static com.example.spanner.SampleRunner.runSample;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link PgLastStatementSample} */
@RunWith(JUnit4.class)
public class PgLastStatementSampleIT extends SampleTestBase {

  private static DatabaseId databaseId;

  @BeforeClass
  public static void createTestDatabase() throws Exception {
    final String database = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            databaseAdminClient
                .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, database))
                .setDialect(Dialect.POSTGRESQL)
                .build(),
            Collections.emptyList())
        .get(10, TimeUnit.MINUTES);
    final OperationFuture<Void, UpdateDatabaseDdlMetadata> updateOperation =
        databaseAdminClient.updateDatabaseDdl(
            instanceId,
            database,
            ImmutableList.of(
                "CREATE TABLE Singers ("
                    + "  SingerId   bigint NOT NULL,"
                    + "  FirstName  character varying(1024),"
                    + "  LastName   character varying(1024),"
                    + "  PRIMARY KEY (SingerId)"
                    + ")"),
            null);
    updateOperation.get(10, TimeUnit.MINUTES);
    databaseId = DatabaseId.of(projectId, instanceId, database);
  }

  @Test
  public void testSetLastStatementOptionSample() throws Exception {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    String out = runSample(() -> PgLastStatementSample.insertAndUpdateUsingLastStatement(client));
    assertThat(out).contains("New singer inserted.");
    assertThat(out).contains("Singer last name updated.");
  }
}
