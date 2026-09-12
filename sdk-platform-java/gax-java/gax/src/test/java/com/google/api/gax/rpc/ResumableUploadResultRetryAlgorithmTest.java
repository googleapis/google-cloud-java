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

import static com.google.api.gax.rpc.ResumableUploadCommand.QUERY;
import static com.google.api.gax.rpc.ResumableUploadCommand.UPLOAD;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import org.junit.jupiter.api.Test;

class ResumableUploadResultRetryAlgorithmTest {

  private static ApiException createApiException(int httpStatus, Code code) {
    return ApiExceptionFactory.createException(
        "HTTP " + httpStatus,
        null,
        new StatusCode() {
          @Override
          public Code getCode() {
            return code;
          }

          @Override
          public Object getTransportCode() {
            return httpStatus;
          }
        },
        false);
  }

  @Test
  void testConstructor_nullCommandThrows() {
    assertThrows(NullPointerException.class, () -> new ResumableUploadResultRetryAlgorithm<>(null));
  }

  @Test
  void testShouldRetry_nullThrowableReturnsFalse() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    assertThat(algorithm.shouldRetry(null, "success")).isFalse();
  }

  @Test
  void testShouldRetry_cancellationExceptionReturnsFalse() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    CancellationException cancellationException = new CancellationException("cancelled");
    assertThat(algorithm.shouldRetry(cancellationException, null)).isFalse();
  }

  @Test
  void testShouldRetry_transientErrorReturnsTrue() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    assertThat(algorithm.shouldRetry(new IOException("connection reset"), null)).isTrue();
    ApiException transient503 = createApiException(503, Code.UNAVAILABLE);
    assertThat(algorithm.shouldRetry(transient503, null)).isTrue();
  }

  @Test
  void testShouldRetry_recoverableErrorIsRetryable() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    ApiException recoverable400 = createApiException(400, Code.INVALID_ARGUMENT);
    ApiException recoverable409 = createApiException(409, Code.ABORTED);
    ApiException recoverable412 = createApiException(412, Code.FAILED_PRECONDITION);

    assertThat(algorithm.shouldRetry(recoverable400, null)).isTrue();
    assertThat(algorithm.shouldRetry(recoverable409, null)).isTrue();
    assertThat(algorithm.shouldRetry(recoverable412, null)).isTrue();
  }

  @Test
  void testShouldRetry_missingStatusHeaderOnChunkResponse_returnsTrueForUpload() {
    ResumableUploadResultRetryAlgorithm<ChunkUploadResponse<String>> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    ChunkUploadResponse<String> responseWithNullStatus =
        ChunkUploadResponse.create(false, "payload", null);
    assertThat(algorithm.shouldRetry(null, responseWithNullStatus)).isTrue();

    ChunkUploadResponse<String> responseWithActiveStatus =
        ChunkUploadResponse.create(false, "payload", "active");
    assertThat(algorithm.shouldRetry(null, responseWithActiveStatus)).isFalse();
  }

  @Test
  void testShouldRetry_missingStatusHeaderOnChunkResponse_returnsFalseForQuery() {
    ResumableUploadResultRetryAlgorithm<ChunkUploadResponse<String>> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(QUERY);

    ChunkUploadResponse<String> responseWithNullStatus =
        ChunkUploadResponse.create(false, "payload", null);
    assertThat(algorithm.shouldRetry(null, responseWithNullStatus)).isFalse();
  }

  @Test
  void testShouldRetry_fatalErrorReturnsFalse() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    ApiException fatal403 = createApiException(403, Code.PERMISSION_DENIED);
    assertThat(algorithm.shouldRetry(fatal403, null)).isFalse();
  }

  @Test
  void testShouldRetry_serverRejectionReturnsFalse() {
    ResumableUploadResultRetryAlgorithm<String> algorithm =
        new ResumableUploadResultRetryAlgorithm<>(UPLOAD);

    // 503 with X-Goog-Upload-Status: final or cancelled is mapped to Code.FAILED_PRECONDITION
    ApiException rejected503 = createApiException(503, Code.FAILED_PRECONDITION);
    assertThat(algorithm.shouldRetry(rejected503, null)).isFalse();
  }
}
