/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public final class GapicUnbufferedReadableByteChannelTest {

  @Test
  public void ensureResponseAreClosed() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    AtomicBoolean close = new AtomicBoolean(false);

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        resp -> ResponseContentLifecycleHandle.create(resp, () -> close.compareAndSet(false, true));

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.noop(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      c.read(buffer);
      assertThat(xxd(buffer)).isEqualTo(xxd(testContent.getBytes()));
      assertThat(close.get()).isTrue();
    }
  }

  @Test
  public void validateCumulativeChecksum_success() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(ObjectChecksums.newBuilder().setCrc32C(testContent.getCrc32c()).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(new ByteBuffer[] {buffer}, 0, 1);
      assertThat(read).isEqualTo(testContent.length());
      assertThat(xxd(buffer)).isEqualTo(xxd(testContent.getBytes()));
    }
  }

  @Test
  public void validateCumulativeChecksum_failure() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(
                ObjectChecksums.newBuilder().setCrc32C(testContent.getCrc32c() + 1).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      IOException exception = assertThrows(IOException.class, () -> c.read(buffer));
      assertThat(exception.getCause()).isInstanceOf(StorageException.class);
      assertThat(exception.getCause().getCause())
          .isInstanceOf(UncheckedCumulativeChecksumMismatchException.class);
    }
  }

  @Test
  public void validateCumulativeChecksum_disabled_noFailureOnMismatch() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(
                ObjectChecksums.newBuilder().setCrc32C(testContent.getCrc32c() + 1).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.noop(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(new ByteBuffer[] {buffer}, 0, 1);
      assertThat(read).isEqualTo(testContent.length());
      assertThat(xxd(buffer)).isEqualTo(xxd(testContent.getBytes()));
    }
  }

  public void validateCumulativeChecksum_skippedForRangedRead() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(
                ObjectChecksums.newBuilder().setCrc32C(testContent.getCrc32c() + 1).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    ReadObjectRequest req = ReadObjectRequest.newBuilder().setReadLimit(5).build();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.slice(0, 5).asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            req,
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(buffer);
      assertThat(read).isEqualTo(5);
      assertThat(xxd(buffer)).isEqualTo(xxd(testContent.slice(0, 5).getBytes()));
    }
  }

  @Test
  public void validateCumulativeChecksum_multipleChunks_success() throws IOException {
    ChecksummedTestContent chunk1 = ChecksummedTestContent.of("abcde".getBytes());
    ChecksummedTestContent chunk2 = ChecksummedTestContent.of("fghij".getBytes());
    ChecksummedTestContent chunk3 = ChecksummedTestContent.of("klmno".getBytes());
    byte[] fullBytes = "abcdefghijklmno".getBytes();
    ChecksummedTestContent fullContent = ChecksummedTestContent.of(fullBytes);

    Object metadata =
        Object.newBuilder()
            .setSize(fullContent.length())
            .setChecksums(ObjectChecksums.newBuilder().setCrc32C(fullContent.getCrc32c()).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    new Thread(
                            () -> {
                              try {
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk1.asChecksummedData())
                                        .build());
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk2.asChecksummedData())
                                        .build());
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk3.asChecksummedData())
                                        .setMetadata(metadata)
                                        .build());
                                respond.onComplete();
                              } catch (Throwable t) {
                                respond.onError(t);
                              }
                            })
                        .start();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(20);
      int read = (int) c.read(new ByteBuffer[] {buffer}, 0, 1);
      assertThat(read).isEqualTo(15);
      assertThat(xxd(buffer)).isEqualTo(xxd(fullContent.getBytes()));
    }
  }

  @Test
  public void validateCumulativeChecksum_multipleChunks_failure() throws IOException {
    ChecksummedTestContent chunk1 = ChecksummedTestContent.of("abcde".getBytes());
    ChecksummedTestContent chunk2 = ChecksummedTestContent.of("fghij".getBytes());
    ChecksummedTestContent chunk3 = ChecksummedTestContent.of("klmno".getBytes());
    byte[] fullBytes = "abcdefghijklmno".getBytes();
    ChecksummedTestContent fullContent = ChecksummedTestContent.of(fullBytes);

    Object metadata =
        Object.newBuilder()
            .setSize(fullContent.length())
            .setChecksums(
                ObjectChecksums.newBuilder().setCrc32C(fullContent.getCrc32c() + 1).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    new Thread(
                            () -> {
                              try {
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk1.asChecksummedData())
                                        .build());
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk2.asChecksummedData())
                                        .build());
                                respond.onResponse(
                                    ReadObjectResponse.newBuilder()
                                        .setChecksummedData(chunk3.asChecksummedData())
                                        .setMetadata(metadata)
                                        .build());
                                respond.onComplete();
                              } catch (Throwable t) {
                                respond.onError(t);
                              }
                            })
                        .start();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(20);
      IOException exception =
          assertThrows(
              IOException.class,
              () -> {
                c.read(new ByteBuffer[] {buffer}, 0, 1);
              });
      assertThat(exception.getCause()).isInstanceOf(StorageException.class);
      assertThat(exception.getCause().getCause())
          .isInstanceOf(UncheckedCumulativeChecksumMismatchException.class);
    }
  }

  @Test
  public void validateCumulativeChecksum_metadataMissingCrc32c_skipped() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(ObjectChecksums.newBuilder().build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(buffer);
      assertThat(read).isEqualTo(10);
    }
  }

  @Test
  public void validateCumulativeChecksum_nonZeroOffset_skipped() throws IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(10));

    Object metadata =
        Object.newBuilder()
            .setSize(testContent.length())
            .setChecksums(
                ObjectChecksums.newBuilder().setCrc32C(testContent.getCrc32c() + 1).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    ReadObjectRequest req = ReadObjectRequest.newBuilder().setReadOffset(5).build();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder()
                            .setChecksummedData(testContent.slice(5, 5).asChecksummedData())
                            .setMetadata(metadata)
                            .build());
                    respond.onComplete();
                  }
                },
                manager),
            req,
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(buffer);
      assertThat(read).isEqualTo(5);
    }
  }

  @Test
  public void validateCumulativeChecksum_zeroByteObject_success() throws IOException {
    Object metadata =
        Object.newBuilder()
            .setSize(0)
            .setChecksums(ObjectChecksums.newBuilder().setCrc32C(0).build())
            .build();

    ResponseContentLifecycleManager<ReadObjectResponse> manager =
        ResponseContentLifecycleManager.noop();

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    respond.onResponse(
                        ReadObjectResponse.newBuilder().setMetadata(metadata).build());
                    respond.onComplete();
                  }
                },
                manager),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.defaultHasher(),
            Retrier.attemptOnce(),
            Retrying.neverRetry())) {

      ByteBuffer buffer = ByteBuffer.allocate(15);
      int read = (int) c.read(buffer);
      assertThat(read).isEqualTo(0);
      assertThat(c.read(buffer)).isEqualTo(-1);
    }
  }

  @Test
  public void midStreamError_retried_recordsRetryAndErrorMetrics() throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setEnableOtelMetrics(true)
            .setMeterProvider(provider)
            .build();
    StorageMetricsContext ctx =
        options.getStorageClientMetrics().createMultiStepContext("ReadObject");
    ctx.setNetworkPath(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    byte[] firstPart = DataGenerator.base64Characters().genBytes(5);
    byte[] secondPart = DataGenerator.base64Characters().genBytes(5);
    ChecksummedTestContent firstContent = ChecksummedTestContent.of(firstPart);
    ChecksummedTestContent secondContent = ChecksummedTestContent.of(secondPart);
    AtomicInteger calls = new AtomicInteger(0);

    try (GapicUnbufferedReadableByteChannel c =
        new GapicUnbufferedReadableByteChannel(
            SettableApiFuture.create(),
            new ZeroCopyServerStreamingCallable<>(
                new ServerStreamingCallable<ReadObjectRequest, ReadObjectResponse>() {
                  @Override
                  public void call(
                      ReadObjectRequest request,
                      ResponseObserver<ReadObjectResponse> respond,
                      ApiCallContext context) {
                    respond.onStart(TestUtils.nullStreamController());
                    if (calls.incrementAndGet() == 1) {
                      respond.onResponse(
                          ReadObjectResponse.newBuilder()
                              .setChecksummedData(firstContent.asChecksummedData())
                              .build());
                      respond.onError(Status.UNAVAILABLE.asRuntimeException());
                    } else {
                      respond.onResponse(
                          ReadObjectResponse.newBuilder()
                              .setChecksummedData(secondContent.asChecksummedData())
                              .build());
                      respond.onComplete();
                    }
                  }
                },
                ResponseContentLifecycleManager.noop()),
            ReadObjectRequest.getDefaultInstance(),
            Hasher.noop(),
            options.createRetrier().withMetricsContext(ctx),
            Retrying.alwaysRetry())) {
      ByteBuffer buffer = ByteBuffer.allocate(10);
      assertThat(c.read(buffer)).isEqualTo(10);
    }

    Collection<MetricData> collected = reader.collectAllMetrics();
    assertThat(calls.get()).isEqualTo(2);
    LongPointData retryPoint =
        findSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RETRIES);
    assertThat(retryPoint.getValue()).isEqualTo(1L);
    assertThat(retryPoint.getAttributes())
        .isEqualTo(
            Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .put(
                    StorageClientMetrics.KEY_NETWORK_PATH,
                    StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
                .put(StorageClientMetrics.KEY_ERROR_TYPE, StorageErrorTypeMapper.STATUS_UNAVAILABLE)
                .build());

    LongPointData errorPoint =
        findSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getValue()).isEqualTo(1L);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNAVAILABLE);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");

    long attemptsTotal =
        collected.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS))
            .flatMap(m -> m.getLongSumData().getPoints().stream())
            .mapToLong(LongPointData::getValue)
            .sum();
    assertThat(attemptsTotal).isEqualTo(2L);
  }

  private static LongPointData findSinglePoint(Collection<MetricData> collected, String name) {
    MetricData metric =
        collected.stream()
            .filter(m -> m.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new AssertionError("Missing metric " + name));
    assertThat(metric.getLongSumData().getPoints()).hasSize(1);
    return metric.getLongSumData().getPoints().iterator().next();
  }
}
