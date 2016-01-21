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

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

/**
 * BigQuery service exception.
 *
 * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Google Cloud
 *      BigQuery error codes</a>
 */
public class BigQueryException extends BaseServiceException {

  // see: https://cloud.google.com/bigquery/troubleshooting-errors
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(500, null),
      new Error(502, null),
      new Error(503, null),
      new Error(504, null));
  private static final long serialVersionUID = -5006625989225438209L;

  private final BigQueryError error;

  public BigQueryException(int code, String message) {
    this(code, message, null);
  }

  public BigQueryException(int code, String message, BigQueryError error) {
    super(code, message, error != null ? error.reason() : null, true);
    this.error = error;
  }

  public BigQueryException(IOException exception) {
    super(exception, true);
    BigQueryError bigqueryError = null;
    if (exception instanceof GoogleJsonResponseException) {
      GoogleJsonError error = ((GoogleJsonResponseException) exception).getDetails();
      if (error != null && error.getErrors() != null  && !error.getErrors().isEmpty()) {
        GoogleJsonError.ErrorInfo errorInfo = error.getErrors().get(0);
        bigqueryError = new BigQueryError(errorInfo.getReason(), errorInfo.getLocation(),
            errorInfo.getMessage(), (String) error.get("debugInfo"));
      }
    }
    this.error = bigqueryError;
  }

  /**
   * Returns the {@link BigQueryError} that caused this exception. Returns {@code null} if none
   * exists.
   */
  public BigQueryError error() {
    return error;
  }

  @Override
  protected Set<Error> retryableErrors() {
    return RETRYABLE_ERRORS;
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
    throw new BigQueryException(UNKNOWN_CODE, ex.getMessage());
  }
}
