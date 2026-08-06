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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import javax.annotation.Nullable;

/**
 * An implementation of {@link ResumableUploadCallable} that orchestrates atomic low-level
 * Scotty upload RPCs via a {@link ResumableUploadClient}.
 *
 * <p>Modeled after {@link OperationCallableImpl}.
 */
@BetaApi
public class ResumableUploadCallableImpl<RequestT, ResponseT>
    extends ResumableUploadCallable<RequestT, ResponseT> {

  private final ResumableUploadClient resumableUploadClient;
  @Nullable private final ResumableUploadCallSettings<RequestT, ResponseT> defaultCallSettings;

  public ResumableUploadCallableImpl(
      ResumableUploadClient resumableUploadClient,
      @Nullable ResumableUploadCallSettings<RequestT, ResponseT> defaultCallSettings) {
    this.resumableUploadClient = Preconditions.checkNotNull(resumableUploadClient);
    this.defaultCallSettings = defaultCallSettings;
  }

  public ResumableUploadCallableImpl(ResumableUploadClient resumableUploadClient) {
    this(resumableUploadClient, null);
  }

  @Override
  public ApiFuture<ResponseT> futureCall(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings,
      ApiCallContext context) {
    Preconditions.checkNotNull(request);

    ResumableUploadCallSettings<RequestT, ResponseT> activeSettings =
        defaultCallSettings != null
            ? defaultCallSettings.mergeWith(perRequestSettings)
            : perRequestSettings;

    int chunkSize =
        activeSettings != null
            ? activeSettings.getChunkSizeOrDefault()
            : 8 * 1024 * 1024; // default 8 MB

    long totalBytes =
        activeSettings != null && activeSettings.getTotalBytes() != null
            ? activeSettings.getTotalBytes()
            : -1L;

    try {
      // 1. Start Upload Session with raw RequestT
      ResumableUploadSession session =
          resumableUploadClient
              .<RequestT>startUploadCallable()
              .call(request, context);

      String uploadUrl = session.getUploadUrl();

      // 2. Transmit Chunks
      ChunkUploadResponse response =
          resumableUploadClient
              .uploadChunkCallable()
              .call(
                  new ChunkUploadRequest(
                      uploadUrl, new byte[0], 0, totalBytes, true),
                  context);

      // Return placeholder/parsed response
      @SuppressWarnings("unchecked")
      ResponseT result = (ResponseT) response.getResponseBody();
      return ApiFutures.immediateFuture(result);
    } catch (Exception e) {
      return ApiFutures.immediateFailedFuture(e);
    }
  }
}
