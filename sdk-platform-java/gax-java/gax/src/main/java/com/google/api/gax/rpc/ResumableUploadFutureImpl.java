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
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Implementation of {@link ResumableUploadFuture} responsible for the end-to-end management of a
 * resumable upload session.
 *
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@NullMarked
final class ResumableUploadFutureImpl<ResponseT> implements ResumableUploadFuture<ResponseT> {

  private final Object lock = new Object();

  private final ApiFuture<ResumableUploadSession> startFuture;
  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final InputStream payload;
  private final ResumableUploadCallSettings settings;
  private final ApiCallContext callContext;
  private final ScheduledExecutorService executor;
  private final SettableApiFuture<ResponseT> resultFuture = SettableApiFuture.create();

  private volatile @Nullable String uploadSessionUrl;

  @GuardedBy("lock")
  private @Nullable ApiFuture<?> inFlightFuture;

  /**
   * Creates and initiates a new resumable upload future tracking session initiation and chunk
   * streaming.
   *
   * <p>The provided {@code payload} stream is managed by the returned future and will be closed
   * automatically upon completion, failure, or cancellation.
   */
  static <ResponseT> ResumableUploadFutureImpl<ResponseT> create(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext,
      ScheduledExecutorService executor) {
    ResumableUploadFutureImpl<ResponseT> future =
        new ResumableUploadFutureImpl<>(
            startFuture, uploadChunkCallable, payload, settings, callContext, executor);
    try {
      future.start();
    } catch (Throwable t) {
      future.fail(t);
    }
    return future;
  }

  private ResumableUploadFutureImpl(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext,
      ScheduledExecutorService executor) {
    this.startFuture = checkNotNull(startFuture, "startFuture must not be null");
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.payload = checkNotNull(payload, "payload must not be null");
    this.settings = checkNotNull(settings, "settings must not be null");
    checkArgument(settings.getChunkSize() > 0, "chunkSize must be > 0");
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.executor = checkNotNull(executor, "executor must not be null");
    this.inFlightFuture = startFuture;
  }

  private void start() {
    ApiFutures.addCallback(
        startFuture,
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            if (resultFuture.isDone()) {
              return;
            }
            uploadSessionUrl = session.getUploadUrl();
            ResumableUploadChunkCoordinator<ResponseT> coordinator =
                new ResumableUploadChunkCoordinator<>(
                    uploadChunkCallable,
                    session.getUploadUrl(),
                    payload,
                    settings.getChunkSize(),
                    callContext,
                    executor,
                    ResumableUploadFutureImpl.this);
            try {
              coordinator.start();
            } catch (Throwable t) {
              fail(t);
            }
          }

          @Override
          public void onFailure(Throwable t) {
            if (t instanceof CancellationException || resultFuture.isDone()) {
              return;
            }
            fail(t);
          }
        },
        executor);
  }

  /**
   * Registers the active in-flight future for cancellation. If this session future has already been
   * canceled, the supplied future is canceled immediately.
   */
  void setInFlightFuture(ApiFuture<?> inFlightFuture) {
    boolean shouldCancel = false;
    synchronized (lock) {
      if (resultFuture.isDone()) {
        shouldCancel = resultFuture.isCancelled();
      } else {
        this.inFlightFuture = inFlightFuture;
      }
    }
    if (shouldCancel) {
      inFlightFuture.cancel(true);
    }
  }

  void succeed(@Nullable ResponseT result) {
    synchronized (lock) {
      inFlightFuture = null;
    }
    closePayload();
    resultFuture.set(result);
  }

  void fail(Throwable t) {
    synchronized (lock) {
      inFlightFuture = null;
    }
    closePayload();
    resultFuture.setException(t);
  }

  private void closePayload() {
    try {
      payload.close();
    } catch (IOException ignored) {
      // Suppressed during stream cleanup
    }
  }

  @Override
  public @Nullable String getUploadSessionUrl() {
    return uploadSessionUrl;
  }

  @Override
  public void addListener(Runnable listener, Executor executor) {
    resultFuture.addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    boolean cancelled;
    ApiFuture<?> inFlight;
    synchronized (lock) {
      cancelled = resultFuture.cancel(mayInterruptIfRunning);
      inFlight = this.inFlightFuture;
      this.inFlightFuture = null;
    }
    if (inFlight != null) {
      inFlight.cancel(mayInterruptIfRunning);
    }
    closePayload();
    return cancelled;
  }

  @Override
  public boolean isCancelled() {
    return resultFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return resultFuture.isDone();
  }

  @Override
  public ResponseT get() throws InterruptedException, ExecutionException {
    return resultFuture.get();
  }

  @Override
  public ResponseT get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return resultFuture.get(timeout, unit);
  }
}
