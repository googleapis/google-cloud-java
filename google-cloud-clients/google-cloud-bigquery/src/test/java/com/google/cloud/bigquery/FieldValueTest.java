/*
 * Copyright 2015 Google LLC
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableCell;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.Test;

public class FieldValueTest {

  private static final byte[] BYTES = {0xD, 0xE, 0xA, 0xD};
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  private static final TableCell BOOLEAN_FIELD = new TableCell().setV("false");
  private static final Map<String, String> INTEGER_FIELD = ImmutableMap.of("v", "1");
  private static final Map<String, String> FLOAT_FIELD = ImmutableMap.of("v", "1.5");
  private static final Map<String, String> NUMERIC_FIELD =
      ImmutableMap.of("v", "123456789.123456789");
  private static final Map<String, String> STRING_FIELD = ImmutableMap.of("v", "string");
  private static final Map<String, String> TIMESTAMP_FIELD = ImmutableMap.of("v", "42");
  private static final Map<String, String> BYTES_FIELD = ImmutableMap.of("v", BYTES_BASE64);
  private static final Map<String, Object> NULL_FIELD =
      ImmutableMap.of("v", Data.nullOf(String.class));
  private static final Map<String, Object> REPEATED_FIELD =
      ImmutableMap.<String, Object>of("v", ImmutableList.<Object>of(INTEGER_FIELD, INTEGER_FIELD));
  private static final Map<String, Object> RECORD_FIELD =
      ImmutableMap.<String, Object>of("f", ImmutableList.<Object>of(FLOAT_FIELD, TIMESTAMP_FIELD));

  @Test
  public void testFromPb() {
    FieldValue value = FieldValue.fromPb(BOOLEAN_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertFalse(value.getBooleanValue());
    value = FieldValue.fromPb(INTEGER_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertEquals(1, value.getLongValue());
    value = FieldValue.fromPb(FLOAT_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertEquals(1.5, value.getDoubleValue(), 0);
    value = FieldValue.fromPb(NUMERIC_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertEquals(new BigDecimal("123456789.123456789"), value.getNumericValue());
    value = FieldValue.fromPb(STRING_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertEquals("string", value.getStringValue());
    value = FieldValue.fromPb(TIMESTAMP_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertEquals(42000000, value.getTimestampValue());
    value = FieldValue.fromPb(BYTES_FIELD);
    assertEquals(FieldValue.Attribute.PRIMITIVE, value.getAttribute());
    assertArrayEquals(BYTES, value.getBytesValue());
    value = FieldValue.fromPb(NULL_FIELD);
    assertNull(value.getValue());
    value = FieldValue.fromPb(REPEATED_FIELD);
    assertEquals(FieldValue.Attribute.REPEATED, value.getAttribute());
    assertEquals(FieldValue.fromPb(INTEGER_FIELD), value.getRepeatedValue().get(0));
    assertEquals(FieldValue.fromPb(INTEGER_FIELD), value.getRepeatedValue().get(1));
    value = FieldValue.fromPb(RECORD_FIELD);
    assertEquals(FieldValue.Attribute.RECORD, value.getAttribute());
    assertEquals(FieldValue.fromPb(FLOAT_FIELD), value.getRepeatedValue().get(0));
    assertEquals(FieldValue.fromPb(TIMESTAMP_FIELD), value.getRepeatedValue().get(1));
  }

  @Test
  public void testEquals() {
    FieldValue booleanValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "false");
    assertEquals(booleanValue, FieldValue.fromPb(BOOLEAN_FIELD));
    assertEquals(booleanValue.hashCode(), FieldValue.fromPb(BOOLEAN_FIELD).hashCode());

    FieldValue integerValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "1");
    assertEquals(integerValue, FieldValue.fromPb(INTEGER_FIELD));
    assertEquals(integerValue.hashCode(), FieldValue.fromPb(INTEGER_FIELD).hashCode());

    FieldValue floatValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "1.5");
    assertEquals(floatValue, FieldValue.fromPb(FLOAT_FIELD));
    assertEquals(floatValue.hashCode(), FieldValue.fromPb(FLOAT_FIELD).hashCode());

    FieldValue numericValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "123456789.123456789");
    assertEquals(numericValue, FieldValue.fromPb(NUMERIC_FIELD));
    assertEquals(numericValue.hashCode(), FieldValue.fromPb(NUMERIC_FIELD).hashCode());

    FieldValue stringValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "string");
    assertEquals(stringValue, FieldValue.fromPb(STRING_FIELD));
    assertEquals(stringValue.hashCode(), FieldValue.fromPb(STRING_FIELD).hashCode());

    FieldValue timestampValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, "42");
    assertEquals(timestampValue, FieldValue.fromPb(TIMESTAMP_FIELD));
    assertEquals(timestampValue.hashCode(), FieldValue.fromPb(TIMESTAMP_FIELD).hashCode());

    FieldValue bytesValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, BYTES_BASE64);
    assertEquals(bytesValue, FieldValue.fromPb(BYTES_FIELD));
    assertEquals(bytesValue.hashCode(), FieldValue.fromPb(BYTES_FIELD).hashCode());

    FieldValue nullValue = FieldValue.of(FieldValue.Attribute.PRIMITIVE, null);
    assertEquals(nullValue, FieldValue.fromPb(NULL_FIELD));
    assertEquals(nullValue.hashCode(), FieldValue.fromPb(NULL_FIELD).hashCode());

    FieldValue repeatedValue =
        FieldValue.of(FieldValue.Attribute.REPEATED, ImmutableList.of(integerValue, integerValue));
    assertEquals(repeatedValue, FieldValue.fromPb(REPEATED_FIELD));
    assertEquals(repeatedValue.hashCode(), FieldValue.fromPb(REPEATED_FIELD).hashCode());

    FieldValue recordValue =
        FieldValue.of(FieldValue.Attribute.RECORD, ImmutableList.of(floatValue, timestampValue));
    assertEquals(recordValue, FieldValue.fromPb(RECORD_FIELD));
    assertEquals(recordValue.hashCode(), FieldValue.fromPb(RECORD_FIELD).hashCode());
  }
}
