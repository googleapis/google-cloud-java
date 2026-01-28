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

import static com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE;
import static com.google.cloud.bigquery.FieldValue.Attribute.RECORD;
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
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.arraySchemaAndValue;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.primitiveSchemaAndValue;
import static com.google.common.io.BaseEncoding.base64;
import static com.google.common.truth.Truth.assertThat;
import static java.time.Month.MARCH;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.jdbc.rules.TimeZoneRule;
import com.google.common.io.BaseEncoding;
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
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BigQueryJsonStructTest {

  @Rule public final TimeZoneRule timeZoneRule = new TimeZoneRule("UTC");

  private Struct structWithPrimitiveValues;
  private Struct structWithNullValue;

  @Before
  public void setUp() {
    List<Tuple<Field, FieldValue>> schemaAndValues =
        Arrays.asList(
            primitiveSchemaAndValue(INT64, "10"),
            primitiveSchemaAndValue(BOOL, "true"),
            primitiveSchemaAndValue(FLOAT64, "11.2"),
            primitiveSchemaAndValue(NUMERIC, "11.2657"),
            primitiveSchemaAndValue(BIGNUMERIC, "11.2657"),
            primitiveSchemaAndValue(STRING, "one"),
            primitiveSchemaAndValue(TIMESTAMP, "1680174859.8200000"), // 2023-03-30 16:44:19.82
            primitiveSchemaAndValue(DATE, "2023-03-30"),
            primitiveSchemaAndValue(TIME, "11:14:19.820000"),
            primitiveSchemaAndValue(DATETIME, "2023-03-30T11:14:19.8200000"),
            primitiveSchemaAndValue(GEOGRAPHY, "POINT(-122 47)"),
            primitiveSchemaAndValue(BYTES, base64().encode("one".getBytes())));
    List<Field> orderedSchemas =
        schemaAndValues.stream().map(Tuple::x).collect(Collectors.toList());
    List<FieldValue> orderedValues =
        schemaAndValues.stream().map(Tuple::y).collect(Collectors.toList());

    structWithPrimitiveValues =
        new BigQueryJsonStruct(
            FieldList.of(orderedSchemas), FieldValue.of(RECORD, FieldValueList.of(orderedValues)));
    structWithNullValue =
        new BigQueryJsonStruct(FieldList.of(orderedSchemas), FieldValue.of(PRIMITIVE, null));
  }

  @Test
  public void structOfPrimitives() throws SQLException {
    assertThat(structWithPrimitiveValues.getAttributes())
        .isEqualTo(
            Arrays.asList(
                    10L,
                    true,
                    11.2,
                    new BigDecimal("11.2657"),
                    new BigDecimal("11.2657"),
                    "one",
                    Timestamp.valueOf(LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820000000)),
                    Date.valueOf(LocalDate.of(2023, MARCH, 30)),
                    new Time(
                        TimeUnit.NANOSECONDS.toMillis(
                            LocalTime.parse("11:14:19.820").toNanoOfDay())),
                    Timestamp.valueOf("2023-03-30 11:14:19.8200000"),
                    "POINT(-122 47)",
                    "one".getBytes())
                .toArray());
  }

  @Test
  public void structOfArrays() throws SQLException {
    LocalDateTime aTimeStamp = LocalDateTime.of(2023, MARCH, 30, 11, 14, 19, 820000000);
    LocalDate aDate = LocalDate.of(2023, MARCH, 30);
    LocalTime aTime = LocalTime.of(11, 14, 19, 820000000);
    List<Tuple<Field, FieldValue>> schemaAndValues =
        Arrays.asList(
            arraySchemaAndValue(INT64, "10", "20"),
            arraySchemaAndValue(BOOL, "true", "false"),
            arraySchemaAndValue(FLOAT64, "11.2", "33.4"),
            arraySchemaAndValue(NUMERIC, "11.2657", "33.4657"),
            arraySchemaAndValue(BIGNUMERIC, "11.2657", "33.4657"),
            arraySchemaAndValue(STRING, "one", "two"),
            arraySchemaAndValue(TIMESTAMP, "1680174859.820000", "1680261259.820000"),
            arraySchemaAndValue(DATE, "2023-03-30", "2023-03-31"),
            arraySchemaAndValue(TIME, "11:14:19.820000", "11:14:20.820000"),
            arraySchemaAndValue(
                DATETIME, "2023-03-30T11:14:19.820000", "2023-03-30T11:15:19.820000"),
            arraySchemaAndValue(GEOGRAPHY, "POINT(-122 47)", "POINT(-122 48)"),
            arraySchemaAndValue(
                BYTES,
                Stream.of("one", "two")
                    .map(s -> BaseEncoding.base64().encode(s.getBytes()))
                    .toArray(String[]::new)));

    List<Field> orderedSchemas =
        schemaAndValues.stream().map(Tuple::x).collect(Collectors.toList());
    List<FieldValue> orderedValues =
        schemaAndValues.stream().map(Tuple::y).collect(Collectors.toList());

    Struct struct =
        new BigQueryJsonStruct(
            FieldList.of(orderedSchemas), FieldValue.of(RECORD, FieldValueList.of(orderedValues)));

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
        .isEqualTo(
            new Time[] {
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.toNanoOfDay())),
              new Time(TimeUnit.NANOSECONDS.toMillis(aTime.plusSeconds(1).toNanoOfDay()))
            });
    assertThat(((Array) attributes[9]).getArray()) // DATETIME
        .isEqualTo(
            new Timestamp[] {
              Timestamp.valueOf("2023-03-30 11:14:19.820000"),
              Timestamp.valueOf("2023-03-30 11:15:19.820000")
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

    FieldValue profileValue =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(
                    FieldValue.of(PRIMITIVE, "Arya"),
                    FieldValue.of(PRIMITIVE, "15"),
                    FieldValue.of(PRIMITIVE, "false"))));
    FieldValue addressValue =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(FieldValue.of(PRIMITIVE, "Michigan"), FieldValue.of(PRIMITIVE, "49086"))));

    FieldValue rootStructValue =
        FieldValue.of(RECORD, FieldValueList.of(asList(profileValue, addressValue)));

    Struct struct = new BigQueryJsonStruct(rootStructSchema, rootStructValue);
    Object[] attributes = struct.getAttributes();
    Struct profileStruct = (Struct) attributes[0];
    Struct addressStruct = (Struct) attributes[1];

    assertThat(profileStruct.getAttributes()).isEqualTo(asList("Arya", 15L, false).toArray());
    assertThat(addressStruct.getAttributes()).isEqualTo(asList("Michigan", 49086L).toArray());
  }

  @Test
  public void structWithNullValue() throws SQLException {
    assertThat(structWithNullValue.getAttributes())
        .isEqualTo(
            Arrays.asList(0L, false, 0.0, null, null, null, null, null, null, null, null, null)
                .toArray());
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
