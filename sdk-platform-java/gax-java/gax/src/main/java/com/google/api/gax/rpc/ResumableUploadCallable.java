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
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
@NullMarked
public abstract class ResumableUploadCallable<RequestT, ResponseT> {

  protected ResumableUploadCallable() {}

  /**
   * Performs a new resumable upload asynchronously.
   *
   * @param request the request message
   * @param payload the data payload input stream
   * @param settings call settings overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public abstract ResumableUploadFuture<ResponseT> futureCall(
      RequestT request, InputStream payload, @Nullable ResumableUploadCallSettings settings);

  /**
   * Same as {@link #futureCall(Object, InputStream, ResumableUploadCallSettings)}, with null
   * settings.
   *
   * @param request the request message
   * @param payload the data payload input stream
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> futureCall(RequestT request, InputStream payload) {
    return futureCall(request, payload, null);
  }

  /**
   * Resumes an existing resumable upload session asynchronously using a saved session URL.
   *
   * @param sessionUrl the upload session URL
   * @param payload the data payload input stream
   * @param settings call settings overrides; may be {@code null}
   * @return future for tracking and controlling the upload
   */
  public abstract ResumableUploadFuture<ResponseT> resumeCall(
      String sessionUrl, InputStream payload, @Nullable ResumableUploadCallSettings settings);

  /**
   * Same as {@link #resumeCall(String, InputStream, ResumableUploadCallSettings)}, with null
   * settings.
   *
   * @param sessionUrl the upload session URL
   * @param payload the data payload input stream
   * @return future for tracking and controlling the upload
   */
  public ResumableUploadFuture<ResponseT> resumeCall(String sessionUrl, InputStream payload) {
    return resumeCall(sessionUrl, payload, null);
  }
}
