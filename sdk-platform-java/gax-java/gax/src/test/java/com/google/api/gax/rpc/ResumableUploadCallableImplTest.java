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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.resumable.ResumableUploadStatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
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
import java.util.concurrent.atomic.AtomicReference;
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
  private ClientContext clientContext;
  private ExecutorService executor;
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
    clientContext = ClientContext.newBuilder().setDefaultCallContext(callContext).build();
    executor = Executors.newSingleThreadExecutor();
    callable = new ResumableUploadCallableImpl<>(mockClient, defaultSettings, clientContext);
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testUploadCallable_singleChunk_happyPath() throws Exception {
    stubStartSession("https://upload.url/single");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "response-single")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "response-multi")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "response-zero")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "response-exact-single")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, null)));

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
  void testUploadCallable_cancelBeforeStartCompletes_abortsChunkUpload() {
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    // Ignore cancellation on startFuture to simulate start completing concurrently with cancel()
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            new ForwardingApiFuture<ResumableUploadSession>(startFuture) {
              @Override
              public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
              }
            });

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();

    startFuture.set(
        ResumableUploadSession.newBuilder().setUploadUrl("https://upload.url/late").build());
    verifyNoInteractions(mockChunkCallable);
  }

  @Test
  void testUploadCallable_cancelDuringChunkDispatch_immediatelyCancelsChunkFuture() {
    stubStartSession("https://upload.url/cancel-dispatch");
    SettableApiFuture<ChunkUploadResponse<String>> lateChunkFuture = SettableApiFuture.create();
    AtomicReference<ResumableUploadFuture<String>> futureRef = new AtomicReference<>();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            inv -> {
              futureRef.get().cancel(true);
              return lateChunkFuture;
            });

    // Defer startFuture completion until futureRef is populated
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(), any())).thenReturn(startFuture);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);
    futureRef.set(future);
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/cancel-dispatch")
            .build());

    assertThat(future.isCancelled()).isTrue();
    assertThat(lateChunkFuture.isCancelled()).isTrue();
  }

  @Test
  void testUploadCallable_startFailure_failsFuture() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("start failed")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
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
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("chunk error");
  }

  @Test
  void testUploadCallable_closesPayloadOnSuccess() throws Exception {
    stubStartSession("https://upload.url/close-success");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done")));

    TrackableStream stream = new TrackableStream("data");
    callable.futureCall("resource-path", stream, null).get();

    assertThat(stream.closed).isTrue();
  }

  @Test
  void testUploadCallable_closesPayloadOnFailure() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(new IllegalStateException("start failed")));

    TrackableStream stream = new TrackableStream("data");
    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);
    assertThrows(ExecutionException.class, future::get);

    assertThat(stream.closed).isTrue();
  }

  @Test
  void testUploadCallable_closesPayloadOnCancel() throws Exception {
    stubStartSession("https://upload.url/close-cancel");
    CountDownLatch chunkStarted = new CountDownLatch(1);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            inv -> {
              chunkStarted.countDown();
              return SettableApiFuture.create();
            });

    TrackableStream stream = new TrackableStream("data");
    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);
    assertThat(chunkStarted.await(5, TimeUnit.SECONDS)).isTrue();
    future.cancel(true);

    assertThat(stream.closed).isTrue();
  }

  @Test
  void testUploadCallable_closesPayloadOnStartSyncFailure() {
    when(mockStartCallable.futureCall(any(), any()))
        .thenThrow(new RuntimeException("sync start failure"));

    TrackableStream stream = new TrackableStream("data");
    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(RuntimeException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("sync start failure");
    assertThat(stream.closed).isTrue();
  }

  @Test
  void testUploadCallable_withApiCallContext_mergesAndPassesContext() throws Exception {
    stubStartSession("https://upload.url/context");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done-ctx")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done-settings")));

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
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done-settings-conv")));

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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done-both")));

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
  void testChunkRetry_transientFailureThenSuccess_retriesAndSucceeds() throws Exception {
    stubStartSession("https://upload.url/chunk-retry-ok");
    TrackableStream stream = new TrackableStream("01234567"); // exactly 1 chunk of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "chunk-done")));

    ResumableUploadFuture<String> future = callable.futureCall("resource-path", stream, null);

    assertThat(future.get()).isEqualTo("chunk-done");
    assertThat(future.isDone()).isTrue();
    assertThat(stream.totalBytesRead).isEqualTo(8);
    assertThat(stream.closed).isTrue();

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(2)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    assertThat(requests.get(0).getOffset()).isEqualTo(0);
    assertThat(requests.get(0).getPayload()).isEqualTo("01234567".getBytes(StandardCharsets.UTF_8));
    assertThat(requests.get(1).getOffset()).isEqualTo(0);
    assertThat(requests.get(1).getPayload()).isEqualTo("01234567".getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void testChunkRetry_transientFailureExhaustion_surfacesLastError() {
    stubStartSession("https://upload.url/chunk-exhaustion");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) exception.getCause()).getStatusCode().getTransportCode())
        .isEqualTo(503);

    // Default chunk retry settings has maxAttempts = 5
    verify(mockChunkCallable, times(5)).futureCall(any(), any());
  }

  @Test
  void testChunkRetry_cancellationDuringBackoff_deschedulesPendingAttempt() {
    stubStartSession("https://upload.url/cancel-backoff");
    SettableApiFuture<ChunkUploadResponse<String>> chunkAttempt0Future = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(chunkAttempt0Future)
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "should-not-reach")));

    ResumableUploadFuture<String> sessionFuture =
        callable.futureCall("resource-path", streamOf("hello"), null);

    // Fail attempt 0 with 503 to schedule backoff
    chunkAttempt0Future.setException(createApiException(503, StatusCode.Code.UNAVAILABLE));

    // Cancel while backoff is pending
    assertThat(sessionFuture.cancel(true)).isTrue();
    assertThat(sessionFuture.isCancelled()).isTrue();
    assertThrows(CancellationException.class, sessionFuture::get);

    // Only attempt 0 occurred; attempt 1 was de-scheduled
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_recoverableChunkError_recoversViaQuery() throws Exception {
    stubStartSession("https://upload.url/recovery-success");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.<String>newBuilder()
                    .setUploadStatus(ResumableUploadStatus.FINAL)
                    .setResponse("recovered-response")
                    .build()));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(0L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("recovered-response");
    assertThat(future.isDone()).isTrue();
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testRecovery_queryReturnsFinal_completesWithoutResending() throws Exception {
    stubStartSession("https://upload.url/recovery-already-complete");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(5L, "server-finalized", ResumableUploadStatus.FINAL)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("server-finalized");
    assertThat(future.isDone()).isTrue();
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_queryNullOffset_failsFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-null-offset");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(null, null, ResumableUploadStatus.ACTIVE)));

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
  void testRecovery_committedMidBuffer_compactsAndTopsUp() throws Exception {
    stubStartSession("https://upload.url/recovery-compact-topup");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "all-done")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(4L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789abcdef"), null);

    assertThat(future.get()).isEqualTo("all-done");

    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> requests = captor.getAllValues();
    assertChunk(requests.get(0), 0, 8, false);
    assertChunk(requests.get(1), 4, 8, false);
    assertChunk(requests.get(2), 12, 4, true);
  }

  @Test
  void testRecovery_offsetBelowBufferBase_failsFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-below-base");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(4L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("0123456789abcdef"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("below buffer base offset");
  }

  @Test
  void testRecovery_missingStatusHeaderOn200_triggersRecovery() throws Exception {
    stubStartSession("https://upload.url/missing-status-200");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.UNKNOWN, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "recovered-ok")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(0L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("recovered-ok");
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testRecovery_finalChunk_preservesFinalFlag() throws Exception {
    stubStartSession("https://upload.url/recovery-final-chunk");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "final-chunk-done")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(10L, null, ResumableUploadStatus.ACTIVE)));

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
  void testRecovery_queryMissingStatusHeader_failsFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-query-missing-status");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(0L, null, ResumableUploadStatus.UNKNOWN)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause())
        .hasMessageThat()
        .contains("missing X-Goog-Upload-Status header");
  }

  @Test
  void testRecovery_queryRecoverableError_failsFatal() throws Exception {
    stubStartSession("https://upload.url/recovery-query-cat2");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    // 400 is recoverable for UPLOAD, but fatal for QUERY
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    verify(mockQueryCallable, times(1)).futureCall(any(), any());
  }

  @Test
  void testRecovery_queryTransientError_retriesAndSucceeds() throws Exception {
    stubStartSession("https://upload.url/recovery-query-transient");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "query-retry-ok")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(createApiException(503, StatusCode.Code.UNAVAILABLE)))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(0L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("query-retry-ok");
    verify(mockQueryCallable, times(2)).futureCall(any(), any());
    verify(mockChunkCallable, times(2)).futureCall(any(), any());
  }

  @Test
  void testRecovery_repeatedWithoutProgress_failsAfterMaxAttempts() throws Exception {
    stubStartSession("https://upload.url/recovery-exhausted");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(0L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    verify(mockQueryCallable, times(4)).futureCall(any(), any());
    verify(mockChunkCallable, times(5)).futureCall(any(), any());
  }

  @Test
  void testRecovery_progressBetweenRecoveries_resetsAttempts() throws Exception {
    stubStartSession("https://upload.url/recovery-reset");
    ApiFuture<ChunkUploadResponse<String>> recoverable =
        ApiFutures.immediateFailedFuture(createApiException(400, StatusCode.Code.INVALID_ARGUMENT));
    ApiFuture<ChunkUploadResponse<String>> active =
        ApiFutures.immediateFuture(ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null));
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(recoverable)
        .thenReturn(active)
        .thenReturn(recoverable)
        .thenReturn(active)
        .thenReturn(recoverable)
        .thenReturn(active)
        .thenReturn(recoverable)
        .thenReturn(active)
        .thenReturn(recoverable)
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "reset-ok")));

    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(createQueryResponse(0L, null, ResumableUploadStatus.ACTIVE)))
        .thenReturn(
            ApiFutures.immediateFuture(createQueryResponse(8L, null, ResumableUploadStatus.ACTIVE)))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(16L, null, ResumableUploadStatus.ACTIVE)))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(24L, null, ResumableUploadStatus.ACTIVE)))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(32L, null, ResumableUploadStatus.ACTIVE)));

    ResumableUploadFuture<String> future =
        callable.futureCall(
            "resource-path", streamOf("0123456789abcdefghijklmnopqrstuvwxyz0123"), null);

    assertThat(future.get()).isEqualTo("reset-ok");
    verify(mockQueryCallable, times(5)).futureCall(any(), any());
    verify(mockChunkCallable, times(10)).futureCall(any(), any());
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

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "ok")));

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
  void testGlobalTimeout_usesDefaultWhenUnset() throws Exception {
    stubStartSession("https://upload.url/default-timeout");
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "ok")));

    ScheduledExecutorService mockExecutor = mock(ScheduledExecutorService.class);
    ScheduledFuture<?> mockScheduledFuture = mock(ScheduledFuture.class);
    when(mockExecutor.schedule(any(Runnable.class), anyLong(), any()))
        .thenAnswer(inv -> mockScheduledFuture);

    ClientContext customClientContext = clientContext.toBuilder().setExecutor(mockExecutor).build();

    // 1. Unset on both stub and per-request -> falls back to GAX default (15m)
    ResumableUploadCallableImpl<String, String> unsetStubCallable =
        new ResumableUploadCallableImpl<>(mockClient, defaultSettings, customClientContext);
    assertThat(unsetStubCallable.futureCall("resource-path", streamOf("hello"), null).get())
        .isEqualTo("ok");
    verify(mockExecutor)
        .schedule(
            any(Runnable.class), eq(Duration.ofMinutes(15).toMillis()), eq(TimeUnit.MILLISECONDS));

    // 2. Stub-level timeout (30m, e.g. from generator/client settings) + null per-request -> 30m
    ResumableUploadCallSettings stubWith30m =
        defaultSettings.toBuilder().setGlobalTimeout(Duration.ofMinutes(30)).build();
    ResumableUploadCallableImpl<String, String> configuredStubCallable =
        new ResumableUploadCallableImpl<>(mockClient, stubWith30m, customClientContext);
    assertThat(configuredStubCallable.futureCall("resource-path", streamOf("hello"), null).get())
        .isEqualTo("ok");
    verify(mockExecutor)
        .schedule(
            any(Runnable.class), eq(Duration.ofMinutes(30).toMillis()), eq(TimeUnit.MILLISECONDS));

    // 3. Stub-level timeout (30m) + per-request with only chunkSize set -> preserves 30m
    ResumableUploadCallSettings perRequestChunkSizeOnly =
        ResumableUploadCallSettings.newBuilder().setChunkSize(16).build();
    assertThat(
            configuredStubCallable
                .futureCall("resource-path", streamOf("hello"), perRequestChunkSizeOnly)
                .get())
        .isEqualTo("ok");
    verify(mockExecutor, times(2))
        .schedule(
            any(Runnable.class), eq(Duration.ofMinutes(30).toMillis()), eq(TimeUnit.MILLISECONDS));

    // 4. Stub-level timeout (30m) + per-request globalTimeout (5m) -> per-request wins (5m)
    ResumableUploadCallSettings perRequestWith5m =
        ResumableUploadCallSettings.newBuilder().setGlobalTimeout(Duration.ofMinutes(5)).build();
    assertThat(
            configuredStubCallable
                .futureCall("resource-path", streamOf("hello"), perRequestWith5m)
                .get())
        .isEqualTo("ok");
    verify(mockExecutor)
        .schedule(
            any(Runnable.class), eq(Duration.ofMinutes(5).toMillis()), eq(TimeUnit.MILLISECONDS));
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

    TrackableStream stream = new TrackableStream("01234567890123456789");
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", stream, timeoutSettings);

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
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

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(exception.getCause().getMessage()).contains("before session initiation completed");
    assertThat(hungStartFuture.isCancelled()).isTrue();
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
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.FINAL, "done")));

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                QueryStatusResponse.<String>newBuilder()
                    .setCommittedOffset(8L)
                    .setUploadStatus(ResumableUploadStatus.ACTIVE)
                    .build()));

    List<ResumableUploadProgress> receivedStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch finalizedLatch = new CountDownLatch(1);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("01234567890123456789"), null);
    future.addProgressListener(
        status -> {
          receivedStatuses.add(status);
          if (status.getState() == ResumableUploadProgress.State.FINALIZED) {
            finalizedLatch.countDown();
          }
        },
        executor);

    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/progress-transitions")
            .build());

    assertThat(future.get()).isEqualTo("done");
    assertThat(finalizedLatch.await(5, TimeUnit.SECONDS)).isTrue();

    List<ResumableUploadProgress.State> states = new ArrayList<>();
    for (ResumableUploadProgress s : receivedStatuses) {
      states.add(s.getState());
    }

    assertThat(states)
        .containsAtLeast(
            ResumableUploadProgress.State.STARTING,
            ResumableUploadProgress.State.STARTED,
            ResumableUploadProgress.State.UPLOADING,
            ResumableUploadProgress.State.RECOVERING,
            ResumableUploadProgress.State.OFFSET_RECEIVED,
            ResumableUploadProgress.State.FINALIZED)
        .inOrder();

    long lastBytes = 0;
    for (ResumableUploadProgress s : receivedStatuses) {
      assertThat(s.getBytesUploaded()).isAtLeast(lastBytes);
      lastBytes = s.getBytesUploaded();
      if (s.getState() != ResumableUploadProgress.State.STARTING) {
        assertThat(s.getUploadUrl()).isEqualTo("https://upload.url/progress-transitions");
      }
    }
    assertThat(lastBytes).isEqualTo(20L);

    ResumableUploadProgress finalStatus = future.getProgress();
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadProgress.State.FINALIZED);
    assertThat(finalStatus.getUploadUrl()).isEqualTo("https://upload.url/progress-transitions");
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(20L);
  }

  @Test
  void testProgressListener_uploadFailure_transitionsToFailed() throws Exception {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(401, StatusCode.Code.UNAUTHENTICATED)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);
    assertThrows(ExecutionException.class, future::get);

    assertThat(future.getProgress().getState()).isEqualTo(ResumableUploadProgress.State.FAILED);

    List<ResumableUploadProgress> postStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch latch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          postStatuses.add(status);
          latch.countDown();
        },
        executor);

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(postStatuses).hasSize(1);
    assertThat(postStatuses.get(0).getState()).isEqualTo(ResumableUploadProgress.State.FAILED);
  }

  @Test
  void testProgressListener_cancel_transitionsToFailed() throws Exception {
    stubStartSession("https://upload.url/cancel-progress");
    SettableApiFuture<ChunkUploadResponse<String>> hungChunk = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any())).thenReturn(hungChunk);

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    CountDownLatch failedLatch = new CountDownLatch(1);
    future.addProgressListener(
        status -> {
          if (status.getState() == ResumableUploadProgress.State.FAILED) {
            failedLatch.countDown();
          }
        },
        executor);

    assertThat(future.cancel(true)).isTrue();
    assertThat(hungChunk.isCancelled()).isTrue();
    assertThat(future.getProgress().getState()).isEqualTo(ResumableUploadProgress.State.FAILED);
    assertThat(failedLatch.await(5, TimeUnit.SECONDS)).isTrue();
  }

  @Test
  void testProgressListener_queryFinal_transitionsToFinalized() throws Exception {
    stubStartSession("https://upload.url/query-final-progress");
    when(mockChunkCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));
    when(mockQueryCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(null, "done", ResumableUploadStatus.FINAL)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    assertThat(future.get()).isEqualTo("done");
    assertThat(future.getProgress().getState()).isEqualTo(ResumableUploadProgress.State.FINALIZED);
    assertThat(future.getProgress().getBytesUploaded()).isEqualTo(5L);
  }

  @Test
  void testActionableErrors_startFailure_preservesOriginalException() {
    ApiException startError = createApiException(401, StatusCode.Code.UNAUTHENTICATED);
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(startError));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isSameInstanceAs(startError);
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

    ExecutionException ex =
        assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
    assertThat(ex.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
  }

  @Test
  void testActionableErrors_rewindFailure_surfacesRestartMessage() {
    String sessionUrl = "https://upload.url/rewind-error-test";
    stubStartSession(sessionUrl);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(ResumableUploadStatus.ACTIVE, null)))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                createQueryResponse(4L, null, ResumableUploadStatus.ACTIVE)));

    byte[] data = new byte[16];
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", new ByteArrayInputStream(data), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(ex.getCause().getMessage()).contains(sessionUrl);
    assertThat(ex.getCause().getMessage()).contains("must be restarted");
    assertThat(future.getUploadSessionUrl()).isEqualTo(sessionUrl);
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
    assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(exception.getCause().getSuppressed()).asList().hasSize(1);
    assertThat(exception.getCause().getSuppressed()[0]).isInstanceOf(IOException.class);
    assertThat(exception.getCause().getSuppressed()[0])
        .hasMessageThat()
        .contains("stream close error");
  }

  @Test
  void testRecovery_serverRejectionWithFinalStatus_failsFatalWithoutRetryOrRecovery() {
    String sessionUrl = "https://upload.url/server-rejection-test";
    stubStartSession(sessionUrl);
    StatusCode rejectionStatusCode =
        ResumableUploadStatusCode.of(
            new HttpStatusStatusCode(400, StatusCode.Code.INVALID_ARGUMENT),
            ResumableUploadStatus.FINAL);
    ApiException rejectionException =
        ApiExceptionFactory.createException("Invalid chunk", null, rejectionStatusCode, false);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFailedFuture(rejectionException));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(InvalidArgumentException.class);
    ApiException cause = (ApiException) ex.getCause();
    assertThat(cause.getStatusCode().getTransportCode()).isEqualTo(400);
    assertThat(cause.getMessage()).contains(sessionUrl);
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
    verifyNoInteractions(mockQueryCallable);
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

  private static QueryStatusResponse<String> createQueryResponse(
      @Nullable Long committedOffset,
      @Nullable String response,
      ResumableUploadStatus uploadStatus) {
    return QueryStatusResponse.<String>newBuilder()
        .setCommittedOffset(committedOffset)
        .setResponse(response)
        .setUploadStatus(uploadStatus)
        .build();
  }

  private void stubStartSession(String uploadUrl) {
    when(mockStartCallable.futureCall(any(), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                ResumableUploadSession.newBuilder().setUploadUrl(uploadUrl).build()));
  }

  private static InputStream streamOf(String content) {
    return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
  }

  private static void assertChunk(
      ChunkUploadRequest chunk, long expectedOffset, int expectedSize, boolean expectedFinal) {
    assertThat(chunk.getOffset()).isEqualTo(expectedOffset);
    assertThat(chunk.getPayload().length).isEqualTo(expectedSize);
    assertThat(chunk.isFinal()).isEqualTo(expectedFinal);
  }

  private static class TrackableStream extends ByteArrayInputStream {
    boolean closed = false;
    int totalBytesRead = 0;

    TrackableStream(String content) {
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

    @Override
    public void close() throws IOException {
      closed = true;
      super.close();
    }
  }
}
