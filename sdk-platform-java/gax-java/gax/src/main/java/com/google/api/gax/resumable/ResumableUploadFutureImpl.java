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
import com.google.api.gax.retrying.AdaptiveAttemptHandler;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Implementation of {@link ResumableUploadFuture} and {@link AdaptiveAttemptHandler} that manages
 * the resumable upload state machine, chunk pipelining, offset synchronization, error recovery, and
 * progress tracking.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadFutureImpl<RequestT, ResponseT>
    implements ResumableUploadFuture<ResponseT>, AdaptiveAttemptHandler<ResponseT> {

  private final ResumableUploadClient<RequestT, ResponseT> client;
  private final RewindableStreamBuffer streamBuffer;
  private final @Nullable RequestT initialRequest;
  private final int chunkSize;

  private final List<ListenerExecutorPair> progressListeners = new CopyOnWriteArrayList<>();
  private volatile ResumableUploadStatus currentStatus;

  private final boolean isResumedSession;
  private boolean initialQueryDone;
  private volatile @Nullable String sessionUrl;
  private volatile long committedOffset = 0L;
  private volatile boolean isUploadFinal = false;
  private volatile @Nullable ResponseT finalResponse;
  private volatile @Nullable RetryingFuture<ResponseT> retryingFuture;

  public ResumableUploadFutureImpl(
      ResumableUploadClient<RequestT, ResponseT> client,
      @Nullable String sessionUrl,
      @Nullable RequestT initialRequest,
      InputStream payload,
      int chunkSize) {
    this.client = checkNotNull(client);
    this.sessionUrl = sessionUrl;
    this.isResumedSession = sessionUrl != null;
    this.initialQueryDone = !isResumedSession;
    this.initialRequest = initialRequest;
    this.streamBuffer = new RewindableStreamBuffer(payload, chunkSize);
    this.chunkSize = chunkSize;

    this.currentStatus =
        ResumableUploadStatus.newBuilder()
            .setUploadUrl(sessionUrl)
            .setBytesUploaded(0L)
            .setTotalBytes(-1L)
            .setState(
                sessionUrl == null
                    ? ResumableUploadStatus.State.STARTING
                    : ResumableUploadStatus.State.UPLOADING)
            .build();
  }

  public void setRetryingFuture(RetryingFuture<ResponseT> retryingFuture) {
    this.retryingFuture = checkNotNull(retryingFuture);
    retryingFuture.addListener(this::ensureTerminalStatus, MoreExecutors.directExecutor());
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
  // AdaptiveAttemptHandler Implementation
  // --------------------------------------------------------------------------

  @Override
  public ApiFuture<ResponseT> startAttempt(ApiCallContext attemptContext) {
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

    if (isResumedSession && !initialQueryDone) {
      initialQueryDone = true;
      QueryStatusRequest queryRequest = QueryStatusRequest.create(sessionUrl);
      return ApiFutures.transformAsync(
          client.queryStatusCallable().futureCall(queryRequest, attemptContext),
          (QueryStatusResponse<ResponseT> queryResponse) -> {
            if (queryResponse.isComplete()) {
              isUploadFinal = true;
              finalResponse = queryResponse.getResponse();
              long finalBytes = queryResponse.getCommittedOffset();
              updateStatus(
                  currentStatus.toBuilder()
                      .setState(ResumableUploadStatus.State.FINALIZED)
                      .setBytesUploaded(finalBytes)
                      .setTotalBytes(finalBytes)
                      .setException(null)
                      .build());
              return ApiFutures.immediateFuture(queryResponse.getResponse());
            }

            long serverCommitted = queryResponse.getCommittedOffset();
            this.committedOffset = serverCommitted;
            try {
              streamBuffer.seek(serverCommitted);
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

    return transmitChunks(attemptContext);
  }

  private ApiFuture<ResponseT> transmitChunks(ApiCallContext attemptContext) {
    ByteString chunkData;
    try {
      chunkData = streamBuffer.readChunk(committedOffset, chunkSize);
    } catch (IOException e) {
      return ApiFutures.immediateFailedFuture(e);
    }

    boolean isFinal = streamBuffer.isEndOfStream();
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(checkNotNull(sessionUrl, "sessionUrl must not be null"))
            .setPayload(chunkData)
            .setOffset(committedOffset)
            .setFinal(isFinal)
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
            long finalBytes = committedOffset + chunkData.size();
            updateStatus(
                currentStatus.toBuilder()
                    .setState(ResumableUploadStatus.State.FINALIZED)
                    .setTotalBytes(finalBytes)
                    .setBytesUploaded(finalBytes)
                    .setException(null)
                    .build());
            return ApiFutures.immediateFuture(response.getResponse());
          }

          committedOffset = response.getCommittedOffset();
          streamBuffer.commit(committedOffset);
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

  @Override
  public ApiFuture<Boolean> onAttemptFailure(
      Throwable previousThrowable, ApiCallContext attemptContext) {
    if (sessionUrl == null) {
      return ApiFutures.immediateFuture(true);
    }

    updateStatus(
        currentStatus.toBuilder()
            .setState(ResumableUploadStatus.State.RECOVERING)
            .setException(previousThrowable)
            .build());

    QueryStatusRequest queryRequest = QueryStatusRequest.create(sessionUrl);
    return ApiFutures.transform(
        client.queryStatusCallable().futureCall(queryRequest, attemptContext),
        (QueryStatusResponse<ResponseT> queryResponse) -> {
          if (queryResponse.isComplete()) {
            isUploadFinal = true;
            finalResponse = queryResponse.getResponse();
            updateStatus(
                currentStatus.toBuilder()
                    .setState(ResumableUploadStatus.State.FINALIZED)
                    .setBytesUploaded(committedOffset)
                    .setTotalBytes(committedOffset)
                    .setException(null)
                    .build());
            return true;
          }

          long serverCommitted = queryResponse.getCommittedOffset();
          this.committedOffset = serverCommitted;
          try {
            streamBuffer.seek(serverCommitted);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          updateStatus(
              currentStatus.toBuilder()
                  .setState(ResumableUploadStatus.State.OFFSET_RECEIVED)
                  .setBytesUploaded(serverCommitted)
                  .setException(null)
                  .build());
          return true;
        },
        MoreExecutors.directExecutor());
  }

  // --------------------------------------------------------------------------
  // ApiFuture Implementation Delegation
  // --------------------------------------------------------------------------

  @Override
  public void addListener(Runnable listener, Executor executor) {
    checkNotNull(retryingFuture, "retryingFuture must be set").addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    try {
      streamBuffer.close();
    } catch (IOException ignored) {
    }
    boolean result = retryingFuture != null && retryingFuture.cancel(mayInterruptIfRunning);
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
    return retryingFuture != null && retryingFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return retryingFuture != null && retryingFuture.isDone();
  }

  @Override
  public ResponseT get() throws InterruptedException, ExecutionException {
    try {
      return checkNotNull(retryingFuture, "retryingFuture must be set").get();
    } finally {
      ensureTerminalStatus();
    }
  }

  @Override
  public ResponseT get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    try {
      return checkNotNull(retryingFuture, "retryingFuture must be set").get(timeout, unit);
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
