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
  private static final ImmutableMap<String, ErrorInfo> REASON_TO_CODE;
  private static final ImmutableMap<Integer, ErrorInfo> HTTP_TO_CODE;

  private final ErrorInfo errorInfo;

  /**
   * Represent metadata about {@link DatastoreException}s.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
   *     Datastore error codes</a>
   */
  public enum ErrorInfo {

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

    ErrorInfo(Reason reason) {
      this(reason.retryable(), reason.description(), reason.httpStatus());
    }

    ErrorInfo(boolean retryable, String description, int httpStatus) {
      this.retryable = retryable;
      this.description = description;
      this.httpStatus = httpStatus;
    }

    public String description() {
      return description;
    }

    public int httpStatus() {
      return httpStatus;
    }

    /**
     * Returns {@code true} if this exception is transient and the same request could be retried.
     * For any retry it is highly recommended to apply an exponential backoff.
     */
    public boolean retryable() {
      return retryable;
    }

    DatastoreException translate(DatastoreRpcException exception, String message) {
      return new DatastoreException(this, message, exception);
    }
  }

  static {
    ImmutableMap.Builder<String, ErrorInfo> builder = ImmutableMap.builder();
    Map<Integer, ErrorInfo> httpCodes = new HashMap<>();
    for (ErrorInfo code : ErrorInfo.values()) {
      builder.put(code.name(), code);
      httpCodes.put(code.httpStatus(), code);
    }
    REASON_TO_CODE = builder.build();
    HTTP_TO_CODE = ImmutableMap.copyOf(httpCodes);
  }

  public DatastoreException(ErrorInfo errorInfo, String message, Exception cause) {
    super(errorInfo.httpStatus(), MoreObjects.firstNonNull(message, errorInfo.description),
        errorInfo.retryable(), cause);
    this.errorInfo = errorInfo;
  }

  public DatastoreException(ErrorInfo errorInfo, String message) {
    this(errorInfo, message, null);
  }

  /**
   * Returns the code associated with this exception.
   */
  public ErrorInfo errorInfo() {
    return errorInfo;
  }

  static DatastoreException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof DatastoreRpcException) {
      return translateAndThrow((DatastoreRpcException) ex.getCause());
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    throw new DatastoreException(ErrorInfo.UNKNOWN, ex.getMessage(), ex);
  }

  /**
   * Translate DatastoreException to DatastoreException based on their
   * HTTP error codes. This method will always throw a new DatastoreException.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException translateAndThrow(DatastoreRpcException exception) {
    String message = exception.getMessage();
    ErrorInfo code = REASON_TO_CODE.get(exception.reason());
    if (code == null) {
      code = MoreObjects.firstNonNull(HTTP_TO_CODE.get(exception.httpStatus()), ErrorInfo.UNKNOWN);
    }
    throw code.translate(exception, message);
  }

  /**
   * Throw a DatastoreException with {@code FAILED_PRECONDITION} code and the {@code message}
   * in a nested exception.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException throwInvalidRequest(String massage, Object... params) {
    throw new DatastoreException(ErrorInfo.FAILED_PRECONDITION, String.format(massage, params));
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(ErrorInfo.UNKNOWN, ex.getMessage(), ex);
  }
}
