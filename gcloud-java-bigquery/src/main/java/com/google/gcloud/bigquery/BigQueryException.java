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

package com.google.gcloud.bigquery;

import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryHelper.RetryInterruptedException;

/**
 * BigQuery service exception.
 *
 * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Google Cloud
 *      BigQuery error codes</a>
 */
public class BigQueryException extends BaseServiceException {

  private static final long serialVersionUID = -5504832700512784654L;
  public static final int UNKNOWN_CODE = -1;

  private final BigQueryError error;

  public BigQueryException(int code, String message, boolean retryable) {
    this(code, message, retryable, null);
  }

  public BigQueryException(int code, String message, boolean retryable, BigQueryError error) {
    super(code, message, retryable);
    this.error = error;
  }

  /**
   * Returns the {@link BigQueryError} that caused this exception. Returns {@code null} if none
   * exists.
   */
  public BigQueryError error() {
    return error;
  }

  /**
   * Translate RetryHelperException to the BigQueryException that caused the error. This method will
   * always throw an exception.
   *
   * @throws BigQueryException when {@code ex} was caused by a {@code BigQueryException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static BigQueryException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof BigQueryException) {
      throw (BigQueryException) ex.getCause();
    }
    if (ex instanceof RetryInterruptedException) {
      RetryInterruptedException.propagate();
    }
    throw new BigQueryException(UNKNOWN_CODE, ex.getMessage(), false);
  }
}
