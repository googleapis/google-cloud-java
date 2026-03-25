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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITExplainTest extends ITAbstractSpannerTest {
  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false");
  }

  @BeforeClass
  public static void setupPostgreSQL() {
    assumeFalse("Emulator does not support PostgreSQL Dialect", isUsingEmulator());
    database = env.getTestHelper().createTestDatabase(Dialect.POSTGRESQL, Collections.emptyList());
  }

  @Before
  public void createTestTable() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      if (!tableExists(connection, "TEST")) {
        connection.setAutocommit(false);
        connection.startBatchDdl();
        connection.execute(
            Statement.of(
                "CREATE TABLE TEST (ID INT NOT NULL PRIMARY KEY, NAME VARCHAR(100) NOT NULL)"));
        connection.runBatch();
      }
    }
  }

  @Test
  public void testExplainStatement() {
    assumeFalse("Emulator does not support PostgreSQL Dialect", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newInsertBuilder("TEST").set("ID").to(3L).set("NAME").to("TEST-3").build(),
              Mutation.newInsertBuilder("TEST").set("ID").to(4L).set("NAME").to("TEST-4").build()));
      connection.commit();

      ResultSet resultSet =
          connection.execute(Statement.of("EXPLAIN SELECT * from TEST")).getResultSet();
      while (resultSet.next()) {
        assertNotNull(resultSet.getString("QUERY PLAN"));
      }
      assertEquals(1, resultSet.getColumnCount());
    }
  }

  @Test
  public void testExplainAnalyzeStatement() {
    assumeFalse("Emulator does not support PostgreSQL Dialect", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST-1").build(),
              Mutation.newInsertBuilder("TEST").set("ID").to(2L).set("NAME").to("TEST-2").build()));
      connection.commit();

      ResultSet resultSet =
          connection.execute(Statement.of("EXPLAIN ANALYZE SELECT * from TEST")).getResultSet();
      while (resultSet.next()) {
        assertNotNull(resultSet.getString("QUERY PLAN"));
        assertNotNull(resultSet.getString("EXECUTION STATS"));
      }
      assertEquals(2, resultSet.getColumnCount());
    }
  }
}
