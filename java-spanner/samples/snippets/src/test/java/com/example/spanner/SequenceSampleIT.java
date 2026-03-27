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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.DatabaseDialect;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Integration tests for Bit reversed sequence samples for GoogleStandardSql and PostgreSql
 * dialects.
 */
@RunWith(Parameterized.class)
public class SequenceSampleIT extends SampleTestBaseV2 {

  private static String databaseId;

  /**
   * Set of dialects for which database has already been created in this test suite. This helps in
   * limiting the number of databases created per dialect to one.
   */
  private static final HashSet<DatabaseDialect> dbInitializedDialects = new HashSet<>();

  @Parameters(name = "dialect = {0}")
  public static Iterable<DatabaseDialect> data() {
    return ImmutableList.of(DatabaseDialect.GOOGLE_STANDARD_SQL, DatabaseDialect.POSTGRESQL);
  }

  @Parameter(0)
  public static DatabaseDialect dialect;

  @Before
  public void createTestDatabase() throws Exception {
    // Limits number of created databases to one per dialect.
    if (dbInitializedDialects.contains(dialect)) {
      return;
    }
    dbInitializedDialects.add(dialect);
    databaseId = idGenerator.generateDatabaseId();
    CreateDatabaseRequest createDatabaseRequest =
        CreateDatabaseRequest.newBuilder()
            .setParent(getInstanceName(projectId, instanceId))
            .setCreateStatement(getCreateDatabaseStatement(databaseId, dialect))
            .setDatabaseDialect(dialect).build();
    databaseAdminClient
        .createDatabaseAsync(createDatabaseRequest)
        .get(10, TimeUnit.MINUTES);
  }

  @Test
  public void createSequence() throws Exception {
    String out;
    if (dialect == DatabaseDialect.GOOGLE_STANDARD_SQL) {
      out =
          runSample(
              () ->
                  CreateSequenceSample.createSequence(
                      projectId, instanceId, databaseId));
    } else {
      out =
          runSample(
              () ->
                  PgCreateSequenceSample.pgCreateSequence(
                      projectId, instanceId, databaseId));
    }
    assertTrue(
        out.contains(
            "Created Seq sequence and Customers table, where the key column "
                + "CustomerId uses the sequence as a default value"));
    assertEquals(out.split("Inserted customer record with CustomerId", -1).length - 1, 3);
    assertTrue(out.contains("Number of customer records inserted is: 3"));
  }

  @Test
  public void alterSequence() throws Exception {
    String out;
    if (dialect == DatabaseDialect.GOOGLE_STANDARD_SQL) {
      out =
          runSample(
              () ->
                  AlterSequenceSample.alterSequence(
                      projectId, instanceId, databaseId));
    } else {
      out =
          runSample(
              () ->
                  PgAlterSequenceSample.pgAlterSequence(
                      projectId, instanceId, databaseId));
    }
    assertTrue(
        out.contains("Altered Seq sequence to skip an inclusive range between 1000 and 5000000"));
    assertEquals(out.split("Inserted customer record with CustomerId", -1).length - 1, 3);
    assertTrue(out.contains("Number of customer records inserted is: 3"));
  }

  @Test
  public void dropSequence() throws Exception {
    String out;
    if (dialect == DatabaseDialect.GOOGLE_STANDARD_SQL) {
      out =
          runSample(
              () ->
                  DropSequenceSample.dropSequence(projectId, instanceId, databaseId));
    } else {
      out =
          runSample(
              () ->
                  PgDropSequenceSample.pgDropSequence(
                      projectId, instanceId, databaseId));
    }
    assertTrue(
        out.contains(
            "Altered Customers table to drop DEFAULT from "
                + "CustomerId column and dropped the Seq sequence"));
  }
}
