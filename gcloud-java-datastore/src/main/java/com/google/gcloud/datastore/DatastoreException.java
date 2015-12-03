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

package com.google.gcloud.datastore;

import com.google.common.collect.ImmutableSet;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

public class DatastoreException extends BaseServiceException {

  /**
   * Possible reasons for a Google Cloud Datastore exception.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Error
   *     Codes</a>
   */
  public enum Reason {
    ABORTED,
    DEADLINE_EXCEEDED,
    UNAVAILABLE,
    FAILED_PRECONDITION,
    INVALID_ARGUMENT,
    PERMISSION_DENIED,
    UNAUTHORIZED,
    INTERNAL,
    RESOURCE_EXHAUSTED,
    UNKNOWN;

    public static Reason of(String reason) {
      try {
        return Reason.valueOf(reason);
      } catch (Exception ex) {
        return Reason.UNKNOWN;
      }
    }
  }

  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(409, 403, 503);
  private static final Set<Reason> RETRYABLE_REASONS = ImmutableSet.of(Reason.ABORTED,
      Reason.DEADLINE_EXCEEDED, Reason.UNAVAILABLE);
  private static final long serialVersionUID = -2336749234060754893L;

  private final Reason reason;

  public DatastoreException(Reason reason, int status, String message, Exception cause) {
    super(status, message, RETRYABLE_CODES.contains(status) && RETRYABLE_REASONS.contains(reason),
        true, cause);
    this.reason = reason;
  }

  public DatastoreException(Reason reason, int status, String message) {
    super(status, message, RETRYABLE_CODES.contains(status) && RETRYABLE_REASONS.contains(reason),
        true);
    this.reason = reason;
  }

  public DatastoreException(IOException exception) {
    super(exception, true);
    this.reason = Reason.UNKNOWN;
  }

  @Override
  protected Set<Integer> retryableCodes() {
    return RETRYABLE_CODES;
  }

  protected Set<Reason> retryableReasons() {
    return RETRYABLE_REASONS;
  }

  /**
   * Translate RetryHelperException to the DatastoreException that caused the error. This method
   * will always throw an exception.
   *
   * @throws DatastoreException when {@code ex} was caused by a {@code DatastoreException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  public static DatastoreException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.<DatastoreException>translateAndThrow(ex);
    throw new DatastoreException(Reason.UNKNOWN, UNKNOWN_CODE, ex.getMessage());
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(
        Reason.UNKNOWN, BaseServiceException.UNKNOWN_CODE, ex.getMessage(), ex);
  }

  /**
   * Returns the reason of the exception.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Error
   *     Codes</a>
   */
  public Reason reason() {
    return reason;
  }
}
