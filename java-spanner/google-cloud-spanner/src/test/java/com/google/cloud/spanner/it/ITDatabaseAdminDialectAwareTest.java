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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Dialect aware integration tests for {@link com.google.cloud.spanner.DatabaseAdminClient}. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITDatabaseAdminDialectAwareTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(20);
  private DatabaseAdminClient client;
  private RemoteSpannerHelper testHelper;
  private List<DatabaseId> databases;

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Before
  public void setUp() {
    testHelper = env.getTestHelper();
    client = testHelper.getClient().getDatabaseAdminClient();
    databases = new ArrayList<>();
  }

  @After
  public void tearDown() {
    if (databases != null) {
      for (DatabaseId id : databases) {
        try {
          client.dropDatabase(id.getInstanceId().getInstance(), id.getDatabase());
        } catch (Exception e) {
          System.err.println("Could not drop database " + id + ", skipping...: " + e.getMessage());
        }
      }
    }
  }

  @Test
  public void testCreateDatabaseWithDialect() throws Exception {
    assumeFalse("emulator does not support different dialects", isUsingEmulator());

    final String projectId = testHelper.getInstanceId().getProject();
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();

    final Database databaseToCreate =
        client
            .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setDialect(dialect)
            .build();
    databases.add(databaseToCreate.getId());

    // Creates the database with the dialect set
    final Database createdDatabase =
        client
            .createDatabase(databaseToCreate, Collections.emptyList())
            .get(OPERATION_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
    assertEquals(dialect, createdDatabase.getDialect());

    // Test dialect in database retrieval
    final Database retrievedDatabase = client.getDatabase(instanceId, databaseId);
    assertEquals(dialect, retrievedDatabase.getDialect());

    // Test dialect database listing
    final Optional<Database> maybeListedDatabase =
        StreamSupport.stream(client.listDatabases(instanceId).iterateAll().spliterator(), false)
            .filter(database -> database.getId().getDatabase().equals(databaseId))
            .findFirst();
    assertTrue("Expected to find database in list", maybeListedDatabase.isPresent());
    assertEquals(dialect, maybeListedDatabase.get().getDialect());
  }
}
