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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.ReadStream;
import com.google.cloud.bigquery.storage.v1.stub.EnhancedBigQueryReadStub;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrowQueryResultTest {

  private BufferAllocator testAllocator;

  @BeforeEach
  void setUp() {
    testAllocator = new RootAllocator(Long.MAX_VALUE);
  }

  @AfterEach
  void tearDown() {
    testAllocator.close();
  }

  private Schema createTestArrowSchema() {
    Field idField =
        new Field("id", FieldType.nullable(new ArrowType.Int(64, true)), ImmutableList.of());
    Field nameField =
        new Field("name", FieldType.nullable(new ArrowType.Utf8()), ImmutableList.of());
    return new Schema(ImmutableList.of(idField, nameField));
  }

  private byte[] createTestBatchBytes(List<Long> ids, List<String> names) throws IOException {
    BigIntVector idVector = new BigIntVector("id", testAllocator);
    idVector.allocateNew(ids.size());
    for (int i = 0; i < ids.size(); i++) {
      if (ids.get(i) != null) {
        idVector.set(i, ids.get(i));
      } else {
        idVector.setNull(i);
      }
    }
    idVector.setValueCount(ids.size());

    VarCharVector nameVector = new VarCharVector("name", testAllocator);
    nameVector.allocateNew(names.size());
    for (int i = 0; i < names.size(); i++) {
      if (names.get(i) != null) {
        nameVector.set(i, names.get(i).getBytes(StandardCharsets.UTF_8));
      } else {
        nameVector.setNull(i);
      }
    }
    nameVector.setValueCount(names.size());

    VectorSchemaRoot root = new VectorSchemaRoot(ImmutableList.of(idVector, nameVector));
    VectorUnloader unloader = new VectorUnloader(root);
    ArrowRecordBatch recordBatch = unloader.getRecordBatch();

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    WriteChannel channel = new WriteChannel(Channels.newChannel(out));
    MessageSerializer.serialize(channel, recordBatch);

    recordBatch.close();
    root.close();
    return out.toByteArray();
  }

  private BigQueryReadClient createMockReadClient(
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable) {
    BigQueryReadClient mockClient = mock(BigQueryReadClient.class);
    EnhancedBigQueryReadStub mockStub = mock(EnhancedBigQueryReadStub.class);
    BigQueryReadSettings mockSettings = mock(BigQueryReadSettings.class);
    try {
      java.lang.reflect.Field settingsField = BigQueryReadClient.class.getDeclaredField("settings");
      settingsField.setAccessible(true);
      settingsField.set(mockClient, mockSettings);

      java.lang.reflect.Field stubField = BigQueryReadClient.class.getDeclaredField("stub");
      stubField.setAccessible(true);
      stubField.set(mockClient, mockStub);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
    when(mockStub.readRowsCallable()).thenReturn(mockCallable);
    return mockClient;
  }

  @Test
  void testSingleBatchIteration() throws IOException {
    Schema arrowSchema = createTestArrowSchema();
    byte[] batchBytes =
        createTestBatchBytes(ImmutableList.of(1L, 2L), ImmutableList.of("Alice", "Bob"));
    JobId jobId = JobId.of("test-project", "job_123");

    try (ArrowQueryResult result =
        new ArrowQueryResultImpl(arrowSchema, jobId, 2L, batchBytes, null, null)) {
      assertEquals(arrowSchema, result.getArrowSchema());
      assertEquals(jobId, result.getJobId());
      assertEquals(2L, result.getTotalRows());

      Iterator<VectorSchemaRoot> it = result.iterator();
      assertTrue(it.hasNext());
      VectorSchemaRoot root = it.next();
      assertEquals(2, root.getRowCount());
      BigIntVector idVec = (BigIntVector) root.getVector("id");
      assertEquals(1L, idVec.get(0));
      assertEquals(2L, idVec.get(1));

      assertFalse(it.hasNext());
      assertThrows(NoSuchElementException.class, it::next);
    }
  }

  @Test
  void testIteratorCannotBeCreatedTwice() throws IOException {
    Schema arrowSchema = createTestArrowSchema();
    byte[] batchBytes = createTestBatchBytes(ImmutableList.of(1L), ImmutableList.of("Alice"));

    try (ArrowQueryResult result =
        new ArrowQueryResultImpl(arrowSchema, JobId.of("j1"), 1L, batchBytes, null, null)) {
      Iterator<VectorSchemaRoot> it1 = result.iterator();
      assertNotNull(it1);
      assertThrows(IllegalStateException.class, result::iterator);
    }
  }

  @Test
  void testCloseIsIdempotentAndReleasesResources() throws IOException {
    Schema arrowSchema = createTestArrowSchema();
    byte[] batchBytes = createTestBatchBytes(ImmutableList.of(1L), ImmutableList.of("Alice"));

    ArrowQueryResult result =
        new ArrowQueryResultImpl(arrowSchema, JobId.of("j1"), 1L, batchBytes, null, null);
    result.close();
    result.close();
    assertThrows(IllegalStateException.class, result::iterator);
  }

  @Test
  void testMultiBatchStreaming() throws IOException {
    Schema arrowSchema = createTestArrowSchema();
    byte[] initialBatchBytes =
        createTestBatchBytes(ImmutableList.of(1L, 2L), ImmutableList.of("A", "B"));
    byte[] streamingBatchBytes =
        createTestBatchBytes(ImmutableList.of(3L, 4L, 5L), ImmutableList.of("C", "D", "E"));

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class);

    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream = mock(ServerStream.class);
    when(mockCallable.call(any(ReadRowsRequest.class))).thenReturn(mockServerStream);

    com.google.cloud.bigquery.storage.v1.ArrowRecordBatch protoBatch =
        com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(ByteString.copyFrom(streamingBatchBytes))
            .build();
    ReadRowsResponse streamResponse =
        ReadRowsResponse.newBuilder().setArrowRecordBatch(protoBatch).build();

    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(streamResponse).iterator());

    BigQueryReadClient mockClient = createMockReadClient(mockCallable);

    String streamName = "projects/p/locations/l/jobs/j/streams/_default";
    try (ArrowQueryResult result =
        new ArrowQueryResultImpl(
            arrowSchema, JobId.of("j"), 5L, initialBatchBytes, streamName, mockClient)) {
      Iterator<VectorSchemaRoot> it = result.iterator();

      // Batch 1 (initial REST response)
      assertTrue(it.hasNext());
      VectorSchemaRoot root1 = it.next();
      assertEquals(2, root1.getRowCount());

      // Batch 2 (streaming gRPC response)
      assertTrue(it.hasNext());
      VectorSchemaRoot root2 = it.next();
      assertEquals(3, root2.getRowCount());

      assertFalse(it.hasNext());
      assertThrows(NoSuchElementException.class, it::next);
    }
  }

  @Test
  void testQueryIdAndJobCreationReason() throws IOException {
    Schema schema = createTestArrowSchema();
    byte[] batch1 = createTestBatchBytes(ImmutableList.of(1L), ImmutableList.of("Alice"));
    JobId jobId = JobId.of("p", "j");
    String queryId = "query-12345";
    JobCreationReason reason =
        JobCreationReason.fromPb(
            new com.google.api.services.bigquery.model.JobCreationReason().setCode("REQUESTED"));

    ArrowQueryResultImpl result =
        new ArrowQueryResultImpl(schema, jobId, queryId, reason, 1L, batch1, null, null);

    assertEquals(queryId, result.getQueryId());
    assertNotNull(result.getJobCreationReason());
    assertEquals(JobCreationReason.Code.REQUESTED, result.getJobCreationReason().getCode());
    assertEquals(jobId, result.getJobId());

    try (ArrowQueryResult res = result) {
      Iterator<VectorSchemaRoot> it = result.iterator();
      assertTrue(it.hasNext());
      VectorSchemaRoot root = it.next();
      assertEquals(1, root.getRowCount());
      assertFalse(it.hasNext());
    }
  }

  @Test
  void testStatelessSingleBatchIterationWithoutJobId() throws IOException {
    Schema schema = createTestArrowSchema();
    byte[] batch1 =
        createTestBatchBytes(ImmutableList.of(1L, 2L), ImmutableList.of("Alice", "Bob"));

    ArrowQueryResultImpl result =
        new ArrowQueryResultImpl(
            schema,
            /* jobId= */ null,
            /* queryId= */ "stateless-q-1",
            /* jobCreationReason= */ null,
            2L,
            batch1,
            /* streamName= */ null,
            /* readClient= */ null);

    assertNull(result.getJobId());
    assertEquals("stateless-q-1", result.getQueryId());
    assertNull(result.getJobCreationReason());

    try (ArrowQueryResult res = result) {
      Iterator<VectorSchemaRoot> it = result.iterator();
      assertTrue(it.hasNext());
      VectorSchemaRoot root = it.next();
      assertEquals(2, root.getRowCount());
      assertFalse(it.hasNext());
    }
  }

  @Test
  void testFromReadSessionFallback() throws IOException {
    Schema schema = createTestArrowSchema();
    byte[] batch1 = createTestBatchBytes(ImmutableList.of(10L), ImmutableList.of("FallbackUser"));

    ByteArrayOutputStream schemaOut = new ByteArrayOutputStream();
    WriteChannel schemaChannel = new WriteChannel(Channels.newChannel(schemaOut));
    MessageSerializer.serialize(schemaChannel, schema);

    ArrowSchema arrowSchemaPb =
        ArrowSchema.newBuilder()
            .setSerializedSchema(ByteString.copyFrom(schemaOut.toByteArray()))
            .build();
    ReadStream streamPb =
        ReadStream.newBuilder().setName("projects/p/locations/l/sessions/s/streams/str1").build();
    ReadSession readSession =
        ReadSession.newBuilder().setArrowSchema(arrowSchemaPb).addStreams(streamPb).build();

    ReadRowsResponse response =
        ReadRowsResponse.newBuilder()
            .setArrowRecordBatch(
                com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
                    .setSerializedRecordBatch(ByteString.copyFrom(batch1))
                    .build())
            .build();

    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream = mock(ServerStream.class);
    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(response).iterator());

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class);
    when(mockCallable.call(any(ReadRowsRequest.class))).thenReturn(mockServerStream);

    BigQueryReadClient mockReadClient = createMockReadClient(mockCallable);

    JobId jobId = JobId.of("p", "fallback-job");
    ArrowQueryResultImpl result =
        ArrowQueryResultImpl.fromReadSession(readSession, jobId, mockReadClient);

    assertEquals(jobId, result.getJobId());
    assertNull(result.getQueryId());
    assertNull(result.getJobCreationReason());

    try (ArrowQueryResult res = result) {
      Iterator<VectorSchemaRoot> it = result.iterator();
      assertTrue(it.hasNext());
      VectorSchemaRoot root = it.next();
      assertEquals(1, root.getRowCount());
      BigIntVector idVector = (BigIntVector) root.getVector("id");
      assertEquals(10L, idVector.get(0));
      assertFalse(it.hasNext());
    }
  }
}
