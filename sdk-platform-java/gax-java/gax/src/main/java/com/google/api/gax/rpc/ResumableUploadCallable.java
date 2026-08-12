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
import com.google.api.core.BetaApi;
import java.io.InputStream;

/**
 * A ResumableUploadCallable is an API-transport-independent wrapper for the Resumable Upload
 * protocol (Scotty). Operates directly on the request object and input stream payload.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
public abstract class ResumableUploadCallable<RequestT, ResponseT> {

  protected ResumableUploadCallable() {}

  /**
   * Performs the resumable upload asynchronously with custom per-request settings and context.
   *
   * @param request the request message
   * @param payload the data payload input stream
   * @param perRequestSettings request-level call settings overrides; may be {@code null}
   * @param context the call context; may be {@code null}
   * @return future for the response
   */
  public abstract ApiFuture<ResponseT> futureCall(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings,
      ApiCallContext context);

  /**
   * Performs the resumable upload asynchronously with custom per-request settings and a null context.
   */
  public ApiFuture<ResponseT> futureCall(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings) {
    return futureCall(request, payload, perRequestSettings, (ApiCallContext) null);
  }

  /**
   * Performs the resumable upload asynchronously with default settings and a null context.
   */
  public ApiFuture<ResponseT> futureCall(RequestT request, InputStream payload) {
    return futureCall(
        request, payload, (ResumableUploadCallSettings<RequestT, ResponseT>) null, (ApiCallContext) null);
  }

  /**
   * Performs the resumable upload synchronously with custom per-request settings and context.
   */
  public ResponseT call(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings,
      ApiCallContext context) {
    return ApiExceptions.callAndTranslateApiException(
        futureCall(request, payload, perRequestSettings, context));
  }

  /**
   * Performs the resumable upload synchronously with custom per-request settings and a null context.
   */
  public ResponseT call(
      RequestT request,
      InputStream payload,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings) {
    return call(request, payload, perRequestSettings, (ApiCallContext) null);
  }

  /**
   * Performs the resumable upload synchronously with default settings and a null context.
   */
  public ResponseT call(RequestT request, InputStream payload) {
    return call(
        request, payload, (ResumableUploadCallSettings<RequestT, ResponseT>) null, (ApiCallContext) null);
  }
}
