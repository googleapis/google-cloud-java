/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.Page;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Operation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link com.google.cloud.spanner.DatabaseAdminClient}. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDatabaseAdminTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private DatabaseAdminClient dbAdminClient;
  private RemoteSpannerHelper testHelper;
  private List<Database> dbs = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    testHelper = env.getTestHelper();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
  }

  @After
  public void tearDown() throws Exception {
    for (Database db : dbs) {
      db.drop();
    }
    dbs.clear();
  }

  @Test
  public void databaseOperations() throws Exception {
    String dbId = testHelper.getUniqueDatabaseId();
    String instanceId = testHelper.getInstanceId().getInstance();
    String statement1 = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";
    Operation<Database, CreateDatabaseMetadata> op =
        dbAdminClient.createDatabase(instanceId, dbId, ImmutableList.of(statement1));
    op = op.waitFor();
    Database db = op.getResult();
    dbs.add(db);
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    db = dbAdminClient.getDatabase(instanceId, dbId);
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    boolean foundDb = false;
    for (Database dbInList :
        Iterators.toArray(dbAdminClient.listDatabases(instanceId).iterateAll(), Database.class)) {
      if (dbInList.getId().getDatabase().equals(dbId)) {
        foundDb = true;
        break;
      }
    }
    assertThat(foundDb).isTrue();

    String statement2 = "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    Operation<?, ?> op2 =
        dbAdminClient.updateDatabaseDdl(instanceId, dbId, ImmutableList.of(statement2), null);
    op2.waitFor();
    List<String> statementsInDb = dbAdminClient.getDatabaseDdl(instanceId, dbId);
    assertThat(statementsInDb).containsExactly(statement1, statement2);

    dbAdminClient.dropDatabase(instanceId, dbId);
    dbs.clear();
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    db = dbAdminClient.getDatabase(testHelper.getInstanceId().getInstance(), dbId);
  }

  @Test
  public void updateDdlRetry() throws Exception {
    String dbId = testHelper.getUniqueDatabaseId();
    String instanceId = testHelper.getInstanceId().getInstance();
    String statement1 = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";
    Operation<Database, CreateDatabaseMetadata> op =
        dbAdminClient.createDatabase(instanceId, dbId, ImmutableList.of(statement1));
    op = op.waitFor();
    Database db = op.getResult();
    dbs.add(db);
    String statement2 = "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    Operation<Void, UpdateDatabaseDdlMetadata> op1 =
        dbAdminClient.updateDatabaseDdl(instanceId, dbId, ImmutableList.of(statement2), "myop");
    Operation<Void, UpdateDatabaseDdlMetadata> op2 =
        dbAdminClient.updateDatabaseDdl(instanceId, dbId, ImmutableList.of(statement2), "myop");
    op1 = op1.waitFor();
    op2 = op2.waitFor();
    assertThat(op1.getMetadata()).isEqualTo(op2.getMetadata());
  }

  @Test
  public void databaseOperationsViaEntity() throws Exception {
    String dbId = testHelper.getUniqueDatabaseId();
    String instanceId = testHelper.getInstanceId().getInstance();
    String statement1 = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";
    Operation<Database, CreateDatabaseMetadata> op =
        dbAdminClient.createDatabase(instanceId, dbId, ImmutableList.of(statement1));
    op = op.waitFor();
    Database db = op.getResult();
    dbs.add(db);
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    db = db.reload();
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    String statement2 = "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    Operation<?, ?> op2 = db.updateDdl(ImmutableList.of(statement2), null);
    op2.waitFor();
    Iterable<String> statementsInDb = db.getDdl();
    assertThat(statementsInDb).containsExactly(statement1, statement2);

    db.drop();
    dbs.clear();
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    db.reload();
  }

  @Test
  public void listPagination() throws Exception {
    List<String> dbIds =
        ImmutableList.of(
            testHelper.getUniqueDatabaseId(),
            testHelper.getUniqueDatabaseId(),
            testHelper.getUniqueDatabaseId());

    String instanceId = testHelper.getInstanceId().getInstance();
    for (String dbId : dbIds) {
      dbAdminClient.createDatabase(instanceId, dbId, ImmutableList.<String>of()).waitFor();
    }
    Page<Database> page = dbAdminClient.listDatabases(instanceId, Options.pageSize(1));
    List<String> dbIdsGot = new ArrayList<>();
    while (page != null) {
      Database db = Iterables.getOnlyElement(page.getValues());
      dbs.add(db);
      dbIdsGot.add(db.getId().getDatabase());
      page = page.getNextPage();
    }
    assertThat(dbIdsGot).containsAllIn(dbIds);
  }
}
