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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.DateDayVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.TimeMicroVector;
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
import org.apache.arrow.vector.types.pojo.FieldType;
import org.junit.jupiter.api.Test;

public class ArrowDeserializerTest {

  @Test
  public void testArrowSchemaToBigQuerySchema() {
    org.apache.arrow.vector.types.pojo.Field intField =
        new org.apache.arrow.vector.types.pojo.Field(
            "int_col", FieldType.nullable(new ArrowType.Int(32, true)), null);
    org.apache.arrow.vector.types.pojo.Field strField =
        new org.apache.arrow.vector.types.pojo.Field(
            "str_col", FieldType.notNullable(new ArrowType.Utf8()), null);
    org.apache.arrow.vector.types.pojo.Field boolField =
        new org.apache.arrow.vector.types.pojo.Field(
            "bool_col", FieldType.nullable(new ArrowType.Bool()), null);
    org.apache.arrow.vector.types.pojo.Field tsField =
        new org.apache.arrow.vector.types.pojo.Field(
            "ts_col",
            FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MICROSECOND, "UTC")),
            null);

    org.apache.arrow.vector.types.pojo.Schema arrowSchema =
        new org.apache.arrow.vector.types.pojo.Schema(
            ImmutableList.of(intField, strField, boolField, tsField));

    Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    assertEquals(4, bqSchema.getFields().size());
    assertEquals("int_col", bqSchema.getFields().get(0).getName());
    assertEquals(LegacySQLTypeName.INTEGER, bqSchema.getFields().get(0).getType());
    assertEquals(Field.Mode.NULLABLE, bqSchema.getFields().get(0).getMode());

    assertEquals("str_col", bqSchema.getFields().get(1).getName());
    assertEquals(LegacySQLTypeName.STRING, bqSchema.getFields().get(1).getType());
    assertEquals(Field.Mode.REQUIRED, bqSchema.getFields().get(1).getMode());

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

      DateDayVector dateVector = new DateDayVector("date_col", allocator);
      dateVector.allocateNew(2);
      // 18993 days -> "2022-01-01"
      dateVector.set(0, 18993);
      dateVector.setNull(1);
      dateVector.setValueCount(2);

      TimeMicroVector timeVector = new TimeMicroVector("time_col", allocator);
      timeVector.allocateNew(2);
      // 43800000000 microseconds = 12:10:00
      timeVector.set(0, 43800000000L);
      timeVector.setNull(1);
      timeVector.setValueCount(2);

      List<FieldVector> vectors =
          ImmutableList.of(
              intVector,
              nameVector,
              scoreVector,
              activeVector,
              bytesVector,
              tsVector,
              dateVector,
              timeVector);

      try (VectorSchemaRoot root = new VectorSchemaRoot(vectors)) {
        org.apache.arrow.vector.types.pojo.Schema arrowSchema = root.getSchema();
        Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

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
        assertEquals("2022-01-01", row0.get("date_col").getStringValue());
        assertEquals("12:10", row0.get("time_col").getStringValue());

        // Row 1
        FieldValueList row1 = rows.get(1);
        assertEquals("102", row1.get("id").getStringValue());
        assertEquals("Bob", row1.get("name").getStringValue());
        assertNull(row1.get("score").getValue());
        assertEquals("false", row1.get("active").getStringValue());
        assertNull(row1.get("data").getValue());
        assertNull(row1.get("ts").getValue());
        assertNull(row1.get("date_col").getValue());
        assertNull(row1.get("time_col").getValue());
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
        Schema mismatchedSchema =
            Schema.of(
                Field.of("col1", LegacySQLTypeName.INTEGER),
                Field.of("col2", LegacySQLTypeName.STRING));

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

  @Test
  public void testLoadArrowRows_multiBatchStream() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      ReadRowsResponse r1 =
          createReadRowsResponse(Arrays.asList(1, 2), Arrays.asList("item1", "item2"), allocator);
      ReadRowsResponse r2 =
          createReadRowsResponse(Arrays.asList(3, 4), Arrays.asList("item3", "item4"), allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      List<FieldValueList> rowBatch = new ArrayList<>();
      Queue<FieldValueList> buffer = new ArrayDeque<>();
      boolean hasMore =
          ArrowDeserializer.loadArrowRows(
              Arrays.asList(r1, r2).iterator(),
              arrowSchema,
              bqSchema,
              rowBatch,
              buffer,
              10L,
              0L,
              10L);

      assertFalse(hasMore);
      assertEquals(4, rowBatch.size());
      assertEquals("1", rowBatch.get(0).get("id").getStringValue());
      assertEquals("item1", rowBatch.get(0).get("name").getStringValue());
      assertEquals("4", rowBatch.get(3).get("id").getStringValue());
      assertEquals("item4", rowBatch.get(3).get("name").getStringValue());
    }
  }

  @Test
  public void testLoadArrowRows_respectsPageSize() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      ReadRowsResponse r1 =
          createReadRowsResponse(Arrays.asList(1, 2), Arrays.asList("item1", "item2"), allocator);
      ReadRowsResponse r2 =
          createReadRowsResponse(Arrays.asList(3, 4), Arrays.asList("item3", "item4"), allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      List<FieldValueList> rowBatch = new ArrayList<>();
      Queue<FieldValueList> buffer = new ArrayDeque<>();
      boolean hasMore =
          ArrowDeserializer.loadArrowRows(
              Arrays.asList(r1, r2).iterator(),
              arrowSchema,
              bqSchema,
              rowBatch,
              buffer,
              2L,
              0L,
              10L);

      assertTrue(hasMore);
      assertEquals(2, rowBatch.size());
      assertEquals("1", rowBatch.get(0).get("id").getStringValue());
      assertEquals("2", rowBatch.get(1).get("id").getStringValue());
    }
  }

  @Test
  public void testLoadArrowRows_respectsMaxResults() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      ReadRowsResponse r1 =
          createReadRowsResponse(Arrays.asList(1, 2), Arrays.asList("item1", "item2"), allocator);
      ReadRowsResponse r2 =
          createReadRowsResponse(Arrays.asList(3, 4), Arrays.asList("item3", "item4"), allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      List<FieldValueList> rowBatch = new ArrayList<>();
      Queue<FieldValueList> buffer = new ArrayDeque<>();
      boolean hasMore =
          ArrowDeserializer.loadArrowRows(
              Arrays.asList(r1, r2).iterator(),
              arrowSchema,
              bqSchema,
              rowBatch,
              buffer,
              10L,
              0L,
              3L);

      assertFalse(hasMore);
      assertEquals(3, rowBatch.size());
      assertEquals("1", rowBatch.get(0).get("id").getStringValue());
      assertEquals("2", rowBatch.get(1).get("id").getStringValue());
      assertEquals("3", rowBatch.get(2).get("id").getStringValue());
    }
  }

  @Test
  public void testLoadArrowRows_unconsumedBatchRowsSignalHasMore() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      ReadRowsResponse r1 =
          createReadRowsResponse(
              Arrays.asList(1, 2, 3, 4),
              Arrays.asList("item1", "item2", "item3", "item4"),
              allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      List<FieldValueList> rowBatch = new ArrayList<>();
      Queue<FieldValueList> buffer = new ArrayDeque<>();
      boolean hasMore =
          ArrowDeserializer.loadArrowRows(
              Arrays.asList(r1).iterator(), arrowSchema, bqSchema, rowBatch, buffer, 2L, 0L, 10L);

      assertTrue(hasMore);
      assertEquals(2, rowBatch.size());
      assertEquals("1", rowBatch.get(0).get("id").getStringValue());
      assertEquals("2", rowBatch.get(1).get("id").getStringValue());
    }
  }

  @Test
  public void testLoadArrowRows_withBuffer_spansPageBoundaryWithoutDroppingRows()
      throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      // 5 elements in a single response, requested with pageSize = 2
      ReadRowsResponse r1 =
          createReadRowsResponse(
              Arrays.asList(1, 2, 3, 4, 5),
              Arrays.asList("item1", "item2", "item3", "item4", "item5"),
              allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      Queue<FieldValueList> buffer = new ArrayDeque<>();
      Iterator<ReadRowsResponse> iterator = Arrays.asList(r1).iterator();

      // Page 1: reads 2 rows, buffers remaining 3 rows
      List<FieldValueList> page1 = new ArrayList<>();
      boolean hasMore1 =
          ArrowDeserializer.loadArrowRows(
              iterator, arrowSchema, bqSchema, page1, buffer, 2L, 0L, 10L);
      assertTrue(hasMore1);
      assertEquals(2, page1.size());
      assertEquals("1", page1.get(0).get("id").getStringValue());
      assertEquals("2", page1.get(1).get("id").getStringValue());
      assertEquals(3, buffer.size());

      // Page 2: drains 2 rows from buffer, 1 row remains in buffer
      List<FieldValueList> page2 = new ArrayList<>();
      boolean hasMore2 =
          ArrowDeserializer.loadArrowRows(
              iterator, arrowSchema, bqSchema, page2, buffer, 2L, 2L, 10L);
      assertTrue(hasMore2);
      assertEquals(2, page2.size());
      assertEquals("3", page2.get(0).get("id").getStringValue());
      assertEquals("4", page2.get(1).get("id").getStringValue());
      assertEquals(1, buffer.size());

      // Page 3: drains final 1 row from buffer, buffer is now empty and stream has no more rows
      List<FieldValueList> page3 = new ArrayList<>();
      boolean hasMore3 =
          ArrowDeserializer.loadArrowRows(
              iterator, arrowSchema, bqSchema, page3, buffer, 2L, 4L, 10L);
      assertFalse(hasMore3);
      assertEquals(1, page3.size());
      assertEquals("5", page3.get(0).get("id").getStringValue());
      assertTrue(buffer.isEmpty());
    }
  }

  @Test
  public void testLoadArrowRows_withBuffer_respectsMaxResults() throws IOException {
    try (BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE)) {
      // 5 elements in a single response, pageSize = 2, maxResults = 3
      ReadRowsResponse r1 =
          createReadRowsResponse(
              Arrays.asList(1, 2, 3, 4, 5),
              Arrays.asList("item1", "item2", "item3", "item4", "item5"),
              allocator);

      org.apache.arrow.vector.types.pojo.Schema arrowSchema = createSimpleArrowSchema();
      Schema bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

      Queue<FieldValueList> buffer = new ArrayDeque<>();
      Iterator<ReadRowsResponse> iterator = Arrays.asList(r1).iterator();

      // Page 1: reads 2 rows, buffers 1 row (capped by maxResults = 3)
      List<FieldValueList> page1 = new ArrayList<>();
      boolean hasMore1 =
          ArrowDeserializer.loadArrowRows(
              iterator, arrowSchema, bqSchema, page1, buffer, 2L, 0L, 3L);
      assertTrue(hasMore1);
      assertEquals(2, page1.size());
      assertEquals("1", page1.get(0).get("id").getStringValue());
      assertEquals("2", page1.get(1).get("id").getStringValue());
      assertEquals(1, buffer.size());

      // Page 2: drains 1 row, reaches maxResults (3 rows total)
      List<FieldValueList> page2 = new ArrayList<>();
      boolean hasMore2 =
          ArrowDeserializer.loadArrowRows(
              iterator, arrowSchema, bqSchema, page2, buffer, 2L, 2L, 3L);
      assertFalse(hasMore2);
      assertEquals(1, page2.size());
      assertEquals("3", page2.get(0).get("id").getStringValue());
      assertTrue(buffer.isEmpty());
    }
  }

  @Test
  public void testLoadArrowRows_nullSchemaThrowsException() {
    List<FieldValueList> rowBatch = new ArrayList<>();
    Queue<FieldValueList> buffer = new ArrayDeque<>();
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ArrowDeserializer.loadArrowRows(
                Arrays.<ReadRowsResponse>asList().iterator(),
                null,
                Schema.of(),
                rowBatch,
                buffer,
                10L,
                0L,
                10L));
  }

  @Test
  public void testFormatTimestampMicros() {
    // Standard positive timestamps
    assertEquals("1408452095.220000", ArrowDeserializer.formatTimestampMicros(1408452095220000L));
    assertEquals("1715000000.123456", ArrowDeserializer.formatTimestampMicros(1715000000123456L));

    // Zero timestamp
    assertEquals("0.000000", ArrowDeserializer.formatTimestampMicros(0L));

    // Sub-second positive timestamp
    assertEquals("0.000123", ArrowDeserializer.formatTimestampMicros(123L));

    // Negative timestamp close to zero
    assertEquals("-0.000123", ArrowDeserializer.formatTimestampMicros(-123L));

    // Negative timestamp across multiple seconds
    assertEquals("-1.500000", ArrowDeserializer.formatTimestampMicros(-1500000L));
    assertEquals("-10.000001", ArrowDeserializer.formatTimestampMicros(-10000001L));
  }

  private static org.apache.arrow.vector.types.pojo.Schema createSimpleArrowSchema() {
    org.apache.arrow.vector.types.pojo.Field intField =
        new org.apache.arrow.vector.types.pojo.Field(
            "id", FieldType.nullable(new ArrowType.Int(32, true)), null);
    org.apache.arrow.vector.types.pojo.Field strField =
        new org.apache.arrow.vector.types.pojo.Field(
            "name", FieldType.nullable(new ArrowType.Utf8()), null);
    return new org.apache.arrow.vector.types.pojo.Schema(ImmutableList.of(intField, strField));
  }

  private ReadRowsResponse createReadRowsResponse(
      List<Integer> ids, List<String> names, BufferAllocator allocator) throws IOException {
    IntVector intVector = new IntVector("id", allocator);
    intVector.allocateNew(ids.size());
    for (int i = 0; i < ids.size(); i++) {
      intVector.set(i, ids.get(i));
    }
    intVector.setValueCount(ids.size());

    VarCharVector nameVector = new VarCharVector("name", allocator);
    nameVector.allocateNew(names.size());
    for (int i = 0; i < names.size(); i++) {
      nameVector.set(i, names.get(i).getBytes(StandardCharsets.UTF_8));
    }
    nameVector.setValueCount(names.size());

    List<FieldVector> vectors = ImmutableList.of(intVector, nameVector);
    try (VectorSchemaRoot root = new VectorSchemaRoot(vectors)) {
      byte[] bytes = serializeVectorSchemaRoot(root, allocator);
      com.google.cloud.bigquery.storage.v1.ArrowRecordBatch protoBatch =
          com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
              .setSerializedRecordBatch(ByteString.copyFrom(bytes))
              .build();
      return ReadRowsResponse.newBuilder().setArrowRecordBatch(protoBatch).build();
    } finally {
      for (FieldVector vector : vectors) {
        vector.close();
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
