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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.retrying.NonCancellableFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.concurrent.Callable;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A {@link Callable} representing an attempt to transmit a single chunk in a resumable upload
 * session. Used with {@link com.google.api.gax.retrying.ScheduledRetryingExecutor}.
 *
 * <p>Execution follows the standard six-step attempt template with an initial attempt preparation
 * seam. The callable never blocks on {@code .get()}; results and cancellations propagate
 * asynchronously.
 *
 * @param <ResponseT> the type of the final response message once the upload completes
 */
@NullMarked
class ChunkAttemptCallable<ResponseT> implements Callable<ChunkUploadResponse<ResponseT>> {

  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final ChunkUploadRequest request;
  private final ApiCallContext originalCallContext;
  private final UploadCommand command;

  private volatile @Nullable RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture;
  private volatile @Nullable Throwable lastFailure;

  ChunkAttemptCallable(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      ChunkUploadRequest request,
      ApiCallContext callContext,
      UploadCommand command) {
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.request = checkNotNull(request, "request must not be null");
    this.originalCallContext = checkNotNull(callContext, "callContext must not be null");
    this.command = checkNotNull(command, "command must not be null");
  }

  void setRetryingFuture(RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture) {
    this.retryingFuture = checkNotNull(retryingFuture, "retryingFuture must not be null");
  }

  /**
   * Pre-attempt hook called before each transmission attempt.
   *
   * <p>In this phase, Category 2 (recoverable) errors throw to fail fast. Subsequent phases expand
   * this seam into the query status -> realign buffer -> top up recovery sequence.
   */
  void prepareAttempt() {
    if (lastFailure != null) {
      UploadErrorCategory category = UploadErrorClassifier.classify(lastFailure, command);
      if (category == UploadErrorCategory.RECOVERABLE) {
        throw new UnsupportedOperationException(
            "Category 2 (recoverable) error recovery is not yet implemented", lastFailure);
      }
    }
  }

  @Override
  public @Nullable ChunkUploadResponse<ResponseT> call() {
    RetryingFuture<ChunkUploadResponse<ResponseT>> currentRetryingFuture =
        checkNotNull(retryingFuture, "retryingFuture must be set before call()");
    ApiCallContext attemptContext = originalCallContext;

    try {
      // Seam for recoverable error handling.
      prepareAttempt();

      // Set the RPC timeout if caller did not provide their own.
      Duration rpcTimeout = currentRetryingFuture.getAttemptSettings().getRpcTimeoutDuration();
      if (!rpcTimeout.isZero() && attemptContext.getTimeoutDuration() == null) {
        attemptContext = attemptContext.withTimeoutDuration(rpcTimeout);
      }

      // Placeholder non-cancellable future.
      currentRetryingFuture.setAttemptFuture(
          new NonCancellableFuture<ChunkUploadResponse<ResponseT>>());

      // Early exit if retryingFuture was already cancelled or completed.
      if (currentRetryingFuture.isDone()) {
        return null;
      }

      // Dispatch chunk upload and wire cancellation propagation and error
      // tracking.
      attemptContext
          .getTracer()
          .attemptStarted(
              request, currentRetryingFuture.getAttemptSettings().getOverallAttemptCount());

      ApiFuture<ChunkUploadResponse<ResponseT>> internalFuture =
          uploadChunkCallable.futureCall(request, attemptContext);

      // Propagate cancellation to the feeder future immediately.
      currentRetryingFuture.addListener(
          () -> {
            if (currentRetryingFuture.isCancelled()) {
              internalFuture.cancel(true);
            }
          },
          MoreExecutors.directExecutor());

      ApiFutures.addCallback(
          internalFuture,
          new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
            @Override
            public void onSuccess(ChunkUploadResponse<ResponseT> response) {
              lastFailure = null;
            }

            @Override
            public void onFailure(Throwable t) {
              lastFailure = t;
            }
          },
          MoreExecutors.directExecutor());

      currentRetryingFuture.setAttemptFuture(internalFuture);
    } catch (Throwable e) {
      lastFailure = e;
      currentRetryingFuture.setAttemptFuture(
          ApiFutures.<ChunkUploadResponse<ResponseT>>immediateFailedFuture(e));
    }

    return null;
  }
}
