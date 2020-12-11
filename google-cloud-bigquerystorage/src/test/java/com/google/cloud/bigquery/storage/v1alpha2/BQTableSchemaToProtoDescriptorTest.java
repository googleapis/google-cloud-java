/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
  // This is a map between the Table.TableFieldSchema.Type and the descriptor it is supposed to
  // produce. The produced descriptor will be used to check against the entry values here.
  private static ImmutableMap<Table.TableFieldSchema.Type, Descriptor>
      BQTableTypeToCorrectProtoDescriptorTest =
          new ImmutableMap.Builder<Table.TableFieldSchema.Type, Descriptor>()
              .put(Table.TableFieldSchema.Type.BOOL, BoolType.getDescriptor())
              .put(Table.TableFieldSchema.Type.BYTES, BytesType.getDescriptor())
              .put(Table.TableFieldSchema.Type.DATE, Int32Type.getDescriptor())
              .put(Table.TableFieldSchema.Type.DATETIME, StringType.getDescriptor())
              .put(Table.TableFieldSchema.Type.DOUBLE, DoubleType.getDescriptor())
              .put(Table.TableFieldSchema.Type.GEOGRAPHY, StringType.getDescriptor())
              .put(Table.TableFieldSchema.Type.INT64, Int64Type.getDescriptor())
              .put(Table.TableFieldSchema.Type.NUMERIC, StringType.getDescriptor())
              .put(Table.TableFieldSchema.Type.STRING, StringType.getDescriptor())
              .put(Table.TableFieldSchema.Type.TIME, StringType.getDescriptor())
              .put(Table.TableFieldSchema.Type.TIMESTAMP, Int64Type.getDescriptor())
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
    for (Map.Entry<Table.TableFieldSchema.Type, Descriptor> entry :
        BQTableTypeToCorrectProtoDescriptorTest.entrySet()) {
      final Table.TableFieldSchema tableFieldSchema =
          Table.TableFieldSchema.newBuilder()
              .setType(entry.getKey())
              .setMode(Table.TableFieldSchema.Mode.NULLABLE)
              .setName("test_field_type")
              .build();
      final Table.TableSchema tableSchema =
          Table.TableSchema.newBuilder().addFields(0, tableFieldSchema).build();
      final Descriptor descriptor =
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
      isDescriptorEqual(descriptor, entry.getValue());
    }
  }

  @Test
  public void testStructSimple() throws Exception {
    final Table.TableFieldSchema StringType =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRING)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_type")
            .build();
    final Table.TableFieldSchema tableFieldSchema =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_field_type")
            .addFields(0, StringType)
            .build();
    final Table.TableSchema tableSchema =
        Table.TableSchema.newBuilder().addFields(0, tableFieldSchema).build();
    final Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(tableSchema);
    isDescriptorEqual(descriptor, MessageType.getDescriptor());
  }

  @Test
  public void testStructComplex() throws Exception {
    final Table.TableFieldSchema test_int =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_int")
            .build();
    final Table.TableFieldSchema test_string =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRING)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("test_string")
            .build();
    final Table.TableFieldSchema test_bytes =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.BYTES)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("test_bytes")
            .build();
    final Table.TableFieldSchema test_bool =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.BOOL)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_bool")
            .build();
    final Table.TableFieldSchema test_double =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.DOUBLE)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("test_double")
            .build();
    final Table.TableFieldSchema test_date =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.DATE)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("test_date")
            .build();
    final Table.TableFieldSchema ComplexLvl2 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .addFields(0, test_int)
            .setName("complex_lvl2")
            .build();
    final Table.TableFieldSchema ComplexLvl1 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .addFields(0, test_int)
            .addFields(1, ComplexLvl2)
            .setName("complex_lvl1")
            .build();
    final Table.TableFieldSchema TEST_NUMERIC =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.NUMERIC)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_numeric")
            .build();
    final Table.TableFieldSchema TEST_GEO =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.GEOGRAPHY)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_geo")
            .build();
    final Table.TableFieldSchema TEST_TIMESTAMP =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.TIMESTAMP)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_timestamp")
            .build();
    final Table.TableFieldSchema TEST_TIME =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.TIME)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_time")
            .build();
    final Table.TableSchema tableSchema =
        Table.TableSchema.newBuilder()
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
    final Table.TableFieldSchema required =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("tEsT_ReQuIrEd")
            .build();
    final Table.TableFieldSchema repeated =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("tESt_repEATed")
            .build();
    final Table.TableFieldSchema optional =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_opTIONal")
            .build();
    final Table.TableFieldSchema test_int =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("TEST_INT")
            .build();
    final Table.TableFieldSchema test_string =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRING)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("TEST_STRING")
            .build();
    final Table.TableFieldSchema test_bytes =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.BYTES)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("TEST_BYTES")
            .build();
    final Table.TableFieldSchema test_bool =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.BOOL)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("TEST_BOOL")
            .build();
    final Table.TableFieldSchema test_double =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.DOUBLE)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("TEST_DOUBLE")
            .build();
    final Table.TableFieldSchema test_date =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.DATE)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("TEST_DATE")
            .build();
    final Table.TableFieldSchema option_test =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .addFields(0, required)
            .addFields(1, repeated)
            .addFields(2, optional)
            .setName("option_test")
            .build();
    final Table.TableSchema tableSchema =
        Table.TableSchema.newBuilder()
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
    final Table.TableFieldSchema required =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.REQUIRED)
            .setName("test_required")
            .build();
    final Table.TableFieldSchema repeated =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.REPEATED)
            .setName("test_repeated")
            .build();
    final Table.TableFieldSchema optional =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_optional")
            .build();
    final Table.TableSchema tableSchema =
        Table.TableSchema.newBuilder()
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
    final Table.TableFieldSchema test_int =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.INT64)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("test_int")
            .build();
    final Table.TableFieldSchema reuse_lvl2 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl2")
            .addFields(0, test_int)
            .build();
    final Table.TableFieldSchema reuse_lvl1 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final Table.TableFieldSchema reuse_lvl1_1 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1_1")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final Table.TableFieldSchema reuse_lvl1_2 =
        Table.TableFieldSchema.newBuilder()
            .setType(Table.TableFieldSchema.Type.STRUCT)
            .setMode(Table.TableFieldSchema.Mode.NULLABLE)
            .setName("reuse_lvl1_2")
            .addFields(0, test_int)
            .addFields(0, reuse_lvl2)
            .build();
    final Table.TableSchema tableSchema =
        Table.TableSchema.newBuilder()
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
