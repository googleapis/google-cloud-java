/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Set;

/**
 * Base class for all service exceptions.
 */
public class BaseServiceException extends RuntimeException {

  private static final long serialVersionUID = 5028833760039966178L;
  public static final int UNKNOWN_CODE = 0;

  private final int code;
  private final boolean retryable;
  private final boolean idempotent;

  public BaseServiceException(IOException exception, boolean idempotent) {
    super(exception.getMessage(), exception);
    this.code = statusCode(exception);
    this.idempotent = idempotent;
    this.retryable = idempotent && isRetryable(exception);
  }

  public BaseServiceException(GoogleJsonError error, boolean idempotent) {
    super(error.getMessage());
    this.code = error.getCode();
    this.idempotent = idempotent;
    this.retryable = idempotent && isRetryable(error);
  }

  public BaseServiceException(int code, String message, boolean retryable, boolean idempotent) {
    super(message);
    this.code = code;
    this.idempotent = idempotent;
    this.retryable = idempotent && retryable;
  }

  public BaseServiceException(int code, String message, boolean retryable, boolean idempotent,
      Exception cause) {
    super(message, cause);
    this.code = code;
    this.idempotent = idempotent;
    this.retryable = idempotent && retryable;
  }

  protected Set<Integer> retryableCodes() {
    return Collections.emptySet();
  }

  protected int statusCode(IOException exception) {
    if (exception instanceof GoogleJsonResponseException) {
      if (((GoogleJsonResponseException) exception).getDetails() != null) {
        return ((GoogleJsonResponseException) exception).getDetails().getCode();
      }
    }
    return UNKNOWN_CODE;
  }

  protected boolean isRetryable(GoogleJsonError error) {
    return error != null && retryableCodes().contains(error.getCode());
  }

  protected boolean isRetryable(IOException exception) {
    if (exception instanceof GoogleJsonResponseException) {
      return isRetryable(((GoogleJsonResponseException) exception).getDetails());
    }
    if (exception instanceof SocketTimeoutException) {
      return true;
    }
    return false;
  }

  /**
   * Returns the code associated with this exception.
   */
  public int code() {
    return code;
  }

  /**
   * Returns {@code true} when it is safe to retry the operation that caused this exception.
   */
  public boolean retryable() {
    return retryable;
  }

  /**
   * Returns {@code true} when the operation that caused this exception had no side effects.
   */
  public boolean idempotent() {
    return idempotent;
  }

  protected static <T extends BaseServiceException> T translateAndThrow(
      RetryHelper.RetryHelperException ex) {
    if (ex.getCause() instanceof BaseServiceException) {
      throw (T) ex.getCause();
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    return null;
  }
}
