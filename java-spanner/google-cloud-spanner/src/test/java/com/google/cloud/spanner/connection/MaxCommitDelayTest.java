/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection;

import static junit.framework.TestCase.assertEquals;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Duration;
import com.google.spanner.v1.CommitRequest;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxCommitDelayTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Collection<Object[]> data() {
    ImmutableList.Builder<Object[]> builder = ImmutableList.builder();
    for (Dialect dialect : Dialect.values()) {
      builder.add(new Object[] {dialect});
    }
    return builder.build();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      // Reset the dialect result.
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
      currentDialect = dialect;
    }
  }

  private Mutation createMutation() {
    return Mutation.newInsertBuilder("foo").set("id").to(1L).build();
  }

  private String getVariablePrefix() {
    return dialect == Dialect.POSTGRESQL ? "spanner." : "";
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testNoMaxCommitDelayByDefault() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        executeCommit(connection);
        assertMaxCommitDelay(Duration.getDefaultInstance(), false);
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testZeroMaxCommitDelay() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.setMaxCommitDelay(java.time.Duration.ZERO);
        executeCommit(connection);
        assertMaxCommitDelay(Duration.getDefaultInstance(), true);
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testMaxCommitDelayInConnectionString() {
    try (Connection connection = createConnection(";maxCommitDelay=1000")) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        executeCommit(connection);
        assertMaxCommitDelay(Duration.newBuilder().setSeconds(1).build(), true);
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testZeroMaxCommitDelayInConnectionString() {
    try (Connection connection = createConnection(";maxCommitDelay=0")) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        executeCommit(connection);
        assertMaxCommitDelay(Duration.getDefaultInstance(), true);
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testSetMaxCommitDelay() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        for (boolean useSql : new boolean[] {true, false}) {
          connection.setAutocommit(autocommit);

          if (useSql) {
            connection.execute(
                Statement.of(String.format("set %smax_commit_delay='40ms'", getVariablePrefix())));
          } else {
            connection.setMaxCommitDelay(java.time.Duration.of(40_000, ChronoUnit.MICROS));
          }

          // Execute two transactions to verify that the new setting is applied to all transactions,
          // and not only the first one that is executed after setting the max_commit_delay value.
          Repeat.twice(
              () -> {
                executeCommit(connection);
                assertMaxCommitDelay(
                    Duration.newBuilder().setNanos((int) TimeUnit.MILLISECONDS.toNanos(40)).build(),
                    true);
                mockSpanner.clearRequests();
              });

          if (useSql) {
            // This is translated to Duration.ZERO.
            connection.execute(
                Statement.of(String.format("set %smax_commit_delay=null", getVariablePrefix())));
          } else {
            connection.setMaxCommitDelay(null);
          }
          executeCommit(connection);
          // The SQL statement set max_commit_delay=null is translated to Duration.ZERO.
          assertMaxCommitDelay(Duration.getDefaultInstance(), useSql);
          mockSpanner.clearRequests();

          if (useSql) {
            connection.execute(
                Statement.of(String.format("set %smax_commit_delay=0", getVariablePrefix())));
          } else {
            connection.setMaxCommitDelay(java.time.Duration.ZERO);
          }
          executeCommit(connection);
          assertMaxCommitDelay(Duration.getDefaultInstance(), true);
          mockSpanner.clearRequests();
        }
      }
    }
  }

  void executeCommit(Connection connection) {
    if (connection.isAutocommit()) {
      connection.write(createMutation());
    } else {
      connection.bufferedWrite(createMutation());
      connection.commit();
    }
  }

  private void assertMaxCommitDelay(Duration expected, boolean hasMaxCommitDelay) {
    List<CommitRequest> requests = mockSpanner.getRequestsOfType(CommitRequest.class);
    assertEquals(1, requests.size());
    CommitRequest request = requests.get(0);
    assertEquals(expected, request.getMaxCommitDelay());
    assertEquals(hasMaxCommitDelay, request.hasMaxCommitDelay());
  }
}
