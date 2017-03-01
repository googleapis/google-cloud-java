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

package com.google.cloud.bigquery;

import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.RetryHelper.RetryInterruptedException;
import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

/**
 * BigQuery service exception.
 *
 * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Google Cloud
 *      BigQuery error codes</a>
 */
public final class BigQueryException extends BaseServiceException {

  // see: https://cloud.google.com/bigquery/troubleshooting-errors
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(500, null),
      new Error(502, null),
      new Error(503, null),
      new Error(504, null));
  private static final long serialVersionUID = -5006625989225438209L;

  private final BigQueryError error;

  public BigQueryException(int code, String message) {
    this(code, message, (Throwable) null);
  }

  public BigQueryException(int code, String message, Throwable cause) {
    super(code, message, null, true, cause);
    this.error = null;
  }

  public BigQueryException(int code, String message, BigQueryError error) {
    super(code, message, error != null ? error.getReason() : null, true);
    this.error = error;
  }

  public BigQueryException(IOException exception) {
    super(exception, true);
    BigQueryError error = null;
    if (getReason() != null) {
      error = new BigQueryError(getReason(), getLocation(), getMessage(), getDebugInfo());
    }
    this.error = error;
  }

  /**
   * Returns the {@link BigQueryError} that caused this exception. Returns {@code null} if none
   * exists.
   */
  @Deprecated
  public BigQueryError error() {
    return getError();
  }

  /**
   * Returns the {@link BigQueryError} that caused this exception. Returns {@code null} if none
   * exists.
   */
  public BigQueryError getError() {
    return error;
  }

  @Override
  protected Set<Error> getRetryableErrors() {
    return RETRYABLE_ERRORS;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof BigQueryException)) {
      return false;
    }
    BigQueryException other = (BigQueryException) obj;
    return super.equals(other) && Objects.equals(error, other.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), error);
  }

  /**
   * Translate RetryHelperException to the BigQueryException that caused the error. This method will
   * always throw an exception.
   *
   * @throws BigQueryException when {@code ex} was caused by a {@code BigQueryException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static BaseServiceException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translateAndPropagateIfPossible(ex);
    throw new BigQueryException(UNKNOWN_CODE, ex.getMessage(), ex.getCause());
  }
}
