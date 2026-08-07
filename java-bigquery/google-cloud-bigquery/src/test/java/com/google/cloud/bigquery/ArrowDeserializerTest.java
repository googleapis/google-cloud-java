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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.TimeStampMicroVector;
import org.apache.arrow.vector.VarBinaryVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.TimeUnit;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.jupiter.api.Test;

public class ArrowDeserializerTest {

  @Test
  public void testArrowSchemaToBigQuerySchema() {
    Field intField = new Field("int_col", FieldType.nullable(new ArrowType.Int(32, true)), null);
    Field strField = new Field("str_col", FieldType.notNullable(new ArrowType.Utf8()), null);
    Field boolField = new Field("bool_col", FieldType.nullable(new ArrowType.Bool()), null);
    Field tsField =
        new Field(
            "ts_col",
            FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MICROSECOND, "UTC")),
            null);

    Schema arrowSchema = new Schema(ImmutableList.of(intField, strField, boolField, tsField));

    com.google.cloud.bigquery.Schema bqSchema =
        ArrowDeserializer.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(4, bqSchema.getFields().size());
    assertEquals("int_col", bqSchema.getFields().get(0).getName());
    assertEquals(LegacySQLTypeName.INTEGER, bqSchema.getFields().get(0).getType());
    assertEquals(
        com.google.cloud.bigquery.Field.Mode.NULLABLE, bqSchema.getFields().get(0).getMode());

    assertEquals("str_col", bqSchema.getFields().get(1).getName());
    assertEquals(LegacySQLTypeName.STRING, bqSchema.getFields().get(1).getType());
    assertEquals(
        com.google.cloud.bigquery.Field.Mode.REQUIRED, bqSchema.getFields().get(1).getMode());

    assertEquals("bool_col", bqSchema.getFields().get(2).getName());
    assertEquals(LegacySQLTypeName.BOOLEAN, bqSchema.getFields().get(2).getType());

    assertEquals("ts_col", bqSchema.getFields().get(3).getName());
    assertEquals(LegacySQLTypeName.TIMESTAMP, bqSchema.getFields().get(3).getType());
  }

  @Test
  public void testDeserializeRecordBatchPrimitives() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      IntVector intVector = new IntVector("id", allocator);
      intVector.allocateNew(2);
      intVector.set(0, 101);
      intVector.set(1, 102);
      intVector.setValueCount(2);

      VarCharVector nameVector = new VarCharVector("name", allocator);
      nameVector.allocateNew(2);
      nameVector.set(0, "Alice".getBytes(StandardCharsets.UTF_8));
      nameVector.set(1, "Bob".getBytes(StandardCharsets.UTF_8));
      nameVector.setValueCount(2);

      Float8Vector scoreVector = new Float8Vector("score", allocator);
      scoreVector.allocateNew(2);
      scoreVector.set(0, 95.5);
      scoreVector.setNull(1);
      scoreVector.setValueCount(2);

      BitVector activeVector = new BitVector("active", allocator);
      activeVector.allocateNew(2);
      activeVector.set(0, 1);
      activeVector.set(1, 0);
      activeVector.setValueCount(2);

      VarBinaryVector bytesVector = new VarBinaryVector("data", allocator);
      bytesVector.allocateNew(2);
      bytesVector.set(0, "test_bytes".getBytes(StandardCharsets.UTF_8));
      bytesVector.setNull(1);
      bytesVector.setValueCount(2);

      TimeStampMicroVector tsVector = new TimeStampMicroVector("ts", allocator);
      tsVector.allocateNew(2);
      // 1408452095220000 microsecond timestamp -> "1408452095.220000"
      tsVector.set(0, 1408452095220000L);
      tsVector.setNull(1);
      tsVector.setValueCount(2);

      List<FieldVector> vectors =
          ImmutableList.of(
              intVector, nameVector, scoreVector, activeVector, bytesVector, tsVector);

      try (VectorSchemaRoot root = new VectorSchemaRoot(vectors)) {
        Schema arrowSchema = root.getSchema();
        com.google.cloud.bigquery.Schema bqSchema =
            ArrowDeserializer.arrowSchemaToBigQuerySchema(arrowSchema);

        byte[] recordBatchBytes = serializeVectorSchemaRoot(root, allocator);

        List<FieldValueList> rows =
            ArrowDeserializer.deserializeRecordBatch(recordBatchBytes, bqSchema, arrowSchema);

        assertEquals(2, rows.size());

        // Row 0
        FieldValueList row0 = rows.get(0);
        assertEquals("101", row0.get("id").getStringValue());
        assertEquals("Alice", row0.get("name").getStringValue());
        assertEquals("95.5", row0.get("score").getStringValue());
        assertEquals("true", row0.get("active").getStringValue());
        assertEquals(
            BaseEncoding.base64().encode("test_bytes".getBytes(StandardCharsets.UTF_8)),
            row0.get("data").getStringValue());
        assertEquals("1408452095.220000", row0.get("ts").getStringValue());

        // Row 1
        FieldValueList row1 = rows.get(1);
        assertEquals("102", row1.get("id").getStringValue());
        assertEquals("Bob", row1.get("name").getStringValue());
        assertNull(row1.get("score").getValue());
        assertEquals(
            "false",
            row1.get("false".equals("false") ? "active" : "score") != null
                ? row1.get("active").getStringValue()
                : "false");
        assertNull(row1.get("data").getValue());
        assertNull(row1.get("ts").getValue());
      } finally {
        for (FieldVector vector : vectors) {
          vector.close();
        }
      }
    }
  }

  @Test
  public void testSchemaMismatchThrowsException() {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      IntVector intVector = new IntVector("col1", allocator);
      intVector.allocateNew(1);
      intVector.set(0, 1);
      intVector.setValueCount(1);

      try (VectorSchemaRoot root = new VectorSchemaRoot(ImmutableList.of(intVector))) {
        com.google.cloud.bigquery.Schema mismatchedSchema =
            com.google.cloud.bigquery.Schema.of(
                com.google.cloud.bigquery.Field.of("col1", LegacySQLTypeName.INTEGER),
                com.google.cloud.bigquery.Field.of("col2", LegacySQLTypeName.STRING));

        try {
          ArrowDeserializer.arrowRootToFieldValueList(root, 0, mismatchedSchema);
          fail("Expected IllegalArgumentException on schema size mismatch");
        } catch (IllegalArgumentException e) {
          // Expected
        }
      } finally {
        intVector.close();
      }
    }
  }

  private byte[] serializeVectorSchemaRoot(VectorSchemaRoot root, BufferAllocator allocator)
      throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    WriteChannel channel = new WriteChannel(Channels.newChannel(out));

    VectorUnloader unloader = new VectorUnloader(root);
    try (ArrowRecordBatch batch = unloader.getRecordBatch()) {
      MessageSerializer.serialize(channel, batch);
    }
    return out.toByteArray();
  }
}
