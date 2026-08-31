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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadFutureImpl;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import java.io.InputStream;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Concrete implementation of {@link ResumableUploadCallable} that manages session initiation (Phase
 * 1) and delegates data transfer and recovery (Phase 2) to {@link ResumableUploadFutureImpl}.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadCallableImpl<RequestT, ResponseT>
    extends ResumableUploadCallable<RequestT, ResponseT> {

  private final ResumableUploadClient<RequestT, ResponseT> client;
  private final RetryingExecutorWithContext<ResponseT> retryingExecutor;
  private final ResumableUploadCallSettings defaultCallSettings;
  private final ApiCallContext callContextPrototype;

  public ResumableUploadCallableImpl(
      ResumableUploadClient<RequestT, ResponseT> client,
      RetryingExecutorWithContext<ResponseT> retryingExecutor,
      ResumableUploadCallSettings defaultCallSettings,
      ApiCallContext callContextPrototype) {
    this.client = checkNotNull(client);
    this.retryingExecutor = checkNotNull(retryingExecutor);
    this.defaultCallSettings = checkNotNull(defaultCallSettings);
    this.callContextPrototype = checkNotNull(callContextPrototype);
  }

  @Override
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    checkNotNull(request, "request must not be null");
    checkNotNull(payload, "payload must not be null");
    ResumableUploadCallSettings effectiveSettings = defaultCallSettings.merge(settings);
    ApiCallContext callContext = callContextPrototype.nullToSelf(null);

    return new ResumableUploadFutureImpl<>(
        client, request, payload, effectiveSettings.getChunkSize(), retryingExecutor, callContext);
  }

  @Override
  public ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    throw new UnsupportedOperationException(
        "Session resumption is supported in subsequent release");
  }
}
