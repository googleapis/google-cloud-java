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

import static com.google.api.gax.rpc.ResumableUploadCommand.CANCEL;
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

import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ResumableUploadErrorClassifierTest {

  private static StatusCode statusCode(int httpStatus, Code code) {
    return new StatusCode() {
      @Override
      public Code getCode() {
        return code;
      }

      @Override
      public Object getTransportCode() {
        return httpStatus;
      }
    };
  }

  private static ApiException createApiException(int httpStatus, Code code) {
    return createApiException(httpStatus, code, null);
  }

  private static ApiException createApiException(
      int httpStatus, Code code, @Nullable Throwable cause) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus, cause, statusCode(httpStatus, code), false);
  }

  @ParameterizedTest(name = "HTTP {0} is TRANSIENT on {1}")
  @CsvSource({
    "408, START",
    "408, UPLOAD",
    "408, QUERY",
    "429, START",
    "429, UPLOAD",
    "429, QUERY",
    "500, START",
    "500, UPLOAD",
    "500, QUERY",
    "502, UPLOAD",
    "503, START",
    "503, UPLOAD",
    "503, QUERY",
    "504, UPLOAD",
  })
  void testTransientHttpErrors_areTransientAcrossCommands(
      int httpStatus, ResumableUploadCommand command) {
    Code code = (httpStatus == 503) ? Code.UNAVAILABLE : Code.INTERNAL;
    ApiException exception = createApiException(httpStatus, code);
    assertThat(ResumableUploadErrorClassifier.classify(exception, command)).isEqualTo(TRANSIENT);
  }

  @Test
  void testIoExceptions_areTransientAcrossCommands() {
    assertThat(ResumableUploadErrorClassifier.classify(new IOException("broken pipe"), UPLOAD))
        .isEqualTo(TRANSIENT);
    assertThat(
            ResumableUploadErrorClassifier.classify(
                new SocketTimeoutException("connect timeout"), START))
        .isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(new IOException("connection reset"), QUERY))
        .isEqualTo(TRANSIENT);
  }

  @Test
  void testSyntheticUnknownWithWrappedIOException_isTransient() {
    // When GAX maps an IOException into Code.UNKNOWN with synthetic 500, it remains TRANSIENT.
    ApiException wrappedIo =
        createApiException(500, Code.UNKNOWN, new IOException("connection reset"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedIo, UPLOAD)).isEqualTo(TRANSIENT);

    ApiException wrappedTimeout =
        createApiException(500, Code.UNKNOWN, new SocketTimeoutException("read timeout"));
    assertThat(ResumableUploadErrorClassifier.classify(wrappedTimeout, START)).isEqualTo(TRANSIENT);
  }

  @ParameterizedTest(name = "HTTP {0} on {1} is RECOVERABLE")
  @CsvSource({
    "400, UPLOAD",
    "400, FINALIZE",
    "400, UPLOAD_FINALIZE",
    "409, UPLOAD",
    "409, FINALIZE",
    "409, UPLOAD_FINALIZE",
    "412, UPLOAD",
    "412, FINALIZE",
    "412, UPLOAD_FINALIZE",
    "416, UPLOAD",
    "416, FINALIZE",
    "416, UPLOAD_FINALIZE",
  })
  void testRecoverableErrors_areRecoverableOnChunkUploadCommands(
      int httpStatus, ResumableUploadCommand command) {
    ApiException exception = createApiException(httpStatus, Code.INVALID_ARGUMENT);
    assertThat(ResumableUploadErrorClassifier.classify(exception, command)).isEqualTo(RECOVERABLE);
  }

  @ParameterizedTest(name = "HTTP {0} on non-chunk command {1} must be FATAL")
  @CsvSource({
    // On START: No session URL exists yet; cannot query status to recover offset.
    "400, START",
    "409, START",
    "412, START",
    "416, START",
    // On QUERY: Already in recovery; 4xx on status query must not loop back into recovery.
    "400, QUERY",
    "409, QUERY",
    "412, QUERY",
    "416, QUERY",
    // On CANCEL: Cancellation failure cannot be recovered by querying byte offsets.
    "400, CANCEL",
    "409, CANCEL",
    "412, CANCEL",
    "416, CANCEL",
  })
  void testRecoverableCodes_areFatalOnNonChunkCommands(
      int httpStatus, ResumableUploadCommand command) {
    ApiException exception = createApiException(httpStatus, Code.INVALID_ARGUMENT);
    assertThat(ResumableUploadErrorClassifier.classify(exception, command)).isEqualTo(FATAL);
  }

  @Test
  void testMissingStatusHeader_commandSpecificClassification() {
    // Missing header on START must be retried directly (TRANSIENT).
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(START))
        .isEqualTo(TRANSIENT);

    // Missing header during chunk transmission must trigger query/recovery.
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(UPLOAD))
        .isEqualTo(RECOVERABLE);
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(FINALIZE))
        .isEqualTo(RECOVERABLE);
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(UPLOAD_FINALIZE))
        .isEqualTo(RECOVERABLE);

    // Missing header on query or cancel is an unrecoverable protocol error (FATAL).
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(QUERY)).isEqualTo(FATAL);
    assertThat(ResumableUploadErrorClassifier.classifyMissingStatusHeader(CANCEL)).isEqualTo(FATAL);
  }

  @Test
  void test408And412_divergeInClassificationDespiteSameGaxCode() {
    // Both 408 and 412 map to Code.FAILED_PRECONDITION in HttpJsonStatusCode.
    ApiException error408 = createApiException(408, Code.FAILED_PRECONDITION);
    ApiException error412 = createApiException(412, Code.FAILED_PRECONDITION);

    assertThat(error408.getStatusCode().getCode()).isEqualTo(error412.getStatusCode().getCode());

    // On chunk upload: 408 is TRANSIENT, 412 is RECOVERABLE.
    assertThat(ResumableUploadErrorClassifier.classify(error408, UPLOAD)).isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(error412, UPLOAD)).isEqualTo(RECOVERABLE);

    // On START: 408 is TRANSIENT, but 412 is FATAL (cannot recover).
    assertThat(ResumableUploadErrorClassifier.classify(error408, START)).isEqualTo(TRANSIENT);
    assertThat(ResumableUploadErrorClassifier.classify(error412, START)).isEqualTo(FATAL);
  }

  @Test
  void testSynthetic500FromWrappedRuntimeException_isFatalWhereasReal500IsTransient() {
    // Real wire 500 arrives with Code.INTERNAL.
    ApiException real500 = createApiException(500, Code.INTERNAL);
    assertThat(ResumableUploadErrorClassifier.classify(real500, UPLOAD)).isEqualTo(TRANSIENT);

    // Synthetic 500 from an unrecognized runtime exception arrives with Code.UNKNOWN.
    // It must be FATAL to prevent endless retries on client-side bugs or NPEs.
    ApiException synthetic500 =
        ApiExceptionFactory.createException(
            new IllegalStateException("local bug"),
            statusCode(500, Code.UNKNOWN),
            /* retryable= */ false);
    assertThat(ResumableUploadErrorClassifier.classify(synthetic500, UPLOAD)).isEqualTo(FATAL);

    ApiException synthetic500Npe =
        ApiExceptionFactory.createException(
            new NullPointerException("null reference"),
            statusCode(500, Code.UNKNOWN),
            /* retryable= */ false);
    assertThat(ResumableUploadErrorClassifier.classify(synthetic500Npe, UPLOAD)).isEqualTo(FATAL);
  }

  @ParameterizedTest(name = "Client error {0} is FATAL")
  @ValueSource(ints = {401, 403, 404, 405, 410, 413, 415, 418, 505})
  void testFatalClientErrorsAndUnmappedCodes_areFatal(int httpStatus) {
    ApiException exception = createApiException(httpStatus, Code.INVALID_ARGUMENT);
    assertThat(ResumableUploadErrorClassifier.classify(exception, UPLOAD)).isEqualTo(FATAL);
  }

  @Test
  void testServerRejection_failedPreconditionOverridesHttpStatus() {
    // When the server rejects an upload (e.g. 503 with X-Goog-Upload-Status: final or canceled),
    // the transport maps it to Code.FAILED_PRECONDITION, which must be FATAL regardless of the 503
    // HTTP status.
    ApiException rejectionOn503 = createApiException(503, Code.FAILED_PRECONDITION);
    assertThat(ResumableUploadErrorClassifier.classify(rejectionOn503, UPLOAD)).isEqualTo(FATAL);
    assertThat(ResumableUploadErrorClassifier.classify(rejectionOn503, START)).isEqualTo(FATAL);
  }

  @Test
  void testSentinelsAndUnrecognizedThrowables_areFatal() {
    // Cancellation is always fatal.
    assertThat(
            ResumableUploadErrorClassifier.classify(new CancellationException("cancelled"), UPLOAD))
        .isEqualTo(FATAL);

    // Unwrapped runtime exceptions default to FATAL.
    assertThat(
            ResumableUploadErrorClassifier.classify(
                new NullPointerException("unexpected null"), UPLOAD))
        .isEqualTo(FATAL);
    assertThat(
            ResumableUploadErrorClassifier.classify(new IllegalStateException("bad state"), UPLOAD))
        .isEqualTo(FATAL);

    // Null inputs throw NullPointerException.
    assertThrows(
        NullPointerException.class, () -> ResumableUploadErrorClassifier.classify(null, UPLOAD));
    assertThrows(
        NullPointerException.class,
        () -> ResumableUploadErrorClassifier.classify(new IOException("io"), null));
    assertThrows(
        NullPointerException.class,
        () -> ResumableUploadErrorClassifier.classifyMissingStatusHeader(null));

    // Sentinel exceptions without wire transport code (e.g. watchdog timeout, client validation)
    // are FATAL.
    StatusCode sentinelWithoutTransportCode =
        new StatusCode() {
          @Override
          public Code getCode() {
            return Code.DEADLINE_EXCEEDED;
          }

          @Override
          public @Nullable Object getTransportCode() {
            return null;
          }
        };
    ApiException watchdogDeadline =
        ApiExceptionFactory.createException(
            "Session timeout", null, sentinelWithoutTransportCode, false);
    assertThat(ResumableUploadErrorClassifier.classify(watchdogDeadline, UPLOAD)).isEqualTo(FATAL);
  }
}
