/*
 * Copyright 2020 Google LLC
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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITPitrUpdateDatabaseTest {

  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(20);
  private static final String VERSION_RETENTION_PERIOD = "7d";

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseAdminClient dbAdminClient;
  private static DatabaseClient dbClient;
  private static String instanceId;
  private static String databaseId;
  private static UpdateDatabaseDdlMetadata metadata;

  @BeforeClass
  public static void setUp() throws Exception {
    assumeFalse("PITR-lite features are not supported by the emulator", isUsingEmulator());

    final RemoteSpannerHelper testHelper = env.getTestHelper();
    final String projectId = testHelper.getOptions().getProjectId();
    instanceId = testHelper.getInstanceId().getInstance();
    databaseId = testHelper.getUniqueDatabaseId();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();

    createDatabase(dbAdminClient, instanceId, databaseId, Collections.emptyList());
    metadata =
        updateVersionRetentionPeriod(
            dbAdminClient, instanceId, databaseId, VERSION_RETENTION_PERIOD);

    dbClient =
        testHelper.getClient().getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
  }

  @AfterClass
  public static void tearDown() {
    if (!isUsingEmulator()) {
      dbAdminClient.dropDatabase(instanceId, databaseId);
    }
  }

  @Test
  public void checksThatTheOperationWasNotThrottled() {
    assertThat(metadata.getThrottled()).isFalse();
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughGetDatabase() {
    final Database database = dbAdminClient.getDatabase(instanceId, databaseId);

    assertThat(database.getVersionRetentionPeriod()).isEqualTo(VERSION_RETENTION_PERIOD);
    assertThat(database.getEarliestVersionTime()).isNotNull();
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughListDatabases() {
    final Page<Database> page = dbAdminClient.listDatabases(instanceId);

    for (Database database : page.iterateAll()) {
      if (!database.getId().getDatabase().equals(databaseId)) {
        continue;
      }
      assertThat(database.getVersionRetentionPeriod()).isEqualTo(VERSION_RETENTION_PERIOD);
      assertThat(database.getEarliestVersionTime()).isNotNull();
    }
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughGetDatabaseDdl() {
    final List<String> ddls = dbAdminClient.getDatabaseDdl(instanceId, databaseId);

    boolean hasVersionRetentionPeriodStatement = false;
    for (String ddl : ddls) {
      hasVersionRetentionPeriodStatement =
          ddl.contains("version_retention_period = '" + VERSION_RETENTION_PERIOD + "'");
      if (hasVersionRetentionPeriodStatement) {
        break;
      }
    }
    assertThat(hasVersionRetentionPeriodStatement).isTrue();
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughInformationSchema() {
    try (final ResultSet rs =
        dbClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT OPTION_VALUE AS version_retention_period "
                        + "FROM INFORMATION_SCHEMA.DATABASE_OPTIONS "
                        + "WHERE SCHEMA_NAME = '' AND OPTION_NAME = 'version_retention_period'"))) {

      String versionRetentionPeriod = null;
      while (rs.next()) {
        versionRetentionPeriod = rs.getString("version_retention_period");
      }

      assertThat(versionRetentionPeriod).isEqualTo(VERSION_RETENTION_PERIOD);
    }
  }

  @Test
  public void returnsAnErrorWhenAnInvalidRetentionPeriodIsGiven() {
    try {
      dbAdminClient
          .updateDatabaseDdl(
              instanceId,
              databaseId,
              Collections.singletonList(
                  "ALTER DATABASE "
                      + databaseId
                      + " SET OPTIONS (version_retention_period = '0d')"),
              "op_invalid_retention_period_" + databaseId)
          .get(OPERATION_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
      fail("Expected invalid argument error when setting invalid version retention period");
    } catch (Exception e) {
      SpannerException spannerException = (SpannerException) e.getCause();
      assertThat(spannerException.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }

    final Database database = dbAdminClient.getDatabase(instanceId, databaseId);

    assertThat(database.getVersionRetentionPeriod()).isEqualTo(VERSION_RETENTION_PERIOD);
    assertThat(database.getEarliestVersionTime()).isNotNull();
  }

  private static Database createDatabase(
      final DatabaseAdminClient dbAdminClient,
      final String instanceId,
      final String databaseId,
      final Iterable<String> extraStatements)
      throws Exception {
    return dbAdminClient
        .createDatabase(instanceId, databaseId, extraStatements)
        .get(OPERATION_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
  }

  private static UpdateDatabaseDdlMetadata updateVersionRetentionPeriod(
      final DatabaseAdminClient dbAdminClient,
      final String instanceId,
      final String databaseId,
      final String versionRetentionPeriod)
      throws Exception {
    final OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        dbAdminClient.updateDatabaseDdl(
            instanceId,
            databaseId,
            Collections.singletonList(
                "ALTER DATABASE "
                    + databaseId
                    + " SET OPTIONS ( version_retention_period = '"
                    + versionRetentionPeriod
                    + "' )"),
            "updateddl_version_retention_period");
    op.get(OPERATION_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
    return op.getMetadata().get(OPERATION_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
  }
}
