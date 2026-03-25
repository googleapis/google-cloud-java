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

import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier;
import com.google.common.collect.ImmutableMap;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** This test class runs a SQL script for testing a connection in read-only mode. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITJdbcReadOnlyTest extends ITAbstractJdbcTest {
  private static final long TEST_ROWS_COUNT = 1000L;

  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    final Map<String, String> googleStandardSqlScripts =
        ImmutableMap.of("TEST_READ_ONLY", "ITReadOnlySpannerTest.sql");
    final Map<String, String> postgresScripts =
        ImmutableMap.of("TEST_READ_ONLY", "PostgreSQL/ITReadOnlySpannerTest.sql");
    params.add(
        new DialectTestParameter(
            Dialect.GOOGLE_STANDARD_SQL,
            "ITReadOnlySpannerTest_CreateTables.sql",
            googleStandardSqlScripts,
            new String[] {"SELECT * FROM PRIME_NUMBERS", "SELECT * FROM NUMBERS"}));
    params.add(
        new DialectTestParameter(
            Dialect.POSTGRESQL,
            "PostgreSQL/ITReadOnlySpannerTest_CreateTables.sql",
            postgresScripts,
            new String[] {"SELECT * FROM PRIME_NUMBERS", "SELECT * FROM NUMBERS"}));
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

  @Override
  protected void appendConnectionUri(StringBuilder url) {
    url.append(";readOnly=true");
  }

  @Before
  public void createTestTables() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      if (!(tableExists(connection, "NUMBERS") && tableExists(connection, "PRIME_NUMBERS"))) {
        // create tables
        JdbcSqlScriptVerifier verifier =
            new JdbcSqlScriptVerifier(new ITJdbcConnectionProvider(env, database));
        verifier.verifyStatementsInFile(
            dialect.createTableFile, JdbcSqlScriptVerifier.class, false);

        // fill tables with data
        connection.setAutoCommit(false);
        connection.setReadOnly(false);
        for (long number = 1L; number <= TEST_ROWS_COUNT; number++) {
          connection.bufferedWrite(
              Mutation.newInsertBuilder("NUMBERS")
                  .set("number")
                  .to(number)
                  .set("name")
                  .to(Long.toBinaryString(number))
                  .build());
        }
        for (long number = 1L; number <= TEST_ROWS_COUNT; number++) {
          if (BigInteger.valueOf(number).isProbablePrime(Integer.MAX_VALUE)) {
            connection.bufferedWrite(
                Mutation.newInsertBuilder("PRIME_NUMBERS")
                    .set("prime_number")
                    .to(number)
                    .set("binary_representation")
                    .to(Long.toBinaryString(number))
                    .build());
          }
        }
        connection.commit();
      }
    }
  }

  @After
  public void closeSpanner() {
    ConnectionOptions.closeSpanner();
  }

  @Test
  public void testSqlScript() throws Exception {
    // Wait 100ms to ensure that staleness tests in the script succeed.
    Thread.sleep(100L);
    JdbcSqlScriptVerifier verifier =
        new JdbcSqlScriptVerifier(new ITJdbcConnectionProvider(env, database));
    verifier.verifyStatementsInFile(
        dialect.executeQueriesFiles.get("TEST_READ_ONLY"), JdbcSqlScriptVerifier.class, false);
  }

  @Test
  public void testMultipleOpenResultSets() throws InterruptedException, SQLException {
    try (Connection connection = createConnection(env, database)) {
      List<ResultSet> resultSets = new ArrayList<ResultSet>();
      ExecutorService exec = Executors.newFixedThreadPool(2);
      for (String query : dialect.queries) {
        final java.sql.ResultSet rs = connection.createStatement().executeQuery(query);
        exec.submit(
            () -> {
              try {
                while (rs.next()) {
                  assertTrue(rs.getInt(1) > 0);
                }
              } catch (SQLException e) {
                throw new RuntimeException(e);
              }
            });
        resultSets.add(rs);
      }
      exec.shutdown();
      assertTrue(exec.awaitTermination(1000L, TimeUnit.SECONDS));
      resultSets.forEach(
          resultSet -> {
            try {
              resultSet.close();
            } catch (SQLException e) {
              throw new RuntimeException(e);
            }
          });
    }
  }
}
