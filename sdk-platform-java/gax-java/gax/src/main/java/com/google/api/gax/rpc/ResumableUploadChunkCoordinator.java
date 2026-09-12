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
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Coordinates chunk transmission steps of a resumable upload session.
 *
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@InternalApi
@NullMarked
final class ResumableUploadChunkCoordinator<ResponseT> {

  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;
  private final String uploadUrl;
  private final RewindableStreamBuffer buffer;
  private final ApiCallContext callContext;
  private final ExponentialRetryAlgorithm recoveryAlgorithm;
  private final ScheduledExecutorService executor;
  private final SettableApiFuture<ResponseT> uploadResultFuture = SettableApiFuture.create();
  private volatile @Nullable Future<?> inFlightFuture;
  private TimedAttemptSettings recoverySettings;
  private boolean madeProgressSinceRecovery = true;

  ResumableUploadChunkCoordinator(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable,
      String uploadUrl,
      InputStream payload,
      int chunkSize,
      ApiCallContext callContext,
      ExponentialRetryAlgorithm recoveryAlgorithm,
      ScheduledExecutorService executor) {
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.queryStatusCallable =
        checkNotNull(queryStatusCallable, "queryStatusCallable must not be null");
    this.uploadUrl = checkNotNull(uploadUrl, "uploadUrl must not be null");
    checkNotNull(payload, "payload must not be null");
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.recoveryAlgorithm = checkNotNull(recoveryAlgorithm, "recoveryAlgorithm must not be null");
    this.executor = checkNotNull(executor, "executor must not be null");
    this.recoverySettings = recoveryAlgorithm.createFirstAttempt();
    this.buffer = new RewindableStreamBuffer(payload, chunkSize, uploadUrl);
  }

  ApiFuture<ResponseT> getFuture() {
    return uploadResultFuture;
  }

  void start() {
    uploadResultFuture.addListener(
        () -> {
          Future<?> inFlight = inFlightFuture;
          if (uploadResultFuture.isCancelled() && inFlight != null) {
            inFlight.cancel(true);
          }
        },
        MoreExecutors.directExecutor());
    try {
      buffer.fill();
      transmitChunk();
    } catch (Throwable t) {
      uploadResultFuture.setException(t);
    }
  }

