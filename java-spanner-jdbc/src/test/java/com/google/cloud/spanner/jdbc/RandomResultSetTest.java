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

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.cloud.spanner.connection.SpannerPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RandomResultSetTest extends AbstractMockServerTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Before
  public void setupDialect() {
    mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
    RandomResultSetGenerator generator =
        new RandomResultSetGenerator(RANDOM_RESULT_SET_ROW_COUNT, dialect);
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_RANDOM_STATEMENT, generator.generate()));
  }

  @After
  public void reset() {
    // This ensures that each test gets a fresh Spanner instance. This is necessary to get a new
    // dialect result for each connection.
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testSelectRandomResults() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      try (ResultSet resultSet =
          connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
        ResultSetMetaData metadata = resultSet.getMetaData();
        int col = 0;
        assertEquals(Types.BOOLEAN, metadata.getColumnType(++col));
        assertEquals(Types.BIGINT, metadata.getColumnType(++col));
        assertEquals(Types.REAL, metadata.getColumnType(++col));
        assertEquals(Types.DOUBLE, metadata.getColumnType(++col));
        assertEquals(Types.NUMERIC, metadata.getColumnType(++col));
        assertEquals(Types.NVARCHAR, metadata.getColumnType(++col));
        assertEquals(Types.NVARCHAR, metadata.getColumnType(++col));
        assertEquals(Types.BINARY, metadata.getColumnType(++col));
        assertEquals(Types.DATE, metadata.getColumnType(++col));
        assertEquals(Types.OTHER, metadata.getColumnType(++col));
        assertEquals(Types.TIMESTAMP, metadata.getColumnType(++col));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(Types.BIGINT, metadata.getColumnType(++col));
        }

        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // boolean
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // bigint
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // real
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // double
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // numeric
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // nvarchar
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // nvarchar
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // binary
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // date
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // uuid
        assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // timestamp
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(Types.ARRAY, metadata.getColumnType(++col)); // oid
        }

        // GoogleSQL also includes proto columns.
        if (dialect == Dialect.GOOGLE_STANDARD_SQL) {
          // Skip for now, as support for this has not yet been added.
          // assertEquals(Types.OTHER, metadata.getColumnType(++col));
          // assertEquals(Types.OTHER, metadata.getColumnType(++col));
          // assertEquals(Types.ARRAY, metadata.getColumnType(++col));
          // assertEquals(Types.ARRAY, metadata.getColumnType(++col));
          col += 4;
        }

        assertEquals(col, metadata.getColumnCount());

        int rowCount = 0;
        while (resultSet.next()) {
          // Verify that we can get all columns as an object.
          for (col = 1; col <= resultSet.getMetaData().getColumnCount(); col++) {
            if (dialect == Dialect.POSTGRESQL && col == 17) {
              // getObject for ARRAY<PG_NUMERIC> tries to get the array as a List<BigDecimal>.
              // That fails if the array contains a NaN, so skipping.
            } else {
              resultSet.getObject(col);
            }
          }

          // Verify that we can get the results as the actual type.
          col = 0;
          resultSet.getBoolean(++col);
          resultSet.getLong(++col);
          resultSet.getFloat(++col);
          resultSet.getDouble(++col);
          resultSet.getFloat(++col);
          resultSet.getString(++col);
          resultSet.getString(++col); // JSON
          resultSet.getBytes(++col);
          resultSet.getDate(++col);
          resultSet.getObject(++col, UUID.class);
          resultSet.getTimestamp(++col);
          if (dialect == Dialect.POSTGRESQL) {
            resultSet.getLong(++col); // oid
          }

          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          if (dialect == Dialect.POSTGRESQL) {
            // Skipping, as getArray(..) returns an array of BigDecimal for PG_NUMERIC, and that is
            // not supported if the array contains a NaN.
            ++col;
          } else {
            resultSet.getArray(++col);
          }
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          resultSet.getArray(++col);
          if (dialect == Dialect.POSTGRESQL) {
            resultSet.getArray(++col); // oid[]
          }

          // GoogleSQL also includes proto columns.
          if (dialect == Dialect.GOOGLE_STANDARD_SQL) {
            // Skip for now, as support for this has not yet been added.
            col += 4;
          }
          assertEquals(col, resultSet.getMetaData().getColumnCount());

          rowCount++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, rowCount);
      }
    }
  }
}
