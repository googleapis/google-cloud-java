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
package com.google.api.gax.httpjson;

import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.base.Strings;
import org.jspecify.annotations.NullMarked;

/** Shared header constants and parsing utilities for HTTP/JSON resumable upload wire calls. */
@NullMarked
final class ResumableUploadHeaders {

  static final String UPLOAD_PROTOCOL_HEADER = "X-Goog-Upload-Protocol";
  static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  static final String UPLOAD_URL_HEADER = "X-Goog-Upload-URL";
  static final String UPLOAD_GRANULARITY_HEADER = "X-Goog-Upload-Chunk-Granularity";
  static final String UPLOAD_OFFSET_HEADER = "X-Goog-Upload-Offset";
  static final String UPLOAD_STATUS_HEADER = "X-Goog-Upload-Status";
  static final String UPLOAD_SIZE_RECEIVED_HEADER = "X-Goog-Upload-Size-Received";

  private ResumableUploadHeaders() {}

  static ResumableUploadStatus parseUploadStatus(HttpJsonMetadata responseHeaders) {
    return ResumableUploadStatus.fromHeader(
        HttpHeadersUtils.getSingleHeader(responseHeaders.getHeaders(), UPLOAD_STATUS_HEADER));
  }

  static int parseChunkGranularity(HttpJsonMetadata responseHeaders) {
    String granularityStr =
        HttpHeadersUtils.getSingleHeader(responseHeaders.getHeaders(), UPLOAD_GRANULARITY_HEADER);
    if (Strings.isNullOrEmpty(granularityStr)) {
      return ResumableUploadSession.DEFAULT_CHUNK_GRANULARITY;
    }
    try {
      int parsed = Integer.parseInt(granularityStr);
      if (parsed <= 0) {
        throw ApiExceptionFactory.createException(
            "Response contained non-positive "
                + UPLOAD_GRANULARITY_HEADER
                + " header: "
                + granularityStr,
            /* cause= */ null,
            HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
            /* retryable= */ false);
      }
      return parsed;
    } catch (NumberFormatException e) {
      throw ApiExceptionFactory.createException(
          "Response contained invalid " + UPLOAD_GRANULARITY_HEADER + " header: " + granularityStr,
          e,
          HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
          /* retryable= */ false);
    }
  }
}
