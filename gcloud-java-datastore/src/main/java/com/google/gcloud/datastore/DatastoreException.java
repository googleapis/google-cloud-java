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
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import java.util.HashMap;
import java.util.Map;

public class DatastoreException extends RuntimeException {

  private static final long serialVersionUID = 8170357898917041899L;
  private static final ImmutableMap<String, Code> REASON_TO_CODE;
  private static final ImmutableMap<Integer, Code> HTTP_TO_CODE;

  private final Code code;

  /**
   * An error code to represent the failure.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
   *     Datastore error codes</a>
   */
  public enum Code {

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

    Code(Reason reason) {
      this(reason.retryable(), reason.description(), reason.httpStatus());
    }

    Code(boolean retryable, String description, int httpStatus) {
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
    ImmutableMap.Builder<String, Code> builder = ImmutableMap.builder();
    Map<Integer, Code> httpCodes = new HashMap<>();
    for (Code code : Code.values()) {
      builder.put(code.name(), code);
      httpCodes.put(code.httpStatus(), code);
    }
    REASON_TO_CODE = builder.build();
    HTTP_TO_CODE = ImmutableMap.copyOf(httpCodes);
  }

  public DatastoreException(Code code, String message, Exception cause) {
    super(MoreObjects.firstNonNull(message, code.description), cause);
    this.code = code;
  }

  public DatastoreException(Code code, String message) {
    this(code, message, null);
  }

  /**
   * Returns the code associated with this exception.
   */
  public Code code() {
    return code;
  }

  static DatastoreException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof DatastoreRpcException) {
      return translateAndThrow((DatastoreRpcException) ex.getCause());
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    throw new DatastoreException(Code.UNKNOWN, ex.getMessage(), ex);
  }

  /**
   * Translate DatastoreException to DatastoreException based on their
   * HTTP error codes. This method will always throw a new DatastoreException.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException translateAndThrow(DatastoreRpcException exception) {
    String message = exception.getMessage();
    Code code = REASON_TO_CODE.get(exception.reason());
    if (code == null) {
      code = MoreObjects.firstNonNull(HTTP_TO_CODE.get(exception.httpStatus()), Code.UNKNOWN);
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
    throw new DatastoreException(Code.FAILED_PRECONDITION, String.format(massage, params));
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(Code.UNKNOWN, ex.getMessage(), ex);
  }
}
