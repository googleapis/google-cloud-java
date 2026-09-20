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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.Channels;
import java.util.Collections;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ArrowQueryPageFetcherTest {

  private static final String PROJECT = "test-project";
  private static final String LOCATION = "US";
  private static final String JOB = "test-job";

  private BufferAllocator allocator;
  private org.apache.arrow.vector.types.pojo.Schema arrowSchema;
  private Schema bqSchema;
  private byte[] schemaBytes;

  @BeforeEach
  void setUp() throws IOException {
    allocator = new RootAllocator(Long.MAX_VALUE);
    arrowSchema =
        new org.apache.arrow.vector.types.pojo.Schema(
            ImmutableList.of(
                org.apache.arrow.vector.types.pojo.Field.nullable(
                    "id", new ArrowType.Int(64, true))));
    bqSchema = ArrowPojoUtils.arrowSchemaToBigQuerySchema(arrowSchema);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), arrowSchema);
      schemaBytes = out.toByteArray();
    }
  }

  @AfterEach
  void tearDown() {
    allocator.close();
  }

  private byte[] createBatchBytes(List<Long> values) throws IOException {
    BigIntVector idVector = new BigIntVector("id", allocator);
    idVector.allocateNew(values.size());
    for (int i = 0; i < values.size(); i++) {
      idVector.set(i, values.get(i));
    }
    idVector.setValueCount(values.size());

    try (VectorSchemaRoot root = new VectorSchemaRoot(ImmutableList.of(idVector))) {
      VectorUnloader unloader = new VectorUnloader(root);
      try (ArrowRecordBatch recordBatch = unloader.getRecordBatch();
          ByteArrayOutputStream out = new ByteArrayOutputStream()) {
        WriteChannel channel = new WriteChannel(Channels.newChannel(out));
        MessageSerializer.serialize(channel, recordBatch);
        return out.toByteArray();
      }
    } finally {
      idVector.close();
    }
  }

  private BigQueryReadClient createMockReadClient(
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable) {
    BigQueryReadClient mockClient =
        mock(BigQueryReadClient.class, withSettings().withoutAnnotations());
    when(mockClient.readRowsCallable()).thenReturn(mockCallable);
    return mockClient;
  }

  @Test
  void testGetNextPage_singlePage() throws IOException {
    byte[] batchBytes = createBatchBytes(ImmutableList.of(10L, 20L));
    com.google.cloud.bigquery.storage.v1.ArrowRecordBatch protoBatch =
        com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
            .setSerializedRecordBatch(ByteString.copyFrom(batchBytes))
            .build();
    ReadRowsResponse response =
        ReadRowsResponse.newBuilder().setArrowRecordBatch(protoBatch).build();

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class, withSettings().withoutAnnotations());
    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream =
        mock(ServerStream.class, withSettings().withoutAnnotations());
    when(mockCallable.call(any(ReadRowsRequest.class))).thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(response).iterator());

    BigQueryReadClient mockReadClient = createMockReadClient(mockCallable);

    BigQueryOptions options =
        BigQueryOptions.newBuilder().setProjectId(PROJECT).setLocation(LOCATION).build();
    BigQuery service = options.getService();
    ((BigQueryImpl) service).setBigQueryReadClient(mockReadClient);

    JobId jobId = JobId.of(PROJECT, JOB).toBuilder().setLocation(LOCATION).build();
    BigQueryImpl.ArrowQueryPageFetcher fetcher =
        new BigQueryImpl.ArrowQueryPageFetcher(
            jobId,
            bqSchema,
            schemaBytes,
            arrowSchema,
            options,
            /* initialRowOffset= */ 0L,
            /* maxResults= */ 10L,
            Collections.emptyMap());

    Page<FieldValueList> page = fetcher.getNextPage();
    assertNotNull(page);
    List<FieldValueList> rows = ImmutableList.copyOf(page.getValues());
    assertEquals(2, rows.size());
    assertEquals("10", rows.get(0).get(0).getStringValue());
    assertEquals("20", rows.get(1).get(0).getStringValue());
    assertNull(page.getNextPageToken());
    assertFalse(page.hasNextPage());

    verify(mockCallable).call(any(ReadRowsRequest.class));
  }

  @Test
  void testGetNextPage_multiplePagesWithPageSizeOption() throws IOException {
    byte[] batch1Bytes = createBatchBytes(ImmutableList.of(1L, 2L));
    byte[] batch2Bytes = createBatchBytes(ImmutableList.of(3L, 4L));

    ReadRowsResponse resp1 =
        ReadRowsResponse.newBuilder()
            .setArrowRecordBatch(
                com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
                    .setSerializedRecordBatch(ByteString.copyFrom(batch1Bytes))
                    .build())
            .build();
    ReadRowsResponse resp2 =
        ReadRowsResponse.newBuilder()
            .setArrowRecordBatch(
                com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
                    .setSerializedRecordBatch(ByteString.copyFrom(batch2Bytes))
                    .build())
            .build();

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class, withSettings().withoutAnnotations());
    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream =
        mock(ServerStream.class, withSettings().withoutAnnotations());
    when(mockCallable.call(any(ReadRowsRequest.class))).thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(resp1, resp2).iterator());

    BigQueryReadClient mockReadClient = createMockReadClient(mockCallable);

    BigQueryOptions options =
        BigQueryOptions.newBuilder().setProjectId(PROJECT).setLocation(LOCATION).build();
    BigQuery service = options.getService();
    ((BigQueryImpl) service).setBigQueryReadClient(mockReadClient);

    JobId jobId = JobId.of(PROJECT, JOB).toBuilder().setLocation(LOCATION).build();
    BigQueryImpl.ArrowQueryPageFetcher fetcher =
        new BigQueryImpl.ArrowQueryPageFetcher(
            jobId,
            bqSchema,
            schemaBytes,
            arrowSchema,
            options,
            /* initialRowOffset= */ 0L,
            /* maxResults= */ 10L,
            ImmutableMap.of(BigQueryRpc.Option.MAX_RESULTS, 2L));

    Page<FieldValueList> page1 = fetcher.getNextPage();
    assertNotNull(page1);
    List<FieldValueList> page1Rows = ImmutableList.copyOf(page1.getValues());
    assertEquals(2, page1Rows.size());
    assertEquals("1", page1Rows.get(0).get(0).getStringValue());
    assertEquals("2", page1Rows.get(1).get(0).getStringValue());
    assertTrue(page1.hasNextPage());
    assertEquals("2", page1.getNextPageToken());

    Page<FieldValueList> page2 = page1.getNextPage();
    assertNotNull(page2);
    List<FieldValueList> page2Rows = ImmutableList.copyOf(page2.getValues());
    assertEquals(2, page2Rows.size());
    assertEquals("3", page2Rows.get(0).get(0).getStringValue());
    assertEquals("4", page2Rows.get(1).get(0).getStringValue());
    assertFalse(page2.hasNextPage());
    assertNull(page2.getNextPageToken());
    assertNull(page2.getNextPage());
  }

  @Test
  void testGetNextPage_respectsMaxResults() throws IOException {
    byte[] batchBytes = createBatchBytes(ImmutableList.of(1L, 2L, 3L));
    ReadRowsResponse resp =
        ReadRowsResponse.newBuilder()
            .setArrowRecordBatch(
                com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
                    .setSerializedRecordBatch(ByteString.copyFrom(batchBytes))
                    .build())
            .build();

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class, withSettings().withoutAnnotations());
    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream =
        mock(ServerStream.class, withSettings().withoutAnnotations());
    when(mockCallable.call(any(ReadRowsRequest.class))).thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(resp).iterator());

    BigQueryReadClient mockReadClient = createMockReadClient(mockCallable);

    BigQueryOptions options =
        BigQueryOptions.newBuilder().setProjectId(PROJECT).setLocation(LOCATION).build();
    BigQuery service = options.getService();
    ((BigQueryImpl) service).setBigQueryReadClient(mockReadClient);

    JobId jobId = JobId.of(PROJECT, JOB).toBuilder().setLocation(LOCATION).build();
    // initialRowOffset = 1, maxResults = 2 -> only 1 more row allowed
    BigQueryImpl.ArrowQueryPageFetcher fetcher =
        new BigQueryImpl.ArrowQueryPageFetcher(
            jobId,
            bqSchema,
            schemaBytes,
            arrowSchema,
            options,
            /* initialRowOffset= */ 1L,
            /* maxResults= */ 2L,
            Collections.emptyMap());

    Page<FieldValueList> page = fetcher.getNextPage();
    assertNotNull(page);
    List<FieldValueList> rows = ImmutableList.copyOf(page.getValues());
    assertEquals(1, rows.size());
    assertEquals("1", rows.get(0).get(0).getStringValue());
    assertFalse(page.hasNextPage());
    assertNull(page.getNextPageToken());
    assertNull(page.getNextPage());
  }

  @Test
  void testGetNextPage_missingLocationDefaultsToGlobal() throws IOException {
    byte[] batchBytes = createBatchBytes(ImmutableList.of(10L));
    ReadRowsResponse response =
        ReadRowsResponse.newBuilder()
            .setArrowRecordBatch(
                com.google.cloud.bigquery.storage.v1.ArrowRecordBatch.newBuilder()
                    .setSerializedRecordBatch(ByteString.copyFrom(batchBytes))
                    .build())
            .build();

    @SuppressWarnings("unchecked")
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> mockCallable =
        mock(ServerStreamingCallable.class, withSettings().withoutAnnotations());
    @SuppressWarnings("unchecked")
    ServerStream<ReadRowsResponse> mockServerStream =
        mock(ServerStream.class, withSettings().withoutAnnotations());
    ArgumentCaptor<ReadRowsRequest> requestCapture = ArgumentCaptor.forClass(ReadRowsRequest.class);
    when(mockCallable.call(requestCapture.capture())).thenReturn(mockServerStream);
    when(mockServerStream.iterator()).thenReturn(ImmutableList.of(response).iterator());

    BigQueryReadClient mockReadClient = createMockReadClient(mockCallable);

    BigQueryOptions options = BigQueryOptions.newBuilder().setProjectId(PROJECT).build();
    BigQuery service = options.getService();
    ((BigQueryImpl) service).setBigQueryReadClient(mockReadClient);

    JobId jobId = JobId.of(PROJECT, JOB); // No location set on JobId or options

    BigQueryImpl.ArrowQueryPageFetcher fetcher =
        new BigQueryImpl.ArrowQueryPageFetcher(
            jobId,
            bqSchema,
            schemaBytes,
            arrowSchema,
            options,
            /* initialRowOffset= */ 0L,
            /* maxResults= */ 10L,
            Collections.emptyMap());

    Page<FieldValueList> page = fetcher.getNextPage();
    assertNotNull(page);
    assertEquals(
        "projects/" + PROJECT + "/locations/global/jobs/" + JOB + "/streams/_default",
        requestCapture.getValue().getReadStream());
  }

  @Test
  void testSerialization() throws Exception {
    BigQueryOptions options =
        BigQueryOptions.newBuilder().setProjectId(PROJECT).setLocation(LOCATION).build();
    JobId jobId = JobId.of(PROJECT, JOB).toBuilder().setLocation(LOCATION).build();

    BigQueryImpl.ArrowQueryPageFetcher fetcher =
        new BigQueryImpl.ArrowQueryPageFetcher(
            jobId,
            bqSchema,
            schemaBytes,
            arrowSchema,
            options,
            /* initialRowOffset= */ 10L,
            /* maxResults= */ 10L,
            Collections.emptyMap());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(fetcher);
    }

    BigQueryImpl.ArrowQueryPageFetcher deserializedFetcher;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedFetcher = (BigQueryImpl.ArrowQueryPageFetcher) ois.readObject();
    }

    assertNotNull(deserializedFetcher);
    java.lang.reflect.Field bufferField =
        BigQueryImpl.ArrowQueryPageFetcher.class.getDeclaredField("buffer");
    bufferField.setAccessible(true);
    assertNull(bufferField.get(deserializedFetcher));

    // Calling getNextPage() lazily initializes the transient buffer without throwing NPE
    assertNull(deserializedFetcher.getNextPage());
    assertNotNull(bufferField.get(deserializedFetcher));
  }
}
