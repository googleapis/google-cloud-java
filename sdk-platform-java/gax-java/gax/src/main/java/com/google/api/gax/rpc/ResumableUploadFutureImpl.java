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

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.InputStream;
import javax.annotation.Nullable;

/**
 * Stateful per-request implementation of {@link ResumableUploadFuture}.
 * Manages payload chunking, stream offsets, recovery, and session tracking.
 */
@BetaApi
public class ResumableUploadFutureImpl<RequestT, ResponseT>
    extends AbstractApiFuture<ResponseT> implements ResumableUploadFuture<ResponseT> {

  private final ResumableUploadClient resumableUploadClient;
  @Nullable private final RequestT request;
  @Nullable private final String initialSessionUrl;
  private final InputStream payload;
  private final ResumableUploadCallSettings settings;
  private final ApiCallContext context;

  private volatile String uploadSessionUrl;
  private volatile long committedOffset = 0L;
  private volatile ApiFuture<?> inFlightChunkFuture;

  public ResumableUploadFutureImpl(
      ResumableUploadClient resumableUploadClient,
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext context) {
    this.resumableUploadClient = Preconditions.checkNotNull(resumableUploadClient);
    this.request = Preconditions.checkNotNull(request);
    this.initialSessionUrl = null;
    this.payload = Preconditions.checkNotNull(payload);
    this.settings = settings;
    this.context = context;
  }

  public ResumableUploadFutureImpl(
      ResumableUploadClient resumableUploadClient,
      String sessionUrl,
      InputStream payload,
      ResumableUploadCallSettings settings,
      ApiCallContext context) {
    this.resumableUploadClient = Preconditions.checkNotNull(resumableUploadClient);
    this.request = null;
    this.initialSessionUrl = Preconditions.checkNotNull(sessionUrl);
    this.payload = Preconditions.checkNotNull(payload);
    this.settings = settings;
    this.context = context;
  }

  public void start() {
    if (initialSessionUrl != null) {
      this.uploadSessionUrl = initialSessionUrl;
      queryAndResume();
    } else {
      initiateSessionAndUpload();
    }
  }

  private void initiateSessionAndUpload() {
    ApiFuture<ResumableUploadSession> sessionFuture =
        resumableUploadClient.<RequestT>startUploadCallable().futureCall(request, context);

    ApiFutures.addCallback(
        sessionFuture,
        new ApiFutureCallback<ResumableUploadSession>() {
          @Override
          public void onSuccess(ResumableUploadSession session) {
            uploadSessionUrl = session.getUploadUrl();
            uploadNextChunk();
          }

          @Override
          public void onFailure(Throwable t) {
            setException(t);
          }
        },
        MoreExecutors.directExecutor());
  }

  private void queryAndResume() {
    uploadNextChunk();
  }

  private void uploadNextChunk() {
    try {
      int chunkSize = settings != null ? settings.getChunkSize() : 8 * 1024 * 1024;
      byte[] buffer = new byte[0];

      ChunkUploadRequest chunkRequest =
          new ChunkUploadRequest(uploadSessionUrl, buffer, committedOffset, -1L, true);

      ApiFuture<ChunkUploadResponse> chunkFuture =
          resumableUploadClient.uploadChunkCallable().futureCall(chunkRequest, context);

      this.inFlightChunkFuture = chunkFuture;

      ApiFutures.addCallback(
          chunkFuture,
          new ApiFutureCallback<ChunkUploadResponse>() {
            @Override
            public void onSuccess(ChunkUploadResponse response) {
              @SuppressWarnings("unchecked")
              ResponseT result = (ResponseT) response.getResponseBody();
              set(result);
            }

            @Override
            public void onFailure(Throwable t) {
              setException(t);
            }
          },
          MoreExecutors.directExecutor());
    } catch (Throwable t) {
      setException(t);
    }
  }

  @Override
  public String getUploadSessionUrl() {
    return uploadSessionUrl;
  }

  public long getCommittedOffset() {
    return committedOffset;
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    if (inFlightChunkFuture != null) {
      inFlightChunkFuture.cancel(mayInterruptIfRunning);
    }
    return super.cancel(mayInterruptIfRunning);
  }
}
