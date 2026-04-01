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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITPgNumericTest {

  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(5);

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static RemoteSpannerHelper testHelper;
  private static DatabaseAdminClient databaseAdminClient;
  private static List<DatabaseId> databasesToDrop;
  private static String projectId;
  private static String instanceId;
  private static String databaseId;
  private DatabaseClient databaseClient;
  private String tableName;

  @BeforeClass
  public static void beforeClass() throws Exception {
    testHelper = env.getTestHelper();
    databaseAdminClient = testHelper.getClient().getDatabaseAdminClient();
    databasesToDrop = new ArrayList<>();
    projectId = testHelper.getInstanceId().getProject();
    instanceId = testHelper.getInstanceId().getInstance();
    databaseId = testHelper.getUniqueDatabaseId();
    final Database database =
        databaseAdminClient
            .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setDialect(Dialect.POSTGRESQL)
            .build();
    databaseAdminClient
        .createDatabase(database, Collections.emptyList())
        .get(OPERATION_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
    databasesToDrop.add(database.getId());
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (databasesToDrop != null) {
      for (DatabaseId id : databasesToDrop) {
        try {
          databaseAdminClient.dropDatabase(id.getInstanceId().getInstance(), id.getDatabase());
        } catch (Exception e) {
          System.err.println("Failed to drop database " + id + ", skipping...: " + e.getMessage());
        }
      }
    }
  }

  @Before
  public void setUp() throws Exception {
    databaseClient =
        testHelper.getClient().getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
    tableName = testHelper.getUniqueDatabaseId();
    databaseAdminClient
        .updateDatabaseDdl(
            instanceId,
            databaseId,
            Collections.singletonList(
                "CREATE TABLE \"" + tableName + "\" (id BIGINT PRIMARY KEY, col1 NUMERIC)"),
            null)
        .get(OPERATION_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
  }

  @Test
  public void testLiteralPgNumeric() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.of(
                      "INSERT INTO "
                          + tableName
                          + " (id, col1) VALUES"
                          + " (1, 1.23)"
                          + ", (2, 'NaN')"
                          + ", (3, null)"));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }

  @Test
  public void testParameterizedWithPgNumericAsValue() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(
                          "INSERT INTO "
                              + tableName
                              + " (id, col1) VALUES"
                              + " (1, $1)"
                              + ", (2, $2)"
                              + ", (3, $3)")
                      .bind("p1")
                      .to(Value.pgNumeric("1.23"))
                      .bind("p2")
                      .to(Value.pgNumeric("NaN"))
                      .bind("p3")
                      .to(Value.pgNumeric(null))
                      .build());
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }

  @Test
  public void testParameterizedWithPgNumericAsDouble() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(
                          "INSERT INTO "
                              + tableName
                              + " (id, col1) VALUES"
                              + " (1, $1)"
                              + ", (2, $2)"
                              + ", (3, $3)")
                      .bind("p1")
                      .to(1.23D)
                      .bind("p2")
                      .to(Double.NaN)
                      .bind("p3")
                      .to((Double) null)
                      .build());
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }

  @Test
  public void testParameterizedWithPgNumericAsInt() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder("INSERT INTO " + tableName + " (id, col1) VALUES (1, $1)")
                      .bind("p1")
                      .to(1)
                      .build());
              return null;
            });

    try (ResultSet resultSet =
        databaseClient.singleUse().executeQuery(Statement.of("SELECT * FROM " + tableName))) {

      resultSet.next();
      assertEquals("1", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1"), resultSet.getValue("col1"));
    }
  }

  @Test
  public void testParameterizedWithPgNumericAsLong() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder("INSERT INTO " + tableName + " (id, col1) VALUES (1, $1)")
                      .bind("p1")
                      .to(1L)
                      .build());
              return null;
            });

    try (ResultSet resultSet =
        databaseClient.singleUse().executeQuery(Statement.of("SELECT * FROM " + tableName))) {

      resultSet.next();
      assertEquals("1", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1"), resultSet.getValue("col1"));
    }
  }

  @Test
  public void testMutationsWithPgNumericAsString() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(
                  ImmutableList.of(
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(1)
                          .set("col1")
                          .to("1.23")
                          .build(),
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(2)
                          .set("col1")
                          .to("NaN")
                          .build(),
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(3)
                          .set("col1")
                          .to((String) null)
                          .build()));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }

  @Test
  public void testMutationsWithPgNumericAsInt() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(
                  ImmutableList.of(
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(1)
                          .set("col1")
                          .to(1)
                          .build()));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient.singleUse().executeQuery(Statement.of("SELECT * FROM " + tableName))) {

      resultSet.next();
      assertEquals("1", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1"), resultSet.getValue("col1"));
    }
  }

  @Test
  public void testMutationsWithPgNumericAsLong() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(
                  ImmutableList.of(
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(1)
                          .set("col1")
                          .to(1L)
                          .build()));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient.singleUse().executeQuery(Statement.of("SELECT * FROM " + tableName))) {

      resultSet.next();
      assertEquals("1", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1"), resultSet.getValue("col1"));
    }
  }

  @Test
  public void testMutationsWithPgNumericAsBigDecimal() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(
                  ImmutableList.of(
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(1)
                          .set("col1")
                          .to(new BigDecimal("1.23"))
                          .build(),
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(3)
                          .set("col1")
                          .to((BigDecimal) null)
                          .build()));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }

  @Test
  public void testMutationsWithPgNumericAsValue() {
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(
                  ImmutableList.of(
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(1)
                          .set("col1")
                          .to(Value.pgNumeric("1.23"))
                          .build(),
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(2)
                          .set("col1")
                          .to(Value.pgNumeric("NaN"))
                          .build(),
                      Mutation.newInsertBuilder(tableName)
                          .set("id")
                          .to(3)
                          .set("col1")
                          .to(Value.pgNumeric(null))
                          .build()));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + tableName + " ORDER BY id"))) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("col1"));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("col1"));

      resultSet.next();
      assertTrue(resultSet.isNull("col1"));
    }
  }
}
