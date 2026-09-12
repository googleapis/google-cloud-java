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
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumableUploadChunkCoordinatorTest {

  private ScheduledExecutorService executor;
  private ClientContext clientContext;
  private ApiCallContext callContext;
  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable;
  private ResumableUploadCallSettings settings;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    executor = Executors.newScheduledThreadPool(2);
    callContext = FakeCallContext.createDefault();
    clientContext =
        ClientContext.newBuilder().setDefaultCallContext(callContext).setExecutor(executor).build();
    mockChunkCallable = mock(UnaryCallable.class, withSettings().withoutAnnotations());
    settings = ResumableUploadCallSettings.newBuilder().setChunkSize(256).build();
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
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

    AtomicInteger closeCount = new AtomicInteger(0);
    ByteArrayInputStream payload =
        new ByteArrayInputStream(new byte[128]) {
          @Override
          public void close() throws IOException {
            closeCount.incrementAndGet();
            super.close();
          }
        };

    ResumableUploadChunkCoordinator<String> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result, startFuture, mockChunkCallable, payload, settings, callContext, clientContext);

    AtomicInteger completionListenerCount = new AtomicInteger(0);
    result.addListener(completionListenerCount::incrementAndGet, MoreExecutors.directExecutor());

    coordinator.start();

    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch doneLatch = new CountDownLatch(2);

    executor.execute(
        () -> {
          try {
            startLatch.await();
            coordinator.cancel(true);
            result.cancel(true);
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

    assertThat(result.isDone()).isTrue();
    assertThat(closeCount.get()).isEqualTo(1);
    assertThat(completionListenerCount.get()).isEqualTo(1);
  }
}
