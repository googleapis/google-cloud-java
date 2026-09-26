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

import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.resumable.ResumableUploadStatusCode;
import com.google.common.collect.ImmutableMap;
import java.net.SocketTimeoutException;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;

/**
 * Classifies exceptions encountered during resumable upload commands to determine whether/how to
 * recover.
 */
@NullMarked
final class ResumableUploadErrorClassifier {

  enum Category {
    /** An errored command that can be retried directly. */
    TRANSIENT,

    /** An errored command that requires status from the server before recovery. */
    RECOVERABLE,

    /** An errored command that immediately fails the upload operation. */
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
          .build();

  private ResumableUploadErrorClassifier() {}

  /**
   * Classifies an exception for the given upload command according to resumable upload protocol
   * rules.
   *
   * @param t the error to classify
   * @param command the upload command that produced the error
   * @return the classified error category
   */
  static Category classify(Throwable t, ResumableUploadCommand command) {
    Objects.requireNonNull(t, "t must not be null");
    Objects.requireNonNull(command, "command must not be null");

    if (!(t instanceof ApiException)) {
      return Category.FATAL;
    }
    ApiException apiException = (ApiException) t;
    StatusCode statusCode = apiException.getStatusCode();

    if (statusCode instanceof ResumableUploadStatusCode) {
      ResumableUploadStatusCode uploadStatusCode = (ResumableUploadStatusCode) statusCode;
      if (uploadStatusCode.getUploadStatus() == ResumableUploadStatus.FINAL) {
        return Category.FATAL;
      }
    }

    // HttpJsonApiExceptionFactory wraps low-level network timeouts as UNKNOWN.
    if (statusCode.getCode() == StatusCode.Code.UNKNOWN) {
      if (apiException.getCause() instanceof SocketTimeoutException) {
        return Category.TRANSIENT;
      }
      return Category.FATAL;
    }

    Category category = HTTP_STATUS_MAP.getOrDefault(statusCode.getTransportCode(), Category.FATAL);
    if (category == Category.RECOVERABLE && !command.isRecoverable()) {
      return Category.FATAL;
    }
    return category;
  }
}
