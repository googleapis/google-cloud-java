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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadFuture;
import com.google.api.gax.resumable.ResumableUploadFutureImpl;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.retrying.AdaptiveRetryingCallable;
import com.google.api.gax.retrying.RetryingFuture;
import java.io.InputStream;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Concrete implementation of {@link ResumableUploadCallable} that initiates or resumes an upload
 * session and executes the state machine under an {@link AdaptiveRetryingCallable}.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadCallableImpl<RequestT, ResponseT>
    extends ResumableUploadCallable<RequestT, ResponseT> {

  private final ResumableUploadClient client;
  private final AdaptiveRetryingCallable<ResponseT> adaptiveRetryingCallable;
  private final ResumableUploadCallSettings defaultCallSettings;
  private final @Nullable ApiFunction<RequestT, StartUploadRequest> requestTransformer;
  private final ApiFunction<String, ResponseT> responseTransformer;
  private final ApiCallContext callContextPrototype;

  public ResumableUploadCallableImpl(
      ResumableUploadClient client,
      AdaptiveRetryingCallable<ResponseT> adaptiveRetryingCallable,
      ResumableUploadCallSettings defaultCallSettings,
      @Nullable ApiFunction<RequestT, StartUploadRequest> requestTransformer,
      ApiFunction<String, ResponseT> responseTransformer,
      ApiCallContext callContextPrototype) {
    this.client = checkNotNull(client);
    this.adaptiveRetryingCallable = checkNotNull(adaptiveRetryingCallable);
    this.defaultCallSettings = checkNotNull(defaultCallSettings);
    this.requestTransformer = requestTransformer;
    this.responseTransformer = checkNotNull(responseTransformer);
    this.callContextPrototype = checkNotNull(callContextPrototype);
  }

  @Override
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    ResumableUploadCallSettings effectiveSettings = defaultCallSettings.merge(settings);

    ResumableUploadFutureImpl<RequestT, ResponseT> future =
        new ResumableUploadFutureImpl<>(
            client,
            /* sessionUrl= */ null,
            request,
            payload,
            effectiveSettings.getChunkSize(),
            requestTransformer,
            responseTransformer);

    if (effectiveSettings.getProgressListener() != null) {
      if (effectiveSettings.getProgressListenerExecutor() != null) {
        future.addProgressListener(
            effectiveSettings.getProgressListener(),
            effectiveSettings.getProgressListenerExecutor());
      } else {
        future.addProgressListener(effectiveSettings.getProgressListener());
      }
    }

    RetryingFuture<ResponseT> retryingFuture =
        adaptiveRetryingCallable.futureCall(future, callContextPrototype);
    future.setRetryingFuture(retryingFuture);

    return future;
  }

  @Override
  public ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    ResumableUploadCallSettings effectiveSettings = defaultCallSettings.merge(settings);

    ResumableUploadFutureImpl<RequestT, ResponseT> future =
        new ResumableUploadFutureImpl<>(
            client,
            sessionUrl,
            /* initialRequest= */ null,
            payload,
            effectiveSettings.getChunkSize(),
            requestTransformer,
            responseTransformer);

    if (effectiveSettings.getProgressListener() != null) {
      if (effectiveSettings.getProgressListenerExecutor() != null) {
        future.addProgressListener(
            effectiveSettings.getProgressListener(),
            effectiveSettings.getProgressListenerExecutor());
      } else {
        future.addProgressListener(effectiveSettings.getProgressListener());
      }
    }

    RetryingFuture<ResponseT> retryingFuture =
        adaptiveRetryingCallable.futureCall(future, callContextPrototype);
    future.setRetryingFuture(retryingFuture);

    return future;
  }
}
