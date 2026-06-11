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

/**
 * A ResumableUploadCallable is an API-transport-independent wrapper for the Resumable Upload
 * protocol.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
public abstract class ResumableUploadCallable<RequestT, ResponseT> {

  protected ResumableUploadCallable() {}

  /**
   * Performs the resumable upload asynchronously.
   *
   * @param request the upload request options
   * @param context the context of the call
   * @return future for the response
   */
  public abstract ApiFuture<ResponseT> futureCall(
      ResumableUploadRequest<RequestT> request, ApiCallContext context);

  /**
   * Performs the resumable upload asynchronously.
   *
   * @param request the upload request options
   * @return future for the response
   */
  public ApiFuture<ResponseT> futureCall(ResumableUploadRequest<RequestT> request) {
    return futureCall(request, null);
  }

  /**
   * Performs the resumable upload synchronously.
   *
   * @param request the upload request options
   * @param context the context of the call
   * @return the RPC response
   */
  public ResponseT call(ResumableUploadRequest<RequestT> request, ApiCallContext context) {
    return ApiExceptions.callAndTranslateApiException(futureCall(request, context));
  }

  /**
   * Performs the resumable upload synchronously.
   *
   * @param request the upload request options
   * @return the RPC response
   */
  public ResponseT call(ResumableUploadRequest<RequestT> request) {
    return call(request, null);
  }
}
