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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
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

  private static final Duration DEFAULT_GLOBAL_TIMEOUT = Duration.ofMinutes(15);

  private final Object lock = new Object();

  private final ApiFuture<ResumableUploadSession> startFuture;
  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;
  private final ResumableUploadCallSettings settings;
  private final ApiCallContext callContext;
  private final ScheduledExecutorService executor;
  private final ExponentialRetryAlgorithm recoveryAlgorithm;
  private final ResumableUploadProgressTracker progressTracker =
      new ResumableUploadProgressTracker();
  private final SettableApiFuture<ResponseT> resultFuture = SettableApiFuture.create();

  private volatile @Nullable InputStream payload;
  private volatile @Nullable String uploadSessionUrl;

  // Tracks the current operation's Future (start, chunk upload) to propagate cancellation, or
  // null once a terminal transition (succeed, fail, cancel) has claimed completion.
  @GuardedBy("lock")
  private @Nullable ApiFuture<?> inFlightFuture;

  /**
   * Creates and initiates a new resumable upload future tracking session initiation and chunk
   * streaming.
   *
   * <p>The stream opened from {@code payloadSupplier} is managed by the returned future and will be
   * closed automatically upon completion, failure, or cancellation.
   */
  static <ResponseT> ResumableUploadFutureImpl<ResponseT> create(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      InputStreamSupplier payloadSupplier,
      ResumableUploadCallSettings settings,
      ClientContext clientContext,
      ExponentialRetryAlgorithm recoveryAlgorithm) {
    checkNotNull(payloadSupplier, "payloadSupplier must not be null");
    ResumableUploadFutureImpl<ResponseT> future =
        new ResumableUploadFutureImpl<>(
            startFuture,
            uploadChunkCallable,
            queryStatusCallable,
            settings,
            clientContext,
            recoveryAlgorithm);
    try {
      future.start(payloadSupplier);
    } catch (Throwable t) {
      future.fail(t);
    }
    return future;
  }

  private ResumableUploadFutureImpl(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      ResumableUploadCallSettings settings,
      ClientContext clientContext,
      ExponentialRetryAlgorithm recoveryAlgorithm) {
    this.startFuture = checkNotNull(startFuture, "startFuture must not be null");
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.queryStatusCallable =
        checkNotNull(queryStatusCallable, "queryStatusCallable must not be null");
    this.settings = checkNotNull(settings, "settings must not be null");
    checkArgument(settings.getChunkSize() > 0, "chunkSize must be > 0");
    checkNotNull(clientContext, "clientContext must not be null");
    this.callContext = clientContext.getDefaultCallContext();
    this.executor = checkNotNull(clientContext.getExecutor(), "executor must not be null");
    this.recoveryAlgorithm = checkNotNull(recoveryAlgorithm, "recoveryAlgorithm must not be null");
    this.inFlightFuture = startFuture;
  }

  private void start(InputStreamSupplier payloadSupplier) throws IOException {
    Duration timeout = firstNonNull(settings.getGlobalTimeout(), DEFAULT_GLOBAL_TIMEOUT);
    ScheduledFuture<?> timeoutFuture =
        executor.schedule(this::onTimeout, timeout.toMillis(), TimeUnit.MILLISECONDS);
    resultFuture.addListener(() -> timeoutFuture.cancel(false), MoreExecutors.directExecutor());
    this.payload = checkNotNull(payloadSupplier.get(), "payload supplier returned null");
    ApiFutures.addCallback(
        startFuture,
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            String sessionUrl = session.getUploadUrl();
            ResumableUploadChunkCoordinator<ResponseT> coordinator =
                new ResumableUploadChunkCoordinator<>(
                    uploadChunkCallable,
                    queryStatusCallable,
                    sessionUrl,
                    payload,
                    settings.getChunkSize(),
                    callContext,
                    recoveryAlgorithm,
                    executor,
                    progressTracker);
            ApiFuture<ResponseT> uploadFuture = coordinator.getFuture();
            synchronized (lock) {
              if (inFlightFuture == null) {
                return;
              }
              uploadSessionUrl = sessionUrl;
              inFlightFuture = uploadFuture;
            }
            ApiFutures.addCallback(
                uploadFuture,
                new ApiFutureCallback<ResponseT>() {
                  @Override
                  public void onSuccess(ResponseT response) {
                    succeed(response);
                  }

                  @Override
                  public void onFailure(Throwable t) {
                    if (t instanceof CancellationException) {
                      return;
                    }
                    fail(t);
                  }
                },
                MoreExecutors.directExecutor());
            coordinator.start();
          }

          @Override
          public void onFailure(Throwable t) {
            if (t instanceof CancellationException || resultFuture.isDone()) {
              return;
            }
            fail(t);
          }
        },
        MoreExecutors.directExecutor());
  }

  private void onTimeout() {
    String sessionUrl = uploadSessionUrl;
    String message;
    if (sessionUrl != null) {
      message = "Resumable upload timed out for session: " + sessionUrl;
    } else {
      message = "Resumable upload timed out before session initiation completed";
    }
    fail(ApiExceptionFactory.createException(message, null, TIMEOUT_STATUS_CODE, false));
  }

  private void succeed(@Nullable ResponseT result) {
    synchronized (lock) {
      if (inFlightFuture == null) {
        return;
      }
      inFlightFuture = null;
    }
    closePayload();
    resultFuture.set(result);
  }

  private void fail(Throwable t) {
    ApiFuture<?> inFlight;
    synchronized (lock) {
      if (inFlightFuture == null) {
        return;
      }
      inFlight = inFlightFuture;
      inFlightFuture = null;
    }
    if (inFlight != null) {
      inFlight.cancel(true);
    }
    progressTracker.onFailed();
    closePayload();
    resultFuture.setException(t);
  }

  private void closePayload() {
    if (payload == null) {
      return;
    }
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
  public void addProgressListener(ResumableUploadProgressListener listener, Executor executor) {
    checkNotNull(listener, "listener must not be null");
    checkNotNull(executor, "executor must not be null");
    progressTracker.addListener(listener, executor);
  }

  @Override
  public ResumableUploadProgress getProgress() {
    return progressTracker.getProgress();
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
      if (inFlightFuture == null) {
        return false;
      }
      cancelled = resultFuture.cancel(mayInterruptIfRunning);
      inFlight = inFlightFuture;
      inFlightFuture = null;
    }
    if (inFlight != null) {
      inFlight.cancel(mayInterruptIfRunning);
    }
    progressTracker.onFailed();
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

  private static final StatusCode TIMEOUT_STATUS_CODE =
      new StatusCode() {
        @Override
        public StatusCode.Code getCode() {
          return StatusCode.Code.DEADLINE_EXCEEDED;
        }

        @Override
        public @Nullable Object getTransportCode() {
          return null;
        }
      };
}
