/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.ConnectionImpl.EndOfFieldValueList;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import org.apache.arrow.vector.util.Text;
import org.junit.Test;

public class BigQueryResultImplTest {

  private static final Schema SCHEMA =
      Schema.of(
          Field.newBuilder("boolean", StandardSQLTypeName.BOOL)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("long", StandardSQLTypeName.NUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("double", StandardSQLTypeName.NUMERIC)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("string", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("bytes", StandardSQLTypeName.BYTES).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("timestamp", StandardSQLTypeName.TIMESTAMP)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("time", StandardSQLTypeName.TIME).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("date", StandardSQLTypeName.DATE).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("intArray", StandardSQLTypeName.INT64)
              .setMode(Field.Mode.REPEATED)
              .build(),
          Field.newBuilder("stringArray", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.REPEATED)
              .build());

  private static final FieldList FIELD_LIST_SCHEMA =
      FieldList.of(
          Field.of("boolean", LegacySQLTypeName.BOOLEAN),
          Field.of("long", LegacySQLTypeName.INTEGER),
          Field.of("double", LegacySQLTypeName.FLOAT),
          Field.of("string", LegacySQLTypeName.STRING),
          Field.of("bytes", LegacySQLTypeName.BYTES),
          Field.of("timestamp", LegacySQLTypeName.TIMESTAMP),
          Field.of("time", LegacySQLTypeName.TIME),
          Field.of("date", LegacySQLTypeName.DATE),
          Field.of("intArray", LegacySQLTypeName.INTEGER),
          Field.of("stringArray", LegacySQLTypeName.STRING));

  private static final byte[] BYTES = {0xD, 0xE, 0xA, 0xD};
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  private static final Timestamp EXPECTED_TIMESTAMP = Timestamp.valueOf("2025-01-02 03:04:05.0");
  private static final String TIME = "20:21:22";
  private static final Time EXPECTED_TIME = Time.valueOf(LocalTime.of(20, 21, 22));
  private static final String DATE = "2020-01-21";
  private static final int DATE_INT = 0;
  private static final Date EXPECTED_DATE = java.sql.Date.valueOf(DATE);
  private static final ArrayList<Integer> EXPECTED_INT_ARRAY =
      new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
  private static final String[] STRING_ARRAY = {"str1", "str2", "str3"};
  private static final ArrayList<String> EXPECTED_STRING_ARRAY =
      new ArrayList<>(Arrays.asList(STRING_ARRAY));
  private static final int BUFFER_SIZE = 10;

  @Test
  public void testResultSetFieldValueList() throws InterruptedException, SQLException {
    BlockingQueue<AbstractList<FieldValue>> buffer = new LinkedBlockingDeque<>(BUFFER_SIZE);
    FieldValueList fieldValues =
        FieldValueList.of(
            ImmutableList.of(
                FieldValue.of(Attribute.PRIMITIVE, "false"),
                FieldValue.of(Attribute.PRIMITIVE, "1"),
                FieldValue.of(Attribute.PRIMITIVE, "1.5"),
                FieldValue.of(Attribute.PRIMITIVE, "string_value"),
                FieldValue.of(Attribute.PRIMITIVE, BYTES_BASE64),
                FieldValue.of(
                    Attribute.PRIMITIVE,
                    Long.toString(EXPECTED_TIMESTAMP.getTime() / 1000),
                    false), // getTime is in milliseconds.
                FieldValue.of(Attribute.PRIMITIVE, TIME),
                FieldValue.of(Attribute.PRIMITIVE, DATE),
                FieldValue.of(Attribute.REPEATED, EXPECTED_INT_ARRAY),
                FieldValue.of(Attribute.REPEATED, STRING_ARRAY)),
            FIELD_LIST_SCHEMA);
    buffer.put(fieldValues);

    FieldValueList nullValues =
        FieldValueList.of(
            ImmutableList.of(
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.PRIMITIVE, null),
                FieldValue.of(Attribute.REPEATED, null),
                FieldValue.of(Attribute.REPEATED, null)),
            FIELD_LIST_SCHEMA);
    buffer.put(nullValues);

    buffer.put(new EndOfFieldValueList()); // End of buffer marker.

    BigQueryResultImpl<AbstractList<FieldValue>> bigQueryResult =
        new BigQueryResultImpl<>(SCHEMA, 1, buffer, null);
    ResultSet resultSet = bigQueryResult.getResultSet();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getObject("string")).isEqualTo("string_value");
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getString("string")).isEqualTo("string_value");
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getInt("long")).isEqualTo(1);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getLong("long")).isEqualTo(1);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getDouble("double")).isEqualTo(1.5);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBigDecimal("double")).isEqualTo(BigDecimal.valueOf(1.5));
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBoolean("boolean")).isFalse();
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBytes("bytes")).isEqualTo(BYTES);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getTimestamp("timestamp")).isEqualTo(EXPECTED_TIMESTAMP);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getTime("time").getTime()).isEqualTo(EXPECTED_TIME.getTime());
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getDate("date").getTime()).isEqualTo(EXPECTED_DATE.getTime());
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getArray("intArray").getArray()).isEqualTo(EXPECTED_INT_ARRAY);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getArray("stringArray").getArray()).isEqualTo(EXPECTED_STRING_ARRAY);
    assertThat(resultSet.wasNull()).isFalse();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getObject("string")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getString("string")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getInt("long")).isEqualTo(0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getLong("long")).isEqualTo(0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getDouble("double")).isEqualTo(0.0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBigDecimal("double")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBoolean("boolean")).isFalse();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBytes("bytes")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getTimestamp("timestamp")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getTime("time")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getDate("date")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getArray("intArray")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getArray("stringArray")).isNull();
    assertThat(resultSet.wasNull()).isTrue();

    assertThat(resultSet.next()).isFalse();
  }

  @Test
  public void testResultSetReadApi() throws InterruptedException, SQLException {
    BlockingQueue<BigQueryResultImpl.Row> buffer = new LinkedBlockingDeque<>(BUFFER_SIZE);

    Map<String, Object> rowValues = new HashMap<>();
    rowValues.put("boolean", false);
    rowValues.put("long", 1L);
    rowValues.put("double", 1.5);
    rowValues.put("string", new Text("string_value"));
    rowValues.put("bytes", BYTES);
    rowValues.put("timestamp", EXPECTED_TIMESTAMP.getTime() * 1000);
    rowValues.put("time", EXPECTED_TIME.getTime() * 1000);
    rowValues.put("date", DATE_INT);
    rowValues.put("intArray", EXPECTED_INT_ARRAY);
    rowValues.put("stringArray", STRING_ARRAY);
    buffer.put(new BigQueryResultImpl.Row(rowValues));

    Map<String, Object> nullValues = new HashMap<>();
    nullValues.put("boolean", null);
    nullValues.put("long", null);
    nullValues.put("double", null);
    nullValues.put("string", null);
    nullValues.put("bytes", null);
    nullValues.put("timestamp", null);
    nullValues.put("time", null);
    nullValues.put("date", null);
    nullValues.put("intArray", null);
    nullValues.put("stringArray", null);
    buffer.put(new BigQueryResultImpl.Row(nullValues));

    buffer.put(new BigQueryResultImpl.Row(null, true)); // End of buffer marker.

    BigQueryResultImpl<BigQueryResultImpl.Row> bigQueryResult =
        new BigQueryResultImpl<>(SCHEMA, 1, buffer, null);
    ResultSet resultSet = bigQueryResult.getResultSet();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getObject("string")).isEqualTo(new Text("string_value"));
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getString("string")).isEqualTo("string_value");
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getInt("long")).isEqualTo(1);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getLong("long")).isEqualTo(1);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getDouble("double")).isEqualTo(1.5);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBigDecimal("double")).isEqualTo(BigDecimal.valueOf(1.5));
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBoolean("boolean")).isFalse();
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getBytes("bytes")).isEqualTo(BYTES);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getTimestamp("timestamp")).isEqualTo(EXPECTED_TIMESTAMP);
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getTime("time").getTime()).isEqualTo(EXPECTED_TIME.getTime());
    assertThat(resultSet.wasNull()).isFalse();
    // Do not check date value as Date object do not have timezone but its toString() applies the
    // JVM default timezone which causes flakes in non-UTC zones.
    assertThat(resultSet.getDate("date")).isNotNull();
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getArray("intArray")).isNotNull();
    assertThat(resultSet.wasNull()).isFalse();
    assertThat(resultSet.getArray("stringArray")).isNotNull();
    assertThat(resultSet.wasNull()).isFalse();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getObject("string")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getString("string")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getInt("long")).isEqualTo(0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getLong("long")).isEqualTo(0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getDouble("double")).isEqualTo(0.0);
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBigDecimal("double")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBoolean("boolean")).isFalse();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getBytes("bytes")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getTimestamp("timestamp")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getTime("time")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getDate("date")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getArray("intArray")).isNull();
    assertThat(resultSet.wasNull()).isTrue();
    assertThat(resultSet.getArray("stringArray")).isNull();
    assertThat(resultSet.wasNull()).isTrue();

    assertThat(resultSet.next()).isFalse();
  }
}
