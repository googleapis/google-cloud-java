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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.StandardTableDefinition.StreamingBuffer;

import org.junit.Test;

public class StandardTableDefinitionTest {

  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", Field.Type.string())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", Field.Type.integer())
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_ROWS = 43L;
  private static final String LOCATION = "US";
  private static final StreamingBuffer STREAMING_BUFFER = new StreamingBuffer(1L, 2L, 3L);
  private static final TimePartitioning TIME_PARTITIONING =
      TimePartitioning.of(TimePartitioning.Type.DAY, 42);
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.newBuilder()
          .setLocation(LOCATION)
          .setNumBytes(NUM_BYTES)
          .setNumRows(NUM_ROWS)
          .setStreamingBuffer(STREAMING_BUFFER)
          .setSchema(TABLE_SCHEMA)
          .setTimePartitioning(TIME_PARTITIONING)
          .build();
  private static final StandardTableDefinition DEPRECATED_TABLE_DEFINITION =
      StandardTableDefinition.builder()
          .setLocation(LOCATION)
          .setNumBytes(NUM_BYTES)
          .setNumRows(NUM_ROWS)
          .setStreamingBuffer(STREAMING_BUFFER)
          .schema(TABLE_SCHEMA)
          .timePartitioning(TIME_PARTITIONING)
          .build();

  @Test
  public void testToBuilder() {
    compareStandardTableDefinition(TABLE_DEFINITION, TABLE_DEFINITION.toBuilder().build());
    StandardTableDefinition tableDefinition = TABLE_DEFINITION.toBuilder().setLocation("EU").build();
    assertEquals("EU", tableDefinition.getLocation());
    tableDefinition = tableDefinition.toBuilder()
        .setLocation(LOCATION)
        .build();
    compareStandardTableDefinition(TABLE_DEFINITION, tableDefinition);
  }

  @Test
  public void testToBuilderIncomplete() {
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    assertEquals(tableDefinition, tableDefinition.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TableDefinition.Type.TABLE, TABLE_DEFINITION.getType());
    assertEquals(TABLE_SCHEMA, TABLE_DEFINITION.getSchema());
    assertEquals(LOCATION, TABLE_DEFINITION.getLocation());
    assertEquals(NUM_BYTES, TABLE_DEFINITION.getNumBytes());
    assertEquals(NUM_ROWS, TABLE_DEFINITION.getNumRows());
    assertEquals(STREAMING_BUFFER, TABLE_DEFINITION.getStreamingBuffer());
    assertEquals(TIME_PARTITIONING, TABLE_DEFINITION.getTimePartitioning());
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(TableDefinition.Type.TABLE, DEPRECATED_TABLE_DEFINITION.type());
    assertEquals(TABLE_SCHEMA, DEPRECATED_TABLE_DEFINITION.schema());
    assertEquals(LOCATION, DEPRECATED_TABLE_DEFINITION.location());
    assertEquals(NUM_BYTES, DEPRECATED_TABLE_DEFINITION.numBytes());
    assertEquals(NUM_ROWS, DEPRECATED_TABLE_DEFINITION.numRows());
    assertEquals(STREAMING_BUFFER, DEPRECATED_TABLE_DEFINITION.streamingBuffer());
    assertEquals(TIME_PARTITIONING, DEPRECATED_TABLE_DEFINITION.timePartitioning());
  }

  @Test
  public void testOf() {
    StandardTableDefinition definition = StandardTableDefinition.of(TABLE_SCHEMA);
    assertEquals(TableDefinition.Type.TABLE, TABLE_DEFINITION.getType());
    assertEquals(TABLE_SCHEMA, TABLE_DEFINITION.getSchema());
    assertNull(definition.getLocation());
    assertNull(definition.getNumBytes());
    assertNull(definition.getNumRows());
    assertNull(definition.getStreamingBuffer());
    assertNull(definition.getTimePartitioning());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(TableDefinition.fromPb(TABLE_DEFINITION.toPb()) instanceof StandardTableDefinition);
    compareStandardTableDefinition(TABLE_DEFINITION,
        TableDefinition.<StandardTableDefinition>fromPb(TABLE_DEFINITION.toPb()));
    StandardTableDefinition definition = StandardTableDefinition.of(TABLE_SCHEMA);
    assertTrue(TableDefinition.fromPb(definition.toPb()) instanceof StandardTableDefinition);
    compareStandardTableDefinition(definition,
        TableDefinition.<StandardTableDefinition>fromPb(definition.toPb()));
  }

  private void compareStandardTableDefinition(StandardTableDefinition expected,
      StandardTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getNumBytes(), value.getNumBytes());
    assertEquals(expected.getNumRows(), value.getNumRows());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getStreamingBuffer(), value.getStreamingBuffer());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getTimePartitioning(), value.getTimePartitioning());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