  private void transmitChunk() {
    try {
      // Abort if the session was already completed or canceled.
      if (uploadResultFuture.isDone()) {
        return;
      }

      ChunkUploadRequest chunkRequest = buildCurrentChunkRequest();

      // Dispatch the chunk upload call and register the in-flight future for cancellation.
      ApiFuture<ChunkUploadResponse<ResponseT>> chunkFuture =
          uploadChunkCallable.futureCall(chunkRequest, callContext);
      if (!tryRegisterInFlightFuture(chunkFuture)) {
        return;
      }
      ApiFutures.addCallback(
          chunkFuture,
          new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
            @Override
            public void onSuccess(ChunkUploadResponse<ResponseT> response) {
              if (uploadResultFuture.isDone()) {
                return;
              }
              if (response.getUploadStatus() == ResumableUploadStatus.UNKNOWN) {
                recover(
                    new IllegalStateException(
                        "Chunk upload response missing X-Goog-Upload-Status header for upload URL: "
                            + uploadUrl));
              } else {
                try {
                  handleChunkResponse(response);
                } catch (Throwable t) {
                  uploadResultFuture.setException(t);
                }
              }
            }

            @Override
            public void onFailure(Throwable t) {
              if (t instanceof CancellationException || uploadResultFuture.isDone()) {
                return;
              }
              Category category =
                  ResumableUploadErrorClassifier.classify(t, ResumableUploadCommand.UPLOAD);
              if (category == Category.RECOVERABLE) {
                recover(t);
              } else {
                // Category.TRANSIENT errors reaching here have already exhausted their retry budget
                // in the underlying RetryingCallable and become fatal per protocol specification.
                uploadResultFuture.setException(t);
              }
            }
          },
          MoreExecutors.directExecutor());
    } catch (Throwable t) {
      uploadResultFuture.setException(t);
    }
  }

  private void recover(Throwable cause) {
    try {
      if (madeProgressSinceRecovery) {
        recoverySettings =
            recoveryAlgorithm.createNextAttempt(recoveryAlgorithm.createFirstAttempt());
      } else {
        recoverySettings = recoveryAlgorithm.createNextAttempt(recoverySettings);
      }
      madeProgressSinceRecovery = false;
      if (!recoveryAlgorithm.shouldRetry(recoverySettings)) {
        uploadResultFuture.setException(cause);
        return;
      }
      tryRegisterInFlightFuture(
          executor.schedule(
              this::queryStatus,
              recoverySettings.getRandomizedRetryDelayDuration().toNanos(),
              TimeUnit.NANOSECONDS));
    } catch (Throwable t) {
      uploadResultFuture.setException(t);
    }
  }

  private void queryStatus() {
    try {
      if (uploadResultFuture.isDone()) {
        return;
      }
      // Dispatch the query status call and register the in-flight future for cancellation.
      ApiFuture<QueryStatusResponse<ResponseT>> queryFuture =
          queryStatusCallable.futureCall(QueryStatusRequest.create(uploadUrl), callContext);
      if (!tryRegisterInFlightFuture(queryFuture)) {
        return;
      }
      ApiFutures.addCallback(
          queryFuture,
          new ApiFutureCallback<QueryStatusResponse<ResponseT>>() {
            @Override
            public void onSuccess(QueryStatusResponse<ResponseT> queryResponse) {
              if (uploadResultFuture.isDone()) {
                return;
              }
              try {
                handleQueryResponse(queryResponse);
              } catch (Throwable t) {
                uploadResultFuture.setException(t);
              }
            }

            @Override
            public void onFailure(Throwable t) {
              if (t instanceof CancellationException || uploadResultFuture.isDone()) {
                return;
              }
              uploadResultFuture.setException(t);
            }
          },
          MoreExecutors.directExecutor());
    } catch (Throwable t) {
      uploadResultFuture.setException(t);
    }
  }

  /**
   * Registers the in-flight future for possible cancellation, returning false if the upload was
   * already cancelled.
   */
  private boolean tryRegisterInFlightFuture(Future<?> future) {
    this.inFlightFuture = future;
    if (uploadResultFuture.isCancelled()) {
      future.cancel(true);
      return false;
    }
    return true;
  }

  private void handleQueryResponse(QueryStatusResponse<ResponseT> queryResponse)
      throws IOException {
    if (queryResponse.getUploadStatus() == ResumableUploadStatus.UNKNOWN) {
      throw new IllegalStateException(
          "Query status response missing X-Goog-Upload-Status header for upload URL: " + uploadUrl);
    }
    if (queryResponse.getUploadStatus() == ResumableUploadStatus.FINAL) {
      uploadResultFuture.set(queryResponse.getResponse());
      return;
    }
    Long committedOffset = queryResponse.getCommittedOffset();
    if (committedOffset == null) {
      throw new IllegalStateException(
          "Incomplete query status response did not include a committed offset for upload URL: "
              + uploadUrl);
    }
    buffer.realignTo(committedOffset);
    transmitChunk();
  }

  private void handleChunkResponse(ChunkUploadResponse<ResponseT> response) throws IOException {
    if (response.getUploadStatus() == ResumableUploadStatus.FINAL) {
      uploadResultFuture.set(response.getResponse());
    } else if (buffer.isFinal()) {
      uploadResultFuture.setException(
          new IllegalStateException(
              "Upload stream ended and final chunk was transmitted, but server returned"
                  + " incomplete status for upload URL: "
                  + uploadUrl));
    } else {
      madeProgressSinceRecovery = true;
      buffer.fill();
      transmitChunk();
    }
  }

  private ChunkUploadRequest buildCurrentChunkRequest() {
    // Determine if this is the final chunk and build the chunk request.
    return ChunkUploadRequest.newBuilder()
        .setUploadUrl(uploadUrl)
        .setPayload(buffer.getPayload())
        .setOffset(buffer.getBufferBaseOffset())
        .setFinal(buffer.isFinal())
        .build();
  }
}
