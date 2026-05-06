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
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.*;
import com.google.spanner.v1.DirectedReadOptions.ExcludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.StructType.Field;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DirectedReadTest extends AbstractMockServerTest {
  private static final Statement READ_STATEMENT = Statement.of("SELECT 1 AS C");

  private static final Statement GOOGLESQL_DML_STATEMENT =
      Statement.of("INSERT INTO T (id) VALUES (1) THEN RETURN ID");
  private static final Statement POSTGRESQL_DML_STATEMENT =
      Statement.of("INSERT INTO T (id) VALUES (1) RETURNING ID");

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

  @BeforeClass
  public static void setupQueryResults() {
    com.google.spanner.v1.ResultSet resultSet =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                Field.newBuilder()
                                    .setName("C")
                                    .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                    .build())
                            .build())
                    .build())
            .addRows(
                ListValue.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("1").build())
                    .build())
            .build();
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(READ_STATEMENT, resultSet));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(
            GOOGLESQL_DML_STATEMENT,
            resultSet.toBuilder()
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(
            POSTGRESQL_DML_STATEMENT,
            resultSet.toBuilder()
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
  }

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

  private String getVariablePrefix() {
    return dialect == Dialect.POSTGRESQL ? "spanner." : "";
  }

  private Statement getDmlStatement() {
    return dialect == Dialect.POSTGRESQL ? POSTGRESQL_DML_STATEMENT : GOOGLESQL_DML_STATEMENT;
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testNoDirectedReadByDefault() {
    try (Connection connection = createConnection()) {
      for (boolean readOnly : new boolean[] {true, false}) {
        for (boolean autocommit : new boolean[] {true, false}) {
          connection.setAutocommit(autocommit);
          connection.setReadOnly(readOnly);

          executeReadQuery(connection);
          assertDirectedReadOptions(DirectedReadOptions.getDefaultInstance());

          if (!autocommit) {
            connection.commit();
          }
          mockSpanner.clearRequests();
        }
      }
    }
  }

  @Test
  public void testSetDirectedRead() {
    for (DirectedReadOptions expected :
        new DirectedReadOptions[] {
          DirectedReadOptions.newBuilder()
              .setIncludeReplicas(
                  IncludeReplicas.newBuilder()
                      .addReplicaSelections(
                          ReplicaSelection.newBuilder()
                              .setLocation("eu-west1")
                              .setType(ReplicaSelection.Type.READ_ONLY)
                              .build())
                      .build())
              .build(),
          DirectedReadOptions.newBuilder()
              .setExcludeReplicas(
                  ExcludeReplicas.newBuilder()
                      .addReplicaSelections(
                          ReplicaSelection.newBuilder()
                              .setLocation("eu-west1")
                              .setType(ReplicaSelection.Type.READ_ONLY)
                              .build())
                      .build())
              .build(),
          DirectedReadOptions.newBuilder().build()
        }) {
      try (Connection connection = createConnection()) {
        connection.setAutocommit(true);
        connection.execute(
            Statement.of(
                String.format(
                    "set %sdirected_read='%s'",
                    getVariablePrefix(), DirectedReadOptionsUtil.toString(expected))));
        Repeat.twice(
            () -> {
              executeReadQuery(connection);
              assertDirectedReadOptions(expected);
              mockSpanner.clearRequests();
            });

        // Reset to default.
        connection.execute(
            Statement.of(String.format("set %sdirected_read=''", getVariablePrefix())));
        executeReadQuery(connection);
        assertDirectedReadOptions(DirectedReadOptions.getDefaultInstance());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testDirectedReadIsIgnoredForDmlInAutoCommit() {
    DirectedReadOptions options =
        DirectedReadOptions.newBuilder()
            .setExcludeReplicas(
                ExcludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder()
                            .setLocation("eu-west1")
                            .setType(ReplicaSelection.Type.READ_ONLY)
                            .build())
                    .build())
            .build();

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.execute(
          Statement.of(
              String.format(
                  "set %sdirected_read='%s'",
                  getVariablePrefix(), DirectedReadOptionsUtil.toString(options))));
      // DML should not use directed read.
      executeDmlQuery(connection);
      assertDirectedReadOptions(DirectedReadOptions.getDefaultInstance());
    }
  }

  @Test
  public void testDirectedReadIsIgnoredInReadWriteTransaction() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(false);

      for (Statement statement : new Statement[] {READ_STATEMENT, getDmlStatement()}) {
        connection.execute(
            Statement.of(
                String.format(
                    "set %sdirected_read='%s'",
                    getVariablePrefix(),
                    DirectedReadOptionsUtil.toString(
                        DirectedReadOptions.newBuilder()
                            .setIncludeReplicas(
                                IncludeReplicas.newBuilder()
                                    .addReplicaSelections(
                                        ReplicaSelection.newBuilder()
                                            .setType(ReplicaSelection.Type.READ_WRITE)
                                            .setLocation("us-west1")
                                            .build())
                                    .build())
                            .build()))));
        // This uses a read/write transaction, which will ignore any DirectedReadOptions.
        executeQuery(connection, statement);
        assertDirectedReadOptions(DirectedReadOptions.getDefaultInstance());

        connection.commit();
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testDirectedReadIsUsedInReadOnlyTransaction() {
    DirectedReadOptions expected =
        DirectedReadOptions.newBuilder()
            .setIncludeReplicas(
                IncludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder()
                            .setType(ReplicaSelection.Type.READ_WRITE)
                            .setLocation("us-west1")
                            .build())
                    .build())
            .build();

    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(true);

      connection.execute(
          Statement.of(
              String.format(
                  "set %sdirected_read='%s'",
                  getVariablePrefix(), DirectedReadOptionsUtil.toString(expected))));
      // This uses a read-only transaction, which will use the DirectedReadOptions.
      // Repeatedly executing a query on the same connection will also continue to use the
      // DirectedReadOptions that have been set for the connection.
      Repeat.twice(
          () -> {
            executeReadQuery(connection);
            assertDirectedReadOptions(expected);
            mockSpanner.clearRequests();
          });
    }
  }

  private void executeReadQuery(Connection connection) {
    executeQuery(connection, READ_STATEMENT);
  }

  private void executeDmlQuery(Connection connection) {
    executeQuery(connection, getDmlStatement());
  }

  private void executeQuery(Connection connection, Statement statement) {
    try (ResultSet resultSet = connection.executeQuery(statement)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }
  }

  private void assertDirectedReadOptions(DirectedReadOptions expected) {
    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());
    ExecuteSqlRequest request = requests.get(0);
    assertEquals(expected, request.getDirectedReadOptions());
  }
}
