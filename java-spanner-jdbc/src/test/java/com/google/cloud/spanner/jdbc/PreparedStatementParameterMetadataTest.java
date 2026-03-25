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

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PreparedStatementParameterMetadataTest extends AbstractMockServerTest {

  @After
  public void reset() {
    // This ensures that each test gets a fresh Spanner instance. This is necessary to get a new
    // dialect result for each connection.
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testAllTypesParameterMetadata_GoogleSql() throws SQLException {
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.GOOGLE_STANDARD_SQL));

    String baseSql =
        "insert into all_types (col_bool, col_bytes, col_date, col_float32, col_float64, col_int64, "
            + "col_json, col_numeric, col_string, col_timestamp, col_bool_array, col_bytes_array, "
            + "col_date_array, col_float32_array, col_float64_array, col_int64_array, col_json_array,"
            + "col_numeric_array, col_string_array, col_timestamp_array) values (%s)";
    String jdbcSql =
        String.format(
            baseSql,
            IntStream.range(0, 20).mapToObj(ignored -> "?").collect(Collectors.joining(", ")));
    String googleSql =
        String.format(
            baseSql,
            IntStream.range(1, 21)
                .mapToObj(index -> "@p" + index)
                .collect(Collectors.joining(", ")));
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(googleSql),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setUndeclaredParameters(
                            createAllTypesParameters(Dialect.GOOGLE_STANDARD_SQL))
                        .build())
                .setStats(ResultSetStats.newBuilder().build())
                .build()));

    try (Connection connection = createJdbcConnection()) {
      try (PreparedStatement statement = connection.prepareStatement(jdbcSql)) {
        ParameterMetaData metadata = statement.getParameterMetaData();
        assertEquals(20, metadata.getParameterCount());
        int index = 0;
        assertEquals(Types.BOOLEAN, metadata.getParameterType(++index));
        assertEquals("BOOL", metadata.getParameterTypeName(index));
        assertEquals(Types.BINARY, metadata.getParameterType(++index));
        assertEquals("BYTES", metadata.getParameterTypeName(index));
        assertEquals(Types.DATE, metadata.getParameterType(++index));
        assertEquals("DATE", metadata.getParameterTypeName(index));
        assertEquals(Types.REAL, metadata.getParameterType(++index));
        assertEquals("FLOAT32", metadata.getParameterTypeName(index));
        assertEquals(Types.DOUBLE, metadata.getParameterType(++index));
        assertEquals("FLOAT64", metadata.getParameterTypeName(index));
        assertEquals(Types.BIGINT, metadata.getParameterType(++index));
        assertEquals("INT64", metadata.getParameterTypeName(index));
        assertEquals(JsonType.VENDOR_TYPE_NUMBER, metadata.getParameterType(++index));
        assertEquals("JSON", metadata.getParameterTypeName(index));
        assertEquals(Types.NUMERIC, metadata.getParameterType(++index));
        assertEquals("NUMERIC", metadata.getParameterTypeName(index));
        assertEquals(Types.NVARCHAR, metadata.getParameterType(++index));
        assertEquals("STRING", metadata.getParameterTypeName(index));
        assertEquals(Types.TIMESTAMP, metadata.getParameterType(++index));
        assertEquals("TIMESTAMP", metadata.getParameterTypeName(index));

        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<BOOL>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<BYTES>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<DATE>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<FLOAT32>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<FLOAT64>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<INT64>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<JSON>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<NUMERIC>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<STRING>", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("ARRAY<TIMESTAMP>", metadata.getParameterTypeName(index));
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }

  @Test
  public void testAllTypesParameterMetadata_PostgreSQL() throws SQLException {
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.POSTGRESQL));

    String baseSql =
        "insert into all_types (col_bool, col_bytes, col_date, col_float64, col_int64, "
            + "col_json, col_numeric, col_string, col_timestamp, col_bool_array, col_bytes_array, "
            + "col_date_array, col_float64_array, col_int64_array, col_json_array, col_numeric_array, "
            + "col_string_array, col_timestamp_array) values (%s)";
    String jdbcSql =
        String.format(
            baseSql,
            IntStream.range(0, 18).mapToObj(ignored -> "?").collect(Collectors.joining(", ")));
    String googleSql =
        String.format(
            baseSql,
            IntStream.range(1, 19)
                .mapToObj(index -> "$" + index)
                .collect(Collectors.joining(", ")));
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(googleSql),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setUndeclaredParameters(createAllTypesParameters(Dialect.POSTGRESQL))
                        .build())
                .setStats(ResultSetStats.newBuilder().build())
                .build()));

    try (Connection connection = createJdbcConnection()) {
      try (PreparedStatement statement = connection.prepareStatement(jdbcSql)) {
        ParameterMetaData metadata = statement.getParameterMetaData();
        assertEquals(20, metadata.getParameterCount());
        int index = 0;
        assertEquals(Types.BOOLEAN, metadata.getParameterType(++index));
        assertEquals("boolean", metadata.getParameterTypeName(index));
        assertEquals(Types.BINARY, metadata.getParameterType(++index));
        assertEquals("bytea", metadata.getParameterTypeName(index));
        assertEquals(Types.DATE, metadata.getParameterType(++index));
        assertEquals("date", metadata.getParameterTypeName(index));
        assertEquals(Types.REAL, metadata.getParameterType(++index));
        assertEquals("real", metadata.getParameterTypeName(index));
        assertEquals(Types.DOUBLE, metadata.getParameterType(++index));
        assertEquals("double precision", metadata.getParameterTypeName(index));
        assertEquals(Types.BIGINT, metadata.getParameterType(++index));
        assertEquals("bigint", metadata.getParameterTypeName(index));
        assertEquals(PgJsonbType.VENDOR_TYPE_NUMBER, metadata.getParameterType(++index));
        assertEquals("jsonb", metadata.getParameterTypeName(index));
        assertEquals(Types.NUMERIC, metadata.getParameterType(++index));
        assertEquals("numeric", metadata.getParameterTypeName(index));
        assertEquals(Types.NVARCHAR, metadata.getParameterType(++index));
        assertEquals("character varying", metadata.getParameterTypeName(index));
        assertEquals(Types.TIMESTAMP, metadata.getParameterType(++index));
        assertEquals("timestamp with time zone", metadata.getParameterTypeName(index));

        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("boolean[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("bytea[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("date[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("real[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("double precision[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("bigint[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("jsonb[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("numeric[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("character varying[]", metadata.getParameterTypeName(index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals("timestamp with time zone[]", metadata.getParameterTypeName(index));
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }

  @Test
  public void testSimpleJdbcParameterMetadata() throws SQLException {
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.GOOGLE_STANDARD_SQL));
    String baseSql =
        "insert into all_types (col_bool, col_bytes, col_date, col_float32, col_float64, col_int64, "
            + "col_json, col_numeric, col_string, col_timestamp, col_bool_array, col_bytes_array, "
            + "col_date_array, col_float32_array, col_float64_array, col_int64_array, col_json_array,"
            + "col_numeric_array, col_string_array, col_timestamp_array) values (%s)";
    String jdbcSql =
        String.format(
            baseSql,
            IntStream.range(0, 20).mapToObj(ignored -> "?").collect(Collectors.joining(", ")));

    System.setProperty(JdbcSimpleParameterMetaData.USE_SIMPLE_PARAMETER_METADATA_KEY, "true");
    try (Connection connection = createJdbcConnection()) {
      try (PreparedStatement statement = connection.prepareStatement(jdbcSql)) {
        ParameterMetaData metadata = statement.getParameterMetaData();
        assertEquals(20, metadata.getParameterCount());
        for (int i = 0; i < metadata.getParameterCount(); i++) {
          assertEquals(Types.OTHER, metadata.getParameterType(i));
        }
      }
      assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    } finally {
      System.clearProperty(JdbcSimpleParameterMetaData.USE_SIMPLE_PARAMETER_METADATA_KEY);
    }
  }

  static StructType createAllTypesParameters(Dialect dialect) {
    return StructType.newBuilder()
        .addFields(
            Field.newBuilder()
                .setName("p1")
                .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p2")
                .setType(Type.newBuilder().setCode(TypeCode.BYTES).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p3")
                .setType(Type.newBuilder().setCode(TypeCode.DATE).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p4")
                .setType(Type.newBuilder().setCode(TypeCode.FLOAT32).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p5")
                .setType(Type.newBuilder().setCode(TypeCode.FLOAT64).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p6")
                .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p7")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.JSON)
                        .setTypeAnnotation(
                            dialect == Dialect.POSTGRESQL
                                ? TypeAnnotationCode.PG_JSONB
                                : TypeAnnotationCode.TYPE_ANNOTATION_CODE_UNSPECIFIED)
                        .build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p8")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.NUMERIC)
                        .setTypeAnnotation(
                            dialect == Dialect.POSTGRESQL
                                ? TypeAnnotationCode.PG_NUMERIC
                                : TypeAnnotationCode.TYPE_ANNOTATION_CODE_UNSPECIFIED)
                        .build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p9")
                .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p10")
                .setType(Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p11")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.BOOL).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p12")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.BYTES).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p13")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.DATE).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p14")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.FLOAT32).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p15")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.FLOAT64).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p16")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.INT64).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p17")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(
                            Type.newBuilder()
                                .setCode(TypeCode.JSON)
                                .setTypeAnnotation(
                                    dialect == Dialect.POSTGRESQL
                                        ? TypeAnnotationCode.PG_JSONB
                                        : TypeAnnotationCode.TYPE_ANNOTATION_CODE_UNSPECIFIED)
                                .build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p18")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(
                            Type.newBuilder()
                                .setCode(TypeCode.NUMERIC)
                                .setTypeAnnotation(
                                    dialect == Dialect.POSTGRESQL
                                        ? TypeAnnotationCode.PG_NUMERIC
                                        : TypeAnnotationCode.TYPE_ANNOTATION_CODE_UNSPECIFIED)
                                .build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p19")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.STRING).build()))
                .build())
        .addFields(
            Field.newBuilder()
                .setName("p20")
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(TypeCode.TIMESTAMP).build()))
                .build())
        .build();
  }
}
