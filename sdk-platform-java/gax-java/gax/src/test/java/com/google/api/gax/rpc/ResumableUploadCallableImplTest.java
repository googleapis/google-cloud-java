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
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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

  private ResumableUploadCallSettings defaultSettings;
  private FakeCallContext callContext;
  private ScheduledExecutorService executor;
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
    executor = Executors.newSingleThreadScheduledExecutor();
    callable =
        new ResumableUploadCallableImpl<>(mockClient, defaultSettings, callContext, executor);
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    if (executor != null) {
      executor.shutdownNow();
      executor.awaitTermination(5, TimeUnit.SECONDS);
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
  void testUploadCallable_setInFlightFutureAfterCancel_immediatelyCancelsFuture() {
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    when(mockStartCallable.futureCall(any(), any())).thenReturn(startFuture);
    ResumableUploadFuture<String> future =
        callable.futureCall("resource-path", streamOf("data"), null);
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();

    SettableApiFuture<String> lateFuture = SettableApiFuture.create();
    ((ResumableUploadFutureImpl<String>) future).setInFlightFuture(lateFuture);
    assertThat(lateFuture.isCancelled()).isTrue();
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
  void testUploadCallable_customExecutor_executesOnExecutor() throws Exception {
    AtomicInteger tasksRun = new AtomicInteger();
    ScheduledExecutorService customExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          public void execute(Runnable command) {
            tasksRun.incrementAndGet();
            super.execute(command);
          }
        };
    try {
      ResumableUploadCallableImpl<String, String> customCallable =
          new ResumableUploadCallableImpl<>(
              mockClient, defaultSettings, callContext, customExecutor);
      stubStartSession("https://upload.url/executor");
      when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
          .thenReturn(
              ApiFutures.immediateFuture(ChunkUploadResponse.create(true, "executor-done")));

      ResumableUploadFuture<String> future =
          customCallable.futureCall("resource-path", streamOf("data"), null);
      assertThat(future.get()).isEqualTo("executor-done");
      assertThat(tasksRun.get()).isGreaterThan(0);
    } finally {
      customExecutor.shutdownNow();
      customExecutor.awaitTermination(5, TimeUnit.SECONDS);
    }
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

    TrackableStream(String content) {
      super(content.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void close() throws IOException {
      closed = true;
      super.close();
    }
  }
}
