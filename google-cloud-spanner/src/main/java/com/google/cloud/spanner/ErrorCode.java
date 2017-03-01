/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.common.collect.ImmutableMap;
import io.grpc.Status;
import java.util.Map;

/**
 * Enumerates the major types of error that the Cloud Spanner service can produce. These codes are
 * accessible via {@link SpannerException#getErrorCode()}.
 */
public enum ErrorCode {

  // TODO(user): Add documentation.
  CANCELLED(Status.CANCELLED),
  UNKNOWN(Status.UNKNOWN),
  INVALID_ARGUMENT(Status.INVALID_ARGUMENT),
  DEADLINE_EXCEEDED(Status.DEADLINE_EXCEEDED),
  NOT_FOUND(Status.NOT_FOUND),
  ALREADY_EXISTS(Status.ALREADY_EXISTS),
  PERMISSION_DENIED(Status.PERMISSION_DENIED),
  UNAUTHENTICATED(Status.UNAUTHENTICATED),
  RESOURCE_EXHAUSTED(Status.RESOURCE_EXHAUSTED),
  FAILED_PRECONDITION(Status.FAILED_PRECONDITION),
  ABORTED(Status.ABORTED),
  OUT_OF_RANGE(Status.OUT_OF_RANGE),
  UNIMPLEMENTED(Status.UNIMPLEMENTED),
  INTERNAL(Status.INTERNAL),
  UNAVAILABLE(Status.UNAVAILABLE),
  DATA_LOSS(Status.DATA_LOSS),
  ;

  private static final Map<Integer, ErrorCode> errorByRpcCode;

  static {
    ImmutableMap.Builder<Integer, ErrorCode> builder = ImmutableMap.builder();
    for (ErrorCode errorCode : ErrorCode.values()) {
      builder.put(errorCode.getCode(), errorCode);
    }
    errorByRpcCode = builder.build();
  }

  private final Status.Code code;

  ErrorCode(Status status) {
    this.code = status.getCode();
  }

  int getCode() {
    return this.code.value();
  }

  /**
   * Returns the error code represents by {@code name}, or {@code defaultValue} if {@code name} does
   * not map to a known code.
   */
  static ErrorCode valueOf(String name, ErrorCode defaultValue) {
    try {
      return ErrorCode.valueOf(name);
    } catch (IllegalArgumentException e) {
      return defaultValue;
    }
  }

  /**
   * Returns the error code corresponding to a gRPC status, or {@code UNKNOWN} if not recognized.
   */
  static ErrorCode fromGrpcStatus(Status status) {
    ErrorCode code = errorByRpcCode.get(status.getCode().value());
    return code == null ? UNKNOWN : code;
  }

  /**
   * Returns the error code corresponding to the given status, or {@code UNKNOWN} if not recognized.
   */
  static ErrorCode fromRpcStatus(com.google.rpc.Status status) {
    ErrorCode code = errorByRpcCode.get(status.getCode());
    return code == null ? UNKNOWN : code;
  }
}
