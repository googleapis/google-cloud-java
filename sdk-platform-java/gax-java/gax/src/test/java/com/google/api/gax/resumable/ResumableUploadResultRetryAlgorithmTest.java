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
package com.google.api.gax.resumable;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.api.gax.rpc.ResourceExhaustedException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CancellationException;
import org.junit.jupiter.api.Test;

class ResumableUploadResultRetryAlgorithmTest {

  private final ResumableUploadResultRetryAlgorithm<String> algorithm =
      ResumableUploadResultRetryAlgorithm.create();

  @Test
  void testCategory1TransientErrors_shouldRetry() {
    // 503 Unavailable
    UnavailableException unavailable =
        new UnavailableException(
            "unavailable", null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), false);
    assertThat(algorithm.shouldRetry(unavailable, null)).isTrue();

    // 504 DeadlineExceeded
    DeadlineExceededException deadlineExceeded =
        new DeadlineExceededException(
            "deadline exceeded", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), false);
    assertThat(algorithm.shouldRetry(deadlineExceeded, null)).isTrue();

    // 429 ResourceExhausted
    ResourceExhaustedException resourceExhausted =
        new ResourceExhaustedException(
            "quota exceeded", null, FakeStatusCode.of(StatusCode.Code.RESOURCE_EXHAUSTED), false);
    assertThat(algorithm.shouldRetry(resourceExhausted, null)).isTrue();

    // Network / Socket I/O exception
    IOException ioException = new IOException("connection reset by peer");
    assertThat(algorithm.shouldRetry(ioException, null)).isTrue();
  }

  @Test
  void testCategory2RecoverableErrors_shouldRetry() {
    // 416 OutOfRange (chunk offset mismatch)
    OutOfRangeException outOfRange =
        new OutOfRangeException(
            "out of range", null, FakeStatusCode.of(StatusCode.Code.OUT_OF_RANGE), false);
    assertThat(algorithm.shouldRetry(outOfRange, null)).isTrue();

    // 400 InvalidArgument (chunk offset / payload mismatch)
    InvalidArgumentException invalidArgument =
        new InvalidArgumentException(
            "invalid argument", null, FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    assertThat(algorithm.shouldRetry(invalidArgument, null)).isTrue();

    // 412 FailedPrecondition
    FailedPreconditionException failedPrecondition =
        new FailedPreconditionException(
            "failed precondition",
            null,
            FakeStatusCode.of(StatusCode.Code.FAILED_PRECONDITION),
            false);
    assertThat(algorithm.shouldRetry(failedPrecondition, null)).isTrue();

    // 409 Aborted (conflict)
    AbortedException aborted =
        new AbortedException("aborted", null, FakeStatusCode.of(StatusCode.Code.ABORTED), false);
    assertThat(algorithm.shouldRetry(aborted, null)).isTrue();

    // 500 / Protocol Internal error (missing status headers)
    InternalException internal =
        new InternalException(
            "internal protocol error", null, FakeStatusCode.of(StatusCode.Code.INTERNAL), false);
    assertThat(algorithm.shouldRetry(internal, null)).isTrue();
  }

  @Test
  void testCategory3FatalTerminalErrors_shouldNotRetry() {
    // 404 NotFound (session expired or invalid)
    NotFoundException notFound =
        new NotFoundException(
            "session not found", null, FakeStatusCode.of(StatusCode.Code.NOT_FOUND), false);
    assertThat(algorithm.shouldRetry(notFound, null)).isFalse();

    // 401 Unauthenticated
    UnauthenticatedException unauthenticated =
        new UnauthenticatedException(
            "unauthenticated", null, FakeStatusCode.of(StatusCode.Code.UNAUTHENTICATED), false);
    assertThat(algorithm.shouldRetry(unauthenticated, null)).isFalse();

    // 403 PermissionDenied
    PermissionDeniedException permissionDenied =
        new PermissionDeniedException(
            "permission denied", null, FakeStatusCode.of(StatusCode.Code.PERMISSION_DENIED), false);
    assertThat(algorithm.shouldRetry(permissionDenied, null)).isFalse();

    // Cancellation
    CancellationException cancellation = new CancellationException("cancelled");
    assertThat(algorithm.shouldRetry(cancellation, null)).isFalse();

    // Generic RuntimeException
    RuntimeException runtime = new RuntimeException("unexpected");
    assertThat(algorithm.shouldRetry(runtime, null)).isFalse();
  }

  @Test
  void testRetryingContextOverride() {
    FakeCallContext contextWithEmptyCodes =
        FakeCallContext.createDefault().withRetryableCodes(Collections.emptySet());

    UnavailableException unavailable =
        new UnavailableException(
            "unavailable", null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), false);

    // Default algorithm retries UNAVAILABLE, but context with empty codes forbids it
    assertThat(algorithm.shouldRetry(contextWithEmptyCodes, unavailable, null)).isFalse();

    FakeCallContext contextWithCustomCodes =
        FakeCallContext.createDefault()
            .withRetryableCodes(ImmutableSet.of(StatusCode.Code.NOT_FOUND));

    NotFoundException notFound =
        new NotFoundException(
            "not found", null, FakeStatusCode.of(StatusCode.Code.NOT_FOUND), false);

    // Custom context allows NOT_FOUND
    assertThat(algorithm.shouldRetry(contextWithCustomCodes, notFound, null)).isTrue();
  }
}
