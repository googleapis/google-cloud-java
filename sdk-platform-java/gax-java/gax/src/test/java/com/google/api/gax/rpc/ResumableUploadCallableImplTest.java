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
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
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

  private ResumableUploadCallSettings defaultSettings;
  private FakeCallContext callContext;
  private ResumableUploadCallableImpl<String, String> callable;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    mockClient = mock(ResumableUploadClient.class, withSettings().withoutAnnotations());
    mockStartCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    mockChunkCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());

    lenient().when(mockClient.startUploadCallable()).thenReturn(mockStartCallable);
    lenient().when(mockClient.uploadChunkCallable()).thenReturn(mockChunkCallable);

    defaultSettings = ResumableUploadCallSettings.newBuilder().setChunkSize(8).build();
    callContext = FakeCallContext.createDefault();
    ClientContext clientContext =
        ClientContext.newBuilder().setDefaultCallContext(callContext).build();
    callable = new ResumableUploadCallableImpl<>(mockClient, defaultSettings, clientContext);
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
  void testChunkRetry_cat2Failure_failsFastWithoutRetrying() {
    stubStartSession("https://upload.url/chunk-cat2-fail");
    // HTTP 400 Bad Request is Category 2 (RECOVERABLE)
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                createApiException(400, StatusCode.Code.INVALID_ARGUMENT)));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("hello"), null);

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) exception.getCause()).getStatusCode().getTransportCode())
        .isEqualTo(400);

    // In G4, Category 2 is not yet retryable / recoverable, so it fails after 1 attempt.
    verify(mockChunkCallable, times(1)).futureCall(any(), any());
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
    assertThat(stream.closed).isTrue();
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
    // Leave startFuture incomplete so sessionFuture does not automatically instantiate its
    // coordinator
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();

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
  void testBufferWindow_reusesSingleArrayAcrossChunks() throws Exception {
    stubStartSession("https://upload.url/reuse-array");
    // 20 bytes with chunkSize = 8 -> 3 chunks: [0..8), [8..16), [16..20)
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(false, null)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "done")));

    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("01234567890123456789"), null);

    assertThat(future.get()).isEqualTo("done");
    ArgumentCaptor<ChunkUploadRequest> captor = ArgumentCaptor.forClass(ChunkUploadRequest.class);
    verify(mockChunkCallable, times(3)).futureCall(captor.capture(), any());
    List<ChunkUploadRequest> chunks = captor.getAllValues();

    // All chunks must reference the exact same backing byte[] instance
    byte[] backingArray = chunks.get(0).getPayload();
    assertThat(chunks.get(1).getPayload()).isSameInstanceAs(backingArray);
    assertThat(chunks.get(2).getPayload()).isSameInstanceAs(backingArray);
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
                ResumableUploadSession.newBuilder().setUploadUrl(uploadUrl).build()));
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
    boolean closed = false;

    TrackableStream(String content) {
      super(content.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void close() throws IOException {
      closed = true;
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
