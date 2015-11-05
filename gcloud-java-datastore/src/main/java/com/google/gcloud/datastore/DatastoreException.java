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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import java.util.HashMap;
import java.util.Map;

public class DatastoreException extends BaseServiceException {

  private static final long serialVersionUID = -2336749234060754893L;
  private static final ImmutableMap<String, DatastoreError> REASON_TO_ERROR;
  private static final ImmutableMap<Integer, DatastoreError> HTTP_TO_ERROR;

  private final DatastoreError error;

  /**
   * Represents Datastore errors.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
   *     Datastore error codes</a>
   */
  public enum DatastoreError {

    ABORTED(Reason.ABORTED),
    DEADLINE_EXCEEDED(Reason.DEADLINE_EXCEEDED),
    UNAVAILABLE(Reason.UNAVAILABLE),
    FAILED_PRECONDITION(Reason.FAILED_PRECONDITION),
    INVALID_ARGUMENT(Reason.INVALID_ARGUMENT),
    PERMISSION_DENIED(Reason.PERMISSION_DENIED),
    UNAUTHORIZED(false, "Unauthorized", 401),
    INTERNAL(Reason.INTERNAL),
    RESOURCE_EXHAUSTED(Reason.RESOURCE_EXHAUSTED),
    UNKNOWN(false, "Unknown failure", -1);

    private final boolean retryable;
    private final String description;
    private final int httpStatus;

    DatastoreError(Reason reason) {
      this(reason.retryable(), reason.description(), reason.httpStatus());
    }

    DatastoreError(boolean retryable, String description, int httpStatus) {
      this.retryable = retryable;
      this.description = description;
      this.httpStatus = httpStatus;
    }

    String description() {
      return description;
    }

    int httpStatus() {
      return httpStatus;
    }

    boolean retryable() {
      return retryable;
    }

    DatastoreException translate(DatastoreRpcException exception, String message) {
      return new DatastoreException(this, message, exception);
    }
  }

  static {
    ImmutableMap.Builder<String, DatastoreError> builder = ImmutableMap.builder();
    Map<Integer, DatastoreError> httpCodes = new HashMap<>();
    for (DatastoreError error : DatastoreError.values()) {
      builder.put(error.name(), error);
      httpCodes.put(error.httpStatus(), error);
    }
    REASON_TO_ERROR = builder.build();
    HTTP_TO_ERROR = ImmutableMap.copyOf(httpCodes);
  }

  public DatastoreException(DatastoreError error, String message, Exception cause) {
    super(error.httpStatus(), MoreObjects.firstNonNull(message, error.description),
        error.retryable(), cause);
    this.error = error;
  }

  public DatastoreException(DatastoreError error, String message) {
    this(error, message, null);
  }

  /**
   * Returns the DatastoreError associated with this exception.
   */
  public DatastoreError datastoreError() {
    return error;
  }

  static DatastoreException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof DatastoreRpcException) {
      return translateAndThrow((DatastoreRpcException) ex.getCause());
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    throw new DatastoreException(DatastoreError.UNKNOWN, ex.getMessage(), ex);
  }

  /**
   * Translate DatastoreRpcExceptions to DatastoreExceptions based on their
   * HTTP error codes. This method will always throw a new DatastoreException.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException translateAndThrow(DatastoreRpcException exception) {
    String message = exception.getMessage();
    DatastoreError error = REASON_TO_ERROR.get(exception.reason());
    if (error == null) {
      error = MoreObjects.firstNonNull(
          HTTP_TO_ERROR.get(exception.httpStatus()), DatastoreError.UNKNOWN);
    }
    throw error.translate(exception, message);
  }

  /**
   * Throw a DatastoreException with {@code FAILED_PRECONDITION} error and the {@code message}
   * in a nested exception.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException throwInvalidRequest(String massage, Object... params) {
    throw new DatastoreException(DatastoreError.FAILED_PRECONDITION, String.format(massage, params));
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(DatastoreError.UNKNOWN, ex.getMessage(), ex);
  }
}
