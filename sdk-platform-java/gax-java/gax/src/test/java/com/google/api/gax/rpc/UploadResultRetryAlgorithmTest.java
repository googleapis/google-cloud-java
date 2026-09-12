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

import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import org.junit.jupiter.api.Test;

class UploadResultRetryAlgorithmTest {

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

  @Test
  void testShouldRetry_transientErrorReturnsTrue() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    ApiException transient503 = createApiException(503, Code.UNAVAILABLE);
    assertThat(algorithm.shouldRetry(transient503, null)).isTrue();
    assertThat(algorithm.shouldRetry(new IOException("connection reset"), null)).isTrue();
  }

  @Test
  void testShouldRetry_recoverableErrorIsRetryable() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    ApiException recoverable400 = createApiException(400, Code.INVALID_ARGUMENT);
    ApiException recoverable409 = createApiException(409, Code.ABORTED);
    ApiException recoverable412 = createApiException(412, Code.FAILED_PRECONDITION);

    assertThat(algorithm.shouldRetry(recoverable400, null)).isTrue();
    assertThat(algorithm.shouldRetry(recoverable409, null)).isTrue();
    assertThat(algorithm.shouldRetry(recoverable412, null)).isTrue();
  }

  @Test
  void testShouldRetry_missingStatusHeaderOnChunkResponse_returnsTrueForUpload() {
    UploadResultRetryAlgorithm<ChunkUploadResponse<String>> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    ChunkUploadResponse<String> responseWithNullStatus =
        ChunkUploadResponse.create(false, "payload", null);
    assertThat(algorithm.shouldRetry(null, responseWithNullStatus)).isTrue();

    ChunkUploadResponse<String> responseWithActiveStatus =
        ChunkUploadResponse.create(false, "payload", "active");
    assertThat(algorithm.shouldRetry(null, responseWithActiveStatus)).isFalse();
  }

  @Test
  void testShouldRetry_missingStatusHeaderOnChunkResponse_returnsFalseForQuery() {
    UploadResultRetryAlgorithm<ChunkUploadResponse<String>> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.QUERY);

    ChunkUploadResponse<String> responseWithNullStatus =
        ChunkUploadResponse.create(false, "payload", null);
    assertThat(algorithm.shouldRetry(null, responseWithNullStatus)).isFalse();
  }

  @Test
  void testShouldRetry_missingStatusHeaderOnStartSession_returnsTrueForStart() {
    UploadResultRetryAlgorithm<ResumableUploadSession> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.START);

    ResumableUploadSession sessionWithNullStatus =
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url")
            .setChunkGranularity(256)
            .setUploadStatus(null)
            .build();
    assertThat(algorithm.shouldRetry(null, sessionWithNullStatus)).isTrue();

    ResumableUploadSession sessionWithActiveStatus =
        ResumableUploadSession.newBuilder()
            .setUploadUrl("https://upload.url")
            .setChunkGranularity(256)
            .setUploadStatus("active")
            .build();
    assertThat(algorithm.shouldRetry(null, sessionWithActiveStatus)).isFalse();
  }

  @Test
  void testShouldRetry_fatalErrorReturnsFalse() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    ApiException fatal401 = createApiException(401, Code.UNAUTHENTICATED);
    ApiException fatal403 = createApiException(403, Code.PERMISSION_DENIED);
    ApiException fatal404 = createApiException(404, Code.NOT_FOUND);

    assertThat(algorithm.shouldRetry(fatal401, null)).isFalse();
    assertThat(algorithm.shouldRetry(fatal403, null)).isFalse();
    assertThat(algorithm.shouldRetry(fatal404, null)).isFalse();
  }

  @Test
  void testShouldRetry_nullThrowableReturnsFalse() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    assertThat(algorithm.shouldRetry(null, "success")).isFalse();
  }

  @Test
  void testShouldRetry_cancellationExceptionReturnsFalse() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.UPLOAD);

    CancellationException cancellationException = new CancellationException("cancelled");
    assertThat(algorithm.shouldRetry(cancellationException, null)).isFalse();
  }

  @Test
  void testShouldRetry_withRetryingContextDelegates() {
    UploadResultRetryAlgorithm<String> algorithm =
        new UploadResultRetryAlgorithm<>(UploadCommand.START);

    ApiException transient503 = createApiException(503, Code.UNAVAILABLE);
    ApiException fatal403 = createApiException(403, Code.PERMISSION_DENIED);

    assertThat(algorithm.shouldRetry(null, transient503, null)).isTrue();
    assertThat(algorithm.shouldRetry(null, fatal403, null)).isFalse();
  }
}
