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

import static com.example.spanner.SampleRunner.runSample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
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

/**
 * Integration tests for {@link TagSample}
 */
@RunWith(JUnit4.class)
public class TagSampleIT extends SampleTestBase {

  private static DatabaseId databaseId;

  @BeforeClass
  public static void createTestDatabase() throws Exception {
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
                    + ") PRIMARY KEY (SingerId, AlbumId)",
                "CREATE TABLE Venues ("
                    + "  VenueId        INT64 NOT NULL,"
                    + "  VenueName      STRING(MAX),"
                    + "  Capacity       INT64,"
                    + "  OutdoorVenue   BOOL,"
                    + "  LastUpdateTime TIMESTAMP OPTIONS (allow_commit_timestamp=true)"
                    + ") PRIMARY KEY  (VenueId)"))
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
            Mutation.newInsertOrUpdateBuilder("Venues")
                .set("VenueId")
                .to(4L)
                .set("VenueName")
                .to("name")
                .set("Capacity")
                .to(4000000)
                .set("OutdoorVenue")
                .to(false)
                .build()));
  }

  @After
  public void removeTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(Collections.singletonList(Mutation.delete("Albums", KeySet.all())));
    client.write(Collections.singleton(Mutation.delete("Venues", KeySet.all())));
  }

  @Test
  public void testSetRequestTag() throws Exception {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);

    final String out = runSample(() -> TagSample.setRequestTag(client));
    assertTrue(out.contains("SingerId: 1, AlbumId: 1, AlbumTitle: title 1"));
  }

  @Test
  public void testSetTransactionTag() throws Exception {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);

    final String out = runSample(() -> TagSample.setTransactionTag(client));
    assertTrue(out.contains("Venue capacities updated."));
    assertTrue(out.contains("New venue inserted."));
  }
}
