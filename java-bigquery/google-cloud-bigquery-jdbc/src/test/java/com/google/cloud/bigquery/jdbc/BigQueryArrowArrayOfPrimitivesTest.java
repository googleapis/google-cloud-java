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
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.arrowArraySchemaAndValue;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.nestedResultSetToColumnLists;
import static com.google.common.truth.Truth.assertThat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.Month.MARCH;
import static java.util.Arrays.copyOfRange;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
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
import java.util.stream.Stream;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.Text;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BigQueryArrowArrayOfPrimitivesTest {

  private final Field schema;
  private final JsonStringArrayList<?> arrayValues;
  private final Object[] expected;
  private final int javaSqlTypeCode;
  private Array array;
  private final StandardSQLTypeName currentType;

  @ClassRule public static final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  public BigQueryArrowArrayOfPrimitivesTest(
      StandardSQLTypeName currentType,
      Tuple<Field, JsonStringArrayList<?>> schemaAndValue,
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
    array = new BigQueryArrowArray(this.schema, this.arrayValues);
  }

  @Parameters(name = "{index}: primitive array of {0}")
  public static Collection<Object[]> data() {
    timeZoneRule.enforce();
    LocalDateTime aTimeStamp = LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820227000);
    LocalDate aDate = LocalDate.of(2023, MARCH, 30);
    LocalTime aTime = LocalTime.of(11, 14, 19, 820227);
    return Arrays.asList(
        new Object[][] {
          {
            INT64,
            arrowArraySchemaAndValue(INT64, 10L, 20L, 30L, 40L),
            new Long[] {10L, 20L, 30L, 40L},
            Types.BIGINT
          },
          {
            BOOL,
            arrowArraySchemaAndValue(BOOL, TRUE, FALSE, FALSE, TRUE),
            new Boolean[] {true, false, false, true},
            Types.BOOLEAN
          },
          {
            FLOAT64,
            arrowArraySchemaAndValue(
                FLOAT64,
                Double.valueOf("11.2"),
                Double.valueOf("33.4"),
                Double.valueOf("55.6"),
                Double.valueOf("77.8")),
            new Double[] {11.2, 33.4, 55.6, 77.8},
            Types.DOUBLE
          },
          {
            NUMERIC,
            arrowArraySchemaAndValue(
                NUMERIC,
                new BigDecimal("11.2657"),
                new BigDecimal("33.4657"),
                new BigDecimal("55.6657"),
                new BigDecimal("77.8657")),
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
            arrowArraySchemaAndValue(
                BIGNUMERIC,
                new BigDecimal("11.2657"),
                new BigDecimal("33.4657"),
                new BigDecimal("55.6657"),
                new BigDecimal("77.8657")),
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
            arrowArraySchemaAndValue(
                STRING, new Text("one"), new Text("two"), new Text("three"), new Text("four")),
            new String[] {"one", "two", "three", "four"},
            Types.NVARCHAR
          },
          {
            TIMESTAMP,
            arrowArraySchemaAndValue(
                TIMESTAMP,
                Long.valueOf("1680174859820227"),
                Long.valueOf("1680261259820227"),
                Long.valueOf("1680347659820227"),
                Long.valueOf("1680434059820227")),
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
            arrowArraySchemaAndValue(DATE, 19446, 19447, 19448, 19449),
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
            arrowArraySchemaAndValue(
                TIME,
                Long.valueOf("40459820227"), // 11:14:19.820227
                Long.valueOf("40460820227"),
                Long.valueOf("40461820227"),
                Long.valueOf("40462820227")),
            new Time[] {
              Time.valueOf(aTime),
              Time.valueOf(aTime.plusSeconds(1)),
              Time.valueOf(aTime.plusSeconds(2)),
              Time.valueOf(aTime.plusSeconds(3))
            },
            Types.TIME
          },
          {
            DATETIME,
            arrowArraySchemaAndValue(
                DATETIME,
                LocalDateTime.parse("2023-03-30T11:14:19.820227"),
                LocalDateTime.parse("2023-03-30T11:15:19.820227"),
                LocalDateTime.parse("2023-03-30T11:16:19.820227"),
                LocalDateTime.parse("2023-03-30T11:17:19.820227")),
            new Timestamp[] {
              Timestamp.valueOf(LocalDateTime.parse("2023-03-30T11:14:19.820227")),
              Timestamp.valueOf(LocalDateTime.parse("2023-03-30T11:15:19.820227")),
              Timestamp.valueOf(LocalDateTime.parse("2023-03-30T11:16:19.820227")),
              Timestamp.valueOf(LocalDateTime.parse("2023-03-30T11:17:19.820227"))
            },
            Types.TIMESTAMP
          },
          {
            GEOGRAPHY,
            arrowArraySchemaAndValue(
                GEOGRAPHY,
                new Text("POINT(-122 47)"),
                new Text("POINT(-122 48)"),
                new Text("POINT(-121 47)"),
                new Text("POINT(-123 48)")),
            new String[] {"POINT(-122 47)", "POINT(-122 48)", "POINT(-121 47)", "POINT(-123 48)"},
            Types.OTHER
          },
          {
            BYTES,
            arrowArraySchemaAndValue(
                BYTES,
                Stream.of("one", "two", "three", "four")
                    .map(String::getBytes)
                    .toArray(byte[][]::new)), // array of bytes array
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
