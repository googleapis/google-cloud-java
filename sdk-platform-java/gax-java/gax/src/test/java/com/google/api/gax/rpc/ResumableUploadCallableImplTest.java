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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadFuture;
import com.google.api.gax.resumable.ResumableUploadProgressListener;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.retrying.AdaptiveRetryingCallable;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumableUploadCallableImplTest {

  private ScheduledExecutorService executor;
  private ResumableUploadClient mockClient;
  private UnaryCallable<StartUploadRequest, ResumableUploadSession> mockStartCallable;
  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse> mockChunkCallable;
  private UnaryCallable<QueryStatusRequest, QueryStatusResponse> mockQueryCallable;
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
            new BasicResultRetryAlgorithm<String>() {
              @Override
              public boolean shouldRetry(Throwable previousThrowable, String previousResponse) {
                return previousThrowable instanceof UnavailableException;
              }
            },
            new ExponentialRetryAlgorithm(retrySettings, com.google.api.core.NanoClock.getDefaultClock()));

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
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "result:" + body,
            FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(StartUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ResumableUploadSession.create("https://upload.url/session-123")));

    // 16 bytes total: 2 chunks of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, false)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(16, true, "upload-complete-json")));

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("result:upload-complete-json");
    assertThat(future.getUploadUrl()).isEqualTo("https://upload.url/session-123");
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testResumeExistingUploadSession() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "resumed:" + body,
            FakeCallContext.createDefault());

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(QueryStatusResponse.create(0, false)));
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "done")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.resumeCall("https://upload.url/existing-session", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("resumed:done");
    assertThat(future.getUploadUrl()).isEqualTo("https://upload.url/existing-session");
  }

  @Test
  void testResumeExistingUploadSession_alreadyComplete() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "resumed:" + body,
            FakeCallContext.createDefault());

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(QueryStatusResponse.create(8, true, "already-done")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.resumeCall("https://upload.url/existing-session", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("resumed:already-done");
    assertThat(future.getStatus().isCompleted()).isTrue();
    verifyNoInteractions(mockChunkCallable);
  }

  @Test
  void testChunkFailureAndRecoveryViaQueryStatus() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "recovered:" + body,
            FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(StartUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ResumableUploadSession.create("https://upload.url/session-recovery")));

    AtomicInteger chunkAttempt = new AtomicInteger(0);

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            invocation -> {
              int count = chunkAttempt.incrementAndGet();
              if (count == 1) {
                // First chunk attempt drops connection / unavailable
                return ApiFutures.immediateFailedFuture(
                    new UnavailableException(
                        "connection reset", null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), true));
              }
              // Second chunk attempt succeeds
              return ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "recovered-body"));
            });

    // queryStatus reports server committed 0 bytes so far
    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(QueryStatusResponse.create(0, false)));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("recovered:recovered-body");
    assertThat(chunkAttempt.get()).isEqualTo(2);
    verify(mockQueryCallable).futureCall(any(QueryStatusRequest.class), any());
  }

  @Test
  void testRecoveryReportsAlreadyFinalized() throws Exception {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "already-final:" + body,
            FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(StartUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ResumableUploadSession.create("https://upload.url/session-final")));

    // Chunk drops connection after server actually finalized it
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                new UnavailableException(
                    "timeout", null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), true)));

    // queryStatus reports server finalized the upload
    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(QueryStatusResponse.create(8, true, "server-final-json")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("already-final:server-final-json");
  }

  @Test
  void testProgressTrackingAndListenerCallbacks() throws Exception {
    java.util.List<ResumableUploadStatus> progressEvents = new java.util.concurrent.CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(8)
            .setProgressListener(listener)
            .build();

    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            customSettings,
            StartUploadRequest::create,
            body -> "result:" + body,
            FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(StartUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ResumableUploadSession.create("https://upload.url/session-progress")));

    // 16 bytes total: 2 chunks of 8 bytes
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, false)))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(16, true, "complete")));

    byte[] payload = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("my-resource-path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("result:complete");

    ResumableUploadStatus finalStatus = future.getStatus();
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(16);
    assertThat(finalStatus.getUploadUrl()).isEqualTo("https://upload.url/session-progress");
    assertThat(finalStatus.isDone()).isTrue();

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
  void testProgressTrackingWithRecovery() throws Exception {
    java.util.List<ResumableUploadStatus> progressEvents = new java.util.concurrent.CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(8)
            .setProgressListener(listener)
            .build();

    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            customSettings,
            StartUploadRequest::create,
            body -> "recovered:" + body,
            FakeCallContext.createDefault());

    when(mockStartCallable.futureCall(any(StartUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ResumableUploadSession.create("https://upload.url/session-rec-progress")));

    AtomicInteger chunkAttempt = new AtomicInteger(0);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenAnswer(
            invocation -> {
              int count = chunkAttempt.incrementAndGet();
              if (count == 1) {
                return ApiFutures.immediateFailedFuture(
                    new UnavailableException(
                        "connection dropped", null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), true));
              }
              return ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "recovered-body"));
            });

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(QueryStatusResponse.create(0, false)));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.futureCall("path", new ByteArrayInputStream(payload), null);

    String result = future.get();
    assertThat(result).isEqualTo("recovered:recovered-body");

    // Check that RECOVERING state occurred in events
    boolean hadRecoveringState =
        progressEvents.stream()
            .anyMatch(p -> p.getState() == ResumableUploadStatus.State.RECOVERING);
    assertThat(hadRecoveringState).isTrue();

    ResumableUploadStatus finalStatus = future.getStatus();
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(8);
  }

  @Test
  void testDynamicAddProgressListenerReceivesCurrentSnapshot() {
    ResumableUploadCallableImpl<String, String> callable =
        new ResumableUploadCallableImpl<>(
            mockClient,
            adaptiveRetryingCallable,
            defaultSettings,
            StartUploadRequest::create,
            body -> "resumed:" + body,
            FakeCallContext.createDefault());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(ApiFutures.immediateFuture(ChunkUploadResponse.create(8, true, "done")));

    byte[] payload = "01234567".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        callable.resumeCall("https://upload.url/existing-session", new ByteArrayInputStream(payload), null);

    java.util.List<ResumableUploadStatus> dynamicEvents = new java.util.concurrent.CopyOnWriteArrayList<>();
    future.addProgressListener(dynamicEvents::add);

    assertThat(dynamicEvents).isNotEmpty();
    assertThat(dynamicEvents.get(0).getUploadUrl()).isEqualTo("https://upload.url/existing-session");
  }
}
