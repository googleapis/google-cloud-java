/*
 * Copyright 2026 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.util.Collections;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Integration tests for {@link DatabaseClient#getDatabaseDefaultIsolationLevel()}. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITDatabaseDefaultIsolationLevelTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Test
  public void testDefaultIsolationLevelWhenOptionIsNotSet() {
    RemoteSpannerHelper testHelper = env.getTestHelper();
    Database database = testHelper.createTestDatabase(dialect, Collections.emptyList());
    DatabaseClient client = testHelper.getDatabaseClient(database);

    assertEquals(
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, client.getDatabaseDefaultIsolationLevel());
    assertEquals(dialect, client.getDialect());
  }

  @Test
  public void testDefaultIsolationLevelRepeatableRead() throws Exception {
    assumeFalse(
        "The emulator does not support the default_transaction_isolation option",
        isUsingEmulator());
    RemoteSpannerHelper testHelper = env.getTestHelper();
    Database database = testHelper.createTestDatabase(dialect, Collections.emptyList());
    String databaseId = database.getId().getDatabase();
    String alterDatabase =
        dialect == Dialect.POSTGRESQL
            ? "ALTER DATABASE "
                + databaseId
                + " SET default_transaction_isolation TO 'repeatable read'"
            : "ALTER DATABASE "
                + databaseId
                + " SET OPTIONS (default_transaction_isolation = 'repeatable read')";
    testHelper
        .getClient()
        .getDatabaseAdminClient()
        .updateDatabaseDdl(
            testHelper.getInstanceId().getInstance(),
            databaseId,
            Collections.singletonList(alterDatabase),
            null)
        .get();

    // The client is created after the option has been set, so it reads the new value.
    DatabaseClient client = testHelper.getDatabaseClient(database);
    assertEquals(IsolationLevel.REPEATABLE_READ, client.getDatabaseDefaultIsolationLevel());
    assertEquals(dialect, client.getDialect());
  }
}
