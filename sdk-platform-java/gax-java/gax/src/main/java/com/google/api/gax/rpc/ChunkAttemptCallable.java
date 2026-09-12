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
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
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
 * <p>Execution follows the standard attempt template with pre-attempt recovery handling. When the
 * previous attempt failed with a Category 2 (recoverable) error or missing status header, {@code
 * prepareAttempt} queries session status, realigns the buffer window, tops up from the stream, and
 * dispatches the chunk upload request. The callable never blocks on {@code .get()}; results and
 * cancellations propagate asynchronously.
 *
 * @param <ResponseT> the type of the final response message once the upload completes
 */
@NullMarked
class ChunkAttemptCallable<ResponseT> implements Callable<ChunkUploadResponse<ResponseT>> {

  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;
  private final RewindableStreamBuffer buffer;
  private final String uploadUrl;
  private final ApiCallContext originalCallContext;
  private final @Nullable UploadProgressTracker progressTracker;

  private volatile ChunkUploadRequest currentRequest;
  private volatile UploadCommand currentCommand;

  private volatile @Nullable RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture;
  private volatile @Nullable ApiFuture<?> inFlightFuture;
  private volatile @Nullable Throwable lastFailure;
  private volatile @Nullable ChunkUploadResponse<ResponseT> lastResponse;

  ChunkAttemptCallable(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      RewindableStreamBuffer buffer,
      String uploadUrl,
      ChunkUploadRequest request,
      ApiCallContext callContext,
      UploadCommand command) {
    this(
        uploadChunkCallable,
        queryStatusCallable,
        buffer,
        uploadUrl,
        request,
        callContext,
        command,
        null);
  }

  ChunkAttemptCallable(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      RewindableStreamBuffer buffer,
      String uploadUrl,
      ChunkUploadRequest request,
      ApiCallContext callContext,
      UploadCommand command,
      @Nullable UploadProgressTracker progressTracker) {
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.queryStatusCallable =
        checkNotNull(queryStatusCallable, "queryStatusCallable must not be null");
    this.buffer = checkNotNull(buffer, "buffer must not be null");
    this.uploadUrl = checkNotNull(uploadUrl, "uploadUrl must not be null");
    this.currentRequest = checkNotNull(request, "request must not be null");
    this.originalCallContext = checkNotNull(callContext, "callContext must not be null");
    this.currentCommand = checkNotNull(command, "command must not be null");
    this.progressTracker = progressTracker;
  }

  void setRetryingFuture(RetryingFuture<ChunkUploadResponse<ResponseT>> retryingFuture) {
    this.retryingFuture = checkNotNull(retryingFuture, "retryingFuture must not be null");
  }

  private boolean needsRecovery() {
    if (lastFailure != null) {
      UploadErrorCategory category = UploadErrorClassifier.classify(lastFailure, currentCommand);
      return category == UploadErrorCategory.RECOVERABLE;
    }
    if (lastResponse != null && lastResponse.getUploadStatus() == null) {
      UploadErrorCategory category =
          UploadErrorClassifier.classifyMissingStatusHeader(currentCommand);
      return category == UploadErrorCategory.RECOVERABLE;
    }
    return false;
  }

  private void failAttempt(
      SettableApiFuture<ChunkUploadResponse<ResponseT>> attemptFuture, Throwable t) {
    lastFailure = t;
    lastResponse = null;
    attemptFuture.setException(t);
  }

  /**
   * Pre-attempt recovery step invoked before transmitting an attempt when the previous attempt
   * encountered a Category 2 (recoverable) error or missing status header.
   */
  private void prepareAttempt(
      SettableApiFuture<ChunkUploadResponse<ResponseT>> attemptFuture,
      ApiCallContext attemptContext,
      RetryingFuture<ChunkUploadResponse<ResponseT>> currentRetryingFuture) {
    if (progressTracker != null) {
      progressTracker.onRecovering(lastFailure);
    }
    QueryStatusRequest queryRequest = QueryStatusRequest.create(uploadUrl);
    ApiFuture<QueryStatusResponse<ResponseT>> queryFuture =
        queryStatusCallable.futureCall(queryRequest, attemptContext);
    if (queryFuture == null) {
      failAttempt(
          attemptFuture, new IllegalStateException("queryStatusCallable returned a null future"));
      return;
    }
    this.inFlightFuture = queryFuture;

    ApiFutures.addCallback(
        queryFuture,
        new ApiFutureCallback<QueryStatusResponse<ResponseT>>() {
          @Override
          public void onSuccess(QueryStatusResponse<ResponseT> queryResponse) {
            handleQuerySuccess(
                queryResponse, attemptFuture, attemptContext, currentRetryingFuture);
          }

          @Override
          public void onFailure(Throwable t) {
            failAttempt(attemptFuture, t);
          }
        },
        MoreExecutors.directExecutor());
  }

