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
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Concrete implementation of {@link ResumableUploadCallable} that delegates the end-to-end
 * management of a resumable upload session to {@link ResumableUploadFutureImpl}.
 *
 * @param <RequestT> the type of the initial request message that initiates the upload session
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadCallableImpl<RequestT, ResponseT>
    extends ResumableUploadCallable<RequestT, ResponseT> {

  private final ResumableUploadClient<RequestT, ResponseT> client;
  private final ResumableUploadCallSettings defaultCallSettings;
  private final ApiCallContext defaultCallContext;
  private final ScheduledExecutorService executor;

  public ResumableUploadCallableImpl(
      ResumableUploadClient<RequestT, ResponseT> client,
      ResumableUploadCallSettings defaultCallSettings,
      ApiCallContext defaultCallContext,
      ScheduledExecutorService executor) {
    this.client = checkNotNull(client, "client must not be null");
    this.defaultCallSettings =
        checkNotNull(defaultCallSettings, "defaultCallSettings must not be null");
    this.defaultCallContext =
        checkNotNull(defaultCallContext, "defaultCallContext must not be null");
    this.executor = checkNotNull(executor, "executor must not be null");
  }

  @Override
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    checkNotNull(request, "request must not be null");
    checkNotNull(payload, "payload must not be null");
    ResumableUploadCallSettings effectiveSettings = defaultCallSettings.merge(settings);

    ApiFuture<ResumableUploadSession> startFuture;
    try {
      startFuture = client.startUploadCallable().futureCall(request, defaultCallContext);
    } catch (Throwable t) {
      startFuture = ApiFutures.immediateFailedFuture(t);
    }

    return ResumableUploadFutureImpl.create(
        startFuture,
        client.uploadChunkCallable(),
        payload,
        effectiveSettings,
        defaultCallContext,
        executor);
  }

  @Override
  public ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    throw new UnsupportedOperationException("Session resumption is not yet implemented.");
  }
}
