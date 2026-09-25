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

import static com.google.api.gax.rpc.ResumableUploadCommand.FINALIZE;
import static com.google.api.gax.rpc.ResumableUploadCommand.QUERY;
import static com.google.api.gax.rpc.ResumableUploadCommand.START;
import static com.google.api.gax.rpc.ResumableUploadCommand.UPLOAD;
import static com.google.api.gax.rpc.ResumableUploadCommand.UPLOAD_FINALIZE;
import static com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category.FATAL;
import static com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category.RECOVERABLE;
import static com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category.TRANSIENT;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.resumable.ResumableUploadStatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

class ResumableUploadErrorClassifierTest {

  private static StatusCode statusCode(@Nullable Integer httpStatus, Code code) {
    return new StatusCode() {
      @Override
      public Code getCode() {
        return code;
      }

      @Override
      public @Nullable Object getTransportCode() {
        return httpStatus;
      }
    };
  }

  private static ApiException createApiException(@Nullable Integer httpStatus, Code code) {
    return createApiException(httpStatus, code, null);
  }

  private static ApiException createApiException(
      @Nullable Integer httpStatus, Code code, @Nullable Throwable cause) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus, cause, statusCode(httpStatus, code), false);
  }

  @Test
  void testServerRejectionStatusCode_isFatalEvenWithRetryableOrRecoverableHttpCode() {
    ApiException final503 =
        ApiExceptionFactory.createException(
            "HTTP 503",
            null,
            ResumableUploadStatusCode.of(
                statusCode(503, Code.UNAVAILABLE), ResumableUploadStatus.FINAL),
            false);
    assertThat(ResumableUploadErrorClassifier.classify(final503, UPLOAD)).isEqualTo(FATAL);

    ApiException final400 =
        ApiExceptionFactory.createException(
            "HTTP 400",
            null,
            ResumableUploadStatusCode.of(
                statusCode(400, Code.INVALID_ARGUMENT), ResumableUploadStatus.FINAL),
            false);
    assertThat(ResumableUploadErrorClassifier.classify(final400, UPLOAD)).isEqualTo(FATAL);
  }

  @Test
  void testTransientHttpErrors_areTransientAcrossCommands() {
    ApiException error503 = createApiException(503, Code.UNAVAILABLE);
    assertThat(ResumableUploadErrorClassifier.classify(error503, START)).isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(error503, UPLOAD)).isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(error503, QUERY)).isEqualTo(TRANSIENT);
  }

  @Test
  void testUnknownStatusCode_transientOnlyWhenCausedBySocketTimeoutException() {
    ApiException wrappedTimeout =
        createApiException(500, Code.UNKNOWN, new SocketTimeoutException("read timeout"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedTimeout, START)).isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(wrappedTimeout, UPLOAD))
        .isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(wrappedTimeout, QUERY)).isEqualTo(TRANSIENT);

    ApiException wrappedSocket =
        createApiException(500, Code.UNKNOWN, new SocketException("connection reset"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedSocket, UPLOAD)).isEqualTo(FATAL);

    ApiException wrappedUnknownHost =
        createApiException(500, Code.UNKNOWN, new UnknownHostException("unknown host"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedUnknownHost, UPLOAD))
        .isEqualTo(FATAL);

    ApiException genericIo =
        createApiException(500, Code.UNKNOWN, new IOException("generic io error"));
    assertThat(ResumableUploadErrorClassifier.classify(genericIo, UPLOAD)).isEqualTo(FATAL);

    ApiException wrappedRuntime =
        createApiException(500, Code.UNKNOWN, new IllegalStateException("local bug"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedRuntime, UPLOAD)).isEqualTo(FATAL);
  }

  @Test
  void testRecoverableHttpErrors_dependOnCommand() {
    ApiException error412 = createApiException(412, Code.FAILED_PRECONDITION);

    // Chunk transmission commands can recover by querying server status.
    assertThat(ResumableUploadErrorClassifier.classify(error412, UPLOAD)).isEqualTo(RECOVERABLE);
    assertThat(ResumableUploadErrorClassifier.classify(error412, FINALIZE)).isEqualTo(RECOVERABLE);
    assertThat(ResumableUploadErrorClassifier.classify(error412, UPLOAD_FINALIZE))
        .isEqualTo(RECOVERABLE);

    // Non-chunk commands cannot recover via byte-offset query.
    assertThat(ResumableUploadErrorClassifier.classify(error412, START)).isEqualTo(FATAL);
    assertThat(ResumableUploadErrorClassifier.classify(error412, QUERY)).isEqualTo(FATAL);
  }

  @Test
  void testCommand_isRecoverable() {
    assertThat(START.isRecoverable()).isFalse();
    assertThat(UPLOAD.isRecoverable()).isTrue();
    assertThat(FINALIZE.isRecoverable()).isTrue();
    assertThat(UPLOAD_FINALIZE.isRecoverable()).isTrue();
    assertThat(QUERY.isRecoverable()).isFalse();
  }

  @Test
  void testUnmappedHttpCodesAndNonApiExceptions_areFatal() {
    assertThat(
            ResumableUploadErrorClassifier.classify(
                createApiException(403, Code.PERMISSION_DENIED), UPLOAD))
        .isEqualTo(FATAL);
    assertThat(
            ResumableUploadErrorClassifier.classify(
                createApiException(null, Code.FAILED_PRECONDITION), UPLOAD))
        .isEqualTo(FATAL);
    assertThat(
            ResumableUploadErrorClassifier.classify(new CancellationException("cancelled"), UPLOAD))
        .isEqualTo(FATAL);
    assertThat(
            ResumableUploadErrorClassifier.classify(new IllegalStateException("bad state"), UPLOAD))
        .isEqualTo(FATAL);

    assertThrows(
        NullPointerException.class, () -> ResumableUploadErrorClassifier.classify(null, UPLOAD));
    assertThrows(
        NullPointerException.class,
        () ->
            ResumableUploadErrorClassifier.classify(
                createApiException(null, Code.FAILED_PRECONDITION), null));
  }
}
