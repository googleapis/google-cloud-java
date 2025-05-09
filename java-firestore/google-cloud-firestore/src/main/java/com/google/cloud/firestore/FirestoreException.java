/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.firestore;

import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.grpc.BaseGrpcServiceException;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Nullable;

/** A Firestore Service exception. */
public class FirestoreException extends BaseGrpcServiceException {
  private Status status;

  FirestoreException(String reason, Status status) {
    this(reason, status, null);
  }

  private FirestoreException(String reason, Status status, @Nullable Throwable cause) {
    super(reason, cause, status.getCode().value(), false);

    this.status = status;
  }

  private FirestoreException(String reason, ApiException exception) {
    super(
        reason,
        exception,
        exception.getStatusCode().getCode().getHttpStatusCode(),
        exception.isRetryable());

    this.status = FirestoreException.toStatus(exception.getStatusCode());
  }

  private FirestoreException(IOException exception, boolean retryable) {
    super(exception, retryable);
  }

  /**
   * Creates a FirestoreException with an {@code INVALID_ARGUMENT} status code and the provided
   * message in a nested exception.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forInvalidArgument(String message, Object... params) {
    return new FirestoreException(String.format(message, params), Status.INVALID_ARGUMENT);
  }

  /**
   * Creates a FirestoreException with the provided GRPC Status code and message in a nested
   * exception.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forServerRejection(
      Status status, String message, Object... params) {
    return forServerRejection(status, null, message, params);
  }

  /**
   * Creates a FirestoreException with the provided GRPC Status code and message in a nested
   * exception.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forServerRejection(
      Status status, @Nullable Throwable cause, String message, Object... params) {
    return new FirestoreException(String.format(message, params), status, cause);
  }

  /**
   * Creates a FirestoreException from an IOException.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forIOException(IOException exception, boolean retryable) {
    return new FirestoreException(exception, retryable);
  }

  /**
   * Creates a FirestoreException from an ApiException.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forApiException(ApiException exception) {
    return new FirestoreException(exception.getMessage(), exception);
  }

  /**
   * Creates a FirestoreException from an ApiException.
   *
   * @return The FirestoreException
   */
  @BetaApi
  public static FirestoreException forApiException(ApiException exception, String message) {
    return new FirestoreException(message, exception);
  }

  @BetaApi
  @Nullable
  public Status getStatus() {
    return status;
  }

  /**
   * Converts a GAX {@code StatusCode} to a corresponding gRPC {@code Status} object. This method
   * assumes that the names of the enum values in {@code com.google.api.gax.rpc.StatusCode.Code}
   * directly correspond to the names of the enum values in {@code io.grpc.Status.Code}.
   *
   * <p>If the provided {@code StatusCode.Code} name does not have a direct matching {@code
   * io.grpc.Status.Code}, {@code Status.UNKNOWN} with a descriptive message is returned.
   */
  private static Status toStatus(StatusCode statusCode) {
    try {
      Status.Code code = Status.Code.valueOf(statusCode.getCode().name());
      return code.toStatus();
    } catch (IllegalArgumentException e) {
      return Status.UNKNOWN.withDescription(
          "Unrecognized StatusCode.code: " + statusCode.getCode());
    }
  }
}
