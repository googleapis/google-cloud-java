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

import static org.junit.Assert.*;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Tests that all types can be read from Spanner and sent to Spanner. */
@RunWith(Parameterized.class)
public class AllTypesMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  public static final Statement SELECT_STATEMENT = Statement.of("select * from all_types");

  public static final boolean BOOL_VALUE = true;
  public static final long INT64_VALUE = 1L;
  public static final float FLOAT32_VALUE = 3.14f;
  public static final double FLOAT64_VALUE = 3.14d;
  public static final BigDecimal NUMERIC_VALUE = new BigDecimal("3.14");
  public static final String PG_NUMERIC_VALUE = "3.14";
  public static final String STRING_VALUE = "test-string";
  public static final String JSON_VALUE = "{\"key1\":\"value1\", \"key2\":\"value2\"}";
  public static final long PG_OID_VALUE = 1L;
  public static final byte[] BYTES_VALUE = "test-bytes".getBytes(StandardCharsets.UTF_8);
  public static final Date DATE_VALUE = Date.fromYearMonthDay(2024, 3, 2);
  public static final UUID UUID_VALUE = UUID.randomUUID();
  public static final Timestamp TIMESTAMP_VALUE =
      Timestamp.parseTimestamp("2024-03-02T07:07:00.20982735Z");

  public static final List<Boolean> BOOL_ARRAY_VALUE = Arrays.asList(true, null, false);
  public static final List<Long> INT64_ARRAY_VALUE =
      Arrays.asList(100L, null, 200L, Long.MIN_VALUE, Long.MAX_VALUE);
  public static final List<Float> FLOAT32_ARRAY_VALUE =
      Arrays.asList(
          -3.14f, null, 6.626f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_NORMAL, Float.NaN);
  public static final List<Double> FLOAT64_ARRAY_VALUE =
      Arrays.asList(
          -3.14d, null, 6.626d, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_NORMAL, Double.NaN);
  public static final List<BigDecimal> NUMERIC_ARRAY_VALUE =
      Arrays.asList(
          new BigDecimal("-3.14"),
          null,
          new BigDecimal("99.99"),
          BigDecimal.ZERO,
          new BigDecimal("1e-9"),
          new BigDecimal("-9.9999999999999999999999999999999999999E+28"),
          new BigDecimal("9.9999999999999999999999999999999999999E+28"));
  public static final List<String> PG_NUMERIC_ARRAY_VALUE =
      Arrays.asList(
          "-3.14",
          null,
          "99.99",
          "NaN",
          "1e-9",
          "-9.9999999999999999999999999999999999999E+28",
          "9.9999999999999999999999999999999999999E+28");
  public static final List<String> STRING_ARRAY_VALUE =
      Arrays.asList("test-string1", null, "test-string2");
  public static final List<String> JSON_ARRAY_VALUE =
      Arrays.asList(
          "{\"key1\":\"value1.1\", \"key2\":\"value1.2\"}",
          null,
          "{\"key1\":\"value3.1\", \"key2\":\"value3.2\"}");
  public static final List<Long> PG_OID_ARRAY_VALUE =
      Arrays.asList(100L, null, 200L, Long.MIN_VALUE, Long.MAX_VALUE);
  public static final List<ByteArray> BYTES_ARRAY_VALUE =
      Arrays.asList(ByteArray.copyFrom("test-bytes1"), null, ByteArray.copyFrom("test-bytes2"));
  public static final List<Date> DATE_ARRAY_VALUE =
      Arrays.asList(
          Date.fromYearMonthDay(2024, 3, 1),
          null,
          Date.fromYearMonthDay(2024, 3, 3),
          Date.fromYearMonthDay(1, 1, 1),
          Date.fromYearMonthDay(9999, 12, 31));

  public static final List<UUID> UUID_ARRAY_VALUE =
      Arrays.asList(UUID.randomUUID(), null, UUID.randomUUID());
  public static final List<Timestamp> TIMESTAMP_ARRAY_VALUE =
      Arrays.asList(
          Timestamp.parseTimestamp("2024-03-01T07:07:00.20982735Z"),
          null,
          Timestamp.parseTimestamp("2024-03-03T07:07:00Z"),
          Timestamp.MIN_VALUE,
          Timestamp.MAX_VALUE);

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
      setupAllTypesResultSet(dialect);
      mockSpanner.putStatementResult(StatementResult.update(createInsertStatement(dialect), 1L));
      SpannerPool.closeSpannerPool();
      currentDialect = dialect;
    }
  }

  private void setupAllTypesResultSet(Dialect dialect) {
    // Use RandomResultSetGenerator to generate metadata for a ResultSet with all types.
    // This guarantees that this test will fail if a new type is added to RandomResultSetGenerator,
    // but not added to this test.
    // The columns in the result set are:
    // COL1: BOOL
    // COL2: INT64
    // COL3: FLOAT32
    // COL4: FLOAT64
    // COL5: NUMERIC / PG_NUMERIC
    // COL6: STRING
    // COL7: JSON / PG_JSONB
    // COL8: BYTES
    // COL9: DATE
    // COL10: UUID
    // COL11: TIMESTAMP
    // COL12: PG_OID (added only for POSTGRESQL dialect)
    // COL13-22: ARRAY<..> for the types above.
    // Only for GoogleSQL:
    // COL23: PROTO
    // COL24: ENUM
    // COL25: ARRAY<PROTO>
    // COL26: ARRAY<ENUM>
    // COL27: ARRAY<PG_OID> (added only for POSTGRESQL dialect)
    ListValue.Builder row1Builder =
        ListValue.newBuilder()
            .addValues(Value.newBuilder().setBoolValue(BOOL_VALUE))
            .addValues(Value.newBuilder().setStringValue(String.valueOf(INT64_VALUE)).build())
            .addValues(Value.newBuilder().setNumberValue(FLOAT32_VALUE))
            .addValues(Value.newBuilder().setNumberValue(FLOAT64_VALUE))
            .addValues(
                Value.newBuilder()
                    .setStringValue(
                        dialect == Dialect.POSTGRESQL
                            ? PG_NUMERIC_VALUE
                            : NUMERIC_VALUE.toEngineeringString()))
            .addValues(Value.newBuilder().setStringValue(STRING_VALUE))
            .addValues(Value.newBuilder().setStringValue(JSON_VALUE))
            .addValues(
                Value.newBuilder().setStringValue(Base64.getEncoder().encodeToString(BYTES_VALUE)))
            .addValues(Value.newBuilder().setStringValue(DATE_VALUE.toString()))
            .addValues(Value.newBuilder().setStringValue(UUID_VALUE.toString()))
            .addValues(Value.newBuilder().setStringValue(TIMESTAMP_VALUE.toString()));
    if (dialect == Dialect.POSTGRESQL) {
      row1Builder.addValues(
          Value.newBuilder().setStringValue(String.valueOf(PG_OID_VALUE)).build());
    }

    row1Builder
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            BOOL_ARRAY_VALUE.stream()
                                .map(
                                    b ->
                                        b == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder().setBoolValue(b).build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            INT64_ARRAY_VALUE.stream()
                                .map(
                                    l ->
                                        l == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder()
                                                .setStringValue(String.valueOf(l))
                                                .build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            FLOAT32_ARRAY_VALUE.stream()
                                .map(
                                    f -> {
                                      if (f == null) {
                                        return Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE)
                                            .build();
                                      } else if (Float.isNaN(f)) {
                                        return Value.newBuilder().setStringValue("NaN").build();
                                      } else {
                                        return Value.newBuilder().setNumberValue(f).build();
                                      }
                                    })
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            FLOAT64_ARRAY_VALUE.stream()
                                .map(
                                    d -> {
                                      if (d == null) {
                                        return Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE)
                                            .build();
                                      } else if (Double.isNaN(d)) {
                                        return Value.newBuilder().setStringValue("NaN").build();
                                      } else {
                                        return Value.newBuilder().setNumberValue(d).build();
                                      }
                                    })
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            dialect == Dialect.POSTGRESQL
                                ? PG_NUMERIC_ARRAY_VALUE.stream()
                                    .map(
                                        string ->
                                            string == null
                                                ? Value.newBuilder()
                                                    .setNullValue(NullValue.NULL_VALUE)
                                                    .build()
                                                : Value.newBuilder().setStringValue(string).build())
                                    .collect(Collectors.toList())
                                : NUMERIC_ARRAY_VALUE.stream()
                                    .map(
                                        bigDecimal ->
                                            bigDecimal == null
                                                ? Value.newBuilder()
                                                    .setNullValue(NullValue.NULL_VALUE)
                                                    .build()
                                                : Value.newBuilder()
                                                    .setStringValue(
                                                        bigDecimal.toEngineeringString())
                                                    .build())
                                    .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            STRING_ARRAY_VALUE.stream()
                                .map(
                                    string ->
                                        string == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder().setStringValue(string).build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            JSON_ARRAY_VALUE.stream()
                                .map(
                                    json ->
                                        json == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder().setStringValue(json).build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            BYTES_ARRAY_VALUE.stream()
                                .map(
                                    byteArray ->
                                        byteArray == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder()
                                                .setStringValue(
                                                    Base64.getEncoder()
                                                        .encodeToString(byteArray.toByteArray()))
                                                .build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            DATE_ARRAY_VALUE.stream()
                                .map(
                                    date ->
                                        date == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder()
                                                .setStringValue(date.toString())
                                                .build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            UUID_ARRAY_VALUE.stream()
                                .map(
                                    uuid ->
                                        uuid == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder()
                                                .setStringValue(uuid.toString())
                                                .build())
                                .collect(Collectors.toList()))
                        .build()))
        .addValues(
            Value.newBuilder()
                .setListValue(
                    ListValue.newBuilder()
                        .addAllValues(
                            TIMESTAMP_ARRAY_VALUE.stream()
                                .map(
                                    timestamp ->
                                        timestamp == null
                                            ? Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()
                                            : Value.newBuilder()
                                                .setStringValue(timestamp.toString())
                                                .build())
                                .collect(Collectors.toList()))
                        .build()));

    if (dialect == Dialect.GOOGLE_STANDARD_SQL) {
      // Add PROTO values.
      row1Builder
          .addValues(
              Value.newBuilder()
                  .setStringValue(
                      Base64.getEncoder()
                          .encodeToString(
                              SingerInfo.newBuilder()
                                  .setSingerId(1L)
                                  .setNationality("unknown")
                                  .setBirthDate("1986-09-30")
                                  .setGenre(Genre.POP)
                                  .build()
                                  .toByteArray()))
                  .build())
          .addValues(Value.newBuilder().setStringValue(String.valueOf(Genre.JAZZ_VALUE)).build())
          .addValues(
              Value.newBuilder()
                  .setListValue(
                      ListValue.newBuilder()
                          .addValues(
                              Value.newBuilder()
                                  .setStringValue(
                                      Base64.getEncoder()
                                          .encodeToString(
                                              SingerInfo.newBuilder()
                                                  .setSingerId(1L)
                                                  .setGenre(Genre.FOLK)
                                                  .setBirthDate("200-01-01")
                                                  .setNationality("no")
                                                  .build()
                                                  .toByteArray()))
                                  .build())
                          .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE))
                          .addValues(
                              Value.newBuilder()
                                  .setStringValue(
                                      Base64.getEncoder()
                                          .encodeToString(
                                              SingerInfo.newBuilder()
                                                  .setSingerId(2L)
                                                  .setGenre(Genre.JAZZ)
                                                  .setBirthDate("200-01-02")
                                                  .setNationality("dk")
                                                  .build()
                                                  .toByteArray()))
                                  .build())
                          .build())
                  .build())
          .addValues(
              Value.newBuilder()
                  .setListValue(
                      ListValue.newBuilder()
                          .addValues(
                              Value.newBuilder()
                                  .setStringValue(String.valueOf(Genre.ROCK_VALUE))
                                  .build())
                          .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE))
                          .addValues(
                              Value.newBuilder()
                                  .setStringValue(String.valueOf(Genre.ROCK_VALUE))
                                  .build())
                          .build())
                  .build());
    }

    if (dialect == Dialect.POSTGRESQL) {
      // Add ARRAY<PG.OID> values.
      row1Builder.addValues(
          Value.newBuilder()
              .setListValue(
                  ListValue.newBuilder()
                      .addAllValues(
                          PG_OID_ARRAY_VALUE.stream()
                              .map(
                                  l ->
                                      l == null
                                          ? Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build()
                                          : Value.newBuilder()
                                              .setStringValue(String.valueOf(l))
                                              .build())
                              .collect(Collectors.toList()))
                      .build()));
    }

    com.google.spanner.v1.ResultSet resultSet =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(
                RandomResultSetGenerator.generateAllTypesMetadata(
                    RandomResultSetGenerator.generateAllTypes(dialect)))
            .addRows(row1Builder.build())
            .build();
    mockSpanner.putStatementResults(StatementResult.query(SELECT_STATEMENT, resultSet));
  }

  public static Statement createInsertStatement(Dialect dialect) {
    Statement.Builder builder = Statement.newBuilder("insert into all_types (");
    builder.append(
        IntStream.rangeClosed(1, RandomResultSetGenerator.generateAllTypes(dialect).length)
            .mapToObj(col -> "COL" + col)
            .collect(Collectors.joining(", ", "", ") values (")));
    builder.append(
        IntStream.rangeClosed(1, RandomResultSetGenerator.generateAllTypes(dialect).length)
            .mapToObj(col -> "@p" + col)
            .collect(Collectors.joining(", ", "", ")")));
    int param = 0;
    builder
        .bind("p" + ++param)
        .to(BOOL_VALUE)
        .bind("p" + ++param)
        .to(INT64_VALUE)
        .bind("p" + ++param)
        .to(FLOAT32_VALUE)
        .bind("p" + ++param)
        .to(FLOAT64_VALUE)
        .bind("p" + ++param)
        .to(
            dialect == Dialect.POSTGRESQL
                ? com.google.cloud.spanner.Value.pgNumeric(PG_NUMERIC_VALUE)
                : com.google.cloud.spanner.Value.numeric(NUMERIC_VALUE))
        .bind("p" + ++param)
        .to(STRING_VALUE)
        .bind("p" + ++param)
        .to(
            dialect == Dialect.POSTGRESQL
                ? com.google.cloud.spanner.Value.pgJsonb(JSON_VALUE)
                : com.google.cloud.spanner.Value.json(JSON_VALUE))
        .bind("p" + ++param)
        .to(ByteArray.copyFrom(BYTES_VALUE))
        .bind("p" + ++param)
        .to(DATE_VALUE)
        .bind("p" + ++param)
        .to(UUID_VALUE)
        .bind("p" + ++param)
        .to(TIMESTAMP_VALUE);
    if (dialect == Dialect.POSTGRESQL) {
      builder.bind("p" + ++param).to(PG_OID_VALUE);
    }
    builder
        .bind("p" + ++param)
        .toBoolArray(BOOL_ARRAY_VALUE)
        .bind("p" + ++param)
        .toInt64Array(INT64_ARRAY_VALUE)
        .bind("p" + ++param)
        .toFloat32Array(FLOAT32_ARRAY_VALUE)
        .bind("p" + ++param)
        .toFloat64Array(FLOAT64_ARRAY_VALUE)
        .bind("p" + ++param)
        .to(
            dialect == Dialect.POSTGRESQL
                ? com.google.cloud.spanner.Value.pgNumericArray(PG_NUMERIC_ARRAY_VALUE)
                : com.google.cloud.spanner.Value.numericArray(NUMERIC_ARRAY_VALUE))
        .bind("p" + ++param)
        .toStringArray(STRING_ARRAY_VALUE)
        .bind("p" + ++param)
        .to(
            dialect == Dialect.POSTGRESQL
                ? com.google.cloud.spanner.Value.pgJsonbArray(JSON_ARRAY_VALUE)
                : com.google.cloud.spanner.Value.jsonArray(JSON_ARRAY_VALUE))
        .bind("p" + ++param)
        .toBytesArray(BYTES_ARRAY_VALUE)
        .bind("p" + ++param)
        .toDateArray(DATE_ARRAY_VALUE)
        .bind("p" + ++param)
        .toUuidArray(UUID_ARRAY_VALUE)
        .bind("p" + ++param)
        .toTimestampArray(TIMESTAMP_ARRAY_VALUE);
    if (dialect == Dialect.POSTGRESQL) {
      builder.bind("p" + ++param).toInt64Array(PG_OID_ARRAY_VALUE);
    }
    return builder.build();
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testSelectAllTypes() {
    try (Connection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(SELECT_STATEMENT)) {
        assertTrue(resultSet.next());

        int col = -1;
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
        assertEquals(
            JSON_VALUE,
            dialect == Dialect.POSTGRESQL ? resultSet.getPgJsonb(++col) : resultSet.getJson(++col));
        assertArrayEquals(BYTES_VALUE, resultSet.getBytes(++col).toByteArray());
        assertEquals(DATE_VALUE, resultSet.getDate(++col));
        assertEquals(UUID_VALUE, resultSet.getUuid(++col));
        assertEquals(TIMESTAMP_VALUE, resultSet.getTimestamp(++col));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(PG_OID_VALUE, resultSet.getLong(++col));
        }

        assertEquals(BOOL_ARRAY_VALUE, resultSet.getBooleanList(++col));
        assertEquals(INT64_ARRAY_VALUE, resultSet.getLongList(++col));
        assertEquals(FLOAT32_ARRAY_VALUE, resultSet.getFloatList(++col));
        assertEquals(FLOAT64_ARRAY_VALUE, resultSet.getDoubleList(++col));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(PG_NUMERIC_ARRAY_VALUE, resultSet.getStringList(++col));
        } else {
          assertEquals(NUMERIC_ARRAY_VALUE, resultSet.getBigDecimalList(++col));
        }
        assertEquals(STRING_ARRAY_VALUE, resultSet.getStringList(++col));
        assertEquals(
            JSON_ARRAY_VALUE,
            dialect == Dialect.POSTGRESQL
                ? resultSet.getPgJsonbList(++col)
                : resultSet.getJsonList(++col));
        assertEquals(BYTES_ARRAY_VALUE, resultSet.getBytesList(++col));
        assertEquals(DATE_ARRAY_VALUE, resultSet.getDateList(++col));
        assertEquals(UUID_ARRAY_VALUE, resultSet.getUuidList(++col));
        assertEquals(TIMESTAMP_ARRAY_VALUE, resultSet.getTimestampList(++col));
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals(PG_OID_ARRAY_VALUE, resultSet.getLongList(++col));
        }
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testInsertAllTypes() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(createInsertStatement(dialect)));

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      Map<String, Type> paramTypes = request.getParamTypesMap();
      Map<String, Value> params = request.getParams().getFieldsMap();
      assertEquals(dialect == Dialect.POSTGRESQL ? 24 : 22, paramTypes.size());
      assertEquals(dialect == Dialect.POSTGRESQL ? 24 : 22, params.size());

      // Verify param types.
      ImmutableList<TypeCode> expectedTypes;
      if (dialect == Dialect.POSTGRESQL) {
        expectedTypes =
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
                TypeCode.UUID,
                TypeCode.TIMESTAMP,
                TypeCode.INT64);
      } else {
        expectedTypes =
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
                TypeCode.UUID,
                TypeCode.TIMESTAMP);
      }
      for (int col = 0; col < expectedTypes.size(); col++) {
        assertEquals(expectedTypes.get(col), paramTypes.get("p" + (col + 1)).getCode());
        int arrayCol = col + expectedTypes.size();
        assertEquals(TypeCode.ARRAY, paramTypes.get("p" + (arrayCol + 1)).getCode());
        assertEquals(
            expectedTypes.get(col),
            paramTypes.get("p" + (arrayCol + 1)).getArrayElementType().getCode());
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
        assertEquals(
            PG_NUMERIC_ARRAY_VALUE,
            params.get("p" + ++col).getListValue().getValuesList().stream()
                .map(value -> value.hasNullValue() ? null : value.getStringValue())
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
              .map(value -> value.hasNullValue() ? null : Date.parseDate(value.getStringValue()))
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
                          : Timestamp.parseTimestamp(value.getStringValue()))
              .collect(Collectors.toList()));
      if (dialect == Dialect.POSTGRESQL) {
        assertEquals(
            PG_OID_ARRAY_VALUE,
            params.get("p" + ++col).getListValue().getValuesList().stream()
                .map(value -> value.hasNullValue() ? null : Long.valueOf(value.getStringValue()))
                .collect(Collectors.toList()));
      }
    }
  }
}
