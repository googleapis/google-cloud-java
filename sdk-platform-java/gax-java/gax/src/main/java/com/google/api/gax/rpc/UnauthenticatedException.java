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

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Exception thrown when the request does not have valid authentication credentials for the
 * operation.
 */
@NullMarked
public class UnauthenticatedException extends ApiException {
  // Pinned to the value computed for previous releases (gax 2.83.0 to 2.87.0) so that adding
  // members does not break Java serialization compatibility with them.
  private static final long serialVersionUID = 6971115068105015909L;

  /**
   * Whether this failure happened on a transport channel that has since been refreshed (for
   * example, after an mTLS certificate rotation), making the request eligible for a single
   * immediate retry on the refreshed channel. Only meaningful within the process that observed the
   * failure, so it is not serialized.
   */
  private final transient boolean channelRefreshed;

  public UnauthenticatedException(Throwable cause, StatusCode statusCode, boolean retryable) {
    super(cause, statusCode, retryable);
    this.channelRefreshed = false;
  }

  public UnauthenticatedException(
      String message, Throwable cause, StatusCode statusCode, boolean retryable) {
    super(message, cause, statusCode, retryable);
    this.channelRefreshed = false;
  }

  public UnauthenticatedException(
      Throwable cause, StatusCode statusCode, boolean retryable, ErrorDetails errorDetails) {
    super(cause, statusCode, retryable, errorDetails);
    this.channelRefreshed = false;
  }

  public UnauthenticatedException(
      String message,
      Throwable cause,
      StatusCode statusCode,
      boolean retryable,
      ErrorDetails errorDetails) {
    super(message, cause, statusCode, retryable, errorDetails);
    this.channelRefreshed = false;
  }

  private UnauthenticatedException(
      @Nullable String message,
      @Nullable Throwable cause,
      StatusCode statusCode,
      boolean retryable,
      @Nullable ErrorDetails errorDetails,
      boolean channelRefreshed) {
    super(message, cause, statusCode, retryable, errorDetails);
    this.channelRefreshed = channelRefreshed;
  }

  /** Returns whether this failure happened on a transport channel that has since been refreshed. */
  boolean isChannelRefreshed() {
    return channelRefreshed;
  }

  /**
   * Returns a copy of this exception marked as having happened on a channel that has since been
   * refreshed. The copy keeps the message, cause, status code, {@link #isRetryable()} value, error
   * details, stack trace and suppressed exceptions of this exception.
   */
  UnauthenticatedException withChannelRefreshed() {
    UnauthenticatedException newEx =
        new UnauthenticatedException(
            getMessage(), getCause(), getStatusCode(), isRetryable(), getErrorDetails(), true);
    newEx.setStackTrace(getStackTrace());
    for (Throwable suppressed : getSuppressed()) {
      newEx.addSuppressed(suppressed);
    }
    return newEx;
  }
}
