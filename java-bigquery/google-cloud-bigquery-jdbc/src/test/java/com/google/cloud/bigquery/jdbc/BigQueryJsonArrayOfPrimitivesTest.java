/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.StandardSQLTypeName.BIGNUMERIC;
import static com.google.cloud.bigquery.StandardSQLTypeName.BOOL;
import static com.google.cloud.bigquery.StandardSQLTypeName.BYTES;
import static com.google.cloud.bigquery.StandardSQLTypeName.DATE;
import static com.google.cloud.bigquery.StandardSQLTypeName.DATETIME;
import static com.google.cloud.bigquery.StandardSQLTypeName.FLOAT64;
import static com.google.cloud.bigquery.StandardSQLTypeName.GEOGRAPHY;
import static com.google.cloud.bigquery.StandardSQLTypeName.INT64;
import static com.google.cloud.bigquery.StandardSQLTypeName.NUMERIC;
import static com.google.cloud.bigquery.StandardSQLTypeName.STRING;
import static com.google.cloud.bigquery.StandardSQLTypeName.TIME;
import static com.google.cloud.bigquery.StandardSQLTypeName.TIMESTAMP;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.INVALID_ARRAY;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.arraySchemaAndValue;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.nestedResultSetToColumnLists;
import static com.google.common.truth.Truth.assertThat;
import static java.time.Month.MARCH;
import static java.util.Arrays.copyOfRange;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import com.google.common.io.BaseEncoding;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BigQueryJsonArrayOfPrimitivesTest {

  private final Field schema;
  private final FieldValue arrayValues;
  private final Object[] expected;
  private final int javaSqlTypeCode;
  private Array array;
  private final StandardSQLTypeName currentType;

  @ClassRule public static final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  public BigQueryJsonArrayOfPrimitivesTest(
      StandardSQLTypeName currentType,
      Tuple<Field, FieldValue> schemaAndValue,
      Object[] expected,
      int javaSqlTypeCode) {
    this.currentType = currentType;
    this.schema = schemaAndValue.x();
    this.arrayValues = schemaAndValue.y();
    this.expected = expected;
    this.javaSqlTypeCode = javaSqlTypeCode;
  }

  @Before
  public void setUp() {
    array = new BigQueryJsonArray(this.schema, this.arrayValues);
  }

  @Parameters(name = "{index}: primitive array of {0}")
  public static Collection<Object[]> data() {
    timeZoneRule.enforce();
    LocalDateTime aTimeStamp = LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820227000);
    LocalDate aDate = LocalDate.of(2023, MARCH, 30);
    LocalTime aTime = LocalTime.of(11, 14, 19, 820227000);
    return Arrays.asList(
        new Object[][] {
          {
            INT64,
            arraySchemaAndValue(INT64, "10", "20", "30", "40"),
            new Long[] {10L, 20L, 30L, 40L},
            Types.BIGINT
          },
          {
            BOOL,
            arraySchemaAndValue(BOOL, "true", "false", "false", "true"),
            new Boolean[] {true, false, false, true},
            Types.BOOLEAN
          },
          {
            FLOAT64,
            arraySchemaAndValue(FLOAT64, "11.2", "33.4", "55.6", "77.8"),
            new Double[] {11.2, 33.4, 55.6, 77.8},
            Types.DOUBLE
          },
          {
            NUMERIC,
            arraySchemaAndValue(NUMERIC, "11.2657", "33.4657", "55.6657", "77.8657"),
            new BigDecimal[] {
              new BigDecimal("11.2657"),
              new BigDecimal("33.4657"),
              new BigDecimal("55.6657"),
              new BigDecimal("77.8657")
            },
            Types.NUMERIC
          },
          {
            BIGNUMERIC,
            arraySchemaAndValue(BIGNUMERIC, "11.2657", "33.4657", "55.6657", "77.8657"),
            new BigDecimal[] {
              new BigDecimal("11.2657"),
              new BigDecimal("33.4657"),
              new BigDecimal("55.6657"),
              new BigDecimal("77.8657")
            },
            Types.NUMERIC
          },
          {
            STRING,
            arraySchemaAndValue(STRING, "one", "two", "three", "four"),
            new String[] {"one", "two", "three", "four"},
            Types.NVARCHAR
          },
          {
            TIMESTAMP,
            arraySchemaAndValue(
                TIMESTAMP,
                "1680174859.8202269",
                "1680261259.8202269",
                "1680347659.8202269",
                "1680434059.8202269"),
            new Timestamp[] {
              Timestamp.valueOf(aTimeStamp), // 2023-03-30 16:44:19.82
              Timestamp.valueOf(aTimeStamp.plusDays(1)),
              Timestamp.valueOf(aTimeStamp.plusDays(2)),
              Timestamp.valueOf(aTimeStamp.plusDays(3))
            },
            Types.TIMESTAMP
          },
          {
            DATE,
            arraySchemaAndValue(DATE, "2023-03-30", "2023-03-31", "2023-04-01", "2023-04-02"),
            new Date[] {
              Date.valueOf(aDate),
              Date.valueOf(aDate.plusDays(1)),
              Date.valueOf(aDate.plusDays(2)),
              Date.valueOf(aDate.plusDays(3))
            },
            Types.DATE
          },
          {
            TIME,
            arraySchemaAndValue(
                TIME, "11:14:19.820227", "11:14:20.820227", "11:14:21.820227", "11:14:22.820227"),
            new Time[] {
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.toNanoOfDay())),
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.plusSeconds(1).toNanoOfDay())),
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.plusSeconds(2).toNanoOfDay())),
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.plusSeconds(3).toNanoOfDay()))
            },
            Types.TIME
          },
          {
            DATETIME,
            arraySchemaAndValue(
                DATETIME,
                "2023-03-30T11:14:19.820227",
                "2023-03-30T11:15:19.820227",
                "2023-03-30T11:16:19.820227",
                "2023-03-30T11:17:19.820227"),
            new Timestamp[] {
              Timestamp.valueOf("2023-03-30 11:14:19.820227"),
              Timestamp.valueOf("2023-03-30 11:15:19.820227"),
              Timestamp.valueOf("2023-03-30 11:16:19.820227"),
              Timestamp.valueOf("2023-03-30 11:17:19.820227")
            },
            Types.TIMESTAMP
          },
          {
            GEOGRAPHY,
            arraySchemaAndValue(
                GEOGRAPHY, "POINT(-122 47)", "POINT(-122 48)", "POINT(-121 47)", "POINT(-123 48)"),
            new String[] {"POINT(-122 47)", "POINT(-122 48)", "POINT(-121 47)", "POINT(-123 48)"},
            Types.OTHER
          },
          {
            BYTES,
            arraySchemaAndValue(
                BYTES,
                Stream.of("one", "two", "three", "four")
                    .map(s -> BaseEncoding.base64().encode(s.getBytes()))
                    .toArray(String[]::new)),
            new byte[][] {
              "one".getBytes(), "two".getBytes(), "three".getBytes(), "four".getBytes()
            },
            Types.VARBINARY
          }
        });
  }

  @Test
  public void getArray() throws SQLException {
    assertThat(array.getArray()).isEqualTo(this.expected);
  }

  @Test
  public void getSlicedArray() throws SQLException {
    int fromIndex = 1;
    int toIndexExclusive = 3;
    Object[] expectedSlicedArray =
        copyOfRange(this.expected, fromIndex, toIndexExclusive); // copying index(1,2)

    // the first element is at index 1
    assertThat(array.getArray(fromIndex + 1, 2)).isEqualTo(expectedSlicedArray);
  }

  @Test
  public void getSlicedArrayWhenCountIsGreaterThanOriginalArrayLength() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> array.getArray(2, 10));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo("The array index is out of range: 12, number of elements: 4.");
  }

  @Test
  public void getResultSet() throws SQLException {
    ResultSet resultSet = this.array.getResultSet();
    Tuple<ArrayList<Object>, ArrayList<Object>> indexAndValues =
        nestedResultSetToColumnLists(resultSet);
    ArrayList<Object> indexList = indexAndValues.x();
    ArrayList<Object> columnValues = indexAndValues.y();

    assertThat(indexList.toArray()).isEqualTo(new Object[] {1, 2, 3, 4});
    assertThat(columnValues.toArray()).isEqualTo(this.expected);
  }

  @Test
  public void getSlicedResultSet() throws SQLException {
    int fromIndex = 1;
    int toIndexExclusive = 3;
    Object[] expectedSlicedArray =
        copyOfRange(this.expected, fromIndex, toIndexExclusive); // copying index(1,2)

    // the first element is at index 1
    ResultSet resultSet = array.getResultSet(fromIndex + 1, 2);

    Tuple<ArrayList<Object>, ArrayList<Object>> indexAndValues =
        nestedResultSetToColumnLists(resultSet);
    ArrayList<Object> indexList = indexAndValues.x();
    ArrayList<Object> columnValues = indexAndValues.y();

    assertThat(indexList.toArray()).isEqualTo(new Object[] {2, 3});
    assertThat(columnValues.toArray()).isEqualTo(expectedSlicedArray);
  }

  @Test
  public void getSlicedResultSetWhenCountIsGreaterThanOriginalArrayLength() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> array.getResultSet(2, 10));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo("The array index is out of range: 12, number of elements: 4.");
  }

  @Test
  public void getBaseTypeName() throws SQLException {
    assertThat(array.getBaseTypeName()).isEqualTo(this.currentType.name());
  }

  @Test
  public void getBaseType() throws SQLException {
    assertThat(array.getBaseType()).isEqualTo(this.javaSqlTypeCode);
  }

  @Test
  public void free() throws SQLException {
    this.array.free();

    ensureArrayIsInvalid(() -> array.getArray());
    ensureArrayIsInvalid(() -> array.getArray(1, 2));
    ensureArrayIsInvalid(() -> array.getResultSet());
    ensureArrayIsInvalid(() -> array.getResultSet(1, 2));
    ensureArrayIsInvalid(() -> array.getBaseTypeName());
    ensureArrayIsInvalid(() -> array.getBaseType());
  }

  @Test
  public void getArrayWithCustomTypeMappingsIsNotSupported() {
    Exception exception1 =
        assertThrows(SQLFeatureNotSupportedException.class, () -> array.getArray(emptyMap()));
    Exception exception2 =
        assertThrows(SQLFeatureNotSupportedException.class, () -> array.getArray(1, 2, emptyMap()));
    assertThat(exception1.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
    assertThat(exception2.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Test
  public void getResultSetWithCustomTypeMappingsIsNotSupported() {
    Exception exception1 =
        assertThrows(SQLFeatureNotSupportedException.class, () -> array.getResultSet(emptyMap()));
    Exception exception2 =
        assertThrows(
            SQLFeatureNotSupportedException.class, () -> array.getResultSet(1, 2, emptyMap()));
    assertThat(exception1.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
    assertThat(exception2.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  private void ensureArrayIsInvalid(ThrowingRunnable block) {
    Exception exception = assertThrows(IllegalStateException.class, block);
    assertThat(exception.getMessage()).isEqualTo(INVALID_ARRAY);
  }
}
