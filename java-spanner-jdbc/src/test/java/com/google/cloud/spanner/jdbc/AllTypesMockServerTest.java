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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AllTypesMockServerTest
    extends com.google.cloud.spanner.connection.AllTypesMockServerTest {

  @Override
  @Test
  public void testSelectAllTypes() {
    try (Connection connection = createJdbcConnection()) {
      try (ResultSet resultSet =
          connection.createStatement().executeQuery(SELECT_STATEMENT.getSql())) {
        assertTrue(resultSet.next());

        int col = 0;
        assertEquals(BOOL_VALUE, resultSet.getBoolean(++col));
        assertEquals(INT64_VALUE, resultSet.getLong(++col));
        assertEquals(FLOAT32_VALUE, resultSet.getFloat(++col), 0.0f);
        assertEquals(FLOAT64_VALUE, resultSet.getDouble(++col), 0.0d);
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(PG_NUMERIC_VALUE, resultSet.getString(++col));
        } else {
          assertEquals(NUMERIC_VALUE, resultSet.getBigDecimal(++col));
        }
        assertEquals(STRING_VALUE, resultSet.getString(++col));
        assertEquals(JSON_VALUE, resultSet.getString(++col));
        assertArrayEquals(BYTES_VALUE, resultSet.getBytes(++col));
        assertEquals(
            new java.sql.Date(
                DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
            resultSet.getDate(++col));
        assertEquals(UUID_VALUE, resultSet.getObject(++col, UUID.class));
        assertEquals(TIMESTAMP_VALUE.toSqlTimestamp(), resultSet.getTimestamp(++col));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(PG_OID_VALUE, resultSet.getLong(++col));
        }

        assertEquals(
            BOOL_ARRAY_VALUE, Arrays.asList((Boolean[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            INT64_ARRAY_VALUE, Arrays.asList((Long[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            FLOAT32_ARRAY_VALUE, Arrays.asList((Float[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            FLOAT64_ARRAY_VALUE, Arrays.asList((Double[]) resultSet.getArray(++col).getArray()));
        if (dialect == Dialect.POSTGRESQL) {
          // TODO: Fix getting an ARRAY<PG_NUMERIC>. This currently tries to cast it to a
          // BigDecimal[], which is not supported for NaN values.
          // assertEquals(PG_NUMERIC_ARRAY_VALUE, Arrays.asList((String[])
          // resultSet.getArray(++col).getArray()));
          ++col;
        } else {
          assertEquals(
              NUMERIC_ARRAY_VALUE,
              Arrays.asList((BigDecimal[]) resultSet.getArray(++col).getArray()));
        }
        assertEquals(
            STRING_ARRAY_VALUE, Arrays.asList((String[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            JSON_ARRAY_VALUE, Arrays.asList((String[]) resultSet.getArray(++col).getArray()));
        // Convert bytes to base64 strings, as the equals(..) method for byte[] uses ==.
        assertEquals(
            BYTES_ARRAY_VALUE.stream()
                .map(bytes -> bytes == null ? null : bytes.toBase64())
                .collect(Collectors.toList()),
            Arrays.stream((byte[][]) resultSet.getArray(++col).getArray())
                .map(bytes -> bytes == null ? null : Base64.getEncoder().encodeToString(bytes))
                .collect(Collectors.toList()));
        assertEquals(
            DATE_ARRAY_VALUE.stream()
                .map(
                    date ->
                        date == null
                            ? null
                            : new Date(
                                date.getYear() - 1900, date.getMonth() - 1, date.getDayOfMonth()))
                .collect(Collectors.toList()),
            Arrays.asList((Date[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            UUID_ARRAY_VALUE, Arrays.asList((UUID[]) resultSet.getArray(++col).getArray()));
        assertEquals(
            TIMESTAMP_ARRAY_VALUE.stream()
                .map(timestamp -> timestamp == null ? null : timestamp.toSqlTimestamp())
                .collect(Collectors.toList()),
            Arrays.asList((Timestamp[]) resultSet.getArray(++col).getArray()));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(
              PG_OID_ARRAY_VALUE, Arrays.asList((Long[]) resultSet.getArray(++col).getArray()));
        }

        assertFalse(resultSet.next());
      }
    } catch (SQLException sqlException) {
      throw new RuntimeException(sqlException);
    }
  }

  @Override
  @Test
  public void testInsertAllTypes() {
    Statement insertStatement = createInsertStatement(dialect);
    if (dialect == Dialect.POSTGRESQL) {
      // TODO: Remove when PG_NUMERIC NaN is supported.
      insertStatement =
          insertStatement.toBuilder()
              .replace(insertStatement.getSql().replaceAll("@p", "\\$"))
              .bind("p17")
              .to(
                  com.google.cloud.spanner.Value.pgNumericArray(
                      NUMERIC_ARRAY_VALUE.stream()
                          .map(
                              bigDecimal ->
                                  bigDecimal == null ? null : bigDecimal.toEngineeringString())
                          .collect(Collectors.toList())))
              .build();
    }
    // The JDBC driver binds UUID values as untyped strings, so we need to add it as 'partial'
    // result, meaning that the match will only be made based on the SQL string.
    mockSpanner.putPartialStatementResult(StatementResult.update(insertStatement, 1L));
    try (Connection connection = createJdbcConnection()) {
      try (PreparedStatement statement =
          connection.prepareStatement(
              createInsertStatement(dialect).getSql().replaceAll("@p\\d+", "?"))) {
        int param = 0;
        statement.setBoolean(++param, BOOL_VALUE);
        statement.setLong(++param, INT64_VALUE);
        statement.setFloat(++param, FLOAT32_VALUE);
        statement.setDouble(++param, FLOAT64_VALUE);
        if (dialect == Dialect.POSTGRESQL) {
          statement.setBigDecimal(++param, new BigDecimal(PG_NUMERIC_VALUE));
        } else {
          statement.setBigDecimal(++param, NUMERIC_VALUE);
        }
        statement.setString(++param, STRING_VALUE);
        if (dialect == Dialect.POSTGRESQL) {
          statement.setObject(++param, JSON_VALUE, JdbcDataType.PG_JSONB.getSqlType());
        } else {
          statement.setObject(++param, JSON_VALUE, JdbcDataType.JSON.getSqlType());
        }
        statement.setBytes(++param, BYTES_VALUE);
        statement.setDate(
            ++param,
            new Date(
                DATE_VALUE.getYear() - 1900,
                DATE_VALUE.getMonth() - 1,
                DATE_VALUE.getDayOfMonth()));
        statement.setObject(++param, UUID_VALUE);
        statement.setTimestamp(++param, TIMESTAMP_VALUE.toSqlTimestamp());
        if (dialect == Dialect.POSTGRESQL) {
          statement.setLong(++param, PG_OID_VALUE);
        }

        // TODO: Support PostgreSQL type names for creating arrays.
        statement.setArray(
            ++param, connection.createArrayOf("BOOL", BOOL_ARRAY_VALUE.toArray(new Boolean[0])));
        statement.setArray(
            ++param, connection.createArrayOf("INT64", INT64_ARRAY_VALUE.toArray(new Long[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf("FLOAT32", FLOAT32_ARRAY_VALUE.toArray(new Float[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf("FLOAT64", FLOAT64_ARRAY_VALUE.toArray(new Double[0])));

        // TODO: Make dialect-specific when NaN in arrays for PG_NUMERIC is supported.
        //        statement.setArray(
        //            ++param,
        //            connection.createArrayOf(
        //                "NUMERIC",
        //                dialect == Dialect.POSTGRESQL
        //                    ? PG_NUMERIC_ARRAY_VALUE.toArray(new String[0])
        //                    : NUMERIC_ARRAY_VALUE.toArray(new BigDecimal[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf(
                dialect == Dialect.POSTGRESQL ? "PG_NUMERIC" : "NUMERIC",
                NUMERIC_ARRAY_VALUE.toArray(new BigDecimal[0])));

        statement.setArray(
            ++param, connection.createArrayOf("STRING", STRING_ARRAY_VALUE.toArray(new String[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf(
                dialect == Dialect.POSTGRESQL ? "JSONB" : "JSON",
                JSON_ARRAY_VALUE.toArray(new String[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf(
                "BYTES",
                BYTES_ARRAY_VALUE.stream()
                    .map(bytes -> bytes == null ? null : bytes.toByteArray())
                    .toArray(byte[][]::new)));
        statement.setArray(
            ++param,
            connection.createArrayOf(
                "DATE",
                DATE_ARRAY_VALUE.stream()
                    .map(
                        date ->
                            date == null
                                ? null
                                : new Date(
                                    date.getYear() - 1900,
                                    date.getMonth() - 1,
                                    date.getDayOfMonth()))
                    .toArray(Date[]::new)));
        statement.setArray(
            ++param, connection.createArrayOf("UUID", UUID_ARRAY_VALUE.toArray(new UUID[0])));
        statement.setArray(
            ++param,
            connection.createArrayOf(
                "TIMESTAMP",
                TIMESTAMP_ARRAY_VALUE.stream()
                    .map(timestamp -> timestamp == null ? null : timestamp.toSqlTimestamp())
                    .toArray(Timestamp[]::new)));
        if (dialect == Dialect.POSTGRESQL) {
          statement.setArray(
              ++param, connection.createArrayOf("INT64", PG_OID_ARRAY_VALUE.toArray(new Long[0])));
        }

        assertEquals(1, statement.executeUpdate());
      }

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      Map<String, Type> paramTypes = request.getParamTypesMap();
      Map<String, Value> params = request.getParams().getFieldsMap();
      // UUID is sent without any type information to allow it to be used with any type of column
      // that accepts a STRING value.
      assertEquals(dialect == Dialect.POSTGRESQL ? 23 : 21, paramTypes.size());
      assertEquals(dialect == Dialect.POSTGRESQL ? 24 : 22, params.size());

      // Verify param types.
      ImmutableList<TypeCode> expectedTypes =
          ImmutableList.of(
              TypeCode.BOOL,
              TypeCode.INT64,
              TypeCode.FLOAT32,
              TypeCode.FLOAT64,
              TypeCode.NUMERIC,
              TypeCode.STRING,
              TypeCode.JSON,
              TypeCode.BYTES,
              TypeCode.DATE,
              TypeCode.TYPE_CODE_UNSPECIFIED, // UUID
              TypeCode.TIMESTAMP);
      if (dialect == Dialect.POSTGRESQL) {
        expectedTypes =
            ImmutableList.<TypeCode>builder().addAll(expectedTypes).add(TypeCode.INT64).build();
      }
      for (int col = 0; col < expectedTypes.size(); col++) {
        TypeCode expectedType = expectedTypes.get(col);
        if (expectedType == TypeCode.TYPE_CODE_UNSPECIFIED) {
          assertFalse(paramTypes.containsKey("p" + (col + 1)));
        } else {
          assertEquals(expectedType, paramTypes.get("p" + (col + 1)).getCode());
        }
        int arrayCol = col + expectedTypes.size();
        assertEquals(TypeCode.ARRAY, paramTypes.get("p" + (arrayCol + 1)).getCode());
        if (expectedType != TypeCode.TYPE_CODE_UNSPECIFIED) {
          assertEquals(
              expectedType, paramTypes.get("p" + (arrayCol + 1)).getArrayElementType().getCode());
        }
      }

      // Verify param values.
      int col = 0;
      assertEquals(BOOL_VALUE, params.get("p" + ++col).getBoolValue());
      assertEquals(String.valueOf(INT64_VALUE), params.get("p" + ++col).getStringValue());
      assertEquals(FLOAT32_VALUE, params.get("p" + ++col).getNumberValue(), 0.0d);
      assertEquals(FLOAT64_VALUE, params.get("p" + ++col).getNumberValue(), 0.0d);
      assertEquals(
          dialect == Dialect.POSTGRESQL ? PG_NUMERIC_VALUE : NUMERIC_VALUE.toEngineeringString(),
          params.get("p" + ++col).getStringValue());
      assertEquals(STRING_VALUE, params.get("p" + ++col).getStringValue());
      assertEquals(JSON_VALUE, params.get("p" + ++col).getStringValue());
      assertEquals(
          Base64.getEncoder().encodeToString(BYTES_VALUE),
          params.get("p" + ++col).getStringValue());
      assertEquals(DATE_VALUE.toString(), params.get("p" + ++col).getStringValue());
      assertEquals(UUID_VALUE.toString(), params.get("p" + ++col).getStringValue());
      assertEquals(TIMESTAMP_VALUE.toString(), params.get("p" + ++col).getStringValue());
      if (dialect == Dialect.POSTGRESQL) {
        assertEquals(String.valueOf(PG_OID_VALUE), params.get("p" + ++col).getStringValue());
      }

      assertEquals(
          BOOL_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : value.getBoolValue())
              .collect(Collectors.toList()));
      assertEquals(
          INT64_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : Long.valueOf(value.getStringValue()))
              .collect(Collectors.toList()));
      assertEquals(
          FLOAT32_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : (float) value.getNumberValue())
              .collect(Collectors.toList()));
      assertEquals(
          FLOAT64_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : value.getNumberValue())
              .collect(Collectors.toList()));
      if (dialect == Dialect.POSTGRESQL) {
        // TODO: Replace with PG specific value when NaN is supported.
        //          assertEquals(
        //              PG_NUMERIC_ARRAY_VALUE,
        //              params.get("p" + ++col).getListValue().getValuesList().stream()
        //                  .map(value -> value.hasNullValue() ? null : value.getStringValue())
        //                  .collect(Collectors.toList()));
        assertEquals(
            NUMERIC_ARRAY_VALUE,
            params.get("p" + ++col).getListValue().getValuesList().stream()
                .map(value -> value.hasNullValue() ? null : new BigDecimal(value.getStringValue()))
                .collect(Collectors.toList()));
      } else {
        assertEquals(
            NUMERIC_ARRAY_VALUE,
            params.get("p" + ++col).getListValue().getValuesList().stream()
                .map(value -> value.hasNullValue() ? null : new BigDecimal(value.getStringValue()))
                .collect(Collectors.toList()));
      }
      assertEquals(
          STRING_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : value.getStringValue())
              .collect(Collectors.toList()));
      assertEquals(
          JSON_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : value.getStringValue())
              .collect(Collectors.toList()));
      assertEquals(
          BYTES_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(
                  value ->
                      value.hasNullValue() ? null : ByteArray.fromBase64(value.getStringValue()))
              .collect(Collectors.toList()));
      assertEquals(
          DATE_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(
                  value ->
                      value.hasNullValue()
                          ? null
                          : com.google.cloud.Date.parseDate(value.getStringValue()))
              .collect(Collectors.toList()));
      assertEquals(
          UUID_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(value -> value.hasNullValue() ? null : UUID.fromString(value.getStringValue()))
              .collect(Collectors.toList()));
      assertEquals(
          TIMESTAMP_ARRAY_VALUE,
          params.get("p" + ++col).getListValue().getValuesList().stream()
              .map(
                  value ->
                      value.hasNullValue()
                          ? null
                          : com.google.cloud.Timestamp.parseTimestamp(value.getStringValue()))
              .collect(Collectors.toList()));
      if (dialect == Dialect.POSTGRESQL) {
        assertEquals(
            PG_OID_ARRAY_VALUE,
            params.get("p" + ++col).getListValue().getValuesList().stream()
                .map(value -> value.hasNullValue() ? null : Long.valueOf(value.getStringValue()))
                .collect(Collectors.toList()));
      }
    } catch (SQLException sqlException) {
      throw new RuntimeException(sqlException);
    }
  }
}
