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
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import org.jspecify.annotations.NullMarked;

/**
 * Coordinates chunk transmission steps of a resumable upload session.
 *
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@InternalApi
@NullMarked
final class ResumableUploadChunkCoordinator<ResponseT> {

  private static final byte[] EMPTY_PAYLOAD = new byte[0];

  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final String uploadUrl;
  private final InputStream payload;
  private final int chunkSize;
  private final ApiCallContext callContext;
  private final ScheduledExecutorService executor;
  private final ResumableUploadFutureImpl<ResponseT> sessionFuture;

  ResumableUploadChunkCoordinator(
      UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable,
      String uploadUrl,
      InputStream payload,
      int chunkSize,
      ApiCallContext callContext,
      ScheduledExecutorService executor,
      ResumableUploadFutureImpl<ResponseT> sessionFuture) {
    this.uploadChunkCallable =
        checkNotNull(uploadChunkCallable, "uploadChunkCallable must not be null");
    this.uploadUrl = checkNotNull(uploadUrl, "uploadUrl must not be null");
    this.payload = checkNotNull(payload, "payload must not be null");
    this.chunkSize = chunkSize;
    this.callContext = checkNotNull(callContext, "callContext must not be null");
    this.executor = checkNotNull(executor, "executor must not be null");
    this.sessionFuture = checkNotNull(sessionFuture, "sessionFuture must not be null");
  }

  void start() {
    transmitChunk(0L);
  }

  private void transmitChunk(long currentOffset) {
    // Abort if the session was already completed or canceled.
    if (sessionFuture.isDone()) {
      return;
    }

    // Read the next chunk slice from the payload stream.
    byte[] buffer = new byte[chunkSize];
    int bytesRead;
    try {
      bytesRead = ByteStreams.read(payload, buffer, 0, chunkSize);
    } catch (IOException e) {
      sessionFuture.fail(e);
      return;
    }

    // Determine if this is the final chunk and build the chunk request.
    boolean isFinal = bytesRead < chunkSize;
    byte[] chunkPayload;
    if (bytesRead == chunkSize) {
      chunkPayload = buffer;
    } else if (bytesRead == 0) {
      chunkPayload = EMPTY_PAYLOAD;
    } else {
      chunkPayload = Arrays.copyOf(buffer, bytesRead);
    }

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(uploadUrl)
            .setPayload(chunkPayload)
            .setOffset(currentOffset)
            .setFinal(isFinal)
            .build();

    // Dispatch the chunk upload call and register the in-flight future for cancellation.
    long chunkLength = chunkPayload.length;
    try {
      ApiFuture<ChunkUploadResponse<ResponseT>> chunkFuture =
          uploadChunkCallable.futureCall(chunkRequest, callContext);
      sessionFuture.setInFlightFuture(chunkFuture);

      // Asynchronously handle the response: complete, fail, or chain the next chunk.
      ApiFutures.addCallback(
          chunkFuture,
          new ApiFutureCallback<ChunkUploadResponse<ResponseT>>() {
            @Override
            public void onSuccess(ChunkUploadResponse<ResponseT> response) {
              if (sessionFuture.isDone()) {
                return;
              }
              long nextOffset = currentOffset + chunkLength;
              if (response.isComplete()) {
                sessionFuture.succeed(response.getResponse());
              } else if (isFinal) {
                sessionFuture.fail(
                    new IllegalStateException(
                        "Upload stream ended and final chunk was transmitted, but server returned"
                            + " incomplete status"));
              } else {
                transmitChunk(nextOffset);
              }
            }

            @Override
            public void onFailure(Throwable t) {
              if (t instanceof CancellationException || sessionFuture.isDone()) {
                return;
              }
              sessionFuture.fail(t);
            }
          },
          executor);
    } catch (Throwable t) {
      sessionFuture.fail(t);
    }
  }
}
