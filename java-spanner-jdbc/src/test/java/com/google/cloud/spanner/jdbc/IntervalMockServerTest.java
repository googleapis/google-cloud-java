/*
 * Copyright 2026 Google LLC
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Duration;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntervalMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] parameters() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private static Dialect currentDialect;

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
      currentDialect = dialect;
    }
    mockSpanner.clearRequests();
  }

  @Test
  public void testSelectInterval() throws SQLException {
    String sql = "SELECT col_interval, col_interval_array FROM test_table";
    Interval interval = Interval.parseFromString("P1Y2M3DT4H5M6S");
    Interval arrayElement1 = Interval.ofMonths(6);
    Interval arrayElement2 = Interval.ofDays(15);

    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(sql),
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("col_interval")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.INTERVAL).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("col_interval_array")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.INTERVAL)
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setStringValue(interval.toString()).build())
                        .addValues(
                            Value.newBuilder()
                                .setListValue(
                                    ListValue.newBuilder()
                                        .addValues(
                                            Value.newBuilder()
                                                .setStringValue(arrayElement1.toString())
                                                .build())
                                        .addValues(
                                            Value.newBuilder()
                                                .setStringValue(arrayElement2.toString())
                                                .build())
                                        .addValues(
                                            Value.newBuilder()
                                                .setNullValue(
                                                    com.google.protobuf.NullValue.NULL_VALUE)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build()));

    try (Connection connection = createJdbcConnection();
        java.sql.Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
      ResultSetMetaData metadata = resultSet.getMetaData();
      assertEquals(Types.OTHER, metadata.getColumnType(1));
      assertEquals(
          dialect == Dialect.POSTGRESQL ? "interval" : "INTERVAL", metadata.getColumnTypeName(1));
      assertEquals(Interval.class.getName(), metadata.getColumnClassName(1));

      assertEquals(Types.ARRAY, metadata.getColumnType(2));
      assertEquals(
          dialect == Dialect.POSTGRESQL ? "_interval" : "ARRAY<INTERVAL>",
          metadata.getColumnTypeName(2));
      assertEquals(Interval[].class.getName(), metadata.getColumnClassName(2));

      assertTrue(resultSet.next());

      JdbcResultSet jdbcResultSet = (JdbcResultSet) resultSet;
      assertEquals(interval, jdbcResultSet.getInterval(1));
      assertEquals(interval, jdbcResultSet.getInterval("col_interval"));
      assertEquals(interval, resultSet.getObject(1));
      assertEquals(interval, resultSet.getObject(1, Interval.class));
      assertEquals(interval.toString(), resultSet.getString(1));

      Array array = resultSet.getArray(2);
      assertNotNull(array);
      assertEquals(IntervalType.VENDOR_TYPE_NUMBER, array.getBaseType());
      Interval[] elements = (Interval[]) array.getArray();
      assertEquals(3, elements.length);
      assertEquals(arrayElement1, elements[0]);
      assertEquals(arrayElement2, elements[1]);
      assertNull(elements[2]);

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testInsertInterval() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
            : "INSERT INTO test_table (id, col_interval, col_array) VALUES (?, ?, ?)";
    Interval interval = Interval.parseFromString("P1Y2M3DT4H5M6S");
    Interval[] intervalArray = new Interval[] {Interval.ofMonths(1), Interval.ofDays(2)};

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
                    : "INSERT INTO test_table (id, col_interval, col_array) VALUES (@p1, @p2, @p3)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(interval)
            .bind("p3")
            .to(com.google.cloud.spanner.Value.intervalArray(Arrays.asList(intervalArray)))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      statement.setObject(2, interval, IntervalType.INSTANCE);
      statement.setArray(3, connection.createArrayOf("INTERVAL", intervalArray));
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertEquals(
          interval.toString(), request.getParams().getFieldsOrThrow("p2").getStringValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());

      assertEquals(TypeCode.ARRAY, request.getParamTypesOrThrow("p3").getCode());
      assertEquals(
          TypeCode.INTERVAL, request.getParamTypesOrThrow("p3").getArrayElementType().getCode());
      ListValue arrayValues = request.getParams().getFieldsOrThrow("p3").getListValue();
      assertEquals(2, arrayValues.getValuesCount());
      assertEquals(intervalArray[0].toString(), arrayValues.getValues(0).getStringValue());
      assertEquals(intervalArray[1].toString(), arrayValues.getValues(1).getStringValue());
    }
  }

  @Test
  public void testInsertIntervalFromString() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval) VALUES ($1, $2)"
            : "INSERT INTO test_table (id, col_interval) VALUES (?, ?)";
    String intervalString = "P1Y2M3DT4H5M6S";

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval) VALUES ($1, $2)"
                    : "INSERT INTO test_table (id, col_interval) VALUES (@p1, @p2)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(Interval.parseFromString(intervalString))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      statement.setObject(2, intervalString, IntervalType.INSTANCE);
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertEquals(intervalString, request.getParams().getFieldsOrThrow("p2").getStringValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());
    }
  }

  @Test
  public void testInsertNullInterval() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
            : "INSERT INTO test_table (id, col_interval, col_array) VALUES (?, ?, ?)";

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
                    : "INSERT INTO test_table (id, col_interval, col_array) VALUES (@p1, @p2, @p3)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to((Interval) null)
            .bind("p3")
            .to(com.google.cloud.spanner.Value.intervalArray((List<Interval>) null))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      statement.setNull(2, IntervalType.VENDOR_TYPE_NUMBER);
      statement.setArray(3, connection.createArrayOf("INTERVAL", null));
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertTrue(request.getParams().getFieldsOrThrow("p2").hasNullValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());

      assertTrue(request.getParams().getFieldsOrThrow("p3").hasNullValue());
      assertEquals(TypeCode.ARRAY, request.getParamTypesOrThrow("p3").getCode());
      assertEquals(
          TypeCode.INTERVAL, request.getParamTypesOrThrow("p3").getArrayElementType().getCode());
    }
  }

  @Test
  public void testInsertDuration() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
            : "INSERT INTO test_table (id, col_interval, col_array) VALUES (?, ?, ?)";
    Duration duration = Duration.ofHours(1).plusMinutes(30);
    Duration[] durationArray = new Duration[] {Duration.ofMinutes(15), Duration.ofSeconds(45)};

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
                    : "INSERT INTO test_table (id, col_interval, col_array) VALUES (@p1, @p2, @p3)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(JdbcTypeConverter.toInterval(duration))
            .bind("p3")
            .to(
                com.google.cloud.spanner.Value.intervalArray(
                    Arrays.asList(
                        JdbcTypeConverter.toInterval(durationArray[0]),
                        JdbcTypeConverter.toInterval(durationArray[1]))))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      // Consistent with pgjdbc: java.time.Duration is bound as INTERVAL
      statement.setObject(2, duration, IntervalType.INSTANCE);
      statement.setArray(3, connection.createArrayOf("INTERVAL", durationArray));
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertEquals("PT1H30M", request.getParams().getFieldsOrThrow("p2").getStringValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());

      assertEquals(TypeCode.ARRAY, request.getParamTypesOrThrow("p3").getCode());
      assertEquals(
          TypeCode.INTERVAL, request.getParamTypesOrThrow("p3").getArrayElementType().getCode());
      ListValue arrayValues = request.getParams().getFieldsOrThrow("p3").getListValue();
      assertEquals(2, arrayValues.getValuesCount());
      assertEquals("PT15M", arrayValues.getValues(0).getStringValue());
      assertEquals("PT45S", arrayValues.getValues(1).getStringValue());
    }
  }

  @Test
  public void testInsertPeriod() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
            : "INSERT INTO test_table (id, col_interval, col_array) VALUES (?, ?, ?)";
    Period period = Period.of(1, 2, 3);
    Period[] periodArray = new Period[] {Period.ofMonths(1), Period.ofDays(2)};

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
                    : "INSERT INTO test_table (id, col_interval, col_array) VALUES (@p1, @p2, @p3)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(JdbcTypeConverter.toInterval(period))
            .bind("p3")
            .to(
                com.google.cloud.spanner.Value.intervalArray(
                    Arrays.asList(
                        JdbcTypeConverter.toInterval(periodArray[0]),
                        JdbcTypeConverter.toInterval(periodArray[1]))))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      // Consistent with pgjdbc: java.time.Period is bound as INTERVAL
      statement.setObject(2, period, IntervalType.INSTANCE);
      statement.setArray(3, connection.createArrayOf("INTERVAL", periodArray));
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertEquals("P1Y2M3D", request.getParams().getFieldsOrThrow("p2").getStringValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());

      assertEquals(TypeCode.ARRAY, request.getParamTypesOrThrow("p3").getCode());
      assertEquals(
          TypeCode.INTERVAL, request.getParamTypesOrThrow("p3").getArrayElementType().getCode());
      ListValue arrayValues = request.getParams().getFieldsOrThrow("p3").getListValue();
      assertEquals(2, arrayValues.getValuesCount());
      assertEquals("P1M", arrayValues.getValues(0).getStringValue());
      assertEquals("P2D", arrayValues.getValues(1).getStringValue());
    }
  }

  @Test
  public void testInsertSpannerValue() throws SQLException {
    String sql =
        dialect == Dialect.POSTGRESQL
            ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
            : "INSERT INTO test_table (id, col_interval, col_array) VALUES (?, ?, ?)";
    Interval interval = Interval.parseFromString("P1Y2M3DT4H5M6S");
    com.google.cloud.spanner.Value spannerValue = com.google.cloud.spanner.Value.interval(interval);
    com.google.cloud.spanner.Value spannerArrayValue =
        com.google.cloud.spanner.Value.intervalArray(Arrays.asList(interval, null));

    Statement insertStatement =
        Statement.newBuilder(
                dialect == Dialect.POSTGRESQL
                    ? "INSERT INTO test_table (id, col_interval, col_array) VALUES ($1, $2, $3)"
                    : "INSERT INTO test_table (id, col_interval, col_array) VALUES (@p1, @p2, @p3)")
            .bind("p1")
            .to(1L)
            .bind("p2")
            .to(interval)
            .bind("p3")
            .to(com.google.cloud.spanner.Value.intervalArray(Arrays.asList(interval, null)))
            .build();
    mockSpanner.putStatementResult(StatementResult.update(insertStatement, 1L));

    try (Connection connection = createJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setLong(1, 1L);
      // Bind with explicit IntervalType
      statement.setObject(2, spannerValue, IntervalType.INSTANCE);
      // Bind array Value
      statement.setObject(3, spannerArrayValue);
      assertEquals(1, statement.executeUpdate());

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);

      assertEquals("P1Y2M3DT4H5M6S", request.getParams().getFieldsOrThrow("p2").getStringValue());
      assertEquals(TypeCode.INTERVAL, request.getParamTypesOrThrow("p2").getCode());

      assertEquals(TypeCode.ARRAY, request.getParamTypesOrThrow("p3").getCode());
      assertEquals(
          TypeCode.INTERVAL, request.getParamTypesOrThrow("p3").getArrayElementType().getCode());
      ListValue arrayValues = request.getParams().getFieldsOrThrow("p3").getListValue();
      assertEquals(2, arrayValues.getValuesCount());
      assertEquals("P1Y2M3DT4H5M6S", arrayValues.getValues(0).getStringValue());
      assertEquals(Value.KindCase.NULL_VALUE, arrayValues.getValues(1).getKindCase());
    }
  }
}
