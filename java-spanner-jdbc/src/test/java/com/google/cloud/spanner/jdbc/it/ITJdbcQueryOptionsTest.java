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

package com.google.cloud.spanner.jdbc.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.cloud.spanner.jdbc.JdbcSqlException;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.rpc.Code;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * {@link QueryOptions} can be used with the JDBC driver on three different levels:
 *
 * <ol>
 *   <li>Specify {@link QueryOptions} in environment variables.
 *   <li>Specify {@link QueryOptions} in the connection URL or by setting these using <code>
 *       SET &lt;query_option&gt; = '&lt;value&gt;'</code> statements.
 *   <li>Specify {@link QueryOptions} in a query hint.
 * </ol>
 *
 * This class tests all three possibilities.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITJdbcQueryOptionsTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private String connectionUriSuffix;

  @Before
  public void resetConnectionUriSuffix() {
    connectionUriSuffix = "";
  }

  @After
  public void closeSpannerPool() {
    // Close the pool after each test to prevent side effects from one test case to affect following
    // test cases.
    SpannerPool.closeSpannerPool();
  }

  @Override
  protected void appendConnectionUri(StringBuilder uri) {
    uri.append(connectionUriSuffix);
  }

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

  private String getNamespace() {
    return getDialect() == Dialect.POSTGRESQL ? "SPANNER." : "";
  }

  private void verifyOptimizerVersion(Connection connection, String expectedVersion)
      throws SQLException {
    try (ResultSet rs =
        connection
            .createStatement()
            .executeQuery(String.format("SHOW VARIABLE %sOPTIMIZER_VERSION", getNamespace()))) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString(String.format("%sOPTIMIZER_VERSION", getNamespace())))
          .isEqualTo(expectedVersion);
      assertThat(rs.next()).isFalse();
    }
  }

  @Test
  public void connectionUrl() throws SQLException {
    this.connectionUriSuffix = ";optimizerVersion=1";
    try (Connection connection = createConnection(env, database)) {
      verifyOptimizerVersion(connection, "1");
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void connectionUrlWithInvalidOptimizerVersion() throws SQLException {
    assumeFalse(
        "optimizer version is ignored on emulator", EmulatorSpannerHelper.isUsingEmulator());
    this.connectionUriSuffix = ";optimizerVersion=9999999";
    try (Connection connection = createConnection(env, database)) {
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        fail("missing expected exception");
      } catch (SQLException e) {
        assertThat((Throwable) e).isInstanceOf(JdbcSqlException.class);
        JdbcSqlException je = (JdbcSqlException) e;
        assertThat(je.getCode()).isEqualTo(Code.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void setOptimizerVersion() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      verifyOptimizerVersion(connection, "");
      connection
          .createStatement()
          .execute(String.format("SET %sOPTIMIZER_VERSION='1'", getNamespace()));
      verifyOptimizerVersion(connection, "1");
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void setLatestOptimizerVersion() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      verifyOptimizerVersion(connection, "");
      connection
          .createStatement()
          .execute(String.format("SET %sOPTIMIZER_VERSION='LATEST'", getNamespace()));
      verifyOptimizerVersion(connection, "LATEST");
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void setInvalidOptimizerVersion() throws SQLException {
    assumeFalse(
        "optimizer version is ignored on emulator", EmulatorSpannerHelper.isUsingEmulator());
    try (Connection connection = createConnection(env, database)) {
      connection
          .createStatement()
          .execute(String.format("SET %sOPTIMIZER_VERSION='9999999'", getNamespace()));
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
        fail("missing expected exception");
      } catch (SQLException e) {
        assertThat((Throwable) e).isInstanceOf(JdbcSqlException.class);
        JdbcSqlException je = (JdbcSqlException) e;
        assertThat(je.getCode()).isEqualTo(Code.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void optimizerVersionInQueryHint() throws SQLException {
    assumeFalse(
        "optimizer version in query hint is not supported on emulator",
        EmulatorSpannerHelper.isUsingEmulator());
    assumeFalse(
        "optimizer version in query hint is not supported on POSTGRESQL",
        getDialect() == Dialect.POSTGRESQL);
    try (Connection connection = createConnection(env, database)) {
      verifyOptimizerVersion(connection, "");
      try (ResultSet rs =
          connection.createStatement().executeQuery("@{optimizer_version=1} SELECT 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
      try (ResultSet rs =
          connection.createStatement().executeQuery("@{optimizer_version=latest} SELECT 1")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testOptionsInEnvironment() throws SQLException {
    assumeFalse(
        "optimizer version is ignored on emulator", EmulatorSpannerHelper.isUsingEmulator());
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Nonnull
            @Override
            public String getOptimizerVersion() {
              return "1";
            }

            @Nonnull
            @Override
            public String getOptimizerStatisticsPackage() {
              return "latest";
            }
          });
      try (Connection connection = createConnection(env, database)) {
        // Environment query options are not visible to the connection.
        verifyOptimizerVersion(connection, "");
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong(1)).isEqualTo(1L);
          assertThat(rs.next()).isFalse();
        }
      }
      // Close the pool to force re-initialization of any cached connections.
      SpannerPool.closeSpannerPool();

      // Now set an invalid version on the environment. The query will now fail.
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Nonnull
            @Override
            public String getOptimizerVersion() {
              return "9999999";
            }

            @Nonnull
            @Override
            public String getOptimizerStatisticsPackage() {
              return "latest";
            }
          });
      try (Connection connection = createConnection(env, database)) {
        SQLException e =
            assertThrows(
                SQLException.class, () -> connection.createStatement().executeQuery("SELECT 1"));
        assertTrue(e instanceof JdbcSqlException);
        JdbcSqlException je = (JdbcSqlException) e;
        assertEquals(Code.INVALID_ARGUMENT, je.getCode());
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }
}
