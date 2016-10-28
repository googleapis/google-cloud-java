/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructsTest {

  private static final Double NUMBER = 42.0;
  private static final String STRING = "string";
  private static final Boolean BOOLEAN = true;
  private static final List<Object> LIST = ImmutableList.<Object>of(NUMBER, STRING, BOOLEAN);
  private static final Map<String, Object> INNER_MAP = new HashMap<>();
  private static final Map<String, Object> MAP = new HashMap<>();
  private static final Value NULL_VALUE =
      Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
  private static final Value NUMBER_VALUE =
      Value.newBuilder().setNumberValue(NUMBER).build();
  private static final Value STRING_VALUE =
      Value.newBuilder().setStringValue(STRING).build();
  private static final Value BOOLEAN_VALUE =
      Value.newBuilder().setBoolValue(BOOLEAN).build();
  private static final ListValue PROTO_LIST = ListValue.newBuilder()
      .addAllValues(ImmutableList.of(NUMBER_VALUE, STRING_VALUE, BOOLEAN_VALUE))
      .build();
  private static final Value LIST_VALUE = Value.newBuilder()
      .setListValue(PROTO_LIST)
      .build();
  private static final Struct INNER_STRUCT = Struct.newBuilder().putAllFields(ImmutableMap.of(
      "null", NULL_VALUE,
      "number", NUMBER_VALUE,
      "string", STRING_VALUE,
      "boolean", BOOLEAN_VALUE,
      "list", LIST_VALUE)).build();
  private static final Value STRUCT_VALUE = Value.newBuilder().setStructValue(INNER_STRUCT).build();
  private static final Map<String, Value> VALUE_MAP = ImmutableMap.<String, Value>builder()
      .put("null", NULL_VALUE)
      .put("number", NUMBER_VALUE)
      .put("string", STRING_VALUE)
      .put("boolean", BOOLEAN_VALUE)
      .put("list", LIST_VALUE)
      .put("struct", STRUCT_VALUE)
      .build();
  private static final Struct STRUCT = Struct.newBuilder().putAllFields(VALUE_MAP).build();
  private static final Map<String, Object> EMPTY_MAP = Collections.emptyMap();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    INNER_MAP.put("null", null);
    INNER_MAP.put("number", NUMBER);
    INNER_MAP.put("string", STRING);
    INNER_MAP.put("boolean", BOOLEAN);
    INNER_MAP.put("list", LIST);
    MAP.put("null", null);
    MAP.put("number", NUMBER);
    MAP.put("string", STRING);
    MAP.put("boolean", BOOLEAN);
    MAP.put("list", LIST);
    MAP.put("struct", INNER_MAP);
  }

  private <T> void checkMapField(Map<String, T> map, String key, T expected) {
    assertTrue(map.containsKey(key));
    assertEquals(expected, map.get(key));
  }

  private void checkStructField(Struct struct, String key, Value expected) {
    Map<String, Value> map = struct.getFieldsMap();
    checkMapField(map, key, expected);
  }

  @Test
  public void testAsMap() {
    Map<String, Object> map = Structs.asMap(STRUCT);
    checkMapField(map, "null", null);
    checkMapField(map, "number", NUMBER);
    checkMapField(map, "string", STRING);
    checkMapField(map, "boolean", BOOLEAN);
    checkMapField(map, "list", LIST);
    checkMapField(map, "struct", INNER_MAP);
    assertEquals(MAP, map);
  }

  @Test
  public void testAsMapPut() {
    Map<String, Object> map = Structs.asMap(STRUCT);
    thrown.expect(UnsupportedOperationException.class);
    map.put("key", "value");
  }

  @Test
  public void testAsMapRemove() {
    Map<String, Object> map = Structs.asMap(STRUCT);
    thrown.expect(UnsupportedOperationException.class);
    map.remove("null");
  }

  @Test
  public void testAsMapEmpty() {
    Map<String, Object> map = Structs.asMap(Struct.getDefaultInstance());
    assertTrue(map.isEmpty());
    assertEquals(EMPTY_MAP, map);
  }

  @Test
  public void testAsMapNull() {
    thrown.expect(NullPointerException.class);
    Structs.asMap(null);
  }

  @Test
  public void testNewStruct() {
    Struct struct = Structs.newStruct(MAP);
    checkStructField(struct, "null", NULL_VALUE);
    checkStructField(struct, "number", NUMBER_VALUE);
    checkStructField(struct, "string", STRING_VALUE);
    checkStructField(struct, "boolean", BOOLEAN_VALUE);
    checkStructField(struct, "list", LIST_VALUE);
    checkStructField(struct, "struct", STRUCT_VALUE);
    assertEquals(STRUCT, struct);
  }

  @Test
  public void testNewStructEmpty() {
    Struct struct = Structs.newStruct(EMPTY_MAP);
    assertTrue(struct.getFieldsMap().isEmpty());
  }

  @Test
  public void testNewStructNull() {
    thrown.expect(NullPointerException.class);
    Structs.newStruct(null);
  }

  @Test
  public void testNumbers() {
    int intNumber = Integer.MIN_VALUE;
    long longNumber = Long.MAX_VALUE;
    float floatNumber = Float.MIN_VALUE;
    double doubleNumber = Double.MAX_VALUE;
    Map<String, Object> map = ImmutableMap.<String, Object>of(
        "int", intNumber, "long", longNumber, "float", floatNumber, "double", doubleNumber);
    Struct struct = Structs.newStruct(map);
    checkStructField(struct, "int", Value.newBuilder().setNumberValue(intNumber).build());
    checkStructField(struct, "long", Value.newBuilder().setNumberValue(longNumber).build());
    checkStructField(struct, "float", Value.newBuilder().setNumberValue(floatNumber).build());
    checkStructField(struct, "double", Value.newBuilder().setNumberValue(doubleNumber).build());
    Map<String, Object> convertedMap = Structs.asMap(struct);
    assertTrue(convertedMap.get("int") instanceof Double);
    assertTrue(convertedMap.get("long") instanceof Double);
    assertTrue(convertedMap.get("float") instanceof Double);
    assertTrue(convertedMap.get("double") instanceof Double);
    int convertedInteger = ((Double) convertedMap.get("int")).intValue();
    long convertedLong = ((Double) convertedMap.get("long")).longValue();
    float convertedFloat = ((Double) convertedMap.get("float")).floatValue();
    double convertedDouble = (Double) convertedMap.get("double");
    assertEquals(intNumber, convertedInteger);
    assertEquals(longNumber, convertedLong);
    assertEquals(floatNumber, convertedFloat, 0);
    assertEquals(doubleNumber, convertedDouble, 0);
  }
}
