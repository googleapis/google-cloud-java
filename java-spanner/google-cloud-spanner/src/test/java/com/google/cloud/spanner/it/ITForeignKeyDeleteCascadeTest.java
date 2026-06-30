/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITForeignKeyDeleteCascadeTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    return params;
  }

  private static final String TABLE_NAME_SINGER = "Singer";
  private static final String TABLE_NAME_CONCERT = "Concert";
  private static final String DELETE_RULE_COLUMN_NAME = "DELETE_RULE";

  private static Database GOOGLE_STANDARD_SQL_DATABASE;
  private static Database POSTGRESQL_DATABASE;
  private static final List<Database> dbs = new ArrayList<>();

  @Parameterized.Parameter(0)
  public DialectTestParameter dialect;

  @BeforeClass
  public static void setUpDatabase() {
    GOOGLE_STANDARD_SQL_DATABASE =
        env.getTestHelper()
            .createTestDatabase(
                ImmutableList.of(
                    "CREATE TABLE Singer (\n"
                        + "  singer_id   INT64 NOT NULL,\n"
                        + "  first_name  STRING(1024),\n"
                        + ") PRIMARY KEY(singer_id)\n",
                    "CREATE TABLE Concert (\n"
                        + "  venue_id      INT64 NOT NULL,\n"
                        + "  singer_id     INT64 NOT NULL,\n"
                        + "  CONSTRAINT Fk_Concert_Singer FOREIGN KEY (singer_id) REFERENCES Singer"
                        + " (singer_id) ON DELETE CASCADE\n"
                        + ") PRIMARY KEY(venue_id, singer_id)"));
    POSTGRESQL_DATABASE =
        env.getTestHelper()
            .createTestDatabase(
                Dialect.POSTGRESQL,
                ImmutableList.of(
                    "CREATE TABLE Singer (\n"
                        + "  singer_id   BIGINT PRIMARY KEY,\n"
                        + "  first_name  VARCHAR\n"
                        + ")",
                    "CREATE TABLE Concert (\n"
                        + "      venue_id      BIGINT NOT NULL,\n"
                        + "      singer_id     BIGINT NOT NULL,\n"
                        + "      PRIMARY KEY (venue_id, singer_id),\n"
                        + "      CONSTRAINT \"Fk_Concert_Singer\" FOREIGN KEY (singer_id)"
                        + " REFERENCES Singer (singer_id) ON DELETE CASCADE\n"
                        + "      )"));

    dbs.add(GOOGLE_STANDARD_SQL_DATABASE);
    dbs.add(POSTGRESQL_DATABASE);
  }

  @AfterClass
  public static void tearDown() {
    for (Database db : dbs) {
      db.drop();
    }
    dbs.clear();
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_withCreateDDLStatements() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();
    try (final ResultSet rs =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT DELETE_RULE\n"
                        + "FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS\n"
                        + "WHERE CONSTRAINT_NAME ='Fk_Concert_Singer'"))) {
      assertTrue(rs.next());
      // TODO: Enable for the emulator when it returns the correct value for DELETE_RULE.
      if (!isUsingEmulator()) {
        assertEquals("CASCADE", rs.getString(0));
      }
      assertFalse(rs.next());
    }
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_withAlterDDLStatements() throws Exception {
    // Creating new tables within this test to ensure we don't pollute tables used by other tests in
    // this class.
    List<String> createStatements;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      createStatements =
          ImmutableList.of(
              "CREATE TABLE Singer (\n"
                  + "  singer_id   BIGINT PRIMARY KEY,\n"
                  + "  first_name  VARCHAR\n"
                  + ")",
              "CREATE TABLE ConcertV2 (\n"
                  + "      venue_id      BIGINT NOT NULL,\n"
                  + "      singer_id     BIGINT NOT NULL,\n"
                  + "      PRIMARY KEY (venue_id, singer_id)\n"
                  + "      )",
              "ALTER TABLE ConcertV2 ADD CONSTRAINT \"Fk_Concert_Singer_V2\" FOREIGN KEY(singer_id)"
                  + " REFERENCES Singer(singer_id) ON DELETE CASCADE");
    } else {
      createStatements =
          ImmutableList.of(
              "CREATE TABLE Singer (\n"
                  + "  singer_id   INT64 NOT NULL,\n"
                  + "  first_name  STRING(1024),\n"
                  + ") PRIMARY KEY(singer_id)\n",
              "CREATE TABLE ConcertV2 (\n"
                  + "  venue_id      INT64 NOT NULL,\n"
                  + "  singer_id     INT64 NOT NULL,\n"
                  + ") PRIMARY KEY(venue_id, singer_id)",
              "ALTER TABLE ConcertV2 ADD CONSTRAINT Fk_Concert_Singer_V2 FOREIGN KEY(singer_id)"
                  + " REFERENCES Singer(singer_id) ON DELETE CASCADE");
    }
    final Database createdDatabase =
        env.getTestHelper().createTestDatabase(dialect.dialect, createStatements);
    dbs.add(createdDatabase);

    final DatabaseClient databaseClient = env.getTestHelper().getDatabaseClient(createdDatabase);

    try (final ResultSet rs =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT DELETE_RULE\n"
                        + "FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS\n"
                        + "WHERE CONSTRAINT_NAME ='Fk_Concert_Singer_V2'"))) {
      assertTrue(rs.next());
      // TODO: Enable when the emulator returns the correct value for this column.
      if (!isUsingEmulator()) {
        assertEquals("CASCADE", rs.getString(0));
      }
      assertFalse(rs.next());
    }

    // remove the foreign key delete cascade constraint
    getDatabaseAdminClient()
        .updateDatabaseDdl(
            env.getTestHelper().getInstanceId().getInstance(),
            createdDatabase.getId().getDatabase(),
            ImmutableList.of(
                "ALTER TABLE ConcertV2\n" + "DROP CONSTRAINT Fk_Concert_Singer_V2",
                "ALTER TABLE ConcertV2 ADD CONSTRAINT Fk_Concert_Singer_V2 FOREIGN KEY(singer_id)"
                    + " REFERENCES Singer(singer_id) "),
            null)
        .get();

    try (final ResultSet rs =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT DELETE_RULE\n"
                        + "FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS\n"
                        + "WHERE LOWER(CONSTRAINT_NAME) ='fk_concert_singer_v2'"))) {
      assertTrue(rs.next());
      assertEquals("NO ACTION", rs.getString(0));
      assertFalse(rs.next());
    }
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_verifyValidInsertions() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();
    final String singerInsertStatement =
        "INSERT INTO Singer (singer_id, first_name) VALUES (" + generateQueryParameters(2) + ")";
    final Statement singerInsertStatementWithValues =
        Statement.newBuilder(singerInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to("singerName")
            .build();

    final String concertInsertStatement =
        "INSERT INTO Concert (venue_id, singer_id) VALUES (" + generateQueryParameters(2) + ")";
    final Statement concertInsertStatementWithValues =
        Statement.newBuilder(concertInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(1L)
            .build();

    // successful inserts into referenced and referencing tables
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.batchUpdate(
                  ImmutableList.of(
                      singerInsertStatementWithValues, concertInsertStatementWithValues));
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME_SINGER))) {

      resultSet.next();
      assertEquals(1, resultSet.getLong("singer_id"));
      assertEquals("singerName", resultSet.getString("first_name"));

      assertFalse(resultSet.next());
    }

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME_CONCERT))) {

      resultSet.next();
      assertEquals(1, resultSet.getLong("singer_id"));
      assertEquals(1, resultSet.getLong("venue_id"));

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_verifyInvalidInsertions() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();

    // unsuccessful inserts into referencing tables when foreign key is not inserted into referenced
    // table
    final String concertInsertStatement =
        "INSERT INTO Concert (venue_id, singer_id) VALUES (" + generateQueryParameters(2) + ")";
    final Statement concertInsertStatementWithInvalidValues =
        Statement.newBuilder(concertInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(2L)
            .bind("p2")
            .to(2L)
            .build();

    SpannerException ex =
        assertThrows(
            SpannerException.class,
            () ->
                databaseClient
                    .readWriteTransaction()
                    .run(
                        transaction -> {
                          transaction.executeUpdate(concertInsertStatementWithInvalidValues);
                          return null;
                        }));
    assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    assertTrue(ex.getMessage(), ex.getMessage().contains("Cannot find referenced"));
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_forDeletions() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();

    final String singerInsertStatement =
        "INSERT INTO Singer (singer_id, first_name) VALUES (" + generateQueryParameters(2) + ")";
    final Statement singerInsertStatementWithValues =
        Statement.newBuilder(singerInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(3L)
            .bind("p2")
            .to("singerName")
            .build();

    final String concertInsertStatement =
        "INSERT INTO Concert (venue_id, singer_id) VALUES (" + generateQueryParameters(2) + ")";
    final Statement concertInsertStatementWithValues =
        Statement.newBuilder(concertInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(3L)
            .bind("p2")
            .to(3L)
            .build();

    // successful inserts into referenced and referencing tables
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.batchUpdate(
                  ImmutableList.of(
                      singerInsertStatementWithValues, concertInsertStatementWithValues));
              return null;
            });

    // execute delete
    final Statement singerDeleteStatementWithValues =
        Statement.newBuilder("DELETE FROM Singer WHERE singer_id = " + generateQueryParameters(1))
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(3L)
            .build();
    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(singerDeleteStatementWithValues);
              return null;
            });

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME_SINGER))) {
      assertFalse(resultSet.next());
    }

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT * FROM " + TABLE_NAME_CONCERT))) {
      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_forMutations_onConflictDueToParentTable() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();

    // inserting and deleting the referenced key within the same mutation are considered
    // conflicting operations, thus this results in an exception.
    SpannerException ex =
        assertThrows(
            SpannerException.class,
            () ->
                databaseClient
                    .readWriteTransaction()
                    .run(
                        transaction -> {
                          transaction.buffer(
                              Arrays.asList(
                                  Mutation.newInsertBuilder("Singer")
                                      .set("singer_id")
                                      .to(4L)
                                      .set("first_name")
                                      .to("singerName")
                                      .build(),
                                  Mutation.delete("Singer", Key.of(4L))));
                          return null;
                        }));
    assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
  }

  @Test
  public void testForeignKeyDeleteCascadeConstraints_forMutations_onConflictsDueToChildTable() {
    final DatabaseClient databaseClient = getCreatedDatabaseClient();

    // referencing a foreign key in child table and deleting the referenced key in parent table
    // within the same mutations are considered conflicting operations.
    final String singerInsertStatement =
        "INSERT INTO Singer (singer_id, first_name) VALUES (" + generateQueryParameters(2) + ")";
    final Statement singerInsertStatementWithValues =
        Statement.newBuilder(singerInsertStatement)
            // Use 'p1' to bind to the parameter with index 1 etc.
            .bind("p1")
            .to(5L)
            .bind("p2")
            .to("singerName")
            .build();

    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(singerInsertStatementWithValues);
              return null;
            });
    assertThrows(
        SpannerException.class,
        () ->
            databaseClient
                .readWriteTransaction()
                .run(
                    transaction -> {
                      transaction.buffer(
                          Arrays.asList(
                              Mutation.newInsertBuilder("Concert")
                                  .set("first_name")
                                  .to(5L)
                                  .set("singer_id")
                                  .to(5L)
                                  .build(),
                              Mutation.delete("Singer", Key.of(5L))));
                      return null;
                    }));
  }

  private DatabaseAdminClient getDatabaseAdminClient() {
    return env.getTestHelper().getClient().getDatabaseAdminClient();
  }

  private DatabaseClient getCreatedDatabaseClient() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return env.getTestHelper().getDatabaseClient(POSTGRESQL_DATABASE);
    }
    return env.getTestHelper().getDatabaseClient(GOOGLE_STANDARD_SQL_DATABASE);
  }

  /**
   * Returns '@p1, @p2, ..., @pNumParams' for GoogleSQL and $1, $2, ..., $NumParams' for PostgreSQL
   */
  private String generateQueryParameters(final int numParams) {
    final List<String> params;
    if (dialect.dialect == Dialect.POSTGRESQL) {
      params =
          IntStream.range(1, numParams + 1)
              .mapToObj(paramIndex -> "$" + paramIndex)
              .collect(Collectors.toList());

    } else {
      params =
          IntStream.range(1, numParams + 1)
              .mapToObj(paramIndex -> "@p" + paramIndex)
              .collect(Collectors.toList());
    }
    if (params.size() == 1) {
      return params.get(0);
    }
    return String.join(",", params);
  }
}
