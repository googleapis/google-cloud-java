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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ResumableUploadCallableImplTest {

  private ResumableUploadClient<String, String> mockClient;
  private UnaryCallable<String, ResumableUploadSession> mockStartCallable;
  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable;
  private UnaryCallable<QueryStatusRequest, QueryStatusResponse<String>> mockQueryCallable;

  private ResumableUploadCallSettings defaultSettings;
  private FakeCallContext callContext;
  private ScheduledExecutorService executor;
  private ClientContext clientContext;
  private ResumableUploadCallableImpl<String, String> callable;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    mockClient = mock(ResumableUploadClient.class, withSettings().withoutAnnotations());
    mockStartCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockChunkCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockQueryCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    lenient().when(mockClient.startUploadCallable()).thenReturn(mockStartCallable);
    lenient().when(mockClient.uploadChunkCallable()).thenReturn(mockChunkCallable);
    lenient().when(mockClient.queryStatusCallable()).thenReturn(mockQueryCallable);

    defaultSettings = ResumableUploadCallSettings.newBuilder().setChunkSize(8).build();
    callContext = FakeCallContext.createDefault();
    executor = Executors.newScheduledThreadPool(2);
    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(callContext)
            .setExecutor(executor)
            .setEndpoint("https://test.endpoint.com")
            .build();
    callable = new ResumableUploadCallableImpl<>(mockClient, defaultSettings, clientContext);
  }

  @AfterEach
  void tearDown() {
    if (executor != null) {
      executor.shutdownNow();
    }
  }

  @Test
  void testUploadCallable_singleChunk_happyPath() throws Exception {
    stubStartSession("https://upload.url/single");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "response-single")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("response-single");
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.getUploadSessionUrl()).isEqualTo("https://upload.url/single");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable).futureCall(captor.capture(), any());
    ChunkUploadRequest chunk = captor.getValue();
    assertThat(chunk.getUploadUrl()).isEqualTo("https://upload.url/single");
    assertChunk(chunk, 0, 5, true);
  }

  @Test
  void testUploadCallable_multiChunk_happyPath() throws Exception {
    stubStartSession("https://upload.url/multi");
    // 20 bytes with chunkSize = 8 -> 8 + 8 + 4 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "response-multi")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("01234567890123456789"), null);

    assertThat(future.get()).isEqualTo("response-multi");
    assertThat(future.isDone()).isTrue();

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> chunks = captor.getAllValues();
    assertChunk(chunks.get(0), 0, 8, false);
    assertChunk(chunks.get(1), 8, 8, false);
    assertChunk(chunks.get(2), 16, 4, true);
  }

  @Test
  void testUploadCallable_zeroByteUpload_finalizesSuccessfully() throws Exception {
    stubStartSession("https://upload.url/zero");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "response-zero")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", new ByteArrayInputStream(new byte[0]), null);

    assertThat(future.get()).isEqualTo("response-zero");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable).futureCall(captor.capture(), any());
    assertChunk(captor.getValue(), 0, 0, true);
  }

  @Test
  void testUploadCallable_singleChunkWithSeparateZeroByteFinalize_completesSuccessfully()
      throws Exception {
    stubStartSession("https://upload.url/exact-single");
    // Exactly 8 bytes with chunkSize = 8 -> 8 bytes (non-final) then 0 bytes (final)
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "response-exact-single")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("12345678"), null);

    assertThat(future.get()).isEqualTo("response-exact-single");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(2)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> chunks = captor.getAllValues();
    assertChunk(chunks.get(0), 0, 8, false);
    assertChunk(chunks.get(1), 8, 0, true);
  }

  @Test
  void testUploadCallable_nullResponse_completesSuccessfully() throws Exception {
    stubStartSession("https://upload.url/null-response");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, null)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);

    assertThat(future.get()).isNull();
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
  }

  @Test
  void testUploadCallable_cancelInFlight_haltsUpload() throws Exception {
    stubStartSession("https://upload.url/cancel");

    CountDownLatch chunkStarted = new CountDownLatch(1);
    CountDownLatch chunkCancelled = new CountDownLatch(1);
    SettableApiFuture<ChunkUploadResponse<String>> pendingChunkFuture = SettableApiFuture.create();
    pendingChunkFuture.addListener(chunkCancelled::countDown, Runnable::run);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            inv -> {
              chunkStarted.countDown();
              return pendingChunkFuture;
            });

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789ABCDEF"), null);

    assertThat(chunkStarted.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(future.isDone()).isTrue();
    assertThat(chunkCancelled.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(pendingChunkFuture.isCancelled()).isTrue();
    assertThrows(CancellationException.class, future::get);
  }

  @Test
  void testUploadCallable_startFailure_failsFuture() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("start failed")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("start failed");
    verifyNoInteractions(mockChunkCallable);
  }

  @Test
  void testUploadCallable_chunkFailure_failsFuture() {
    stubStartSession("https://upload.url/chunk-fail");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("chunk error")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("chunk error");
  }

  @Test
  void testUploadCallable_closesPayloadOnSuccess() throws Exception {
    stubStartSession("https://upload.url/close-success");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done")));

    TrackableStream stream = new TrackableStream("data");
    callable.futureCall("resource-path", stream, null).get();

    assertThat(stream.closeCount).isEqualTo(1);
  }

  @Test
  void testUploadCallable_closesPayloadOnFailure() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("start failed")));

    TrackableStream stream = new TrackableStream("data");
    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);
    assertThrows(ExecutionException.class, future::get);

    assertThat(stream.closeCount).isEqualTo(1);
  }

  @Test
  void testUploadCallable_withApiCallContext_mergesAndPassesContext() throws Exception {
    stubStartSession("https://upload.url/context");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done-ctx")));

    ApiCallContext customContext =
        FakeCallContext.createDefault()
            .withExtraHeaders(
                java.util.Collections.singletonMap(
                    "X-Custom", java.util.Collections.singletonList("val")));
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), customContext, null);
    assertThat(future.get()).isEqualTo("done-ctx");

    ArgumentCaptor<ApiCallContext> startContextCaptor =
        ArgumentCaptor.forClass(ApiCallContext.class);
    verify(mockStartCallable).futureCall(any(), startContextCaptor.capture());
    assertThat(startContextCaptor.getValue()).isNotNull();
    assertThat(((FakeCallContext) startContextCaptor.getValue()).getExtraHeaders())
        .containsKey("X-Custom");

    ArgumentCaptor<ApiCallContext> chunkContextCaptor =
        ArgumentCaptor.forClass(ApiCallContext.class);
    verify(mockChunkCallable).futureCall(any(), chunkContextCaptor.capture());
    assertThat(chunkContextCaptor.getValue()).isNotNull();
    assertThat(((FakeCallContext) chunkContextCaptor.getValue()).getExtraHeaders())
        .doesNotContainKey("X-Custom");
  }

  @Test
  void testUploadCallable_withSettings_mergesAndAppliesSettings() throws Exception {
    stubStartSession("https://upload.url/settings");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done-settings")));

    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(16).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null, customSettings);
    assertThat(future.get()).isEqualTo("done-settings");
  }

  @Test
  void testUploadCallable_withSettings_delegatesWithNullContext() throws Exception {
    stubStartSession("https://upload.url/settings-convenience");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done-settings-conv")));

    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(16).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), customSettings);
    assertThat(future.get()).isEqualTo("done-settings-conv");
  }

  @Test
  void testUploadCallable_withContextAndSettings_appliesBoth() throws Exception {
    stubStartSession("https://upload.url/ctx-settings");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done-both")));

    FakeCallContext customContext = FakeCallContext.createDefault();
    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(16).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), customContext, customSettings);
    assertThat(future.get()).isEqualTo("done-both");
  }

  @Test
  void testResumeCall_throwsUnsupportedOperationException() {
    assertThrows(
        UnsupportedOperationException.class,
        () -> callable.resumeCall("https://upload.url/session", streamOf("data"), null));
  }

  @Test
  void testChunkRetry_cat1FailureThenSuccess_retriesAndSucceeds() throws Exception {
    stubStartSession("https://upload.url/chunk-retry-ok");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "chunk-done")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("chunk-done");
    assertThat(future.isDone()).isTrue();

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(2)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    assertThat(requests.get(0).getOffset()).isEqualTo(0);
    assertThat(Arrays.copyOf(requests.get(0).getPayload(), requests.get(0).getPayloadLength()))
        .isEqualTo("hello".getBytes(StandardCharsets.UTF_8));
    assertThat(requests.get(1).getOffset()).isEqualTo(0);
    assertThat(Arrays.copyOf(requests.get(1).getPayload(), requests.get(1).getPayloadLength()))
        .isEqualTo("hello".getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void testChunkRetry_streamNotAdvancedByRetry_sameBytesSent() throws Exception {
    stubStartSession("https://upload.url/stream-no-advance");
    ByteCountingStream stream = new ByteCountingStream("01234567"); // exactly 1 chunk of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        // Chunk 0, attempt 0 -> fails with 503
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)))
        // Chunk 0, attempt 1 -> succeeds with final response
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "final-response")));

    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);

    assertThat(future.get()).isEqualTo("final-response");
    assertThat(future.isDone()).isTrue();

    // Stream must only have been read exactly 8 bytes (the payload length),
    // proving retry did not re-read or advance the input stream.
    assertThat(stream.totalBytesRead).isEqualTo(8);

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(2)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    // Both attempts correspond to chunk 0 and transmit identical bytes
    assertThat(requests.get(0).getOffset()).isEqualTo(0);
    assertThat(requests.get(0).getPayload()).isEqualTo("01234567".getBytes(StandardCharsets.UTF_8));
    assertThat(requests.get(1).getOffset()).isEqualTo(0);
    assertThat(requests.get(1).getPayload()).isEqualTo("01234567".getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void testChunkRetry_cat3Failure_failsFastWithoutRetrying() {
    stubStartSession("https://upload.url/chunk-cat3-fail");
    // HTTP 403 Forbidden is Category 3 (FATAL)
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(403, StatusCode.Code.PERMISSION_DENIED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) exception.getCause()).getStatusCode().getTransportCode())
        .isEqualTo(403);

    // Category 3 is fatal / non-retryable, so it fails after 1 attempt without retrying.
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testChunkRetry_transientFailureExhaustion_surfacesLastError() {
    stubStartSession("https://upload.url/chunk-exhaustion");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)));

    // 300ms global timeout -> 150ms derived chunk local deadline (per GAX-R7)
    ResumableUploadCallSettings settings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMillis(300)).build();
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), settings);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) exception.getCause()).getStatusCode().getTransportCode())
        .isEqualTo(503);

    verify(mockChunkCallable, atLeast(2)).futureCall(any(), any());
  }

  @Test
  void testChunkRetry_cancelSession_cancelsInFlightHttpFuture() throws Exception {
    stubStartSession("https://upload.url/cancel-in-flight");
    CountDownLatch chunkStarted = new CountDownLatch(1);
    SettableApiFuture<ChunkUploadResponse<String>> inFlightChunkFuture = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            inv -> {
              chunkStarted.countDown();
              return inFlightChunkFuture;
            });

    TrackableStream stream = new TrackableStream("hello");
    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);

    // Wait until chunk callable is invoked so cancel tests in-flight chunk cancellation.
    assertThat(chunkStarted.await(5, TimeUnit.SECONDS)).isTrue();

    // While chunk upload is in-flight, cancel the session future
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(future.isDone()).isTrue();

    // The in-flight HTTP chunk future must have been cancelled
    assertThat(inFlightChunkFuture.isCancelled()).isTrue();
    // The payload stream must be closed
    assertThat(stream.closeCount).isEqualTo(1);
  }

  @Test
  void testChunkRetry_cancellationDuringBackoff_deschedulesPendingAttempt() {
    SettableApiFuture<ChunkUploadResponse<String>> chunkAttempt0Future = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(chunkAttempt0Future)
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "should-not-reach")));

    ClientContext clientContext =
        ClientContext.newBuilder().setDefaultCallContext(callContext).build();
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startSessionFuture = SettableApiFuture.create();
    startSessionFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/cancel-backoff")
            .build());
    ResumableUploadCallSettings customSettings =
        defaultSettings.toBuilder().setChunkSize(8).build();
    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startSessionFuture,
            mockChunkCallable,
            mockQueryCallable,
            streamOf("hello"),
            customSettings,
            callContext,
            clientContext);
    ResumableUploadFutureImpl<String> sessionFuture =
        new ResumableUploadFutureImpl<>(result, coordinator);

    coordinator.start();

    // Fail attempt 0 with 503 to schedule backoff
    chunkAttempt0Future.setException(createApiException(503, StatusCode.Code.UNAVAILABLE));

    // Cancel while backoff is pending
    assertThat(sessionFuture.cancel(true)).isTrue();
    assertThat(sessionFuture.isCancelled()).isTrue();
    assertThrows(CancellationException.class, sessionFuture::get);

    // Only attempt 0 occurred; attempt 1 was de-scheduled
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  private static QueryStatusResponse<String> createQueryResponse(
      boolean isComplete,
      @Nullable Long committedOffset,
      @Nullable String response,
      @Nullable String uploadStatus) {
    return QueryStatusResponse.<String>newBuilder()
        .setComplete(isComplete)
        .setCommittedOffset(committedOffset)
        .setResponse(response)
        .setUploadStatus(uploadStatus)
        .build();
  }

  @Test
  void testRecovery_category2Error_recoversViaQueryAndSucceeds() throws Exception {
    stubStartSession("https://upload.url/recovery-success");
    // Attempt 0 fails with 400 (Category 2)
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(true, "recovered-response", "final")));

    // Query status returns active session with committed offset 0
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 0L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("recovered-response");
    assertThat(future.isDone()).isTrue();
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testRecovery_queryReturnsComplete_completesSessionWithoutResending() throws Exception {
    stubStartSession("https://upload.url/recovery-already-complete");
    // Attempt 0 fails with 400 (Category 2)
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    // Query status returns that the server already finalized the upload
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(createQueryResponse(true, 5L, "server-finalized", "final")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("server-finalized");
    assertThat(future.isDone()).isTrue();
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    // Only 1 chunk upload attempt happened; no resend occurred because the server was already
    // complete
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_queryReturnsIncompleteWithNullOffset_failsFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-null-offset");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    // Incomplete response with null committed offset violates the protocol contract
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, null, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause())
        .hasMessageThat()
        .contains("did not include a committed offset");
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_serverCommittedAheadWithinBuffer_compactsAndTopsUp() throws Exception {
    stubStartSession("https://upload.url/recovery-compact-topup");
    // 16-byte payload, chunkSize = 8
    // Attempt 0 for chunk 0 (bytes 0..7) fails with 400
    // Query returns committedOffset = 4 (server committed 4 bytes)
    // Buffer realigns to offset 4: compacts [4..7] ("4567") and tops up from stream ("89ab") ->
    // window [4..11]
    // Attempt 1 for realigned chunk transmits 8 bytes (offset 4, len 8) and succeeds
    // Chunk 2 (offset 12..15, "cdef") succeeds and finalizes
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null, "active")))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "all-done", "final")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 4L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789abcdef"), null);

    assertThat(future.get()).isEqualTo("all-done");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();

    // Request 0: initial chunk 0 (offset 0, length 8)
    assertChunk(requests.get(0), 0, 8, false);
    // Request 1: realigned chunk (offset 4, length 8)
    assertChunk(requests.get(1), 4, 8, false);
    // Request 2: final chunk (offset 12, length 4)
    assertChunk(requests.get(2), 12, 4, true);
  }

  @Test
  void testRecovery_serverOffsetBehind_resendsFromOffset() throws Exception {
    stubStartSession("https://upload.url/recovery-behind");
    // Chunk 0 (0..7) succeeds
    // Chunk 1 (8..15) fails with 409
    // Query returns committed offset 10 (between base 8 and attempt 16)
    // Buffer realigns to 10: compacts remaining 6 bytes, stream at EOF, isFinal remains true
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null, "active")))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(409, StatusCode.Code.ABORTED)))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "resend-ok", "final")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 10L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789abcdef"), null);

    assertThat(future.get()).isEqualTo("resend-ok");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    assertChunk(requests.get(0), 0, 8, false);
    assertChunk(requests.get(1), 8, 8, false);
    assertChunk(requests.get(2), 10, 6, true);
  }

  @Test
  void testRecovery_serverOffsetBelowBase_failsWithFatalFailedPrecondition() throws Exception {
    stubStartSession("https://upload.url/recovery-below-base");
    // Chunk 0 (0..7) succeeds
    // Chunk 1 (8..15) fails with 400
    // Query returns committed offset 4 (below buffer base of 8)
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null, "active")))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 4L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789abcdef"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("below buffer base offset");
  }

  @Test
  void testRecovery_missingStatusHeaderOn200_triggersRecovery() throws Exception {
    stubStartSession("https://upload.url/missing-status-200");
    // Attempt 0 succeeds with HTTP 200, but uploadStatus is null
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null, null)))
        .thenReturn(
            ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "recovered-ok", "final")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 0L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("recovered-ok");
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testRecovery_onFinalChunk_preservesUploadFinalize() throws Exception {
    stubStartSession("https://upload.url/recovery-final-chunk");
    // 12 bytes with chunkSize = 8 -> chunk 0 is 8 bytes, chunk 1 is 4 bytes (trailing partial)
    // Chunk 0 succeeds
    // Chunk 1 attempt 0 (offset 8, len 4, isFinal true) fails with 400
    // Query returns committed offset 10 (mid-buffer within trailing partial)
    // Buffer realigns to 10: remaining length 2 bytes, isFinal true
    // Chunk 1 attempt 1 transmits offset 10, len 2, isFinal true and completes
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null, "active")))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(true, "final-chunk-done", "final")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 10L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789ab"), null);

    assertThat(future.get()).isEqualTo("final-chunk-done");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    assertChunk(requests.get(0), 0, 8, false);
    assertChunk(requests.get(1), 8, 4, true);
    assertChunk(requests.get(2), 10, 2, true);
  }

  @Test
  void testRecovery_queryReturnsMissingStatusHeader_failsFatalProtocolViolation() throws Exception {
    stubStartSession("https://upload.url/recovery-missing-status-query");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    // Query status response missing upload status header is a fatal protocol violation
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 0L, null, null)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause())
        .hasMessageThat()
        .contains("missing X-Goog-Upload-Status header");
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_category3ErrorOnQuery_isFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-query-cat3");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    // Query status fails with 403 Forbidden (Category 3 / FATAL)
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(403, StatusCode.Code.PERMISSION_DENIED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) exception.getCause()).getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.PERMISSION_DENIED);
    // Query failed fatally, so no resend of chunk
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_transientErrorOnQuery_isRetried() throws Exception {
    stubStartSession("https://upload.url/recovery-query-transient");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(true, "query-retry-ok", "final")));

    // Query status fails first with 503 (transient), then succeeds
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 0L, null, "active")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("query-retry-ok");
    verify(mockQueryCallable, times(2)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testBufferWindow_noArrayCopyForPartialChunk_backingArrayIdentityPreserved()
      throws Exception {
    stubStartSession("https://upload.url/partial-no-copy");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "ok")));

    // 5 bytes with default chunkSize = 8 -> partial chunk
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("12345"), null);

    assertThat(future.get()).isEqualTo("ok");
    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable).futureCall(captor.capture(), any());
    ChunkUploadRequest chunk = captor.getValue();
    assertThat(chunk.getPayloadLength()).isEqualTo(5);
    // Backing array capacity is 8 (chunkSize), not 5 (no copy performed)
    assertThat(chunk.getPayload().length).isEqualTo(8);
  }

  @Test
  void testGlobalTimeout_firesAndFailsSessionWithDeadlineExceeded() throws Exception {
    stubStartSession("https://upload.url/timeout-fire");
    SettableApiFuture<ChunkUploadResponse<String>> hungChunk = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any())).thenReturn(hungChunk);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMillis(100)).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), timeoutSettings);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    DeadlineExceededException cause = (DeadlineExceededException) exception.getCause();
    assertThat(cause.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    assertThat(cause.getMessage()).contains("https://upload.url/timeout-fire");
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
  }

  @Test
  void testGlobalTimeout_cancelledCleanlyOnSuccess() throws Exception {
    stubStartSession("https://upload.url/timeout-success");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "ok")));

    ScheduledExecutorService mockExecutor = mock(ScheduledExecutorService.class);
    ScheduledFuture<?> mockScheduledFuture = mock(ScheduledFuture.class);
    when(mockExecutor.schedule(any(Runnable.class), anyLong(), any()))
        .thenAnswer(inv -> mockScheduledFuture);

    ClientContext customClientContext = clientContext.toBuilder().setExecutor(mockExecutor).build();
    ResumableUploadCallableImpl<String, String> customCallable =
        new ResumableUploadCallableImpl<>(mockClient, defaultSettings, customClientContext);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofSeconds(60)).build();

    ResumableUploadFuture<String> future =
        customCallable.futureCall("resource-path", streamOf("hello"), timeoutSettings);

    assertThat(future.get()).isEqualTo("ok");
    verify(mockScheduledFuture).cancel(false);
  }

  @Test
  void testGlobalTimeout_cancelledCleanlyOnFailure() throws Exception {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(401, StatusCode.Code.UNAUTHENTICATED)));

    ScheduledExecutorService mockExecutor = mock(ScheduledExecutorService.class);
    ScheduledFuture<?> mockScheduledFuture = mock(ScheduledFuture.class);
    when(mockExecutor.schedule(any(Runnable.class), anyLong(), any()))
        .thenAnswer(inv -> mockScheduledFuture);

    ClientContext customClientContext = clientContext.toBuilder().setExecutor(mockExecutor).build();
    ResumableUploadCallableImpl<String, String> customCallable =
        new ResumableUploadCallableImpl<>(mockClient, defaultSettings, customClientContext);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofSeconds(60)).build();

    ResumableUploadFuture<String> future =
        customCallable.futureCall("resource-path", streamOf("hello"), timeoutSettings);

    assertThrows(ExecutionException.class, future::get);
    verify(mockScheduledFuture).cancel(false);
  }

  @Test
  void testGlobalTimeout_cancelledCleanlyOnUserCancel() throws Exception {
    stubStartSession("https://upload.url/timeout-cancel");
    SettableApiFuture<ChunkUploadResponse<String>> hungChunk = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any())).thenReturn(hungChunk);

    ScheduledExecutorService mockExecutor = mock(ScheduledExecutorService.class);
    ScheduledFuture<?> mockScheduledFuture = mock(ScheduledFuture.class);
    when(mockExecutor.schedule(any(Runnable.class), anyLong(), any()))
        .thenAnswer(inv -> mockScheduledFuture);

    ClientContext customClientContext = clientContext.toBuilder().setExecutor(mockExecutor).build();
    ResumableUploadCallableImpl<String, String> customCallable =
        new ResumableUploadCallableImpl<>(mockClient, defaultSettings, customClientContext);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofSeconds(60)).build();

    ResumableUploadFuture<String> future =
        customCallable.futureCall("resource-path", streamOf("hello"), timeoutSettings);

    assertThat(future.cancel(true)).isTrue();
    verify(mockScheduledFuture).cancel(false);
  }

  @Test
  void testGlobalTimeout_derivesChunkLocalAndAttemptDeadlines() throws Exception {
    stubStartSession("https://upload.url/derived-deadlines");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "ok")));

    // 1. 60s global timeout yields 30s chunk budget
    ResumableUploadCallSettings settings60s =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofSeconds(60)).build();
    callable.futureCall("resource-path", streamOf("hello"), settings60s).get();

    ArgumentCaptor<ApiCallContext> captor60s = ArgumentCaptor.forClass(ApiCallContext.class);
    verify(mockChunkCallable).futureCall(any(), captor60s.capture());
    assertThat(captor60s.getValue().getTimeoutDuration()).isEqualTo(Duration.ofSeconds(30));
    assertThat(captor60s.getValue().getRetrySettings().getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(30));

    // 2. 10s global timeout yields 5s chunk budget (not the old 5-minute floor)
    clearInvocations(mockChunkCallable);
    ResumableUploadCallSettings settings10s =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofSeconds(10)).build();
    callable.futureCall("resource-path", streamOf("hello"), settings10s).get();

    ArgumentCaptor<ApiCallContext> captor10s = ArgumentCaptor.forClass(ApiCallContext.class);
    verify(mockChunkCallable).futureCall(any(), captor10s.capture());
    assertThat(captor10s.getValue().getTimeoutDuration()).isEqualTo(Duration.ofSeconds(5));
    assertThat(captor10s.getValue().getRetrySettings().getTotalTimeoutDuration())
        .isEqualTo(Duration.ofSeconds(5));
  }

  @Test
  void testUploadCallable_failureOutcome_attachesCloseExceptionViaAddSuppressed() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("upload failed")));

    InputStream failingStream =
        new InputStream() {
          @Override
          public int read() {
            return -1;
          }

          @Override
          public void close() throws IOException {
            throw new IOException("stream close error");
          }
        };

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", failingStream, null);
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(exception.getCause().getSuppressed()).asList().hasSize(1);
    assertThat(exception.getCause().getSuppressed()[0]).isInstanceOf(IOException.class);
    assertThat(exception.getCause().getSuppressed()[0])
        .hasMessageThat()
        .contains("stream close error");
  }

  @Test
  void testGlobalTimeout_timeoutWhileAttemptInFlight_cancelsInFlightFutureAndDoesNotCorruptBuffer()
      throws Exception {
    stubStartSession("https://upload.url/in-flight-timeout");
    SettableApiFuture<ChunkUploadResponse<String>> inFlightFuture = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(inFlightFuture);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMillis(80)).build();

    ByteCountingStream stream = new ByteCountingStream("01234567890123456789");
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", stream, timeoutSettings);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    // In-flight attempt future must be cancelled
    assertThat(inFlightFuture.isCancelled()).isTrue();

    // Stream should have been read only up to the first chunk (chunkSize = 8), not refilled or
    // advanced
    assertThat(stream.totalBytesRead).isEqualTo(8);
  }

  @Test
  void testGlobalTimeout_coversStartSessionTimeout() throws Exception {
    SettableApiFuture<ResumableUploadSession> hungStartFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(), any())).thenReturn(hungStartFuture);

    ResumableUploadCallSettings timeoutSettings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMillis(80)).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), timeoutSettings);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(exception.getCause().getMessage()).contains("before session initiation completed");
    assertThat(hungStartFuture.isCancelled()).isTrue();
  }

  @Test
  void testProgressListener_snapshotOnSubscribe_postsExactlyOneImmediateUpdate() throws Exception {
    SettableApiFuture<ResumableUploadSession> hungStartFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(), any())).thenReturn(hungStartFuture);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    List<ResumableUploadStatus> statuses = new CopyOnWriteArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          statuses.add(status);
          latch.countDown();
        },
        executor);

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(statuses).hasSize(1);
    ResumableUploadStatus snapshot = statuses.get(0);
    assertThat(snapshot.getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    assertThat(snapshot.getBytesUploaded()).isEqualTo(0L);
    assertThat(snapshot.getUploadUrl()).isNull();
  }

  @Test
  void testProgressListener_prescribedStateTransitions() throws Exception {
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(), any())).thenReturn(startFuture);

    // 20 bytes with chunkSize = 8 -> 3 chunks: [0..8), [8..16), [16..20)
    // Chunk 1 succeeds -> [0..8)
    // Chunk 2 fails with Cat-2 400
    // Query succeeds -> committed offset = 8
    // Chunk 2 resend succeeds -> [8..16)
    // Chunk 3 succeeds and finalizes -> [16..20)
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done")));

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                QueryStatusResponse.<String>newBuilder()
                    .setComplete(false)
                    .setCommittedOffset(8L)
                    .setUploadStatus("active")
                    .build()));

    List<ResumableUploadStatus> receivedStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch finalizedLatch = new CountDownLatch(1);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("01234567890123456789"), null);
    future.addProgressListener(
        status -> {
          receivedStatuses.add(status);
          if (status.getState() == ResumableUploadStatus.State.FINALIZED) {
            finalizedLatch.countDown();
          }
        },
        executor);

    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/progress-transitions")
            .setUploadStatus("active")
            .build());

    assertThat(future.get()).isEqualTo("done");
    assertThat(finalizedLatch.await(5, TimeUnit.SECONDS)).isTrue();

    List<ResumableUploadStatus.State> states = new ArrayList<>();
    for (ResumableUploadStatus s : receivedStatuses) {
      states.add(s.getState());
    }

    assertThat(states)
        .containsAtLeast(
            ResumableUploadStatus.State.STARTED,
            ResumableUploadStatus.State.UPLOADING,
            ResumableUploadStatus.State.RECOVERING,
            ResumableUploadStatus.State.OFFSET_RECEIVED,
            ResumableUploadStatus.State.FINALIZED)
        .inOrder();

    long lastBytes = 0;
    for (ResumableUploadStatus s : receivedStatuses) {
      assertThat(s.getBytesUploaded()).isAtLeast(lastBytes);
      lastBytes = s.getBytesUploaded();
      if (s.getState() != ResumableUploadStatus.State.STARTING) {
        assertThat(s.getUploadUrl()).isEqualTo("https://upload.url/progress-transitions");
      }
    }
    assertThat(lastBytes).isEqualTo(20L);
  }

  @Test
  void testProgressListener_throwingListener_doesNotBreakUpload() throws Exception {
    stubStartSession("https://upload.url/throwing-listener");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "ok")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    future.addProgressListener(
        status -> {
          throw new RuntimeException("boom from listener");
        },
        executor);

    assertThat(future.get()).isEqualTo("ok");
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testProgressListener_subscribingAfterCompletion_yieldsOneTerminalSnapshot()
      throws Exception {
    stubStartSession("https://upload.url/post-completion");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "completed-ok")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);
    assertThat(future.get()).isEqualTo("completed-ok");

    List<ResumableUploadStatus> postStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          postStatuses.add(status);
          latch.countDown();
        },
        executor);

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    executor.submit(() -> {}).get(5, TimeUnit.SECONDS);
    assertThat(postStatuses).hasSize(1);
    ResumableUploadStatus snapshot = postStatuses.get(0);
    assertThat(snapshot.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(snapshot.getUploadUrl()).isEqualTo("https://upload.url/post-completion");
    assertThat(snapshot.getBytesUploaded()).isEqualTo(5L);
  }

  @Test
  void testProgressListener_subscribingAfterFailure_yieldsOneTerminalFailedSnapshot()
      throws Exception {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(401, StatusCode.Code.UNAUTHENTICATED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);
    assertThrows(ExecutionException.class, future::get);

    List<ResumableUploadStatus> postStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          postStatuses.add(status);
          latch.countDown();
        },
        executor);

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    executor.submit(() -> {}).get(5, TimeUnit.SECONDS);
    assertThat(postStatuses).hasSize(1);
    ResumableUploadStatus snapshot = postStatuses.get(0);
    assertThat(snapshot.getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
    assertThat(snapshot.getException()).isInstanceOf(ApiException.class);
  }

  @Test
  void testProgressListener_futureCancelFromInsideListenerBody_worksWithoutDeadlock()
      throws Exception {
    stubStartSession("https://upload.url/cancel-inside-listener");
    SettableApiFuture<ChunkUploadResponse<String>> hungChunk = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any())).thenReturn(hungChunk);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    CountDownLatch cancelAttemptedLatch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          if (status.getState() == ResumableUploadStatus.State.STARTED) {
            future.cancel(true);
            cancelAttemptedLatch.countDown();
          }
        },
        executor);

    assertThat(cancelAttemptedLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(hungChunk.isCancelled()).isTrue();
  }

  @Test
  void testProgressListener_getStatus_reflectsCurrentState() throws Exception {
    stubStartSession("https://upload.url/get-status");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "ok")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("ok");
    ResumableUploadStatus status = future.getStatus();
    assertThat(status.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(status.getUploadUrl()).isEqualTo("https://upload.url/get-status");
    assertThat(status.getBytesUploaded()).isEqualTo(5L);
  }

  @Test
  void testProgressListener_orderingUnderConcurrency_pinsSequentialExecutor() throws Exception {
    ExecutorService multiThreadedExecutor = Executors.newFixedThreadPool(8);
    try {
      stubStartSession("https://upload.url/concurrency-order");
      when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
          .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
          .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
          .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
          .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
          .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "finished")));

      List<ResumableUploadStatus> events = new CopyOnWriteArrayList<>();
      AtomicInteger concurrentExecutions = new AtomicInteger(0);
      AtomicBoolean concurrencyDetected = new AtomicBoolean(false);
      CountDownLatch finalizedLatch = new CountDownLatch(1);

      ResumableUploadFuture<String> future =
          callable.futureCall(
              "resource-path", streamOf("0123456789012345678901234567890123456789"), null);

      future.addProgressListener(
          status -> {
            int inProgress = concurrentExecutions.incrementAndGet();
            if (inProgress > 1) {
              concurrencyDetected.set(true);
            }
            try {
              Thread.sleep(10);
              events.add(status);
              if (status.getState() == ResumableUploadStatus.State.FINALIZED) {
                finalizedLatch.countDown();
              }
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            } finally {
              concurrentExecutions.decrementAndGet();
            }
          },
          multiThreadedExecutor);

      assertThat(future.get(10, TimeUnit.SECONDS)).isEqualTo("finished");
      assertThat(finalizedLatch.await(5, TimeUnit.SECONDS)).isTrue();
      assertThat(concurrencyDetected.get()).isFalse();

      long lastBytes = 0;
      for (ResumableUploadStatus s : events) {
        assertThat(s.getBytesUploaded()).isAtLeast(lastBytes);
        lastBytes = s.getBytesUploaded();
      }
      assertThat(lastBytes).isEqualTo(40L);
    } finally {
      multiThreadedExecutor.shutdownNow();
    }
  }

  @Test
  void testActionableErrors_startFailure_preservesOriginalExceptionWithoutEndpointSuffix() {
    ApiException startError = createApiException(401, StatusCode.Code.UNAUTHENTICATED);
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(startError));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isSameInstanceAs(startError);
    assertThat(ex.getCause().getMessage()).doesNotContain("endpoint:");
    assertThat(future.getUploadSessionUrl()).isNull();
  }

  @Test
  void testActionableErrors_chunkFailure_messageContainsUploadSessionUrl() {
    String sessionUrl = "https://upload.url/chunk-error-test";
    stubStartSession(sessionUrl);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(403, StatusCode.Code.PERMISSION_DENIED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(ApiException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  @Test
  void testActionableErrors_preservesErrorDetailsCauseChainAndSuppressedExceptions() {
    String sessionUrl = "https://upload.url/chunk-error-details-test";
    stubStartSession(sessionUrl);
    ErrorDetails errorDetails = ErrorDetails.builder().build();
    ApiException original =
        ApiExceptionFactory.createException(
            "HTTP 403",
            null,
            new HttpStatusStatusCode(403, StatusCode.Code.PERMISSION_DENIED),
            false,
            errorDetails);
    IOException suppressed = new IOException("underlying stream error");
    original.addSuppressed(suppressed);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(original));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(ApiException.class);
    ApiException cause = (ApiException) ex.getCause();
    assertThat(cause.getMessage()).contains(sessionUrl);
    assertThat(cause.getCause()).isSameInstanceAs(original);
    assertThat(cause.getErrorDetails()).isSameInstanceAs(errorDetails);
    assertThat(cause.getSuppressed()).asList().contains(suppressed);
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  @Test
  void testActionableErrors_recoveryFailure_messageContainsUploadSessionUrl() {
    String sessionUrl = "https://upload.url/recovery-error-test";
    stubStartSession(sessionUrl);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));
    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(403, StatusCode.Code.PERMISSION_DENIED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(ApiException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  @Test
  void testActionableErrors_globalTimeoutFailure_messageContainsUploadSessionUrl() {
    String sessionUrl = "https://upload.url/timeout-error-test";
    stubStartSession(sessionUrl);
    SettableApiFuture<ChunkUploadResponse<String>> hungChunk = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any())).thenReturn(hungChunk);

    ResumableUploadCallSettings settings =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMillis(50)).build();

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null, settings);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  @Test
  void testActionableErrors_rewindFailure_surfacesActionableSeekableStreamMessage() {
    String sessionUrl = "https://upload.url/rewind-error-test";
    stubStartSession(sessionUrl);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(createQueryResponse(false, 4L, null, "active")));

    byte[] data = new byte[16];
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", new ByteArrayInputStream(data), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(ex.getCause().getMessage()).contains("seekable stream");
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  private static class HttpStatusStatusCode implements StatusCode {
    private final int httpStatus;
    private final StatusCode.Code code;

    HttpStatusStatusCode(int httpStatus, StatusCode.Code code) {
      this.httpStatus = httpStatus;
      this.code = code;
    }

    @Override
    public StatusCode.Code getCode() {
      return code;
    }

    @Override
    public Integer getTransportCode() {
      return httpStatus;
    }
  }

  private static ApiException createApiException(int httpStatus, StatusCode.Code code) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus, null, new HttpStatusStatusCode(httpStatus, code), false);
  }

  @Test
  void testTransmitChunk_largePayloadSmallChunksSynchronousCompletion_doesNotStackOverflow()
      throws Exception {
    stubStartSession("https://upload.url/trampoline-test");
    byte[] payload = new byte[200 * 1024]; // 200 KB
    int chunkSize = 16; // 12,800 chunks

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            inv -> {
              ChunkUploadRequest req = inv.getArgument(0);
              boolean isComplete = req.isFinal();
              return ApiFutures.immediateFuture(
                  ChunkUploadResponse.create(isComplete, isComplete ? "done-200k" : null));
            });

    ResumableUploadCallSettings settings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(chunkSize).build();
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", new ByteArrayInputStream(payload), settings);

    assertThat(future.get(10, TimeUnit.SECONDS)).isEqualTo("done-200k");
  }

  private void stubStartSession(String uploadUrl) {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ResumableUploadSession.newBuilder()
                    .setUploadUrl(uploadUrl)
                    .setUploadStatus("active")
                    .build()));
  }

  private static InputStream streamOf(String content) {
    return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
  }

  private static void assertChunk(
      ChunkUploadRequest chunk, long expectedOffset, int expectedSize, boolean expectedFinal) {
    assertThat(chunk.getOffset()).isEqualTo(expectedOffset);
    assertThat(chunk.getPayloadLength()).isEqualTo(expectedSize);
    assertThat(chunk.isFinal()).isEqualTo(expectedFinal);
  }

  private static class TrackableStream extends ByteArrayInputStream {
    volatile int closeCount = 0;

    TrackableStream(String content) {
      super(content.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void close() throws IOException {
      closeCount++;
      super.close();
    }
  }

  private static class ByteCountingStream extends ByteArrayInputStream {
    int totalBytesRead = 0;

    ByteCountingStream(String content) {
      super(content.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public int read(byte[] b, int off, int len) {
      int read = super.read(b, off, len);
      if (read > 0) {
        totalBytesRead += read;
      }
      return read;
    }
  }
}
