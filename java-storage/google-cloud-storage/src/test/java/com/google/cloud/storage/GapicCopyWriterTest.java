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

package com.google.cloud.storage;

import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_UNAVAILABLE;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.storage.v2.Object;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.stub.StorageStub;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

public final class GapicCopyWriterTest {

  private static final String BUCKET = "test-bucket";
  private static final String OBJECT = "test-object";
  private static final RewriteObjectRequest REQUEST =
      RewriteObjectRequest.newBuilder()
          .setSourceBucket("projects/_/buckets/" + BUCKET)
          .setSourceObject(OBJECT)
          .setDestinationBucket("projects/_/buckets/" + BUCKET)
          .setDestinationName("test-dest")
          .build();
  private static final Object RESOURCE =
      Object.newBuilder()
          .setBucket("projects/_/buckets/" + BUCKET)
          .setName("test-dest")
          .setGeneration(1L)
          .build();
  private static final RewriteResponse NOT_DONE_RESPONSE =
      RewriteResponse.newBuilder()
          .setDone(false)
          .setObjectSize(100L)
          .setTotalBytesRewritten(50L)
          .setRewriteToken("token-1")
          .build();
  private static final RewriteResponse DONE_RESPONSE =
      RewriteResponse.newBuilder()
          .setDone(true)
          .setObjectSize(100L)
          .setTotalBytesRewritten(100L)
          .setResource(RESOURCE)
          .build();

  private InMemoryMetricReader reader;
  private StorageClientMetrics metrics;
  private GrpcStorageImpl storage;
  private UnaryCallable<RewriteObjectRequest, RewriteResponse> callable;
  private RetrierWithAlg retrier;

  @Before
  @SuppressWarnings("unchecked")
  public void setUp() {
    reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    GrpcStorageOptions options =
        GrpcStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .build();
    metrics = options.getStorageClientMetrics();

    StorageStub storageStub = mock(StorageStub.class);
    StorageClient storageClient = StorageClient.create(storageStub);
    storage =
        new GrpcStorageImpl(
            options,
            storageClient,
            null,
            ResponseContentLifecycleManager.noop(),
            null,
            options.createRetrier(),
            Opts.empty());

    callable = mock(UnaryCallable.class);
    retrier = Retrier.attemptOnce().withAlg(Retrying.neverRetry());
  }

  @Test
  public void copyChunk_doesNotDoubleRecordOperationCompletionWhenDone() {
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(metrics, "RewriteObject");
    when(callable.call(any(RewriteObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(DONE_RESPONSE);

    GapicCopyWriter writer =
        new GapicCopyWriter(storage, callable, retrier, REQUEST, NOT_DONE_RESPONSE, metricsContext);

    writer.copyChunk();
    assertThat(writer.isDone()).isTrue();
    assertOperationCount(STATUS_OK, 1L);

    // Subsequent copyChunk should be a no-op and not record another operation
    writer.copyChunk();
    assertOperationCount(STATUS_OK, 1L);

    // getResult should return blob and not record another operation
    Blob blob = writer.getResult();
    assertThat(blob).isNotNull();
    assertOperationCount(STATUS_OK, 1L);
  }

  @Test
  public void getResult_doesNotDoubleRecordWhenInitialResponseIsAlreadyDone() {
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createMultiStepContext(metrics, "RewriteObject");

    GapicCopyWriter writer =
        new GapicCopyWriter(storage, callable, retrier, REQUEST, DONE_RESPONSE, metricsContext);

    assertThat(writer.isDone()).isTrue();
    Blob blob = writer.getResult();
    assertThat(blob).isNotNull();
    assertNoOperationsRecorded();
  }

  @Test
  public void whenMetricsContextIsNull_internalChunksDoNotEmitTopLevelOperationMetrics() {
    when(callable.call(any(RewriteObjectRequest.class), any(GrpcCallContext.class)))
        .thenReturn(DONE_RESPONSE);

    GapicCopyWriter writer =
        new GapicCopyWriter(storage, callable, retrier, REQUEST, NOT_DONE_RESPONSE, null);

    writer.copyChunk();
    assertThat(writer.isDone()).isTrue();
    Blob blob = writer.getResult();
    assertThat(blob).isNotNull();

    assertNoOperationsRecorded();
  }

  @Test
  public void errorsInCopyChunk_recordFailureOnMetricsContext() {
    StorageMetricsContext metricsContext =
        StorageClientMetrics.createContext(metrics, "RewriteObject");
    when(callable.call(any(RewriteObjectRequest.class), any(GrpcCallContext.class)))
        .thenThrow(new StorageException(503, "Service Unavailable"));

    GapicCopyWriter writer =
        new GapicCopyWriter(storage, callable, retrier, REQUEST, NOT_DONE_RESPONSE, metricsContext);

    assertThrows(StorageException.class, writer::copyChunk);
    assertOperationCount(STATUS_UNAVAILABLE, 1L);
  }

  private void assertOperationCount(String errorType, long expectedCount) {
    Collection<MetricData> collected = reader.collectAllMetrics();
    long count = 0;
    for (MetricData md : collected) {
      if (md.getName().equals(METRIC_GCP_STORAGE_CLIENT_OPERATIONS)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          String val = point.getAttributes().get(KEY_ERROR_TYPE);
          if (errorType.equals(val)) {
            count += point.getValue();
          }
        }
      }
    }
    assertThat(count).isEqualTo(expectedCount);
  }

  private void assertNoOperationsRecorded() {
    Collection<MetricData> collected = reader.collectAllMetrics();
    long count = 0;
    for (MetricData md : collected) {
      if (md.getName().equals(METRIC_GCP_STORAGE_CLIENT_OPERATIONS)) {
        for (LongPointData point : md.getLongSumData().getPoints()) {
          count += point.getValue();
        }
      }
    }
    assertThat(count).isEqualTo(0L);
  }
}
