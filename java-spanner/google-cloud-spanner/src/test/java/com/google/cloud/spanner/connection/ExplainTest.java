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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PlanNode;
import com.google.spanner.v1.QueryPlan;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExplainTest extends AbstractMockServerTest {
  private static final Statement EXPLAIN_STATEMENT_QUERY =
      Statement.of("SELECT * FROM SomeTable ORDER BY Value");

  @BeforeClass
  public static void setupAnalyzeResults() {
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.POSTGRESQL));
    Struct metadata =
        Struct.newBuilder()
            .putFields("subquery_cluster_node", Value.newBuilder().setStringValue("1").build())
            .build();
    Struct cpuTime =
        Struct.newBuilder()
            .putFields("unit", Value.newBuilder().setStringValue("msec").build())
            .putFields("total_time", Value.newBuilder().setStringValue("10").build())
            .build();
    Struct executionStats =
        Struct.newBuilder()
            .putFields("cpu_time", Value.newBuilder().setStructValue(cpuTime).build())
            .build();
    ResultSetStats resultSetStats =
        ResultSetStats.newBuilder()
            .setQueryPlan(
                QueryPlan.newBuilder()
                    .addPlanNodes(
                        PlanNode.newBuilder()
                            .setDisplayName("some-plan-node")
                            .setMetadata(metadata)
                            .setExecutionStats(executionStats)
                            .build())
                    .build())
            .build();
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(
            EXPLAIN_STATEMENT_QUERY,
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .setName("Key")
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .setName("Value")
                                        .build())
                                .build())
                        .build())
                .setStats(resultSetStats)
                .build()));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  private void testExplain(String statement) {
    mockSpanner.clearRequests();
    final Statement explainStatement = Statement.of(statement);

    try (Connection connection = createConnection()) {

      try (ResultSet resultSet = connection.execute(explainStatement).getResultSet()) {
        int count = 0;

        while (resultSet.next()) {
          if (count == 1) {
            fail(
                "The resultset was expected t contains exactly 1 row but it contains more than 1"
                    + " row");
          }

          ++count;

          com.google.cloud.spanner.Struct row = resultSet.getCurrentRowAsStruct();

          assertEquals(1, row.getColumnCount());
          assertNotNull(row.getString("QUERY PLAN"));
          String expectedQueryPlan = "some-plan-node : { subquery_cluster_node : 1 }";
          assertEquals(expectedQueryPlan, row.getString("QUERY PLAN"));
        }
      }
    }

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());
    ExecuteSqlRequest request = requests.get(0);
    assertEquals(EXPLAIN_STATEMENT_QUERY.getSql(), request.getSql());
    assertEquals(QueryMode.PLAN, request.getQueryMode());
  }

  private void testExplainAnalyze(String statement) {
    mockSpanner.clearRequests();
    final Statement explainAnalyzeStatement = Statement.of(statement);
    try (Connection connection = createConnection()) {

      try (ResultSet resultSet = connection.execute(explainAnalyzeStatement).getResultSet()) {
        int count = 0;

        while (resultSet.next()) {
          if (count == 1) {
            fail(
                "The resultset was expected t contains exactly 1 row but it contains more than 1"
                    + " row");
          }

          ++count;

          com.google.cloud.spanner.Struct row = resultSet.getCurrentRowAsStruct();

          assertEquals(2, row.getColumnCount());

          assertNotNull(row.getString("QUERY PLAN"));
          String expectedQueryPlan = "some-plan-node : { subquery_cluster_node : 1 }";
          assertEquals(expectedQueryPlan, row.getString("QUERY PLAN"));

          assertNotNull(row.getString("EXECUTION STATS"));
          String expectedExecutionStats = "cpu_time : { unit : msec , total_time : 10 }";
          assertEquals(expectedExecutionStats, row.getString("EXECUTION STATS"));
        }
      }
    }

    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(1, requests.size());
    ExecuteSqlRequest request = requests.get(0);
    assertEquals(EXPLAIN_STATEMENT_QUERY.getSql(), request.getSql());
    assertEquals(QueryMode.PROFILE, request.getQueryMode());
  }

  @Test
  public void testValidExplain() {
    String statement = "Explain " + EXPLAIN_STATEMENT_QUERY;
    testExplain(statement);

    statement = "explain " + EXPLAIN_STATEMENT_QUERY;
    testExplain(statement);

    statement = "explain     " + EXPLAIN_STATEMENT_QUERY;
    testExplain(statement);

    statement = "explain \t (" + EXPLAIN_STATEMENT_QUERY + ") ";
    testExplain(statement);

    statement = "    explain \t ( \n   " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);

    statement = "    ExpLAin  (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);

    statement = "    EXPLAIN  (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);
  }

  @Test
  public void testValidExplainWithFalseAnalyze() {
    String statement = "    explain (analyze false)      " + EXPLAIN_STATEMENT_QUERY;
    testExplain(statement);

    statement = "    explain (analyze FALSE)      " + EXPLAIN_STATEMENT_QUERY + "    ";
    testExplain(statement);

    statement = "    explain (analyze fAlsE)  (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);

    statement = "    explain (analyze 0)  (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);

    statement = "    explain (analyze off)  (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplain(statement);

    statement =
        "    explain (analyze false, analyze true, analyze false, analyze false)      "
            + EXPLAIN_STATEMENT_QUERY;
    testExplain(statement);

    statement =
        "    explain (   analyze off , analyze true , analyze 0  )  (    "
            + EXPLAIN_STATEMENT_QUERY
            + "   ) ";
    testExplain(statement);

    statement =
        "    explain (   analyze off , analyze 0 , analyze 0  )  (    "
            + EXPLAIN_STATEMENT_QUERY
            + "   ) ";
    testExplain(statement);

    statement =
        "    explain (   analyze off , analyze,   analyze 0 , analyze false  )  (    "
            + EXPLAIN_STATEMENT_QUERY
            + "   ) ";
    testExplain(statement);
  }

  @Test
  public void testValidExplainAnalyze() {
    String statement = "Explain analyze " + EXPLAIN_STATEMENT_QUERY;
    testExplainAnalyze(statement);

    statement = "explain analyze " + EXPLAIN_STATEMENT_QUERY;
    testExplainAnalyze(statement);

    statement = "explain   analyze  " + EXPLAIN_STATEMENT_QUERY;
    testExplainAnalyze(statement);

    statement = "explain analyze (" + EXPLAIN_STATEMENT_QUERY + ") ";
    testExplainAnalyze(statement);

    statement = "    explain (  analyze true  ) (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement = "    ExpLAin(   analyze 1  ) (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement = "    ExpLAin(   analyze On  ) (    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement = "    EXPLAIN(analyze)(    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement =
        "    EXPLAIN(analyze , analyze false , analyze 1)(    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement =
        "    EXPLAIN(analyze , aNAlyzE false , analyze  )(    " + EXPLAIN_STATEMENT_QUERY + "   ) ";
    testExplainAnalyze(statement);

    statement =
        "    EXPLAIN(analyze off  , analyze false , AnalYZE  )(    "
            + EXPLAIN_STATEMENT_QUERY
            + "   ) ";
    testExplainAnalyze(statement);

    statement =
        "    EXPLAIN(analyze \n off  , analyze false , analyze  )(    "
            + EXPLAIN_STATEMENT_QUERY
            + " \t  ) ";
    testExplainAnalyze(statement);

    statement =
        "    EXPLAIN(analyse \n off  , analyze false , analyse  )(    "
            + EXPLAIN_STATEMENT_QUERY
            + " \t  ) ";
    testExplainAnalyze(statement);
  }

  @Test
  public void testInvalidExplain() {

    String statement = " explain  verbose " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement));

    String statement2 = " explain  foo " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement2));

    String statement3 = " explain  analyze analyze  " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement3));

    String statement4 = " explain  analyze true  " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement4));

    String statement5 = " explain  (analyze true , verbose )   " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement5));

    String statement6 = " explain  (analyze hello)   " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement6));

    String statement7 = " explain  (analyze true , verbose , costs )   " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement7));

    String statement8 = " explain  (analyze true , verbose , costs    " + EXPLAIN_STATEMENT_QUERY;
    assertThrows(SpannerException.class, () -> testExplain(statement8));
  }
}
