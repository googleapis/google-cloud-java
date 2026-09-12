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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChunkAttemptCallableTest {

  private static final RetrySettings TEST_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofMillis(100))
          .setRetryDelayMultiplier(1.0)
          .setMaxRetryDelayDuration(Duration.ofMillis(100))
          .setInitialRpcTimeoutDuration(Duration.ofSeconds(10))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(Duration.ofSeconds(10))
          .setTotalTimeoutDuration(Duration.ofMinutes(1))
          .setMaxAttempts(3)
          .build();

  private RetryingFuture<ChunkUploadResponse<String>> mockExternalFuture;
  private TimedAttemptSettings attemptSettings;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    mockExternalFuture = mock(RetryingFuture.class);
    attemptSettings =
        TimedAttemptSettings.newBuilder()
            .setGlobalSettings(TEST_RETRY_SETTINGS)
            .setAttemptCount(0)
            .setOverallAttemptCount(0)
            .setFirstAttemptStartTimeNanos(0)
            .setRetryDelayDuration(Duration.ofSeconds(1))
            .setRandomizedRetryDelayDuration(Duration.ofSeconds(1))
            .setRpcTimeoutDuration(Duration.ZERO)
            .build();
    when(mockExternalFuture.getAttemptSettings()).thenReturn(attemptSettings);
  }

  @Test
  @SuppressWarnings("unchecked")
  void call_successfulChunk_setsAttemptFuture() {
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable =
        mock(UnaryCallable.class);

    ChunkUploadRequest request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl("https://upload.url/test")
            .setPayload(new byte[] {1, 2, 3})
            .setOffset(0L)
            .setFinal(false)
            .build();

    ChunkUploadResponse<String> expectedResponse =
        ChunkUploadResponse.create(false, null, "active");
    ApiFuture<ChunkUploadResponse<String>> internalFuture =
        ApiFutures.immediateFuture(expectedResponse);
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(internalFuture);

    ApiCallContext callContext = FakeCallContext.createDefault();

    ChunkAttemptCallable<String> callable =
        new ChunkAttemptCallable<>(
            mockChunkCallable, request, callContext, UploadCommand.UPLOAD);

    callable.setRetryingFuture(mockExternalFuture);
    ChunkUploadResponse<String> callResult = callable.call();

    // Call returns immediately without blocking
    assertThat(callResult).isNull();
    verify(mockChunkCallable).futureCall(eq(request), any());
    verify(mockExternalFuture).setAttemptFuture(internalFuture);
  }

  @Test
  @SuppressWarnings("unchecked")
  void call_returnsWithoutBlocking_andPropagatesCancellation() {
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<String>> mockChunkCallable =
        mock(UnaryCallable.class);

    SettableApiFuture<ChunkUploadResponse<String>> internalFuture = SettableApiFuture.create();
    when(mockChunkCallable.futureCall(any(ChunkUploadRequest.class), any()))
        .thenReturn(internalFuture);

    ChunkUploadRequest request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl("https://upload.url/test")
            .setPayload(new byte[] {1, 2, 3})
            .setOffset(0L)
            .setFinal(false)
            .build();

    ApiCallContext callContext = FakeCallContext.createDefault();

    ChunkAttemptCallable<String> callable =
        new ChunkAttemptCallable<>(
            mockChunkCallable, request, callContext, UploadCommand.UPLOAD);

    List<Runnable> listeners = new ArrayList<>();
    doAnswer(
            invocation -> {
              listeners.add(invocation.getArgument(0));
              return null;
            })
        .when(mockExternalFuture)
        .addListener(any(), any());

    callable.setRetryingFuture(mockExternalFuture);

    // Call returns immediately without blocking
    assertThat(callable.call()).isNull();
    assertThat(internalFuture.isDone()).isFalse();

    // Cancellation of external future propagates to internal future
    when(mockExternalFuture.isCancelled()).thenReturn(true);
    for (Runnable listener : listeners) {
      listener.run();
    }
    assertThat(internalFuture.isCancelled()).isTrue();
  }
}
