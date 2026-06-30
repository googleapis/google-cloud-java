/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.rpc.InternalException;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;

public class IsRetryableInternalError implements Predicate<Throwable> {
  public static final IsRetryableInternalError INSTANCE = new IsRetryableInternalError();

  private static final ImmutableList<String> RETRYABLE_ERROR_MESSAGES =
      ImmutableList.of(
          "HTTP/2 error code: INTERNAL_ERROR",
          "Connection closed with unknown cause",
          "Received unexpected EOS on DATA frame from server",
          "stream terminated by RST_STREAM",
          "Authentication backend internal server error. Please retry.");

  public boolean isRetryableInternalError(Status status) {
    return status.getCode() == Code.INTERNAL
        && status.getDescription() != null
        && isRetryableErrorMessage(status.getDescription());
  }

  @Override
  public boolean apply(Throwable cause) {
    return isInternalError(cause) && isRetryableErrorMessage(cause.getMessage());
  }

  private boolean isRetryableErrorMessage(String errorMessage) {
    return RETRYABLE_ERROR_MESSAGES.stream().anyMatch(errorMessage::contains);
  }

  private boolean isInternalError(Throwable cause) {
    return (cause instanceof InternalException)
        || (cause instanceof StatusRuntimeException
            && ((StatusRuntimeException) cause).getStatus().getCode() == Status.Code.INTERNAL);
  }
}
