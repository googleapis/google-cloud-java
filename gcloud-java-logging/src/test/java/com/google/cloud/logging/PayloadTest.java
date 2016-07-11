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

import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.ProtoPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Payload.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayloadTest {

  private static final String STRING_DATA = "string";
  private static final Value NULL_VALUE =
      Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
  private static final Double NUMBER = 42.0;
  private static final Value NUMBER_VALUE = Value.newBuilder().setNumberValue(NUMBER).build();
  private static final String STRING = "string";
  private static final Value STRING_VALUE = Value.newBuilder().setStringValue(STRING).build();
  private static final Boolean BOOLEAN = true;
  private static final Value BOOLEAN_VALUE = Value.newBuilder().setBoolValue(BOOLEAN).build();
  private static final List<Object> LIST = ImmutableList.<Object>of(NUMBER, STRING, BOOLEAN);
  private static final Value VALUE_LIST = Value.newBuilder()
      .setListValue(ListValue.newBuilder()
          .addValues(NUMBER_VALUE)
          .addValues(STRING_VALUE)
          .addValues(BOOLEAN_VALUE)
          .build())
      .build();
  private static final Map<String, Object> INNER_MAP = new HashMap<>();
  private static final Map<String, Object> JSON_DATA = new HashMap<>();
  private static final Struct INNER_STRUCT = Struct.newBuilder()
      .putAllFields(ImmutableMap.of(
          "null", NULL_VALUE,
          "number", NUMBER_VALUE,
          "string", STRING_VALUE,
          "boolean", BOOLEAN_VALUE,
          "list", VALUE_LIST))
      .build();
  private static final Struct STRUCT_DATA = Struct.newBuilder()
      .putAllFields(ImmutableMap.<String, Value>builder()
          .put("null", NULL_VALUE)
          .put("number", NUMBER_VALUE)
          .put("string", STRING_VALUE)
          .put("boolean", BOOLEAN_VALUE)
          .put("list", VALUE_LIST)
          .put("struct", Value.newBuilder().setStructValue(INNER_STRUCT).build())
          .build())
      .build();
  static {
    INNER_MAP.put("null", null);
    INNER_MAP.put("number", NUMBER);
    INNER_MAP.put("string", STRING);
    INNER_MAP.put("boolean", BOOLEAN);
    INNER_MAP.put("list", LIST);
    JSON_DATA.put("null", null);
    JSON_DATA.put("number", NUMBER);
    JSON_DATA.put("string", STRING);
    JSON_DATA.put("boolean", BOOLEAN);
    JSON_DATA.put("list", LIST);
    JSON_DATA.put("struct", INNER_MAP);
  }
  private static final Any PROTO_DATA = Any.getDefaultInstance();
  private static final StringPayload STRING_PAYLOAD = StringPayload.of(STRING_DATA);
  private static final JsonPayload JSON_PAYLOAD = JsonPayload.of(JSON_DATA);
  private static final ProtoPayload PROTO_PAYLOAD = ProtoPayload.of(PROTO_DATA);

  @Test
  public void testOf() {
    assertEquals(Type.STRING, STRING_PAYLOAD.type());
    assertEquals(STRING_DATA, STRING_PAYLOAD.data());
    assertEquals(Type.JSON, JSON_PAYLOAD.type());
    assertEquals(STRUCT_DATA, JSON_PAYLOAD.data());
    assertEquals(JSON_DATA, JSON_PAYLOAD.dataAsMap());
    assertEquals(Type.PROTO, PROTO_PAYLOAD.type());
    assertEquals(PROTO_DATA, PROTO_PAYLOAD.data());
    JsonPayload jsonPayload = JsonPayload.of(STRUCT_DATA);
    assertEquals(Type.JSON, jsonPayload.type());
    assertEquals(STRUCT_DATA, jsonPayload.data());
    assertEquals(JSON_DATA, jsonPayload.dataAsMap());
  }

  @Test
  public void testToAndFromPb() {
    Payload<?> payload = Payload.fromPb(STRING_PAYLOAD.toPb().build());
    assertTrue(payload instanceof StringPayload);
    comparePayload(STRING_PAYLOAD, payload);
    payload = Payload.fromPb(JSON_PAYLOAD.toPb().build());
    assertTrue(payload instanceof JsonPayload);
    comparePayload(JSON_PAYLOAD, payload);
    payload = ProtoPayload.fromPb(PROTO_PAYLOAD.toPb().build());
    assertTrue(payload instanceof ProtoPayload);
    comparePayload(PROTO_PAYLOAD, payload);
  }

  private void comparePayload(Payload<?> expected, Payload<?> value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.data(), value.data());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
