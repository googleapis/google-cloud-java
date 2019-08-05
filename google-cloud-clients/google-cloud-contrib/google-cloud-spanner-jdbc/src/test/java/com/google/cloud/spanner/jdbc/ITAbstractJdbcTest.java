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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.GceTestEnvConfig;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier.JdbcGenericConnection;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.experimental.categories.Category;

/** Base class for all JDBC integration tests. */
@Category(IntegrationTest.class)
public class ITAbstractJdbcTest {
  protected class ITJdbcConnectionProvider implements GenericConnectionProvider {
    public ITJdbcConnectionProvider() {}

    @Override
    public JdbcGenericConnection getConnection() {
      try {
        return JdbcGenericConnection.of(createConnection());
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String DEFAULT_KEY_FILE = null;
  private static Database database;

  protected static String getKeyFile() {
    return System.getProperty(GceTestEnvConfig.GCE_CREDENTIALS_FILE, DEFAULT_KEY_FILE);
  }

  protected static boolean hasValidKeyFile() {
    return getKeyFile() != null && Files.exists(Paths.get(getKeyFile()));
  }

  protected static IntegrationTestEnv getTestEnv() {
    return env;
  }

  protected static Database getDatabase() {
    return database;
  }

  @BeforeClass
  public static void setup() throws IOException, InterruptedException, ExecutionException {
    database = env.getTestHelper().createTestDatabase();
  }

  /**
   * Creates a new default JDBC connection to a test database. Use the method {@link
   * ITAbstractJdbcTest#appendConnectionUri(StringBuilder)} to append additional connection options
   * to the connection URI.
   *
   * @return The newly opened JDBC connection.
   */
  public CloudSpannerJdbcConnection createConnection() throws SQLException {
    StringBuilder url =
        new StringBuilder("jdbc:cloudspanner:/").append(getDatabase().getId().getName());
    if (hasValidKeyFile()) {
      url.append(";credentials=").append(getKeyFile());
    }
    appendConnectionUri(url);

    return DriverManager.getConnection(url.toString()).unwrap(CloudSpannerJdbcConnection.class);
  }

  protected void appendConnectionUri(StringBuilder uri) {}

  /**
   * Override this method to instruct the test to create a default test table in the form:
   *
   * <pre>
   * CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY (ID)
   * </pre>
   *
   * Note that the table is not re-created for each test case, but is preserved between test cases.
   * It is the responsibility of the test class to either empty the table at the end of each test
   * case, or keep track of the state of the test table and execute the test cases in a specific
   * order.
   *
   * @return true if the default test table should be created.
   */
  protected boolean doCreateDefaultTestTable() {
    return false;
  }

  protected boolean doCreateMusicTables() {
    return false;
  }

  @Before
  public void createTestTable() throws SQLException {
    if (doCreateDefaultTestTable()) {
      try (Connection connection = createConnection()) {
        connection.setAutoCommit(true);
        if (!tableExists(connection, "TEST")) {
          connection.setAutoCommit(false);
          connection.createStatement().execute("START BATCH DDL");
          connection
              .createStatement()
              .execute(
                  "CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY (ID)");
          connection.createStatement().execute("RUN BATCH");
        }
      }
    }
  }

  @Before
  public void createMusicTables() throws SQLException {
    if (doCreateMusicTables()) {
      try (Connection connection = createConnection()) {
        connection.setAutoCommit(true);
        if (!tableExists(connection, "Singers")) {
          for (String statement :
              AbstractSqlScriptVerifier.readStatementsFromFile(
                  "CreateMusicTables.sql", getClass())) {
            connection.createStatement().execute(statement);
          }
        }
      }
    }
  }

  protected boolean tableExists(Connection connection, String table) throws SQLException {
    try (ResultSet rs = connection.getMetaData().getTables("", "", table, null)) {
      if (rs.next()) {
        if (rs.getString("TABLE_NAME").equalsIgnoreCase(table)) {
          return true;
        }
      }
    }
    return false;
  }

  protected boolean indexExists(Connection connection, String table, String index)
      throws SQLException {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(index));
    try (PreparedStatement ps =
        connection.prepareStatement(
            "SELECT INDEX_NAME FROM INFORMATION_SCHEMA.INDEXES WHERE UPPER(TABLE_NAME)=? AND UPPER(INDEX_NAME)=?")) {
      ps.setString(1, table);
      ps.setString(2, index);
      try (ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    }
  }
}
