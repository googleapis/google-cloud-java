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
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
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
  private final String uploadUrl;
  private final RewindableStreamBuffer buffer;
  private final ApiCallContext callContext;
  private final SettableApiFuture<ResponseT> uploadResultFuture = SettableApiFuture.create();
  private volatile @Nullable ApiFuture<?> inFlightFuture;

  ResumableUploadChunkCoordinator(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      String uploadUrl,
      InputStream payload,
      int chunkSize,
      ApiCallContext callContext) {
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.uploadUrl = checkNotNull(uploadUrl, "uploadUrl must not be null");
    checkNotNull(payload, "payload must not be null");
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.buffer = new RewindableStreamBuffer(payload, chunkSize, uploadUrl);
  }

  ApiFuture<ResponseT> getFuture() {
    return uploadResultFuture;
  }

  void start() {
    uploadResultFuture.addListener(
        () -> {
          ApiFuture<?> inFlight = inFlightFuture;
          if (uploadResultFuture.isCancelled() && inFlight != null) {
            inFlight.cancel(true);
          }
        },
        MoreExecutors.directExecutor());
    transmitChunk();
  }

  private void transmitChunk() {
    try {
      // Abort if the session was already completed or canceled.
      if (uploadResultFuture.isDone()) {
        return;
      }

      // Read the next chunk slice from the payload stream.
      buffer.fill();

      // Determine if this is the final chunk and build the chunk request.
      ChunkUploadRequest chunkRequest =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(uploadUrl)
              .setPayload(buffer.getPayload())
              .setOffset(buffer.getBufferBaseOffset())
              .setFinal(buffer.isFinal())
              .build();

      // Dispatch the chunk upload call and register the in-flight future for cancellation.
      boolean isFinal = chunkRequest.isFinal();
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
              if (response.getUploadStatus() == ResumableUploadStatus.FINAL) {
                uploadResultFuture.set(response.getResponse());
              } else if (isFinal) {
                uploadResultFuture.setException(
                    new IllegalStateException(
                        "Upload stream ended and final chunk was transmitted, but server returned"
                            + " incomplete status"));
              } else {
                transmitChunk();
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
  private boolean tryRegisterInFlightFuture(ApiFuture<?> future) {
    this.inFlightFuture = future;
    if (uploadResultFuture.isCancelled()) {
      future.cancel(true);
      return false;
    }
    return true;
  }
}
