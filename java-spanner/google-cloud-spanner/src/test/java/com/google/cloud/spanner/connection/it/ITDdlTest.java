/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseNotFoundException;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MissingDefaultSequenceKindException;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.SqlScriptVerifier;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Execute DDL statements using the generic connection API. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDdlTest extends ITAbstractSpannerTest {
  @BeforeClass
  public static void setup() {
    // This overrides the default behavior that creates a single database for the test class. This
    // test needs a separate database per method.
  }

  @Before
  public void createTestDatabase() {
    database = env.getTestHelper().createTestDatabase();
  }

  @Test
  public void testSqlScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile("ITDdlTest.sql", SqlScriptVerifier.class, false);
  }

  @Test
  public void testCreateDatabase() {
    DatabaseAdminClient client = getTestEnv().getTestHelper().getClient().getDatabaseAdminClient();
    String instance = getTestEnv().getTestHelper().getInstanceId().getInstance();
    String name = getTestEnv().getTestHelper().getUniqueDatabaseId();

    assertThrows(DatabaseNotFoundException.class, () -> client.getDatabase(instance, name));

    try (Connection connection = createConnection()) {
      connection.execute(Statement.of(String.format("CREATE DATABASE `%s`", name)));
      assertNotNull(client.getDatabase(instance, name));
    } finally {
      client.dropDatabase(instance, name);
    }
  }

  @Test
  public void testDefaultSequenceKind() {
    try (Connection connection = createConnection()) {
      Statement statement =
          Statement.of(
              "create table test (id int64 auto_increment primary key, value string(max))");

      // Creating a table with an auto_increment column fails if no default sequence kind has been
      // set.
      assertNull(connection.getDefaultSequenceKind());
      assertThrows(MissingDefaultSequenceKindException.class, () -> connection.execute(statement));

      // Setting a default sequence kind on the connection should make the statement succeed.
      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.execute(statement);

      assertEquals(
          1L, connection.executeUpdate(Statement.of("insert into test (value) values ('One')")));
      try (ResultSet resultSet = connection.executeQuery(Statement.of("select * from test"))) {
        assertTrue(resultSet.next());
        assertEquals("One", resultSet.getString(1));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testDefaultSequenceKind_PostgreSQL() throws Exception {
    DatabaseAdminClient client = getTestEnv().getTestHelper().getClient().getDatabaseAdminClient();
    String instance = getTestEnv().getTestHelper().getInstanceId().getInstance();
    String name = getTestEnv().getTestHelper().getUniqueDatabaseId();

    Database database =
        client
            .createDatabase(
                instance,
                "create database \"" + name + "\"",
                Dialect.POSTGRESQL,
                Collections.emptyList())
            .get();

    StringBuilder url = extractConnectionUrl(getTestEnv().getTestHelper().getOptions(), database);
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder().setUri(url.toString());
    if (hasValidKeyFile()) {
      builder.setCredentialsUrl(getKeyFile());
    }
    ConnectionOptions options = builder.build();

    try (Connection connection = options.getConnection()) {
      Statement statement =
          Statement.of("create table test (id serial primary key, value varchar)");

      // Creating a table with an auto_increment column fails if no default sequence kind has been
      // set.
      assertNull(connection.getDefaultSequenceKind());
      assertThrows(MissingDefaultSequenceKindException.class, () -> connection.execute(statement));

      // Setting a default sequence kind on the connection should make the statement succeed.
      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.execute(statement);

      assertEquals(
          1L, connection.executeUpdate(Statement.of("insert into test (value) values ('One')")));
      try (ResultSet resultSet = connection.executeQuery(Statement.of("select * from test"))) {
        assertTrue(resultSet.next());
        assertEquals("One", resultSet.getString(1));
        assertFalse(resultSet.next());
      }
    } finally {
      client.dropDatabase(instance, name);
    }
  }

  @Test
  public void testDefaultSequenceKindInBatch() {
    try (Connection connection = createConnection()) {
      Statement statement1 =
          Statement.of("create table testseq1 (id1 int64 primary key, value string(max))");
      Statement statement2 =
          Statement.of(
              "create table testseq2 (id2 int64 auto_increment primary key, value string(max))");

      // Creating a table with an auto_increment column fails if no default sequence kind has been
      // set.
      assertNull(connection.getDefaultSequenceKind());
      connection.startBatchDdl();
      connection.execute(statement1);
      connection.execute(statement2);
      SpannerBatchUpdateException exception =
          assertThrows(SpannerBatchUpdateException.class, connection::runBatch);
      long updateCount = Arrays.stream(exception.getUpdateCounts()).sum();
      // The emulator refuses the entire batch. Spanner executes the first statement and fails on
      // the second statement.
      if (EmulatorSpannerHelper.isUsingEmulator()) {
        assertEquals(0, updateCount);
      } else {
        assertEquals(1, updateCount);
      }

      // Setting a default sequence kind on the connection should make the statement succeed.
      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.startBatchDdl();
      if (updateCount == 0) {
        connection.execute(statement1);
      }
      connection.execute(statement2);
      connection.runBatch();
    }
  }

  @Test
  public void testDefaultSequenceKindRetriesBatchCorrectly() {
    try (Connection connection = createConnection()) {
      Statement statement1 =
          Statement.of("create table testseq1 (id1 int64 primary key, value string(max))");
      Statement statement2 =
          Statement.of(
              "create table testseq2 (id2 int64 auto_increment primary key, value string(max))");

      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.startBatchDdl();
      connection.execute(statement1);
      connection.execute(statement2);
      connection.runBatch();
    }
  }
}
