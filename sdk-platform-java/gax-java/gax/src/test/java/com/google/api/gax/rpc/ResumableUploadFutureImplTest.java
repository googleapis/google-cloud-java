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

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

class ResumableUploadFutureImplTest {

  @SuppressWarnings("unchecked")
  private ResumableUploadChunkCoordinator<String> createCoordinator(
      SettableApiFuture<String> result,
      ApiFuture<ResumableUploadSession> startFuture,
      SettableApiFuture<ChunkUploadResponse<String>> chunkFuture) {
    ClientContext clientContext =
        ClientContext.newBuilder().setDefaultCallContext(FakeCallContext.createDefault()).build();
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(chunkFuture);
    UnaryCallable<QueryStatusRequest, QueryStatusResponse<String>> mockQueryCallable =
        mock(UnaryCallable.class, withSettings().withoutAnnotations());
    ResumableUploadCallSettings settings = ResumableUploadCallSettings.newBuilder().build();
    return new ResumableUploadChunkCoordinator<>(
        result,
        startFuture,
        mockChunkCallable,
        mockQueryCallable,
        new ByteArrayInputStream(new byte[] {1, 2, 3}),
        settings,
        clientContext.getDefaultCallContext(),
        clientContext);
  }

  @Test
  void handle_delegatesToResultAndCoordinator() throws Exception {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    SettableApiFuture<ChunkUploadResponse<String>> chunkFuture = SettableApiFuture.create();
    ResumableUploadChunkCoordinator<String> coordinator =
        createCoordinator(result, startFuture, chunkFuture);

    ResumableUploadFutureImpl<String> handle = new ResumableUploadFutureImpl<>(result, coordinator);

    assertThat(handle.getUploadSessionUrl()).isNull();
    assertThat(handle.isDone()).isFalse();
    assertThat(handle.isCancelled()).isFalse();

    coordinator.start();
    startFuture.set(
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url/test-session")
            .build());
    assertThat(handle.getUploadSessionUrl()).isEqualTo("https://upload.url/test-session");

    AtomicBoolean listenerFired = new AtomicBoolean(false);
    handle.addListener(() -> listenerFired.set(true), MoreExecutors.directExecutor());

    result.set("response-ok");

    assertThat(handle.isDone()).isTrue();
    assertThat(handle.get()).isEqualTo("response-ok");
    assertThat(listenerFired.get()).isTrue();
  }

  @Test
  void handle_cancel_delegatesToCoordinatorAndResult() {
    SettableApiFuture<String> result = SettableApiFuture.create();
    SettableApiFuture<ResumableUploadSession> startFuture = SettableApiFuture.create();
    SettableApiFuture<ChunkUploadResponse<String>> chunkFuture = SettableApiFuture.create();
    ResumableUploadChunkCoordinator<String> coordinator =
        createCoordinator(result, startFuture, chunkFuture);
    coordinator.start();

    ResumableUploadFutureImpl<String> handle = new ResumableUploadFutureImpl<>(result, coordinator);

    boolean cancelled = handle.cancel(true);

    assertThat(cancelled).isTrue();
    assertThat(handle.isCancelled()).isTrue();
    assertThat(result.isCancelled()).isTrue();
    assertThat(startFuture.isCancelled()).isTrue();
  }
}
