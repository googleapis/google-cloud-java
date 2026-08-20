/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.core.NanoClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadProgressListener;
import com.google.api.gax.resumable.ResumableUploadResultRetryAlgorithm;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.retrying.AdaptiveRetryingCallable;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumableUploadCallableImplTest {

  private ScheduledExecutorService executor;
  private ResumableUploadClient<String, String> mockClient;
  private UnaryCallable<String, ResumableUploadSession> mockStartCallable;
  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable;
  private UnaryCallable<QueryStatusRequest, QueryStatusResponse<String>> mockQueryCallable;
  private AdaptiveRetryingCallable<String> adaptiveRetryingCallable;
  private ResumableUploadCallSettings defaultSettings;

  @SuppressWarnings("unchecked")
  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    mockClient = mock(ResumableUploadClient.class);
    mockStartCallable = mock(UnaryCallable.class);
    mockChunkCallable = mock(UnaryCallable.class);
    mockQueryCallable = mock(UnaryCallable.class);

    when(mockClient.startUploadCallable()).thenReturn(mockStartCallable);
    when(mockClient.uploadChunkCallable()).thenReturn(mockChunkCallable);
    when(mockClient.queryStatusCallable()).thenReturn(mockQueryCallable);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofSeconds(5))
            .build();

    RetryAlgorithm<String> retryAlgorithm =
        new RetryAlgorithm<>(
            ResumableUploadResultRetryAlgorithm.create(),
            new ExponentialRetryAlgorithm(retrySettings, NanoClock.getDefaultClock()));

    adaptiveRetryingCallable = new AdaptiveRetryingCallable<>(retryAlgorithm, executor);
    defaultSettings = ResumableUploadCallSettings.newBuilder().setChunkSize(8).build();
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testStartAndUploadMultiChunksSuccess() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient, adaptiveRetryingCallable, defaultSettings, FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(String.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ResumableUploadSession.newBuilder()
                    .setUploadUrl("https://upload.url/session-123")
                    .build()));

    // 16 bytes total: 2 chunks of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, false, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(16, true, "upload-complete-json")));

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("upload-complete-json");
    assertThat(future.getUploadSessionUrl()).isEqualTo("https://upload.url/session-123");
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testHealthyUploadExceedsTotalRetryTimeout_succeeds() throws Exception {
    FakeApiClock fakeClock = new FakeApiClock(0L);
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofMillis(100))
            .build();

    RetryAlgorithm<String> retryAlgorithm =
        new RetryAlgorithm<>(
            ResumableUploadResultRetryAlgorithm.create(),
            new ExponentialRetryAlgorithm(retrySettings, fakeClock));

    AdaptiveRetryingCallable<String> retryingCallable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    // CallContext with explicit per-chunk timeout duration prevents totalTimeout clamping
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            retryingCallable,
            defaultSettings,
            FakeCallContext.createDefault().withTimeoutDuration(Duration.ofSeconds(5)));

    when(mockStartCallable.futureCall(any(String.class), any()))
        .thenAnswer(
            invocation -> {
              fakeClock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(60));
              return ApiFutures.immediateFuture(
                  ResumableUploadSession.newBuilder()
                      .setUploadUrl("https://upload.url/session-timeout")
                      .build());
            });

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            invocation -> {
              // Advance clock by 60ms; total elapsed is now 120ms (> 100ms totalTimeoutDuration)
              fakeClock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(60));
              return ApiFutures.immediateFuture(ChunkUploadResponse.create(8, false, null));
            })
        .thenAnswer(
            invocation -> {
              // Advance clock by 60ms; total elapsed is now 180ms (> 100ms totalTimeoutDuration)
              fakeClock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(60));
              return ApiFutures.immediateFuture(
                  ChunkUploadResponse.create(16, true, "upload-complete-json"));
            });

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("upload-complete-json");
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(fakeClock.millisTime()).isGreaterThan(100L);
  }

  @Test
  void testChunkFailureAfterTotalRetryTimeoutExhaustsRetries() {
    FakeApiClock fakeClock = new FakeApiClock(0L);
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofMillis(100))
            .build();

    RetryAlgorithm<String> retryAlgorithm =
        new RetryAlgorithm<>(
            ResumableUploadResultRetryAlgorithm.create(),
            new ExponentialRetryAlgorithm(retrySettings, fakeClock));

    AdaptiveRetryingCallable<String> retryingCallable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            retryingCallable,
            defaultSettings,
            FakeCallContext.createDefault().withTimeoutDuration(Duration.ofSeconds(5)));

    when(mockStartCallable.futureCall(any(String.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ResumableUploadSession.newBuilder()
                    .setUploadUrl("https://upload.url/session-fail-timeout")
                    .build()));

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            invocation -> {
              // Advance clock past totalTimeout (100ms) before failure occurs
              fakeClock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(150));
              return ApiFutures.immediateFailedFuture(
                  new UnavailableException(
                      "temporary unavailable",
                      null,
                      FakeStatusCode.of(StatusCode.Code.UNAVAILABLE),
                      true));
            });

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
  }

  @Test
  void testResumeExistingUploadSession() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient, adaptiveRetryingCallable, defaultSettings, FakeCallContext.createDefault());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "done")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.resumeCall(
            "https://upload.url/existing-session", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("done");
    assertThat(future.getUploadSessionUrl()).isEqualTo("https://upload.url/existing-session");
  }

  @Test
  void testProgressTrackingAndListenerCallbacks() throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(8).build();

    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient, adaptiveRetryingCallable, customSettings, FakeCallContext.createDefault());

    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(String.class), any())).thenReturn(startFuture);

    // 16 bytes total: 2 chunks of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(16, true, "complete")));

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);
    future.addProgressListener(listener);

    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/session-progress")
            .build());

    String result = future.get();
    assertThat(result).isEqualTo("complete");

    ResumableUploadStatus finalStatus = future.getStatus();
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(16);
    assertThat(finalStatus.getUploadUrl()).isEqualTo("https://upload.url/session-progress");

    // Verify progress events recorded by listener
    assertThat(progressEvents).isNotEmpty();
    // Verify initial starting event
    assertThat(progressEvents.get(0).getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    // Verify final completed event
    ResumableUploadStatus lastEvent = progressEvents.get(progressEvents.size() - 1);
    assertThat(lastEvent.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(lastEvent.getBytesUploaded()).isEqualTo(16);
  }

  @Test
  void testDynamicAddProgressListenerReceivesCurrentSnapshot() {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient, adaptiveRetryingCallable, defaultSettings, FakeCallContext.createDefault());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "done")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.resumeCall(
            "https://upload.url/existing-session", new ByteArrayInputStream(payload), null);

    List<ResumableUploadStatus> dynamicEvents = new CopyOnWriteArrayList<>();
    future.addProgressListener(dynamicEvents::add);

    assertThat(dynamicEvents).isNotEmpty();
    assertThat(dynamicEvents.get(0).getUploadUrl())
        .isEqualTo("https://upload.url/existing-session");
  }
}
