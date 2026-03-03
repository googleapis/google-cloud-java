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

/**
 * A factory class that returns the corresponding type of exception class from the given status
 * code.
 */
public class ApiExceptionFactory {
  private ApiExceptionFactory() {}

  public static ApiException createException(
      Throwable cause, StatusCode statusCode, boolean retryable) {
    return createException(cause, statusCode, retryable, null);
  }

  public static ApiException createException(
      String message, Throwable cause, StatusCode statusCode, boolean retryable) {
    switch (statusCode.getCode()) {
      case CANCELLED:
        return new CancelledException(message, cause, statusCode, retryable);
      case NOT_FOUND:
        return new NotFoundException(message, cause, statusCode, retryable);
      case INVALID_ARGUMENT:
        return new InvalidArgumentException(message, cause, statusCode, retryable);
      case DEADLINE_EXCEEDED:
        return new DeadlineExceededException(message, cause, statusCode, retryable);
      case ALREADY_EXISTS:
        return new AlreadyExistsException(message, cause, statusCode, retryable);
      case PERMISSION_DENIED:
        return new PermissionDeniedException(message, cause, statusCode, retryable);
      case RESOURCE_EXHAUSTED:
        return new ResourceExhaustedException(message, cause, statusCode, retryable);
      case FAILED_PRECONDITION:
        return new FailedPreconditionException(message, cause, statusCode, retryable);
      case ABORTED:
        return new AbortedException(message, cause, statusCode, retryable);
      case OUT_OF_RANGE:
        return new OutOfRangeException(message, cause, statusCode, retryable);
      case UNIMPLEMENTED:
        return new UnimplementedException(message, cause, statusCode, retryable);
      case INTERNAL:
        return new InternalException(message, cause, statusCode, retryable);
      case UNAVAILABLE:
        return new UnavailableException(message, cause, statusCode, retryable);
      case DATA_LOSS:
        return new DataLossException(message, cause, statusCode, retryable);
      case UNAUTHENTICATED:
        return new UnauthenticatedException(message, cause, statusCode, retryable);

      case UNKNOWN: // Fall through.
      default:
        return new UnknownException(message, cause, statusCode, retryable);
    }
  }

  public static ApiException createException(
      Throwable cause, StatusCode statusCode, boolean retryable, ErrorDetails errorDetails) {
    switch (statusCode.getCode()) {
      case CANCELLED:
        return new CancelledException(cause, statusCode, retryable, errorDetails);
      case NOT_FOUND:
        return new NotFoundException(cause, statusCode, retryable, errorDetails);
      case INVALID_ARGUMENT:
        return new InvalidArgumentException(cause, statusCode, retryable, errorDetails);
      case DEADLINE_EXCEEDED:
        return new DeadlineExceededException(cause, statusCode, retryable, errorDetails);
      case ALREADY_EXISTS:
        return new AlreadyExistsException(cause, statusCode, retryable, errorDetails);
      case PERMISSION_DENIED:
        return new PermissionDeniedException(cause, statusCode, retryable, errorDetails);
      case RESOURCE_EXHAUSTED:
        return new ResourceExhaustedException(cause, statusCode, retryable, errorDetails);
      case FAILED_PRECONDITION:
        return new FailedPreconditionException(cause, statusCode, retryable, errorDetails);
      case ABORTED:
        return new AbortedException(cause, statusCode, retryable, errorDetails);
      case OUT_OF_RANGE:
        return new OutOfRangeException(cause, statusCode, retryable, errorDetails);
      case UNIMPLEMENTED:
        return new UnimplementedException(cause, statusCode, retryable, errorDetails);
      case INTERNAL:
        return new InternalException(cause, statusCode, retryable, errorDetails);
      case UNAVAILABLE:
        return new UnavailableException(cause, statusCode, retryable, errorDetails);
      case DATA_LOSS:
        return new DataLossException(cause, statusCode, retryable, errorDetails);
      case UNAUTHENTICATED:
        return new UnauthenticatedException(cause, statusCode, retryable, errorDetails);
      case UNKNOWN: // Fall through.
      default:
        return new UnknownException(cause, statusCode, retryable, errorDetails);
    }
  }
}
