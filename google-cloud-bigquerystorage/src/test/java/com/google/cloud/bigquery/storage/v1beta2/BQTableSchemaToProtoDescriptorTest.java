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

import static org.junit.Assert.*;

import com.google.cloud.bigquery.storage.test.JsonTest.*;
import com.google.cloud.bigquery.storage.test.SchemaTest.*;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BQTableSchemaToProtoDescriptorTest {
  // This is a map between the TableFieldSchema.Type and the descriptor it is supposed to
  // produce. The produced descriptor will be used to check against the entry values here.
  private static ImmutableMap<TableFieldSchema.Type, Descriptor>
      BQTableTypeToCorrectProtoDescriptorTest =
          new ImmutableMap.Builder<TableFieldSchema.Type, Descriptor>()
              .put(TableFieldSchema.Type.BOOL, BoolType.getDescriptor())
              .put(TableFieldSchema.Type.BYTES, BytesType.getDescriptor())
              .put(TableFieldSchema.Type.DATE, Int32Type.getDescriptor())
              .put(TableFieldSchema.Type.DATETIME, StringType.getDescriptor())
              .put(TableFieldSchema.Type.DOUBLE, DoubleType.getDescriptor())
              .put(TableFieldSchema.Type.GEOGRAPHY, StringType.getDescriptor())
              .put(TableFieldSchema.Type.INT64, Int64Type.getDescriptor())
              .put(TableFieldSchema.Type.NUMERIC, StringType.getDescriptor())
              .put(TableFieldSchema.Type.STRING, StringType.getDescriptor())
              .put(TableFieldSchema.Type.TIME, StringType.getDescriptor())
              .put(TableFieldSchema.Type.TIMESTAMP, Int64Type.getDescriptor())
              .build();

  // Creates mapping from descriptor to how many times it was reused.
  private void mapDescriptorToCount(Descriptor descriptor, HashMap<String, Integer> map) {
    for (FieldDescriptor field : descriptor.getFields()) {
      if (field.getType() == FieldDescriptor.Type.MESSAGE) {
        Descriptor subDescriptor = field.getMessageType();
        String messageName = subDescriptor.getName();
        if (map.containsKey(messageName)) {
          map.put(messageName, map.get(messageName) + 1);
        } else {
          map.put(messageName, 1);
        }
        mapDescriptorToCount(subDescriptor, map);
      }
    }
  }

  private void isDescriptorEqual(Descriptor convertedProto, Descriptor originalProto) {
    // Check same number of fields
    assertEquals(convertedProto.getFields().size(), originalProto.getFields().size());
    for (FieldDescriptor convertedField : convertedProto.getFields()) {
      // Check field name
      FieldDescriptor originalField = originalProto.findFieldByName(convertedField.getName());
      assertNotNull(originalField);
      // Check type
      FieldDescriptor.Type convertedType = convertedField.getType();
      FieldDescriptor.Type originalType = originalField.getType();
      assertEquals(convertedField.getName(), convertedType, originalType);
      // Check mode
      assertTrue(
          (originalField.isRepeated() == convertedField.isRepeated())
              && (originalField.isRequired() == convertedField.isRequired())
              && (originalField.isOptional() == convertedField.isOptional()));
      // Recursively check nested messages
      if (convertedType == FieldDescriptor.Type.MESSAGE) {
        isDescriptorEqual(convertedField.getMessageType(), originalField.getMessageType());
      }
    }
  }

  @Test
  public void testSimpleTypes() throws Exception {
    for (Map.Entry<TableFieldSchema.Type, Descriptor> entry :
        BQTableTypeToCorrectProtoDescriptorTest.entrySet()) {
      final TableFieldSchema tableFieldSchema =
          TableFieldSchema.newBuilder()
              .setType(entry.getKey())
              .setMode(TableFieldSchema.Mode.NULLABLE)
              .setName("test_field_type")
              .build();
      final TableSchema tableSchema =
          TableSchema.newBuilder().addFields(0, tableFieldSchema).build();
      final Descriptor descriptor =
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
      isDescriptorEqual(descriptor, entry.getValue());
    }
  }

  @Test
  public void testStructSimple() throws Exception {
    final TableFieldSchema StringType =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_type")
            .build();
    final TableFieldSchema tableFieldSchema =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_type")
            .addFields(0, StringType)
            .build();
    final TableSchema tableSchema = TableSchema.newBuilder().addFields(0, tableFieldSchema).build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    isDescriptorEqual(descriptor, MessageType.getDescriptor());
  }

  @Test
  public void testStructComplex() throws Exception {
    final TableFieldSchema test_int =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_int")
            .build();
    final TableFieldSchema test_string =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("test_string")
            .build();
    final TableFieldSchema test_bytes =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.BYTES)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("test_bytes")
            .build();
    final TableFieldSchema test_bool =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.BOOL)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_bool")
            .build();
    final TableFieldSchema test_double =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.DOUBLE)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("test_double")
            .build();
    final TableFieldSchema test_date =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.DATE)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("test_date")
            .build();
    final TableFieldSchema ComplexLvl2 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .addFields(0, test_int)
            .setName("complex_lvl2")
            .build();
    final TableFieldSchema ComplexLvl1 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .addFields(0, test_int)
            .addFields(1, ComplexLvl2)
            .setName("complex_lvl1")
            .build();
    final TableFieldSchema TEST_NUMERIC =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.NUMERIC)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_numeric")
            .build();
    final TableFieldSchema TEST_GEO =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.GEOGRAPHY)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_geo")
            .build();
    final TableFieldSchema TEST_TIMESTAMP =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.TIMESTAMP)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_timestamp")
            .build();
    final TableFieldSchema TEST_TIME =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.TIME)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_time")
            .build();
    final TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, test_int)
            .addFields(1, test_string)
            .addFields(2, test_bytes)
            .addFields(3, test_bool)
            .addFields(4, test_double)
            .addFields(5, test_date)
            .addFields(6, ComplexLvl1)
            .addFields(7, ComplexLvl2)
            .addFields(8, TEST_NUMERIC)
            .addFields(9, TEST_GEO)
            .addFields(10, TEST_TIMESTAMP)
            .addFields(11, TEST_TIME)
            .build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    isDescriptorEqual(descriptor, ComplexRoot.getDescriptor());
  }

  @Test
  public void testCasingComplexStruct() throws Exception {
    final TableFieldSchema required =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("tEsT_ReQuIrEd")
            .build();
    final TableFieldSchema repeated =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("tESt_repEATed")
            .build();
    final TableFieldSchema optional =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_opTIONal")
            .build();
    final TableFieldSchema test_int =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("TEST_INT")
            .build();
    final TableFieldSchema test_string =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("TEST_STRING")
            .build();
    final TableFieldSchema test_bytes =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.BYTES)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("TEST_BYTES")
            .build();
    final TableFieldSchema test_bool =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.BOOL)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("TEST_BOOL")
            .build();
    final TableFieldSchema test_double =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.DOUBLE)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("TEST_DOUBLE")
            .build();
    final TableFieldSchema test_date =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.DATE)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("TEST_DATE")
            .build();
    final TableFieldSchema option_test =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .addFields(0, required)
            .addFields(1, repeated)
            .addFields(2, optional)
            .setName("option_test")
            .build();
    final TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, test_int)
            .addFields(1, test_string)
            .addFields(2, test_bytes)
            .addFields(3, test_bool)
            .addFields(4, test_double)
            .addFields(5, test_date)
            .addFields(6, option_test)
            .build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    isDescriptorEqual(descriptor, CasingComplex.getDescriptor());
  }

  @Test
  public void testOptions() throws Exception {
    final TableFieldSchema required =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.REQUIRED)
            .setName("test_required")
            .build();
    final TableFieldSchema repeated =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("test_repeated")
            .build();
    final TableFieldSchema optional =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_optional")
            .build();
    final TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, required)
            .addFields(1, repeated)
            .addFields(2, optional)
            .build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    isDescriptorEqual(descriptor, OptionTest.getDescriptor());
  }

  @Test
  public void testDescriptorReuseDuringCreation() throws Exception {
    final TableFieldSchema test_int =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.INT64)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_int")
            .build();
    final TableFieldSchema reuse_lvl2 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl2")
            .addFields(0, test_int)
            .build();
    final TableFieldSchema reuse_lvl1 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final TableFieldSchema reuse_lvl1_1 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1_1")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final TableFieldSchema reuse_lvl1_2 =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRUCT)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1_2")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, reuse_lvl1)
            .addFields(1, reuse_lvl1_1)
            .addFields(2, reuse_lvl1_2)
            .build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    HashMap<String, Integer> descriptorToCount = new HashMap<String, Integer>();
    mapDescriptorToCount(descriptor, descriptorToCount);
    assertEquals(descriptorToCount.size(), 2);
    assertTrue(descriptorToCount.containsKey("root__reuse_lvl1"));
    assertEquals(descriptorToCount.get("root__reuse_lvl1").intValue(), 3);
    assertTrue(descriptorToCount.containsKey("root__reuse_lvl1__reuse_lvl2"));
    assertEquals(descriptorToCount.get("root__reuse_lvl1__reuse_lvl2").intValue(), 3);
    isDescriptorEqual(descriptor, ReuseRoot.getDescriptor());
  }
}
