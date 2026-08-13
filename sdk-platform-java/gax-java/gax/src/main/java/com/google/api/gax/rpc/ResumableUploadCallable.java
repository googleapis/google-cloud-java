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

import com.google.api.core.BetaApi;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import javax.annotation.Nullable;

/**
 * A ResumableUploadCallable is an API-transport-independent wrapper for the Resumable Upload
 * protocol. Operates directly on the request object and input stream payload.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
public class ResumableUploadCallable<RequestT, ResponseT> {

  private final ResumableUploadClient resumableUploadClient;
  @Nullable private final ResumableUploadCallSettings defaultCallSettings;

  public ResumableUploadCallable(
      ResumableUploadClient resumableUploadClient,
      @Nullable ResumableUploadCallSettings defaultCallSettings) {
    this.resumableUploadClient = Preconditions.checkNotNull(resumableUploadClient);
    this.defaultCallSettings = defaultCallSettings;
  }

  public ResumableUploadCallable(ResumableUploadClient resumableUploadClient) {
    this(resumableUploadClient, null);
  }

  /**
   * Performs a new resumable upload asynchronously.
   *
   * @param request the request message
   * @param payload the data payload input stream
   * @param perRequestSettings call settings overrides; may be {@code null}
   * @param context call context overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings perRequestSettings,
      ApiCallContext context) {
    Preconditions.checkNotNull(request);

    ResumableUploadCallSettings activeSettings =
        defaultCallSettings != null
            ? defaultCallSettings.merge(perRequestSettings)
            : perRequestSettings;

    ResumableUploadFutureImpl<RequestT, ResponseT> future =
        new ResumableUploadFutureImpl<>(
            resumableUploadClient, request, payload, activeSettings, context);

    future.start();
    return future;
  }

  /**
   * Resumes an existing resumable upload session asynchronously using a saved session URL.
   *
   * @param sessionUrl the upload session URL
   * @param payload the data payload input stream
   * @param perRequestSettings call settings overrides; may be {@code null}
   * @param context call context overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl,
      InputStream payload,
      ResumableUploadCallSettings perRequestSettings,
      ApiCallContext context) {
    Preconditions.checkNotNull(sessionUrl);

    ResumableUploadCallSettings activeSettings =
        defaultCallSettings != null
            ? defaultCallSettings.merge(perRequestSettings)
            : perRequestSettings;

    ResumableUploadFutureImpl<RequestT, ResponseT> future =
        new ResumableUploadFutureImpl<>(
            resumableUploadClient, sessionUrl, payload, activeSettings, context);

    future.start();
    return future;
  }

  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, ResumableUploadCallSettings settings) {
    return futureCall(request, payload, settings, null);
  }

  public ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, ResumableUploadCallSettings settings) {
    return resumeCall(sessionUrl, payload, settings, null);
  }
}
