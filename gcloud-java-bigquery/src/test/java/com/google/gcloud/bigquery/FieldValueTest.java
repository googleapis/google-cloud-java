/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.TableCell;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

public class FieldValueTest {

  private static final TableCell BOOLEAN_FIELD = new TableCell().setV("false");
  private static final Map<String, String> INTEGER_FIELD = ImmutableMap.of("v", "1");
  private static final Map<String, String> FLOAT_FIELD = ImmutableMap.of("v", "1.5");
  private static final Map<String, String> STRING_FIELD = ImmutableMap.of("v", "string");
  private static final Map<String, String> TIMESTAMP_FIELD = ImmutableMap.of("v", "42");
  private static final Map<String, Object> NULL_FIELD =
      ImmutableMap.of("v", Data.nullOf(String.class));
  private static final Map<String, Object> REPEATED_FIELD =
      ImmutableMap.<String, Object>of("v", ImmutableList.<Object>of(INTEGER_FIELD, INTEGER_FIELD));
  private static final Map<String, Object> RECORD_FIELD =
      ImmutableMap.<String, Object>of("f", ImmutableList.<Object>of(FLOAT_FIELD, TIMESTAMP_FIELD));

  @Test
  public void testFromPb() {
    FieldValue value = FieldValue.fromPb(BOOLEAN_FIELD);
    assertEquals(FieldValue.Kind.PRIMITIVE, value.kind());
    assertFalse(value.booleanValue());
    value = FieldValue.fromPb(INTEGER_FIELD);
    assertEquals(FieldValue.Kind.PRIMITIVE, value.kind());
    assertEquals(1, value.longValue());
    value = FieldValue.fromPb(FLOAT_FIELD);
    assertEquals(FieldValue.Kind.PRIMITIVE, value.kind());
    assertEquals(1.5, value.doubleValue(), 0);
    value = FieldValue.fromPb(STRING_FIELD);
    assertEquals(FieldValue.Kind.PRIMITIVE, value.kind());
    assertEquals("string", value.stringValue());
    value = FieldValue.fromPb(TIMESTAMP_FIELD);
    assertEquals(FieldValue.Kind.PRIMITIVE, value.kind());
    assertEquals(42000000, value.timestampValue());
    value = FieldValue.fromPb(NULL_FIELD);
    assertNull(value.value());
    value = FieldValue.fromPb(REPEATED_FIELD);
    assertEquals(FieldValue.Kind.REPEATED, value.kind());
    assertEquals(FieldValue.fromPb(INTEGER_FIELD), value.repeatedValue().get(0));
    assertEquals(FieldValue.fromPb(INTEGER_FIELD), value.repeatedValue().get(1));
    value = FieldValue.fromPb(RECORD_FIELD);
    assertEquals(FieldValue.Kind.RECORD, value.kind());
    assertEquals(FieldValue.fromPb(FLOAT_FIELD), value.repeatedValue().get(0));
    assertEquals(FieldValue.fromPb(TIMESTAMP_FIELD), value.repeatedValue().get(1));
  }

  @Test
  public void testEquals() {
    FieldValue booleanValue = new FieldValue(FieldValue.Kind.PRIMITIVE, "false");
    assertEquals(booleanValue, FieldValue.fromPb(BOOLEAN_FIELD));
    assertEquals(booleanValue.hashCode(), FieldValue.fromPb(BOOLEAN_FIELD).hashCode());

    FieldValue integerValue = new FieldValue(FieldValue.Kind.PRIMITIVE, "1");
    assertEquals(integerValue, FieldValue.fromPb(INTEGER_FIELD));
    assertEquals(integerValue.hashCode(), FieldValue.fromPb(INTEGER_FIELD).hashCode());

    FieldValue floatValue = new FieldValue(FieldValue.Kind.PRIMITIVE, "1.5");
    assertEquals(floatValue, FieldValue.fromPb(FLOAT_FIELD));
    assertEquals(floatValue.hashCode(), FieldValue.fromPb(FLOAT_FIELD).hashCode());

    FieldValue stringValue = new FieldValue(FieldValue.Kind.PRIMITIVE, "string");
    assertEquals(stringValue, FieldValue.fromPb(STRING_FIELD));
    assertEquals(stringValue.hashCode(), FieldValue.fromPb(STRING_FIELD).hashCode());

    FieldValue timestampValue = new FieldValue(FieldValue.Kind.PRIMITIVE, "42");
    assertEquals(timestampValue, FieldValue.fromPb(TIMESTAMP_FIELD));
    assertEquals(timestampValue.hashCode(), FieldValue.fromPb(TIMESTAMP_FIELD).hashCode());

    FieldValue nullValue = new FieldValue(FieldValue.Kind.PRIMITIVE, null);
    assertEquals(nullValue, FieldValue.fromPb(NULL_FIELD));
    assertEquals(nullValue.hashCode(), FieldValue.fromPb(NULL_FIELD).hashCode());

    FieldValue repeatedValue = new FieldValue(FieldValue.Kind.REPEATED,
        ImmutableList.of(integerValue, integerValue));
    assertEquals(repeatedValue, FieldValue.fromPb(REPEATED_FIELD));
    assertEquals(repeatedValue.hashCode(), FieldValue.fromPb(REPEATED_FIELD).hashCode());

    FieldValue recordValue = new FieldValue(FieldValue.Kind.RECORD,
        ImmutableList.of(floatValue, timestampValue));
    assertEquals(recordValue, FieldValue.fromPb(RECORD_FIELD));
    assertEquals(recordValue.hashCode(), FieldValue.fromPb(RECORD_FIELD).hashCode());
  }
}
