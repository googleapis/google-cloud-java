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

import static com.example.spanner.SampleRunner.runSample;
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

/** Integration tests for DML Returning samples for GoogleStandardSql dialect. */
@RunWith(JUnit4.class)
public class DmlReturningSampleIT extends SampleTestBase {

  private static DatabaseId databaseId;

  @BeforeClass
  public static void createTestDatabase() throws Exception {
    final String database = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            instanceId,
            database,
            ImmutableList.of(
                "CREATE TABLE Singers ("
                    + "  SingerId   INT64 NOT NULL,"
                    + "  FirstName  STRING(1024),"
                    + "  LastName   STRING(1024),"
                    + "  SingerInfo BYTES(MAX),"
                    + "  FullName STRING(2048) AS "
                    + "  (ARRAY_TO_STRING([FirstName, LastName], \" \")) STORED"
                    + ") PRIMARY KEY (SingerId)",
                "CREATE TABLE Albums ("
                    + "  SingerId     INT64 NOT NULL,"
                    + "  AlbumId      INT64 NOT NULL,"
                    + "  AlbumTitle   STRING(MAX),"
                    + "  MarketingBudget INT64"
                    + ") PRIMARY KEY (SingerId, AlbumId),"
                    + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE"))
        .get(10, TimeUnit.MINUTES);
    databaseId = DatabaseId.of(projectId, instanceId, database);
  }

  @Before
  public void insertTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(
        Arrays.asList(
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(1L)
                .set("FirstName")
                .to("Alice")
                .set("LastName")
                .to("Trentor")
                .build(),
            Mutation.newInsertOrUpdateBuilder("Albums")
                .set("SingerId")
                .to(1L)
                .set("AlbumId")
                .to(1L)
                .set("AlbumTitle")
                .to("title 1")
                .set("MarketingBudget")
                .to(20000L)
                .build()));
  }

  @After
  public void removeTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(Collections.singletonList(Mutation.delete("Singers", KeySet.all())));
  }

  @Test
  public void testInsertUsingReturningSample() throws Exception {
    final String out =
        runSample(
            () ->
                InsertUsingDmlReturningSample.insertUsingDmlReturning(
                    projectId, instanceId, databaseId.getDatabase()));
    assertTrue(out.contains("Inserted row(s) count: 4"));
    assertTrue(out.contains("Melissa Garcia"));
    assertTrue(out.contains("Russell Morales"));
    assertTrue(out.contains("Jacqueline Long"));
    assertTrue(out.contains("Dylan Shaw"));
  }

  @Test
  public void testUpdateUsingReturningSample() throws Exception {
    final String out =
        runSample(
            () ->
                UpdateUsingDmlReturningSample.updateUsingDmlReturning(
                    projectId, instanceId, databaseId.getDatabase()));
    assertTrue(out.contains("Updated row(s) count: 1"));
    assertTrue(out.contains("40000"));
  }

  @Test
  public void testDeleteUsingReturningSample() throws Exception {
    final String out =
        runSample(
            () ->
                DeleteUsingDmlReturningSample.deleteUsingDmlReturningSample(
                    projectId, instanceId, databaseId.getDatabase()));
    assertTrue(out.contains("Deleted row(s) count: 1"));
    assertTrue(out.contains("Alice Trentor"));
  }
}
