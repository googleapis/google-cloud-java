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
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Mutation;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class PgPartitionedDmlSampleIT extends SampleTestBase {

  @Test
  public void testPgPartitionedDml() throws Exception {
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
                "CREATE TABLE users ("
                    + "  user_id   bigint NOT NULL PRIMARY KEY,"
                    + "  user_name varchar(1024),"
                    + "  active    boolean"
                    + ")"),
            null);
    updateOperation.get();
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
    client.write(
        Arrays.asList(
            Mutation.newInsertBuilder("users")
                .set("user_id")
                .to(1L)
                .set("user_name")
                .to("user1")
                .set("active")
                .to(false)
                .build(),
            Mutation.newInsertBuilder("users")
                .set("user_id")
                .to(2L)
                .set("user_name")
                .to("user2")
                .set("active")
                .to(false)
                .build(),
            Mutation.newInsertBuilder("users")
                .set("user_id")
                .to(3L)
                .set("user_name")
                .to("user3")
                .set("active")
                .to(true)
                .build()));

    final String out =
        SampleRunner.runSample(
            () -> PgPartitionedDmlSample.partitionedDml(projectId, instanceId, databaseId));

    assertTrue(out.contains("Deleted at least 2 inactive users"));
  }
}