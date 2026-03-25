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

package com.google.cloud.spanner.jdbc.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.Duration;
import java.util.Collections;
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
public class ITJdbcPgNumericTest {

  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(10);
  private static RemoteSpannerHelper testHelper;
  private static Database database;
  private static String url;

  @BeforeClass
  public static void setup() throws Exception {
    testHelper = env.getTestHelper();
    final String projectId = testHelper.getInstanceId().getProject();
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final DatabaseAdminClient databaseAdminClient = testHelper.getClient().getDatabaseAdminClient();
    final Database databaseToCreate =
        databaseAdminClient
            .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setDialect(Dialect.POSTGRESQL)
            .build();
    final String host = SpannerTestHost.getHost();

    database =
        databaseAdminClient
            .createDatabase(databaseToCreate, Collections.emptyList())
            .get(OPERATION_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
    url = "jdbc:cloudspanner://" + host + "/" + database.getId() + "?dialect=postgresql";
    if (isUsingEmulator()) {
      url += ";usePlainText=true";
    }
  }

  @AfterClass
  public static void teardown() {
    if (database != null) {
      database.drop();
    }
    ConnectionOptions.closeSpanner();
  }

  @Test
  public void testResultSet() throws SQLException {
    final String table = testHelper.getUniqueDatabaseId();
    final String positiveBigNumeric =
        String.join("", Collections.nCopies(131072, "1"))
            + "."
            + String.join("", Collections.nCopies(16383, "2"));
    final String negativeBigNumeric = "-" + positiveBigNumeric;
    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement()) {
      statement.executeUpdate(
          "CREATE TABLE \"" + table + "\" (id BIGINT PRIMARY KEY, col1 NUMERIC)");
      statement.executeUpdate(
          "INSERT INTO "
              + table
              + " (id, col1) VALUES"
              + " (1, 1.23),"
              + " (2, 'NaN'),"
              + " (3, null),"
              + " (4, "
              + positiveBigNumeric
              + "),"
              + " (5, "
              + negativeBigNumeric
              + ")");
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " ORDER BY id")) {

      resultSet.next();
      assertEquals("1.23", resultSet.getString("col1"));
      assertEquals((byte) 1, resultSet.getByte("col1"));
      assertEquals((short) 1, resultSet.getShort("col1"));
      assertEquals(1, resultSet.getInt("col1"));
      assertEquals(1L, resultSet.getLong("col1"));
      assertEquals(1.23F, resultSet.getFloat("col1"), 0.001F);
      assertEquals(1.23D, resultSet.getDouble("col1"), 0.001D);
      assertEquals(new BigDecimal("1.23"), resultSet.getBigDecimal("col1"));
      assertEquals(new BigDecimal("1.23"), resultSet.getObject("col1"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getObject("col1", Value.class));

      resultSet.next();
      assertEquals("NaN", resultSet.getString("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getByte("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getShort("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getInt("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getLong("col1"));
      assertEquals(Float.NaN, resultSet.getFloat("col1"), 0F);
      assertEquals(Double.NaN, resultSet.getDouble("col1"), 0D);
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getBigDecimal("col1"));
      assertEquals(Double.NaN, resultSet.getObject("col1"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getObject("col1", Value.class));

      resultSet.next();
      assertNull(resultSet.getString("col1"));
      assertEquals((byte) 0, resultSet.getByte("col1"));
      assertEquals((short) 0, resultSet.getShort("col1"));
      assertEquals(0, resultSet.getInt("col1"));
      assertEquals(0L, resultSet.getLong("col1"));
      assertEquals(0F, resultSet.getFloat("col1"), 0F);
      assertEquals(0D, resultSet.getDouble("col1"), 0D);
      assertNull(resultSet.getBigDecimal("col1"));
      assertNull(resultSet.getObject("col1"));
      assertNull(resultSet.getObject("col1", Value.class));

      resultSet.next();
      assertEquals(positiveBigNumeric, resultSet.getString("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getByte("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getShort("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getInt("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getLong("col1"));
      assertEquals(Float.POSITIVE_INFINITY, resultSet.getFloat("col1"), 0F);
      assertEquals(Double.POSITIVE_INFINITY, resultSet.getDouble("col1"), 0D);
      assertEquals(new BigDecimal(positiveBigNumeric), resultSet.getBigDecimal("col1"));
      assertEquals(new BigDecimal(positiveBigNumeric), resultSet.getObject("col1"));
      assertEquals(Value.pgNumeric(positiveBigNumeric), resultSet.getObject("col1", Value.class));

      resultSet.next();
      assertEquals(negativeBigNumeric, resultSet.getString("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getByte("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getShort("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getInt("col1"));
      assertThrows(JdbcSqlExceptionImpl.class, () -> resultSet.getLong("col1"));
      assertEquals(Float.NEGATIVE_INFINITY, resultSet.getFloat("col1"), 0F);
      assertEquals(Double.NEGATIVE_INFINITY, resultSet.getDouble("col1"), 0D);
      assertEquals(new BigDecimal(negativeBigNumeric), resultSet.getBigDecimal("col1"));
      assertEquals(new BigDecimal(negativeBigNumeric), resultSet.getObject("col1"));
      assertEquals(Value.pgNumeric(negativeBigNumeric), resultSet.getObject("col1", Value.class));

      // Just verify that the getColumns method works
      try (ResultSet columns = connection.getMetaData().getColumns(null, null, null, null)) {
        //noinspection StatementWithEmptyBody
        while (columns.next()) {
          // ignore
        }
      }
    }
  }

  @Test
  public void testPreparedStatement() throws Exception {
    final String table = testHelper.getUniqueDatabaseId();
    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement(); ) {
      statement.executeUpdate(
          "CREATE TABLE \"" + table + "\" (id BIGINT PRIMARY KEY, col1 NUMERIC)");
    }

    try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement preparedStatement =
            connection.prepareStatement(
                "INSERT INTO "
                    + table
                    + " (id, col1) VALUES"
                    + " (1, ?),"
                    + " (2, ?),"
                    + " (3, ?),"
                    + " (4, ?),"
                    + " (5, ?),"
                    + " (6, ?),"
                    + " (7, ?),"
                    + " (8, ?),"
                    + " (9, ?),"
                    + " (10, ?),"
                    + " (11, ?),"
                    + " (12, ?),"
                    + " (13, ?),"
                    + " (14, ?),"
                    + " (15, ?),"
                    + " (16, ?),"
                    + " (17, ?),"
                    + " (18, ?),"
                    + " (19, ?)")) {

      preparedStatement.setNull(1, Types.NUMERIC);

      preparedStatement.setByte(2, (byte) 1);
      preparedStatement.setShort(3, (short) 1);
      preparedStatement.setInt(4, 1);
      preparedStatement.setLong(5, 1L);
      preparedStatement.setFloat(6, 1f);
      preparedStatement.setDouble(7, 1D);
      preparedStatement.setBigDecimal(8, new BigDecimal("1"));
      preparedStatement.setObject(9, (byte) 1);
      preparedStatement.setObject(10, (short) 1);
      preparedStatement.setObject(11, 1);
      preparedStatement.setObject(12, 1L);
      preparedStatement.setObject(13, 1F);
      preparedStatement.setObject(14, 1D);
      preparedStatement.setObject(15, new BigDecimal("1"));
      preparedStatement.setObject(16, Value.pgNumeric("1"));

      preparedStatement.setFloat(17, Float.NaN);
      preparedStatement.setDouble(18, Double.NaN);
      preparedStatement.setObject(19, Value.pgNumeric("NaN"));

      final int updateCount = preparedStatement.executeUpdate();
      assertEquals(19, updateCount);
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " ORDER BY id")) {
      resultSet.next();
      assertNull(resultSet.getObject("col1"));

      for (int i = 2; i <= 16; i++) {
        resultSet.next();
        assertEquals(Value.pgNumeric("1"), resultSet.getObject("col1", Value.class));
      }

      for (int i = 17; i < 19; i++) {
        resultSet.next();
        assertEquals(Value.pgNumeric("NaN"), resultSet.getObject("col1", Value.class));
      }
    }
  }
}
