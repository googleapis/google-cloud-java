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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.bigquery.DefaultTableDefinition.StreamingBuffer;

import org.junit.Test;

public class DefaultTableDefinitionTest {

  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_ROWS = 43L;
  private static final String LOCATION = "US";
  private static final StreamingBuffer STREAMING_BUFFER = new StreamingBuffer(1L, 2L, 3L);
  private static final DefaultTableDefinition DEFAULT_TABLE_DEFINITION =
      DefaultTableDefinition.builder()
          .location(LOCATION)
          .numBytes(NUM_BYTES)
          .numRows(NUM_ROWS)
          .streamingBuffer(STREAMING_BUFFER)
          .schema(TABLE_SCHEMA)
          .build();

  @Test
  public void testToBuilder() {
    compareDefaultTableDefinition(DEFAULT_TABLE_DEFINITION,
        DEFAULT_TABLE_DEFINITION.toBuilder().build());
    DefaultTableDefinition tableDefinition = DEFAULT_TABLE_DEFINITION.toBuilder()
        .location("EU")
        .build();
    assertEquals("EU", tableDefinition.location());
    tableDefinition = tableDefinition.toBuilder()
        .location(LOCATION)
        .build();
    compareDefaultTableDefinition(DEFAULT_TABLE_DEFINITION, tableDefinition);
  }

  @Test
  public void testToBuilderIncomplete() {
    DefaultTableDefinition tableDefinition = DefaultTableDefinition.of(TABLE_SCHEMA);
    assertEquals(tableDefinition, tableDefinition.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(BaseTableDefinition.Type.TABLE, DEFAULT_TABLE_DEFINITION.type());
    assertEquals(TABLE_SCHEMA, DEFAULT_TABLE_DEFINITION.schema());
    assertEquals(LOCATION, DEFAULT_TABLE_DEFINITION.location());
    assertEquals(NUM_BYTES, DEFAULT_TABLE_DEFINITION.numBytes());
    assertEquals(NUM_ROWS, DEFAULT_TABLE_DEFINITION.numRows());
    assertEquals(STREAMING_BUFFER, DEFAULT_TABLE_DEFINITION.streamingBuffer());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(
        BaseTableDefinition.fromPb(DEFAULT_TABLE_DEFINITION.toPb())
            instanceof DefaultTableDefinition);
    compareDefaultTableDefinition(DEFAULT_TABLE_DEFINITION,
        BaseTableDefinition.<DefaultTableDefinition>fromPb(DEFAULT_TABLE_DEFINITION.toPb()));
  }

  private void compareDefaultTableDefinition(DefaultTableDefinition expected,
      DefaultTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.numBytes(), value.numBytes());
    assertEquals(expected.numRows(), value.numRows());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.streamingBuffer(), value.streamingBuffer());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
