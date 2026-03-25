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

package com.google.cloud.spanner.jdbc.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Value;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Test executing simple statements through JDBC. */
@RunWith(Parameterized.class)
@Category(ParallelIntegrationTest.class)
public class ITJdbcSimpleStatementsTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    return params;
  }

  @Parameter public DialectTestParameter dialect;

  private Database database;

  @Before
  public void setup() {
    database = env.getOrCreateDatabase(getDialect(), Collections.emptyList());
  }

  @Override
  public Dialect getDialect() {
    return dialect.dialect;
  }

  @Test
  public void testSelect1() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (ResultSet rs = connection.createStatement().executeQuery("select 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getInt(1)).isEqualTo(1);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testSelect1PreparedStatement() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (PreparedStatement ps = connection.prepareStatement("select 1")) {
        try (ResultSet rs = ps.executeQuery()) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getInt(1)).isEqualTo(1);
          assertThat(rs.next()).isFalse();
        }
      }
    }
  }

  @Test
  public void testPreparedStatement() throws SQLException {
    String sql =
        "select * from (select 1 as number union all select 2 union all select 3) numbers where number=?";
    try (Connection connection = createConnection(env, database)) {
      try (PreparedStatement ps = connection.prepareStatement(sql)) {
        for (int i = 1; i <= 3; i++) {
          ps.setInt(1, i);
          try (ResultSet rs = ps.executeQuery()) {
            assertThat(rs.next()).isTrue();
            assertThat(rs.getInt(1)).isEqualTo(i);
            assertThat(rs.next()).isFalse();
          }
        }
      }
    }
  }

  @Test
  public void testBatchedDdlStatements() throws SQLException {
    String createTableFoo1 =
        "CREATE TABLE FOO1 (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID)";
    String createTableFoo2 =
        "CREATE TABLE FOO2 (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID)";
    String createTableFoo3 =
        "CREATE TABLE FOO3 (ID INT64 NOT NULL, NAME STRING(100)) PRIMARY KEY (ID)";
    String countTable =
        "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='' AND TABLE_NAME LIKE 'FOO%'";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      createTableFoo1 = "CREATE TABLE FOO1 (ID BIGINT PRIMARY KEY, NAME VARCHAR (100))";
      createTableFoo2 = "CREATE TABLE FOO2 (ID BIGINT PRIMARY KEY, NAME VARCHAR(100))";
      createTableFoo3 = "CREATE TABLE FOO3 (ID BIGINT PRIMARY KEY, NAME VARCHAR(100))";
      countTable = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE 'foo%'";
    }
    // Execute a successful batch of DDL statements.
    try (Connection connection = createConnection(env, database)) {
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(createTableFoo1);
        statement.addBatch(createTableFoo2);
        int[] updateCounts = statement.executeBatch();
        assertThat(updateCounts)
            .asList()
            .containsExactly(Statement.SUCCESS_NO_INFO, Statement.SUCCESS_NO_INFO);
      }
      try (ResultSet rs = connection.createStatement().executeQuery(countTable)) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(2L);
      }
    }
    // Execute a batch of DDL statements that contains a statement that will fail.
    try (Connection connection = createConnection(env, database)) {
      // First create a couple of test records that will cause the index creation to fail.
      try (Statement statement = connection.createStatement()) {
        statement.executeUpdate("INSERT INTO FOO1 (ID, NAME) VALUES (1,'TEST')");
        statement.executeUpdate("INSERT INTO FOO1 (ID, NAME) VALUES (2,'TEST')");
      }
      boolean gotExpectedException = false;
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(createTableFoo3);
        statement.addBatch("CREATE UNIQUE INDEX IDX_FOO1_UNIQUE ON FOO1 (NAME)");
        statement.executeBatch();
      } catch (SQLException e) {
        gotExpectedException = true;
      }
      assertThat(gotExpectedException).isTrue();
      // The table should have been created, the index should not.
      try (ResultSet rs = connection.createStatement().executeQuery(countTable)) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(3L);
      }
      try (ResultSet rs =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT COUNT(*) FROM INFORMATION_SCHEMA.INDEXES WHERE TABLE_SCHEMA='' AND INDEX_NAME='IDX_FOO1_UNIQUE'")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(0L);
      }
    }
  }

  @Test
  public void testAddBatchWhenAlreadyInBatch() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (Statement statement = connection.createStatement()) {
        statement.execute("START BATCH DML");
        statement.addBatch("INSERT INTO Singers (SingerId) VALUES (-1)");
        statement.addBatch("INSERT INTO Singers (SingerId) VALUES (-2)");
        // The returned update count for DML statements in a batch is -1.
        assertArrayEquals(new int[] {-1, -1}, statement.executeBatch());
        // Note: The 'Singers' table does not actually exist, so we're not executing the batch.
      }
    }
  }

  @Test
  public void testSelectArrayOfStructs() throws SQLException {
    // skipping the test when dialect is POSTGRESQL because of exception below
    // INVALID_ARGUMENT: io.grpc.StatusRuntimeException: INVALID_ARGUMENT: [ERROR] syntax error at
    // or near "[" - Statement: 'WITH points AS
    assumeFalse(
        "select array of structs is not supported on POSTGRESQL",
        dialect.dialect == Dialect.POSTGRESQL);
    String sql =
        "WITH points AS\n"
            + "  (SELECT [1, 5] as point\n"
            + "   UNION ALL SELECT [2, 8] as point\n"
            + "   UNION ALL SELECT [3, 7] as point\n"
            + "   UNION ALL SELECT [4, 1] as point\n"
            + "   UNION ALL SELECT [5, 7] as point)\n"
            + "SELECT ARRAY(\n"
            + "  SELECT STRUCT(point)\n"
            + "  FROM points)\n"
            + "  AS coordinates";
    try (Connection connection = createConnection(env, database)) {
      try (ResultSet resultSet = connection.createStatement().executeQuery(sql)) {
        assertTrue(resultSet.next());
        assertEquals(resultSet.getMetaData().getColumnCount(), 1);
        Array array = resultSet.getArray(1);
        assertThat((Struct[]) array.getArray())
            .asList()
            .containsExactly(
                Struct.newBuilder().set("point").to(Value.int64Array(new long[] {1L, 5L})).build(),
                Struct.newBuilder().set("point").to(Value.int64Array(new long[] {2L, 8L})).build(),
                Struct.newBuilder().set("point").to(Value.int64Array(new long[] {3L, 7L})).build(),
                Struct.newBuilder().set("point").to(Value.int64Array(new long[] {4L, 1L})).build(),
                Struct.newBuilder().set("point").to(Value.int64Array(new long[] {5L, 7L})).build());
        // Getting a result set from an array of structs is not supported, as structs are not
        // supported as a valid column type in a result set.
        assertThrows(SQLFeatureNotSupportedException.class, array::getResultSet);
        assertFalse(resultSet.next());
      }
    }
  }
}
