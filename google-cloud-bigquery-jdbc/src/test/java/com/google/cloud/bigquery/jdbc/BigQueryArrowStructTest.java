/*
 * Copyright 2023 Google LLC
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
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.arrowArraySchemaAndValue;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.arrowStructOf;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.toArrowStruct;
import static com.google.common.truth.Truth.assertThat;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.Month.MARCH;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;
import org.apache.arrow.vector.util.Text;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BigQueryArrowStructTest {

  @Rule public final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  private Struct structWithPrimitiveValues;

  @Before
  public void setUp() {
    Tuple<FieldList, JsonStringHashMap<String, Object>> schemaAndValues =
        arrowStructOf(
            Tuple.of(INT64, Long.valueOf("10")),
            Tuple.of(BOOL, TRUE),
            Tuple.of(FLOAT64, Double.valueOf("11.2")),
            Tuple.of(NUMERIC, new BigDecimal("11.2657")),
            Tuple.of(BIGNUMERIC, new BigDecimal("11.2657")),
            Tuple.of(STRING, new Text("one")),
            Tuple.of(TIMESTAMP, Long.valueOf("1680174859820227")), // 2023-03-30 16:44:19.82
            Tuple.of(DATE, 19446), // 2023-03-30
            Tuple.of(TIME, Long.valueOf("40459820227")),
            Tuple.of(DATETIME, LocalDateTime.parse("2023-03-30T11:14:19.820227")),
            Tuple.of(GEOGRAPHY, new Text("POINT(-122 47)")),
            Tuple.of(BYTES, "one".getBytes()));

    structWithPrimitiveValues = new BigQueryArrowStruct(schemaAndValues.x(), schemaAndValues.y());
  }

  @Test
  public void structOfPrimitives() throws SQLException {
    assertThat(structWithPrimitiveValues.getAttributes())
        .isEqualTo(
            asList(
                    10L,
                    true,
                    11.2,
                    new BigDecimal("11.2657"),
                    new BigDecimal("11.2657"),
                    "one",
                    Timestamp.valueOf(LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820227000)),
                    Date.valueOf(LocalDate.of(2023, MARCH, 30)),
                    Time.valueOf(LocalTime.of(11, 14, 19, 820227)),
                    Timestamp.valueOf("2023-03-30 11:14:19.820227"),
                    "POINT(-122 47)",
                    "one".getBytes())
                .toArray());
  }

  @Test
  public void structOfArrays() throws SQLException {
    LocalDateTime aTimeStamp = LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820227000);
    LocalDate aDate = LocalDate.of(2023, MARCH, 30);
    LocalTime aTime = LocalTime.of(11, 14, 19, 820227);
    List<Tuple<Field, JsonStringArrayList<Object>>> schemaAndValues =
        Arrays.asList(
            arrowArraySchemaAndValue(INT64, 10L, 20L),
            arrowArraySchemaAndValue(BOOL, Boolean.TRUE, FALSE),
            arrowArraySchemaAndValue(FLOAT64, Double.valueOf("11.2"), Double.valueOf("33.4")),
            arrowArraySchemaAndValue(NUMERIC, new BigDecimal("11.2657"), new BigDecimal("33.4657")),
            arrowArraySchemaAndValue(
                BIGNUMERIC, new BigDecimal("11.2657"), new BigDecimal("33.4657")),
            arrowArraySchemaAndValue(STRING, new Text("one"), new Text("two")),
            arrowArraySchemaAndValue(
                TIMESTAMP, Long.valueOf("1680174859820227"), Long.valueOf("1680261259820227")),
            arrowArraySchemaAndValue(DATE, 19446, 19447),
            arrowArraySchemaAndValue(
                TIME, Long.valueOf("40459820227"), Long.valueOf("40460820227")),
            arrowArraySchemaAndValue(
                DATETIME,
                LocalDateTime.parse("2023-03-30T11:14:19.820227"),
                LocalDateTime.parse("2023-03-30T11:15:19.820227")),
            arrowArraySchemaAndValue(
                GEOGRAPHY, new Text("POINT(-122 47)"), new Text("POINT(-122 48)")),
            arrowArraySchemaAndValue(
                BYTES, Stream.of("one", "two").map(String::getBytes).toArray(byte[][]::new)));

    List<Field> orderedSchemas =
        schemaAndValues.stream().map(Tuple::x).collect(Collectors.toList());
    JsonStringHashMap<String, Object> jsonStringHashMap = toArrowStruct(schemaAndValues);

    Struct struct = new BigQueryArrowStruct(FieldList.of(orderedSchemas), jsonStringHashMap);

    Object[] attributes = struct.getAttributes();
    assertThat(((Array) attributes[0]).getArray()).isEqualTo(new Long[] {10L, 20L});
    assertThat(((Array) attributes[1]).getArray()).isEqualTo(new Boolean[] {true, false});
    assertThat(((Array) attributes[2]).getArray()).isEqualTo(new Double[] {11.2, 33.4});
    assertThat(((Array) attributes[3]).getArray())
        .isEqualTo(new BigDecimal[] {new BigDecimal("11.2657"), new BigDecimal("33.4657")});
    assertThat(((Array) attributes[4]).getArray())
        .isEqualTo(new BigDecimal[] {new BigDecimal("11.2657"), new BigDecimal("33.4657")});
    assertThat(((Array) attributes[5]).getArray()).isEqualTo(new String[] {"one", "two"});
    assertThat(((Array) attributes[6]).getArray())
        .isEqualTo(
            new Timestamp[] {
              Timestamp.valueOf(aTimeStamp), // 2023-03-30 16:44:19.82
              Timestamp.valueOf(aTimeStamp.plusDays(1))
            });
    assertThat(((Array) attributes[7]).getArray())
        .isEqualTo(new Date[] {Date.valueOf(aDate), Date.valueOf(aDate.plusDays(1))});
    assertThat(((Array) attributes[8]).getArray())
        .isEqualTo(new Time[] {Time.valueOf(aTime), Time.valueOf(aTime.plusSeconds(1))});
    assertThat(((Array) attributes[9]).getArray()) // DATETIME
        .isEqualTo(
            new Timestamp[] {
              Timestamp.valueOf("2023-03-30 11:14:19.820227"),
              Timestamp.valueOf("2023-03-30 11:15:19.820227")
            });
    assertThat(((Array) attributes[10]).getArray())
        .isEqualTo(new String[] {"POINT(-122 47)", "POINT(-122 48)"});
    assertThat(((Array) attributes[11]).getArray())
        .isEqualTo(new byte[][] {"one".getBytes(), "two".getBytes()});
  }

  @Test
  public void structOfStructs() throws SQLException {
    FieldList profileSchema =
        FieldList.of(
            Field.of("name", LegacySQLTypeName.STRING),
            Field.of("age", LegacySQLTypeName.INTEGER),
            Field.of("adult", LegacySQLTypeName.BOOLEAN));
    FieldList addressSchema =
        FieldList.of(
            Field.of("state", LegacySQLTypeName.STRING),
            Field.of("zip", LegacySQLTypeName.INTEGER));
    FieldList rootStructSchema =
        FieldList.of(
            Field.of("profile", LegacySQLTypeName.RECORD, profileSchema),
            Field.of("address", LegacySQLTypeName.RECORD, addressSchema));

    JsonStringHashMap<String, Object> profileValue =
        new JsonStringHashMap<String, Object>() {
          {
            put("name", new Text("Arya"));
            put("age", 15L);
            put("adult", FALSE);
          }
        };
    JsonStringHashMap<String, Object> addressValue =
        new JsonStringHashMap<String, Object>() {
          {
            put("state", new Text("Michigan"));
            put("zip", 49086L);
          }
        };
    JsonStringHashMap<String, Object> rootStructValue =
        new JsonStringHashMap<String, Object>() {
          {
            put("profile", profileValue);
            put("address", addressValue);
          }
        };

    Struct struct = new BigQueryArrowStruct(rootStructSchema, rootStructValue);
    Object[] attributes = struct.getAttributes();
    Struct profileStruct = (Struct) attributes[0];
    Struct addressStruct = (Struct) attributes[1];

    assertThat(profileStruct.getAttributes()).isEqualTo(asList("Arya", 15L, false).toArray());
    assertThat(addressStruct.getAttributes()).isEqualTo(asList("Michigan", 49086L).toArray());
  }

  @Test
  public void getSQLTypeNameIsNotSupported() {
    Exception exception =
        assertThrows(
            SQLFeatureNotSupportedException.class, structWithPrimitiveValues::getSQLTypeName);
    assertThat(exception.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Test
  public void getAttributesWithCustomTypeMappingsIsNotSupported() {
    Exception exception =
        assertThrows(
            SQLFeatureNotSupportedException.class,
            () -> structWithPrimitiveValues.getAttributes(emptyMap()));
    assertThat(exception.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }
}
