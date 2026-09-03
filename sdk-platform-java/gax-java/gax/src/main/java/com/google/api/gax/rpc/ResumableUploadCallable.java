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
import java.io.InputStream;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A ResumableUploadCallable is an API-transport-independent wrapper for the Resumable Upload
 * protocol. Operates directly on the request object and input stream payload.
 *
 * @param <RequestT> the type of the initial request message that initiates the upload session
 * @param <ResponseT> the type of the final response message returned once the upload completes
 */
@BetaApi
@NullMarked
public abstract class ResumableUploadCallable<RequestT, ResponseT> {

  protected ResumableUploadCallable() {}

  /**
   * Performs a new resumable upload asynchronously with default call context and default settings.
   *
   * <p>The provided {@code payload} stream is consumed asynchronously by the returned {@link
   * ResumableUploadFuture} and will be closed automatically upon completion, failure, or
   * cancellation.
   *
   * @param request the request message
   * @param payload the data payload input stream to upload and close
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> futureCall(RequestT request, InputStream payload) {
    return futureCall(request, payload, null, null);
  }

  /**
   * Performs a new resumable upload asynchronously with a call context override and default
   * settings.
   *
   * <p>The provided {@code payload} stream is consumed asynchronously by the returned {@link
   * ResumableUploadFuture} and will be closed automatically upon completion, failure, or
   * cancellation.
   *
   * @param request the request message
   * @param payload the data payload input stream to upload and close
   * @param context call context overrides (e.g. extra headers, credentials, timeout); may be {@code
   *     null}
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ApiCallContext context) {
    return futureCall(request, payload, context, null);
  }

  /**
   * Performs a new resumable upload asynchronously with settings overrides and default call
   * context.
   *
   * <p>The provided {@code payload} stream is consumed asynchronously by the returned {@link
   * ResumableUploadFuture} and will be closed automatically upon completion, failure, or
   * cancellation.
   *
   * @param request the request message
   * @param payload the data payload input stream to upload and close
   * @param settings request-level call settings overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ResumableUploadCallSettings settings) {
    return futureCall(request, payload, null, settings);
  }

  /**
   * Performs a new resumable upload asynchronously with call context and settings overrides.
   *
   * <p>The provided {@code payload} stream is consumed asynchronously by the returned {@link
   * ResumableUploadFuture} and will be closed automatically upon completion, failure, or
   * cancellation.
   *
   * @param request the request message
   * @param payload the data payload input stream to upload and close
   * @param context call context overrides; may be {@code null}
   * @param settings request-level call settings overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public abstract ResumableUploadFuture<ResponseT> futureCall(
      RequestT request,
      InputStream payload,
      @Nullable ApiCallContext context,
      @Nullable ResumableUploadCallSettings settings);

  /**
   * Resumes an existing resumable upload session asynchronously using a saved session URL.
   *
   * <p>The provided {@code payload} stream is consumed asynchronously by the returned {@link
   * ResumableUploadFuture} and will be closed automatically upon completion, failure, or
   * cancellation.
   *
   * @param sessionUrl the upload session URL
   * @param payload the data payload input stream to upload and close
   * @param settings call settings overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public abstract ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, @Nullable ResumableUploadCallSettings settings);
}
