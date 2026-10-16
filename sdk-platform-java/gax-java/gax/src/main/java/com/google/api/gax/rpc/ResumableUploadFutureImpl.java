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

  private final @Nullable ApiFuture<ResumableUploadSession> startFuture;
  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;
  private final ResumableUploadOptions options;
  private final ApiCallContext callContext;
  private final ScheduledExecutorService executor;
  private final ExponentialRetryAlgorithm recoveryAlgorithm;
  private final ResumableUploadProgressTracker progressTracker;
  private final SettableApiFuture<ResponseT> resultFuture = SettableApiFuture.create();

  private volatile @Nullable InputStream payload;

  @GuardedBy("lock")
  private @Nullable String uploadSessionUrl;

  @GuardedBy("lock")
  private @Nullable Integer effectiveChunkSize;

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
      ResumableUploadOptions options,
      ClientContext clientContext,
      ExponentialRetryAlgorithm recoveryAlgorithm) {
    checkNotNull(startFuture, "startFuture must not be null");
    checkNotNull(payloadSupplier, "payloadSupplier must not be null");
    ResumableUploadFutureImpl<ResponseT> future =
        new ResumableUploadFutureImpl<>(
            startFuture,
            /* sessionUrl= */ null,
            uploadChunkCallable,
            queryStatusCallable,
            options,
            clientContext,
            recoveryAlgorithm,
            ResumableUploadProgressTracker.create());
    try {
      future.start(payloadSupplier);
    } catch (Throwable t) {
      future.fail(t);
    }
    return future;
  }

  /**
   * Creates and initiates a resumable upload future that resumes an existing upload session from
   * {@code sessionUrl}.
   *
   * <p>The stream opened from {@code payloadSupplier} is managed by the returned future and will be
   * closed automatically upon completion, failure, or cancellation.
   */
  static <ResponseT> ResumableUploadFutureImpl<ResponseT> createForResume(
      String sessionUrl,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      InputStreamSupplier payloadSupplier,
      ResumableUploadOptions options,
      ClientContext clientContext,
      ExponentialRetryAlgorithm recoveryAlgorithm) {
    checkNotNull(sessionUrl, "sessionUrl must not be null");
    checkNotNull(payloadSupplier, "payloadSupplier must not be null");
    ResumableUploadFutureImpl<ResponseT> future =
        new ResumableUploadFutureImpl<>(
            /* startFuture= */ null,
            sessionUrl,
            uploadChunkCallable,
            queryStatusCallable,
            options,
            clientContext,
            recoveryAlgorithm,
            ResumableUploadProgressTracker.createForResume(sessionUrl, options.getChunkSize()));
    try {
      future.resume(sessionUrl, payloadSupplier);
    } catch (Throwable t) {
      future.fail(t);
    }
    return future;
  }

  private ResumableUploadFutureImpl(
      @Nullable ApiFuture<ResumableUploadSession> startFuture,
      @Nullable String sessionUrl,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      ResumableUploadOptions options,
      ClientContext clientContext,
      ExponentialRetryAlgorithm recoveryAlgorithm,
      ResumableUploadProgressTracker progressTracker) {
    this.startFuture = startFuture;
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.queryStatusCallable =
        checkNotNull(queryStatusCallable, "queryStatusCallable must not be null");
    this.options = checkNotNull(options, "options must not be null");
    checkArgument(options.getChunkSize() > 0, "chunkSize must be > 0");
    checkNotNull(clientContext, "clientContext must not be null");
    this.callContext = clientContext.getDefaultCallContext();
    this.executor = checkNotNull(clientContext.getExecutor(), "executor must not be null");
    this.recoveryAlgorithm = checkNotNull(recoveryAlgorithm, "recoveryAlgorithm must not be null");
    this.progressTracker = checkNotNull(progressTracker, "progressTracker must not be null");
    if (sessionUrl != null) {
      this.uploadSessionUrl = sessionUrl;
      this.effectiveChunkSize = options.getChunkSize();
    }
    this.inFlightFuture = firstNonNull(startFuture, SettableApiFuture.create());
    ResumableUploadProgressListener progressListener = options.getProgressListener();
    if (progressListener != null) {
      progressTracker.addListener(progressListener, executor);
    }
  }

  private void start(InputStreamSupplier payloadSupplier) throws IOException {
    setUpGlobalTimeout();
    this.payload = checkNotNull(payloadSupplier.get(), "payload supplier returned null");
    ApiFutures.addCallback(
        checkNotNull(startFuture),
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            String sessionUrl = session.getUploadUrl();
            int chunkSize;
            try {
              chunkSize = alignChunkSize(options.getChunkSize(), session.getChunkGranularity());
            } catch (Throwable t) {
              fail(t);
              return;
            }
            ResumableUploadChunkCoordinator<ResponseT> coordinator =
                createAndRegisterCoordinator(sessionUrl, chunkSize);
            if (coordinator != null) {
              coordinator.start();
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
        MoreExecutors.directExecutor());
  }

  private void resume(String sessionUrl, InputStreamSupplier payloadSupplier) throws IOException {
    setUpGlobalTimeout();
    this.payload = checkNotNull(payloadSupplier.get(), "payload supplier returned null");
    ResumableUploadChunkCoordinator<ResponseT> coordinator =
        createAndRegisterCoordinator(sessionUrl, options.getChunkSize());
    if (coordinator != null) {
      coordinator.resume();
    }
  }

  private void setUpGlobalTimeout() {
    Duration timeout = firstNonNull(options.getGlobalTimeout(), DEFAULT_GLOBAL_TIMEOUT);
    ScheduledFuture<?> timeoutFuture =
        executor.schedule(this::onTimeout, timeout.toMillis(), TimeUnit.MILLISECONDS);
    resultFuture.addListener(() -> timeoutFuture.cancel(false), MoreExecutors.directExecutor());
  }

  private @Nullable ResumableUploadChunkCoordinator<ResponseT> createAndRegisterCoordinator(
      String sessionUrl, int chunkSize) {
    ResumableUploadChunkCoordinator<ResponseT> coordinator =
        new ResumableUploadChunkCoordinator<>(
            uploadChunkCallable,
            queryStatusCallable,
            sessionUrl,
            checkNotNull(payload),
            chunkSize,
            callContext,
            recoveryAlgorithm,
            executor,
            progressTracker);
    ApiFuture<ResponseT> uploadFuture = coordinator.getFuture();
    synchronized (lock) {
      if (inFlightFuture == null) {
        return null;
      }
      effectiveChunkSize = chunkSize;
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
    return coordinator;
  }

  private void onTimeout() {
    String message;
    if (getUploadSessionUrl() != null) {
      message = "Resumable upload timed out";
    } else {
      message = "Resumable upload timed out before session initiation completed";
    }
    fail(
        ApiExceptionFactory.createException(
            message, null, statusCodeOf(StatusCode.Code.DEADLINE_EXCEEDED), false));
  }

  private void succeed(@Nullable ResponseT result) {
    synchronized (lock) {
      if (inFlightFuture == null) {
        return;
      }
      inFlightFuture = null;
    }
    closePayload(null);
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
    inFlight.cancel(true);
    ApiException terminal = toTerminalException(t);
    progressTracker.onFailed();
    closePayload(terminal);
    resultFuture.setException(terminal);
  }

  private ApiException toTerminalException(Throwable t) {
    String sessionUrl;
    Integer chunkSize;
    synchronized (lock) {
      sessionUrl = uploadSessionUrl;
      chunkSize = effectiveChunkSize;
    }
    if (t instanceof ApiException && sessionUrl == null) {
      return (ApiException) t;
    }
    String message = firstNonNull(t.getMessage(), t.getClass().getSimpleName());
    if (sessionUrl != null) {
      message =
          String.format(
              "%s (upload URL: %s, effective chunk size: %d)", message, sessionUrl, chunkSize);
    }
    // Rethrow with URL and effective chunk size included in message.
    if (t instanceof ApiException) {
      ApiException apiException = (ApiException) t;
      return ApiExceptionFactory.createException(
          message,
          apiException.getCause(),
          apiException.getStatusCode(),
          apiException.isRetryable(),
          apiException.getErrorDetails());
    }
    return ApiExceptionFactory.createException(
        message, t, statusCodeOf(StatusCode.Code.UNKNOWN), false);
  }

  static int alignChunkSize(int configuredChunkSize, long chunkGranularity) {
    checkArgument(configuredChunkSize > 0, "configuredChunkSize must be > 0");
    checkArgument(chunkGranularity > 0, "chunkGranularity must be > 0");
    checkArgument(
        configuredChunkSize >= chunkGranularity,
        "Configured chunk size (%s bytes) must be at least the server chunk granularity (%s bytes)",
        configuredChunkSize,
        chunkGranularity);
    int unalignedRemainder = (int) (configuredChunkSize % chunkGranularity);
    return configuredChunkSize - unalignedRemainder;
  }

  private void closePayload(@Nullable Throwable primaryException) {
    if (payload == null) {
      return;
    }
    try {
      payload.close();
    } catch (Throwable e) {
      if (primaryException != null) {
        primaryException.addSuppressed(e);
      }
    }
  }

  @Override
  public @Nullable String getUploadSessionUrl() {
    synchronized (lock) {
      return uploadSessionUrl;
    }
  }

  @Override
  public @Nullable Integer getEffectiveChunkSize() {
    synchronized (lock) {
      return effectiveChunkSize;
    }
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
    inFlight.cancel(mayInterruptIfRunning);
    progressTracker.onFailed();
    closePayload(null);
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

  private static StatusCode statusCodeOf(StatusCode.Code code) {
    return new StatusCode() {
      @Override
      public StatusCode.Code getCode() {
        return code;
      }

      @Override
      public @Nullable Object getTransportCode() {
        return null;
      }
    };
  }
}
