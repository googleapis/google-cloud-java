/*
 * Copyright 2021 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcTransactionOptionsTest extends AbstractMockServerTest {

  @After
  public void closeSpannerPool() {
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testDefaultReturnCommitStats() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RETURN_COMMIT_STATS")) {
        assertTrue(rs.next());
        assertFalse(rs.getBoolean("RETURN_COMMIT_STATS"));
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testReturnCommitStatsInConnectionUrl() throws SQLException {
    try (java.sql.Connection connection =
        DriverManager.getConnection(
            String.format("jdbc:%s;returnCommitStats=true", getBaseUrl()))) {
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RETURN_COMMIT_STATS")) {
        assertTrue(rs.next());
        assertTrue(rs.getBoolean("RETURN_COMMIT_STATS"));
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testSetReturnCommitStats() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.createStatement().execute("SET RETURN_COMMIT_STATS=true");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RETURN_COMMIT_STATS")) {
        assertTrue(rs.next());
        assertTrue(rs.getBoolean("RETURN_COMMIT_STATS"));
        assertFalse(rs.next());
      }
      connection.createStatement().execute("SET RETURN_COMMIT_STATS=false");
      try (java.sql.ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE RETURN_COMMIT_STATS")) {
        assertTrue(rs.next());
        assertFalse(rs.getBoolean("RETURN_COMMIT_STATS"));
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testSetAndUseReturnCommitStats() throws SQLException {
    try (CloudSpannerJdbcConnection connection =
        createJdbcConnection().unwrap(CloudSpannerJdbcConnection.class)) {
      connection.setReturnCommitStats(true);
      connection.bufferedWrite(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
      connection.commit();
      CommitResponse response = connection.getCommitResponse();
      assertNotNull(response);
      assertNotNull(response.getCommitStats());
      assertThat(response.getCommitStats().getMutationCount()).isAtLeast(1);
    }
  }

  @Test
  public void testSetAndUseReturnCommitStatsUsingSql() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.createStatement().execute("SET RETURN_COMMIT_STATS=true");
      // Use a Mutation as the mock server only returns a non-zero mutation count for mutations, and
      // not for DML statements.
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .bufferedWrite(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
      connection.commit();
      try (ResultSet rs =
          connection.createStatement().executeQuery("SHOW VARIABLE COMMIT_RESPONSE")) {
        assertTrue(rs.next());
        assertNotNull(rs.getTimestamp("COMMIT_TIMESTAMP"));
        assertThat(rs.getLong("MUTATION_COUNT")).isAtLeast(1L);
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testMaxCommitDelay() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.createStatement().execute("SET max_commit_delay='50ms'");
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .bufferedWrite(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      CommitRequest request = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
      assertEquals(Duration.ofMillis(50).toNanos(), request.getMaxCommitDelay().getNanos());
    }
  }

  @Test
  public void testDefaultIsolationLevel() throws SQLException {
    for (IsolationLevel isolationLevel :
        Arrays.stream(IsolationLevel.values())
            .filter(level -> !level.equals(IsolationLevel.UNRECOGNIZED))
            .collect(Collectors.toList())) {
      try (java.sql.Connection connection =
          DriverManager.getConnection(
              "jdbc:" + getBaseUrl() + ";default_isolation_level=" + isolationLevel.name())) {
        connection.setAutoCommit(false);
        try (ResultSet resultSet =
            connection.createStatement().executeQuery(SELECT1_STATEMENT.getSql())) {
          while (resultSet.next()) {
            // ignore
          }
        }
        connection.commit();
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
        assertTrue(request.hasTransaction());
        assertTrue(request.getTransaction().hasBegin());
        assertTrue(request.getTransaction().getBegin().hasReadWrite());
        assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testSetIsolationLevel() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      for (int isolationLevel :
          new int[] {Connection.TRANSACTION_REPEATABLE_READ, Connection.TRANSACTION_SERIALIZABLE}) {
        connection.setTransactionIsolation(isolationLevel);
        try (ResultSet resultSet =
            connection.createStatement().executeQuery(SELECT1_STATEMENT.getSql())) {
          while (resultSet.next()) {
            // ignore
          }
        }
        connection.commit();
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
        assertTrue(request.hasTransaction());
        assertTrue(request.getTransaction().hasBegin());
        assertTrue(request.getTransaction().getBegin().hasReadWrite());
        assertEquals(
            IsolationLevelConverter.convertToSpanner(isolationLevel),
            request.getTransaction().getBegin().getIsolationLevel());
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

        mockSpanner.clearRequests();
      }
    }
  }
}
