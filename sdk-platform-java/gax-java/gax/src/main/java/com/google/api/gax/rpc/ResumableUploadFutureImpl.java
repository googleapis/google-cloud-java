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
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Caller-facing delegation handle for a resumable upload session.
 *
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@NullMarked
final class ResumableUploadFutureImpl<ResponseT> implements ResumableUploadFuture<ResponseT> {

  private final SettableApiFuture<ResponseT> result;
  private final ResumableUploadChunkCoordinator<ResponseT> coordinator;

  static <ResponseT> ResumableUploadFutureImpl<ResponseT> create(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext) {
    return create(
        startFuture,
        uploadChunkCallable,
        payload,
        settings,
        callContext,
        ClientContext.newBuilder().setDefaultCallContext(callContext).build());
  }

  static <ResponseT> ResumableUploadFutureImpl<ResponseT> create(
      ApiFuture<ResumableUploadSession> startFuture,
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext callContext,
      ClientContext clientContext) {
    SettableApiFuture<ResponseT> result = SettableApiFuture.create();
    ResumableUploadChunkCoordinator<ResponseT> coordinator =
        new ResumableUploadChunkCoordinator<>(
            result,
            startFuture,
            uploadChunkCallable,
            payload,
            settings,
            callContext,
            clientContext);
    ResumableUploadFutureImpl<ResponseT> handle =
        new ResumableUploadFutureImpl<>(result, coordinator);
    coordinator.start();
    return handle;
  }

  ResumableUploadFutureImpl(
      SettableApiFuture<ResponseT> result, ResumableUploadChunkCoordinator<ResponseT> coordinator) {
    this.result = checkNotNull(result, "result must not be null");
    this.coordinator = checkNotNull(coordinator, "coordinator must not be null");
  }

  @Override
  public @Nullable String getUploadSessionUrl() {
    return coordinator.getUploadSessionUrl();
  }

  @Override
  public void addListener(Runnable listener, Executor executor) {
    result.addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    coordinator.cancel(mayInterruptIfRunning);
    return result.cancel(mayInterruptIfRunning);
  }

  @Override
  public boolean isCancelled() {
    return result.isCancelled();
  }

  @Override
  public boolean isDone() {
    return result.isDone();
  }

  @Override
  public ResponseT get() throws InterruptedException, ExecutionException {
    return result.get();
  }

  @Override
  public ResponseT get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return result.get(timeout, unit);
  }
}
