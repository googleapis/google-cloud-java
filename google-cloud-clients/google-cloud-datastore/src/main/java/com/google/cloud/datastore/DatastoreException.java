/*
 * Copyright 2019 Google LLC
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

import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.grpc.BaseGrpcServiceException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Datastore service exception.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
 *     Datastore error codes</a>
 */
public class DatastoreException extends BaseGrpcServiceException {

  // see https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes"
  private static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(10, "ABORTED", false),
          new Error(4, "DEADLINE_EXCEEDED", false),
          new Error(14, "UNAVAILABLE", true));

  private static final long serialVersionUID = 20190326L;
  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  private ErrorCode code;
  private String exceptionReason;

  /** Private constructor. Use {@link DatastoreExceptionFactory} to create instances. */
  DatastoreException(
      DoNotConstructDirectly token,
      ErrorCode code,
      boolean retryable,
      @Nullable String message,
      @Nullable Throwable cause) {
    super(message, cause, code.getCode(), retryable);
    if (token != DoNotConstructDirectly.ALLOWED) {
      throw new AssertionError("Do not construct directly: use SpannerExceptionFactory");
    }
    this.code = Preconditions.checkNotNull(code);
  }

  /** Returns the error code associated with this exception. */
  public ErrorCode getErrorCode() {
    return code;
  }

  enum DoNotConstructDirectly {
    ALLOWED
  }

  /**
   * Return the retry delay for operation in milliseconds. Return -1 if this does not specify any
   * retry delay.
   */
  public long getRetryDelayInMillis() {
    return extractRetryDelay(this.getCause());
  }

  static long extractRetryDelay(Throwable cause) {
    if (cause != null) {
      Metadata trailers = Status.trailersFromThrowable(cause);
      if (trailers != null && trailers.containsKey(KEY_RETRY_INFO)) {
        RetryInfo retryInfo = trailers.get(KEY_RETRY_INFO);
        if (retryInfo.hasRetryDelay()) {
          return Durations.toMillis(retryInfo.getRetryDelay());
        }
      }
    }
    return -1L;
  }

  // Added for backward compatibility
  // TODO(User) Remove later unused constructors
  public DatastoreException(int code, String message) {
    this(code, message, null, true, null);
  }
  public DatastoreException(int code, String message, String reason) {
    this(code, message, reason, true, null);
  }

  public DatastoreException(int code, String message, String reason, Throwable cause) {
    this(code, message, reason, true, cause);
  }

  public DatastoreException(
      int code, String message, String reason, boolean idempotent, Throwable cause) {
    super(message, cause, code,
        BaseServiceException.isRetryable(code, reason, idempotent, RETRYABLE_ERRORS));
    // Added for unit test compatibility
    // TODO(User) remove when tests updated
    this.exceptionReason = reason;
  }

  @Override
  public String getReason() {
    String reason = super.getReason();
    return reason != null ? reason : exceptionReason;
  }

  public DatastoreException(IOException exception) {
    super(exception, true);
  }

  /**
   * Translate RetryHelperException to the DatastoreException that caused the error. This method
   * will always throw an exception.
   *
   * @throws DatastoreException when {@code ex} was caused by a {@code DatastoreException}
   */
  static DatastoreException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    throw DatastoreExceptionFactory.newDatastoreException(ErrorCode.UNKNOWN, ex.getMessage(),
        ex);
  }

  /**
   * Throw a DatastoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in a
   * nested exception.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException throwInvalidRequest(String massage, Object... params) {
    throw DatastoreExceptionFactory.newDatastoreException(
        ErrorCode.FAILED_PRECONDITION, String.format(massage, params));
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw DatastoreExceptionFactory.newDatastoreException(ex);
  }
}
