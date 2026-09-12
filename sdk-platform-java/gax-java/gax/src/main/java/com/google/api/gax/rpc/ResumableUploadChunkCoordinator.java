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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Coordinates chunk transmission steps and manages lifecycle of a resumable upload session.
 *
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@NullMarked
final class ResumableUploadChunkCoordinator<ResponseT> {

  static final RetrySettings DEFAULT_CHUNK_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofMillis(100))
          .setRetryDelayMultiplier(1.3)
          .setMaxRetryDelayDuration(Duration.ofMinutes(1))
          .setInitialRpcTimeoutDuration(Duration.ofSeconds(30))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(Duration.ofSeconds(30))
          .setTotalTimeoutDuration(Duration.ofMinutes(5))
          .setMaxAttempts(5)
          .build();

  private static final byte[] EMPTY_PAYLOAD = new byte[0];

  private final Object lock = new Object();
  private final AtomicBoolean dispatching = new AtomicBoolean(false);
  private final AtomicLong nextChunkOffset = new AtomicLong(-1L);

  private final SettableApiFuture<ResponseT> result;
  private final ApiFuture<ResumableUploadSession> startFuture;
  private final RetryingCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      retryingChunkCallable;
  private final InputStream payload;
  private final byte[] buffer;
  private final int chunkSize;
  private final ApiCallContext callContext;
  private final ClientContext clientContext;
  private final RetrySettings chunkRetrySettings;

  private volatile @Nullable String uploadSessionUrl;

  @GuardedBy("lock")
  private boolean done;

  @GuardedBy("lock")
  private boolean payloadClosed;

  @GuardedBy("lock")
  private @Nullable ApiFuture<?> inFlightFuture;

  ResumableUploadChunkCoordinator(
      SettableApiFuture<ResponseT> result,
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext,
      ClientContext clientContext) {
    this.result = checkNotNull(result, "result must not be null");
    this.startFuture = checkNotNull(startFuture, "startFuture must not be null");
    checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.payload = checkNotNull(payload, "payload must not be null");
    checkNotNull(settings, "settings must not be null");
    checkArgument(settings.getChunkSize() > 0, "chunkSize must be > 0");
    this.chunkSize = settings.getChunkSize();
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.clientContext = checkNotNull(clientContext, "clientContext must not be null");
    this.chunkRetrySettings = DEFAULT_CHUNK_RETRY_SETTINGS;
    this.buffer = new byte[chunkSize];

    RetryAlgorithm<ChunkUploadResponse<ResponseT>> retryAlgorithm =
        new RetryAlgorithm<>(
            new ResumableUploadResultRetryAlgorithm<>(ResumableUploadCommand.UPLOAD),
            new ExponentialRetryAlgorithm(chunkRetrySettings, clientContext.getClock()));
    ScheduledRetryingExecutor<ChunkUploadResponse<ResponseT>> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());
    this.retryingChunkCallable =
        new RetryingCallable<>(
            clientContext.getDefaultCallContext(), uploadChunkCallable, retryingExecutor);

    synchronized (lock) {
      this.inFlightFuture = startFuture;
    }
  }

  void start() {
    ApiFutures.addCallback(
        startFuture,
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            synchronized (lock) {
              if (done) {
                return;
              }
            }
            uploadSessionUrl = session.getUploadUrl();
            scheduleNextChunk(0L);
          }

          @Override
          public void onFailure(Throwable t) {
            if (t instanceof CancellationException) {
              return;
            }
            finish(null, t);
          }
        },
        MoreExecutors.directExecutor());
  }

  @Nullable String getUploadSessionUrl() {
    return uploadSessionUrl;
  }

  void setInFlightFuture(ApiFuture<?> future) {
    boolean shouldCancel = false;
    synchronized (lock) {
      if (done) {
        shouldCancel = result.isCancelled();
      } else {
        this.inFlightFuture = future;
      }
    }
    if (shouldCancel) {
      future.cancel(true);
    }
  }

  void cancel(boolean mayInterruptIfRunning) {
    ApiFuture<?> inFlight;
    synchronized (lock) {
      if (done) {
        return;
      }
      done = true;
      inFlight = this.inFlightFuture;
      this.inFlightFuture = null;
    }
    if (inFlight != null) {
      inFlight.cancel(mayInterruptIfRunning);
    }
    closePayload();
  }

  private void finish(@Nullable ResponseT response, @Nullable Throwable error) {
    synchronized (lock) {
      if (done) {
        return;
      }
      done = true;
      inFlightFuture = null;
    }
    IOException closeError = closePayload();
    if (error == null) {
      result.set(response);
    } else {
      if (closeError != null) {
        error.addSuppressed(closeError);
      }
      result.setException(error);
    }
  }

  private @Nullable IOException closePayload() {
    synchronized (lock) {
      if (payloadClosed) {
        return null;
      }
      payloadClosed = true;
    }
    try {
      payload.close();
      return null;
    } catch (IOException e) {
      return e;
    }
  }

  private void scheduleNextChunk(long offset) {
    nextChunkOffset.set(offset);
    if (dispatching.compareAndSet(false, true)) {
      driveLoop();
    }
  }

  private void driveLoop() {
    do {
      long offset = nextChunkOffset.getAndSet(-1L);
      if (offset >= 0) {
        transmitSingleChunk(offset);
      }
      dispatching.set(false);
    } while (nextChunkOffset.get() >= 0 && dispatching.compareAndSet(false, true));
  }

  private void transmitSingleChunk(long currentOffset) {
    synchronized (lock) {
      if (done) {
        return;
      }
    }

    int bytesRead;
    try {
      bytesRead = ByteStreams.read(payload, buffer, 0, chunkSize);
    } catch (IOException e) {
      finish(null, e);
      return;
    }

    boolean isFinal = bytesRead < chunkSize;
    byte[] chunkPayload;
    if (bytesRead == chunkSize) {
      chunkPayload = buffer;
    } else if (bytesRead == 0) {
      chunkPayload = EMPTY_PAYLOAD;
    } else {
      chunkPayload = Arrays.copyOf(buffer, bytesRead);
    }

    String url = uploadSessionUrl;
    if (url == null) {
      finish(null, new IllegalStateException("Upload session URL not available"));
      return;
    }

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(url)
            .setPayload(chunkPayload)
            .setOffset(currentOffset)
            .setFinal(isFinal)
            .build();

    RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture =
        retryingChunkCallable.futureCall(chunkRequest, callContext);
    setInFlightFuture(retryingFuture);

    long chunkLength = chunkPayload.length;
    ApiFutures.addCallback(
        retryingFuture,
        new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
          @Override
          public void onSuccess(ChunkUploadResponse<ResponseT> response) {
            synchronized (lock) {
              if (done) {
                return;
              }
            }
            long nextOffset = currentOffset + chunkLength;
            if (response.isComplete()) {
              finish(response.getResponse(), null);
            } else if (isFinal) {
              finish(
                  null,
                  new IllegalStateException(
                      "Upload stream ended and final chunk was transmitted, but server returned"
                          + " incomplete status for upload URL: "
                          + url));
            } else {
              scheduleNextChunk(nextOffset);
            }
          }

          @Override
          public void onFailure(Throwable t) {
            if (t instanceof CancellationException) {
              return;
            }
            finish(null, t);
          }
        },
        MoreExecutors.directExecutor());
  }
}
