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

package com.google.cloud.spanner.jdbc;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.SpannerEnvironment;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.common.base.MoreObjects;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.annotation.Nonnull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcQueryOptionsTest extends AbstractMockServerTest {

  @Test
  public void testDefaultOptions() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_VERSION")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_VERSION")).isEqualTo("");
        assertThat(rs.next()).isFalse();
      }
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_STATISTICS_PACKAGE")).isEqualTo("");
        assertThat(rs.next()).isFalse();
      }
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RPC_PRIORITY")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("RPC_PRIORITY")).isEqualTo("PRIORITY_UNSPECIFIED");
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testOptionsInConnectionUrl() throws SQLException {
    try (java.sql.Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:%s;optimizerVersion=%s;optimizerStatisticsPackage=%s;rpcPriority=%s",
                getBaseUrl(), "100", "url_package", "LOW"))) {
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_VERSION")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_VERSION")).isEqualTo("100");
        assertThat(rs.next()).isFalse();
      }
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_STATISTICS_PACKAGE")).isEqualTo("url_package");
        assertThat(rs.next()).isFalse();
      }
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RPC_PRIORITY")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("RPC_PRIORITY")).isEqualTo("LOW");
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testSetOptions() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.createStatement().execute("SET OPTIMIZER_VERSION='20'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_VERSION")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_VERSION")).isEqualTo("20");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET OPTIMIZER_VERSION='latest'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_VERSION")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_VERSION")).isEqualTo("latest");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET OPTIMIZER_VERSION=''");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_VERSION")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_VERSION")).isEqualTo("");
        assertThat(rs.next()).isFalse();
      }

      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE='20210609'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_STATISTICS_PACKAGE")).isEqualTo("20210609");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE='latest'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_STATISTICS_PACKAGE")).isEqualTo("latest");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE=''");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("OPTIMIZER_STATISTICS_PACKAGE")).isEqualTo("");
        assertThat(rs.next()).isFalse();
      }

      connection.createStatement().execute("SET RPC_PRIORITY='LOW'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RPC_PRIORITY")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("RPC_PRIORITY")).isEqualTo("LOW");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET RPC_PRIORITY='MEDIUM'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RPC_PRIORITY")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("RPC_PRIORITY")).isEqualTo("MEDIUM");
        assertThat(rs.next()).isFalse();
      }
      connection.createStatement().execute("SET RPC_PRIORITY='NULL'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RPC_PRIORITY")) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getString("RPC_PRIORITY")).isEqualTo("UNSPECIFIED");
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testSetAndUseOptions() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.createStatement().execute("SET OPTIMIZER_VERSION='20'");
      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE='20210609'");
      connection.createStatement().execute("SET RPC_PRIORITY='LOW'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
        assertThat(rs.next()).isFalse();
        // Verify that the last ExecuteSqlRequest that the server received used the options that
        // were set.
        ExecuteSqlRequest request = getLastExecuteSqlRequest();
        assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("20");
        assertThat(request.getQueryOptions().getOptimizerStatisticsPackage()).isEqualTo("20210609");
        assertThat(request.getRequestOptions().getPriority().toString()).isEqualTo("PRIORITY_LOW");
      }

      connection.createStatement().execute("SET OPTIMIZER_VERSION='latest'");
      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE='latest'");
      connection.createStatement().execute("SET RPC_PRIORITY='MEDIUM'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
        assertThat(rs.next()).isFalse();
        ExecuteSqlRequest request = getLastExecuteSqlRequest();
        assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("latest");
        assertThat(request.getQueryOptions().getOptimizerStatisticsPackage()).isEqualTo("latest");
        assertThat(request.getRequestOptions().getPriority().toString())
            .isEqualTo("PRIORITY_MEDIUM");
      }

      // Set the options to ''. This will do a fallback to the default, meaning that it will be read
      // from the environment variables as we have nothing set on the connection URL.
      connection.createStatement().execute("SET OPTIMIZER_VERSION=''");
      connection.createStatement().execute("SET OPTIMIZER_STATISTICS_PACKAGE=''");
      connection.createStatement().execute("SET RPC_PRIORITY='NULL'");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
        assertThat(rs.next()).isFalse();
        // Verify that the last ExecuteSqlRequest that the server received specified an optimizer
        // version equal to the environment default.
        ExecuteSqlRequest request = getLastExecuteSqlRequest();
        assertThat(request.getQueryOptions().getOptimizerVersion())
            .isEqualTo(MoreObjects.firstNonNull(System.getenv("SPANNER_OPTIMIZER_VERSION"), ""));
        assertThat(request.getQueryOptions().getOptimizerStatisticsPackage())
            .isEqualTo(MoreObjects.firstNonNull(System.getenv("OPTIMIZER_STATISTICS_PACKAGE"), ""));
        assertThat(request.getRequestOptions().getPriority().toString())
            .isEqualTo("PRIORITY_UNSPECIFIED");
      }
    }
  }

  @Test
  public void testUseOptionsFromConnectionUrl() throws SQLException {
    try (java.sql.Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:%s;optimizerVersion=10;optimizerStatisticsPackage=20210609_10_00_00;rpcPriority=LOW",
                getBaseUrl()))) {
      // Do a query and verify that the version from the connection URL is used.
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
        assertThat(rs.next()).isFalse();
        // The options should come from the connection URL.
        ExecuteSqlRequest request = getLastExecuteSqlRequest();
        assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("10");
        assertThat(request.getQueryOptions().getOptimizerStatisticsPackage())
            .isEqualTo("20210609_10_00_00");
        assertThat(request.getRequestOptions().getPriority().toString()).isEqualTo("PRIORITY_LOW");
      }
    }
  }

  @Test
  public void testUseOptionsFromEnvironment() throws SQLException {
    // Make sure that all existing connections are closed, so these do not affect this test.
    ConnectionOptions.closeSpanner();
    try {
      SpannerOptions.useEnvironment(
          new SpannerEnvironment() {
            @Nonnull
            @Override
            public String getOptimizerVersion() {
              return "20";
            }

            @Nonnull
            @Override
            public String getOptimizerStatisticsPackage() {
              return "env_package";
            }
          });
      try (java.sql.Connection connection =
          DriverManager.getConnection(String.format("jdbc:%s", getBaseUrl()))) {
        // Do a query and verify that the version from the environment is used.
        try (java.sql.ResultSet rs =
            connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
          assertThat(rs.next()).isFalse();
          // Verify query options from the environment.
          ExecuteSqlRequest request = getLastExecuteSqlRequest();
          assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("20");
          assertThat(request.getQueryOptions().getOptimizerStatisticsPackage())
              .isEqualTo("env_package");
        }
        // Now set one of the query options on the connection. That option should be used in
        // combination with the other option from the environment.
        connection.createStatement().execute("SET OPTIMIZER_VERSION='30'");
        try (java.sql.ResultSet rs =
            connection.createStatement().executeQuery(SELECT_COUNT_STATEMENT.getSql())) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
          assertThat(rs.next()).isFalse();

          ExecuteSqlRequest request = getLastExecuteSqlRequest();
          // Optimizer version should come from the connection.
          assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("30");
          // Optimizer statistics package should come from the environment.
          assertThat(request.getQueryOptions().getOptimizerStatisticsPackage())
              .isEqualTo("env_package");
        }
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testUseQueryHint() throws SQLException {
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(
                String.format(
                    "@{optimizer_version=1, optimizer_statistics_package=hint_package} %s",
                    SELECT_COUNT_STATEMENT.getSql())),
            SELECT_COUNT_RESULTSET_BEFORE_INSERT));
    try (java.sql.Connection connection =
        DriverManager.getConnection(String.format("jdbc:%s", getBaseUrl()))) {
      try (java.sql.ResultSet rs =
          connection
              .createStatement()
              .executeQuery(
                  String.format(
                      "@{optimizer_version=1, optimizer_statistics_package=hint_package} %s",
                      SELECT_COUNT_STATEMENT.getSql()))) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong(1)).isEqualTo(COUNT_BEFORE_INSERT);
        assertThat(rs.next()).isFalse();
        // The options used in the ExecuteSqlRequest should be empty as the query hint is parsed by
        // the backend.
        ExecuteSqlRequest request = getLastExecuteSqlRequest();
        assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("");
        assertThat(request.getQueryOptions().getOptimizerStatisticsPackage()).isEqualTo("");
      }
    }
  }
}
