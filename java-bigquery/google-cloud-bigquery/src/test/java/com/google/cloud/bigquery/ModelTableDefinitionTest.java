/*
 * Copyright 2026 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModelTableDefinitionTest {

  private static final String LOCATION = "US";
  private static final Long NUM_BYTES = 14L;
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", LegacySQLTypeName.RECORD, FIELD_SCHEMA1, FIELD_SCHEMA2)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final ModelTableDefinition MODEL_TABLE_DEFINITION =
      ModelTableDefinition.newBuilder()
          .setSchema(TABLE_SCHEMA)
          .setType(TableDefinition.Type.MODEL)
          .setLocation(LOCATION)
          .setNumBytes(NUM_BYTES)
          .build();

  @Test
  void testToBuilder() {
    compareModelTableDefinition(MODEL_TABLE_DEFINITION, MODEL_TABLE_DEFINITION.toBuilder().build());
  }

  @Test
  void testTypeNullPointerException() {
    NullPointerException ex =
        Assertions.assertThrows(
            NullPointerException.class,
            () -> MODEL_TABLE_DEFINITION.toBuilder().setType(null).build());
    assertNotNull(ex.getMessage());
  }

  @Test
  void testToBuilderIncomplete() {
    ModelTableDefinition modelTableDefinition = ModelTableDefinition.newBuilder().build();
    assertEquals(modelTableDefinition, modelTableDefinition.toBuilder().build());
  }

  @Test
  void testToAndFromPb() {
    assertEquals(
        MODEL_TABLE_DEFINITION, ModelTableDefinition.fromPb(MODEL_TABLE_DEFINITION.toPb()));
  }

  @Test
  void testBuilder() {
    assertEquals(MODEL_TABLE_DEFINITION.getSchema(), TABLE_SCHEMA);
    assertEquals(MODEL_TABLE_DEFINITION.getType(), TableDefinition.Type.MODEL);
    assertEquals(MODEL_TABLE_DEFINITION.getLocation(), LOCATION);
    assertEquals(MODEL_TABLE_DEFINITION.getNumBytes(), NUM_BYTES);
  }

  @Test
  void testEquals() {
    assertEquals(MODEL_TABLE_DEFINITION, MODEL_TABLE_DEFINITION);
  }

  @Test
  void testNotEquals() {
    assertNotEquals(MODEL_TABLE_DEFINITION, LOCATION);
  }

  private void compareModelTableDefinition(
      ModelTableDefinition expected, ModelTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getNumBytes(), value.getNumBytes());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
