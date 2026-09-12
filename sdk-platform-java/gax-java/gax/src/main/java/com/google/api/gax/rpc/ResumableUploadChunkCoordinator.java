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
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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

  private final Object lock = new Object();

  private final SettableApiFuture<ResponseT> result;
  private final ApiFuture<ResumableUploadSession> startFuture;
  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;
  private final InputStream payload;
  private final ResumableUploadCallSettings settings;
  private final int chunkSize;
  private final ApiCallContext callContext;
  private final ClientContext clientContext;
  private final RetrySettings chunkRetrySettings;
  private final UploadProgressTracker progressTracker = new UploadProgressTracker();

  private volatile @Nullable String uploadSessionUrl;
  private volatile @Nullable RewindableStreamBuffer buffer;

  @GuardedBy("lock")
  private boolean done;

  @GuardedBy("lock")
  private boolean payloadClosed;

  @GuardedBy("lock")
  private @Nullable ApiFuture<?> inFlightFuture;

  @GuardedBy("lock")
  private @Nullable ScheduledFuture<?> timeoutFuture;

  ResumableUploadChunkCoordinator(
      SettableApiFuture<ResponseT> result,
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext,
      ClientContext clientContext) {
    this.result = checkNotNull(result, "result must not be null");
    this.startFuture = checkNotNull(startFuture, "startFuture must not be null");
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.queryStatusCallable =
        checkNotNull(queryStatusCallable, "queryStatusCallable must not be null");
    this.payload = checkNotNull(payload, "payload must not be null");
    this.settings = checkNotNull(settings, "settings must not be null");
    checkArgument(settings.getChunkSize() > 0, "chunkSize must be > 0");
    this.chunkSize = settings.getChunkSize();
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.clientContext = checkNotNull(clientContext, "clientContext must not be null");
    this.chunkRetrySettings = DEFAULT_CHUNK_RETRY_SETTINGS;
    this.inFlightFuture = startFuture;
  }

  void start() {
    Duration timeout = settings.getGlobalTimeout();
    if (timeout != null && !timeout.isZero() && !timeout.isNegative()) {
      ScheduledExecutorService executor = clientContext.getExecutor();
      if (executor != null) {
        synchronized (lock) {
          if (!done) {
            this.timeoutFuture =
                executor.schedule(this::onTimeout, timeout.toMillis(), TimeUnit.MILLISECONDS);
          }
        }
      }
    }

    ApiFutures.addCallback(
        startFuture,
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            if (isDone()) {
              return;
            }
            uploadSessionUrl = session.getUploadUrl();
            progressTracker.onStarted(uploadSessionUrl);
            buffer = new RewindableStreamBuffer(payload, chunkSize, uploadSessionUrl);
            transmitChunk(0L);
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

  void addProgressListener(ResumableUploadProgressListener listener, Executor executor) {
    progressTracker.addListener(listener, executor);
  }

  ResumableUploadStatus getStatus() {
    return progressTracker.getStatus();
  }

  private boolean isDone() {
    synchronized (lock) {
      return done;
    }
  }

  private void onTimeout() {
    Duration timeout = settings.getGlobalTimeout();
    Duration effectiveTimeout = timeout != null ? timeout : Duration.ZERO;
    finish(null, new ResumableUploadTimeoutException(uploadSessionUrl, effectiveTimeout));
  }

  @Nullable String getUploadSessionUrl() {
    return uploadSessionUrl;
  }

  void setInFlightFuture(ApiFuture<?> future) {
    boolean shouldCancel = false;
    synchronized (lock) {
      if (done) {
        shouldCancel = true;
      } else {
        this.inFlightFuture = future;
      }
    }
    if (shouldCancel) {
      future.cancel(true);
    }
  }

  void cancel(boolean mayInterruptIfRunning) {
    ScheduledFuture<?> timeout;
    ApiFuture<?> inFlight;
    synchronized (lock) {
      if (done) {
        return;
      }
      done = true;
      inFlight = this.inFlightFuture;
      this.inFlightFuture = null;
      timeout = this.timeoutFuture;
      this.timeoutFuture = null;
    }
    if (timeout != null) {
      timeout.cancel(false);
    }
    if (inFlight != null) {
      inFlight.cancel(mayInterruptIfRunning);
    }
    progressTracker.onFailed(
        new CancellationException("Upload was cancelled"), uploadSessionUrl);
    closePayload();
  }

  private void finish(@Nullable ResponseT response, @Nullable Throwable error) {
    ScheduledFuture<?> timeout;
    ApiFuture<?> inFlight;
    synchronized (lock) {
      if (done) {
        return;
      }
      done = true;
      inFlight = inFlightFuture;
      inFlightFuture = null;
      timeout = timeoutFuture;
      timeoutFuture = null;
    }
    if (timeout != null) {
      timeout.cancel(false);
    }
    if (inFlight != null) {
      inFlight.cancel(true);
    }
    IOException closeError = closePayload();
    if (error == null) {
      RewindableStreamBuffer currentBuffer = buffer;
      long totalBytes =
          currentBuffer != null
              ? currentBuffer.getBufferBaseOffset() + currentBuffer.getPayloadLength()
              : 0L;
      progressTracker.onFinalized(totalBytes);
      result.set(response);
    } else {
      Throwable augmented = augmentWithUrl(error);
      if (closeError != null) {
        augmented.addSuppressed(closeError);
      }
      progressTracker.onFailed(augmented, uploadSessionUrl);
      result.setException(augmented);
    }
  }

  private Throwable augmentWithUrl(Throwable t) {
    if (t instanceof ResumableUploadTimeoutException
        || t instanceof UploadProtocolViolationException) {
      return t;
    }
    String url = uploadSessionUrl != null ? uploadSessionUrl : clientContext.getEndpoint();
    if (url == null || url.isEmpty()) {
      return t;
    }
    String message = t.getMessage();
    String label = uploadSessionUrl != null ? "upload URL: " : "endpoint: ";
    String augmentedMessage =
        (message != null ? message : t.getClass().getSimpleName()) + " (" + label + url + ")";
    Throwable augmented = t;
    if (t instanceof ApiException) {
      ApiException apiException = (ApiException) t;
      augmented =
          ApiExceptionFactory.createException(
              augmentedMessage,
              apiException.getCause(),
              apiException.getStatusCode(),
              apiException.isRetryable(),
              apiException.getErrorDetails());
    } else if (t instanceof IllegalStateException) {
      augmented = new IllegalStateException(augmentedMessage, t.getCause());
    } else if (t instanceof IOException) {
      augmented = new IOException(augmentedMessage, t.getCause());
    }
    if (augmented != t) {
      for (Throwable suppressed : t.getSuppressed()) {
        augmented.addSuppressed(suppressed);
      }
    }
    return augmented;
  }

  private @Nullable IOException closePayload() {
    if (payloadClosed) {
      return null;
    }
    payloadClosed = true;
    try {
      payload.close();
      return null;
    } catch (IOException e) {
      return e;
    }
  }

  private void transmitChunk(long currentOffset) {
    if (isDone()) {
      return;
    }

    String url = uploadSessionUrl;
    if (url == null) {
      finish(null, new IllegalStateException("Upload session URL not available"));
      return;
    }

    RewindableStreamBuffer streamBuffer = buffer;
    if (streamBuffer == null) {
      finish(null, new IllegalStateException("Upload buffer not initialized"));
      return;
    }

    try {
      streamBuffer.fill(currentOffset);
    } catch (IOException e) {
      finish(null, e);
      return;
    }

    UploadCommand command;
    if (streamBuffer.isFinal()) {
      command =
          streamBuffer.isEmpty() ? UploadCommand.FINALIZE : UploadCommand.UPLOAD_FINALIZE;
    } else {
      command = UploadCommand.UPLOAD;
    }

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(url)
            .setPayload(streamBuffer.getBuffer())
            .setPayloadLength(streamBuffer.getPayloadLength())
            .setOffset(streamBuffer.getBufferBaseOffset())
            .setFinal(streamBuffer.isFinal())
            .build();

    ChunkAttemptCallable<ResponseT> attemptCallable =
        new ChunkAttemptCallable<>(
            uploadChunkCallable,
            queryStatusCallable,
            streamBuffer,
            url,
            chunkRequest,
            callContext,
            command,
            progressTracker);

    RetryAlgorithm<ChunkUploadResponse<ResponseT>> retryAlgorithm =
        new RetryAlgorithm<>(
            new UploadResultRetryAlgorithm<>(command),
            new ExponentialRetryAlgorithm(chunkRetrySettings, clientContext.getClock()));

    ScheduledRetryingExecutor<ChunkUploadResponse<ResponseT>> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture =
        retryingExecutor.createFuture(attemptCallable, callContext);
    attemptCallable.setRetryingFuture(retryingFuture);
    setInFlightFuture(retryingFuture);

    ApiFutures.addCallback(
        retryingFuture,
        new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
          @Override
          public void onSuccess(ChunkUploadResponse<ResponseT> response) {
            if (isDone()) {
              return;
            }
            long nextOffset = streamBuffer.getBufferBaseOffset() + streamBuffer.getPayloadLength();
            progressTracker.onChunkUploaded(nextOffset);
            if (response.isComplete()) {
              finish(response.getResponse(), null);
            } else if (streamBuffer.isFinal()) {
              finish(
                  null,
                  new IllegalStateException(
                      "Upload stream ended and final chunk was transmitted, but server returned"
                          + " incomplete status for upload URL: "
                          + url));
            } else {
              transmitChunk(nextOffset);
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

    try {
      attemptCallable.call();
    } catch (Throwable t) {
      if (!retryingFuture.isDone()) {
        finish(null, t);
      }
    }
  }
}
