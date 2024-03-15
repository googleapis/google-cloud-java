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
package com.google.cloud.bigquery.storage.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.storage.test.JsonTest.*;
import com.google.cloud.bigquery.storage.test.SchemaTest.*;
import com.google.cloud.bigquery.storage.v1.Exceptions.RowIndexToErrorException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.LocalTime;

@RunWith(JUnit4.class)
public class JsonToProtoMessageTest {
  private static final Logger LOG = Logger.getLogger(JsonToProtoMessageTest.class.getName());
  private static ImmutableMap<Descriptor, String> AllTypesToDebugMessageTest =
      new ImmutableMap.Builder<Descriptor, String>()
          .put(BoolType.getDescriptor(), "boolean")
          .put(BytesType.getDescriptor(), "bytes")
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
                BytesType.newBuilder().setTestFieldType(ByteString.copyFromUtf8("test")).build(),
                BytesType.newBuilder()
                    .setTestFieldType(ByteString.copyFrom(new byte[] {1, 2, 3}))
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
              new Message[] {
                DoubleType.newBuilder().setTestFieldType(Long.MAX_VALUE).build(),
                DoubleType.newBuilder().setTestFieldType(Integer.MAX_VALUE).build(),
                DoubleType.newBuilder().setTestFieldType(1.23).build()
              })
          .put(
              StringType.getDescriptor(),
              new Message[] {
                StringType.newBuilder().setTestFieldType("9223372036854775807").build(),
                StringType.newBuilder().setTestFieldType("2147483647").build(),
                StringType.newBuilder().setTestFieldType("true").build(),
                StringType.newBuilder().setTestFieldType("test").build()
              })
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
          .put(RepeatedBytes.getDescriptor(), "bytes")
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
                    .addTestRepeated(ByteString.copyFrom(new byte[] {0}))
                    .addTestRepeated(ByteString.copyFrom(new byte[] {0, -116, -122, 71}))
                    .build(),
                RepeatedBytes.newBuilder()
                    .addTestRepeated(
                        BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0")))
                    .addTestRepeated(
                        BigDecimalByteStringEncoder.encodeToNumericByteString(
                            new BigDecimal("1.2")))
                    .build()
              })
          .put(
              RepeatedString.getDescriptor(),
              new Message[] {
                RepeatedString.newBuilder().addTestRepeated("9223372036854775807").build(),
                RepeatedString.newBuilder().addTestRepeated("2147483647").build(),
                RepeatedString.newBuilder().addTestRepeated("true").build(),
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
                RepeatedDouble.newBuilder()
                    .addTestRepeated(Integer.MAX_VALUE)
                    .addTestRepeated(Integer.MIN_VALUE)
                    .addTestRepeated(Short.MAX_VALUE)
                    .addTestRepeated(Short.MIN_VALUE)
                    .addTestRepeated(Byte.MAX_VALUE)
                    .addTestRepeated(Byte.MIN_VALUE)
                    .addTestRepeated(0)
                    .build(),
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
    new JSONObject().put("test_field_type", ByteString.copyFromUtf8("test")),
    new JSONObject().put("test_field_type", new JSONArray("[1, 2, 3]")),
    new JSONObject().put("test_field_type", new JSONObject().put("test_int", 1)),
    new JSONObject().put("test_field_type", "test")
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
                new byte[][] {
                  BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0"))
                      .toByteArray(),
                  BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("1.2"))
                      .toByteArray()
                })),
    new JSONObject().put("test_repeated", new JSONArray(new int[][] {{11111, 22222}})),
    new JSONObject().put("test_repeated", new JSONArray(new char[][] {{'a', 'b'}, {'c'}})),
    new JSONObject().put("test_repeated", new JSONArray(new String[][] {{"hello"}, {"test"}})),
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
  private final TableFieldSchema TEST_INT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.INT64)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_int")
          .build();
  private final TableFieldSchema TEST_STRING =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_string")
          .build();
  private final TableFieldSchema TEST_BYTES =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BYTES)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .setName("test_bytes")
          .build();
  private final TableFieldSchema TEST_BOOL =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BOOL)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bool")
          .build();
  private final TableFieldSchema TEST_DOUBLE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DOUBLE)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_double")
          .build();
  private final TableFieldSchema TEST_DATE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DATE)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .setName("test_date")
          .build();
  private final TableFieldSchema TEST_DATETIME =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DATETIME)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_datetime")
          .build();
  private final TableFieldSchema TEST_DATETIME_STR =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DATETIME)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_datetime_str")
          .build();
  private final TableFieldSchema COMPLEXLVL2 =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRUCT)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .addFields(0, TEST_INT)
          .setName("complex_lvl2")
          .build();
  private final TableFieldSchema COMPLEXLVL1 =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRUCT)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .addFields(0, TEST_INT)
          .addFields(1, COMPLEXLVL2)
          .setName("complex_lvl1")
          .build();
  private final TableFieldSchema TEST_NUMERIC =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric")
          .build();
  private final TableFieldSchema TEST_NUMERIC_REPEATED =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_numeric_repeated")
          .build();
  private final TableFieldSchema TEST_GEO =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.GEOGRAPHY)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_geo")
          .build();
  private final TableFieldSchema TEST_TIMESTAMP =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIMESTAMP)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_timestamp")
          .build();
  private final TableFieldSchema TEST_TIMESTAMP_REPEATED =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIMESTAMP)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_timestamp_repeated")
          .build();
  private final TableFieldSchema TEST_TIME =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIME)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_time")
          .build();
  private final TableFieldSchema TEST_TIME_STR =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIME)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_time_str")
          .build();
  private final TableFieldSchema TEST_NUMERIC_STR =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_str")
          .build();
  private final TableFieldSchema TEST_NUMERIC_SHORT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_short")
          .build();
  private final TableFieldSchema TEST_NUMERIC_INT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_int")
          .build();
  private final TableFieldSchema TEST_NUMERIC_LONG =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_long")
          .build();
  private final TableFieldSchema TEST_NUMERIC_FLOAT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_float")
          .build();
  private final TableFieldSchema TEST_NUMERIC_DOUBLE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric_double")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_STR =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_bignumeric_str")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_SHORT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric_short")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_INT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric_int")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_LONG =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric_long")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_FLOAT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric_float")
          .build();
  private final TableFieldSchema TEST_BIGNUMERIC_DOUBLE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BIGNUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bignumeric_double")
          .build();
  final TableFieldSchema TEST_INTERVAL =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.INTERVAL)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_interval")
          .build();
  final TableFieldSchema TEST_JSON =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.JSON)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_json")
          .build();
  private final TableSchema COMPLEX_TABLE_SCHEMA =
      TableSchema.newBuilder()
          .addFields(0, TEST_INT)
          .addFields(1, TEST_STRING)
          .addFields(2, TEST_BYTES)
          .addFields(3, TEST_BOOL)
          .addFields(4, TEST_DOUBLE)
          .addFields(5, TEST_DATE)
          .addFields(6, TEST_DATETIME)
          .addFields(7, TEST_DATETIME_STR)
          .addFields(8, COMPLEXLVL1)
          .addFields(9, COMPLEXLVL2)
          .addFields(10, TEST_NUMERIC)
          .addFields(11, TEST_GEO)
          .addFields(12, TEST_TIMESTAMP)
          .addFields(13, TEST_TIME)
          .addFields(14, TEST_TIME_STR)
          .addFields(15, TEST_NUMERIC_REPEATED)
          .addFields(16, TEST_NUMERIC_STR)
          .addFields(17, TEST_NUMERIC_SHORT)
          .addFields(18, TEST_NUMERIC_INT)
          .addFields(19, TEST_NUMERIC_LONG)
          .addFields(20, TEST_NUMERIC_FLOAT)
          .addFields(21, TEST_NUMERIC_DOUBLE)
          .addFields(22, TEST_BIGNUMERIC)
          .addFields(23, TEST_BIGNUMERIC_STR)
          .addFields(24, TEST_BIGNUMERIC_SHORT)
          .addFields(25, TEST_BIGNUMERIC_INT)
          .addFields(26, TEST_BIGNUMERIC_LONG)
          .addFields(27, TEST_BIGNUMERIC_FLOAT)
          .addFields(28, TEST_BIGNUMERIC_DOUBLE)
          .addFields(29, TEST_INTERVAL)
          .addFields(30, TEST_JSON)
          .build();

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
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt64.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testBool() throws Exception {
    TestBool expectedProto =
        TestBool.newBuilder().setBool(true).setUppercase(true).setLowercase(false).build();
    JSONObject json = new JSONObject();
    json.put("bool", true);
    json.put("uppercase", "TRUE");
    json.put("lowercase", "false");
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestBool.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testInt64() throws Exception {
    TestInt64 expectedProto =
        TestInt64.newBuilder().setByte(1).setShort(1).setInt(1).setLong(1).setString(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1);
    json.put("long", 1L);
    json.put("string", "1");
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt64.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testInt32() throws Exception {
    TestInt32 expectedProto =
        TestInt32.newBuilder().setByte(1).setShort(1).setInt(1).setString(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1);
    json.put("string", 1);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt32.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testInt32NotMatchInt64() throws Exception {
    JSONObject json = new JSONObject();
    json.put("byte", (byte) 1);
    json.put("short", (short) 1);
    json.put("int", 1L);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt32.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("JSONObject does not have a int32 field at root.int."));
    }
  }

  @Test
  public void testDateTimeMismatch() throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setName("datetime")
            .setType(TableFieldSchema.Type.DATETIME)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(field).build();
    JSONObject json = new JSONObject();
    json.put("datetime", 1.0);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(
              TestDatetime.getDescriptor(), tableSchema, json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage().contains("JSONObject does not have a int64 field at root.datetime."));
    }
  }

  private void dateTimeMatch_Internal(String jsonVal, Long expectedVal) throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setName("datetime")
            .setType(TableFieldSchema.Type.DATETIME)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(field).build();
    TestDatetime expectedProto = TestDatetime.newBuilder().setDatetime(expectedVal).build();
    JSONObject json = new JSONObject();
    json.put("datetime", jsonVal);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestDatetime.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDateTimeMatch() throws Exception {
    dateTimeMatch_Internal("2021-09-27T20:51:10.752", 142258614586538368L);
    dateTimeMatch_Internal("2021-09-27t20:51:10.752", 142258614586538368L);
    dateTimeMatch_Internal("2021-09-27 20:51:10.752", 142258614586538368L);
    dateTimeMatch_Internal("2021-9-27T20:51:10.752", 142258614586538368L);
    dateTimeMatch_Internal("2021-09-27T00:00:00", 142258525253402624L);
    dateTimeMatch_Internal("2021-09-27T00:0:00", 142258525253402624L);
    dateTimeMatch_Internal("2021-09-27", 142258525253402624L);
  }

  @Test
  public void testTimeMismatch() throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setName("time")
            .setType(TableFieldSchema.Type.TIME)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(field).build();
    JSONObject json = new JSONObject();
    json.put("time", new JSONArray(new Double[] {1.0}));
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(
              TestTime.getDescriptor(), tableSchema, json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage().contains("JSONObject does not have a int64 field at root.time[0]."));
    }
  }

  @Test
  public void testMixedCaseFieldNames() throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setName("fooBar")
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(field).build();

    JSONObject json = new JSONObject();
    json.put("fooBar", "hello");

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestMixedCaseFieldNames.getDescriptor(), tableSchema, json);
  }

  @Test
  public void testDouble() throws Exception {
    TestDouble expectedProto =
        TestDouble.newBuilder()
            .setDouble(1.2)
            .setFloat(3.4f)
            .setByte(5)
            .setShort(6)
            .setInt(7)
            .setLong(8)
            .setString(9.1)
            .build();
    JSONObject json = new JSONObject();
    json.put("double", 1.2);
    json.put("float", 3.4f);
    json.put("byte", new Byte((byte) 5));
    json.put("short", new Short((short) 6));
    json.put("int", 7);
    json.put("long", 8L);
    json.put("string", "9.1");
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestDouble.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDoubleHighPrecision() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("numeric")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .build())
            .build();
    TestNumeric expectedProto =
        TestNumeric.newBuilder()
            .setNumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("3.400500513")))
            .build();
    JSONObject json = new JSONObject();
    json.put("numeric", 3.400500512978076);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestNumeric.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDoubleHighPrecision_RepeatedField() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("bignumeric")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .build();
    TestBignumeric expectedProto =
        TestBignumeric.newBuilder()
            .addBignumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("3.400500513")))
            .addBignumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0.1")))
            .addBignumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0.12")))
            .build();
    JSONObject json = new JSONObject();
    json.put("bignumeric", ImmutableList.of(3.400500512978076, 0.10000000000055, 0.12));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestBignumeric.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testTimestamp() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_string").build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_string_T_Z").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_long").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_int").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_float").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_offset").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_timezone").build())
            .addFields(TableFieldSchema.newBuilder(TEST_TIMESTAMP).setName("test_saformat").build())
            .build();
    TestTimestamp expectedProto =
        TestTimestamp.newBuilder()
            .setTestString(10L)
            .setTestStringTZ(1648493279010000L)
            .setTestLong(1687984085000000L)
            .setTestInt(153480695L)
            .setTestFloat(153468069500L)
            .setTestOffset(1649135171000000L)
            .setTestTimezone(1649174771000000L)
            .setTestSaformat(1534680660000000L)
            .build();
    JSONObject json = new JSONObject();
    json.put("test_string", "1970-01-01 00:00:00.000010");
    json.put("test_string_T_Z", "2022-03-28T18:47:59.01Z");
    json.put("test_long", 1687984085000000L);
    json.put("test_int", 153480695);
    json.put("test_float", "1.534680695e11");
    json.put("test_offset", "2022-04-05T09:06:11+04:00");
    json.put("test_timezone", "2022-04-05 09:06:11 PST");
    json.put("test_saformat", "2018/08/19 12:11");
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestTimestamp.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testTimestampRepeated() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_string_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_string_T_Z_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_long_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_int_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_float_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_offset_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_timezone_repeated")
                    .build())
            .addFields(
                TableFieldSchema.newBuilder(TEST_TIMESTAMP_REPEATED)
                    .setName("test_saformat_repeated")
                    .build())
            .build();
    TestRepeatedTimestamp expectedProto =
        TestRepeatedTimestamp.newBuilder()
            .addTestStringRepeated(10L)
            .addTestStringTZRepeated(1648493279010000L)
            .addTestLongRepeated(1687984085000000L)
            .addTestIntRepeated(153480695L)
            .addTestFloatRepeated(153468069500L)
            .addTestOffsetRepeated(1649135171000000L)
            .addTestTimezoneRepeated(1649174771000000L)
            .addTestSaformatRepeated(1534680660000000L)
            .build();
    JSONObject json = new JSONObject();
    json.put("test_string_repeated", new JSONArray(new String[] {"1970-01-01 00:00:00.000010"}));
    json.put("test_string_T_Z_repeated", new JSONArray(new String[] {"2022-03-28T18:47:59.01Z"}));
    json.put("test_long_repeated", new JSONArray(new Long[] {1687984085000000L}));
    json.put("test_int_repeated", new JSONArray(new Integer[] {153480695}));
    json.put("test_float_repeated", new JSONArray(new String[] {"1.534680695e11"}));
    json.put("test_offset_repeated", new JSONArray(new String[] {"2022-04-05T09:06:11+04:00"}));
    json.put("test_timezone_repeated", new JSONArray(new String[] {"2022-04-05 09:06:11 PST"}));
    json.put("test_saformat_repeated", new JSONArray(new String[] {"2018/08/19 12:11"}));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestRepeatedTimestamp.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDate() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(TableFieldSchema.newBuilder(TEST_DATE).setName("test_string").build())
            .addFields(TableFieldSchema.newBuilder(TEST_DATE).setName("test_long").build())
            .build();
    TestDate expectedProto = TestDate.newBuilder().setTestString(18935).setTestLong(18935).build();
    JSONObject json = new JSONObject();
    json.put("test_string", "2021-11-04");
    json.put("test_long", 18935L);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestDate.getDescriptor(), tableSchema, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testAllTypes() throws Exception {
    for (Map.Entry<Descriptor, String> entry : AllTypesToDebugMessageTest.entrySet()) {
      int success = 0;
      for (JSONObject json : simpleJSONObjects) {
        try {
          LOG.info("Testing " + json + " over " + entry.getKey().getFullName());
          DynamicMessage protoMsg =
              JsonToProtoMessage.INSTANCE.convertToProtoMessage(entry.getKey(), json);
          LOG.info("Convert Success!");
          assertEquals(protoMsg, AllTypesToCorrectProto.get(entry.getKey())[success]);
          success += 1;
        } catch (IllegalArgumentException e) {
          assertTrue(
              e.getMessage()
                  .contains(
                      "JSONObject does not have a "
                          + entry.getValue()
                          + " field at root.test_field_type."));
        }
      }
      if (entry.getKey() == DoubleType.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 3, success);
      } else if (entry.getKey() == Int64Type.getDescriptor()
          || entry.getKey() == BytesType.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 2, success);
      } else if (entry.getKey() == StringType.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 4, success);
      } else {
        assertEquals(entry.getKey().getFullName(), 1, success);
      }
    }
  }

  @Test
  public void testAllRepeatedTypesWithLimits() throws Exception {
    for (Map.Entry<Descriptor, String> entry : AllRepeatedTypesToDebugMessageTest.entrySet()) {
      int success = 0;
      for (JSONObject json : simpleJSONArrays) {
        try {
          LOG.info("Testing " + json + " over " + entry.getKey().getFullName());
          DynamicMessage protoMsg =
              JsonToProtoMessage.INSTANCE.convertToProtoMessage(entry.getKey(), json);
          LOG.info("Convert Success!");
          assertEquals(
              protoMsg.toString(),
              protoMsg,
              AllRepeatedTypesToCorrectProto.get(entry.getKey())[success]);
          success += 1;
        } catch (IllegalArgumentException e) {
          LOG.info(e.getMessage());
          assertTrue(
              e.getMessage()
                      .contains(
                          "JSONObject does not have a "
                              + entry.getValue()
                              + " field at root.test_repeated[0].")
                  || e.getMessage()
                      .contains("Error: root.test_repeated[0] could not be converted to byte[]."));
        }
      }
      if (entry.getKey() == RepeatedDouble.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 4, success);
      } else if (entry.getKey() == RepeatedInt64.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 2, success);
      } else if (entry.getKey() == RepeatedString.getDescriptor()) {
        assertEquals(entry.getKey().getFullName(), 4, success);
      } else {
        assertEquals(entry.getKey().getFullName(), 1, success);
      }
    }
  }

  @Test
  public void testOptional() throws Exception {
    TestInt64 expectedProto = TestInt64.newBuilder().setByte(1).build();
    JSONObject json = new JSONObject();
    json.put("byte", 1);

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt64.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testRepeatedIsOptional() throws Exception {
    TestRepeatedIsOptional expectedProto =
        TestRepeatedIsOptional.newBuilder().setRequiredDouble(1.1).build();
    JSONObject json = new JSONObject();
    json.put("required_double", 1.1);

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestRepeatedIsOptional.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testRequired() throws Exception {
    JSONObject json = new JSONObject();
    json.put("optional_double", 1.1);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestRequired.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains("JSONObject does not have the required field root.required_double."));
    }
  }

  @Test
  public void testStructSimple() throws Exception {
    structSimple("test", "test");
    structSimple(true, "true");
    structSimple(1, "1");
    structSimple((short) 1, "1");
    structSimple((long) 1, "1");
  }

  private void structSimple(Object value, String expected) throws Exception {
    MessageType expectedProto =
        MessageType.newBuilder()
            .setTestFieldType(StringType.newBuilder().setTestFieldType(expected).build())
            .build();
    JSONObject stringType = new JSONObject(ImmutableMap.of("test_field_type", value));
    JSONObject json = new JSONObject(ImmutableMap.of("test_field_type", stringType));

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(MessageType.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testStructSimpleFail() throws Exception {
    JSONObject stringType = new JSONObject();
    stringType.put("test_field_type", new boolean[0]);
    JSONObject json = new JSONObject();
    json.put("test_field_type", stringType);
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(MessageType.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains(
                  "JSONObject does not have a string field at root.test_field_type.test_field_type."));
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
            .setTestDatetime(1)
            .addTestDatetimeStr(142258614586538368L)
            .addTestDatetimeStr(142258614586538368L)
            .addTestDatetimeStr(142258614586538368L)
            .addTestDatetimeStr(142258525253402624L)
            .addTestDatetimeStr(142258525253402624L)
            .setComplexLvl1(
                ComplexLvl1.newBuilder()
                    .setTestInt(2)
                    .setComplexLvl2(ComplexLvl2.newBuilder().setTestInt(3).build())
                    .build())
            .setComplexLvl2(ComplexLvl2.newBuilder().setTestInt(3).build())
            .setTestNumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("1.23456")))
            .setTestGeo("POINT(1,1)")
            .setTestTimestamp(12345678L)
            .setTestTime(CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 0, 1)))
            .setTestTimeStr(89332507144L)
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0")))
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("99999999999999999999999999999.999999999")))
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("-99999999999999999999999999999.999999999")))
            .setTestNumericStr(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("12.4")))
            .setTestNumericShort(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal(1)))
            .setTestNumericInt(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal(2)))
            .setTestNumericLong(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal(3L)))
            .setTestNumericFloat(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal(4f)))
            .setTestNumericDouble(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal(5D)))
            .setTestBignumeric(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                    new BigDecimal("578960446186580977117854925043439539266.3222222222")))
            .addTestBignumericStr(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal("1.23")))
            .setTestBignumericShort(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal(1)))
            .setTestBignumericInt(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal(2)))
            .setTestBignumericLong(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal(3L)))
            .setTestBignumericFloat(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal(4f)))
            .setTestBignumericDouble(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal(5D)))
            .setTestInterval("0-0 0 0:0:0.000005")
            .addTestJson("{'a':'b'}")
            .build();
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("test_int", 3);

    JSONObject complex_lvl1 = new JSONObject();
    complex_lvl1.put("test_int", 2);
    complex_lvl1.put("complex_lvl2", complex_lvl2);

    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("test_string", new JSONArray(new String[] {"a", "b", "c"}));
    json.put("test_bytes", ByteString.copyFromUtf8("hello"));
    json.put("test_bool", true);
    json.put("test_DOUBLe", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("test_datetime", 1);
    json.put(
        "test_datetime_str",
        new JSONArray(
            new String[] {
              "2021-09-27T20:51:10.752",
              "2021-09-27t20:51:10.752",
              "2021-09-27 20:51:10.752",
              "2021-09-27T00:00:00",
              "2021-09-27"
            }));
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);
    json.put(
        "test_numeric",
        BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("1.23456")));
    json.put(
        "test_numeric_repeated",
        new JSONArray(
            new byte[][] {
              BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0"))
                  .toByteArray(),
              BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal("99999999999999999999999999999.999999999"))
                  .toByteArray(),
              BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal("-99999999999999999999999999999.999999999"))
                  .toByteArray(),
            }));
    json.put("test_geo", "POINT(1,1)");
    json.put("test_timestamp", 12345678);
    json.put("test_time", CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 0, 1)));
    json.put("test_time_str", "20:51:10.1234");
    json.put("test_numeric_str", "12.4");
    json.put("test_numeric_short", 1);
    json.put("test_numeric_int", 2);
    json.put("test_numeric_long", 3L);
    json.put("test_numeric_float", 4f);
    json.put("test_numeric_double", 5D);
    json.put(
        "test_bignumeric", new BigDecimal("578960446186580977117854925043439539266.3222222222"));
    json.put("test_bignumeric_str", new JSONArray(new String[] {"1.23"}));
    json.put("test_bignumeric_short", 1);
    json.put("test_bignumeric_int", 2);
    json.put("test_bignumeric_long", 3L);
    json.put("test_bignumeric_float", 4f);
    json.put("test_bignumeric_double", 5D);
    json.put("test_interval", "0-0 0 0:0:0.000005");
    json.put("test_json", new JSONArray(new String[] {"{'a':'b'}"}));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            ComplexRoot.getDescriptor(), COMPLEX_TABLE_SCHEMA, json);
    assertEquals(expectedProto, protoMsg);
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
    json.put("test_bytes", ByteString.copyFromUtf8("hello"));
    json.put("test_bool", true);
    json.put("test_double", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(ComplexRoot.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains("JSONObject does not have a int64 field at root.complex_lvl1.test_int."));
    }
  }

  @Test
  public void testRepeatedWithMixedTypes() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray("[1.1, 2.2, true]"));
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(RepeatedDouble.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains("JSONObject does not have a double field at root.test_repeated[2]."));
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
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(NestedRepeated.getDescriptor(), json);
    assertEquals(protoMsg, expectedProto);
  }

  @Test
  public void testNestedRepeatedComplexFail() throws Exception {
    double[] doubleArr = {1.1, 2.2, 3.3, 4.4, 5.5};
    Boolean[][] fakeStringArr = {new Boolean[0], new Boolean[0]};
    int[] intArr = {1, 2, 3, 4, 5};

    JSONObject json = new JSONObject();
    json.put("double", new JSONArray(doubleArr));
    json.put("int", new JSONArray(intArr));
    JSONObject jsonRepeatedString = new JSONObject();
    jsonRepeatedString.put("test_repeated", new JSONArray(fakeStringArr));
    json.put("repeated_string", jsonRepeatedString);

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(NestedRepeated.getDescriptor(), json);
      Assert.fail("should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains(
                  "JSONObject does not have a string field at root.repeated_string.test_repeated[0]."));
    }
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
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(ComplexLvl1.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testAllowUnknownFieldsError() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new int[] {1, 2, 3, 4, 5}));
    json.put("string", "hello");

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(RepeatedInt64.getDescriptor(), json);
      Assert.fail("Should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains("The source object has fields unknown to BigQuery: " + "root.string."));
    }
  }

  @Test
  public void testEmptyProtoMessage() throws Exception {
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new int[0]));

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(RepeatedInt64.getDescriptor(), json);
    assertEquals(protoMsg.getAllFields().size(), 0);
  }

  @Test
  public void testEmptyJSONObject() throws Exception {
    JSONObject json = new JSONObject();
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(Int64Type.getDescriptor(), json);
      Assert.fail("Should fail");
    } catch (IllegalStateException e) {
      assertEquals("JSONObject is empty.", e.getMessage());
    }
  }

  @Test
  public void testNullJson() throws Exception {
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(Int64Type.getDescriptor(), null);
      Assert.fail("Should fail");
    } catch (NullPointerException e) {
      assertEquals("JSONObject is null.", e.getMessage());
    }
  }

  @Test
  public void testNullDescriptor() throws Exception {
    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(null, new JSONObject());
      Assert.fail("Should fail");
    } catch (NullPointerException e) {
      assertEquals("Protobuf descriptor is null.", e.getMessage());
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
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(ComplexLvl1.getDescriptor(), json);
      Assert.fail("Should fail");
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .contains(
                  "The source object has fields unknown to BigQuery: root.complex_lvl2.no_match."));
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
    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("complex_lvl2", complex_lvl2);

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(ComplexLvl1.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testJsonNullValue() throws Exception {
    TestInt64 expectedProto = TestInt64.newBuilder().setInt(1).build();
    JSONObject json = new JSONObject();
    json.put("long", JSONObject.NULL);
    json.put("int", 1);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt64.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testJsonAllFieldsNullValue() throws Exception {
    TestInt64 expectedProto = TestInt64.newBuilder().build();
    JSONObject json = new JSONObject();
    json.put("long", JSONObject.NULL);
    json.put("int", JSONObject.NULL);
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestInt64.getDescriptor(), json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testBadJsonFieldRepeated() throws Exception {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("test_repeated")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .build();
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new String[] {"123", "blah"}));

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(
              RepeatedBytes.getDescriptor(), ts, json);
      Assert.fail("Should fail");
    } catch (RowIndexToErrorException ex) {
      assertTrue(ex.rowIndexToErrorMessage.size() == 1);
      assertTrue(ex.getMessage().contains("root.test_repeated failed to convert to NUMERIC."));
    }
  }

  @Test
  public void testBadJsonFieldIntRepeated() throws Exception {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("test_repeated")
                    .setType(TableFieldSchema.Type.DATE)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .build();
    JSONObject json = new JSONObject();
    json.put("test_repeated", new JSONArray(new String[] {"blah"}));

    try {
      DynamicMessage protoMsg =
          JsonToProtoMessage.INSTANCE.convertToProtoMessage(
              RepeatedInt32.getDescriptor(), ts, json);
      Assert.fail("Should fail");
    } catch (IllegalArgumentException ex) {
      assertTrue(ex.getMessage().contains("Text 'blah' could not be parsed at index 0"));
    }
  }

  @Test
  public void testNullRepeatedField() throws Exception {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("test_repeated")
                    .setType(TableFieldSchema.Type.DATE)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .addFields(
                1,
                TableFieldSchema.newBuilder()
                    .setName("test_non_repeated")
                    .setType(TableFieldSchema.Type.DATE)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .build();
    JSONObject json = new JSONObject();
    // Null repeated field.
    json.put("test_repeated", JSONObject.NULL);

    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(RepeatedInt32.getDescriptor(), ts, json);
    assertTrue(protoMsg.getAllFields().isEmpty());

    // Missing repeated field.
    json = new JSONObject();
    json.put("test_non_repeated", JSONObject.NULL);

    protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(RepeatedInt32.getDescriptor(), ts, json);
    assertTrue(protoMsg.getAllFields().isEmpty());
  }

  @Test
  public void testDoubleAndFloatToNumericConversion() {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("numeric")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .build())
            .build();
    TestNumeric expectedProto =
        TestNumeric.newBuilder()
            .setNumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("24.678")))
            .build();
    JSONObject json = new JSONObject();
    json.put("numeric", new Double(24.678));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestNumeric.getDescriptor(), ts, json);
    assertEquals(expectedProto, protoMsg);
    json.put("numeric", new Float(24.678));
    protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestNumeric.getDescriptor(), ts, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDoubleAndFloatToNumericConversionWithJsonArray() {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("numeric")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .build())
            .build();
    List<TestNumeric> protoList = new ArrayList<>();
    int protoNum = 10;
    for (int i = 0; i < protoNum; i++) {
      protoList.add(
          TestNumeric.newBuilder()
              .setNumeric(
                  BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal("24.678" + i)))
              .build());
    }

    JSONArray doubleJsonArray = new JSONArray();
    JSONArray floatJsonArray = new JSONArray();
    for (int i = 0; i < protoNum; i++) {
      JSONObject doubleJson = new JSONObject();
      doubleJson.put("numeric", new Double(24.678 + (i * 0.0001)));
      doubleJsonArray.put(doubleJson);

      JSONObject floatJson = new JSONObject();
      floatJson.put("numeric", new Float(24.678 + (i * 0.0001)));
      floatJsonArray.put(floatJson);
    }

    List<DynamicMessage> protoMsgList =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestNumeric.getDescriptor(), ts, doubleJsonArray, false);
    assertEquals(protoList, protoMsgList);

    protoMsgList =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(
            TestNumeric.getDescriptor(), ts, floatJsonArray, false);
    assertEquals(protoList, protoMsgList);
  }

  @Test
  public void testBigDecimalToBigNumericConversion() {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("bignumeric")
                    .setType(TableFieldSchema.Type.BIGNUMERIC)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .build();
    TestBignumeric expectedProto =
        TestBignumeric.newBuilder()
            .addBignumeric(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(
                    new BigDecimal("24.6789012345")))
            .build();
    JSONObject json = new JSONObject();
    json.put("bignumeric", Collections.singletonList(new BigDecimal("24.6789012345")));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestBignumeric.getDescriptor(), ts, json);
    assertEquals(expectedProto, protoMsg);
  }

  @Test
  public void testDoubleAndFloatToRepeatedBigNumericConversion() {
    TableSchema ts =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("bignumeric")
                    .setType(TableFieldSchema.Type.BIGNUMERIC)
                    .setMode(TableFieldSchema.Mode.REPEATED)
                    .build())
            .build();
    TestBignumeric expectedProto =
        TestBignumeric.newBuilder()
            .addBignumeric(
                BigDecimalByteStringEncoder.encodeToBigNumericByteString(new BigDecimal("24.678")))
            .build();
    JSONObject json = new JSONObject();
    json.put("bignumeric", Collections.singletonList(new Double(24.678)));
    DynamicMessage protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestBignumeric.getDescriptor(), ts, json);
    assertEquals(expectedProto, protoMsg);
    json.put("bignumeric", Collections.singletonList(new Float(24.678)));
    protoMsg =
        JsonToProtoMessage.INSTANCE.convertToProtoMessage(TestBignumeric.getDescriptor(), ts, json);
    assertEquals(expectedProto, protoMsg);
  }
}
