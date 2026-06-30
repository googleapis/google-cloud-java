/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
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

package com.google.auth.oauth2;

import com.google.api.client.http.HttpResponseException;
import com.google.auth.Retryable;
import java.io.IOException;

/**
 * Base class for the standard Auth error response. It extends a default exception while keeping
 * Json response format
 */
class GoogleAuthException extends IOException implements Retryable {

  private final boolean isRetryable;
  private final int retryCount;

  /**
   * Constructor with all parameters
   *
   * @param isRetryable A retry status for the related HTTP request
   * @param retryCount A number of retries performed for the related HTTP request
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  GoogleAuthException(boolean isRetryable, int retryCount, String message, Throwable cause) {
    super(message, cause);
    this.isRetryable = isRetryable;
    this.retryCount = retryCount;
  }

  /**
   * Constructor with message defaulted to the cause
   *
   * @param isRetryable A retry status for the related HTTP request
   * @param retryCount A number of retries performed for the related HTTP request
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.) If the
   *     cause has retry information, it is going to be skipped in favor of the {@code retryCount}
   *     parameter
   */
  GoogleAuthException(boolean isRetryable, int retryCount, Throwable cause) {
    super(cause);
    this.isRetryable = isRetryable;
    this.retryCount = retryCount;
  }

  /**
   * Constructor without explicit retry count.
   *
   * @param isRetryable A retry status for the related HTTP request
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  GoogleAuthException(boolean isRetryable, Throwable cause) {
    super(cause);
    this.isRetryable = isRetryable;
    this.retryCount = 0;
  }

  /**
   * Constructor without retry info
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  GoogleAuthException(Throwable cause) {
    this(false, cause);
  }

  /** A default Constructor */
  GoogleAuthException() {
    super();
    this.isRetryable = false;
    this.retryCount = 0;
  }

  /**
   * Creates an instance of the exception based on {@link HttpResponseException} and a custom error
   * message.
   *
   * @see #createWithTokenEndpointResponseException(HttpResponseException, String)
   * @param responseException an instance of {@link HttpResponseException}
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @return new instance of {@link GoogleAuthException}
   */
  static GoogleAuthException createWithTokenEndpointResponseException(
      HttpResponseException responseException, String message) {
    int responseStatus = responseException.getStatusCode();
    boolean isRetryable =
        OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(responseStatus);
    int retryCount = responseException.getAttemptCount() - 1;

    if (message == null) {
      return new GoogleAuthException(isRetryable, retryCount, responseException);
    } else {
      return new GoogleAuthException(isRetryable, retryCount, message, responseException);
    }
  }

  /**
   * Creates an instance of the exception based on {@link HttpResponseException} returned by Google
   * token endpoint. It uses response status code information to populate the {@code #isRetryable}
   * property and a number of performed attempts to populate the {@code #retryCount} property
   *
   * @param responseException an instance of {@link HttpResponseException}
   * @return new instance of {@link GoogleAuthException}
   */
  static GoogleAuthException createWithTokenEndpointResponseException(
      HttpResponseException responseException) {
    return GoogleAuthException.createWithTokenEndpointResponseException(responseException, null);
  }

  /**
   * Creates an instance of the exception based on {@link IOException} and a custom error message.
   *
   * @see #createWithTokenEndpointIOException(IOException)
   * @param ioException an instance of {@link IOException}
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @return new instance of {@link GoogleAuthException}
   */
  static GoogleAuthException createWithTokenEndpointIOException(
      IOException ioException, String message) {

    if (message == null) {
      return new GoogleAuthException(true, OAuth2Utils.DEFAULT_NUMBER_OF_RETRIES, ioException);
    } else {
      return new GoogleAuthException(
          true, OAuth2Utils.DEFAULT_NUMBER_OF_RETRIES, message, ioException);
    }
  }

  /**
   * Creates an instance of the exception based on {@link IOException} returned by Google token
   * endpoint. It uses response status code information to populate the {@code #isRetryable}
   * property and a number of performed attempts to populate the {@code #retryCount} property
   *
   * @see #createWithTokenEndpointIOException(IOException)
   * @param ioException an instance of {@link IOException}
   * @return new instance of {@link GoogleAuthException}
   */
  static GoogleAuthException createWithTokenEndpointIOException(IOException ioException) {
    return GoogleAuthException.createWithTokenEndpointIOException(ioException, null);
  }

  /** Returns true if the error is retryable, false otherwise */
  @Override
  public boolean isRetryable() {
    return isRetryable;
  }

  /** Returns number of reties performed for the related HTTP request */
  @Override
  public int getRetryCount() {
    return retryCount;
  }
}
