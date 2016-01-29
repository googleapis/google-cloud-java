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

import com.google.gcloud.bigquery.DefaultTableType.StreamingBuffer;

import org.junit.Test;

public class DefaultTableTypeTest {

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
  private static final DefaultTableType DEFAULT_TABLE_TYPE = DefaultTableType.builder()
      .location(LOCATION)
      .numBytes(NUM_BYTES)
      .numRows(NUM_ROWS)
      .streamingBuffer(STREAMING_BUFFER)
      .schema(TABLE_SCHEMA)
      .build();


  @Test
  public void testToBuilder() {
    compareDefaultTableType(DEFAULT_TABLE_TYPE, DEFAULT_TABLE_TYPE.toBuilder().build());
    DefaultTableType tableType = DEFAULT_TABLE_TYPE.toBuilder()
        .location("EU")
        .build();
    assertEquals("EU", tableType.location());
    tableType = tableType.toBuilder()
        .location(LOCATION)
        .build();
    compareDefaultTableType(DEFAULT_TABLE_TYPE, tableType);
  }

  @Test
  public void testToBuilderIncomplete() {
    DefaultTableType tableType = DefaultTableType.of(TABLE_SCHEMA);
    assertEquals(tableType, tableType.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(BaseTableType.Type.TABLE, DEFAULT_TABLE_TYPE.type());
    assertEquals(TABLE_SCHEMA, DEFAULT_TABLE_TYPE.schema());
    assertEquals(LOCATION, DEFAULT_TABLE_TYPE.location());
    assertEquals(NUM_BYTES, DEFAULT_TABLE_TYPE.numBytes());
    assertEquals(NUM_ROWS, DEFAULT_TABLE_TYPE.numRows());
    assertEquals(STREAMING_BUFFER, DEFAULT_TABLE_TYPE.streamingBuffer());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(BaseTableType.fromPb(DEFAULT_TABLE_TYPE.toPb()) instanceof DefaultTableType);
    compareDefaultTableType(DEFAULT_TABLE_TYPE,
        BaseTableType.<DefaultTableType>fromPb(DEFAULT_TABLE_TYPE.toPb()));
  }

  private void compareDefaultTableType(DefaultTableType expected, DefaultTableType value) {
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
