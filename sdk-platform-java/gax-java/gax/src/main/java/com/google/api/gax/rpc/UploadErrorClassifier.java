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

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Classifies exceptions encountered during resumable upload commands into protocol error
 * categories.
 *
 * <p>Implements the normative 5-step classification order:
 *
 * <ol>
 *   <li>Non-retryable sentinels by type (e.g. rewind below buffer base, session watchdog timeout).
 *   <li>{@link CancellationException} (propagated or terminal, never retried).
 *   <li>{@link ApiException} with {@code StatusCode.Code.UNKNOWN} (unwrap cause; ignore synthetic
 *       HTTP 500 transport code).
 *   <li>Standard table lookup on raw HTTP transport code.
 *   <li>Plain I/O or timeout exceptions (transient), anything else fatal.
 * </ol>
 */
@NullMarked
final class UploadErrorClassifier {

  private static final ImmutableMap<Integer, UploadErrorCategory> HTTP_STATUS_MAP =
      ImmutableMap.<Integer, UploadErrorCategory>builder()
          // Category 1: Transient - retry identical request with backoff
          // 408 Request Timeout: connection drop or socket timeout during request transmission
          .put(408, UploadErrorCategory.TRANSIENT)
          // 429 Too Many Requests: server-side rate limiting or throttling
          .put(429, UploadErrorCategory.TRANSIENT)
          // 500 Internal Server Error: transient server-side error
          .put(500, UploadErrorCategory.TRANSIENT)
          // 502 Bad Gateway: transient intermediate proxy or gateway error
          .put(502, UploadErrorCategory.TRANSIENT)
          // 503 Service Unavailable: transient server overload or temporary maintenance
          .put(503, UploadErrorCategory.TRANSIENT)
          // 504 Gateway Timeout: transient upstream gateway timeout
          .put(504, UploadErrorCategory.TRANSIENT)

          // Category 2: Recoverable - query status to realign buffer offset before resending
          // 400 Bad Request: wrong offset or unaligned chunk boundary from upload server
          .put(400, UploadErrorCategory.RECOVERABLE)
          // 409 Conflict: offset mismatch between client and server
          .put(409, UploadErrorCategory.RECOVERABLE)
          // 412 Precondition Failed: upload session state precondition mismatch
          .put(412, UploadErrorCategory.RECOVERABLE)
          // 416 Range Not Satisfiable: chunk byte range out of server bounds
          .put(416, UploadErrorCategory.RECOVERABLE)

          // Category 3: Fatal - bubble up to fail the upload session immediately
          // 401 Unauthorized: unauthenticated caller or invalid credentials
          .put(401, UploadErrorCategory.FATAL)
          // 403 Forbidden: caller lacks required permissions
          .put(403, UploadErrorCategory.FATAL)
          // 404 Not Found: upload session URL expired, unknown, or resource deleted
          .put(404, UploadErrorCategory.FATAL)
          // 405 Method Not Allowed: unsupported HTTP method
          .put(405, UploadErrorCategory.FATAL)
          // 410 Gone: upload session permanently expired or cancelled
          .put(410, UploadErrorCategory.FATAL)
          // 413 Payload Too Large: payload size exceeds maximum allowed upload size
          .put(413, UploadErrorCategory.FATAL)
          // 415 Unsupported Media Type: payload media type rejected by server
          .put(415, UploadErrorCategory.FATAL)
          .build();

  private UploadErrorClassifier() {}

  /**
   * Classifies an exception for the given upload command according to the normative classification
   * order.
   *
   * @param t the error to classify
   * @param command the upload command that produced the error
   * @return the classified error category
   */
  static UploadErrorCategory classify(@Nullable Throwable t, UploadCommand command) {
    if (t == null) {
      return UploadErrorCategory.FATAL;
    }

    // Step 1: Non-retryable sentinels by type before inspecting status codes.
    if (t instanceof UploadProtocolViolationException
        || t instanceof ResumableUploadTimeoutException) {
      return UploadErrorCategory.FATAL;
    }

    // Step 2: CancellationException -> terminal, do not classify as retryable.
    if (t instanceof CancellationException) {
      return UploadErrorCategory.FATAL;
    }

    // Steps 3 & 4: ApiException handling.
    if (t instanceof ApiException) {
      ApiException apiException = (ApiException) t;

      // Step 3: ApiException with Code.UNKNOWN -> ignore the transport code entirely.
      // GAX transforms unrecognised throwables into Code.UNKNOWN, which carries a synthetic
      // HTTP transport code 500. Without this step, internal bugs and NPEs would be misclassified
      // as Cat 1 and retried indefinitely. Real HTTP 500 responses arrive with Code.INTERNAL.
      if (apiException.getStatusCode().getCode() == StatusCode.Code.UNKNOWN) {
        Throwable cause = apiException.getCause();
        if (cause instanceof IOException) {
          return UploadErrorCategory.TRANSIENT;
        }
        return UploadErrorCategory.FATAL;
      }

      // Step 4: Table lookup on raw HTTP transport code.
      Object transportCode = apiException.getStatusCode().getTransportCode();
      if (transportCode instanceof Integer) {
        UploadErrorCategory category = HTTP_STATUS_MAP.get(transportCode);
        if (category != null) {
          // The START command cannot enter recovery since no upload session exists yet.
          if (command == UploadCommand.START && category == UploadErrorCategory.RECOVERABLE) {
            return UploadErrorCategory.FATAL;
          }
          return category;
        }
      }
      return UploadErrorCategory.FATAL;
    }

    // Step 5: Plain I/O or timeout exceptions that bypassed ApiException wrapping.
    if (t instanceof IOException) {
      return UploadErrorCategory.TRANSIENT;
    }

    // Anything else unrecognized -> FATAL. Never default to retryable.
    return UploadErrorCategory.FATAL;
  }

  /**
   * Classifies a missing upload status response header according to the wire command.
   *
   * @param command the upload command that received a response lacking the status header
   * @return the classified error category
   */
  static UploadErrorCategory classifyMissingStatusHeader(UploadCommand command) {
    switch (command) {
      case START:
        return UploadErrorCategory.TRANSIENT;
      case UPLOAD:
      case FINALIZE:
      case UPLOAD_FINALIZE:
        return UploadErrorCategory.RECOVERABLE;
      case QUERY:
      case CANCEL:
      default:
        return UploadErrorCategory.FATAL;
    }
  }
}
