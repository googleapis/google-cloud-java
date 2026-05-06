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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Integration tests for Role Permissions using {@link com.google.cloud.spanner.DatabaseRole}. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITDatabaseRolePermissionTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseAdminClient dbAdminClient;
  private static RemoteSpannerHelper testHelper;

  private static List<DatabaseId> databasesToDrop;

  @Parameter public DialectTestParameter dialect;

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    return ImmutableList.of(
        new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL),
        new DialectTestParameter(Dialect.POSTGRESQL));
  }

  @BeforeClass
  public static void setUp() {
    assumeFalse("Experimental Host does not support database roles", isExperimentalHost());
    assumeFalse("Emulator does not support database roles", isUsingEmulator());
    testHelper = env.getTestHelper();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
    databasesToDrop = new ArrayList<>();
  }

  @AfterClass
  public static void cleanup() throws Exception {
    if (databasesToDrop != null) {
      for (DatabaseId id : databasesToDrop) {
        try {
          dbAdminClient.dropDatabase(id.getInstanceId().getInstance(), id.getDatabase());
        } catch (Exception e) {
          System.err.println("Failed to drop database " + id + ", skipping...: " + e.getMessage());
        }
      }
    }
  }

  @Test
  public void grantAndRevokeDatabaseRolePermissions() throws Exception {
    // Create database with table and role permission.
    final String dbRoleParent = "parent";
    final String databaseId = testHelper.getUniqueDatabaseId();
    final InstanceId instanceId = testHelper.getInstanceId();

    final String createTableT = getCreateTableStatement();
    final String createRoleParent = String.format("CREATE ROLE %s", dbRoleParent);
    final String grantSelectOnTableToParent =
        dialect.dialect == Dialect.POSTGRESQL
            ? String.format("GRANT SELECT ON TABLE T TO %s", dbRoleParent)
            : String.format("GRANT SELECT ON TABLE T TO ROLE %s", dbRoleParent);
    final Database createdDatabase =
        createAndUpdateDatabase(
            instanceId,
            databaseId,
            ImmutableList.of(createTableT, createRoleParent, grantSelectOnTableToParent));

    // Connect to db with dbRoleParent.
    SpannerOptions options =
        testHelper.getOptions().toBuilder().setDatabaseRole(dbRoleParent).build();

    Spanner spanner = options.getService();
    DatabaseClient dbClient = spanner.getDatabaseClient(createdDatabase.getId());

    // Test SELECT permissions to role dbRoleParent on table T.
    // Query using dbRoleParent should return result.
    try (ResultSet rs =
        dbClient.singleUse().executeQuery(Statement.of("SELECT COUNT(*) as cnt FROM T"))) {
      assertTrue(rs.next());
      assertEquals(dbClient.getDatabaseRole(), dbRoleParent);
    } catch (PermissionDeniedException e) {
      // This is not expected
      fail("Got PermissionDeniedException when it should not have occurred.");
    }

    // Revoke select Permission for dbRoleParent.
    final String revokeSelectOnTableFromParent =
        dialect.dialect == Dialect.POSTGRESQL
            ? String.format("REVOKE SELECT ON TABLE T FROM %s", dbRoleParent)
            : String.format("REVOKE SELECT ON TABLE T FROM ROLE %s", dbRoleParent);

    dbAdminClient
        .updateDatabaseDdl(
            instanceId.getInstance(),
            databaseId,
            ImmutableList.of(revokeSelectOnTableFromParent),
            null)
        .get(5, TimeUnit.MINUTES);

    // Test SELECT permissions to role dbRoleParent on table T.
    // Query using dbRoleParent should return PermissionDeniedException.
    try (ResultSet rs =
        dbClient.singleUse().executeQuery(Statement.of("SELECT COUNT(*) as cnt FROM T"))) {
      SpannerException e = assertThrows(SpannerException.class, () -> rs.next());
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.PERMISSION_DENIED);
      assertThat(e.getMessage()).contains(dbRoleParent);
    }
    // Drop role and table.
    final String dropTableT = "DROP TABLE T";
    final String dropRoleParent = String.format("DROP ROLE %s", dbRoleParent);
    dbAdminClient
        .updateDatabaseDdl(
            instanceId.getInstance(),
            databaseId,
            ImmutableList.of(dropTableT, dropRoleParent),
            null)
        .get(5, TimeUnit.MINUTES);
    databasesToDrop.add(createdDatabase.getId());
  }

  @Test
  public void roleWithNoPermissions() throws Exception {
    final String dbRoleOrphan = testHelper.getUniqueDatabaseRole();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final InstanceId instanceId = testHelper.getInstanceId();

    final String createTableT = getCreateTableStatement();
    final String createRoleOrphan = String.format("CREATE ROLE %s", dbRoleOrphan);

    final Database createdDatabase =
        createAndUpdateDatabase(
            instanceId, databaseId, ImmutableList.of(createTableT, createRoleOrphan));

    // Connect to db with dbRoleOrphan
    SpannerOptions options =
        testHelper.getOptions().toBuilder().setDatabaseRole(dbRoleOrphan).build();

    Spanner spanner = options.getService();
    DatabaseClient dbClient = spanner.getDatabaseClient(createdDatabase.getId());

    // Test SELECT permissions to role dbRoleOrphan on table T.
    // Query using dbRoleOrphan should return PermissionDeniedException.
    try (ResultSet rs =
        dbClient.singleUse().executeQuery(Statement.of("SELECT COUNT(*) as cnt FROM T"))) {
      SpannerException e = assertThrows(SpannerException.class, () -> rs.next());
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.PERMISSION_DENIED);
      assertThat(e.getMessage()).contains(dbRoleOrphan);
    }
    // Drop role and table.
    final String dropTableT = "DROP TABLE T";
    final String dropRoleParent = String.format("DROP ROLE %s", dbRoleOrphan);
    dbAdminClient
        .updateDatabaseDdl(
            instanceId.getInstance(), databaseId, Arrays.asList(dropTableT, dropRoleParent), null)
        .get(5, TimeUnit.MINUTES);
    databasesToDrop.add(createdDatabase.getId());
  }

  private Database createAndUpdateDatabase(
      final InstanceId instanceId, final String databaseId, final List<String> statements)
      throws Exception {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      // DDL statements other than <CREATE DATABASE> are not allowed in database creation request
      // for PostgreSQL-enabled databases.
      final Database database =
          dbAdminClient
              .createDatabase(
                  dbAdminClient
                      .newDatabaseBuilder(DatabaseId.of(instanceId, databaseId))
                      .setDialect(dialect.dialect)
                      .build(),
                  ImmutableList.of())
              .get(5, TimeUnit.MINUTES);
      dbAdminClient
          .updateDatabaseDdl(instanceId.getInstance(), databaseId, statements, null)
          .get(5, TimeUnit.MINUTES);
      return database;
    } else {
      return dbAdminClient
          .createDatabase(
              dbAdminClient
                  .newDatabaseBuilder(DatabaseId.of(instanceId, databaseId))
                  .setDialect(dialect.dialect)
                  .build(),
              statements)
          .get(5, TimeUnit.MINUTES);
    }
  }

  private String getCreateTableStatement() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "CREATE TABLE T (" + "  \"K\"    VARCHAR PRIMARY KEY" + ")";
    } else {
      return "CREATE TABLE T (" + "  K    STRING(MAX)" + ") PRIMARY KEY (K)";
    }
  }
}
