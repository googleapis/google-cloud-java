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
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumableUploadChunkCoordinatorTest {

  private ScheduledExecutorService executor;
  private ClientContext clientContext;
  private ApiCallContext callContext;
  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable;
  private UnaryCallable<QueryStatusRequest, QueryStatusResponse<String>> mockQueryCallable;
  private ResumableUploadCallSettings settings;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    executor = Executors.newScheduledThreadPool(2);
    callContext = FakeCallContext.createDefault();
    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(callContext)
            .setExecutor(executor)
            .build();
    mockChunkCallable = mock(UnaryCallable.class);
    mockQueryCallable = mock(UnaryCallable.class);
    settings = ResumableUploadCallSettings.newBuilder().setChunkSize(256).build();
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testCategory1_transientErrorRetriesInPlace_doesNotPublishRecovering() throws Exception {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/cat1-test")
            .build());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                ApiExceptionFactory.createException(
                    "Unavailable",
                    null,
                    new TestStatusCode(503, StatusCode.Code.UNAVAILABLE),
                    false)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(true, "done-cat1", "final")));

    List<ResumableUploadStatus.State> observedStates =
        Collections.synchronizedList(new ArrayList<>());
    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startFuture,
            mockChunkCallable,
            mockQueryCallable,
            new ByteArrayInputStream(new byte[128]),
            settings,
            callContext,
            clientContext);

    coordinator.addProgressListener(
        status -> observedStates.add(status.getState()), MoreExecutors.directExecutor());
    coordinator.start();

    String response = result.get(5, TimeUnit.SECONDS);
    assertThat(response).isEqualTo("done-cat1");
    assertThat(observedStates).contains(ResumableUploadStatus.State.STARTED);
    assertThat(observedStates).contains(ResumableUploadStatus.State.UPLOADING);
    assertThat(observedStates).contains(ResumableUploadStatus.State.FINALIZED);
    assertThat(observedStates).doesNotContain(ResumableUploadStatus.State.RECOVERING);
  }

  @Test
  void testCategory2_recoverableError_queriesAndRealigns() throws Exception {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/cat2-test")
            .build());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                ApiExceptionFactory.createException(
                    "Bad Request",
                    null,
                    new TestStatusCode(400, StatusCode.Code.INVALID_ARGUMENT),
                    false)))
        .thenReturn(
            ApiFutures.immediateFuture(
                ChunkUploadResponse.create(true, "done-cat2", "final")));

    when(mockQueryCallable.futureCall(any(QueryStatusRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFuture(
                QueryStatusResponse.<String>newBuilder()
                    .setComplete(false)
                    .setCommittedOffset(0L)
                    .setUploadStatus("active")
                    .build()));

    List<ResumableUploadStatus.State> observedStates =
        Collections.synchronizedList(new ArrayList<>());
    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startFuture,
            mockChunkCallable,
            mockQueryCallable,
            new ByteArrayInputStream(new byte[128]),
            settings,
            callContext,
            clientContext);

    coordinator.addProgressListener(
        status -> observedStates.add(status.getState()), MoreExecutors.directExecutor());
    coordinator.start();

    String response = result.get(5, TimeUnit.SECONDS);
    assertThat(response).isEqualTo("done-cat2");
    assertThat(observedStates).contains(ResumableUploadStatus.State.RECOVERING);
    assertThat(observedStates).contains(ResumableUploadStatus.State.OFFSET_RECEIVED);
    assertThat(observedStates).contains(ResumableUploadStatus.State.FINALIZED);
  }

  @Test
  void testRetryBudgetExhaustion_failsUpload() throws Exception {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/exhaust-test")
            .build());

    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                ApiExceptionFactory.createException(
                    "Service Unavailable",
                    null,
                    new TestStatusCode(503, StatusCode.Code.UNAVAILABLE),
                    false)));

    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startFuture,
            mockChunkCallable,
            mockQueryCallable,
            new ByteArrayInputStream(new byte[128]),
            settings,
            callContext,
            clientContext);

    coordinator.start();
    ExecutionException ex =
        assertThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
    assertThat(ex.getCause()).isInstanceOf(ApiException.class);
    assertThat(coordinator.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
  }

  @Test
  void testTerminalArbitration_concurrentCancelAndComplete_happensExactlyOnce() throws Exception {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/arbitration-test")
            .build());

    SettableApiFuture<ChunkUploadResponse<String>> chunkFuture = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(chunkFuture);

    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startFuture,
            mockChunkCallable,
            mockQueryCallable,
            new ByteArrayInputStream(new byte[128]),
            settings,
            callContext,
            clientContext);

    List<ResumableUploadStatus> terminalStatuses =
        Collections.synchronizedList(new ArrayList<>());
    coordinator.addProgressListener(
        status -> {
          if (status.getState() == ResumableUploadStatus.State.FINALIZED
              || status.getState() == ResumableUploadStatus.State.FAILED) {
            terminalStatuses.add(status);
          }
        },
        MoreExecutors.directExecutor());

    coordinator.start();

    // Concurrently trigger cancel and complete
    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch doneLatch = new CountDownLatch(2);

    executor.execute(
        () -> {
          try {
            startLatch.await();
            coordinator.cancel(true);
          } catch (Exception e) {
            // ignore
          } finally {
            doneLatch.countDown();
          }
        });

    executor.execute(
        () -> {
          try {
            startLatch.await();
            chunkFuture.set(ChunkUploadResponse.create(true, "done", "final"));
          } catch (Exception e) {
            // ignore
          } finally {
            doneLatch.countDown();
          }
        });

    startLatch.countDown();
    assertThat(doneLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // Either cancelled or completed, but exactly one terminal status update was published
    assertThat(terminalStatuses).hasSize(1);
  }

  private static class TestStatusCode implements StatusCode {
    private final int transportCode;
    private final StatusCode.Code code;

    TestStatusCode(int transportCode, StatusCode.Code code) {
      this.transportCode = transportCode;
      this.code = code;
    }

    @Override
    public Code getCode() {
      return code;
    }

    @Override
    public Object getTransportCode() {
      return transportCode;
    }
  }
}
