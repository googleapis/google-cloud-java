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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UploadErrorClassifierTest {

  private static class HttpStatusStatusCode implements StatusCode {
    private final int httpStatus;
    private final Code code;

    HttpStatusStatusCode(int httpStatus, Code code) {
      this.httpStatus = httpStatus;
      this.code = code;
    }

    @Override
    public Code getCode() {
      return code;
    }

    @Override
    public Integer getTransportCode() {
      return httpStatus;
    }
  }

  private static ApiException createApiException(int httpStatus, Code code) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus, null, new HttpStatusStatusCode(httpStatus, code), false);
  }

  private static ApiException createApiExceptionWithCause(
      int httpStatus, Code code, Throwable cause) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus, cause, new HttpStatusStatusCode(httpStatus, code), false);
  }

  @ParameterizedTest(name = "HTTP {0} on {1} -> {2}")
  @CsvSource({
    // Transient (Cat 1)
    "408, UPLOAD, TRANSIENT",
    "429, UPLOAD, TRANSIENT",
    "500, UPLOAD, TRANSIENT",
    "502, UPLOAD, TRANSIENT",
    "503, UPLOAD, TRANSIENT",
    "504, UPLOAD, TRANSIENT",
    "408, START, TRANSIENT",
    "429, START, TRANSIENT",
    "500, START, TRANSIENT",
    "502, START, TRANSIENT",
    "503, START, TRANSIENT",
    "504, START, TRANSIENT",

    // Recoverable (Cat 2)
    "400, UPLOAD, RECOVERABLE",
    "409, UPLOAD, RECOVERABLE",
    "412, UPLOAD, RECOVERABLE",
    "416, UPLOAD, RECOVERABLE",
    "400, FINALIZE, RECOVERABLE",
    "409, FINALIZE, RECOVERABLE",
    "412, FINALIZE, RECOVERABLE",
    "416, FINALIZE, RECOVERABLE",
    "400, UPLOAD_FINALIZE, RECOVERABLE",
    "409, UPLOAD_FINALIZE, RECOVERABLE",
    "412, UPLOAD_FINALIZE, RECOVERABLE",
    "416, UPLOAD_FINALIZE, RECOVERABLE",

    // Recoverable codes on START must be FATAL (no session exists to recover)
    "400, START, FATAL",
    "409, START, FATAL",
    "412, START, FATAL",
    "416, START, FATAL",

    // Fatal (Cat 3)
    "401, UPLOAD, FATAL",
    "403, UPLOAD, FATAL",
    "404, UPLOAD, FATAL",
    "405, UPLOAD, FATAL",
    "410, UPLOAD, FATAL",
    "413, UPLOAD, FATAL",
    "415, UPLOAD, FATAL",
    "401, START, FATAL",
    "403, START, FATAL",
    "404, START, FATAL",
    "405, START, FATAL",
    "410, START, FATAL",
    "413, START, FATAL",
    "415, START, FATAL",

    // Unmapped codes -> FATAL
    "418, UPLOAD, FATAL",
    "505, UPLOAD, FATAL"
  })
  void testTableDrivenClassification(
      int httpStatus, UploadCommand command, String expectedCategory) {
    // Determine the corresponding standard Code
    Code code;
    switch (httpStatus) {
      case 400:
        code = Code.INVALID_ARGUMENT;
        break;
      case 401:
        code = Code.UNAUTHENTICATED;
        break;
      case 403:
        code = Code.PERMISSION_DENIED;
        break;
      case 404:
        code = Code.NOT_FOUND;
        break;
      case 409:
        code = Code.ABORTED;
        break;
      case 416:
        code = Code.OUT_OF_RANGE;
        break;
      case 429:
        code = Code.RESOURCE_EXHAUSTED;
        break;
      case 500:
      case 502:
        code = Code.INTERNAL;
        break;
      case 503:
        code = Code.UNAVAILABLE;
        break;
      case 504:
        code = Code.DEADLINE_EXCEEDED;
        break;
      default:
        code = Code.FAILED_PRECONDITION;
        break;
    }

    ApiException exception = createApiException(httpStatus, code);
    UploadErrorCategory result = UploadErrorClassifier.classify(exception, command);
    assertThat(result).isEqualTo(UploadErrorCategory.valueOf(expectedCategory));
  }

  @Test
  void test408And412BothMapToFailedPreconditionButDivergeInClassification() {
    // Both 408 (Request Timeout) and 412 (Precondition Failed) map to Code.FAILED_PRECONDITION
    // in HttpJsonStatusCode, yet 408 must be TRANSIENT and 412 must be RECOVERABLE.
    ApiException error408 = createApiException(408, Code.FAILED_PRECONDITION);
    ApiException error412 = createApiException(412, Code.FAILED_PRECONDITION);

    assertThat(error408.getStatusCode().getCode()).isEqualTo(error412.getStatusCode().getCode());
    assertThat(UploadErrorClassifier.classify(error408, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);
    assertThat(UploadErrorClassifier.classify(error412, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.RECOVERABLE);
  }

  @Test
  void testSynthetic500FromWrappedIllegalStateExceptionIsFatalWhereasReal500IsTransient() {
    // Upstream facts: HttpJsonApiExceptionFactory.java:83-87 maps unrecognized throwables
    // to Code.UNKNOWN, and StatusCode.java:49 defines Code.UNKNOWN with synthetic HTTP code 500.
    // Real wire 500 arrives with Code.INTERNAL and transport code 500.
    ApiException real500 = createApiException(500, Code.INTERNAL);
    assertThat(UploadErrorClassifier.classify(real500, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);

    // Synthetic 500 from an unrecognised runtime exception arrives with Code.UNKNOWN
    // and synthetic transport code 500. It must be FATAL, not TRANSIENT.
    ApiException synthetic500 =
        createApiExceptionWithCause(500, Code.UNKNOWN, new IllegalStateException("local bug"));
    assertThat(UploadErrorClassifier.classify(synthetic500, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);
  }

  @Test
  void testSyntheticUnknownWithWrappedIOExceptionIsTransient() {
    // When an IOException is wrapped into an ApiException with Code.UNKNOWN and synthetic 500,
    // it must still be classified as TRANSIENT.
    ApiException wrappedIo =
        createApiExceptionWithCause(500, Code.UNKNOWN, new IOException("connection reset"));
    assertThat(UploadErrorClassifier.classify(wrappedIo, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);

    ApiException wrappedTimeout =
        createApiExceptionWithCause(500, Code.UNKNOWN, new SocketTimeoutException("read timeout"));
    assertThat(UploadErrorClassifier.classify(wrappedTimeout, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);
  }

  @Test
  void testUnwrappedIoAndTimeoutExceptionsAreTransient() {
    assertThat(UploadErrorClassifier.classify(new IOException("broken pipe"), UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);
    assertThat(
            UploadErrorClassifier.classify(
                new SocketTimeoutException("connect timeout"), UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);
  }

  @Test
  void testNonRetryableSentinelsAreFatal() {
    // Typed sentinel exceptions: protocol violation and upload timeout are FATAL
    assertThat(
            UploadErrorClassifier.classify(
                new UploadProtocolViolationException("Buffer underflow"), UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);

    assertThat(
            UploadErrorClassifier.classify(
                new ResumableUploadTimeoutException("Session expired"), UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);

    // Watchdog DeadlineExceededException without wire transport code is FATAL
    DeadlineExceededException watchdogDeadline =
        new DeadlineExceededException(
            "Session timeout",
            null,
            new StatusCode() {
              @Override
              public Code getCode() {
                return Code.DEADLINE_EXCEEDED;
              }

              @Override
              public @Nullable Object getTransportCode() {
                return null;
              }
            },
            false);
    assertThat(UploadErrorClassifier.classify(watchdogDeadline, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);

    // Wire 504 Gateway Timeout carries transport code 504 and is TRANSIENT
    ApiException wire504 = createApiException(504, Code.DEADLINE_EXCEEDED);
    assertThat(UploadErrorClassifier.classify(wire504, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.TRANSIENT);

    // CancellationException is fatal
    assertThat(
            UploadErrorClassifier.classify(
                new CancellationException("upload cancelled"), UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);
  }

  @Test
  void testDegenerateInputsAreFatal() {
    assertThat(UploadErrorClassifier.classify(null, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);

    // Object transport code that is not Integer
    StatusCode nonIntegerTransportCode =
        new StatusCode() {
          @Override
          public Code getCode() {
            return Code.INTERNAL;
          }

          @Override
          public Object getTransportCode() {
            return "NON_INTEGER";
          }
        };
    ApiException nonIntegerException =
        ApiExceptionFactory.createException("custom", null, nonIntegerTransportCode, false);
    assertThat(UploadErrorClassifier.classify(nonIntegerException, UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.FATAL);
  }

  @Test
  void testMissingStatusHeaderPerCommand() {
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.START))
        .isEqualTo(UploadErrorCategory.TRANSIENT);
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.UPLOAD))
        .isEqualTo(UploadErrorCategory.RECOVERABLE);
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.FINALIZE))
        .isEqualTo(UploadErrorCategory.RECOVERABLE);
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.UPLOAD_FINALIZE))
        .isEqualTo(UploadErrorCategory.RECOVERABLE);
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.QUERY))
        .isEqualTo(UploadErrorCategory.FATAL);
    assertThat(UploadErrorClassifier.classifyMissingStatusHeader(UploadCommand.CANCEL))
        .isEqualTo(UploadErrorCategory.FATAL);
  }
}
