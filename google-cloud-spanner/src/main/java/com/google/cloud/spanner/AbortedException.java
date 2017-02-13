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

import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import javax.annotation.Nullable;

/**
 * Exception thrown by Cloud Spanner when an operation detects that a transaction has aborted. This
 * type of error has its own subclass since it is often necessary to handle aborted differently to
 * other types of errors, most typically by retrying the transaction.
 */
public class AbortedException extends SpannerException {
  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  /**
   * Abort is not retryable per se: the operation request needs to change (generally to reflect a
   * new transaction attempt) before a retry can succeed.
   */
  private static final boolean IS_RETRYABLE = false;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AbortedException(
      DoNotConstructDirectly token, @Nullable String message, @Nullable Throwable cause) {
    super(token, ErrorCode.ABORTED, IS_RETRYABLE, message, cause);
  }

  /**
   * Return the retry delay for transaction in milliseconds. Return -1 if this does not specify any
   * retry delay. In that case, clients should fall back to a locally computed retry delay.
   */
  public long getRetryDelayInMillis() {
    if (this.getCause() != null) {
      Metadata trailers = Status.trailersFromThrowable(this.getCause());
      if (trailers != null && trailers.containsKey(KEY_RETRY_INFO)) {
        RetryInfo retryInfo = trailers.get(KEY_RETRY_INFO);
        if (retryInfo.hasRetryDelay()) {
          return Durations.toMillis(retryInfo.getRetryDelay());
        }
      }
    }
    return -1L;
  }
}
