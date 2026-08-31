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
package com.google.api.gax.resumable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.NonCancellableFuture;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Implementation of {@link ResumableUploadFuture} that manages the chunk streaming pipeline, offset
 * synchronization via queryStatus, error recovery, and progress tracking using standard GAX
 * retries.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadFutureImpl<RequestT, ResponseT>
    implements ResumableUploadFuture<ResponseT> {

  private final ResumableUploadClient<RequestT, ResponseT> client;
  private final @Nullable RequestT initialRequest;
  private final boolean isResumedSession;
  private final RewindableStreamBuffer streamBuffer;
  private final int chunkSize;
  private final ApiCallContext callContext;

  private final List<ListenerExecutorPair> progressListeners = new CopyOnWriteArrayList<>();
  private volatile ResumableUploadStatus currentStatus;

  private volatile @Nullable String sessionUrl;
  private volatile long committedOffset = 0L;
  private volatile boolean isUploadFinal = false;
  private volatile @Nullable ResponseT finalResponse;
  private final RetryingFuture<ResponseT> retryingFuture;

  public ResumableUploadFutureImpl(
      ResumableUploadClient<RequestT, ResponseT> client,
      @Nullable String sessionUrl,
      @Nullable RequestT initialRequest,
      InputStream payload,
      int chunkSize,
      RetryingExecutorWithContext<ResponseT> retryingExecutor,
      ApiCallContext callContext) {
    this.client = checkNotNull(client, "client must not be null");
    this.initialRequest = initialRequest;
    this.sessionUrl = sessionUrl;
    this.isResumedSession = sessionUrl != null;
    this.streamBuffer = new RewindableStreamBuffer(payload, chunkSize);
    this.chunkSize = chunkSize;
    this.callContext = checkNotNull(callContext, "callContext must not be null");

    this.currentStatus =
        ResumableUploadStatus.newBuilder()
            .setUploadUrl(sessionUrl)
            .setBytesUploaded(0L)
            .setState(
                isResumedSession
                    ? ResumableUploadStatus.State.UPLOADING
                    : ResumableUploadStatus.State.STARTING)
            .build();

    UploadAttemptCallable attemptCallable = new UploadAttemptCallable();
    this.retryingFuture = retryingExecutor.createFuture(attemptCallable, callContext);
    attemptCallable.setExternalFuture(this.retryingFuture);
    this.retryingFuture.addListener(this::ensureTerminalStatus, MoreExecutors.directExecutor());

    // Trigger the first attempt
    attemptCallable.call();
  }

  @Override
  public @Nullable String getUploadSessionUrl() {
    return sessionUrl;
  }

  @Override
  public ResumableUploadStatus getStatus() {
    ensureTerminalStatus();
    return currentStatus;
  }

  private void ensureTerminalStatus() {
    if (retryingFuture != null
        && retryingFuture.isDone()
        && currentStatus.getState() != ResumableUploadStatus.State.FINALIZED
        && currentStatus.getState() != ResumableUploadStatus.State.FAILED) {
      if (retryingFuture.isCancelled()) {
        updateStatus(
            currentStatus.toBuilder()
                .setState(ResumableUploadStatus.State.FAILED)
                .setException(new CancellationException("Upload was cancelled"))
                .build());
      } else {
        try {
          retryingFuture.get();
        } catch (ExecutionException e) {
          updateStatus(
              currentStatus.toBuilder()
                  .setState(ResumableUploadStatus.State.FAILED)
                  .setException(e.getCause() != null ? e.getCause() : e)
                  .build());
        } catch (InterruptedException | CancellationException e) {
          updateStatus(
              currentStatus.toBuilder()
                  .setState(ResumableUploadStatus.State.FAILED)
                  .setException(e)
                  .build());
        }
      }
    }
  }

  @Override
  public void addProgressListener(ResumableUploadProgressListener listener) {
    addProgressListener(listener, MoreExecutors.directExecutor());
  }

  @Override
  public void addProgressListener(ResumableUploadProgressListener listener, Executor executor) {
    checkNotNull(listener, "listener must not be null");
    checkNotNull(executor, "executor must not be null");
    progressListeners.add(new ListenerExecutorPair(listener, executor));
    ResumableUploadStatus snapshot = this.currentStatus;
    try {
      executor.execute(
          () -> {
            try {
              listener.onProgress(snapshot);
            } catch (Throwable ignored) {
            }
          });
    } catch (Throwable ignored) {
    }
  }

  private void updateStatus(ResumableUploadStatus status) {
    this.currentStatus = status;
    notifyProgressListeners(status);
  }

  private void notifyProgressListeners(ResumableUploadStatus status) {
    for (ListenerExecutorPair pair : progressListeners) {
      try {
        pair.executor.execute(
            () -> {
              try {
                pair.listener.onProgress(status);
              } catch (Throwable ignored) {
              }
            });
      } catch (Throwable ignored) {
      }
    }
  }

  // --------------------------------------------------------------------------
  // Attempt Callable & Execution
  // --------------------------------------------------------------------------

  private class UploadAttemptCallable implements Callable<ResponseT> {
    private volatile @Nullable RetryingFuture<ResponseT> externalFuture;
    private int attemptCount = 0;

    void setExternalFuture(RetryingFuture<ResponseT> externalFuture) {
      this.externalFuture = externalFuture;
    }

    @Override
    public ResponseT call() {
      attemptCount++;
      RetryingFuture<ResponseT> extFuture =
          checkNotNull(externalFuture, "externalFuture must be set");
      ApiCallContext attemptContext = callContext;

      try {
        Duration rpcTimeout = extFuture.getAttemptSettings().getRpcTimeoutDuration();
        if (!rpcTimeout.isZero() && attemptContext.getTimeoutDuration() == null) {
          attemptContext = attemptContext.withTimeoutDuration(rpcTimeout);
        }

        extFuture.setAttemptFuture(new NonCancellableFuture<>());
        if (extFuture.isDone()) {
          return null;
        }

        callContext
            .getTracer()
            .attemptStarted(null, extFuture.getAttemptSettings().getOverallAttemptCount());

        if (attemptCount > 1) {
          updateStatus(
              currentStatus.toBuilder().setState(ResumableUploadStatus.State.RECOVERING).build());
        }

        ApiFuture<ResponseT> internalFuture = executeAttempt(attemptCount, attemptContext);
        extFuture.setAttemptFuture(internalFuture);
      } catch (Throwable e) {
        extFuture.setAttemptFuture(ApiFutures.immediateFailedFuture(e));
      }
      return null;
    }
  }

  private ApiFuture<ResponseT> executeAttempt(int attemptCount, ApiCallContext attemptContext) {
    if (isUploadFinal) {
      return ApiFutures.immediateFuture(finalResponse);
    }

    if (sessionUrl == null) {
      RequestT request =
          checkNotNull(
              initialRequest, "initialRequest must not be null when starting a new session");
      return ApiFutures.transformAsync(
          client.startUploadCallable().futureCall(request, attemptContext),
          session -> {
            this.sessionUrl = session.getUploadUrl();
            updateStatus(
                currentStatus.toBuilder()
                    .setUploadUrl(this.sessionUrl)
                    .setState(ResumableUploadStatus.State.UPLOADING)
                    .setBytesUploaded(committedOffset)
                    .setException(null)
                    .build());
            return transmitChunks(attemptContext);
          },
          MoreExecutors.directExecutor());
    }

    // Offset reconciliation needed if retrying an attempt or resuming a saved session URL
    if (attemptCount > 1 || (isResumedSession && committedOffset == 0L)) {
      QueryStatusRequest queryRequest = QueryStatusRequest.create(checkNotNull(sessionUrl));
      return ApiFutures.transformAsync(
          client.queryStatusCallable().futureCall(queryRequest, attemptContext),
          (QueryStatusResponse<ResponseT> queryResponse) -> {
            if (queryResponse.isComplete()) {
              isUploadFinal = true;
              finalResponse = queryResponse.getResponse();
              Long serverCommitted = queryResponse.getCommittedOffset();
              long finalBytes = serverCommitted != null ? serverCommitted : this.committedOffset;
              updateStatus(
                  currentStatus.toBuilder()
                      .setState(ResumableUploadStatus.State.FINALIZED)
                      .setBytesUploaded(finalBytes)
                      .setException(null)
                      .build());
              return ApiFutures.immediateFuture(finalResponse);
            }

            long serverCommitted = checkNotNull(queryResponse.getCommittedOffset());
            this.committedOffset = serverCommitted;
            try {
              streamBuffer.seekTo(serverCommitted);
            } catch (IOException e) {
              return ApiFutures.immediateFailedFuture(e);
            }
            updateStatus(
                currentStatus.toBuilder()
                    .setState(ResumableUploadStatus.State.OFFSET_RECEIVED)
                    .setBytesUploaded(serverCommitted)
                    .setException(null)
                    .build());
            return transmitChunks(attemptContext);
          },
          MoreExecutors.directExecutor());
    }

    updateStatus(
        currentStatus.toBuilder()
            .setUploadUrl(sessionUrl)
            .setState(ResumableUploadStatus.State.UPLOADING)
            .setBytesUploaded(committedOffset)
            .setException(null)
            .build());

    return transmitChunks(attemptContext);
  }

  private ApiFuture<ResponseT> transmitChunks(ApiCallContext attemptContext) {
    DataChunk chunk;
    try {
      chunk = streamBuffer.nextChunk();
    } catch (IOException e) {
      return ApiFutures.immediateFailedFuture(e);
    }

    String currentSessionUrl = checkNotNull(sessionUrl, "sessionUrl must not be null");

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(currentSessionUrl)
            .setPayload(chunk.getPayload())
            .setOffset(chunk.getOffset())
            .setFinal(chunk.isFinal())
            .build();

    return ApiFutures.transformAsync(
        client.uploadChunkCallable().futureCall(chunkRequest, attemptContext),
        (ChunkUploadResponse<ResponseT> response) -> {
          if (response.isComplete()) {
            isUploadFinal = true;
            finalResponse = response.getResponse();
            try {
              streamBuffer.close();
            } catch (IOException ignored) {
            }
            long finalBytes = chunk.getOffset() + chunk.getPayload().length;
            updateStatus(
                currentStatus.toBuilder()
                    .setState(ResumableUploadStatus.State.FINALIZED)
                    .setBytesUploaded(finalBytes)
                    .setException(null)
                    .build());
            return ApiFutures.immediateFuture(response.getResponse());
          }

          long confirmedOffset = chunk.getOffset() + chunk.getPayload().length;
          committedOffset = confirmedOffset;
          streamBuffer.acknowledge(confirmedOffset);
          updateStatus(
              currentStatus.toBuilder()
                  .setState(ResumableUploadStatus.State.UPLOADING)
                  .setBytesUploaded(committedOffset)
                  .setException(null)
                  .build());

          return transmitChunks(attemptContext);
        },
        MoreExecutors.directExecutor());
  }

  // --------------------------------------------------------------------------
  // ApiFuture Interface Delegation
  // --------------------------------------------------------------------------

  @Override
  public void addListener(Runnable listener, Executor executor) {
    retryingFuture.addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    try {
      streamBuffer.close();
    } catch (IOException ignored) {
    }
    boolean result = retryingFuture.cancel(mayInterruptIfRunning);
    if (result) {
      updateStatus(
          currentStatus.toBuilder()
              .setState(ResumableUploadStatus.State.FAILED)
              .setException(new CancellationException("Upload was cancelled"))
              .build());
    }
    return result;
  }

  @Override
  public boolean isCancelled() {
    return retryingFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return retryingFuture.isDone();
  }

  @Override
  public ResponseT get() throws InterruptedException, ExecutionException {
    try {
      return retryingFuture.get();
    } finally {
      ensureTerminalStatus();
    }
  }

  @Override
  public ResponseT get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    try {
      return retryingFuture.get(timeout, unit);
    } finally {
      ensureTerminalStatus();
    }
  }

  private static class ListenerExecutorPair {
    final ResumableUploadProgressListener listener;
    final Executor executor;

    ListenerExecutorPair(ResumableUploadProgressListener listener, Executor executor) {
      this.listener = listener;
      this.executor = executor;
    }
  }
}
