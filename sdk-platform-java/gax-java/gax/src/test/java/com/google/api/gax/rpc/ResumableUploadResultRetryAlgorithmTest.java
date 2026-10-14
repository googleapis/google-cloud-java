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

import static com.google.api.gax.rpc.ResumableUploadCommand.UPLOAD;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.StatusCode.Code;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

class ResumableUploadResultRetryAlgorithmTest {

  private final ResumableUploadResultRetryAlgorithm<String> algorithm =
      new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

  private static ApiException createApiException(@Nullable Integer httpStatus, Code code) {
    return createApiException(httpStatus, code, null);
  }

  private static ApiException createApiException(
      @Nullable Integer httpStatus, Code code, @Nullable Throwable cause) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus,
        cause,
        new StatusCode() {
          @Override
          public Code getCode() {
            return code;
          }

          @Override
          public @Nullable Object getTransportCode() {
            return httpStatus;
          }
        },
        false);
  }

  @Test
  void testShouldRetry_nullThrowableReturnsFalse() {
    assertThat(algorithm.shouldRetry(null, "success")).isFalse();
  }

  @Test
  void testShouldRetry_transientErrorReturnsTrue() {
    ApiException wrappedTimeout =
        createApiException(500, Code.UNKNOWN, new SocketTimeoutException("read timeout"));
    assertThat(algorithm.shouldRetry(wrappedTimeout, null)).isTrue();

    ApiException transient503 = createApiException(503, Code.UNAVAILABLE);
    assertThat(algorithm.shouldRetry(transient503, null)).isTrue();
  }

  @Test
  void testShouldRetry_recoverableErrorReturnsFalse() {
    ApiException recoverable412 = createApiException(412, Code.FAILED_PRECONDITION);
    assertThat(algorithm.shouldRetry(recoverable412, null)).isFalse();
  }

  @Test
  void testShouldRetry_fatalErrorReturnsFalse() {
    assertThat(algorithm.shouldRetry(createApiException(403, Code.PERMISSION_DENIED), null))
        .isFalse();
    assertThat(algorithm.shouldRetry(createApiException(null, Code.FAILED_PRECONDITION), null))
        .isFalse();
    assertThat(algorithm.shouldRetry(new CancellationException("cancelled"), null)).isFalse();
  }
}
