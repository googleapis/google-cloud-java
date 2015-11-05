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
public class BigqueryException extends BaseServiceException {

  private static final long serialVersionUID = -5504832700512784654L;
  public static final int UNKNOWN_CODE = -1;

  public BigqueryException(int code, String message, boolean retryable) {
    super(code, message, retryable);
  }

  /**
   * Translate RetryHelperException to the BigqueryException that caused the error. This method will
   * always throw an exception.
   *
   * @throws BigqueryException when {@code ex} was caused by a {@code BigqueryException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static BigqueryException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof BigqueryException) {
      throw (BigqueryException) ex.getCause();
    }
    if (ex instanceof RetryInterruptedException) {
      RetryInterruptedException.propagate();
    }
    throw new BigqueryException(UNKNOWN_CODE, ex.getMessage(), false);
  }
}
