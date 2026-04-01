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

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.DatabaseNotFoundException;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITPitrCreateDatabaseTest {

  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(2);
  private static final String VERSION_RETENTION_PERIOD = "7d";

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private RemoteSpannerHelper testHelper;
  private DatabaseAdminClient dbAdminClient;
  private List<Database> databasesToDrop;

  @BeforeClass
  public static void doNotRunOnEmulator() {
    assumeFalse("PITR-lite features are not supported by the emulator", isUsingEmulator());
  }

  @Before
  public void setUp() {
    testHelper = env.getTestHelper();
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
    databasesToDrop = new ArrayList<>();
  }

  @After
  public void tearDown() {
    for (Database database : databasesToDrop) {
      final DatabaseId id = database.getId();
      dbAdminClient.dropDatabase(id.getInstanceId().getInstance(), id.getDatabase());
    }
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughCreateDatabase() throws Exception {
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final String extraStatement =
        "ALTER DATABASE "
            + databaseId
            + " SET OPTIONS (version_retention_period = '"
            + VERSION_RETENTION_PERIOD
            + "')";

    final Database database = createDatabase(instanceId, databaseId, extraStatement);

    assertThat(database.getVersionRetentionPeriod()).isEqualTo(VERSION_RETENTION_PERIOD);
    assertThat(database.getEarliestVersionTime()).isNotNull();
  }

  @Test
  public void returnsTheVersionRetentionPeriodSetThroughGetDatabase() throws Exception {
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final String extraStatement =
        "ALTER DATABASE "
            + databaseId
            + " SET OPTIONS (version_retention_period = '"
            + VERSION_RETENTION_PERIOD
            + "')";

    createDatabase(instanceId, databaseId, extraStatement);
    final Database database = dbAdminClient.getDatabase(instanceId, databaseId);

    assertThat(database.getVersionRetentionPeriod()).isEqualTo(VERSION_RETENTION_PERIOD);
    assertThat(database.getEarliestVersionTime()).isNotNull();
  }

  @Test(expected = DatabaseNotFoundException.class)
  public void returnsAnErrorWhenAnInvalidVersionRetentionPeriodIsGiven() {
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final String extraStatement =
        "ALTER DATABASE " + databaseId + " SET OPTIONS (version_retention_period = '0d')";

    try {
      createDatabase(instanceId, databaseId, extraStatement);
      fail("Expected invalid argument error when setting invalid version retention period");
    } catch (Exception e) {
      SpannerException spannerException = (SpannerException) e.getCause();
      assertThat(spannerException.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }

    // Expects a database not found exception
    dbAdminClient.getDatabase(instanceId, databaseId);
  }

  private Database createDatabase(
      final String instanceId, final String databaseId, final String extraStatement)
      throws Exception {
    final Database database =
        dbAdminClient
            .createDatabase(instanceId, databaseId, Collections.singletonList(extraStatement))
            .get(OPERATION_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
    databasesToDrop.add(database);

    return database;
  }
}
