/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.SessionImpl.NO_CHANNEL_HINT;

import com.google.api.core.BetaApi;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import javax.annotation.Nonnull;

/**
 * An experimental error handler that allows DEADLINE_EXCEEDED errors to be retried on a different
 * gRPC channel. This handler is only used if the system property
 * 'spanner.retry_deadline_exceeded_on_different_channel' has been set to true, and it is only used
 * in the following specific cases:
 *
 * <ol>
 *   <li>A DEADLINE_EXCEEDED error during a read/write transaction. The error is translated to a
 *       {@link RetryOnDifferentGrpcChannelException}, which is caught by the session pool and
 *       causes a retry of the entire transaction on a different session and different gRPC channel.
 *   <li>A DEADLINE_EXCEEDED error during a single-use read-only transaction using a multiplexed
 *       session. Note that errors for the same using a regular session are not retried.
 * </ol>
 */
@BetaApi
class RetryOnDifferentGrpcChannelErrorHandler implements ErrorHandler {
  private final int maxAttempts;

  private final SessionImpl session;

  static boolean isEnabled() {
    return Boolean.parseBoolean(
        System.getProperty("spanner.retry_deadline_exceeded_on_different_channel", "false"));
  }

  RetryOnDifferentGrpcChannelErrorHandler(int maxAttempts, SessionImpl session) {
    this.maxAttempts = maxAttempts;
    this.session = session;
  }

  @Override
  @Nonnull
  public Throwable translateException(@Nonnull Throwable exception) {
    if (session == null || !(exception instanceof SpannerException)) {
      return exception;
    }
    SpannerException spannerException = (SpannerException) exception;
    if (spannerException.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED) {
      if (session.getIsMultiplexed()
          || (session.getOptions() != null
              && session.getOptions().containsKey(Option.CHANNEL_HINT))) {
        int channel = NO_CHANNEL_HINT;
        if (session.getOptions() != null && session.getOptions().containsKey(Option.CHANNEL_HINT)) {
          channel = Option.CHANNEL_HINT.getLong(session.getOptions()).intValue();
        }
        return SpannerExceptionFactory.newRetryOnDifferentGrpcChannelException(
            "Retrying on a new gRPC channel due to a DEADLINE_EXCEEDED error",
            channel,
            spannerException);
      }
    }
    return spannerException;
  }

  @Override
  public int getMaxAttempts() {
    return maxAttempts;
  }
}
