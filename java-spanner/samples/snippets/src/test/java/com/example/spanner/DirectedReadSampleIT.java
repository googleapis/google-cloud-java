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

import static com.example.spanner.SampleRunner.runSample;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link DirectedReadSample} */
@RunWith(JUnit4.class)
public class DirectedReadSampleIT extends SampleTestBase {

  private static DatabaseId databaseId;
  private static Spanner spanner;

  @BeforeClass
  public static void createTestDatabase() throws Exception {
    spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
    DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
    final String database = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            instanceId,
            database,
            ImmutableList.of(
                "CREATE TABLE Albums ("
                    + "  SingerId    INT64 NOT NULL,"
                    + "  AlbumId     INT64,"
                    + "  AlbumTitle  STRING(1024)"
                    + ") PRIMARY KEY (SingerId, AlbumId)"))
        .get(10, TimeUnit.MINUTES);
    databaseId = DatabaseId.of(projectId, instanceId, database);
  }

  @Before
  public void insertTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(
        Arrays.asList(
            Mutation.newInsertOrUpdateBuilder("Albums")
                .set("SingerId")
                .to(1L)
                .set("AlbumId")
                .to(1L)
                .set("AlbumTitle")
                .to("title 1")
                .build(),
            Mutation.newInsertOrUpdateBuilder("Albums")
                .set("SingerId")
                .to(2L)
                .set("AlbumId")
                .to(2L)
                .set("AlbumTitle")
                .to("title 2")
                .build()));
  }

  @After
  public void removeTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(Collections.singletonList(Mutation.delete("Albums", KeySet.all())));
  }

  @Test
  public void testDirectedRead() throws Exception {
    final String out =
        runSample(
            () -> DirectedReadSample.directedRead(projectId, instanceId, databaseId.getDatabase()));
    assertTrue(out.contains("SingerId: 1, AlbumId: 1, AlbumTitle: title 1"));
    assertTrue(out.contains("SingerId: 2, AlbumId: 2, AlbumTitle: title 2"));
    assertTrue(
        out.contains("Successfully executed read-only transaction with directedReadOptions"));
  }
}
