/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseInfo.DatabaseField;
import com.google.cloud.spanner.DatabaseRole;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for {@link com.google.cloud.spanner.DatabaseAdminClient}. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDatabaseAdminTest {
  private static final long TIMEOUT_MINUTES = 5;
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private static final Logger logger = Logger.getLogger(ITDatabaseAdminTest.class.getName());
  private DatabaseAdminClient dbAdminClient;
  private RemoteSpannerHelper testHelper;

  @Before
  public void setUp() {
    testHelper = env.getTestHelper();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
  }

  @Test
  public void testDatabaseOperations() throws Exception {
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String createTableT = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";

    final Database createdDatabase = testHelper.createTestDatabase(createTableT);
    final String databaseId = createdDatabase.getId().getDatabase();

    assertEquals(databaseId, createdDatabase.getId().getDatabase());
    assertEquals(Dialect.GOOGLE_STANDARD_SQL, createdDatabase.getDialect());

    final Database retrievedDatabase = dbAdminClient.getDatabase(instanceId, databaseId);
    assertEquals(databaseId, retrievedDatabase.getId().getDatabase());
    assertEquals(Dialect.GOOGLE_STANDARD_SQL, retrievedDatabase.getDialect());

    Optional<Database> maybeDatabaseInList = Optional.empty();
    for (Database listedDatabase : dbAdminClient.listDatabases(instanceId).iterateAll()) {
      if (listedDatabase.getId().getDatabase().equals(databaseId)) {
        maybeDatabaseInList = Optional.of(listedDatabase);
        break;
      }
    }
    assertTrue("Expected to find database in list", maybeDatabaseInList.isPresent());
    assertEquals(databaseId, maybeDatabaseInList.get().getId().getDatabase());
    assertEquals(Dialect.GOOGLE_STANDARD_SQL, maybeDatabaseInList.get().getDialect());

    final String createTableT2 =
        "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    dbAdminClient
        .updateDatabaseDdl(instanceId, databaseId, ImmutableList.of(createTableT2), null)
        .get(5, TimeUnit.MINUTES);

    final List<String> databaseDdl = dbAdminClient.getDatabaseDdl(instanceId, databaseId);
    assertEquals(databaseDdl, ImmutableList.of(createTableT, createTableT2));

    dbAdminClient.dropDatabase(instanceId, databaseId);

    try {
      dbAdminClient.getDatabase(instanceId, databaseId);
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.NOT_FOUND, e.getErrorCode());
    }
  }

  @Test
  public void updateDdlRetry() throws Exception {
    String instanceId = testHelper.getInstanceId().getInstance();
    String statement1 = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";
    Database db = testHelper.createTestDatabase(statement1);
    String dbId = db.getId().getDatabase();

    String statement2 = "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op1 =
        dbAdminClient.updateDatabaseDdl(instanceId, dbId, ImmutableList.of(statement2), "myop");
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op2 =
        dbAdminClient.updateDatabaseDdl(instanceId, dbId, ImmutableList.of(statement2), "myop");
    op1.get(TIMEOUT_MINUTES, TimeUnit.MINUTES);
    op2.get(TIMEOUT_MINUTES, TimeUnit.MINUTES);

    // Remove the progress list from the metadata before comparing, as there could be small
    // differences between the two in the reported progress depending on exactly when each
    // operation was fetched from the backend.
    UpdateDatabaseDdlMetadata metadata1 =
        op1.getMetadata().get().toBuilder().clearProgress().build();
    UpdateDatabaseDdlMetadata metadata2 =
        op2.getMetadata().get().toBuilder().clearProgress().build();
    assertThat(metadata1).isEqualTo(metadata2);
  }

  @Test
  public void databaseOperationsViaEntity() throws Exception {
    String statement1 = "CREATE TABLE T (\n" + "  K STRING(MAX),\n" + ") PRIMARY KEY(K)";
    Database db = testHelper.createTestDatabase(statement1);
    String dbId = db.getId().getDatabase();
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    db = db.reload();
    assertThat(db.getId().getDatabase()).isEqualTo(dbId);

    String statement2 = "CREATE TABLE T2 (\n" + "  K2 STRING(MAX),\n" + ") PRIMARY KEY(K2)";
    OperationFuture<?, ?> op2 = db.updateDdl(ImmutableList.of(statement2), null);
    op2.get(TIMEOUT_MINUTES, TimeUnit.MINUTES);
    Iterable<String> statementsInDb = db.getDdl();
    assertThat(statementsInDb).containsExactly(statement1, statement2);
    db.drop();
    try {
      db.reload();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
    }
  }

  @Test
  public void listPagination() {
    String instanceId = testHelper.getInstanceId().getInstance();
    List<String> dbIds = new ArrayList<>(3);
    for (int n = 0; n < 3; n++) {
      dbIds.add(testHelper.createTestDatabase().getId().getDatabase());
    }
    Page<Database> page = dbAdminClient.listDatabases(instanceId, Options.pageSize(1));
    List<String> dbIdsGot = new ArrayList<>();
    // A valid page will contain 0 or 1 elements.
    while (page != null && page.getValues().iterator().hasNext()) {
      Database db = Iterables.getOnlyElement(page.getValues());
      dbIdsGot.add(db.getId().getDatabase());
      // page.getNextPage() will return null if the previous call did not return a 'nextPageToken'.
      // That is an indication that the server knows that there are no more results. The method may
      // however also return a page with zero results. That happens if there was another result on
      // the server when the previous call was executed (and returned a nextPageToken), but that
      // result has been deleted in the meantime.
      page = page.getNextPage();
    }
    assertThat(dbIdsGot).containsAtLeastElementsIn(dbIds);
  }

  @Test
  public void createAndListDatabaseRoles() throws Exception {
    assumeFalse("Experimental Host does not support database roles", isExperimentalHost());
    assumeFalse("Emulator does not support create & list database roles", isUsingEmulator());
    List<String> dbRoles =
        ImmutableList.of(
            testHelper.getUniqueDatabaseRole(),
            testHelper.getUniqueDatabaseRole(),
            testHelper.getUniqueDatabaseRole());

    String instanceId = testHelper.getInstanceId().getInstance();
    Database database = testHelper.createTestDatabase();

    // Create the roles in Db.
    List<String> dbRolesCreateStatements = new ArrayList<>();
    for (String dbRole : dbRoles) {
      dbRolesCreateStatements.add(String.format("CREATE ROLE %s", dbRole));
    }
    dbAdminClient
        .updateDatabaseDdl(
            instanceId, database.getId().getDatabase(), dbRolesCreateStatements, null)
        .get();

    // List roles from Db.
    Page<DatabaseRole> page =
        dbAdminClient.listDatabaseRoles(instanceId, database.getId().getDatabase());
    List<String> dbRolesGot = new ArrayList<>();
    while (page != null && page.getValues().iterator().hasNext()) {
      for (DatabaseRole value : page.getValues()) {
        String[] split = value.getName().split("/");
        dbRolesGot.add(split[split.length - 1]);
      }
      page = page.getNextPage();
    }
    assertThat(dbRolesGot).containsAtLeastElementsIn(dbRoles);

    // Delete the created roles.
    List<String> dbRolesDropStatements = new ArrayList<>();
    for (String dbRole : dbRoles) {
      dbRolesDropStatements.add(String.format("DROP ROLE %s", dbRole));
    }
    dbAdminClient
        .updateDatabaseDdl(instanceId, database.getId().getDatabase(), dbRolesDropStatements, null)
        .get();

    // List roles from Db. Deleted roles should not be present in list.
    Page<DatabaseRole> pageRemainingRoles =
        dbAdminClient.listDatabaseRoles(instanceId, database.getId().getDatabase());
    List<String> dbRolesRemaining = new ArrayList<>();
    while (pageRemainingRoles != null && pageRemainingRoles.getValues().iterator().hasNext()) {
      for (DatabaseRole value : pageRemainingRoles.getValues()) {
        String[] split = value.getName().split("/");
        dbRolesRemaining.add(split[split.length - 1]);
      }
      pageRemainingRoles = pageRemainingRoles.getNextPage();
    }
    assertThat(dbRolesRemaining).containsNoneIn(dbRoles);
  }

  @Test
  public void updateDatabaseInvalidFieldsToUpdate() {
    assumeFalse("Emulator does not drop database protection", isUsingEmulator());
    Database database = testHelper.createTestDatabase();
    logger.log(Level.INFO, "Created database: {0}", database.getId().getName());

    Database databaseToUpdate =
        dbAdminClient.newDatabaseBuilder(database.getId()).enableDropProtection().build();
    // Don't provide any fields to update.
    OperationFuture<Database, UpdateDatabaseMetadata> op =
        dbAdminClient.updateDatabase(databaseToUpdate);

    try {
      op.get(5, TimeUnit.MINUTES);
      Assert.fail("No exception thrown");
    } catch (ExecutionException | InterruptedException | TimeoutException e) {
      Assert.assertTrue(e.getCause() instanceof SpannerException);
      SpannerException exception = ((SpannerException) e.getCause());
      assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    }
  }

  @Test
  public void dropDatabaseWithProtectionEnabled() throws Exception {
    assumeFalse("Tracking the failure via b/441255724", isExperimentalHost());
    assumeFalse("Emulator does not drop database protection", isUsingEmulator());
    String instanceId = testHelper.getInstanceId().getInstance();
    Database database = testHelper.createTestDatabase();
    logger.log(Level.INFO, "Created database: {0}", database.getId().getName());

    // Enable drop protection for the database.
    Database databaseToUpdate =
        dbAdminClient.newDatabaseBuilder(database.getId()).enableDropProtection().build();
    OperationFuture<Database, UpdateDatabaseMetadata> op =
        dbAdminClient.updateDatabase(databaseToUpdate, DatabaseField.DROP_PROTECTION);
    Database updatedDatabase = op.get(5, TimeUnit.MINUTES);
    assertEquals(updatedDatabase.getId().getName(), database.getId().getName());
    assertTrue(updatedDatabase.isDropProtectionEnabled());

    String databaseId = database.getId().getDatabase();

    // Assert that dropping a database with protection enabled fails due to precondition violation.
    SpannerException e =
        assertThrows(
            SpannerException.class, () -> dbAdminClient.dropDatabase(instanceId, databaseId));
    assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());

    // Assert that deleting the instance also fails due to precondition violation.
    e =
        assertThrows(
            SpannerException.class,
            () -> testHelper.getClient().getInstanceAdminClient().deleteInstance(instanceId));
    assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());

    // Disable drop protection for the database.
    databaseToUpdate =
        dbAdminClient.newDatabaseBuilder(database.getId()).disableDropProtection().build();
    op = dbAdminClient.updateDatabase(databaseToUpdate, DatabaseField.DROP_PROTECTION);
    updatedDatabase = op.get(5, TimeUnit.MINUTES);
    assertEquals(updatedDatabase.getId().getName(), database.getId().getName());
    assertFalse(updatedDatabase.isDropProtectionEnabled());

    // Dropping the database should succeed now.
    dbAdminClient.dropDatabase(instanceId, databaseId);
  }
}
