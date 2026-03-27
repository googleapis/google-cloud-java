/*
 * Copyright 2016 Google LLC
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

import com.google.common.base.Preconditions;
import java.util.Map;

/** Represents an exception thrown during an RPC call. */
public class ApiException extends RuntimeException {

  private static final long serialVersionUID = -4375114339928877996L;

  private final ErrorDetails errorDetails;
  private final StatusCode statusCode;
  private final boolean retryable;

  public ApiException(Throwable cause, StatusCode statusCode, boolean retryable) {
    this(cause, statusCode, retryable, null);
  }

  public ApiException(String message, Throwable cause, StatusCode statusCode, boolean retryable) {
    super(message, cause);
    this.statusCode = Preconditions.checkNotNull(statusCode);
    this.retryable = retryable;
    this.errorDetails = null;
  }

  public ApiException(
      Throwable cause, StatusCode statusCode, boolean retryable, ErrorDetails errorDetails) {
    super(cause);
    this.statusCode = Preconditions.checkNotNull(statusCode);
    this.retryable = retryable;
    this.errorDetails = errorDetails;
  }

  public ApiException(
      String message,
      Throwable cause,
      StatusCode statusCode,
      boolean retryable,
      ErrorDetails errorDetails) {
    super(message, cause);
    this.statusCode = Preconditions.checkNotNull(statusCode);
    this.retryable = retryable;
    this.errorDetails = errorDetails;
  }

  /** Returns whether the failed request can be retried. */
  public boolean isRetryable() {
    return retryable;
  }

  /** Returns the status code of the underlying exception. */
  public StatusCode getStatusCode() {
    return statusCode;
  }

  /**
   * Returns the reason of the exception. This is a constant value that identifies the proximate
   * cause of the error. e.g. SERVICE_DISABLED
   */
  public String getReason() {
    if (isErrorInfoEmpty()) {
      return null;
    }
    return errorDetails.getErrorInfo().getReason();
  }

  /**
   * Returns the logical grouping to which the "reason" belongs. The error domain is typically the
   * registered service name of the tool or product that generates the error. e.g. googleapis.com
   */
  public String getDomain() {
    if (isErrorInfoEmpty()) {
      return null;
    }
    return errorDetails.getErrorInfo().getDomain();
  }

  /** Returns additional structured details about this exception. */
  public Map<String, String> getMetadata() {
    if (isErrorInfoEmpty()) {
      return null;
    }
    return errorDetails.getErrorInfo().getMetadataMap();
  }

  /** Returns all standard error messages that server sends. */
  public ErrorDetails getErrorDetails() {
    return errorDetails;
  }

  private boolean isErrorInfoEmpty() {
    return errorDetails == null || errorDetails.getErrorInfo() == null;
  }
}
