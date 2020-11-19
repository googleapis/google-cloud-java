/*
 * Copyright 2017 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableCell;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FieldValueListTest {
  private static final byte[] BYTES = {0xD, 0xE, 0xA, 0xD};
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  private static final TableCell booleanPb = new TableCell().setV("false");

  private final FieldList schema =
      FieldList.of(
          Field.of("first", LegacySQLTypeName.BOOLEAN),
          Field.of("second", LegacySQLTypeName.INTEGER),
          Field.of("third", LegacySQLTypeName.FLOAT),
          Field.of("fourth", LegacySQLTypeName.STRING),
          Field.of("fifth", LegacySQLTypeName.TIMESTAMP),
          Field.of("sixth", LegacySQLTypeName.BYTES),
          Field.of("seventh", LegacySQLTypeName.STRING),
          Field.of("eight", LegacySQLTypeName.INTEGER),
          Field.of(
              "ninth",
              LegacySQLTypeName.RECORD,
              Field.of("first", LegacySQLTypeName.FLOAT),
              Field.of("second", LegacySQLTypeName.TIMESTAMP)),
          Field.of("tenth", LegacySQLTypeName.NUMERIC),
          Field.of("eleventh", LegacySQLTypeName.BIGNUMERIC));

  private final Map<String, String> integerPb = ImmutableMap.of("v", "1");
  private final Map<String, String> floatPb = ImmutableMap.of("v", "1.5");
  private final Map<String, String> stringPb = ImmutableMap.of("v", "string");
  private final Map<String, String> timestampPb = ImmutableMap.of("v", "42");
  private final Map<String, String> bytesPb = ImmutableMap.of("v", BYTES_BASE64);
  private final Map<String, String> nullPb = ImmutableMap.of("v", Data.nullOf(String.class));
  private final Map<String, Object> repeatedPb =
      ImmutableMap.<String, Object>of("v", ImmutableList.<Object>of(integerPb, integerPb));
  private final Map<String, Object> recordPb =
      ImmutableMap.<String, Object>of("f", ImmutableList.<Object>of(floatPb, timestampPb));
  private final Map<String, String> numericPb = ImmutableMap.of("v", "123456789.123456789");
  private final Map<String, String> bigNumericPb =
      ImmutableMap.of(
          "v", "99999999999999999999999999999999999999.99999999999999999999999999999999999999");

  private final FieldValue booleanFv = FieldValue.of(Attribute.PRIMITIVE, "false");
  private final FieldValue integerFv = FieldValue.of(Attribute.PRIMITIVE, "1");
  private final FieldValue floatFv = FieldValue.of(Attribute.PRIMITIVE, "1.5");
  private final FieldValue stringFv = FieldValue.of(Attribute.PRIMITIVE, "string");
  private final FieldValue timestampFv = FieldValue.of(Attribute.PRIMITIVE, "42");
  private final FieldValue bytesFv = FieldValue.of(Attribute.PRIMITIVE, BYTES_BASE64);
  private final FieldValue nullFv = FieldValue.of(Attribute.PRIMITIVE, null);
  private final FieldValue repeatedFv =
      FieldValue.of(Attribute.REPEATED, FieldValueList.of(ImmutableList.of(integerFv, integerFv)));
  private final FieldValue recordFv =
      FieldValue.of(
          Attribute.RECORD,
          FieldValueList.of(
              ImmutableList.of(floatFv, timestampFv), schema.get("ninth").getSubFields()));
  private final FieldValue numericFv = FieldValue.of(Attribute.PRIMITIVE, "123456789.123456789");
  private final FieldValue bigNumericFv =
      FieldValue.of(
          Attribute.PRIMITIVE,
          "99999999999999999999999999999999999999.99999999999999999999999999999999999999");

  private final List<?> fieldValuesPb =
      ImmutableList.of(
          booleanPb,
          integerPb,
          floatPb,
          stringPb,
          timestampPb,
          bytesPb,
          nullPb,
          repeatedPb,
          recordPb,
          numericPb,
          bigNumericPb);

  private final FieldValueList fieldValues =
      FieldValueList.of(
          ImmutableList.of(
              booleanFv,
              integerFv,
              floatFv,
              stringFv,
              timestampFv,
              bytesFv,
              nullFv,
              repeatedFv,
              recordFv,
              numericFv,
              bigNumericFv),
          schema);

  @Test
  public void testFromPb() {
    assertEquals(fieldValues, FieldValueList.fromPb(fieldValuesPb, schema));
    // Schema does not influence values equality
    assertEquals(fieldValues, FieldValueList.fromPb(fieldValuesPb, null));
  }

  @Test
  public void testGetByIndex() {
    assertEquals(11, fieldValues.size());
    assertEquals(booleanFv, fieldValues.get(0));
    assertEquals(integerFv, fieldValues.get(1));
    assertEquals(floatFv, fieldValues.get(2));
    assertEquals(stringFv, fieldValues.get(3));
    assertEquals(timestampFv, fieldValues.get(4));
    assertEquals(bytesFv, fieldValues.get(5));
    assertEquals(nullFv, fieldValues.get(6));
    assertEquals(repeatedFv, fieldValues.get(7));
    assertEquals(2, fieldValues.get(7).getRepeatedValue().size());
    assertEquals(integerFv, fieldValues.get(7).getRepeatedValue().get(0));
    assertEquals(integerFv, fieldValues.get(7).getRepeatedValue().get(1));
    assertEquals(recordFv, fieldValues.get(8));
    assertEquals(2, fieldValues.get(8).getRecordValue().size());
    assertEquals(floatFv, fieldValues.get(8).getRecordValue().get(0));
    assertEquals(timestampFv, fieldValues.get(8).getRecordValue().get(1));
    assertEquals(numericFv, fieldValues.get(9));
    assertEquals(bigNumericFv, fieldValues.get(10));
  }

  @Test
  public void testGetByName() {
    assertEquals(11, fieldValues.size());
    assertEquals(booleanFv, fieldValues.get("first"));
    assertEquals(integerFv, fieldValues.get("second"));
    assertEquals(floatFv, fieldValues.get("third"));
    assertEquals(stringFv, fieldValues.get("fourth"));
    assertEquals(timestampFv, fieldValues.get("fifth"));
    assertEquals(bytesFv, fieldValues.get("sixth"));
    assertEquals(nullFv, fieldValues.get("seventh"));
    assertEquals(repeatedFv, fieldValues.get("eight"));
    assertEquals(2, fieldValues.get("eight").getRepeatedValue().size());
    assertEquals(integerFv, fieldValues.get("eight").getRepeatedValue().get(0));
    assertEquals(integerFv, fieldValues.get("eight").getRepeatedValue().get(1));
    assertEquals(recordFv, fieldValues.get("ninth"));
    assertEquals(2, fieldValues.get("ninth").getRecordValue().size());
    assertEquals(floatFv, fieldValues.get("ninth").getRecordValue().get("first"));
    assertEquals(timestampFv, fieldValues.get("ninth").getRecordValue().get("second"));
    assertEquals(numericFv, fieldValues.get("tenth"));
    assertEquals(bigNumericFv, fieldValues.get("eleventh"));
  }

  @Test
  public void testNullSchema() {
    FieldValueList fieldValuesNoSchema =
        FieldValueList.of(
            ImmutableList.of(
                booleanFv,
                integerFv,
                floatFv,
                stringFv,
                timestampFv,
                bytesFv,
                nullFv,
                repeatedFv,
                recordFv,
                numericFv,
                bigNumericFv));

    assertEquals(fieldValues, fieldValuesNoSchema);

    UnsupportedOperationException exception = null;
    try {
      fieldValuesNoSchema.get("first");
    } catch (UnsupportedOperationException e) {
      exception = e;
    }

    assertNotNull(exception);
  }

  @Test
  public void testGetNonExistentField() {
    IllegalArgumentException exception = null;
    try {
      fieldValues.get("nonexistent");
    } catch (IllegalArgumentException e) {
      exception = e;
    }

    assertNotNull(exception);
  }
}
