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
import java.util.Objects;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.NullMarked;

/**
 * Classifies exceptions encountered during resumable upload commands to determine whether/how to
 * recover.
 */
@NullMarked
final class ResumableUploadErrorClassifier {

  enum Category {
    TRANSIENT,
    RECOVERABLE,
    FATAL
  }

  private static final ImmutableMap<Integer, Category> HTTP_STATUS_MAP =
      ImmutableMap.<Integer, Category>builder()
          .put(408, Category.TRANSIENT)
          .put(429, Category.TRANSIENT)
          .put(500, Category.TRANSIENT)
          .put(502, Category.TRANSIENT)
          .put(503, Category.TRANSIENT)
          .put(504, Category.TRANSIENT)
          .put(400, Category.RECOVERABLE)
          .put(409, Category.RECOVERABLE)
          .put(412, Category.RECOVERABLE)
          .put(416, Category.RECOVERABLE)
          .put(401, Category.FATAL)
          .put(403, Category.FATAL)
          .put(404, Category.FATAL)
          .put(405, Category.FATAL)
          .put(410, Category.FATAL)
          .put(413, Category.FATAL)
          .put(415, Category.FATAL)
          .build();

  private ResumableUploadErrorClassifier() {}

  /**
   * Classifies an exception for the given upload command according to protocol rules.
   *
   * @param t the error to classify
   * @param command the upload command that produced the error
   * @return the classified error category
   */
  static Category classify(Throwable t, ResumableUploadCommand command) {
    Objects.requireNonNull(t, "t must not be null");
    Objects.requireNonNull(command, "command must not be null");

    // Cancellation is terminal and never retryable.
    if (t instanceof CancellationException) {
      return Category.FATAL;
    }

    if (t instanceof ApiException) {
      ApiException apiException = (ApiException) t;

      // GAX assigns a synthetic HTTP 500 to Code.UNKNOWN. Only retry if caused
      // by an IOException; client bugs (NPE, etc.) must remain FATAL.
      // Actual 500s from the wire arrive with Code.INTERNAL.
      if (apiException.getStatusCode().getCode() == StatusCode.Code.UNKNOWN) {
        Throwable cause = apiException.getCause();
        if (cause instanceof IOException) {
          return Category.TRANSIENT;
        }
        return Category.FATAL;
      }

      // Server rejections (final/cancelled on non-2xx) and protocol violations map to
      // FAILED_PRECONDITION and are terminal. HTTP 408 and 412 also map to FAILED_PRECONDITION in
      // HttpJsonStatusCode but have distinct protocol categories.
      Object transportCode = apiException.getStatusCode().getTransportCode();
      if (apiException.getStatusCode().getCode() == StatusCode.Code.FAILED_PRECONDITION
          && !Integer.valueOf(408).equals(transportCode)
          && !Integer.valueOf(412).equals(transportCode)) {
        return Category.FATAL;
      }

      // Status table lookup on raw HTTP transport code.
      if (transportCode instanceof Integer) {
        Category category = HTTP_STATUS_MAP.get(transportCode);
        if (category == Category.RECOVERABLE && !isRecoverableCommand(command)) {
          return Category.FATAL;
        }
        if (category != null) {
          return category;
        }
      }
      return Category.FATAL;
    }

    // Plain I/O or timeout exceptions that bypassed ApiException wrapping are transient.
    if (t instanceof IOException) {
      return Category.TRANSIENT;
    }

    // Unrecognized errors fail the upload immediately.
    return Category.FATAL;
  }

  /**
   * Classifies a missing upload status response header according to the wire command.
   *
   * @param command the upload command that received a response lacking the status header
   * @return the classified error category
   */
  static Category classifyMissingStatusHeader(ResumableUploadCommand command) {
    Objects.requireNonNull(command, "command must not be null");
    switch (command) {
      case START:
        return Category.TRANSIENT;
      case UPLOAD:
      case FINALIZE:
      case UPLOAD_FINALIZE:
        return Category.RECOVERABLE;
      case QUERY:
      case CANCEL:
      default:
        return Category.FATAL;
    }
  }

  private static boolean isRecoverableCommand(ResumableUploadCommand command) {
    switch (command) {
      case UPLOAD:
      case FINALIZE:
      case UPLOAD_FINALIZE:
        return true;
      case START:
      case QUERY:
      case CANCEL:
      default:
        return false;
    }
  }
}
