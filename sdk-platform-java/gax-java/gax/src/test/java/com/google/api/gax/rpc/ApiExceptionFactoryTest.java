/*
 * Copyright 2017 Google LLC
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

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class ApiExceptionFactoryTest {

  @Test
  void cancelled() {
    Truth.assertThat(createException(Code.CANCELLED)).isInstanceOf(CancelledException.class);
    Truth.assertThat(createExceptionWithMessage(Code.CANCELLED))
        .isInstanceOf(CancelledException.class);
  }

  @Test
  void notFound() {
    Truth.assertThat(createException(Code.NOT_FOUND)).isInstanceOf(NotFoundException.class);
    Truth.assertThat(createExceptionWithMessage(Code.NOT_FOUND))
        .isInstanceOf(NotFoundException.class);
  }

  @Test
  void unknown() {
    Truth.assertThat(createException(Code.UNKNOWN)).isInstanceOf(UnknownException.class);
    Truth.assertThat(createExceptionWithMessage(Code.UNKNOWN)).isInstanceOf(UnknownException.class);
  }

  @Test
  void invalidArgument() {
    Truth.assertThat(createException(Code.INVALID_ARGUMENT))
        .isInstanceOf(InvalidArgumentException.class);
    Truth.assertThat(createExceptionWithMessage(Code.INVALID_ARGUMENT))
        .isInstanceOf(InvalidArgumentException.class);
  }

  @Test
  void deadlineExceeded() {
    Truth.assertThat(createException(Code.DEADLINE_EXCEEDED))
        .isInstanceOf(DeadlineExceededException.class);
    Truth.assertThat(createExceptionWithMessage(Code.DEADLINE_EXCEEDED))
        .isInstanceOf(DeadlineExceededException.class);
  }

  @Test
  void alreadyExists() {
    Truth.assertThat(createException(Code.ALREADY_EXISTS))
        .isInstanceOf(AlreadyExistsException.class);
    Truth.assertThat(createExceptionWithMessage(Code.ALREADY_EXISTS))
        .isInstanceOf(AlreadyExistsException.class);
  }

  @Test
  void permissionDenied() {
    Truth.assertThat(createException(Code.PERMISSION_DENIED))
        .isInstanceOf(PermissionDeniedException.class);
    Truth.assertThat(createExceptionWithMessage(Code.PERMISSION_DENIED))
        .isInstanceOf(PermissionDeniedException.class);
  }

  @Test
  void resourceExhausted() {
    Truth.assertThat(createException(Code.RESOURCE_EXHAUSTED))
        .isInstanceOf(ResourceExhaustedException.class);
    Truth.assertThat(createExceptionWithMessage(Code.RESOURCE_EXHAUSTED))
        .isInstanceOf(ResourceExhaustedException.class);
  }

  @Test
  void failedPrecondition() {
    Truth.assertThat(createException(Code.FAILED_PRECONDITION))
        .isInstanceOf(FailedPreconditionException.class);
    Truth.assertThat(createExceptionWithMessage(Code.FAILED_PRECONDITION))
        .isInstanceOf(FailedPreconditionException.class);
  }

  @Test
  void aborted() {
    Truth.assertThat(createException(Code.ABORTED)).isInstanceOf(AbortedException.class);
    Truth.assertThat(createExceptionWithMessage(Code.ABORTED)).isInstanceOf(AbortedException.class);
  }

  @Test
  void outOfRange() {
    Truth.assertThat(createException(Code.OUT_OF_RANGE)).isInstanceOf(OutOfRangeException.class);
    Truth.assertThat(createExceptionWithMessage(Code.OUT_OF_RANGE))
        .isInstanceOf(OutOfRangeException.class);
  }

  @Test
  void internal() {
    Truth.assertThat(createException(Code.INTERNAL)).isInstanceOf(InternalException.class);
    Truth.assertThat(createExceptionWithMessage(Code.INTERNAL))
        .isInstanceOf(InternalException.class);
  }

  @Test
  void unavailable() {
    Truth.assertThat(createException(Code.UNAVAILABLE)).isInstanceOf(UnavailableException.class);
    Truth.assertThat(createExceptionWithMessage(Code.UNAVAILABLE))
        .isInstanceOf(UnavailableException.class);
  }

  @Test
  void dataLoss() {
    Truth.assertThat(createException(Code.DATA_LOSS)).isInstanceOf(DataLossException.class);
    Truth.assertThat(createExceptionWithMessage(Code.DATA_LOSS))
        .isInstanceOf(DataLossException.class);
  }

  @Test
  void unauthenticated() {
    Truth.assertThat(createException(Code.UNAUTHENTICATED))
        .isInstanceOf(UnauthenticatedException.class);
    Truth.assertThat(createExceptionWithMessage(Code.UNAUTHENTICATED))
        .isInstanceOf(UnauthenticatedException.class);
  }

  @Test
  void unimplemented() {
    Truth.assertThat(createException(Code.UNIMPLEMENTED))
        .isInstanceOf(UnimplementedException.class);
    Truth.assertThat(createExceptionWithMessage(Code.UNIMPLEMENTED))
        .isInstanceOf(UnimplementedException.class);
  }

  @Test
  void unknown_default() {
    Truth.assertThat(createException(Code.OK)).isInstanceOf(UnknownException.class);
    Truth.assertThat(createExceptionWithMessage(Code.OK)).isInstanceOf(UnknownException.class);
  }

  private ApiException createException(StatusCode.Code statusCode) {
    return ApiExceptionFactory.createException(
        new RuntimeException(), FakeStatusCode.of(statusCode), false);
  }

  private ApiException createExceptionWithMessage(StatusCode.Code statusCode) {
    return ApiExceptionFactory.createException(
        "message", new RuntimeException(), FakeStatusCode.of(statusCode), false);
  }
}
