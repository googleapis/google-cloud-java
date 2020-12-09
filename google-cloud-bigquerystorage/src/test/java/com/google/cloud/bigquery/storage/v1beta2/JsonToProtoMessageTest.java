/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.Assert.assertEquals;

import com.google.cloud.bigquery.storage.test.JsonTest.*;
import com.google.cloud.bigquery.storage.test.SchemaTest.*;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JsonToProtoMessageTest {
  private static ImmutableMap<Descriptor, String> AllTypesToDebugMessageTest =
      new ImmutableMap.Builder<Descriptor, String>()
          .put(BoolType.getDescriptor(), "boolean")
          .put(BytesType.getDescriptor(), "string")
          .put(Int64Type.getDescriptor(), "int64")
          .put(Int32Type.getDescriptor(), "int32")
          .put(DoubleType.getDescriptor(), "double")
          .put(StringType.getDescriptor(), "string")
          .put(RepeatedType.getDescriptor(), "array")
          .put(ObjectType.getDescriptor(), "object")
          .build();

  private static ImmutableMap<Descriptor, Message[]> AllTypesToCorrectProto =
      new ImmutableMap.Builder<Descriptor, Message[]>()
          .put(
              BoolType.getDescriptor(),
              new Message[] {BoolType.newBuilder().setTestFieldType(true).build()})
          .put(
              BytesType.getDescriptor(),
              new Message[] {
                BytesType.newBuilder()
                    .setTestFieldType(ByteString.copyFrom("test".getBytes()))
                    .build()
              })
          .put(
              Int64Type.getDescriptor(),
              new Message[] {
                Int64Type.newBuilder().setTestFieldType(Long.MAX_VALUE).build(),
                Int64Type.newBuilder().setTestFieldType(new Long(Integer.MAX_VALUE)).build()
              })
          .put(
              Int32Type.getDescriptor(),
              new Message[] {Int32Type.newBuilder().setTestFieldType(Integer.MAX_VALUE).build()})
          .put(
              DoubleType.getDescriptor(),
              new Message[] {DoubleType.newBuilder().setTestFieldType(1.23).build()})
          .put(
              StringType.getDescriptor(),
              new Message[] {StringType.newBuilder().setTestFieldType("test").build()})
          .put(
              RepeatedType.getDescriptor(),
              new Message[] {
                RepeatedType.newBuilder()
                    .addAllTestFieldType(
                        new ArrayList<Long>() {
                          {
                            add(1L);
                            add(2L);
                            add(3L);
                          }
                        })
                    .build()
              })
          .put(
              ObjectType.getDescriptor(),
              new Message[] {
                ObjectType.newBuilder()
                    .setTestFieldType(ComplexLvl2.newBuilder().setTestInt(1).build())
                    .build()
              })
          .build();

  private static ImmutableMap<Descriptor, String> AllRepeatedTypesToDebugMessageTest =
      new ImmutableMap.Builder<Descriptor, String>()
          .put(RepeatedBool.getDescriptor(), "boolean")
          .put(RepeatedBytes.getDescriptor(), "string")
          .put(RepeatedInt64.getDescriptor(), "int64")
          .put(RepeatedInt32.getDescriptor(), "int32")
          .put(RepeatedDouble.getDescriptor(), "double")
          .put(RepeatedString.getDescriptor(), "string")
          .put(RepeatedObject.getDescriptor(), "object")
          .build();

  private static ImmutableMap<Descriptor, Message[]> AllRepeatedTypesToCorrectProto =
      new ImmutableMap.Builder<Descriptor, Message[]>()
          .put(
              RepeatedBool.getDescriptor(),
              new Message[] {
                RepeatedBool.newBuilder().addTestRepeated(true).addTestRepeated(false).build()
              })
          .put(
              RepeatedBytes.getDescriptor(),
              new Message[] {
                RepeatedBytes.newBuilder()
                    .addTestRepeated(ByteString.copyFrom("hello".getBytes()))
                    .addTestRepeated(ByteString.copyFrom("test".getBytes()))
                    .build()
              })
          .put(
              RepeatedString.getDescriptor(),
              new Message[] {
                RepeatedString.newBuilder().addTestRepeated("hello").addTestRepeated("test").build()
              })
          .put(
              RepeatedInt64.getDescriptor(),
              new Message[] {
                RepeatedInt64.newBuilder()
                    .addTestRepeated(Long.MAX_VALUE)
                    .addTestRepeated(Long.MIN_VALUE)
                    .addTestRepeated(Integer.MAX_VALUE)
                    .addTestRepeated(Integer.MIN_VALUE)
                    .addTestRepeated(Short.MAX_VALUE)
                    .addTestRepeated(Short.MIN_VALUE)
                    .addTestRepeated(Byte.MAX_VALUE)
                    .addTestRepeated(Byte.MIN_VALUE)
                    .addTestRepeated(0)
                    .build(),
                RepeatedInt64.newBuilder()
                    .addTestRepeated(Integer.MAX_VALUE)
                    .addTestRepeated(Integer.MIN_VALUE)
                    .addTestRepeated(Short.MAX_VALUE)
                    .addTestRepeated(Short.MIN_VALUE)
                    .addTestRepeated(Byte.MAX_VALUE)
                    .addTestRepeated(Byte.MIN_VALUE)
                    .addTestRepeated(0)
                    .build()
              })
          .put(
              RepeatedInt32.getDescriptor(),
              new Message[] {
                RepeatedInt32.newBuilder()
                    .addTestRepeated(Integer.MAX_VALUE)
                    .addTestRepeated(Integer.MIN_VALUE)
                    .addTestRepeated(Short.MAX_VALUE)
                    .addTestRepeated(Short.MIN_VALUE)
                    .addTestRepeated(Byte.MAX_VALUE)
                    .addTestRepeated(Byte.MIN_VALUE)
                    .addTestRepeated(0)
                    .build()
              })
          .put(
              RepeatedDouble.getDescriptor(),
              new Message[] {
                RepeatedDouble.newBuilder()
                    .addTestRepeated(Double.MAX_VALUE)
                    .addTestRepeated(Double.MIN_VALUE)
                    .addTestRepeated(Float.MAX_VALUE)
                    .addTestRepeated(Float.MIN_VALUE)
                    .build(),
                RepeatedDouble.newBuilder()
                    .addTestRepeated(Float.MAX_VALUE)
                    .addTestRepeated(Float.MIN_VALUE)
                    .build()
              })
          .put(
              RepeatedObject.getDescriptor(),
              new Message[] {
                RepeatedObject.newBuilder()
                    .addTestRepeated(ComplexLvl2.newBuilder().setTestInt(1).build())
                    .addTestRepeated(ComplexLvl2.newBuilder().setTestInt(2).build())
                    .addTestRepeated(ComplexLvl2.newBuilder().setTestInt(3).build())
                    .build()
              })
          .build();

  private static JSONObject[] simpleJSONObjects = {
    new JSONObject().put("test_field_type", Long.MAX_VALUE),
    new JSONObject().put("test_field_type", Integer.MAX_VALUE),
    new JSONObject().put("test_field_type", 1.23),
    new JSONObject().put("test_field_type", true),
    new JSONObject().put("test_field_type", "test"),
    new JSONObject().put("test_field_type", new JSONArray("[1, 2, 3]")),
    new JSONObject().put("test_field_type", new JSONObject().put("test_int", 1))
  };

  private static JSONObject[] simpleJSONArrays = {
    new JSONObject()
        .put(
            "test_repeated",
            new JSONArray(
                new Long[] {
                  Long.MAX_VALUE,
                  Long.MIN_VALUE,
                  (long) Integer.MAX_VALUE,
                  (long) Integer.MIN_VALUE,
                  (long) Short.MAX_VALUE,
                  (long) Short.MIN_VALUE,
                  (long) Byte.MAX_VALUE,
                  (long) Byte.MIN_VALUE,
                  0L
                })),
    new JSONObject()
        .put(
            "test_repeated",
            new JSONArray(
                new Integer[] {
                  Integer.MAX_VALUE,
                  Integer.MIN_VALUE,
                  (int) Short.MAX_VALUE,
                  (int) Short.MIN_VALUE,
                  (int) Byte.MAX_VALUE,
                  (int) Byte.MIN_VALUE,
                  0
                })),
    new JSONObject()
        .put(
            "test_repeated",
            new JSONArray(
                new Double[] {
                  Double.MAX_VALUE,
                  Double.MIN_VALUE,
                  (double) Float.MAX_VALUE,
                  (double) Float.MIN_VALUE
                })),
    new JSONObject()
        .put("test_repeated", new JSONArray(new Float[] {Float.MAX_VALUE, Float.MIN_VALUE})),
    new JSONObject().put("test_repeated", new JSONArray(new Boolean[] {true, false})),
    new JSONObject().put("test_repeated", new JSONArray(new String[] {"hello", "test"})),
    new JSONObject()
        .put(
            "test_repeated",
            new JSONArray(
                new JSONObject[] {
                  new JSONObject().put("test_int", 1),
                  new JSONObject().put("test_int", 2),
                  new JSONObject().put("test_int", 3)
                }))
  };

  @Test
  public void testDifferentNameCasing() throws Exception {
    TestInt64 expectedProto =
        TestInt64.newBuilder().setByte(1).setShort(1).setInt(1).setLong(1).build();

    JSONObject json = new JSONObject();
    json.put("bYtE", (byte) 1);
    json.put("SHORT", (short) 1);
    json.put("inT", 1);
    json.put("lONg", 1L);
    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(TestInt64.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testInt64() throws Exception {
    TestInt64 expectedProto =
        TestInt64.newBuilder().setByte(1).setShort(1).setInt(1).setLong(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1);
    json.put("long", 1L);
    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(TestInt64.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testInt32() throws Exception {
    TestInt32 expectedProto = TestInt32.newBuilder().setByte(1).setShort(1).setInt(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1);
    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(TestInt32.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testInt32NotMatchInt64() throws Exception {
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1L);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(TestInt32.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "JSONObject does not have a int32 field at root.int.");
    }
  }

  @Test
  public void testDouble() throws Exception {
    TestDouble expectedProto = TestDouble.newBuilder().setDouble(1.2).setFloat(3.4f).build();
    JSONObject json = new JSONObject();
    json.put("double", 1.2);
    json.put("float", 3.4f);
    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(TestDouble.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testAllTypes() throws Exception {
    for (Map.Entry<Descriptor, String> entry : AllTypesToDebugMessageTest.entrySet()) {
      int success = 0;
      for (JSONObject json : simpleJSONObjects) {
        try {
          DynamicMessage protoMsg =
              JsonToProtoMessage.convertJsonToProtoMessage(entry.getKey(), json, false);
          assertEquals(protoMsg, AllTypesToCorrectProto.get(entry.getKey())[success]);
          success += 1;
        } catch (IllegalArgumentException e) {
          assertEquals(
              e.getMessage(),
              "JSONObject does not have a " + entry.getValue() + " field at root.test_field_type.");
        }
      }
      if (entry.getKey() == Int64Type.getDescriptor()) {
        assertEquals(2, success);
      } else {
        assertEquals(1, success);
      }
    }
  }

  @Test
  public void testAllRepeatedTypesWithLimits() throws Exception {
    for (Map.Entry<Descriptor, String> entry : AllRepeatedTypesToDebugMessageTest.entrySet()) {
      int success = 0;
      for (JSONObject json : simpleJSONArrays) {
        try {
          DynamicMessage protoMsg =
              JsonToProtoMessage.convertJsonToProtoMessage(entry.getKey(), json, false);
          assertEquals(protoMsg, AllRepeatedTypesToCorrectProto.get(entry.getKey())[success]);
          success += 1;
        } catch (IllegalArgumentException e) {
          assertEquals(
              e.getMessage(),
              "JSONObject does not have a "
                  + entry.getValue()
                  + " field at root.test_repeated[0].");
        }
      }
      if (entry.getKey() == RepeatedInt64.getDescriptor()
          || entry.getKey() == RepeatedDouble.getDescriptor()) {
        assertEquals(2, success);
      } else {
        assertEquals(1, success);
      }
    }
  }

  @Test
  public void testOptional() throws Exception {
    TestInt64 expectedProto = TestInt64.newBuilder().setByte(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", 1);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(TestInt64.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testRepeatedIsOptional() throws Exception {
    TestRepeatedIsOptional expectedProto =
        TestRepeatedIsOptional.newBuilder().setRequiredDouble(1.1).build();
    JSONObject json = new JSONObject();
    json.put("required_double", 1.1);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(
            TestRepeatedIsOptional.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testRequired() throws Exception {
    JSONObject json = new JSONObject();
    json.put("optional_double", 1.1);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(TestRequired.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(), "JSONObject does not have the required field root.required_double.");
    }
  }

  @Test
  public void testStructSimple() throws Exception {
    MessageType expectedProto =
        MessageType.newBuilder()
            .setTestFieldType(StringType.newBuilder().setTestFieldType("test").build())
            .build();
    JSONObject stringType = new JSONObject();
    stringType.put("test_field_type", "test");
    JSONObject json = new JSONObject();
    json.put("test_field_type", stringType);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(MessageType.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testStructSimpleFail() throws Exception {
    JSONObject stringType = new JSONObject();
    stringType.put("test_field_type", 1);
    JSONObject json = new JSONObject();
    json.put("test_field_type", stringType);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(MessageType.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(),
          "JSONObject does not have a string field at root.test_field_type.test_field_type.");
    }
  }

  @Test
  public void testStructComplex() throws Exception {
    ComplexRoot expectedProto =
        ComplexRoot.newBuilder()
            .setTestInt(1)
            .addTestString("a")
            .addTestString("b")
            .addTestString("c")
            .setTestBytes(ByteString.copyFrom("hello".getBytes()))
            .setTestBool(true)
            .addTestDouble(1.1)
            .addTestDouble(2.2)
            .addTestDouble(3.3)
            .addTestDouble(4.4)
            .setTestDate(1)
            .setComplexLvl1(
                ComplexLvl1.newBuilder()
                    .setTestInt(2)
                    .setComplexLvl2(ComplexLvl2.newBuilder().setTestInt(3).build())
                    .build())
            .setComplexLvl2(ComplexLvl2.newBuilder().setTestInt(3).build())
            .build();
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("test_int", 3);

    JSONObject complex_lvl1 = new JSONObject();
    complex_lvl1.put("test_int", 2);
    complex_lvl1.put("complex_lvl2", complex_lvl2);

    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("test_string", new JSONArray(new String[] {"a", "b", "c"}));
    json.put("test_bytes", "hello");
    json.put("test_bool", true);
    json.put("test_DOUBLe", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(ComplexRoot.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testStructComplexFail() throws Exception {
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("test_int", 3);

    JSONObject complex_lvl1 = new JSONObject();
    complex_lvl1.put("test_int", "not_int");
    complex_lvl1.put("complex_lvl2", complex_lvl2);

    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("test_string", new JSONArray(new String[] {"a", "b", "c"}));
    json.put("test_bytes", "hello");
    json.put("test_bool", true);
    json.put("test_double", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(ComplexRoot.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(), "JSONObject does not have a int64 field at root.complex_lvl1.test_int.");
    }
  }

  @Test
  public void testRepeatedWithMixedTypes() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray("[1.1, 2.2, true]"));
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(RepeatedDouble.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(), "JSONObject does not have a double field at root.test_repeated[2].");
    }
  }

  @Test
  public void testNestedRepeatedComplex() throws Exception {
    NestedRepeated expectedProto =
        NestedRepeated.newBuilder()
            .addDouble(1.1)
            .addDouble(2.2)
            .addDouble(3.3)
            .addDouble(4.4)
            .addDouble(5.5)
            .addInt(1)
            .addInt(2)
            .addInt(3)
            .addInt(4)
            .addInt(5)
            .setRepeatedString(
                RepeatedString.newBuilder()
                    .addTestRepeated("hello")
                    .addTestRepeated("this")
                    .addTestRepeated("is")
                    .addTestRepeated("a")
                    .addTestRepeated("test")
                    .build())
            .build();
    double[] doubleArr = {1.1, 2.2, 3.3, 4.4, 5.5};
    String[] stringArr = {"hello", "this", "is", "a", "test"};
    int[] intArr = {1, 2, 3, 4, 5};

    JSONObject json = new JSONObject();
    json.put("double", new JSONArray(doubleArr));
    json.put("int", new JSONArray(intArr));
    JSONObject jsonRepeatedString = new JSONObject();
    jsonRepeatedString.put("test_repeated", new JSONArray(stringArr));
    json.put("repeated_string", jsonRepeatedString);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(NestedRepeated.getDescriptor(), json, false);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testNestedRepeatedComplexFail() throws Exception {
    double[] doubleArr = {1.1, 2.2, 3.3, 4.4, 5.5};
    Boolean[] fakeStringArr = {true, false};
    int[] intArr = {1, 2, 3, 4, 5};

    JSONObject json = new JSONObject();
    json.put("double", new JSONArray(doubleArr));
    json.put("int", new JSONArray(intArr));
    JSONObject jsonRepeatedString = new JSONObject();
    jsonRepeatedString.put("test_repeated", new JSONArray(fakeStringArr));
    json.put("repeated_string", jsonRepeatedString);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(NestedRepeated.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(),
          "JSONObject does not have a string field at root.repeated_string.test_repeated[0].");
    }
  }

  @Test
  public void testAllowUnknownFields() throws Exception {
    RepeatedInt64 expectedProto =
        RepeatedInt64.newBuilder()
            .addTestRepeated(1)
            .addTestRepeated(2)
            .addTestRepeated(3)
            .addTestRepeated(4)
            .addTestRepeated(5)
            .build();
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new int[] {1, 2, 3, 4, 5}));
    json.put("string", "hello");

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(RepeatedInt64.getDescriptor(), json, true);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testEmptySecondLevelObject() throws Exception {
    ComplexLvl1 expectedProto =
        ComplexLvl1.newBuilder()
            .setTestInt(1)
            .setComplexLvl2(ComplexLvl2.newBuilder().build())
            .build();
    JSONObject complexLvl2 = new JSONObject();
    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("complex_lvl2", complexLvl2);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(ComplexLvl1.getDescriptor(), json, true);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testAllowUnknownFieldsError() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new int[] {1, 2, 3, 4, 5}));
    json.put("string", "hello");

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(RepeatedInt64.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(),
          "JSONObject has fields unknown to BigQuery: root.string. Set allowUnknownFields to True to allow unknown fields.");
    }
  }

  @Test
  public void testEmptyProtoMessage() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new int[0]));
    json.put("string", "hello");

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(RepeatedInt64.getDescriptor(), json, true);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The created protobuf message is empty.");
    }
  }

  @Test
  public void testEmptyJSONObject() throws Exception {
    JSONObject json = new JSONObject();
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(Int64Type.getDescriptor(), json, false);
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "JSONObject is empty.");
    }
  }

  @Test
  public void testNullJson() throws Exception {
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(Int64Type.getDescriptor(), null, false);
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), "JSONObject is null.");
    }
  }

  @Test
  public void testNullDescriptor() throws Exception {
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(null, new JSONObject(), false);
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), "Protobuf descriptor is null.");
    }
  }

  @Test
  public void testAllowUnknownFieldsSecondLevel() throws Exception {
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("no_match", 1);
    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("complex_lvl2", complex_lvl2);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(ComplexLvl1.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(),
          "JSONObject has fields unknown to BigQuery: root.complex_lvl2.no_match. Set allowUnknownFields to True to allow unknown fields.");
    }
  }

  @Test
  public void testTopLevelMismatch() throws Exception {
    JSONObject json = new JSONObject();
    json.put("no_match", 1.1);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(
              TopLevelMismatch.getDescriptor(), json, true);
    } catch (IllegalArgumentException e) {
      assertEquals(
          e.getMessage(),
          "There are no matching fields found for the JSONObject and the protocol buffer descriptor.");
    }
  }

  @Test
  public void testTopLevelMatchSecondLevelMismatch() throws Exception {
    ComplexLvl1 expectedProto =
        ComplexLvl1.newBuilder()
            .setTestInt(1)
            .setComplexLvl2(ComplexLvl2.newBuilder().build())
            .build();
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("no_match", 1);
    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("complex_lvl2", complex_lvl2);

    DynamicMessage protoMsg =
        JsonToProtoMessage.convertJsonToProtoMessage(ComplexLvl1.getDescriptor(), json, true);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testJsonNullValue() throws Exception {
    JSONObject json = new JSONObject();
    json.put("long", JSONObject.NULL);
    json.put("int", 1);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.convertJsonToProtoMessage(TestInt64.getDescriptor(), json, false);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "JSONObject does not have a int64 field at root.long.");
    }
  }
}
