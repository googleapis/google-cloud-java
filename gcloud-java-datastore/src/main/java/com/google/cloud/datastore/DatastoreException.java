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

package com.google.cloud.datastore;

import com.google.common.collect.ImmutableSet;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

/**
 * Datastore service exception.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
 *      Datastore error codes</a>
 */
public class DatastoreException extends BaseServiceException {

  // see https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes"
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(10, "ABORTED"), new Error(4, "DEADLINE_EXCEEDED"), new Error(14, "UNAVAILABLE"));
  private static final long serialVersionUID = 2663750991205874435L;

  public DatastoreException(int code, String message, String reason, Throwable cause) {
    super(code, message, reason, true, cause);
  }

  public DatastoreException(int code, String message, String reason) {
    super(code, message, reason, true);
  }

  public DatastoreException(IOException exception) {
    super(exception, true);
  }

  @Override
  protected Set<Error> retryableErrors() {
    return RETRYABLE_ERRORS;
  }

  /**
   * Translate RetryHelperException to the DatastoreException that caused the error. This method
   * will always throw an exception.
   *
   * @throws DatastoreException when {@code ex} was caused by a {@code DatastoreException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static DatastoreException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translateAndPropagateIfPossible(ex);
    throw new DatastoreException(UNKNOWN_CODE, ex.getMessage(), null);
  }

  /**
   * Throw a DatastoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in a
   * nested exception.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException throwInvalidRequest(String massage, Object... params) {
    throw new DatastoreException(UNKNOWN_CODE, String.format(massage, params),
        "FAILED_PRECONDITION");
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(BaseServiceException.UNKNOWN_CODE, ex.getMessage(), null, ex);
  }
}
