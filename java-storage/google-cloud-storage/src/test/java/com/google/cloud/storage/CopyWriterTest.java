/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_STORAGE_OPERATION;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_NOT_FOUND;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_UNAVAILABLE;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CopyWriterTest {

  private static final String SOURCE_BUCKET_NAME = "b";
  private static final String SOURCE_BLOB_NAME = "n";
  private static final String DESTINATION_BUCKET_NAME = "b1";
  private static final String DESTINATION_BLOB_NAME = "n1";
  private static final BlobId BLOB_ID = BlobId.of(SOURCE_BUCKET_NAME, SOURCE_BLOB_NAME);
  private static final BlobInfo BLOB_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME).build();
  private static final BlobInfo RESULT_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME)
          .setContentType("type")
          .build();
  private static final Map<StorageRpc.Option, ?> EMPTY_OPTIONS = ImmutableMap.of();
  private static final RewriteRequest REQUEST_WITH_OBJECT =
      new StorageRpc.RewriteRequest(
          Conversions.json().blobId().encode(BLOB_ID),
          EMPTY_OPTIONS,
          true,
          Conversions.json().blobInfo().encode(BLOB_INFO),
          EMPTY_OPTIONS,
          null);
  private static final RewriteRequest REQUEST_WITHOUT_OBJECT =
      new StorageRpc.RewriteRequest(
          Conversions.json().blobId().encode(BLOB_ID),
          EMPTY_OPTIONS,
          false,
          Conversions.json().blobInfo().encode(BLOB_INFO),
          EMPTY_OPTIONS,
          null);
  private static final RewriteResponse RESPONSE_WITH_OBJECT =
      new RewriteResponse(REQUEST_WITH_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT =
      new RewriteResponse(REQUEST_WITHOUT_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITH_OBJECT_DONE =
      new RewriteResponse(
          REQUEST_WITH_OBJECT,
          Conversions.json().blobInfo().encode(RESULT_INFO),
          42L,
          true,
          "token",
          42L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT_DONE =
      new RewriteResponse(
          REQUEST_WITHOUT_OBJECT,
          Conversions.json().blobInfo().encode(RESULT_INFO),
          42L,
          true,
          "token",
          42L);

  private HttpStorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private CopyWriter copyWriter;
  private Blob result;

  @Before
  public void setUp() {
    rpcFactoryMock = Mockito.mock(StorageRpcFactory.class);
    storageRpcMock = Mockito.mock(StorageRpc.class);
    when(rpcFactoryMock.create(any(StorageOptions.class))).thenReturn(storageRpcMock);
    options =
        HttpStorageOptions.newBuilder()
            .setProjectId("projectid")
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
    result = new Blob(options.getService(), new BlobInfo.BuilderImpl(RESULT_INFO));
    verify(rpcFactoryMock).create(any(StorageOptions.class));
  }

  @Test
  public void testRewriteWithObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testRewriteWithoutObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testRewriteWithObjectMultipleRequests() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testRewriteWithoutObjectMultipleRequests() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    copyWriter.copyChunk();
    assertTrue(!copyWriter.isDone());
    assertEquals(21L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithoutObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
    copyWriter.copyChunk();
    assertTrue(!copyWriter.isDone());
    assertEquals(21L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithResult() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    copyWriter.copyChunk();
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
    verify(storageRpcMock).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testCopyChunkPassesMetricsContext() {
    HttpStorageOptions metricsOptions =
        options.toBuilder()
            .setEnableOtelMetrics(true)
            .setMeterProvider(SdkMeterProvider.builder().build())
            .build();
    Retrier retrierMock = Mockito.mock(Retrier.class);
    copyWriter = new HttpCopyWriter(metricsOptions, RESPONSE_WITH_OBJECT, retrierMock);
    copyWriter.copyChunk();
    ArgumentCaptor<StorageMetricsContext> captor =
        ArgumentCaptor.forClass(StorageMetricsContext.class);
    verify(retrierMock).run(any(), any(), any(), captor.capture());
    StorageMetricsContext context = captor.getValue();
    assertThat(context).isNotNull();
    assertThat(context.getOperationName()).isEqualTo("RewriteObject");
    assertThat(context.shouldRecordOperationOnRetrierExit()).isFalse();
  }

  @Test
  public void testMultiChunkCopyRecordsSingleOperationAndMultipleAttempts() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITH_OBJECT_DONE);

    copyWriter =
        new HttpCopyWriter(metricsOptions, RESPONSE_WITH_OBJECT, metricsOptions.createRetrier());
    Blob copied = copyWriter.getResult();
    assertThat(copied.asBlobInfo()).isEqualTo(RESULT_INFO);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "RewriteObject"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_ATTEMPTS,
                KEY_GCP_STORAGE_OPERATION,
                "RewriteObject"))
        .isEqualTo(2L);
  }

  @Test
  public void testRestoredCopyWriterRecordsMultiStepMetrics() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITH_OBJECT_DONE);

    copyWriter =
        new HttpCopyWriter(metricsOptions, RESPONSE_WITH_OBJECT, metricsOptions.createRetrier());
    RestorableState<CopyWriter> captured = copyWriter.capture();
    CopyWriter restored = captured.restore();
    Blob copied = restored.getResult();
    assertThat(copied.asBlobInfo()).isEqualTo(RESULT_INFO);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "RewriteObject"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_ATTEMPTS,
                KEY_GCP_STORAGE_OPERATION,
                "RewriteObject"))
        .isEqualTo(2L);
  }

  @Test
  public void testCopyChunkFailureRecordsErrorOperation() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenThrow(new StorageException(503, "Service Unavailable"));

    copyWriter =
        new HttpCopyWriter(metricsOptions, RESPONSE_WITH_OBJECT, metricsOptions.createRetrier());
    assertThrows(StorageException.class, () -> copyWriter.copyChunk());

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE))
        .isEqualTo(1L);
  }

  @Test
  public void testReadChannelPreservesReadFailureOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "ReadObject");

    @SuppressWarnings("unchecked")
    ReadableByteChannelSession<ReadableByteChannel, StorageObject> sessionMock =
        Mockito.mock(ReadableByteChannelSession.class);
    ReadableByteChannel channelMock = Mockito.mock(ReadableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.read(any(ByteBuffer.class))).thenThrow(new StorageException(404, "Not Found"));

    BaseStorageReadChannel<StorageObject> readChannel =
        new BaseStorageReadChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<ReadChannel> capture() {
            return null;
          }

          @Override
          protected LazyReadChannel<?, StorageObject> newLazyReadChannel() {
            return new LazyReadChannel<>(() -> sessionMock);
          }
        };

    assertThrows(IOException.class, () -> readChannel.read(ByteBuffer.allocate(16)));
    readChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_NOT_FOUND))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testReadChannel416TreatedAsNormalEofOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "ReadObject");

    @SuppressWarnings("unchecked")
    ReadableByteChannelSession<ReadableByteChannel, StorageObject> sessionMock =
        Mockito.mock(ReadableByteChannelSession.class);
    ReadableByteChannel channelMock = Mockito.mock(ReadableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.read(any(ByteBuffer.class)))
        .thenThrow(new StorageException(416, "Range Not Satisfiable"));

    BaseStorageReadChannel<StorageObject> readChannel =
        new BaseStorageReadChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<ReadChannel> capture() {
            return null;
          }

          @Override
          protected LazyReadChannel<?, StorageObject> newLazyReadChannel() {
            return new LazyReadChannel<>(() -> sessionMock);
          }
        };

    assertThat(readChannel.read(ByteBuffer.allocate(16))).isEqualTo(-1);
    readChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(1L);
  }

  @Test
  public void testWriteChannelPreservesWriteFailureOnClose() throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    StorageClientMetrics clientMetrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(clientMetrics, "WriteObject");

    @SuppressWarnings("unchecked")
    BufferedWritableByteChannelSession<StorageObject> sessionMock =
        Mockito.mock(BufferedWritableByteChannelSession.class);
    BufferedWritableByteChannel channelMock = Mockito.mock(BufferedWritableByteChannel.class);
    when(sessionMock.open()).thenReturn(channelMock);
    when(sessionMock.getResult()).thenReturn(SettableApiFuture.create());
    when(channelMock.isOpen()).thenReturn(true);
    when(channelMock.write(any(ByteBuffer.class)))
        .thenThrow(new StorageException(503, "Service Unavailable"));

    BaseStorageWriteChannel<StorageObject> writeChannel =
        new BaseStorageWriteChannel<StorageObject>(
            Conversions.json().blobInfo(), metricsContext, clientMetrics) {
          @Override
          public RestorableState<WriteChannel> capture() {
            return null;
          }

          @Override
          protected LazyWriteChannel<StorageObject> newLazyWriteChannel() {
            return new LazyWriteChannel<>(() -> sessionMock);
          }
        };

    assertThrows(IOException.class, () -> writeChannel.write(ByteBuffer.wrap(new byte[] {1, 2})));
    writeChannel.close();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics, METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK))
        .isEqualTo(0L);
  }

  @Test
  public void testStorageImplPaginationRecordsSingleOperationAcrossPages() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    Storage storage = metricsOptions.getService();

    StorageObject obj1 = Conversions.json().blobInfo().encode(BLOB_INFO);
    StorageObject obj2 = Conversions.json().blobInfo().encode(RESULT_INFO);
    when(storageRpcMock.list(eq(DESTINATION_BUCKET_NAME), anyMap()))
        .thenReturn(Tuple.of("page-2", ImmutableList.of(obj1)))
        .thenReturn(Tuple.of(null, ImmutableList.of(obj2)));

    Page<Blob> firstPage = storage.list(DESTINATION_BUCKET_NAME);
    Page<Blob> secondPage = firstPage.getNextPage();
    assertThat(secondPage).isNotNull();

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "ListObjects"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_ATTEMPTS,
                KEY_GCP_STORAGE_OPERATION,
                "ListObjects"))
        .isEqualTo(2L);
  }

  @Test
  public void testStorageImplPcuSubOperationsDoNotEmitTopLevelOperations() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    HttpStorageOptions metricsOptions =
        options.toBuilder().setEnableOtelMetrics(true).setMeterProvider(meterProvider).build();
    StorageImpl storage = (StorageImpl) metricsOptions.getService();

    StorageObject encodedResult = Conversions.json().blobInfo().encode(RESULT_INFO);
    when(storageRpcMock.create(any(StorageObject.class), any(InputStream.class), anyMap()))
        .thenReturn(encodedResult);
    when(storageRpcMock.get(any(StorageObject.class), anyMap())).thenReturn(encodedResult);
    when(storageRpcMock.delete(any(StorageObject.class), anyMap())).thenReturn(true);

    storage.create(BLOB_INFO, new byte[] {1, 2, 3});
    storage.internalDirectUpload(BLOB_INFO, Opts.empty(), ByteBuffer.wrap(new byte[] {4, 5}));
    storage.internalObjectGet(BLOB_ID, Opts.empty());
    storage.internalObjectDelete(BLOB_ID, Opts.empty());

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "WriteObject"))
        .isEqualTo(1L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "GetObject"))
        .isEqualTo(0L);
    assertThat(
            getCounterValueWithAttr(
                metrics,
                METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
                KEY_GCP_STORAGE_OPERATION,
                "DeleteObject"))
        .isEqualTo(0L);
  }

  private static long getCounterValueWithAttr(
      Collection<MetricData> metrics,
      String metricName,
      AttributeKey<String> key,
      String expectedValue) {
    for (MetricData md : metrics) {
      if (md.getName().equals(metricName) || md.getName().equals(metricName.replace(".", "/"))) {
        return md.getLongSumData().getPoints().stream()
            .filter(p -> expectedValue.equals(p.getAttributes().get(key)))
            .mapToLong(LongPointData::getValue)
            .sum();
      }
    }
    return 0L;
  }
}