  private void handleQuerySuccess(
      QueryStatusResponse<ResponseT> queryResponse,
      SettableApiFuture<ChunkUploadResponse<ResponseT>> attemptFuture,
      ApiCallContext attemptContext,
      RetryingFuture<ChunkUploadResponse<ResponseT>> currentRetryingFuture) {
    if (currentRetryingFuture.isDone()) {
      return;
    }

    if (queryResponse.getUploadStatus() == null) {
      failAttempt(
          attemptFuture,
          new UploadProtocolViolationException(
              "Query status response missing X-Goog-Upload-Status header for upload URL: "
                  + uploadUrl));
      return;
    }

    // Server already finalized the upload.
    if (queryResponse.isComplete()) {
      ChunkUploadResponse<ResponseT> response =
          ChunkUploadResponse.create(
              true, queryResponse.getResponse(), queryResponse.getUploadStatus());
      lastFailure = null;
      lastResponse = response;
      attemptFuture.set(response);
      return;
    }

    // Incomplete query response with null committed offset violates the protocol invariant.
    Long committedOffset = queryResponse.getCommittedOffset();
    if (committedOffset == null) {
      failAttempt(
          attemptFuture,
          new UploadProtocolViolationException(
              "Incomplete query status response did not include a committed offset for upload"
                  + " URL: "
                  + uploadUrl));
      return;
    }

    // Normal path: realign buffer to committedOffset, compact and top up.
    try {
      buffer.realignTo(committedOffset);
      if (progressTracker != null) {
        progressTracker.onOffsetReceived(committedOffset);
      }
    } catch (Throwable e) {
      failAttempt(attemptFuture, e);
      return;
    }

    // Determine the upload command for the realigned buffer.
    // Preserve upload,finalize for a trailing partial after realignment.
    UploadCommand realignedCommand;
    if (buffer.isFinal()) {
      realignedCommand =
          buffer.isEmpty() ? UploadCommand.FINALIZE : UploadCommand.UPLOAD_FINALIZE;
    } else {
      realignedCommand = UploadCommand.UPLOAD;
    }

    ChunkUploadRequest realignedRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(uploadUrl)
            .setPayload(buffer.getBuffer())
            .setPayloadLength(buffer.getPayloadLength())
            .setOffset(buffer.getBufferBaseOffset())
            .setFinal(buffer.isFinal())
            .build();

    this.currentRequest = realignedRequest;
    this.currentCommand = realignedCommand;

    dispatchChunkUpload(attemptFuture, attemptContext, currentRetryingFuture);
  }

  private void dispatchChunkUpload(
      SettableApiFuture<ChunkUploadResponse<ResponseT>> attemptFuture,
      ApiCallContext attemptContext,
      RetryingFuture<ChunkUploadResponse<ResponseT>> currentRetryingFuture) {
    attemptContext
        .getTracer()
        .attemptStarted(
            currentRequest, currentRetryingFuture.getAttemptSettings().getOverallAttemptCount());

    ApiFuture<ChunkUploadResponse<ResponseT>> chunkFuture =
        uploadChunkCallable.futureCall(currentRequest, attemptContext);
    this.inFlightFuture = chunkFuture;

    ApiFutures.addCallback(
        chunkFuture,
        new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
          @Override
          public void onSuccess(ChunkUploadResponse<ResponseT> response) {
            lastFailure = null;
            lastResponse = response;
            attemptFuture.set(response);
          }

          @Override
          public void onFailure(Throwable t) {
            failAttempt(attemptFuture, t);
          }
        },
        MoreExecutors.directExecutor());
  }

  @Override
  public @Nullable ChunkUploadResponse<ResponseT> call() {
    RetryingFuture<ChunkUploadResponse<ResponseT>> currentRetryingFuture =
        checkNotNull(retryingFuture, "retryingFuture must be set before call()");
    ApiCallContext attemptContext = originalCallContext;

    Duration rpcTimeout = currentRetryingFuture.getAttemptSettings().getRpcTimeoutDuration();
    if (!rpcTimeout.isZero() && attemptContext.getTimeoutDuration() == null) {
      attemptContext = attemptContext.withTimeoutDuration(rpcTimeout);
    }

    SettableApiFuture<ChunkUploadResponse<ResponseT>> attemptFuture = SettableApiFuture.create();
    currentRetryingFuture.setAttemptFuture(attemptFuture);

    if (currentRetryingFuture.isDone()) {
      return null;
    }

    currentRetryingFuture.addListener(
        () -> {
          if (currentRetryingFuture.isCancelled()) {
            ApiFuture<?> inFlight = inFlightFuture;
            if (inFlight != null) {
              inFlight.cancel(true);
            }
            attemptFuture.cancel(true);
          }
        },
        MoreExecutors.directExecutor());

    try {
      if (needsRecovery()) {
        prepareAttempt(attemptFuture, attemptContext, currentRetryingFuture);
      } else {
        dispatchChunkUpload(attemptFuture, attemptContext, currentRetryingFuture);
      }
    } catch (Throwable t) {
      failAttempt(attemptFuture, t);
    }

    return null;
  }
}
