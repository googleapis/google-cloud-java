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
import static org.mockito.Mockito.*;

import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.storage.test.SchemaTest.*;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class SchemaCompatibilityTest {
  @Mock private BigQuery mockBigquery;
  @Mock private Table mockBigqueryTable;
  Descriptors.Descriptor[] type_descriptors = {
    Int32Type.getDescriptor(),
    Int64Type.getDescriptor(),
    UInt32Type.getDescriptor(),
    UInt64Type.getDescriptor(),
    Fixed32Type.getDescriptor(),
    Fixed64Type.getDescriptor(),
    SFixed32Type.getDescriptor(),
    SFixed64Type.getDescriptor(),
    FloatType.getDescriptor(),
    DoubleType.getDescriptor(),
    BoolType.getDescriptor(),
    BytesType.getDescriptor(),
    StringType.getDescriptor(),
    EnumType.getDescriptor(),
    MessageType.getDescriptor(),
    GroupType.getDescriptor()
  };

  @Before
  public void setUp() throws IOException {
    MockitoAnnotations.initMocks(this);
    when(mockBigquery.getTable(any(TableId.class))).thenReturn(mockBigqueryTable);
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(mockBigquery);
    verifyNoMoreInteractions(mockBigqueryTable);
  }

  public void customizeSchema(final Schema schema) {
    TableDefinition definition =
        new TableDefinition() {
          @Override
          public Type getType() {
            return null;
          }

          @Nullable
          @Override
          public Schema getSchema() {
            return schema;
          }

          @Override
          public Builder toBuilder() {
            return null;
          }
        };
    when(mockBigqueryTable.getDefinition()).thenReturn(definition);
  }

  @Test
  public void testSuccess() throws Exception {
    customizeSchema(
        Schema.of(
            Field.newBuilder("Foo", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", FooType.getDescriptor(), false);
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testBadTableName() throws Exception {
    try {
      SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
      compact.check("blah", FooType.getDescriptor(), false);
      fail("should fail");
    } catch (IllegalArgumentException expected) {
      assertEquals("Invalid table name: blah", expected.getMessage());
    }
  }

  @Test
  public void testSupportedTypes() {
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    for (Descriptors.FieldDescriptor field : SupportedTypes.getDescriptor().getFields()) {
      assertTrue(compact.isSupportedType(field));
    }

    for (Descriptors.FieldDescriptor field : NonSupportedTypes.getDescriptor().getFields()) {
      assertFalse(compact.isSupportedType(field));
    }
  }

  @Test
  public void testMap() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("map_value", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    Descriptors.Descriptor testMap = NonSupportedMap.getDescriptor();
    String protoName = testMap.getName() + ".map_value";
    try {
      compact.check("projects/p/datasets/d/tables/t", testMap, false);
      fail("Should not be supported: field contains map");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Proto schema " + protoName + " is not supported: is a map field.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testNestingSupportedSimple() {
    Field BQSupportedNestingLvl2 =
        Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build(),
            Field.newBuilder("nesting_value", LegacySQLTypeName.RECORD, BQSupportedNestingLvl2)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    Descriptors.Descriptor testNesting = SupportedNestingLvl1.getDescriptor();
    try {
      compact.check("projects/p/datasets/d/tables/t", testNesting, false);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testNestingSupportedStacked() {
    Field BQSupportedNestingLvl2 =
        Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build(),
            Field.newBuilder("nesting_value1", LegacySQLTypeName.RECORD, BQSupportedNestingLvl2)
                .setMode(Field.Mode.NULLABLE)
                .build(),
            Field.newBuilder("nesting_value2", LegacySQLTypeName.RECORD, BQSupportedNestingLvl2)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    Descriptors.Descriptor testNesting = SupportedNestingStacked.getDescriptor();
    try {
      compact.check("projects/p/datasets/d/tables/t", testNesting, false);
    } catch (Exception e) {
      fail(e.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  /*
   * This is not the "exact" test, as BigQuery fields cannot be recursive. Instead, this test uses
   * two DIFFERENT records with the same name to simulate recursive protos (protos can't have the
   * same name anyways unless they are the same proto).
   */
  @Test
  public void testNestingContainsRecursive() {
    Field BQNonSupportedNestingRecursive =
        Field.newBuilder(
                "nesting_value",
                LegacySQLTypeName.RECORD,
                Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
                    .setMode(Field.Mode.NULLABLE)
                    .build())
            .setMode(Field.Mode.NULLABLE)
            .build();

    customizeSchema(
        Schema.of(
            Field.newBuilder("int_value", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build(),
            Field.newBuilder(
                    "nesting_value", LegacySQLTypeName.RECORD, BQNonSupportedNestingRecursive)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    Descriptors.Descriptor testNesting = NonSupportedNestingContainsRecursive.getDescriptor();
    try {
      compact.check("projects/p/datasets/d/tables/t", testNesting, false);
      fail("Should not be supported: contains nested messages of more than 15 levels.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Proto schema "
              + testNesting.getName()
              + ".nesting_value.nesting_value is not supported: is a recursively nested message.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testNestingRecursiveLimit() {
    Field NonSupportedNestingLvl16 =
        Field.newBuilder("test1", LegacySQLTypeName.INTEGER).setMode(Field.Mode.NULLABLE).build();
    Field NonSupportedNestingLvl15 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl16)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl14 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl15)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl13 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl14)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl12 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl13)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl11 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl12)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl10 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl11)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl9 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl10)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl8 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl9)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl7 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl8)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl6 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl7)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl5 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl6)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl4 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl5)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl3 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl4)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl2 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl3)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field NonSupportedNestingLvl1 =
        Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl2)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("test1", LegacySQLTypeName.RECORD, NonSupportedNestingLvl1)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    Descriptors.Descriptor testNesting = NonSupportedNestingLvl0.getDescriptor();
    try {
      compact.check("projects/p/datasets/d/tables/t", testNesting, false);
      fail("Should not be supported: contains nested messages of more than 15 levels.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Proto schema "
              + testNesting.getName()
              + " is not supported: contains nested messages of more than 15 levels.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testProtoMoreFields() {
    Schema customSchema = Schema.of(Field.of("int32_value", LegacySQLTypeName.INTEGER));
    customizeSchema(customSchema);
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);

    try {
      compact.check("projects/p/datasets/d/tables/t", SupportedTypes.getDescriptor(), false);
      fail("Should fail: proto has more fields and allowUnknownFields flag is false.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Proto schema "
              + SupportedTypes.getDescriptor().getName()
              + " has "
              + SupportedTypes.getDescriptor().getFields().size()
              + " fields, while BQ schema t has "
              + 1
              + " fields.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testBQRepeated() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("repeated_mode", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.REPEATED)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", ProtoRepeatedBQRepeated.getDescriptor(), false);
    try {
      compact.check(
          "projects/p/datasets/d/tables/t", ProtoOptionalBQRepeated.getDescriptor(), false);
      fail("Should fail: BQ schema is repeated, but proto is optional.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Given proto field "
              + ProtoOptionalBQRepeated.getDescriptor().getName()
              + ".repeated_mode"
              + " is not repeated but Big Query field t.repeated_mode is.",
          expected.getMessage());
    }

    try {
      compact.check(
          "projects/p/datasets/d/tables/t", ProtoRequiredBQRepeated.getDescriptor(), false);
      fail("Should fail: BQ schema is repeated, but proto is required.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Given proto field "
              + ProtoRequiredBQRepeated.getDescriptor().getName()
              + ".repeated_mode"
              + " is not repeated but Big Query field t.repeated_mode is.",
          expected.getMessage());
    }
    verify(mockBigquery, times(3)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(3)).getDefinition();
  }

  @Test
  public void testBQRequired() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("required_mode", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.REQUIRED)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", ProtoRequiredBQRequired.getDescriptor(), false);

    try {
      compact.check("projects/p/datasets/d/tables/t", ProtoNoneBQRequired.getDescriptor(), false);
      fail("Should fail: BQ schema is required, but proto does not have this field.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "The required Big Query field t.required_mode is missing in the proto schema "
              + ProtoNoneBQRequired.getDescriptor().getName()
              + ".",
          expected.getMessage());
    }

    try {
      compact.check(
          "projects/p/datasets/d/tables/t", ProtoOptionalBQRequired.getDescriptor(), false);
      fail("Should fail: BQ schema is required, but proto is optional.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Given proto field "
              + ProtoOptionalBQRequired.getDescriptor().getName()
              + ".required_mode is not required but Big Query field t.required_mode is.",
          expected.getMessage());
    }

    try {
      compact.check(
          "projects/p/datasets/d/tables/t", ProtoRepeatedBQRequired.getDescriptor(), false);
      fail("Should fail: BQ schema is required, but proto is repeated.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Given proto field "
              + ProtoRepeatedBQRequired.getDescriptor().getName()
              + ".required_mode is not required but Big Query field t.required_mode is.",
          expected.getMessage());
    }
    verify(mockBigquery, times(4)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(4)).getDefinition();
  }

  @Test
  public void testBQOptional() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("optional_mode", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", ProtoOptionalBQOptional.getDescriptor(), false);
    compact.check("projects/p/datasets/d/tables/t", ProtoRequiredBQOptional.getDescriptor(), false);

    try {
      compact.check(
          "projects/p/datasets/d/tables/t", ProtoRepeatedBQOptional.getDescriptor(), false);
      fail("Should fail: BQ schema is nullable, but proto field is repeated.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "Given proto field "
              + ProtoRepeatedBQOptional.getDescriptor().getName()
              + ".optional_mode is repeated but Big Query field t.optional_mode is optional.",
          expected.getMessage());
    }

    verify(mockBigquery, times(3)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(3)).getDefinition();
  }

  @Test
  public void testBQBool() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.BOOLEAN)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(
            Arrays.asList(
                Int32Type.getDescriptor(),
                Int64Type.getDescriptor(),
                UInt32Type.getDescriptor(),
                UInt64Type.getDescriptor(),
                Fixed32Type.getDescriptor(),
                Fixed64Type.getDescriptor(),
                SFixed32Type.getDescriptor(),
                SFixed64Type.getDescriptor(),
                BoolType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Boolean.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQBytes() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.BYTES)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(BytesType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Bytes.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQDate() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.DATE)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(
            Arrays.asList(
                Int32Type.getDescriptor(),
                Int64Type.getDescriptor(),
                SFixed32Type.getDescriptor(),
                SFixed64Type.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Date.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQDatetime() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.DATETIME)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(Int64Type.getDescriptor(), StringType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Datetime.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQFloat() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.FLOAT)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(FloatType.getDescriptor(), DoubleType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Float.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQGeography() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.GEOGRAPHY)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(StringType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Geography.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQInteger() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.INTEGER)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(
            Arrays.asList(
                Int32Type.getDescriptor(),
                Int64Type.getDescriptor(),
                UInt32Type.getDescriptor(),
                Fixed32Type.getDescriptor(),
                SFixed32Type.getDescriptor(),
                SFixed64Type.getDescriptor(),
                EnumType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Integer.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQNumeric() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.NUMERIC)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(
            Arrays.asList(
                Int32Type.getDescriptor(),
                Int64Type.getDescriptor(),
                UInt32Type.getDescriptor(),
                UInt64Type.getDescriptor(),
                Fixed32Type.getDescriptor(),
                Fixed64Type.getDescriptor(),
                SFixed32Type.getDescriptor(),
                SFixed64Type.getDescriptor(),
                BytesType.getDescriptor(),
                StringType.getDescriptor(),
                FloatType.getDescriptor(),
                DoubleType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Numeric.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQRecord() {
    Field nestedMessage =
        Field.newBuilder("test_field_type", LegacySQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.RECORD, nestedMessage)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(MessageType.getDescriptor(), GroupType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ String.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQRecordMismatch() {
    Field nestedMessage1 =
        Field.newBuilder("test_field_type", LegacySQLTypeName.INTEGER)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field nestedMessage0 =
        Field.newBuilder("mismatchlvl1", LegacySQLTypeName.RECORD, nestedMessage1)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("mismatchlvl0", LegacySQLTypeName.RECORD, nestedMessage0)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    try {
      compact.check("projects/p/datasets/d/tables/t", MessageTypeMismatch.getDescriptor(), false);
      fail("Should fail: Proto schema type should not match BQ String.");
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "The proto field "
              + MessageTypeMismatch.getDescriptor().getName()
              + ".mismatchlvl0.mismatchlvl1.test_field_type does not have a matching type with the big query field t.mismatchlvl0.mismatchlvl1.test_field_type.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testBQRecordMatch() {
    Field nestedMessage1 =
        Field.newBuilder("test_field_type", LegacySQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build();
    Field nestedMessage0 =
        Field.newBuilder("mismatchlvl1", LegacySQLTypeName.RECORD, nestedMessage1)
            .setMode(Field.Mode.NULLABLE)
            .build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("mismatchlvl0", LegacySQLTypeName.RECORD, nestedMessage0)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", MessageTypeMismatch.getDescriptor(), false);
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testBQString() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(StringType.getDescriptor(), EnumType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ String.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQTime() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.TIME)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(Arrays.asList(Int64Type.getDescriptor(), StringType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Time.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  @Test
  public void testBQTimestamp() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_field_type", LegacySQLTypeName.TIMESTAMP)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    HashSet<Descriptors.Descriptor> compatible =
        new HashSet<>(
            Arrays.asList(
                Int32Type.getDescriptor(),
                Int64Type.getDescriptor(),
                UInt32Type.getDescriptor(),
                Fixed32Type.getDescriptor(),
                SFixed32Type.getDescriptor(),
                SFixed64Type.getDescriptor(),
                EnumType.getDescriptor()));

    for (Descriptors.Descriptor descriptor : type_descriptors) {
      if (compatible.contains(descriptor)) {
        compact.check("projects/p/datasets/d/tables/t", descriptor, false);
      } else {
        try {
          compact.check("projects/p/datasets/d/tables/t", descriptor, false);
          fail("Should fail: Proto schema type should not match BQ Timestamp.");
        } catch (IllegalArgumentException expected) {
          assertEquals(
              "The proto field "
                  + descriptor.getName()
                  + ".test_field_type does not have a matching type with the big query field t.test_field_type.",
              expected.getMessage());
        }
      }
    }
    verify(mockBigquery, times(16)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(16)).getDefinition();
  }

  /*
   * Tests if having no matching fields in the top level causes an error.
   */
  @Test
  public void testBQTopLevelMismatch() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("test_toplevel_mismatch", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    try {
      compact.check("projects/p/datasets/d/tables/t", StringType.getDescriptor(), false);
    } catch (IllegalArgumentException expected) {
      assertEquals(
          "There is no matching fields found for the proto schema "
              + StringType.getDescriptor().getName()
              + " and the BQ table schema t.",
          expected.getMessage());
    }
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  /*
   * Tests if there is at least 1 matching field in the top level.
   */
  @Test
  public void testBQTopLevelMatch() {
    Field nestedMessage0 =
        Field.newBuilder("mismatch", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build();
    customizeSchema(
        Schema.of(
            Field.newBuilder("mismatch", LegacySQLTypeName.RECORD, nestedMessage0)
                .setMode(Field.Mode.NULLABLE)
                .build(),
            Field.newBuilder("match", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", TopLevelMatch.getDescriptor(), false);
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testAllowUnknownUnsupportedFields() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("string_value", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check(
        "projects/p/datasets/d/tables/t", AllowUnknownUnsupportedFields.getDescriptor(), true);
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }

  @Test
  public void testLowerCase() {
    customizeSchema(
        Schema.of(
            Field.newBuilder("tEsT_fIeLd_TyPe", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build()));
    SchemaCompatibility compact = SchemaCompatibility.getInstance(mockBigquery);
    compact.check("projects/p/datasets/d/tables/t", StringType.getDescriptor(), true);
    verify(mockBigquery, times(1)).getTable(any(TableId.class));
    verify(mockBigqueryTable, times(1)).getDefinition();
  }
}
